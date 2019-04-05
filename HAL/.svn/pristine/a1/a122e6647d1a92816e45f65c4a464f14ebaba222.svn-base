package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_soc table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="store_soc"
 */

public abstract class BaseStoreSoc implements Serializable {

	public static String REF = "StoreSoc";
	public static String PROP_HOLDING_SOURCES = "HoldingSources";
	public static String PROP_STATUS = "Status";
	public static String PROP_FWD_TO_HQ = "FwdToHq";
	public static String PROP_COST = "Cost";
	public static String PROP_ITEM = "Item";
	public static String PROP_INDENT_DATE = "IndentDate";
	public static String PROP_FWD_TO_DHAFMS = "FwdToDhafms";
	public static String PROP_PRESENT_STATUS = "PresentStatus";
	public static String PROP_FWD_TO_TC = "FwdToTc";
	public static String PROP_IF_PAC_DETAIL = "IfPacDetail";
	public static String PROP_INDENT_NO = "IndentNo";
	public static String PROP_BRIEF_JUST = "BriefJust";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_QUANTITY_DEMANDED = "QuantityDemanded";
	public static String PROP_IF_PAC_NAME = "IfPacName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreSoc() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreSoc(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String indentNo;
	private java.util.Date indentDate;
	private java.lang.String quantityDemanded;
	private java.lang.Integer cost;
	private java.lang.String holdingSources;
	private java.lang.String briefJust;
	private java.lang.String ifPacDetail;
	private java.lang.String ifPacName;
	private java.lang.String fwdToTc;
	private java.lang.String fwdToHq;
	private java.lang.String fwdToDhafms;
	private java.lang.String presentStatus;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="soc_id"
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
	 * Return the value associated with the column: indent_no
	 */
	public java.lang.String getIndentNo() {
		return indentNo;
	}

	/**
	 * Set the value related to the column: indent_no
	 * 
	 * @param indentNo
	 *            the indent_no value
	 */
	public void setIndentNo(java.lang.String indentNo) {
		this.indentNo = indentNo;
	}

	/**
	 * Return the value associated with the column: indent_date
	 */
	public java.util.Date getIndentDate() {
		return indentDate;
	}

	/**
	 * Set the value related to the column: indent_date
	 * 
	 * @param indentDate
	 *            the indent_date value
	 */
	public void setIndentDate(java.util.Date indentDate) {
		this.indentDate = indentDate;
	}

	/**
	 * Return the value associated with the column: quantity_demanded
	 */
	public java.lang.String getQuantityDemanded() {
		return quantityDemanded;
	}

	/**
	 * Set the value related to the column: quantity_demanded
	 * 
	 * @param quantityDemanded
	 *            the quantity_demanded value
	 */
	public void setQuantityDemanded(java.lang.String quantityDemanded) {
		this.quantityDemanded = quantityDemanded;
	}

	/**
	 * Return the value associated with the column: cost
	 */
	public java.lang.Integer getCost() {
		return cost;
	}

	/**
	 * Set the value related to the column: cost
	 * 
	 * @param cost
	 *            the cost value
	 */
	public void setCost(java.lang.Integer cost) {
		this.cost = cost;
	}

	/**
	 * Return the value associated with the column: holding_sources
	 */
	public java.lang.String getHoldingSources() {
		return holdingSources;
	}

	/**
	 * Set the value related to the column: holding_sources
	 * 
	 * @param holdingSources
	 *            the holding_sources value
	 */
	public void setHoldingSources(java.lang.String holdingSources) {
		this.holdingSources = holdingSources;
	}

	/**
	 * Return the value associated with the column: brief_just
	 */
	public java.lang.String getBriefJust() {
		return briefJust;
	}

	/**
	 * Set the value related to the column: brief_just
	 * 
	 * @param briefJust
	 *            the brief_just value
	 */
	public void setBriefJust(java.lang.String briefJust) {
		this.briefJust = briefJust;
	}

	/**
	 * Return the value associated with the column: if_pac_detail
	 */
	public java.lang.String getIfPacDetail() {
		return ifPacDetail;
	}

	/**
	 * Set the value related to the column: if_pac_detail
	 * 
	 * @param ifPacDetail
	 *            the if_pac_detail value
	 */
	public void setIfPacDetail(java.lang.String ifPacDetail) {
		this.ifPacDetail = ifPacDetail;
	}

	/**
	 * Return the value associated with the column: if_pac_name
	 */
	public java.lang.String getIfPacName() {
		return ifPacName;
	}

	/**
	 * Set the value related to the column: if_pac_name
	 * 
	 * @param ifPacName
	 *            the if_pac_name value
	 */
	public void setIfPacName(java.lang.String ifPacName) {
		this.ifPacName = ifPacName;
	}

	/**
	 * Return the value associated with the column: fwd_to_tc
	 */
	public java.lang.String getFwdToTc() {
		return fwdToTc;
	}

	/**
	 * Set the value related to the column: fwd_to_tc
	 * 
	 * @param fwdToTc
	 *            the fwd_to_tc value
	 */
	public void setFwdToTc(java.lang.String fwdToTc) {
		this.fwdToTc = fwdToTc;
	}

	/**
	 * Return the value associated with the column: fwd_to_hq
	 */
	public java.lang.String getFwdToHq() {
		return fwdToHq;
	}

	/**
	 * Set the value related to the column: fwd_to_hq
	 * 
	 * @param fwdToHq
	 *            the fwd_to_hq value
	 */
	public void setFwdToHq(java.lang.String fwdToHq) {
		this.fwdToHq = fwdToHq;
	}

	/**
	 * Return the value associated with the column: fwd_to_dhafms
	 */
	public java.lang.String getFwdToDhafms() {
		return fwdToDhafms;
	}

	/**
	 * Set the value related to the column: fwd_to_dhafms
	 * 
	 * @param fwdToDhafms
	 *            the fwd_to_dhafms value
	 */
	public void setFwdToDhafms(java.lang.String fwdToDhafms) {
		this.fwdToDhafms = fwdToDhafms;
	}

	/**
	 * Return the value associated with the column: present_status
	 */
	public java.lang.String getPresentStatus() {
		return presentStatus;
	}

	/**
	 * Set the value related to the column: present_status
	 * 
	 * @param presentStatus
	 *            the present_status value
	 */
	public void setPresentStatus(java.lang.String presentStatus) {
		this.presentStatus = presentStatus;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreSoc))
			return false;
		else {
			jkt.hms.masters.business.StoreSoc storeSoc = (jkt.hms.masters.business.StoreSoc) obj;
			if (null == this.getId() || null == storeSoc.getId())
				return false;
			else
				return (this.getId().equals(storeSoc.getId()));
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