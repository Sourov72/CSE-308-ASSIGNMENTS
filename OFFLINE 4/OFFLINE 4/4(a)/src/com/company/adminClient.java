package com.company;
import javax.swing.plaf.IconUIResource;
import java.net.*;
import java.io.*;


public class adminClient {

    Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public adminClient(String address, int port)
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
        String line = "";
        BufferedReader input= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);

        while(!line.equals("X"))
        {
            try {
                line = keyboard.readLine();
                pr.println(line);

                String serverResponse = input.readLine();
                System.out.println(serverResponse);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        try{
            input.close();
            pr.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


