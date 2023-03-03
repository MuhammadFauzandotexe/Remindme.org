package AAA_Coba2;
import Model.UserData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
@Path("getDataUser")
public class Controller1 {
    @GET
    public List<UserData> getData(){
        return UserData.listAll();
    }
    @GET@Path("{id}")
    public UserData getId(Long id){
        return UserData.findById(id);
    }
}
