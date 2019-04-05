package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mis_bed_state table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mis_bed_state"
 */

public abstract class BaseMisBedState implements Serializable {

	public static String REF = "MisBedState";
	public static String PROP_ORS = "Ors";
	public static String PROP_OFFICERS = "Officers";
	public static String PROP_BED_STATE = "BedState";
	public static String PROP_TOTAL = "Total";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMisBedState() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisBedState(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bedState;
	private java.lang.Integer officers;
	private java.lang.Integer ors;
	private java.lang.Integer total;

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
	 * Return the value associated with the column: bed_state
	 */
	public java.lang.String getBedState() {
		return bedState;
	}

	/**
	 * Set the value related to the column: bed_state
	 * 
	 * @param bedState
	 *            the bed_state value
	 */
	public void setBedState(java.lang.String bedState) {
		this.bedState = bedState;
	}

	/**
	 * Return the value associated with the column: officers
	 */
	public java.lang.Integer getOfficers() {
		return officers;
	}

	/**
	 * Set the value related to the column: officers
	 * 
	 * @param officers
	 *            the officers value
	 */
	public void setOfficers(java.lang.Integer officers) {
		this.officers = officers;
	}

	/**
	 * Return the value associated with the column: ors
	 */
	public java.lang.Integer getOrs() {
		return ors;
	}

	/**
	 * Set the value related to the column: ors
	 * 
	 * @param ors
	 *            the ors value
	 */
	public void setOrs(java.lang.Integer ors) {
		this.ors = ors;
	}

	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.Integer getTotal() {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * 
	 * @param total
	 *            the total value
	 */
	public void setTotal(java.lang.Integer total) {
		this.total = total;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MisBedState))
			return false;
		else {
			jkt.hms.masters.business.MisBedState misBedState = (jkt.hms.masters.business.MisBedState) obj;
			if (null == this.getId() || null == misBedState.getId())
				return false;
			else
				return (this.getId().equals(misBedState.getId()));
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