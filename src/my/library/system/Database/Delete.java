package my.library.system.Database;

import java.sql.*;
import java.util.Scanner;

public class Delete
{
    public void Delete()
    {
        Scanner acc = new Scanner(System.in);

        try
        {
            // Create connection with the database
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

            int options;

            System.out.println("======================================================");
            System.out.println("To Delete, Please Choose Which Parameter Value to Use:");
            System.out.println("=======================================================");
            System.out.println("1. Author");
            System.out.println("2. Title");

            options = acc.nextInt();
            acc.nextLine();  // Consume the leftover newline

            if (options == 1)
            {
                Read newreader = new Read();
                newreader.Read();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM books WHERE Author = ?"
                );

                System.out.println("Enter the author's name:");
                String author = acc.nextLine();  // Properly read author name after consuming newline

                preparedStatement.setString(1, author);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0)
                {
                    System.out.println("Deletion successful!");
                }
                else
                {
                    System.out.println("No matching record found!");
                }

                newreader.Read();
                preparedStatement.close();
            }
            else if (options == 2)
            {
                Read newreader = new Read();
                newreader.Read();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM books WHERE Title = ?"
                );

                System.out.println("Enter the title of the book you want to delete:");
                String title = acc.nextLine();  // Properly read title

                preparedStatement.setString(1, title);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0)
                {
                    System.out.println("Deletion successful!");
                }
                else
                {
                    System.out.println("No matching record found!");
                }

                newreader.Read();
                preparedStatement.close();
            }
            else
            {
                System.out.println("Invalid input!");
            }

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("Failed to delete! " + e.getMessage());
        }
    }
}
