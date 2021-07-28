package com.company;
import javax.swing.plaf.IconUIResource;
import java.net.*;
import java.io.*;
public class Client {

    private Socket socket = null;
    private DataInputStream input = null;
    private PrintWriter pr= null;

    public Client(String address, int port)
    {
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            //takes input from terminal
            input = new DataInputStream(System.in);
            //send output to server
            pr = new PrintWriter(socket.getOutputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";

        while(!line.equals("Over"))
        {

            try {

                line = input.readLine();
                System.out.println(line);
                pr.println(line);
                pr.flush();

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

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
    }

}
