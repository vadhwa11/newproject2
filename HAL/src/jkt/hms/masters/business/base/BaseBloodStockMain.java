package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_stock_main table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="blood_stock_main"
 */

public abstract class BaseBloodStockMain implements Serializable {

	public static String REF = "BloodStockMain";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_UNIT_ADDRESS = "UnitAddress";
	public static String PROP_COLLECTION_DATE = "CollectionDate";
	public static String PROP_RANK = "Rank";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_HIN = "Hin";
	public static String PROP_NAME = "Name";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodStockMain() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodStockMain(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date collectionDate;
	private java.util.Date expiryDate;
	private java.lang.String name;
	private java.lang.String unitAddress;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodStockDetail> bloodStockDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="stock_id"
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
	 * Return the value associated with the column: collection_date
	 */
	public java.util.Date getCollectionDate() {
		return collectionDate;
	}

	/**
	 * Set the value related to the column: collection_date
	 * 
	 * @param collectionDate
	 *            the collection_date value
	 */
	public void setCollectionDate(java.util.Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * 
	 * @param expiryDate
	 *            the expiry_date value
	 */
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: unit_address
	 */
	public java.lang.String getUnitAddress() {
		return unitAddress;
	}

	/**
	 * Set the value related to the column: unit_address
	 * 
	 * @param unitAddress
	 *            the unit_address value
	 */
	public void setUnitAddress(java.lang.String unitAddress) {
		this.unitAddress = unitAddress;
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
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * 
	 * @param rank
	 *            the rank_id value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}

	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * 
	 * @param bloodGroup
	 *            the blood_group_id value
	 */
	public void setBloodGroup(jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodStockMain))
			return false;
		else {
			jkt.hms.masters.business.BloodStockMain bloodStockMain = (jkt.hms.masters.business.BloodStockMain) obj;
			if (null == this.getId() || null == bloodStockMain.getId())
				return false;
			else
				return (this.getId().equals(bloodStockMain.getId()));
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