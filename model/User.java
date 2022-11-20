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

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String cPF) {
    CPF = cPF;
  }
  
}
