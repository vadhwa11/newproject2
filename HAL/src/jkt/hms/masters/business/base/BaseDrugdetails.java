package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DRUGDETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DRUGDETAILS"
 */


public abstract class BaseDrugdetails  implements Serializable {

	public static String REF = "Drugdetails";
	public static String PROP_GENERICNAME = "Genericname";
	public static String PROP_DRUG_CLASS = "DrugClass";
	public static String PROP_INDICATIONDOSAGE = "Indicationdosage";
	public static String PROP_ADMINISTRATION = "Administration";
	public static String PROP_OVERDOSAGE = "Overdosage";
	public static String PROP_CONTRAINDICATIONS = "Contraindications";
	public static String PROP_SPECIALPRECAUTIONS = "Specialprecautions";
	public static String PROP_ADVERSEDRUGREACTIONS = "Adversedrugreactions";
	public static String PROP_DRUGINTERACTIONS = "Druginteractions";
	public static String PROP_PREGNANCYCATEGORY = "Pregnancycategory";
	public static String PROP_STORAGE = "Storage";
	public static String PROP_MECHANISMACTION = "Mechanismaction";
	public static String PROP_ATCCLASSIFICATION = "Atcclassification";
	public static String PROP_ATCCLASSIFICATIONDETAILS = "Atcclassificationdetails";


	// constructors
	public BaseDrugdetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDrugdetails (java.lang.String sno) {
		this.setSno(sno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String sno;

	// fields
	private java.lang.String genericname;
	private java.lang.String drugClass;
	private java.lang.String indicationdosage;
	private java.lang.String administration;
	private java.lang.String overdosage;
	private java.lang.String contraindications;
	private java.lang.String specialprecautions;
	private java.lang.String adversedrugreactions;
	private java.lang.String druginteractions;
	private java.lang.String pregnancycategory;
	private java.lang.String storage;
	private java.lang.String mechanismaction;
	private java.lang.String atcclassification;
	private java.lang.String atcclassificationdetails;



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
	 * Return the value associated with the column: GENERICNAME
	 */
	public java.lang.String getGenericname () {
		return genericname;
	}

	/**
	 * Set the value related to the column: GENERICNAME
	 * @param genericname the GENERICNAME value
	 */
	public void setGenericname (java.lang.String genericname) {
		this.genericname = genericname;
	}



	/**
	 * Return the value associated with the column: CLASS
	 */
	public java.lang.String getDrugClass () {
		return drugClass;
	}

	/**
	 * Set the value related to the column: CLASS
	 * @param drugClass the CLASS value
	 */
	public void setDrugClass (java.lang.String drugClass) {
		this.drugClass = drugClass;
	}



	/**
	 * Return the value associated with the column: INDICATIONDOSAGE
	 */
	public java.lang.String getIndicationdosage () {
		return indicationdosage;
	}

	/**
	 * Set the value related to the column: INDICATIONDOSAGE
	 * @param indicationdosage the INDICATIONDOSAGE value
	 */
	public void setIndicationdosage (java.lang.String indicationdosage) {
		this.indicationdosage = indicationdosage;
	}



	/**
	 * Return the value associated with the column: ADMINISTRATION
	 */
	public java.lang.String getAdministration () {
		return administration;
	}

	/**
	 * Set the value related to the column: ADMINISTRATION
	 * @param administration the ADMINISTRATION value
	 */
	public void setAdministration (java.lang.String administration) {
		this.administration = administration;
	}



	/**
	 * Return the value associated with the column: OVERDOSAGE
	 */
	public java.lang.String getOverdosage () {
		return overdosage;
	}

	/**
	 * Set the value related to the column: OVERDOSAGE
	 * @param overdosage the OVERDOSAGE value
	 */
	public void setOverdosage (java.lang.String overdosage) {
		this.overdosage = overdosage;
	}



	/**
	 * Return the value associated with the column: CONTRAINDICATIONS
	 */
	public java.lang.String getContraindications () {
		return contraindications;
	}

	/**
	 * Set the value related to the column: CONTRAINDICATIONS
	 * @param contraindications the CONTRAINDICATIONS value
	 */
	public void setContraindications (java.lang.String contraindications) {
		this.contraindications = contraindications;
	}



	/**
	 * Return the value associated with the column: SPECIALPRECAUTIONS
	 */
	public java.lang.String getSpecialprecautions () {
		return specialprecautions;
	}

	/**
	 * Set the value related to the column: SPECIALPRECAUTIONS
	 * @param specialprecautions the SPECIALPRECAUTIONS value
	 */
	public void setSpecialprecautions (java.lang.String specialprecautions) {
		this.specialprecautions = specialprecautions;
	}



	/**
	 * Return the value associated with the column: ADVERSEDRUGREACTIONS
	 */
	public java.lang.String getAdversedrugreactions () {
		return adversedrugreactions;
	}

	/**
	 * Set the value related to the column: ADVERSEDRUGREACTIONS
	 * @param adversedrugreactions the ADVERSEDRUGREACTIONS value
	 */
	public void setAdversedrugreactions (java.lang.String adversedrugreactions) {
		this.adversedrugreactions = adversedrugreactions;
	}



	/**
	 * Return the value associated with the column: DRUGINTERACTIONS
	 */
	public java.lang.String getDruginteractions () {
		return druginteractions;
	}

	/**
	 * Set the value related to the column: DRUGINTERACTIONS
	 * @param druginteractions the DRUGINTERACTIONS value
	 */
	public void setDruginteractions (java.lang.String druginteractions) {
		this.druginteractions = druginteractions;
	}



	/**
	 * Return the value associated with the column: PREGNANCYCATEGORY
	 */
	public java.lang.String getPregnancycategory () {
		return pregnancycategory;
	}

	/**
	 * Set the value related to the column: PREGNANCYCATEGORY
	 * @param pregnancycategory the PREGNANCYCATEGORY value
	 */
	public void setPregnancycategory (java.lang.String pregnancycategory) {
		this.pregnancycategory = pregnancycategory;
	}



	/**
	 * Return the value associated with the column: STORAGE
	 */
	public java.lang.String getStorage () {
		return storage;
	}

	/**
	 * Set the value related to the column: STORAGE
	 * @param storage the STORAGE value
	 */
	public void setStorage (java.lang.String storage) {
		this.storage = storage;
	}



	/**
	 * Return the value associated with the column: MECHANISMACTION
	 */
	public java.lang.String getMechanismaction () {
		return mechanismaction;
	}

	/**
	 * Set the value related to the column: MECHANISMACTION
	 * @param mechanismaction the MECHANISMACTION value
	 */
	public void setMechanismaction (java.lang.String mechanismaction) {
		this.mechanismaction = mechanismaction;
	}



	/**
	 * Return the value associated with the column: ATCCLASSIFICATION
	 */
	public java.lang.String getAtcclassification () {
		return atcclassification;
	}

	/**
	 * Set the value related to the column: ATCCLASSIFICATION
	 * @param atcclassification the ATCCLASSIFICATION value
	 */
	public void setAtcclassification (java.lang.String atcclassification) {
		this.atcclassification = atcclassification;
	}



	/**
	 * Return the value associated with the column: ATCCLASSIFICATIONDETAILS
	 */
	public java.lang.String getAtcclassificationdetails () {
		return atcclassificationdetails;
	}

	/**
	 * Set the value related to the column: ATCCLASSIFICATIONDETAILS
	 * @param atcclassificationdetails the ATCCLASSIFICATIONDETAILS value
	 */
	public void setAtcclassificationdetails (java.lang.String atcclassificationdetails) {
		this.atcclassificationdetails = atcclassificationdetails;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Drugdetails)) return false;
		else {
			jkt.hms.masters.business.Drugdetails drugdetails = (jkt.hms.masters.business.Drugdetails) obj;
			if (null == this.getSno() || null == drugdetails.getSno()) return false;
			else return (this.getSno().equals(drugdetails.getSno()));
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