package com.company;

import Users.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    private Socket client;
    private InputStreamReader in;
    private BufferedReader bf;
    private int id;
    private PrintWriter pr;
    private ArrayList<ClientHandler> clients;
    private boolean login;
    user User;
    public int getId() {
        return id;

    }


    public Socket getClient() {
        return client;
    }

    public ClientHandler(Socket clientSocket, int id, ArrayList<ClientHandler> clients, user User) throws IOException {
        this.client = clientSocket;
        in = new InputStreamReader(client.getInputStream());
        bf = new BufferedReader(in);
        pr = new PrintWriter(client.getOutputStream(), true);
        this.id = id;
        this.clients = clients;

        this.login = false;
        this.User = User;
    }

    @Override
    public void run() {

            String line = "";
            try{
                while(true)
                {
                    if(id != 1 && !login){
                        pr.println(User.getEditor().show());
                    }

                    login = true;
                    line = bf.readLine();

                    System.out.println(line);
                    if(id == 1){
                        String [] Input = line.split(" ");
                        User.getEditor().change(Input[0], Input[2], Input[1]);
                        pr.println("hello admin");
                        notifyAll(Input[1]);
                    }
                    else{


                        String [] Input = line.split(" ");
                        if(Input[0].equals("S")){
                            if(!User.search(Input[1]) && User.getEditor().getstockCount(Input[1]) > 0){
                                User.getSubsList().add(Input[1]);
                                User.getEditor().addUser(User, Input[1]);
                                System.out.println("Client " + User.getId() + " has Subsribed to stock " + Input[1]);
                                pr.println("subscribed successfully");
                            }
                            else{
                                pr.println("You have already subscribed to this stock or stocks aren't available");
                            }
                        }
                        else if(Input[0].equals("U")){
                            if(User.search(Input[1])){
                                User.remove(Input[1]);
                                User.getEditor().removeUser(User, Input[1]);
                                System.out.println("Client " + User.getId() + " has unsubsribeded from stock " + Input[1]);
                                pr.println("Unsubscribed successfully");
                            }
                            else{
                                pr.println("you haven't subscribed to this channel");
                            }
                        }

                    }


                }
            }
            catch (IOException e){
                System.out.println("error has occoured");
            }

        }

        private void notifyAll(String s){
            String updatedInfo = User.getEditor().notifyy();
//            for (user observer : User.getEditor().getSubscriberList()) {
//                if(observer.search(s))
//                    observer.update(s);
//            }
            for(ClientHandler aClient: clients){
                if(aClient.User.search(s))
                    aClient.pr.println(updatedInfo);
            }
        }

}

