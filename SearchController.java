package Project;

import java.util.*;
import dblibrary.project.csci230.UniversityDBLibrary;
import Project.*;

/**
 * A controller class that lets the user search for universities with their
 * provided information
 * 
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class SearchController {
	/**
	 * Creates an instance of the Database Library
	 */
	private DBController dbController;

	/**
	 * Default constructor. Initialized the DB Controller.
	 */
	public SearchController() {
		dbController = new DBController();
	}

	/**
	 * Checks if the school's actual data is within the range of the low and
	 * high that the user searched for
	 * 
	 * @param low:
	 *            the low bound the user inputed
	 * @param high:
	 *            the high bound the user inputed
	 * @param actual:
	 *            the concrete number of the school
	 * @return true if the actual is between the low and the high
	 * 
	 */
	public boolean isWithinRangeDouble(double low, double high, double actual) {
		if (actual >= low && actual <= high) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the school's actual data is within the range of the low and
	 * high that the user searched for
	 * 
	 * @param low:
	 *            the low bound the user inputed
	 * @param high:
	 *            the high bound the user inputed
	 * @param actual:
	 *            the concrete number of the school
	 * @return true if the actual is between the low and the high
	 * 
	 */
	public boolean isWithinRangeInt(int low, int high, int actual) {
		if (actual >= low && actual <= high) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets any recommended schools
	 * 
	 * @param name
	 *            the name of the University
	 * 
	 * @return ArrayList of recommended schools
	 */
	public ArrayList<String> findRecommendations(String name) {
		return dbController.findRecommendations(name);
	}
	
	/**
	 * Searches for schools with the provided information
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
	 *            up to five areas of study the University excels at (all
	 *            Strings)
	 * @return hashset of the schools that were found
	 */
	public HashSet<String> search(String name, String state, String location, String control, int numStudentsLow,
			int numStudentsHigh, double perFemaleLow, double perFemaleHigh, int satVerbalLow, int satVerbalHigh,
			int satMathLow, int satMathHigh, int expensesLow, int expensesHigh, double perFALow, double perFAHigh,
			int numApplicantsLow, int numApplicantsHigh, double perAdmittedLow, double perAdmittedHigh,
			double perEnrolledLow, double perEnrolledHigh, int academicScaleLow, int academicScaleHigh,
			int socialScaleLow, int socialScaleHigh, int lifeScaleLow, int lifeScaleHigh, ArrayList<String> emphases) {
		ArrayList<University> allUniversities = dbController.getUniversityObjects();
		HashSet<String> answer = new HashSet<String>();
		for (int i=0;i<allUniversities.size();i++){
			if(allUniversities.get(i).getName().toLowerCase().contains(name.toLowerCase()) || name.equals("-1")){
				if(allUniversities.get(i).getState().toLowerCase().contains(state.toLowerCase()) || state.equals("-1")){
					if(allUniversities.get(i).getLocation().toLowerCase().contains(location.toLowerCase()) || location.equals("-1")){
						if(allUniversities.get(i).getControl().toLowerCase().contains(control.toLowerCase()) || control.equals("-1")){
							if(isWithinRangeInt(numStudentsLow,numStudentsHigh,allUniversities.get(i).getNumStudents()) || (numStudentsLow==0&&numStudentsHigh==0)){
								if(isWithinRangeDouble(perFemaleLow,perFemaleHigh,allUniversities.get(i).getPercentFemale()) || (perFemaleLow==0 && perFemaleHigh==0)){
									if(isWithinRangeInt(satVerbalLow,satVerbalHigh,allUniversities.get(i).getSatVerbal()) || (satVerbalLow==0 && satVerbalHigh==0)){
										if(isWithinRangeInt(satMathLow,satMathHigh,allUniversities.get(i).getSatMath()) || (satMathLow==0 && satMathHigh==0)){
											if(isWithinRangeInt(expensesLow,expensesHigh,allUniversities.get(i).getExpenses()) || (expensesLow==0 && expensesHigh==0)){
												if(isWithinRangeDouble(perFALow,perFAHigh,allUniversities.get(i).getFinancialAid()) || (perFALow==0 && perFAHigh==0)){
													if(isWithinRangeInt(numApplicantsLow,numApplicantsHigh,allUniversities.get(i).getNumApplicants()) || (numApplicantsLow==0 && numApplicantsHigh==0)){
														if(isWithinRangeDouble(perAdmittedLow,perAdmittedHigh,allUniversities.get(i).getPercentAdmitted()) || (perAdmittedLow==0 && perAdmittedHigh==0)){
															if(isWithinRangeDouble(perEnrolledLow,perEnrolledHigh,allUniversities.get(i).getPercentEnrolled()) || (perEnrolledLow==0 && perEnrolledHigh==0)){
																if(isWithinRangeInt(academicScaleLow,academicScaleHigh,allUniversities.get(i).getAcademicScale()) || (academicScaleLow==0 && academicScaleHigh==0)){
																	if(isWithinRangeInt(socialScaleLow,socialScaleHigh,allUniversities.get(i).getSocialScale()) || (socialScaleLow==0 && socialScaleHigh==0)){
																		if(isWithinRangeInt(lifeScaleLow,lifeScaleHigh,allUniversities.get(i).getLifeScale()) || (lifeScaleLow==0 && lifeScaleHigh==0)){
																			if(emphases==null){
																				answer.add(allUniversities.get(i).getName());
																			}
																			else{
																				ArrayList<String> currentUEmphases = allUniversities.get(i).getEmphases();
																				for(int e=0;e<currentUEmphases.size();e++){
																					if(emphases.contains(currentUEmphases.get(e))){
																						answer.add(allUniversities.get(i).getName());
																					}
																				}
																			}
																		}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		return answer;		
		}
		}
	

