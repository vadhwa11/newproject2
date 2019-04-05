package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pool_rank table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="pool_rank"
 */

public abstract class BasePoolRank implements Serializable {

	public static String REF = "PoolRank";
	public static String PROP_POOL = "Pool";
	public static String PROP_RANK = "Rank";
	public static String PROP_ID = "Id";

	// constructors
	public BasePoolRank() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePoolRank(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasPool pool;
	private jkt.hms.masters.business.MasRank rank;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="pool_rank_id"
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PoolRank))
			return false;
		else {
			jkt.hms.masters.business.PoolRank poolRank = (jkt.hms.masters.business.PoolRank) obj;
			if (null == this.getId() || null == poolRank.getId())
				return false;
			else
				return (this.getId().equals(poolRank.getId()));
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