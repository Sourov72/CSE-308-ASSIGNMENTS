package com.company;


import Publisher.Editor;
import Publisher.Publisher;
import Users.userlist;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner input = new Scanner(System.in);
        Editor editor = new Publisher();
        userlist Userlist = new userlist(editor);
        while (true){
            System.out.println("press 1: Create user\n");
            System.out.println("press 2: Change Stock attributes\n");
            System.out.println("press 3: Login\n");
            //editor.show();
            String choice = input.nextLine();
            if(choice.equals("1")){

                System.out.println("Name: ");
                String name = input.nextLine();
                Userlist.createUser(name);
            }
            else if(choice.equals("2")){
                String type = input.nextLine();
                String [] Input = type.split(" ");
                editor.change(Input[0], Input[2], Input[1]);
            }
            else if(choice.equals("3")){
                System.out.println("Name: ");
                String name = input.nextLine();
                Userlist.login(name);
            }
        }



    }
}
