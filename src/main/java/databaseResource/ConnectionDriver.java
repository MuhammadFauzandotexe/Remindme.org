package databaseResource;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionDriver {
    public Connection connect(){
        Connection con = null;
        try {Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            return con1;}
        catch (Exception e){e.printStackTrace();
            return con;}
    }
}
