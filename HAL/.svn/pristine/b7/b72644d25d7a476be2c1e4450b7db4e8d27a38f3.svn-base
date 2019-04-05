package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_PROFORMA_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_PROFORMA_HEADER"
 */

public abstract class BaseStoreProformaHeader  implements Serializable {

	public static String REF = "StoreProformaHeader";
	public static String PROP_PROFORMA_NO = "ProformaNo";
	public static String PROP_PROFORMA_DATE = "ProformaDate";
	public static String PROP_CHANGE_DATE = "ChangeDate";
	public static String PROP_INVOICE_NO = "InvoiceNo";
	public static String PROP_INVOICE_DATE = "InvoiceDate";
	public static String PROP_INVOICE_AMOUNT = "InvoiceAmount";
	public static String PROP_TOTAL_ALLOCATED_AMOUNT = "TotalAllocatedAmount";
	public static String PROP_BALANCE_AMOUNT = "BalanceAmount";
	public static String PROP_SPEND_AMOUNT = "SpendAmount";
	public static String PROP_STATUS = "Status";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_PROFORMA_DATE_FROM = "ProformaDateFrom";
	public static String PROP_PROFORMA_DATE_TO = "ProformaDateTo";
	public static String PROP_PROFORMA_LAST_UPDATE = "ProformaLastUpdate";


	// constructors
	public BaseStoreProformaHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreProformaHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String proformaNo;
	private java.util.Date proformaDate;
	private java.util.Date changeDate;
	private java.lang.String invoiceNo;
	private java.util.Date invoiceDate;
	private java.math.BigDecimal invoiceAmount;
	private java.math.BigDecimal totalAllocatedAmount;
	private java.math.BigDecimal balanceAmount;
	private java.math.BigDecimal spendAmount;
	private java.lang.String status;
	private java.math.BigDecimal roundOff;
	private java.util.Date proformaDateFrom;
	private java.util.Date proformaDateTo;
	private java.util.Date proformaLastUpdate;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set storeProformaDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PROFORMA_ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PROFORMA_NO
	 */
	public java.lang.String getProformaNo () {
		return proformaNo;
	}

	/**
	 * Set the value related to the column: PROFORMA_NO
	 * @param proformaNo the PROFORMA_NO value
	 */
	public void setProformaNo (java.lang.String proformaNo) {
		this.proformaNo = proformaNo;
	}



	/**
	 * Return the value associated with the column: PROFORMA_DATE
	 */
	public java.util.Date getProformaDate () {
		return proformaDate;
	}

	/**
	 * Set the value related to the column: PROFORMA_DATE
	 * @param proformaDate the PROFORMA_DATE value
	 */
	public void setProformaDate (java.util.Date proformaDate) {
		this.proformaDate = proformaDate;
	}



	/**
	 * Return the value associated with the column: CHANGE_DATE
	 */
	public java.util.Date getChangeDate () {
		return changeDate;
	}

	/**
	 * Set the value related to the column: CHANGE_DATE
	 * @param changeDate the CHANGE_DATE value
	 */
	public void setChangeDate (java.util.Date changeDate) {
		this.changeDate = changeDate;
	}



	/**
	 * Return the value associated with the column: invoice_no
	 */
	public java.lang.String getInvoiceNo () {
		return invoiceNo;
	}

	/**
	 * Set the value related to the column: invoice_no
	 * @param invoiceNo the invoice_no value
	 */
	public void setInvoiceNo (java.lang.String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}



	/**
	 * Return the value associated with the column: invoice_date
	 */
	public java.util.Date getInvoiceDate () {
		return invoiceDate;
	}

	/**
	 * Set the value related to the column: invoice_date
	 * @param invoiceDate the invoice_date value
	 */
	public void setInvoiceDate (java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	/**
	 * Return the value associated with the column: invoice_amount
	 */
	public java.math.BigDecimal getInvoiceAmount () {
		return invoiceAmount;
	}

	/**
	 * Set the value related to the column: invoice_amount
	 * @param invoiceAmount the invoice_amount value
	 */
	public void setInvoiceAmount (java.math.BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}



	/**
	 * Return the value associated with the column: total_allocated_amount
	 */
	public java.math.BigDecimal getTotalAllocatedAmount () {
		return totalAllocatedAmount;
	}

	/**
	 * Set the value related to the column: total_allocated_amount
	 * @param totalAllocatedAmount the total_allocated_amount value
	 */
	public void setTotalAllocatedAmount (java.math.BigDecimal totalAllocatedAmount) {
		this.totalAllocatedAmount = totalAllocatedAmount;
	}



	/**
	 * Return the value associated with the column: balance_amount
	 */
	public java.math.BigDecimal getBalanceAmount () {
		return balanceAmount;
	}

	/**
	 * Set the value related to the column: balance_amount
	 * @param balanceAmount the balance_amount value
	 */
	public void setBalanceAmount (java.math.BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}



	/**
	 * Return the value associated with the column: spend_amount
	 */
	public java.math.BigDecimal getSpendAmount () {
		return spendAmount;
	}

	/**
	 * Set the value related to the column: spend_amount
	 * @param spendAmount the spend_amount value
	 */
	public void setSpendAmount (java.math.BigDecimal spendAmount) {
		this.spendAmount = spendAmount;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: ROUND_OFF
	 */
	public java.math.BigDecimal getRoundOff () {
		return roundOff;
	}

	/**
	 * Set the value related to the column: ROUND_OFF
	 * @param roundOff the ROUND_OFF value
	 */
	public void setRoundOff (java.math.BigDecimal roundOff) {
		this.roundOff = roundOff;
	}



	/**
	 * Return the value associated with the column: CHALLAN_FROM_DATE
	 */
	public java.util.Date getProformaDateFrom () {
		return proformaDateFrom;
	}

	/**
	 * Set the value related to the column: CHALLAN_FROM_DATE
	 * @param proformaDateFrom the CHALLAN_FROM_DATE value
	 */
	public void setProformaDateFrom (java.util.Date proformaDateFrom) {
		this.proformaDateFrom = proformaDateFrom;
	}



	/**
	 * Return the value associated with the column: CHALLAN_TO_DATE
	 */
	public java.util.Date getProformaDateTo () {
		return proformaDateTo;
	}

	/**
	 * Set the value related to the column: CHALLAN_TO_DATE
	 * @param proformaDateTo the CHALLAN_TO_DATE value
	 */
	public void setProformaDateTo (java.util.Date proformaDateTo) {
		this.proformaDateTo = proformaDateTo;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATE_DATE
	 */
	public java.util.Date getProformaLastUpdate () {
		return proformaLastUpdate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATE_DATE
	 * @param proformaLastUpdate the LAST_UPDATE_DATE value
	 */
	public void setProformaLastUpdate (java.util.Date proformaLastUpdate) {
		this.proformaLastUpdate = proformaLastUpdate;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param department the DEPARTMENT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: StoreProformaDetails
	 */
	public java.util.Set getStoreProformaDetails () {
		return storeProformaDetails;
	}

	/**
	 * Set the value related to the column: StoreProformaDetails
	 * @param storeProformaDetails the StoreProformaDetails value
	 */
	public void setStoreProformaDetails (java.util.Set storeProformaDetails) {
		this.storeProformaDetails = storeProformaDetails;
	}

	public void addToStoreProformaDetails (jkt.hms.masters.business.StoreProformaDetail storeProformaDetail) {
		if (null == getStoreProformaDetails()) setStoreProformaDetails(new java.util.HashSet());
		getStoreProformaDetails().add(storeProformaDetail);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreProformaHeader)) return false;
		else {
			jkt.hms.masters.business.StoreProformaHeader storeProformaHeader = (jkt.hms.masters.business.StoreProformaHeader) obj;
			if (null == this.getId() || null == storeProformaHeader.getId()) return false;
			else return (this.getId().equals(storeProformaHeader.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}