


/**
 * Blueprint for Money objects...
 *
 * @author (Ryan Deisler & Akmal Muminov)
 * @version (2/20/18)
 */
public class Money
{
    // instance variables - replace the example below with your own
    //private int dollars, cents;
    private long totalCents;
    /**
     * Constructor for objects of class Money: initialize all attributes
     * 
     * @param an int theDollars, the number of dollars
     * @param an int theCents, the number of cents
     */
    public Money(int theDollars, int theCents)
    {
        // initialise instance variables
        //this.dollars=theDollars;
        //this.cents=theCents;
        this.totalCents = theDollars * 100L + theCents;
    }
    
    /**
     * Constructor for objects of class Money: initialize all attributes
     * 
     * @param a long theCents, the total number of cents
     */
    public Money (long theCents)
    {
        this.totalCents = theCents;
    }

    /**
     * getDollars: return the number of dollars
     * 
     * Precondition: This money object is valid
     * Postcondition: The int returned is the number of dollars of this Money
     * 
     * @return an int, the number of dollars
     */
    public int getDollars()
    {
        //return this.dollars;
        return (int) (this.totalCents / 100);
    }
    
    /**
     * getCents: return the number of cents
     * 
     * Precondition: This money object is valid
     * Postcondition: The int returned is the number of cents of this Money
     * 
     * @return an int, the number of cents
     */
    public int getCents()
    {
        int realCents;
        
        realCents = (int) (this.totalCents % 100);

        return realCents;
    }
    
    /**
     * toString
     * @return a String representation of this object
     * Precondition: this Money object is valid
     * Postcondition: String object is returned that can be printed
     */
    public String toString()
    {
      String result;
      result = "$" + this.getDollars() + ".";
              if (this.getCents() < 10)
        {
            result += "0";
        }
      result+=this.getCents();
      
      if(this.totalCents < 0 && this.totalCents >= -100)
      {
          result = "-$0." + this.getCents() *-1;
      }
            else if(this.totalCents < 0)
      {
          result = "-$" + this.getDollars() *-1 + "." + this.getCents() *-1;
      }
      

        
      // result= "$" + this.dollars + ".";
      
      // if (this.cents < 10)
      // {
          // result+="0"+this.cents;
      // }
      // else
      // {
          // result+=this.cents;
      // }

      return result;
    }
    
    /**
     * equals: determines if two money objects are equal
     * 
     * @return a boolean, true if calling object is the same as parameter object
     * @param Money object, other
     * 
     * Precondition: Both Money objects are valid
     * Postcondition: A boolean is returned
     */
    public boolean equals (Money other)
    {
        return (this.totalCents == other.totalCents);
    }
    
    /**
     * add: adds two Money objects 
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is added to theMoney;
     * The Money returned is the sum of the two Moneys
     * Neither the calling object nor the parameter are changed.
     * 
     * @param a Money, the Money amount to add to the calling object (this)
     * @return a Money, the sum of the two money objects
     */
    public Money add(Money theMoney)
    {
        //Money result;
        
        // int newDollars = this.dollars + theMoney.dollars;
        // int newCents = this.cents + theMoney.cents;
        //long newTotalCents = this.totalCents + theMoney.totalCents;
       
        //result = new Money (this.totalCents + theMoney.totalCents);
        
        return new Money (this.totalCents + theMoney.totalCents);
        
    }
    
    /**
     * subtract: adds two Money objects 
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in theMoney object is subtracted from this Money;
     * The Money returned is the difference of the two Moneys
     * Neither the calling object nor the parameter are changed.
     * 
     * @param a Money, the Money amount to subtract from the calling object (this)
     * @return a Money, the difference of the two money objects
     */
    public Money subtract(Money theMoney)
    {
        return new Money (this.totalCents - theMoney.totalCents);
    }
    
    /**
     * compareTo: compares two Money objects 
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the int returned represents if this Money is equal to,
     * greater than, or less than theMoney object
     * 0 means equal, 1 means this Money > theMoney, -1 means this Money < theMoney
     * 
     * @param a Money, theMoney
     * @return an int, result
     */
    public int compareTo(Money theMoney)
    {
        int result=2;
        
        if(this.totalCents == theMoney.totalCents)
        {
            result = 0;
        }
        else if(this.totalCents > theMoney.totalCents)
        {
            result = 1;
        }
        else if(this.totalCents < theMoney.totalCents)
        {
            result = -1;
        }
        
        return result;
    }
    
    /**
     * getTotalCents: what it sounds like
     */
    public long getTotalCents()
    {
        return this.totalCents;
    }
}
