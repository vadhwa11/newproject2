package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pre_anesthesia_consult_doctor_hd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pre_anesthesia_consult_doctor_hd"
 */

public abstract class BasePreAnesthesiaConsultDoctorHd  implements Serializable {

	public static String REF = "PreAnesthesiaConsultDoctorHd";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_OT_PRE_ANESTHESIA_HD = "OtPreAnesthesiaHd";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BasePreAnesthesiaConsultDoctorHd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePreAnesthesiaConsultDoctorHd (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.OtPreAnesthesiaHd otPreAnesthesiaHd;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt> preAnesthesiaConsultDoctorDts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="consult_doctor_id_hd"
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: ot_pre_anesthesia_hd
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaHd getOtPreAnesthesiaHd () {
		return otPreAnesthesiaHd;
	}

	/**
	 * Set the value related to the column: ot_pre_anesthesia_hd
	 * @param otPreAnesthesiaHd the ot_pre_anesthesia_hd value
	 */
	public void setOtPreAnesthesiaHd (jkt.hms.masters.business.OtPreAnesthesiaHd otPreAnesthesiaHd) {
		this.otPreAnesthesiaHd = otPreAnesthesiaHd;
	}



	/**
	 * Return the value associated with the column: hospital
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital
	 * @param hospital the hospital value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: PreAnesthesiaConsultDoctorDts
	 */
	public java.util.Set<jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt> getPreAnesthesiaConsultDoctorDts () {
		return preAnesthesiaConsultDoctorDts;
	}

	/**
	 * Set the value related to the column: PreAnesthesiaConsultDoctorDts
	 * @param preAnesthesiaConsultDoctorDts the PreAnesthesiaConsultDoctorDts value
	 */
	public void setPreAnesthesiaConsultDoctorDts (java.util.Set<jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt> preAnesthesiaConsultDoctorDts) {
		this.preAnesthesiaConsultDoctorDts = preAnesthesiaConsultDoctorDts;
	}

	public void addToPreAnesthesiaConsultDoctorDts (jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt preAnesthesiaConsultDoctorDt) {
		if (null == getPreAnesthesiaConsultDoctorDts()) setPreAnesthesiaConsultDoctorDts(new java.util.TreeSet<jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt>());
		getPreAnesthesiaConsultDoctorDts().add(preAnesthesiaConsultDoctorDt);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd)) return false;
		else {
			jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd preAnesthesiaConsultDoctorHd = (jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd) obj;
			if (null == this.getId() || null == preAnesthesiaConsultDoctorHd.getId()) return false;
			else return (this.getId().equals(preAnesthesiaConsultDoctorHd.getId()));
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