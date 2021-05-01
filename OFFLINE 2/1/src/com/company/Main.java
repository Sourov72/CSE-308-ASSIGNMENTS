package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner input = new Scanner(System.in);
        String filename;
        Editor editor = Editor.getInstace();
        while(true){
            System.out.println("Input the File Name: (press X to close the program)");
            filename = input.nextLine();
            if(filename.equalsIgnoreCase("X"))
                break;
            editor.chooseParser(filename);
            editor.getparserInfo();

        }
        input.close();

    }
}
