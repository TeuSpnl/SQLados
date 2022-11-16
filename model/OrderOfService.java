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
  
}
