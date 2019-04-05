package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_parameter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_parameter"
 */

public abstract class BaseBlParameter  implements Serializable {

	public static String REF = "BlParameter";
	public static String PROP_BILL_TYPE = "BillType";
	public static String PROP_SEQ_NO = "SeqNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CRITERIA = "Criteria";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BILL_SUB_TYPE = "BillSubType";


	// constructors
	public BaseBlParameter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlParameter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer seqNo;
	private java.lang.String billType;
	private java.lang.String billSubType;
	private java.lang.String criteria;
	private java.lang.String prefix;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="bl_param_id"
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
	 * Return the value associated with the column: seq_no
	 */
	public java.lang.Integer getSeqNo () {
		return seqNo;
	}

	/**
	 * Set the value related to the column: seq_no
	 * @param seqNo the seq_no value
	 */
	public void setSeqNo (java.lang.Integer seqNo) {
		this.seqNo = seqNo;
	}



	/**
	 * Return the value associated with the column: bill_type
	 */
	public java.lang.String getBillType () {
		return billType;
	}

	/**
	 * Set the value related to the column: bill_type
	 * @param billType the bill_type value
	 */
	public void setBillType (java.lang.String billType) {
		this.billType = billType;
	}



	/**
	 * Return the value associated with the column: bill_sub_type
	 */
	public java.lang.String getBillSubType () {
		return billSubType;
	}

	/**
	 * Set the value related to the column: bill_sub_type
	 * @param billSubType the bill_sub_type value
	 */
	public void setBillSubType (java.lang.String billSubType) {
		this.billSubType = billSubType;
	}



	/**
	 * Return the value associated with the column: criteria
	 */
	public java.lang.String getCriteria () {
		return criteria;
	}

	/**
	 * Set the value related to the column: criteria
	 * @param criteria the criteria value
	 */
	public void setCriteria (java.lang.String criteria) {
		this.criteria = criteria;
	}



	/**
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix () {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * @param prefix the prefix value
	 */
	public void setPrefix (java.lang.String prefix) {
		this.prefix = prefix;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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
		if (!(obj instanceof jkt.hms.masters.business.BlParameter)) return false;
		else {
			jkt.hms.masters.business.BlParameter blParameter = (jkt.hms.masters.business.BlParameter) obj;
			if (null == this.getId() || null == blParameter.getId()) return false;
			else return (this.getId().equals(blParameter.getId()));
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