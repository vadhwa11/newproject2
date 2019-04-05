package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_diet_items table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_diet_items"
 */

public abstract class BaseMasDietItems  implements Serializable {

	public static String REF = "MasDietItems";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIET_ITEMS_NAME = "DietItemsName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIET_ITEMS_CODE = "DietItemsCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasDietItems () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDietItems (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dietItemsCode;
	private java.lang.String dietItemsName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDietMenuItem> masDietMenuItems;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="diet_items_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: diet_items_code
	 */
	public java.lang.String getDietItemsCode () {
		return dietItemsCode;
	}

	/**
	 * Set the value related to the column: diet_items_code
	 * @param dietItemsCode the diet_items_code value
	 */
	public void setDietItemsCode (java.lang.String dietItemsCode) {
		this.dietItemsCode = dietItemsCode;
	}



	/**
	 * Return the value associated with the column: diet_items_name
	 */
	public java.lang.String getDietItemsName () {
		return dietItemsName;
	}

	/**
	 * Set the value related to the column: diet_items_name
	 * @param dietItemsName the diet_items_name value
	 */
	public void setDietItemsName (java.lang.String dietItemsName) {
		this.dietItemsName = dietItemsName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: MasDietMenuItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasDietMenuItem> getMasDietMenuItems () {
		return masDietMenuItems;
	}

	/**
	 * Set the value related to the column: MasDietMenuItems
	 * @param masDietMenuItems the MasDietMenuItems value
	 */
	public void setMasDietMenuItems (java.util.Set<jkt.hms.masters.business.MasDietMenuItem> masDietMenuItems) {
		this.masDietMenuItems = masDietMenuItems;
	}

	public void addToMasDietMenuItems (jkt.hms.masters.business.MasDietMenuItem masDietMenuItem) {
		if (null == getMasDietMenuItems()) setMasDietMenuItems(new java.util.TreeSet<jkt.hms.masters.business.MasDietMenuItem>());
		getMasDietMenuItems().add(masDietMenuItem);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDietItems)) return false;
		else {
			jkt.hms.masters.business.MasDietItems masDietItems = (jkt.hms.masters.business.MasDietItems) obj;
			if (null == this.getId() || null == masDietItems.getId()) return false;
			else return (this.getId().equals(masDietItems.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}