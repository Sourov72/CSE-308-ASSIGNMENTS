package com.company;

import Mediator.JCC;
import Organizations.JWSA;
import Organizations.organization;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        String num, otype, stype;
        System.out.println("write Init to initialize the system");
        num = input.nextLine();
        if(num.equals("Init")){
            JCC mediator = new JCC();
            organization water = mediator.getWaterOrganization();
            organization energy = mediator.getEneryOrganization();
            organization transport = mediator.getTransportOrganization();
            organization telecom = mediator.getTelecomOrganization();
            System.out.println("All four services are initiated through mediator");

            while(true){
                otype = input.next();
                stype = input.next();
                if(stype.equals("SERVE")){
                    if(otype.equals("JWSA")){
                        water.serve();
                    }
                    else if(otype.equals("JPDC")){
                        energy.serve();
                    }
                    else if(otype.equals("JRTA")){
                        transport.serve();
                    }
                    else if(otype.equals("JTRC")){
                        telecom.serve();
                    }
                }
                else{
                    if(otype.equals("JWSA")){
                        water.request(stype);
                    }
                    else if(otype.equals("JPDC")){
                        energy.request(stype);
                    }
                    else if(otype.equals("JRTA")){
                        transport.request(stype);
                    }
                    else if(otype.equals("JTRC")){
                        telecom.request(stype);
                    }

                }


            }
        }

    }
}
