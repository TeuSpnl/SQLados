package model;

public class Patient {
  private String record = ""; // Record numbeR
  private String recordDate = "";
  private String name = "";
  private String birthDate = "";
  private String CPF = "";
  private String insuranceCode = "";
  private String phone = "";

  public Patient(){
    this.record = "";
    this.recordDate = "";
    this.name = "";
    this.birthDate = "";
    this.CPF = "";
    this.insuranceCode = "";
    this.phone = "";
  }

  public Patient(String record , String recordDate, String name, String birthDate, String CPF, String insuranceCode, String phone){
    this.record = record;
    this.recordDate = recordDate;
    this.name = name;
    this.birthDate = birthDate;
    this.CPF = CPF;
    this.insuranceCode = insuranceCode;
    this.phone = phone;
  }

  public String getRecord() {
    return record;
  }

  public void setRecord(String record) {
    this.record = record;
  }

  public String getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(String recordDate) {
    this.recordDate = recordDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getInsuranceCode() {
    return insuranceCode;
  }

  public void setInsuranceCode(String insuranceCode) {
    this.insuranceCode = insuranceCode;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  
}
