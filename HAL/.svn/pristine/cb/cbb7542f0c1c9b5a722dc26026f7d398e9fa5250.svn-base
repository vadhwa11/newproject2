package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the code_type_details table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="code_type_details"
 */

public abstract class BaseCodeTypeDetails implements Serializable {

	public static String REF = "CodeTypeDetails";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_CODE_TYPE_DETAILS_CODE = "CodeTypeDetailsCode";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_CODE_TYPE_DETAILS_DESCRIPTION = "CodeTypeDetailsDescription";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_CODE_TYPE_MASTER_ID = "CodeTypeMasterId";
	public static String PROP_ID = "Id";

	// constructors
	public BaseCodeTypeDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCodeTypeDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalId;
	private java.lang.String codeTypeDetailsCode;
	private java.lang.String codeTypeDetailsDescription;
	private java.lang.Integer codeTypeMasterId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	// collections
	private java.util.Set<jkt.hms.masters.business.Uom> uomsByTouom;
	private java.util.Set<jkt.hms.masters.business.Uom> uomsByFromuom;
	private java.util.Set<jkt.hms.masters.business.SalesTaxMaintenance> salesTaxMaintenances;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="code_type_details_id"
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: code_type_details_code
	 */
	public java.lang.String getCodeTypeDetailsCode() {
		return codeTypeDetailsCode;
	}

	/**
	 * Set the value related to the column: code_type_details_code
	 * 
	 * @param codeTypeDetailsCode
	 *            the code_type_details_code value
	 */
	public void setCodeTypeDetailsCode(java.lang.String codeTypeDetailsCode) {
		this.codeTypeDetailsCode = codeTypeDetailsCode;
	}

	/**
	 * Return the value associated with the column:
	 * code_type_details_description
	 */
	public java.lang.String getCodeTypeDetailsDescription() {
		return codeTypeDetailsDescription;
	}

	/**
	 * Set the value related to the column: code_type_details_description
	 * 
	 * @param codeTypeDetailsDescription
	 *            the code_type_details_description value
	 */
	public void setCodeTypeDetailsDescription(
			java.lang.String codeTypeDetailsDescription) {
		this.codeTypeDetailsDescription = codeTypeDetailsDescription;
	}

	/**
	 * Return the value associated with the column: code_type_master_id
	 */
	public java.lang.Integer getCodeTypeMasterId() {
		return codeTypeMasterId;
	}

	/**
	 * Set the value related to the column: code_type_master_id
	 * 
	 * @param codeTypeMasterId
	 *            the code_type_master_id value
	 */
	public void setCodeTypeMasterId(java.lang.Integer codeTypeMasterId) {
		this.codeTypeMasterId = codeTypeMasterId;
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
	 * Return the value associated with the column: UomsByTouom
	 */
	public java.util.Set<jkt.hms.masters.business.Uom> getUomsByTouom() {
		return uomsByTouom;
	}

	/**
	 * Set the value related to the column: UomsByTouom
	 * 
	 * @param uomsByTouom
	 *            the UomsByTouom value
	 */
	public void setUomsByTouom(
			java.util.Set<jkt.hms.masters.business.Uom> uomsByTouom) {
		this.uomsByTouom = uomsByTouom;
	}

	public void addToUomsByTouom(jkt.hms.masters.business.Uom uom) {
		if (null == getUomsByTouom())
			setUomsByTouom(new java.util.TreeSet<jkt.hms.masters.business.Uom>());
		getUomsByTouom().add(uom);
	}

	/**
	 * Return the value associated with the column: UomsByFromuom
	 */
	public java.util.Set<jkt.hms.masters.business.Uom> getUomsByFromuom() {
		return uomsByFromuom;
	}

	/**
	 * Set the value related to the column: UomsByFromuom
	 * 
	 * @param uomsByFromuom
	 *            the UomsByFromuom value
	 */
	public void setUomsByFromuom(
			java.util.Set<jkt.hms.masters.business.Uom> uomsByFromuom) {
		this.uomsByFromuom = uomsByFromuom;
	}

	public void addToUomsByFromuom(jkt.hms.masters.business.Uom uom) {
		if (null == getUomsByFromuom())
			setUomsByFromuom(new java.util.TreeSet<jkt.hms.masters.business.Uom>());
		getUomsByFromuom().add(uom);
	}

	/**
	 * Return the value associated with the column: SalesTaxMaintenances
	 */
	public java.util.Set<jkt.hms.masters.business.SalesTaxMaintenance> getSalesTaxMaintenances() {
		return salesTaxMaintenances;
	}

	/**
	 * Set the value related to the column: SalesTaxMaintenances
	 * 
	 * @param salesTaxMaintenances
	 *            the SalesTaxMaintenances value
	 */
	public void setSalesTaxMaintenances(
			java.util.Set<jkt.hms.masters.business.SalesTaxMaintenance> salesTaxMaintenances) {
		this.salesTaxMaintenances = salesTaxMaintenances;
	}

	public void addToSalesTaxMaintenances(
			jkt.hms.masters.business.SalesTaxMaintenance salesTaxMaintenance) {
		if (null == getSalesTaxMaintenances())
			setSalesTaxMaintenances(new java.util.TreeSet<jkt.hms.masters.business.SalesTaxMaintenance>());
		getSalesTaxMaintenances().add(salesTaxMaintenance);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CodeTypeDetails))
			return false;
		else {
			jkt.hms.masters.business.CodeTypeDetails codeTypeDetails = (jkt.hms.masters.business.CodeTypeDetails) obj;
			if (null == this.getId() || null == codeTypeDetails.getId())
				return false;
			else
				return (this.getId().equals(codeTypeDetails.getId()));
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