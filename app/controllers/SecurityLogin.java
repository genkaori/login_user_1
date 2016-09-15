package controllers;


import models.User;
import models.UserDB;
import play.mvc.Http;
import play.mvc.Security;
import play.mvc.Result;

/**
 * Created by FRAMGIA\nguyen.thi.thu.huong on 14/09/2016.
 */
public class SecurityLogin extends Security.Authenticator {
    @Override
    public String getUsername(Http.Context ctx) {
        return ctx.session().get("email");
    }


    @Override
    public Result onUnauthorized(Http.Context context) {
        return redirect(routes.HomeController.login());
    }

    public static String getUser(Http.Context ctx) {

            return ctx.session().get("email");

    }

    public static boolean isLoggedIn(Http.Context ctx) {
        return (getUser(ctx) != null);
    }

    public static User getUserInfo(Http.Context ctx) {
        return (isLoggedIn(ctx) ? UserDB.getUser(getUser(ctx)) : null);
    }

}
