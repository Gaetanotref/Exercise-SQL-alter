import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "developer");
            Statement statement = connection.createStatement();
            //statement.executeUpdate("ALTER TABLE test1 ADD COLUMN country VARCHAR(30)");
            statement.executeUpdate("UPDATE test1 SET country = 'Italy' WHERE id = 1");
            statement.executeUpdate("UPDATE test1 SET country = 'Italy' WHERE id = 2");
            statement.executeUpdate("UPDATE test1 SET country = 'Germany' WHERE id = 3");
            statement.executeUpdate("UPDATE test1 SET country = 'Germany' WHERE id = 4");
            ResultSet resultSet = statement.executeQuery("select * from test1");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("country"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
