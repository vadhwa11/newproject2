package jkt.hms.util;

public class ImmunizationUtil {
	Integer id;
  String name;
  String scheDate;
  String vaccinToDate;
  String vaccinComplDate;
  Integer minDays;
  Integer maxDays;
  Integer doseCount;
  
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getScheDate() {
	return scheDate;
}
public void setScheDate(String scheDate) {
	this.scheDate = scheDate;
}

public String getVaccinToDate() {
	return vaccinToDate;
}
public void setVaccinToDate(String vaccinToDate) {
	this.vaccinToDate = vaccinToDate;
}
public String getVaccinComplDate() {
	return vaccinComplDate;
}
public void setVaccinComplDate(String vaccinComplDate) {
	this.vaccinComplDate = vaccinComplDate;
}
public Integer getMinDays() {
	return minDays;
}
public void setMinDays(Integer minDays) {
	this.minDays = minDays;
}
public Integer getMaxDays() {
	return maxDays;
}
public void setMaxDays(Integer maxDays) {
	this.maxDays = maxDays;
}
public Integer getDoseCount() {
	return doseCount;
}
public void setDoseCount(Integer doseCount) {
	this.doseCount = doseCount;
}
  
}
