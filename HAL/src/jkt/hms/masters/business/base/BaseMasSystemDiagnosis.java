package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_SYSTEM_DIAGNOSIS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_SYSTEM_DIAGNOSIS"
 */

public abstract class BaseMasSystemDiagnosis  implements Serializable {

	public static String REF = "MasSystemDiagnosis";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SYSTEM_DIAGNOSIS_NAME = "SystemDiagnosisName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SYSTEM_DIAGNOSIS_CODE = "SystemDiagnosisCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_GROUP_ID = "GroupId";


	// constructors
	public BaseMasSystemDiagnosis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSystemDiagnosis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String systemDiagnosisCode;
	private java.lang.String systemDiagnosisName;
	private java.lang.Integer groupId;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="SYSTEM_DIAGNOSIS_ID"
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
	 * Return the value associated with the column: SYSTEM_DIAGNOSIS_CODE
	 */
	public java.lang.String getSystemDiagnosisCode () {
		return systemDiagnosisCode;
	}

	/**
	 * Set the value related to the column: SYSTEM_DIAGNOSIS_CODE
	 * @param systemDiagnosisCode the SYSTEM_DIAGNOSIS_CODE value
	 */
	public void setSystemDiagnosisCode (java.lang.String systemDiagnosisCode) {
		this.systemDiagnosisCode = systemDiagnosisCode;
	}



	/**
	 * Return the value associated with the column: SYSTEM_DIAGNOSIS_NAME
	 */
	public java.lang.String getSystemDiagnosisName () {
		return systemDiagnosisName;
	}

	/**
	 * Set the value related to the column: SYSTEM_DIAGNOSIS_NAME
	 * @param systemDiagnosisName the SYSTEM_DIAGNOSIS_NAME value
	 */
	public void setSystemDiagnosisName (java.lang.String systemDiagnosisName) {
		this.systemDiagnosisName = systemDiagnosisName;
	}



	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public java.lang.Integer getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param groupId the GROUP_ID value
	 */
	public void setGroupId (java.lang.Integer groupId) {
		this.groupId = groupId;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSystemDiagnosis)) return false;
		else {
			jkt.hms.masters.business.MasSystemDiagnosis masSystemDiagnosis = (jkt.hms.masters.business.MasSystemDiagnosis) obj;
			if (null == this.getId() || null == masSystemDiagnosis.getId()) return false;
			else return (this.getId().equals(masSystemDiagnosis.getId()));
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