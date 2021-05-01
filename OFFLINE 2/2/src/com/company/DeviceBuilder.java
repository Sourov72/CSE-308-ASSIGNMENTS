package com.company;

import controller.Buttons;
import controller.TouchControl;
import display.LCD;
import display.LED;
import display.TouchScreen;
import frameworkk.Django;
import frameworkk.Laravel;
import frameworkk.Spring;
import identification.NFC;
import identification.RFID;
import internetconnection.Ethernet;
import internetconnection.GSM;
import internetconnection.Wifi;
import microcontroller.ATMega32;
import microcontroller.ArduinoMega;
import microcontroller.RaspberryPi;
import storage.InternalMemory;
import storage.SDcard;
import weightmeasurement.LoadSensor;
import weightmeasurement.WeightModule;

public class DeviceBuilder {


    private fullDevice frameBuilder(String frametype){

        if(frametype.equalsIgnoreCase("Django")){
            return new Django();
        }
        else if(frametype.equalsIgnoreCase("Spring")){
            return new Spring();
        }
        else if(frametype.equalsIgnoreCase("Laravel")){
            return new Laravel();
        }
        return null;


    }

    private fullDevice WeightBuilder(String measuretype){

        if(measuretype.equalsIgnoreCase("load sensor")){
            return new LoadSensor();
        }
        else if(measuretype.equalsIgnoreCase("weight module")){
            return new WeightModule();

        }
        else
            return null;

    }

    private fullDevice ConnectionBuilder(String connecttype){

        if(connecttype.equalsIgnoreCase("WiFi")){
            return new Wifi();
        }
        else if(connecttype.equalsIgnoreCase("SIM card")){
            return new GSM();
        }
        else if(connecttype.equalsIgnoreCase("Ethernet")){
            return new Ethernet();
        }
        else
            return null;

    }

    private void PackageBuilder(Device device, String Package, String WeightType, String Frame, String Connection){

        if(Package.equalsIgnoreCase("Silver")){
            device.addComponent(new ATMega32());
            device.addComponent(new RFID());
            device.addComponent(new SDcard());
            device.addComponent(new LCD());
            device.addComponent(new Buttons());
        }
        else if(Package.equalsIgnoreCase("Gold")){
            device.addComponent(new ArduinoMega());
            device.addComponent(new RFID());
            device.addComponent(new SDcard());
            device.addComponent(new LED());
            device.addComponent(new Buttons());
        }
        else if(Package.equalsIgnoreCase("Diamond") || Package.equalsIgnoreCase("Platinum")){
            device.addComponent(new RaspberryPi());
            device.addComponent(new NFC());
            device.addComponent(new InternalMemory());
            device.addComponent(new TouchScreen());
            device.addComponent(new TouchControl());
        }
        device.addComponent(ConnectionBuilder(Connection));
        device.addComponent(frameBuilder(Frame));
        device.addComponent(WeightBuilder(WeightType));
    }



    public Device buildDevice(String Package, String connection, String frame){

        Device device = new Device();
        String WeightType;

        if(Package.equalsIgnoreCase("Silver") || Package.equalsIgnoreCase("Diamond"))
            WeightType = "load sensor";
        else
            WeightType = "weight module";

        if(Package.equalsIgnoreCase("Silver") && connection.equalsIgnoreCase("Ethernet")){
            System.out.println("You can't Choose this package for this internet connection");
            return device;
        }

        PackageBuilder(device, Package, WeightType, frame, connection);


        return device;

    }
}
