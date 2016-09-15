package views.formdata;

import models.UserDB;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.thi.thu.huong on 15/09/2016.
 */
public class AddUserFormData {
    public  String name = "";
    public  String email = "";
    public  String password = "";

    public AddUserFormData(){

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
