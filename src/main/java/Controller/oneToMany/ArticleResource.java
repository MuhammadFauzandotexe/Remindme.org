package Controller.oneToMany;
import Model.oneToMany.Article;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("article")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticleResource {
    @GET
    public List<Article> getArticle(){
        return Article.listAll();
    }
    @GET
    @Path("{id}")
    public Article getArticle(@PathParam("id")Long id){
        return Article.findById(id);
    }
    @POST
    @Transactional
    public Article addArticle(JsonObject body){
        Article article = new Article();
        article.body = body.getString("body");
        article.tittle = body.getString("tittle");
        article.persist();
        return article;
    }
}
