package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnect implements Runnable{
    private Socket server;
    private InputStreamReader in;
    private BufferedReader bf;

    public ServerConnect(Socket server) throws IOException {
        this.server = server;
        in = new InputStreamReader(server.getInputStream());
        bf = new BufferedReader(in);

    }

    @Override
    public void run() {

        try {
            while (true){
                String response = null;
                response = bf.readLine();
                System.out.println(response);

            }
        }catch (IOException e){

        }


    }
}
