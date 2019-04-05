package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_surgey_pa_surgey_detail table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_surgey_pa_surgey_detail"
 */

public abstract class BaseOtSurgeyPaSurgeyDetail implements Serializable {

	public static String REF = "OtSurgeyPaSurgeyDetail";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_OT_POST_ANAESTHESIA_PROCEDURE = "OtPostAnaesthesiaProcedure";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOtSurgeyPaSurgeyDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSurgeyPaSurgeyDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="surgey_pa_surgey_detail_id"
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

	/**
	 * Return the value associated with the column:
	 * ot_post_anaesthesia_procedure_id
	 */
	public jkt.hms.masters.business.OtPostAnaesthesiaProcedure getOtPostAnaesthesiaProcedure() {
		return otPostAnaesthesiaProcedure;
	}

	/**
	 * Set the value related to the column: ot_post_anaesthesia_procedure_id
	 * 
	 * @param otPostAnaesthesiaProcedure
	 *            the ot_post_anaesthesia_procedure_id value
	 */
	public void setOtPostAnaesthesiaProcedure(
			jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure) {
		this.otPostAnaesthesiaProcedure = otPostAnaesthesiaProcedure;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtSurgeyPaSurgeyDetail))
			return false;
		else {
			jkt.hms.masters.business.OtSurgeyPaSurgeyDetail otSurgeyPaSurgeyDetail = (jkt.hms.masters.business.OtSurgeyPaSurgeyDetail) obj;
			if (null == this.getId() || null == otSurgeyPaSurgeyDetail.getId())
				return false;
			else
				return (this.getId().equals(otSurgeyPaSurgeyDetail.getId()));
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