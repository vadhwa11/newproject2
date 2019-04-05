package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the accom_registration table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="accom_registration"
 */

public abstract class BaseAccomRegistration implements Serializable {

	public static String REF = "AccomRegistration";
	public static String PROP_CANCEL_DATE = "CancelDate";
	public static String PROP_POSTED_DATE = "PostedDate";
	public static String PROP_POOL = "Pool";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_POSTING_DATE = "PostingDate";
	public static String PROP_REPORTING_DATE = "ReportingDate";
	public static String PROP_REG_TYPE = "RegType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_SFX = "Sfx";
	public static String PROP_SERVICE_PERSON_NAME = "ServicePersonName";
	public static String PROP_ANTI_DATE_REMARKS = "AntiDateRemarks";
	public static String PROP_ACTUAL_REGISTRATION_DATE = "ActualRegistrationDate";
	public static String PROP_TRADE = "Trade";
	public static String PROP_PREVIOUS_SMQ = "PreviousSmq";
	public static String PROP_ANTE_DATE = "AnteDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PREVIOUS_UNIT = "PreviousUnit";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_REGISTRATION_NO = "RegistrationNo";
	public static String PROP_REGISTRATION_DATE = "RegistrationDate";
	public static String PROP_ANTI_DATE_SENIORITY = "AntiDateSeniority";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CANCEL_NO = "CancelNo";
	public static String PROP_REGISTRATION_TIME = "RegistrationTime";
	public static String PROP_REG_STATUS = "RegStatus";
	public static String PROP_MARRIAGE_DATE = "MarriageDate";
	public static String PROP_RANK = "Rank";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ACCEPTED_DATE = "AcceptedDate";
	public static String PROP_TYPE_OF_RECEIVE = "TypeOfReceive";
	public static String PROP_ID = "Id";

	// constructors
	public BaseAccomRegistration() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccomRegistration(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccomRegistration(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasPool pool,
			jkt.hms.masters.business.MasUnit previousUnit,
			jkt.hms.masters.business.MasRank rank,
			java.lang.String registrationNo, java.util.Date registrationDate,
			java.lang.String registrationTime, java.lang.String serviceNo,
			java.lang.String servicePersonName, java.lang.String previousSmq,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String sfx,
			java.lang.String regType) {

		this.setId(id);
		this.setHospital(hospital);
		this.setPool(pool);
		this.setPreviousUnit(previousUnit);
		this.setRank(rank);
		this.setRegistrationNo(registrationNo);
		this.setRegistrationDate(registrationDate);
		this.setRegistrationTime(registrationTime);
		this.setServiceNo(serviceNo);
		this.setServicePersonName(servicePersonName);
		this.setPreviousSmq(previousSmq);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		this.setSfx(sfx);
		this.setRegType(regType);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String registrationNo;
	private java.util.Date registrationDate;
	private java.lang.String registrationTime;
	private java.lang.String serviceNo;
	private java.lang.String servicePersonName;
	private java.util.Date reportingDate;
	private java.lang.String previousSmq;
	private java.util.Date marriageDate;
	private java.util.Date acceptedDate;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String sfx;
	private java.lang.String regType;
	private java.util.Date postingDate;
	private java.util.Date anteDate;
	private java.lang.String typeOfReceive;
	private java.util.Date postedDate;
	private java.lang.String regStatus;
	private java.util.Date actualRegistrationDate;
	private java.util.Date antiDateSeniority;
	private java.lang.String antiDateRemarks;
	private java.util.Date cancelDate;
	private java.lang.String cancelNo;

	// many to one
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasPool pool;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasUnit previousUnit;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasTrade trade;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="accom_id"
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
	 * Return the value associated with the column: registration_no
	 */
	public java.lang.String getRegistrationNo() {
		return registrationNo;
	}

	/**
	 * Set the value related to the column: registration_no
	 * 
	 * @param registrationNo
	 *            the registration_no value
	 */
	public void setRegistrationNo(java.lang.String registrationNo) {
		this.registrationNo = registrationNo;
	}

	/**
	 * Return the value associated with the column: registration_date
	 */
	public java.util.Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Set the value related to the column: registration_date
	 * 
	 * @param registrationDate
	 *            the registration_date value
	 */
	public void setRegistrationDate(java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Return the value associated with the column: registration_time
	 */
	public java.lang.String getRegistrationTime() {
		return registrationTime;
	}

	/**
	 * Set the value related to the column: registration_time
	 * 
	 * @param registrationTime
	 *            the registration_time value
	 */
	public void setRegistrationTime(java.lang.String registrationTime) {
		this.registrationTime = registrationTime;
	}

	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo() {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * 
	 * @param serviceNo
	 *            the service_no value
	 */
	public void setServiceNo(java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}

	/**
	 * Return the value associated with the column: service_person_name
	 */
	public java.lang.String getServicePersonName() {
		return servicePersonName;
	}

	/**
	 * Set the value related to the column: service_person_name
	 * 
	 * @param servicePersonName
	 *            the service_person_name value
	 */
	public void setServicePersonName(java.lang.String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}

	/**
	 * Return the value associated with the column: reporting_date
	 */
	public java.util.Date getReportingDate() {
		return reportingDate;
	}

	/**
	 * Set the value related to the column: reporting_date
	 * 
	 * @param reportingDate
	 *            the reporting_date value
	 */
	public void setReportingDate(java.util.Date reportingDate) {
		this.reportingDate = reportingDate;
	}

	/**
	 * Return the value associated with the column: previous_smq
	 */
	public java.lang.String getPreviousSmq() {
		return previousSmq;
	}

	/**
	 * Set the value related to the column: previous_smq
	 * 
	 * @param previousSmq
	 *            the previous_smq value
	 */
	public void setPreviousSmq(java.lang.String previousSmq) {
		this.previousSmq = previousSmq;
	}

	/**
	 * Return the value associated with the column: marriage_date
	 */
	public java.util.Date getMarriageDate() {
		return marriageDate;
	}

	/**
	 * Set the value related to the column: marriage_date
	 * 
	 * @param marriageDate
	 *            the marriage_date value
	 */
	public void setMarriageDate(java.util.Date marriageDate) {
		this.marriageDate = marriageDate;
	}

	/**
	 * Return the value associated with the column: accepted_date
	 */
	public java.util.Date getAcceptedDate() {
		return acceptedDate;
	}

	/**
	 * Set the value related to the column: accepted_date
	 * 
	 * @param acceptedDate
	 *            the accepted_date value
	 */
	public void setAcceptedDate(java.util.Date acceptedDate) {
		this.acceptedDate = acceptedDate;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: sfx
	 */
	public java.lang.String getSfx() {
		return sfx;
	}

	/**
	 * Set the value related to the column: sfx
	 * 
	 * @param sfx
	 *            the sfx value
	 */
	public void setSfx(java.lang.String sfx) {
		this.sfx = sfx;
	}

	/**
	 * Return the value associated with the column: reg_type
	 */
	public java.lang.String getRegType() {
		return regType;
	}

	/**
	 * Set the value related to the column: reg_type
	 * 
	 * @param regType
	 *            the reg_type value
	 */
	public void setRegType(java.lang.String regType) {
		this.regType = regType;
	}

	/**
	 * Return the value associated with the column: posting_date
	 */
	public java.util.Date getPostingDate() {
		return postingDate;
	}

	/**
	 * Set the value related to the column: posting_date
	 * 
	 * @param postingDate
	 *            the posting_date value
	 */
	public void setPostingDate(java.util.Date postingDate) {
		this.postingDate = postingDate;
	}

	/**
	 * Return the value associated with the column: ante_date
	 */
	public java.util.Date getAnteDate() {
		return anteDate;
	}

	/**
	 * Set the value related to the column: ante_date
	 * 
	 * @param anteDate
	 *            the ante_date value
	 */
	public void setAnteDate(java.util.Date anteDate) {
		this.anteDate = anteDate;
	}

	/**
	 * Return the value associated with the column: type_of_receive
	 */
	public java.lang.String getTypeOfReceive() {
		return typeOfReceive;
	}

	/**
	 * Set the value related to the column: type_of_receive
	 * 
	 * @param typeOfReceive
	 *            the type_of_receive value
	 */
	public void setTypeOfReceive(java.lang.String typeOfReceive) {
		this.typeOfReceive = typeOfReceive;
	}

	/**
	 * Return the value associated with the column: posted_date
	 */
	public java.util.Date getPostedDate() {
		return postedDate;
	}

	/**
	 * Set the value related to the column: posted_date
	 * 
	 * @param postedDate
	 *            the posted_date value
	 */
	public void setPostedDate(java.util.Date postedDate) {
		this.postedDate = postedDate;
	}

	/**
	 * Return the value associated with the column: reg_status
	 */
	public java.lang.String getRegStatus() {
		return regStatus;
	}

	/**
	 * Set the value related to the column: reg_status
	 * 
	 * @param regStatus
	 *            the reg_status value
	 */
	public void setRegStatus(java.lang.String regStatus) {
		this.regStatus = regStatus;
	}

	/**
	 * Return the value associated with the column: actual_registration_date
	 */
	public java.util.Date getActualRegistrationDate() {
		return actualRegistrationDate;
	}

	/**
	 * Set the value related to the column: actual_registration_date
	 * 
	 * @param actualRegistrationDate
	 *            the actual_registration_date value
	 */
	public void setActualRegistrationDate(java.util.Date actualRegistrationDate) {
		this.actualRegistrationDate = actualRegistrationDate;
	}

	/**
	 * Return the value associated with the column: anti_date_seniority
	 */
	public java.util.Date getAntiDateSeniority() {
		return antiDateSeniority;
	}

	/**
	 * Set the value related to the column: anti_date_seniority
	 * 
	 * @param antiDateSeniority
	 *            the anti_date_seniority value
	 */
	public void setAntiDateSeniority(java.util.Date antiDateSeniority) {
		this.antiDateSeniority = antiDateSeniority;
	}

	/**
	 * Return the value associated with the column: anti_date_remarks
	 */
	public java.lang.String getAntiDateRemarks() {
		return antiDateRemarks;
	}

	/**
	 * Set the value related to the column: anti_date_remarks
	 * 
	 * @param antiDateRemarks
	 *            the anti_date_remarks value
	 */
	public void setAntiDateRemarks(java.lang.String antiDateRemarks) {
		this.antiDateRemarks = antiDateRemarks;
	}

	/**
	 * Return the value associated with the column: cancel_date
	 */
	public java.util.Date getCancelDate() {
		return cancelDate;
	}

	/**
	 * Set the value related to the column: cancel_date
	 * 
	 * @param cancelDate
	 *            the cancel_date value
	 */
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	/**
	 * Return the value associated with the column: cancel_no
	 */
	public java.lang.String getCancelNo() {
		return cancelNo;
	}

	/**
	 * Set the value related to the column: cancel_no
	 * 
	 * @param cancelNo
	 *            the cancel_no value
	 */
	public void setCancelNo(java.lang.String cancelNo) {
		this.cancelNo = cancelNo;
	}

	/**
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * 
	 * @param serviceType
	 *            the service_type_id value
	 */
	public void setServiceType(
			jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
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
	 * Return the value associated with the column: pool_id
	 */
	public jkt.hms.masters.business.MasPool getPool() {
		return pool;
	}

	/**
	 * Set the value related to the column: pool_id
	 * 
	 * @param pool
	 *            the pool_id value
	 */
	public void setPool(jkt.hms.masters.business.MasPool pool) {
		this.pool = pool;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getPreviousUnit() {
		return previousUnit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param previousUnit
	 *            the unit_id value
	 */
	public void setPreviousUnit(jkt.hms.masters.business.MasUnit previousUnit) {
		this.previousUnit = previousUnit;
	}

	/**
	 * Return the value associated with the column: unit
	 */
	public jkt.hms.masters.business.MasUnit getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit
	 * 
	 * @param unit
	 *            the unit value
	 */
	public void setUnit(jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * 
	 * @param rank
	 *            the rank_id value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}

	/**
	 * Return the value associated with the column: trade_id
	 */
	public jkt.hms.masters.business.MasTrade getTrade() {
		return trade;
	}

	/**
	 * Set the value related to the column: trade_id
	 * 
	 * @param trade
	 *            the trade_id value
	 */
	public void setTrade(jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.AccomRegistration))
			return false;
		else {
			jkt.hms.masters.business.AccomRegistration accomRegistration = (jkt.hms.masters.business.AccomRegistration) obj;
			if (null == this.getId() || null == accomRegistration.getId())
				return false;
			else
				return (this.getId().equals(accomRegistration.getId()));
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