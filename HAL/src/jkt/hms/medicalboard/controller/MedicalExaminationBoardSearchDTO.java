package jkt.hms.medicalboard.controller;

public class MedicalExaminationBoardSearchDTO {
	private String service;
	private String yearlySearialNo;
	private String rollNo;
	private String chestNo;
	private String batchNo;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getYearlySearialNo() {
		return yearlySearialNo;
	}

	public void setYearlySearialNo(String yearlySearialNo) {
		this.yearlySearialNo = yearlySearialNo;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getChestNo() {
		return chestNo;
	}

	public void setChestNo(String chestNo) {
		this.chestNo = chestNo;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
}
