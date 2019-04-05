package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_FOLLOWUP_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_FOLLOWUP_DETAILS"
 */

public abstract class BaseStoreFollowupDetails  implements Serializable {

	public static String REF = "StoreFollowupDetails";
	public static String PROP_REFERENCE_NO = "ReferenceNo";
	public static String PROP_FOLLOW_UP_DATE = "FollowUpDate";
	public static String PROP_DEFECT_M = "DefectM";
	public static String PROP_ID = "Id";
	public static String PROP_REMARKS = "Remarks";


	// constructors
	public BaseStoreFollowupDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreFollowupDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date followUpDate;
	private java.lang.String referenceNo;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.StoreDefectiveDrugM defectM;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: FOLLOWUP_DATE
	 */
	public java.util.Date getFollowUpDate () {
		return followUpDate;
	}

	/**
	 * Set the value related to the column: FOLLOWUP_DATE
	 * @param followUpDate the FOLLOWUP_DATE value
	 */
	public void setFollowUpDate (java.util.Date followUpDate) {
		this.followUpDate = followUpDate;
	}



	/**
	 * Return the value associated with the column: REFERANCE_NO
	 */
	public java.lang.String getReferenceNo () {
		return referenceNo;
	}

	/**
	 * Set the value related to the column: REFERANCE_NO
	 * @param referenceNo the REFERANCE_NO value
	 */
	public void setReferenceNo (java.lang.String referenceNo) {
		this.referenceNo = referenceNo;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: DEFECTIVE_M_ID
	 */
	public jkt.hms.masters.business.StoreDefectiveDrugM getDefectM () {
		return defectM;
	}

	/**
	 * Set the value related to the column: DEFECTIVE_M_ID
	 * @param defectM the DEFECTIVE_M_ID value
	 */
	public void setDefectM (jkt.hms.masters.business.StoreDefectiveDrugM defectM) {
		this.defectM = defectM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreFollowupDetails)) return false;
		else {
			jkt.hms.masters.business.StoreFollowupDetails storeFollowupDetails = (jkt.hms.masters.business.StoreFollowupDetails) obj;
			if (null == this.getId() || null == storeFollowupDetails.getId()) return false;
			else return (this.getId().equals(storeFollowupDetails.getId()));
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