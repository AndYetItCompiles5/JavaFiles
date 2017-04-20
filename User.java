package Project;
import java.util.*;
import Project.*;


/**
 * A class that can add and remove schools from a user's list
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class User extends Account{
  
  /**
   * Constructs a user object who can save schools. Also creates the set of savedSchools
   * 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username, username of the user
   * @param password the password of the user
   */
  public User(String first, String last, String username, String password)
  {
    super(first,last,username,password,'u', 'y');
  }
  
}