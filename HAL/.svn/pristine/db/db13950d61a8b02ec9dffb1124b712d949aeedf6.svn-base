package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * physiotherapy_visit_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="physiotherapy_visit_details"
 */

public abstract class BasePhysiotherapyVisitDetails implements Serializable {

	public static String REF = "PhysiotherapyVisitDetails";
	public static String PROP_REFERRED_DOC = "ReferredDoc";
	public static String PROP_STATUS = "Status";
	public static String PROP_PHYSIOTHERAPY_VISIT_DATE = "PhysiotherapyVisitDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TREATMENT_START_DATE = "TreatmentStartDate";
	public static String PROP_TREATMENT_END_DATE = "TreatmentEndDate";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_REFERRED_DEPARTMENT = "ReferredDepartment";

	// constructors
	public BasePhysiotherapyVisitDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysiotherapyVisitDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date physiotherapyVisitDate;
	private java.lang.String status;
	private java.lang.Integer tokenNo;
	private java.util.Date treatmentEndDate;
	private java.util.Date treatmentStartDate;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment referredDepartment;
	private jkt.hms.masters.business.MasEmployee referredDoc;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="physiotherapy_visit_id"
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
	 * Return the value associated with the column: physiotherapy_visit_date
	 */
	public java.util.Date getPhysiotherapyVisitDate() {
		return physiotherapyVisitDate;
	}

	/**
	 * Set the value related to the column: physiotherapy_visit_date
	 * 
	 * @param physiotherapyVisitDate
	 *            the physiotherapy_visit_date value
	 */
	public void setPhysiotherapyVisitDate(java.util.Date physiotherapyVisitDate) {
		this.physiotherapyVisitDate = physiotherapyVisitDate;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: token_no
	 */
	public java.lang.Integer getTokenNo() {
		return tokenNo;
	}

	/**
	 * Set the value related to the column: token_no
	 * 
	 * @param tokenNo
	 *            the token_no value
	 */
	public void setTokenNo(java.lang.Integer tokenNo) {
		this.tokenNo = tokenNo;
	}

	/**
	 * Return the value associated with the column: treatment_end_date
	 */
	public java.util.Date getTreatmentEndDate() {
		return treatmentEndDate;
	}

	/**
	 * Set the value related to the column: treatment_end_date
	 * 
	 * @param treatmentEndDate
	 *            the treatment_end_date value
	 */
	public void setTreatmentEndDate(java.util.Date treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}

	/**
	 * Return the value associated with the column: treatment_start_date
	 */
	public java.util.Date getTreatmentStartDate() {
		return treatmentStartDate;
	}

	/**
	 * Set the value related to the column: treatment_start_date
	 * 
	 * @param treatmentStartDate
	 *            the treatment_start_date value
	 */
	public void setTreatmentStartDate(java.util.Date treatmentStartDate) {
		this.treatmentStartDate = treatmentStartDate;
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

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: referred_department
	 */
	public jkt.hms.masters.business.MasDepartment getReferredDepartment() {
		return referredDepartment;
	}

	/**
	 * Set the value related to the column: referred_department
	 * 
	 * @param referredDepartment
	 *            the referred_department value
	 */
	public void setReferredDepartment(
			jkt.hms.masters.business.MasDepartment referredDepartment) {
		this.referredDepartment = referredDepartment;
	}

	/**
	 * Return the value associated with the column: referred_doc
	 */
	public jkt.hms.masters.business.MasEmployee getReferredDoc() {
		return referredDoc;
	}

	/**
	 * Set the value related to the column: referred_doc
	 * 
	 * @param referredDoc
	 *            the referred_doc value
	 */
	public void setReferredDoc(jkt.hms.masters.business.MasEmployee referredDoc) {
		this.referredDoc = referredDoc;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysiotherapyVisitDetails))
			return false;
		else {
			jkt.hms.masters.business.PhysiotherapyVisitDetails physiotherapyVisitDetails = (jkt.hms.masters.business.PhysiotherapyVisitDetails) obj;
			if (null == this.getId()
					|| null == physiotherapyVisitDetails.getId())
				return false;
			else
				return (this.getId().equals(physiotherapyVisitDetails.getId()));
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