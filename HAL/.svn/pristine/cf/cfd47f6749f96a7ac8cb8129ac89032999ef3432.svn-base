package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_transfussion_reaction_hd table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="blood_transfussion_reaction_hd"
 */

public abstract class BaseBloodTransfussionReactionHd implements Serializable {

	public static String REF = "BloodTransfussionReactionHd";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAJOR_DS = "MajorDs";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_CROSS_MATCH_BY = "CrossMatchBy";
	public static String PROP_MAJOR_RS = "MajorRs";
	public static String PROP_REACTION = "Reaction";
	public static String PROP_TEST_BY = "TestBy";
	public static String PROP_TEST_DATE = "TestDate";
	public static String PROP_TEST_NO = "TestNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_COMPATIBILITY = "Compatibility";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodTransfussionReactionHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodTransfussionReactionHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date testDate;
	private java.lang.Integer testNo;
	private java.lang.String majorRs;
	private java.lang.String majorDs;
	private java.lang.String compatibility;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee crossMatchBy;
	private jkt.hms.masters.business.BloodReactionEntry reaction;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee testBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodTransfussionReactionDt> bloodTransfussionReactionDts;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: test_date
	 */
	public java.util.Date getTestDate() {
		return testDate;
	}

	/**
	 * Set the value related to the column: test_date
	 * 
	 * @param testDate
	 *            the test_date value
	 */
	public void setTestDate(java.util.Date testDate) {
		this.testDate = testDate;
	}

	/**
	 * Return the value associated with the column: test_no
	 */
	public java.lang.Integer getTestNo() {
		return testNo;
	}

	/**
	 * Set the value related to the column: test_no
	 * 
	 * @param testNo
	 *            the test_no value
	 */
	public void setTestNo(java.lang.Integer testNo) {
		this.testNo = testNo;
	}

	/**
	 * Return the value associated with the column: major_rs
	 */
	public java.lang.String getMajorRs() {
		return majorRs;
	}

	/**
	 * Set the value related to the column: major_rs
	 * 
	 * @param majorRs
	 *            the major_rs value
	 */
	public void setMajorRs(java.lang.String majorRs) {
		this.majorRs = majorRs;
	}

	/**
	 * Return the value associated with the column: major_ds
	 */
	public java.lang.String getMajorDs() {
		return majorDs;
	}

	/**
	 * Set the value related to the column: major_ds
	 * 
	 * @param majorDs
	 *            the major_ds value
	 */
	public void setMajorDs(java.lang.String majorDs) {
		this.majorDs = majorDs;
	}

	/**
	 * Return the value associated with the column: compatibility
	 */
	public java.lang.String getCompatibility() {
		return compatibility;
	}

	/**
	 * Set the value related to the column: compatibility
	 * 
	 * @param compatibility
	 *            the compatibility value
	 */
	public void setCompatibility(java.lang.String compatibility) {
		this.compatibility = compatibility;
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
	 * Return the value associated with the column: cross_match_by
	 */
	public jkt.hms.masters.business.MasEmployee getCrossMatchBy() {
		return crossMatchBy;
	}

	/**
	 * Set the value related to the column: cross_match_by
	 * 
	 * @param crossMatchBy
	 *            the cross_match_by value
	 */
	public void setCrossMatchBy(
			jkt.hms.masters.business.MasEmployee crossMatchBy) {
		this.crossMatchBy = crossMatchBy;
	}

	/**
	 * Return the value associated with the column: reaction_id
	 */
	public jkt.hms.masters.business.BloodReactionEntry getReaction() {
		return reaction;
	}

	/**
	 * Set the value related to the column: reaction_id
	 * 
	 * @param reaction
	 *            the reaction_id value
	 */
	public void setReaction(jkt.hms.masters.business.BloodReactionEntry reaction) {
		this.reaction = reaction;
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
	 * Return the value associated with the column: test_by
	 */
	public jkt.hms.masters.business.MasEmployee getTestBy() {
		return testBy;
	}

	/**
	 * Set the value related to the column: test_by
	 * 
	 * @param testBy
	 *            the test_by value
	 */
	public void setTestBy(jkt.hms.masters.business.MasEmployee testBy) {
		this.testBy = testBy;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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

	/**
	 * Return the value associated with the column: BloodTransfussionReactionDts
	 */
	public java.util.Set<jkt.hms.masters.business.BloodTransfussionReactionDt> getBloodTransfussionReactionDts() {
		return bloodTransfussionReactionDts;
	}

	/**
	 * Set the value related to the column: BloodTransfussionReactionDts
	 * 
	 * @param bloodTransfussionReactionDts
	 *            the BloodTransfussionReactionDts value
	 */
	public void setBloodTransfussionReactionDts(
			java.util.Set<jkt.hms.masters.business.BloodTransfussionReactionDt> bloodTransfussionReactionDts) {
		this.bloodTransfussionReactionDts = bloodTransfussionReactionDts;
	}

	public void addToBloodTransfussionReactionDts(
			jkt.hms.masters.business.BloodTransfussionReactionDt bloodTransfussionReactionDt) {
		if (null == getBloodTransfussionReactionDts())
			setBloodTransfussionReactionDts(new java.util.TreeSet<jkt.hms.masters.business.BloodTransfussionReactionDt>());
		getBloodTransfussionReactionDts().add(bloodTransfussionReactionDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodTransfussionReactionHd))
			return false;
		else {
			jkt.hms.masters.business.BloodTransfussionReactionHd bloodTransfussionReactionHd = (jkt.hms.masters.business.BloodTransfussionReactionHd) obj;
			if (null == this.getId()
					|| null == bloodTransfussionReactionHd.getId())
				return false;
			else
				return (this.getId()
						.equals(bloodTransfussionReactionHd.getId()));
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