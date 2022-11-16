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
  
}
