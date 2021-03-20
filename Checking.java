
/**
 * Write a description of class Checking here.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (a version number or a date)
 */
public class Checking extends Account
{
    private Money overdraftMaximum;
    char typeOfAccount;

    public Checking(String checkingName, String checkingID, Money checkingBalance, char t, Money odMax)
    {
            super(checkingName,checkingID,checkingBalance);
            overdraftMaximum = odMax;
            typeOfAccount = t;
    }
    
    /**
     * withdraw
     */
    @Override
    public void withdraw(Money checkingWithdrawal) throws InsufficientFundsException
    {
        
            if(checkingWithdrawal.compareTo(this.getBalance().add(overdraftMaximum)) <= 0)
            {
                super.withdraw(checkingWithdrawal);
            }
            else
            {
                throw new InsufficientFundsException();
            }
        
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", Account Type: Checking"; 
    }
    
    /**
     * returns char type
     */
    public char getType()
    {
        return 'c';
    }
}
