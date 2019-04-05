package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_ECG_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_ECG_TYPE"
 */

public abstract class BaseMasEcgType  implements Serializable {

	public static String REF = "MasEcgType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ECG_TYPE_CODE = "EcgTypeCode";
	public static String PROP_ECG_TYPE_NAME = "EcgTypeName";


	// constructors
	public BaseMasEcgType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEcgType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ecgTypeCode;
	private java.lang.String ecgTypeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="incement"
     *  column="MAS_ECG_TYPE_ID"
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
	 * Return the value associated with the column: ECG_TYPE_CODE
	 */
	public java.lang.String getEcgTypeCode () {
		return ecgTypeCode;
	}

	/**
	 * Set the value related to the column: ECG_TYPE_CODE
	 * @param ecgTypeCode the ECG_TYPE_CODE value
	 */
	public void setEcgTypeCode (java.lang.String ecgTypeCode) {
		this.ecgTypeCode = ecgTypeCode;
	}



	/**
	 * Return the value associated with the column: ECG_TYPE_NAME
	 */
	public java.lang.String getEcgTypeName () {
		return ecgTypeName;
	}

	/**
	 * Set the value related to the column: ECG_TYPE_NAME
	 * @param ecgTypeName the ECG_TYPE_NAME value
	 */
	public void setEcgTypeName (java.lang.String ecgTypeName) {
		this.ecgTypeName = ecgTypeName;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEcgType)) return false;
		else {
			jkt.hms.masters.business.MasEcgType masEcgType = (jkt.hms.masters.business.MasEcgType) obj;
			if (null == this.getId() || null == masEcgType.getId()) return false;
			else return (this.getId().equals(masEcgType.getId()));
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