package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ot_anesthesiologist
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_anesthesiologist"
 */

public abstract class BaseOtAnesthesiologist implements Serializable {

	public static String REF = "OtAnesthesiologist";
	public static String PROP_LAST_CHGD_TIME = "LastChgdTime";
	public static String PROP_OT = "Ot";
	public static String PROP_ANES1_ID = "Anes1Id";
	public static String PROP_LAST_CHGD_DATE = "LastChgdDate";
	public static String PROP_ANES2_ID = "Anes2Id";
	public static String PROP_PAC = "Pac";
	public static String PROP_SURGERY_DATE = "SurgeryDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHGD_BY = "LastChgdBy";

	// constructors
	public BaseOtAnesthesiologist() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtAnesthesiologist(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date surgeryDate;
	private java.lang.String pac;
	private java.lang.String lastChgdBy;
	private java.util.Date lastChgdDate;
	private java.lang.String lastChgdTime;

	// many to one
	private jkt.hms.masters.business.MasOt ot;
	private jkt.hms.masters.business.MasEmployee anes1Id;
	private jkt.hms.masters.business.MasEmployee anes2Id;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="anes_id"
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
	 * Return the value associated with the column: surgery_date
	 */
	public java.util.Date getSurgeryDate() {
		return surgeryDate;
	}

	/**
	 * Set the value related to the column: surgery_date
	 * 
	 * @param surgeryDate
	 *            the surgery_date value
	 */
	public void setSurgeryDate(java.util.Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}

	/**
	 * Return the value associated with the column: pac
	 */
	public java.lang.String getPac() {
		return pac;
	}

	/**
	 * Set the value related to the column: pac
	 * 
	 * @param pac
	 *            the pac value
	 */
	public void setPac(java.lang.String pac) {
		this.pac = pac;
	}

	/**
	 * Return the value associated with the column: last_chgd_by
	 */
	public java.lang.String getLastChgdBy() {
		return lastChgdBy;
	}

	/**
	 * Set the value related to the column: last_chgd_by
	 * 
	 * @param lastChgdBy
	 *            the last_chgd_by value
	 */
	public void setLastChgdBy(java.lang.String lastChgdBy) {
		this.lastChgdBy = lastChgdBy;
	}

	/**
	 * Return the value associated with the column: last_chgd_date
	 */
	public java.util.Date getLastChgdDate() {
		return lastChgdDate;
	}

	/**
	 * Set the value related to the column: last_chgd_date
	 * 
	 * @param lastChgdDate
	 *            the last_chgd_date value
	 */
	public void setLastChgdDate(java.util.Date lastChgdDate) {
		this.lastChgdDate = lastChgdDate;
	}

	/**
	 * Return the value associated with the column: last_chgd_time
	 */
	public java.lang.String getLastChgdTime() {
		return lastChgdTime;
	}

	/**
	 * Set the value related to the column: last_chgd_time
	 * 
	 * @param lastChgdTime
	 *            the last_chgd_time value
	 */
	public void setLastChgdTime(java.lang.String lastChgdTime) {
		this.lastChgdTime = lastChgdTime;
	}

	/**
	 * Return the value associated with the column: ot_id
	 */
	public jkt.hms.masters.business.MasOt getOt() {
		return ot;
	}

	/**
	 * Set the value related to the column: ot_id
	 * 
	 * @param ot
	 *            the ot_id value
	 */
	public void setOt(jkt.hms.masters.business.MasOt ot) {
		this.ot = ot;
	}

	/**
	 * Return the value associated with the column: anes1_id
	 */
	public jkt.hms.masters.business.MasEmployee getAnes1Id() {
		return anes1Id;
	}

	/**
	 * Set the value related to the column: anes1_id
	 * 
	 * @param anes1Id
	 *            the anes1_id value
	 */
	public void setAnes1Id(jkt.hms.masters.business.MasEmployee anes1Id) {
		this.anes1Id = anes1Id;
	}

	/**
	 * Return the value associated with the column: anes2_id
	 */
	public jkt.hms.masters.business.MasEmployee getAnes2Id() {
		return anes2Id;
	}

	/**
	 * Set the value related to the column: anes2_id
	 * 
	 * @param anes2Id
	 *            the anes2_id value
	 */
	public void setAnes2Id(jkt.hms.masters.business.MasEmployee anes2Id) {
		this.anes2Id = anes2Id;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtAnesthesiologist))
			return false;
		else {
			jkt.hms.masters.business.OtAnesthesiologist otAnesthesiologist = (jkt.hms.masters.business.OtAnesthesiologist) obj;
			if (null == this.getId() || null == otAnesthesiologist.getId())
				return false;
			else
				return (this.getId().equals(otAnesthesiologist.getId()));
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