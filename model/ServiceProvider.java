package model;

public class ServiceProvider {
  private int code;
  private String name;
  private long CPF;
  private String council;
  private String type;
  private String UF;

  public ServiceProvider(int code, String name, long CPF, String council, String type, String UF){
    this.code = code;
    this.name = name;
    this.CPF = CPF;
    this.council = council;
    this.type = type;
    this.UF = UF;
  }

  public ServiceProvider(){
    this.code = 0;
    this.name = "";
    this.CPF = 0;
    this.council = "";
    this.type = "";
    this.UF = "";
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

  public long getCPF() {
    return CPF;
  }

  public void setCPF(long cPF) {
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

  //this method is used to show the information of the service provider in the table
  public String[] serviceProviderToString(){
    String[] s = new String[6];
    s[0] = "Codigo: " + Integer.toString(this.code);
    s[1] = "Nome: " + this.name;
    s[2] = "CPF: " + Long.toString(this.CPF);
    s[3] = "Conselho: " + this.council;
    s[4] = "Tipo: " + this.type;
    s[5] = "UF: " + this.UF;
    return s;
  }
  
}
