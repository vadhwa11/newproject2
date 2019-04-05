package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_sample table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_sample"
 */

public abstract class BaseMasSample implements Serializable {

	public static String REF = "MasSample";
	public static String PROP_STATUS = "Status";
	public static String PROP_UOM = "Uom";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SAMPLE_DESCRIPTION = "SampleDescription";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COLLECTION = "Collection";
	public static String PROP_SAMPLE_CODE = "SampleCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasSample() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSample(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sampleCode;
	private java.lang.String sampleDescription;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.DgMasCollection collection;
	private jkt.hms.masters.business.DgUom uom;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="sample_id"
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
	 * Return the value associated with the column: sample_code
	 */
	public java.lang.String getSampleCode() {
		return sampleCode;
	}

	/**
	 * Set the value related to the column: sample_code
	 * 
	 * @param sampleCode
	 *            the sample_code value
	 */
	public void setSampleCode(java.lang.String sampleCode) {
		this.sampleCode = sampleCode;
	}

	/**
	 * Return the value associated with the column: sample_description
	 */
	public java.lang.String getSampleDescription() {
		return sampleDescription;
	}

	/**
	 * Set the value related to the column: sample_description
	 * 
	 * @param sampleDescription
	 *            the sample_description value
	 */
	public void setSampleDescription(java.lang.String sampleDescription) {
		this.sampleDescription = sampleDescription;
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
	 * Return the value associated with the column: collection_id
	 */
	public jkt.hms.masters.business.DgMasCollection getCollection() {
		return collection;
	}

	/**
	 * Set the value related to the column: collection_id
	 * 
	 * @param collection
	 *            the collection_id value
	 */
	public void setCollection(
			jkt.hms.masters.business.DgMasCollection collection) {
		this.collection = collection;
	}

	/**
	 * Return the value associated with the column: uom_id
	 */
	public jkt.hms.masters.business.DgUom getUom() {
		return uom;
	}

	/**
	 * Set the value related to the column: uom_id
	 * 
	 * @param uom
	 *            the uom_id value
	 */
	public void setUom(jkt.hms.masters.business.DgUom uom) {
		this.uom = uom;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSample))
			return false;
		else {
			jkt.hms.masters.business.MasSample masSample = (jkt.hms.masters.business.MasSample) obj;
			if (null == this.getId() || null == masSample.getId())
				return false;
			else
				return (this.getId().equals(masSample.getId()));
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