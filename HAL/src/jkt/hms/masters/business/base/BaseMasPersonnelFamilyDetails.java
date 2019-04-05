package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mas_personnel_family_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_personnel_family_details"
 */

public abstract class BaseMasPersonnelFamilyDetails implements Serializable {

	public static String REF = "MasPersonnelFamilyDetails";
	public static String PROP_NOMINEE = "Nominee";
	public static String PROP_IDENTIFICATION_MARK = "IdentificationMark";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RELATION = "Relation";
	public static String PROP_NOMINEE_PERCENT = "NomineePercent";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_FAMILY_NAME = "FamilyName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONNEL = "Personnel";

	// constructors
	public BaseMasPersonnelFamilyDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPersonnelFamilyDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String familyName;
	private java.util.Date dateOfBirth;
	private java.lang.String nominee;
	private java.math.BigDecimal nomineePercent;
	private java.lang.Integer height;
	private java.lang.String identificationMark;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasPersonnelDetails personnel;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="family_id"
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
	 * Return the value associated with the column: family_name
	 */
	public java.lang.String getFamilyName() {
		return familyName;
	}

	/**
	 * Set the value related to the column: family_name
	 * 
	 * @param familyName
	 *            the family_name value
	 */
	public void setFamilyName(java.lang.String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * 
	 * @param dateOfBirth
	 *            the date_of_birth value
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Return the value associated with the column: is_nominee
	 */
	public java.lang.String getNominee() {
		return nominee;
	}

	/**
	 * Set the value related to the column: is_nominee
	 * 
	 * @param nominee
	 *            the is_nominee value
	 */
	public void setNominee(java.lang.String nominee) {
		this.nominee = nominee;
	}

	/**
	 * Return the value associated with the column: nominee_percent
	 */
	public java.math.BigDecimal getNomineePercent() {
		return nomineePercent;
	}

	/**
	 * Set the value related to the column: nominee_percent
	 * 
	 * @param nomineePercent
	 *            the nominee_percent value
	 */
	public void setNomineePercent(java.math.BigDecimal nomineePercent) {
		this.nomineePercent = nomineePercent;
	}

	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Integer getHeight() {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * 
	 * @param height
	 *            the height value
	 */
	public void setHeight(java.lang.Integer height) {
		this.height = height;
	}

	/**
	 * Return the value associated with the column: identification_mark
	 */
	public java.lang.String getIdentificationMark() {
		return identificationMark;
	}

	/**
	 * Set the value related to the column: identification_mark
	 * 
	 * @param identificationMark
	 *            the identification_mark value
	 */
	public void setIdentificationMark(java.lang.String identificationMark) {
		this.identificationMark = identificationMark;
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
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation() {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * 
	 * @param relation
	 *            the relation_id value
	 */
	public void setRelation(jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}

	/**
	 * Return the value associated with the column: personnel_id
	 */
	public jkt.hms.masters.business.MasPersonnelDetails getPersonnel() {
		return personnel;
	}

	/**
	 * Set the value related to the column: personnel_id
	 * 
	 * @param personnel
	 *            the personnel_id value
	 */
	public void setPersonnel(
			jkt.hms.masters.business.MasPersonnelDetails personnel) {
		this.personnel = personnel;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPersonnelFamilyDetails))
			return false;
		else {
			jkt.hms.masters.business.MasPersonnelFamilyDetails masPersonnelFamilyDetails = (jkt.hms.masters.business.MasPersonnelFamilyDetails) obj;
			if (null == this.getId()
					|| null == masPersonnelFamilyDetails.getId())
				return false;
			else
				return (this.getId().equals(masPersonnelFamilyDetails.getId()));
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