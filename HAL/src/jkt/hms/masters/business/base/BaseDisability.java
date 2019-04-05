package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DISABILITY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DISABILITY"
 */

public abstract class BaseDisability  implements Serializable {

	public static String REF = "Disability";
	public static String PROP_SERVICE_NUMBER = "ServiceNumber";
	public static String PROP_DATE = "Date";
	public static String PROP_DISABILITY = "Disability";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_PERM_TEMP = "PermTemp";
	public static String PROP_PERIODS = "Periods";


	// constructors
	public BaseDisability () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDisability (java.lang.Integer disabilityid) {
		this.setDisabilityid(disabilityid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer disabilityid;

	// fields
	private java.lang.Integer serviceNumber;
	private java.util.Date date;
	private java.lang.String disability;
	private java.lang.String category;
	private java.lang.Integer permTemp;
	private java.lang.Integer periods;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="DISABILITYID"
     */
	public java.lang.Integer getDisabilityid () {
		return disabilityid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param disabilityid the new ID
	 */
	public void setDisabilityid (java.lang.Integer disabilityid) {
		this.disabilityid = disabilityid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: SERVICE_NUMBER
	 */
	public java.lang.Integer getServiceNumber () {
		return serviceNumber;
	}

	/**
	 * Set the value related to the column: SERVICE_NUMBER
	 * @param serviceNumber the SERVICE_NUMBER value
	 */
	public void setServiceNumber (java.lang.Integer serviceNumber) {
		this.serviceNumber = serviceNumber;
	}



	/**
	 * Return the value associated with the column: DATE_
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: DATE_
	 * @param date the DATE_ value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: DISABILITY
	 */
	public java.lang.String getDisability () {
		return disability;
	}

	/**
	 * Set the value related to the column: DISABILITY
	 * @param disability the DISABILITY value
	 */
	public void setDisability (java.lang.String disability) {
		this.disability = disability;
	}



	/**
	 * Return the value associated with the column: CATEGORY
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY
	 * @param category the CATEGORY value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: PERM__TEMP
	 */
	public java.lang.Integer getPermTemp () {
		return permTemp;
	}

	/**
	 * Set the value related to the column: PERM__TEMP
	 * @param permTemp the PERM__TEMP value
	 */
	public void setPermTemp (java.lang.Integer permTemp) {
		this.permTemp = permTemp;
	}



	/**
	 * Return the value associated with the column: PERIODS
	 */
	public java.lang.Integer getPeriods () {
		return periods;
	}

	/**
	 * Set the value related to the column: PERIODS
	 * @param periods the PERIODS value
	 */
	public void setPeriods (java.lang.Integer periods) {
		this.periods = periods;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Disability)) return false;
		else {
			jkt.hms.masters.business.Disability disability = (jkt.hms.masters.business.Disability) obj;
			if (null == this.getDisabilityid() || null == disability.getDisabilityid()) return false;
			else return (this.getDisabilityid().equals(disability.getDisabilityid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getDisabilityid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getDisabilityid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}