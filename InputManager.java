
/**
 * Manage input to be read from either keyboard or file.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class InputManager
{
    // Method: readOneAccountFrom
    // Precondition: inputSource is a Scanner object, already set up
    // to read from a text file or standard input source (keyboard).
    // Postcondition: returns an Account with the data read for its attributes.
    // Assumption: Account data will be in the format of: name,id,balance
    public static Account readOneAccountFrom (Scanner inputSource)
    {
        // Read one line of account data into oneLine
        System.out.println ("Reading: name,id,balance,typeOfAccount,overdraft maximum / interest rate");
        String oneLine = inputSource.nextLine();
        
        // Parse line of account data, separated by commas.
        Scanner lineTokenizer = new Scanner (oneLine);
        lineTokenizer.useDelimiter (",");
        
        // Get account data (i.e. name, accountNum and balance) from oneLine
        String name = lineTokenizer.next ();
        String accountNum = lineTokenizer.next ();
        Money balance = new Money (lineTokenizer.nextLong());
        String typeOfAccount = lineTokenizer.next();
        Integer ODoIR = new Integer (lineTokenizer.nextInt());
        //Account oneAccount = null;
        // Create and return an Account object with the data read for one   account.
        if (typeOfAccount.charAt(0)=='c')
        {
            Money odMax = new Money(ODoIR.longValue());
            return new Checking (name, accountNum, balance,typeOfAccount.charAt(0),odMax);
            //oneAccount = account;
        }
        else
        {
            double interestRate = ODoIR.doubleValue();
            return new Savings (name, accountNum, balance, typeOfAccount.charAt(0), interestRate);
            //oneAccount = otherAccount;
        }
        
        
        //return oneAccount;
    } // end readOneAccountFrom
    
} // end InputManager
