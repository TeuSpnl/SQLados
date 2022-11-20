package model;

public class Equipment {

  private String number;
  private String registerDate; 
  private String name; 
  private String departmentCode;
  
  public Equipment(String number, String registerDate, String name, String departmentCode){
    this.number = number;
    this.registerDate = registerDate;
    this.name = name;
    this.departmentCode = departmentCode;
  }

  public Equipment(){
    this.number = "";
    this.registerDate = "";
    this.name = "";
    this.departmentCode = "";
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(String registerDate) {
    this.registerDate = registerDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
  }
  
}
