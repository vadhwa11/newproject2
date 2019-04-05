package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_defective_drug_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_defective_drug_m"
 */

public abstract class BaseStoreDefectiveDrugM  implements Serializable {

	public static String REF = "StoreDefectiveDrugM";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DOC_DATE = "DocDate";
	public static String PROP_TO_PLACE = "ToPlace";
	public static String PROP_DESC1 = "Desc1";
	public static String PROP_DESC2 = "Desc2";
	public static String PROP_DESC3 = "Desc3";
	public static String PROP_COPY_TO = "CopyTo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_REASON = "Reason";
	public static String PROP_SIGNAL_NO = "SignalNo";
	public static String PROP_DISPOSAL_INSTRUCTIONS = "DisposalInstructions";
	public static String PROP_REMARKS = "Remarks";


	// constructors
	public BaseStoreDefectiveDrugM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDefectiveDrugM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreDefectiveDrugM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasEmployee authorisedBy,
		jkt.hms.masters.business.MasEmployee enteredBy,
		java.util.Date entryDate,
		java.util.Date docDate,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime,
		java.lang.String entryNo,
		java.lang.String reason,
		java.lang.String signalNo,
		java.lang.String disposalInstructions,
		java.lang.String remarks) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setAuthorisedBy(authorisedBy);
		this.setEnteredBy(enteredBy);
		this.setEntryDate(entryDate);
		this.setDocDate(docDate);
		this.setStatus(status);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		this.setEntryNo(entryNo);
		this.setReason(reason);
		this.setSignalNo(signalNo);
		this.setDisposalInstructions(disposalInstructions);
		this.setRemarks(remarks);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date entryDate;
	private java.util.Date docDate;
	private java.lang.String toPlace;
	private java.lang.String desc1;
	private java.lang.String desc2;
	private java.lang.String desc3;
	private java.lang.String copyTo;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String entryNo;
	private java.lang.String reason;
	private java.lang.String signalNo;
	private java.lang.String disposalInstructions;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee authorisedBy;
	private jkt.hms.masters.business.MasEmployee enteredBy;

	// collections
	private java.util.Set storeDefectiveDrugTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="DEFECT_M_ID"
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
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: doc_date
	 */
	public java.util.Date getDocDate () {
		return docDate;
	}

	/**
	 * Set the value related to the column: doc_date
	 * @param docDate the doc_date value
	 */
	public void setDocDate (java.util.Date docDate) {
		this.docDate = docDate;
	}



	/**
	 * Return the value associated with the column: to_place
	 */
	public java.lang.String getToPlace () {
		return toPlace;
	}

	/**
	 * Set the value related to the column: to_place
	 * @param toPlace the to_place value
	 */
	public void setToPlace (java.lang.String toPlace) {
		this.toPlace = toPlace;
	}



	/**
	 * Return the value associated with the column: desc1
	 */
	public java.lang.String getDesc1 () {
		return desc1;
	}

	/**
	 * Set the value related to the column: desc1
	 * @param desc1 the desc1 value
	 */
	public void setDesc1 (java.lang.String desc1) {
		this.desc1 = desc1;
	}



	/**
	 * Return the value associated with the column: desc2
	 */
	public java.lang.String getDesc2 () {
		return desc2;
	}

	/**
	 * Set the value related to the column: desc2
	 * @param desc2 the desc2 value
	 */
	public void setDesc2 (java.lang.String desc2) {
		this.desc2 = desc2;
	}



	/**
	 * Return the value associated with the column: desc3
	 */
	public java.lang.String getDesc3 () {
		return desc3;
	}

	/**
	 * Set the value related to the column: desc3
	 * @param desc3 the desc3 value
	 */
	public void setDesc3 (java.lang.String desc3) {
		this.desc3 = desc3;
	}



	/**
	 * Return the value associated with the column: copy_to
	 */
	public java.lang.String getCopyTo () {
		return copyTo;
	}

	/**
	 * Set the value related to the column: copy_to
	 * @param copyTo the copy_to value
	 */
	public void setCopyTo (java.lang.String copyTo) {
		this.copyTo = copyTo;
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: SIGNAL_NO
	 */
	public java.lang.String getSignalNo () {
		return signalNo;
	}

	/**
	 * Set the value related to the column: SIGNAL_NO
	 * @param signalNo the SIGNAL_NO value
	 */
	public void setSignalNo (java.lang.String signalNo) {
		this.signalNo = signalNo;
	}



	/**
	 * Return the value associated with the column: DISPOSAL_INSTRUCTIONS
	 */
	public java.lang.String getDisposalInstructions () {
		return disposalInstructions;
	}

	/**
	 * Set the value related to the column: DISPOSAL_INSTRUCTIONS
	 * @param disposalInstructions the DISPOSAL_INSTRUCTIONS value
	 */
	public void setDisposalInstructions (java.lang.String disposalInstructions) {
		this.disposalInstructions = disposalInstructions;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: authorised_id
	 */
	public jkt.hms.masters.business.MasEmployee getAuthorisedBy () {
		return authorisedBy;
	}

	/**
	 * Set the value related to the column: authorised_id
	 * @param authorisedBy the authorised_id value
	 */
	public void setAuthorisedBy (jkt.hms.masters.business.MasEmployee authorisedBy) {
		this.authorisedBy = authorisedBy;
	}



	/**
	 * Return the value associated with the column: enterd_id
	 */
	public jkt.hms.masters.business.MasEmployee getEnteredBy () {
		return enteredBy;
	}

	/**
	 * Set the value related to the column: enterd_id
	 * @param enteredBy the enterd_id value
	 */
	public void setEnteredBy (jkt.hms.masters.business.MasEmployee enteredBy) {
		this.enteredBy = enteredBy;
	}



	/**
	 * Return the value associated with the column: StoreDefectiveDrugTs
	 */
	public java.util.Set getStoreDefectiveDrugTs () {
		return storeDefectiveDrugTs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugTs
	 * @param storeDefectiveDrugTs the StoreDefectiveDrugTs value
	 */
	public void setStoreDefectiveDrugTs (java.util.Set storeDefectiveDrugTs) {
		this.storeDefectiveDrugTs = storeDefectiveDrugTs;
	}

	public void addToStoreDefectiveDrugTs (jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT) {
		if (null == getStoreDefectiveDrugTs()) setStoreDefectiveDrugTs(new java.util.HashSet());
		getStoreDefectiveDrugTs().add(storeDefectiveDrugT);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreDefectiveDrugM)) return false;
		else {
			jkt.hms.masters.business.StoreDefectiveDrugM storeDefectiveDrugM = (jkt.hms.masters.business.StoreDefectiveDrugM) obj;
			if (null == this.getId() || null == storeDefectiveDrugM.getId()) return false;
			else return (this.getId().equals(storeDefectiveDrugM.getId()));
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