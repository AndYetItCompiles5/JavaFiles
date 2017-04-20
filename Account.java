package Project;
import java.util.*;
import Project.*;

/**
 * Super class Account that can either be an Admin or User
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 3/1/17
 */

public class Account{
  
  /**
   * First name of user
   */
  private String firstName;
  /**
   * Last name of user
   */
  private String lastName;
  /**
   * Username of user
   */
  private String username;
  /**
   * The password for the user
   */
  private String password;
  /**
   * type of the account 'a' for admin, 'u' for user
   */
  private char type;
  /**
   * status of the account (activated or deactivated) 'y' or 'n'
   */
  private char status;
  
  public Account(){
	  this.firstName = "";
	    this.lastName = "";
	    this.username = "";
	    this.password = "";
	    this.type = 'U';
		this.status='Y';
  }
  
  /**
   * Constructor for an Account
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of the Account
   * @param password the password of the Account
   * @param type what type of Account this is 'a' for admin, 'u' for user
   * @param status if the user/admin is activated or deactivated
   * @throws IllegalArgumentException if type is not 'a' or 'u'
   * @throws IllegalArgumentException if status is not 'Y' or 'n'
   */
  public Account(String first, String last, String username, String password, char type, char status)
  {
    this.firstName = first;
    this.lastName = last;
    this.username = username;
    this.password = password;
    if(type=='a'||type=='A'||type=='U'||type=='u'){
    	this.type = type;
    }
    else{
    	throw new IllegalArgumentException("Type must be A,a,U,or u");
    }
    if(status=='Y'||status=='y'|| status=='N' || status=='n'){
		  this.status=status;
	    }
	else{
	    throw new IllegalArgumentException("Must set status to Y,y,N, or n");
	}  
  }
  
  /**
   * Gets the first name of the account
   * @return the account's first name
   */
  public String getFirstName()
  {
    return firstName; 
  }
  
  /**
   * Sets the first name of the account
   * @param name: the first name being set
   */
  public void setFirstName(String name)
  {
    this.firstName=name;
  }
  
  /**
   * Gets the last name of the account
   * @return the account's last name
   */
  public String getLastName()
  {
    return lastName;
  }
  
  /**
   * Sets the last name of the account
   * @param name: the last name being set
   */
  public void setLastName(String name)
  {
    this.lastName=name;
  }
  
  /**
   * Gets the password of the account
   * @return the account's password
   */
  public String getPassword()
  {
    return password;
  }
  
  /**
   * Sets the password of the account
   * @param password: the password being set
   */
  public void setPassword(String password)
  {
    this.password=password;
  }
  
  /**
   * Gets the username of the account
   * @return the account's username
   */
  public String getUsername()
  {
    return username; 
  }
  
  /**
   * Gets the type of the account
   * @return the account's type
   */
  public char getType()
  {
    return type; 
  }
  
  /**
   * Sets the type of the account
   * @param type: the type being set
   * @throws IllegalArgumentException if type != a or u
   */
  public void setType(char type)
  {
    if(type=='u'|| type=='a' ||type=='U'||type=='A'){
    	this.type=type;
    }
    else{
    	throw new IllegalArgumentException("Cannot set type to "+type);
    }
  }
  
  /**
   * Gets the status of the account
   * @return the account's status
   */
  public char getStatus()
  {
    return status; 
  }
  
  /**
   * Sets the status of the account
   * @param status: the type being set
   */
  public void setStatus(char status)
  {
	  if(status=='Y'|| type=='y' || type=='N' || type=='n'){
		  this.status=status;
	    }
	    else{
	    	throw new IllegalArgumentException("Cannot set status to "+status);
	    }
  }
}