package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        String Package, connection, frame;
     
        while(true){
            System.out.println("You have the following packages");
            System.out.println("Silver Package: ATMega32 with load sensor");
            System.out.println("Gold Package: Arduino with weight module");
            System.out.println("Diamond Package: Raspberry Pi with load sensor");
            System.out.println("Platinum Package: Raspberry Pi with weight module");
            System.out.println("You can choose Internet Connection from these 3 options");
            System.out.println("Internet Connection Type: 1.WiFi, 2.Ethernet, 3.SIM card");
            System.out.println("You can choose Framework from following 3 options");
            System.out.println("FrameWork for the web server: 1.Django, 2.Spring, 3.Laravel");
            System.out.println("press X to close the program");
            System.out.println("Type Package name: ");
            Package = input.nextLine();
            if(Package.equalsIgnoreCase("X"))
                break;
            System.out.println("Type Connection Type");
            connection = input.nextLine();
            System.out.println("Type Framework Type");
            frame = input.nextLine();

            DeviceBuilder devicebuilder = new DeviceBuilder();
            Device newDeivce = devicebuilder.buildDevice(Package, connection, frame);
            newDeivce.getDeviceInformation();
            System.out.println("");

        }
        input.close();

    }
}
