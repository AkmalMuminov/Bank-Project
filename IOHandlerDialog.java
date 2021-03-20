import javax.swing.JOptionPane;

/**
 * IOHandlerDialog: uses dialog boxes for input (via get method) and output (via put method).
 * Note: exceptions are potentially thrown by methods of JOptionPane; refer to documentation in Java standard library. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IOHandlerDialog implements IOHandlerInterface
{
    // Attributes
    private JOptionPane panel; // for dialog IO 
    
    /**
     * constructor
     * @param none
     */
    public IOHandlerDialog()
    {
        panel = new JOptionPane();
    }
    
    /**
     * get: 
     * @param a String prompt
     * @return a String that was input by the user from the selected source.
     */
    public String get(String prompt)
    {
	// Source is input dialog box.
        // Show input dialog box and return the input.
        return panel.showInputDialog (prompt);    
    }
    
    /**
     * put: 
     * @param a String to write to the selected destination.
     * @return none.
     */
    public void put(String output)
    {
	    // Destination is output dialog box.
        // Show output dialog box.
        panel.showMessageDialog (null, output);    
    }
}