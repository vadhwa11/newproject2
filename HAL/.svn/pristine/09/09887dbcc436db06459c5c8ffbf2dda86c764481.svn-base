package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_CA_LICENCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_CA_LICENCE"
 */

public abstract class BaseMasCaLicence  implements Serializable {

	public static String REF = "MasCaLicence";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CA_LICENCE_NAME = "CaLicenceName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CA_LICENCE_CODE = "CaLicenceCode";


	// constructors
	public BaseMasCaLicence () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCaLicence (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String caLicenceCode;
	private java.lang.String caLicenceName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="CA_LICENCE_ID"
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
	 * Return the value associated with the column: CA_LICENCE_CODE
	 */
	public java.lang.String getCaLicenceCode () {
		return caLicenceCode;
	}

	/**
	 * Set the value related to the column: CA_LICENCE_CODE
	 * @param caLicenceCode the CA_LICENCE_CODE value
	 */
	public void setCaLicenceCode (java.lang.String caLicenceCode) {
		this.caLicenceCode = caLicenceCode;
	}



	/**
	 * Return the value associated with the column: CA_LICENCE_NAME
	 */
	public java.lang.String getCaLicenceName () {
		return caLicenceName;
	}

	/**
	 * Set the value related to the column: CA_LICENCE_NAME
	 * @param caLicenceName the CA_LICENCE_NAME value
	 */
	public void setCaLicenceName (java.lang.String caLicenceName) {
		this.caLicenceName = caLicenceName;
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
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCaLicence)) return false;
		else {
			jkt.hms.masters.business.MasCaLicence masCaLicence = (jkt.hms.masters.business.MasCaLicence) obj;
			if (null == this.getId() || null == masCaLicence.getId()) return false;
			else return (this.getId().equals(masCaLicence.getId()));
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