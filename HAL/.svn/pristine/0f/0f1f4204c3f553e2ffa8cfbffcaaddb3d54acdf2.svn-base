package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_block table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_block"
 */

public abstract class BaseMasBlock implements Serializable {

	public static String REF = "MasBlock";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BLOCK_CODE = "BlockCode";
	public static String PROP_BLOCK_NAME = "BlockName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasBlock() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBlock(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String blockCode;
	private java.lang.String blockName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDistrict district;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.MasPostCode> masPostCodes;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="block_id"
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
	 * Return the value associated with the column: block_code
	 */
	public java.lang.String getBlockCode() {
		return blockCode;
	}

	/**
	 * Set the value related to the column: block_code
	 * 
	 * @param blockCode
	 *            the block_code value
	 */
	public void setBlockCode(java.lang.String blockCode) {
		this.blockCode = blockCode;
	}

	/**
	 * Return the value associated with the column: block_name
	 */
	public java.lang.String getBlockName() {
		return blockName;
	}

	/**
	 * Set the value related to the column: block_name
	 * 
	 * @param blockName
	 *            the block_name value
	 */
	public void setBlockName(java.lang.String blockName) {
		this.blockName = blockName;
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
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict() {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * 
	 * @param district
	 *            the district_id value
	 */
	public void setDistrict(jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}

	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients() {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * 
	 * @param patients
	 *            the Patients value
	 */
	public void setPatients(
			java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients(jkt.hms.masters.business.Patient patient) {
		if (null == getPatients())
			setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}

	/**
	 * Return the value associated with the column: MasPostCodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasPostCode> getMasPostCodes() {
		return masPostCodes;
	}

	/**
	 * Set the value related to the column: MasPostCodes
	 * 
	 * @param masPostCodes
	 *            the MasPostCodes value
	 */
	public void setMasPostCodes(
			java.util.Set<jkt.hms.masters.business.MasPostCode> masPostCodes) {
		this.masPostCodes = masPostCodes;
	}

	public void addToMasPostCodes(
			jkt.hms.masters.business.MasPostCode masPostCode) {
		if (null == getMasPostCodes())
			setMasPostCodes(new java.util.TreeSet<jkt.hms.masters.business.MasPostCode>());
		getMasPostCodes().add(masPostCode);
	}

	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails() {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * 
	 * @param expiryDetails
	 *            the ExpiryDetails value
	 */
	public void setExpiryDetails(
			java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails(
			jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails())
			setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBlock))
			return false;
		else {
			jkt.hms.masters.business.MasBlock masBlock = (jkt.hms.masters.business.MasBlock) obj;
			if (null == this.getId() || null == masBlock.getId())
				return false;
			else
				return (this.getId().equals(masBlock.getId()));
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