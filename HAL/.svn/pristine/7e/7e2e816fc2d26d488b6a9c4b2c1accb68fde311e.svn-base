package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_MEDICAL_UPLOAD_DOCUMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_MEDICAL_UPLOAD_DOCUMENT"
 */

public abstract class BaseMasMedicalUploadDocument  implements Serializable {

	public static String REF = "MasMedicalUploadDocument";
	public static String PROP_MED_DATE = "MedDate";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_FILE_EXTENSION = "FileExtension";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DG_MAS_INVESTIGATION = "DgMasInvestigation";
	public static String PROP_ID_FLAG = "IdFlag";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_MAS_MEDICAL_EXAM_REPORT = "MasMedicalExamReport";
	public static String PROP_FILE_FLAG = "FileFlag";


	// constructors
	public BaseMasMedicalUploadDocument () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMedicalUploadDocument (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private byte[] document;
	private java.lang.String fileName;
	private java.lang.String description;
	private java.lang.String fileExtension;
	private java.lang.String fileFlag;
	private java.lang.String idFlag;
	private java.util.Date medDate;

	// many to one
	private jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport;



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
	 * Return the value associated with the column: document
	 */
	public byte[] getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: document
	 * @param document the document value
	 */
	public void setDocument (byte[] document) {
		this.document = document;
	}



	/**
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: file_extension
	 */
	public java.lang.String getFileExtension () {
		return fileExtension;
	}

	/**
	 * Set the value related to the column: file_extension
	 * @param fileExtension the file_extension value
	 */
	public void setFileExtension (java.lang.String fileExtension) {
		this.fileExtension = fileExtension;
	}



	/**
	 * Return the value associated with the column: file_flag
	 */
	public java.lang.String getFileFlag () {
		return fileFlag;
	}

	/**
	 * Set the value related to the column: file_flag
	 * @param fileFlag the file_flag value
	 */
	public void setFileFlag (java.lang.String fileFlag) {
		this.fileFlag = fileFlag;
	}



	/**
	 * Return the value associated with the column: id_flag
	 */
	public java.lang.String getIdFlag () {
		return idFlag;
	}

	/**
	 * Set the value related to the column: id_flag
	 * @param idFlag the id_flag value
	 */
	public void setIdFlag (java.lang.String idFlag) {
		this.idFlag = idFlag;
	}



	/**
	 * Return the value associated with the column: med_date
	 */
	public java.util.Date getMedDate () {
		return medDate;
	}

	/**
	 * Set the value related to the column: med_date
	 * @param medDate the med_date value
	 */
	public void setMedDate (java.util.Date medDate) {
		this.medDate = medDate;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getDgMasInvestigation () {
		return dgMasInvestigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param dgMasInvestigation the investigation_id value
	 */
	public void setDgMasInvestigation (jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		this.dgMasInvestigation = dgMasInvestigation;
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



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: med_exam_id
	 */
	public jkt.hms.masters.business.MasMedicalExaminationReportOnEntry getMasMedicalExamReport () {
		return masMedicalExamReport;
	}

	/**
	 * Set the value related to the column: med_exam_id
	 * @param masMedicalExamReport the med_exam_id value
	 */
	public void setMasMedicalExamReport (jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport) {
		this.masMedicalExamReport = masMedicalExamReport;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMedicalUploadDocument)) return false;
		else {
			jkt.hms.masters.business.MasMedicalUploadDocument masMedicalUploadDocument = (jkt.hms.masters.business.MasMedicalUploadDocument) obj;
			if (null == this.getId() || null == masMedicalUploadDocument.getId()) return false;
			else return (this.getId().equals(masMedicalUploadDocument.getId()));
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