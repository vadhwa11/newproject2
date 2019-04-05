package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the COMPLAIN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="COMPLAIN"
 */

public abstract class BaseComplain  implements Serializable {

	public static String REF = "Complain";
	public static String PROP_COMPLETION_DATE = "CompletionDate";
	public static String PROP_DISCRIPTION = "Discription";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_COMPLAIN_DATE = "ComplainDate";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";
	public static String PROP_COMPLAIN_TIME = "ComplainTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_REQUEST_BY = "RequestBy";
	public static String PROP_AIR_HQ_REMARKS = "AirHqRemarks";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_REQUEST_TYPE = "RequestType";
	public static String PROP_VENDOR_REMARKS = "VendorRemarks";


	// constructors
	public BaseComplain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseComplain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date complainDate;
	private java.lang.String complainTime;
	private java.lang.String requestType;
	private java.lang.String discription;
	private java.lang.String status;
	private java.lang.String airHqRemarks;
	private java.util.Date completionDate;
	private java.lang.String vendorRemarks;
	private java.lang.String lastChangeBy;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee requestBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="COMPLAIN_ID"
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
	 * Return the value associated with the column: COMPLAIN_DATE
	 */
	public java.util.Date getComplainDate () {
		return complainDate;
	}

	/**
	 * Set the value related to the column: COMPLAIN_DATE
	 * @param complainDate the COMPLAIN_DATE value
	 */
	public void setComplainDate (java.util.Date complainDate) {
		this.complainDate = complainDate;
	}



	/**
	 * Return the value associated with the column: COMPLAIN_TIME
	 */
	public java.lang.String getComplainTime () {
		return complainTime;
	}

	/**
	 * Set the value related to the column: COMPLAIN_TIME
	 * @param complainTime the COMPLAIN_TIME value
	 */
	public void setComplainTime (java.lang.String complainTime) {
		this.complainTime = complainTime;
	}



	/**
	 * Return the value associated with the column: REQUEST_TYPE
	 */
	public java.lang.String getRequestType () {
		return requestType;
	}

	/**
	 * Set the value related to the column: REQUEST_TYPE
	 * @param requestType the REQUEST_TYPE value
	 */
	public void setRequestType (java.lang.String requestType) {
		this.requestType = requestType;
	}



	/**
	 * Return the value associated with the column: DISCRIPTION
	 */
	public java.lang.String getDiscription () {
		return discription;
	}

	/**
	 * Set the value related to the column: DISCRIPTION
	 * @param discription the DISCRIPTION value
	 */
	public void setDiscription (java.lang.String discription) {
		this.discription = discription;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: AIR_HQ_REMARKS
	 */
	public java.lang.String getAirHqRemarks () {
		return airHqRemarks;
	}

	/**
	 * Set the value related to the column: AIR_HQ_REMARKS
	 * @param airHqRemarks the AIR_HQ_REMARKS value
	 */
	public void setAirHqRemarks (java.lang.String airHqRemarks) {
		this.airHqRemarks = airHqRemarks;
	}



	/**
	 * Return the value associated with the column: COMPLETION_DATE
	 */
	public java.util.Date getCompletionDate () {
		return completionDate;
	}

	/**
	 * Set the value related to the column: COMPLETION_DATE
	 * @param completionDate the COMPLETION_DATE value
	 */
	public void setCompletionDate (java.util.Date completionDate) {
		this.completionDate = completionDate;
	}



	/**
	 * Return the value associated with the column: VENDOR_REMARKS
	 */
	public java.lang.String getVendorRemarks () {
		return vendorRemarks;
	}

	/**
	 * Set the value related to the column: VENDOR_REMARKS
	 * @param vendorRemarks the VENDOR_REMARKS value
	 */
	public void setVendorRemarks (java.lang.String vendorRemarks) {
		this.vendorRemarks = vendorRemarks;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_BY
	 */
	public java.lang.String getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_BY
	 * @param lastChangeBy the LAST_CHANGE_BY value
	 */
	public void setLastChangeBy (java.lang.String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_DATE
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_DATE
	 * @param lastChangeDate the LAST_CHANGE_DATE value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_TIME
	 */
	public java.lang.String getLastChangeTime () {
		return lastChangeTime;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_TIME
	 * @param lastChangeTime the LAST_CHANGE_TIME value
	 */
	public void setLastChangeTime (java.lang.String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}



	/**
	 * Return the value associated with the column: request_by
	 */
	public jkt.hms.masters.business.MasEmployee getRequestBy () {
		return requestBy;
	}

	/**
	 * Set the value related to the column: request_by
	 * @param requestBy the request_by value
	 */
	public void setRequestBy (jkt.hms.masters.business.MasEmployee requestBy) {
		this.requestBy = requestBy;
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
		if (!(obj instanceof jkt.hms.masters.business.Complain)) return false;
		else {
			jkt.hms.masters.business.Complain complain = (jkt.hms.masters.business.Complain) obj;
			if (null == this.getId() || null == complain.getId()) return false;
			else return (this.getId().equals(complain.getId()));
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