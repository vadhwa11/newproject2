package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_item_class table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_item_class"
 */

public abstract class BaseMasItemClass  implements Serializable {

	public static String REF = "MasItemClass";
	public static String PROP_SECTION = "Section";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ITEM_CLASS_NAME = "ItemClassName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_CLASS_CODE = "ItemClassCode";


	// constructors
	public BaseMasItemClass () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasItemClass (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemClassCode;
	private java.lang.String itemClassName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreSection section;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="item_class_id"
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
	 * Return the value associated with the column: item_class_code
	 */
	public java.lang.String getItemClassCode () {
		return itemClassCode;
	}

	/**
	 * Set the value related to the column: item_class_code
	 * @param itemClassCode the item_class_code value
	 */
	public void setItemClassCode (java.lang.String itemClassCode) {
		this.itemClassCode = itemClassCode;
	}



	/**
	 * Return the value associated with the column: item_class_name
	 */
	public java.lang.String getItemClassName () {
		return itemClassName;
	}

	/**
	 * Set the value related to the column: item_class_name
	 * @param itemClassName the item_class_name value
	 */
	public void setItemClassName (java.lang.String itemClassName) {
		this.itemClassName = itemClassName;
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
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: section_id
	 */
	public jkt.hms.masters.business.MasStoreSection getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section_id
	 * @param section the section_id value
	 */
	public void setSection (jkt.hms.masters.business.MasStoreSection section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems () {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * @param masStoreItems the MasStoreItems value
	 */
	public void setMasStoreItems (java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems()) setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasItemClass)) return false;
		else {
			jkt.hms.masters.business.MasItemClass masItemClass = (jkt.hms.masters.business.MasItemClass) obj;
			if (null == this.getId() || null == masItemClass.getId()) return false;
			else return (this.getId().equals(masItemClass.getId()));
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