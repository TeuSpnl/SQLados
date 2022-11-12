package model;

public class Patient {
  private String record = ""; // Record numbeR
  private String recordDate = "";
  private String name = "";
  private String birthDate = "";
  private String CPF = "";
  private String insuranceCode = "";
  private String phone = "";

  public Patient(String record , String recordDate, String name, String birthDate, String CPF, String insuranceCode, String phone){
    this.record = record;
    this.recordDate = recordDate;
    this.name = name;
    this.birthDate = birthDate;
    this.CPF = CPF;
    this.insuranceCode = insuranceCode;
    this.phone = phone;
  }

  
}
