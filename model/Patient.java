package model;

import java.sql.Date;

public class Patient {
  private int record = 0; // Record numbeR
  private Date recordDate = null;
  private String name = "";
  private Date birthDate = null;
  private long CPF = 0;
  private int insuranceCode = 0;
  private long phone = 0;

  public Patient(){
    this.record = 0;
    this.recordDate = null;
    this.name = "";
    this.birthDate = null;
    this.CPF = 0;
    this.insuranceCode = 0;
    this.phone = 0;
  }

  public Patient(int record , Date recordDate, String name, Date birthDate, long CPF, int insuranceCode, long phone){
    this.record = record;
    this.recordDate = recordDate;
    this.name = name;
    this.birthDate = birthDate;
    this.CPF = CPF;
    this.insuranceCode = insuranceCode;
    this.phone = phone;
  }

  public int getRecord() {
    return record;
  }

  public void setRecord(int record) {
    this.record = record;
  }

  public Date getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(Date recordDate) {
    this.recordDate = recordDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public long getCPF() {
    return CPF;
  }

  public void setCPF(long cPF) {
    CPF = cPF;
  }

  public int getInsuranceCode() {
    return insuranceCode;
  }

  public void setInsuranceCode(int insuranceCode) {
    this.insuranceCode = insuranceCode;
  }

  public long getPhone() {
    return phone;
  }

  public void setPhone(long phone) {
    this.phone = phone;
  }

  
}
