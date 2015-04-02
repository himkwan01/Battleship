/*
 * Author: jdecker
 */
package regexcheck;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegExCheck {
    
    //First name regular expression pattern.
    public static String FNAMEPTRN = "[A-Z][a-zA-Z]*";
    //Last name regular expression pattern.
    public static String LNAMEPTRN = "[A-Z][a-zA-Z]*";
    //Email regular expression pattern.
    public static String EMAILPTRN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //American phone number regular expression pattern.
    //XXX-XXX-XXXX or (XXX) XXX-XXXX. No area code below 200.
    public static String PHONEPTRN = "^(\\([2-9][0-9][0-9]\\) |[2-9][0-9]"
            + "[0-9]-)[0-9]{3}-[0-9]{4}$";

    //Validate first name.
    public static boolean checkFirstName (String firstName){
        return firstName.matches (FNAMEPTRN);
    }
    
    //Validate last name.
    public static boolean checkLastName (String lastName){
        return lastName.matches (LNAMEPTRN);
    }
    
    //Validate email.
    public static boolean checkEmail (String emailAdd){
        return emailAdd.matches (EMAILPTRN);
    }
    
    //Validate American phone number.
    public static boolean checkPhone (String phoneNum){
        return phoneNum.matches (PHONEPTRN);
    }
    
}