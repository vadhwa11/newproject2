package jkt.hms.workservices.controller;

public class AgendaDTO {
	private String minorWorkNo;
	private String fromDate;
	private String toDate;
	private String workCategoryName;
	private String workTypeName;
	private String department;
	private String workDetails;

	public String getMinorWorkNo() {
		return minorWorkNo;
	}

	public void setMinorWorkNo(String minorWorkNo) {
		this.minorWorkNo = minorWorkNo;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getWorkCategoryName() {
		return workCategoryName;
	}

	public void setWorkCategoryName(String workCategoryName) {
		this.workCategoryName = workCategoryName;
	}

	public String getWorkTypeName() {
		return workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the workDetails
	 */
	public String getWorkDetails() {
		return workDetails;
	}

	/**
	 * @param workDetails
	 *            the workDetails to set
	 */
	public void setWorkDetails(String workDetails) {
		this.workDetails = workDetails;
	}

}
