package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NUTRITION_EXAMINATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="NUTRITION_EXAMINATION"
 */

public abstract class BaseNutritionExamination  implements Serializable {

	public static String REF = "NutritionExamination";
	public static String PROP_MEAT_QUALITY = "MeatQuality";
	public static String PROP_MEAT_SUPPLY_SOURCE = "MeatSupplySource";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_QUALITY_OF_RATION = "QualityOfRation";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_MILK_QUALITY = "MilkQuality";
	public static String PROP_EXAMINATION_DATE = "ExaminationDate";
	public static String PROP_UNHYGIENIC_DEFECTS = "UnhygienicDefects";
	public static String PROP_ID = "Id";
	public static String PROP_MILK_SUPPLY_SOURCE = "MilkSupplySource";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_STATE_OF_PERSONNEL = "StateOfPersonnel";
	public static String PROP_COOKING_MESSAGING_ARRANG = "CookingMessagingArrang";


	// constructors
	public BaseNutritionExamination () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNutritionExamination (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String qualityOfRation;
	private java.lang.String stateOfPersonnel;
	private java.lang.String cookingMessagingArrang;
	private java.lang.String unhygienicDefects;
	private java.lang.String meatSupplySource;
	private java.lang.String meatQuality;
	private java.lang.String milkSupplySource;
	private java.lang.String milkQuality;
	private java.lang.String remarks;
	private java.lang.String actionTaken;
	private java.util.Date examinationDate;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: QUALITY_OF_RATION
	 */
	public java.lang.String getQualityOfRation () {
		return qualityOfRation;
	}

	/**
	 * Set the value related to the column: QUALITY_OF_RATION
	 * @param qualityOfRation the QUALITY_OF_RATION value
	 */
	public void setQualityOfRation (java.lang.String qualityOfRation) {
		this.qualityOfRation = qualityOfRation;
	}



	/**
	 * Return the value associated with the column: STATE_OF_PERSONNEL
	 */
	public java.lang.String getStateOfPersonnel () {
		return stateOfPersonnel;
	}

	/**
	 * Set the value related to the column: STATE_OF_PERSONNEL
	 * @param stateOfPersonnel the STATE_OF_PERSONNEL value
	 */
	public void setStateOfPersonnel (java.lang.String stateOfPersonnel) {
		this.stateOfPersonnel = stateOfPersonnel;
	}



	/**
	 * Return the value associated with the column: COOKING_MESSAGING_ARRANG
	 */
	public java.lang.String getCookingMessagingArrang () {
		return cookingMessagingArrang;
	}

	/**
	 * Set the value related to the column: COOKING_MESSAGING_ARRANG
	 * @param cookingMessagingArrang the COOKING_MESSAGING_ARRANG value
	 */
	public void setCookingMessagingArrang (java.lang.String cookingMessagingArrang) {
		this.cookingMessagingArrang = cookingMessagingArrang;
	}



	/**
	 * Return the value associated with the column: UNHYGIENIC_DEFECTS
	 */
	public java.lang.String getUnhygienicDefects () {
		return unhygienicDefects;
	}

	/**
	 * Set the value related to the column: UNHYGIENIC_DEFECTS
	 * @param unhygienicDefects the UNHYGIENIC_DEFECTS value
	 */
	public void setUnhygienicDefects (java.lang.String unhygienicDefects) {
		this.unhygienicDefects = unhygienicDefects;
	}



	/**
	 * Return the value associated with the column: MEAT_SUPPLY_SOURCE
	 */
	public java.lang.String getMeatSupplySource () {
		return meatSupplySource;
	}

	/**
	 * Set the value related to the column: MEAT_SUPPLY_SOURCE
	 * @param meatSupplySource the MEAT_SUPPLY_SOURCE value
	 */
	public void setMeatSupplySource (java.lang.String meatSupplySource) {
		this.meatSupplySource = meatSupplySource;
	}



	/**
	 * Return the value associated with the column: MEAT_QUALITY
	 */
	public java.lang.String getMeatQuality () {
		return meatQuality;
	}

	/**
	 * Set the value related to the column: MEAT_QUALITY
	 * @param meatQuality the MEAT_QUALITY value
	 */
	public void setMeatQuality (java.lang.String meatQuality) {
		this.meatQuality = meatQuality;
	}



	/**
	 * Return the value associated with the column: MILK_SUPPLY_SOURCE
	 */
	public java.lang.String getMilkSupplySource () {
		return milkSupplySource;
	}

	/**
	 * Set the value related to the column: MILK_SUPPLY_SOURCE
	 * @param milkSupplySource the MILK_SUPPLY_SOURCE value
	 */
	public void setMilkSupplySource (java.lang.String milkSupplySource) {
		this.milkSupplySource = milkSupplySource;
	}



	/**
	 * Return the value associated with the column: MILK_QUALITY
	 */
	public java.lang.String getMilkQuality () {
		return milkQuality;
	}

	/**
	 * Set the value related to the column: MILK_QUALITY
	 * @param milkQuality the MILK_QUALITY value
	 */
	public void setMilkQuality (java.lang.String milkQuality) {
		this.milkQuality = milkQuality;
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
	 * Return the value associated with the column: ACTION_TAKEN
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: ACTION_TAKEN
	 * @param actionTaken the ACTION_TAKEN value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
	}



	/**
	 * Return the value associated with the column: EXAMINATION_DATE
	 */
	public java.util.Date getExaminationDate () {
		return examinationDate;
	}

	/**
	 * Set the value related to the column: EXAMINATION_DATE
	 * @param examinationDate the EXAMINATION_DATE value
	 */
	public void setExaminationDate (java.util.Date examinationDate) {
		this.examinationDate = examinationDate;
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
		if (!(obj instanceof jkt.hms.masters.business.NutritionExamination)) return false;
		else {
			jkt.hms.masters.business.NutritionExamination nutritionExamination = (jkt.hms.masters.business.NutritionExamination) obj;
			if (null == this.getId() || null == nutritionExamination.getId()) return false;
			else return (this.getId().equals(nutritionExamination.getId()));
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