package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_PROFORMA_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_PROFORMA_DETAIL"
 */

public abstract class BaseStoreProformaDetail  implements Serializable {

	public static String REF = "StoreProformaDetail";
	public static String PROP_AU = "AU";
	public static String PROP_INDENT_NO = "IndentNo";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_QTY = "Qty";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_TAX = "Tax";
	public static String PROP_RATE = "Rate";
	public static String PROP_CHANGE_DATE = "ChangeDate";
	public static String PROP_PRESCRIPTION_ID = "PrescriptionId";
	public static String PROP_CRV_ID = "CrvId";


	// constructors
	public BaseStoreProformaDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreProformaDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreProformaDetail (
		java.lang.Integer id,
		java.math.BigDecimal qty,
		java.math.BigDecimal rate) {

		this.setId(id);
		this.setQty(qty);
		this.setRate(rate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String aU;
	private java.lang.String indentNo;
	private java.lang.String category;
	private java.math.BigDecimal qty;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal rate;
	private java.util.Date changeDate;
	private java.lang.String prescriptionId;
	private java.lang.Integer crvId;

	// many to one
	private jkt.hms.masters.business.StoreProformaHeader po;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PROFORMA_DETAIL_ID"
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
	 * Return the value associated with the column: AU
	 */
	public java.lang.String getAU () {
		return aU;
	}

	/**
	 * Set the value related to the column: AU
	 * @param aU the AU value
	 */
	public void setAU (java.lang.String aU) {
		this.aU = aU;
	}



	/**
	 * Return the value associated with the column: INDENT_NO
	 */
	public java.lang.String getIndentNo () {
		return indentNo;
	}

	/**
	 * Set the value related to the column: INDENT_NO
	 * @param indentNo the INDENT_NO value
	 */
	public void setIndentNo (java.lang.String indentNo) {
		this.indentNo = indentNo;
	}



	/**
	 * Return the value associated with the column: CATEGORY
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY
	 * @param category the CATEGORY value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: QTY
	 */
	public java.math.BigDecimal getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: QTY
	 * @param qty the QTY value
	 */
	public void setQty (java.math.BigDecimal qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.math.BigDecimal discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: tax
	 */
	public java.math.BigDecimal getTax () {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * @param tax the tax value
	 */
	public void setTax (java.math.BigDecimal tax) {
		this.tax = tax;
	}



	/**
	 * Return the value associated with the column: RATE
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: PRESCRIPTION_ID
	 */
	public java.lang.String getPrescriptionId () {
		return prescriptionId;
	}

	/**
	 * Set the value related to the column: PRESCRIPTION_ID
	 * @param prescriptionId the PRESCRIPTION_ID value
	 */
	public void setPrescriptionId (java.lang.String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}



	/**
	 * Return the value associated with the column: CRV_ID
	 */
	public java.lang.Integer getCrvId () {
		return crvId;
	}

	/**
	 * Set the value related to the column: CRV_ID
	 * @param crvId the CRV_ID value
	 */
	public void setCrvId (java.lang.Integer crvId) {
		this.crvId = crvId;
	}



	/**
	 * Return the value associated with the column: PROFORMA_ID
	 */
	public jkt.hms.masters.business.StoreProformaHeader getPo () {
		return po;
	}

	/**
	 * Set the value related to the column: PROFORMA_ID
	 * @param po the PROFORMA_ID value
	 */
	public void setPo (jkt.hms.masters.business.StoreProformaHeader po) {
		this.po = po;
	}



	/**
	 * Return the value associated with the column: ITEM_ID
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: ITEM_ID
	 * @param item the ITEM_ID value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreProformaDetail)) return false;
		else {
			jkt.hms.masters.business.StoreProformaDetail storeProformaDetail = (jkt.hms.masters.business.StoreProformaDetail) obj;
			if (null == this.getId() || null == storeProformaDetail.getId()) return false;
			else return (this.getId().equals(storeProformaDetail.getId()));
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