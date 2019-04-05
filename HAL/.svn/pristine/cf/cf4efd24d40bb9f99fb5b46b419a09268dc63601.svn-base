package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_diet_combination table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_diet_combination"
 */

public abstract class BaseMasDietCombination  implements Serializable {

	public static String REF = "MasDietCombination";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIET_COMBINATION_NAME = "DietCombinationName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DIET_TYPE = "DietType";
	public static String PROP_DEMAND_DISPLAY = "DemandDisplay";
	public static String PROP_ID = "Id";
	public static String PROP_DIET = "Diet";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasDietCombination () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDietCombination (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dietCombinationName;
	private java.lang.String demandDisplay;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDiet diet;
	private jkt.hms.masters.business.MasDietType dietType;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.DietMenuItemFormula> dietMenuItemFormulas;
	private java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="diet_combination_id"
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
	 * Return the value associated with the column: diet_combination_name
	 */
	public java.lang.String getDietCombinationName () {
		return dietCombinationName;
	}

	/**
	 * Set the value related to the column: diet_combination_name
	 * @param dietCombinationName the diet_combination_name value
	 */
	public void setDietCombinationName (java.lang.String dietCombinationName) {
		this.dietCombinationName = dietCombinationName;
	}



	/**
	 * Return the value associated with the column: demand_display
	 */
	public java.lang.String getDemandDisplay () {
		return demandDisplay;
	}

	/**
	 * Set the value related to the column: demand_display
	 * @param demandDisplay the demand_display value
	 */
	public void setDemandDisplay (java.lang.String demandDisplay) {
		this.demandDisplay = demandDisplay;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet_id
	 * @param diet the diet_id value
	 */
	public void setDiet (jkt.hms.masters.business.MasDiet diet) {
		this.diet = diet;
	}



	/**
	 * Return the value associated with the column: diet_type_id
	 */
	public jkt.hms.masters.business.MasDietType getDietType () {
		return dietType;
	}

	/**
	 * Set the value related to the column: diet_type_id
	 * @param dietType the diet_type_id value
	 */
	public void setDietType (jkt.hms.masters.business.MasDietType dietType) {
		this.dietType = dietType;
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
	 * Return the value associated with the column: DietMenuItemFormulas
	 */
	public java.util.Set<jkt.hms.masters.business.DietMenuItemFormula> getDietMenuItemFormulas () {
		return dietMenuItemFormulas;
	}

	/**
	 * Set the value related to the column: DietMenuItemFormulas
	 * @param dietMenuItemFormulas the DietMenuItemFormulas value
	 */
	public void setDietMenuItemFormulas (java.util.Set<jkt.hms.masters.business.DietMenuItemFormula> dietMenuItemFormulas) {
		this.dietMenuItemFormulas = dietMenuItemFormulas;
	}

	public void addToDietMenuItemFormulas (jkt.hms.masters.business.DietMenuItemFormula dietMenuItemFormula) {
		if (null == getDietMenuItemFormulas()) setDietMenuItemFormulas(new java.util.TreeSet<jkt.hms.masters.business.DietMenuItemFormula>());
		getDietMenuItemFormulas().add(dietMenuItemFormula);
	}



	/**
	 * Return the value associated with the column: DietDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DietDetails> getDietDetails () {
		return dietDetails;
	}

	/**
	 * Set the value related to the column: DietDetails
	 * @param dietDetails the DietDetails value
	 */
	public void setDietDetails (java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails) {
		this.dietDetails = dietDetails;
	}

	public void addToDietDetails (jkt.hms.masters.business.DietDetails dietDetails) {
		if (null == getDietDetails()) setDietDetails(new java.util.TreeSet<jkt.hms.masters.business.DietDetails>());
		getDietDetails().add(dietDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDietCombination)) return false;
		else {
			jkt.hms.masters.business.MasDietCombination masDietCombination = (jkt.hms.masters.business.MasDietCombination) obj;
			if (null == this.getId() || null == masDietCombination.getId()) return false;
			else return (this.getId().equals(masDietCombination.getId()));
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