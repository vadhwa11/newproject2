package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_diet table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_diet"
 */

public abstract class BaseMasDiet implements Serializable {

	public static String REF = "MasDiet";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIET_NAME = "DietName";
	public static String PROP_DIET_CATEGORY = "DietCategory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DIET_CODE = "DietCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDiet() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDiet(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dietCode;
	private java.lang.String dietName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String dietCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.DietDetails> dietDetailsByDiet;
	private java.util.Set<jkt.hms.masters.business.DietDetails> dietDetailsByTherapeuticDiet;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.MasDietCombination> masDietCombinations;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="diet_id"
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
	 * Return the value associated with the column: diet_code
	 */
	public java.lang.String getDietCode() {
		return dietCode;
	}

	/**
	 * Set the value related to the column: diet_code
	 * 
	 * @param dietCode
	 *            the diet_code value
	 */
	public void setDietCode(java.lang.String dietCode) {
		this.dietCode = dietCode;
	}

	/**
	 * Return the value associated with the column: diet_name
	 */
	public java.lang.String getDietName() {
		return dietName;
	}

	/**
	 * Set the value related to the column: diet_name
	 * 
	 * @param dietName
	 *            the diet_name value
	 */
	public void setDietName(java.lang.String dietName) {
		this.dietName = dietName;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: diet_category
	 */
	public java.lang.String getDietCategory() {
		return dietCategory;
	}

	/**
	 * Set the value related to the column: diet_category
	 * 
	 * @param dietCategory
	 *            the diet_category value
	 */
	public void setDietCategory(java.lang.String dietCategory) {
		this.dietCategory = dietCategory;
	}

	/**
	 * Return the value associated with the column: DietDetailsByDiet
	 */
	public java.util.Set<jkt.hms.masters.business.DietDetails> getDietDetailsByDiet() {
		return dietDetailsByDiet;
	}

	/**
	 * Set the value related to the column: DietDetailsByDiet
	 * 
	 * @param dietDetailsByDiet
	 *            the DietDetailsByDiet value
	 */
	public void setDietDetailsByDiet(
			java.util.Set<jkt.hms.masters.business.DietDetails> dietDetailsByDiet) {
		this.dietDetailsByDiet = dietDetailsByDiet;
	}

	public void addToDietDetailsByDiet(
			jkt.hms.masters.business.DietDetails dietDetails) {
		if (null == getDietDetailsByDiet())
			setDietDetailsByDiet(new java.util.TreeSet<jkt.hms.masters.business.DietDetails>());
		getDietDetailsByDiet().add(dietDetails);
	}

	/**
	 * Return the value associated with the column: DietDetailsByTherapeuticDiet
	 */
	public java.util.Set<jkt.hms.masters.business.DietDetails> getDietDetailsByTherapeuticDiet() {
		return dietDetailsByTherapeuticDiet;
	}

	/**
	 * Set the value related to the column: DietDetailsByTherapeuticDiet
	 * 
	 * @param dietDetailsByTherapeuticDiet
	 *            the DietDetailsByTherapeuticDiet value
	 */
	public void setDietDetailsByTherapeuticDiet(
			java.util.Set<jkt.hms.masters.business.DietDetails> dietDetailsByTherapeuticDiet) {
		this.dietDetailsByTherapeuticDiet = dietDetailsByTherapeuticDiet;
	}

	public void addToDietDetailsByTherapeuticDiet(
			jkt.hms.masters.business.DietDetails dietDetails) {
		if (null == getDietDetailsByTherapeuticDiet())
			setDietDetailsByTherapeuticDiet(new java.util.TreeSet<jkt.hms.masters.business.DietDetails>());
		getDietDetailsByTherapeuticDiet().add(dietDetails);
	}

	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients() {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * 
	 * @param attachInpatients
	 *            the AttachInpatients value
	 */
	public void setAttachInpatients(
			java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients(
			jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients())
			setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}

	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients() {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * 
	 * @param inpatients
	 *            the Inpatients value
	 */
	public void setInpatients(
			java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients(jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients())
			setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}

	/**
	 * Return the value associated with the column: MasDietCombinations
	 */
	public java.util.Set<jkt.hms.masters.business.MasDietCombination> getMasDietCombinations() {
		return masDietCombinations;
	}

	/**
	 * Set the value related to the column: MasDietCombinations
	 * 
	 * @param masDietCombinations
	 *            the MasDietCombinations value
	 */
	public void setMasDietCombinations(
			java.util.Set<jkt.hms.masters.business.MasDietCombination> masDietCombinations) {
		this.masDietCombinations = masDietCombinations;
	}

	public void addToMasDietCombinations(
			jkt.hms.masters.business.MasDietCombination masDietCombination) {
		if (null == getMasDietCombinations())
			setMasDietCombinations(new java.util.TreeSet<jkt.hms.masters.business.MasDietCombination>());
		getMasDietCombinations().add(masDietCombination);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDiet))
			return false;
		else {
			jkt.hms.masters.business.MasDiet masDiet = (jkt.hms.masters.business.MasDiet) obj;
			if (null == this.getId() || null == masDiet.getId())
				return false;
			else
				return (this.getId().equals(masDiet.getId()));
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