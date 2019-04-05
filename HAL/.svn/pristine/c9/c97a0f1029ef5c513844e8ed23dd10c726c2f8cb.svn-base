package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_tender_m table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_m"
 */

public abstract class BaseStoreTenderM implements Serializable {

	public static String REF = "StoreTenderM";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_TERMS_AND_CONDITIONS = "TermsAndConditions";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ISSUE_LAST_DATE = "IssueLastDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TENDER_RECEIPT_TIME = "TenderReceiptTime";
	public static String PROP_TENDER_REC_LAST_TIME = "TenderRecLastTime";
	public static String PROP_GROUP = "Group";
	public static String PROP_TENDER_RECEIPT_PLACE = "TenderReceiptPlace";
	public static String PROP_TENDER_INVITATION_DATE = "TenderInvitationDate";
	public static String PROP_COMMERCIAL_OPENING_DATE = "CommercialOpeningDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_TENDER_REC_LAST_DATE = "TenderRecLastDate";
	public static String PROP_COMM_OF_ISSUE_DATE = "CommOfIssueDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_ADDRESS_OF_COMMUNICATION = "AddressOfCommunication";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TECHNICAL_OPENING_DATE = "TechnicalOpeningDate";
	public static String PROP_TENDER_NO = "TenderNo";

	// constructors
	public BaseStoreTenderM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tenderNo;
	private java.util.Date tenderInvitationDate;
	private java.util.Date commOfIssueDate;
	private java.util.Date issueLastDate;
	private java.lang.String tenderReceiptTime;
	private java.lang.String tenderReceiptPlace;
	private java.util.Date tenderRecLastDate;
	private java.lang.String tenderRecLastTime;
	private java.util.Date technicalOpeningDate;
	private java.util.Date commercialOpeningDate;
	private java.lang.String addressOfCommunication;
	private java.lang.String remarks;
	private java.lang.String termsAndConditions;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreGroup group;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderT> storeTenderTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: tender_no
	 */
	public java.lang.String getTenderNo() {
		return tenderNo;
	}

	/**
	 * Set the value related to the column: tender_no
	 * 
	 * @param tenderNo
	 *            the tender_no value
	 */
	public void setTenderNo(java.lang.String tenderNo) {
		this.tenderNo = tenderNo;
	}

	/**
	 * Return the value associated with the column: tender_invitation_date
	 */
	public java.util.Date getTenderInvitationDate() {
		return tenderInvitationDate;
	}

	/**
	 * Set the value related to the column: tender_invitation_date
	 * 
	 * @param tenderInvitationDate
	 *            the tender_invitation_date value
	 */
	public void setTenderInvitationDate(java.util.Date tenderInvitationDate) {
		this.tenderInvitationDate = tenderInvitationDate;
	}

	/**
	 * Return the value associated with the column: comm_of_issue_date
	 */
	public java.util.Date getCommOfIssueDate() {
		return commOfIssueDate;
	}

	/**
	 * Set the value related to the column: comm_of_issue_date
	 * 
	 * @param commOfIssueDate
	 *            the comm_of_issue_date value
	 */
	public void setCommOfIssueDate(java.util.Date commOfIssueDate) {
		this.commOfIssueDate = commOfIssueDate;
	}

	/**
	 * Return the value associated with the column: issue_last_date
	 */
	public java.util.Date getIssueLastDate() {
		return issueLastDate;
	}

	/**
	 * Set the value related to the column: issue_last_date
	 * 
	 * @param issueLastDate
	 *            the issue_last_date value
	 */
	public void setIssueLastDate(java.util.Date issueLastDate) {
		this.issueLastDate = issueLastDate;
	}

	/**
	 * Return the value associated with the column: tender_receipt_time
	 */
	public java.lang.String getTenderReceiptTime() {
		return tenderReceiptTime;
	}

	/**
	 * Set the value related to the column: tender_receipt_time
	 * 
	 * @param tenderReceiptTime
	 *            the tender_receipt_time value
	 */
	public void setTenderReceiptTime(java.lang.String tenderReceiptTime) {
		this.tenderReceiptTime = tenderReceiptTime;
	}

	/**
	 * Return the value associated with the column: tender_receipt_place
	 */
	public java.lang.String getTenderReceiptPlace() {
		return tenderReceiptPlace;
	}

	/**
	 * Set the value related to the column: tender_receipt_place
	 * 
	 * @param tenderReceiptPlace
	 *            the tender_receipt_place value
	 */
	public void setTenderReceiptPlace(java.lang.String tenderReceiptPlace) {
		this.tenderReceiptPlace = tenderReceiptPlace;
	}

	/**
	 * Return the value associated with the column: tender_rec_last_date
	 */
	public java.util.Date getTenderRecLastDate() {
		return tenderRecLastDate;
	}

	/**
	 * Set the value related to the column: tender_rec_last_date
	 * 
	 * @param tenderRecLastDate
	 *            the tender_rec_last_date value
	 */
	public void setTenderRecLastDate(java.util.Date tenderRecLastDate) {
		this.tenderRecLastDate = tenderRecLastDate;
	}

	/**
	 * Return the value associated with the column: tender_rec_last_time
	 */
	public java.lang.String getTenderRecLastTime() {
		return tenderRecLastTime;
	}

	/**
	 * Set the value related to the column: tender_rec_last_time
	 * 
	 * @param tenderRecLastTime
	 *            the tender_rec_last_time value
	 */
	public void setTenderRecLastTime(java.lang.String tenderRecLastTime) {
		this.tenderRecLastTime = tenderRecLastTime;
	}

	/**
	 * Return the value associated with the column: technical_opening_date
	 */
	public java.util.Date getTechnicalOpeningDate() {
		return technicalOpeningDate;
	}

	/**
	 * Set the value related to the column: technical_opening_date
	 * 
	 * @param technicalOpeningDate
	 *            the technical_opening_date value
	 */
	public void setTechnicalOpeningDate(java.util.Date technicalOpeningDate) {
		this.technicalOpeningDate = technicalOpeningDate;
	}

	/**
	 * Return the value associated with the column: commercial_opening_date
	 */
	public java.util.Date getCommercialOpeningDate() {
		return commercialOpeningDate;
	}

	/**
	 * Set the value related to the column: commercial_opening_date
	 * 
	 * @param commercialOpeningDate
	 *            the commercial_opening_date value
	 */
	public void setCommercialOpeningDate(java.util.Date commercialOpeningDate) {
		this.commercialOpeningDate = commercialOpeningDate;
	}

	/**
	 * Return the value associated with the column: address_of_communication
	 */
	public java.lang.String getAddressOfCommunication() {
		return addressOfCommunication;
	}

	/**
	 * Set the value related to the column: address_of_communication
	 * 
	 * @param addressOfCommunication
	 *            the address_of_communication value
	 */
	public void setAddressOfCommunication(
			java.lang.String addressOfCommunication) {
		this.addressOfCommunication = addressOfCommunication;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: terms_and_conditions
	 */
	public java.lang.String getTermsAndConditions() {
		return termsAndConditions;
	}

	/**
	 * Set the value related to the column: terms_and_conditions
	 * 
	 * @param termsAndConditions
	 *            the terms_and_conditions value
	 */
	public void setTermsAndConditions(java.lang.String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	/**
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * 
	 * @param lastChangedDate
	 *            the last_changed_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * 
	 * @param lastChangedTime
	 *            the last_changed_time value
	 */
	public void setLastChangedTime(java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup() {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * 
	 * @param group
	 *            the group_id value
	 */
	public void setGroup(jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
	}

	/**
	 * Return the value associated with the column: StoreTenderTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderT> getStoreTenderTs() {
		return storeTenderTs;
	}

	/**
	 * Set the value related to the column: StoreTenderTs
	 * 
	 * @param storeTenderTs
	 *            the StoreTenderTs value
	 */
	public void setStoreTenderTs(
			java.util.Set<jkt.hms.masters.business.StoreTenderT> storeTenderTs) {
		this.storeTenderTs = storeTenderTs;
	}

	public void addToStoreTenderTs(
			jkt.hms.masters.business.StoreTenderT storeTenderT) {
		if (null == getStoreTenderTs())
			setStoreTenderTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderT>());
		getStoreTenderTs().add(storeTenderT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderM))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderM storeTenderM = (jkt.hms.masters.business.StoreTenderM) obj;
			if (null == this.getId() || null == storeTenderM.getId())
				return false;
			else
				return (this.getId().equals(storeTenderM.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}