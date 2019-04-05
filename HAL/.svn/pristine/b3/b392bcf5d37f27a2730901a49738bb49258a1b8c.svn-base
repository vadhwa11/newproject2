package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_PRE_FLIGHT_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_PRE_FLIGHT_DT"
 */

public abstract class BaseAvPreFlightDt  implements Serializable {

	public static String REF = "AvPreFlightDt";
	public static String PROP_MED_CATEGORY = "MedCategory";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_VISUAL_INSPECT = "VisualInspect";
	public static String PROP_IMAGE_DATE = "ImageDate";
	public static String PROP_SORTIE_DAY = "SortieDay";
	public static String PROP_UNIT = "Unit";
	public static String PROP_CHECK_STATUS = "CheckStatus";
	public static String PROP_IMAGE_TIME = "ImageTime";
	public static String PROP_SERVICE_IMAGE = "ServiceImage";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_ID = "Id";
	public static String PROP_FLIGHT_HD = "FlightHd";
	public static String PROP_HIN = "Hin";
	public static String PROP_IMAGE_FILE_EXTENSION = "ImageFileExtension";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseAvPreFlightDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvPreFlightDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String fullName;
	private java.lang.String age;
	private java.lang.String sortieDay;
	private java.lang.String checkStatus;
	private java.lang.String visualInspect;
	private byte[] serviceImage;
	private java.lang.String imageFileExtension;
	private java.lang.String fileName;
	private java.util.Date imageDate;
	private java.lang.String imageTime;

	// many to one
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.AvPreFlight flightHd;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.Category medCategory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: FULL_NAME
	 */
	public java.lang.String getFullName () {
		return fullName;
	}

	/**
	 * Set the value related to the column: FULL_NAME
	 * @param fullName the FULL_NAME value
	 */
	public void setFullName (java.lang.String fullName) {
		this.fullName = fullName;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: SORTIE_DAY
	 */
	public java.lang.String getSortieDay () {
		return sortieDay;
	}

	/**
	 * Set the value related to the column: SORTIE_DAY
	 * @param sortieDay the SORTIE_DAY value
	 */
	public void setSortieDay (java.lang.String sortieDay) {
		this.sortieDay = sortieDay;
	}



	/**
	 * Return the value associated with the column: CHECK_STATUS
	 */
	public java.lang.String getCheckStatus () {
		return checkStatus;
	}

	/**
	 * Set the value related to the column: CHECK_STATUS
	 * @param checkStatus the CHECK_STATUS value
	 */
	public void setCheckStatus (java.lang.String checkStatus) {
		this.checkStatus = checkStatus;
	}



	/**
	 * Return the value associated with the column: VISUAL_INSPECT
	 */
	public java.lang.String getVisualInspect () {
		return visualInspect;
	}

	/**
	 * Set the value related to the column: VISUAL_INSPECT
	 * @param visualInspect the VISUAL_INSPECT value
	 */
	public void setVisualInspect (java.lang.String visualInspect) {
		this.visualInspect = visualInspect;
	}



	/**
	 * Return the value associated with the column: service_image
	 */
	public byte[] getServiceImage () {
		return serviceImage;
	}

	/**
	 * Set the value related to the column: service_image
	 * @param serviceImage the service_image value
	 */
	public void setServiceImage (byte[] serviceImage) {
		this.serviceImage = serviceImage;
	}



	/**
	 * Return the value associated with the column: image_file_extension
	 */
	public java.lang.String getImageFileExtension () {
		return imageFileExtension;
	}

	/**
	 * Set the value related to the column: image_file_extension
	 * @param imageFileExtension the image_file_extension value
	 */
	public void setImageFileExtension (java.lang.String imageFileExtension) {
		this.imageFileExtension = imageFileExtension;
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
	 * Return the value associated with the column: image_date
	 */
	public java.util.Date getImageDate () {
		return imageDate;
	}

	/**
	 * Set the value related to the column: image_date
	 * @param imageDate the image_date value
	 */
	public void setImageDate (java.util.Date imageDate) {
		this.imageDate = imageDate;
	}



	/**
	 * Return the value associated with the column: image_time
	 */
	public java.lang.String getImageTime () {
		return imageTime;
	}

	/**
	 * Set the value related to the column: image_time
	 * @param imageTime the image_time value
	 */
	public void setImageTime (java.lang.String imageTime) {
		this.imageTime = imageTime;
	}



	/**
	 * Return the value associated with the column: SEX_ID
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX_ID
	 * @param sex the SEX_ID value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rank the RANK_ID value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: FLIGHT_HD_ID
	 */
	public jkt.hms.masters.business.AvPreFlight getFlightHd () {
		return flightHd;
	}

	/**
	 * Set the value related to the column: FLIGHT_HD_ID
	 * @param flightHd the FLIGHT_HD_ID value
	 */
	public void setFlightHd (jkt.hms.masters.business.AvPreFlight flightHd) {
		this.flightHd = flightHd;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unit the UNIT_ID value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: med_category
	 */
	public jkt.hms.masters.business.Category getMedCategory () {
		return medCategory;
	}

	/**
	 * Set the value related to the column: med_category
	 * @param medCategory the med_category value
	 */
	public void setMedCategory (jkt.hms.masters.business.Category medCategory) {
		this.medCategory = medCategory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvPreFlightDt)) return false;
		else {
			jkt.hms.masters.business.AvPreFlightDt avPreFlightDt = (jkt.hms.masters.business.AvPreFlightDt) obj;
			if (null == this.getId() || null == avPreFlightDt.getId()) return false;
			else return (this.getId().equals(avPreFlightDt.getId()));
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