package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WATER_SURVILLANCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WATER_SURVILLANCE"
 */

public abstract class BaseWaterSurvillance  implements Serializable {

	public static String REF = "WaterSurvillance";
	public static String PROP_TYPE_OF_EXAMINATION = "TypeOfExamination";
	public static String PROP_RESULT = "Result";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SOURCE_OF_WATER_SUPPLY = "SourceOfWaterSupply";
	public static String PROP_PLACE_OF_COLLECTION = "PlaceOfCollection";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";
	public static String PROP_SURVILANCE_DATE = "SurvilanceDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";


	// constructors
	public BaseWaterSurvillance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWaterSurvillance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date survilanceDate;
	private java.lang.String typeOfExamination;
	private java.lang.String sourceOfWaterSupply;
	private java.lang.String placeOfCollection;
	private java.lang.String result;
	private java.lang.String quantity;
	private java.lang.String remarks;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee lastChangeBy;
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="SURVILLANCE_ID"
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
	 * Return the value associated with the column: SURVILANCE_DATE
	 */
	public java.util.Date getSurvilanceDate () {
		return survilanceDate;
	}

	/**
	 * Set the value related to the column: SURVILANCE_DATE
	 * @param survilanceDate the SURVILANCE_DATE value
	 */
	public void setSurvilanceDate (java.util.Date survilanceDate) {
		this.survilanceDate = survilanceDate;
	}



	/**
	 * Return the value associated with the column: TYPE_OF_EXAMINATION
	 */
	public java.lang.String getTypeOfExamination () {
		return typeOfExamination;
	}

	/**
	 * Set the value related to the column: TYPE_OF_EXAMINATION
	 * @param typeOfExamination the TYPE_OF_EXAMINATION value
	 */
	public void setTypeOfExamination (java.lang.String typeOfExamination) {
		this.typeOfExamination = typeOfExamination;
	}



	/**
	 * Return the value associated with the column: SOURCE_OF_WATER_SUPPLY
	 */
	public java.lang.String getSourceOfWaterSupply () {
		return sourceOfWaterSupply;
	}

	/**
	 * Set the value related to the column: SOURCE_OF_WATER_SUPPLY
	 * @param sourceOfWaterSupply the SOURCE_OF_WATER_SUPPLY value
	 */
	public void setSourceOfWaterSupply (java.lang.String sourceOfWaterSupply) {
		this.sourceOfWaterSupply = sourceOfWaterSupply;
	}



	/**
	 * Return the value associated with the column: PLACE_OF_COLLECTION
	 */
	public java.lang.String getPlaceOfCollection () {
		return placeOfCollection;
	}

	/**
	 * Set the value related to the column: PLACE_OF_COLLECTION
	 * @param placeOfCollection the PLACE_OF_COLLECTION value
	 */
	public void setPlaceOfCollection (java.lang.String placeOfCollection) {
		this.placeOfCollection = placeOfCollection;
	}



	/**
	 * Return the value associated with the column: RESULT
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: RESULT
	 * @param result the RESULT value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: QUANTITY
	 */
	public java.lang.String getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: QUANTITY
	 * @param quantity the QUANTITY value
	 */
	public void setQuantity (java.lang.String quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_DATE
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_DATE
	 * @param lastChangeDate the LAST_CHANGE_DATE value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_TIME
	 */
	public java.lang.String getLastChangeTime () {
		return lastChangeTime;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_TIME
	 * @param lastChangeTime the LAST_CHANGE_TIME value
	 */
	public void setLastChangeTime (java.lang.String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_BY
	 */
	public jkt.hms.masters.business.MasEmployee getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_BY
	 * @param lastChangeBy the LAST_CHANGE_BY value
	 */
	public void setLastChangeBy (jkt.hms.masters.business.MasEmployee lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.WaterSurvillance)) return false;
		else {
			jkt.hms.masters.business.WaterSurvillance waterSurvillance = (jkt.hms.masters.business.WaterSurvillance) obj;
			if (null == this.getId() || null == waterSurvillance.getId()) return false;
			else return (this.getId().equals(waterSurvillance.getId()));
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