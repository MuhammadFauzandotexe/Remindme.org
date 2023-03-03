package Controller.lama;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
@Path("emailValidation")
public class EmailValidation {
    private Connection connection;
    @GET
    @Path("{link}")
    public String userValidation(String link){
        List<String> mydata = new ArrayList<>();
        Base64.Decoder decoder = Base64.getDecoder();
        String stg = new String(decoder.decode(link));
        String[] spStg = stg.split("&=");
        for (String i: spStg) {
            mydata.add(i);
        }
        String email = mydata.get(0);
        String username = mydata.get(1);
        String token = mydata.get(2);
        Integer resultSet = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_registered (id,email,username,token) VALUES(nextval('hibernate_sequence'),?,?,?);");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,token);
            resultSet = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
        String result = (resultSet >= 1) ? "Aktivasi Berhasil" : "Aktivasi Gagal";
        return result;
    }
}
