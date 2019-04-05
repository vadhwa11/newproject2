package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * md_special_investigation_dt table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_special_investigation_dt"
 */

public abstract class BaseMdSpecialInvestigationDt implements Serializable {

	public static String REF = "MdSpecialInvestigationDt";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_SPECIAL_INV = "SpecialInv";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdSpecialInvestigationDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdSpecialInvestigationDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasChargeCode charge;
	private jkt.hms.masters.business.MdSpecialInvestigationHd specialInv;

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
	 * Return the value associated with the column: charge_id
	 */
	public jkt.hms.masters.business.MasChargeCode getCharge() {
		return charge;
	}

	/**
	 * Set the value related to the column: charge_id
	 * 
	 * @param charge
	 *            the charge_id value
	 */
	public void setCharge(jkt.hms.masters.business.MasChargeCode charge) {
		this.charge = charge;
	}

	/**
	 * Return the value associated with the column: special_inv_id
	 */
	public jkt.hms.masters.business.MdSpecialInvestigationHd getSpecialInv() {
		return specialInv;
	}

	/**
	 * Set the value related to the column: special_inv_id
	 * 
	 * @param specialInv
	 *            the special_inv_id value
	 */
	public void setSpecialInv(
			jkt.hms.masters.business.MdSpecialInvestigationHd specialInv) {
		this.specialInv = specialInv;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdSpecialInvestigationDt))
			return false;
		else {
			jkt.hms.masters.business.MdSpecialInvestigationDt mdSpecialInvestigationDt = (jkt.hms.masters.business.MdSpecialInvestigationDt) obj;
			if (null == this.getId()
					|| null == mdSpecialInvestigationDt.getId())
				return false;
			else
				return (this.getId().equals(mdSpecialInvestigationDt.getId()));
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