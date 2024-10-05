package my.library.system.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection
{
    public void DB()
    {
        try
        {
            Connection newconn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/library",
                    "root",
                    "user"
                /*
                Replace Library with the name of your database
                Replace root with your username
                Replace user with your password
                 */

            );


            Statement statement = newconn.createStatement();

            System.out.println("Connection Successful!!");

            statement.close();
            newconn.close();
        }
        catch (Exception e)
        {
            System.out.println("Connection failed!!");
        }
    }
}
