package Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Path("endpoit2")
public class Endpoit2 {

    public Connection connection = null;
    @GET
    public String sayHello(){
        return "hello";
    }
    //@GET@Path("registrasi")
    public String addUser(){
        Integer resultSet = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_registration (id,email_registration,name_registration,password_registration,token,bash64_decode) VALUES(nextval('hibernate_sequence'),?,?,?,?,?);");
            preparedStatement.setString(1,"mfauzan");
            preparedStatement.setString(2,"ds");
            preparedStatement.setString(3,"wq");
            preparedStatement.setString(4,"dada");
            preparedStatement.setString(5,"dadada");
            resultSet = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
        return resultSet.toString();
    }

}
