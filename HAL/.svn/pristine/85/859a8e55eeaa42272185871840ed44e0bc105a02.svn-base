package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hrorderly_leave_application table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="hrorderly_leave_application"
 */

public abstract class BaseHrorderlyLeaveApplication implements Serializable {

	public static String REF = "HrorderlyLeaveApplication";
	public static String PROP_TICKET_FOR_SIDE = "TicketForSide";
	public static String PROP_REQUIRED_FROM = "RequiredFrom";
	public static String PROP_PIN = "Pin";
	public static String PROP_DATE_OF_REPORTING = "DateOfReporting";
	public static String PROP_SET_OF_CV = "SetOfCv";
	public static String PROP_TYPE = "Type";
	public static String PROP_LEAVE_TOTAL_DAYS = "LeaveTotalDays";
	public static String PROP_LEAVE_AVAILED = "LeaveAvailed";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_APPROVED_STATUS = "ApprovedStatus";
	public static String PROP_NRS = "Nrs";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_PREVIOUS_YEAR = "PreviousYear";
	public static String PROP_YEAR = "Year";
	public static String PROP_DAYS_OF_CL = "DaysOfCl";
	public static String PROP_RETURN_JOURNEY_VALID_UPTO = "ReturnJourneyValidUpto";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_RAJDHANI_UPTO = "RajdhaniUpto";
	public static String PROP_TRAIN_CLASS = "TrainClass";
	public static String PROP_OTHER_TRAINS_UPTO = "OtherTrainsUpto";
	public static String PROP_APPLICATION_DATE = "ApplicationDate";
	public static String PROP_ADDL_LEAVE_TO_DATE = "AddlLeaveToDate";
	public static String PROP_RECOMMENDED_STATUS = "RecommendedStatus";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_AVAILING_LTC = "AvailingLtc";
	public static String PROP_HOUSE_NAME = "HouseName";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_ADDL_LEAVE_FROM_DATE = "AddlLeaveFromDate";
	public static String PROP_LEAVE_FROM_DATE = "LeaveFromDate";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_DRAWING_TRANSPORT_ALLOWANCE = "DrawingTransportAllowance";
	public static String PROP_PO = "Po";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_TELEPHONE_NO = "TelephoneNo";
	public static String PROP_UNDER_TR = "UnderTr";
	public static String PROP_TELEGRAPH_OFFICE = "TelegraphOffice";
	public static String PROP_STATUS = "Status";
	public static String PROP_LEAVE = "Leave";
	public static String PROP_ADDL_LEAVE_TOTAL_DAYS = "AddlLeaveTotalDays";
	public static String PROP_STATE = "State";
	public static String PROP_CITY_TO = "CityTo";
	public static String PROP_APPROVED_DATE = "ApprovedDate";
	public static String PROP_ID = "Id";
	public static String PROP_DISTRICT_NAME = "DistrictName";

	// constructors
	public BaseHrorderlyLeaveApplication() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrorderlyLeaveApplication(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date addlLeaveFromDate;
	private java.util.Date addlLeaveToDate;
	private java.lang.String addlLeaveTotalDays;
	private java.util.Date applicationDate;
	private java.util.Date approvedDate;
	private java.lang.String approvedStatus;
	private java.lang.String availingLtc;
	private java.util.Date dateOfReporting;
	private java.lang.String daysOfCl;
	private java.lang.String drawingTransportAllowance;
	private java.util.Date entryDate;
	private java.lang.String entryNo;
	private java.lang.String fullName;
	private java.lang.String houseName;
	private java.lang.Integer leaveAvailed;
	private java.util.Date leaveFromDate;
	private java.lang.String leaveTotalDays;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String nrs;
	private java.lang.String otherTrainsUpto;
	private java.lang.String pin;
	private java.lang.String po;
	private java.lang.String policeStation;
	private java.lang.Integer previousYear;
	private java.lang.String recommendedStatus;
	private java.lang.String remarks;
	private java.lang.String returnJourneyValidUpto;
	private java.lang.String setOfCv;
	private java.lang.String status;
	private java.lang.String telegraphOffice;
	private java.lang.String telephoneNo;
	private java.lang.String ticketForSide;
	private java.lang.String trainClass;
	private java.lang.String type;
	private java.lang.String underTr;
	private java.lang.String village;
	private java.lang.Integer year;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasDistrict cityTo;
	private jkt.hms.masters.business.MasDistrict districtName;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.HrLeaveTypeMaster leave;
	private jkt.hms.masters.business.MasDistrict rajdhaniUpto;
	private jkt.hms.masters.business.MasDistrict requiredFrom;
	private jkt.hms.masters.business.MasState state;

	// collections
	private java.util.Set<jkt.hms.masters.business.EmpLeaveBalance> empLeaveBalances;
	private java.util.Set<jkt.hms.masters.business.FamilyDetails> familyDetails;
	private java.util.Set<jkt.hms.masters.business.HrorderlyMonthlyRationAccounting> hrorderlyMonthlyRationAccountings;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="leave_application_id"
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
	 * Return the value associated with the column: addl_leave_from_date
	 */
	public java.util.Date getAddlLeaveFromDate() {
		return addlLeaveFromDate;
	}

	/**
	 * Set the value related to the column: addl_leave_from_date
	 * 
	 * @param addlLeaveFromDate
	 *            the addl_leave_from_date value
	 */
	public void setAddlLeaveFromDate(java.util.Date addlLeaveFromDate) {
		this.addlLeaveFromDate = addlLeaveFromDate;
	}

	/**
	 * Return the value associated with the column: addl_leave_to_date
	 */
	public java.util.Date getAddlLeaveToDate() {
		return addlLeaveToDate;
	}

	/**
	 * Set the value related to the column: addl_leave_to_date
	 * 
	 * @param addlLeaveToDate
	 *            the addl_leave_to_date value
	 */
	public void setAddlLeaveToDate(java.util.Date addlLeaveToDate) {
		this.addlLeaveToDate = addlLeaveToDate;
	}

	/**
	 * Return the value associated with the column: addl_leave_total_days
	 */
	public java.lang.String getAddlLeaveTotalDays() {
		return addlLeaveTotalDays;
	}

	/**
	 * Set the value related to the column: addl_leave_total_days
	 * 
	 * @param addlLeaveTotalDays
	 *            the addl_leave_total_days value
	 */
	public void setAddlLeaveTotalDays(java.lang.String addlLeaveTotalDays) {
		this.addlLeaveTotalDays = addlLeaveTotalDays;
	}

	/**
	 * Return the value associated with the column: application_date
	 */
	public java.util.Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * Set the value related to the column: application_date
	 * 
	 * @param applicationDate
	 *            the application_date value
	 */
	public void setApplicationDate(java.util.Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * Return the value associated with the column: approved_date
	 */
	public java.util.Date getApprovedDate() {
		return approvedDate;
	}

	/**
	 * Set the value related to the column: approved_date
	 * 
	 * @param approvedDate
	 *            the approved_date value
	 */
	public void setApprovedDate(java.util.Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	/**
	 * Return the value associated with the column: approved_status
	 */
	public java.lang.String getApprovedStatus() {
		return approvedStatus;
	}

	/**
	 * Set the value related to the column: approved_status
	 * 
	 * @param approvedStatus
	 *            the approved_status value
	 */
	public void setApprovedStatus(java.lang.String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	/**
	 * Return the value associated with the column: availing_ltc
	 */
	public java.lang.String getAvailingLtc() {
		return availingLtc;
	}

	/**
	 * Set the value related to the column: availing_ltc
	 * 
	 * @param availingLtc
	 *            the availing_ltc value
	 */
	public void setAvailingLtc(java.lang.String availingLtc) {
		this.availingLtc = availingLtc;
	}

	/**
	 * Return the value associated with the column: date_of_reporting
	 */
	public java.util.Date getDateOfReporting() {
		return dateOfReporting;
	}

	/**
	 * Set the value related to the column: date_of_reporting
	 * 
	 * @param dateOfReporting
	 *            the date_of_reporting value
	 */
	public void setDateOfReporting(java.util.Date dateOfReporting) {
		this.dateOfReporting = dateOfReporting;
	}

	/**
	 * Return the value associated with the column: days_of_cl
	 */
	public java.lang.String getDaysOfCl() {
		return daysOfCl;
	}

	/**
	 * Set the value related to the column: days_of_cl
	 * 
	 * @param daysOfCl
	 *            the days_of_cl value
	 */
	public void setDaysOfCl(java.lang.String daysOfCl) {
		this.daysOfCl = daysOfCl;
	}

	/**
	 * Return the value associated with the column: drawing_transport_allowance
	 */
	public java.lang.String getDrawingTransportAllowance() {
		return drawingTransportAllowance;
	}

	/**
	 * Set the value related to the column: drawing_transport_allowance
	 * 
	 * @param drawingTransportAllowance
	 *            the drawing_transport_allowance value
	 */
	public void setDrawingTransportAllowance(
			java.lang.String drawingTransportAllowance) {
		this.drawingTransportAllowance = drawingTransportAllowance;
	}

	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: full_name
	 */
	public java.lang.String getFullName() {
		return fullName;
	}

	/**
	 * Set the value related to the column: full_name
	 * 
	 * @param fullName
	 *            the full_name value
	 */
	public void setFullName(java.lang.String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Return the value associated with the column: house_name
	 */
	public java.lang.String getHouseName() {
		return houseName;
	}

	/**
	 * Set the value related to the column: house_name
	 * 
	 * @param houseName
	 *            the house_name value
	 */
	public void setHouseName(java.lang.String houseName) {
		this.houseName = houseName;
	}

	/**
	 * Return the value associated with the column: leave_availed
	 */
	public java.lang.Integer getLeaveAvailed() {
		return leaveAvailed;
	}

	/**
	 * Set the value related to the column: leave_availed
	 * 
	 * @param leaveAvailed
	 *            the leave_availed value
	 */
	public void setLeaveAvailed(java.lang.Integer leaveAvailed) {
		this.leaveAvailed = leaveAvailed;
	}

	/**
	 * Return the value associated with the column: leave_from_date
	 */
	public java.util.Date getLeaveFromDate() {
		return leaveFromDate;
	}

	/**
	 * Set the value related to the column: leave_from_date
	 * 
	 * @param leaveFromDate
	 *            the leave_from_date value
	 */
	public void setLeaveFromDate(java.util.Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	/**
	 * Return the value associated with the column: leave_total_days
	 */
	public java.lang.String getLeaveTotalDays() {
		return leaveTotalDays;
	}

	/**
	 * Set the value related to the column: leave_total_days
	 * 
	 * @param leaveTotalDays
	 *            the leave_total_days value
	 */
	public void setLeaveTotalDays(java.lang.String leaveTotalDays) {
		this.leaveTotalDays = leaveTotalDays;
	}

	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy() {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * 
	 * @param lstChangedBy
	 *            the lst_changed_by value
	 */
	public void setLstChangedBy(java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}

	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate() {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * 
	 * @param lstChangedDate
	 *            the lst_changed_date value
	 */
	public void setLstChangedDate(java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}

	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime() {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * 
	 * @param lstChangedTime
	 *            the lst_changed_time value
	 */
	public void setLstChangedTime(java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
	}

	/**
	 * Return the value associated with the column: nrs
	 */
	public java.lang.String getNrs() {
		return nrs;
	}

	/**
	 * Set the value related to the column: nrs
	 * 
	 * @param nrs
	 *            the nrs value
	 */
	public void setNrs(java.lang.String nrs) {
		this.nrs = nrs;
	}

	/**
	 * Return the value associated with the column: other_trains_upto
	 */
	public java.lang.String getOtherTrainsUpto() {
		return otherTrainsUpto;
	}

	/**
	 * Set the value related to the column: other_trains_upto
	 * 
	 * @param otherTrainsUpto
	 *            the other_trains_upto value
	 */
	public void setOtherTrainsUpto(java.lang.String otherTrainsUpto) {
		this.otherTrainsUpto = otherTrainsUpto;
	}

	/**
	 * Return the value associated with the column: pin
	 */
	public java.lang.String getPin() {
		return pin;
	}

	/**
	 * Set the value related to the column: pin
	 * 
	 * @param pin
	 *            the pin value
	 */
	public void setPin(java.lang.String pin) {
		this.pin = pin;
	}

	/**
	 * Return the value associated with the column: po
	 */
	public java.lang.String getPo() {
		return po;
	}

	/**
	 * Set the value related to the column: po
	 * 
	 * @param po
	 *            the po value
	 */
	public void setPo(java.lang.String po) {
		this.po = po;
	}

	/**
	 * Return the value associated with the column: police_station
	 */
	public java.lang.String getPoliceStation() {
		return policeStation;
	}

	/**
	 * Set the value related to the column: police_station
	 * 
	 * @param policeStation
	 *            the police_station value
	 */
	public void setPoliceStation(java.lang.String policeStation) {
		this.policeStation = policeStation;
	}

	/**
	 * Return the value associated with the column: previous_year
	 */
	public java.lang.Integer getPreviousYear() {
		return previousYear;
	}

	/**
	 * Set the value related to the column: previous_year
	 * 
	 * @param previousYear
	 *            the previous_year value
	 */
	public void setPreviousYear(java.lang.Integer previousYear) {
		this.previousYear = previousYear;
	}

	/**
	 * Return the value associated with the column: recommended_status
	 */
	public java.lang.String getRecommendedStatus() {
		return recommendedStatus;
	}

	/**
	 * Set the value related to the column: recommended_status
	 * 
	 * @param recommendedStatus
	 *            the recommended_status value
	 */
	public void setRecommendedStatus(java.lang.String recommendedStatus) {
		this.recommendedStatus = recommendedStatus;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: return_journey_valid_upto
	 */
	public java.lang.String getReturnJourneyValidUpto() {
		return returnJourneyValidUpto;
	}

	/**
	 * Set the value related to the column: return_journey_valid_upto
	 * 
	 * @param returnJourneyValidUpto
	 *            the return_journey_valid_upto value
	 */
	public void setReturnJourneyValidUpto(
			java.lang.String returnJourneyValidUpto) {
		this.returnJourneyValidUpto = returnJourneyValidUpto;
	}

	/**
	 * Return the value associated with the column: set_of_cv
	 */
	public java.lang.String getSetOfCv() {
		return setOfCv;
	}

	/**
	 * Set the value related to the column: set_of_cv
	 * 
	 * @param setOfCv
	 *            the set_of_cv value
	 */
	public void setSetOfCv(java.lang.String setOfCv) {
		this.setOfCv = setOfCv;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: telegraph_office
	 */
	public java.lang.String getTelegraphOffice() {
		return telegraphOffice;
	}

	/**
	 * Set the value related to the column: telegraph_office
	 * 
	 * @param telegraphOffice
	 *            the telegraph_office value
	 */
	public void setTelegraphOffice(java.lang.String telegraphOffice) {
		this.telegraphOffice = telegraphOffice;
	}

	/**
	 * Return the value associated with the column: telephone_no
	 */
	public java.lang.String getTelephoneNo() {
		return telephoneNo;
	}

	/**
	 * Set the value related to the column: telephone_no
	 * 
	 * @param telephoneNo
	 *            the telephone_no value
	 */
	public void setTelephoneNo(java.lang.String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	/**
	 * Return the value associated with the column: ticket_for_side
	 */
	public java.lang.String getTicketForSide() {
		return ticketForSide;
	}

	/**
	 * Set the value related to the column: ticket_for_side
	 * 
	 * @param ticketForSide
	 *            the ticket_for_side value
	 */
	public void setTicketForSide(java.lang.String ticketForSide) {
		this.ticketForSide = ticketForSide;
	}

	/**
	 * Return the value associated with the column: train_class
	 */
	public java.lang.String getTrainClass() {
		return trainClass;
	}

	/**
	 * Set the value related to the column: train_class
	 * 
	 * @param trainClass
	 *            the train_class value
	 */
	public void setTrainClass(java.lang.String trainClass) {
		this.trainClass = trainClass;
	}

	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * 
	 * @param type
	 *            the type value
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * Return the value associated with the column: under_tr
	 */
	public java.lang.String getUnderTr() {
		return underTr;
	}

	/**
	 * Set the value related to the column: under_tr
	 * 
	 * @param underTr
	 *            the under_tr value
	 */
	public void setUnderTr(java.lang.String underTr) {
		this.underTr = underTr;
	}

	/**
	 * Return the value associated with the column: village
	 */
	public java.lang.String getVillage() {
		return village;
	}

	/**
	 * Set the value related to the column: village
	 * 
	 * @param village
	 *            the village value
	 */
	public void setVillage(java.lang.String village) {
		this.village = village;
	}

	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear() {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * 
	 * @param year
	 *            the year value
	 */
	public void setYear(java.lang.Integer year) {
		this.year = year;
	}

	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * Return the value associated with the column: city_to
	 */
	public jkt.hms.masters.business.MasDistrict getCityTo() {
		return cityTo;
	}

	/**
	 * Set the value related to the column: city_to
	 * 
	 * @param cityTo
	 *            the city_to value
	 */
	public void setCityTo(jkt.hms.masters.business.MasDistrict cityTo) {
		this.cityTo = cityTo;
	}

	/**
	 * Return the value associated with the column: district_name
	 */
	public jkt.hms.masters.business.MasDistrict getDistrictName() {
		return districtName;
	}

	/**
	 * Set the value related to the column: district_name
	 * 
	 * @param districtName
	 *            the district_name value
	 */
	public void setDistrictName(
			jkt.hms.masters.business.MasDistrict districtName) {
		this.districtName = districtName;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: leave_id
	 */
	public jkt.hms.masters.business.HrLeaveTypeMaster getLeave() {
		return leave;
	}

	/**
	 * Set the value related to the column: leave_id
	 * 
	 * @param leave
	 *            the leave_id value
	 */
	public void setLeave(jkt.hms.masters.business.HrLeaveTypeMaster leave) {
		this.leave = leave;
	}

	/**
	 * Return the value associated with the column: rajdhani_upto
	 */
	public jkt.hms.masters.business.MasDistrict getRajdhaniUpto() {
		return rajdhaniUpto;
	}

	/**
	 * Set the value related to the column: rajdhani_upto
	 * 
	 * @param rajdhaniUpto
	 *            the rajdhani_upto value
	 */
	public void setRajdhaniUpto(
			jkt.hms.masters.business.MasDistrict rajdhaniUpto) {
		this.rajdhaniUpto = rajdhaniUpto;
	}

	/**
	 * Return the value associated with the column: required_from
	 */
	public jkt.hms.masters.business.MasDistrict getRequiredFrom() {
		return requiredFrom;
	}

	/**
	 * Set the value related to the column: required_from
	 * 
	 * @param requiredFrom
	 *            the required_from value
	 */
	public void setRequiredFrom(
			jkt.hms.masters.business.MasDistrict requiredFrom) {
		this.requiredFrom = requiredFrom;
	}

	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * 
	 * @param state
	 *            the state_id value
	 */
	public void setState(jkt.hms.masters.business.MasState state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: EmpLeaveBalances
	 */
	public java.util.Set<jkt.hms.masters.business.EmpLeaveBalance> getEmpLeaveBalances() {
		return empLeaveBalances;
	}

	/**
	 * Set the value related to the column: EmpLeaveBalances
	 * 
	 * @param empLeaveBalances
	 *            the EmpLeaveBalances value
	 */
	public void setEmpLeaveBalances(
			java.util.Set<jkt.hms.masters.business.EmpLeaveBalance> empLeaveBalances) {
		this.empLeaveBalances = empLeaveBalances;
	}

	public void addToEmpLeaveBalances(
			jkt.hms.masters.business.EmpLeaveBalance empLeaveBalance) {
		if (null == getEmpLeaveBalances())
			setEmpLeaveBalances(new java.util.TreeSet<jkt.hms.masters.business.EmpLeaveBalance>());
		getEmpLeaveBalances().add(empLeaveBalance);
	}

	/**
	 * Return the value associated with the column: FamilyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.FamilyDetails> getFamilyDetails() {
		return familyDetails;
	}

	/**
	 * Set the value related to the column: FamilyDetails
	 * 
	 * @param familyDetails
	 *            the FamilyDetails value
	 */
	public void setFamilyDetails(
			java.util.Set<jkt.hms.masters.business.FamilyDetails> familyDetails) {
		this.familyDetails = familyDetails;
	}

	public void addToFamilyDetails(
			jkt.hms.masters.business.FamilyDetails familyDetails) {
		if (null == getFamilyDetails())
			setFamilyDetails(new java.util.TreeSet<jkt.hms.masters.business.FamilyDetails>());
		getFamilyDetails().add(familyDetails);
	}

	/**
	 * Return the value associated with the column:
	 * HrorderlyMonthlyRationAccountings
	 */
	public java.util.Set<jkt.hms.masters.business.HrorderlyMonthlyRationAccounting> getHrorderlyMonthlyRationAccountings() {
		return hrorderlyMonthlyRationAccountings;
	}

	/**
	 * Set the value related to the column: HrorderlyMonthlyRationAccountings
	 * 
	 * @param hrorderlyMonthlyRationAccountings
	 *            the HrorderlyMonthlyRationAccountings value
	 */
	public void setHrorderlyMonthlyRationAccountings(
			java.util.Set<jkt.hms.masters.business.HrorderlyMonthlyRationAccounting> hrorderlyMonthlyRationAccountings) {
		this.hrorderlyMonthlyRationAccountings = hrorderlyMonthlyRationAccountings;
	}

	public void addToHrorderlyMonthlyRationAccountings(
			jkt.hms.masters.business.HrorderlyMonthlyRationAccounting hrorderlyMonthlyRationAccounting) {
		if (null == getHrorderlyMonthlyRationAccountings())
			setHrorderlyMonthlyRationAccountings(new java.util.TreeSet<jkt.hms.masters.business.HrorderlyMonthlyRationAccounting>());
		getHrorderlyMonthlyRationAccountings().add(
				hrorderlyMonthlyRationAccounting);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrorderlyLeaveApplication))
			return false;
		else {
			jkt.hms.masters.business.HrorderlyLeaveApplication hrorderlyLeaveApplication = (jkt.hms.masters.business.HrorderlyLeaveApplication) obj;
			if (null == this.getId()
					|| null == hrorderlyLeaveApplication.getId())
				return false;
			else
				return (this.getId().equals(hrorderlyLeaveApplication.getId()));
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