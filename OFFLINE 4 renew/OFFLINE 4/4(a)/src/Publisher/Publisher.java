package Publisher;

import Users.user;

import java.util.ArrayList;
import java.util.List;

public class Publisher extends Editor{
    private List<user> subscriberList;

    public Publisher(){
        super();
        subscriberList = new ArrayList<user>();
    }

    public boolean searchUser(user User){
        for(int i = 0; i < subscriberList.size(); i++){
            if(subscriberList.get(i).equals(User)){
                return true;
            }
        }
        return false;
    }
    public void addUser(user User, String stype){
        if(!searchUser(User))
            subscriberList.add(User);
        changeCount(stype, -1);
    }

    @Override
    public void removeUser(user User, String stype) {
        for(int i = 0; i < subscriberList.size(); i++){
            if(subscriberList.get(i).equals(User) && subscriberList.get(i).getSubsListsize() == 0){
                subscriberList.remove(subscriberList.get(i));
            }
        }
        changeCount(stype, 1);
    }

    public List<user> getSubscriberList() {
        return subscriberList;
    }

//    public void notify(String stype, String s){
//        for (user observer : subscriberList) {
//            if(observer.search(stype))
//                observer.update(s);
//        }
//    }
}
