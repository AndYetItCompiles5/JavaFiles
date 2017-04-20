package Project;
import java.util.*;
import Project.*;

/**
 * Gives the admin the ability to add universities to the database and edit any university
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */
public class UniversityController
{
  /**
   * Creates an instance of the Database Library
   */
  private DBController dbController;
  
  /**
   * creates the instance for the database
   */
  public UniversityController()
  {
    dbController = new DBController();
  }
  /**
   * Lets the admin add a university with the given information
   *@param name the name of the University
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
   * @return an string indicating the number of university records inserted or -1 if school name is NOT unique or if a database error is encountered
   */
  public boolean addUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    return dbController.addUniversity(name,state, location, control, numStudents,
                                perFemale, satVerbal, satMath, expenses, perFA,
                                numApplicants, perAdmitted, perEnrolled, academicScale,
                                socialScale, lifeScale,emphases);
  }
  /**
   * Lets the admin edit the given university
   *@param name the name of the University
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
   * @return a boolean indicating how many fields were change if any
   */
  public boolean editUniversity(String name, String state, String location, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                                int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                                int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    return dbController.editUniversity(name,state,location,control,numStudents,perFemale,satVerbal,satMath,expenses,perFA,numApplicants,perAdmitted,perEnrolled,academicScale,
                                       socialScale,lifeScale,emphases);
  }
  
  /**
   * Displays an array list of university's attributes
   * @param name of a university in the database.
   * @return an array list of a given university's attributes
   */
  public ArrayList<String> displayUniversity(String name){
   return dbController.displayUniversity(name);
  }
}