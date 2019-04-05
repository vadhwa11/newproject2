package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_donor_sample_screening_detail table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="blood_donor_sample_screening_detail"
 */

public abstract class BaseBloodDonorSampleScreeningDetail implements
		Serializable {

	public static String REF = "BloodDonorSampleScreeningDetail";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RESULT = "Result";
	public static String PROP_SCREENING_HEADER = "ScreeningHeader";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodDonorSampleScreeningDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodDonorSampleScreeningDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String result;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.BloodDonorSampleScreeningHeader screeningHeader;
	private jkt.hms.masters.business.DgMasInvestigation investigation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="screening_detail_id"
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
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult() {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * 
	 * @param result
	 *            the result value
	 */
	public void setResult(java.lang.String result) {
		this.result = result;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: screening_header_id
	 */
	public jkt.hms.masters.business.BloodDonorSampleScreeningHeader getScreeningHeader() {
		return screeningHeader;
	}

	/**
	 * Set the value related to the column: screening_header_id
	 * 
	 * @param screeningHeader
	 *            the screening_header_id value
	 */
	public void setScreeningHeader(
			jkt.hms.masters.business.BloodDonorSampleScreeningHeader screeningHeader) {
		this.screeningHeader = screeningHeader;
	}

	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation() {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * 
	 * @param investigation
	 *            the investigation_id value
	 */
	public void setInvestigation(
			jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodDonorSampleScreeningDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodDonorSampleScreeningDetail bloodDonorSampleScreeningDetail = (jkt.hms.masters.business.BloodDonorSampleScreeningDetail) obj;
			if (null == this.getId()
					|| null == bloodDonorSampleScreeningDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodDonorSampleScreeningDetail
						.getId()));
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