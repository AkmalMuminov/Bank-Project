
/**
 * IOHandlerInterface: specifies an ADT for handling of input, e.g.
 * I/O can be based on standard input and output, or dialog boxes
 * as implemented in concrete classes IOHandlerStandard and IOHandlerDialog
 * respectively, which implement this interface.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface IOHandlerInterface
{        
    /**
     * get: 
     * @param none
     * @return a String from input source.
     */
    public String get(String prompt);
    
    /**
     * put: 
     * @param a String to write to the selected destination.
     * @return none.
     */
    public void put(String output);
    
} // end IOHandler