package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_formation table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_formation"
 */

public abstract class BaseMasFormation implements Serializable {

	public static String REF = "MasFormation";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FORMATION_CODE = "FormationCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FORMATION_NAME = "FormationName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasFormation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasFormation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String formationCode;
	private java.lang.String formationName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasServiceType serviceType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="formation_id"
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
	 * Return the value associated with the column: formation_code
	 */
	public java.lang.String getFormationCode() {
		return formationCode;
	}

	/**
	 * Set the value related to the column: formation_code
	 * 
	 * @param formationCode
	 *            the formation_code value
	 */
	public void setFormationCode(java.lang.String formationCode) {
		this.formationCode = formationCode;
	}

	/**
	 * Return the value associated with the column: formation_name
	 */
	public java.lang.String getFormationName() {
		return formationName;
	}

	/**
	 * Set the value related to the column: formation_name
	 * 
	 * @param formationName
	 *            the formation_name value
	 */
	public void setFormationName(java.lang.String formationName) {
		this.formationName = formationName;
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
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * 
	 * @param serviceType
	 *            the service_type_id value
	 */
	public void setServiceType(
			jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasFormation))
			return false;
		else {
			jkt.hms.masters.business.MasFormation masFormation = (jkt.hms.masters.business.MasFormation) obj;
			if (null == this.getId() || null == masFormation.getId())
				return false;
			else
				return (this.getId().equals(masFormation.getId()));
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