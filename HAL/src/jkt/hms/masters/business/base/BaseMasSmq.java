package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_smq table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_smq"
 */

public abstract class BaseMasSmq implements Serializable {

	public static String REF = "MasSmq";
	public static String PROP_STATUS = "Status";
	public static String PROP_SMQ_TYPE = "SmqType";
	public static String PROP_SMQ_NAME = "SmqName";
	public static String PROP_POOL = "Pool";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SMQ_CODE = "SmqCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SMQ_STATUS = "SmqStatus";
	public static String PROP_POOL_CATEGORY = "PoolCategory";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_LOCATION = "Location";

	// constructors
	public BaseMasSmq() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSmq(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String smqCode;
	private java.lang.String smqName;
	private java.lang.String smqType;
	private java.lang.String smqStatus;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPool pool;
	private jkt.hms.masters.business.MasPoolCategory poolCategory;
	private jkt.hms.masters.business.MasLocation location;

	// collections
	private java.util.Set<jkt.hms.masters.business.AccomAllotment> accomAllotments;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="smq_id"
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
	 * Return the value associated with the column: smq_code
	 */
	public java.lang.String getSmqCode() {
		return smqCode;
	}

	/**
	 * Set the value related to the column: smq_code
	 * 
	 * @param smqCode
	 *            the smq_code value
	 */
	public void setSmqCode(java.lang.String smqCode) {
		this.smqCode = smqCode;
	}

	/**
	 * Return the value associated with the column: smq_name
	 */
	public java.lang.String getSmqName() {
		return smqName;
	}

	/**
	 * Set the value related to the column: smq_name
	 * 
	 * @param smqName
	 *            the smq_name value
	 */
	public void setSmqName(java.lang.String smqName) {
		this.smqName = smqName;
	}

	/**
	 * Return the value associated with the column: smq_type
	 */
	public java.lang.String getSmqType() {
		return smqType;
	}

	/**
	 * Set the value related to the column: smq_type
	 * 
	 * @param smqType
	 *            the smq_type value
	 */
	public void setSmqType(java.lang.String smqType) {
		this.smqType = smqType;
	}

	/**
	 * Return the value associated with the column: smq_status
	 */
	public java.lang.String getSmqStatus() {
		return smqStatus;
	}

	/**
	 * Set the value related to the column: smq_status
	 * 
	 * @param smqStatus
	 *            the smq_status value
	 */
	public void setSmqStatus(java.lang.String smqStatus) {
		this.smqStatus = smqStatus;
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
	 * Return the value associated with the column: pool_id
	 */
	public jkt.hms.masters.business.MasPool getPool() {
		return pool;
	}

	/**
	 * Set the value related to the column: pool_id
	 * 
	 * @param pool
	 *            the pool_id value
	 */
	public void setPool(jkt.hms.masters.business.MasPool pool) {
		this.pool = pool;
	}

	/**
	 * Return the value associated with the column: pool_category_id
	 */
	public jkt.hms.masters.business.MasPoolCategory getPoolCategory() {
		return poolCategory;
	}

	/**
	 * Set the value related to the column: pool_category_id
	 * 
	 * @param poolCategory
	 *            the pool_category_id value
	 */
	public void setPoolCategory(
			jkt.hms.masters.business.MasPoolCategory poolCategory) {
		this.poolCategory = poolCategory;
	}

	/**
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasLocation getLocation() {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * 
	 * @param location
	 *            the location_id value
	 */
	public void setLocation(jkt.hms.masters.business.MasLocation location) {
		this.location = location;
	}

	/**
	 * Return the value associated with the column: AccomAllotments
	 */
	public java.util.Set<jkt.hms.masters.business.AccomAllotment> getAccomAllotments() {
		return accomAllotments;
	}

	/**
	 * Set the value related to the column: AccomAllotments
	 * 
	 * @param accomAllotments
	 *            the AccomAllotments value
	 */
	public void setAccomAllotments(
			java.util.Set<jkt.hms.masters.business.AccomAllotment> accomAllotments) {
		this.accomAllotments = accomAllotments;
	}

	public void addToAccomAllotments(
			jkt.hms.masters.business.AccomAllotment accomAllotment) {
		if (null == getAccomAllotments())
			setAccomAllotments(new java.util.TreeSet<jkt.hms.masters.business.AccomAllotment>());
		getAccomAllotments().add(accomAllotment);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSmq))
			return false;
		else {
			jkt.hms.masters.business.MasSmq masSmq = (jkt.hms.masters.business.MasSmq) obj;
			if (null == this.getId() || null == masSmq.getId())
				return false;
			else
				return (this.getId().equals(masSmq.getId()));
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