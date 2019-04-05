package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_hospital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_hospital"
 */

public abstract class BaseMasHospital  implements Serializable {

	public static String REF = "MasHospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HOSPITAL_CODE = "HospitalCode";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COMMAND = "Command";
	public static String PROP_CONTACT_NUMBER = "ContactNumber";
	public static String PROP_ID = "Id";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseMasHospital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasHospital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasHospital (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hospitalCode;
	private java.lang.String hospitalName;
	private java.lang.String status;
	private java.lang.String address;
	private java.lang.String contactNumber;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasCommand command;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoos;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals;
	private java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers;
	private java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs;
	private java.util.Set<jkt.hms.masters.business.UsergroupHospital> usergroupHospitals;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs;
	private java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals;
	private java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails;
	private java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMs;
	private java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles;
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMs;
	private java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> storeWorkOrderMs;
	private java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets;
	private java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> storeDefectiveDrugMs;
	private java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts;
	private java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs;
	private java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderM> storeTenderMs;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs;
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="hospital_id"
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
	 * Return the value associated with the column: hospital_code
	 */
	public java.lang.String getHospitalCode () {
		return hospitalCode;
	}

	/**
	 * Set the value related to the column: hospital_code
	 * @param hospitalCode the hospital_code value
	 */
	public void setHospitalCode (java.lang.String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}



	/**
	 * Return the value associated with the column: hospital_name
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: hospital_name
	 * @param hospitalName the hospital_name value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
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
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: contact_number
	 */
	public java.lang.String getContactNumber () {
		return contactNumber;
	}

	/**
	 * Set the value related to the column: contact_number
	 * @param contactNumber the contact_number value
	 */
	public void setContactNumber (java.lang.String contactNumber) {
		this.contactNumber = contactNumber;
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
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: command_id
	 */
	public jkt.hms.masters.business.MasCommand getCommand () {
		return command;
	}

	/**
	 * Set the value related to the column: command_id
	 * @param command the command_id value
	 */
	public void setCommand (jkt.hms.masters.business.MasCommand command) {
		this.command = command;
	}



	/**
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges () {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * @param discharges the Discharges value
	 */
	public void setDischarges (java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges (jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges()) setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}



	/**
	 * Return the value associated with the column: StoreBoos
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoos () {
		return storeBoos;
	}

	/**
	 * Set the value related to the column: StoreBoos
	 * @param storeBoos the StoreBoos value
	 */
	public void setStoreBoos (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoos) {
		this.storeBoos = storeBoos;
	}

	public void addToStoreBoos (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoos()) setStoreBoos(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoos().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputs
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> getIpdIntakeOutputs () {
		return ipdIntakeOutputs;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputs
	 * @param ipdIntakeOutputs the IpdIntakeOutputs value
	 */
	public void setIpdIntakeOutputs (java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs) {
		this.ipdIntakeOutputs = ipdIntakeOutputs;
	}

	public void addToIpdIntakeOutputs (jkt.hms.masters.business.IpdIntakeOutput ipdIntakeOutput) {
		if (null == getIpdIntakeOutputs()) setIpdIntakeOutputs(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutput>());
		getIpdIntakeOutputs().add(ipdIntakeOutput);
	}



	/**
	 * Return the value associated with the column: MlcCases
	 */
	public java.util.Set<jkt.hms.masters.business.MlcCase> getMlcCases () {
		return mlcCases;
	}

	/**
	 * Set the value related to the column: MlcCases
	 * @param mlcCases the MlcCases value
	 */
	public void setMlcCases (java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases) {
		this.mlcCases = mlcCases;
	}

	public void addToMlcCases (jkt.hms.masters.business.MlcCase mlcCase) {
		if (null == getMlcCases()) setMlcCases(new java.util.TreeSet<jkt.hms.masters.business.MlcCase>());
		getMlcCases().add(mlcCase);
	}



	/**
	 * Return the value associated with the column: UserStatusHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserStatusHospital> getUserStatusHospitals () {
		return userStatusHospitals;
	}

	/**
	 * Set the value related to the column: UserStatusHospitals
	 * @param userStatusHospitals the UserStatusHospitals value
	 */
	public void setUserStatusHospitals (java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals) {
		this.userStatusHospitals = userStatusHospitals;
	}

	public void addToUserStatusHospitals (jkt.hms.masters.business.UserStatusHospital userStatusHospital) {
		if (null == getUserStatusHospitals()) setUserStatusHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserStatusHospital>());
		getUserStatusHospitals().add(userStatusHospital);
	}



	/**
	 * Return the value associated with the column: StoreIndentSocTrackers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> getStoreIndentSocTrackers () {
		return storeIndentSocTrackers;
	}

	/**
	 * Set the value related to the column: StoreIndentSocTrackers
	 * @param storeIndentSocTrackers the StoreIndentSocTrackers value
	 */
	public void setStoreIndentSocTrackers (java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers) {
		this.storeIndentSocTrackers = storeIndentSocTrackers;
	}

	public void addToStoreIndentSocTrackers (jkt.hms.masters.business.StoreIndentSocTracker storeIndentSocTracker) {
		if (null == getStoreIndentSocTrackers()) setStoreIndentSocTrackers(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentSocTracker>());
		getStoreIndentSocTrackers().add(storeIndentSocTracker);
	}



	/**
	 * Return the value associated with the column: DischargeSummaries
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeSummary> getDischargeSummaries () {
		return dischargeSummaries;
	}

	/**
	 * Set the value related to the column: DischargeSummaries
	 * @param dischargeSummaries the DischargeSummaries value
	 */
	public void setDischargeSummaries (java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries) {
		this.dischargeSummaries = dischargeSummaries;
	}

	public void addToDischargeSummaries (jkt.hms.masters.business.DischargeSummary dischargeSummary) {
		if (null == getDischargeSummaries()) setDischargeSummaries(new java.util.TreeSet<jkt.hms.masters.business.DischargeSummary>());
		getDischargeSummaries().add(dischargeSummary);
	}



	/**
	 * Return the value associated with the column: Birthdeathregs
	 */
	public java.util.Set<jkt.hms.masters.business.Birthdeathreg> getBirthdeathregs () {
		return birthdeathregs;
	}

	/**
	 * Set the value related to the column: Birthdeathregs
	 * @param birthdeathregs the Birthdeathregs value
	 */
	public void setBirthdeathregs (java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs) {
		this.birthdeathregs = birthdeathregs;
	}

	public void addToBirthdeathregs (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathregs()) setBirthdeathregs(new java.util.TreeSet<jkt.hms.masters.business.Birthdeathreg>());
		getBirthdeathregs().add(birthdeathreg);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMs () {
		return storeGrnReturnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMs
	 * @param storeGrnReturnMs the StoreGrnReturnMs value
	 */
	public void setStoreGrnReturnMs (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs) {
		this.storeGrnReturnMs = storeGrnReturnMs;
	}

	public void addToStoreGrnReturnMs (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMs()) setStoreGrnReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMs().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMs () {
		return storeIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIssueMs
	 * @param storeIssueMs the StoreIssueMs value
	 */
	public void setStoreIssueMs (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs) {
		this.storeIssueMs = storeIssueMs;
	}

	public void addToStoreIssueMs (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMs()) setStoreIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMs().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: UsergroupHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupHospital> getUsergroupHospitals () {
		return usergroupHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupHospitals
	 * @param usergroupHospitals the UsergroupHospitals value
	 */
	public void setUsergroupHospitals (java.util.Set<jkt.hms.masters.business.UsergroupHospital> usergroupHospitals) {
		this.usergroupHospitals = usergroupHospitals;
	}

	public void addToUsergroupHospitals (jkt.hms.masters.business.UsergroupHospital usergroupHospital) {
		if (null == getUsergroupHospitals()) setUsergroupHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupHospital>());
		getUsergroupHospitals().add(usergroupHospital);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> getStoreTenderCommBidMs () {
		return storeTenderCommBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderCommBidMs
	 * @param storeTenderCommBidMs the StoreTenderCommBidMs value
	 */
	public void setStoreTenderCommBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs) {
		this.storeTenderCommBidMs = storeTenderCommBidMs;
	}

	public void addToStoreTenderCommBidMs (jkt.hms.masters.business.StoreTenderCommBidM storeTenderCommBidM) {
		if (null == getStoreTenderCommBidMs()) setStoreTenderCommBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommBidM>());
		getStoreTenderCommBidMs().add(storeTenderCommBidM);
	}



	/**
	 * Return the value associated with the column: UserAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> getUserAccessrightsHospitals () {
		return userAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UserAccessrightsHospitals
	 * @param userAccessrightsHospitals the UserAccessrightsHospitals value
	 */
	public void setUserAccessrightsHospitals (java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals) {
		this.userAccessrightsHospitals = userAccessrightsHospitals;
	}

	public void addToUserAccessrightsHospitals (jkt.hms.masters.business.UserAccessrightsHospital userAccessrightsHospital) {
		if (null == getUserAccessrightsHospitals()) setUserAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserAccessrightsHospital>());
		getUserAccessrightsHospitals().add(userAccessrightsHospital);
	}



	/**
	 * Return the value associated with the column: Ipdcaredetails
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdcaredetail> getIpdcaredetails () {
		return ipdcaredetails;
	}

	/**
	 * Set the value related to the column: Ipdcaredetails
	 * @param ipdcaredetails the Ipdcaredetails value
	 */
	public void setIpdcaredetails (java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails) {
		this.ipdcaredetails = ipdcaredetails;
	}

	public void addToIpdcaredetails (jkt.hms.masters.business.Ipdcaredetail ipdcaredetail) {
		if (null == getIpdcaredetails()) setIpdcaredetails(new java.util.TreeSet<jkt.hms.masters.business.Ipdcaredetail>());
		getIpdcaredetails().add(ipdcaredetail);
	}



	/**
	 * Return the value associated with the column: UserHospitalDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> getUserHospitalDepartments () {
		return userHospitalDepartments;
	}

	/**
	 * Set the value related to the column: UserHospitalDepartments
	 * @param userHospitalDepartments the UserHospitalDepartments value
	 */
	public void setUserHospitalDepartments (java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments) {
		this.userHospitalDepartments = userHospitalDepartments;
	}

	public void addToUserHospitalDepartments (jkt.hms.masters.business.UserHospitalDepartment userHospitalDepartment) {
		if (null == getUserHospitalDepartments()) setUserHospitalDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalDepartment>());
		getUserHospitalDepartments().add(userHospitalDepartment);
	}



	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts () {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * @param masDiscounts the MasDiscounts value
	 */
	public void setMasDiscounts (java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts (jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts()) setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}



	/**
	 * Return the value associated with the column: StoreIndentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentM> getStoreIndentMs () {
		return storeIndentMs;
	}

	/**
	 * Set the value related to the column: StoreIndentMs
	 * @param storeIndentMs the StoreIndentMs value
	 */
	public void setStoreIndentMs (java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMs) {
		this.storeIndentMs = storeIndentMs;
	}

	public void addToStoreIndentMs (jkt.hms.masters.business.StoreIndentM storeIndentM) {
		if (null == getStoreIndentMs()) setStoreIndentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentM>());
		getStoreIndentMs().add(storeIndentM);
	}



	/**
	 * Return the value associated with the column: UserHospitalRoles
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalRole> getUserHospitalRoles () {
		return userHospitalRoles;
	}

	/**
	 * Set the value related to the column: UserHospitalRoles
	 * @param userHospitalRoles the UserHospitalRoles value
	 */
	public void setUserHospitalRoles (java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles) {
		this.userHospitalRoles = userHospitalRoles;
	}

	public void addToUserHospitalRoles (jkt.hms.masters.business.UserHospitalRole userHospitalRole) {
		if (null == getUserHospitalRoles()) setUserHospitalRoles(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalRole>());
		getUserHospitalRoles().add(userHospitalRole);
	}



	/**
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}



	/**
	 * Return the value associated with the column: MisNotifiables
	 */
	public java.util.Set<jkt.hms.masters.business.MisNotifiable> getMisNotifiables () {
		return misNotifiables;
	}

	/**
	 * Set the value related to the column: MisNotifiables
	 * @param misNotifiables the MisNotifiables value
	 */
	public void setMisNotifiables (java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables) {
		this.misNotifiables = misNotifiables;
	}

	public void addToMisNotifiables (jkt.hms.masters.business.MisNotifiable misNotifiable) {
		if (null == getMisNotifiables()) setMisNotifiables(new java.util.TreeSet<jkt.hms.masters.business.MisNotifiable>());
		getMisNotifiables().add(misNotifiable);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMs () {
		return storeInternalReturnMs;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMs
	 * @param storeInternalReturnMs the StoreInternalReturnMs value
	 */
	public void setStoreInternalReturnMs (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMs) {
		this.storeInternalReturnMs = storeInternalReturnMs;
	}

	public void addToStoreInternalReturnMs (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMs()) setStoreInternalReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMs().add(storeInternalReturnM);
	}



	/**
	 * Return the value associated with the column: StoreWorkOrderMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> getStoreWorkOrderMs () {
		return storeWorkOrderMs;
	}

	/**
	 * Set the value related to the column: StoreWorkOrderMs
	 * @param storeWorkOrderMs the StoreWorkOrderMs value
	 */
	public void setStoreWorkOrderMs (java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> storeWorkOrderMs) {
		this.storeWorkOrderMs = storeWorkOrderMs;
	}

	public void addToStoreWorkOrderMs (jkt.hms.masters.business.StoreWorkOrderM storeWorkOrderM) {
		if (null == getStoreWorkOrderMs()) setStoreWorkOrderMs(new java.util.TreeSet<jkt.hms.masters.business.StoreWorkOrderM>());
		getStoreWorkOrderMs().add(storeWorkOrderM);
	}



	/**
	 * Return the value associated with the column: EmpAfmsfDets
	 */
	public java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> getEmpAfmsfDets () {
		return empAfmsfDets;
	}

	/**
	 * Set the value related to the column: EmpAfmsfDets
	 * @param empAfmsfDets the EmpAfmsfDets value
	 */
	public void setEmpAfmsfDets (java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets) {
		this.empAfmsfDets = empAfmsfDets;
	}

	public void addToEmpAfmsfDets (jkt.hms.masters.business.EmpAfmsfDet empAfmsfDet) {
		if (null == getEmpAfmsfDets()) setEmpAfmsfDets(new java.util.TreeSet<jkt.hms.masters.business.EmpAfmsfDet>());
		getEmpAfmsfDets().add(empAfmsfDet);
	}



	/**
	 * Return the value associated with the column: StoreMeScaleDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> getStoreMeScaleDetails () {
		return storeMeScaleDetails;
	}

	/**
	 * Set the value related to the column: StoreMeScaleDetails
	 * @param storeMeScaleDetails the StoreMeScaleDetails value
	 */
	public void setStoreMeScaleDetails (java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails) {
		this.storeMeScaleDetails = storeMeScaleDetails;
	}

	public void addToStoreMeScaleDetails (jkt.hms.masters.business.StoreMeScaleDetails storeMeScaleDetails) {
		if (null == getStoreMeScaleDetails()) setStoreMeScaleDetails(new java.util.TreeSet<jkt.hms.masters.business.StoreMeScaleDetails>());
		getStoreMeScaleDetails().add(storeMeScaleDetails);
	}



	/**
	 * Return the value associated with the column: StoreIpIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueM> getStoreIpIssueMs () {
		return storeIpIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueMs
	 * @param storeIpIssueMs the StoreIpIssueMs value
	 */
	public void setStoreIpIssueMs (java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs) {
		this.storeIpIssueMs = storeIpIssueMs;
	}

	public void addToStoreIpIssueMs (jkt.hms.masters.business.StoreIpIssueM storeIpIssueM) {
		if (null == getStoreIpIssueMs()) setStoreIpIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueM>());
		getStoreIpIssueMs().add(storeIpIssueM);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> getStoreOpPatientIssueMs () {
		return storeOpPatientIssueMs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueMs
	 * @param storeOpPatientIssueMs the StoreOpPatientIssueMs value
	 */
	public void setStoreOpPatientIssueMs (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs) {
		this.storeOpPatientIssueMs = storeOpPatientIssueMs;
	}

	public void addToStoreOpPatientIssueMs (jkt.hms.masters.business.StoreOpPatientIssueM storeOpPatientIssueM) {
		if (null == getStoreOpPatientIssueMs()) setStoreOpPatientIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueM>());
		getStoreOpPatientIssueMs().add(storeOpPatientIssueM);
	}



	/**
	 * Return the value associated with the column: StoreDefectiveDrugMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> getStoreDefectiveDrugMs () {
		return storeDefectiveDrugMs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugMs
	 * @param storeDefectiveDrugMs the StoreDefectiveDrugMs value
	 */
	public void setStoreDefectiveDrugMs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> storeDefectiveDrugMs) {
		this.storeDefectiveDrugMs = storeDefectiveDrugMs;
	}

	public void addToStoreDefectiveDrugMs (jkt.hms.masters.business.StoreDefectiveDrugM storeDefectiveDrugM) {
		if (null == getStoreDefectiveDrugMs()) setStoreDefectiveDrugMs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugM>());
		getStoreDefectiveDrugMs().add(storeDefectiveDrugM);
	}



	/**
	 * Return the value associated with the column: UsergroupAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> getUsergroupAccessrightsHospitals () {
		return usergroupAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupAccessrightsHospitals
	 * @param usergroupAccessrightsHospitals the UsergroupAccessrightsHospitals value
	 */
	public void setUsergroupAccessrightsHospitals (java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals) {
		this.usergroupAccessrightsHospitals = usergroupAccessrightsHospitals;
	}

	public void addToUsergroupAccessrightsHospitals (jkt.hms.masters.business.UsergroupAccessrightsHospital usergroupAccessrightsHospital) {
		if (null == getUsergroupAccessrightsHospitals()) setUsergroupAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupAccessrightsHospital>());
		getUsergroupAccessrightsHospitals().add(usergroupAccessrightsHospital);
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> getIpdIntakeOutputCharts () {
		return ipdIntakeOutputCharts;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputCharts
	 * @param ipdIntakeOutputCharts the IpdIntakeOutputCharts value
	 */
	public void setIpdIntakeOutputCharts (java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts) {
		this.ipdIntakeOutputCharts = ipdIntakeOutputCharts;
	}

	public void addToIpdIntakeOutputCharts (jkt.hms.masters.business.IpdIntakeOutputChart ipdIntakeOutputChart) {
		if (null == getIpdIntakeOutputCharts()) setIpdIntakeOutputCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutputChart>());
		getIpdIntakeOutputCharts().add(ipdIntakeOutputChart);
	}



	/**
	 * Return the value associated with the column: IpdClinicalCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdClinicalChart> getIpdClinicalCharts () {
		return ipdClinicalCharts;
	}

	/**
	 * Set the value related to the column: IpdClinicalCharts
	 * @param ipdClinicalCharts the IpdClinicalCharts value
	 */
	public void setIpdClinicalCharts (java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts) {
		this.ipdClinicalCharts = ipdClinicalCharts;
	}

	public void addToIpdClinicalCharts (jkt.hms.masters.business.IpdClinicalChart ipdClinicalChart) {
		if (null == getIpdClinicalCharts()) setIpdClinicalCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdClinicalChart>());
		getIpdClinicalCharts().add(ipdClinicalChart);
	}



	/**
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs (jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		getStoreGrnMs().add(storeGrnM);
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: Ipdclinicals
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdclinical> getIpdclinicals () {
		return ipdclinicals;
	}

	/**
	 * Set the value related to the column: Ipdclinicals
	 * @param ipdclinicals the Ipdclinicals value
	 */
	public void setIpdclinicals (java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals) {
		this.ipdclinicals = ipdclinicals;
	}

	public void addToIpdclinicals (jkt.hms.masters.business.Ipdclinical ipdclinical) {
		if (null == getIpdclinicals()) setIpdclinicals(new java.util.TreeSet<jkt.hms.masters.business.Ipdclinical>());
		getIpdclinicals().add(ipdclinical);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}



	/**
	 * Return the value associated with the column: StoreTenderTechnicalBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> getStoreTenderTechnicalBidMs () {
		return storeTenderTechnicalBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidMs
	 * @param storeTenderTechnicalBidMs the StoreTenderTechnicalBidMs value
	 */
	public void setStoreTenderTechnicalBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs) {
		this.storeTenderTechnicalBidMs = storeTenderTechnicalBidMs;
	}

	public void addToStoreTenderTechnicalBidMs (jkt.hms.masters.business.StoreTenderTechnicalBidM storeTenderTechnicalBidM) {
		if (null == getStoreTenderTechnicalBidMs()) setStoreTenderTechnicalBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidM>());
		getStoreTenderTechnicalBidMs().add(storeTenderTechnicalBidM);
	}



	/**
	 * Return the value associated with the column: MisFatalTrackings
	 */
	public java.util.Set<jkt.hms.masters.business.MisFatalTracking> getMisFatalTrackings () {
		return misFatalTrackings;
	}

	/**
	 * Set the value related to the column: MisFatalTrackings
	 * @param misFatalTrackings the MisFatalTrackings value
	 */
	public void setMisFatalTrackings (java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings) {
		this.misFatalTrackings = misFatalTrackings;
	}

	public void addToMisFatalTrackings (jkt.hms.masters.business.MisFatalTracking misFatalTracking) {
		if (null == getMisFatalTrackings()) setMisFatalTrackings(new java.util.TreeSet<jkt.hms.masters.business.MisFatalTracking>());
		getMisFatalTrackings().add(misFatalTracking);
	}



	/**
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs () {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * @param storeLoaninMs the StoreLoaninMs value
	 */
	public void setStoreLoaninMs (java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs (jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		getStoreLoaninMs().add(storeLoaninM);
	}



	/**
	 * Return the value associated with the column: StoreTenderMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderM> getStoreTenderMs () {
		return storeTenderMs;
	}

	/**
	 * Set the value related to the column: StoreTenderMs
	 * @param storeTenderMs the StoreTenderMs value
	 */
	public void setStoreTenderMs (java.util.Set<jkt.hms.masters.business.StoreTenderM> storeTenderMs) {
		this.storeTenderMs = storeTenderMs;
	}

	public void addToStoreTenderMs (jkt.hms.masters.business.StoreTenderM storeTenderM) {
		if (null == getStoreTenderMs()) setStoreTenderMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderM>());
		getStoreTenderMs().add(storeTenderM);
	}



	/**
	 * Return the value associated with the column: Transfers
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfers () {
		return transfers;
	}

	/**
	 * Set the value related to the column: Transfers
	 * @param transfers the Transfers value
	 */
	public void setTransfers (java.util.Set<jkt.hms.masters.business.Transfer> transfers) {
		this.transfers = transfers;
	}

	public void addToTransfers (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfers()) setTransfers(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfers().add(transfer);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: StoreCondemnationMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationM> getStoreCondemnationMs () {
		return storeCondemnationMs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationMs
	 * @param storeCondemnationMs the StoreCondemnationMs value
	 */
	public void setStoreCondemnationMs (java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs) {
		this.storeCondemnationMs = storeCondemnationMs;
	}

	public void addToStoreCondemnationMs (jkt.hms.masters.business.StoreCondemnationM storeCondemnationM) {
		if (null == getStoreCondemnationMs()) setStoreCondemnationMs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationM>());
		getStoreCondemnationMs().add(storeCondemnationM);
	}



	/**
	 * Return the value associated with the column: StoreAdjustmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> getStoreAdjustmentMs () {
		return storeAdjustmentMs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentMs
	 * @param storeAdjustmentMs the StoreAdjustmentMs value
	 */
	public void setStoreAdjustmentMs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs) {
		this.storeAdjustmentMs = storeAdjustmentMs;
	}

	public void addToStoreAdjustmentMs (jkt.hms.masters.business.StoreAdjustmentM storeAdjustmentM) {
		if (null == getStoreAdjustmentMs()) setStoreAdjustmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentM>());
		getStoreAdjustmentMs().add(storeAdjustmentM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasHospital)) return false;
		else {
			jkt.hms.masters.business.MasHospital masHospital = (jkt.hms.masters.business.MasHospital) obj;
			if (null == this.getId() || null == masHospital.getId()) return false;
			else return (this.getId().equals(masHospital.getId()));
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