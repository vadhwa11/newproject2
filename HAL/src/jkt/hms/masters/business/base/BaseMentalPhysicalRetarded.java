package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MENTAL_PHYSICAL_RETARDED table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MENTAL_PHYSICAL_RETARDED"
 */

public abstract class BaseMentalPhysicalRetarded  implements Serializable {

	public static String REF = "MentalPhysicalRetarded";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_CHILDREN_AGE = "ChildrenAge";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_CHILDREN_NAME = "ChildrenName";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_MENTAL_PHYSICAL_RETARTED = "MentalPhysicalRetarted";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HIN_ID = "HinId";


	// constructors
	public BaseMentalPhysicalRetarded () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMentalPhysicalRetarded (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hospitalName;
	private java.lang.String diagnosis;
	private java.lang.String mentalPhysicalRetarted;
	private java.lang.String childrenName;
	private java.lang.String childrenAge;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.Patient hinId;



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
	 * Return the value associated with the column: HOSPITAL_NAME
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: HOSPITAL_NAME
	 * @param hospitalName the HOSPITAL_NAME value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: MENTAL_PHYSICAL_RETARTED
	 */
	public java.lang.String getMentalPhysicalRetarted () {
		return mentalPhysicalRetarted;
	}

	/**
	 * Set the value related to the column: MENTAL_PHYSICAL_RETARTED
	 * @param mentalPhysicalRetarted the MENTAL_PHYSICAL_RETARTED value
	 */
	public void setMentalPhysicalRetarted (java.lang.String mentalPhysicalRetarted) {
		this.mentalPhysicalRetarted = mentalPhysicalRetarted;
	}



	/**
	 * Return the value associated with the column: CHILDREN_NAME
	 */
	public java.lang.String getChildrenName () {
		return childrenName;
	}

	/**
	 * Set the value related to the column: CHILDREN_NAME
	 * @param childrenName the CHILDREN_NAME value
	 */
	public void setChildrenName (java.lang.String childrenName) {
		this.childrenName = childrenName;
	}



	/**
	 * Return the value associated with the column: CHILDREN_AGE
	 */
	public java.lang.String getChildrenAge () {
		return childrenAge;
	}

	/**
	 * Set the value related to the column: CHILDREN_AGE
	 * @param childrenAge the CHILDREN_AGE value
	 */
	public void setChildrenAge (java.lang.String childrenAge) {
		this.childrenAge = childrenAge;
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



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hinId the HIN_ID value
	 */
	public void setHinId (jkt.hms.masters.business.Patient hinId) {
		this.hinId = hinId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MentalPhysicalRetarded)) return false;
		else {
			jkt.hms.masters.business.MentalPhysicalRetarded mentalPhysicalRetarded = (jkt.hms.masters.business.MentalPhysicalRetarded) obj;
			if (null == this.getId() || null == mentalPhysicalRetarded.getId()) return false;
			else return (this.getId().equals(mentalPhysicalRetarded.getId()));
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