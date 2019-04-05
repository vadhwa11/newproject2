package jkt.hms.masters.handler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.HrEmployeeOtherEarning;
import jkt.hms.masters.business.HrEmployeePayElements;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.HrItaxHeader;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxIncomeCode;
import jkt.hms.masters.business.HrMasItaxSecInvestment;
import jkt.hms.masters.business.HrMasItaxSlab;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasSurcharge;
import jkt.hms.masters.dataservice.IncomeTaxMasDataService;

public class IncomeTaxMasHandlerServiceImpl implements IncomeTaxMasHandlerService{
	
	public Map<String, Object> getConnectionForReport(){
		return incomeTaxMasDataService.getConnectionForReport();
	}	

	private IncomeTaxMasDataService incomeTaxMasDataService = null;

	public IncomeTaxMasDataService getIncomeTaxMasDataService() {
		return incomeTaxMasDataService;
	}

	public void setIncomeTaxMasDataService(	IncomeTaxMasDataService incomeTaxMasDataService) {
		this.incomeTaxMasDataService = incomeTaxMasDataService;
	}

	public Map showIncomeTaxSlabJsp() {
		
		return incomeTaxMasDataService.showIncomeTaxSlabJsp();
	}

	public Map searchItaxSlabMaster(Float taxRate, String financialYear) {
		
		return incomeTaxMasDataService.searchItaxSlabMaster(taxRate, financialYear);
		
	}
	public boolean addIncomeTaxSlabMaster(HrMasItaxSlab hrMasItaxSlab) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addIncomeTaxSlabMaster(hrMasItaxSlab);
	}
	public boolean editIncomeTaxSlabMaster(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editIncomeTaxSlabMaster(generalMap);
	}
	
	public boolean deleteIncomeTaxSlabMaster(int slabid, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteIncomeTaxSlabMaster(slabid,generalMap);
	}
	
	/*public Map showFinancialJsp() {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showFinancialJsp();
	}

	public Map searchFinancialYearMaster(String year,String financialYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.searchFinancialYearMaster(year,financialYear);
	}

	public boolean addFinancialYearMaster(MasStoreFinancial hrMasFinancialYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addFinancialYearMaster(hrMasFinancialYear);
	}

	public boolean editFinancialYearMaster(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editFinancialYearMaster(generalMap);
	}

	public boolean deleteFinancialYearMaster(int financialYrId, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteFinancialYearMaster(financialYrId,generalMap);
	}*/

	public Map showIncomeTaxExemptJsp() {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showIncomeTaxExemptJsp();
	}
	
	public Map copyIncomeTaxExemptMaster(int copyFromYear, int copyToYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.copyIncomeTaxExemptMaster(copyFromYear, copyToYear);
	}

	public Map searchIncomeTaxExemptMaster(String financialYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.searchIncomeTaxExemptMaster(financialYear);
	}

	public boolean addIncomeTaxExemptMaster(HrMasItaxExemption hrMasItaxExemption) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addIncomeTaxExemptMaster(hrMasItaxExemption);
	}

	public boolean editIncomeTaxExemptMaster(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editIncomeTaxExemptMaster(generalMap);
	}

	public boolean deleteIncomeTaxExemptMaster(int slabid, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteIncomeTaxExemptMaster(slabid,generalMap);
	}
	public Map showSectionInvestmentJsp() {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showSectionInvestmentJsp();
	}
	public Map copySectionInvestmentJsp(int copyFromYear, int copyToYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.copySectionInvestmentJsp(copyFromYear, copyToYear);
	}
	public Map searchSectionInvestmentJsp(String financialYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.searchSectionInvestmentJsp(financialYear);
	}
	

	public boolean addISectionInvestmentJsp(
			HrMasItaxSecInvestment hrMasItaxSecInvestment) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addISectionInvestmentJsp(hrMasItaxSecInvestment);
	}

	public boolean editISectionInvestmentJsp(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editISectionInvestmentJsp(generalMap);
	}
	public boolean deleteISectionInvestmentJsp(int id, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteISectionInvestmentJsp(id, generalMap);
	}

	
	
	public Map showIncomeTaxSurchargeJsp() {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showIncomeTaxSurchargeJsp();
	}

	public Map copyIncomeTaxSurchargeJsp(int copyFromYear, int copyToYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.copyIncomeTaxSurchargeJsp(copyFromYear, copyToYear);
	}
	
	public Map searchIncomeTaxSurchargeJsp(String financialYear) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.searchIncomeTaxSurchargeJsp(financialYear);
	}
	
	public boolean addIncomeTaxSurchargeJsp(
			HrMasItaxSurcharge hrMasItaxSurcharge) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addIncomeTaxSurchargeJsp(hrMasItaxSurcharge);
	}

	public boolean editIncomeTaxSurchargeJsp(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editIncomeTaxSurchargeJsp(generalMap);
	}

	public boolean deleteIncomeTaxSurchargeJsp(int id, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteIncomeTaxSurchargeJsp(id, generalMap);
	}

	public Map showEmployeeOtherEarningJsp(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showEmployeeOtherEarningJsp(detailMap);
	}

	public boolean addEmployeeOtherEarning(HrEmployeeOtherEarning hrEmployeeOtherEarning) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addEmployeeOtherEarning(hrEmployeeOtherEarning);
	}

	public boolean editEmployeeOtherEarning(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editEmployeeOtherEarning(generalMap);
	}

	public boolean deleteEmployeeOtherEarning(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteEmployeeOtherEarning(generalMap);
	}

	public Map showEmployeeInvestmentJsp(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showEmployeeInvestmentJsp(detailMap);
	}

	public Map showEmployeeInvestmentWithData(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showEmployeeInvestmentWithData(detailMap);
	}
	
	public Map showITComputationJsp(Map<String, Object> detailMap)
	{
		return incomeTaxMasDataService.showITComputationJsp(detailMap);
	}
	
	public List  getEmployeeListForITcomp()
	{
		return incomeTaxMasDataService.getEmployeeListForITcomp();
	}
	
	public Object loadObject(Class klass ,Integer id)
	{
		return incomeTaxMasDataService.loadObject(klass, id);
	}
	public Map computeIncomeTax(Map parameterMap)
	{
		return incomeTaxMasDataService.computeIncomeTax(parameterMap);
	}

	public Map computeIncomeTax(MasEmployee employee,Map parameterMap)
	{
		return incomeTaxMasDataService.computeIncomeTax(employee, parameterMap);
	}
	
	public List<MasStoreFinancial> getFinancialYearList()
	{
		return incomeTaxMasDataService.getFinancialYearList();
	}
	
	public void saveObject(Object object)
	{
		incomeTaxMasDataService.saveObject(object);
	}
	
	public Boolean checkDuplicateITaxHeader(HrItaxHeader itaxHeader)
	{
		return incomeTaxMasDataService.checkDuplicateITaxHeader(itaxHeader);
	}
	
	public List getITaxHeaderList(Map parameterMap)
	{
		return incomeTaxMasDataService.getITaxHeaderList(parameterMap);
	}
	public List getPayElementsAmountSumList(List listHeader)
	{
		return incomeTaxMasDataService.getPayElementsAmountSumList(listHeader);
	}
	
	public HrEmployeePayStructure getEmployeePayStructure(Integer empId)
	{
		return incomeTaxMasDataService.getEmployeePayStructure(empId);
	}
	public List<HrEmployeePayElements> getEmployeePayElements(Integer empId)
	{
		return incomeTaxMasDataService.getEmployeePayElements(empId);
	}
	
	public List<HrMasItaxSlab> getSlabList(Map map)
	{
		return incomeTaxMasDataService.getSlabList(map);
	}
	
	public List<HrMasItaxSurcharge> getSurcharge(MasStoreFinancial finYear)
	{
		return incomeTaxMasDataService.getSurcharge(finYear);
	}
	public Map saveEmployeeInvestment(Map generalMap)
	{
		return incomeTaxMasDataService.saveEmployeeInvestment(generalMap);
	}
	
	public void removeItaxDetails(Map parameterMap)
	{
		 incomeTaxMasDataService.removeItaxDetails(parameterMap);
	}
	
	public Map checkForExistingIncomeTaxExempt(Map generalMap)
	{
		return incomeTaxMasDataService.checkForExistingIncomeTaxExempt(generalMap);
	}
	public Map checkEmployeeInvestment(Map generalMap)
	{
		return incomeTaxMasDataService.checkEmployeeInvestment(generalMap);
	}
	public Connection getDBConnection()
	{
		return incomeTaxMasDataService.getDBConnection();
	}
	//======================Surcharge=======================
	public Map showSurchargeJsp() {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showSurchargeJsp();
	}

	public Map searchSurcharge(String code,String name) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.searchSurcharge(code,name);
	}

	public boolean addSurcharge(HrMasSurcharge hrMasSurcharge) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addSurcharge(hrMasSurcharge);
	}

	public boolean editSurcharge(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editSurcharge(generalMap);
	}

	public boolean deleteSurcharge(int surchargeId, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteSurcharge(surchargeId,generalMap);
	}
	
	//======================Other Income Code=======================
	public Map showOtherIncomeCodeJsp() {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.showOtherIncomeCodeJsp();
	}

	public Map searchOtherIncomeCode(String code,String name) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.searchOtherIncomeCode(code,name);
	}

	public boolean addOtherIncomeCode(HrMasItaxIncomeCode hrMasItaxIncomeCode) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.addOtherIncomeCode(hrMasItaxIncomeCode);
	}

	public boolean editOtherIncomeCode(Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.editOtherIncomeCode(generalMap);
	}

	public boolean deleteOtherIncomeCode(int otehrIncomeCodeId, Map generalMap) {
		// TODO Auto-generated method stub
		return incomeTaxMasDataService.deleteOtherIncomeCode(otehrIncomeCodeId,generalMap);
	}

	
	
}
