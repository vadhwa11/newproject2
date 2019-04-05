package jkt.hms.masters.handler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrEmployeeOtherEarning;
import jkt.hms.masters.business.HrEmployeePayElements;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.HrItaxHeader;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxIncomeCode;
import jkt.hms.masters.business.HrMasItaxSecInvestment;
import jkt.hms.masters.business.HrMasItaxSlab;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasSurcharge;
import jkt.hms.masters.business.MasEmployee;


public interface IncomeTaxMasHandlerService {


	
	public Map<String, Object> getConnectionForReport();

	public Map showIncomeTaxSlabJsp();
	public Map	searchItaxSlabMaster(Float taxRate, String financialYear);
	public boolean addIncomeTaxSlabMaster(HrMasItaxSlab hrMasItaxSlab);
	public boolean editIncomeTaxSlabMaster(Map generalMap);
	public boolean deleteIncomeTaxSlabMaster(int slabid,Map generalMap);
	
	/*public Map showFinancialJsp();
	public Map searchFinancialYearMaster(String year, String financialYear);
	public boolean addFinancialYearMaster(MasStoreFinancial hrMasFinancialYear);
	public boolean editFinancialYearMaster(Map generalMap);
	public boolean deleteFinancialYearMaster(int financialYrId,Map generalMap);*/
	
	public Map showIncomeTaxExemptJsp();
	public Map	searchIncomeTaxExemptMaster(String financialYear);
	public boolean addIncomeTaxExemptMaster(HrMasItaxExemption hrMasItaxExemption);
	public boolean editIncomeTaxExemptMaster(Map generalMap);
	public boolean deleteIncomeTaxExemptMaster(int slabid,Map generalMap);
	public Map	copyIncomeTaxExemptMaster(int copyFromYear, int copyToYear);
	
	public Map     showSectionInvestmentJsp();
	public Map	   copySectionInvestmentJsp(int copyFromYear, int copyToYear);
	public Map	   searchSectionInvestmentJsp(String financialYear);
	public boolean addISectionInvestmentJsp(HrMasItaxSecInvestment hrMasItaxSecInvestment);
	public boolean editISectionInvestmentJsp(Map generalMap);
	public boolean deleteISectionInvestmentJsp(int id, Map generalMap);
		
	public Map showIncomeTaxSurchargeJsp();
	public Map	   copyIncomeTaxSurchargeJsp(int copyFromYear, int copyToYear);
	public Map	   searchIncomeTaxSurchargeJsp(String financialYear);
	public boolean addIncomeTaxSurchargeJsp(HrMasItaxSurcharge hrMasItaxSurcharge);
	public boolean editIncomeTaxSurchargeJsp(Map generalMap);
	public boolean deleteIncomeTaxSurchargeJsp(int id,Map generalMap);
	
	public Map showEmployeeOtherEarningJsp(Map<String, Object> detailMap);
	public boolean addEmployeeOtherEarning(HrEmployeeOtherEarning hrEmployeeOtherEarning);
	public boolean editEmployeeOtherEarning(Map generalMap);
	public boolean deleteEmployeeOtherEarning(Map generalMap);
	public Map showITComputationJsp(Map<String, Object> detailMap);
	
	public Map showEmployeeInvestmentJsp(Map<String, Object> detailMap);
	public Map showEmployeeInvestmentWithData(Map<String, Object> detailMap);
	public List getEmployeeListForITcomp();
	public Object loadObject(Class klass ,Integer id);
	Map computeIncomeTax(Map parameterMap);
	public Map computeIncomeTax(MasEmployee employee,Map parameterMap);
	public List<MasStoreFinancial> getFinancialYearList();
	public void saveObject(Object object);
	public Boolean checkDuplicateITaxHeader(HrItaxHeader itaxHeader);
	public List getITaxHeaderList(Map parameterMap);
	public List getPayElementsAmountSumList(List listHeader);
	public HrEmployeePayStructure getEmployeePayStructure(Integer empId);
	public List<HrEmployeePayElements> getEmployeePayElements(Integer empId);
	public List<HrMasItaxSlab> getSlabList(Map map);
	public List<HrMasItaxSurcharge> getSurcharge(MasStoreFinancial finYear);
	public Map saveEmployeeInvestment(Map generalMap);
	public void removeItaxDetails(Map parameterMap);
	public Map checkForExistingIncomeTaxExempt(Map generalMap);
	public Map checkEmployeeInvestment(Map generalMap);
	public Connection getDBConnection();
	
	//=======================Surcharge===================
	public Map showSurchargeJsp();
	public Map searchSurcharge(String code, String name);
	public boolean addSurcharge(HrMasSurcharge hrMasSurcharge);
	public boolean editSurcharge(Map generalMap);
	public boolean deleteSurcharge(int surchargeId,Map generalMap);
	
	//=======================Other Income Code===================
	public Map showOtherIncomeCodeJsp();
	public Map searchOtherIncomeCode(String code, String name);
	public boolean addOtherIncomeCode(HrMasItaxIncomeCode hrMasItaxIncomeCode);
	public boolean editOtherIncomeCode(Map generalMap);
	public boolean deleteOtherIncomeCode(int otehrIncomeCodeId,Map generalMap);
	


}
