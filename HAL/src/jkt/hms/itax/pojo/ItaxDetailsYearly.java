package jkt.hms.itax.pojo;

import java.math.BigDecimal;
import java.util.List;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasStoreFinancial;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ItaxDetailsYearly {
	MasEmployee employee ;
	MasStoreFinancial financialYear;
	List<ItaxPayElementsPojo> deductions ;
	List<ItaxPayElementsPojo> earnings ;
	JRBeanCollectionDataSource deductionsDataSource ;
	JRBeanCollectionDataSource earningsDataSource;
	BigDecimal taxableSalary ; 
	BigDecimal surcharge ;
	BigDecimal eduCess;
	BigDecimal iTaxMonthly;
	BigDecimal taxAlreadyPaid;
	BigDecimal totalTax;
	Integer remainingPeriod;
	String lastProcessedMonth;
	/**
	 * @return the lastProcessedMonth
	 */
	public String getLastProcessedMonth() {
		return lastProcessedMonth;
	}
	/**
	 * @param lastProcessedMonth the lastProcessedMonth to set
	 */
	public void setLastProcessedMonth(String lastProcessedMonth) {
		this.lastProcessedMonth = lastProcessedMonth;
	}
	/**
	 * @return the employee
	 */
	public MasEmployee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(MasEmployee employee) {
		this.employee = employee;
	}
	/**
	 * @return the financialYear
	 */
	public MasStoreFinancial getFinancialYear() {
		return financialYear;
	}
	/**
	 * @param financialYear the financialYear to set
	 */
	public void setFinancialYear(MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}
	/**
	 * @return the iTaxMonthly
	 */
	public BigDecimal getITaxMonthly() {
		return iTaxMonthly;
	}
	/**
	 * @param taxMonthly the iTaxMonthly to set
	 */
	public void setITaxMonthly(BigDecimal taxMonthly) {
		iTaxMonthly = taxMonthly;
	}
	/**
	 * @return the totalTax
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	public JRBeanCollectionDataSource getDeductionsDataSource() {
		return deductionsDataSource;
	}
	public void setDeductionsDataSource(
			JRBeanCollectionDataSource deductionsDataSource) {
		this.deductionsDataSource = deductionsDataSource;
	}
	public JRBeanCollectionDataSource getEarningsDataSource() {
		return earningsDataSource;
	}
	public void setEarningsDataSource(JRBeanCollectionDataSource earningsDataSource) {
		this.earningsDataSource = earningsDataSource;
	}
	/**
	 * @return the deductions
	 */
	public List<ItaxPayElementsPojo> getDeductions() {
		return deductions;
	}
	/**
	 * @param deductions the deductions to set
	 */
	public void setDeductions(List<ItaxPayElementsPojo> deductions) {
		this.deductions = deductions;
	}
	/**
	 * @return the earnings
	 */
	public List<ItaxPayElementsPojo> getEarnings() {
		return earnings;
	}
	/**
	 * @param earnings the earnings to set
	 */
	public void setEarnings(List<ItaxPayElementsPojo> earnings) {
		this.earnings = earnings;
	}
	/**
	 * @return the surcharge
	 */
	public BigDecimal getSurcharge() {
		return surcharge;
	}
	/**
	 * @param surcharge the surcharge to set
	 */
	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}
	/**
	 * @return the taxableSalary
	 */
	public BigDecimal getTaxableSalary() {
		return taxableSalary;
	}
	/**
	 * @param taxableSalary the taxableSalary to set
	 */
	public void setTaxableSalary(BigDecimal taxableSalary) {
		this.taxableSalary = taxableSalary;
	}
	/**
	 * @return the eduCess
	 */
	public BigDecimal getEduCess() {
		return eduCess;
	}
	/**
	 * @param eduCess the eduCess to set
	 */
	public void setEduCess(BigDecimal eduCess) {
		this.eduCess = eduCess;
	}
	/**
	 * @return the taxAlreadyPaid
	 */
	public BigDecimal getTaxAlreadyPaid() {
		return taxAlreadyPaid;
	}
	/**
	 * @param taxAlreadyPaid the taxAlreadyPaid to set
	 */
	public void setTaxAlreadyPaid(BigDecimal taxAlreadyPaid) {
		this.taxAlreadyPaid = taxAlreadyPaid;
	}
	public Integer getRemainingPeriod() {
		return remainingPeriod;
	}
	public void setRemainingPeriod(Integer remainingPeriod) {
		this.remainingPeriod = remainingPeriod;
	}
	
}
