package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYMPTOM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYMPTOM"
 */

public abstract class BaseSymptom  implements Serializable {

	public static String REF = "Symptom";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_COMPLAINT_DESCRIPTION = "ComplaintDescription";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSymptom () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptom (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String complaintDescription;
	private java.lang.Integer parentId;
	private java.lang.String description;



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
	 * Return the value associated with the column: Complaint_desc
	 */
	public java.lang.String getComplaintDescription () {
		return complaintDescription;
	}

	/**
	 * Set the value related to the column: Complaint_desc
	 * @param complaintDescription the Complaint_desc value
	 */
	public void setComplaintDescription (java.lang.String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}



	/**
	 * Return the value associated with the column: parent_id
	 */
	public java.lang.Integer getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parentId the parent_id value
	 */
	public void setParentId (java.lang.Integer parentId) {
		this.parentId = parentId;
	}



	/**
	 * Return the value associated with the column: Description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: Description
	 * @param description the Description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Symptom)) return false;
		else {
			jkt.hms.masters.business.Symptom symptom = (jkt.hms.masters.business.Symptom) obj;
			if (null == this.getId() || null == symptom.getId()) return false;
			else return (this.getId().equals(symptom.getId()));
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