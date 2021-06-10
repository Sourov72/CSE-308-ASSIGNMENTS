package Users;

import Publisher.Editor;

import java.util.ArrayList;
import java.util.List;

public class userlist {
    private List<user> userList;
    private String name;
    private user User;
    private Editor editor;

    public userlist(Editor editor){
        userList = new ArrayList<user>();
        this.editor = editor;
    }

    public void userAdd(){
        User.setName(name);
        userList.add(User);

    }

    public void createUser(String name){
        this.name = name;
        User = new user();
        userAdd();
        User.userInput(editor);
    }

    public void login(String name){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getName().equals(name)){
                userList.get(i).userInput(editor);
            }

        }
        System.out.println("User doesn't exist\n");
        return;
    }


}
