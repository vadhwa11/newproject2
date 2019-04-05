package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DENTAL_TREATMENT_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DENTAL_TREATMENT_DETAIL"
 */

public abstract class BaseDentalTreatmentDetail  implements Serializable {

	public static String REF = "DentalTreatmentDetail";
	public static String PROP_TEETH = "Teeth";
	public static String PROP_DTC = "Dtc";
	public static String PROP_ID = "Id";
	public static String PROP_DENTAL_TREATMENT_HEADER = "DentalTreatmentHeader";
	public static String PROP_REMARK = "Remark";
	public static String PROP_TREATMENT = "Treatment";


	// constructors
	public BaseDentalTreatmentDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDentalTreatmentDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String teeth;
	private java.lang.String treatment;
	private java.lang.String dtc;
	private java.lang.String remark;

	// many to one
	private jkt.hms.masters.business.DentalTreatmentHeader dentalTreatmentHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="DENTAL_TREATMENT_DETAIL_ID"
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
	 * Return the value associated with the column: TEETH
	 */
	public java.lang.String getTeeth () {
		return teeth;
	}

	/**
	 * Set the value related to the column: TEETH
	 * @param teeth the TEETH value
	 */
	public void setTeeth (java.lang.String teeth) {
		this.teeth = teeth;
	}



	/**
	 * Return the value associated with the column: TREATMENT
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: TREATMENT
	 * @param treatment the TREATMENT value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: DTC
	 */
	public java.lang.String getDtc () {
		return dtc;
	}

	/**
	 * Set the value related to the column: DTC
	 * @param dtc the DTC value
	 */
	public void setDtc (java.lang.String dtc) {
		this.dtc = dtc;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: DENTAL_TREATMENT_HEADER_ID
	 */
	public jkt.hms.masters.business.DentalTreatmentHeader getDentalTreatmentHeader () {
		return dentalTreatmentHeader;
	}

	/**
	 * Set the value related to the column: DENTAL_TREATMENT_HEADER_ID
	 * @param dentalTreatmentHeader the DENTAL_TREATMENT_HEADER_ID value
	 */
	public void setDentalTreatmentHeader (jkt.hms.masters.business.DentalTreatmentHeader dentalTreatmentHeader) {
		this.dentalTreatmentHeader = dentalTreatmentHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DentalTreatmentDetail)) return false;
		else {
			jkt.hms.masters.business.DentalTreatmentDetail dentalTreatmentDetail = (jkt.hms.masters.business.DentalTreatmentDetail) obj;
			if (null == this.getId() || null == dentalTreatmentDetail.getId()) return false;
			else return (this.getId().equals(dentalTreatmentDetail.getId()));
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