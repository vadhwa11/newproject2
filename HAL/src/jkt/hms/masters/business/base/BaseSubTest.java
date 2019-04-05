package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the sub_test table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="sub_test"
 */

public abstract class BaseSubTest implements Serializable {

	public static String REF = "SubTest";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_CHARGE_CODE_ID = "ChargeCodeId";
	public static String PROP_UNIT_OF_RESULT = "UnitOfResult";
	public static String PROP_ID = "Id";
	public static String PROP_SUB_TEST_DESCRIPTION = "SubTestDescription";
	public static String PROP_SUB_TEST_CODE = "SubTestCode";

	// constructors
	public BaseSubTest() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSubTest(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subTestCode;
	private java.lang.String subTestDescription;
	private java.lang.Integer chargeCodeId;
	private java.lang.Integer statusId;
	private java.lang.String normalValue;
	private java.lang.String unitOfResult;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="sub_test_id"
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
	 * Return the value associated with the column: sub_test_code
	 */
	public java.lang.String getSubTestCode() {
		return subTestCode;
	}

	/**
	 * Set the value related to the column: sub_test_code
	 * 
	 * @param subTestCode
	 *            the sub_test_code value
	 */
	public void setSubTestCode(java.lang.String subTestCode) {
		this.subTestCode = subTestCode;
	}

	/**
	 * Return the value associated with the column: sub_test_description
	 */
	public java.lang.String getSubTestDescription() {
		return subTestDescription;
	}

	/**
	 * Set the value related to the column: sub_test_description
	 * 
	 * @param subTestDescription
	 *            the sub_test_description value
	 */
	public void setSubTestDescription(java.lang.String subTestDescription) {
		this.subTestDescription = subTestDescription;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public java.lang.Integer getChargeCodeId() {
		return chargeCodeId;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCodeId
	 *            the charge_code_id value
	 */
	public void setChargeCodeId(java.lang.Integer chargeCodeId) {
		this.chargeCodeId = chargeCodeId;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Return the value associated with the column: normal_value
	 */
	public java.lang.String getNormalValue() {
		return normalValue;
	}

	/**
	 * Set the value related to the column: normal_value
	 * 
	 * @param normalValue
	 *            the normal_value value
	 */
	public void setNormalValue(java.lang.String normalValue) {
		this.normalValue = normalValue;
	}

	/**
	 * Return the value associated with the column: unit_of_result
	 */
	public java.lang.String getUnitOfResult() {
		return unitOfResult;
	}

	/**
	 * Set the value related to the column: unit_of_result
	 * 
	 * @param unitOfResult
	 *            the unit_of_result value
	 */
	public void setUnitOfResult(java.lang.String unitOfResult) {
		this.unitOfResult = unitOfResult;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.SubTest))
			return false;
		else {
			jkt.hms.masters.business.SubTest subTest = (jkt.hms.masters.business.SubTest) obj;
			if (null == this.getId() || null == subTest.getId())
				return false;
			else
				return (this.getId().equals(subTest.getId()));
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