package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DIAGNOSISPRO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DIAGNOSISPRO"
 */

public abstract class BaseDiagnosispro  implements Serializable {

	public static String REF = "Diagnosispro";
	public static String PROP_NAME = "Name";
	public static String PROP_SIGNSSYMPTOMS = "Signssymptoms";
	public static String PROP_DISEASEPROGRESSION = "Diseaseprogression";
	public static String PROP_DIAGNOSTICTESTRESULTS = "Diagnostictestresults";
	public static String PROP_ASSOCIATEDDISEASESRULEOUTS = "Associateddiseasesruleouts";
	public static String PROP_DISEASEMECHANISMCLASSIFICATION = "Diseasemechanismclassification";
	public static String PROP_TREATMENT = "Treatment";


	// constructors
	public BaseDiagnosispro () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiagnosispro (java.lang.String sno) {
		this.setSno(sno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String sno;

	// fields
	private java.lang.String name;
	private java.lang.String signssymptoms;
	private java.lang.String diseaseprogression;
	private java.lang.String diagnostictestresults;
	private java.lang.String associateddiseasesruleouts;
	private java.lang.String diseasemechanismclassification;
	private java.lang.String treatment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="SNO"
     */
	public java.lang.String getSno () {
		return sno;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sno the new ID
	 */
	public void setSno (java.lang.String sno) {
		this.sno = sno;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: SIGNSSYMPTOMS
	 */
	public java.lang.String getSignssymptoms () {
		return signssymptoms;
	}

	/**
	 * Set the value related to the column: SIGNSSYMPTOMS
	 * @param signssymptoms the SIGNSSYMPTOMS value
	 */
	public void setSignssymptoms (java.lang.String signssymptoms) {
		this.signssymptoms = signssymptoms;
	}



	/**
	 * Return the value associated with the column: DISEASEPROGRESSION
	 */
	public java.lang.String getDiseaseprogression () {
		return diseaseprogression;
	}

	/**
	 * Set the value related to the column: DISEASEPROGRESSION
	 * @param diseaseprogression the DISEASEPROGRESSION value
	 */
	public void setDiseaseprogression (java.lang.String diseaseprogression) {
		this.diseaseprogression = diseaseprogression;
	}



	/**
	 * Return the value associated with the column: DIAGNOSTICTESTRESULTS
	 */
	public java.lang.String getDiagnostictestresults () {
		return diagnostictestresults;
	}

	/**
	 * Set the value related to the column: DIAGNOSTICTESTRESULTS
	 * @param diagnostictestresults the DIAGNOSTICTESTRESULTS value
	 */
	public void setDiagnostictestresults (java.lang.String diagnostictestresults) {
		this.diagnostictestresults = diagnostictestresults;
	}



	/**
	 * Return the value associated with the column: ASSOCIATEDDISEASESRULEOUTS
	 */
	public java.lang.String getAssociateddiseasesruleouts () {
		return associateddiseasesruleouts;
	}

	/**
	 * Set the value related to the column: ASSOCIATEDDISEASESRULEOUTS
	 * @param associateddiseasesruleouts the ASSOCIATEDDISEASESRULEOUTS value
	 */
	public void setAssociateddiseasesruleouts (java.lang.String associateddiseasesruleouts) {
		this.associateddiseasesruleouts = associateddiseasesruleouts;
	}



	/**
	 * Return the value associated with the column: DISEASEMECHANISMCLASSIFICATION
	 */
	public java.lang.String getDiseasemechanismclassification () {
		return diseasemechanismclassification;
	}

	/**
	 * Set the value related to the column: DISEASEMECHANISMCLASSIFICATION
	 * @param diseasemechanismclassification the DISEASEMECHANISMCLASSIFICATION value
	 */
	public void setDiseasemechanismclassification (java.lang.String diseasemechanismclassification) {
		this.diseasemechanismclassification = diseasemechanismclassification;
	}



	/**
	 * Return the value associated with the column: TREATMENT
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: TREATMENT
	 * @param treatment the TREATMENT value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Diagnosispro)) return false;
		else {
			jkt.hms.masters.business.Diagnosispro diagnosispro = (jkt.hms.masters.business.Diagnosispro) obj;
			if (null == this.getSno() || null == diagnosispro.getSno()) return false;
			else return (this.getSno().equals(diagnosispro.getSno()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSno()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSno().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}