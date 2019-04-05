package jkt.hms.hrOrder.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.EmpLeaveBalance;
import jkt.hms.masters.business.FamilyDetails;
import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.business.HroEntry;
import jkt.hms.masters.business.HrorderlyLeaveApplication;
import jkt.hms.masters.business.HrorderlyLeavechoice;
import jkt.hms.masters.business.HrorderlyMessMaster;
import jkt.hms.masters.business.LeaveRestrictionEntry;
import jkt.hms.masters.business.MasPorProgram;
import jkt.hms.masters.business.MovementInEntry;
import jkt.hms.masters.business.MovementOutEntry;
import jkt.hms.masters.business.PostedOutEntry;
import jkt.hms.masters.business.ProposalForHroEntry;
import jkt.hms.util.Box;

public interface HrOrderlyRoomHandlerService
{

   public Map<String, Object> showPorJsp();

   public boolean addPorProgram(MasPorProgram masporProgram);

   public boolean deletePorProgram(int porProgramId, Map<String, Object> generalMap);

   public boolean editPorProgram(Map<String, Object> generalMap);

   public Map<String, Object> searchPorProgram(String porNumber, Date fromDateField, Date toDateField);

   public Map<String, Object> getDetailsForSearchForLeaveApplication(Map<String, Object> dataMap);

   public Map<String, Object> searchLeaveJsp();

   public Map<String, Object> searchLeaveApplication(String serviceNo, String entryNo);

   public Map<String, Object> getEmployeeDetailsGrid(Map<String, Object> mapForDs);

   public Map<String, Object> showLeaveApplicationJsp(int Id);

   public Map<String, Object> addLeaveApplication(HrorderlyLeaveApplication hrorderlyLeaveApplication,
         List<FamilyDetails> familyDetails, Map<String, Object> generalMap);

   public String generateLeaveApplicationEntryNumber(String userName);

   // //////// Employee Arrival ///////////////
   
   public Map<String, Object> searchEmployee(Map<String, Object> infoMap);
   
   public Map<String, Object> showEmployeeJsp();

   public Map<String, Object> showEmployeeUpdateJsp(int id);

   public Map<String, Object> EmployeeExist(String service_no, int service_type);

   Map<String,Object> addEmployee(Map<String, Object> map);

   boolean editEmployeeToDatabase(Map<String, Object> generalMap);

   boolean deleteEmployee(int employeeId, Map<String, Object> generalMap);

   // ////// LEAVE RESTRICTION METHODS////////

   public String generateLeaveRestrictionEntryNumber(Map<String, Object> infoMap);

   public Map<String, Object> showLeaveRestrictionEntryJsp();

   public boolean addLeaveRestrictionEntry(LeaveRestrictionEntry leaveRestrictionEntry);

   public Map<String, Object> showLeaveRestrictionUpdateJsp(int Id);

   public Map<String, Object> showSearchLeaveRestrictionJsp();

   public Map<String, Object> searchLeaveRestrictionEntry(String entryNo, Date entryDate);

   public boolean editLeaveRestrictionUpdateToDatabase(Map<String, Object> generalMap);

   // / PROPOSAL FOR HRO METHODS/////////

   public Map<String, Object> showProposalForHro();

   public boolean addProposalForHro(ProposalForHroEntry proposalForHroEntry);

   public boolean updateProposalForHro(Box box);
   
   public Map<String, Object> printHroDetail(Box box);

   public boolean editProposalHroUpdateToDatabase(Map<String, Object> generalMap);

   Map<String, Object> showDepartment(int deptId);

   public String generateProposalHroEntryNo(Map<String, Object> diagMap);

   // ////// HRO ENtry Methods
   public Map<String, Object> showHroEntry();

   public Map<String, Object> showHroSearchEntry();

   public Map<String, Object> showUpdateHroEntryJsp(int hroId);
   
   public Map<String,Object> getPendingProposalList();

   public Map<String, Object> searchHROEntry(String entryNo, Date proposalDate);

   // ///////////////////
   public boolean EmployeeExistForOtherPersonnel(String service_no, int service_type);
   
   public boolean addPersonnelFromOtherUnitJsp(Map<String, Object> generalMap);
   
   public boolean UpdatePersonFroOtherUnit(Box box);
   
   public Map<String, Object> searchOtherPersonUpdate(Box box);
   
   public Map<String, Object> showUpdatePersonnelFromOtherUnitJsp(int personelId);
   
   public Map<String, Object> addHroEntry(HroEntry hroEntry);

   public boolean editHroEntryToDatabase(Map<String, Object> generalMap);

   public String generateHroEntryNo(Map<String, Object> diagMap);

   public Map<String, Object> getDetailsForSearchForMovementOut(Map<String, Object> dataMap);

   public Map<String, Object> getMovementInDetailsGrid(Map<String, Object> infoMap);
   
   public Map<String, Object> getMovementOutDetailsGrid(Map<String, Object> infoMap);

   public Map<String, Object> getDetailsForSearchPostedOut(Map<String, Object> dataMap);

   public Map<String, Object> getPostedOutDetailsGrid(Map<String, Object> infoMap);

   public Map<String, Object> showPostedOutJsp(int Id);

   public Map<String, Object> showSearchPostedOutJsp();

   public Map<String, Object> searchPostedOutEntry(String entryNo, String serviceNo);

   public Map<String, Object> showUpdatePostedOutJsp(int Id);

   public Map<String, Object> addPostedOutEntry(PostedOutEntry postedOutEntry);

   public boolean editPostedOutUpdateToDatabase(Map<String, Object> generalMap);

   public String generatePostedOutEntryNo(Map<String, Object> infoMap);

   public Map<String, Object> showMovementOutJsp(int Id,String employeecode);

   public Map<String, Object> pendingListForHro();

   public Map<String, Object> showMovementInJsp(int Id,String employeecode);
   
   public Map<String, Object> showPersonnelFromOtherUnitJsp();

   public Map<String, Object> getDetailsForSearchForMovementIn(Map<String, Object> dataMap);

   public boolean addMovementInEntry(MovementInEntry movementInEntry, Map<String, Object> generalMap);

   public Map<String, Object> getConnectionForReport();

   Map<String, Object> getEmployeeId(Map<String, Object> dataMap);

   // / Search Proposal For HRO Entry
   Map<String, Object> showProposalHroSearchJsp();

   public Map<String, Object> searchProposalForHRO(String entryNo, Date proposalDate);

   public Map<String, Object> showUpdateProposalJsp(int proposalId);

   public Map<String, Object> getPostedOutSearchGrid(Map<String, Object> infoMap);

   public boolean addMovementOutEntry(MovementOutEntry movementOutEntry, Map<String, Object> generalMap);

   // //////// GUARD DUTY

   Map<String, Object> showGuardDutyEntryJsp();
   
   Map<String, Object> searchGuardDutyPerformed(Date date);
   
   boolean updateGuardDutyPerformed( Map<String, Object> generalMap);

   Map<String, Object> getEmployeeDetailsForGuardDutyAdd(Box box);

   Map<String, Object> getGridDataForGuardEmployeeAdd(Box box);

   Map<String, Object> getEmployeeDetailsForGuardDuty(Box box);

   Map<String, Object> getGridDataForGuardEmployee(Box box);

   Map<String, Object> searchGuardDutyEntry(Box box);
   
   Map<String, Object> searchGuardDutyData(Box box);

   boolean AddGuardDutyEntry(Box box);

   Map<String, Object> getGuardEmployeeLastDutyDetails(Box box);

   boolean deleteGuardDutyEntry(Box box);

   boolean updateGuardDutyEntry(Box box);

   // //////// ORDERLY DUTY ENTRY

   Map<String, Object> getEmployeeDetailsForOrderlyDutyAdd(Box box);
  
   Map<String, Object> searchOrderlyDutyEntry(Box box);
   
   Map<String, Object> searchOrderlyDutyData(Box box);
   
   Map<String, Object> getGridDataForOrderlyEmployeeAdd(Box box);

   Map<String, Object> getEmployeeDetailsForOrderlyDuty(Box box);

   Map<String, Object> getGridDataForOrderlyEmployee(Box box);

   boolean AddOrderlyDutyEntry(Box box);

   Map<String, Object> showOrderlyDutyEntryJsp();

   Map<String, Object> getOrderlyEmployeeLastDutyDetails(Box box);

   boolean updateOrderlyDutyEntry(Box box);

   boolean deleteOrderlyDutyEntry(Box box);

   // //////// ORDERLY OFFICER DUTY ENTRY

   Map<String, Object> getEmployeeDetailsForOfficerDutyAdd(Box box);

   Map<String, Object> getGridDataForOfficerEmployeeAdd(Box box);

   Map<String, Object> getEmployeeDetailsForOfficerDuty(Box box);

   Map<String, Object> getGridDataForOfficerEmployee(Box box);

   boolean AddOfficerDutyEntry(Box box);

   Map<String, Object> showOfficerDutyEntryJsp();

   Map<String, Object> getOfficerEmployeeLastDutyDetails(Box box);

   boolean updateOfficerDutyEntry(Box box);

   boolean deleteOfficerDutyEntry(Box box);
   
   Map<String, Object> searchOfficerDutyEntry(Box box);
   
   Map<String, Object> searchOfficerDutyData(Box box);

   /**
    * ----------------------------- RANGE FIRING DUTY ENTRY
    * ---------------------------
    * 
    */

   Map<String, Object> getEmployeeDetailsForRangeFiringDutyAdd(Box box);

   Map<String, Object> getGridDataForRangeFiringEmployeeAdd(Box box);

   Map<String, Object> getEmployeeDetailsForRangeFiringDuty(Box box);

   Map<String, Object> getGridDataForRangeFiringEmployee(Box box);

   boolean AddRangeFiringDutyEntry(Box box);

   boolean updateRangeFiringDutyEntry(Box box);

   Map<String, Object> searchRangeFiringDutyEntry(Box box);

   /**
    * ----------------------------- MONTHLY RATION ACCOUNTING
    * ---------------------------
    * 
    */

   Map<String, Object> getEmployeeDetailsForMonthlyRationAccountingAdd(Box box);

   Map<String, Object> getGridDataForMonthlyRationAccountingEmployeeAdd(Box box);

   Map<String, Object> getEmployeeDetailsForMonthlyRationAccountingDuty(Box box);

   Map<String, Object> getGridDataForMonthlyRationAccountingEmployee(Box box);
   
   public Map<String , Object> getGridDataForMonthlyRationStrength(Box box ) ;
   
   public Map<String , Object> getDetailsForEmployeeAbsence(Box box ) ;
   
   boolean updateMonthlyRationAccounting(Box box);
   
   public void printRationSummaryDaily(int month , int year );

   /**
    * -----------------------------LEAVE ---------------------------
    * 
    */

   Map<String, Object> showTrainClassGroupJsp();
   
   Map<String, Object> searchTrainClassGroupJsp(String searchField);
   
   public boolean addTrainClassGroupJsp(Map<String, Object> generalMap);
   
   public boolean updateTrainClassGroupJsp(Map<String, Object> generalMap);
  
   Map<String, Object> showLeaveApplicationPendingJsp();

   public Map<String, Object> searchleaveApplication(String entryNo, String serviceNo);

   Map<String, Object> showSearchLeaveApplicationJsp();

   Map<String, Object> showLeaveApplicationUpdateJsp(int Id);

   public boolean editLeaveApplicationUpdateToDatabase(Map<String, Object> generalMap);

   boolean submitLeavePendingEntry(Box box);

   public boolean addleaveAppPending(EmpLeaveBalance empLeaveBalance, Map<String, Object> generalMap);
   //::::::::::::::::::added by yogesh for hr master 
   
   Map<String, Object> showSpecialityJsp();

   boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster);

   Map<String, Object> searchSpeciality(String code, String name);

   boolean editSpecialityToDatabase(Map<String, Object> generalMap);

   boolean deleteSpeciality(int id, Map<String, Object> generalMap);

   /**
    * -------------------Mess Master-----------------------
    * 
    */
   Map<String, Object> showMessJsp();

   boolean addMess(HrorderlyMessMaster hrorderlyMessMaster);

   Map<String, Object> searchMess(String code, String name);

   boolean editMessToDatabase(Map<String, Object> generalMap);

   boolean deleteMess(int id, Map<String, Object> generalMap);

   /**
    * -------------------Leave choice Master-----------------------
    * 
    */
   Map<String, Object> showLeaveChoiceApprovalJsp();
   
   Map<String, Object> searchLeaveChoiceApprovalJsp(String selectedRadio,String searchfield);
   
   boolean updateLeaveChoiceApprovalJsp(Box box);
  
   Map<String, Object> showLeaveChoiceJsp();

   boolean addLeaveChoice(HrorderlyLeavechoice hrorderlyLeaveChoice);

   Map<String, Object> searchLeaveChoice(String code, String name);

   boolean editLeaveChoiceToDatabase(HrorderlyLeavechoice hrorderlyleavechoice);

   boolean deleteLeaveChoice(int id, Map<String, Object> generalMap);

   public Map<String, Object> CheckEmployee(String serviceNo, String servicetype);
/**
    * ------------------- Leave Type Master ----------------------
    * 
    * @return
    */

   Map<String, Object> showLeaveTypeJsp();

   boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster);

   Map<String, Object> searchLeaveType(String leaveType, String details);

   boolean editLeaveTypeToDatabase(Map<String, Object> generalMap);

   boolean deleteLeaveType(int id, Map<String, Object> generalMap);
 /**
    * ----------------------- Class Master ----------------------
    */
   Map<String, Object> showClassJsp();

   boolean addClass(HrClassMaster hrClassMaster);

   Map<String, Object> searchClass(String code, String name);

   boolean editClassToDatabase(Map<String, Object> generalMap);

   boolean deleteClass(int id, Map<String, Object> generalMap);
  
 //::::::::::::::::::added by yogesh for hr master  ended
   //public Map<String, Object> showNominalRollReportForOfficer();
   

}
