package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * physiotherapy_treatment_details table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="physiotherapy_treatment_details"
 */

public abstract class BasePhysiotherapyTreatmentDetails implements Serializable {

	public static String REF = "PhysiotherapyTreatmentDetails";
	public static String PROP_PHYSIOTHERAPY_VISIT = "PhysiotherapyVisit";
	public static String PROP_TREARTMENT = "Treartment";
	public static String PROP_ID = "Id";

	// constructors
	public BasePhysiotherapyTreatmentDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysiotherapyTreatmentDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasPhysiotherapyTreatment treartment;
	private jkt.hms.masters.business.PhysiotherapyVisitDetails physiotherapyVisit;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment"
	 *               column="physiotherapy_treatment_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: treartment_id
	 */
	public jkt.hms.masters.business.MasPhysiotherapyTreatment getTreartment() {
		return treartment;
	}

	/**
	 * Set the value related to the column: treartment_id
	 * 
	 * @param treartment
	 *            the treartment_id value
	 */
	public void setTreartment(
			jkt.hms.masters.business.MasPhysiotherapyTreatment treartment) {
		this.treartment = treartment;
	}

	/**
	 * Return the value associated with the column: physiotherapy_visit_id
	 */
	public jkt.hms.masters.business.PhysiotherapyVisitDetails getPhysiotherapyVisit() {
		return physiotherapyVisit;
	}

	/**
	 * Set the value related to the column: physiotherapy_visit_id
	 * 
	 * @param physiotherapyVisit
	 *            the physiotherapy_visit_id value
	 */
	public void setPhysiotherapyVisit(
			jkt.hms.masters.business.PhysiotherapyVisitDetails physiotherapyVisit) {
		this.physiotherapyVisit = physiotherapyVisit;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysiotherapyTreatmentDetails))
			return false;
		else {
			jkt.hms.masters.business.PhysiotherapyTreatmentDetails physiotherapyTreatmentDetails = (jkt.hms.masters.business.PhysiotherapyTreatmentDetails) obj;
			if (null == this.getId()
					|| null == physiotherapyTreatmentDetails.getId())
				return false;
			else
				return (this.getId().equals(physiotherapyTreatmentDetails
						.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}