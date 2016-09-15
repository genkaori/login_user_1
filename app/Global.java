import models.UserDB;
import play.Application;
import play.GlobalSettings;


/**
 * Created by FRAMGIA\nguyen.thi.thu.huong on 14/09/2016.
 */
public class Global extends GlobalSettings {
    public void onStart(Application app) {
        UserDB.addUserInfo("Nguyen Huong", "huong@.com", "123456");
    }

}
