

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckingTest
{
    private Checking _checkingAccount;
    /**
     * Default constructor for test class CheckingTest
     */
    public CheckingTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _checkingAccount = new Checking ("John Smith", "12345", new Money (10000), 'c', new Money (5000));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        _checkingAccount = null;
    }
    
    /**
     * Tests the withdrawal method of checking
     */
    @Test
    public void testWithdrawal()
    {
        //Test 1: Tests withdrawing more than the overdraftMaximum
        try
        {
            _checkingAccount.withdraw(new Money(16000));
            Money expectedAmount = new Money (10000);
        }
        catch (InsufficientFundsException ife)
        {
            System.out.println("Insufficient funds.");
            ife.printStackTrace();
        }

        
        //Test 2: Tests withdrawing less than the overdraftMaximum
        Checking test2 = new Checking ("Ryan","420", new Money (10000), 'c', new Money (5000));
        test2.withdraw(new Money(11000));
        Money expectedAmount2 = new Money (-1000);
        
        assertTrue("Error in testWithdrawal: Test 2", test2.getBalance().equals(expectedAmount2));
        
        //Test 3: Tests withdrawing an amount equal to the overdraftMaximum + the account balance
        Checking test3 = new Checking ("Akmal","21", new Money (10000), 'c', new Money (5000));
        test3.withdraw(new Money(15000));
        Money expectedAmount3 = new Money (-5000);
        
        assertTrue("Error in testWithdrawal: Test 3", test3.getBalance().equals(expectedAmount3));
    }
    
    @Test (expected = InsufficientFundsException.class)
    public void testOverwithdraw() 
    {
        // Create a checking account.
        Checking acc = new Checking("Ryan", "123", new Money(5000), 'c', new Money(5000));

        // Withdraw an amount that should cause an exception of type InsufficientFundsException...
        acc.withdraw( new Money(20000) );
    }
}
