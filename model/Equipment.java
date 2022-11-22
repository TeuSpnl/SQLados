package model;

import java.sql.Date;

public class Equipment {

  private int number;
  private Date registerDate; 
  private String name; 
  private int departmentCode;
  
  public Equipment(int number, Date registerDate, String name, int departmentCode){
    this.number = number;
    this.registerDate = registerDate;
    this.name = name;
    this.departmentCode = departmentCode;
  }

  public Equipment(){
    this.number = 0;
    this.registerDate = null;
    this.name = "";
    this.departmentCode = 0;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(int departmentCode) {
    this.departmentCode = departmentCode;
  }

  public String[] equipmentToString(){
    String[] s = new String[4];
    s[0] = "Numero: " + Integer.toString(this.number);
    s[1] = "Data de Registro: " + this.registerDate.toString();
    s[2] = "Nome: " + this.name;
    s[3] = "Codigo do Setor: " + Integer.toString(this.departmentCode);
    return s;
  }
  
}
