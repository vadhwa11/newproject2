package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the work_load_entry_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="work_load_entry_detail"
 */

public abstract class BaseWorkLoadEntryDetail implements Serializable {

	public static String REF = "WorkLoadEntryDetail";
	public static String PROP_WORK_LOAD = "WorkLoad";
	public static String PROP_SELECT_STATUS = "SelectStatus";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_LINEN_WEIGHT = "LinenWeight";
	public static String PROP_QUANTITY = "Quantity";

	// constructors
	public BaseWorkLoadEntryDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkLoadEntryDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal quantity;
	private java.lang.String selectStatus;

	// many to one
	private jkt.hms.masters.business.MasLinenWeight linenWeight;
	private jkt.hms.masters.business.WorkLoadEntry workLoad;
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="detail_id"
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
	 * Return the value associated with the column: quantity
	 */
	public java.math.BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: select_status
	 */
	public java.lang.String getSelectStatus() {
		return selectStatus;
	}

	/**
	 * Set the value related to the column: select_status
	 * 
	 * @param selectStatus
	 *            the select_status value
	 */
	public void setSelectStatus(java.lang.String selectStatus) {
		this.selectStatus = selectStatus;
	}

	/**
	 * Return the value associated with the column: linen_weight_id
	 */
	public jkt.hms.masters.business.MasLinenWeight getLinenWeight() {
		return linenWeight;
	}

	/**
	 * Set the value related to the column: linen_weight_id
	 * 
	 * @param linenWeight
	 *            the linen_weight_id value
	 */
	public void setLinenWeight(
			jkt.hms.masters.business.MasLinenWeight linenWeight) {
		this.linenWeight = linenWeight;
	}

	/**
	 * Return the value associated with the column: work_load_id
	 */
	public jkt.hms.masters.business.WorkLoadEntry getWorkLoad() {
		return workLoad;
	}

	/**
	 * Set the value related to the column: work_load_id
	 * 
	 * @param workLoad
	 *            the work_load_id value
	 */
	public void setWorkLoad(jkt.hms.masters.business.WorkLoadEntry workLoad) {
		this.workLoad = workLoad;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.WorkLoadEntryDetail))
			return false;
		else {
			jkt.hms.masters.business.WorkLoadEntryDetail workLoadEntryDetail = (jkt.hms.masters.business.WorkLoadEntryDetail) obj;
			if (null == this.getId() || null == workLoadEntryDetail.getId())
				return false;
			else
				return (this.getId().equals(workLoadEntryDetail.getId()));
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