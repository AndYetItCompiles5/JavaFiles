package Project;

import java.util.*;
import java.lang.*;
import Project.*;

/**
 * University Objects that represent schools in the database
 * 
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/22/2017
 */
public class University {
 /**
  * name of the University
  */
 private String name;

 /**
  * state the University is located in
  */
 private String state;

 /**
  * can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if
  * unknown
  */
 private String location;

 /**
  * can be one of the following: PRIVATE, STATE, CITY, or -1 if unknown
  */
 private String control;

 /**
  * number of students enrolled in the University
  */
 private int numberOfStudents;

 /**
  * percentage of enrolled students that are females (between 0 and 100)
  */
 private double percentFemale;

 /**
  * average SAT verbal score for enrolled students(between 0 and 800)
  */
 private int satVerbal;

 /**
  * average SAT math score for enrolled students(between 0 and 800)
  */
 private int satMath;

 /**
  * annual expenses or tuition to attend the school
  */
 private int expenses;

 /**
  * percentage of enrolled students receiving financial aid
  */
 private double percentFA;

 /**
  * total number of applicants that apply to the school anually
  */
 private int numApplicants;

 /**
  * percent of applicants that get admitted
  */
 private double percentAdmitted;

 /**
  * percent of applicants that decide to enroll
  */
 private double percentEnrolled;

 /**
  * integer between 1 and 5 indicating the academic scale of the University
  */
 private int academicScale;

 /**
  * integer between 1 and 5 indicating the quality of social life at the
  * University
  */
 private int socialScale;

 /**
  * integer between 1 and 5 indicating the quality of life at the University
  */
 private int lifeScale;

 /**
  * up to five areas of study the University excels at (all Strings)
  */
 private ArrayList<String> emphases;

 /**
  * Constructor. Creates a university with just a name.
  * 
  * @param name
  */
 public University(String name) {
  this.name = name;
  this.state = "-1";
  this.location = "-1";
  this.control = "-1";
  this.numberOfStudents = -1;
  this.percentFemale = -1.0;
  this.satVerbal = -1;
  this.satMath = -1;
  this.expenses = -1;
  this.percentFA = -1.0;
  this.numApplicants = -1;
  this.percentAdmitted = -1.0;
  this.percentEnrolled = -1.0;
  this.academicScale = -1;
  this.socialScale = -1;
  this.lifeScale = -1;
  this.emphases = null;
 }

 /**
  * Constructor to create a University object. Name must be filled in
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
  *             if name is not given
  */
 public University(String name, String state, String location, String control, int numStudents, double perFemale,
   int satVerbal, int satMath, int expenses, double perFA, int numApplicants, double perAdmitted,
   double perEnrolled, int academicScale, int socialScale, int lifeScale, ArrayList<String> emphases) {
  if (name == null||name.equals("")) {
   throw new IllegalArgumentException("Name of the university is required");
  } else {
   this.name = name;
  }
  
  this.state = state;
  
  if (location.equals("URBAN") || location.equals("SUBURBAN") || location.equals("SMALL-CITY")
    || location.equals("RURAL") || location.equals("-1")) {
   this.location = location;

  } else {
   throw new IllegalArgumentException("Location must be SUBURBAN or URBAN or SMALL-CITY or RURAL"+location);
  }
  if (control.equals("PRIVATE") || control.equals("STATE") || control.equals("CITY") || control.equals("-1")) {
   this.control = control;
  } else {
   throw new IllegalArgumentException("Control must be STATE or PRIVATE or CITY");
  }
  if (numStudents < -1) {
   throw new IllegalArgumentException("Number of students cannot be negative");
  } else {
   this.numberOfStudents = numStudents;
  }
  if ((perFemale < 0 || perFemale > 100.0) && perFemale != -1) {
   throw new IllegalArgumentException("Percent should be between 0 and 100");
  } else {
   this.percentFemale = perFemale;
  }
  if (satVerbal < -1 || satVerbal >= 801) {
   throw new IllegalArgumentException("SAT Verbal score should be between 0 and 800");
  } else {
   this.satVerbal = satVerbal;
  }
  if (satMath < -1 || satMath >= 801) {
   throw new IllegalArgumentException("SAT Math score should be between 0 and 800");
  } else {
   this.satMath = satMath;
  }
  if (expenses < -1) {
   throw new IllegalArgumentException("Expenses cannot be negative");
  } else {
   this.expenses = expenses;
  }
  if ((perFA < 0 || perFA > 100.0) && perFA != -1) {
   throw new IllegalArgumentException("Percent should be between 0 and 100");
  } else {
   this.percentFA = perFA;
  }
  if (numApplicants < -1) {
   throw new IllegalArgumentException("Number of Applicants cannot be negative");
  } else {
   this.numApplicants = numApplicants;
  }
  if ((perAdmitted < 0 || perAdmitted > 100.0) && perAdmitted != -1) {
   throw new IllegalArgumentException("Percent should be between 0 and 100");
  } else {
   this.percentAdmitted = perAdmitted;
  }
  if ((perEnrolled < 0 || perEnrolled > 100.0) && perEnrolled != -1) {
   throw new IllegalArgumentException("Percent should be between 0 and 100");
  } else {
   this.percentEnrolled = perEnrolled;
  }
  if (academicScale < -1 || academicScale > 5 || academicScale == 0) {
   throw new IllegalArgumentException("Academic Scale should be between 1 and 5");
  } else {
   this.academicScale = academicScale;
  }
  if (socialScale < -1 || socialScale > 5 || socialScale == 0) {
   throw new IllegalArgumentException("Social Scale should be between 1 and 5");
  } else {
   this.socialScale = socialScale;
  }
  if (lifeScale < -1 || lifeScale > 5 || lifeScale == 0) {
   throw new IllegalArgumentException("Life Scale should be between 1 and 5");
  } else {
   this.lifeScale = lifeScale;
  }
  this.emphases = emphases;
 }

 /**
  * get the name of the University
  * 
  * @return the name of the University
  */
 public String getName() {
  return name;
 }

 /**
  * get the state the University is in
  * 
  * @return the state the University is in
  */
 public String getState() {
  return state;
 }

 /**
  * sets the state the University is in
  * 
  * @param state
  *            the state the University is in
  */
 public void setState(String state) {
  this.state = state;
 }

 /**
  * get the location of the University
  * 
  * @return the location of the University
  */
 public String getLocation() {
  return location;
 }

 /**
  * set the location of the University
  * 
  * @param location
  *            the location of the University
  * @throws IllegalArgumentException
  *             if location is not SUBURBAN, URBAN, SMALL-CITY, or -1
  */
 public void setLocation(String location) {
  if (location.equals("SUBURBAN") || location.equals("URBAN") || location.equals("SMALL-CITY")
    || location.equals("-1"))
   this.location = location;
  else
   throw new IllegalArgumentException("location must be SUBURBAN, URBAN, SMALL-CITY, or -1");
 }

 /**
  * get the control of the University
  * 
  * @return the control of the University
  */
 public String getControl() {
  return control;
 }

 /**
  * set the control of the University
  * 
  * @param control
  *            the control of the University
  * @throws IllegalArgumentException
  *             if control is not PRIVATE, STATE, CITY, or -1
  */
 public void setControl(String control) {
  if (control.equals("PRIVATE") || control.equals("STATE") || control.equals("CITY") || control.equals("-1"))
   this.control = control;
  else
   throw new IllegalArgumentException("control must be PRIVATE, STATE, CITY, or -1");
 }

 /**
  * gets the number of students enrolled at the University
  * 
  * @return the number of students enrolled at the University
  */
 public int getNumStudents() {
  return numberOfStudents;
 }

 /**
  * sets the number of students enrolled at the University
  * 
  * @param num
  *            the number of students enrolled at the University
  */
 public void setNumStudents(int num) {
  if (num < -1)
   throw new IllegalArgumentException("Number of students cannot be negative");
  else
   this.numberOfStudents = num;
 }

 /**
  * gets the percent of enrolled students who are female
  * 
  * @return the percent of enrolled students who are female
  */
 public double getPercentFemale() {
  return percentFemale;
 }

 /**
  * sets the percent of enrolled students who are female. It will give
  * IllegalArgumentException if per is less then 0 or greater 100
  * 
  * @param d
  *            the percent of enrolled students who are female
  * @throws IllegalArgumentException
  */
 public void setPercentFemale(double perFA) {
  if ((perFA < 0 || perFA > 100.0) && perFA != -1)
   throw new IllegalArgumentException("percent must be greater than zero and less than 100");
  else
   this.percentFemale = perFA;
 }

 /**
  * gets the average SAT verbal score for enrolled students
  * 
  * @return the average SAT verbal score for enrolled students
  */
 public int getSatVerbal() {
  return satVerbal;
 }

 /**
  * sets the average SAT verbal score for enrolled students
  * 
  * @param score
  *            the average SAT verbal score for enrolled students
  * @throws IllegalArgumentException
  *             if score is not between 0 and 800
  */
 public void setSatVerbal(int score) {
  if (score < -1 || score > 800)
   throw new IllegalArgumentException("Score must be between 0 and 800");
  else
   this.satVerbal = score;
 }

 /**
  * gets the average SAT math score for enrolled students
  * 
  * @return the average SAT math score for enrolled students
  */
 public int getSatMath() {
  return satMath;
 }

 /**
  * sets the average SAT math score for enrolled students
  * 
  * @param score
  *            the average SAT math score for enrolled students
  * @throws IllegalArgumentException
  *             if score is not between 0 and 800
  */
 public void setSatMath(int score) {
  if (score < -1 || score > 800)
   throw new IllegalArgumentException("Score must be between 0 and 800");
  else
   this.satMath = score;
 }

 /**
  * gets the annual expenses or tuition to attend the University
  * 
  * @return the annual expenses or tuition to attend the University
  */
 public int getExpenses() {
  return expenses;
 }

 /**
  * sets the annual expenses or tuition to attend the University
  * 
  * @param expense
  *            the annual expenses or tuition to attend the University
  */
 public void setExpenses(int expense) {
  if (expense < -1)
   throw new IllegalArgumentException("Expenses cannot be negative");
  else
   this.expenses = expense;
 }

 /**
  * gets the percent of enrolled students receiving financial aid
  * 
  * @return the percent of enrolled students receiving financial aid
  */
 public double getFinancialAid() {
  return percentFA;
 }

 /**
  * set the percent of enrolled students receiving financial aid
  * 
  * @param percent
  *            the percent of enrolled students receiving financial aid
  * @throws IllegalArgumentException
  *             if percent less then 0 or greater then 100
  */
 public void setFinancialAid(double percent) {
  if ((percent < 0 || percent > 100.0) && percent != -1)
   throw new IllegalArgumentException("percent must be greater than 0 and less than 100");
  else
   this.percentFA = percent;
 }

 /**
  * gets the number of applicant that apply to the school annually
  * 
  * @return the number of applicants that apply to the school annually
  */
 public int getNumApplicants() {
  return numApplicants;
 }

 /**
  * set the number of applicants that apply to the school annually
  * 
  * @param num
  *            the number of applicants that apply to the school annually
  */
 public void setNumApplicants(int num) {
  if (num < -1)
   throw new IllegalArgumentException("Number of applicants cannot be below 0");
  else
   this.numApplicants = num;
 }

 /**
  * gets the percent of applicants that get admitted
  * 
  * @return the percent of applicants that get admitted
  */
 public double getPercentAdmitted() {
  return percentAdmitted;
 }

 /**
  * set the percent of applicants that get admitted
  * 
  * @param per
  *            the percent of applicants that get admitted
  * @throws IllegalArgumentException
  *             if per is less then 0 or greater than 100
  */
 public void setPercentAdmitted(double per) {
  if ((per < 0 || per > 100.0) && per != -1)
   throw new IllegalArgumentException("percent must be greater than 0 and less than 100");
  else
   this.percentAdmitted = per;
 }

 /**
  * get the percent of applicants that decide to enroll
  * 
  * @return the percent of applicants that decide to enroll
  */
 public double getPercentEnrolled() {
  return percentEnrolled;
 }

 /**
  * set the percent of applicants that decide to enroll
  * 
  * @param per
  *            the percent of applicants that decide to enroll
  * @throws IllegalArgumentException
  *             if per is less than 0 or is greater than 100
  */
 public void setPercentEnrolled(double per) {
  if ((per < 0 || per > 100.0) && per != -1)
   throw new IllegalArgumentException("percent must be greater than 0 and less than 100");
  else
   this.percentEnrolled = per;
 }

 /**
  * get the academic scale of the University
  * 
  * @return the academic scale of the University
  */
 public int getAcademicScale() {
  return academicScale;
 }

 /**
  * set the academic scale of the University
  * 
  * @param scale
  *            the academic scale of the University
  * @throws IllegalArgumentException
  *             if scale is not between 1 and 5
  */
 public void setAcademicScale(int scale) {
  if (scale < -1 || scale > 5 || scale == 0)
   throw new IllegalArgumentException("scale must be between 1 and 5");
  else
   this.academicScale = scale;
 }

 /**
  * get the social scale of the University
  * 
  * @return the social scale of the University
  */
 public int getSocialScale() {
  return socialScale;
 }

 /**
  * set the social scale of the University
  * 
  * @param scale
  *            the social scale of the University
  * @throws IllegalArgumentException
  *             if scale is not between 1 and 5
  */
 public void setSocialscale(int scale) {
  if (scale < -1 || scale > 5 || scale == 0)
   throw new IllegalArgumentException("scale must be between 1 and 5");
  else
   this.socialScale = scale;
 }

 /**
  * get the life scale of the University
  * 
  * @return the life scale of the University
  */
 public int getLifeScale() {
  return lifeScale;
 }

 /**
  * set the life scale of the University
  * 
  * @param scale
  *            the life scale of University
  * @throws IllegalArgumentException
  *             if scale is not between 1 and 5
  */
 public void setLifeScale(int scale) {
  if (scale < -1 || scale > 5 || scale == 0)
   throw new IllegalArgumentException("scale must be between 1 and 5");
  else
   this.lifeScale = scale;
 }

 /**
  * gets the emphases of the University
  * 
  * @return the emphases of the University
  */
 public ArrayList<String> getEmphases() {
  return emphases;
 }

 /**
  * set the emphases of the University
  * 
  * @param emphases
  *            the emphases of the University
  */
 public void setEmphases(ArrayList<String> emphases) {
  this.emphases = emphases;
 }
}
