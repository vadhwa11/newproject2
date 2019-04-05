package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_pool table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_pool"
 */

public abstract class BaseMasPool implements Serializable {

	public static String REF = "MasPool";
	public static String PROP_STATUS = "Status";
	public static String PROP_AUTHORISATION = "Authorisation";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_POOL_NAME = "PoolName";
	public static String PROP_POOL_CODE = "PoolCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RANK = "Rank";
	public static String PROP_POOL_CATEGORY = "PoolCategory";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasPool() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPool(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String poolCode;
	private java.lang.String poolName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer authorisation;

	// many to one
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasPoolCategory poolCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.PoolRank> poolRanks;
	private java.util.Set<jkt.hms.masters.business.MasSmq> masSmqs;
	private java.util.Set<jkt.hms.masters.business.AccomRegistration> accomRegistrations;
	private java.util.Set<jkt.hms.masters.business.AccomAllotment> accomAllotments;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="pool_id"
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
	 * Return the value associated with the column: pool_code
	 */
	public java.lang.String getPoolCode() {
		return poolCode;
	}

	/**
	 * Set the value related to the column: pool_code
	 * 
	 * @param poolCode
	 *            the pool_code value
	 */
	public void setPoolCode(java.lang.String poolCode) {
		this.poolCode = poolCode;
	}

	/**
	 * Return the value associated with the column: pool_name
	 */
	public java.lang.String getPoolName() {
		return poolName;
	}

	/**
	 * Set the value related to the column: pool_name
	 * 
	 * @param poolName
	 *            the pool_name value
	 */
	public void setPoolName(java.lang.String poolName) {
		this.poolName = poolName;
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
	 * Return the value associated with the column: authorisation
	 */
	public java.lang.Integer getAuthorisation() {
		return authorisation;
	}

	/**
	 * Set the value related to the column: authorisation
	 * 
	 * @param authorisation
	 *            the authorisation value
	 */
	public void setAuthorisation(java.lang.Integer authorisation) {
		this.authorisation = authorisation;
	}

	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * 
	 * @param rank
	 *            the rank_id value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
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
	 * Return the value associated with the column: PoolRanks
	 */
	public java.util.Set<jkt.hms.masters.business.PoolRank> getPoolRanks() {
		return poolRanks;
	}

	/**
	 * Set the value related to the column: PoolRanks
	 * 
	 * @param poolRanks
	 *            the PoolRanks value
	 */
	public void setPoolRanks(
			java.util.Set<jkt.hms.masters.business.PoolRank> poolRanks) {
		this.poolRanks = poolRanks;
	}

	public void addToPoolRanks(jkt.hms.masters.business.PoolRank poolRank) {
		if (null == getPoolRanks())
			setPoolRanks(new java.util.TreeSet<jkt.hms.masters.business.PoolRank>());
		getPoolRanks().add(poolRank);
	}

	/**
	 * Return the value associated with the column: MasSmqs
	 */
	public java.util.Set<jkt.hms.masters.business.MasSmq> getMasSmqs() {
		return masSmqs;
	}

	/**
	 * Set the value related to the column: MasSmqs
	 * 
	 * @param masSmqs
	 *            the MasSmqs value
	 */
	public void setMasSmqs(
			java.util.Set<jkt.hms.masters.business.MasSmq> masSmqs) {
		this.masSmqs = masSmqs;
	}

	public void addToMasSmqs(jkt.hms.masters.business.MasSmq masSmq) {
		if (null == getMasSmqs())
			setMasSmqs(new java.util.TreeSet<jkt.hms.masters.business.MasSmq>());
		getMasSmqs().add(masSmq);
	}

	/**
	 * Return the value associated with the column: AccomRegistrations
	 */
	public java.util.Set<jkt.hms.masters.business.AccomRegistration> getAccomRegistrations() {
		return accomRegistrations;
	}

	/**
	 * Set the value related to the column: AccomRegistrations
	 * 
	 * @param accomRegistrations
	 *            the AccomRegistrations value
	 */
	public void setAccomRegistrations(
			java.util.Set<jkt.hms.masters.business.AccomRegistration> accomRegistrations) {
		this.accomRegistrations = accomRegistrations;
	}

	public void addToAccomRegistrations(
			jkt.hms.masters.business.AccomRegistration accomRegistration) {
		if (null == getAccomRegistrations())
			setAccomRegistrations(new java.util.TreeSet<jkt.hms.masters.business.AccomRegistration>());
		getAccomRegistrations().add(accomRegistration);
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
		if (!(obj instanceof jkt.hms.masters.business.MasPool))
			return false;
		else {
			jkt.hms.masters.business.MasPool masPool = (jkt.hms.masters.business.MasPool) obj;
			if (null == this.getId() || null == masPool.getId())
				return false;
			else
				return (this.getId().equals(masPool.getId()));
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