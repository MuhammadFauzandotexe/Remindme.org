package Controller;

import Model.Register;
import Utility.Bash64Token;
import Utility.RandonString;

import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/register")
public class UserRegister {
    @POST@Transactional
    public Register userRegistration(JsonObject body){
        RandonString randonString = new RandonString();
        String keyValue = randonString.getAlphaNumericString(12);
        Bash64Token bash64Token = new Bash64Token(body.getString("name")+"&="+body.getString("email")+keyValue);

        Register registration = new Register();
        registration.name = body.getString("name");
        registration.email = body.getString("email");
        registration.password = body.getString("password");
        registration.key_value = keyValue;
        registration.keyValueEncode = bash64Token.getBash64();

        registration.persist();
        return registration;
    }


}
