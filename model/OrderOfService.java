package model;

import java.sql.Date;

public class OrderOfService {

  private int Number;
  private int patientRecord;
  private Date dateAndHour;
  private int referringDoctor;
  private int department;
  private String typeOfservice;
  private String responsibleUser;
  private int insurance;

  public OrderOfService(int Number, int patientRecord, Date dateAndHour, int referringDoctor, int department, String typeOfservice, String responsibleUser, int insurance){
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
    this.Number = 0;
    this.patientRecord = 0;
    this.dateAndHour = null;
    this.referringDoctor = 0;
    this.department = 0;
    this.typeOfservice = "";
    this.responsibleUser = "";
    this.insurance = 0;
  }

  public int getNumber() {
    return Number;
  }

  public void setNumber(int number) {
    Number = number;
  }

  public int getPatientRecord() {
    return patientRecord;
  }

  public void setPatientRecord(int patientRecord) {
    this.patientRecord = patientRecord;
  }

  public Date getDateAndHour() {
    return dateAndHour;
  }

  public void setDateAndHour(Date dateAndHour) {
    this.dateAndHour = dateAndHour;
  }

  public int getReferringDoctor() {
    return referringDoctor;
  }

  public void setReferringDoctor(int referringDoctor) {
    this.referringDoctor = referringDoctor;
  }

  public int getDepartment() {
    return department;
  }

  public void setDepartment(int department) {
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

  public int getInsurance() {
    return insurance;
  }

  public void setInsurance(int insurance) {
    this.insurance = insurance;
  }

  public String[] orderOfServiceToString(){
    String[] s = new String[8];
    s[0] = "Numero: " + Integer.toString(this.Number);
    s[1] = "Numero do prontuario: " + Integer.toString(this.patientRecord);
    s[2] = "Data e hora: " + this.dateAndHour.toString();
    s[3] = "Numero do medico encaminhante: " + Integer.toString(this.referringDoctor);
    s[4] = "Numero do departamento: " + Integer.toString(this.department);
    s[5] = "Tipo de servico: " + this.typeOfservice;
    s[6] = "Usuario responsavel: " + this.responsibleUser;
    s[7] = "Numero do seguro: " + Integer.toString(this.insurance);
    return s;
  }
}