package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_normal_value table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="dg_normal_value"
 */

public abstract class BaseDgNormalValue implements Serializable {

	public static String REF = "DgNormalValue";
	public static String PROP_FROM_AGE = "FromAge";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_SUB_INVESTIGATION = "SubInvestigation";
	public static String PROP_MIN_NORMAL_VALUE = "MinNormalValue";
	public static String PROP_SEX = "Sex";
	public static String PROP_MAX_NORMAL_VALUE = "MaxNormalValue";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_TO_AGE = "ToAge";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDgNormalValue() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgNormalValue(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sex;
	private java.lang.Integer fromAge;
	private java.lang.Integer toAge;
	private java.lang.String minNormalValue;
	private java.lang.String maxNormalValue;
	private java.lang.String normalValue;

	// many to one
	private jkt.hms.masters.business.DgSubMasInvestigation subInvestigation;
	private jkt.hms.masters.business.MasChargeCode chargeCode;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="normal_id"
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
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex() {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * 
	 * @param sex
	 *            the sex value
	 */
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	/**
	 * Return the value associated with the column: from_age
	 */
	public java.lang.Integer getFromAge() {
		return fromAge;
	}

	/**
	 * Set the value related to the column: from_age
	 * 
	 * @param fromAge
	 *            the from_age value
	 */
	public void setFromAge(java.lang.Integer fromAge) {
		this.fromAge = fromAge;
	}

	/**
	 * Return the value associated with the column: to_age
	 */
	public java.lang.Integer getToAge() {
		return toAge;
	}

	/**
	 * Set the value related to the column: to_age
	 * 
	 * @param toAge
	 *            the to_age value
	 */
	public void setToAge(java.lang.Integer toAge) {
		this.toAge = toAge;
	}

	/**
	 * Return the value associated with the column: min_normal_value
	 */
	public java.lang.String getMinNormalValue() {
		return minNormalValue;
	}

	/**
	 * Set the value related to the column: min_normal_value
	 * 
	 * @param minNormalValue
	 *            the min_normal_value value
	 */
	public void setMinNormalValue(java.lang.String minNormalValue) {
		this.minNormalValue = minNormalValue;
	}

	/**
	 * Return the value associated with the column: max_normal_value
	 */
	public java.lang.String getMaxNormalValue() {
		return maxNormalValue;
	}

	/**
	 * Set the value related to the column: max_normal_value
	 * 
	 * @param maxNormalValue
	 *            the max_normal_value value
	 */
	public void setMaxNormalValue(java.lang.String maxNormalValue) {
		this.maxNormalValue = maxNormalValue;
	}

	/**
	 * Return the value associated with the column: normalValue
	 */
	public java.lang.String getNormalValue() {
		return normalValue;
	}

	/**
	 * Set the value related to the column: normalValue
	 * 
	 * @param normalValue
	 *            the normalValue value
	 */
	public void setNormalValue(java.lang.String normalValue) {
		this.normalValue = normalValue;
	}

	/**
	 * Return the value associated with the column: sub_investigation_id
	 */
	public jkt.hms.masters.business.DgSubMasInvestigation getSubInvestigation() {
		return subInvestigation;
	}

	/**
	 * Set the value related to the column: sub_investigation_id
	 * 
	 * @param subInvestigation
	 *            the sub_investigation_id value
	 */
	public void setSubInvestigation(
			jkt.hms.masters.business.DgSubMasInvestigation subInvestigation) {
		this.subInvestigation = subInvestigation;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}

	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails() {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * 
	 * @param dgResultEntryDetails
	 *            the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails(
			java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails(
			jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails())
			setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DgNormalValue))
			return false;
		else {
			jkt.hms.masters.business.DgNormalValue dgNormalValue = (jkt.hms.masters.business.DgNormalValue) obj;
			if (null == this.getId() || null == dgNormalValue.getId())
				return false;
			else
				return (this.getId().equals(dgNormalValue.getId()));
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