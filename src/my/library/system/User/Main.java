package my.library.system.User;

import my.library.system.Database.*;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
      Scanner impt = new Scanner(System.in);
      DatabaseConnection advance = new DatabaseConnection();
      Create now = new Create();
      Read read = new Read();
      Update update = new Update();
      Delete delete = new Delete();

      int count;

      while (true)
      {

          System.out.println("\nWelcome to Masomo Library System.\n");
          System.out.print("=================================================\n");
          System.out.print("=================================================\n");
          System.out.println("Please choose one of the following options:");
          System.out.print("=================================================\n");
          System.out.println("1. SHOW ALL AVAILABLE BOOKS:");
          System.out.println("2. ADD NEW BOOKS:");
          System.out.println("3. UPDATE BOOKS RECORDS:");
          System.out.println("4. DELETE FROM EXISTING RECORD:");
          System.out.println("5. EXIT");

          count = impt.nextInt();

          if (count == 1)
          {
             read.Read();
          }
          else if (count == 2)
          {
              now.Create();
          }

          else if (count == 3)
          {
              update.Update();
          }

          else if (count == 4)
          {
              delete.Delete();
          }

          else if (count == 5)
          {
              System.exit(0);
          }

          else
          {
            System.out.println("Wrong input. Try Again!");
          }
      }

    }
}
