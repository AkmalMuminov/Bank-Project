import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

// Driver class for Bank project

public class ATM
{
   public static void main (String[] args)
   {
      try 
      {

          // Read data from a file into a Bank.
          // Each line of the file has info for one account.  
          BankInterface myBank = readFromFile("in_accounts.txt");
          myBank.sortAccounts();

          // Print all the data stored in the bank.
          IOHandlerDialog handler = new IOHandlerDialog();
          //handler.get("Welcome to Generic Bank. Please enter your account ID");
          handler.put("Welcome to Generic Bank.");
          
          
          Account currentAccount = null;
          String id=enterID();
          while (currentAccount == null) {
            try
            { 
                currentAccount = lookForAccount(myBank, id);
                
            }
            catch(NumberFormatException e)
            {
                handler.put("Goodbye.");
                System.exit(1);
            }
            catch(Exception e)
            {
              handler.put("Not valid input. Try again.");
              handler.put("Welcome to Generic Bank.");
              id = enterID();   
            }
          } 
         
          // Display drop down menu and get choice
          char choice = getFromMenu();
          
          while(choice!='E')
          {
              try {
                 executeTransaction(choice, currentAccount.getID(), myBank);
              }
              catch (InsufficientFundsException e) 
              {
                  // if(currentAccount.getType() == 'c')
                  // {
                      // executeTransaction(choice, currentAccount.getID(), myBank);
                  // }
                  // else
                  // {
                      handler.put("Insufficient funds.");
                  // // }
              }
              choice = getFromMenu();
          }
          //FileCopier copier = new FileCopier();
          //copyTextFile(myBank,"out_accounts.txt");
          PrintWriter ofStream = null; // declare an output file stream
            try {
                // Initialize the input file stream, based on the name of the input file, stored in originalFileName
                //ifStream = new BufferedReader(new FileReader(theBank.toString()));

                // Initialize the output file stream, based on the name of the output file, stored in copyFileName
                ofStream = new PrintWriter(new FileWriter("out_accounts.txt")); 

                String line;
    
                // copy lines one at a time from given file to new file
                // while ((line = ifStream.readLine()) != null) {
                    // ofStream.println(line);  // Write a line to the output file.
                    // } // end while
                    for(int i=0;i<myBank.getNumOfAccounts();i++)
                    {
                        line = myBank.getAccount(i).toString();
                        ofStream.println(line);
                    }
                    //ifStream.close(); // close the files
                    ofStream.close();
                } // end try
                catch (IOException e) {
                    System.out.println("Error copying file");
                } // end catch
                finally {
                    if (ofStream != null) {
                        ofStream.close();
                    } // end if
                } // end finally
    } // end try  
      catch (IOException ioe) {
         System.out.println("IOException in main: " + ioe.getMessage()); 
         ioe.printStackTrace();
      } // end catch
      catch(NumberFormatException e)
            {
                IOHandlerDialog handler = new IOHandlerDialog();
                handler.put("Goodbye.");
                System.exit(1);
            }
      catch (NullPointerException e)
      {
          IOHandlerDialog handler = new IOHandlerDialog();
          handler.put("Goodbye.");
          System.exit(1);
      }
      catch (Exception e) {
         System.out.println("Exception in main: " + e.getMessage());
         e.printStackTrace();
      } // end catch
      
   } // end main


   
   public static Account lookForAccount(BankInterface myBank, String id)
   {
      Account currentAccount = myBank.search(id);
      IOHandlerDialog handler = new IOHandlerDialog();
      
       if(currentAccount!=null)
       {
        handler.put(currentAccount.toString());
      }
      else
      {
          while(currentAccount == null)
          {
              handler.put("Account not found.");
              String otherID = enterID();
              currentAccount = myBank.search(otherID);
          }
      }
      return currentAccount;
   }//end lookForAccount
   
   /**
    * 
    */
   public static void executeTransaction(char choice, String userID, BankInterface myBank)
   {
       IOHandlerDialog handler = new IOHandlerDialog();
       switch (choice)
       {
          case 'W': 
          String withdrawal = handler.get("Amount to withdraw. (ex: 100 = $1.00)");
          long longAmountW = Long.parseLong(withdrawal);
          Money amountW = new Money(longAmountW);
          
          myBank.withdraw(userID, amountW);
          break;
          
          case 'D':
          String deposit = handler.get("Amount to deposit. (ex: 100 = $1.00)");
          long longAmountD = Long.parseLong(deposit);
          Money amountD = new Money(longAmountD);
          myBank.deposit(userID, amountD);
          break;
          
          case 'B':
          handler.put(myBank.search(userID).toString());
          break;
          
          case 'E':
          break;
          
        }
       
    
    
    }//end executeTransaction
    
   
   public static char getFromMenu()
   {
       String[] choices = { "Withdraw", "Deposit", "Balance","Exit" };
       String input = (String) JOptionPane.showInputDialog(null, "Choose transaction.",
        "Generic Bank, Inc", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                        // default
                                                                        // icon
        choices, // Array of choices
        choices[0]); // Initial choice    
        
        return input.charAt(0);
   }
   
   public static String enterID()
   {
       IOHandlerDialog handler = new IOHandlerDialog();
       String id = handler.get("Please enter your account ID");
       return id;
   }


   /**
    * readFromFile:    **** INSERT COMMENTS ****
    * 
    */
   public static BankInterface readFromFile (String fileName) throws IOException
   {
     // Creata a bank.
     BankInterface myBank = new Bank3 ("Generic Bank");//***** INSERT CODE TO CONSTRUCT BANK OBJECT ****

         // Open a file for reading.
         Scanner inputSource = new Scanner (new File(fileName));//*** INSERT PARAMETER STORING FILE NAME ****
       
         // while there are more tokens to read from the input source...
     while (inputSource.hasNext())
     //**** INSERT CODE FOR BOOLEAN EXPRESSION: THERE IS MORE TO READ FROM THE INPUT SOURCE i.e. call hasNext() method on Scanner object ****
     {

        // Read one line of input from the file into an Account object
        //**** INSERT SCANNER OBJECT ****
            Account acct = InputManager.readOneAccountFrom (inputSource);
        
        // Store the account info in the bank.
        //**** INSERT CODE TO ADD acct TO THE BANK ****
        myBank.addAccount(acct);

     } // end while


         return myBank;

    } // end readFromFile

} // end ATM