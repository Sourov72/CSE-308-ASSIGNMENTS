package com.company;
import Publisher.Editor;
import Publisher.Publisher;
import Users.userlist;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


class ClientAccept implements Runnable{

    static ArrayList<ClientHandler> clientList = new ArrayList<ClientHandler>();
    private ServerSocket listener;
    int id = 0;
    private userlist userList;
    public ServerSocket getListener() {
        return listener;
    }

    ClientAccept(userlist userList) throws IOException {
        listener = new ServerSocket(5000);
        System.out.println("server Started");
        this.userList = userList;
    }
    @Override
    public void run() {
        System.out.println("Waiting for a client..");
        Socket client = null;
        while(true){
            try {
                client = listener.accept();
                System.out.println("Connected to client");
                userList.createUser(id + 1);
                ClientHandler clientThread = new ClientHandler(client, id + 1, clientList, userList.getUser());
                clientList.add(clientThread);
                id += 1;
                Thread newclient = new Thread(clientThread);
                newclient.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

class hello {
    void execute(String s)throws IOException{


    }
}


public class Server {

    public static void main(String[] args) throws IOException {
        // write your code here

        Editor editor = new Publisher();
        userlist Userlist = new userlist(editor);

        Runnable r = new ClientAccept(Userlist);

        Thread ServerRun = new Thread(r);
        ServerRun.start();

    }

}

