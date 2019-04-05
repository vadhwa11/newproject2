package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_mas_collection table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="dg_mas_collection"
 */

public abstract class BaseDgMasCollection implements Serializable {

	public static String REF = "DgMasCollection";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COLLECTION_CODE = "CollectionCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_COLLECTION_NAME = "CollectionName";

	// constructors
	public BaseDgMasCollection() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgMasCollection(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String collectionCode;
	private java.lang.String collectionName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.MasSample> masSamples;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="collection_id"
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
	 * Return the value associated with the column: collection_code
	 */
	public java.lang.String getCollectionCode() {
		return collectionCode;
	}

	/**
	 * Set the value related to the column: collection_code
	 * 
	 * @param collectionCode
	 *            the collection_code value
	 */
	public void setCollectionCode(java.lang.String collectionCode) {
		this.collectionCode = collectionCode;
	}

	/**
	 * Return the value associated with the column: collection_name
	 */
	public java.lang.String getCollectionName() {
		return collectionName;
	}

	/**
	 * Set the value related to the column: collection_name
	 * 
	 * @param collectionName
	 *            the collection_name value
	 */
	public void setCollectionName(java.lang.String collectionName) {
		this.collectionName = collectionName;
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
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails() {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * 
	 * @param dgSampleCollectionDetails
	 *            the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails(
			java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails(
			jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails())
			setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}

	/**
	 * Return the value associated with the column: MasSamples
	 */
	public java.util.Set<jkt.hms.masters.business.MasSample> getMasSamples() {
		return masSamples;
	}

	/**
	 * Set the value related to the column: MasSamples
	 * 
	 * @param masSamples
	 *            the MasSamples value
	 */
	public void setMasSamples(
			java.util.Set<jkt.hms.masters.business.MasSample> masSamples) {
		this.masSamples = masSamples;
	}

	public void addToMasSamples(jkt.hms.masters.business.MasSample masSample) {
		if (null == getMasSamples())
			setMasSamples(new java.util.TreeSet<jkt.hms.masters.business.MasSample>());
		getMasSamples().add(masSample);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DgMasCollection))
			return false;
		else {
			jkt.hms.masters.business.DgMasCollection dgMasCollection = (jkt.hms.masters.business.DgMasCollection) obj;
			if (null == this.getId() || null == dgMasCollection.getId())
				return false;
			else
				return (this.getId().equals(dgMasCollection.getId()));
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