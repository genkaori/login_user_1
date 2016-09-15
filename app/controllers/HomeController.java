package controllers;

import models.User;
import org.springframework.ui.Model;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import scala.Product;
import views.formdata.LoginFormData;
import views.html.*;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

public class HomeController extends Controller {
    @Inject
    private FormFactory formFactory;

    public  Result index() {
        return ok(index.render("Home", SecurityLogin.isLoggedIn(ctx()), SecurityLogin.getUserInfo(ctx())));
    }
    public  Result login() {
        Form<LoginFormData> formData = Form.form(LoginFormData.class);
        return ok(login.render("Login", SecurityLogin.isLoggedIn(ctx()), SecurityLogin.getUserInfo(ctx()), formData));
    }

    public  Result postLogin() {

        Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            flash("error", "Login credentials not valid.");
            return badRequest(login.render("Login", SecurityLogin.isLoggedIn(ctx()), SecurityLogin.getUserInfo(ctx()), formData));
        }
        else {
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.HomeController.profile());
        }
    }

    @play.mvc.Security.Authenticated(SecurityLogin.class)
    public  Result logout() {
        session().clear();
        return redirect(routes.HomeController.index());
    }

    @play.mvc.Security.Authenticated(SecurityLogin.class)
    public  Result profile() {
        return ok(profile.render("Profile", SecurityLogin.isLoggedIn(ctx()), SecurityLogin.getUserInfo(ctx())));
    }

    public Result indexAddUser(){
       /* Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
       // user.save();
        //return ok("Product: " + product.name); // DEBUG
        return redirect(routes.HomeController.index());*/

        return ok(views.html.adduser.render());

    }

    public Result addUser(){
        //flash("success", "Add User success.");
        Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
        return ok("Add succes 1 User \n "+user.getName());

        //return ok(views.html.edituser.render());
    }

    public Result getUser() {
        return TODO;
    }

}
