package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DMA_REGISTER_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DMA_REGISTER_DETAILS"
 */

public abstract class BaseDmaRegisterDetails  implements Serializable {

	public static String REF = "DmaRegisterDetails";
	public static String PROP_ITEM = "Item";
	public static String PROP_ISSUE_QTY = "IssueQty";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DMA_REGISTER_HEADER = "DmaRegisterHeader";
	public static String PROP_STOCK = "Stock";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_ROUTE = "Route";


	// constructors
	public BaseDmaRegisterDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDmaRegisterDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dosage;
	private java.lang.Integer issueQty;
	private java.lang.String remarks;
	private java.lang.String route;
	private java.lang.Integer noOfDays;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.DmaRegisterHeader dmaRegisterHeader;
	private jkt.hms.masters.business.StoreItemBatchStock stock;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="DMA_REGISTER_DETAILS_ID"
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
	 * Return the value associated with the column: DOSAGE
	 */
	public java.lang.String getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: DOSAGE
	 * @param dosage the DOSAGE value
	 */
	public void setDosage (java.lang.String dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: ISSUE_QTY
	 */
	public java.lang.Integer getIssueQty () {
		return issueQty;
	}

	/**
	 * Set the value related to the column: ISSUE_QTY
	 * @param issueQty the ISSUE_QTY value
	 */
	public void setIssueQty (java.lang.Integer issueQty) {
		this.issueQty = issueQty;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: route
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route
	 * @param route the route value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
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



	/**
	 * Return the value associated with the column: DMA_REGISTER_HEADER_ID
	 */
	public jkt.hms.masters.business.DmaRegisterHeader getDmaRegisterHeader () {
		return dmaRegisterHeader;
	}

	/**
	 * Set the value related to the column: DMA_REGISTER_HEADER_ID
	 * @param dmaRegisterHeader the DMA_REGISTER_HEADER_ID value
	 */
	public void setDmaRegisterHeader (jkt.hms.masters.business.DmaRegisterHeader dmaRegisterHeader) {
		this.dmaRegisterHeader = dmaRegisterHeader;
	}



	/**
	 * Return the value associated with the column: STOCK_ID
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStock () {
		return stock;
	}

	/**
	 * Set the value related to the column: STOCK_ID
	 * @param stock the STOCK_ID value
	 */
	public void setStock (jkt.hms.masters.business.StoreItemBatchStock stock) {
		this.stock = stock;
	}



	/**
	 * Return the value associated with the column: FREQUENCY_ID
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: FREQUENCY_ID
	 * @param frequency the FREQUENCY_ID value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DmaRegisterDetails)) return false;
		else {
			jkt.hms.masters.business.DmaRegisterDetails dmaRegisterDetails = (jkt.hms.masters.business.DmaRegisterDetails) obj;
			if (null == this.getId() || null == dmaRegisterDetails.getId()) return false;
			else return (this.getId().equals(dmaRegisterDetails.getId()));
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