package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AUTOMATIC_BLEACHING_ENTRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AUTOMATIC_BLEACHING_ENTRY"
 */

public abstract class BaseAutomaticBleachingEntry  implements Serializable {

	public static String REF = "AutomaticBleachingEntry";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_NO_BP_DOSER_INSTALLED = "NoBpDoserInstalled";
	public static String PROP_NO_MECHANICAL_DEFECT = "NoMechanicalDefect";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_NO_INSTALLED = "NoInstalled";
	public static String PROP_NO_CHLORINE_GAS = "NoChlorineGas";
	public static String PROP_CHLOROFORM_ENTRY_DATE = "ChloroformEntryDate";
	public static String PROP_NO_AUTHORISED = "NoAuthorised";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_NO_BP_DOSER_US = "NoBpDoserUs";
	public static String PROP_NO_CYLINDER = "NoCylinder";


	// constructors
	public BaseAutomaticBleachingEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAutomaticBleachingEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String noAuthorised;
	private java.lang.String noInstalled;
	private java.lang.String noMechanicalDefect;
	private java.lang.String noChlorineGas;
	private java.lang.String noCylinder;
	private java.lang.String noBpDoserInstalled;
	private java.lang.String noBpDoserUs;
	private java.lang.String actionTaken;
	private java.lang.String remarks;
	private java.util.Date chloroformEntryDate;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



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
	 * Return the value associated with the column: NO_AUTHORISED
	 */
	public java.lang.String getNoAuthorised () {
		return noAuthorised;
	}

	/**
	 * Set the value related to the column: NO_AUTHORISED
	 * @param noAuthorised the NO_AUTHORISED value
	 */
	public void setNoAuthorised (java.lang.String noAuthorised) {
		this.noAuthorised = noAuthorised;
	}



	/**
	 * Return the value associated with the column: NO_INSTALLED
	 */
	public java.lang.String getNoInstalled () {
		return noInstalled;
	}

	/**
	 * Set the value related to the column: NO_INSTALLED
	 * @param noInstalled the NO_INSTALLED value
	 */
	public void setNoInstalled (java.lang.String noInstalled) {
		this.noInstalled = noInstalled;
	}



	/**
	 * Return the value associated with the column: NO_MECHANICAL_DEFECT
	 */
	public java.lang.String getNoMechanicalDefect () {
		return noMechanicalDefect;
	}

	/**
	 * Set the value related to the column: NO_MECHANICAL_DEFECT
	 * @param noMechanicalDefect the NO_MECHANICAL_DEFECT value
	 */
	public void setNoMechanicalDefect (java.lang.String noMechanicalDefect) {
		this.noMechanicalDefect = noMechanicalDefect;
	}



	/**
	 * Return the value associated with the column: NO_CHLORINE_GAS
	 */
	public java.lang.String getNoChlorineGas () {
		return noChlorineGas;
	}

	/**
	 * Set the value related to the column: NO_CHLORINE_GAS
	 * @param noChlorineGas the NO_CHLORINE_GAS value
	 */
	public void setNoChlorineGas (java.lang.String noChlorineGas) {
		this.noChlorineGas = noChlorineGas;
	}



	/**
	 * Return the value associated with the column: NO_CYLINDER
	 */
	public java.lang.String getNoCylinder () {
		return noCylinder;
	}

	/**
	 * Set the value related to the column: NO_CYLINDER
	 * @param noCylinder the NO_CYLINDER value
	 */
	public void setNoCylinder (java.lang.String noCylinder) {
		this.noCylinder = noCylinder;
	}



	/**
	 * Return the value associated with the column: NO_BP_DOSER_INSTALLED
	 */
	public java.lang.String getNoBpDoserInstalled () {
		return noBpDoserInstalled;
	}

	/**
	 * Set the value related to the column: NO_BP_DOSER_INSTALLED
	 * @param noBpDoserInstalled the NO_BP_DOSER_INSTALLED value
	 */
	public void setNoBpDoserInstalled (java.lang.String noBpDoserInstalled) {
		this.noBpDoserInstalled = noBpDoserInstalled;
	}



	/**
	 * Return the value associated with the column: NO_BP_DOSER_US
	 */
	public java.lang.String getNoBpDoserUs () {
		return noBpDoserUs;
	}

	/**
	 * Set the value related to the column: NO_BP_DOSER_US
	 * @param noBpDoserUs the NO_BP_DOSER_US value
	 */
	public void setNoBpDoserUs (java.lang.String noBpDoserUs) {
		this.noBpDoserUs = noBpDoserUs;
	}



	/**
	 * Return the value associated with the column: ACTION_TAKEN
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: ACTION_TAKEN
	 * @param actionTaken the ACTION_TAKEN value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: CHLOROFORM_ENTRY_DATE
	 */
	public java.util.Date getChloroformEntryDate () {
		return chloroformEntryDate;
	}

	/**
	 * Set the value related to the column: CHLOROFORM_ENTRY_DATE
	 * @param chloroformEntryDate the CHLOROFORM_ENTRY_DATE value
	 */
	public void setChloroformEntryDate (java.util.Date chloroformEntryDate) {
		this.chloroformEntryDate = chloroformEntryDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AutomaticBleachingEntry)) return false;
		else {
			jkt.hms.masters.business.AutomaticBleachingEntry automaticBleachingEntry = (jkt.hms.masters.business.AutomaticBleachingEntry) obj;
			if (null == this.getId() || null == automaticBleachingEntry.getId()) return false;
			else return (this.getId().equals(automaticBleachingEntry.getId()));
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