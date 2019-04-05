package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ot_pre_op_drugs_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_pre_op_drugs_entry"
 */

public abstract class BaseOtPreOpDrugsEntry implements Serializable {

	public static String REF = "OtPreOpDrugsEntry";
	public static String PROP_PRE_ANESTHSIA_DETAILS = "PreAnesthsiaDetails";
	public static String PROP_TIME = "Time";
	public static String PROP_DOSE = "Dose";
	public static String PROP_ROUTE = "Route";
	public static String PROP_ITEM = "Item";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOtPreOpDrugsEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreOpDrugsEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dose;
	private java.lang.String route;
	private java.lang.String time;

	// many to one
	private jkt.hms.masters.business.OtPreAnesthesiaDetails preAnesthsiaDetails;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="pre_op_id"
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
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose() {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * 
	 * @param dose
	 *            the dose value
	 */
	public void setDose(java.lang.String dose) {
		this.dose = dose;
	}

	/**
	 * Return the value associated with the column: route
	 */
	public java.lang.String getRoute() {
		return route;
	}

	/**
	 * Set the value related to the column: route
	 * 
	 * @param route
	 *            the route value
	 */
	public void setRoute(java.lang.String route) {
		this.route = route;
	}

	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime() {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * 
	 * @param time
	 *            the time value
	 */
	public void setTime(java.lang.String time) {
		this.time = time;
	}

	/**
	 * Return the value associated with the column: pre_anesthsia_details_id
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaDetails getPreAnesthsiaDetails() {
		return preAnesthsiaDetails;
	}

	/**
	 * Set the value related to the column: pre_anesthsia_details_id
	 * 
	 * @param preAnesthsiaDetails
	 *            the pre_anesthsia_details_id value
	 */
	public void setPreAnesthsiaDetails(
			jkt.hms.masters.business.OtPreAnesthesiaDetails preAnesthsiaDetails) {
		this.preAnesthsiaDetails = preAnesthsiaDetails;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreOpDrugsEntry))
			return false;
		else {
			jkt.hms.masters.business.OtPreOpDrugsEntry otPreOpDrugsEntry = (jkt.hms.masters.business.OtPreOpDrugsEntry) obj;
			if (null == this.getId() || null == otPreOpDrugsEntry.getId())
				return false;
			else
				return (this.getId().equals(otPreOpDrugsEntry.getId()));
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