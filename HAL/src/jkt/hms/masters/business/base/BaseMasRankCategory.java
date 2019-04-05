package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_rank_category table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_rank_category"
 */

public abstract class BaseMasRankCategory implements Serializable {

	public static String REF = "MasRankCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RANK_CATEGORY_CODE = "RankCategoryCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RANK_CATEGORY_NAME = "RankCategoryName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasRankCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasRankCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasRankCategory(java.lang.Integer id, java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String rankCategoryCode;
	private java.lang.String rankCategoryName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasRank> masRanks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="rank_category_id"
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
	 * Return the value associated with the column: rank_category_code
	 */
	public java.lang.String getRankCategoryCode() {
		return rankCategoryCode;
	}

	/**
	 * Set the value related to the column: rank_category_code
	 * 
	 * @param rankCategoryCode
	 *            the rank_category_code value
	 */
	public void setRankCategoryCode(java.lang.String rankCategoryCode) {
		this.rankCategoryCode = rankCategoryCode;
	}

	/**
	 * Return the value associated with the column: rank_category_name
	 */
	public java.lang.String getRankCategoryName() {
		return rankCategoryName;
	}

	/**
	 * Set the value related to the column: rank_category_name
	 * 
	 * @param rankCategoryName
	 *            the rank_category_name value
	 */
	public void setRankCategoryName(java.lang.String rankCategoryName) {
		this.rankCategoryName = rankCategoryName;
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
	 * Return the value associated with the column: MasRanks
	 */
	public java.util.Set<jkt.hms.masters.business.MasRank> getMasRanks() {
		return masRanks;
	}

	/**
	 * Set the value related to the column: MasRanks
	 * 
	 * @param masRanks
	 *            the MasRanks value
	 */
	public void setMasRanks(
			java.util.Set<jkt.hms.masters.business.MasRank> masRanks) {
		this.masRanks = masRanks;
	}

	public void addToMasRanks(jkt.hms.masters.business.MasRank masRank) {
		if (null == getMasRanks())
			setMasRanks(new java.util.TreeSet<jkt.hms.masters.business.MasRank>());
		getMasRanks().add(masRank);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasRankCategory))
			return false;
		else {
			jkt.hms.masters.business.MasRankCategory masRankCategory = (jkt.hms.masters.business.MasRankCategory) obj;
			if (null == this.getId() || null == masRankCategory.getId())
				return false;
			else
				return (this.getId().equals(masRankCategory.getId()));
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