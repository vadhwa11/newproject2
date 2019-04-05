package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ame_lmc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ame_lmc"
 */

public abstract class BaseAmeLmc  implements Serializable {

	public static String REF = "AmeLmc";
	public static String PROP_DATE_OF_NRV = "DateOfNrv";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_EMP_RESTRICTION = "EmpRestriction";
	public static String PROP_LMC_HEADER_ID = "LmcHeaderId";
	public static String PROP_DISABILITY_NAME = "DisabilityName";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_PERM_TEMP = "PermTemp";


	// constructors
	public BaseAmeLmc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAmeLmc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String disabilityName;
	private java.lang.String duration;
	private java.lang.String permTemp;
	private java.util.Date dateOfNrv;
	private java.lang.String empRestriction;

	// many to one
	private jkt.hms.masters.business.MasMedicalCategory category;
	private jkt.hms.masters.business.AmeLmcHeader lmcHeaderId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: disability_name
	 */
	public java.lang.String getDisabilityName () {
		return disabilityName;
	}

	/**
	 * Set the value related to the column: disability_name
	 * @param disabilityName the disability_name value
	 */
	public void setDisabilityName (java.lang.String disabilityName) {
		this.disabilityName = disabilityName;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: perm_temp
	 */
	public java.lang.String getPermTemp () {
		return permTemp;
	}

	/**
	 * Set the value related to the column: perm_temp
	 * @param permTemp the perm_temp value
	 */
	public void setPermTemp (java.lang.String permTemp) {
		this.permTemp = permTemp;
	}



	/**
	 * Return the value associated with the column: date_of_nrv
	 */
	public java.util.Date getDateOfNrv () {
		return dateOfNrv;
	}

	/**
	 * Set the value related to the column: date_of_nrv
	 * @param dateOfNrv the date_of_nrv value
	 */
	public void setDateOfNrv (java.util.Date dateOfNrv) {
		this.dateOfNrv = dateOfNrv;
	}



	/**
	 * Return the value associated with the column: emp_restriction
	 */
	public java.lang.String getEmpRestriction () {
		return empRestriction;
	}

	/**
	 * Set the value related to the column: emp_restriction
	 * @param empRestriction the emp_restriction value
	 */
	public void setEmpRestriction (java.lang.String empRestriction) {
		this.empRestriction = empRestriction;
	}



	/**
	 * Return the value associated with the column: category
	 */
	public jkt.hms.masters.business.MasMedicalCategory getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (jkt.hms.masters.business.MasMedicalCategory category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: lmc_header_id
	 */
	public jkt.hms.masters.business.AmeLmcHeader getLmcHeaderId () {
		return lmcHeaderId;
	}

	/**
	 * Set the value related to the column: lmc_header_id
	 * @param lmcHeaderId the lmc_header_id value
	 */
	public void setLmcHeaderId (jkt.hms.masters.business.AmeLmcHeader lmcHeaderId) {
		this.lmcHeaderId = lmcHeaderId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AmeLmc)) return false;
		else {
			jkt.hms.masters.business.AmeLmc ameLmc = (jkt.hms.masters.business.AmeLmc) obj;
			if (null == this.getId() || null == ameLmc.getId()) return false;
			else return (this.getId().equals(ameLmc.getId()));
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