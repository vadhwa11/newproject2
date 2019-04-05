package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_grade table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_grade"
 */

public abstract class BaseMasGrade  implements Serializable {

	public static String REF = "MasGrade";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRADE_CODE = "GradeCode";
	public static String PROP_RANK_CATEGORY = "RankCategory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_GRADE_NAME = "GradeName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasGrade () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasGrade (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gradeCode;
	private java.lang.String gradeName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasRankCategory rankCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="grade_id"
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
	 * Return the value associated with the column: grade_code
	 */
	public java.lang.String getGradeCode () {
		return gradeCode;
	}

	/**
	 * Set the value related to the column: grade_code
	 * @param gradeCode the grade_code value
	 */
	public void setGradeCode (java.lang.String gradeCode) {
		this.gradeCode = gradeCode;
	}



	/**
	 * Return the value associated with the column: grade_name
	 */
	public java.lang.String getGradeName () {
		return gradeName;
	}

	/**
	 * Set the value related to the column: grade_name
	 * @param gradeName the grade_name value
	 */
	public void setGradeName (java.lang.String gradeName) {
		this.gradeName = gradeName;
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
	 * Return the value associated with the column: rank_category_id
	 */
	public jkt.hms.masters.business.MasRankCategory getRankCategory () {
		return rankCategory;
	}

	/**
	 * Set the value related to the column: rank_category_id
	 * @param rankCategory the rank_category_id value
	 */
	public void setRankCategory (jkt.hms.masters.business.MasRankCategory rankCategory) {
		this.rankCategory = rankCategory;
	}



	/**
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasGrade)) return false;
		else {
			jkt.hms.masters.business.MasGrade masGrade = (jkt.hms.masters.business.MasGrade) obj;
			if (null == this.getId() || null == masGrade.getId()) return false;
			else return (this.getId().equals(masGrade.getId()));
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