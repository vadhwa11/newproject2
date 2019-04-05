package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mpr_priority table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mpr_priority"
 */

public abstract class BaseMprPriority  implements Serializable {

	public static String REF = "MprPriority";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHY_BY = "LastChyBy";
	public static String PROP_PR_CODE = "PrCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PR_NAME = "PrName";


	// constructors
	public BaseMprPriority () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMprPriority (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String prCode;
	private java.lang.String prName;
	private java.lang.Integer lastChyBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreMaterialPurchaseReqM> storeMaterialPurchaseReqMs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: pr_code
	 */
	public java.lang.String getPrCode () {
		return prCode;
	}

	/**
	 * Set the value related to the column: pr_code
	 * @param prCode the pr_code value
	 */
	public void setPrCode (java.lang.String prCode) {
		this.prCode = prCode;
	}



	/**
	 * Return the value associated with the column: pr_name
	 */
	public java.lang.String getPrName () {
		return prName;
	}

	/**
	 * Set the value related to the column: pr_name
	 * @param prName the pr_name value
	 */
	public void setPrName (java.lang.String prName) {
		this.prName = prName;
	}



	/**
	 * Return the value associated with the column: last_chy_by
	 */
	public java.lang.Integer getLastChyBy () {
		return lastChyBy;
	}

	/**
	 * Set the value related to the column: last_chy_by
	 * @param lastChyBy the last_chy_by value
	 */
	public void setLastChyBy (java.lang.Integer lastChyBy) {
		this.lastChyBy = lastChyBy;
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
	 * Return the value associated with the column: StoreMaterialPurchaseReqMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMaterialPurchaseReqM> getStoreMaterialPurchaseReqMs () {
		return storeMaterialPurchaseReqMs;
	}

	/**
	 * Set the value related to the column: StoreMaterialPurchaseReqMs
	 * @param storeMaterialPurchaseReqMs the StoreMaterialPurchaseReqMs value
	 */
	public void setStoreMaterialPurchaseReqMs (java.util.Set<jkt.hms.masters.business.StoreMaterialPurchaseReqM> storeMaterialPurchaseReqMs) {
		this.storeMaterialPurchaseReqMs = storeMaterialPurchaseReqMs;
	}

	public void addToStoreMaterialPurchaseReqMs (jkt.hms.masters.business.StoreMaterialPurchaseReqM storeMaterialPurchaseReqM) {
		if (null == getStoreMaterialPurchaseReqMs()) setStoreMaterialPurchaseReqMs(new java.util.TreeSet<jkt.hms.masters.business.StoreMaterialPurchaseReqM>());
		getStoreMaterialPurchaseReqMs().add(storeMaterialPurchaseReqM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MprPriority)) return false;
		else {
			jkt.hms.masters.business.MprPriority mprPriority = (jkt.hms.masters.business.MprPriority) obj;
			if (null == this.getId() || null == mprPriority.getId()) return false;
			else return (this.getId().equals(mprPriority.getId()));
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