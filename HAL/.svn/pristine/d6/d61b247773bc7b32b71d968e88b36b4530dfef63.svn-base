package jkt.hms.hrOrder.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.hrOrder.dataservice.HrOrderlyRoomDataService;
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

public class HrOrderlyRoomHandlerServiceImpl implements HrOrderlyRoomHandlerService
{

   // -------------------------------------------------------------------------------------------------------
   HrOrderlyRoomDataService hrOrderlyRoomDataService = null;

   public HrOrderlyRoomDataService getHrOrderlyRoomDataService()
   {
      return hrOrderlyRoomDataService;
   }

   public void setHrOrderlyRoomDataService(HrOrderlyRoomDataService hrOrderlyRoomDataService)
   {
      this.hrOrderlyRoomDataService = hrOrderlyRoomDataService;
   }

   // -------------------------------------------------------------------------------------------------------

   // ////////Arrival of Employee //////////////////
   
   public Map<String, Object> searchEmployee(Map<String, Object> infoMap)
   {
	   return hrOrderlyRoomDataService.searchEmployee(infoMap);
   }
   
   public Map<String, Object> showEmployeeJsp()
   {
      return hrOrderlyRoomDataService.showEmployeeJsp();
   }

   public Map<String, Object> showEmployeeUpdateJsp(int id)
   {
      return hrOrderlyRoomDataService.showEmployeeUpdateJsp(id);
   }

   public Map<String,Object> addEmployee(Map<String, Object> map)
   {
      return hrOrderlyRoomDataService.addEmployee(map);
   }

   public Map<String,Object> EmployeeExist(String service_no, int service_type)
   {
      return hrOrderlyRoomDataService.EmployeeExist(service_no, service_type);
   }

   public Map<String, Object> showPorJsp()
   {
      return hrOrderlyRoomDataService.showPorJsp();
   }

   public boolean editEmployeeToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editEmployeeToDatabase(generalMap);
   }

   public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deleteEmployee(employeeId, generalMap);
   }

   public boolean addPorProgram(MasPorProgram masporProgram)
   {
      return hrOrderlyRoomDataService.addPorProgram(masporProgram);
   }

   public boolean deletePorProgram(int porProgramId, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deletePorProgram(porProgramId, generalMap);
   }

   public boolean editPorProgram(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editPorProgram(generalMap);
   }

   public Map<String, Object> searchPorProgram(String porNumber, Date fromDateField, Date toDateField)
   {
      return hrOrderlyRoomDataService.searchPorProgram(porNumber, fromDateField, toDateField);
   }

   public Map<String, Object> getDetailsForSearchForLeaveApplication(Map<String, Object> dataMap)
   {
      return hrOrderlyRoomDataService.getDetailsForSearchForLeaveApplication(dataMap);
   }

   public Map<String, Object> getEmployeeDetailsGrid(Map<String, Object> mapForDs)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsGrid(mapForDs);
   }

   public Map<String, Object> showLeaveApplicationJsp(int Id)
   {
      return hrOrderlyRoomDataService.showLeaveApplicationJsp(Id);
   }

   public Map<String, Object> addLeaveApplication(HrorderlyLeaveApplication hrorderlyLeaveApplication,
         List<FamilyDetails> familyDetails, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.addLeaveApplication(hrorderlyLeaveApplication, familyDetails, generalMap);
   }

   public String generateLeaveApplicationEntryNumber(String userName)
   {
      return hrOrderlyRoomDataService.generateLeaveApplicationEntryNumber(userName);
   }

   public Map<String, Object> showProposalForHro()
   {
      return hrOrderlyRoomDataService.showProposalForHro();
   }

   public Map<String, Object> showDepartment(int deptId)
   {
      return hrOrderlyRoomDataService.showDepartment(deptId);
   }

   public boolean addProposalForHro(ProposalForHroEntry proposalForHroEntry)
   {
      return hrOrderlyRoomDataService.addProposalForHro(proposalForHroEntry);
   }

   public String generateProposalHroEntryNo(Map<String, Object> diagMap)
   {
      return hrOrderlyRoomDataService.generateProposalHroEntryNo(diagMap);
   }
   public Map<String,Object> getPendingProposalList()
   {
	   return hrOrderlyRoomDataService.getPendingProposalList();
   }
   public Map<String, Object> printHroDetail(Box box)
   {
	   return hrOrderlyRoomDataService.printHroDetail(box);
   }
  

   public Map<String,Object> addHroEntry(HroEntry hroEntry)
   {
      return hrOrderlyRoomDataService.addHroEntry(hroEntry);
   }

   public Map<String, Object> showHroEntry()
   {
      return hrOrderlyRoomDataService.showHroEntry();
   }

   public String generateHroEntryNo(Map<String, Object> diagMap)
   {
      return hrOrderlyRoomDataService.generateHroEntryNo(diagMap);
   }

   public Map<String, Object> getDetailsForSearchForMovementOut(Map<String, Object> dataMap)
   {
      return hrOrderlyRoomDataService.getDetailsForSearchForMovementOut(dataMap);
   }

   public Map<String, Object> getMovementInDetailsGrid(Map<String, Object> infoMap)
   {
      return hrOrderlyRoomDataService.getMovementInDetailsGrid(infoMap);
   }
   public Map<String, Object> showPersonnelFromOtherUnitJsp()
   {
      return hrOrderlyRoomDataService.showPersonnelFromOtherUnitJsp();
   }
   public Map<String, Object> getMovementOutDetailsGrid(Map<String, Object> infoMap)
   {
      return hrOrderlyRoomDataService.getMovementOutDetailsGrid(infoMap);
   }
   public Map<String, Object> getDetailsForSearchPostedOut(Map<String, Object> dataMap)
   {
      return hrOrderlyRoomDataService.getDetailsForSearchPostedOut(dataMap);
   }

   public Map<String, Object> getPostedOutDetailsGrid(Map<String, Object> infoMap)
   {
      return hrOrderlyRoomDataService.getPostedOutDetailsGrid(infoMap);
   }

   public Map<String, Object> showPostedOutJsp(int Id)
   {
      return hrOrderlyRoomDataService.showPostedOutJsp(Id);
   }

   public Map<String, Object> addPostedOutEntry(PostedOutEntry postedOutEntry)
   {
      return hrOrderlyRoomDataService.addPostedOutEntry(postedOutEntry);
   }

   public String generatePostedOutEntryNo(Map<String, Object> infoMap)
   {
      return hrOrderlyRoomDataService.generatePostedOutEntryNo(infoMap);
   }

   public Map<String, Object> showMovementOutJsp(int Id , String employeecode)
   {
      return hrOrderlyRoomDataService.showMovementOutJsp(Id,employeecode);
   }

   public Map<String, Object> pendingListForHro()
   {
      return hrOrderlyRoomDataService.pendingListForHro();
   }

   public boolean addMovementOutEntry(MovementOutEntry movementOutEntry, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.addMovementOutEntry(movementOutEntry, generalMap);
   }
   
   public boolean EmployeeExistForOtherPersonnel(String service_no, int service_type)
   {
	   return hrOrderlyRoomDataService.EmployeeExistForOtherPersonnel(service_no,service_type);
   }
   
   public boolean addPersonnelFromOtherUnitJsp(Map<String, Object> generalMap)
   {
	   return hrOrderlyRoomDataService.addPersonnelFromOtherUnitJsp(generalMap);
   }
   
   public boolean UpdatePersonFroOtherUnit(Box box)
   {
	   return hrOrderlyRoomDataService.UpdatePersonFroOtherUnit(box);
   }
   public Map<String, Object> searchOtherPersonUpdate(Box box)
   {
	   return hrOrderlyRoomDataService.searchOtherPersonUpdate(box);
   }
   public Map<String, Object> showUpdatePersonnelFromOtherUnitJsp(int personelId)
    {
      return hrOrderlyRoomDataService.showUpdatePersonnelFromOtherUnitJsp(personelId);
   }
   
   public Map<String, Object> showMovementInJsp(int Id , String employeecode)
   {
      return hrOrderlyRoomDataService.showMovementInJsp(Id, employeecode);
   }

   public Map<String, Object> getDetailsForSearchForMovementIn(Map<String, Object> dataMap)
   {
      return hrOrderlyRoomDataService.getDetailsForSearchForMovementIn(dataMap);
   }

   public boolean addMovementInEntry(MovementInEntry movementInEntry, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.addMovementInEntry(movementInEntry, generalMap);
   }

   public Map<String, Object> getConnectionForReport()
   {
      return hrOrderlyRoomDataService.getConnectionForReport();
   }

   public Map<String, Object> getEmployeeId(Map<String, Object> dataMap)
   {
      return hrOrderlyRoomDataService.getEmployeeId(dataMap);
   }

   public Map<String, Object> searchProposalForHRO(String entryNo, Date proposalDate)
   {
      return hrOrderlyRoomDataService.searchProposalForHRO(entryNo, proposalDate);
   }

   public Map<String, Object> showUpdateProposalJsp(int proposalId)
   {
      return hrOrderlyRoomDataService.showUpdateProposalJsp(proposalId);
   }

   public Map<String, Object> showProposalHroSearchJsp()
   {
      return hrOrderlyRoomDataService.showProposalHroSearchJsp();
   }

   public Map<String, Object> getPostedOutSearchGrid(Map<String, Object> infoMap)
   {
      return hrOrderlyRoomDataService.getPostedOutSearchGrid(infoMap);
   }

   public boolean AddGuardDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.AddGuardDutyEntry(box);
   }
   public boolean updateGuardDutyPerformed(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.updateGuardDutyPerformed(generalMap);
   }
   public Map<String, Object> searchGuardDutyPerformed(Date dutydate)
   {
      return hrOrderlyRoomDataService.searchGuardDutyPerformed(dutydate);
   }
   public Map<String, Object> getEmployeeDetailsForGuardDuty(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForGuardDuty(box);
   }

   public Map<String, Object> getEmployeeDetailsForGuardDutyAdd(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForGuardDutyAdd(box);
   }

   public Map<String, Object> getGridDataForGuardEmployee(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForGuardEmployee(box);
   }

   public Map<String, Object> getGridDataForGuardEmployeeAdd(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForGuardEmployeeAdd(box);
   }

   public Map<String, Object> getGuardEmployeeLastDutyDetails(Box box)
   {
      return hrOrderlyRoomDataService.getGuardEmployeeLastDutyDetails(box);
   }

   public boolean updateGuardDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.updateGuardDutyEntry(box);
   }

   public Map<String, Object> searchLeaveApplication(String serviceNo, String entryNo)
   {
      return hrOrderlyRoomDataService.searchLeaveApplication(serviceNo, entryNo);
   }
  
   public Map<String, Object> searchGuardDutyData(Box box)
   {
      return hrOrderlyRoomDataService.searchGuardDutyData(box);
   }
   public Map<String, Object> searchLeaveJsp()
   {
      return hrOrderlyRoomDataService.searchLeaveJsp();
   }

   public boolean AddOrderlyDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.AddOrderlyDutyEntry(box);
   }

   public Map<String, Object> getEmployeeDetailsForOrderlyDuty(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForOrderlyDuty(box);
   }

   public Map<String, Object> getEmployeeDetailsForOrderlyDutyAdd(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForOrderlyDutyAdd(box);
   }

   public Map<String, Object> getGridDataForOrderlyEmployee(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForOrderlyEmployee(box);
   }

   public Map<String, Object> getGridDataForOrderlyEmployeeAdd(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForOrderlyEmployeeAdd(box);
   }

   public Map<String, Object> getOrderlyEmployeeLastDutyDetails(Box box)
   {
      return hrOrderlyRoomDataService.getOrderlyEmployeeLastDutyDetails(box);
   }

   public boolean updateOrderlyDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.updateOrderlyDutyEntry(box);
   }
   public Map<String, Object> searchOrderlyDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.searchOrderlyDutyEntry(box);
   }
   public Map<String, Object> searchOrderlyDutyData(Box box)
   {
      return hrOrderlyRoomDataService.searchOrderlyDutyData(box);
   }
   public Map<String, Object> searchGuardDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.searchGuardDutyEntry(box);
   }

   public Map<String, Object> showUpdateHroEntryJsp(int hroId)
   {
      return hrOrderlyRoomDataService.showUpdateHroEntryJsp(hroId);
   }

   public Map<String, Object> searchHROEntry(String entryNo, Date proposalDate)
   {
      return hrOrderlyRoomDataService.searchHROEntry(entryNo, proposalDate);
   }

   public Map<String, Object> showHroSearchEntry()
   {
      return hrOrderlyRoomDataService.showHroSearchEntry();
   }

   public Map<String, Object> searchPostedOutEntry(String entryNo, String serviceNo)
   {
      return hrOrderlyRoomDataService.searchPostedOutEntry(entryNo, serviceNo);
   }

   public Map<String, Object> showUpdatePostedOutJsp(int Id)
   {
      return hrOrderlyRoomDataService.showUpdatePostedOutJsp(Id);
   }

   public boolean editPostedOutUpdateToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editPostedOutUpdateToDatabase(generalMap);
   }

   public boolean editProposalHroUpdateToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editProposalHroUpdateToDatabase(generalMap);
   }

   public boolean editHroEntryToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editHroEntryToDatabase(generalMap);
   }

   public boolean updateProposalForHro(Box box)
   {
      return hrOrderlyRoomDataService.updateProposalForHro(box);
   }

   public String generateLeaveRestrictionEntryNumber(Map<String, Object> infoMap)
   {
      return hrOrderlyRoomDataService.generateLeaveRestrictionEntryNumber(infoMap);
   }

   public Map<String, Object> showLeaveRestrictionEntryJsp()
   {
      return hrOrderlyRoomDataService.showLeaveRestrictionEntryJsp();
   }
   
   public Map<String, Object> showTrainClassGroupJsp()
   {
      return hrOrderlyRoomDataService.showTrainClassGroupJsp();
   }
   public Map<String, Object> searchTrainClassGroupJsp(String searchField)
   {
      return hrOrderlyRoomDataService.searchTrainClassGroupJsp(searchField);
   }
   public boolean addTrainClassGroupJsp(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.addTrainClassGroupJsp(generalMap);
   }
   public boolean updateTrainClassGroupJsp(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.updateTrainClassGroupJsp(generalMap);
   }
   public Map<String, Object> showLeaveRestrictionUpdateJsp(int Id)
   {
      return hrOrderlyRoomDataService.showLeaveRestrictionUpdateJsp(Id);
   }

   public Map<String, Object> searchLeaveRestrictionEntry(String entryNo, Date entryDate)
   {
      return hrOrderlyRoomDataService.searchLeaveRestrictionEntry(entryNo, entryDate);
   }

   public boolean editLeaveRestrictionUpdateToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editLeaveRestrictionUpdateToDatabase(generalMap);
   }

   public boolean addLeaveRestrictionEntry(LeaveRestrictionEntry leaveRestrictionEntry)
   {
      return hrOrderlyRoomDataService.addLeaveRestrictionEntry(leaveRestrictionEntry);
   }

   public boolean addleaveAppPending(EmpLeaveBalance empLeaveBalance, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.addleaveAppPending(empLeaveBalance, generalMap);
   }

   public boolean editLeaveApplicationUpdateToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editLeaveApplicationUpdateToDatabase(generalMap);
   }

   public Map<String, Object> searchleaveApplication(String entryNo, String serviceNo)
   {
      return hrOrderlyRoomDataService.searchleaveApplication(entryNo, serviceNo);
   }

   public Map<String, Object> showLeaveApplicationPendingJsp()
   {
      return hrOrderlyRoomDataService.showLeaveApplicationPendingJsp();
   }

   public Map<String, Object> showLeaveApplicationUpdateJsp(int Id)
   {
      return hrOrderlyRoomDataService.showLeaveApplicationUpdateJsp(Id);
   }

   public Map<String, Object> showSearchLeaveApplicationJsp()
   {
      return hrOrderlyRoomDataService.showSearchLeaveApplicationJsp();
   }

   public Map<String, Object> showSearchLeaveRestrictionJsp()
   {
      return hrOrderlyRoomDataService.showSearchLeaveRestrictionJsp();
   }

   public Map<String, Object> showSearchPostedOutJsp()
   {
      return hrOrderlyRoomDataService.showSearchPostedOutJsp();
   }

   public boolean deleteGuardDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.deleteGuardDutyEntry(box);
   }

   public Map<String, Object> showGuardDutyEntryJsp()
   {
      return hrOrderlyRoomDataService.showGuardDutyEntryJsp();
   }

   public Map<String, Object> getEmployeeDetailsForMonthlyRationAccountingAdd(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForMonthlyRationAccountingAdd(box);
   }

   public Map<String, Object> getEmployeeDetailsForMonthlyRationAccountingDuty(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForMonthlyRationAccountingDuty(box);
   }

   public Map<String, Object> getGridDataForMonthlyRationAccountingEmployee(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForMonthlyRationAccountingEmployee(box);
   }
   public Map<String, Object> getGridDataForMonthlyRationStrength(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForMonthlyRationStrength(box);
   }
   public Map<String, Object> getDetailsForEmployeeAbsence(Box box)
   {
      return hrOrderlyRoomDataService.getDetailsForEmployeeAbsence(box);
   }

   public Map<String, Object> getGridDataForMonthlyRationAccountingEmployeeAdd(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForMonthlyRationAccountingEmployeeAdd(box);
   }
   
   public void printRationSummaryDaily(int month , int year )
   {
	   hrOrderlyRoomDataService.printRationSummaryDaily( month , year );
   }

   /**
    * --------------------------- RANGE FIRING DUTY ENTRY
    * ------------------------
    */
   public Map<String, Object> getEmployeeDetailsForRangeFiringDutyAdd(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForRangeFiringDutyAdd(box);
   }

   public Map<String, Object> getGridDataForRangeFiringEmployeeAdd(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForRangeFiringEmployeeAdd(box);
   }

   public Map<String, Object> getEmployeeDetailsForRangeFiringDuty(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForRangeFiringDuty(box);
   }

   public Map<String, Object> getGridDataForRangeFiringEmployee(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForRangeFiringEmployee(box);
   }

   public boolean AddRangeFiringDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.AddRangeFiringDutyEntry(box);
   }

   public boolean updateRangeFiringDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.updateRangeFiringDutyEntry(box);
   }

   public Map<String, Object> searchRangeFiringDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.searchRangeFiringDutyEntry(box);
   }

   public boolean updateMonthlyRationAccounting(Box box)
   {
      return hrOrderlyRoomDataService.updateMonthlyRationAccounting(box);
   }

   public boolean submitLeavePendingEntry(Box box)
   {
      return hrOrderlyRoomDataService.submitLeavePendingEntry(box);
   }

   public Map<String, Object> showOrderlyDutyEntryJsp()
   {
      return hrOrderlyRoomDataService.showOrderlyDutyEntryJsp();
   }

   public boolean AddOfficerDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.AddOfficerDutyEntry(box);
   }

   public Map<String, Object> getEmployeeDetailsForOfficerDuty(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForOfficerDuty(box);
   }

   public Map<String, Object> getEmployeeDetailsForOfficerDutyAdd(Box box)
   {
      return hrOrderlyRoomDataService.getEmployeeDetailsForOfficerDutyAdd(box);
   }

   public Map<String, Object> getGridDataForOfficerEmployee(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForOfficerEmployee(box);
   }

   public Map<String, Object> getGridDataForOfficerEmployeeAdd(Box box)
   {
      return hrOrderlyRoomDataService.getGridDataForOfficerEmployeeAdd(box);
   }

   public Map<String, Object> getOfficerEmployeeLastDutyDetails(Box box)
   {
      return hrOrderlyRoomDataService.getOfficerEmployeeLastDutyDetails(box);
   }

   public Map<String, Object> showOfficerDutyEntryJsp()
   {
      return hrOrderlyRoomDataService.showOfficerDutyEntryJsp();
   }

   public boolean updateOfficerDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.updateOfficerDutyEntry(box);
   }

   public boolean deleteOfficerDutyEntry(Box box)
   {
	     
      return hrOrderlyRoomDataService.deleteOfficerDutyEntry(box);
   }
   
   public Map<String, Object> searchOfficerDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.searchOfficerDutyEntry(box);
   }
   public Map<String, Object> searchOfficerDutyData(Box box)
   {
      return hrOrderlyRoomDataService.searchOfficerDutyData(box);
   }
   
   
   public boolean deleteOrderlyDutyEntry(Box box)
   {
      return hrOrderlyRoomDataService.deleteOrderlyDutyEntry(box);
   }
   // :::::::::::::::::added by yogesh for hr master 
   
   public Map<String, Object> showSpecialityJsp()
   {
      return hrOrderlyRoomDataService.showSpecialityJsp();
   }

   public boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster)
   {
      return hrOrderlyRoomDataService.addSpeciality(hrSpecialistMaster);
   }

   public boolean deleteSpeciality(int id, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deleteSpeciality(id, generalMap);
   }

   public boolean editSpecialityToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editSpecialityToDatabase(generalMap);
   }

   public Map<String, Object> searchSpeciality(String code, String name)
   {
      return hrOrderlyRoomDataService.searchSpeciality(code, name);
   }

   /**
    * -------------------- Mess Master------------------------
    */
   public Map<String, Object> showMessJsp()
   {
      return hrOrderlyRoomDataService.showMessJsp();
   }

   public boolean addMess(HrorderlyMessMaster hrorderlyMessMaster)
   {
      return hrOrderlyRoomDataService.addMess(hrorderlyMessMaster);
   }

   public boolean deleteMess(int id, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deleteMess(id, generalMap);
   }

   public boolean editMessToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editMessToDatabase(generalMap);
   }

   public Map<String, Object> searchMess(String code, String name)
   {
      return hrOrderlyRoomDataService.searchMess(code, name);
   }

   /**
    * -------------------- Leave Choice Master------------------------
    */
   public Map<String, Object> showLeaveChoiceApprovalJsp()
   {
      return hrOrderlyRoomDataService.showLeaveChoiceApprovalJsp();
   }
   public Map<String, Object> searchLeaveChoiceApprovalJsp(String selectedRadio,String searchfield)
   {
      return hrOrderlyRoomDataService.searchLeaveChoiceApprovalJsp(selectedRadio,searchfield);
   }
   public boolean updateLeaveChoiceApprovalJsp(Box box)
   {
      return hrOrderlyRoomDataService.updateLeaveChoiceApprovalJsp(box);
   }
   public Map<String, Object> showLeaveChoiceJsp()
   {
      return hrOrderlyRoomDataService.showLeaveChoiceJsp();
   }

   public boolean addLeaveChoice(HrorderlyLeavechoice hrorderlyLeaveChoice)
   {
      return hrOrderlyRoomDataService.addLeaveChoice(hrorderlyLeaveChoice);
   }

   public boolean deleteLeaveChoice(int id, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deleteLeaveChoice(id, generalMap);
   }

   public boolean editLeaveChoiceToDatabase(HrorderlyLeavechoice hrorderlyleavechoice)
   {
      return hrOrderlyRoomDataService.editLeaveChoiceToDatabase(hrorderlyleavechoice);
   }

   public Map<String, Object> searchLeaveChoice(String code, String name)
   {
      return hrOrderlyRoomDataService.searchLeaveChoice(code, name);
   }

   public Map<String, Object> CheckEmployee(String serviceNo, String servicetype)
   {
      return hrOrderlyRoomDataService.CheckEmployee(serviceNo, servicetype);
   }
 /**
    * ----------------- Leave Type Master ---------------
    */
   public Map<String, Object> showLeaveTypeJsp()
   {
      return hrOrderlyRoomDataService.showLeaveTypeJsp();
   }

   public boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster)
   {
      return hrOrderlyRoomDataService.addLeaveType(hrLeaveTypeMaster);
   }

   public boolean deleteLeaveType(int id, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deleteLeaveType(id, generalMap);
   }

   public boolean editLeaveTypeToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editLeaveTypeToDatabase(generalMap);
   }

   public Map<String, Object> searchLeaveType(String leaveType, String details)
   {
      return hrOrderlyRoomDataService.searchLeaveType(leaveType, details);
   }
 /**
    * --------------------- Class Master --------------------
    */

   public Map<String, Object> showClassJsp()
   {
      return hrOrderlyRoomDataService.showClassJsp();
   }

   public boolean addClass(HrClassMaster hrClassMaster)
   {
      return hrOrderlyRoomDataService.addClass(hrClassMaster);
   }

   public boolean deleteClass(int id, Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.deleteClass(id, generalMap);
   }

   public boolean editClassToDatabase(Map<String, Object> generalMap)
   {
      return hrOrderlyRoomDataService.editClassToDatabase(generalMap);
   }

   public Map<String, Object> searchClass(String code, String name)
   {
      return hrOrderlyRoomDataService.searchClass(code, name);
   }
  // :::::::::::::::::added by yogesh for hr master ended
   /*public Map<String, Object> showNominalRollReportForOfficer(){
         return hrOrderlyRoomDataService.showNominalRollReportForOfficer();
   }*/
   
}
