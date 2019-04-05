package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_request_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_request_entry"
 */

public abstract class BaseBloodRequestEntry implements Serializable {

	public static String REF = "BloodRequestEntry";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_SPECIFIC_REFERENCE = "SpecificReference";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_QTY = "Qty";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_IF_ANY = "IfAny";
	public static String PROP_REQ_DATE = "ReqDate";
	public static String PROP_HB = "Hb";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COMPONENT = "Component";
	public static String PROP_DATE1 = "Date1";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_OF_TIME = "OfTime";
	public static String PROP_NO_BOTTLES = "NoBottles";
	public static String PROP_FEVER = "Fever";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REQUEST_TYPE = "RequestType";
	public static String PROP_PREGNANCIES = "Pregnancies";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PRESENCE1 = "Presence1";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodRequestEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodRequestEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String orderNo;
	private java.util.Date orderDate;
	private java.lang.String requestType;
	private java.util.Date date1;
	private java.lang.String noBottles;
	private java.lang.String hb;
	private java.lang.String presence1;
	private java.lang.String fever;
	private java.lang.String ofTime;
	private java.lang.String ifAny;
	private java.lang.String pregnancies;
	private java.lang.String specificReference;
	private java.lang.Integer qty;
	private java.util.Date reqDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.BloodMasComponent component;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="request_id"
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
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo() {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * 
	 * @param orderNo
	 *            the order_no value
	 */
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Return the value associated with the column: order_date
	 */
	public java.util.Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Set the value related to the column: order_date
	 * 
	 * @param orderDate
	 *            the order_date value
	 */
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Return the value associated with the column: request_type
	 */
	public java.lang.String getRequestType() {
		return requestType;
	}

	/**
	 * Set the value related to the column: request_type
	 * 
	 * @param requestType
	 *            the request_type value
	 */
	public void setRequestType(java.lang.String requestType) {
		this.requestType = requestType;
	}

	/**
	 * Return the value associated with the column: date1
	 */
	public java.util.Date getDate1() {
		return date1;
	}

	/**
	 * Set the value related to the column: date1
	 * 
	 * @param date1
	 *            the date1 value
	 */
	public void setDate1(java.util.Date date1) {
		this.date1 = date1;
	}

	/**
	 * Return the value associated with the column: no_bottles
	 */
	public java.lang.String getNoBottles() {
		return noBottles;
	}

	/**
	 * Set the value related to the column: no_bottles
	 * 
	 * @param noBottles
	 *            the no_bottles value
	 */
	public void setNoBottles(java.lang.String noBottles) {
		this.noBottles = noBottles;
	}

	/**
	 * Return the value associated with the column: hb
	 */
	public java.lang.String getHb() {
		return hb;
	}

	/**
	 * Set the value related to the column: hb
	 * 
	 * @param hb
	 *            the hb value
	 */
	public void setHb(java.lang.String hb) {
		this.hb = hb;
	}

	/**
	 * Return the value associated with the column: presence1
	 */
	public java.lang.String getPresence1() {
		return presence1;
	}

	/**
	 * Set the value related to the column: presence1
	 * 
	 * @param presence1
	 *            the presence1 value
	 */
	public void setPresence1(java.lang.String presence1) {
		this.presence1 = presence1;
	}

	/**
	 * Return the value associated with the column: fever
	 */
	public java.lang.String getFever() {
		return fever;
	}

	/**
	 * Set the value related to the column: fever
	 * 
	 * @param fever
	 *            the fever value
	 */
	public void setFever(java.lang.String fever) {
		this.fever = fever;
	}

	/**
	 * Return the value associated with the column: of_time
	 */
	public java.lang.String getOfTime() {
		return ofTime;
	}

	/**
	 * Set the value related to the column: of_time
	 * 
	 * @param ofTime
	 *            the of_time value
	 */
	public void setOfTime(java.lang.String ofTime) {
		this.ofTime = ofTime;
	}

	/**
	 * Return the value associated with the column: if_any
	 */
	public java.lang.String getIfAny() {
		return ifAny;
	}

	/**
	 * Set the value related to the column: if_any
	 * 
	 * @param ifAny
	 *            the if_any value
	 */
	public void setIfAny(java.lang.String ifAny) {
		this.ifAny = ifAny;
	}

	/**
	 * Return the value associated with the column: pregnancies
	 */
	public java.lang.String getPregnancies() {
		return pregnancies;
	}

	/**
	 * Set the value related to the column: pregnancies
	 * 
	 * @param pregnancies
	 *            the pregnancies value
	 */
	public void setPregnancies(java.lang.String pregnancies) {
		this.pregnancies = pregnancies;
	}

	/**
	 * Return the value associated with the column: specific_reference
	 */
	public java.lang.String getSpecificReference() {
		return specificReference;
	}

	/**
	 * Set the value related to the column: specific_reference
	 * 
	 * @param specificReference
	 *            the specific_reference value
	 */
	public void setSpecificReference(java.lang.String specificReference) {
		this.specificReference = specificReference;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodRequestEntry))
			return false;
		else {
			jkt.hms.masters.business.BloodRequestEntry bloodRequestEntry = (jkt.hms.masters.business.BloodRequestEntry) obj;
			if (null == this.getId() || null == bloodRequestEntry.getId())
				return false;
			else
				return (this.getId().equals(bloodRequestEntry.getId()));
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