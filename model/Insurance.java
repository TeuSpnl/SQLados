package model;

public class Insurance {

  private String code;
  private String name;
  
  public Insurance(String code, String name){
    this.code = code;
    this.name = name;
  }

  public Insurance(){
    this.code = "";
    this.name = "";
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
