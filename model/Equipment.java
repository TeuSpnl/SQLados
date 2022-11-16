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
  
}
