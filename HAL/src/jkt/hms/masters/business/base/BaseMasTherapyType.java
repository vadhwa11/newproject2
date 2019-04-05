package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_THERAPY_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_THERAPY_TYPE"
 */

public abstract class BaseMasTherapyType  implements Serializable {

	public static String REF = "MasTherapyType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_THERAPY_TYPE_CODE = "TherapyTypeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_THERAPY_TYPE_NAME = "TherapyTypeName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasTherapyType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasTherapyType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String therapyTypeCode;
	private java.lang.String therapyTypeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="THERAPY_TYPE_ID"
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
	 * Return the value associated with the column: THERAPY_TYPE_CODE
	 */
	public java.lang.String getTherapyTypeCode () {
		return therapyTypeCode;
	}

	/**
	 * Set the value related to the column: THERAPY_TYPE_CODE
	 * @param therapyTypeCode the THERAPY_TYPE_CODE value
	 */
	public void setTherapyTypeCode (java.lang.String therapyTypeCode) {
		this.therapyTypeCode = therapyTypeCode;
	}



	/**
	 * Return the value associated with the column: THERAPY_TYPE_NAME
	 */
	public java.lang.String getTherapyTypeName () {
		return therapyTypeName;
	}

	/**
	 * Set the value related to the column: THERAPY_TYPE_NAME
	 * @param therapyTypeName the THERAPY_TYPE_NAME value
	 */
	public void setTherapyTypeName (java.lang.String therapyTypeName) {
		this.therapyTypeName = therapyTypeName;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasTherapyType)) return false;
		else {
			jkt.hms.masters.business.MasTherapyType masTherapyType = (jkt.hms.masters.business.MasTherapyType) obj;
			if (null == this.getId() || null == masTherapyType.getId()) return false;
			else return (this.getId().equals(masTherapyType.getId()));
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