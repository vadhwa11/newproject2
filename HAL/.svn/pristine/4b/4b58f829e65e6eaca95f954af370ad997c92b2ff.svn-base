package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * md_contigent_medical_bill_dt table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_contigent_medical_bill_dt"
 */

public abstract class BaseMdContigentMedicalBillDt implements Serializable {

	public static String REF = "MdContigentMedicalBillDt";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_BILL_HEADER = "BillHeader";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdContigentMedicalBillDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdContigentMedicalBillDt(java.lang.Integer id) {
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
	private jkt.hms.masters.business.MdContigentMedicalBillHd billHeader;

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
	 * Return the value associated with the column: bill_header_id
	 */
	public jkt.hms.masters.business.MdContigentMedicalBillHd getBillHeader() {
		return billHeader;
	}

	/**
	 * Set the value related to the column: bill_header_id
	 * 
	 * @param billHeader
	 *            the bill_header_id value
	 */
	public void setBillHeader(
			jkt.hms.masters.business.MdContigentMedicalBillHd billHeader) {
		this.billHeader = billHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdContigentMedicalBillDt))
			return false;
		else {
			jkt.hms.masters.business.MdContigentMedicalBillDt mdContigentMedicalBillDt = (jkt.hms.masters.business.MdContigentMedicalBillDt) obj;
			if (null == this.getId()
					|| null == mdContigentMedicalBillDt.getId())
				return false;
			else
				return (this.getId().equals(mdContigentMedicalBillDt.getId()));
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