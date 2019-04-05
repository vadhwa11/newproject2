package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HEALTH_PROMOTION_ACTIVITY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HEALTH_PROMOTION_ACTIVITY"
 */

public abstract class BaseHealthPromotionActivity  implements Serializable {

	public static String REF = "HealthPromotionActivity";
	public static String PROP_SUBJECT = "Subject";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_HEALTH_PROMOTION_TOPIC = "HealthPromotionTopic";
	public static String PROP_HEALTH_PROMOTION_DATE = "HealthPromotionDate";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";
	public static String PROP_HEALTH_PROMOTION_REMARK = "HealthPromotionRemark";
	public static String PROP_RANK_CATEGORY = "RankCategory";
	public static String PROP_HEALTH_PROMOTION_ATTENDED = "HealthPromotionAttended";
	public static String PROP_ID = "Id";
	public static String PROP_HEALTH_PROMOTION_PLACE = "HealthPromotionPlace";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";


	// constructors
	public BaseHealthPromotionActivity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHealthPromotionActivity (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date healthPromotionDate;
	private java.lang.String healthPromotionTopic;
	private java.lang.String healthPromotionPlace;
	private java.lang.String healthPromotionAttended;
	private java.lang.String healthPromotionRemark;
	private java.lang.String lastChangeBy;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;
	private java.lang.String subject;
	private java.lang.String rankCategory;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="HEALTH_PROMOTION_ID"
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
	 * Return the value associated with the column: HEALTH_PROMOTION_DATE
	 */
	public java.util.Date getHealthPromotionDate () {
		return healthPromotionDate;
	}

	/**
	 * Set the value related to the column: HEALTH_PROMOTION_DATE
	 * @param healthPromotionDate the HEALTH_PROMOTION_DATE value
	 */
	public void setHealthPromotionDate (java.util.Date healthPromotionDate) {
		this.healthPromotionDate = healthPromotionDate;
	}



	/**
	 * Return the value associated with the column: HEALTH_PROMOTION_TOPIC
	 */
	public java.lang.String getHealthPromotionTopic () {
		return healthPromotionTopic;
	}

	/**
	 * Set the value related to the column: HEALTH_PROMOTION_TOPIC
	 * @param healthPromotionTopic the HEALTH_PROMOTION_TOPIC value
	 */
	public void setHealthPromotionTopic (java.lang.String healthPromotionTopic) {
		this.healthPromotionTopic = healthPromotionTopic;
	}



	/**
	 * Return the value associated with the column: HEALTH_PROMOTION_PLACE
	 */
	public java.lang.String getHealthPromotionPlace () {
		return healthPromotionPlace;
	}

	/**
	 * Set the value related to the column: HEALTH_PROMOTION_PLACE
	 * @param healthPromotionPlace the HEALTH_PROMOTION_PLACE value
	 */
	public void setHealthPromotionPlace (java.lang.String healthPromotionPlace) {
		this.healthPromotionPlace = healthPromotionPlace;
	}



	/**
	 * Return the value associated with the column: HEALTH_PROMOTION_ATTENDED
	 */
	public java.lang.String getHealthPromotionAttended () {
		return healthPromotionAttended;
	}

	/**
	 * Set the value related to the column: HEALTH_PROMOTION_ATTENDED
	 * @param healthPromotionAttended the HEALTH_PROMOTION_ATTENDED value
	 */
	public void setHealthPromotionAttended (java.lang.String healthPromotionAttended) {
		this.healthPromotionAttended = healthPromotionAttended;
	}



	/**
	 * Return the value associated with the column: HEALTH_PROMOTION_REMARK
	 */
	public java.lang.String getHealthPromotionRemark () {
		return healthPromotionRemark;
	}

	/**
	 * Set the value related to the column: HEALTH_PROMOTION_REMARK
	 * @param healthPromotionRemark the HEALTH_PROMOTION_REMARK value
	 */
	public void setHealthPromotionRemark (java.lang.String healthPromotionRemark) {
		this.healthPromotionRemark = healthPromotionRemark;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_BY
	 */
	public java.lang.String getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_BY
	 * @param lastChangeBy the LAST_CHANGE_BY value
	 */
	public void setLastChangeBy (java.lang.String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_DATE
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_DATE
	 * @param lastChangeDate the LAST_CHANGE_DATE value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_TIME
	 */
	public java.lang.String getLastChangeTime () {
		return lastChangeTime;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_TIME
	 * @param lastChangeTime the LAST_CHANGE_TIME value
	 */
	public void setLastChangeTime (java.lang.String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}



	/**
	 * Return the value associated with the column: SUBJECT
	 */
	public java.lang.String getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: SUBJECT
	 * @param subject the SUBJECT value
	 */
	public void setSubject (java.lang.String subject) {
		this.subject = subject;
	}



	/**
	 * Return the value associated with the column: RANK_CATEGORY
	 */
	public java.lang.String getRankCategory () {
		return rankCategory;
	}

	/**
	 * Set the value related to the column: RANK_CATEGORY
	 * @param rankCategory the RANK_CATEGORY value
	 */
	public void setRankCategory (java.lang.String rankCategory) {
		this.rankCategory = rankCategory;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HealthPromotionActivity)) return false;
		else {
			jkt.hms.masters.business.HealthPromotionActivity healthPromotionActivity = (jkt.hms.masters.business.HealthPromotionActivity) obj;
			if (null == this.getId() || null == healthPromotionActivity.getId()) return false;
			else return (this.getId().equals(healthPromotionActivity.getId()));
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