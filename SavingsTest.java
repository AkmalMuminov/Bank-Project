

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SavingsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SavingsTest
{
    private Savings _savingsAccount;
    /**
     * Default constructor for test class SavingsTest
     */
    public SavingsTest()
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
        _savingsAccount = new Savings("John", "123", new Money(10000),'s', 5.0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        _savingsAccount = null;
    }
    
    /**
     * Tests the addInterest method of Savings
     */
    @Test
    public void testAddInterest()
    {
        //Test 1
        _savingsAccount.addInterest();
        Money expectedAmount = new Money (10500);
        //System.out.println(_savingsAccount);
        assertTrue("Error in testAddInterest: Test 1" + _savingsAccount, _savingsAccount.getBalance().equals(expectedAmount));
    }
    
    //dummy test
    // @Test
    // public void testWithdraw()
    // {
        // Savings test = new Savings("Jane Smith", "69713", new Money(4000),'s',135);
        // test.withdraw(new Money(5000));
        // System.out.println(test);
    // }
}
