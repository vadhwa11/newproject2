package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_mmf_item_remarks
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_mmf_item_remarks"
 */

public abstract class BaseStoreMmfItemRemarks implements Serializable {

	public static String REF = "StoreMmfItemRemarks";
	public static String PROP_MMF_STORE_TYPE = "MmfStoreType";
	public static String PROP_ITEM = "Item";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_MMF_FOR_THE_YEAR = "MmfForTheYear";

	// constructors
	public BaseStoreMmfItemRemarks() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMmfItemRemarks(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer mmfForTheYear;
	private java.lang.String mmfStoreType;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;

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
	 * Return the value associated with the column: mmf_for_the_year
	 */
	public java.lang.Integer getMmfForTheYear() {
		return mmfForTheYear;
	}

	/**
	 * Set the value related to the column: mmf_for_the_year
	 * 
	 * @param mmfForTheYear
	 *            the mmf_for_the_year value
	 */
	public void setMmfForTheYear(java.lang.Integer mmfForTheYear) {
		this.mmfForTheYear = mmfForTheYear;
	}

	/**
	 * Return the value associated with the column: mmf_store_type
	 */
	public java.lang.String getMmfStoreType() {
		return mmfStoreType;
	}

	/**
	 * Set the value related to the column: mmf_store_type
	 * 
	 * @param mmfStoreType
	 *            the mmf_store_type value
	 */
	public void setMmfStoreType(java.lang.String mmfStoreType) {
		this.mmfStoreType = mmfStoreType;
	}

	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remark
	 * 
	 * @param remarks
	 *            the remark value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMmfItemRemarks))
			return false;
		else {
			jkt.hms.masters.business.StoreMmfItemRemarks storeMmfItemRemarks = (jkt.hms.masters.business.StoreMmfItemRemarks) obj;
			if (null == this.getId() || null == storeMmfItemRemarks.getId())
				return false;
			else
				return (this.getId().equals(storeMmfItemRemarks.getId()));
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