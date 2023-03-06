package Controller;

import Model.Registration;
import Util.Bash64Token;
import Util.RandonString;

import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Path("registration")
public class RegistrationResource {
    @GET
    public List<Registration> getData(){
        return Registration.listAll();
    }
    @POST
    @Transactional
    public String registration(JsonObject body){
        String status = null;
        String emailPattern = "^((?!\\.)[\\w_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])";
        if(bacadata(body.getString("email"),emailPattern)==true){
            RandonString randonString = new RandonString();
            String token = randonString.getAlphaNumericString(12);
            Bash64Token bash64Token = new Bash64Token(
                    body.getString("email")+"&="+
                            body.getString("username")+"&="+
                            token);
            Registration registration = new Registration();
            registration.email = body.getString("email");
            registration.username = body.getString("username");
            registration.password = body.getString("password");
            registration.token = token;
            registration.validationLink = bash64Token.getBash64();
            registration.persist();
            if (registration.isPersistent()==true){
                status = "successful registration \n" +
                        "verify your account via the link we sent to your email address \n" +
                        "the link will expire after 24 hours.";
            }
        }
        else {status = "invalid e-mail address";}
        return status;
    }
    boolean bacadata(String email,String pattern){
        Pattern emailPattern = Pattern.compile(pattern);
        Matcher emailMatc = emailPattern.matcher(email);
        boolean b = emailMatc.matches();
        return b;
    }
}
