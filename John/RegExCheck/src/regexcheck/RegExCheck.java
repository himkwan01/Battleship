/*
 * Author: jdecker
 */
package regexcheck;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegExCheck {
 
	private Pattern fnameptrn;
	private Matcher fnamemtch;
        private Pattern lnameptrn;
	private Matcher lnamemtch;
        private Pattern emailptrn;
	private Matcher emailmtch;
        private Pattern phoneptrn;
	private Matcher phonemtch;

        //Email regular expression.
	private static final String EMAILREGEX = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        //First name regular expression.
        private static final String FNAMEREGEX = 
		"[A-Z][a-zA-Z]*";
        
        //Last name regular expression.
        private static final String LNAMEREGEX = 
		"[A-Z][a-zA-Z]*";
        
        //Phone number regular expression.
        private static final String PHONEREGEX = 
		"^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$";
                //"^(\\([2-9][0-9][0-9]\\) |[2-9][0-9][0-9]-)[0-9]{3}-[0-9]{4}$"
                // would eliminate area codes below 200.
 
	public RegExCheck() {
            emailptrn = Pattern.compile(EMAILREGEX);
            fnameptrn = Pattern.compile(FNAMEREGEX);
            lnameptrn = Pattern.compile(LNAMEREGEX);
            phoneptrn = Pattern.compile(PHONEREGEX);
	}
 
	/**
	 * Validate check with regular expression
	 * 
	 * @param check for validation
         * 
	 * @return Invalid hex returns false
	 */
        
	public boolean validEmail(final String check) {
 
		emailmtch = emailptrn.matcher(check);
		return emailmtch.matches();
 
	}
        
        public boolean validFName(final String check) {
 
		fnamemtch = fnameptrn.matcher(check);
		return fnamemtch.matches();
 
	}
        
        public boolean validLName(final String check) {
 
		lnamemtch = lnameptrn.matcher(check);
		return lnamemtch.matches();
 
	}
        
        public boolean validPhone(final String check) {
 
		phonemtch = phoneptrn.matcher(check);
		return phonemtch.matches();
 
	}
}
