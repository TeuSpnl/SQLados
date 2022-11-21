package model;

public class Insurance {

  private int code;
  private String name;
  
  public Insurance(int code, String name){
    this.code = code;
    this.name = name;
  }

  public Insurance(){
    this.code = 0;
    this.name = "";
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
