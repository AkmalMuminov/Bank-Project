
/**
 * Interface BankInterface for the ADT Bank.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (3/22/18)
 */
public interface BankInterface
{
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
    public void addAccount(Account newAccount);

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
    public Account search(String thisID);

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
    
    public void deposit(String thisID, Money thisMoney);

    
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
    
    public void withdraw(String thisID, Money thisMoney);

    
     /**
     * toString 
     * @return a String representation of this object
     * Precondition: this Bank object is valid
     * Postcondition: String object is returned that can be printed
     */
    
    public String toString();

    
    /**
     * getNumOfAccounts: what it sounds like
     */
    public int getNumOfAccounts();

    
    /**
     * getNameOfBank: what it sounds like
     */
    public String getNameOfBank();
    
    public void sortAccounts ();
    
    public Account getAccount(int index);


}
