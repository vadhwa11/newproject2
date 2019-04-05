package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the sales_tax_maintenance
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="sales_tax_maintenance"
 */

public abstract class BaseSalesTaxMaintenance implements Serializable {

	public static String REF = "SalesTaxMaintenance";
	public static String PROP_SALES_TAX_GROUP = "SalesTaxGroup";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_SALES_TAX_TYPE = "SalesTaxType";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_SALES_TAX_DESCRIPTION = "SalesTaxDescription";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_SALES_TAX_PERCENT = "SalesTaxPercent";
	public static String PROP_ID = "Id";

	// constructors
	public BaseSalesTaxMaintenance() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSalesTaxMaintenance(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String salesTaxType;
	private java.lang.String salesTaxDescription;
	private java.lang.Integer salesTaxPercent;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	// many to one
	private jkt.hms.masters.business.CodeTypeDetails salesTaxGroup;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="sales_tax_id"
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
	 * Return the value associated with the column: sales_tax_type
	 */
	public java.lang.String getSalesTaxType() {
		return salesTaxType;
	}

	/**
	 * Set the value related to the column: sales_tax_type
	 * 
	 * @param salesTaxType
	 *            the sales_tax_type value
	 */
	public void setSalesTaxType(java.lang.String salesTaxType) {
		this.salesTaxType = salesTaxType;
	}

	/**
	 * Return the value associated with the column: sales_tax_description
	 */
	public java.lang.String getSalesTaxDescription() {
		return salesTaxDescription;
	}

	/**
	 * Set the value related to the column: sales_tax_description
	 * 
	 * @param salesTaxDescription
	 *            the sales_tax_description value
	 */
	public void setSalesTaxDescription(java.lang.String salesTaxDescription) {
		this.salesTaxDescription = salesTaxDescription;
	}

	/**
	 * Return the value associated with the column: sales_tax_percent
	 */
	public java.lang.Integer getSalesTaxPercent() {
		return salesTaxPercent;
	}

	/**
	 * Set the value related to the column: sales_tax_percent
	 * 
	 * @param salesTaxPercent
	 *            the sales_tax_percent value
	 */
	public void setSalesTaxPercent(java.lang.Integer salesTaxPercent) {
		this.salesTaxPercent = salesTaxPercent;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById() {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditById
	 *            the add_edit_by_id value
	 */
	public void setAddEditById(java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}

	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime() {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * 
	 * @param addEditDateTime
	 *            the add_edit_date_time value
	 */
	public void setAddEditDateTime(java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Return the value associated with the column: sales_tax_group_id
	 */
	public jkt.hms.masters.business.CodeTypeDetails getSalesTaxGroup() {
		return salesTaxGroup;
	}

	/**
	 * Set the value related to the column: sales_tax_group_id
	 * 
	 * @param salesTaxGroup
	 *            the sales_tax_group_id value
	 */
	public void setSalesTaxGroup(
			jkt.hms.masters.business.CodeTypeDetails salesTaxGroup) {
		this.salesTaxGroup = salesTaxGroup;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.SalesTaxMaintenance))
			return false;
		else {
			jkt.hms.masters.business.SalesTaxMaintenance salesTaxMaintenance = (jkt.hms.masters.business.SalesTaxMaintenance) obj;
			if (null == this.getId() || null == salesTaxMaintenance.getId())
				return false;
			else
				return (this.getId().equals(salesTaxMaintenance.getId()));
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