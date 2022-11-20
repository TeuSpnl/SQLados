package model;

public class ServiceProvider {
  private String code;
  private String name;
  private String CPF;
  private String council;
  private String type;
  private String UF;

  public ServiceProvider(String code, String name, String CPF, String council, String type, String UF){
    this.code = code;
    this.name = name;
    this.CPF = CPF;
    this.council = council;
    this.type = type;
    this.UF = UF;
  }

  public ServiceProvider(){
    this.code = "";
    this.name = "";
    this.CPF = "";
    this.council = "";
    this.type = "";
    this.UF = "";
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

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String cPF) {
    CPF = cPF;
  }

  public String getCouncil() {
    return council;
  }

  public void setCouncil(String council) {
    this.council = council;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUF() {
    return UF;
  }

  public void setUF(String uF) {
    UF = uF;
  }
  
}
