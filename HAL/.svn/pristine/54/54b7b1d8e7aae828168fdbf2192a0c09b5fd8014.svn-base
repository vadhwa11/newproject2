package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the cims table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="cims"
 */

public abstract class BaseCims  implements Serializable {

	public static String REF = "Cims";
	public static String PROP_PREGNANCYCATEGORY = "Pregnancycategory";
	public static String PROP_ITEM_ID = "ItemId";
	public static String PROP_INDICATIONDOSAGE = "Indicationdosage";
	public static String PROP_ATCCLASSIFICATIONDETAILS = "Atcclassificationdetails";
	public static String PROP_ADVERSEDRUGREACTIONS = "Adversedrugreactions";
	public static String PROP_DRUGINTERACTIONS = "Druginteractions";
	public static String PROP_STORAGE = "Storage";
	public static String PROP_SPECIALPRECAUTIONS = "Specialprecautions";
	public static String PROP_GENERICNAME = "Genericname";
	public static String PROP_CLASS = "Class";
	public static String PROP_MECHANISMACTION = "Mechanismaction";
	public static String PROP_ID = "Id";
	public static String PROP_ATCCLASSIFICATION = "Atcclassification";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_CONTRAINDICATIONS = "Contraindications";


	// constructors
	public BaseCims () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCims (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String genericname;
	private java.lang.String m_class;
	private java.lang.String indicationdosage;
	private java.lang.String contraindications;
	private java.lang.String specialprecautions;
	private java.lang.String adversedrugreactions;
	private java.lang.String druginteractions;
	private java.lang.String pregnancycategory;
	private java.lang.String storage;
	private java.lang.String mechanismaction;
	private java.lang.String atcclassification;
	private java.lang.String atcclassificationdetails;
	private java.lang.Integer srNo;

	// many to one
	private jkt.hms.masters.business.MasStoreItem itemId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: class
	 */
	public java.lang.String getClass () {
		return m_class;
	}

	/**
	 * Set the value related to the column: class
	 * @param m_class the class value
	 */
	public void setClass (java.lang.String m_class) {
		this.m_class = m_class;
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



	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItemId () {
		return itemId;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param itemId the item_id value
	 */
	public void setItemId (jkt.hms.masters.business.MasStoreItem itemId) {
		this.itemId = itemId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Cims)) return false;
		else {
			jkt.hms.masters.business.Cims cims = (jkt.hms.masters.business.Cims) obj;
			if (null == this.getId() || null == cims.getId()) return false;
			else return (this.getId().equals(cims.getId()));
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