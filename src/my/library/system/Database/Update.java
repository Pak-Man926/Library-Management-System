package my.library.system.Database;

import java.sql.*;
import java.util.Scanner;

public class Update
{
    public void Update()
    {
        try {
            Scanner obj = new Scanner(System.in);

            //Create connection with the database
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

            //Printout all values within the database
            Read firstreader = new Read();

            firstreader.Read();

            int change;

            //Choose what you'd like to update
            System.out.println("Please choose the part you'd like to update:");
            System.out.println("1. Author");
            System.out.println("2. Title");
            System.out.println("3. Genre");
            System.out.println("4. Count");

            change = obj.nextInt();

            int rowsAffected = 0;

            if (change == 1) {
                Scanner input = new Scanner(System.in);

                // Correct SQL query syntax
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE books " +
                                "SET Author = ? " +
                                "WHERE Author = ?"
                );

                System.out.println("Enter the current author's name:");
                String oldAuthor = input.nextLine();

                System.out.println("Enter the new author's name:");
                String newAuthor = input.nextLine();

                // Set the new author first, then the old author for the WHERE clause
                preparedStatement.setString(1, newAuthor);
                preparedStatement.setString(2, oldAuthor);

                // Execute update and check if rows were affected
                rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0)
                {
                    System.out.println("Author updated successfully!");
                }
                else
                {
                    System.out.println("No matching record found to update!");
                }

                // Close resources
                preparedStatement.close();
                firstreader.Read();
            }
            else if (change == 2)
            {
                Scanner second = new Scanner(System.in);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE books " +
                                "SET Title = ? " +
                                "WHERE Title = ?"
                );

                System.out.println("Enter the book's current title:");
                String oldTitle = second.nextLine();

                System.out.println("Enter the book's new title:");
                String newTitle = second.nextLine();

                //Set the new title first then the old to follow
                preparedStatement.setString(1, newTitle);
                preparedStatement.setString(2, oldTitle);

                // Execute update and check if rows were affected
                rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0)
                {
                    System.out.println("Title updated successfully!");
                } else {
                    System.out.println("No matching record found to update!");
                }

                // Close resources
                preparedStatement.close();
                firstreader.Read();
            }
            else if (change == 3)
            {

                Scanner third = new Scanner(System.in);

                // Prepare statement to update the Genre based on the Title
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE books SET Genre = ? WHERE Title = ?"
                );

                System.out.println("Enter the book's title:");
                String title = third.nextLine();

                System.out.println("Enter the book's new genre:");
                String newGenre = third.nextLine();

                // Set parameters: new genre and title
                preparedStatement.setString(1, newGenre);
                preparedStatement.setString(2, title);

                // Execute the update and check if rows were affected
                rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Genre updated successfully!");
                } else {
                    System.out.println("No matching record found to update!");
                }

                // Close resources
                preparedStatement.close();
                firstreader.Read();
            }
            else if (change == 4)
            {
                Scanner fourth = new Scanner(System.in);

                // Prepare statement to update the Count based on the Title
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE books SET Count = ? WHERE Title = ?"
                );

                System.out.println("Enter the book's title:");
                String title = fourth.nextLine();

                System.out.println("Enter the book's new count:");
                int newCount = fourth.nextInt(); // Since Count is an integer

                // Set parameters: new count and title
                preparedStatement.setInt(1, newCount);
                preparedStatement.setString(2, title);

                // Execute the update and check if rows were affected
                rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Count updated successfully!");
                } else {
                    System.out.println("No matching record found to update!");
                }

                // Close resources
                preparedStatement.close();
                firstreader.Read();
            }
            else
            {
                System.out.println("Input not valid. Please try again!!");
            }

            connection.close();

        }
        catch (Exception e)
        {
            System.out.println("Failed to update: " + e.getMessage());
        }
    }
}
