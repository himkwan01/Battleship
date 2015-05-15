package battleship_gui;

/**
 *
 * @author Jasmine
 */
public class PlayerInfo {

   private int addressID;
   private String firstName;
   private String lastName;
   private String email;
   private String username;
   private String password;

   // constructor
   public PlayerInfo()
   {
   } 

   // constructor
   public PlayerInfo(int addressID, String firstName, String lastName, 
      String email, String username, String password)
   {
      setAddressID(addressID);
      setFirstName(firstName);
      setLastName(lastName);
      setEmail(email);
      setUsername(username);
      setPassword(password);
   } 

   // sets the addressID
   public void setAddressID(int addressID){
      this.addressID = addressID;
   }

   // returns the addressID 
   public int getAddressID(){
      return addressID;
   }
   
   // sets the firstName
   public void setFirstName(String firstName){
      this.firstName = firstName;
   } 

   // returns the first name 
   public String getFirstName(){
      return firstName;
   } 
   
   // sets the lastName
   public void setLastName(String lastName){
      this.lastName = lastName;
   } 

   // returns the last name 
   public String getLastName(){
      return lastName;
   }
   
   // sets the email address
   public void setEmail(String email){
      this.email = email;
   }

   // returns the email address
   public String getEmail(){
      return email;
   }
   
    // sets the username
   public void setUsername(String username){
      this.username = username;
   }

   // returns the username
   public String getUsername(){
      return username;
   } 
   
   // sets the password
   public void setPassword(String password){
      this.password = password;
   }

   // returns the password
   public String getPassword(){
      return password;
   } 
   
} // end class PlayerInfo


