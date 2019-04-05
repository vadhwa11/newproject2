package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DISABILITYGROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DISABILITYGROUP"
 */

public abstract class BaseDisabilitygroup  implements Serializable {

	public static String REF = "Disabilitygroup";
	public static String PROP_DISEASE_GROUPS = "DiseaseGroups";


	// constructors
	public BaseDisabilitygroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDisabilitygroup (java.lang.Integer groupid) {
		this.setGroupid(groupid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer groupid;

	// fields
	private java.lang.String diseaseGroups;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="GROUPID"
     */
	public java.lang.Integer getGroupid () {
		return groupid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param groupid the new ID
	 */
	public void setGroupid (java.lang.Integer groupid) {
		this.groupid = groupid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: DISEASE_GROUPS
	 */
	public java.lang.String getDiseaseGroups () {
		return diseaseGroups;
	}

	/**
	 * Set the value related to the column: DISEASE_GROUPS
	 * @param diseaseGroups the DISEASE_GROUPS value
	 */
	public void setDiseaseGroups (java.lang.String diseaseGroups) {
		this.diseaseGroups = diseaseGroups;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Disabilitygroup)) return false;
		else {
			jkt.hms.masters.business.Disabilitygroup disabilitygroup = (jkt.hms.masters.business.Disabilitygroup) obj;
			if (null == this.getGroupid() || null == disabilitygroup.getGroupid()) return false;
			else return (this.getGroupid().equals(disabilitygroup.getGroupid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getGroupid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getGroupid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}