package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_test_entry_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_test_entry_detail"
 */

public abstract class BaseBloodTestEntryDetail implements Serializable {

	public static String REF = "BloodTestEntryDetail";
	public static String PROP_TEST_HEADER = "TestHeader";
	public static String PROP_RESULT = "Result";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodTestEntryDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodTestEntryDetail(java.lang.Integer id) {
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

	// many to one
	private jkt.hms.masters.business.BloodTestEntryHeader testHeader;
	private jkt.hms.masters.business.DgMasInvestigation investigation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: test_header_id
	 */
	public jkt.hms.masters.business.BloodTestEntryHeader getTestHeader() {
		return testHeader;
	}

	/**
	 * Set the value related to the column: test_header_id
	 * 
	 * @param testHeader
	 *            the test_header_id value
	 */
	public void setTestHeader(
			jkt.hms.masters.business.BloodTestEntryHeader testHeader) {
		this.testHeader = testHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.BloodTestEntryDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodTestEntryDetail bloodTestEntryDetail = (jkt.hms.masters.business.BloodTestEntryDetail) obj;
			if (null == this.getId() || null == bloodTestEntryDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodTestEntryDetail.getId()));
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