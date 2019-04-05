package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_bill_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_bill_type"
 */

public abstract class BaseMasBillType  implements Serializable {

	public static String REF = "MasBillType";
	public static String PROP_STATUS = "Status";
	public static String PROP_BILL_TYPE_CODE = "BillTypeCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BILL_TYPE_NAME = "BillTypeName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasBillType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBillType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasBillType (
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
	private java.lang.String billTypeCode;
	private java.lang.String billTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="bill_type_id"
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
	 * Return the value associated with the column: bill_type_code
	 */
	public java.lang.String getBillTypeCode () {
		return billTypeCode;
	}

	/**
	 * Set the value related to the column: bill_type_code
	 * @param billTypeCode the bill_type_code value
	 */
	public void setBillTypeCode (java.lang.String billTypeCode) {
		this.billTypeCode = billTypeCode;
	}



	/**
	 * Return the value associated with the column: bill_type_name
	 */
	public java.lang.String getBillTypeName () {
		return billTypeName;
	}

	/**
	 * Set the value related to the column: bill_type_name
	 * @param billTypeName the bill_type_name value
	 */
	public void setBillTypeName (java.lang.String billTypeName) {
		this.billTypeName = billTypeName;
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
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts () {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * @param masDiscounts the MasDiscounts value
	 */
	public void setMasDiscounts (java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts (jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts()) setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBillType)) return false;
		else {
			jkt.hms.masters.business.MasBillType masBillType = (jkt.hms.masters.business.MasBillType) obj;
			if (null == this.getId() || null == masBillType.getId()) return false;
			else return (this.getId().equals(masBillType.getId()));
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