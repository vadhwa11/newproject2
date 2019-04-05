package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * store_tender_technical_bid_m table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_technical_bid_m"
 */

public abstract class BaseStoreTenderTechnicalBidM implements Serializable {

	public static String REF = "StoreTenderTechnicalBidM";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_GROUP = "Group";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUALIFIED = "Qualified";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_TENDER = "Tender";
	public static String PROP_GOOD_MANUF_LAB_PRACTICE = "GoodManufLabPractice";
	public static String PROP_ID = "Id";
	public static String PROP_NO_CONVICTION_ISSUED = "NoConvictionIssued";
	public static String PROP_MARKET_STANDING_CERTIFICATE = "MarketStandingCertificate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ACCEPTANCE_LETTER_ATTACHED = "AcceptanceLetterAttached";

	// constructors
	public BaseStoreTenderTechnicalBidM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderTechnicalBidM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTenderTechnicalBidM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasStoreSupplier supplier,
			jkt.hms.masters.business.StoreTenderM tender,
			jkt.hms.masters.business.MasStoreGroup group,
			java.lang.String goodManufLabPractice,
			java.lang.String noConvictionIssued,
			java.lang.String marketStandingCertificate,
			java.lang.String status, java.lang.String qualified,
			java.lang.String lastChgBy, java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setSupplier(supplier);
		this.setTender(tender);
		this.setGroup(group);
		this.setGoodManufLabPractice(goodManufLabPractice);
		this.setNoConvictionIssued(noConvictionIssued);
		this.setMarketStandingCertificate(marketStandingCertificate);
		this.setStatus(status);
		this.setQualified(qualified);
		this.setLastChgBy(lastChgBy);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String goodManufLabPractice;
	private java.lang.String noConvictionIssued;
	private java.lang.String marketStandingCertificate;
	private java.lang.String status;
	private java.lang.String qualified;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String acceptanceLetterAttached;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.StoreTenderM tender;
	private jkt.hms.masters.business.MasStoreGroup group;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> storeTenderTechnicalBidTs;

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
	 * Return the value associated with the column: good_manuf_lab_practice
	 */
	public java.lang.String getGoodManufLabPractice() {
		return goodManufLabPractice;
	}

	/**
	 * Set the value related to the column: good_manuf_lab_practice
	 * 
	 * @param goodManufLabPractice
	 *            the good_manuf_lab_practice value
	 */
	public void setGoodManufLabPractice(java.lang.String goodManufLabPractice) {
		this.goodManufLabPractice = goodManufLabPractice;
	}

	/**
	 * Return the value associated with the column: no_conviction_issued
	 */
	public java.lang.String getNoConvictionIssued() {
		return noConvictionIssued;
	}

	/**
	 * Set the value related to the column: no_conviction_issued
	 * 
	 * @param noConvictionIssued
	 *            the no_conviction_issued value
	 */
	public void setNoConvictionIssued(java.lang.String noConvictionIssued) {
		this.noConvictionIssued = noConvictionIssued;
	}

	/**
	 * Return the value associated with the column: market_standing_certificate
	 */
	public java.lang.String getMarketStandingCertificate() {
		return marketStandingCertificate;
	}

	/**
	 * Set the value related to the column: market_standing_certificate
	 * 
	 * @param marketStandingCertificate
	 *            the market_standing_certificate value
	 */
	public void setMarketStandingCertificate(
			java.lang.String marketStandingCertificate) {
		this.marketStandingCertificate = marketStandingCertificate;
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
	 * Return the value associated with the column: qualified
	 */
	public java.lang.String getQualified() {
		return qualified;
	}

	/**
	 * Set the value related to the column: qualified
	 * 
	 * @param qualified
	 *            the qualified value
	 */
	public void setQualified(java.lang.String qualified) {
		this.qualified = qualified;
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
	 * Return the value associated with the column: acceptance_letter_attached
	 */
	public java.lang.String getAcceptanceLetterAttached() {
		return acceptanceLetterAttached;
	}

	/**
	 * Set the value related to the column: acceptance_letter_attached
	 * 
	 * @param acceptanceLetterAttached
	 *            the acceptance_letter_attached value
	 */
	public void setAcceptanceLetterAttached(
			java.lang.String acceptanceLetterAttached) {
		this.acceptanceLetterAttached = acceptanceLetterAttached;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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

	/**
	 * Return the value associated with the column: StoreTenderTechnicalBidTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> getStoreTenderTechnicalBidTs() {
		return storeTenderTechnicalBidTs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidTs
	 * 
	 * @param storeTenderTechnicalBidTs
	 *            the StoreTenderTechnicalBidTs value
	 */
	public void setStoreTenderTechnicalBidTs(
			java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> storeTenderTechnicalBidTs) {
		this.storeTenderTechnicalBidTs = storeTenderTechnicalBidTs;
	}

	public void addToStoreTenderTechnicalBidTs(
			jkt.hms.masters.business.StoreTenderTechnicalBidT storeTenderTechnicalBidT) {
		if (null == getStoreTenderTechnicalBidTs())
			setStoreTenderTechnicalBidTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidT>());
		getStoreTenderTechnicalBidTs().add(storeTenderTechnicalBidT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderTechnicalBidM))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderTechnicalBidM storeTenderTechnicalBidM = (jkt.hms.masters.business.StoreTenderTechnicalBidM) obj;
			if (null == this.getId()
					|| null == storeTenderTechnicalBidM.getId())
				return false;
			else
				return (this.getId().equals(storeTenderTechnicalBidM.getId()));
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