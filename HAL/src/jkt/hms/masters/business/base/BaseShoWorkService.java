package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_WORK_SERVICE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_WORK_SERVICE"
 */

public abstract class BaseShoWorkService  implements Serializable {

	public static String REF = "ShoWorkService";
	public static String PROP_DENTAL_CARIES = "DentalCaries";
	public static String PROP_SPECIALIST_COVER_REMARKS = "SpecialistCoverRemarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HYGINE_CHEMICAL = "HygineChemical";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_HYGINE_CHEMICAL_REMARKS = "HygineChemicalRemarks";
	public static String PROP_NURSING_STAFF = "NursingStaff";
	public static String PROP_DENTAL_CARIES_REMARKS = "DentalCariesRemarks";
	public static String PROP_MEDICAL_STORE_REMARKS = "MedicalStoreRemarks";
	public static String PROP_NURSING_STAFF_REMARKS = "NursingStaffRemarks";
	public static String PROP_SPECIALIST_COVER = "SpecialistCover";
	public static String PROP_MEDICAL_STORE = "MedicalStore";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_ID = "Id";


	// constructors
	public BaseShoWorkService () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoWorkService (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date currentDate;
	private java.util.Date lastUpdatedDate;
	private java.lang.String nursingStaff;
	private java.lang.String nursingStaffRemarks;
	private java.lang.String dentalCaries;
	private java.lang.String dentalCariesRemarks;
	private java.lang.String specialistCover;
	private java.lang.String specialistCoverRemarks;
	private java.lang.String medicalStore;
	private java.lang.String medicalStoreRemarks;
	private java.lang.String hygineChemical;
	private java.lang.String hygineChemicalRemarks;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="WORK_SERVICE_ID"
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
	 * Return the value associated with the column: CURRENT_DATE
	 */
	public java.util.Date getCurrentDate () {
		return currentDate;
	}

	/**
	 * Set the value related to the column: CURRENT_DATE
	 * @param currentDate the CURRENT_DATE value
	 */
	public void setCurrentDate (java.util.Date currentDate) {
		this.currentDate = currentDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATED_DATE
	 */
	public java.util.Date getLastUpdatedDate () {
		return lastUpdatedDate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATED_DATE
	 * @param lastUpdatedDate the LAST_UPDATED_DATE value
	 */
	public void setLastUpdatedDate (java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	/**
	 * Return the value associated with the column: NURSING_STAFF
	 */
	public java.lang.String getNursingStaff () {
		return nursingStaff;
	}

	/**
	 * Set the value related to the column: NURSING_STAFF
	 * @param nursingStaff the NURSING_STAFF value
	 */
	public void setNursingStaff (java.lang.String nursingStaff) {
		this.nursingStaff = nursingStaff;
	}



	/**
	 * Return the value associated with the column: NURSING_STAFF_REMARKS
	 */
	public java.lang.String getNursingStaffRemarks () {
		return nursingStaffRemarks;
	}

	/**
	 * Set the value related to the column: NURSING_STAFF_REMARKS
	 * @param nursingStaffRemarks the NURSING_STAFF_REMARKS value
	 */
	public void setNursingStaffRemarks (java.lang.String nursingStaffRemarks) {
		this.nursingStaffRemarks = nursingStaffRemarks;
	}



	/**
	 * Return the value associated with the column: DENTAL_CARRIES
	 */
	public java.lang.String getDentalCaries () {
		return dentalCaries;
	}

	/**
	 * Set the value related to the column: DENTAL_CARRIES
	 * @param dentalCaries the DENTAL_CARRIES value
	 */
	public void setDentalCaries (java.lang.String dentalCaries) {
		this.dentalCaries = dentalCaries;
	}



	/**
	 * Return the value associated with the column: DENTAL_CARIES_REMARKS
	 */
	public java.lang.String getDentalCariesRemarks () {
		return dentalCariesRemarks;
	}

	/**
	 * Set the value related to the column: DENTAL_CARIES_REMARKS
	 * @param dentalCariesRemarks the DENTAL_CARIES_REMARKS value
	 */
	public void setDentalCariesRemarks (java.lang.String dentalCariesRemarks) {
		this.dentalCariesRemarks = dentalCariesRemarks;
	}



	/**
	 * Return the value associated with the column: SPECIALIST_COVER
	 */
	public java.lang.String getSpecialistCover () {
		return specialistCover;
	}

	/**
	 * Set the value related to the column: SPECIALIST_COVER
	 * @param specialistCover the SPECIALIST_COVER value
	 */
	public void setSpecialistCover (java.lang.String specialistCover) {
		this.specialistCover = specialistCover;
	}



	/**
	 * Return the value associated with the column: SPECIALIST_COVER_REMARKS
	 */
	public java.lang.String getSpecialistCoverRemarks () {
		return specialistCoverRemarks;
	}

	/**
	 * Set the value related to the column: SPECIALIST_COVER_REMARKS
	 * @param specialistCoverRemarks the SPECIALIST_COVER_REMARKS value
	 */
	public void setSpecialistCoverRemarks (java.lang.String specialistCoverRemarks) {
		this.specialistCoverRemarks = specialistCoverRemarks;
	}



	/**
	 * Return the value associated with the column: MEDICAL_STORE
	 */
	public java.lang.String getMedicalStore () {
		return medicalStore;
	}

	/**
	 * Set the value related to the column: MEDICAL_STORE
	 * @param medicalStore the MEDICAL_STORE value
	 */
	public void setMedicalStore (java.lang.String medicalStore) {
		this.medicalStore = medicalStore;
	}



	/**
	 * Return the value associated with the column: MEDICAL_STORE_REMARKS
	 */
	public java.lang.String getMedicalStoreRemarks () {
		return medicalStoreRemarks;
	}

	/**
	 * Set the value related to the column: MEDICAL_STORE_REMARKS
	 * @param medicalStoreRemarks the MEDICAL_STORE_REMARKS value
	 */
	public void setMedicalStoreRemarks (java.lang.String medicalStoreRemarks) {
		this.medicalStoreRemarks = medicalStoreRemarks;
	}



	/**
	 * Return the value associated with the column: HYGINE_CHEMICAL
	 */
	public java.lang.String getHygineChemical () {
		return hygineChemical;
	}

	/**
	 * Set the value related to the column: HYGINE_CHEMICAL
	 * @param hygineChemical the HYGINE_CHEMICAL value
	 */
	public void setHygineChemical (java.lang.String hygineChemical) {
		this.hygineChemical = hygineChemical;
	}



	/**
	 * Return the value associated with the column: HYGINE_CHEMICAL_REMARKS
	 */
	public java.lang.String getHygineChemicalRemarks () {
		return hygineChemicalRemarks;
	}

	/**
	 * Set the value related to the column: HYGINE_CHEMICAL_REMARKS
	 * @param hygineChemicalRemarks the HYGINE_CHEMICAL_REMARKS value
	 */
	public void setHygineChemicalRemarks (java.lang.String hygineChemicalRemarks) {
		this.hygineChemicalRemarks = hygineChemicalRemarks;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoWorkService)) return false;
		else {
			jkt.hms.masters.business.ShoWorkService shoWorkService = (jkt.hms.masters.business.ShoWorkService) obj;
			if (null == this.getId() || null == shoWorkService.getId()) return false;
			else return (this.getId().equals(shoWorkService.getId()));
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