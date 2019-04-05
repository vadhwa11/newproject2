package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hrorderly_classification_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hrorderly_classification_master"
 */

public abstract class BaseHrorderlyClassificationMaster  implements Serializable {

	public static String REF = "HrorderlyClassificationMaster";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_CLASSIFICATION_CODE = "ClassificationCode";
	public static String PROP_CLASSIFICATION_NAME = "ClassificationName";
	public static String PROP_ID = "Id";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";


	// constructors
	public BaseHrorderlyClassificationMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrorderlyClassificationMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String classificationCode;
	private java.lang.String classificationName;
	private java.lang.String lstChangedBy;
	private java.lang.String lstChangedTime;
	private java.util.Date lstChangedDate;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.HrUpdateArrival> hrUpdateArrivals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="classification_id"
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
	 * Return the value associated with the column: classification_code
	 */
	public java.lang.String getClassificationCode () {
		return classificationCode;
	}

	/**
	 * Set the value related to the column: classification_code
	 * @param classificationCode the classification_code value
	 */
	public void setClassificationCode (java.lang.String classificationCode) {
		this.classificationCode = classificationCode;
	}



	/**
	 * Return the value associated with the column: classification_name
	 */
	public java.lang.String getClassificationName () {
		return classificationName;
	}

	/**
	 * Set the value related to the column: classification_name
	 * @param classificationName the classification_name value
	 */
	public void setClassificationName (java.lang.String classificationName) {
		this.classificationName = classificationName;
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



	/**
	 * Return the value associated with the column: HrUpdateArrivals
	 */
	public java.util.Set<jkt.hms.masters.business.HrUpdateArrival> getHrUpdateArrivals () {
		return hrUpdateArrivals;
	}

	/**
	 * Set the value related to the column: HrUpdateArrivals
	 * @param hrUpdateArrivals the HrUpdateArrivals value
	 */
	public void setHrUpdateArrivals (java.util.Set<jkt.hms.masters.business.HrUpdateArrival> hrUpdateArrivals) {
		this.hrUpdateArrivals = hrUpdateArrivals;
	}

	public void addToHrUpdateArrivals (jkt.hms.masters.business.HrUpdateArrival hrUpdateArrival) {
		if (null == getHrUpdateArrivals()) setHrUpdateArrivals(new java.util.TreeSet<jkt.hms.masters.business.HrUpdateArrival>());
		getHrUpdateArrivals().add(hrUpdateArrival);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrorderlyClassificationMaster)) return false;
		else {
			jkt.hms.masters.business.HrorderlyClassificationMaster hrorderlyClassificationMaster = (jkt.hms.masters.business.HrorderlyClassificationMaster) obj;
			if (null == this.getId() || null == hrorderlyClassificationMaster.getId()) return false;
			else return (this.getId().equals(hrorderlyClassificationMaster.getId()));
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