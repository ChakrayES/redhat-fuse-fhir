package com.chakray.microservice.pojo;

import java.io.Serializable;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@CsvRecord(separator = ",")
public class Record implements Serializable {

  private static final long serialVersionUID = 7747416447408606464L; // DeviceId,PIN,DNI,GivenName,FamilyName,MobilePhone,Gender,BirthDate,Email

  @DataField(pos = 1, trim = true)
  private String DeviceId;
  @DataField(pos = 2, trim = true)
  private String PIN;
  @DataField(pos = 3, trim = true)
  private String DNI;
  @DataField(pos = 4, trim = true)
  private String GivenName;
  @DataField(pos = 5, trim = true)
  private String FamilyName;
  @DataField(pos = 6, trim = true)
  private String MobilePhone;
  @DataField(pos = 7, trim = true)
  private String Gender;
  @DataField(pos = 8, trim = true)
  private String BirthDate;
  @DataField(pos = 9, trim = true)
  private String Email;

  public String getDeviceId() {
    return DeviceId;
  }

  public void setDeviceId(final String deviceId) {
    DeviceId = deviceId;
  }

  public String getPIN() {
    return PIN;
  }

  public void setPIN(final String pIN) {
    PIN = pIN;
  }

  public String getDNI() {
    return DNI;
  }

  public void setDNI(final String dNI) {
    DNI = dNI;
  }

  public String getGivenName() {
    return GivenName;
  }

  public void setGivenName(final String givenName) {
    GivenName = givenName;
  }

  public String getFamilyName() {
    return FamilyName;
  }

  public void setFamilyName(final String familyName) {
    FamilyName = familyName;
  }

  public String getMobilePhone() {
    return MobilePhone;
  }

  public void setMobilePhone(final String mobilePhone) {
    MobilePhone = mobilePhone;
  }

  public String getGender() {
    return Gender;
  }

  public void setGender(final String gender) {
    Gender = gender;
  }

  public String getBirthDate() {
    return BirthDate;
  }

  public void setBirthDate(final String birthDate) {
    BirthDate = birthDate;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(final String email) {
    Email = email;
  }

}
