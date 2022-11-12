package model;


/*
 * This class is used to create a user object
 * 
 * @param login
 * @param password 
 * @param name
 * @param department
 * @param birthDate
 * @param CPF
 */

public class User{

  private String login;
  private String password;
  private String name;
  private String department;
  private String birthDate;
  private String CPF;

  public User(){
    this.login = "";
    this.password = "";
    this.name = "";
    this.department = "";
    this.birthDate = "";
    this.CPF = "";
  }

  public User(String login, String password, String name, String department, String birthDate, String CPF){
    this.login = login;
    this.password = password;
    this.name = name;
    this.department = department;
    this.birthDate = birthDate;
    this.CPF = CPF;
  }
  
}
