package Project;
import java.util.*;
import Project.*;

/**
 * Admin
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */

public class Admin extends Account{
  
  /**
   * Default constructor
   * @param first the first name of the Admin
   * @param last the last name of the Admin
   * @param username of the Admin
   * @param password the password of the admin
   */
  public Admin(String first, String last, String username, String password)
  {
    super(first,last,username,password,'a','y');
  }
}
