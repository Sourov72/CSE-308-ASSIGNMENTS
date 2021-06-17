package Mediator;

import Organizations.*;

import java.util.LinkedList;
import java.util.Queue;

public class JCC {
    private Queue<String> water ;
    private Queue<String> enery ;
    private Queue<String> transport ;
    private Queue<String> telecom;

    private String otype;

    public JCC(){
        water = new LinkedList<>();
        enery = new LinkedList<>();
        transport = new LinkedList<>();
        telecom = new LinkedList<>();

    }

    public organization getWaterOrganization() {

        return new JWSA(this);
    }

    public organization getEneryOrganization() {

        return new JPDC(this);
    }

    public organization getTransportOrganization() {
        return new JRTA(this);
    }


    public organization getTelecomOrganization() {
        return new JTRC(this);
    }

    public void check(organization o){
        if(o instanceof JWSA)
            otype = "JWSA";
        else if(o instanceof JPDC)
            otype = "JPDC";
        else if(o instanceof JRTA)
            otype = "JRTA";
        else if(o instanceof JTRC)
            otype = "JTRC";
    }

    public void notifyy(String type, organization o){
        check(o);
        if(type.equals("POWER")){
            enery.add(otype);
            System.out.println(otype + " requests for POWER service");
        }
        else if(type.equals("WATER")){
            water.add(otype);
            System.out.println(otype + " requests for WATER service");
        }
        else if(type.equals("TRANSPORT")){
            transport.add(otype);
            System.out.println(otype + " requests for TRANSPORT service");
        }
        else if(type.equals("TELECOM")){
            telecom.add(otype);
            System.out.println(otype + " requests for TELECOM service");
        }


    }
    public void serve(organization o){
        check(o);
        if(otype.equals("JPDC")){
            System.out.println(otype + " serves the request for " + enery.peek());
            enery.remove();
        }
        else if(otype.equals("JWSA")){
            System.out.println(otype + " serves the request for " + water.peek());
            water.remove();
        }
        else if(otype.equals("JRTA")){
            System.out.println(otype + " serves the request for " + transport.peek());
            transport.remove();
        }
        else if(otype.equals("JTRC")){
            System.out.println(otype + " serves the request for " + telecom.peek());
            telecom.remove();
        }
    }



}
