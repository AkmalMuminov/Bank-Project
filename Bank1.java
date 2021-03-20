import java.util.Collections;
/**
 * Alternate bank #1.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (4/12/18)
 */
public class Bank1 implements BankInterface
{
    private String nameOfBank;
    private ListArrayBased accounts;
    private int numOfAccounts;
    
    /**
     * Constructor for objects of class Bank
     */
    public Bank1(String theName)
    {
        accounts = new ListArrayBased();
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
        accounts.add(this.numOfAccounts, new Account(newAccount));
        this.numOfAccounts++;
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
    
      if (first >= last) 
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
        
        //Old Linear Search Code
        // for (int i = 0; i<numOfAccounts; i++)
        // {
            // if (thisID.equals(accounts[i].getID()))
            // {
                // //result = 
                // return new Account(accounts[i]);
            // }
        // }
        int binResult=this.binarySearch(0, this.numOfAccounts, thisID);
        if (binResult==-1)
        {
            return result;
        }
        else
        {
            return new Account((Account)accounts.get(binResult));
        }

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
        int binResult = this.binarySearch(0, this.numOfAccounts, thisID);
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
     *
     */
    public void sortAccounts ()
    {
        //Collections.sort(this.accounts);
    }
    
    public Account getAccount(int index)
    {
        Account result = null;
        return result;
    }
    
}


