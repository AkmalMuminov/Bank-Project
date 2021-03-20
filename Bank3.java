import java.util.Collections;
import java.util.ArrayList;
/**
 * Alternate bank #1.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (4/12/18)
 */
public class Bank3 implements BankInterface
{
    private String nameOfBank;
    private ArrayList<Account> accounts;
    private int numOfAccounts;
    
    /**
     * Constructor for objects of class Bank
     */
    public Bank3(String theName)
    {
        accounts = new ArrayList<Account>();
        nameOfBank=theName;
        numOfAccounts = 0;
    }

    /**
     * addAccount: Adds Account newAccount to the Bank class' array
     *
     * @param  Account newAccount
     * @return    void
     * 
     * Precondition: newAccount has a unique ID string attribute
     * 
     * Postcondition: newAccount is added to the Bank class' array
     */
    public void addAccount(Account newAccount)
    {

            if(containsAccount(newAccount))
            {
                //put code in that lets the user try again
            }
            else
            {
                accounts.add(this.numOfAccounts,newAccount);
                this.numOfAccounts++;
            }
    }
    
    public boolean containsAccount (Account anAccount)
    {
        boolean result = false;
        Account dummy = null;
       
        dummy = this.search(anAccount.getID());
        if(dummy !=null)
        {
            result = true;
        }
        return result;
    }
    
    /**
     * Searches the array items anArray[first] through
     * anArray[last] for value by using a binary search.
     * Precondition: 0 <= first, last <= SIZE-1, where
     * SIZE is the maximum size of the array, and
     * anArray[first] <= anArray[first+1] <= ... <= anArray[last].
     * Postcondition: If value is in the array, the method
     * returns the index of the array item that equals value;
     * otherwise the method returns -1.
     */
    public int binarySearch(int first, int last, String value) 
    {
    

    
      int index;
    
      if (first > last) 
      {
    
        index = -1;      // value not in original array
    
      } 
      else 
      {
    
        // Invariant: If value is in anArray, 
        // anArray[first] <= value <= anArray[last]
    
        int mid = (first + last)/2;
    
        if (Integer.parseInt(value) == Integer.parseInt(((Account)this.accounts.get(mid)).getID())) 
        {
    
          index = mid;  // value found at anArray[mid]
    
        } 
        else if (Integer.parseInt(value) < Integer.parseInt(((Account)this.accounts.get(mid)).getID())) 
        {
    
          index = binarySearch(first, mid-1, value);   // point X
    
        } 
        else 
        {
    
          index = binarySearch(mid+1, last, value);    // point Y
    
        }  // end if
      }  // end if
    
      return index;
    }  // end binarySearch
    
    
    /**
     * search: return an account after being given an ID
     * 
     * @param a String thisID, the ID that corresponds to a Account
     * @return an Account, the one with the same String attribute "ID" as thisID
     * 
     * Precondition: the String thisID is the same as one of the Accounts
     * String attribute "ID" in the Bank class array
     * 
     * Postcondition: the Account returned corresponds to the ID given, if the ID does not exist returns null
     */
    public Account search(String thisID)
    {
        Account result=null;
        
        int binResult=this.binarySearch(0, this.numOfAccounts-1, thisID);
        if (binResult==-1)
        {
            return result;
        }
        else
        {
            return (Account)accounts.get(binResult);
        }

    }
    
    public Account getAccount(int index)
    {
        return this.accounts.get(index);
    }
    
    
    /**
     * searchHelper: return an account after being given an ID
     * 
     * @param a String thisID, the ID that corresponds to a Account
     * @return an Account, the one with the same String attribute "ID" as thisID
     * 
     * Precondition: the String thisID is the same as one of the Accounts
     * String attribute "ID" in the Bank class array
     * 
     * Postcondition: the Account returned corresponds to the ID given, if the ID does not exist returns null
     */
    private Account searchHelper(String thisID)
    {
        Account result=null;
        
        //Old Linear Search Code
        // for (int i = 0; i<numOfAccounts; i++)
        // {
            // if (thisID.equals(accounts[i].getID()))
            // {
                // //result = 
                // return this.accounts[i];
            // }
        // }
        int binResult = this.binarySearch(0, this.numOfAccounts-1, thisID);
        if (binResult == -1)
        {
            return result;
        }
        else
        {
            return (Account)accounts.get(binResult);
        }
        //return result;
    }
    
    /**
     * deposit: adds money to a certain account
     * 
     * @param a String thisID, the ID that corresponds to a Account
     * @param a Money object thisMoney with the amount of money should be added
     *       
     * Precondition: the String thisID is the same as one of the Accounts
     * String attribute "ID" in the Bank class array
     * 
     * 
     * Postcondition: certain Account`s balance increases by thisMoney amount
     */
    
    public void deposit(String thisID, Money thisMoney)
    {
        //this.search(thisID).deposit(thisMoney);
        if(this.searchHelper(thisID)!=null)
        {
            Account accountReturned = this.searchHelper(thisID);
            accountReturned.deposit(thisMoney);
        }
    
    }
    
    /**
     * withdraw: withdraws money from a certain account
     * 
     * @param a String thisID, the ID that corresponds to a Account
     * @param a Money object thisMoney with the amount of money should be withdrew
     *       
     * Precondition: the String thisID is the same as one of the Accounts
     * String attribute "ID" in the Bank class array
     * 
     * 
     * Postcondition: certain Account`s balance decreases by thisMoney amount
     */
    
    public void withdraw(String thisID, Money thisMoney)
    {
        if(this.searchHelper(thisID)!=null)
        {
            Account accountReturned = this.searchHelper(thisID);
                 
            // if (accountReturned.getType() == 's') {
                // Savings a = (Savings) accountReturned;
                // a.withdraw(thisMoney);
            // }
            // else if (accountReturned.getType() == 'c') {
                        // Checking a = (Checking) accountReturned;
                        // a.withdraw(thisMoney);
                    // }
            
            
  
            // if (a instanceof Savings)
                // System.out.println (thisID + " has a Savings account");
            // else if (a instanceof Checking)
                    // System.out.println (thisID + " has a Checking account");
                // else if (a instanceof Account)
                   // System.out.println (thisID + " has an unknown account");
            
            accountReturned.withdraw(thisMoney);
        }
    }
    
     /**
     * toString 
     * @return a String representation of this object
     * Precondition: this Bank object is valid
     * Postcondition: String object is returned that can be printed
     */
    
    public String toString()
    {
        String allAccounts = "";
        allAccounts+=this.nameOfBank + ", # of accounts: "+ numOfAccounts + "\n";
        
        for(int i = 0; i<numOfAccounts; i++)
        {
            allAccounts+=accounts.get(i).toString() + "\n";
        }
        return allAccounts;
    }
    
    /**
     * getNumOfAccounts: what it sounds like
     */
    public int getNumOfAccounts()
    {
        return this.numOfAccounts;
    }
    
    /**
     * getNameOfBank: what it sounds like
     */
    public String getNameOfBank()
    {
        return this.nameOfBank;
    }
    
    /**
     * sortAccounts
     * Calls: bubbleSort
     */
    public void sortAccounts ()
    {
        //SortsClass.quickSort((Comparable[])this.accounts.toArray(), 0, this.numOfAccounts-1);
        Collections.sort(this.accounts);
    }
    
    // /**
     // * Sorts the items in an array into ascending order.
     // * Precondition: theArray is an array of n items.
     // * Postcondition: theArray is sorted into ascending order.
     // */
    // private static void bubbleSort(Comparable[] theArray, int n)
    // {
        // boolean sorted = false; // false when swaps occur
         // for (int pass = 1; (pass < n) && !sorted; ++pass) {
         // // Invariant: theArray[n+1-pass..n-1] is sorted
         // // and > theArray[0..n-pass]
            // sorted = true; // assume sorted
            // for (int index = 0; index < n-pass; ++index) {
            // // Invariant: theArray[0..index-1] <= theArray[index]
               // int nextIndex = index + 1;
               // if (theArray[index].compareTo(theArray[nextIndex]) > 0) {
               // // exchange items
                  // Comparable temp = theArray[index];
                  // theArray[index] = theArray[nextIndex];
                  // theArray[nextIndex] = temp;
                  // sorted = false; // signal exchange
               // } // end if
            // } // end for
         // // Assertion: theArray[0..n-pass-1] < theArray[n-pass]
         // } // end for
    // }
}


