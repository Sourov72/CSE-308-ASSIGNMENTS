package com.company;

import java.util.ArrayList;
import java.util.List;



public class Device {

        private List<fullDevice> Components = new ArrayList<fullDevice>();

        public void addComponent(fullDevice component){
                Components.add(component);
        }

        public void getDeviceInformation(){
                System.out.println(" ");
                for (fullDevice component : Components) {
                        System.out.println(component.part());

                }
        }

}
