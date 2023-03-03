package Controller;
import Model.Registered;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
@Path("/verify")
public class UserVerificationEmail {
    @GET@Path("{userdata}")@Transactional
    public List<String> verifyUser(@PathParam("userdata")String userdata){
        List<String> user = new ArrayList<>();
        Base64.Decoder decoder = Base64.getDecoder();
        String data = new String(decoder.decode(userdata));
        String[] parsing = data.split("&=");
        for (String i: parsing) {
            user.add(i);
        }
        Registered registered = new Registered();
        registered.username = user.get(0);
        registered.email = user.get(1);
        registered.token = user.get(2);
        registered.persist();
        return user;
    }
}
