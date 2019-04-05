package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mortuary_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mortuary_details"
 */

public abstract class BaseMortuaryDetails  implements Serializable {

	public static String REF = "MortuaryDetails";
	public static String PROP_DEAD_DEPARTMENT = "DeadDepartment";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseMortuaryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMortuaryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deadDepartment;

	// many to one
	private jkt.hms.masters.business.Patient hin;



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
	 * Return the value associated with the column: dead_department
	 */
	public java.lang.String getDeadDepartment () {
		return deadDepartment;
	}

	/**
	 * Set the value related to the column: dead_department
	 * @param deadDepartment the dead_department value
	 */
	public void setDeadDepartment (java.lang.String deadDepartment) {
		this.deadDepartment = deadDepartment;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MortuaryDetails)) return false;
		else {
			jkt.hms.masters.business.MortuaryDetails mortuaryDetails = (jkt.hms.masters.business.MortuaryDetails) obj;
			if (null == this.getId() || null == mortuaryDetails.getId()) return false;
			else return (this.getId().equals(mortuaryDetails.getId()));
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