package com.company;
import javax.swing.plaf.IconUIResource;
import java.net.*;
import java.io.*;

public class Client {

    Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public Client(String address, int port)
    {
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            //takes input from terminal
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) throws IOException {
        Socket socket = null;


        Client client = new Client("127.0.0.1", 5000);
        socket = client.getSocket();
        ServerConnect server = new ServerConnect(socket);

        new Thread(server).start();
        String line = "";
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);


        while(!line.equals("X"))
        {
            try {
                line = keyboard.readLine();
                pr.println(line);


            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        try{
            pr.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


