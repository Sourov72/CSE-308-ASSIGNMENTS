package Users;

import Publisher.Editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class user implements Observer {
    private String name;
    private String stype;
    private List<String> subsList;
    Scanner input = new Scanner(System.in);

    user(){
        subsList = new ArrayList<String>();
    }
    public String getName() {
        return name;
    }

    public int getSubsListsize() {
        return subsList.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean search(String stype){
        for(int i = 0; i < subsList.size(); i++){
           if(subsList.get(i).equals(stype))
               return true;
        }
        return false;
    }
    public void remove(String stype){
        for(int i = 0; i < subsList.size(); i++){
            if(subsList.get(i).equals(stype))
                subsList.remove(i);
        }

    }
    @Override
    public void update(String s) {
        System.out.println(name + "'s " + s);
    }

    public void userInput(Editor editor){
        editor.show();
        while(true){
            System.out.println("Subscribe: ");
            System.out.println("UnSubscribe: ");
            System.out.println("press X: to logout");
            String type = input.nextLine();
            if(type.equals("X"))
                break;
            String [] Input = type.split(" ");
            if(Input[0].equals("S")){
                if(!search(Input[1]) && editor.getstockCount(Input[1]) > 0){
                    subsList.add(Input[1]);
                    editor.addUser(this, Input[1]);
                    System.out.println("subscribed successfully");
                }
                else{
                    System.out.println("You have already subscribed to this stock or stocks aren't available");
                }
            }
            else if(Input[0].equals("U")){
                if(search(Input[1])){
                    remove(Input[1]);
                    editor.removeUser(this, Input[1]);
                    System.out.println("Unsubscribed successfully");
                }
                else{
                    System.out.println("you haven't subscribed to this channel");
                }
            }

        }

    }
}
