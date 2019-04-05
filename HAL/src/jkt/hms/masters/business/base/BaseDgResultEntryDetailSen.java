package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * dg_result_entry_detail_sen table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="dg_result_entry_detail_sen"
 */

public abstract class BaseDgResultEntryDetailSen implements Serializable {

	public static String REF = "DgResultEntryDetailSen";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_SENSITIVITY = "Sensitivity";
	public static String PROP_GROWTH_OPTION = "GrowthOption";
	public static String PROP_RESULT = "Result";
	public static String PROP_SAMPLE_COLLECTION = "SampleCollection";
	public static String PROP_NOSOCOMIAL = "Nosocomial";
	public static String PROP_ORGANISM_GROUP = "OrganismGroup";
	public static String PROP_RESULT_OTHER = "ResultOther";
	public static String PROP_RESULT_ENTRY = "ResultEntry";
	public static String PROP_ID = "Id";
	public static String PROP_ORGANISM = "Organism";

	// constructors
	public BaseDgResultEntryDetailSen() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgResultEntryDetailSen(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String result;
	private java.lang.String resultOther;
	private java.lang.String nosocomial;
	private java.lang.String growthOption;

	// many to one
	private jkt.hms.masters.business.DgMasOrganismGroup organismGroup;
	private jkt.hms.masters.business.DgResultEntryHeader resultEntry;
	private jkt.hms.masters.business.DgMasOrganism organism;
	private jkt.hms.masters.business.MasAntibioticLab sensitivity;
	private jkt.hms.masters.business.DgSampleCollectionDetails sampleCollection;
	private jkt.hms.masters.business.DgMasInvestigation investigation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult() {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * 
	 * @param result
	 *            the result value
	 */
	public void setResult(java.lang.String result) {
		this.result = result;
	}

	/**
	 * Return the value associated with the column: result_other
	 */
	public java.lang.String getResultOther() {
		return resultOther;
	}

	/**
	 * Set the value related to the column: result_other
	 * 
	 * @param resultOther
	 *            the result_other value
	 */
	public void setResultOther(java.lang.String resultOther) {
		this.resultOther = resultOther;
	}

	/**
	 * Return the value associated with the column: nosocomial
	 */
	public java.lang.String getNosocomial() {
		return nosocomial;
	}

	/**
	 * Set the value related to the column: nosocomial
	 * 
	 * @param nosocomial
	 *            the nosocomial value
	 */
	public void setNosocomial(java.lang.String nosocomial) {
		this.nosocomial = nosocomial;
	}

	/**
	 * Return the value associated with the column: growth_option
	 */
	public java.lang.String getGrowthOption() {
		return growthOption;
	}

	/**
	 * Set the value related to the column: growth_option
	 * 
	 * @param growthOption
	 *            the growth_option value
	 */
	public void setGrowthOption(java.lang.String growthOption) {
		this.growthOption = growthOption;
	}

	/**
	 * Return the value associated with the column: organism_group_id
	 */
	public jkt.hms.masters.business.DgMasOrganismGroup getOrganismGroup() {
		return organismGroup;
	}

	/**
	 * Set the value related to the column: organism_group_id
	 * 
	 * @param organismGroup
	 *            the organism_group_id value
	 */
	public void setOrganismGroup(
			jkt.hms.masters.business.DgMasOrganismGroup organismGroup) {
		this.organismGroup = organismGroup;
	}

	/**
	 * Return the value associated with the column: result_entry_id
	 */
	public jkt.hms.masters.business.DgResultEntryHeader getResultEntry() {
		return resultEntry;
	}

	/**
	 * Set the value related to the column: result_entry_id
	 * 
	 * @param resultEntry
	 *            the result_entry_id value
	 */
	public void setResultEntry(
			jkt.hms.masters.business.DgResultEntryHeader resultEntry) {
		this.resultEntry = resultEntry;
	}

	/**
	 * Return the value associated with the column: organism_id
	 */
	public jkt.hms.masters.business.DgMasOrganism getOrganism() {
		return organism;
	}

	/**
	 * Set the value related to the column: organism_id
	 * 
	 * @param organism
	 *            the organism_id value
	 */
	public void setOrganism(jkt.hms.masters.business.DgMasOrganism organism) {
		this.organism = organism;
	}

	/**
	 * Return the value associated with the column: sensitivity_id
	 */
	public jkt.hms.masters.business.MasAntibioticLab getSensitivity() {
		return sensitivity;
	}

	/**
	 * Set the value related to the column: sensitivity_id
	 * 
	 * @param sensitivity
	 *            the sensitivity_id value
	 */
	public void setSensitivity(
			jkt.hms.masters.business.MasAntibioticLab sensitivity) {
		this.sensitivity = sensitivity;
	}

	/**
	 * Return the value associated with the column: sample_collection_id
	 */
	public jkt.hms.masters.business.DgSampleCollectionDetails getSampleCollection() {
		return sampleCollection;
	}

	/**
	 * Set the value related to the column: sample_collection_id
	 * 
	 * @param sampleCollection
	 *            the sample_collection_id value
	 */
	public void setSampleCollection(
			jkt.hms.masters.business.DgSampleCollectionDetails sampleCollection) {
		this.sampleCollection = sampleCollection;
	}

	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation() {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * 
	 * @param investigation
	 *            the investigation_id value
	 */
	public void setInvestigation(
			jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DgResultEntryDetailSen))
			return false;
		else {
			jkt.hms.masters.business.DgResultEntryDetailSen dgResultEntryDetailSen = (jkt.hms.masters.business.DgResultEntryDetailSen) obj;
			if (null == this.getId() || null == dgResultEntryDetailSen.getId())
				return false;
			else
				return (this.getId().equals(dgResultEntryDetailSen.getId()));
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