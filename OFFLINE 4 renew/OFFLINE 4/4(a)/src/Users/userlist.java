package Users;

import Publisher.Editor;

import java.util.ArrayList;
import java.util.List;

public class userlist {
    private List<user> userList;
    private int id;
    private user User;
    private Editor editor;

    public userlist(Editor editor){
        userList = new ArrayList<user>();
        this.editor = editor;
    }

    public void userAdd(){
        User.setId(id);
        userList.add(User);

    }

    public user getUser(){
        return userList.get(userList.size()-1);
    }

    public void createUser(int id){
        this.id = id;
        User = new user();
        userAdd();
        User.setEditor(editor);
        //User.userInput(editor);

    }



}
