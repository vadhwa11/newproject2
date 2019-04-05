package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DISPENSARY_INDENT_LP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DISPENSARY_INDENT_LP"
 */

public abstract class BaseDispensaryIndentLp  implements Serializable {

	public static String REF = "DispensaryIndentLp";
	public static String PROP_NOMENCLATURE = "nomenclature";
	public static String PROP_STRENGTH = "strength";
	public static String PROP_PVMS_NO = "pvmsNo";
	public static String PROP_ID = "Id";
	public static String PROP_QUANTITY = "quantity";


	// constructors
	public BaseDispensaryIndentLp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDispensaryIndentLp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pvmsNo;
	private java.lang.String nomenclature;
	private java.lang.String strength;
	private java.lang.Integer quantity;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: pvms_no
	 */
	public java.lang.String getPvmsNo () {
		return pvmsNo;
	}

	/**
	 * Set the value related to the column: pvms_no
	 * @param pvmsNo the pvms_no value
	 */
	public void setPvmsNo (java.lang.String pvmsNo) {
		this.pvmsNo = pvmsNo;
	}



	/**
	 * Return the value associated with the column: nomenclature
	 */
	public java.lang.String getNomenclature () {
		return nomenclature;
	}

	/**
	 * Set the value related to the column: nomenclature
	 * @param nomenclature the nomenclature value
	 */
	public void setNomenclature (java.lang.String nomenclature) {
		this.nomenclature = nomenclature;
	}



	/**
	 * Return the value associated with the column: strength
	 */
	public java.lang.String getStrength () {
		return strength;
	}

	/**
	 * Set the value related to the column: strength
	 * @param strength the strength value
	 */
	public void setStrength (java.lang.String strength) {
		this.strength = strength;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DispensaryIndentLp)) return false;
		else {
			jkt.hms.masters.business.DispensaryIndentLp dispensaryIndentLp = (jkt.hms.masters.business.DispensaryIndentLp) obj;
			if (null == this.getId() || null == dispensaryIndentLp.getId()) return false;
			else return (this.getId().equals(dispensaryIndentLp.getId()));
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