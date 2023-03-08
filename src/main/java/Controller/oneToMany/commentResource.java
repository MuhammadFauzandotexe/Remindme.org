package Controller.oneToMany;
import Model.oneToMany.comment;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
@Path("comment")
public class commentResource {
    @GET
    public List<comment> getData(){
        return comment.listAll();
    }
    @POST
    @Transactional
    public comment addComment(JsonObject body){
        comment mycomment = new comment();
        mycomment.body = body.getString("body");
        mycomment.persist();
        return mycomment;
    }
}
