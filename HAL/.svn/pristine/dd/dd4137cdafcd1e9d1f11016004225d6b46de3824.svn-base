package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_MEDICINE_RETURN_M table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_MEDICINE_RETURN_M"
 */

public abstract class BaseStoreMedicineReturnM  implements Serializable {

	public static String REF = "StoreMedicineReturnM";
	public static String PROP_STATUS = "Status";
	public static String PROP_RELATION_NAME = "RelationName";
	public static String PROP_RETURN_DATE = "ReturnDate";
	public static String PROP_MO = "Mo";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_RANK = "Rank";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_RETURN_NO = "ReturnNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";


	// constructors
	public BaseStoreMedicineReturnM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMedicineReturnM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String returnNo;
	private java.util.Date returnDate;
	private java.lang.String patientName;
	private java.lang.String rank;
	private java.lang.String serviceNo;
	private java.lang.String mo;
	private java.lang.String relationName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasDepartment department;



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
	 * Return the value associated with the column: RETURN_NO
	 */
	public java.lang.String getReturnNo () {
		return returnNo;
	}

	/**
	 * Set the value related to the column: RETURN_NO
	 * @param returnNo the RETURN_NO value
	 */
	public void setReturnNo (java.lang.String returnNo) {
		this.returnNo = returnNo;
	}



	/**
	 * Return the value associated with the column: RETURN_DATE
	 */
	public java.util.Date getReturnDate () {
		return returnDate;
	}

	/**
	 * Set the value related to the column: RETURN_DATE
	 * @param returnDate the RETURN_DATE value
	 */
	public void setReturnDate (java.util.Date returnDate) {
		this.returnDate = returnDate;
	}



	/**
	 * Return the value associated with the column: PATIENT_NAME
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: PATIENT_NAME
	 * @param patientName the PATIENT_NAME value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: RANK
	 */
	public java.lang.String getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK
	 * @param rank the RANK value
	 */
	public void setRank (java.lang.String rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: MO
	 */
	public java.lang.String getMo () {
		return mo;
	}

	/**
	 * Set the value related to the column: MO
	 * @param mo the MO value
	 */
	public void setMo (java.lang.String mo) {
		this.mo = mo;
	}



	/**
	 * Return the value associated with the column: RELATION_NAME
	 */
	public java.lang.String getRelationName () {
		return relationName;
	}

	/**
	 * Set the value related to the column: RELATION_NAME
	 * @param relationName the RELATION_NAME value
	 */
	public void setRelationName (java.lang.String relationName) {
		this.relationName = relationName;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: DEPT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPT_ID
	 * @param department the DEPT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMedicineReturnM)) return false;
		else {
			jkt.hms.masters.business.StoreMedicineReturnM storeMedicineReturnM = (jkt.hms.masters.business.StoreMedicineReturnM) obj;
			if (null == this.getId() || null == storeMedicineReturnM.getId()) return false;
			else return (this.getId().equals(storeMedicineReturnM.getId()));
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