package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_uom table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="dg_uom"
 */

public abstract class BaseDgUom implements Serializable {

	public static String REF = "DgUom";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_UOM_CODE = "UomCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_UOM_NAME = "UomName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDgUom() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgUom(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String uomCode;
	private java.lang.String uomName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="uom_id"
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
	 * Return the value associated with the column: uom_code
	 */
	public java.lang.String getUomCode() {
		return uomCode;
	}

	/**
	 * Set the value related to the column: uom_code
	 * 
	 * @param uomCode
	 *            the uom_code value
	 */
	public void setUomCode(java.lang.String uomCode) {
		this.uomCode = uomCode;
	}

	/**
	 * Return the value associated with the column: uom_name
	 */
	public java.lang.String getUomName() {
		return uomName;
	}

	/**
	 * Set the value related to the column: uom_name
	 * 
	 * @param uomName
	 *            the uom_name value
	 */
	public void setUomName(java.lang.String uomName) {
		this.uomName = uomName;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: DgSubMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> getDgSubMasInvestigations() {
		return dgSubMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgSubMasInvestigations
	 * 
	 * @param dgSubMasInvestigations
	 *            the DgSubMasInvestigations value
	 */
	public void setDgSubMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations) {
		this.dgSubMasInvestigations = dgSubMasInvestigations;
	}

	public void addToDgSubMasInvestigations(
			jkt.hms.masters.business.DgSubMasInvestigation dgSubMasInvestigation) {
		if (null == getDgSubMasInvestigations())
			setDgSubMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgSubMasInvestigation>());
		getDgSubMasInvestigations().add(dgSubMasInvestigation);
	}

	/**
	 * Return the value associated with the column: DgMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgMasInvestigation> getDgMasInvestigations() {
		return dgMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgMasInvestigations
	 * 
	 * @param dgMasInvestigations
	 *            the DgMasInvestigations value
	 */
	public void setDgMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations) {
		this.dgMasInvestigations = dgMasInvestigations;
	}

	public void addToDgMasInvestigations(
			jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		if (null == getDgMasInvestigations())
			setDgMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgMasInvestigation>());
		getDgMasInvestigations().add(dgMasInvestigation);
	}

	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails() {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * 
	 * @param dgResultEntryDetails
	 *            the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails(
			java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails(
			jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails())
			setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DgUom))
			return false;
		else {
			jkt.hms.masters.business.DgUom dgUom = (jkt.hms.masters.business.DgUom) obj;
			if (null == this.getId() || null == dgUom.getId())
				return false;
			else
				return (this.getId().equals(dgUom.getId()));
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