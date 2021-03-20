

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AccountTest.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (2/20/18)
 */
public class AccountTest
{
    
    private Account _account;
    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
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
         _account = new Account ("John Smith", "12345", new Money (10000));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */                     
    @After                          
    public void tearDown()
    {  
        _account = null;
    }

    /**
     * Tests the creation of accounts
     */
    @Test
    public void testCreate ()
    {
        Account x = new Account("John Smith", "12345", new Money (10000));
        assertTrue("Error in testCreate", _account.equals(x));
        
        
    }
    
    /**
     * Tests the deposit of money into accounts
     */
    @Test
    public void testDeposit()
    {
        Account x= new Account("Will Smith", "911",new Money (1000));
        Money m = new Money (100);
        Account y= new Account ("Will Smith", "911", new Money (1100));

        x.deposit(m);

        assertTrue("Error in testDeposit", x.equals(y));
        
    }
    
    /**
     * Tests the withdrawal of money from accounts
     */
    @Test
    public void testWithdrawal()
    {
        Account x= new Account("Will Smith", "911",new Money (1000));
        Money withdrawal= new Money (100);
        Account y= new Account ("Will Smith", "911", new Money (900));
        
        x.withdraw(withdrawal);
        
        assertTrue("Error in testDeposit", x.equals(y));
    }
    
    /**
     * Tests the transfer of money from one account to the other.
     */
    @Test
    public void testTransfer()
    {
        Account x= new Account("Will Smith", "911",new Money (1000));
        Account y= new Account ("Jayden Smith", "785", new Money (900));
        
        x.transfer(y,new Money (100));
        
        Account z= new Account ("Jayden Smith" , "785", new Money (1000));
        Account a= new Account ("Will Smith", "911", new Money (900));
        
        assertTrue("Error in testTransfer", y.equals(z));
        assertTrue("Error in testTransfer", x.equals(a));        
        
        
    }
    
    /**
     * Tests the transfer of money from one account to the other.
     */
    @Test
    public void testToString()
    {
        Account x= new Account("Will Smith", "911",new Money (1000));
        
        String a=x.toString();
        String b= "Name: Will Smith, ID#: 911, Balance: $10.00";
        
        assertTrue("Error in testToString", b.equals(a));//this equals method tests 2 strings
        
    }
   
    /**
     * Tests that one account is the same as another.
     */
    @Test
    public void testEquals()
    {
        Account x= new Account("Will Smith", "911",new Money (1000));
        Account y= new Account ("Will Smith", "911",new Money (1000));
        
        assertTrue("Error in testEquals", y.equals(x)); //this equals method tests 2 accounts
    }
    
    /**
     * Tests for privacy leaks in Account class
     */
    @Test
    public void testPrivacyLeak ()
    {
        //Test 1: will changing a Money in an account affect the account?
        
        Money test1 = new Money (1000);
        Money test2 = _account.getBalance();
        
        test1.add(test2);
        
        String expected = "Name: John Smith, ID#: 12345, Balance: $100.00";
        assertTrue("Error in testPrivacyLeak: Test 1", expected.equals(_account.toString())); 
    }
}
