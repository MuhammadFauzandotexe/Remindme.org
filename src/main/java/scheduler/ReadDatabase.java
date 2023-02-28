package scheduler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ReadDatabase {
    public static void main(String[] args) {
        Connection connection;
        Connection connection2;
        try {
            List<String> id= new ArrayList<>();
            List<String> task = new ArrayList<>();
            List<String> taskName = new ArrayList<>();

            String statement = "SELECT * FROM user_data where date='2023-02-28' and time='21:14:00' order by id asc limit 1";
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                id.add(resultSet.getString("id"));
                task.add(resultSet.getString("task"));
                taskName.add(resultSet.getString("task_name"));
            }
            System.out.println(id);
            String statement2 = "DELETE FROM user_data WHERE id = 4";
            connection2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            PreparedStatement preparedStatement1 = connection2.prepareStatement(statement2);
            System.out.println(preparedStatement1.executeUpdate());

        }catch (Exception e){ e.printStackTrace();}
    }
}
