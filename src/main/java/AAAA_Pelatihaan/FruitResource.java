package AAAA_Pelatihaan;

import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/fruit")
public class FruitResource {
    @GET
    public List<Fruit> getData(){
        return Fruit.listAll();
    }
    @POST@Transactional
    public Fruit postFruit(JsonObject body){
        Fruit fruit = new Fruit();
        fruit.name = body.getString("name");
        fruit.description = body.getString("description");
        fruit.persist();
        return fruit;
    }
}

