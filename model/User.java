package model;

import java.sql.Date;

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
  private int department;
  private Date birthDate;
  private long CPF;

  public User(){
    this.login = "";
    this.password = "";
    this.name = "";
    this.department = 0;
    this.birthDate = null;
    this.CPF = 0;
  }

  public User(String login, String password, String name, int department, Date birthDate, long CPF){
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

  public int getDepartment() {
    return department;
  }

  public void setDepartment(int department) {
    this.department = department;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public long getCPF() {
    return CPF;
  }

  public void setCPF(long cPF) {
    CPF = cPF;
  }

  public String[] userToString(){
    String[] user = new String[6];
    user[0] = "Login: " + this.login;
    user[1] = "Senha: " + this.password;
    user[2] = "Nome: " + this.name;
    user[3] = "Cod_dep: " + Integer.toString(this.department);
    user[4] = "Aniversario: " + this.birthDate.toString();
    user[5] = "CPF: " + Long.toString(this.CPF);
    return user;
  }
  
}
