
/**
 * Subclass of Account that has interestRate.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (4/3/18)
 */
public class Savings extends Account
{
    private double interestRate;
    char typeOfAccount;
    
    public Savings(String savingsName, String savingsID, Money savingsBalance, char t, double rateOfInterest)
    {
        super(savingsName, savingsID, savingsBalance);
        interestRate = rateOfInterest;
        typeOfAccount = t;
    }
    
    /**
     * addInterest: adds the interest rate to the Account's balance
     * Precondition: this account is a valid Account object
     * Postcondition: the balance of this account is equal what the balance was
     * previously + the variable rate below 
     */
    public void addInterest()
    {
      long x = super.getBalance().getTotalCents(); //gets the balance of this account and calls it x
      Money rate= new Money((long)((x*interestRate/100))); // creates a money that is equal to 'interestRate'% of x
      
      super.deposit(rate); //deposits x into this account

    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", Account Type: Savings"; 
    }
    
    @Override
    public void withdraw(Money theWithdrawal) throws InsufficientFundsException
    {
       
            if(theWithdrawal.compareTo(this.getBalance()) <= 0)
            {
                super.withdraw(theWithdrawal);
            }
            else
            {
                throw new InsufficientFundsException();
            }
        
    }
}
