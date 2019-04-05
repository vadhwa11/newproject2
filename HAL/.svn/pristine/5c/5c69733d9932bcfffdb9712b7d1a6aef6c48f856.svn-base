package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_store_supplier_group
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_store_supplier_group"
 */

public abstract class BaseMasStoreSupplierGroup implements Serializable {

	public static String REF = "MasStoreSupplierGroup";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_ID = "Id";
	public static String PROP_GROUP = "Group";

	// constructors
	public BaseMasStoreSupplierGroup() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreSupplierGroup(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasStoreSupplier supplier;
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
		if (!(obj instanceof jkt.hms.masters.business.MasStoreSupplierGroup))
			return false;
		else {
			jkt.hms.masters.business.MasStoreSupplierGroup masStoreSupplierGroup = (jkt.hms.masters.business.MasStoreSupplierGroup) obj;
			if (null == this.getId() || null == masStoreSupplierGroup.getId())
				return false;
			else
				return (this.getId().equals(masStoreSupplierGroup.getId()));
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