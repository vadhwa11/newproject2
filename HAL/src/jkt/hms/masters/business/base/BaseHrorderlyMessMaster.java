package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hrorderly_mess_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hrorderly_mess_master"
 */

public abstract class BaseHrorderlyMessMaster  implements Serializable {

	public static String REF = "HrorderlyMessMaster";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_MESS_CODE = "MessCode";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_MESS_NAME = "MessName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";


	// constructors
	public BaseHrorderlyMessMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrorderlyMessMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String messCode;
	private java.lang.String messName;
	private java.lang.String lstChangedBy;
	private java.lang.String lstChangedTime;
	private java.util.Date lstChangedDate;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasUnit unitId;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="mess_id"
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
	 * Return the value associated with the column: mess_code
	 */
	public java.lang.String getMessCode () {
		return messCode;
	}

	/**
	 * Set the value related to the column: mess_code
	 * @param messCode the mess_code value
	 */
	public void setMessCode (java.lang.String messCode) {
		this.messCode = messCode;
	}



	/**
	 * Return the value associated with the column: mess_name
	 */
	public java.lang.String getMessName () {
		return messName;
	}

	/**
	 * Set the value related to the column: mess_name
	 * @param messName the mess_name value
	 */
	public void setMessName (java.lang.String messName) {
		this.messName = messName;
	}



	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy () {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * @param lstChangedBy the lst_changed_by value
	 */
	public void setLstChangedBy (java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}



	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime () {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * @param lstChangedTime the lst_changed_time value
	 */
	public void setLstChangedTime (java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
	}



	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate () {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * @param lstChangedDate the lst_changed_date value
	 */
	public void setLstChangedDate (java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unitId the unit_id value
	 */
	public void setUnitId (jkt.hms.masters.business.MasUnit unitId) {
		this.unitId = unitId;
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
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrorderlyMessMaster)) return false;
		else {
			jkt.hms.masters.business.HrorderlyMessMaster hrorderlyMessMaster = (jkt.hms.masters.business.HrorderlyMessMaster) obj;
			if (null == this.getId() || null == hrorderlyMessMaster.getId()) return false;
			else return (this.getId().equals(hrorderlyMessMaster.getId()));
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