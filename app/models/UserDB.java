package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FRAMGIA\nguyen.thi.thu.huong on 13/09/2016.
 */
public class UserDB {
    private static Map<String, User>userinfo = new HashMap<String, User>();


    public static void addUserInfo(String name, String email, String password){
        userinfo.put(email, new User(name, email, password));
    }

    public  static  boolean isUser(String email){
        return userinfo.containsKey(email);

    }

    public static  User getUser(String email){
        return  userinfo.get((email == null)? "": email);
    }
    public static boolean isValid(String email, String password){
        return ((email!=null) && (password!=null) && isUser(email) && getUser(email).getPassword().equals(password));
    }


}
