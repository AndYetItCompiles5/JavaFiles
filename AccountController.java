package Project;
import java.util.*;
import Project.*;

/**
 * Gives the user/admin multiple options on what they can do with their accounts or other accounts
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class AccountController{
  /**
   * Who is logged into the system
   */
  private String loggedIn;
  /**
   * creates an instance of a DBController
   */
  private DBController dbController;
  /**
   * default creates a db object
   */
  public AccountController()
  {
    dbController = new DBController();
  }
  
  /**
   * Logs the user in with the specified username and password
   * 
   * @param username: the Username of the person logging in
   * @param password: the Password of the person logging in
   * @throws IllegalArgumentException if username/password is incorrect
   * @throws IllegalArgumentException if account is deactivated
   * @return boolean for if the user successfully logged in
   */
  public boolean login(String username, String password)
  {

    Account account = dbController.getAccount(username);
    
    String username1 = account.getUsername();
    String password1 = account.getPassword();
    char   type      = account.getType();
    char   status    = account.getStatus();
    
    if(!password1.equals(password) || !username1.equals(username))
    {
     throw new IllegalArgumentException("Username/password Incorrect");
    }
    
    if(status == 'n'|| status=='N')
    {
     throw new IllegalArgumentException("Account is deactivated");
    }
    
    setLoggedIn(username);
    
    return true;
  }
  
  
  /**
   * Logout whoever is logged in
   * @throws NullPointerException if nobody is logged in
   * @return whoever is logged in
   */
  public String logout()
  {
    if(loggedIn==null || loggedIn.equals("")){
     throw new NullPointerException("Nobody is logged in");
    }
    loggedIn="";
    return loggedIn;
  }
  
  /**
   * Sets the account given as logged in
   * @param username: the account that will be set as logged in
   */
  public void setLoggedIn(String username)
  {
    loggedIn = username;
  }
  
  /**
   * Edits the user with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
   * @return Whether the user was successfully edited
   */
  public boolean editUser(String first, String last, String password)
  {
    return dbController.editAccount(first,last,loggedIn,password,'u','y');
  }
  
  /**
   * Edits any account with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param username: the user's username
   * @param password: the user's password
   * @param type: the type of the account
   * @param status: the status of the account
   * @return whether the account was successfully edited
   */
  public boolean editAccount(String first, String last, String username, String password, char type, char status)
  {
    return dbController.editAccount(first,last,username,password,type,status); 
  }
  
  /**
   * Deactivates a user by setting status to 'n'
   * 
   * @param username the username of the user
   * 
   * @return whether the user was deactivated or if there was an error
   */
  public boolean deactivateUser(String username)
  {
    return dbController.deactivateUser(username);
  }
  
  /**
   * Returns who is logged on
   * @return the username of the user logged on
   */
  public String getLoggedIn(){
   return loggedIn;
  }
 }

