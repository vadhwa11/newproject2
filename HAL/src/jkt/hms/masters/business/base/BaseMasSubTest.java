package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_sub_test table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_sub_test"
 */

public abstract class BaseMasSubTest implements Serializable {

	public static String REF = "MasSubTest";
	public static String PROP_STATUS = "Status";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_SUB_TEST_NAME = "SubTestName";
	public static String PROP_UNIT_OF_RESULT = "UnitOfResult";
	public static String PROP_ID = "Id";
	public static String PROP_SUB_TEST_CODE = "SubTestCode";

	// constructors
	public BaseMasSubTest() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSubTest(java.lang.Integer id) {
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
	private java.lang.String subTestName;
	private java.lang.String status;
	private java.lang.String normalValue;
	private java.lang.String unitOfResult;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;

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
	 * Return the value associated with the column: sub_test_name
	 */
	public java.lang.String getSubTestName() {
		return subTestName;
	}

	/**
	 * Set the value related to the column: sub_test_name
	 * 
	 * @param subTestName
	 *            the sub_test_name value
	 */
	public void setSubTestName(java.lang.String subTestName) {
		this.subTestName = subTestName;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSubTest))
			return false;
		else {
			jkt.hms.masters.business.MasSubTest masSubTest = (jkt.hms.masters.business.MasSubTest) obj;
			if (null == this.getId() || null == masSubTest.getId())
				return false;
			else
				return (this.getId().equals(masSubTest.getId()));
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