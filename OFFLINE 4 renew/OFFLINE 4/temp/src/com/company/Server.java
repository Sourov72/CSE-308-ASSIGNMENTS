package com.company;
import java.io.*;
import java.net.*;
public class Server {

    private Socket socket = null;
    private ServerSocket server = null;
    private InputStreamReader in = null;
    private BufferedReader bf = null;
    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server Started");

            System.out.println("Waiting for a client..");

            socket = server.accept();
            System.out.println("Client Accepted");
            //takes input from client
            in = new InputStreamReader(socket.getInputStream());
            bf = new BufferedReader(in);
            String line = "";
            while(!line.equals("Over"))
            {

                try {

                    line = bf.readLine();
                    System.out.println(line);


                } catch (IOException e) {

                    e.printStackTrace();
                }
            }


            socket.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
	// write your code here
        Server server = new Server(5000);

    }
}
