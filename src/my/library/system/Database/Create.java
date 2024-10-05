package my.library.system.Database;

import java.sql.*;
import java.util.Scanner;

public class Create
{
    public void Create()
    {
        Scanner obj = new Scanner(System.in);
        try
        {
            Connection myConn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/library",
                    "root",
                    "user"

                    /*
                Replace Library with the name of your database
                Replace root with your username
                Replace user with your password
                 */
            );

            PreparedStatement mystmnt = myConn.prepareStatement(
                    "INSERT INTO books (Author, Title, Genre, Count) VALUES (?, ?, ?, ?)");

            System.out.println("Enter the Book's Author:");
            String Author = obj.nextLine();

            System.out.println("Enter the Book Title:");
            String Title = obj.nextLine();

            System.out.println("Enter the Book Genre:");
            String Genre = obj.nextLine();

            System.out.println("Enter the Number of copies available:");
            String Count = obj.next();

            // Set the parameters
            mystmnt.setString(1, Author);
            mystmnt.setString(2, Title);
            mystmnt.setString(3, Genre);
            mystmnt.setString(4, Count);

            // Execute the update
            int rowsAffected = mystmnt.executeUpdate();

            if (rowsAffected > 0)
            {
                System.out.println("Data Inserted!");
            }
            else
            {
                System.out.println("No data inserted!");
            }

            // Close resources
            mystmnt.close();
            myConn.close();

        }
        catch (Exception e)
        {
            System.out.println("Failed to insert: " + e.getMessage());
        }
    }
}
