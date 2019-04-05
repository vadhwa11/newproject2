package jkt.hms.payroll.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;



public interface PayrollHandlerService {

	Map<String, Object> showPrePayrollProcessJsp();

	List<MasEmployee> getAllEmployeeList();

	MasDepartment getDepartment(int departmentId);

	List<MasEmployee> getEmployee(Map<String, Object> generalMap1);

	List<MasHospital> getHospital(int locationId);

	Map<String, Object> processPrePayrollDetail(Map<String, Object> generalMap);

	Map<String, Object> showSearchPrePayrollProcessJsp();

	Map<String, Object> searchPrePayrollDetail(Map<String, Object> generalMap);

	Map<String, Object> editPrePayrollDetail(int prePayrollProcessId);

	Map<String, Object> updateProcessPrePayrollDetail(
			Map<String, Object> generalMap);

	Map<String, Object> showPostPayrollProcessJsp();

	Map<String, Object> processPostPayrollDetail(Map<String, Object> generalMap);

	Map<String, Object> showPaySlipJsp();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showMonthlyBankAdviceReportJsp();

	Map<String, Object> showEarningAndDeductionJsp();

	Map<String, Object> showIncomeTaxSheet();

	Map<String, Object> getFinancialYearDate(int year);
	
}
