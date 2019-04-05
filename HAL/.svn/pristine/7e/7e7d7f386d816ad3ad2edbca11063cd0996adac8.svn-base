package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SCHOOL_INSPECTION_ENTRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SCHOOL_INSPECTION_ENTRY"
 */

public abstract class BaseSchoolInspectionEntry  implements Serializable {

	public static String REF = "SchoolInspectionEntry";
	public static String PROP_ACTION_RECTIFY_DEFECTS = "ActionRectifyDefects";
	public static String PROP_NO_CHILDREN_MEDICALLY_EXAMINED = "NoChildrenMedicallyExamined";
	public static String PROP_DENTAL_CARRIES = "DentalCarries";
	public static String PROP_OTHER = "Other";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_DETAILS_PROT_SCHOOL_CHILD = "DetailsProtSchoolChild";
	public static String PROP_DEFECTIVE_VISION = "DefectiveVision";
	public static String PROP_ID = "Id";
	public static String PROP_NAME_OF_INSPECTING_PERSON = "NameOfInspectingPerson";
	public static String PROP_ENLARGED_GLANDS = "EnlargedGlands";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_NAME_OF_SCHOOL = "NameOfSchool";
	public static String PROP_DATE_OF_INSPECTION = "DateOfInspection";
	public static String PROP_WAX_EAR = "WaxEar";


	// constructors
	public BaseSchoolInspectionEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSchoolInspectionEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfInspection;
	private java.lang.String nameOfSchool;
	private java.lang.String nameOfInspectingPerson;
	private java.lang.String noChildrenMedicallyExamined;
	private java.lang.String dentalCarries;
	private java.lang.String defectiveVision;
	private java.lang.String waxEar;
	private java.lang.String enlargedGlands;
	private java.lang.String other;
	private java.lang.String actionRectifyDefects;
	private java.lang.String detailsProtSchoolChild;

	// many to one
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasDepartment departmentId;



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
	 * Return the value associated with the column: DATE_OF_INSPECTION
	 */
	public java.util.Date getDateOfInspection () {
		return dateOfInspection;
	}

	/**
	 * Set the value related to the column: DATE_OF_INSPECTION
	 * @param dateOfInspection the DATE_OF_INSPECTION value
	 */
	public void setDateOfInspection (java.util.Date dateOfInspection) {
		this.dateOfInspection = dateOfInspection;
	}



	/**
	 * Return the value associated with the column: NAME_OF_SCHOOL
	 */
	public java.lang.String getNameOfSchool () {
		return nameOfSchool;
	}

	/**
	 * Set the value related to the column: NAME_OF_SCHOOL
	 * @param nameOfSchool the NAME_OF_SCHOOL value
	 */
	public void setNameOfSchool (java.lang.String nameOfSchool) {
		this.nameOfSchool = nameOfSchool;
	}



	/**
	 * Return the value associated with the column: NAME_OF_INSPECTING_PERSON
	 */
	public java.lang.String getNameOfInspectingPerson () {
		return nameOfInspectingPerson;
	}

	/**
	 * Set the value related to the column: NAME_OF_INSPECTING_PERSON
	 * @param nameOfInspectingPerson the NAME_OF_INSPECTING_PERSON value
	 */
	public void setNameOfInspectingPerson (java.lang.String nameOfInspectingPerson) {
		this.nameOfInspectingPerson = nameOfInspectingPerson;
	}



	/**
	 * Return the value associated with the column: NO_CHILDREN_MEDICALLY_EXAMINED
	 */
	public java.lang.String getNoChildrenMedicallyExamined () {
		return noChildrenMedicallyExamined;
	}

	/**
	 * Set the value related to the column: NO_CHILDREN_MEDICALLY_EXAMINED
	 * @param noChildrenMedicallyExamined the NO_CHILDREN_MEDICALLY_EXAMINED value
	 */
	public void setNoChildrenMedicallyExamined (java.lang.String noChildrenMedicallyExamined) {
		this.noChildrenMedicallyExamined = noChildrenMedicallyExamined;
	}



	/**
	 * Return the value associated with the column: DENTAL_CARRIES
	 */
	public java.lang.String getDentalCarries () {
		return dentalCarries;
	}

	/**
	 * Set the value related to the column: DENTAL_CARRIES
	 * @param dentalCarries the DENTAL_CARRIES value
	 */
	public void setDentalCarries (java.lang.String dentalCarries) {
		this.dentalCarries = dentalCarries;
	}



	/**
	 * Return the value associated with the column: DEFECTIVE_VISION
	 */
	public java.lang.String getDefectiveVision () {
		return defectiveVision;
	}

	/**
	 * Set the value related to the column: DEFECTIVE_VISION
	 * @param defectiveVision the DEFECTIVE_VISION value
	 */
	public void setDefectiveVision (java.lang.String defectiveVision) {
		this.defectiveVision = defectiveVision;
	}



	/**
	 * Return the value associated with the column: WAX_EAR
	 */
	public java.lang.String getWaxEar () {
		return waxEar;
	}

	/**
	 * Set the value related to the column: WAX_EAR
	 * @param waxEar the WAX_EAR value
	 */
	public void setWaxEar (java.lang.String waxEar) {
		this.waxEar = waxEar;
	}



	/**
	 * Return the value associated with the column: ENLARGED_GLANDS
	 */
	public java.lang.String getEnlargedGlands () {
		return enlargedGlands;
	}

	/**
	 * Set the value related to the column: ENLARGED_GLANDS
	 * @param enlargedGlands the ENLARGED_GLANDS value
	 */
	public void setEnlargedGlands (java.lang.String enlargedGlands) {
		this.enlargedGlands = enlargedGlands;
	}



	/**
	 * Return the value associated with the column: OTHER
	 */
	public java.lang.String getOther () {
		return other;
	}

	/**
	 * Set the value related to the column: OTHER
	 * @param other the OTHER value
	 */
	public void setOther (java.lang.String other) {
		this.other = other;
	}



	/**
	 * Return the value associated with the column: ACTION_RECTIFY_DEFECTS
	 */
	public java.lang.String getActionRectifyDefects () {
		return actionRectifyDefects;
	}

	/**
	 * Set the value related to the column: ACTION_RECTIFY_DEFECTS
	 * @param actionRectifyDefects the ACTION_RECTIFY_DEFECTS value
	 */
	public void setActionRectifyDefects (java.lang.String actionRectifyDefects) {
		this.actionRectifyDefects = actionRectifyDefects;
	}



	/**
	 * Return the value associated with the column: DETAILS_PROT_SCHOOL_CHILD
	 */
	public java.lang.String getDetailsProtSchoolChild () {
		return detailsProtSchoolChild;
	}

	/**
	 * Set the value related to the column: DETAILS_PROT_SCHOOL_CHILD
	 * @param detailsProtSchoolChild the DETAILS_PROT_SCHOOL_CHILD value
	 */
	public void setDetailsProtSchoolChild (java.lang.String detailsProtSchoolChild) {
		this.detailsProtSchoolChild = detailsProtSchoolChild;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SchoolInspectionEntry)) return false;
		else {
			jkt.hms.masters.business.SchoolInspectionEntry schoolInspectionEntry = (jkt.hms.masters.business.SchoolInspectionEntry) obj;
			if (null == this.getId() || null == schoolInspectionEntry.getId()) return false;
			else return (this.getId().equals(schoolInspectionEntry.getId()));
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