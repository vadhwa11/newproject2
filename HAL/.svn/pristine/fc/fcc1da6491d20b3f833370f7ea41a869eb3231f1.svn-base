package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_SAMPLE_TESTING_ENTRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_SAMPLE_TESTING_ENTRY"
 */

public abstract class BaseStoreSampleTestingEntry  implements Serializable {

	public static String REF = "StoreSampleTestingEntry";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_DETAILS = "PatientDetails";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PATIENT_REACTION = "PatientReaction";
	public static String PROP_DEFECTIVE_DATE = "DefectiveDate";
	public static String PROP_DEFECT_TYPE = "DefectType";
	public static String PROP_DEFECT_NO = "DefectNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_SAMPLE_SENT_ON = "SampleSentOn";


	// constructors
	public BaseStoreSampleTestingEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreSampleTestingEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreSampleTestingEntry (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String defectNo,
		java.util.Date defectiveDate,
		java.util.Date sampleSentOn) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setDefectNo(defectNo);
		this.setDefectiveDate(defectiveDate);
		this.setSampleSentOn(sampleSentOn);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String defectNo;
	private java.util.Date defectiveDate;
	private java.lang.String defectType;
	private java.lang.String patientDetails;
	private java.lang.String patientReaction;
	private java.util.Date sampleSentOn;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreSampleTestingDetail> storeSampleTestingDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: DEFECT_NO
	 */
	public java.lang.String getDefectNo () {
		return defectNo;
	}

	/**
	 * Set the value related to the column: DEFECT_NO
	 * @param defectNo the DEFECT_NO value
	 */
	public void setDefectNo (java.lang.String defectNo) {
		this.defectNo = defectNo;
	}



	/**
	 * Return the value associated with the column: DEFECTIVE_DATE
	 */
	public java.util.Date getDefectiveDate () {
		return defectiveDate;
	}

	/**
	 * Set the value related to the column: DEFECTIVE_DATE
	 * @param defectiveDate the DEFECTIVE_DATE value
	 */
	public void setDefectiveDate (java.util.Date defectiveDate) {
		this.defectiveDate = defectiveDate;
	}



	/**
	 * Return the value associated with the column: DEFECT_TYPE
	 */
	public java.lang.String getDefectType () {
		return defectType;
	}

	/**
	 * Set the value related to the column: DEFECT_TYPE
	 * @param defectType the DEFECT_TYPE value
	 */
	public void setDefectType (java.lang.String defectType) {
		this.defectType = defectType;
	}



	/**
	 * Return the value associated with the column: PATIENT_DETAILS
	 */
	public java.lang.String getPatientDetails () {
		return patientDetails;
	}

	/**
	 * Set the value related to the column: PATIENT_DETAILS
	 * @param patientDetails the PATIENT_DETAILS value
	 */
	public void setPatientDetails (java.lang.String patientDetails) {
		this.patientDetails = patientDetails;
	}



	/**
	 * Return the value associated with the column: PATIENT_REACTION
	 */
	public java.lang.String getPatientReaction () {
		return patientReaction;
	}

	/**
	 * Set the value related to the column: PATIENT_REACTION
	 * @param patientReaction the PATIENT_REACTION value
	 */
	public void setPatientReaction (java.lang.String patientReaction) {
		this.patientReaction = patientReaction;
	}



	/**
	 * Return the value associated with the column: SAMPLE_SENT_ON
	 */
	public java.util.Date getSampleSentOn () {
		return sampleSentOn;
	}

	/**
	 * Set the value related to the column: SAMPLE_SENT_ON
	 * @param sampleSentOn the SAMPLE_SENT_ON value
	 */
	public void setSampleSentOn (java.util.Date sampleSentOn) {
		this.sampleSentOn = sampleSentOn;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: StoreSampleTestingDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSampleTestingDetail> getStoreSampleTestingDetails () {
		return storeSampleTestingDetails;
	}

	/**
	 * Set the value related to the column: StoreSampleTestingDetails
	 * @param storeSampleTestingDetails the StoreSampleTestingDetails value
	 */
	public void setStoreSampleTestingDetails (java.util.Set<jkt.hms.masters.business.StoreSampleTestingDetail> storeSampleTestingDetails) {
		this.storeSampleTestingDetails = storeSampleTestingDetails;
	}

	public void addToStoreSampleTestingDetails (jkt.hms.masters.business.StoreSampleTestingDetail storeSampleTestingDetail) {
		if (null == getStoreSampleTestingDetails()) setStoreSampleTestingDetails(new java.util.TreeSet<jkt.hms.masters.business.StoreSampleTestingDetail>());
		getStoreSampleTestingDetails().add(storeSampleTestingDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreSampleTestingEntry)) return false;
		else {
			jkt.hms.masters.business.StoreSampleTestingEntry storeSampleTestingEntry = (jkt.hms.masters.business.StoreSampleTestingEntry) obj;
			if (null == this.getId() || null == storeSampleTestingEntry.getId()) return false;
			else return (this.getId().equals(storeSampleTestingEntry.getId()));
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