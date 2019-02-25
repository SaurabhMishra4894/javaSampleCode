
package carpurchaseassignment.util;

/**
 *
 * @author saurabh.mishra@jungleworks.com
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public final class Validate{
    private static Scanner scanner ;
    
    public Validate(){
        scanner = new Scanner(System.in).useDelimiter("\\n");
    }
    
/**
 * This method used to check input id is of int type or not
 * in this method input is checked before reading and then out put is given based on that
 * 
 * {@link Scanner} for Scanning the input from the user
 * 
 * @return int type is returned which will be a valid int value
 * 
 */
    
    public int readValidatedInt(){
        int number;
        do {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number.Please try again!");
            scanner.next();
        }
        number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }
    
/**
 * This method used to check input if the input String is correct or not
 * in this method isValidString(final String name) is called which will
 * match the input to the regex pattern to check if string is valid
 * 
 * {@link Scanner} used for scanning users input
 * 
 * @return String type provide valid String pattern
 * 
 */
    public String readValidatedString(){
        String validString ;
        validString = scanner.next();
        if(isValidString(validString)){
            return validString;
        }
        else{
            System.out.println("String is not valid. Please try again !!");
            return readValidatedString();
        }
    }
/**
 * 
 * This method used to check input name is of character type or not
 * in this regex define language of valid input ^\\pL+[\\pL\\pZ\\pP]{0,}
 * 
 * {@link Pattern} for generating pattern for given language
 * {@link Matcher} used for matching input name and pattern generated
 * 
 * @param name String type to check is the valid or not
 * @return boolean type provide results in [true , false] for input name
 * 
 */
    public static boolean isValidString(final String name) {
		String regex="^\\pL+[\\pL\\pZ\\pP]{0,}";
		final Pattern pattern = Pattern.compile(regex);;
		
		Matcher matcher = pattern.matcher(name);
		
		return matcher.matches();
	}
}
