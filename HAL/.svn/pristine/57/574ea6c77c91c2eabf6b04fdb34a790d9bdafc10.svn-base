package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_result_entry_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_result_entry_header"
 */

public abstract class BaseDgResultEntryHeader  implements Serializable {

	public static String REF = "DgResultEntryHeader";
	public static String PROP_PRESCRIBED_BY = "PrescribedBy";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_VERIFIED_ON = "VerifiedOn";
	public static String PROP_LAST_CHGD_TIME = "LastChgdTime";
	public static String PROP_VERIFIED_TIME = "VerifiedTime";
	public static String PROP_MAS_HOSPITAL = "MasHospital";
	public static String PROP_UPDATE_ON = "UpdateOn";
	public static String PROP_RESULT_NO = "ResultNo";
	public static String PROP_TEMPELATE_ID = "TempelateId";
	public static String PROP_TEST_ORDER_NO = "TestOrderNo";
	public static String PROP_VERIFIED = "Verified";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_RELATION = "Relation";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RESULT_TIME = "ResultTime";
	public static String PROP_RESULT_VERIFIED_BY = "ResultVerifiedBy";
	public static String PROP_RESULT_STATUS = "ResultStatus";
	public static String PROP_LAST_CHGD_DATE = "LastChgdDate";
	public static String PROP_PATIENT = "Patient";
	public static String PROP_RESULT_TYPE = "ResultType";
	public static String PROP_IMPRESSION = "Impression";
	public static String PROP_RESULT_UPDATED_BY = "ResultUpdatedBy";
	public static String PROP_SAMPLE_COLLECTION_HEADER = "SampleCollectionHeader";
	public static String PROP_DG_MAS_INVESTIGATION = "DgMasInvestigation";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_LAST_CHGD_BY = "LastChgdBy";
	public static String PROP_ID = "Id";
	public static String PROP_RESULT_DATE = "ResultDate";


	// constructors
	public BaseDgResultEntryHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgResultEntryHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String impression;
	private java.lang.String lastChgdBy;
	private java.util.Date lastChgdDate;
	private java.lang.String lastChgdTime;
	private java.lang.String receivedBy;
	private java.lang.String remarks;
	private java.util.Date resultDate;
	private java.lang.String resultNo;
	private java.lang.String resultStatus;
	private java.lang.String resultTime;
	private java.lang.String resultType;
	private java.lang.String tempelateId;
	private java.lang.Integer testOrderNo;
	private java.util.Date updateOn;
	private java.lang.String verified;
	private java.util.Date verifiedOn;
	private java.lang.String verifiedTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.MasHospital masHospital;
	private jkt.hms.masters.business.Patient patient;
	private jkt.hms.masters.business.MasEmployee prescribedBy;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasEmployee resultUpdatedBy;
	private jkt.hms.masters.business.MasEmployee resultVerifiedBy;
	private jkt.hms.masters.business.DgSampleCollectionHeader sampleCollectionHeader;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> dgResultEntryDetailSen;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="result_entry_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: impression
	 */
	public java.lang.String getImpression () {
		return impression;
	}

	/**
	 * Set the value related to the column: impression
	 * @param impression the impression value
	 */
	public void setImpression (java.lang.String impression) {
		this.impression = impression;
	}



	/**
	 * Return the value associated with the column: last_chgd_by
	 */
	public java.lang.String getLastChgdBy () {
		return lastChgdBy;
	}

	/**
	 * Set the value related to the column: last_chgd_by
	 * @param lastChgdBy the last_chgd_by value
	 */
	public void setLastChgdBy (java.lang.String lastChgdBy) {
		this.lastChgdBy = lastChgdBy;
	}



	/**
	 * Return the value associated with the column: last_chgd_date
	 */
	public java.util.Date getLastChgdDate () {
		return lastChgdDate;
	}

	/**
	 * Set the value related to the column: last_chgd_date
	 * @param lastChgdDate the last_chgd_date value
	 */
	public void setLastChgdDate (java.util.Date lastChgdDate) {
		this.lastChgdDate = lastChgdDate;
	}



	/**
	 * Return the value associated with the column: last_chgd_time
	 */
	public java.lang.String getLastChgdTime () {
		return lastChgdTime;
	}

	/**
	 * Set the value related to the column: last_chgd_time
	 * @param lastChgdTime the last_chgd_time value
	 */
	public void setLastChgdTime (java.lang.String lastChgdTime) {
		this.lastChgdTime = lastChgdTime;
	}



	/**
	 * Return the value associated with the column: received_by
	 */
	public java.lang.String getReceivedBy () {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by
	 * @param receivedBy the received_by value
	 */
	public void setReceivedBy (java.lang.String receivedBy) {
		this.receivedBy = receivedBy;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: result_date
	 */
	public java.util.Date getResultDate () {
		return resultDate;
	}

	/**
	 * Set the value related to the column: result_date
	 * @param resultDate the result_date value
	 */
	public void setResultDate (java.util.Date resultDate) {
		this.resultDate = resultDate;
	}



	/**
	 * Return the value associated with the column: result_no
	 */
	public java.lang.String getResultNo () {
		return resultNo;
	}

	/**
	 * Set the value related to the column: result_no
	 * @param resultNo the result_no value
	 */
	public void setResultNo (java.lang.String resultNo) {
		this.resultNo = resultNo;
	}



	/**
	 * Return the value associated with the column: result_status
	 */
	public java.lang.String getResultStatus () {
		return resultStatus;
	}

	/**
	 * Set the value related to the column: result_status
	 * @param resultStatus the result_status value
	 */
	public void setResultStatus (java.lang.String resultStatus) {
		this.resultStatus = resultStatus;
	}



	/**
	 * Return the value associated with the column: result_time
	 */
	public java.lang.String getResultTime () {
		return resultTime;
	}

	/**
	 * Set the value related to the column: result_time
	 * @param resultTime the result_time value
	 */
	public void setResultTime (java.lang.String resultTime) {
		this.resultTime = resultTime;
	}



	/**
	 * Return the value associated with the column: result_type
	 */
	public java.lang.String getResultType () {
		return resultType;
	}

	/**
	 * Set the value related to the column: result_type
	 * @param resultType the result_type value
	 */
	public void setResultType (java.lang.String resultType) {
		this.resultType = resultType;
	}



	/**
	 * Return the value associated with the column: tempelate_id
	 */
	public java.lang.String getTempelateId () {
		return tempelateId;
	}

	/**
	 * Set the value related to the column: tempelate_id
	 * @param tempelateId the tempelate_id value
	 */
	public void setTempelateId (java.lang.String tempelateId) {
		this.tempelateId = tempelateId;
	}



	/**
	 * Return the value associated with the column: test_order_no
	 */
	public java.lang.Integer getTestOrderNo () {
		return testOrderNo;
	}

	/**
	 * Set the value related to the column: test_order_no
	 * @param testOrderNo the test_order_no value
	 */
	public void setTestOrderNo (java.lang.Integer testOrderNo) {
		this.testOrderNo = testOrderNo;
	}



	/**
	 * Return the value associated with the column: update_on
	 */
	public java.util.Date getUpdateOn () {
		return updateOn;
	}

	/**
	 * Set the value related to the column: update_on
	 * @param updateOn the update_on value
	 */
	public void setUpdateOn (java.util.Date updateOn) {
		this.updateOn = updateOn;
	}



	/**
	 * Return the value associated with the column: verified
	 */
	public java.lang.String getVerified () {
		return verified;
	}

	/**
	 * Set the value related to the column: verified
	 * @param verified the verified value
	 */
	public void setVerified (java.lang.String verified) {
		this.verified = verified;
	}



	/**
	 * Return the value associated with the column: verified_on
	 */
	public java.util.Date getVerifiedOn () {
		return verifiedOn;
	}

	/**
	 * Set the value related to the column: verified_on
	 * @param verifiedOn the verified_on value
	 */
	public void setVerifiedOn (java.util.Date verifiedOn) {
		this.verifiedOn = verifiedOn;
	}



	/**
	 * Return the value associated with the column: verified_time
	 */
	public java.lang.String getVerifiedTime () {
		return verifiedTime;
	}

	/**
	 * Set the value related to the column: verified_time
	 * @param verifiedTime the verified_time value
	 */
	public void setVerifiedTime (java.lang.String verifiedTime) {
		this.verifiedTime = verifiedTime;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getDgMasInvestigation () {
		return dgMasInvestigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param dgMasInvestigation the investigation_id value
	 */
	public void setDgMasInvestigation (jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		this.dgMasInvestigation = dgMasInvestigation;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargecode () {
		return mainChargecode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * @param mainChargecode the main_chargecode_id value
	 */
	public void setMainChargecode (jkt.hms.masters.business.MasMainChargecode mainChargecode) {
		this.mainChargecode = mainChargecode;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getMasHospital () {
		return masHospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param masHospital the hospital_id value
	 */
	public void setMasHospital (jkt.hms.masters.business.MasHospital masHospital) {
		this.masHospital = masHospital;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getPatient () {
		return patient;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param patient the hin_id value
	 */
	public void setPatient (jkt.hms.masters.business.Patient patient) {
		this.patient = patient;
	}



	/**
	 * Return the value associated with the column: prescribed_by
	 */
	public jkt.hms.masters.business.MasEmployee getPrescribedBy () {
		return prescribedBy;
	}

	/**
	 * Set the value related to the column: prescribed_by
	 * @param prescribedBy the prescribed_by value
	 */
	public void setPrescribedBy (jkt.hms.masters.business.MasEmployee prescribedBy) {
		this.prescribedBy = prescribedBy;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: result_updated_by
	 */
	public jkt.hms.masters.business.MasEmployee getResultUpdatedBy () {
		return resultUpdatedBy;
	}

	/**
	 * Set the value related to the column: result_updated_by
	 * @param resultUpdatedBy the result_updated_by value
	 */
	public void setResultUpdatedBy (jkt.hms.masters.business.MasEmployee resultUpdatedBy) {
		this.resultUpdatedBy = resultUpdatedBy;
	}



	/**
	 * Return the value associated with the column: result_verified_by
	 */
	public jkt.hms.masters.business.MasEmployee getResultVerifiedBy () {
		return resultVerifiedBy;
	}

	/**
	 * Set the value related to the column: result_verified_by
	 * @param resultVerifiedBy the result_verified_by value
	 */
	public void setResultVerifiedBy (jkt.hms.masters.business.MasEmployee resultVerifiedBy) {
		this.resultVerifiedBy = resultVerifiedBy;
	}



	/**
	 * Return the value associated with the column: sample_collection_header_id
	 */
	public jkt.hms.masters.business.DgSampleCollectionHeader getSampleCollectionHeader () {
		return sampleCollectionHeader;
	}

	/**
	 * Set the value related to the column: sample_collection_header_id
	 * @param sampleCollectionHeader the sample_collection_header_id value
	 */
	public void setSampleCollectionHeader (jkt.hms.masters.business.DgSampleCollectionHeader sampleCollectionHeader) {
		this.sampleCollectionHeader = sampleCollectionHeader;
	}



	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargecode () {
		return subChargecode;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * @param subChargecode the sub_chargecode_id value
	 */
	public void setSubChargecode (jkt.hms.masters.business.MasSubChargecode subChargecode) {
		this.subChargecode = subChargecode;
	}



	/**
	 * Return the value associated with the column: DgResultEntryDetailSen
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> getDgResultEntryDetailSen () {
		return dgResultEntryDetailSen;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetailSen
	 * @param dgResultEntryDetailSen the DgResultEntryDetailSen value
	 */
	public void setDgResultEntryDetailSen (java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> dgResultEntryDetailSen) {
		this.dgResultEntryDetailSen = dgResultEntryDetailSen;
	}

	public void addToDgResultEntryDetailSen (jkt.hms.masters.business.DgResultEntryDetailSen dgResultEntryDetailSen) {
		if (null == getDgResultEntryDetailSen()) setDgResultEntryDetailSen(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetailSen>());
		getDgResultEntryDetailSen().add(dgResultEntryDetailSen);
	}



	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails () {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * @param dgResultEntryDetails the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails (java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails (jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails()) setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgResultEntryHeader)) return false;
		else {
			jkt.hms.masters.business.DgResultEntryHeader dgResultEntryHeader = (jkt.hms.masters.business.DgResultEntryHeader) obj;
			if (null == this.getId() || null == dgResultEntryHeader.getId()) return false;
			else return (this.getId().equals(dgResultEntryHeader.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}