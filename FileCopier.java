import java.io.*;

/**
 * Write a description of class sda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileCopier
{
   public static void copyTextFile(String originalFileName,
                                String copyFileName) 
 {
     // ---------------------------------------------------------
    // Makes a duplicate copy of a text file.
    // Precondition: originalFileName is the name of an existing
    // external text file, and copyFileName is the name of the
    // text file to be created.
    // Postcondition: The text file named copyFileName is a
    // duplicate of the file named originalFileName.
    // ---------------------------------------------------------
  BufferedReader ifStream = null;
  PrintWriter ofStream = null; // declare an output file stream
  try {
    // Initialize the input file stream, based on the name of the input file, stored in originalFileName
    //ifStream = new BufferedReader(new FileReader(originalFileName));

    // Initialize the output file stream, based on the name of the output file, stored in copyFileName
    ofStream = new PrintWriter(new FileWriter(copyFileName)); 

    String line;

    // copy lines one at a time from given file to new file
    while ((line = ifStream.readLine()) != null) {
      ofStream.println(line);  // Write a line to the output file.
    } // end while

    //ifStream.close(); // close the files
    ofStream.close();
  } // end try
  catch (IOException e) {
    System.out.println("Error copying file");
  } // end catch
  finally {
    if (ofStream != null) {
           ofStream.close();
    } // end if
    // if (ifStream != null) {
           // try {
              // ifStream.close(); 
           // } // end try
           // catch (IOException e) {
              // System.out.println("Error closing files...");
           // } // end catch
    // } // end if
  } // end finally
} // end copyTextFile
}
