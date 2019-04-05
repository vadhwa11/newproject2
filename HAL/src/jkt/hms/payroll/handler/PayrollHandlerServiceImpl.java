package jkt.hms.payroll.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.payroll.dataservice.PayrollDataService;



public class PayrollHandlerServiceImpl implements PayrollHandlerService {

	PayrollDataService payrollDataService = null;

	public PayrollDataService getPayrollDataService() {
		return payrollDataService;
	}

	public void setPayrollDataService(PayrollDataService payrollDataService) {
		this.payrollDataService = payrollDataService;
	}
	@Override
	public Map<String, Object> showPrePayrollProcessJsp() {
		// TODO Auto-generated method stub
		return payrollDataService.showPrePayrollProcessJsp();
	}
	
	public List<MasEmployee> getAllEmployeeList()
	{
		return payrollDataService.getAllEmployeeList();
	}

	@Override
	public MasDepartment getDepartment(int departmentId) {
		// TODO Auto-generated method stub
		return payrollDataService.getDepartment(departmentId);
	}

	@Override
	public List<MasEmployee> getEmployee(Map<String, Object> generalMap1) {
		// TODO Auto-generated method stub
		return payrollDataService. getEmployee( generalMap1);
	}

	@Override
	public List<MasHospital> getHospital(int locationId) {
		// TODO Auto-generated method stub
		return payrollDataService.getHospital(locationId);
	}

	@Override
	public Map<String, Object> processPrePayrollDetail(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return payrollDataService.processPrePayrollDetail(generalMap);
	}

	@Override
	public Map<String, Object> showSearchPrePayrollProcessJsp() {
		// TODO Auto-generated method stub
		return payrollDataService.showSearchPrePayrollProcessJsp();
	}

	@Override
	public Map<String, Object> searchPrePayrollDetail(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return payrollDataService.searchPrePayrollDetail(generalMap);
	}

	@Override
	public Map<String, Object> editPrePayrollDetail(int prePayrollProcessId) {
		// TODO Auto-generated method stub
		return payrollDataService.editPrePayrollDetail(prePayrollProcessId);
	}

	@Override
	public Map<String, Object> updateProcessPrePayrollDetail(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return payrollDataService.updateProcessPrePayrollDetail(generalMap);
	}

	@Override
	public Map<String, Object> showPostPayrollProcessJsp() {
		// TODO Auto-generated method stub
		return payrollDataService.showPostPayrollProcessJsp();
	}

	@Override
	public Map<String, Object> processPostPayrollDetail(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return payrollDataService.processPostPayrollDetail(generalMap);
	}

	@Override
	public Map<String, Object> showPaySlipJsp() {
		// TODO Auto-generated method stub
		return payrollDataService.showPaySlipJsp();
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return payrollDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> showMonthlyBankAdviceReportJsp() {
		// TODO Auto-generated method stub
		return payrollDataService.showMonthlyBankAdviceReportJsp();
	}

	@Override
	public Map<String, Object> showEarningAndDeductionJsp() {
		// TODO Auto-generated method stub
		return payrollDataService.showEarningAndDeductionJsp();
	}

	@Override
	public Map<String, Object> showIncomeTaxSheet() {
		// TODO Auto-generated method stub
		return payrollDataService.showIncomeTaxSheet();
	}

	@Override
	public Map<String, Object> getFinancialYearDate(int year) {
		// TODO Auto-generated method stub
		return payrollDataService.getFinancialYearDate(year);
	}
	
}
