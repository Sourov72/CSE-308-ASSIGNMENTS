package Users;

import Publisher.Editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class user implements Observer {
    private int id;
    private String stype;
    private List<String> subsList;
    private Editor editor;

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public List<String> getSubsList() {
        return subsList;
    }

    public void setSubsList(List<String> subsList) {
        this.subsList = subsList;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    Scanner input = new Scanner(System.in);

    user(){
        subsList = new ArrayList<String>();
    }
    public int getId() {
        return id;
    }

    public int getSubsListsize() {
        return subsList.size();
    }

    public void setId(int id) {
        this.id = id;
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
        System.out.println(id + "'s " + s);
    }

    public String stockShow(Editor editor){
        this.editor = editor;
        return editor.show();
    }
}
