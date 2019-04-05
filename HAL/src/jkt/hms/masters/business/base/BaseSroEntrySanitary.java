package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SRO_ENTRY_SANITARY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SRO_ENTRY_SANITARY"
 */

public abstract class BaseSroEntrySanitary  implements Serializable {

	public static String REF = "SroEntrySanitary";
	public static String PROP_SRO_ENTRY_REMARKS = "SroEntryRemarks";
	public static String PROP_CHECKED_BY = "CheckedBy";
	public static String PROP_SRO_ENTRY_AREA = "SroEntryArea";
	public static String PROP_SRO_ENTRY_PLACE = "SroEntryPlace";
	public static String PROP_SANITARY_ROUND = "SanitaryRound";
	public static String PROP_SRO_ENTRY_TIME = "SroEntryTime";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_SRO_ENTRY_DATE = "SroEntryDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_FORM_NAME = "FormName";
	public static String PROP_REMARK_BY_SHO = "RemarkBySho";


	// constructors
	public BaseSroEntrySanitary () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSroEntrySanitary (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date sroEntryDate;
	private java.lang.String sroEntryTime;
	private java.lang.String sanitaryRound;
	private java.lang.String sroEntryPlace;
	private java.lang.String sroEntryArea;
	private java.lang.String sroEntryRemarks;
	private java.lang.String checkedBy;
	private java.lang.String remarkBySho;
	private java.lang.String formName;

	// many to one
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasDepartment departmentId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: SRO_ENTRY_DATE
	 */
	public java.util.Date getSroEntryDate () {
		return sroEntryDate;
	}

	/**
	 * Set the value related to the column: SRO_ENTRY_DATE
	 * @param sroEntryDate the SRO_ENTRY_DATE value
	 */
	public void setSroEntryDate (java.util.Date sroEntryDate) {
		this.sroEntryDate = sroEntryDate;
	}



	/**
	 * Return the value associated with the column: SRO_ENTRY_TIME
	 */
	public java.lang.String getSroEntryTime () {
		return sroEntryTime;
	}

	/**
	 * Set the value related to the column: SRO_ENTRY_TIME
	 * @param sroEntryTime the SRO_ENTRY_TIME value
	 */
	public void setSroEntryTime (java.lang.String sroEntryTime) {
		this.sroEntryTime = sroEntryTime;
	}



	/**
	 * Return the value associated with the column: SANITARY_ROUND
	 */
	public java.lang.String getSanitaryRound () {
		return sanitaryRound;
	}

	/**
	 * Set the value related to the column: SANITARY_ROUND
	 * @param sanitaryRound the SANITARY_ROUND value
	 */
	public void setSanitaryRound (java.lang.String sanitaryRound) {
		this.sanitaryRound = sanitaryRound;
	}



	/**
	 * Return the value associated with the column: SRO_ENTRY_PLACE
	 */
	public java.lang.String getSroEntryPlace () {
		return sroEntryPlace;
	}

	/**
	 * Set the value related to the column: SRO_ENTRY_PLACE
	 * @param sroEntryPlace the SRO_ENTRY_PLACE value
	 */
	public void setSroEntryPlace (java.lang.String sroEntryPlace) {
		this.sroEntryPlace = sroEntryPlace;
	}



	/**
	 * Return the value associated with the column: SRO_ENTRY_AREA
	 */
	public java.lang.String getSroEntryArea () {
		return sroEntryArea;
	}

	/**
	 * Set the value related to the column: SRO_ENTRY_AREA
	 * @param sroEntryArea the SRO_ENTRY_AREA value
	 */
	public void setSroEntryArea (java.lang.String sroEntryArea) {
		this.sroEntryArea = sroEntryArea;
	}



	/**
	 * Return the value associated with the column: SRO_ENTRY_REMARKS
	 */
	public java.lang.String getSroEntryRemarks () {
		return sroEntryRemarks;
	}

	/**
	 * Set the value related to the column: SRO_ENTRY_REMARKS
	 * @param sroEntryRemarks the SRO_ENTRY_REMARKS value
	 */
	public void setSroEntryRemarks (java.lang.String sroEntryRemarks) {
		this.sroEntryRemarks = sroEntryRemarks;
	}



	/**
	 * Return the value associated with the column: CHECKED_BY
	 */
	public java.lang.String getCheckedBy () {
		return checkedBy;
	}

	/**
	 * Set the value related to the column: CHECKED_BY
	 * @param checkedBy the CHECKED_BY value
	 */
	public void setCheckedBy (java.lang.String checkedBy) {
		this.checkedBy = checkedBy;
	}



	/**
	 * Return the value associated with the column: REMARK_BY_SHO
	 */
	public java.lang.String getRemarkBySho () {
		return remarkBySho;
	}

	/**
	 * Set the value related to the column: REMARK_BY_SHO
	 * @param remarkBySho the REMARK_BY_SHO value
	 */
	public void setRemarkBySho (java.lang.String remarkBySho) {
		this.remarkBySho = remarkBySho;
	}



	/**
	 * Return the value associated with the column: FORM_NAME
	 */
	public java.lang.String getFormName () {
		return formName;
	}

	/**
	 * Set the value related to the column: FORM_NAME
	 * @param formName the FORM_NAME value
	 */
	public void setFormName (java.lang.String formName) {
		this.formName = formName;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SroEntrySanitary)) return false;
		else {
			jkt.hms.masters.business.SroEntrySanitary sroEntrySanitary = (jkt.hms.masters.business.SroEntrySanitary) obj;
			if (null == this.getId() || null == sroEntrySanitary.getId()) return false;
			else return (this.getId().equals(sroEntrySanitary.getId()));
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