package jkt.hms.workservices.dataservice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.business.MisMonthlyBedSts;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.Patient;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReportDataServiceImpl extends HibernateDaoSupport implements
		ReportDataService {

	public Map<String, Object> showMinorWorkRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<MasWorkType> masWorkTypeList = new ArrayList<MasWorkType>();
		masWorkTypeList = session.createCriteria(MasWorkType.class).add(
				Restrictions.eq("Status", "y")).list();
		if (masWorkTypeList.size() > 0) {

			map.put("masWorkTypeList", masWorkTypeList);
		}
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> showMajorWorkRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		// TODO Auto-generated method stub
		List<MasWorkType> masWorkTypeList = new ArrayList<MasWorkType>();
		masWorkTypeList = session.createCriteria(MasWorkType.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("masWorkTypeList", masWorkTypeList);
		return map;
	}

	// =====================================================

	public Map<String, Object> printAraogyaReport(Map<String, Object> mapForDs) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();

		Date fromDate = null;
		Date toDate = null;

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
			//System.out.println("fromDate===-=-=-" + fromDate);
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
			//System.out.println("toDate=-=-=-=-=-=-" + toDate);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fromDateString = sdf.format(fromDate);
		String toDateString = sdf.format(toDate);

		List<Object[]> patientList = new ArrayList<Object[]>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		/*
		 * List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
		 * List<MstrSiteHeader> mstrSiteHeaderList = new
		 * ArrayList<MstrSiteHeader>();
		 */

		inPatientList = session.createCriteria(Inpatient.class).add(
				Restrictions.between("DateOfAddmission", fromDate, toDate))
				.list();

		/*
		 * mstrSiteHeaderList = session.createCriteria(MstrSiteHeader.class)
		 * .add(Restrictions.eq("Id", siteId)) .list();
		 */

		String hospitalName = "CHAFB Command Hospital";
		/*
		 * String projectCode = mstrProjectList.get(0).getPrjCode(); String
		 * projectName = mstrProjectList.get(0).getPrjName();
		 * 
		 * String siteCode = mstrSiteHeaderList.get(0).getSiteCode(); String
		 * siteName = mstrSiteHeaderList.get(0).getSiteName(); String
		 * hospitalName =
		 * mstrProjectList.get(0).getHospital().getHospitalName();
		 */

		try {

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("AraogyaReport");

			// Create a new font and alter it.

			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font2 = wb.createFont();
			font2.setFontHeightInPoints((short) 9);
			font2.setFontName(HSSFFont.FONT_ARIAL);
			font2.setColor((short) 80);
			font2.setItalic(false);
			font2.setStrikeout(false);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);

			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);

			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setFont(font2);
			style2.setAlignment((short) 2);

			// style1.setLocked(true);

			HSSFRow row2 = sheet.createRow((short) 2);
			HSSFCell cell20 = row2.createCell((short) 3);
			cell20.setCellValue(new HSSFRichTextString(hospitalName));
			cell20.setCellStyle(style1);
			sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

			HSSFRow row3 = sheet.createRow((short) 3);
			HSSFCell cell30 = row3.createCell((short) 3);
			cell30.setCellValue(new HSSFRichTextString("Araogya Report"));
			cell30.setCellStyle(style1);
			sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

			HSSFRow row4 = sheet.createRow((short) 4);
			HSSFCell cell40 = row4.createCell((short) 1);
			cell40.setCellStyle(style1);
			cell40.setCellValue(new HSSFRichTextString(""));
			sheet.addMergedRegion(new Region(4, (short) 1, 4, (short) 7));

			HSSFRow row5 = sheet.createRow((short) 5);
			HSSFCell cell51 = row5.createCell((short) 1);
			cell51.setCellValue(new HSSFRichTextString("From  :"));

			HSSFCell cell52 = row5.createCell((short) 3);
			cell52.setCellValue(new HSSFRichTextString(fromDateString));

			HSSFCell cell57 = row5.createCell((short) 4);
			cell57.setCellValue(new HSSFRichTextString("To  :"));

			HSSFCell cell60 = row5.createCell((short) 6);
			cell60.setCellValue(new HSSFRichTextString(toDateString));

			// sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
			// =====Heading Row Start===========================
			HSSFRow headingRow1 = sheet.createRow((short) 7);

			HSSFCell cell70 = headingRow1.createCell((short) 0);
			cell70.setCellValue(new HSSFRichTextString("MEDICAL_UNIT"));
			cell70.setCellStyle(style2);

			HSSFCell cell71 = headingRow1.createCell((short) 1);
			cell71.setCellValue(new HSSFRichTextString("AND_NO"));
			cell71.setCellStyle(style2);

			HSSFCell cell72 = headingRow1.createCell((short) 2);
			cell72.setCellValue(new HSSFRichTextString("DIET"));
			cell72.setCellStyle(style2);

			HSSFCell cell73 = headingRow1.createCell((short) 3);
			cell73.setCellValue(new HSSFRichTextString("ADMSN_DATE"));
			cell73.setCellStyle(style2);

			HSSFCell cell74 = headingRow1.createCell((short) 4);
			cell74.setCellValue(new HSSFRichTextString("WARD"));
			cell74.setCellStyle(style2);

			HSSFCell cell75 = headingRow1.createCell((short) 5);
			cell75.setCellValue(new HSSFRichTextString("NAME"));
			cell75.setCellStyle(style2);

			HSSFCell cell76 = headingRow1.createCell((short) 6);
			cell76.setCellValue(new HSSFRichTextString("AGE Years"));
			cell76.setCellStyle(style2);

			HSSFCell cell7601 = headingRow1.createCell((short) 7);
			cell7601.setCellValue(new HSSFRichTextString("AGE Months"));
			cell7601.setCellStyle(style2);

			HSSFCell cell7602 = headingRow1.createCell((short) 8);
			cell7602.setCellValue(new HSSFRichTextString("AGE Days"));
			cell7602.setCellStyle(style2);

			HSSFCell cell77 = headingRow1.createCell((short) 9);
			cell77.setCellValue(new HSSFRichTextString("SEX"));
			cell77.setCellStyle(style2);

			HSSFCell cell78 = headingRow1.createCell((short) 10);
			cell78.setCellValue(new HSSFRichTextString("MARITAL_STATUS"));
			cell78.setCellStyle(style2);

			HSSFCell cell79 = headingRow1.createCell((short) 11);
			cell79.setCellValue(new HSSFRichTextString("RELATIONSHIP"));
			cell79.setCellStyle(style2);

			HSSFCell cell710 = headingRow1.createCell((short) 12);
			cell710.setCellValue(new HSSFRichTextString("NBB"));
			cell710.setCellStyle(style2);

			HSSFCell cell711 = headingRow1.createCell((short) 13);
			cell711.setCellValue(new HSSFRichTextString("NBB_WEIGHT"));
			cell711.setCellStyle(style2);

			HSSFCell cell712 = headingRow1.createCell((short) 14);
			cell712.setCellValue(new HSSFRichTextString("PERSNL_NO"));
			cell712.setCellStyle(style2);

			HSSFCell cell713 = headingRow1.createCell((short) 15);
			cell713.setCellValue(new HSSFRichTextString("CATEGORY"));
			cell713.setCellStyle(style2);

			HSSFCell cell714 = headingRow1.createCell((short) 16);
			cell714.setCellValue(new HSSFRichTextString("RANK"));
			cell714.setCellStyle(style2);

			HSSFCell cell715 = headingRow1.createCell((short) 17);
			cell715.setCellValue(new HSSFRichTextString("PERSNL_NAME"));
			cell715.setCellStyle(style2);

			HSSFCell cell716 = headingRow1.createCell((short) 18);
			cell716.setCellValue(new HSSFRichTextString("PERSNL_AGE_YEAR"));
			cell716.setCellStyle(style2);

			HSSFCell cell717 = headingRow1.createCell((short) 19);
			cell717.setCellValue(new HSSFRichTextString("PERSNL_AGE_MONTH"));
			cell717.setCellStyle(style2);

			HSSFCell cell7171 = headingRow1.createCell((short) 20);
			cell7171.setCellValue(new HSSFRichTextString("PERSNL_AGE_Days"));
			cell7171.setCellStyle(style2);

			HSSFCell cell718 = headingRow1.createCell((short) 21);
			cell718.setCellValue(new HSSFRichTextString("PERSNL_SEX"));
			cell718.setCellStyle(style2);

			HSSFCell cell719 = headingRow1.createCell((short) 22);
			cell719.setCellValue(new HSSFRichTextString("SERVICE_YEARS"));
			cell719.setCellStyle(style2);

			HSSFCell cell720 = headingRow1.createCell((short) 23);
			cell720.setCellValue(new HSSFRichTextString("SERVICE_MONTHS"));
			cell720.setCellStyle(style2);

			HSSFCell cell721 = headingRow1.createCell((short) 24);
			cell721.setCellValue(new HSSFRichTextString("PERSNL_UNIT"));
			cell721.setCellStyle(style2);

			HSSFCell cell722 = headingRow1.createCell((short) 25);
			cell722.setCellValue(new HSSFRichTextString("PERSNL_UNIT_DESC"));
			cell722.setCellStyle(style2);

			HSSFCell cell723 = headingRow1.createCell((short) 26);
			cell723.setCellValue(new HSSFRichTextString("STATION"));
			cell723.setCellStyle(style2);

			HSSFCell cell724 = headingRow1.createCell((short) 27);
			cell724.setCellValue(new HSSFRichTextString("FORMATION"));
			cell724.setCellStyle(style2);

			HSSFCell cell725 = headingRow1.createCell((short) 28);
			cell725.setCellValue(new HSSFRichTextString("ARM_CORPS"));
			cell725.setCellStyle(style2);

			HSSFCell cell726 = headingRow1.createCell((short) 29);
			cell726.setCellValue(new HSSFRichTextString("TRADE"));
			cell726.setCellStyle(style2);

			HSSFCell cell727 = headingRow1.createCell((short) 30);
			cell727.setCellValue(new HSSFRichTextString("RELIGION"));
			cell727.setCellStyle(style2);

			HSSFCell cell728 = headingRow1.createCell((short) 31);
			cell728.setCellValue(new HSSFRichTextString("CLASS"));
			cell728.setCellStyle(style2);

			HSSFCell cell729 = headingRow1.createCell((short) 32);
			cell729
					.setCellValue(new HSSFRichTextString(
							"PERSNL_MARITAL_STATUS"));
			cell729.setCellStyle(style2);

			HSSFCell cell730 = headingRow1.createCell((short) 33);
			cell730.setCellValue(new HSSFRichTextString("DIST_ORIGIN"));
			cell730.setCellStyle(style2);

			HSSFCell cell731 = headingRow1.createCell((short) 34);
			cell731.setCellValue(new HSSFRichTextString("STATE_ORIGIN"));
			cell731.setCellStyle(style2);

			HSSFCell cell732 = headingRow1.createCell((short) 35);
			cell732.setCellValue(new HSSFRichTextString("RECORDS_OFFICE"));
			cell732.setCellStyle(style2);

			HSSFCell cell733 = headingRow1.createCell((short) 36);
			cell733.setCellValue(new HSSFRichTextString("ARRIVAL_TIME"));
			cell733.setCellStyle(style2);

			HSSFCell cell734 = headingRow1.createCell((short) 37);
			cell734.setCellValue(new HSSFRichTextString("ADMSN_TYPE"));
			cell734.setCellStyle(style2);

			HSSFCell cell735 = headingRow1.createCell((short) 38);
			cell735.setCellValue(new HSSFRichTextString("TRNSFRD_FROM"));
			cell735.setCellStyle(style2);

			HSSFCell cell736 = headingRow1.createCell((short) 39);
			cell736.setCellValue(new HSSFRichTextString("TRNSFRD_FROM_DESC"));
			cell736.setCellStyle(style2);

			HSSFCell cell737 = headingRow1.createCell((short) 40);
			cell737.setCellValue(new HSSFRichTextString("TRNSFRD_AND_NO"));
			cell737.setCellStyle(style2);

			HSSFCell cell738 = headingRow1.createCell((short) 41);
			cell738.setCellValue(new HSSFRichTextString("ON_LIST"));
			cell738.setCellStyle(style2);

			HSSFCell cell739 = headingRow1.createCell((short) 42);
			cell739.setCellValue(new HSSFRichTextString("CONDITION"));
			cell739.setCellStyle(style2);

			HSSFCell cell740 = headingRow1.createCell((short) 43);
			cell740.setCellValue(new HSSFRichTextString("MLC"));
			cell740.setCellStyle(style2);

			HSSFCell cell741 = headingRow1.createCell((short) 44);
			cell741.setCellValue(new HSSFRichTextString("MLC_DATE"));
			cell741.setCellStyle(style2);

			HSSFCell cell742 = headingRow1.createCell((short) 45);
			cell742.setCellValue(new HSSFRichTextString("INJRY_RPT"));
			cell742.setCellStyle(style2);

			HSSFCell cell743 = headingRow1.createCell((short) 46);
			cell743.setCellValue(new HSSFRichTextString("INJRY_RPT_DATE"));
			cell743.setCellStyle(style2);

			HSSFCell cell744 = headingRow1.createCell((short) 47);
			cell744.setCellValue(new HSSFRichTextString("MED_CTGRY_S"));
			cell744.setCellStyle(style2);

			HSSFCell cell745 = headingRow1.createCell((short) 48);
			cell745.setCellValue(new HSSFRichTextString("MED_CTGRY_H"));
			cell745.setCellStyle(style2);

			HSSFCell cell746 = headingRow1.createCell((short) 49);
			cell746.setCellValue(new HSSFRichTextString("MED_CTGRY_A"));
			cell746.setCellStyle(style2);

			HSSFCell cell747 = headingRow1.createCell((short) 50);
			cell747.setCellValue(new HSSFRichTextString("MED_CTGRY_P"));
			cell747.setCellStyle(style2);

			HSSFCell cell748 = headingRow1.createCell((short) 51);
			cell748.setCellValue(new HSSFRichTextString("MED_CTGRY_E"));
			cell748.setCellStyle(style2);

			HSSFCell cell749 = headingRow1.createCell((short) 52);
			cell749.setCellValue(new HSSFRichTextString("DSCHRG_DATE"));
			cell749.setCellStyle(style2);

			HSSFCell cell750 = headingRow1.createCell((short) 53);
			cell750.setCellValue(new HSSFRichTextString("DISPOSAL"));
			cell750.setCellStyle(style2);

			HSSFCell cell751 = headingRow1.createCell((short) 54);
			cell751.setCellValue(new HSSFRichTextString("TRNSFRD_TO"));
			cell751.setCellStyle(style2);

			HSSFCell cell752 = headingRow1.createCell((short) 55);
			cell752.setCellValue(new HSSFRichTextString("TRNSFRD_TO_DESC"));
			cell752.setCellStyle(style2);

			HSSFCell cell753 = headingRow1.createCell((short) 56);
			cell753.setCellValue(new HSSFRichTextString("REJECTION_REASON"));
			cell753.setCellStyle(style2);

			HSSFCell cell754 = headingRow1.createCell((short) 57);
			cell754.setCellValue(new HSSFRichTextString("PATIENT_STATUS"));
			cell754.setCellStyle(style2);

			HSSFCell cell755 = headingRow1.createCell((short) 58);
			cell755.setCellValue(new HSSFRichTextString("ADMSN_STATUS"));
			cell755.setCellStyle(style2);

			HSSFCell cell756 = headingRow1.createCell((short) 59);
			cell756.setCellValue(new HSSFRichTextString("DSCHRG_STATUS"));
			cell756.setCellStyle(style2);

			HSSFCell cell757 = headingRow1.createCell((short) 60);
			cell757.setCellValue(new HSSFRichTextString("CREATED_ON"));
			cell757.setCellStyle(style2);

			HSSFCell cell758 = headingRow1.createCell((short) 61);
			cell758.setCellValue(new HSSFRichTextString("CREATED_BY"));
			cell758.setCellStyle(style2);

			HSSFCell cell759 = headingRow1.createCell((short) 62);
			cell759.setCellValue(new HSSFRichTextString("MODIFIED_ON"));
			cell759.setCellStyle(style2);

			HSSFCell cell760 = headingRow1.createCell((short) 63);
			cell760.setCellValue(new HSSFRichTextString("MODIFIED_BY"));
			cell760.setCellStyle(style2);

			HSSFCell cell761 = headingRow1.createCell((short) 64);
			cell761.setCellValue(new HSSFRichTextString("APPRVD_AT_UNIT_ON"));
			cell761.setCellStyle(style2);

			HSSFCell cell762 = headingRow1.createCell((short) 65);
			cell762.setCellValue(new HSSFRichTextString("APPRVR_AT_UNIT_BY"));
			cell762.setCellStyle(style2);

			HSSFCell cell763 = headingRow1.createCell((short) 66);
			cell763.setCellValue(new HSSFRichTextString("APPRVD_AT_MISO_ON"));
			cell763.setCellStyle(style2);

			HSSFCell cell764 = headingRow1.createCell((short) 67);
			cell764.setCellValue(new HSSFRichTextString("APPRVR_AT_MISO_BY"));
			cell764.setCellStyle(style2);

			HSSFCell cell765 = headingRow1.createCell((short) 68);
			cell765.setCellValue(new HSSFRichTextString("TIME_STAMP"));
			cell765.setCellStyle(style2);

			HSSFCell cell766 = headingRow1.createCell((short) 69);
			cell766.setCellValue(new HSSFRichTextString("NOK_NAME"));
			cell766.setCellStyle(style2);

			HSSFCell cell767 = headingRow1.createCell((short) 70);
			cell767.setCellValue(new HSSFRichTextString("NOK_RELATION"));
			cell767.setCellStyle(style2);

			HSSFCell cell768 = headingRow1.createCell((short) 71);
			cell768.setCellValue(new HSSFRichTextString("NOK_ADDRESS"));
			cell768.setCellStyle(style2);

			HSSFCell cell769 = headingRow1.createCell((short) 72);
			cell769.setCellValue(new HSSFRichTextString("CDA_NO"));
			cell769.setCellStyle(style2);

			HSSFCell cell770 = headingRow1.createCell((short) 73);
			cell770.setCellValue(new HSSFRichTextString("TYPE_INJURY"));
			cell770.setCellStyle(style2);

			HSSFCell cell771 = headingRow1.createCell((short) 74);
			cell771.setCellValue(new HSSFRichTextString("DETAILS_SICKLEAVE"));
			cell771.setCellStyle(style2);

			HSSFCell cell772 = headingRow1.createCell((short) 75);
			cell772.setCellValue(new HSSFRichTextString("INJURY_REPORT_A"));
			cell772.setCellStyle(style2);

			HSSFCell cell773 = headingRow1.createCell((short) 76);
			cell773.setCellValue(new HSSFRichTextString("DISCHARGE_WARD"));
			cell773.setCellStyle(style2);

			HSSFCell cell774 = headingRow1.createCell((short) 77);
			cell774.setCellValue(new HSSFRichTextString("TRANSPORT_MODE"));
			cell774.setCellStyle(style2);

			HSSFCell cell775 = headingRow1.createCell((short) 78);
			cell775.setCellValue(new HSSFRichTextString("OTHER_DETAILS"));
			cell775.setCellStyle(style2);

			HSSFCell cell776 = headingRow1.createCell((short) 79);
			cell776.setCellValue(new HSSFRichTextString("WARD_NO_A"));
			cell776.setCellStyle(style2);

			HSSFCell cell777 = headingRow1.createCell((short) 80);
			cell777.setCellValue(new HSSFRichTextString("WARD_NO_D"));
			cell777.setCellStyle(style2);

			HSSFCell cell778 = headingRow1.createCell((short) 81);
			cell778.setCellValue(new HSSFRichTextString("NOT_PATIENT"));
			cell778.setCellStyle(style2);

			HSSFCell cell779 = headingRow1.createCell((short) 82);
			cell779.setCellValue(new HSSFRichTextString("DEPENDENT_DETAILS"));
			cell779.setCellStyle(style2);

			HSSFCell cell780 = headingRow1.createCell((short) 83);
			cell780.setCellValue(new HSSFRichTextString("DISCHARGE_REMARKS"));
			cell780.setCellStyle(style2);

			HSSFCell cell781 = headingRow1.createCell((short) 84);
			cell781.setCellValue(new HSSFRichTextString("AB64"));
			cell781.setCellStyle(style2);

			HSSFCell cell782 = headingRow1.createCell((short) 85);
			cell782.setCellValue(new HSSFRichTextString("ICD_REMARKS_A"));
			cell782.setCellStyle(style2);

			HSSFCell cell783 = headingRow1.createCell((short) 86);
			cell783.setCellValue(new HSSFRichTextString("ICD_REMARKS_D"));
			cell783.setCellStyle(style2);

			HSSFCell cell784 = headingRow1.createCell((short) 87);
			cell784.setCellValue(new HSSFRichTextString("ID_CARD"));
			cell784.setCellStyle(style2);

			HSSFCell cell785 = headingRow1.createCell((short) 88);
			cell785.setCellValue(new HSSFRichTextString("SURGERY_DONE"));
			cell785.setCellStyle(style2);

			HSSFCell cell786 = headingRow1.createCell((short) 89);
			cell786.setCellValue(new HSSFRichTextString("SURGERY_REMARKS"));
			cell786.setCellStyle(style2);

			// ============Heading Completed=======================

			// Region(int rowFrom, short colFrom, int rowTo, short colTo)
			sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

			// Region(int rowFrom, short colFrom, int rowTo, short colTo)
			sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));
			// ================Inserted Value================
			int row = 9;

			for (Inpatient inpatient : inPatientList) {
				String inPatientAdNo = inpatient.getAdNo();
				Patient patient = inpatient.getHin();
				Set<MlcCase> mlcCaseSet = patient.getMlcCases();
				Set<Discharge> dischargeSet = patient.getDischarges();
				HSSFRow detailRow = sheet.createRow((short) row);

				HSSFCell cell90 = detailRow.createCell((short) 0);
				cell90.setCellValue(new HSSFRichTextString("CHAFB"));
				// cell90.setCellStyle(style1);

				HSSFCell cell91 = detailRow.createCell((short) 1);
				if (inpatient.getAdNo() != null) {
					cell91.setCellValue(new HSSFRichTextString(inpatient
							.getAdNo()));
				}
				// cell91.setCellStyle(style1);

				HSSFCell cell92 = detailRow.createCell((short) 2);
				if (inpatient.getDietType() != null) {
					cell92.setCellValue(new HSSFRichTextString(inpatient
							.getDiet().getDietCode()
							+ " - " + inpatient.getDietType()));
				}
				// cell92.setCellStyle(style1);

				HSSFCell cell93 = detailRow.createCell((short) 3);
				if (inpatient.getDateOfAddmission() != null) {
					cell93.setCellValue(new HSSFRichTextString(sdf
							.format(inpatient.getDateOfAddmission())));
				}
				// cell93.setCellStyle(style1);

				HSSFCell cell94 = detailRow.createCell((short) 4);
				if (inpatient.getAdWardId() != null) {
					cell94.setCellValue(new HSSFRichTextString(inpatient
							.getAdWardId().getDepartmentName()));
				}

				HSSFCell cell95 = detailRow.createCell((short) 5);
				if (patient.getPFirstName() != null) {
					cell95
							.setCellValue(new HSSFRichTextString(patient
									.getPFirstName()
									+ patient.getPMiddleName()
									+ patient.getPLastName()));
				}

				HSSFCell cell96 = detailRow.createCell((short) 6);
				HSSFCell cell9601 = detailRow.createCell((short) 7);
				HSSFCell cell9602 = detailRow.createCell((short) 8);
				if (patient.getAge() != null) {
					if (patient.getAge().substring(
							patient.getAge().length() - 2,
							patient.getAge().length()).equalsIgnoreCase("rs")) {
						cell96.setCellValue(new HSSFRichTextString(patient
								.getAge()));
					}

					else if (patient.getAge().substring(
							patient.getAge().length() - 2,
							patient.getAge().length()).equalsIgnoreCase("hs")) {
						cell9601.setCellValue(new HSSFRichTextString(patient
								.getAge()));
					} else if (patient.getAge().substring(
							patient.getAge().length() - 2,
							patient.getAge().length()).equalsIgnoreCase("ys")) {
						cell9602.setCellValue(new HSSFRichTextString(patient
								.getAge()));
					}
				}

				HSSFCell cell97 = detailRow.createCell((short) 9);
				if (patient.getSex() != null) {
					cell97.setCellValue(new HSSFRichTextString(patient.getSex()
							.getAdministrativeSexName()));
				}

				HSSFCell cell98 = detailRow.createCell((short) 10);
				if (patient.getMaritalStatus() != null) {
					cell98.setCellValue(new HSSFRichTextString(patient
							.getMaritalStatus().getMaritalStatusName()));
				}

				HSSFCell cell99 = detailRow.createCell((short) 11);
				if (patient.getRelation() != null) {
					cell99.setCellValue(new HSSFRichTextString(patient
							.getRelation().getRelationName()));
				}

				HSSFCell cell910 = detailRow.createCell((short) 12);
				if (patient.getAge() != null) {
					if (patient.getAge().equalsIgnoreCase("1 Days")) {
						cell910.setCellValue(new HSSFRichTextString("Y"));
					}
				}

				HSSFCell cell911 = detailRow.createCell((short) 13);
				// if(patient.getRelation() != null){
				cell911.setCellValue(new HSSFRichTextString(""));
				// }

				HSSFCell cell912 = detailRow.createCell((short) 14);
				if (patient.getServiceNo() != null) {
					cell912.setCellValue(new HSSFRichTextString(patient
							.getPrefix()
							+ " "
							+ patient.getServiceNo()
							+ " "
							+ patient.getSuffix()));
				}

				HSSFCell cell913 = detailRow.createCell((short) 15);
				if (patient.getRank() != null) {
					cell913
							.setCellValue(new HSSFRichTextString(patient
									.getRank().getRankCategory()
									.getRankCategoryName()));
				}

				HSSFCell cell914 = detailRow.createCell((short) 16);
				if (patient.getRank() != null) {
					cell914.setCellValue(new HSSFRichTextString(patient
							.getRank().getRankName()));
				}

				HSSFCell cell915 = detailRow.createCell((short) 17);
				if (patient.getSFirstName() != null) {
					cell915.setCellValue(new HSSFRichTextString(patient
							.getSFirstName()
							+ " "
							+ patient.getSMiddleName()
							+ " "
							+ patient.getSLastName()));
				}

				HSSFCell cell916 = detailRow.createCell((short) 18);
				if (patient.getAge() != null
						&& patient.getRelation() != null
						&& patient.getRelation().getRelationName()
								.equalsIgnoreCase("Self")) {
					if (patient.getAge().substring(
							patient.getAge().length() - 2,
							patient.getAge().length()).equalsIgnoreCase("rs")) {
						cell916.setCellValue(new HSSFRichTextString(patient
								.getAge()));
					}
				}

				HSSFCell cell917 = detailRow.createCell((short) 19);
				if (patient.getAge() != null
						&& patient.getRelation() != null
						&& patient.getRelation().getRelationName()
								.equalsIgnoreCase("Self")) {
					if (patient.getAge().substring(
							patient.getAge().length() - 2,
							patient.getAge().length()).equalsIgnoreCase("hs")) {
						cell917.setCellValue(new HSSFRichTextString(patient
								.getAge()));
					}
				}

				HSSFCell cell91701 = detailRow.createCell((short) 20);
				if (patient.getAge() != null
						&& patient.getRelation() != null
						&& patient.getRelation().getRelationName()
								.equalsIgnoreCase("Self")) {
					if (patient.getAge().substring(
							patient.getAge().length() - 2,
							patient.getAge().length()).equalsIgnoreCase("ys")) {
						cell91701.setCellValue(new HSSFRichTextString(patient
								.getAge()));
					}
				}

				HSSFCell cell918 = detailRow.createCell((short) 21);
				if (patient.getSex() != null
						&& patient.getRelation().getRelationName()
								.equalsIgnoreCase("Self")) {
					cell918.setCellValue(new HSSFRichTextString(patient
							.getSex().getAdministrativeSexName()));
				}

				HSSFCell cell919 = detailRow.createCell((short) 22);
				if (patient.getServiceYears() != null) {
					cell919.setCellValue(patient.getServiceYears()
							.doubleValue());
				}

				HSSFCell cell920 = detailRow.createCell((short) 23);
				// if(patient.getSFirstName() != null){
				cell920.setCellValue(new HSSFRichTextString(""));
				// }

				HSSFCell cell921 = detailRow.createCell((short) 24);
				if (patient.getUnit() != null) {
					cell921.setCellValue(new HSSFRichTextString(patient
							.getUnit().getUnitName()));
				}

				HSSFCell cell922 = detailRow.createCell((short) 25);
				if (patient.getUnit() != null) {
					cell922.setCellValue(new HSSFRichTextString(patient
							.getUnit().getUnitAddress()));
				}

				HSSFCell cell923 = detailRow.createCell((short) 26);
				if (patient.getStation() != null) {
					cell923.setCellValue(new HSSFRichTextString(patient
							.getStation()));
				}

				HSSFCell cell924 = detailRow.createCell((short) 27);
				if (patient.getFormation() != null) {
					cell924.setCellValue(new HSSFRichTextString(patient
							.getFormation()));
				}

				HSSFCell cell925 = detailRow.createCell((short) 28);
				// if(patient.getFormation() != null){
				cell925.setCellValue(new HSSFRichTextString(""));
				// }

				HSSFCell cell926 = detailRow.createCell((short) 29);
				if (patient.getTrade() != null) {
					cell926.setCellValue(new HSSFRichTextString(patient
							.getTrade().getTradeName()));
				}

				HSSFCell cell927 = detailRow.createCell((short) 30);
				if (patient.getReligion() != null) {
					cell927.setCellValue(new HSSFRichTextString(patient
							.getReligion().getReligionName()));
				}

				HSSFCell cell928 = detailRow.createCell((short) 31);
				// if(patient.getClass() != null){
				cell928.setCellValue(new HSSFRichTextString(""));
				// }

				HSSFCell cell929 = detailRow.createCell((short) 32);
				if (patient.getMaritalStatus() != null
						&& patient.getRelation().getRelationName()
								.equalsIgnoreCase("Self")) {
					cell929.setCellValue(new HSSFRichTextString(patient
							.getMaritalStatus().getMaritalStatusName()));
				}

				HSSFCell cell930 = detailRow.createCell((short) 33);
				if (patient.getDistrict() != null) {
					cell930.setCellValue(new HSSFRichTextString(patient
							.getDistrict().getDistrictName()));
				}

				HSSFCell cell931 = detailRow.createCell((short) 34);
				if (patient.getState() != null) {
					cell931.setCellValue(new HSSFRichTextString(patient
							.getDistrict().getState().getStateName()));
				}

				HSSFCell cell932 = detailRow.createCell((short) 35);
				if (patient.getRecordOfficeAddress() != null) {
					cell932.setCellValue(new HSSFRichTextString(patient
							.getRecordOfficeAddress().getAddress()));
				}

				HSSFCell cell933 = detailRow.createCell((short) 36);
				if (inpatient.getDateOfAddmission() != null
						&& inpatient.getTimeOfAddmission() != null) {
					cell933.setCellValue(new HSSFRichTextString(inpatient
							.getDateOfAddmission()
							+ " " + inpatient.getTimeOfAddmission()));
				} else if ((inpatient.getDateOfAddmission() != null && !(inpatient
						.getTimeOfAddmission() != null))) {
					cell933.setCellValue(new HSSFRichTextString(sdf
							.format(inpatient.getDateOfAddmission())));
				} else if (!(inpatient.getDateOfAddmission() != null && (inpatient
						.getTimeOfAddmission() != null))) {
					cell933.setCellValue(new HSSFRichTextString(sdf
							.format(inpatient.getDateOfAddmission())));
				}

				HSSFCell cell934 = detailRow.createCell((short) 37);
				if (inpatient.getAdmissionType() != null) {
					cell934.setCellValue(new HSSFRichTextString(inpatient
							.getAdmissionType().getAdmissionTypeName()));
				}

				HSSFCell cell935 = detailRow.createCell((short) 38);
				if (inpatient.getTransFrom() != null) {
					cell935.setCellValue(new HSSFRichTextString(inpatient
							.getTransFrom()));
				}

				HSSFCell cell936 = detailRow.createCell((short) 39);
				// if(inpatient.getPreviousAdNo() != null){
				cell936.setCellValue(new HSSFRichTextString(""));
				// }

				// for TRANS_AND_NO
				HSSFCell cell937 = detailRow.createCell((short) 40);
				cell937.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell938 = detailRow.createCell((short) 41);
				if (inpatient.getConditionStatus() != null) {
					if (inpatient.getConditionStatus().equalsIgnoreCase(
							"Normal")) {
						cell938.setCellValue(new HSSFRichTextString("None"));
					} else {
						cell938.setCellValue(new HSSFRichTextString(inpatient
								.getConditionStatus()));
					}
				}

				HSSFCell cell939 = detailRow.createCell((short) 42);
				if (inpatient.getPatientCondition() != null) {
					cell939.setCellValue(new HSSFRichTextString(inpatient
							.getPatientCondition()));
				}

				HSSFCell cell940 = detailRow.createCell((short) 43);
				if (inpatient.getMlc() != null) {
					cell940.setCellValue(new HSSFRichTextString(inpatient
							.getMlc()));
				}

				HSSFCell cell941 = detailRow.createCell((short) 44);
				HSSFCell cell942 = detailRow.createCell((short) 45);

				/*for (MlcCase mlcCase : mlcCaseSet) {
					if (inPatientAdNo.equals(mlcCase.getAdNo())) {
						if (mlcCase.getMlcDate() != null) {
							cell941.setCellValue(new HSSFRichTextString(sdf
									.format(mlcCase.getMlcDate())));
						}
						if (mlcCase.getRemarks() != null) {
							cell942.setCellValue(new HSSFRichTextString(mlcCase
									.getRemarks()));
						}
					}
				}*/

				HSSFCell cell943 = detailRow.createCell((short) 46);
				for (Discharge discharge : dischargeSet) {
					if (inPatientAdNo.equals(discharge.getAdNo())) {
						if (discharge.getInjuryReportInitiatedOn() != null) {
							cell943.setCellValue(new HSSFRichTextString(sdf
									.format(discharge
											.getInjuryReportInitiatedOn())));
						}
					}
				}

				// for MED_CTGRY_S
				HSSFCell cell944 = detailRow.createCell((short) 47);
				cell944.setCellValue(new HSSFRichTextString(""));

				// for MED_CTGRY_H
				HSSFCell cell945 = detailRow.createCell((short) 48);
				cell945.setCellValue(new HSSFRichTextString(""));

				// for MED_CTGRY_A
				HSSFCell cell946 = detailRow.createCell((short) 49);
				cell946.setCellValue(new HSSFRichTextString(""));

				// for MED_CTGRY_P
				HSSFCell cell947 = detailRow.createCell((short) 50);
				cell947.setCellValue(new HSSFRichTextString(""));

				// for MED_CTGRY_E
				HSSFCell cell948 = detailRow.createCell((short) 51);
				cell948.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell949 = detailRow.createCell((short) 52);
				if (inpatient.getDischargeDate() != null) {
					cell949.setCellValue(new HSSFRichTextString(sdf
							.format(inpatient.getDischargeDate())));
				}

				HSSFCell cell950 = detailRow.createCell((short) 53);
				HSSFCell cell951 = detailRow.createCell((short) 54);
				HSSFCell cell952 = detailRow.createCell((short) 55);
				for (Discharge discharge : dischargeSet) {
					if (inPatientAdNo.equals(discharge.getAdNo())) {
						if (discharge.getDisposedTo() != null) {
							cell950.setCellValue(new HSSFRichTextString(
									discharge.getDisposedTo()
											.getDisposedToName()));
						}
						if (discharge.getOtherHospital() != null) {
							cell951.setCellValue(new HSSFRichTextString(
									discharge.getOtherHospital()));
						}
						if (discharge.getRemarks() != null) {
							cell952.setCellValue(new HSSFRichTextString(
									discharge.getRemarks()));
						}
					}
				}

				// for PEJECTION_REASON
				HSSFCell cell953 = detailRow.createCell((short) 56);
				cell953.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell954 = detailRow.createCell((short) 57);
				if (inpatient.getAdmissionType() != null) {
					cell954.setCellValue(new HSSFRichTextString(inpatient
							.getAdmissionType().getAdmissionTypeName()));
				}

				// ADMSN_STATUS
				HSSFCell cell955 = detailRow.createCell((short) 58);
				cell955.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell956 = detailRow.createCell((short) 59);
				for (Discharge discharge : dischargeSet) {
					if (inPatientAdNo.equals(discharge.getAdNo())) {
						if (discharge.getDischargeStatus() != null) {
							cell956.setCellValue(new HSSFRichTextString(
									discharge.getDischargeStatus()
											.getDischargeStatusName()));
						}
					}
				}

				// for CREATED_ON
				HSSFCell cell957 = detailRow.createCell((short) 60);
				if (inpatient.getAddEditDate() != null) {
					cell957.setCellValue(new HSSFRichTextString(""));
				}

				// for CREATED_BY
				HSSFCell cell958 = detailRow.createCell((short) 61);
				if (inpatient.getAddEditBy() != null) {
					cell958.setCellValue(new HSSFRichTextString(""));
				}

				// for MODIFIED_ON
				HSSFCell cell959 = detailRow.createCell((short) 62);
				if (inpatient.getAddEditDate() != null) {
					cell959.setCellValue(new HSSFRichTextString(""));
				}

				// for MODIFIED_BY
				HSSFCell cell960 = detailRow.createCell((short) 63);
				if (inpatient.getAddEditBy() != null) {
					cell960.setCellValue(new HSSFRichTextString(""));
				}

				// for APPRVD_AT_UNIT_ON
				HSSFCell cell961 = detailRow.createCell((short) 64);
				// if(inpatient.getAdmissionType() != null){
				cell961.setCellValue(new HSSFRichTextString(""));
				// }

				// for APPRVD_AT_UNIT_BY
				HSSFCell cell962 = detailRow.createCell((short) 65);
				// if(inpatient.getAdmissionType() != null){
				cell962.setCellValue(new HSSFRichTextString(""));
				// }

				// for APPRVD_AT_MISO_ON
				HSSFCell cell963 = detailRow.createCell((short) 66);
				// if(inpatient.getAdmissionType() != null){
				cell963.setCellValue(new HSSFRichTextString(""));
				// }

				// for APPRVD_AT_MISO_BY
				HSSFCell cell964 = detailRow.createCell((short) 67);
				// if(inpatient.getAdmissionType() != null){
				cell964.setCellValue(new HSSFRichTextString(""));
				// }

				// for TIME_STAMP
				HSSFCell cell965 = detailRow.createCell((short) 68);
				// if(inpatient.getAdmissionType() != null){
				cell965.setCellValue(new HSSFRichTextString(""));
				// }

				HSSFCell cell966 = detailRow.createCell((short) 69);
				if (patient.getNextOfKinName() != null) {
					cell966.setCellValue(new HSSFRichTextString(patient
							.getNextOfKinName()));
				}

				HSSFCell cell967 = detailRow.createCell((short) 70);
				if (patient.getNextOfKinRelation() != null) {
					cell967.setCellValue(new HSSFRichTextString(patient
							.getNextOfKinRelation().getRelationName()));
				}

				HSSFCell cell968 = detailRow.createCell((short) 71);
				if (patient.getNextOfKinAddress() != null) {
					cell968.setCellValue(new HSSFRichTextString(patient
							.getNextOfKinAddress()));
				}

				HSSFCell cell969 = detailRow.createCell((short) 72);
				if (patient.getCdaAccountNo() != null) {
					cell969.setCellValue(new HSSFRichTextString(patient
							.getCdaAccountNo()));
				}

				// for TYPE_INJURY
				HSSFCell cell970 = detailRow.createCell((short) 73);
				cell970.setCellValue(new HSSFRichTextString(""));

				// for DETAILS_SICK_LEAVE
				HSSFCell cell971 = detailRow.createCell((short) 74);
				cell971.setCellValue(new HSSFRichTextString(""));

				// for INJURY_REPORT_A
				HSSFCell cell972 = detailRow.createCell((short) 75);
				cell972.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell973 = detailRow.createCell((short) 76);
				for (Discharge discharge : dischargeSet) {
					if (inPatientAdNo.equals(discharge.getAdNo())) {
						if (discharge.getWard() != null) {
							cell973.setCellValue(new HSSFRichTextString(
									discharge.getWard().getDepartmentName()));
						}
					}
				}

				// for TRANSPORT_MODE
				HSSFCell cell974 = detailRow.createCell((short) 77);
				cell974.setCellValue(new HSSFRichTextString(""));

				// for OTHER_DEATILS
				HSSFCell cell975 = detailRow.createCell((short) 78);
				cell975.setCellValue(new HSSFRichTextString(""));

				// for WARD_NO_A
				HSSFCell cell976 = detailRow.createCell((short) 79);
				cell976.setCellValue(new HSSFRichTextString(""));

				// for WARD_NO_D
				HSSFCell cell977 = detailRow.createCell((short) 80);
				cell977.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell978 = detailRow.createCell((short) 81);
				if (inpatient.getAttachedPatient().equalsIgnoreCase("N")) {
					cell978.setCellValue(new HSSFRichTextString("N"));
				} else {
					cell978.setCellValue(new HSSFRichTextString("Y"));
				}

				// for DEPENDENT_DETAILS
				HSSFCell cell979 = detailRow.createCell((short) 82);
				cell979.setCellValue(new HSSFRichTextString(""));

				// for DISCHARGE_REMARKS
				HSSFCell cell980 = detailRow.createCell((short) 83);
				cell980.setCellValue(new HSSFRichTextString(""));

				HSSFCell cell981 = detailRow.createCell((short) 84);
				if (inpatient.getDischargeDate() != null
						&& patient.getAb64Available() != null) {
					if (patient.getAb64Available().equalsIgnoreCase("n")) {
						cell981.setCellValue(new HSSFRichTextString(
								"Not Available"));
					} else if (patient.getAb64Available().equalsIgnoreCase("y")) {
						cell981
								.setCellValue(new HSSFRichTextString(
										"Available"));
					}
				} else {
					cell981.setCellValue(new HSSFRichTextString(""));
				}

				HSSFCell cell982 = detailRow.createCell((short) 85);
				if (inpatient.getInitDiagnosis() != null) {
					cell982.setCellValue(new HSSFRichTextString(inpatient
							.getInitDiagnosis()));
				}

				HSSFCell cell983 = detailRow.createCell((short) 86);
				for (Discharge discharge : dischargeSet) {
					if (inPatientAdNo.equals(discharge.getAdNo())) {
						if (discharge.getWorkingDiagnosis() != null) {
							cell983.setCellValue(new HSSFRichTextString(
									discharge.getWorkingDiagnosis()));
						}
					}
				}

				HSSFCell cell984 = detailRow.createCell((short) 87);
				if (patient.getServiceCardStatus() != null) {
					if (patient.getServiceCardStatus().equalsIgnoreCase("y")) {
						cell984
								.setCellValue(new HSSFRichTextString(
										"Available"));
					} else if (patient.getServiceCardStatus().equalsIgnoreCase(
							"n")) {
						cell984.setCellValue(new HSSFRichTextString(
								"Not Available"));
					}
				}

				// for SURGERY_DONE
				HSSFCell cell985 = detailRow.createCell((short) 88);
				cell985.setCellValue(new HSSFRichTextString(""));

				// for SURGERY_REMARKS
				HSSFCell cell986 = detailRow.createCell((short) 89);
				cell986.setCellValue(new HSSFRichTextString(""));

				row = row + 1;
			}
			// //System.out.println("row======"+row);

			// sheet.addMergedRegion(new Region(9, (short) 3, 9, (short)
			// lastCellNoVisitName));

			map.put("wb", wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// ======================================================

	public Map<String, Object> printMedAdmissionDiagReport(
			Map<String, Object> mapForDs) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		Date fromDate = null;
		Date toDate = null;

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
			//System.out.println("fromDate===-=-=-" + fromDate);
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
			//System.out.println("toDate=-=-=-=-=-=-" + toDate);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fromDateString = sdf.format(fromDate);
		String toDateString = sdf.format(toDate);

		List<Object[]> patientList = new ArrayList<Object[]>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();

		inPatientList = session.createCriteria(Inpatient.class).add(
				Restrictions.ne("AdStatus", "C")).add(
				Restrictions.between("DateOfAddmission", fromDate, toDate))
				.list();
		//System.out.println("inPatientList--" + inPatientList);
		String hospitalName = "CHAFB Command Hospital";

		try {

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("TB_MED_ADMISSION_DIAGNOSIS");

			// Create a new font and alter it.

			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);

			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font2 = wb.createFont();
			font2.setFontHeightInPoints((short) 9);
			font2.setFontName(HSSFFont.FONT_ARIAL);
			font2.setColor((short) 80);
			font2.setItalic(false);
			font2.setStrikeout(false);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// Fonts are set into a style so create a new one to use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);

			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);

			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setFont(font2);
			style2.setAlignment((short) 2);

			// style1.setLocked(true);

			HSSFRow row2 = sheet.createRow((short) 2);
			HSSFCell cell20 = row2.createCell((short) 3);
			cell20.setCellValue(new HSSFRichTextString(hospitalName));
			cell20.setCellStyle(style1);
			sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

			HSSFRow row3 = sheet.createRow((short) 3);
			HSSFCell cell30 = row3.createCell((short) 3);
			cell30.setCellValue(new HSSFRichTextString(
					"Medical Admission Diagnosis"));
			cell30.setCellStyle(style1);
			sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

			HSSFRow row4 = sheet.createRow((short) 4);
			HSSFCell cell40 = row4.createCell((short) 1);
			cell40.setCellStyle(style1);
			cell40.setCellValue(new HSSFRichTextString(""));
			sheet.addMergedRegion(new Region(4, (short) 1, 4, (short) 7));

			HSSFRow row5 = sheet.createRow((short) 5);
			HSSFCell cell51 = row5.createCell((short) 1);
			cell51.setCellValue(new HSSFRichTextString("From  :"));

			HSSFCell cell52 = row5.createCell((short) 3);
			cell52.setCellValue(new HSSFRichTextString(fromDateString));

			HSSFCell cell57 = row5.createCell((short) 4);
			cell57.setCellValue(new HSSFRichTextString("To  :"));

			HSSFCell cell60 = row5.createCell((short) 6);
			cell60.setCellValue(new HSSFRichTextString(toDateString));

			// sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
			// =====Heading Row Start===========================
			HSSFRow headingRow1 = sheet.createRow((short) 7);

			HSSFCell cell70 = headingRow1.createCell((short) 0);
			cell70.setCellValue(new HSSFRichTextString("MEDICAL_UNIT"));
			cell70.setCellStyle(style2);

			HSSFCell cell71 = headingRow1.createCell((short) 1);
			cell71.setCellValue(new HSSFRichTextString("AND_NO"));
			cell71.setCellStyle(style2);

			HSSFCell cell72 = headingRow1.createCell((short) 2);
			cell72.setCellValue(new HSSFRichTextString("DIAGNOSIS_CODE"));
			cell72.setCellStyle(style2);

			HSSFCell cell73 = headingRow1.createCell((short) 3);
			cell73.setCellValue(new HSSFRichTextString("ADMSN_DSCHRG_FLAG"));
			cell73.setCellStyle(style2);

			HSSFCell cell74 = headingRow1.createCell((short) 4);
			cell74.setCellValue(new HSSFRichTextString("ICD_CAUSE_CODE"));
			cell74.setCellStyle(style2);

			HSSFCell cell75 = headingRow1.createCell((short) 5);
			cell75.setCellValue(new HSSFRichTextString("PRIORITY_INDEX"));
			cell75.setCellStyle(style2);

			// ============Heading Completed=======================

			// Region(int rowFrom, short colFrom, int rowTo, short colTo)
			sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

			// Region(int rowFrom, short colFrom, int rowTo, short colTo)
			sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));
			// ================Inserted Value================
			int row = 9;

			for (Inpatient inpatient : inPatientList) {
				Patient patient = inpatient.getHin();
				Set<DischargeIcdCode> dischargeIcdCodeSet = inpatient
						.getDischargeIcdCodes();

				Set<MlcCase> mlcCaseSet = patient.getMlcCases();
				Set<Discharge> dischargeSet = patient.getDischarges();
				HSSFRow detailRow = sheet.createRow((short) row);

				HSSFCell cell90 = detailRow.createCell((short) 0);
				cell90.setCellValue(new HSSFRichTextString("CHAFB"));

				HSSFCell cell91 = detailRow.createCell((short) 1);
				if (inpatient.getAdNo() != null) {
					cell91.setCellValue(new HSSFRichTextString(inpatient
							.getAdNo()));
				}
				String icdCode = "";
				String icdCouseCode = "";

				for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeSet) {
					if (dischargeIcdCode.getIcd() != null) {
						icdCode = icdCode
								+ dischargeIcdCode.getIcd().getIcdCode() + ", ";
					}
					if (dischargeIcdCode.getIcd() != null) {
						icdCouseCode = icdCouseCode
								+ dischargeIcdCode.getIcd().getIcdSubCategory()
										.getIcdSubCategoryName() + " :"
								+ dischargeIcdCode.getIcd().getIcdName() + ", ";
					}
					// //System.out.println("icdCouseCode---"+icdCouseCode);

				}
				HSSFCell cell92 = detailRow.createCell((short) 2);
				cell92.setCellValue(new HSSFRichTextString(icdCode));

				HSSFCell cell93 = detailRow.createCell((short) 3);
				if (inpatient.getAdStatus() != null) {
					cell93.setCellValue(new HSSFRichTextString(inpatient
							.getAdStatus()));

				}

				HSSFCell cell94 = detailRow.createCell((short) 4);
				cell94.setCellValue(new HSSFRichTextString(icdCouseCode));
				sheet.autoSizeColumn((short) 4);
				// for prority
				HSSFCell cell95 = detailRow.createCell((short) 5);
				cell95.setCellValue(new HSSFRichTextString(""));

				row = row + 1;

			}

			map.put("wb", wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	// ====================================================

	public Map<String, Object> printMisBedReport(Map<String, Object> mapForDs){
	    Session session = (Session)getSession();
	    Map<String, Object> map = new HashMap<String, Object>();
		   
	    String month = null;
	    String year = null;
	    String monthString = null;
	    
	    if(mapForDs.get("month") != null){
	    	month = (String)mapForDs.get("month");
	    }
	 //   //System.out.println("month---"+month);
	    if(mapForDs.get("year") != null){
	    	year = (String)mapForDs.get("year");
	     }
	 //   //System.out.println("year---"+year);
	    if(mapForDs.get("monthString") != null){
	    	 monthString = (String)mapForDs.get("monthString");
	    	// //System.out.println("monthString--"+monthString);
	     }
	    
	  java.sql.Connection con = session.connection();
		String sql = "{call misr1("+"'"+ year+"'"+ "," +"'"+ month +"'"+")}";
		try {
			CallableStatement cals= con.prepareCall(sql);
			cals.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		 SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
	///	 String fromDateString = sdf.format(fromDate);
	//	 String toDateString = sdf.format(toDate);
	    
	 //   List<Object[]> patientList = new ArrayList<Object[]>();
	 //   List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<MisMonthlyBedSts> misMonthlyBedStsList = new ArrayList<MisMonthlyBedSts>();
		misMonthlyBedStsList = session.createCriteria(MisMonthlyBedSts.class).list();
	//	//System.out.println("list size here "+misMonthlyBedStsList.size());
		String hospitalName = "Command Hospital Air Force Bangalore";
	
		
		
		try{
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("MIS BED REPORT");
			
			// Create a new font and alter it.
			
			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			HSSFFont font2 = wb.createFont();
			font2.setFontHeightInPoints((short) 9);
			font2.setFontName(HSSFFont.FONT_ARIAL);
			font2.setColor((short) 80);
			font2.setItalic(false);
			font2.setStrikeout(false);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	
			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);
			
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);
			
			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setFont(font2);
			style2.setAlignment((short) 2);
			
			//style1.setLocked(true);
	
				HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));
	
				HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(new HSSFRichTextString("Bed Occupancy Report"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
	
				HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short) 1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 7));
	
				HSSFRow row5 = sheet.createRow((short) 5);
				HSSFCell cell51 = row5.createCell((short) 1);
				cell51.setCellStyle(style);
				cell51.setCellValue(new HSSFRichTextString("Year  :"));

				HSSFCell cell52 = row5.createCell((short) 3);
				cell52.setCellValue(new HSSFRichTextString(year));
				
				HSSFCell cell57 = row5.createCell((short) 4);
				cell57.setCellStyle(style);
				cell57.setCellValue(new HSSFRichTextString("Month :"));

				HSSFCell cell60 = row5.createCell((short) 6);
				cell60.setCellValue(new HSSFRichTextString(monthString));
				
				HSSFRow row6 = sheet.createRow((short) 6);
				HSSFCell cell67 = row6.createCell((short) 6);
				cell67.setCellValue(new HSSFRichTextString("Officers"));
				cell67.setCellStyle(style1);
				
				HSSFCell cell610 = row6.createCell((short) 10);
				cell610.setCellValue(new HSSFRichTextString("Officers Family"));
				cell610.setCellStyle(style1);
				
				HSSFCell cell614 = row6.createCell((short) 14);
				cell614.setCellValue(new HSSFRichTextString("ORS"));
				cell614.setCellStyle(style1);
				
				HSSFCell cell618 = row6.createCell((short) 18);
				cell618.setCellValue(new HSSFRichTextString("ORS Family"));
				cell618.setCellStyle(style1);
				
				sheet.addMergedRegion(new Region(6, (short) 6, 6, (short) 9));
				sheet.addMergedRegion(new Region(6, (short) 10, 6, (short) 13));
				sheet.addMergedRegion(new Region(6, (short) 14, 6, (short) 17));
				sheet.addMergedRegion(new Region(6, (short) 18, 6, (short) 21));
				
				//sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
			  // =====Heading Row Start===========================	
				HSSFRow headingRow1 = sheet.createRow((short) 7);
				
				HSSFCell cell70 = headingRow1.createCell((short) 0);
				cell70.setCellValue(new HSSFRichTextString("Date"));
				cell70.setCellStyle(style2);
				
				HSSFCell cell71 = headingRow1.createCell((short) 1);
				cell71.setCellValue(new HSSFRichTextString("Remd"));
				cell71.setCellStyle(style2);
				
				HSSFCell cell72 = headingRow1.createCell((short) 2);
				cell72.setCellValue(new HSSFRichTextString("Adm"));
				cell72.setCellStyle(style2);
				
				HSSFCell cell73 = headingRow1.createCell((short) 3);
				cell73.setCellValue(new HSSFRichTextString("Dis"));
				cell73.setCellStyle(style2);
				
				HSSFCell cell74 = headingRow1.createCell((short) 4);
				cell74.setCellValue(new HSSFRichTextString("Death"));
				cell74.setCellStyle(style2);
				
				HSSFCell cell75 = headingRow1.createCell((short) 5);
				cell75.setCellStyle(style);
				cell75.setCellValue(new HSSFRichTextString("Total"));
				cell75.setCellStyle(style2);
				
				HSSFCell cell76 = headingRow1.createCell((short) 6);
				cell76.setCellValue(new HSSFRichTextString("AF"));
				cell76.setCellStyle(style2);
				
				HSSFCell cell77 = headingRow1.createCell((short) 7);
				cell77.setCellValue(new HSSFRichTextString("Army"));
				cell77.setCellStyle(style2);
				
				HSSFCell cell78 = headingRow1.createCell((short) 8);
				cell78.setCellValue(new HSSFRichTextString("Navy/CG"));
				cell78.setCellStyle(style2);
				
				HSSFCell cell79 = headingRow1.createCell((short) 9);
				cell79.setCellValue(new HSSFRichTextString("Total"));
				cell79.setCellStyle(style2);
				
				HSSFCell cell710 = headingRow1.createCell((short) 10);
				cell710.setCellValue(new HSSFRichTextString("AF"));
				cell710.setCellStyle(style2);
				
				HSSFCell cell711 = headingRow1.createCell((short) 11);
				cell711.setCellValue(new HSSFRichTextString("Army"));
				cell711.setCellStyle(style2);
				
				HSSFCell cell712 = headingRow1.createCell((short) 12);
				cell712.setCellValue(new HSSFRichTextString("Navy/CG"));
				cell712.setCellStyle(style2);
				
				HSSFCell cell713 = headingRow1.createCell((short) 13);
				cell713.setCellValue(new HSSFRichTextString("Total"));
				cell713.setCellStyle(style2);
				
				HSSFCell cell714 = headingRow1.createCell((short) 14);
				cell714.setCellValue(new HSSFRichTextString("AF"));
				cell714.setCellStyle(style2);
				
				HSSFCell cell715 = headingRow1.createCell((short) 15);
				cell715.setCellValue(new HSSFRichTextString("Army"));
				cell715.setCellStyle(style2);
				
				HSSFCell cell716 = headingRow1.createCell((short) 16);
				cell716.setCellValue(new HSSFRichTextString("Navy/CG"));
				cell716.setCellStyle(style2);
				
				HSSFCell cell717 = headingRow1.createCell((short) 17);
				cell717.setCellValue(new HSSFRichTextString("Total"));
				cell717.setCellStyle(style2);
				
				HSSFCell cell718 = headingRow1.createCell((short) 18);
				cell718.setCellValue(new HSSFRichTextString("AF"));
				cell718.setCellStyle(style2);
				
				HSSFCell cell719 = headingRow1.createCell((short) 19);
				cell719.setCellValue(new HSSFRichTextString("Army"));
				cell719.setCellStyle(style2);
				
				HSSFCell cell720 = headingRow1.createCell((short) 20);
				cell720.setCellValue(new HSSFRichTextString("Navy/CG"));
				cell720.setCellStyle(style2);
				
				HSSFCell cell721 = headingRow1.createCell((short) 21);
				cell721.setCellValue(new HSSFRichTextString("Total"));
				cell721.setCellStyle(style2);
				
				HSSFCell cell722 = headingRow1.createCell((short) 22);
				cell722.setCellValue(new HSSFRichTextString("AF"));
				cell722.setCellStyle(style2);
				
				HSSFCell cell723 = headingRow1.createCell((short) 23);
				cell723.setCellValue(new HSSFRichTextString("Army"));
				cell723.setCellStyle(style2);
				
				HSSFCell cell724 = headingRow1.createCell((short) 24);
				cell724.setCellValue(new HSSFRichTextString("Navy/CG"));
				cell724.setCellStyle(style2);
				
				HSSFCell cell725 = headingRow1.createCell((short) 25);
				cell725.setCellValue(new HSSFRichTextString("CE/NE"));
				cell725.setCellStyle(style2);
				
				HSSFCell cell726 = headingRow1.createCell((short) 26);
				cell726.setCellValue(new HSSFRichTextString("Forg"));
				cell726.setCellStyle(style2);
				
				HSSFCell cell727 = headingRow1.createCell((short) 27);
				cell727.setCellValue(new HSSFRichTextString("Total"));
				cell727.setCellStyle(style2);
				
				
				
								
				//============Heading Completed=======================

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
			//	sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

				

				

				
				//sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));
		//================Inserted Value================		
			int row = 9;
			int rmd =0;
			int adm =0;
			int dis =0;
			int death =0;
			int count = 0;
			int lastRow=misMonthlyBedStsList.size()+10;
			int calcRow = lastRow + 1;
			for(MisMonthlyBedSts misMonthlyBedSts : misMonthlyBedStsList){
				rmd =0;
				adm =0;
				dis =0;
				death =0;
				count++;
				HSSFRow detailRow = sheet.createRow((short) row);
				HSSFCell cell90 = detailRow.createCell((short) 0);
				if(misMonthlyBedSts.getMDate() != null){
				/*	cell90.setCellValue(new HSSFRichTextString(sdf.format(misMonthlyBedSts.getMDate()))); */
					cell90.setCellValue((int)count);
				}	
	
				
				HSSFCell cell91 = detailRow.createCell((short) 1);
				if(misMonthlyBedSts.getRemd() != null){
					cell91.setCellValue((int)misMonthlyBedSts.getRemd());
					rmd = misMonthlyBedSts.getRemd();
				}
	
				
				HSSFCell cell92 = detailRow.createCell((short) 2);
				if(misMonthlyBedSts.getAdm() != null){
					cell92.setCellValue(misMonthlyBedSts.getAdm());
					adm =misMonthlyBedSts.getAdm();
				}
				else{
					cell92.setCellValue(0);
				}
					
	
				
				HSSFCell cell93 = detailRow.createCell((short) 3);
				if(misMonthlyBedSts.getDis() != null){
					cell93.setCellValue(misMonthlyBedSts.getDis());
					dis = misMonthlyBedSts.getDis();
				}
				else {
					cell93.setCellValue(0);
				}
				
				HSSFCell cell94 = detailRow.createCell((short) 4);
				int dt =0;
				if(misMonthlyBedSts.getDeath() != null){
					dt = misMonthlyBedSts.getDeath();
					death = misMonthlyBedSts.getDeath();
				}
				cell94.setCellValue(dt);
				dt = 0;
				
				HSSFCell cell95 = detailRow.createCell((short) 5);
				if(misMonthlyBedSts.getTot() != null){
					cell95.setCellValue(rmd+adm-dis-death);
				}
								
				HSSFCell cell96 = detailRow.createCell((short) 6);
				if(misMonthlyBedSts.getOffAf()!= null){
					cell96.setCellValue(misMonthlyBedSts.getOffAf());	
				}
				
				HSSFCell cell97 = detailRow.createCell((short) 7);
				if(misMonthlyBedSts.getOffArm() != null){
					cell97.setCellValue(misMonthlyBedSts.getOffArm());	
				}
				
				HSSFCell cell98 = detailRow.createCell((short) 8);
				if(misMonthlyBedSts.getOffNav() != null){
					cell98.setCellValue(misMonthlyBedSts.getOffNav());	
				}
				
				HSSFCell cell99 = detailRow.createCell((short) 9);
				if(misMonthlyBedSts.getOffTot() != null){
					cell99.setCellValue(misMonthlyBedSts.getOffTot());	
				}
				
				HSSFCell cell910 = detailRow.createCell((short) 10);
				if(misMonthlyBedSts.getOffFamAf() != null){
					cell910.setCellValue(misMonthlyBedSts.getOffFamAf());
				}
			
				HSSFCell cell911 = detailRow.createCell((short) 11);
				if(misMonthlyBedSts.getOffFamArm() != null){
					cell911.setCellValue(misMonthlyBedSts.getOffFamArm());	
				}
					
				HSSFCell cell912 = detailRow.createCell((short) 12);
				if(misMonthlyBedSts.getOffFamNav() != null){
					cell912.setCellValue(misMonthlyBedSts.getOffFamNav());	
				}
				
				HSSFCell cell913 = detailRow.createCell((short) 13);
				if(misMonthlyBedSts.getOffFamTot() != null){
					cell913.setCellValue(misMonthlyBedSts.getOffFamTot());	
				}
				
				HSSFCell cell914 = detailRow.createCell((short) 14);
				if(misMonthlyBedSts.getOrsAf() != null){
					cell914.setCellValue(misMonthlyBedSts.getOrsAf());	
				}	
				
				HSSFCell cell915 = detailRow.createCell((short) 15);
				if(misMonthlyBedSts.getOrsArm() != null){
					cell915.setCellValue(misMonthlyBedSts.getOrsArm());	
				}
				
				HSSFCell cell916 = detailRow.createCell((short) 16);
				if(misMonthlyBedSts.getOrsNav() != null ){
					cell916.setCellValue(misMonthlyBedSts.getOrsNav());	
				}	
				
				HSSFCell cell917 = detailRow.createCell((short) 17);
				if(misMonthlyBedSts.getOrsTot() != null){
					cell917.setCellValue(misMonthlyBedSts.getOrsTot());	
				}
				
				HSSFCell cell918 = detailRow.createCell((short) 18);
				if(misMonthlyBedSts.getOrsFamAf() != null){
					cell918.setCellValue(misMonthlyBedSts.getOrsFamAf());	
				}
				
				HSSFCell cell919 = detailRow.createCell((short) 19);
				if(misMonthlyBedSts.getOrsFamArm() != null){
					cell919.setCellValue(misMonthlyBedSts.getOrsFamArm());	
				}
				
				HSSFCell cell920 = detailRow.createCell((short) 20);
				if(misMonthlyBedSts.getOrsFamNav() != null){
					cell920.setCellValue(misMonthlyBedSts.getOrsFamNav());	
				}
					
				HSSFCell cell921 = detailRow.createCell((short) 21);
				if(misMonthlyBedSts.getOrsFamTot() != null){
					cell921.setCellValue(misMonthlyBedSts.getOrsFamTot());	
				}
				
				HSSFCell cell922 = detailRow.createCell((short) 22);
				if(misMonthlyBedSts.getTotAf() != null){
					cell922.setCellValue(misMonthlyBedSts.getTotAf());	
				}
				
				HSSFCell cell923 = detailRow.createCell((short) 23);
				if(misMonthlyBedSts.getTotArm() != null){
					cell923.setCellValue(misMonthlyBedSts.getTotArm());	
				}
				
				HSSFCell cell924 = detailRow.createCell((short) 24);
				if(misMonthlyBedSts.getTotNav() != null){
					cell924.setCellValue(misMonthlyBedSts.getTotNav());	
				}
				
				HSSFCell cell925 = detailRow.createCell((short) 25);
				if(misMonthlyBedSts.getTotCene() != null){
					cell925.setCellValue(misMonthlyBedSts.getTotCene());	
				}
				
				HSSFCell cell926 = detailRow.createCell((short) 26);
				if(misMonthlyBedSts.getTotFor() != null){
					cell926.setCellValue(misMonthlyBedSts.getTotFor());	
				}
				
				HSSFCell cell927 = detailRow.createCell((short) 27);
				if(misMonthlyBedSts.getTotal() != null){
					cell927.setCellValue(rmd+adm-dis-death);	
				}
				
			row = row + 1;	
			}
            ////System.out.println("row======"+row);
			HSSFRow detailRow = sheet.createRow((short) row+1);
			
			HSSFCell cell100 = detailRow.createCell((short) 0);
			cell100.setCellValue(new HSSFRichTextString("Total"));
			
			HSSFCell cell101 = detailRow.createCell((short) 1);
			cell101.setCellFormula("SUM(B10:B"+lastRow+")");
			
			HSSFCell cell102 = detailRow.createCell((short) 2);
			cell102.setCellFormula("SUM(C10:C"+lastRow+")");
			
			HSSFCell cell103 = detailRow.createCell((short) 3);
			cell103.setCellFormula("SUM(D10:D"+lastRow+")");
			
			HSSFCell cell104 = detailRow.createCell((short) 4);
			cell104.setCellFormula("SUM(e10:e"+lastRow+")");
			
			HSSFCell cell105 = detailRow.createCell((short) 5);
			cell105.setCellFormula("SUM(f10:f"+lastRow+")");
			
			HSSFCell cell106 = detailRow.createCell((short) 6);
			cell106.setCellFormula("SUM(g10:g"+lastRow+")");
			
			HSSFCell cell107 = detailRow.createCell((short) 7);
			cell107.setCellFormula("SUM(h10:h"+lastRow+")");
			
			HSSFCell cell108 = detailRow.createCell((short) 8);
			cell108.setCellFormula("SUM(i10:i"+lastRow+")");
			
			HSSFCell cell109 = detailRow.createCell((short) 9);
			cell109.setCellFormula("SUM(j10:j"+lastRow+")");
			
			HSSFCell cell110 = detailRow.createCell((short) 10);
			cell110.setCellFormula("SUM(k10:k"+lastRow+")");
			
			HSSFCell cell111 = detailRow.createCell((short) 11);
			cell111.setCellFormula("SUM(l10:l"+lastRow+")");
			
			HSSFCell cell112 = detailRow.createCell((short) 12);
			cell112.setCellFormula("SUM(m10:m"+lastRow+")");
			
			HSSFCell cell113 = detailRow.createCell((short) 13);
			cell113.setCellFormula("SUM(n10:n"+lastRow+")");
			
			HSSFCell cell114 = detailRow.createCell((short) 14);
			cell114.setCellFormula("SUM(o10:o"+lastRow+")");
			
			HSSFCell cell115 = detailRow.createCell((short) 15);
			cell115.setCellFormula("SUM(p10:p"+lastRow+")");
			
			HSSFCell cell116 = detailRow.createCell((short) 16);
			cell116.setCellFormula("SUM(q10:q"+lastRow+")");
			
			HSSFCell cell117 = detailRow.createCell((short) 17);
			cell117.setCellFormula("SUM(r10:r"+lastRow+")");
			
			HSSFCell cell118 = detailRow.createCell((short) 18);
			cell118.setCellFormula("SUM(s10:s"+lastRow+")");
			
			HSSFCell cell119 = detailRow.createCell((short) 19);
			cell119.setCellFormula("SUM(t10:t"+lastRow+")");
			
			HSSFCell cell120 = detailRow.createCell((short) 20);
			cell120.setCellFormula("SUM(u10:u"+lastRow+")");
			
			HSSFCell cell121 = detailRow.createCell((short) 21);
			cell121.setCellFormula("SUM(v10:v"+lastRow+")");
			
			HSSFCell cell122 = detailRow.createCell((short) 22);
			cell122.setCellFormula("SUM(w10:w"+lastRow+")");
			
			HSSFCell cell123 = detailRow.createCell((short) 23);
			cell123.setCellFormula("SUM(x10:x"+lastRow+")");
			
			HSSFCell cell124 = detailRow.createCell((short) 24);
			cell124.setCellFormula("SUM(y10:y"+lastRow+")");
			
			HSSFCell cell125 = detailRow.createCell((short) 25);
			cell125.setCellFormula("SUM(z10:z"+lastRow+")");
			
			HSSFCell cell126 = detailRow.createCell((short) 26);
			cell126.setCellFormula("SUM(aa10:aa"+lastRow+")");
			
			HSSFCell cell127 = detailRow.createCell((short) 27);
			cell127.setCellFormula("SUM(ab10:ab"+lastRow+")");
			
			// for Summary data
			row = row + 4;
			HSSFRow summaryRow1 = sheet.createRow((short) row);
			
			HSSFCell cell128 = summaryRow1.createCell((short) 5);
			cell128.setCellStyle(style);
			cell128.setCellValue(new HSSFRichTextString("Summary Of The Month "+monthString+" "+year));
			row = row + 2;

			HSSFRow summaryRow2 = sheet.createRow((short) row);
			HSSFCell cell129 = summaryRow2.createCell((short) 2);
			cell129.setCellValue(new HSSFRichTextString("Officer Max"));
			
			HSSFCell cell130 = summaryRow2.createCell((short) 8);
			cell130.setCellFormula("ROUND(MAX(J10:J"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow3 = sheet.createRow((short) row);
			HSSFCell cell131 = summaryRow3.createCell((short) 2);
			cell131.setCellValue(new HSSFRichTextString("Officer Average"));

			HSSFCell cell132 = summaryRow3.createCell((short) 8);
			cell132.setCellFormula("ROUND(AVERAGE(J10:J"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow4 = sheet.createRow((short) row);
			HSSFCell cell133 = summaryRow4.createCell((short) 2);
			cell133.setCellValue(new HSSFRichTextString("Officer Family Max"));

			HSSFCell cell134 = summaryRow4.createCell((short) 8);
			cell134.setCellFormula("ROUND(MAX(N10:N"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow5 = sheet.createRow((short) row);
			HSSFCell cell135 = summaryRow5.createCell((short) 2);
			cell135.setCellValue(new HSSFRichTextString("Officer Family Average"));

			HSSFCell cell136 = summaryRow5.createCell((short) 8);
			cell136.setCellFormula("ROUND(AVERAGE(N10:N"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow6 = sheet.createRow((short) row);
			HSSFCell cell137 = summaryRow6.createCell((short) 2);
			cell137.setCellValue(new HSSFRichTextString("ORS"));

			HSSFCell cell138 = summaryRow6.createCell((short) 8);
			cell138.setCellFormula("MAX(R10:R"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow7 = sheet.createRow((short) row);
			HSSFCell cell139 = summaryRow7.createCell((short) 2);
			cell139.setCellValue(new HSSFRichTextString("ORS Average"));

			HSSFCell cell140 = summaryRow7.createCell((short) 8);
			cell140.setCellFormula("ROUND(AVERAGE(R10:R"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow8 = sheet.createRow((short) row);
			HSSFCell cell141 = summaryRow8.createCell((short) 2);
			cell141.setCellValue(new HSSFRichTextString("ORS Family Max"));

			HSSFCell cell142 = summaryRow8.createCell((short) 8);
			cell142.setCellFormula("MAX(V10:V"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow9 = sheet.createRow((short) row);
			HSSFCell cell143 = summaryRow9.createCell((short) 2);
			cell143.setCellValue(new HSSFRichTextString("ORS Family Average"));

			HSSFCell cell144 = summaryRow9.createCell((short) 8);
			cell144.setCellFormula("ROUND(AVERAGE(V10:V"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow10 = sheet.createRow((short) row);
			HSSFCell cell145 = summaryRow10.createCell((short) 2);
			cell145.setCellValue(new HSSFRichTextString("AF Max"));

			HSSFCell cell146 = summaryRow10.createCell((short) 8);
			cell146.setCellFormula("MAX(W10:W"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow11 = sheet.createRow((short) row);
			HSSFCell cell147 = summaryRow11.createCell((short) 2);
			cell147.setCellValue(new HSSFRichTextString("AF Min"));

			HSSFCell cell148 = summaryRow11.createCell((short) 8);
			cell148.setCellFormula("MIN(W10:W"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow12 = sheet.createRow((short) row);
			HSSFCell cell149 = summaryRow12.createCell((short) 2);
			cell149.setCellValue(new HSSFRichTextString("AF Average"));

			HSSFCell cell150 = summaryRow12.createCell((short) 8);
			cell150.setCellFormula("ROUND(AVERAGE(W10:W"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow13 = sheet.createRow((short) row);
			HSSFCell cell151 = summaryRow13.createCell((short) 2);
			cell151.setCellValue(new HSSFRichTextString("Army Max"));

			HSSFCell cell152 = summaryRow13.createCell((short) 8);
			cell152.setCellFormula("MAX(x10:x"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow14 = sheet.createRow((short) row);
			HSSFCell cell153 = summaryRow14.createCell((short) 2);
			cell153.setCellValue(new HSSFRichTextString("Army Min"));

			HSSFCell cell154 = summaryRow14.createCell((short) 8);
			cell154.setCellFormula("MIN(x10:x"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow15 = sheet.createRow((short) row);
			HSSFCell cell155 = summaryRow15.createCell((short) 2);
			cell155.setCellValue(new HSSFRichTextString("Army Average"));

			HSSFCell cell156 = summaryRow15.createCell((short) 8);
			cell156.setCellFormula("ROUND(AVERAGE(x10:x"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow16 = sheet.createRow((short) row);
			HSSFCell cell157 = summaryRow16.createCell((short) 2);
			cell157.setCellValue(new HSSFRichTextString("Navy Max"));

			HSSFCell cell158 = summaryRow16.createCell((short) 8);
			cell158.setCellFormula("MAX(y10:y"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow17 = sheet.createRow((short) row);
			HSSFCell cell159 = summaryRow17.createCell((short) 2);
			cell159.setCellValue(new HSSFRichTextString("Navy Min"));

			HSSFCell cell160 = summaryRow17.createCell((short) 8);
			cell160.setCellFormula("MIN(y10:y"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow18 = sheet.createRow((short) row);
			HSSFCell cell161 = summaryRow18.createCell((short) 2);
			cell161.setCellValue(new HSSFRichTextString("Navy Average"));

			HSSFCell cell162 = summaryRow18.createCell((short) 8);
			cell162.setCellFormula("ROUND(AVERAGE(y10:y"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow19 = sheet.createRow((short) row);
			HSSFCell cell163 = summaryRow19.createCell((short) 2);
			cell163.setCellValue(new HSSFRichTextString("Total No of Death"));

			HSSFCell cell164 = summaryRow19.createCell((short) 8);
			cell164.setCellFormula("SUM(E10:E"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow20 = sheet.createRow((short) row);
			HSSFCell cell165 = summaryRow20.createCell((short) 2);
			cell165.setCellValue(new HSSFRichTextString("Average of Death"));

			HSSFCell cell166 = summaryRow20.createCell((short) 8);
			cell166.setCellFormula("ROUND(average(E10:E"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow21 = sheet.createRow((short) row);
			HSSFCell cell167 = summaryRow21.createCell((short) 2);
			cell167.setCellValue(new HSSFRichTextString("Total No of Admission"));

			HSSFCell cell168 = summaryRow21.createCell((short) 8);
			cell168.setCellFormula("SUM(C10:C"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow22 = sheet.createRow((short) row);
			HSSFCell cell169 = summaryRow22.createCell((short) 2);
			cell169.setCellValue(new HSSFRichTextString("Average Admission"));

			HSSFCell cell170 = summaryRow22.createCell((short) 8);
			cell170.setCellFormula("ROUND(average(C10:C"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow23 = sheet.createRow((short) row);
			HSSFCell cell171 = summaryRow23.createCell((short) 2);
			cell171.setCellValue(new HSSFRichTextString("Total No of Discharge"));

			HSSFCell cell172 = summaryRow23.createCell((short) 8);
			cell172.setCellFormula("sum(d10:d"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow24 = sheet.createRow((short) row);
			HSSFCell cell173 = summaryRow24.createCell((short) 2);
			cell173.setCellValue(new HSSFRichTextString("Average Discharge"));

			HSSFCell cell174 = summaryRow24.createCell((short) 8);
			cell174.setCellFormula("ROUND(average(d10:d"+lastRow+"),2)");
			
			row = row + 1;
			HSSFRow summaryRow25 = sheet.createRow((short) row);
			HSSFCell cell175 = summaryRow25.createCell((short) 2);
			cell175.setCellValue(new HSSFRichTextString("Average Stay of Pat"));

			HSSFCell cell176 = summaryRow25.createCell((short) 8);
		//	cell176.setCellValue(new HSSFRichTextString(""));
			cell176.setCellFormula("ROUND((F"+calcRow+" / sum(d"+calcRow+" + e"+calcRow+")),2)");
			
			row = row + 1;
			HSSFRow summaryRow26 = sheet.createRow((short) row);
			HSSFCell cell177 = summaryRow26.createCell((short) 2);
			cell177.setCellValue(new HSSFRichTextString("Occupancy Rate"));

			HSSFCell cell178 = summaryRow26.createCell((short) 8);
			cell178.setCellFormula("ROUND(((F"+calcRow+"*100)/(800 * "+(calcRow-11)+")),2)");
			
			row = row + 1;
			HSSFRow summaryRow27 = sheet.createRow((short) row);
			HSSFCell cell179 = summaryRow27.createCell((short) 2);
			cell179.setCellValue(new HSSFRichTextString("Min Bed Occupied"));

			HSSFCell cell180 = summaryRow27.createCell((short) 8);
			cell180.setCellFormula("MIN(AB10:AB"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow28 = sheet.createRow((short) row);
			HSSFCell cell181 = summaryRow28.createCell((short) 2);
			cell181.setCellValue(new HSSFRichTextString("Max Bed Occupied"));

			HSSFCell cell182 = summaryRow28.createCell((short) 8);
			cell182.setCellFormula("max(AB10:AB"+lastRow+")");
			
			row = row + 1;
			HSSFRow summaryRow29 = sheet.createRow((short) row);
			HSSFCell cell183 = summaryRow29.createCell((short) 2);
			cell183.setCellValue(new HSSFRichTextString("Internal Turnover"));

			HSSFCell cell184 = summaryRow29.createCell((short) 8);
			cell184.setCellFormula("ROUND(((800*"+(calcRow -11)+")-F"+calcRow+")/(D"+calcRow+" + E"+calcRow+"),2)");
			
			
			
			
		//	sheet.addMergedRegion(new Region(9, (short) 3, 9, (short) lastCellNoVisitName));
			
			map.put("wb", wb);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
   }

}
