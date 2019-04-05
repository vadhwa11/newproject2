package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_CONSERVANCY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_CONSERVANCY"
 */

public abstract class BaseShoConservancy  implements Serializable {

	public static String REF = "ShoConservancy";
	public static String PROP_ACTION = "Action";
	public static String PROP_DATE_OF_CONSERVANCY = "DateOfConservancy";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_METHOD_OF_DISPOSAL = "MethodOfDisposal";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_DISPOSAL_OF_GARBAGE = "DisposalOfGarbage";
	public static String PROP_FUNCTIONING_ADEQUATELY = "FunctioningAdequately";
	public static String PROP_REASON = "Reason";


	// constructors
	public BaseShoConservancy () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoConservancy (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfConservancy;
	private java.util.Date lastUpdatedDate;
	private java.lang.String disposal;
	private java.lang.String methodOfDisposal;
	private java.lang.String functioningAdequately;
	private java.lang.String reason;
	private java.lang.String action;
	private java.lang.String disposalOfGarbage;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="CONSERVANCY_ID"
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
	 * Return the value associated with the column: DATE_OF_CONSERVANCY
	 */
	public java.util.Date getDateOfConservancy () {
		return dateOfConservancy;
	}

	/**
	 * Set the value related to the column: DATE_OF_CONSERVANCY
	 * @param dateOfConservancy the DATE_OF_CONSERVANCY value
	 */
	public void setDateOfConservancy (java.util.Date dateOfConservancy) {
		this.dateOfConservancy = dateOfConservancy;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATED_DATE
	 */
	public java.util.Date getLastUpdatedDate () {
		return lastUpdatedDate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATED_DATE
	 * @param lastUpdatedDate the LAST_UPDATED_DATE value
	 */
	public void setLastUpdatedDate (java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	/**
	 * Return the value associated with the column: DISPOSAL
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: DISPOSAL
	 * @param disposal the DISPOSAL value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
	}



	/**
	 * Return the value associated with the column: METHOD_OF_DISPOSAL
	 */
	public java.lang.String getMethodOfDisposal () {
		return methodOfDisposal;
	}

	/**
	 * Set the value related to the column: METHOD_OF_DISPOSAL
	 * @param methodOfDisposal the METHOD_OF_DISPOSAL value
	 */
	public void setMethodOfDisposal (java.lang.String methodOfDisposal) {
		this.methodOfDisposal = methodOfDisposal;
	}



	/**
	 * Return the value associated with the column: FUNCTIONING_ADEQUATELY
	 */
	public java.lang.String getFunctioningAdequately () {
		return functioningAdequately;
	}

	/**
	 * Set the value related to the column: FUNCTIONING_ADEQUATELY
	 * @param functioningAdequately the FUNCTIONING_ADEQUATELY value
	 */
	public void setFunctioningAdequately (java.lang.String functioningAdequately) {
		this.functioningAdequately = functioningAdequately;
	}



	/**
	 * Return the value associated with the column: REASON
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: REASON
	 * @param reason the REASON value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: ACTION
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: ACTION
	 * @param action the ACTION value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
	}



	/**
	 * Return the value associated with the column: DISPOSAL_OF_GARBAGE
	 */
	public java.lang.String getDisposalOfGarbage () {
		return disposalOfGarbage;
	}

	/**
	 * Set the value related to the column: DISPOSAL_OF_GARBAGE
	 * @param disposalOfGarbage the DISPOSAL_OF_GARBAGE value
	 */
	public void setDisposalOfGarbage (java.lang.String disposalOfGarbage) {
		this.disposalOfGarbage = disposalOfGarbage;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoConservancy)) return false;
		else {
			jkt.hms.masters.business.ShoConservancy shoConservancy = (jkt.hms.masters.business.ShoConservancy) obj;
			if (null == this.getId() || null == shoConservancy.getId()) return false;
			else return (this.getId().equals(shoConservancy.getId()));
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