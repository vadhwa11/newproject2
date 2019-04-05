package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_CHILD_MILESTONE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_CHILD_MILESTONE"
 */

public abstract class BaseMasChildMilestone  implements Serializable {

	public static String REF = "MasChildMilestone";
	public static String PROP_STATUS = "Status";
	public static String PROP_MILESTONE_CODE = "MilestoneCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_NORMAL_AGE_RANGE = "NormalAgeRange";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MILESTONE_NAME = "MilestoneName";


	// constructors
	public BaseMasChildMilestone () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasChildMilestone (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String milestoneCode;
	private java.lang.String milestoneName;
	private java.lang.String normalAgeRange;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="MILESTONE_ID"
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
	 * Return the value associated with the column: MILESTONE_CODE
	 */
	public java.lang.String getMilestoneCode () {
		return milestoneCode;
	}

	/**
	 * Set the value related to the column: MILESTONE_CODE
	 * @param milestoneCode the MILESTONE_CODE value
	 */
	public void setMilestoneCode (java.lang.String milestoneCode) {
		this.milestoneCode = milestoneCode;
	}



	/**
	 * Return the value associated with the column: MILESTONE_NAME
	 */
	public java.lang.String getMilestoneName () {
		return milestoneName;
	}

	/**
	 * Set the value related to the column: MILESTONE_NAME
	 * @param milestoneName the MILESTONE_NAME value
	 */
	public void setMilestoneName (java.lang.String milestoneName) {
		this.milestoneName = milestoneName;
	}



	/**
	 * Return the value associated with the column: NORMAL_AGE_RANGE
	 */
	public java.lang.String getNormalAgeRange () {
		return normalAgeRange;
	}

	/**
	 * Set the value related to the column: NORMAL_AGE_RANGE
	 * @param normalAgeRange the NORMAL_AGE_RANGE value
	 */
	public void setNormalAgeRange (java.lang.String normalAgeRange) {
		this.normalAgeRange = normalAgeRange;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasChildMilestone)) return false;
		else {
			jkt.hms.masters.business.MasChildMilestone masChildMilestone = (jkt.hms.masters.business.MasChildMilestone) obj;
			if (null == this.getId() || null == masChildMilestone.getId()) return false;
			else return (this.getId().equals(masChildMilestone.getId()));
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