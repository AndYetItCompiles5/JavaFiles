package Project;
import java.util.*;
import Project.*;

/**
 * AdminUI
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class AdminUI{
  /**
   * Creates an instance of the AdminFucController
   */
  private AdminFuncController aFuncController;
  
  /**
   * Creates an instance of the AccountController
   */
  private AccountController aController;
  
  /**
   * Creates an instance of the UniversityController
   */
  private UniversityController uController;
  
  /** 
   * initialized all of the instances
   */
  public AdminUI(){
    aFuncController = new AdminFuncController();
    aController = new AccountController();
    uController = new UniversityController();
  }
  
  /**
   * view a set of Universities
   * 
   * @return a set of Universities
   */
  public ArrayList<String> viewUniversities(){
    return aFuncController.viewUniversities();
  }
  
  /**
   * An admin can edit Universities
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
   * @return true if the University was added else return false
   */
  public boolean addUniversity(String name, String state, String location, String control, int numStudents,
                              double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                              int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                              int socialScale, int lifeScale, ArrayList<String> emphases){
    
    return uController.addUniversity(name,state, location, control, numStudents,
                                     perFemale, satVerbal, satMath, expenses, perFA,
                                     numApplicants, perAdmitted, perEnrolled, academicScale,
                                     socialScale, lifeScale,emphases);
  }
  
  /**
   * An admin edits the Universities
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
   * @return a string
   */
  public boolean editUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases){
    
    return aFuncController.editUniversity(name,state, location, control, numStudents,
                                          perFemale, satVerbal, satMath, expenses, perFA,
                                          numApplicants, perAdmitted, perEnrolled, academicScale,
                                          socialScale, lifeScale, emphases);
  }
  
  /**
   * View all users
   * @return a string of all users
   */
  public String[][] viewUsers(){
    return aFuncController.viewUsers();
  }
  
  /**
   * Admin can edit an account
   *
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username of the user
   * @param password the password of the user
   * @param type of the account
   * @param status the status of the account
   * 
   * @return boolean if edit was successful
   */
  public boolean editAccount(String first, String last,String username, String password, char type, char status){
    return aFuncController.editAccount(first,last,username,password,type, status); 
  }
  
  /**
   * An admin can deactivate a user
   *
   * @param username of the user
   */

  public boolean deactivateUser(String username)
  {
    return aController.deactivateUser(username);
  }
  
  /**
   * Display the account information
   *
   * @param username of the user
   * 
   * @return an array list of the user's info
   */
  public ArrayList<String> displayInfo(String username)
  {
    return aFuncController.displayInfo(username);
  }
  
  /**
   * An admin can create an account 
   *
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username of the user
   * @param password the password of the user
   * @param type of the account
   * 
   * @return confirmation message if the account was added successfully
   */
  public String addAccount(String first, String last, String username, String password, char type)
  {
    return aFuncController.addAccount(first,last,username,password,type);
  }
  
  /**
   * userNotComplete error
   * 
   * @return an error message
   */
  public String userNotCompleteError(){
    return "something"; 
  }
  
  /**
   * confirmation Messgae
   * 
   * @return a conformation message
   */
  public String confirmationMessage(){
    return "something"; 
  }
  
  /**
   * A confirm change
   * 
   * @return true if change is confirmed else return false
   */
  public String confirmChange(){
    return "Are you sure?"; 
  }
  
  /**
   * An empty field error
   * 
   * @return a error message
   */
  public String emptyFieldError(){
    return "error"; 
  }
  
  /**
   * A account is already deactivated
   * 
   * @return "The account is already deactivated"
   */
  public String alreadyDeactivatedError(){
    return "The account is already deactivated"; 
  }
  
  /**
   * display University's name
   *
   * @param name of the university
   * 
   * @return name the name of the University
   */
  public ArrayList<String> displayUniversity(String name){
    return uController.displayUniversity(name); 
  }
  
  /**
   * No name error. No user with that given name
   * 
   * @return "no name error"
   */
  public String noNameError(){
    return "no name error"; 
  }                                               
}