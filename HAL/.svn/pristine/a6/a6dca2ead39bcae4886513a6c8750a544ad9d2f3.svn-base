package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_request_entry_detail table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_request_entry_detail"
 */

public abstract class BaseBloodRequestEntryDetail implements Serializable {

	public static String REF = "BloodRequestEntryDetail";
	public static String PROP_QTY = "Qty";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REQ_DATE = "ReqDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COMPONENT = "Component";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_REQUEST = "Request";

	// constructors
	public BaseBloodRequestEntryDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodRequestEntryDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer qty;
	private java.util.Date reqDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.BloodMasComponent component;
	private jkt.hms.masters.business.BloodRequestEntryHeader request;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="detail_id"
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
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: req_date
	 */
	public java.util.Date getReqDate() {
		return reqDate;
	}

	/**
	 * Set the value related to the column: req_date
	 * 
	 * @param reqDate
	 *            the req_date value
	 */
	public void setReqDate(java.util.Date reqDate) {
		this.reqDate = reqDate;
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
	 * Return the value associated with the column: component_id
	 */
	public jkt.hms.masters.business.BloodMasComponent getComponent() {
		return component;
	}

	/**
	 * Set the value related to the column: component_id
	 * 
	 * @param component
	 *            the component_id value
	 */
	public void setComponent(
			jkt.hms.masters.business.BloodMasComponent component) {
		this.component = component;
	}

	/**
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.BloodRequestEntryHeader getRequest() {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * 
	 * @param request
	 *            the request_id value
	 */
	public void setRequest(
			jkt.hms.masters.business.BloodRequestEntryHeader request) {
		this.request = request;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodRequestEntryDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodRequestEntryDetail bloodRequestEntryDetail = (jkt.hms.masters.business.BloodRequestEntryDetail) obj;
			if (null == this.getId() || null == bloodRequestEntryDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodRequestEntryDetail.getId()));
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