package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_diet_indent_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_diet_indent_item"
 */

public abstract class BaseMasDietIndentItem  implements Serializable {

	public static String REF = "MasDietIndentItem";
	public static String PROP_STATUS = "Status";
	public static String PROP_DENOMINATIONS = "Denominations";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INDENT_ITEM_TYPE = "IndentItemType";
	public static String PROP_INDENT_ITEM_NAME = "IndentItemName";
	public static String PROP_EXTRA_ITEM = "ExtraItem";
	public static String PROP_ID = "Id";
	public static String PROP_INDENT_ITEM_CODE = "IndentItemCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INDENT_GROUP = "IndentGroup";


	// constructors
	public BaseMasDietIndentItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDietIndentItem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String indentItemCode;
	private java.lang.String indentItemName;
	private java.lang.String indentItemType;
	private java.lang.String extraItem;
	private java.lang.String indentGroup;
	private java.lang.String denominations;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.DietExtraItemFormula> dietExtraItemFormulas;
	private java.util.Set<jkt.hms.masters.business.DietIndentItemFormula> dietIndentItemFormulas;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="diet_indent_item_id"
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
	 * Return the value associated with the column: indent_item_code
	 */
	public java.lang.String getIndentItemCode () {
		return indentItemCode;
	}

	/**
	 * Set the value related to the column: indent_item_code
	 * @param indentItemCode the indent_item_code value
	 */
	public void setIndentItemCode (java.lang.String indentItemCode) {
		this.indentItemCode = indentItemCode;
	}



	/**
	 * Return the value associated with the column: indent_item_name
	 */
	public java.lang.String getIndentItemName () {
		return indentItemName;
	}

	/**
	 * Set the value related to the column: indent_item_name
	 * @param indentItemName the indent_item_name value
	 */
	public void setIndentItemName (java.lang.String indentItemName) {
		this.indentItemName = indentItemName;
	}



	/**
	 * Return the value associated with the column: indent_item_type
	 */
	public java.lang.String getIndentItemType () {
		return indentItemType;
	}

	/**
	 * Set the value related to the column: indent_item_type
	 * @param indentItemType the indent_item_type value
	 */
	public void setIndentItemType (java.lang.String indentItemType) {
		this.indentItemType = indentItemType;
	}



	/**
	 * Return the value associated with the column: extra_item
	 */
	public java.lang.String getExtraItem () {
		return extraItem;
	}

	/**
	 * Set the value related to the column: extra_item
	 * @param extraItem the extra_item value
	 */
	public void setExtraItem (java.lang.String extraItem) {
		this.extraItem = extraItem;
	}



	/**
	 * Return the value associated with the column: indent_group
	 */
	public java.lang.String getIndentGroup () {
		return indentGroup;
	}

	/**
	 * Set the value related to the column: indent_group
	 * @param indentGroup the indent_group value
	 */
	public void setIndentGroup (java.lang.String indentGroup) {
		this.indentGroup = indentGroup;
	}



	/**
	 * Return the value associated with the column: denominations
	 */
	public java.lang.String getDenominations () {
		return denominations;
	}

	/**
	 * Set the value related to the column: denominations
	 * @param denominations the denominations value
	 */
	public void setDenominations (java.lang.String denominations) {
		this.denominations = denominations;
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
	 * Return the value associated with the column: DietExtraItemFormulas
	 */
	public java.util.Set<jkt.hms.masters.business.DietExtraItemFormula> getDietExtraItemFormulas () {
		return dietExtraItemFormulas;
	}

	/**
	 * Set the value related to the column: DietExtraItemFormulas
	 * @param dietExtraItemFormulas the DietExtraItemFormulas value
	 */
	public void setDietExtraItemFormulas (java.util.Set<jkt.hms.masters.business.DietExtraItemFormula> dietExtraItemFormulas) {
		this.dietExtraItemFormulas = dietExtraItemFormulas;
	}

	public void addToDietExtraItemFormulas (jkt.hms.masters.business.DietExtraItemFormula dietExtraItemFormula) {
		if (null == getDietExtraItemFormulas()) setDietExtraItemFormulas(new java.util.TreeSet<jkt.hms.masters.business.DietExtraItemFormula>());
		getDietExtraItemFormulas().add(dietExtraItemFormula);
	}



	/**
	 * Return the value associated with the column: DietIndentItemFormulas
	 */
	public java.util.Set<jkt.hms.masters.business.DietIndentItemFormula> getDietIndentItemFormulas () {
		return dietIndentItemFormulas;
	}

	/**
	 * Set the value related to the column: DietIndentItemFormulas
	 * @param dietIndentItemFormulas the DietIndentItemFormulas value
	 */
	public void setDietIndentItemFormulas (java.util.Set<jkt.hms.masters.business.DietIndentItemFormula> dietIndentItemFormulas) {
		this.dietIndentItemFormulas = dietIndentItemFormulas;
	}

	public void addToDietIndentItemFormulas (jkt.hms.masters.business.DietIndentItemFormula dietIndentItemFormula) {
		if (null == getDietIndentItemFormulas()) setDietIndentItemFormulas(new java.util.TreeSet<jkt.hms.masters.business.DietIndentItemFormula>());
		getDietIndentItemFormulas().add(dietIndentItemFormula);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDietIndentItem)) return false;
		else {
			jkt.hms.masters.business.MasDietIndentItem masDietIndentItem = (jkt.hms.masters.business.MasDietIndentItem) obj;
			if (null == this.getId() || null == masDietIndentItem.getId()) return false;
			else return (this.getId().equals(masDietIndentItem.getId()));
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