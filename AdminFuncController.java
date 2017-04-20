package Project;
import java.util.*;
import Project.*;

/**
 * AdminFuncController
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class AdminFuncController {
  /**
   * instance of DBController
   */
  private DBController dbController;
  /**
   * instance of UniversityController
   */
  private UniversityController uController;
  /**
   * instance of AccountController
   */
  private AccountController aController;
  
  /**
   * creates the instance of each controller
   */
  public AdminFuncController(){
    dbController = new DBController();
    aController = new AccountController();
    uController = new UniversityController();
  }
  
  /**
   * Creates an account 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of the user
   * @param password for the account
   * @param type the type of user
   * @return Whether the account was successfully created, an error if not
   */
	  public String addAccount(String first, String last, String username, String password, char type)
	  {
	  return dbController.addAccount(first,last,username,password,type);
	  }
  
  /**
   * Edits the University
   * 
   * @param name the name of the University
   * @param state the state the University is located int
   * @param location can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
   * @param control can be one of the following: PRIVATE, STATE, CITY, or -1 if unknown
   * @param numStudents number of students enrolled in the University
   * @param perFemale percentage of enrolled students that are females (between 0 and 100)
   * @param satVerbal average SAT verbal score for enrolled students(between 0 and 800)
   * @param satMath average SAT math score for enrolled students(between 0 and 800)
   * @param expenses annual expenses or tuition to attend the school
   * @param perFA percentage of enrolled students receiving financial aid
   * @param numApplicants total number of applicants that apply to the school anually
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   * 
   * @return Whether the university was successfully edited, error if not successful
   */
  public boolean editUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases){
    return uController.editUniversity(name,state,location,control,numStudents,perFemale,satVerbal,satMath,
                                      expenses,perFA,numApplicants,perAdmitted,perEnrolled,academicScale,
                                      socialScale,lifeScale,emphases);
  }
  
  /**
   * The admin can view a list Users
   * 
   * @return a 2-d array of of strings from the database
   */
  public String[][] viewUsers(){
   return dbController.getAllUsers();
  }
  
  /**
   * Displays the info of the account 
   * 
   * @param username the username of the account we need information from
   * 
   * @throws IllegalArgumentException if the username does not exist
   * @return an ArrayList of all the account details
   */
  public ArrayList<String> displayInfo(String username)
  {
	  if(dbController.isUsernameTaken(username)){
		  Account account = dbController.getAccount(username);
    
		  ArrayList<String> accountInfo = new ArrayList<String>();
    
		  accountInfo.add(account.getFirstName());
		  accountInfo.add(account.getLastName());
		  accountInfo.add(account.getUsername());
		  accountInfo.add(account.getPassword());
		  accountInfo.add(account.getType() + "");
		  accountInfo.add(account.getStatus() + "");
    
		  return accountInfo;
	  }
	  else{
		  throw new IllegalArgumentException("Username does not exist");
	  }
  }
  
  /**
   * An Admin can edit an account.
   * 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of the user
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status true if active, false if deactivated
   * 
   * @return whether the account was successfully edited, error if not
   */
  public boolean editAccount(String first, String last, String username, String password, char type, char status){
    return aController.editAccount(first,last,username,password,type,status);
  }
  
  
  /**
   * shows a list of Universities
   * 
   * @return a list of Universities
   */
  public ArrayList<String> viewUniversities(){
    return dbController.getAllUniversities();
    
  }
}
