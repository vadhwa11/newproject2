package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_delivery_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_delivery_type"
 */

public abstract class BaseMasDeliveryType  implements Serializable {

	public static String REF = "MasDeliveryType";
	public static String PROP_STATUS = "Status";
	public static String PROP_DELIVERY_TYPE_DESCRIPTION = "DeliveryTypeDescription";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DELIVERY_TYPE = "DeliveryType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasDeliveryType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDeliveryType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasDeliveryType (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		java.lang.String deliveryType,
		java.lang.String deliveryTypeDescription,
		java.lang.String status,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setDeliveryType(deliveryType);
		this.setDeliveryTypeDescription(deliveryTypeDescription);
		this.setStatus(status);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deliveryType;
	private java.lang.String deliveryTypeDescription;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="delivery_type_id"
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
	 * Return the value associated with the column: delivery_type
	 */
	public java.lang.String getDeliveryType () {
		return deliveryType;
	}

	/**
	 * Set the value related to the column: delivery_type
	 * @param deliveryType the delivery_type value
	 */
	public void setDeliveryType (java.lang.String deliveryType) {
		this.deliveryType = deliveryType;
	}



	/**
	 * Return the value associated with the column: delivery_type_description
	 */
	public java.lang.String getDeliveryTypeDescription () {
		return deliveryTypeDescription;
	}

	/**
	 * Set the value related to the column: delivery_type_description
	 * @param deliveryTypeDescription the delivery_type_description value
	 */
	public void setDeliveryTypeDescription (java.lang.String deliveryTypeDescription) {
		this.deliveryTypeDescription = deliveryTypeDescription;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDeliveryType)) return false;
		else {
			jkt.hms.masters.business.MasDeliveryType masDeliveryType = (jkt.hms.masters.business.MasDeliveryType) obj;
			if (null == this.getId() || null == masDeliveryType.getId()) return false;
			else return (this.getId().equals(masDeliveryType.getId()));
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