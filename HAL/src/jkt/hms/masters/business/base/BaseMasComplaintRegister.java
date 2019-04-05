package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_complaint_register table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_complaint_register"
 */

public abstract class BaseMasComplaintRegister  implements Serializable {

	public static String REF = "MasComplaintRegister";
	public static String PROP_STATUS = "Status";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_COMMANDANT_REMARK = "CommandantRemark";
	public static String PROP_DOCKET_NO = "DocketNo";
	public static String PROP_COMPLAINT_ATTANDED_DATE = "ComplaintAttandedDate";
	public static String PROP_COMPLAINT_LOCATION = "ComplaintLocation";
	public static String PROP_SERVICE_PERSON_NAME = "ServicePersonName";
	public static String PROP_COMPLAINT_TIME = "ComplaintTime";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_ALLOCATED_TO = "AllocatedTo";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_PDC = "Pdc";
	public static String PROP_COMPLAINT_NO = "ComplaintNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_COMPLAINT_DATE = "ComplaintDate";
	public static String PROP_MES_REMARK = "MesRemark";
	public static String PROP_CADO_REMARK = "CadoRemark";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_COMPLAINT_CRITERIA = "ComplaintCriteria";
	public static String PROP_COMPLAINT_DETAILS = "ComplaintDetails";
	public static String PROP_ID = "Id";
	public static String PROP_SMQ_NO = "SmqNo";
	public static String PROP_COMPLETION_DATE = "CompletionDate";


	// constructors
	public BaseMasComplaintRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasComplaintRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date complaintDate;
	private java.lang.String complaintTime;
	private java.lang.String complaintCriteria;
	private java.lang.String serviceNo;
	private java.lang.String servicePersonName;
	private java.lang.String complaintDetails;
	private java.lang.String lstChangedBy;
	private java.lang.String lstChangedTime;
	private java.util.Date lstChangedDate;
	private java.lang.String status;
	private java.lang.String complaintNo;
	private java.lang.String complaintLocation;
	private java.lang.String allocatedTo;
	private java.lang.String docketNo;
	private java.lang.String mesRemark;
	private java.lang.String cadoRemark;
	private java.lang.String commandantRemark;
	private java.util.Date complaintAttandedDate;
	private java.util.Date completionDate;
	private java.util.Date pdc;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasSmq smqNo;

	// collections
	private java.util.Set<jkt.hms.masters.business.PdcDetails> pdcDetails;
	private java.util.Set<jkt.hms.masters.business.MasWorkCompletion> masWorkCompletions;
	private java.util.Set<jkt.hms.masters.business.ComplaintRegister> masComplaintRegisters;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="complaint_register_id"
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
	 * Return the value associated with the column: complaint_date
	 */
	public java.util.Date getComplaintDate () {
		return complaintDate;
	}

	/**
	 * Set the value related to the column: complaint_date
	 * @param complaintDate the complaint_date value
	 */
	public void setComplaintDate (java.util.Date complaintDate) {
		this.complaintDate = complaintDate;
	}



	/**
	 * Return the value associated with the column: complaint_time
	 */
	public java.lang.String getComplaintTime () {
		return complaintTime;
	}

	/**
	 * Set the value related to the column: complaint_time
	 * @param complaintTime the complaint_time value
	 */
	public void setComplaintTime (java.lang.String complaintTime) {
		this.complaintTime = complaintTime;
	}



	/**
	 * Return the value associated with the column: complaint_criteria
	 */
	public java.lang.String getComplaintCriteria () {
		return complaintCriteria;
	}

	/**
	 * Set the value related to the column: complaint_criteria
	 * @param complaintCriteria the complaint_criteria value
	 */
	public void setComplaintCriteria (java.lang.String complaintCriteria) {
		this.complaintCriteria = complaintCriteria;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: service_person_name
	 */
	public java.lang.String getServicePersonName () {
		return servicePersonName;
	}

	/**
	 * Set the value related to the column: service_person_name
	 * @param servicePersonName the service_person_name value
	 */
	public void setServicePersonName (java.lang.String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}



	/**
	 * Return the value associated with the column: complaint_details
	 */
	public java.lang.String getComplaintDetails () {
		return complaintDetails;
	}

	/**
	 * Set the value related to the column: complaint_details
	 * @param complaintDetails the complaint_details value
	 */
	public void setComplaintDetails (java.lang.String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}



	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy () {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * @param lstChangedBy the lst_changed_by value
	 */
	public void setLstChangedBy (java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}



	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime () {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * @param lstChangedTime the lst_changed_time value
	 */
	public void setLstChangedTime (java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
	}



	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate () {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * @param lstChangedDate the lst_changed_date value
	 */
	public void setLstChangedDate (java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
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
	 * Return the value associated with the column: complaint_no
	 */
	public java.lang.String getComplaintNo () {
		return complaintNo;
	}

	/**
	 * Set the value related to the column: complaint_no
	 * @param complaintNo the complaint_no value
	 */
	public void setComplaintNo (java.lang.String complaintNo) {
		this.complaintNo = complaintNo;
	}



	/**
	 * Return the value associated with the column: complaint_location
	 */
	public java.lang.String getComplaintLocation () {
		return complaintLocation;
	}

	/**
	 * Set the value related to the column: complaint_location
	 * @param complaintLocation the complaint_location value
	 */
	public void setComplaintLocation (java.lang.String complaintLocation) {
		this.complaintLocation = complaintLocation;
	}



	/**
	 * Return the value associated with the column: allocated_to
	 */
	public java.lang.String getAllocatedTo () {
		return allocatedTo;
	}

	/**
	 * Set the value related to the column: allocated_to
	 * @param allocatedTo the allocated_to value
	 */
	public void setAllocatedTo (java.lang.String allocatedTo) {
		this.allocatedTo = allocatedTo;
	}



	/**
	 * Return the value associated with the column: docket_no
	 */
	public java.lang.String getDocketNo () {
		return docketNo;
	}

	/**
	 * Set the value related to the column: docket_no
	 * @param docketNo the docket_no value
	 */
	public void setDocketNo (java.lang.String docketNo) {
		this.docketNo = docketNo;
	}



	/**
	 * Return the value associated with the column: mes_remark
	 */
	public java.lang.String getMesRemark () {
		return mesRemark;
	}

	/**
	 * Set the value related to the column: mes_remark
	 * @param mesRemark the mes_remark value
	 */
	public void setMesRemark (java.lang.String mesRemark) {
		this.mesRemark = mesRemark;
	}



	/**
	 * Return the value associated with the column: cado_remark
	 */
	public java.lang.String getCadoRemark () {
		return cadoRemark;
	}

	/**
	 * Set the value related to the column: cado_remark
	 * @param cadoRemark the cado_remark value
	 */
	public void setCadoRemark (java.lang.String cadoRemark) {
		this.cadoRemark = cadoRemark;
	}



	/**
	 * Return the value associated with the column: commandant_remark
	 */
	public java.lang.String getCommandantRemark () {
		return commandantRemark;
	}

	/**
	 * Set the value related to the column: commandant_remark
	 * @param commandantRemark the commandant_remark value
	 */
	public void setCommandantRemark (java.lang.String commandantRemark) {
		this.commandantRemark = commandantRemark;
	}



	/**
	 * Return the value associated with the column: complaint_attanded_date
	 */
	public java.util.Date getComplaintAttandedDate () {
		return complaintAttandedDate;
	}

	/**
	 * Set the value related to the column: complaint_attanded_date
	 * @param complaintAttandedDate the complaint_attanded_date value
	 */
	public void setComplaintAttandedDate (java.util.Date complaintAttandedDate) {
		this.complaintAttandedDate = complaintAttandedDate;
	}



	/**
	 * Return the value associated with the column: completion_date
	 */
	public java.util.Date getCompletionDate () {
		return completionDate;
	}

	/**
	 * Set the value related to the column: completion_date
	 * @param completionDate the completion_date value
	 */
	public void setCompletionDate (java.util.Date completionDate) {
		this.completionDate = completionDate;
	}



	/**
	 * Return the value associated with the column: pdc
	 */
	public java.util.Date getPdc () {
		return pdc;
	}

	/**
	 * Set the value related to the column: pdc
	 * @param pdc the pdc value
	 */
	public void setPdc (java.util.Date pdc) {
		this.pdc = pdc;
	}



	/**
	 * Return the value associated with the column: department
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department
	 * @param department the department value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: smq_no
	 */
	public jkt.hms.masters.business.MasSmq getSmqNo () {
		return smqNo;
	}

	/**
	 * Set the value related to the column: smq_no
	 * @param smqNo the smq_no value
	 */
	public void setSmqNo (jkt.hms.masters.business.MasSmq smqNo) {
		this.smqNo = smqNo;
	}



	/**
	 * Return the value associated with the column: PdcDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PdcDetails> getPdcDetails () {
		return pdcDetails;
	}

	/**
	 * Set the value related to the column: PdcDetails
	 * @param pdcDetails the PdcDetails value
	 */
	public void setPdcDetails (java.util.Set<jkt.hms.masters.business.PdcDetails> pdcDetails) {
		this.pdcDetails = pdcDetails;
	}

	public void addToPdcDetails (jkt.hms.masters.business.PdcDetails pdcDetails) {
		if (null == getPdcDetails()) setPdcDetails(new java.util.TreeSet<jkt.hms.masters.business.PdcDetails>());
		getPdcDetails().add(pdcDetails);
	}



	/**
	 * Return the value associated with the column: MasWorkCompletions
	 */
	public java.util.Set<jkt.hms.masters.business.MasWorkCompletion> getMasWorkCompletions () {
		return masWorkCompletions;
	}

	/**
	 * Set the value related to the column: MasWorkCompletions
	 * @param masWorkCompletions the MasWorkCompletions value
	 */
	public void setMasWorkCompletions (java.util.Set<jkt.hms.masters.business.MasWorkCompletion> masWorkCompletions) {
		this.masWorkCompletions = masWorkCompletions;
	}

	public void addToMasWorkCompletions (jkt.hms.masters.business.MasWorkCompletion masWorkCompletion) {
		if (null == getMasWorkCompletions()) setMasWorkCompletions(new java.util.TreeSet<jkt.hms.masters.business.MasWorkCompletion>());
		getMasWorkCompletions().add(masWorkCompletion);
	}



	/**
	 * Return the value associated with the column: MasComplaintRegisters
	 */
	public java.util.Set<jkt.hms.masters.business.ComplaintRegister> getMasComplaintRegisters () {
		return masComplaintRegisters;
	}

	/**
	 * Set the value related to the column: MasComplaintRegisters
	 * @param masComplaintRegisters the MasComplaintRegisters value
	 */
	public void setMasComplaintRegisters (java.util.Set<jkt.hms.masters.business.ComplaintRegister> masComplaintRegisters) {
		this.masComplaintRegisters = masComplaintRegisters;
	}

	public void addToMasComplaintRegisters (jkt.hms.masters.business.ComplaintRegister complaintRegister) {
		if (null == getMasComplaintRegisters()) setMasComplaintRegisters(new java.util.TreeSet<jkt.hms.masters.business.ComplaintRegister>());
		getMasComplaintRegisters().add(complaintRegister);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasComplaintRegister)) return false;
		else {
			jkt.hms.masters.business.MasComplaintRegister masComplaintRegister = (jkt.hms.masters.business.MasComplaintRegister) obj;
			if (null == this.getId() || null == masComplaintRegister.getId()) return false;
			else return (this.getId().equals(masComplaintRegister.getId()));
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