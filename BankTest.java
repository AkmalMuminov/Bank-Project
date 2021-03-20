

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BankTest.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (2/20/18)
 */
public class BankTest
{
    private Bank _bank;

    /**
     * Default constructor for test class BankTest
     */
    public BankTest()
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
        _bank = new Bank ("GenericBank");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */                     
    @After                          
    public void tearDown()
    {   
        _bank = null;
    }

    /**
     * Tests the Bank constructor.
     */
    @Test
    public void testCreate()
    {
        //Bank b1 = new Bank ("GenericBank");
        //Account[] acc= new Account[0];
        assertTrue("Error in testCreate",_bank.getNameOfBank().equals("GenericBank"));
        assertEquals("Error in testCreate",0, _bank.getNumOfAccounts());//create getNumOfAccounts later (not a required method)
        
    }
    
    /**
     * Test for the addAccount method
     * 
     */
    @Test
    public void testAddAccount()
    {
        //Test 1: adds 1 account to a bank and tests if the banks has 1 account
        Bank b1 = new Bank ("Citibank");
        Account a1= new Account("Will Smith", "911",new Money (1000));
        
        b1.addAccount(a1);
        
        assertEquals("Error in testAddAccount: Test 1", 1, b1.getNumOfAccounts());
        
        //Test 2: adds 4 accounts to a bank and tests if the bank has 4 accounts
        Bank b2 = new Bank ("OtherBank");
        for (int i = 1; i <= 4; i++)
        {
            Account a2 = new Account ("Jayden Smith", "1234", new Money (10000));
            b2.addAccount(a2);
        }
        
        assertEquals("Error in testAddAccount: Test 2", 4, b2.getNumOfAccounts());
        
        //Test 3: creates an identical account to the one added to the bank, gets the account stored in the bank using the search method, and tests if they are the same
        Account a3= new Account("Will Smith", "911",new Money (1000));
        
        Account a4 = b1.search("911");
        
        assertTrue("Error in testAddAccount: Test 3", a3.equals(a4)); 
    }
    
    /**
     * Test for the search method
     */
    @Test
    public void testSearch()
    {
        //Test 1: creates two identical accounts, adds one to an empty bank object, and tests if the search method returns the account
        Account a1= new Account("Will Smith", "911",new Money (1000));
        
        Bank b1 = new Bank("CitiBank");
        b1.addAccount(a1);
        
        Account actualAccount = b1.search("911");
        
        Account expectedAccount= new Account("Will Smith", "911",new Money (1000));
        
        assertTrue("Error in testSearch", actualAccount.equals(expectedAccount));
    }
    
    /**
     * Test for the deposit method !!add test that trys to deposit into null account!!
     */
    @Test
    public void testDeposit()
    {
        //Test 1: _bank is used to add an account to, and Money equals method is used to test deposit method
        _bank.addAccount(new Account ("Will Smith", "911", new Money (1000)));
        _bank.deposit("911", new Money (1000));
        
        Money expectedMoney = new Money (2000);
        
        Account actualAccount = _bank.search("911");
        
        assertTrue("Error in testDeposit: Test 1",expectedMoney.equals(actualAccount.getBalance()));  
        
        //Test 2: tests depositing to a null account
        
        Bank bank2 = new Bank ("Bank2");
        
        bank2.addAccount(new Account ("Will Smith", "911", new Money (2000)));
         
        String beforeString2 = bank2.toString();
        bank2.deposit("53567", new Money(10000));
        String afterString2 = bank2.toString();
        
        assertTrue("Error in testWithdraw: Test 2", afterString2.equals(beforeString2));
    }
    
    /**
     * Test for the withdraw method !!add test that trys to withdraw from null account!!
     */
    @Test
    public void testWithdraw()
    {
        //Test 1: Tests the normal case
        _bank.addAccount(new Account ("Will Smith", "911", new Money (2000)));
        _bank.withdraw("911", new Money (1000));
        
        Money expectedMoney = new Money (1000);
        Account actualAccount = _bank.search("911");
        //System.out.println(actualAccount.getBalance());
        
        assertTrue("Error in testWithdraw: Test 1",expectedMoney.equals(actualAccount.getBalance())); 
        
        //Test 2: Tests withdrawing from a null account
        
        Bank bank2 = new Bank ("Bank2");
        
        bank2.addAccount(new Account ("Will Smith", "911", new Money (2000)));
         
        String beforeString2 = bank2.toString();
        bank2.withdraw("53567", new Money(10000));
        String afterString2 = bank2.toString();
        
        assertTrue("Error in testWithdraw: Test 2", afterString2.equals(beforeString2));
        
    }
    
      /**
     * Test for the toString method
     */
    @Test
     public void testToString()
     {
        //Test 1: default case
        _bank.addAccount(new Account ("Will Smith", "911", new Money (2000)));
         
        String expected="GenericBank, # of accounts: 1" + "\n" + "Name: Will Smith, ID#: 911, Balance: $20.00\n" ;
        
        String actual=_bank.toString();
        assertTrue("Error in testToString: Test 1", expected.equals(actual));
    }
    
    /**
     * Test for privacy leaks
     */
    @Test
    public void testPrivacyLeak ()
    {
        //Test 1: if we call deposit on an account already in a bank, then the bank should not be affected
        Account test1 = new Account ("Will Smith", "911", new Money (2000));
        _bank.addAccount(test1);
        test1.deposit(new Money(1000));

        assertTrue("Error in testPrivacyLeak: Test 1", _bank.search("911").getBalance().equals(new Money (2000)));
        
        //Test 2: if we call withdraw on an account already in a bank, then the bank should not be affected
        Account test2 = new Account ("Will Smith", "911", new Money (2000));
        _bank.addAccount(test2);
        test2.withdraw(new Money(1000));
        
        assertTrue("Error in testPrivacyLeak: Test 2", _bank.search("911").getBalance().equals(new Money (2000)));
        
        //Test 3: 
        Bank bank3 = new Bank ("Bank3");
        bank3.addAccount(new Account ("Will Smith", "911", new Money (2000)));
        Account copyOfAccount = bank3.search("911");
        copyOfAccount.deposit(new Money (2000));
        
        String expected = "Bank3, # of accounts: 1" + "\n" + "Name: Will Smith, ID#: 911, Balance: $20.00\n";
        assertTrue("Error in testPrivacyLeak: Test 3", expected.equals(bank3.toString()));
    }
    
    /**
     * Tests the sortAccounts method
     */
    @Test
    public void testSortAccounts()
    {
        //Test 1
        _bank.addAccount(new Account("Akmal", "444", new Money (5000)));
        _bank.addAccount(new Account("Akmal", "12", new Money (5000)));
        _bank.addAccount(new Account("Akmal", "44", new Money (5000)));
        _bank.addAccount(new Account("Akmal", "999", new Money (5000)));
        _bank.addAccount(new Account("Akmal", "01", new Money (5000)));
        
        _bank.sortAccounts();
        String expected = "GenericBank, # of accounts: 5" + "\n" + "Name: Akmal, ID#: 01, Balance: $50.00" + "\n" + "Name: Akmal, ID#: 12, Balance: $50.00" + "\n" + "Name: Akmal, ID#: 44, Balance: $50.00" + "\n" + "Name: Akmal, ID#: 444, Balance: $50.00" + "\n" + "Name: Akmal, ID#: 999, Balance: $50.00\n";
        assertTrue("Error in testSortAccounts: Test 1", _bank.toString().equals(expected));
        //System.out.println(_bank);
    }
}

   
   
    
