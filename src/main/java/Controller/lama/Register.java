package Controller.lama;
import Utility.Bash64Token;
import Utility.RandonString;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@Path("register")
public class Register {
    private Connection connection;
    @GET@Path("{email}/{username}/{password}")//http://localhost:8080/register/mfauzan51087@gmail.com/fauzan/loveyoubabe
    //https://061c-2404-c0-9820-00-44-92d8.ap.ngrok.io/register/mfauzan51087@gmail.com/fauzan/kreditguys
    public String coba(String email,String username,String password){
        RandonString randon = new RandonString();//token
        String randomString = randon.getAlphaNumericString(20);
        Bash64Token bash64 = new Bash64Token(email+"&="+username+"&="+randomString);
        String bash64Token = bash64.getBash64();
        String linkSendEmail = "http://localhost:8080/emailValidation/"+bash64Token;
        Integer resultSet = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_registration (id,email_registration,name_registration,password_registration,token,bash64_decode) VALUES(nextval('hibernate_sequence'),?,?,?,?,?);");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,randomString);
            preparedStatement.setString(5,linkSendEmail);
            resultSet = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
        String result = (resultSet >= 1) ? "pendaftaran berhasil" : "pendaftaran gagal";
        return result+" link validasi ini yang akan di kirim melalui email : "+linkSendEmail;
    }
}
