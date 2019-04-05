package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_result_entry_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_result_entry_detail"
 */

public abstract class BaseDgResultEntryDetail  implements Serializable {

	public static String REF = "DgResultEntryDetail";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_RESULT = "Result";
	public static String PROP_FILM_SIZE = "FilmSize";
	public static String PROP_VALIDATED = "Validated";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_NPRMAL = "Nprmal";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_HL7_FLAG = "Hl7Flag";
	public static String PROP_FILM_USED = "FilmUsed";
	public static String PROP_UOM = "Uom";
	public static String PROP_RESULT_DETAIL_STATUS = "ResultDetailStatus";
	public static String PROP_SUB_INVESTIGATION = "SubInvestigation";
	public static String PROP_NORMAL = "Normal";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_RESULT_ENTRY = "ResultEntry";
	public static String PROP_SAMPLE_COLLECTION_DETAILS = "SampleCollectionDetails";
	public static String PROP_ID = "Id";
	public static String PROP_FIXED = "Fixed";
	public static String PROP_RESULT_TYPE = "ResultType";


	// constructors
	public BaseDgResultEntryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgResultEntryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String resultType;
	private java.lang.String result;
	private java.lang.String remarks;
	private java.lang.String filmSize;
	private java.lang.Integer filmUsed;
	private java.lang.String validated;
	private java.lang.String resultDetailStatus;
	private java.lang.String hl7Flag;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.DgSubMasInvestigation subInvestigation;
	private jkt.hms.masters.business.DgResultEntryHeader resultEntry;
	private jkt.hms.masters.business.DgUom uom;
	private jkt.hms.masters.business.DgSampleCollectionDetails sampleCollectionDetails;
	private jkt.hms.masters.business.DgTemplate template;
	private jkt.hms.masters.business.DgNormalValue nprmal;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.DgFixedValue fixed;
	private jkt.hms.masters.business.DgNormalValue normal;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgFilmDetail> dgFilmDetail;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="result_entry_detail_id"
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
	 * Return the value associated with the column: result_type
	 */
	public java.lang.String getResultType () {
		return resultType;
	}

	/**
	 * Set the value related to the column: result_type
	 * @param resultType the result_type value
	 */
	public void setResultType (java.lang.String resultType) {
		this.resultType = resultType;
	}



	/**
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * @param result the result value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: film_size
	 */
	public java.lang.String getFilmSize () {
		return filmSize;
	}

	/**
	 * Set the value related to the column: film_size
	 * @param filmSize the film_size value
	 */
	public void setFilmSize (java.lang.String filmSize) {
		this.filmSize = filmSize;
	}



	/**
	 * Return the value associated with the column: film_used
	 */
	public java.lang.Integer getFilmUsed () {
		return filmUsed;
	}

	/**
	 * Set the value related to the column: film_used
	 * @param filmUsed the film_used value
	 */
	public void setFilmUsed (java.lang.Integer filmUsed) {
		this.filmUsed = filmUsed;
	}



	/**
	 * Return the value associated with the column: validated
	 */
	public java.lang.String getValidated () {
		return validated;
	}

	/**
	 * Set the value related to the column: validated
	 * @param validated the validated value
	 */
	public void setValidated (java.lang.String validated) {
		this.validated = validated;
	}



	/**
	 * Return the value associated with the column: result_detail_status
	 */
	public java.lang.String getResultDetailStatus () {
		return resultDetailStatus;
	}

	/**
	 * Set the value related to the column: result_detail_status
	 * @param resultDetailStatus the result_detail_status value
	 */
	public void setResultDetailStatus (java.lang.String resultDetailStatus) {
		this.resultDetailStatus = resultDetailStatus;
	}



	/**
	 * Return the value associated with the column: HL7_flag
	 */
	public java.lang.String getHl7Flag () {
		return hl7Flag;
	}

	/**
	 * Set the value related to the column: HL7_flag
	 * @param hl7Flag the HL7_flag value
	 */
	public void setHl7Flag (java.lang.String hl7Flag) {
		this.hl7Flag = hl7Flag;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: sub_investigation_id
	 */
	public jkt.hms.masters.business.DgSubMasInvestigation getSubInvestigation () {
		return subInvestigation;
	}

	/**
	 * Set the value related to the column: sub_investigation_id
	 * @param subInvestigation the sub_investigation_id value
	 */
	public void setSubInvestigation (jkt.hms.masters.business.DgSubMasInvestigation subInvestigation) {
		this.subInvestigation = subInvestigation;
	}



	/**
	 * Return the value associated with the column: result_entry_id
	 */
	public jkt.hms.masters.business.DgResultEntryHeader getResultEntry () {
		return resultEntry;
	}

	/**
	 * Set the value related to the column: result_entry_id
	 * @param resultEntry the result_entry_id value
	 */
	public void setResultEntry (jkt.hms.masters.business.DgResultEntryHeader resultEntry) {
		this.resultEntry = resultEntry;
	}



	/**
	 * Return the value associated with the column: uom_id
	 */
	public jkt.hms.masters.business.DgUom getUom () {
		return uom;
	}

	/**
	 * Set the value related to the column: uom_id
	 * @param uom the uom_id value
	 */
	public void setUom (jkt.hms.masters.business.DgUom uom) {
		this.uom = uom;
	}



	/**
	 * Return the value associated with the column: sample_collection_details_id
	 */
	public jkt.hms.masters.business.DgSampleCollectionDetails getSampleCollectionDetails () {
		return sampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: sample_collection_details_id
	 * @param sampleCollectionDetails the sample_collection_details_id value
	 */
	public void setSampleCollectionDetails (jkt.hms.masters.business.DgSampleCollectionDetails sampleCollectionDetails) {
		this.sampleCollectionDetails = sampleCollectionDetails;
	}



	/**
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.DgTemplate getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.DgTemplate template) {
		this.template = template;
	}



	/**
	 * Return the value associated with the column: nprmal_id
	 */
	public jkt.hms.masters.business.DgNormalValue getNprmal () {
		return nprmal;
	}

	/**
	 * Set the value related to the column: nprmal_id
	 * @param nprmal the nprmal_id value
	 */
	public void setNprmal (jkt.hms.masters.business.DgNormalValue nprmal) {
		this.nprmal = nprmal;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample () {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * @param sample the sample_id value
	 */
	public void setSample (jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
	}



	/**
	 * Return the value associated with the column: fixed_id
	 */
	public jkt.hms.masters.business.DgFixedValue getFixed () {
		return fixed;
	}

	/**
	 * Set the value related to the column: fixed_id
	 * @param fixed the fixed_id value
	 */
	public void setFixed (jkt.hms.masters.business.DgFixedValue fixed) {
		this.fixed = fixed;
	}



	/**
	 * Return the value associated with the column: normal_id
	 */
	public jkt.hms.masters.business.DgNormalValue getNormal () {
		return normal;
	}

	/**
	 * Set the value related to the column: normal_id
	 * @param normal the normal_id value
	 */
	public void setNormal (jkt.hms.masters.business.DgNormalValue normal) {
		this.normal = normal;
	}



	/**
	 * Return the value associated with the column: DgFilmDetail
	 */
	public java.util.Set<jkt.hms.masters.business.DgFilmDetail> getDgFilmDetail () {
		return dgFilmDetail;
	}

	/**
	 * Set the value related to the column: DgFilmDetail
	 * @param dgFilmDetail the DgFilmDetail value
	 */
	public void setDgFilmDetail (java.util.Set<jkt.hms.masters.business.DgFilmDetail> dgFilmDetail) {
		this.dgFilmDetail = dgFilmDetail;
	}

	public void addToDgFilmDetail (jkt.hms.masters.business.DgFilmDetail dgFilmDetail) {
		if (null == getDgFilmDetail()) setDgFilmDetail(new java.util.TreeSet<jkt.hms.masters.business.DgFilmDetail>());
		getDgFilmDetail().add(dgFilmDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgResultEntryDetail)) return false;
		else {
			jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail = (jkt.hms.masters.business.DgResultEntryDetail) obj;
			if (null == this.getId() || null == dgResultEntryDetail.getId()) return false;
			else return (this.getId().equals(dgResultEntryDetail.getId()));
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