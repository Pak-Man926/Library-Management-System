package my.library.system.Database;

import java.sql.*;

public class Read
{
    public void Read()
    {
        try
        {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/library",
                    "root",
                    "user"


                    /*
                Replace Library with the name of your database
                Replace root with your username
                Replace user with your password
                 */
            );

            // Prepare SQL query
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM books"
            );

            // Execute the query and retrieve the result set
            ResultSet resultSet = statement.executeQuery();

            // Loop through the result set and print the data
            while (resultSet.next())
            {
                // Retrieve data by column names or indexes
                String author = resultSet.getString("Author");
                String title = resultSet.getString("Title");
                String genre = resultSet.getString("Genre");
                int count = resultSet.getInt("Count");

                // Display the retrieved data
                System.out.println("Author: " + author);
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Count: " + count);
                System.out.println("----------------------------");
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (Exception e)
        {
            System.out.println("Could not show data: " + e.getMessage());
        }
    }
}
