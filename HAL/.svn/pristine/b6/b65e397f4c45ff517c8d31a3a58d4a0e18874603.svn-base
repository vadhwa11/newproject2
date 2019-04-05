package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_service_type table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_service_type"
 */

public abstract class BaseMasServiceType implements Serializable {

	public static String REF = "MasServiceType";
	public static String PROP_STATUS = "Status";
	public static String PROP_SERVICE_NAME_SHORT_DESC = "ServiceNameShortDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SERVICE_TYPE_NAME = "ServiceTypeName";
	public static String PROP_SERVICE_TYPE_CODE = "ServiceTypeCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasServiceType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasServiceType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceTypeCode;
	private java.lang.String serviceTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String serviceNameShortDesc;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasFormation> masFormations;
	private java.util.Set<jkt.hms.masters.business.MasRecordOfficeAddress> masRecordOfficeAddress;
	private java.util.Set<jkt.hms.masters.business.MasTrade> masTrades;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.MasRank> masRanks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="service_type_id"
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
	 * Return the value associated with the column: service_type_code
	 */
	public java.lang.String getServiceTypeCode() {
		return serviceTypeCode;
	}

	/**
	 * Set the value related to the column: service_type_code
	 * 
	 * @param serviceTypeCode
	 *            the service_type_code value
	 */
	public void setServiceTypeCode(java.lang.String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}

	/**
	 * Return the value associated with the column: service_type_name
	 */
	public java.lang.String getServiceTypeName() {
		return serviceTypeName;
	}

	/**
	 * Set the value related to the column: service_type_name
	 * 
	 * @param serviceTypeName
	 *            the service_type_name value
	 */
	public void setServiceTypeName(java.lang.String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
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
	 * Return the value associated with the column: service_name_short_desc
	 */
	public java.lang.String getServiceNameShortDesc() {
		return serviceNameShortDesc;
	}

	/**
	 * Set the value related to the column: service_name_short_desc
	 * 
	 * @param serviceNameShortDesc
	 *            the service_name_short_desc value
	 */
	public void setServiceNameShortDesc(java.lang.String serviceNameShortDesc) {
		this.serviceNameShortDesc = serviceNameShortDesc;
	}

	/**
	 * Return the value associated with the column: MasFormations
	 */
	public java.util.Set<jkt.hms.masters.business.MasFormation> getMasFormations() {
		return masFormations;
	}

	/**
	 * Set the value related to the column: MasFormations
	 * 
	 * @param masFormations
	 *            the MasFormations value
	 */
	public void setMasFormations(
			java.util.Set<jkt.hms.masters.business.MasFormation> masFormations) {
		this.masFormations = masFormations;
	}

	public void addToMasFormations(
			jkt.hms.masters.business.MasFormation masFormation) {
		if (null == getMasFormations())
			setMasFormations(new java.util.TreeSet<jkt.hms.masters.business.MasFormation>());
		getMasFormations().add(masFormation);
	}

	/**
	 * Return the value associated with the column: MasRecordOfficeAddress
	 */
	public java.util.Set<jkt.hms.masters.business.MasRecordOfficeAddress> getMasRecordOfficeAddress() {
		return masRecordOfficeAddress;
	}

	/**
	 * Set the value related to the column: MasRecordOfficeAddress
	 * 
	 * @param masRecordOfficeAddress
	 *            the MasRecordOfficeAddress value
	 */
	public void setMasRecordOfficeAddress(
			java.util.Set<jkt.hms.masters.business.MasRecordOfficeAddress> masRecordOfficeAddress) {
		this.masRecordOfficeAddress = masRecordOfficeAddress;
	}

	public void addToMasRecordOfficeAddress(
			jkt.hms.masters.business.MasRecordOfficeAddress masRecordOfficeAddress) {
		if (null == getMasRecordOfficeAddress())
			setMasRecordOfficeAddress(new java.util.TreeSet<jkt.hms.masters.business.MasRecordOfficeAddress>());
		getMasRecordOfficeAddress().add(masRecordOfficeAddress);
	}

	/**
	 * Return the value associated with the column: MasTrades
	 */
	public java.util.Set<jkt.hms.masters.business.MasTrade> getMasTrades() {
		return masTrades;
	}

	/**
	 * Set the value related to the column: MasTrades
	 * 
	 * @param masTrades
	 *            the MasTrades value
	 */
	public void setMasTrades(
			java.util.Set<jkt.hms.masters.business.MasTrade> masTrades) {
		this.masTrades = masTrades;
	}

	public void addToMasTrades(jkt.hms.masters.business.MasTrade masTrade) {
		if (null == getMasTrades())
			setMasTrades(new java.util.TreeSet<jkt.hms.masters.business.MasTrade>());
		getMasTrades().add(masTrade);
	}

	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients() {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * 
	 * @param patients
	 *            the Patients value
	 */
	public void setPatients(
			java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients(jkt.hms.masters.business.Patient patient) {
		if (null == getPatients())
			setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}

	/**
	 * Return the value associated with the column: MasRanks
	 */
	public java.util.Set<jkt.hms.masters.business.MasRank> getMasRanks() {
		return masRanks;
	}

	/**
	 * Set the value related to the column: MasRanks
	 * 
	 * @param masRanks
	 *            the MasRanks value
	 */
	public void setMasRanks(
			java.util.Set<jkt.hms.masters.business.MasRank> masRanks) {
		this.masRanks = masRanks;
	}

	public void addToMasRanks(jkt.hms.masters.business.MasRank masRank) {
		if (null == getMasRanks())
			setMasRanks(new java.util.TreeSet<jkt.hms.masters.business.MasRank>());
		getMasRanks().add(masRank);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasServiceType))
			return false;
		else {
			jkt.hms.masters.business.MasServiceType masServiceType = (jkt.hms.masters.business.MasServiceType) obj;
			if (null == this.getId() || null == masServiceType.getId())
				return false;
			else
				return (this.getId().equals(masServiceType.getId()));
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