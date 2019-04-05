package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * diet_daily_therapeutic_summary table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="diet_daily_therapeutic_summary"
 */

public abstract class BaseDietDailyTherapeuticSummary implements Serializable {

	public static String REF = "DietDailyTherapeuticSummary";
	public static String PROP_DIET_SUMMARY_DATE = "DietSummaryDate";
	public static String PROP_DIET_COUNT = "DietCount";
	public static String PROP_DIET_CATEGORY = "DietCategory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DIET_CODE = "DietCode";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDietDailyTherapeuticSummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDailyTherapeuticSummary(java.lang.Integer id) {
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
	private java.lang.Integer dietCount;
	private java.util.Date dietSummaryDate;
	private java.lang.String dietCategory;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="therapeutic_diet_summary_id"
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
	 * Return the value associated with the column: diet_count
	 */
	public java.lang.Integer getDietCount() {
		return dietCount;
	}

	/**
	 * Set the value related to the column: diet_count
	 * 
	 * @param dietCount
	 *            the diet_count value
	 */
	public void setDietCount(java.lang.Integer dietCount) {
		this.dietCount = dietCount;
	}

	/**
	 * Return the value associated with the column: diet_summary_date
	 */
	public java.util.Date getDietSummaryDate() {
		return dietSummaryDate;
	}

	/**
	 * Set the value related to the column: diet_summary_date
	 * 
	 * @param dietSummaryDate
	 *            the diet_summary_date value
	 */
	public void setDietSummaryDate(java.util.Date dietSummaryDate) {
		this.dietSummaryDate = dietSummaryDate;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDailyTherapeuticSummary))
			return false;
		else {
			jkt.hms.masters.business.DietDailyTherapeuticSummary dietDailyTherapeuticSummary = (jkt.hms.masters.business.DietDailyTherapeuticSummary) obj;
			if (null == this.getId()
					|| null == dietDailyTherapeuticSummary.getId())
				return false;
			else
				return (this.getId()
						.equals(dietDailyTherapeuticSummary.getId()));
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