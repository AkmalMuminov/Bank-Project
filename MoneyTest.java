

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MoneyTest.
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (2/20/18)
 */
public class MoneyTest
{
    // ClassBeingTested example = new ClassBeingTested(3, "hello");
    private Money _amount;

    /**
     * Default constructor for test class MoneyTest
     */
    public MoneyTest()
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
        _amount = new Money(00);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */                     
    @After                          
    public void tearDown()
    {      
        _amount=null;
    }

    /**
     * A sample test method.
     */
    @Test
    public void testCreate ()
    {
        assertEquals ("Error in testCreate", 0, _amount.getDollars());
        assertEquals ("Error in testCreate", 0, _amount.getCents());
        
        Money amount2 = new Money(4,50);
        assertEquals ("Error in testCreate", 4, amount2.getDollars());
        assertEquals ("Error in testCreate", 50, amount2.getCents());
        
        
        assertEquals ("Error in testCreate", 0, _amount.getDollars());
        assertEquals ("Error in testCreate", 0, _amount.getCents());
    }
    
    @Test
    public void testToString()
    {
        //First test: cents is two digits
        Money amount = new Money (755);
        String actual= amount.toString();
        String expected = "$7.55";
        assertTrue ("Error in cents is two digits",actual.equals(expected));
        System.out.println(actual);
        
        //Second test: cents is one digit
        Money amount2 = new Money (705);
        String actual2 = amount2.toString();
        String expected2 = "$7.05";
        assertTrue ("Error in cents is one digit",actual2.equals(expected2));
        System.out.println(actual2);
    }
    
    //Test equality of money values that are the same.
    @Test
    public void testEquality()
    {
        Money myCash = new Money (3,75);
        Money yourCash = new Money (3,75);
        
        assertTrue ("Error in testEquality", myCash.equals(yourCash));
    }
    
    @Test
    public void testInequality()
    {
        Money myCash = new Money (3,75);
        Money difftDollarsSameCents = new Money (4,75);
        Money difftDollarsDifftCents = new Money (4,80);
        Money sameDollarsDifftCents = new Money (3,80);
        assertFalse ("Error in testInequality", myCash.equals(difftDollarsSameCents));
        assertFalse ("Error in testInequality", myCash.equals(difftDollarsDifftCents));
        assertFalse ("Error in testInequality", myCash.equals(sameDollarsDifftCents));
    }
    
    @Test
    public void testSimpleAdd()
    {
        Money amount2 = new Money (2,30);
        Money amount3 = new Money (3,50);
        
        Money actualAmount = amount2.add(amount3);
        // actualAmount now has the sum of amount2 + amount3
        
        //Expected result is $5.80
        Money expectedAmount = new Money (5,80);
        
        assertTrue ("Error in testSimpleAdd", actualAmount.equals(expectedAmount));
        
    }
    
    //Test the complex addition of two money values, i.e. sum of cents is greater than or equal to 100
    @Test
    public void testComplexAdd()
    {
        //First test: sum of cents is 100
        
        Money myCash = new Money (350);
        Money yourCash = new Money (450);
        
        //Expected result is $8.00
        Money expectedAmount = new Money (800);
        
        Money actualAmount = myCash.add(yourCash);
        
        System.out.println(actualAmount.toString()); //just for tracing purposes
        
        assertTrue("Error in testComplexAdd", actualAmount.equals(expectedAmount));
        
        //Second test: sum of cents is over 100
        Money myCash2 = new Money (350);
        Money yourCash2 = new Money (460);
        
        //Expected result is $8.10
        Money expectedAmount2 = new Money (810);
        
        Money actualAmount2 = myCash2.add(yourCash2);
        assertTrue("Error in testComplexAdd Test2", actualAmount2.equals(expectedAmount2));
    }
    
    //Test the simple subtraction of two money values, i.e. the amount will not be negative
    @Test
    public void testSimpleSubtract()
    {
        //First test: same dollar amount
        Money myCash = new Money (450);
        Money yourCash = new Money (430);
        
        //Expected result is $0.20
        Money expectedAmount = new Money (20);
        
        Money actualAmount = myCash.subtract(yourCash);
        assertTrue("Error in testSimpleSubtract", actualAmount.equals(expectedAmount));
        
        //Second test: different dollar amount
        Money myCash2 = new Money (450);
        Money yourCash2 = new Money (350);
        
        //Expected result is $1.00
        Money expectedAmount2 = new Money (100);
        
        Money actualAmount2 = myCash2.subtract(yourCash2);
        assertTrue("Error in testSimpleSubtract", actualAmount.equals(expectedAmount));
    }
    
    //Test the complex subraction of two money values, i.e. the amount will be negative
    @Test
    public void testComplexSubtract()
    {
        //First test: money yielded will be negative, but cents doesn't change
        Money myCash = new Money (200);
        Money yourCash = new Money (400);
        
        //Expected result is -$2.00
        Money expectedAmount = new Money (-200);
        
        Money actualAmount = myCash.subtract(yourCash);
        assertTrue("Error in testComplexSubtract Test1", actualAmount.equals(expectedAmount));
        
        //Second test: dollars change, greater than -$1.00: 
        Money myCash2 = new Money (250);
        Money yourCash2 = new Money (300);
        
        //Expected result is -$0.50
        Money expectedAmount2 = new Money (-50);
        
        Money actualAmount2 = myCash2.subtract(yourCash2);
        assertTrue("Error in testComplexSubtract Test2", actualAmount2.equals(expectedAmount2));
        
        //Third test: cents and dollars change, less than -$1.00:
        Money myCash3 = new Money (250);
        Money yourCash3 = new Money (430);
        
        //Expected result is -$1.80
        Money expectedAmount3 = new Money (-180);
        
        Money actualAmount3 = myCash3.subtract(yourCash3);
        assertTrue("Error in testComplexSubtract Test3", actualAmount3.equals(expectedAmount3));
    }
    
    //Test the comparison of two money values, if the object invoking the compareTo method is equal to the parameter method returns 0, bigger than parameter returns 1, less than parameter returns -1
    @Test
    public void testCompareTo()
    {
        //First test: money objects are the same
        Money myCash = new Money (200);
        Money yourCash = new Money (200);
        
        //Expected result is 0
        int expectedInt = 0;
        
        int actualInt = myCash.compareTo(yourCash);
        assertTrue("Error in testCompareTo Test1", expectedInt == actualInt);
        
        //Second test: invoking object is greater than the parameter
        Money myCash2 = new Money (202);
        Money yourCash2 = new Money (200);
        
        //Expected result is 1
        int expectedInt2 = 1;
        
        int actualInt2 = myCash2.compareTo(yourCash2);
        assertTrue("Error in testCompareTo Test2", expectedInt2 == actualInt2);
        
        //Third test: invoking object is less than the parameter
        Money myCash3 = new Money(199);
        Money yourCash3 = new Money(200);
        
        //Expected result is -1
        int expectedInt3 = -1;
        
        int actualInt3 = myCash3.compareTo(yourCash3);
        assertTrue("Error in testCompareTo Test3", expectedInt3 == actualInt3);
    }
}
