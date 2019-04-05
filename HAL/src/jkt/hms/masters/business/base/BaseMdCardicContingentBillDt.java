package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * md_cardic_contingent_bill_dt table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_cardic_contingent_bill_dt"
 */

public abstract class BaseMdCardicContingentBillDt implements Serializable {

	public static String REF = "MdCardicContingentBillDt";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_DETAILS = "Details";
	public static String PROP_ID = "Id";
	public static String PROP_CARDIC_HD = "CardicHd";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_BILL_NO = "BillNo";

	// constructors
	public BaseMdCardicContingentBillDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdCardicContingentBillDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String billNo;
	private java.util.Date billDate;
	private java.math.BigDecimal amount;

	// many to one
	private jkt.hms.masters.business.MdCardicContingentBillHd cardicHd;
	private jkt.hms.masters.business.MasChargeCode details;

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
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo() {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * 
	 * @param billNo
	 *            the bill_no value
	 */
	public void setBillNo(java.lang.String billNo) {
		this.billNo = billNo;
	}

	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate() {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * 
	 * @param billDate
	 *            the bill_date value
	 */
	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: cardic_hd_id
	 */
	public jkt.hms.masters.business.MdCardicContingentBillHd getCardicHd() {
		return cardicHd;
	}

	/**
	 * Set the value related to the column: cardic_hd_id
	 * 
	 * @param cardicHd
	 *            the cardic_hd_id value
	 */
	public void setCardicHd(
			jkt.hms.masters.business.MdCardicContingentBillHd cardicHd) {
		this.cardicHd = cardicHd;
	}

	/**
	 * Return the value associated with the column: details
	 */
	public jkt.hms.masters.business.MasChargeCode getDetails() {
		return details;
	}

	/**
	 * Set the value related to the column: details
	 * 
	 * @param details
	 *            the details value
	 */
	public void setDetails(jkt.hms.masters.business.MasChargeCode details) {
		this.details = details;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdCardicContingentBillDt))
			return false;
		else {
			jkt.hms.masters.business.MdCardicContingentBillDt mdCardicContingentBillDt = (jkt.hms.masters.business.MdCardicContingentBillDt) obj;
			if (null == this.getId()
					|| null == mdCardicContingentBillDt.getId())
				return false;
			else
				return (this.getId().equals(mdCardicContingentBillDt.getId()));
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