package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_frequency table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_frequency"
 */

public abstract class BaseMasFrequency  implements Serializable {

	public static String REF = "MasFrequency";
	public static String PROP_STATUS = "Status";
	public static String PROP_FEQ = "Feq";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_FREQUENCY_NAME = "FrequencyName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FREQUENCY_CODE = "FrequencyCode";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasFrequency () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasFrequency (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasFrequency (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal feq;
	private java.lang.String frequency;
	private java.lang.String frequencyCode;
	private java.lang.String frequencyName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer orderNo;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="frequency_id"
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
	 * Return the value associated with the column: FEQ
	 */
	public java.math.BigDecimal getFeq () {
		return feq;
	}

	/**
	 * Set the value related to the column: FEQ
	 * @param feq the FEQ value
	 */
	public void setFeq (java.math.BigDecimal feq) {
		this.feq = feq;
	}



	/**
	 * Return the value associated with the column: FREQUENCY
	 */
	public java.lang.String getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: FREQUENCY
	 * @param frequency the FREQUENCY value
	 */
	public void setFrequency (java.lang.String frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: frequency_code
	 */
	public java.lang.String getFrequencyCode () {
		return frequencyCode;
	}

	/**
	 * Set the value related to the column: frequency_code
	 * @param frequencyCode the frequency_code value
	 */
	public void setFrequencyCode (java.lang.String frequencyCode) {
		this.frequencyCode = frequencyCode;
	}



	/**
	 * Return the value associated with the column: frequency_name
	 */
	public java.lang.String getFrequencyName () {
		return frequencyName;
	}

	/**
	 * Set the value related to the column: frequency_name
	 * @param frequencyName the frequency_name value
	 */
	public void setFrequencyName (java.lang.String frequencyName) {
		this.frequencyName = frequencyName;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
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
	 * Return the value associated with the column: NursingcareSetups
	 */
	public java.util.Set<jkt.hms.masters.business.NursingcareSetup> getNursingcareSetups () {
		return nursingcareSetups;
	}

	/**
	 * Set the value related to the column: NursingcareSetups
	 * @param nursingcareSetups the NursingcareSetups value
	 */
	public void setNursingcareSetups (java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups) {
		this.nursingcareSetups = nursingcareSetups;
	}

	public void addToNursingcareSetups (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		if (null == getNursingcareSetups()) setNursingcareSetups(new java.util.TreeSet<jkt.hms.masters.business.NursingcareSetup>());
		getNursingcareSetups().add(nursingcareSetup);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasFrequency)) return false;
		else {
			jkt.hms.masters.business.MasFrequency masFrequency = (jkt.hms.masters.business.MasFrequency) obj;
			if (null == this.getId() || null == masFrequency.getId()) return false;
			else return (this.getId().equals(masFrequency.getId()));
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