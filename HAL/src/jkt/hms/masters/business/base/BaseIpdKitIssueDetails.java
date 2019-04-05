package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the IPD_KIT_ISSUE_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="IPD_KIT_ISSUE_DETAILS"
 */

public abstract class BaseIpdKitIssueDetails  implements Serializable {

	public static String REF = "IpdKitIssueDetails";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ITEM = "Item";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ID = "Id";
	public static String PROP_IPD_KIT_ISSUE_HEADER = "IpdKitIssueHeader";


	// constructors
	public BaseIpdKitIssueDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdKitIssueDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemName;
	private java.lang.Integer quantity;

	// many to one
	private jkt.hms.masters.business.IpdKitIssueHeader ipdKitIssueHeader;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="IPD_KIT_ISSUE_DETAILS_ID"
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
	 * Return the value associated with the column: ITEM_NAME
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: ITEM_NAME
	 * @param itemName the ITEM_NAME value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
	}



	/**
	 * Return the value associated with the column: QUANTITY
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: QUANTITY
	 * @param quantity the QUANTITY value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: IPD_KIT_ISSUE_HEADER_ID
	 */
	public jkt.hms.masters.business.IpdKitIssueHeader getIpdKitIssueHeader () {
		return ipdKitIssueHeader;
	}

	/**
	 * Set the value related to the column: IPD_KIT_ISSUE_HEADER_ID
	 * @param ipdKitIssueHeader the IPD_KIT_ISSUE_HEADER_ID value
	 */
	public void setIpdKitIssueHeader (jkt.hms.masters.business.IpdKitIssueHeader ipdKitIssueHeader) {
		this.ipdKitIssueHeader = ipdKitIssueHeader;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdKitIssueDetails)) return false;
		else {
			jkt.hms.masters.business.IpdKitIssueDetails ipdKitIssueDetails = (jkt.hms.masters.business.IpdKitIssueDetails) obj;
			if (null == this.getId() || null == ipdKitIssueDetails.getId()) return false;
			else return (this.getId().equals(ipdKitIssueDetails.getId()));
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