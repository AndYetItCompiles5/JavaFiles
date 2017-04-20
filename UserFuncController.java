package Project;
import java.util.*;
import Project.*;

/**
 * A class that runs the options that the user can select
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class UserFuncController{
  
  /**
   * Creates an instance of the Database Library
   */
  private DBController dbController;
  
  /**
   * creates dbcontroller instance
   */
  public UserFuncController(){
   dbController = new DBController();
   
  }
  /**
   * Edits the user with the given information
   * @param username: the user's username
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
   * @param type: the user's type
   * @param status: the user's status
   * @return boolean if the account was successfully edited
   */
  public boolean editUser(String first, String last, String username, String password,char type, char status)
  {
    return dbController.editAccount(first,last,username, password,type,status);
  }
  
  /**
   * Removes a university from the student's saved schools
   * @param user : String
   * @param school : String
   * @return boolean if the school was not removed
   */
  public boolean removeSchool(String user, String school)
  {
    return dbController.removeSchool(user, school); 
  }
  
  /**
   * Saves the selected university to the user's list of universities
   * @param user : String
   * @param school : String
   * @return string if school was saved
   */
  public boolean saveSchool(String user, String school)
  {
    return dbController.saveSchool(user, school); 
  }
  
  public ArrayList<String> getUserSchools(String user){
	  return dbController.getUserSavedSchools(user);
  }

}