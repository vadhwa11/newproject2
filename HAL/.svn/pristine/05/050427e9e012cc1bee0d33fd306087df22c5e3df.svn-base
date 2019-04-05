package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the caresummary table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="caresummary"
 */

public abstract class BaseCaresummary implements Serializable {

	public static String REF = "Caresummary";
	public static String PROP_NO_OF_TIMES = "NoOfTimes";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_DATE_OF_CARE = "DateOfCare";
	public static String PROP_NURSING = "Nursing";
	public static String PROP_ID = "Id";

	// constructors
	public BaseCaresummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCaresummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.Integer noOfTimes;
	private java.util.Date dateOfCare;

	// many to one
	private jkt.hms.masters.business.MasNursingCare nursing;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="caresummary_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo() {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * 
	 * @param adNo
	 *            the ad_no value
	 */
	public void setAdNo(java.lang.String adNo) {
		this.adNo = adNo;
	}

	/**
	 * Return the value associated with the column: no_of_times
	 */
	public java.lang.Integer getNoOfTimes() {
		return noOfTimes;
	}

	/**
	 * Set the value related to the column: no_of_times
	 * 
	 * @param noOfTimes
	 *            the no_of_times value
	 */
	public void setNoOfTimes(java.lang.Integer noOfTimes) {
		this.noOfTimes = noOfTimes;
	}

	/**
	 * Return the value associated with the column: date_of_care
	 */
	public java.util.Date getDateOfCare() {
		return dateOfCare;
	}

	/**
	 * Set the value related to the column: date_of_care
	 * 
	 * @param dateOfCare
	 *            the date_of_care value
	 */
	public void setDateOfCare(java.util.Date dateOfCare) {
		this.dateOfCare = dateOfCare;
	}

	/**
	 * Return the value associated with the column: nursing_id
	 */
	public jkt.hms.masters.business.MasNursingCare getNursing() {
		return nursing;
	}

	/**
	 * Set the value related to the column: nursing_id
	 * 
	 * @param nursing
	 *            the nursing_id value
	 */
	public void setNursing(jkt.hms.masters.business.MasNursingCare nursing) {
		this.nursing = nursing;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.Caresummary))
			return false;
		else {
			jkt.hms.masters.business.Caresummary caresummary = (jkt.hms.masters.business.Caresummary) obj;
			if (null == this.getId() || null == caresummary.getId())
				return false;
			else
				return (this.getId().equals(caresummary.getId()));
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