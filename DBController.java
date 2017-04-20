package Project;

import java.util.*;
import dblibrary.project.csci230.UniversityDBLibrary;
import java.lang.*;

/**
 * DB controller
 * 
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class DBController {
  /**
   * Creates an instance of the Database Library
   */
  private UniversityDBLibrary dataBase = new UniversityDBLibrary("andyic", "andyic", "csci230");
  
  /**
   * Returns an account
   * 
   * @param username:the
   *            username of the account that is being found
   * 
   * @return the Account object associated with the username
   */
  public Account getAccount(String username) {
    String first = "";
    String last = "";
    String password = "";
    char type = ' ';
    char status = ' ';
    boolean found = false;
    
    String[][] users = dataBase.user_getUsers();
    for (int i = 0; i < users.length; i++) {
      if (users[i][2].equals(username)) {
        first = users[i][0];
        last = users[i][1];
        password = users[i][3];
        type = users[i][4].charAt(0);
        status = users[i][5].charAt(0);
        found = true;
      }
    }
    if (found == false) {
      throw new IllegalArgumentException("The name you have entered was not found.");
    }
    
    Account account = new Account(first, last, username, password, type, status);
    
    return account;
  }
  
  /**
   * Finds a university that matches the given name
   * 
   * @param name:the
   *            school name that is being found
   * @return a university object
   */
  public University getUniversity(String name) {
    boolean found = false;
    
    String state = "";
    String location = "-1";
    String control = "-1";
    int numStudents = 0;
    double perFemale = 0;
    int satVerbal = 0;
    int satMath = 0;
    int expenses = 0;
    double perFA = 0;
    int numApplicants = 0;
    double perAdmitted = 0;
    double perEnrolled = 0;
    int academicScale = 0;
    int socialScale = 0;
    int lifeScale = 0;
    ArrayList<String> emp = new ArrayList<String>();
    
    String[][] universities = dataBase.university_getUniversities();
    
    for (int i = 0; i < universities.length; i++) {
      if (universities[i][0].equals(name)) {
        found = true;
        state = universities[i][1];
        location = universities[i][2];
        control = universities[i][3];
        numStudents = Integer.parseInt(universities[i][4]);
        perFemale = Double.parseDouble(universities[i][5]);
        satVerbal = Integer.parseInt(universities[i][6]);
        satMath = Integer.parseInt(universities[i][7]);
        expenses = Integer.parseInt(universities[i][8]);
        perFA = Double.parseDouble(universities[i][9]);
        numApplicants = Integer.parseInt(universities[i][10]);
        perAdmitted = Double.parseDouble(universities[i][11]);
        perEnrolled = Double.parseDouble(universities[i][12]);
        academicScale = Integer.parseInt(universities[i][13]);
        socialScale = Integer.parseInt(universities[i][14]);
        lifeScale = Integer.parseInt(universities[i][15]);
      }
    }
    
    if (!found)
      throw new IllegalArgumentException("There is no University by the name of " + name);
    
    University university = new University(name, state, location, control, numStudents, perFemale, satVerbal,
                                           satMath, expenses, perFA, numApplicants, perAdmitted, perEnrolled, academicScale, socialScale,
                                           lifeScale, emp);
    return university;
  }
  
  /**
   * Displays a single university
   * 
   * @param name:the
   *            school name that is being displayed
   * @return an array list of the school's information
   */
  
  public ArrayList<String> displayUniversity(String name) {
    
    String[][] allUniversities = dataBase.university_getUniversities();
    
    boolean found = false;
    
    for (int x = 0; x < allUniversities.length; x++) {
      if (allUniversities[x][0].equals(name)) {
        found = true;
      }
    }
    
    if (!found)
      throw new IllegalArgumentException("There is no University by the name of " + name);
    
    ArrayList<String> univs = new ArrayList<String>();
    University univ = getUniversity(name);
    String state = univ.getState();
    String loc = univ.getLocation();
    String control = univ.getControl();
    int numStudents = univ.getNumStudents();
    double perFemale = univ.getPercentFemale();
    int satVerbal = univ.getSatVerbal();
    int satMath = univ.getSatMath();
    int expenses = univ.getExpenses();
    double perFA = univ.getFinancialAid();
    int numApplicants = univ.getNumApplicants();
    double perAdmitted = univ.getPercentAdmitted();
    double perEnrolled = univ.getPercentEnrolled();
    int academicScale = univ.getAcademicScale();
    int socialScale = univ.getSocialScale();
    int lifeScale = univ.getLifeScale();
    String[][] emphases = dataBase.university_getNamesWithEmphases();
    univs.add(name);
    univs.add(state);
    univs.add(loc);
    univs.add(control);
    univs.add(Integer.toString(numStudents));
    univs.add(Double.toString(perFemale));
    univs.add(Integer.toString(satVerbal));
    univs.add(Integer.toString(satMath));
    univs.add(Integer.toString(expenses));
    univs.add(Double.toString(perFA));
    univs.add(Integer.toString(numApplicants));
    univs.add(Double.toString(perAdmitted));
    univs.add(Double.toString(perEnrolled));
    univs.add(Integer.toString(academicScale));
    univs.add(Integer.toString(socialScale));
    univs.add(Integer.toString(lifeScale));
    for (int i = 0; i < emphases.length; i++) {
      if (emphases[i][0].equals(name)) {
        univs.add(emphases[i][1]);
      }
      
    }
    return univs;
  }
  
  /**
   * Edits a given university with the specified parameters unless they are
   * null/0
   * 
   * @param name
   *            the name of the University
   * @param state
   *            the state the University is located int
   * @param location
   *            can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or
   *            -1 if unknown
   * @param control
   *            can be one of the following: PRIVATE, STATE, CITY, or -1 if
   *            unknown
   * @param numStudents
   *            number of students enrolled in the University
   * @param perFemale
   *            percentage of enrolled students that are females (between 0
   *            and 100)
   * @param satVerbal
   *            average SAT verbal score for enrolled students(between 0 and
   *            800)
   * @param satMath
   *            average SAT math score for enrolled students(between 0 and
   *            800)
   * @param expenses
   *            annual expenses or tuition to attend the school
   * @param perFA
   *            percentage of enrolled students receiving financial aid
   * @param numApplicants
   *            total number of applicants that apply to the school annually
   * @param perAdmitted
   *            percent of applicants that get admitted
   * @param perEnrolled
   *            percent of applicants that decide to enroll
   * @param academicScale
   *            integer between 1 and 5 indicating the academic scale of the
   *            University
   * @param socialScale
   *            integer between 1 and 5 indicating the quality of social life
   *            at the University
   * @param lifeScale
   *            integer between 1 and 5 indicating the quality of life at the
   *            University
   * @param emphases
   *            up to five areas of study the University excels at (all
   *            Strings)
   * @throws IllegalArgumentException
   *             if the university was not found
   * @return a success message
   */
  public boolean editUniversity(String name, String state, String location, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA, int numApplicants,
                                double perAdmitted, double perEnrolled, int academicScale, int socialScale, int lifeScale,
                                ArrayList<String> emphases) {
    
    String[][] universities = dataBase.university_getUniversities();
    
    University testSchool = new University(name, state, location, control, numStudents, perFemale, satVerbal,
                                           satMath, expenses, perFA, numApplicants, perAdmitted, perEnrolled, academicScale, socialScale,
                                           lifeScale, emphases);
    for (int i = 0; i < universities.length; i++) {
      if (universities[i][0].equals(name)) {
        
        dataBase.university_editUniversity(name, state, location, control, numStudents, perFemale, satVerbal,
                                           satMath, expenses, perFA, numApplicants, perAdmitted, perEnrolled, academicScale, socialScale,
                                           lifeScale);
        return true;
      }
    }
    //throw new IllegalArgumentException("University was not found");
    return false;
  }
  
  /**
   * Method to add a a new University object to the database
   * 
   * @param name
   *            the name of the University
   * @param state
   *            the state the University is located int
   * @param location
   *            can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or
   *            -1 if unknown
   * @param control
   *            can be one of the following: PRIVATE, STATE, CITY, or -1 if
   *            unknown
   * @param numStudents
   *            number of students enrolled in the University
   * @param perFemale
   *            percentage of enrolled students that are females (between 0
   *            and 100)
   * @param satVerbal
   *            average SAT verbal score for enrolled students(between 0 and
   *            800)
   * @param satMath
   *            average SAT math score for enrolled students(between 0 and
   *            800)
   * @param expenses
   *            annual expenses or tuition to attend the school
   * @param perFA
   *            percentage of enrolled students receiving financial aid
   * @param numApplicants
   *            total number of applicants that apply to the school annually
   * @param perAdmitted
   *            percent of applicants that get admitted
   * @param perEnrolled
   *            percent of applicants that decide to enroll
   * @param academicScale
   *            integer between 1 and 5 indicating the academic scale of the
   *            University
   * @param socialScale
   *            integer between 1 and 5 indicating the quality of social life
   *            at the University
   * @param lifeScale
   *            integer between 1 and 5 indicating the quality of life at the
   *            University
   * @param emphases
   *            up to five areas of study the University excels at (all
   *            Strings)
   * @throw new IllegalArgumentException if the school name is empty or the
   *        school is already saved
   * @return success message if the school has been added successfully
   */
  public boolean addUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA, int numApplicants,
                               double perAdmitted, double perEnrolled, int academicScale, int socialScale, int lifeScale,
                               ArrayList<String> emphases) {
    
    University u = new University(name, state, location, control, numStudents, perFemale, satVerbal, satMath,
                                  expenses, perFA, numApplicants, perAdmitted, perEnrolled, academicScale, socialScale, lifeScale,
                                  emphases);
    if (name.equals("") || name == null) {
      throw new IllegalArgumentException("Name is required");
    } else if (isSchoolSaved(name)) {
      throw new IllegalArgumentException("School is already saved");
    } else {
      dataBase.university_addUniversity(name, state, location, control, numStudents, perFemale, satVerbal,
                                        satMath, expenses, perFA, numApplicants, perAdmitted, perEnrolled, academicScale, socialScale,
                                        lifeScale);
      if (emphases != null) {
        for (int i = 0; i < emphases.size(); i++) {
          dataBase.university_addUniversityEmphasis(name, emphases.get(i));
          
        }
        
      }
      return true;
    }
  }
  
  /**
   * Saves a school to the user's list of saved schools
   * 
   * @param user:the
   *            username of the user where the school is being added to
   * @param school:
   *            the school name of the school being added
   * @throws IllegalArgumentException
   *             if an error occurs
   * @return a boolean if the school saved
   */
  public boolean saveSchool(String user, String school) {
    int r = dataBase.user_saveSchool(user, school);
    
    if (r == -1) {
      throw new IllegalArgumentException("There was an error");
    }
    
    return true;
  }
  
  /**
   * This methods gets the user's saved schools from the DB
   * 
   * @param user:the
   *            username of the user where the saved schools are being
   *            obtained from
   * @throws IllegalArgumentException
   *             if user has no saved schools
   * @return an array of the user's saved schools
   */
  public ArrayList<String> getUserSavedSchools(String user) {
    ArrayList<String> listSchools = new ArrayList<String>();
    String[][] namesWithSchools = dataBase.user_getUsernamesWithSavedSchools();
    boolean added = false;
    if(isDeactivated(user)){
    	throw new IllegalArgumentException("The user is deactivated");
    }
    if (namesWithSchools == null) {
      return listSchools;
    }
    for (int i = 0; i < namesWithSchools.length; i++) {
      if (namesWithSchools[i][0].equals(user)) {
        listSchools.add(namesWithSchools[i][1]);
        added = true;
      }
    }
    if (added == false) {
      throw new IllegalArgumentException("The user: " + user + " does not have any saved schools");
    }
    return listSchools;
  }
  
  /**
   * Returns a Set of all the University objects in the database
   * 
   * @return a Set of all the University objects in the database
   */
  public ArrayList<String> getAllUniversities() {
    String[][] universities = dataBase.university_getUniversities();
    ArrayList<String> result = new ArrayList<String>();
    String name;
    for (int i = 0; i < universities.length; i++) {
      name = universities[i][0];
      result.add(name);
    }
    
    return result;
  }
  
  /**
   * Returns an ArrayList of University objects of all universities in the
   * database
   * 
   * @return an ArrayList of all universities
   */
  public ArrayList<University> getUniversityObjects() {
    String[][] universities = dataBase.university_getUniversities();
    String[][] emphasesList = dataBase.university_getNamesWithEmphases();
    ArrayList<University> result = new ArrayList<University>();
    
    for (int i = 0; i < universities.length; i++) {
    	 ArrayList<String> emphases = new ArrayList<String>();
    	String name;
    	String state;
        String location;
        String control;
        int numStudents;
        double perFemale;
        int satVerbal;
        int satMath;
        int expenses;
        double perFA;
        int numApplicants;
        double perAdmitted;
        double perEnrolled;
        int academicScale;
        int socialScale;
        int lifeScale;
      name = universities[i][0];
      state = universities[i][1];
      location = universities[i][2];
      control = universities[i][3];
      numStudents = Integer.parseInt(universities[i][4]);
      perFemale = Double.parseDouble(universities[i][5]);
      satVerbal = Integer.parseInt(universities[i][6]);
      satMath = Integer.parseInt(universities[i][7]);
      expenses = Integer.parseInt(universities[i][8]);
      perFA = Double.parseDouble(universities[i][9]);
      numApplicants = Integer.parseInt(universities[i][10]);
      perAdmitted = Double.parseDouble(universities[i][11]);
      perEnrolled = Double.parseDouble(universities[i][12]);
      academicScale = Integer.parseInt(universities[i][13]);
      socialScale = Integer.parseInt(universities[i][14]);
      lifeScale = Integer.parseInt(universities[i][15]);
      for (int j = 0; j < emphasesList.length; j++) {
        if (emphasesList[j][0].equals(name)) {
          emphases.add(emphasesList[j][1]);
        }
      }
      University u = new University(name, state, location, control, numStudents, perFemale, satVerbal, satMath,
                                    expenses, perFA, numApplicants, perAdmitted, perEnrolled, academicScale, socialScale, lifeScale,
                                    emphases);
      result.add(u);
    }
    return result;
  }
  
  /**
   * Returns a Set of all the University objects that mat System.out.println(
   * "Should return 'User deactivated' error: "+loginUI.Login("calaseth",
   * "password")); System.out.println(
   * "Should return 'Wrong login info' error: "+loginUI.Login("wrong",
   * "info"));ch the search criteria in the database
   * 
   * @param name
   *            the name of the University
   * @param state
   *            the state the University is located int
   * @param location
   *            can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or
   *            -1 if unknown
   * @param control
   *            can be one of the following: PRIVATE, STATE, CITY, or -1 if
   *            unknown
   * @param numStudentsLow
   *            user search input of minimum number of students
   * @param numStudentsHigh
   *            user search input of maximum number of students
   * @param perFemaleLow
   *            user search input of minimum female percentage
   * @param perFemaleHigh
   *            user search input of maximum female percentage
   * @param satVerbalLow
   *            user search input of minimum SAT Verbal score
   * @param satVerbalHigh
   *            user search input of maximum SAT Verbal score
   * @param satMathLow
   *            user search input of minimum SAT Math score
   * @param satMathHigh
   *            user search input of minimum SAT Math score
   * @param expensesLow
   *            user search input of minimum expenses
   * @param expensesHigh
   *            user search input of maximum expenses
   * @param perFALow
   *            user search input of minimum Financial Aid percentage
   * @param perFAHigh
   *            user search input of maximum Financial Aid percentage
   * @param numApplicantsLow
   *            user search input of minimum number of applicants
   * @param numApplicantsHigh
   *            user search input of maximum number of applicants
   * @param perAdmittedLow
   *            user search input of minimum number of admitted
   * @param perAdmittedHigh
   *            user search input of maximum number of admitted
   * @param perEnrolledLow
   *            user search input of minimum number of enrolled
   * @param perEnrolledHigh
   *            user search input of maximum number of enrolled
   * @param academicScaleLow
   *            user search input of minimum academic scale number
   * @param academicScaleHigh
   *            user search input of maximum academic scale number
   * @param socialScaleLow
   *            user search input of minimum social scale number
   * @param socialScaleHigh
   *            user search input of maximimum social scale number
   * @param lifeScaleLow
   *            user search input of minimum life scale number
   * @param lifeScaleHigh
   *            user search input of maximum life scale number
   * @param emphases
   *            up to five areas of study the Univer System.out.println(
   *            "Should return 'User deactivated' error: "
   *            +loginUI.Login("calaseth", "password")); System.out.println(
   *            "Should return 'Wrong login info' error: "
   *            +loginUI.Login("wrong", "info"));sity excels at (all Strings)
   * @return a hashset of the found schools
   */
  
  /**
   * Removes the specified school from the user's list
   * 
   * @param user:
   *            the username of the user where the school is being deleted
   *            from
   * @param school:
   *            the school name that is being removed
   * @throws IllegalArgumentException
   *             if the user does not exist
   * @return an integer
   * 
   */
  public boolean removeSchool(String user, String school) {
    String[][] temp = dataBase.user_getUsers();
    for (int i = 0; i < temp.length; i++) {
      if (temp[i][2].equals(user)) {
        dataBase.user_removeSchool(user, school);
        return true;
      }
    }
    throw new IllegalArgumentException("Invalid Username");
  }
  
  /**
   * Finds whether or not the schools has been saved
   * 
   * @param name
   *            the university name that is being saved
   * @return true if the school has already been saved
   */
  public boolean isSchoolSaved(String name) {
    String[][] universityList = dataBase.university_getUniversities();
    for (int i = 0; i < universityList.length; i++) {
      if (universityList[i][0].equals(name)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Returns an ArrayList of all the users(admin and regular users) in the
   * database
   * 
   * @return a set of all the users in the database
   */
  public String[][] getAllUsers() {
    String[][] users = dataBase.user_getUsers();
    
    return users;
  }
  
  /**
   * Add an account to the database
   * 
   * @param first:the
   *            first name of the user being added
   * @param last:
   *            the last name of the user being added
   * @param username:
   *            the username of the user being added
   * @param password:
   *            the password of the user being added
   * @param type:
   *            boolean of the user's activation or deactivation
   * @throws IllegalArgumentException
   *             if username is taken or password or username is empty
   * @return confirmation message if successfully added to the database
   */
  public String addAccount(String first, String last, String username, String password, char type) {
    boolean taken = isUsernameTaken(username);
    if (username.equals("") || password.equals("")) {
      throw new IllegalArgumentException("Username or password cannot be empty");
    } else if (!taken) {
      dataBase.user_addUser(first, last, username, password, type);
      return "Addition Successful!";
    } else {
      throw new IllegalArgumentException("Username is taken");
    }
  }
  
  /**
   * Checks whether or not the username has been taken
   * 
   * @param username
   *            the username we want to check if it currently exists
   * @return true if the username is already taken
   */
  public boolean isUsernameTaken(String username) {
    String[][] userList = dataBase.user_getUsers();
    for (int i = 0; i < userList.length; i++) {
      if (userList[i][2].equals(username)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Method to edit an existing user
   * 
   * @param first:
   *            the first name of the user
   * @param last:
   *            the last name of the user
   * @param username:
   *            the username of the user
   * @param password
   *            the password of the user
   * @param type:
   *            U for user, A for admin
   * @param status:
   *            Y if active, N if deactive
   * @throws Illegal
   *             Argument Exception if an erro occurs
   * @return true if the user was successfully edited
   */
  public boolean editAccount(String first, String last, String username, String password, char type, char status) {
    
    if (username.equals("") || password.equals("") || type == (' ') || status == (' ')) {
      throw new IllegalArgumentException("Username, password, type and status are required.");
    }
    if (status == 'Y' || status == 'y' || status == 'N' || status == 'n') {
      if (type == 'A' || type == 'a' || type == 'U' || type == 'u') {
        dataBase.user_editUser(username, first, last, password, type, status);
        return true;
      } else {
        throw new IllegalArgumentException("Type cannot be " + type);
      }
    } else {
      throw new IllegalArgumentException("Status cannot be " + status);
    }
  }
  
  /**
   * Checks to see if an Account is deactivated
   * 
   * @param username:
   *            the username of the user that the admin is checking
   * @return true if account is deactivated
   */
  public boolean isDeactivated(String username) {
    String[][] userList = dataBase.user_getUsers();
    for (int i = 0; i < userList.length; i++) {
      if (userList[i][2].equals(username)) {
        if (userList[i][5].equals("N") || userList[i][5].equals("n")) {
          return true;
        }
      }
    }
    return false;
    
  }
  
  /**
   * Deactivates a given Account
   * 
   * @param username:
   *            the username of the user
   * 
   * @throws IllegalArgumentException
   *             if account is deactivated
   * 
   * @return confirmation message if the user was deactivated or not
   */
  public boolean deactivateUser(String username) {
    if (!isUsernameTaken(username)) {
      throw new IllegalArgumentException("The name you have entered was not found.");
    } else if (isDeactivated(username)) {
      throw new IllegalArgumentException("Account is deactivated");
    }
    
    else {
      Account account = getAccount(username);
      
      String first = account.getFirstName();
      String last = account.getLastName();
      String password = account.getPassword();
      char type = account.getType();
      
      dataBase.user_editUser(username, first, last, password, type, 'N');
      
      return true;
    }
  }
  
  /**
   * Find recommendations of closely related schools
   * 
   * @param name
   * @return topFive closely related schools.
   */
  public ArrayList<String> findRecommendations(String name) {
    String[][] rec = dataBase.university_getUniversities();
    String[][] values = new String[rec.length][2];
    ArrayList<String> topFive = new ArrayList<String>();
    
    University currentUniversity = getUniversity(name);
    
    String loc = currentUniversity.getLocation(); // 1
    String state = currentUniversity.getState(); // 2
    String control = currentUniversity.getControl(); // 3
    int numStudents = currentUniversity.getNumStudents(); // 4
    double percentFemale = currentUniversity.getPercentFemale(); // 5
    int satVerbal = currentUniversity.getSatVerbal(); // 6
    int satMath = currentUniversity.getSatMath(); // 7
    int expenses = currentUniversity.getExpenses(); // 8
    double perFA = currentUniversity.getFinancialAid(); // 9
    int numApplicants = currentUniversity.getNumApplicants(); // 10
    double perAdmitted = currentUniversity.getPercentAdmitted(); // 11
    double perEnrolled = currentUniversity.getPercentEnrolled(); // 12
    int academicScale = currentUniversity.getAcademicScale(); // 13
    int socialScale = currentUniversity.getSocialScale(); // 14
    int lifeScale = currentUniversity.getLifeScale(); // 15
    // ArrayList<String> emp = currentUniversity.getEmphases(); //16
    
    int maxNumStudents = 0, maxSatVerbal = 0, maxSatMath = 0, maxExpenses = 0, maxNumApplicants = 0,
      maxAcademicScale = 5, maxSocialScale = 5, maxLifeScale = 5;
    double minPercentFemale, maxPercentFemale = 0, minPerFA, maxPerFA = 0, minPerAdmitted, maxPerAdmitted = 0,
      minPerEnrolled, maxPerEnrolled = 0;
    
    int minNumStudents, minSatVerbal, minSatMath, minExpenses, minNumApplicants, minAcademicScale = 1,
      minSocialScale = 1, minLifeScale = 1;
    minPerEnrolled = minPerAdmitted = minPerFA = minPercentFemale = minNumStudents = minSatVerbal = minSatMath = minExpenses = minNumApplicants = 999999999;
    
    // getting maxes and mins
    for (int i = 0; i < rec.length; i++) {
      for (int j = 4; j < rec[i].length; j++) {
        
        switch (j) {
          // numStudents
          case 4:
            if (Integer.parseInt(rec[i][j]) > maxNumStudents) {
            maxNumStudents = Integer.parseInt(rec[i][j]);
          } else if (Integer.parseInt(rec[i][j]) < minNumStudents) {
            minNumStudents = Integer.parseInt(rec[i][j]);
          }
          break;
          // percentFemale
          case 5:
            if (Double.parseDouble(rec[i][j]) > maxPercentFemale) {
            maxPercentFemale = Double.parseDouble(rec[i][j]);
          } else if (Double.parseDouble(rec[i][j]) < minPercentFemale) {
            minPercentFemale = Double.parseDouble(rec[i][j]);
          }
          break;
          // satVerbal
          case 6:
            if (Integer.parseInt(rec[i][j]) > maxSatVerbal) {
            maxSatVerbal = Integer.parseInt(rec[i][j]);
          } else if (Integer.parseInt(rec[i][j]) < minSatVerbal) {
            minSatVerbal = Integer.parseInt(rec[i][j]);
          }
          break;
          // satMath
          case 7:
            if (Integer.parseInt(rec[i][j]) > maxSatMath) {
            maxSatMath = Integer.parseInt(rec[i][j]);
          } else if (Integer.parseInt(rec[i][j]) < minSatMath) {
            minSatMath = Integer.parseInt(rec[i][j]);
          }
          break;
          // expenses
          case 8:
            if (Integer.parseInt(rec[i][j]) > maxExpenses) {
            maxExpenses = Integer.parseInt(rec[i][j]);
          } else if (Integer.parseInt(rec[i][j]) < minExpenses) {
            minExpenses = Integer.parseInt(rec[i][j]);
          }
          break;
          // perFA
          case 9:
            if (Integer.parseInt(rec[i][j]) > maxPerFA) {
            maxPerFA = Double.parseDouble(rec[i][j]);
          } else if (Integer.parseInt(rec[i][j]) < minPerFA) {
            minPerFA = Double.parseDouble(rec[i][j]);
          }
          break;
          // numApplicants
          case 10:
            if (Integer.parseInt(rec[i][j]) > maxNumApplicants) {
            maxNumApplicants = Integer.parseInt(rec[i][j]);
          } else if (Integer.parseInt(rec[i][j]) < minNumApplicants) {
            minNumApplicants = Integer.parseInt(rec[i][j]);
          }
          break;
          // percentAdmitted
          case 11:
            if (Double.parseDouble(rec[i][j]) > maxPerAdmitted) {
            maxPerAdmitted = Integer.parseInt(rec[i][j]);
          } else if (Double.parseDouble(rec[i][j]) < minPerAdmitted) {
            minPerAdmitted = Integer.parseInt(rec[i][j]);
          }
          break;
          // percentEnrolled
          case 12:
            if (Double.parseDouble(rec[i][j]) > maxPerEnrolled) {
            maxPerEnrolled = Integer.parseInt(rec[i][j]);
          } else if (Double.parseDouble(rec[i][j]) < minPerEnrolled) {
            minPerEnrolled = Integer.parseInt(rec[i][j]);
          }
          break;
        }
        
      }
    }
    
    for (int i = 0; i < rec.length; i++) {
      // don't compare the university to itself
      if (name.equals(rec[i][0])) {
        values[i][0] = name;
        values[i][1] = "100";
      } else {
        
        double value = 0;
        
        University comparedUniversity = getUniversity(rec[i][0]);
        
        // compare location
        value += (loc.equals(comparedUniversity.getLocation()) || comparedUniversity.getLocation() == null) ? 0
          : 1;
        
        // compare state
        value += (state.equals(comparedUniversity.getState()) || comparedUniversity.getState() == null) ? 0 : 1;
        
        // compare control
        value += (control.equals(comparedUniversity.getControl()) || comparedUniversity.getControl() == null)
          ? 0 : 1;
        
        // compare numStudents
        value += comparedUniversity.getNumStudents() == 0 ? 0
          : Math.abs((numStudents - comparedUniversity.getNumStudents())
                       / (maxNumStudents - minNumStudents));
        
        // compare percentFemale
        value += comparedUniversity.getPercentFemale() == 0 ? 0
          : Math.abs((percentFemale - comparedUniversity.getPercentFemale())
                       / (maxPercentFemale - minPercentFemale));
        
        // compare satVerbal
        value += comparedUniversity.getSatVerbal() == 0 ? 0
          : Math.abs((satVerbal - comparedUniversity.getSatVerbal()) / (maxSatVerbal - minSatVerbal));
        
        // compare satMath
        value += comparedUniversity.getSatMath() == 0 ? 0
          : Math.abs((satMath - comparedUniversity.getSatMath()) / (maxSatMath - minSatMath));
        
        // compare expenses
        value += comparedUniversity.getExpenses() == 0 ? 0
          : Math.abs((expenses - comparedUniversity.getExpenses()) / (maxExpenses - minExpenses));
        
        // compare perFA
        value += comparedUniversity.getFinancialAid() == 0 ? 0
          : Math.abs((perFA - comparedUniversity.getFinancialAid()) / (maxPerFA - minPerFA));
        
        // compare numApplicants
        value += comparedUniversity.getNumApplicants() == 0 ? 0
          : Math.abs((numApplicants - comparedUniversity.getNumApplicants())
                       / (maxNumApplicants - minNumApplicants));
        
        // compare perAdmitted
        value += comparedUniversity.getPercentAdmitted() == 0 ? 0
          : Math.abs((perAdmitted - comparedUniversity.getPercentAdmitted())
                       / (maxPerAdmitted - minPerAdmitted));
        
        // compare perEnrolled
        value += comparedUniversity.getPercentEnrolled() == 0 ? 0
          : Math.abs((perEnrolled - comparedUniversity.getPercentEnrolled())
                       / (maxPerEnrolled - minPerEnrolled));
        
        // compare academicScale
        value += comparedUniversity.getAcademicScale() == 0 ? 0
          : Math.abs((academicScale - comparedUniversity.getAcademicScale()) / (4));
        
        // compare socialScale
        value += comparedUniversity.getSocialScale() == 0 ? 0
          : Math.abs((socialScale - comparedUniversity.getSocialScale()) / (4));
        
        // compare lifeScale
        value += comparedUniversity.getLifeScale() == 0 ? 0
          : Math.abs((lifeScale - comparedUniversity.getLifeScale()) / (4));
        
        // compare emphases
        // ^^^^ still needs to be implemented
        
        values[i][0] = comparedUniversity.getName();
        values[i][1] = Double.toString(value);
        
      }
      
    }
    double a = 0;
    double b = 0;
    // get top 5 from the map and put them into an ArrayList: return the
    // arraylist
    for (int i = 0; i < values.length - 1; i++) {
      for (int j = i + 1; j < values.length; j++) {
        a = Double.parseDouble(values[i][1]);
        b = Double.parseDouble(values[j][1]);
        if (a > b) {
          String tempValue = values[i][1];
          String tempName = (String) values[i][0];
          
          values[i][1] = values[j][1];
          values[j][1] = tempValue;
          values[i][0] = values[j][0];
          values[j][0] = tempName;
        }
      }
    }
    
    for (int i = 0; i < 5; i++) {
      topFive.add((String) values[i][0]);
    }
    
    return topFive;
  }
  
}
