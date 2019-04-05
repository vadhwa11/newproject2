package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_tender_to_supplier
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_to_supplier"
 */

public abstract class BaseStoreTenderToSupplier implements Serializable {

	public static String REF = "StoreTenderToSupplier";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_TENDER = "Tender";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_GROUP = "Group";

	// constructors
	public BaseStoreTenderToSupplier() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderToSupplier(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date date;

	// many to one
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.StoreTenderM tender;
	private jkt.hms.masters.business.MasStoreGroup group;

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
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: tender_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTender() {
		return tender;
	}

	/**
	 * Set the value related to the column: tender_id
	 * 
	 * @param tender
	 *            the tender_id value
	 */
	public void setTender(jkt.hms.masters.business.StoreTenderM tender) {
		this.tender = tender;
	}

	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup() {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * 
	 * @param group
	 *            the group_id value
	 */
	public void setGroup(jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderToSupplier))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderToSupplier storeTenderToSupplier = (jkt.hms.masters.business.StoreTenderToSupplier) obj;
			if (null == this.getId() || null == storeTenderToSupplier.getId())
				return false;
			else
				return (this.getId().equals(storeTenderToSupplier.getId()));
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