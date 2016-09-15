package views.formdata;

import models.User;
import models.UserDB;
import play.api.libs.openid.UserInfo;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.thi.thu.huong on 14/09/2016.
 */
public class LoginFormData {
    public  String email = "";
    public  String password = "";

    public LoginFormData(){

    }

    public List<ValidationError> validate(){
        List<ValidationError> errors = new ArrayList<>();

        if(!UserDB.isValid(email, password)){
            errors.add(new ValidationError("email", ""));
            errors.add(new ValidationError("password",""));

        }
        return (errors.size()> 0)? errors: null;
    }

}
