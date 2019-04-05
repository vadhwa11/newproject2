package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_PROFORMAB_APPROVED table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_PROFORMAB_APPROVED"
 */

public abstract class BaseStoreProformabApproved  implements Serializable {

	public static String REF = "StoreProformabApproved";
	public static String PROP_STATUS = "Status";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PROFORMA_APPROVED_DATE = "ProformaApprovedDate";


	// constructors
	public BaseStoreProformabApproved () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreProformabApproved (java.lang.Integer approvedId) {
		this.setApprovedId(approvedId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer approvedId;

	// fields
	private java.lang.String status;
	private java.lang.String remarks;
	private java.util.Date proformaApprovedDate;

	// many to one
	private jkt.hms.masters.business.StoreProformaHeader proforma;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="APPROVED_ID "
     */
	public java.lang.Integer getApprovedId () {
		return approvedId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param approvedId the new ID
	 */
	public void setApprovedId (java.lang.Integer approvedId) {
		this.approvedId = approvedId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: PROFORMA_APPROVAL_DATE
	 */
	public java.util.Date getProformaApprovedDate () {
		return proformaApprovedDate;
	}

	/**
	 * Set the value related to the column: PROFORMA_APPROVAL_DATE
	 * @param proformaApprovedDate the PROFORMA_APPROVAL_DATE value
	 */
	public void setProformaApprovedDate (java.util.Date proformaApprovedDate) {
		this.proformaApprovedDate = proformaApprovedDate;
	}



	/**
	 * Return the value associated with the column: PROFORMA_ID
	 */
	public jkt.hms.masters.business.StoreProformaHeader getProforma () {
		return proforma;
	}

	/**
	 * Set the value related to the column: PROFORMA_ID
	 * @param proforma the PROFORMA_ID value
	 */
	public void setProforma (jkt.hms.masters.business.StoreProformaHeader proforma) {
		this.proforma = proforma;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreProformabApproved)) return false;
		else {
			jkt.hms.masters.business.StoreProformabApproved storeProformabApproved = (jkt.hms.masters.business.StoreProformabApproved) obj;
			if (null == this.getApprovedId() || null == storeProformabApproved.getApprovedId()) return false;
			else return (this.getApprovedId().equals(storeProformabApproved.getApprovedId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getApprovedId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getApprovedId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}