
/**
 * An account with money.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (2/20/18)
 */
public class Account implements Comparable
{
    private String name;
    private String id;
    private Money balance;
    
    /**
     * Constructor for objects of class Account
     */
    public Account (String theName, String theID, Money theBalance)
    {
        this.name = theName;
        this.id = theID;
        this.balance = theBalance;
    }
    
    /**
     * Copy constructor for objects of class Account
     */
    public Account (Account original)
    {
        this.name = original.name;
        this.id = original.id;
        this.balance = original.balance;
    }
    
    /**
     * deposit: Increases the Money balance by the amount, theDeposit
     *
     * @param  a Money, theDeposit
     * @return    void
     * 
     * Precondition: This account object and the Money theDeposit are both valid
     * 
     * Postcondition: The account's balance increases by theDeposit amount
     * The calling object is changed while the parameter is not.
     */
    public void deposit(Money theDeposit)
    {
        //Money result = new Money (this.balance.add(theDeposit));
        this.balance=this.balance.add(theDeposit);
    }
    
    /**
     * withdraw: Decreases the Money balance by the amount, theWithdrawal
     *
     * @param  a Money, theWithdrawal
     * @return    void
     * 
     * Precondition: This account object and the Money theWithdrawal are both valid
     * 
     * Postcondition: The account's balance decreases by theWithdrawal amount
     * The calling object is changed while the parameter is not.
     */
    public void withdraw(Money theWithdrawal) //throws InsufficientFundsException
    {
            // if(theWithdrawal.compareTo(this.getBalance()) <= 0)
            // {
                this.balance=this.balance.subtract(theWithdrawal);
            // }
            // else
            // {
                // throw new InsufficientFundsException();
            // }
        
    }
    
    /**
     * Transfers money from the account invoking the method to the parameter account
     * @param: Account object j
     * @param: Money object a
     * 
     * Precondition: This account/ Account j and Money a objects are valid
     * Postcondition: Transfers an amount of Money a, to Account j from this Account
     */
    public void transfer(Account j, Money a)
    {
        this.withdraw(a);
        j.deposit(a);
    }
    
    
     /**
     * toString 
     * @return a String representation of this object
     * Precondition: this Account object is valid
     * Postcondition: String object is returned that can be printed
     */
    public String toString()
    {
        return "Name: "+this.name + ", ID#: " + this.id + ", Balance: " + this.balance.toString();
    }
    
    /**
     * equals: determines if two Account objects are equal
     * 
     * @return a boolean, true if calling object is the same as parameter object
     * @param Account j object
     * 
     * Precondition: Both Account objects are valid
     * Postcondition: A boolean is returned
     */
    public boolean equals (Account j)
    {
        boolean result;
        
        if (this.name.equals(j.name) && this.id.equals(j.id) && this.balance.equals(j.balance))
        {
            result=true;
        }
        else
        {
            result=false;
        }
        
        return result;
    }
    
    /**
     * 
     * getID: what it sounds like
     */
    public String getID()
    {
        return this.id;
    }
    
    /**
     * 
     * getBalance: what it sounds like
     */
    public Money getBalance()
    {
        return this.balance;
    }
    
    /**
     * compareTo: compare two Account objects.
     * Precondition: parameter o is an Object (of type Account)
     * Postcondition: return 0 if this.id is the same as o.id, -1 if this.id < o.id, 1 if this.id > o.id.
     */
    @Override
    public int compareTo(Object o)
    {
        if (o instanceof Account)
        {
            Account asAccount = (Account) o;
            if (Integer.parseInt(this.id)==Integer.parseInt((asAccount.id)))
            {
                return 0;
            }
            else if (Integer.parseInt(this.id)>Integer.parseInt((asAccount.id)))
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        return 2;
    }
    
    public char getType()
    {
        return 'c';
    }
}
