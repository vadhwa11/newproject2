package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the kit_issue_master_template_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="kit_issue_master_template_t"
 */

public abstract class BaseKitIssueMasterTemplateT  implements Serializable {

	public static String REF = "KitIssueMasterTemplateT";
	public static String PROP_STATUS = "Status";
	public static String PROP_ITEM = "Item";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ID = "Id";
	public static String PROP_AUTH_QUANTITY = "AuthQuantity";


	// constructors
	public BaseKitIssueMasterTemplateT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseKitIssueMasterTemplateT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer authQuantity;
	private java.lang.String itemName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.KitIssueMasterTemplateM template;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: auth_quantity
	 */
	public java.lang.Integer getAuthQuantity () {
		return authQuantity;
	}

	/**
	 * Set the value related to the column: auth_quantity
	 * @param authQuantity the auth_quantity value
	 */
	public void setAuthQuantity (java.lang.Integer authQuantity) {
		this.authQuantity = authQuantity;
	}



	/**
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * @param itemName the item_name value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
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
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.KitIssueMasterTemplateM getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.KitIssueMasterTemplateM template) {
		this.template = template;
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
		if (!(obj instanceof jkt.hms.masters.business.KitIssueMasterTemplateT)) return false;
		else {
			jkt.hms.masters.business.KitIssueMasterTemplateT kitIssueMasterTemplateT = (jkt.hms.masters.business.KitIssueMasterTemplateT) obj;
			if (null == this.getId() || null == kitIssueMasterTemplateT.getId()) return false;
			else return (this.getId().equals(kitIssueMasterTemplateT.getId()));
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