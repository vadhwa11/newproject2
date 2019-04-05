package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_amc_t table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="store_amc_t"
 */

public abstract class BaseStoreAmcT implements Serializable {

	public static String REF = "StoreAmcT";
	public static String PROP_COST_OF_AMC = "CostOfAmc";
	public static String PROP_ADV_BILL_DATE = "AdvBillDate";
	public static String PROP_AMC_M = "AmcM";
	public static String PROP_BALANCE_BILL_DATE = "BalanceBillDate";
	public static String PROP_AMC_START_DATE = "AmcStartDate";
	public static String PROP_AMC_END_DATE = "AmcEndDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ADV_BILL_NO = "AdvBillNo";
	public static String PROP_AMC_COMPANY = "AmcCompany";
	public static String PROP_BALANCE_BILL_NO = "BalanceBillNo";
	public static String PROP_BALANCE_BILL_AMOUNT = "BalanceBillAmount";
	public static String PROP_ADV_BILL_AMOUNT = "AdvBillAmount";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreAmcT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreAmcT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date amcStartDate;
	private java.util.Date amcEndDate;
	private java.math.BigDecimal costOfAmc;
	private java.lang.String advBillNo;
	private java.util.Date advBillDate;
	private java.math.BigDecimal advBillAmount;
	private java.lang.String balanceBillNo;
	private java.util.Date balanceBillDate;
	private java.math.BigDecimal balanceBillAmount;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.StoreAmcM amcM;
	private jkt.hms.masters.business.MasStoreSupplier amcCompany;

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
	 * Return the value associated with the column: amc_start_date
	 */
	public java.util.Date getAmcStartDate() {
		return amcStartDate;
	}

	/**
	 * Set the value related to the column: amc_start_date
	 * 
	 * @param amcStartDate
	 *            the amc_start_date value
	 */
	public void setAmcStartDate(java.util.Date amcStartDate) {
		this.amcStartDate = amcStartDate;
	}

	/**
	 * Return the value associated with the column: amc_end_date
	 */
	public java.util.Date getAmcEndDate() {
		return amcEndDate;
	}

	/**
	 * Set the value related to the column: amc_end_date
	 * 
	 * @param amcEndDate
	 *            the amc_end_date value
	 */
	public void setAmcEndDate(java.util.Date amcEndDate) {
		this.amcEndDate = amcEndDate;
	}

	/**
	 * Return the value associated with the column: cost_of_amc
	 */
	public java.math.BigDecimal getCostOfAmc() {
		return costOfAmc;
	}

	/**
	 * Set the value related to the column: cost_of_amc
	 * 
	 * @param costOfAmc
	 *            the cost_of_amc value
	 */
	public void setCostOfAmc(java.math.BigDecimal costOfAmc) {
		this.costOfAmc = costOfAmc;
	}

	/**
	 * Return the value associated with the column: adv_bill_no
	 */
	public java.lang.String getAdvBillNo() {
		return advBillNo;
	}

	/**
	 * Set the value related to the column: adv_bill_no
	 * 
	 * @param advBillNo
	 *            the adv_bill_no value
	 */
	public void setAdvBillNo(java.lang.String advBillNo) {
		this.advBillNo = advBillNo;
	}

	/**
	 * Return the value associated with the column: adv_bill_date
	 */
	public java.util.Date getAdvBillDate() {
		return advBillDate;
	}

	/**
	 * Set the value related to the column: adv_bill_date
	 * 
	 * @param advBillDate
	 *            the adv_bill_date value
	 */
	public void setAdvBillDate(java.util.Date advBillDate) {
		this.advBillDate = advBillDate;
	}

	/**
	 * Return the value associated with the column: adv_bill_amount
	 */
	public java.math.BigDecimal getAdvBillAmount() {
		return advBillAmount;
	}

	/**
	 * Set the value related to the column: adv_bill_amount
	 * 
	 * @param advBillAmount
	 *            the adv_bill_amount value
	 */
	public void setAdvBillAmount(java.math.BigDecimal advBillAmount) {
		this.advBillAmount = advBillAmount;
	}

	/**
	 * Return the value associated with the column: balance_bill_no
	 */
	public java.lang.String getBalanceBillNo() {
		return balanceBillNo;
	}

	/**
	 * Set the value related to the column: balance_bill_no
	 * 
	 * @param balanceBillNo
	 *            the balance_bill_no value
	 */
	public void setBalanceBillNo(java.lang.String balanceBillNo) {
		this.balanceBillNo = balanceBillNo;
	}

	/**
	 * Return the value associated with the column: balance_bill_date
	 */
	public java.util.Date getBalanceBillDate() {
		return balanceBillDate;
	}

	/**
	 * Set the value related to the column: balance_bill_date
	 * 
	 * @param balanceBillDate
	 *            the balance_bill_date value
	 */
	public void setBalanceBillDate(java.util.Date balanceBillDate) {
		this.balanceBillDate = balanceBillDate;
	}

	/**
	 * Return the value associated with the column: balance_bill_amount
	 */
	public java.math.BigDecimal getBalanceBillAmount() {
		return balanceBillAmount;
	}

	/**
	 * Set the value related to the column: balance_bill_amount
	 * 
	 * @param balanceBillAmount
	 *            the balance_bill_amount value
	 */
	public void setBalanceBillAmount(java.math.BigDecimal balanceBillAmount) {
		this.balanceBillAmount = balanceBillAmount;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: amc_m_id
	 */
	public jkt.hms.masters.business.StoreAmcM getAmcM() {
		return amcM;
	}

	/**
	 * Set the value related to the column: amc_m_id
	 * 
	 * @param amcM
	 *            the amc_m_id value
	 */
	public void setAmcM(jkt.hms.masters.business.StoreAmcM amcM) {
		this.amcM = amcM;
	}

	/**
	 * Return the value associated with the column: amc_company_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getAmcCompany() {
		return amcCompany;
	}

	/**
	 * Set the value related to the column: amc_company_id
	 * 
	 * @param amcCompany
	 *            the amc_company_id value
	 */
	public void setAmcCompany(
			jkt.hms.masters.business.MasStoreSupplier amcCompany) {
		this.amcCompany = amcCompany;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreAmcT))
			return false;
		else {
			jkt.hms.masters.business.StoreAmcT storeAmcT = (jkt.hms.masters.business.StoreAmcT) obj;
			if (null == this.getId() || null == storeAmcT.getId())
				return false;
			else
				return (this.getId().equals(storeAmcT.getId()));
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