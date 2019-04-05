package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_oph_follow_up table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="opd_oph_follow_up"
 */

public abstract class BaseOpdOphFollowUp implements Serializable {

	public static String REF = "OpdOphFollowUp";
	public static String PROP_FUNDUS_LE = "FundusLe";
	public static String PROP_ADV = "Adv";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ANT_SEGMENT_LE = "AntSegmentLe";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_ANT_SEGMENT_RE = "AntSegmentRe";
	public static String PROP_IOP = "Iop";
	public static String PROP_FUNDUS_RE = "FundusRe";
	public static String PROP_VISIT = "Visit";
	public static String PROP_FOLLOW_UP_DATE = "FollowUpDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOphFollowUp() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOphFollowUp(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String antSegmentRe;
	private java.lang.String antSegmentLe;
	private java.lang.String iop;
	private java.lang.String fundusRe;
	private java.lang.String fundusLe;
	private java.lang.String adv;
	private java.util.Date followUpDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="oph_follow_up_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: ant_segment_re
	 */
	public java.lang.String getAntSegmentRe() {
		return antSegmentRe;
	}

	/**
	 * Set the value related to the column: ant_segment_re
	 * 
	 * @param antSegmentRe
	 *            the ant_segment_re value
	 */
	public void setAntSegmentRe(java.lang.String antSegmentRe) {
		this.antSegmentRe = antSegmentRe;
	}

	/**
	 * Return the value associated with the column: ant_segment_le
	 */
	public java.lang.String getAntSegmentLe() {
		return antSegmentLe;
	}

	/**
	 * Set the value related to the column: ant_segment_le
	 * 
	 * @param antSegmentLe
	 *            the ant_segment_le value
	 */
	public void setAntSegmentLe(java.lang.String antSegmentLe) {
		this.antSegmentLe = antSegmentLe;
	}

	/**
	 * Return the value associated with the column: iop
	 */
	public java.lang.String getIop() {
		return iop;
	}

	/**
	 * Set the value related to the column: iop
	 * 
	 * @param iop
	 *            the iop value
	 */
	public void setIop(java.lang.String iop) {
		this.iop = iop;
	}

	/**
	 * Return the value associated with the column: fundus_re
	 */
	public java.lang.String getFundusRe() {
		return fundusRe;
	}

	/**
	 * Set the value related to the column: fundus_re
	 * 
	 * @param fundusRe
	 *            the fundus_re value
	 */
	public void setFundusRe(java.lang.String fundusRe) {
		this.fundusRe = fundusRe;
	}

	/**
	 * Return the value associated with the column: fundus_le
	 */
	public java.lang.String getFundusLe() {
		return fundusLe;
	}

	/**
	 * Set the value related to the column: fundus_le
	 * 
	 * @param fundusLe
	 *            the fundus_le value
	 */
	public void setFundusLe(java.lang.String fundusLe) {
		this.fundusLe = fundusLe;
	}

	/**
	 * Return the value associated with the column: adv
	 */
	public java.lang.String getAdv() {
		return adv;
	}

	/**
	 * Set the value related to the column: adv
	 * 
	 * @param adv
	 *            the adv value
	 */
	public void setAdv(java.lang.String adv) {
		this.adv = adv;
	}

	/**
	 * Return the value associated with the column: follow_up_date
	 */
	public java.util.Date getFollowUpDate() {
		return followUpDate;
	}

	/**
	 * Set the value related to the column: follow_up_date
	 * 
	 * @param followUpDate
	 *            the follow_up_date value
	 */
	public void setFollowUpDate(java.util.Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOphFollowUp))
			return false;
		else {
			jkt.hms.masters.business.OpdOphFollowUp opdOphFollowUp = (jkt.hms.masters.business.OpdOphFollowUp) obj;
			if (null == this.getId() || null == opdOphFollowUp.getId())
				return false;
			else
				return (this.getId().equals(opdOphFollowUp.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}