package model;

public class OrderOfService {

  private String Number;
  private String patientRecord;
  private String dateAndHour;
  private String referringDoctor;
  private String department;
  private String typeOfservice;
  private String responsibleUser;
  private String insurance;

  public OrderOfService(String Number, String patientRecord, String dateAndHour, String referringDoctor, String department, String typeOfservice, String responsibleUser, String insurance){
    this.Number = Number;
    this.patientRecord = patientRecord;
    this.dateAndHour = dateAndHour;
    this.referringDoctor = referringDoctor;
    this.department = department;
    this.typeOfservice = typeOfservice;
    this.responsibleUser = responsibleUser;
    this.insurance = insurance;
  }

  public OrderOfService(){
    this.Number = "";
    this.patientRecord = "";
    this.dateAndHour = "";
    this.referringDoctor = "";
    this.department = "";
    this.typeOfservice = "";
    this.responsibleUser = "";
    this.insurance = "";
  }

  public String getNumber() {
    return Number;
  }

  public void setNumber(String number) {
    Number = number;
  }

  public String getPatientRecord() {
    return patientRecord;
  }

  public void setPatientRecord(String patientRecord) {
    this.patientRecord = patientRecord;
  }

  public String getDateAndHour() {
    return dateAndHour;
  }

  public void setDateAndHour(String dateAndHour) {
    this.dateAndHour = dateAndHour;
  }

  public String getReferringDoctor() {
    return referringDoctor;
  }

  public void setReferringDoctor(String referringDoctor) {
    this.referringDoctor = referringDoctor;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getTypeOfservice() {
    return typeOfservice;
  }

  public void setTypeOfservice(String typeOfservice) {
    this.typeOfservice = typeOfservice;
  }

  public String getResponsibleUser() {
    return responsibleUser;
  }

  public void setResponsibleUser(String responsibleUser) {
    this.responsibleUser = responsibleUser;
  }

  public String getInsurance() {
    return insurance;
  }

  public void setInsurance(String insurance) {
    this.insurance = insurance;
  }
}