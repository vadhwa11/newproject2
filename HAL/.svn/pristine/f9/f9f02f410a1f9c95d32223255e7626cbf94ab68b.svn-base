package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_opening_stock_detail table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_opening_stock_detail"
 */

public abstract class BaseBloodOpeningStockDetail implements Serializable {

	public static String REF = "BloodOpeningStockDetail";
	public static String PROP_QTY = "Qty";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_UNIT_ADDRESS = "UnitAddress";
	public static String PROP_COLLECTION_DATE = "CollectionDate";
	public static String PROP_BLOOD_BAG_NO = "BloodBagNo";
	public static String PROP_RANK = "Rank";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_COMPONENT = "Component";
	public static String PROP_OPENING_MAIN = "OpeningMain";
	public static String PROP_HIN = "Hin";
	public static String PROP_NAME = "Name";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodOpeningStockDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodOpeningStockDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bloodBagNo;
	private java.util.Date collectionDate;
	private java.lang.String unitAddress;
	private java.lang.String name;
	private java.util.Date expiryDate;
	private java.lang.Integer qty;

	// many to one
	private jkt.hms.masters.business.BloodOpeningStockMain openingMain;
	private jkt.hms.masters.business.BloodMasComponent component;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="opening_detail_id"
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
	 * Return the value associated with the column: blood_bag_no
	 */
	public java.lang.String getBloodBagNo() {
		return bloodBagNo;
	}

	/**
	 * Set the value related to the column: blood_bag_no
	 * 
	 * @param bloodBagNo
	 *            the blood_bag_no value
	 */
	public void setBloodBagNo(java.lang.String bloodBagNo) {
		this.bloodBagNo = bloodBagNo;
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
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: opening_main_id
	 */
	public jkt.hms.masters.business.BloodOpeningStockMain getOpeningMain() {
		return openingMain;
	}

	/**
	 * Set the value related to the column: opening_main_id
	 * 
	 * @param openingMain
	 *            the opening_main_id value
	 */
	public void setOpeningMain(
			jkt.hms.masters.business.BloodOpeningStockMain openingMain) {
		this.openingMain = openingMain;
	}

	/**
	 * Return the value associated with the column: component_id
	 */
	public jkt.hms.masters.business.BloodMasComponent getComponent() {
		return component;
	}

	/**
	 * Set the value related to the column: component_id
	 * 
	 * @param component
	 *            the component_id value
	 */
	public void setComponent(
			jkt.hms.masters.business.BloodMasComponent component) {
		this.component = component;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodOpeningStockDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodOpeningStockDetail bloodOpeningStockDetail = (jkt.hms.masters.business.BloodOpeningStockDetail) obj;
			if (null == this.getId() || null == bloodOpeningStockDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodOpeningStockDetail.getId()));
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