package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_mas_component
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_mas_component"
 */

public abstract class BaseBloodMasComponent implements Serializable {

	public static String REF = "BloodMasComponent";
	public static String PROP_STATUS = "Status";
	public static String PROP_LIFE_SPAN = "LifeSpan";
	public static String PROP_QTY_UNIT = "QtyUnit";
	public static String PROP_COMPONENT_NAME = "ComponentName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_WHOLE_BLOOD = "WholeBlood";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_COMPONENT_CODE = "ComponentCode";
	public static String PROP_PERIOD = "Period";

	// constructors
	public BaseBloodMasComponent() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodMasComponent(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String componentCode;
	private java.lang.String componentName;
	private java.lang.Integer lifeSpan;
	private java.lang.Integer temperature;
	private java.lang.Integer qtyUnit;
	private java.lang.String wholeBlood;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String period;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodStockDetail> bloodStockDetails;
	private java.util.Set<jkt.hms.masters.business.BloodRequestEntryDetail> bloodRequestEntryDetails;
	private java.util.Set<jkt.hms.masters.business.BloodTransfusion> bloodTransfusions;
	private java.util.Set<jkt.hms.masters.business.BloodDonationEntryDetail> bloodDonationEntryDetails;
	private java.util.Set<jkt.hms.masters.business.BloodOpeningStockDetail> bloodOpeningStockDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="component_id"
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
	 * Return the value associated with the column: component_code
	 */
	public java.lang.String getComponentCode() {
		return componentCode;
	}

	/**
	 * Set the value related to the column: component_code
	 * 
	 * @param componentCode
	 *            the component_code value
	 */
	public void setComponentCode(java.lang.String componentCode) {
		this.componentCode = componentCode;
	}

	/**
	 * Return the value associated with the column: component_name
	 */
	public java.lang.String getComponentName() {
		return componentName;
	}

	/**
	 * Set the value related to the column: component_name
	 * 
	 * @param componentName
	 *            the component_name value
	 */
	public void setComponentName(java.lang.String componentName) {
		this.componentName = componentName;
	}

	/**
	 * Return the value associated with the column: life_span
	 */
	public java.lang.Integer getLifeSpan() {
		return lifeSpan;
	}

	/**
	 * Set the value related to the column: life_span
	 * 
	 * @param lifeSpan
	 *            the life_span value
	 */
	public void setLifeSpan(java.lang.Integer lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.Integer getTemperature() {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * 
	 * @param temperature
	 *            the temperature value
	 */
	public void setTemperature(java.lang.Integer temperature) {
		this.temperature = temperature;
	}

	/**
	 * Return the value associated with the column: qty_unit
	 */
	public java.lang.Integer getQtyUnit() {
		return qtyUnit;
	}

	/**
	 * Set the value related to the column: qty_unit
	 * 
	 * @param qtyUnit
	 *            the qty_unit value
	 */
	public void setQtyUnit(java.lang.Integer qtyUnit) {
		this.qtyUnit = qtyUnit;
	}

	/**
	 * Return the value associated with the column: whole_blood
	 */
	public java.lang.String getWholeBlood() {
		return wholeBlood;
	}

	/**
	 * Set the value related to the column: whole_blood
	 * 
	 * @param wholeBlood
	 *            the whole_blood value
	 */
	public void setWholeBlood(java.lang.String wholeBlood) {
		this.wholeBlood = wholeBlood;
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
	 * Return the value associated with the column: period
	 */
	public java.lang.String getPeriod() {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * 
	 * @param period
	 *            the period value
	 */
	public void setPeriod(java.lang.String period) {
		this.period = period;
	}

	/**
	 * Return the value associated with the column: BloodStockDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodStockDetail> getBloodStockDetails() {
		return bloodStockDetails;
	}

	/**
	 * Set the value related to the column: BloodStockDetails
	 * 
	 * @param bloodStockDetails
	 *            the BloodStockDetails value
	 */
	public void setBloodStockDetails(
			java.util.Set<jkt.hms.masters.business.BloodStockDetail> bloodStockDetails) {
		this.bloodStockDetails = bloodStockDetails;
	}

	public void addToBloodStockDetails(
			jkt.hms.masters.business.BloodStockDetail bloodStockDetail) {
		if (null == getBloodStockDetails())
			setBloodStockDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodStockDetail>());
		getBloodStockDetails().add(bloodStockDetail);
	}

	/**
	 * Return the value associated with the column: BloodRequestEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodRequestEntryDetail> getBloodRequestEntryDetails() {
		return bloodRequestEntryDetails;
	}

	/**
	 * Set the value related to the column: BloodRequestEntryDetails
	 * 
	 * @param bloodRequestEntryDetails
	 *            the BloodRequestEntryDetails value
	 */
	public void setBloodRequestEntryDetails(
			java.util.Set<jkt.hms.masters.business.BloodRequestEntryDetail> bloodRequestEntryDetails) {
		this.bloodRequestEntryDetails = bloodRequestEntryDetails;
	}

	public void addToBloodRequestEntryDetails(
			jkt.hms.masters.business.BloodRequestEntryDetail bloodRequestEntryDetail) {
		if (null == getBloodRequestEntryDetails())
			setBloodRequestEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodRequestEntryDetail>());
		getBloodRequestEntryDetails().add(bloodRequestEntryDetail);
	}

	/**
	 * Return the value associated with the column: BloodTransfusions
	 */
	public java.util.Set<jkt.hms.masters.business.BloodTransfusion> getBloodTransfusions() {
		return bloodTransfusions;
	}

	/**
	 * Set the value related to the column: BloodTransfusions
	 * 
	 * @param bloodTransfusions
	 *            the BloodTransfusions value
	 */
	public void setBloodTransfusions(
			java.util.Set<jkt.hms.masters.business.BloodTransfusion> bloodTransfusions) {
		this.bloodTransfusions = bloodTransfusions;
	}

	public void addToBloodTransfusions(
			jkt.hms.masters.business.BloodTransfusion bloodTransfusion) {
		if (null == getBloodTransfusions())
			setBloodTransfusions(new java.util.TreeSet<jkt.hms.masters.business.BloodTransfusion>());
		getBloodTransfusions().add(bloodTransfusion);
	}

	/**
	 * Return the value associated with the column: BloodDonationEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodDonationEntryDetail> getBloodDonationEntryDetails() {
		return bloodDonationEntryDetails;
	}

	/**
	 * Set the value related to the column: BloodDonationEntryDetails
	 * 
	 * @param bloodDonationEntryDetails
	 *            the BloodDonationEntryDetails value
	 */
	public void setBloodDonationEntryDetails(
			java.util.Set<jkt.hms.masters.business.BloodDonationEntryDetail> bloodDonationEntryDetails) {
		this.bloodDonationEntryDetails = bloodDonationEntryDetails;
	}

	public void addToBloodDonationEntryDetails(
			jkt.hms.masters.business.BloodDonationEntryDetail bloodDonationEntryDetail) {
		if (null == getBloodDonationEntryDetails())
			setBloodDonationEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodDonationEntryDetail>());
		getBloodDonationEntryDetails().add(bloodDonationEntryDetail);
	}

	/**
	 * Return the value associated with the column: BloodOpeningStockDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodOpeningStockDetail> getBloodOpeningStockDetails() {
		return bloodOpeningStockDetails;
	}

	/**
	 * Set the value related to the column: BloodOpeningStockDetails
	 * 
	 * @param bloodOpeningStockDetails
	 *            the BloodOpeningStockDetails value
	 */
	public void setBloodOpeningStockDetails(
			java.util.Set<jkt.hms.masters.business.BloodOpeningStockDetail> bloodOpeningStockDetails) {
		this.bloodOpeningStockDetails = bloodOpeningStockDetails;
	}

	public void addToBloodOpeningStockDetails(
			jkt.hms.masters.business.BloodOpeningStockDetail bloodOpeningStockDetail) {
		if (null == getBloodOpeningStockDetails())
			setBloodOpeningStockDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodOpeningStockDetail>());
		getBloodOpeningStockDetails().add(bloodOpeningStockDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodMasComponent))
			return false;
		else {
			jkt.hms.masters.business.BloodMasComponent bloodMasComponent = (jkt.hms.masters.business.BloodMasComponent) obj;
			if (null == this.getId() || null == bloodMasComponent.getId())
				return false;
			else
				return (this.getId().equals(bloodMasComponent.getId()));
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