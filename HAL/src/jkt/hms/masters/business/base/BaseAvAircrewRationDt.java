package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_AIRCREW_RATION_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_AIRCREW_RATION_DT"
 */

public abstract class BaseAvAircrewRationDt  implements Serializable {

	public static String REF = "AvAircrewRationDt";
	public static String PROP_AUTH_ITEM_ID = "AuthItemId";
	public static String PROP_RATION_DT_ID = "RationDtId";
	public static String PROP_SUPPLIED_QTY = "SuppliedQty";
	public static String PROP_RATION_HD_ID = "RationHdId";


	// constructors
	public BaseAvAircrewRationDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvAircrewRationDt (java.lang.Integer rationDtId) {
		this.setRationDtId(rationDtId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer rationDtId;

	// fields
	private java.lang.String suppliedQty;

	// many to one
	private jkt.hms.masters.business.AvAircrewRationHd rationHdId;
	private jkt.hms.masters.business.AvAuthorisedItem authItemId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="RATION_DT_ID"
     */
	public java.lang.Integer getRationDtId () {
		return rationDtId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param rationDtId the new ID
	 */
	public void setRationDtId (java.lang.Integer rationDtId) {
		this.rationDtId = rationDtId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: SUPPLIED_QTY
	 */
	public java.lang.String getSuppliedQty () {
		return suppliedQty;
	}

	/**
	 * Set the value related to the column: SUPPLIED_QTY
	 * @param suppliedQty the SUPPLIED_QTY value
	 */
	public void setSuppliedQty (java.lang.String suppliedQty) {
		this.suppliedQty = suppliedQty;
	}



	/**
	 * Return the value associated with the column: RATION_HD_ID
	 */
	public jkt.hms.masters.business.AvAircrewRationHd getRationHdId () {
		return rationHdId;
	}

	/**
	 * Set the value related to the column: RATION_HD_ID
	 * @param rationHdId the RATION_HD_ID value
	 */
	public void setRationHdId (jkt.hms.masters.business.AvAircrewRationHd rationHdId) {
		this.rationHdId = rationHdId;
	}



	/**
	 * Return the value associated with the column: AUTH_ITEM_ID
	 */
	public jkt.hms.masters.business.AvAuthorisedItem getAuthItemId () {
		return authItemId;
	}

	/**
	 * Set the value related to the column: AUTH_ITEM_ID
	 * @param authItemId the AUTH_ITEM_ID value
	 */
	public void setAuthItemId (jkt.hms.masters.business.AvAuthorisedItem authItemId) {
		this.authItemId = authItemId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvAircrewRationDt)) return false;
		else {
			jkt.hms.masters.business.AvAircrewRationDt avAircrewRationDt = (jkt.hms.masters.business.AvAircrewRationDt) obj;
			if (null == this.getRationDtId() || null == avAircrewRationDt.getRationDtId()) return false;
			else return (this.getRationDtId().equals(avAircrewRationDt.getRationDtId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getRationDtId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getRationDtId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}