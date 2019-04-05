package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_po_delivery_terms table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_po_delivery_terms"
 */

public abstract class BaseMasStorePoDeliveryTerms  implements Serializable {

	public static String REF = "MasStorePoDeliveryTerms";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PO_DELIVERY_TERMS_NAME = "PoDeliveryTermsName";
	public static String PROP_PO_DELIVERY_TERMS_DESCRIPTION = "PoDeliveryTermsDescription";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasStorePoDeliveryTerms () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStorePoDeliveryTerms (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String poDeliveryTermsName;
	private java.lang.String poDeliveryTermsDescription;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="po_delivery_terms_id"
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
	 * Return the value associated with the column: po_delivery_terms_name
	 */
	public java.lang.String getPoDeliveryTermsName () {
		return poDeliveryTermsName;
	}

	/**
	 * Set the value related to the column: po_delivery_terms_name
	 * @param poDeliveryTermsName the po_delivery_terms_name value
	 */
	public void setPoDeliveryTermsName (java.lang.String poDeliveryTermsName) {
		this.poDeliveryTermsName = poDeliveryTermsName;
	}



	/**
	 * Return the value associated with the column: po_delivery_terms_description
	 */
	public java.lang.String getPoDeliveryTermsDescription () {
		return poDeliveryTermsDescription;
	}

	/**
	 * Set the value related to the column: po_delivery_terms_description
	 * @param poDeliveryTermsDescription the po_delivery_terms_description value
	 */
	public void setPoDeliveryTermsDescription (java.lang.String poDeliveryTermsDescription) {
		this.poDeliveryTermsDescription = poDeliveryTermsDescription;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStorePoDeliveryTerms)) return false;
		else {
			jkt.hms.masters.business.MasStorePoDeliveryTerms masStorePoDeliveryTerms = (jkt.hms.masters.business.MasStorePoDeliveryTerms) obj;
			if (null == this.getId() || null == masStorePoDeliveryTerms.getId()) return false;
			else return (this.getId().equals(masStorePoDeliveryTerms.getId()));
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