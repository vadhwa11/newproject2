package jkt.hms.hr.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasDesignation;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPersonnelDetails;
import jkt.hms.masters.business.MasPersonnelFamilyDetails;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.PensionCalculationSheet;
import jkt.hms.masters.business.PensionDataSheet;
import jkt.hms.masters.business.PensionEmoluments;
import jkt.hms.masters.business.PensionEol;
import jkt.hms.masters.business.PensionForm7Details;
import jkt.hms.masters.business.PensionForm7EmolumentsDetail;
import jkt.hms.masters.business.PensionForm8Entry;
import jkt.hms.masters.business.PensionOtherServices;
import jkt.hms.masters.business.PensionRetirementEntry;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PensionRelatedDataServiceImpl extends HibernateDaoSupport
		implements PensionRelatedDataService {
	Session session;

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPersonnelEntryDetailsJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		List<MasReligion> religionList = new ArrayList<MasReligion>();
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		try {

			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).add(Restrictions.eq("DependentUnit", "y")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();
			religionList = session.createCriteria(MasReligion.class).add(
					Restrictions.eq("Status", "y")).list();
			genderList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("unitList", unitList);
		map.put("relationList", relationList);
		map.put("designationList", designationList);
		map.put("religionList", religionList);
		map.put("genderList", genderList);

		return map;

	}

	@SuppressWarnings("unchecked")
public Map<String, Object> submitPersonnelEntryDetailsJsp(Box box,
			Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		boolean alreadyAdded = false;
		String ac_no = null;
		Integer passNo = 0;
		String p_name = null;
		String fat_or_hus = null;
		int desi_id = 0;
		List<MasPersonnelDetails> masChkPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		
		Session session = (Session) getSession();
		List<String> familyNameList = (List<String>) dataMap
				.get("familyNameList");
		List<Integer> relationIdList = (List<Integer>) dataMap
				.get("relationIdList");
		List<String> dateOfBirthList = (List<String>) dataMap
				.get("dateOfBirthList");
		List<String> isNomineeList = (List<String>) dataMap
				.get("isNomineeList");
		List<String> nomineePercentList = (List<String>) dataMap
				.get("nomineePercentList");
		List<Integer> heightsList = (List<Integer>) dataMap.get("heightsList");
		List<String> identificationMarkList = (List<String>) dataMap
				.get("identificationMarkList");
		int hospitalId = (Integer) dataMap.get("hospitalId");

		Transaction tx = null;
		ac_no = box.get("acNo");
		passNo = box.getInt("passNo");
		p_name =box.getString("personnelName");
		fat_or_hus = box.getString("fatherOrHusband");
		desi_id = box.getInt("designationId");
		int unit_id = box.getInt("unit");
		masChkPersonnelDetailsList = session.createCriteria(MasPersonnelDetails.class)
		        .add(Restrictions.eq("PassNo", passNo))
				.createAlias("Unit", "ut").add(Restrictions.eq("ut.Id", unit_id)).list();
		
		if(masChkPersonnelDetailsList != null && masChkPersonnelDetailsList.size() > 0){
			alreadyAdded = true;
		}
		else{
			alreadyAdded = false;
		}
			
		if(masChkPersonnelDetailsList.size() == 0){
		
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			//System.out.println("personnel name===="+ box.getString("personnelName"));
			masPersonnelDetails
					.setPersonnelName(box.getString("personnelName"));
			masPersonnelDetails.setPresentAddress(box.get("presentAddress"));
			masPersonnelDetails.setBankAcNo(box.get("acNo"));
			masPersonnelDetails.setPassNo(box.getInt("passNo"));
			masPersonnelDetails.setHeight(box.getInt("height"));
			MasUnit masUnit = new MasUnit();
			masUnit.setId(box.getInt("unit"));
			masPersonnelDetails.setUnit(masUnit);
			masPersonnelDetails.setSfx(box.getString("sfx"));
			masPersonnelDetails.setPresentPin(box.getInt("presentPin"));
			masPersonnelDetails.setIdentificationMark(box
					.getString("identificationMark"));
			MasDesignation masDesignation = new MasDesignation();
			masDesignation.setId(box.getInt("designationId"));
			masPersonnelDetails.setDesignation(masDesignation);
			masPersonnelDetails.setPermanentAddress(box
					.getString("permanentAddress"));
			masPersonnelDetails.setPermanentPin(box.getInt("permanentPin"));
			masPersonnelDetails
					.setPersonnelName(box.getString("personnelName"));
			masPersonnelDetails.setBankAddress(box.getString("bankAddress"));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(box.getInt("genderId"));
			masPersonnelDetails.setAdministrativeSex(masAdministrativeSex);
			masPersonnelDetails.setFatherHusbandName(box
					.getString("fatherOrHusband"));

			MasReligion masReligion = new MasReligion();
			masReligion.setId(box.getInt("religionId"));
			masPersonnelDetails.setReligion(masReligion);
			masPersonnelDetails.setPayScale(box.getString("payScale"));
			if (box.getString("birthDate") != null
					&& !box.getString("birthDate").equals(""))
				masPersonnelDetails.setDateOfBirth(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("birthDate")));
			if (box.getString("appointmentDate") != null
					&& !box.getString("appointmentDate").equals(""))
				masPersonnelDetails.setAppointmentDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("appointmentDate")));
			if (box.getString("marriageDate") != null
					&& !box.getString("marriageDate").equals(""))
				masPersonnelDetails.setMarriageDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("marriageDate")));
			if (box.getString("postingInDate") != null
					&& !box.getString("postingInDate").equals(""))
				masPersonnelDetails.setPostingIn(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("postingInDate")));
			if (box.getString("postedOutDate") != null
					&& !box.getString("postedOutDate").equals(""))
				masPersonnelDetails.setPostedOut(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("postedOutDate")));
			if (box.getString("retirementDate") != null
					&& !box.getString("retirementDate").equals(""))
				masPersonnelDetails.setRetirementDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("retirementDate")));
			if (box.getString("incrementDate") != null
					&& !box.getString("incrementDate").equals(""))
				masPersonnelDetails.setIncrementDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("incrementDate")));
			masPersonnelDetails.setTotalServiceWithoutEolYears(box
					.getInt("serviceYears"));
			masPersonnelDetails.setTotalServiceWithoutEolMonths(box
					.getInt("serviceMonths"));
			masPersonnelDetails.setTotalServiceWithoutEolDays(box
					.getInt("serviceDays"));
			masPersonnelDetails.setDataSheetStatus("o");
			masPersonnelDetails.setCalculationSheetStatus("o");
			masPersonnelDetails.setForm7Status("o");
			masPersonnelDetails.setForm8Status("o");
			masPersonnelDetails.setRetirementEntryStatus("o");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masPersonnelDetails.setHospital(masHospital);
			masPersonnelDetails.setLastChgBy(box.getString("changed_by"));
			masPersonnelDetails.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			masPersonnelDetails.setLastChgTime(box.getString("changed_time"));
			hbt.save(masPersonnelDetails);

			Iterator itr = familyNameList.iterator();
			for (int i = 0; i < familyNameList.size(); i++) {
				String isNominee = "";
				String familyName = (String) familyNameList.get(i);
				if (!familyName.trim().equals("")) {
					MasPersonnelFamilyDetails masPersonnelFamilyDetails = new MasPersonnelFamilyDetails();
					masPersonnelFamilyDetails.setFamilyName(familyName);
					MasRelation masRelation = new MasRelation();
					masRelation.setId(relationIdList.get(i));
					masPersonnelFamilyDetails.setRelation(masRelation);
					masPersonnelFamilyDetails.setDateOfBirth(HMSUtil
							.convertStringTypeDateToDateType(dateOfBirthList
									.get(i)));
					if (isNomineeList.get(i) != null) {
						isNominee = "y";

						if (nomineePercentList.get(i) != null
								&& !nomineePercentList.get(i).equals(""))
							masPersonnelFamilyDetails
									.setNomineePercent(new BigDecimal(
											nomineePercentList.get(i)));
						else
							masPersonnelFamilyDetails
									.setNomineePercent(new BigDecimal("0"));

					} else {
						isNominee = "n";
						masPersonnelFamilyDetails
								.setNomineePercent(new BigDecimal("0"));
					}

					masPersonnelFamilyDetails.setNominee(isNominee);
					masPersonnelFamilyDetails.setHeight(heightsList.get(i));
					masPersonnelFamilyDetails
							.setIdentificationMark(identificationMarkList
									.get(i));
					masPersonnelFamilyDetails.setPersonnel(masPersonnelDetails);
					masPersonnelFamilyDetails.setLastChgBy(box
							.getString("changed_by"));
					masPersonnelFamilyDetails.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("changed_date")));
					masPersonnelFamilyDetails.setLastChgTime(box
							.getString("changed_time"));
					hbt.save(masPersonnelFamilyDetails);

				}

			}

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			successfullyAdded = false;

		} finally {
			// --------Session Closing----------
			session.close();
		}
	}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successfullyAdded",successfullyAdded );
		map.put("alreadyAdded",alreadyAdded);
	
	return map;
		
	}
	public Map<String , Object> EmployeeExist(String passNo, int unitId) {

		boolean flag = false;
		Map<String , Object> returnMap = new HashMap<String , Object>();
		Session session = (Session) getSession();
		List<MasPersonnelDetails> masemployeelist = new ArrayList<MasPersonnelDetails>();
		masemployeelist = session.createCriteria(MasPersonnelDetails.class)
                          .add(Restrictions.eq("PassNo", Integer.parseInt(passNo)))
		                  .createAlias("Unit", "ut").add(Restrictions.eq("ut.Id", unitId)).list();
		if (masemployeelist == null || masemployeelist.size() == 0) {
			flag = true;
		}
		returnMap.put("flag", flag);
		returnMap.put("masEmployeeList",masemployeelist);

		return returnMap;
	}

	public Map<String, Object> showPersonnelSearchJsp(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> personnelDetailList = new ArrayList<MasPersonnelDetails>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		String jspName = "";
		if (dataMap.get("personnelName") != null) {
			personnelName = (String) dataMap.get("personnelName");
		}
		if (dataMap.get("passNo") != null) {
			passNo = (Integer) dataMap.get("passNo");
		}
		if (dataMap.get("unitId") != null) {
			unitId = (Integer) dataMap.get("unitId");
		}
		if (dataMap.get("designationId") != null) {
			designationId = (Integer) dataMap.get("designationId");
		}
		if (dataMap.get("jspName") != null) {
			jspName = (String) dataMap.get("jspName");
		}
		try {
			Criteria crit = null;
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();
			if (jspName.equals("DataSheet"))
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("DataSheetStatus", "o"));
			else
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("CalculationSheetStatus", "o"));

			if (personnelName != "") {
				crit = crit.add(Restrictions.like("PersonnelName",
						personnelName + "%"));

			}
			if (passNo != 0) {
				crit = crit.add(Restrictions.eq("PassNo", passNo));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (designationId != 0) {
				crit = crit.createAlias("Designation", "designation").add(
						Restrictions.eq("designation.Id", designationId));
			}
			personnelDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("personnelDetailList", personnelDetailList);
		map.put("unitList", unitList);
		map.put("designationList", designationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUpdatePersonnelSearchJsp(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		List<MasReligion> religionList = new ArrayList<MasReligion>();
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		List<MasPersonnelFamilyDetails> masPersonnelFamilyDetailsList = new ArrayList<MasPersonnelFamilyDetails>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("DependentUnit", "y")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();
			religionList = session.createCriteria(MasReligion.class).add(
					Restrictions.eq("Status", "y")).list();
			genderList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y")).list();
			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();
			masPersonnelFamilyDetailsList = session.createCriteria(
					MasPersonnelFamilyDetails.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masPersonnelDetailsList", masPersonnelDetailsList);
		map.put("unitList", unitList);
		map.put("relationList", relationList);
		map.put("designationList", designationList);
		map.put("religionList", religionList);
		map.put("genderList", genderList);
		map.put("masPersonnelFamilyDetailsList", masPersonnelFamilyDetailsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updatePersonnelEntryDetailsJsp(Box box,
			Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		
		boolean alreadyAdded = false;
		String ac_no = null;
		Integer passNo = 0;
		String p_name = null;
		String fat_or_hus = null;
		int desi_id = 0;
		List<MasPersonnelDetails> masChkPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		List<String> familyNameList = (List<String>) dataMap
				.get("familyNameList");
		List<Integer> relationIdList = (List<Integer>) dataMap
				.get("relationIdList");
		List<String> dateOfBirthList = (List<String>) dataMap
				.get("dateOfBirthList");
		List<String> isNomineeList = (List<String>) dataMap
				.get("isNomineeList");
		List<String> nomineePercentList = (List<String>) dataMap
				.get("nomineePercentList");
		List<Integer> heightsList = (List<Integer>) dataMap.get("heightsList");
		List<String> identificationMarkList = (List<String>) dataMap
				.get("identificationMarkList");
		int personnelId = (Integer) dataMap.get("personnelId");
		
		ac_no = box.get("acNo");
		passNo = box.getInt("passNo");
		p_name =box.getString("personnelName");
		fat_or_hus = box.getString("fatherOrHusband");
		desi_id = box.getInt("designationId");
		/*masChkPersonnelDetailsList = session.createCriteria(MasPersonnelDetails.class)
        .add(Restrictions.eq("BankAcNo", ac_no)).add(Restrictions.eq("PersonnelName", p_name))
		.add(Restrictions.eq("FatherHusbandName", fat_or_hus))
		.add(Restrictions.eq("PassNo", passNo))
		.add(Restrictions.eq("Designation.Id", desi_id)).list();*/

		if(masChkPersonnelDetailsList != null && masChkPersonnelDetailsList.size() > 0){
			alreadyAdded = true;
		}
		else{
			alreadyAdded = false;
		}
		
		if(masChkPersonnelDetailsList.size() == 0)
		{

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<MasPersonnelFamilyDetails> maspList = session.createCriteria(
					MasPersonnelFamilyDetails.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			hbt.deleteAll(maspList);
			
			

			MasPersonnelDetails masPersonnelDetails = (MasPersonnelDetails) hbt
					.load(MasPersonnelDetails.class, personnelId);
			//System.out.println("personnel name===="+ box.getString("personnelName"));
			masPersonnelDetails
					.setPersonnelName(box.getString("personnelName"));
			masPersonnelDetails.setPresentAddress(box.get("presentAddress"));
			masPersonnelDetails.setBankAcNo(box.get("acNo"));
			/*masPersonnelDetails.setPassNo(box.getInt("passNo"));*/
			masPersonnelDetails.setHeight(box.getInt("height"));
			/*MasUnit masUnit = new MasUnit();
			masUnit.setId(box.getInt("unit"));
			masPersonnelDetails.setUnit(masUnit);*/
			masPersonnelDetails.setSfx(box.getString("sfx"));
			masPersonnelDetails.setPresentPin(box.getInt("presentPin"));
			masPersonnelDetails.setIdentificationMark(box
					.getString("identificationMark"));
			MasDesignation masDesignation = new MasDesignation();
			masDesignation.setId(box.getInt("designationId"));
			masPersonnelDetails.setDesignation(masDesignation);
			masPersonnelDetails.setPermanentAddress(box
					.getString("permanentAddress"));
			masPersonnelDetails.setPermanentPin(box.getInt("permanentPin"));
			masPersonnelDetails
					.setPersonnelName(box.getString("personnelName"));
			masPersonnelDetails.setBankAddress(box.getString("bankAddress"));
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(box.getInt("genderId"));
			masPersonnelDetails.setAdministrativeSex(masAdministrativeSex);
			masPersonnelDetails.setFatherHusbandName(box
					.getString("fatherOrHusband"));

			MasReligion masReligion = new MasReligion();
			masReligion.setId(box.getInt("religionId"));
			masPersonnelDetails.setReligion(masReligion);
			masPersonnelDetails.setPayScale(box.getString("payScale"));
			if (box.getString("birthDate") != null
					&& !box.getString("birthDate").equals(""))
				masPersonnelDetails.setDateOfBirth(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("birthDate")));
			if (box.getString("appointmentDate") != null
					&& !box.getString("appointmentDate").equals(""))
				masPersonnelDetails.setAppointmentDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("appointmentDate")));
			if (box.getString("marriageDate") != null
					&& !box.getString("marriageDate").equals(""))
				masPersonnelDetails.setMarriageDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("marriageDate")));
			if (box.getString("postingInDate") != null
					&& !box.getString("postingInDate").equals(""))
				masPersonnelDetails.setPostingIn(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("postingInDate")));
			if (box.getString("postedOutDate") != null
					&& !box.getString("postedOutDate").equals(""))
				masPersonnelDetails.setPostedOut(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("postedOutDate")));
			if (box.getString("retirementDate") != null
					&& !box.getString("retirementDate").equals(""))
				masPersonnelDetails.setRetirementDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("retirementDate")));
			if (box.getString("incrementDate") != null
					&& !box.getString("incrementDate").equals(""))
				masPersonnelDetails.setIncrementDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("incrementDate")));
			masPersonnelDetails.setTotalServiceWithoutEolYears(box
					.getInt("serviceYears"));
			masPersonnelDetails.setTotalServiceWithoutEolMonths(box
					.getInt("serviceMonths"));
			masPersonnelDetails.setTotalServiceWithoutEolDays(box
					.getInt("serviceDays"));
			masPersonnelDetails.setLastChgBy(box.getString("changed_by"));
			masPersonnelDetails.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			masPersonnelDetails.setLastChgTime(box.getString("changed_time"));
			hbt.update(masPersonnelDetails);

			Iterator itr = familyNameList.iterator();
			for (int i = 0; i < familyNameList.size(); i++) {
				String isNominee = "";
				String familyName = (String) familyNameList.get(i);
				if (!familyName.trim().equals("")) {
					MasPersonnelFamilyDetails masPersonnelFamilyDetails = new MasPersonnelFamilyDetails();
					masPersonnelFamilyDetails.setFamilyName(familyName);
					MasRelation masRelation = new MasRelation();
					masRelation.setId(relationIdList.get(i));
					masPersonnelFamilyDetails.setRelation(masRelation);
					masPersonnelFamilyDetails.setDateOfBirth(HMSUtil
							.convertStringTypeDateToDateType(dateOfBirthList
									.get(i)));
					if (isNomineeList.get(i) != null) {
						isNominee = "y";

						if (nomineePercentList.get(i) != null
								&& !nomineePercentList.get(i).equals(""))
							masPersonnelFamilyDetails
									.setNomineePercent(new BigDecimal(
											nomineePercentList.get(i)));
						else
							masPersonnelFamilyDetails
									.setNomineePercent(new BigDecimal("0"));
					} else {
						isNominee = "n";
						masPersonnelFamilyDetails
								.setNomineePercent(new BigDecimal("0"));
					}
					masPersonnelFamilyDetails.setNominee(isNominee);

					masPersonnelFamilyDetails.setHeight(heightsList.get(i));
					masPersonnelFamilyDetails
							.setIdentificationMark(identificationMarkList
									.get(i));
					masPersonnelFamilyDetails.setPersonnel(masPersonnelDetails);
					masPersonnelFamilyDetails.setLastChgBy(box
							.getString("changed_by"));
					masPersonnelFamilyDetails.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("changed_date")));
					masPersonnelFamilyDetails.setLastChgTime(box
							.getString("changed_time"));
					hbt.save(masPersonnelFamilyDetails);

				}

			}
	
			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		
		}	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successfullyAdded",successfullyAdded );
		map.put("alreadyAdded",alreadyAdded);
	
	return map;
	}

	public Map<String, Object> getDataForPersonnelSearchJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();

		try {

			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();

			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("unitList", unitList);

		map.put("designationList", designationList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPersonnelDetailsForCalculationSheet(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {
			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();
			masRelationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masPersonnelDetailsList", masPersonnelDetailsList);
		map.put("masRelationList", masRelationList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean submitCalculationSheetDetails(Box box,
			Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		int personnelId = box.getInt("personnelId");
		List<String> fromDateForOtherSList = (List<String>) dataMap
				.get("fromDateForOtherSList");
		List<String> toDateForOtherSList = (List<String>) dataMap
				.get("toDateForOtherSList");
		List<Integer> totalOtherServiceYearsList = (List<Integer>) dataMap
				.get("totalOtherServiceYearsList");
		List<Integer> totalOtherServiceMonthsList = (List<Integer>) dataMap
				.get("totalOtherServiceMonthsList");
		List<Integer> totalOtherServiceDaysList = (List<Integer>) dataMap
				.get("totalOtherServiceDaysList");
		List<String> fromDateForEolList = (List<String>) dataMap
				.get("fromDateForEolList");
		List<String> toDateForEolList = (List<String>) dataMap
				.get("toDateForEolList");
		List<Integer> eolYearsList = (List<Integer>) dataMap
				.get("eolYearsList");
		List<Integer> eolMonthsList = (List<Integer>) dataMap
				.get("eolMonthsList");
		List<Integer> eolDaysList = (List<Integer>) dataMap.get("eolDaysList");
		List<String> fromDateForEmolList = (List<String>) dataMap
				.get("fromDateForEmolList");
		List<String> toDateForEmolList = (List<String>) dataMap
				.get("toDateForEmolList");
		List<BigDecimal> basicPayList = (List<BigDecimal>) dataMap
				.get("basicPayList");
		//pankaj
		List<BigDecimal> gradePayList = (List<BigDecimal>) dataMap
		.get("gradePayList");
		
		List<BigDecimal> stagnList = (List<BigDecimal>) dataMap
				.get("stagnList");
		List<BigDecimal> rankPayList = (List<BigDecimal>) dataMap
				.get("rankPayList");
		List<BigDecimal> dpList = (List<BigDecimal>) dataMap.get("dpList");
		List<BigDecimal> npaList = (List<BigDecimal>) dataMap.get("npaList");
		List<BigDecimal> othersList = (List<BigDecimal>) dataMap
				.get("othersList");
		List<BigDecimal> daList = (List<BigDecimal>) dataMap.get("daList");
		List<BigDecimal> totalEmolList = (List<BigDecimal>) dataMap
				.get("totalEmolList");
		List<Integer> noOfMonthsList = (List<Integer>) dataMap
				.get("noOfMonthsList");
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasPersonnelDetails masPersonnelDetailsObj = (MasPersonnelDetails) hbt
					.load(MasPersonnelDetails.class, personnelId);
			masPersonnelDetailsObj.setCalculationSheetStatus("c");
			hbt.update(masPersonnelDetailsObj);

			Iterator itr = fromDateForOtherSList.iterator();
			for (int i = 0; i < fromDateForOtherSList.size(); i++) {
				PensionOtherServices pensionOtherServices = new PensionOtherServices();
				pensionOtherServices.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateForOtherSList
								.get(i)));
				pensionOtherServices.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateForOtherSList
								.get(i)));
				pensionOtherServices.setTotalYears(totalOtherServiceYearsList
						.get(i));
				pensionOtherServices.setTotalMonths(totalOtherServiceMonthsList
						.get(i));
				pensionOtherServices.setTotalDays(totalOtherServiceDaysList
						.get(i));
				MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
				masPersonnelDetails.setId(personnelId);
				pensionOtherServices.setPersonnel(masPersonnelDetails);
				pensionOtherServices.setLastChgBy(box.getString("changed_by"));
				pensionOtherServices.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionOtherServices.setLastChgTime(box
						.getString("changed_time"));
				hbt.save(pensionOtherServices);

			}

			Iterator itr1 = fromDateForEolList.iterator();
			for (int i = 0; i < fromDateForEolList.size(); i++) {
				PensionEol pensionEol = new PensionEol();
				pensionEol.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateForEolList
								.get(i)));
				pensionEol.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateForEolList
								.get(i)));
				pensionEol.setTotalYears(eolYearsList.get(i));
				pensionEol.setTotalMonths(eolMonthsList.get(i));
				pensionEol.setTotalDays(eolDaysList.get(i));
				MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
				masPersonnelDetails.setId(personnelId);
				pensionEol.setPersonnel(masPersonnelDetails);
				pensionEol.setLastChgBy(box.getString("changed_by"));
				pensionEol.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionEol.setLastChgTime(box.getString("changed_time"));
				hbt.save(pensionEol);

			}
			Iterator itr2 = fromDateForEmolList.iterator();
			for (int i = 0; i < fromDateForEmolList.size(); i++) {
				PensionEmoluments pensionEmoluments = new PensionEmoluments();
				pensionEmoluments.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateForEmolList
								.get(i)));
				pensionEmoluments.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateForEmolList
								.get(i)));
				pensionEmoluments.setBasicPay(basicPayList.get(i));
				//pankaj
				pensionEmoluments.setGradePay(gradePayList.get(i));
				
				pensionEmoluments.setStagn(stagnList.get(i));
				pensionEmoluments.setRankPay(rankPayList.get(i));
				pensionEmoluments.setDp(dpList.get(i));
				pensionEmoluments.setNpa(npaList.get(i));
				pensionEmoluments.setDa(daList.get(i));
				pensionEmoluments.setOthers(othersList.get(i));
				pensionEmoluments.setNoOfMonths(noOfMonthsList.get(i));
				pensionEmoluments.setTotalEmoluments(totalEmolList.get(i));
				MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
				masPersonnelDetails.setId(personnelId);
				pensionEmoluments.setPersonnel(masPersonnelDetails);
				pensionEmoluments.setLastChgBy(box.getString("changed_by"));
				pensionEmoluments.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionEmoluments.setLastChgTime(box.getString("changed_time"));
				hbt.save(pensionEmoluments);
			}
			PensionCalculationSheet pensionCalculationSheet = new PensionCalculationSheet();
			pensionCalculationSheet.setPensionClass(box
					.getString("pensionClass"));
			pensionCalculationSheet.setPensionRules(box
					.getString("pensionRules"));
			pensionCalculationSheet.setNetQualifyingServiceYears(box
					.getInt("netQualifyingServiceInYears"));
			pensionCalculationSheet.setNetQualifyingServiceMonths(box
					.getInt("netQualifyingServiceInMonths"));
			pensionCalculationSheet.setNetQualifyingServiceDays(box
					.getInt("netQualifyingServiceInDays"));
			MasPersonnelDetails masPersonnelDetailObj = new MasPersonnelDetails();
			masPersonnelDetailObj.setId(personnelId);
			pensionCalculationSheet.setPersonnel(masPersonnelDetailObj);
			pensionCalculationSheet.setLastChgBy(box.getString("changed_by"));
			pensionCalculationSheet.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionCalculationSheet.setLastChgTime(box
					.getString("changed_time"));
			hbt.save(pensionCalculationSheet);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUpdatePersonnelSearchForCalculationSheet(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> personnelDetailList = new ArrayList<MasPersonnelDetails>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (dataMap.get("personnelName") != null) {
			personnelName = (String) dataMap.get("personnelName");
		}
		if (dataMap.get("passNo") != null) {
			passNo = (Integer) dataMap.get("passNo");
		}
		if (dataMap.get("unitId") != null) {
			unitId = (Integer) dataMap.get("unitId");
		}
		if (dataMap.get("designationId") != null) {
			designationId = (Integer) dataMap.get("designationId");
		}

		//System.out.println("pass no=====" + passNo);
		try {
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();
			/*
			 * List<PensionEmoluments> distinctIdList =
			 * session.createCriteria(PensionEmoluments
			 * .class).createAlias("Personnel",
			 * "personnel").setProjection(Projections.distinct(
			 * Projections.projectionList()
			 * .add(Projections.property("personnel.Id")) )).list();
			 * //System.out.println
			 * ("distinct id list size====="+distinctIdList.size());
			 */
			Criteria crit = session.createCriteria(MasPersonnelDetails.class)
					.add(Restrictions.eq("CalculationSheetStatus", "c"));

			if (personnelName != "") {
				crit = crit.add(Restrictions.like("PersonnelName",
						personnelName + "%"));

			}
			if (passNo != 0) {
				crit = crit.add(Restrictions.eq("PassNo", passNo));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (designationId != 0) {
				crit = crit.createAlias("Designation", "designation").add(
						Restrictions.eq("designation.Id", designationId));
			}

			personnelDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("unitList", unitList);
		map.put("designationList", designationList);
		map.put("personnelDetailList", personnelDetailList);

		return map;
	}

	public Map<String, Object> showUpdateCalculationSheet(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PensionEmoluments> pensionEmolumentsList = new ArrayList<PensionEmoluments>();
		List<PensionEol> pensionEolList = new ArrayList<PensionEol>();
		List<PensionOtherServices> pensionOtherServicesList = new ArrayList<PensionOtherServices>();
		List<PensionCalculationSheet> pensionCalculationSheetList = new ArrayList<PensionCalculationSheet>();

		int personnelId = (Integer) dataMap.get("personnelId");
		try {
			pensionEmolumentsList = session.createCriteria(
					PensionEmoluments.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			pensionEolList = session.createCriteria(PensionEol.class)
					.createAlias("Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();
			pensionOtherServicesList = session.createCriteria(
					PensionOtherServices.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			pensionCalculationSheetList = session.createCriteria(
					PensionCalculationSheet.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pensionEmolumentsList", pensionEmolumentsList);
		map.put("pensionEolList", pensionEolList);
		map.put("pensionOtherServicesList", pensionOtherServicesList);
		map.put("pensionCalculationSheetList", pensionCalculationSheetList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean updateCalculationSheet(Box box, Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		int personnelId = box.getInt("personnelId");
		List<String> fromDateForOtherSList = (List<String>) dataMap
				.get("fromDateForOtherSList");
		List<String> toDateForOtherSList = (List<String>) dataMap
				.get("toDateForOtherSList");
		List<Integer> totalOtherServiceYearsList = (List<Integer>) dataMap
				.get("totalOtherServiceYearsList");
		List<Integer> totalOtherServiceMonthsList = (List<Integer>) dataMap
				.get("totalOtherServiceMonthsList");
		List<Integer> totalOtherServiceDaysList = (List<Integer>) dataMap
				.get("totalOtherServiceDaysList");
		List<String> fromDateForEolList = (List<String>) dataMap
				.get("fromDateForEolList");
		List<String> toDateForEolList = (List<String>) dataMap
				.get("toDateForEolList");
		List<Integer> eolYearsList = (List<Integer>) dataMap
				.get("eolYearsList");
		List<Integer> eolMonthsList = (List<Integer>) dataMap
				.get("eolMonthsList");
		List<Integer> eolDaysList = (List<Integer>) dataMap.get("eolDaysList");
		List<String> fromDateForEmolList = (List<String>) dataMap
				.get("fromDateForEmolList");
		List<String> toDateForEmolList = (List<String>) dataMap
				.get("toDateForEmolList");
		List<BigDecimal> basicPayList = (List<BigDecimal>) dataMap
				.get("basicPayList");
		
		List<BigDecimal> gradePayList = (List<BigDecimal>) dataMap
		.get("gradePayList");
		
		List<BigDecimal> stagnList = (List<BigDecimal>) dataMap
				.get("stagnList");
		List<BigDecimal> rankPayList = (List<BigDecimal>) dataMap
				.get("rankPayList");
		List<BigDecimal> dpList = (List<BigDecimal>) dataMap.get("dpList");
		List<BigDecimal> npaList = (List<BigDecimal>) dataMap.get("npaList");
		List<BigDecimal> othersList = (List<BigDecimal>) dataMap
				.get("othersList");
		List<BigDecimal> daList = (List<BigDecimal>) dataMap.get("daList");
		List<BigDecimal> totalEmolList = (List<BigDecimal>) dataMap
				.get("totalEmolList");
		List<Integer> noOfMonthsList = (List<Integer>) dataMap
				.get("noOfMonthsList");
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<PensionOtherServices> pensionOtherServiceList = session
					.createCriteria(PensionOtherServices.class).createAlias(
							"Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();

			List<PensionEol> penEolList = session.createCriteria(
					PensionEol.class).createAlias("Personnel", "personnel")
					.add(Restrictions.eq("personnel.Id", personnelId)).list();

			List<PensionEmoluments> pensionEmolList = session.createCriteria(
					PensionEmoluments.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();

			hbt.deleteAll(penEolList);
			hbt.deleteAll(pensionOtherServiceList);
			hbt.deleteAll(pensionEmolList);
			List<PensionCalculationSheet> pensionCalculationSheetList = session
					.createCriteria(PensionCalculationSheet.class).createAlias(
							"Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();
			PensionCalculationSheet pensionCalculationSheet = pensionCalculationSheetList
					.get(0);
			int calculationSheetId = pensionCalculationSheet.getId();
			PensionCalculationSheet pensionCalculationSheetObj = (PensionCalculationSheet) hbt
					.load(PensionCalculationSheet.class, calculationSheetId);
			pensionCalculationSheetObj.setPensionClass(box
					.getString("pensionClass"));
			pensionCalculationSheetObj.setPensionRules(box
					.getString("pensionRules"));
			pensionCalculationSheetObj.setNetQualifyingServiceYears(box
					.getInt("netQualifyingServiceInYears"));
			pensionCalculationSheetObj.setNetQualifyingServiceMonths(box
					.getInt("netQualifyingServiceInMonths"));
			pensionCalculationSheetObj.setNetQualifyingServiceDays(box
					.getInt("netQualifyingServiceInDays"));
			pensionCalculationSheetObj
					.setLastChgBy(box.getString("changed_by"));
			pensionCalculationSheetObj.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionCalculationSheetObj.setLastChgTime(box
					.getString("changed_time"));
			hbt.update(pensionCalculationSheetObj);

			Iterator itr = fromDateForOtherSList.iterator();
			for (int i = 0; i < fromDateForOtherSList.size(); i++) {
				PensionOtherServices pensionOtherServices = new PensionOtherServices();
				pensionOtherServices.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateForOtherSList
								.get(i)));
				pensionOtherServices.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateForOtherSList
								.get(i)));
				pensionOtherServices.setTotalYears(totalOtherServiceYearsList
						.get(i));
				pensionOtherServices.setTotalMonths(totalOtherServiceMonthsList
						.get(i));
				pensionOtherServices.setTotalDays(totalOtherServiceDaysList
						.get(i));
				MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
				masPersonnelDetails.setId(personnelId);
				pensionOtherServices.setPersonnel(masPersonnelDetails);
				pensionOtherServices.setLastChgBy(box.getString("changed_by"));
				pensionOtherServices.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionOtherServices.setLastChgTime(box
						.getString("changed_time"));
				hbt.save(pensionOtherServices);

			}

			Iterator itr1 = fromDateForEolList.iterator();
			for (int i = 0; i < fromDateForEolList.size(); i++) {
				PensionEol pensionEol = new PensionEol();
				pensionEol.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateForEolList
								.get(i)));
				pensionEol.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateForEolList
								.get(i)));
				pensionEol.setTotalYears(eolYearsList.get(i));
				pensionEol.setTotalMonths(eolMonthsList.get(i));
				pensionEol.setTotalDays(eolDaysList.get(i));
				MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
				masPersonnelDetails.setId(personnelId);
				pensionEol.setPersonnel(masPersonnelDetails);
				pensionEol.setLastChgBy(box.getString("changed_by"));
				pensionEol.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionEol.setLastChgTime(box.getString("changed_time"));
				hbt.save(pensionEol);

			}
			Iterator itr2 = fromDateForEmolList.iterator();
			for (int i = 0; i < fromDateForEmolList.size(); i++) {
				PensionEmoluments pensionEmoluments = new PensionEmoluments();

				pensionEmoluments.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateForEmolList
								.get(i)));
				pensionEmoluments.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateForEmolList
								.get(i)));
				pensionEmoluments.setBasicPay(basicPayList.get(i));
				pensionEmoluments.setGradePay(gradePayList.get(i));
				
				pensionEmoluments.setStagn(stagnList.get(i));
				pensionEmoluments.setRankPay(rankPayList.get(i));
				pensionEmoluments.setDp(dpList.get(i));
				pensionEmoluments.setNpa(npaList.get(i));
				pensionEmoluments.setDa(daList.get(i));
				pensionEmoluments.setOthers(othersList.get(i));
				pensionEmoluments.setNoOfMonths(noOfMonthsList.get(i));
				pensionEmoluments.setTotalEmoluments(totalEmolList.get(i));
				MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
				masPersonnelDetails.setId(personnelId);
				pensionEmoluments.setPersonnel(masPersonnelDetails);
				pensionEmoluments.setLastChgBy(box.getString("changed_by"));
				pensionEmoluments.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionEmoluments.setLastChgTime(box.getString("changed_time"));
				hbt.save(pensionEmoluments);

			}

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public boolean submitDataSheetJsp(Box box) {
		boolean successfullyAdded = false;
		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasPersonnelDetails masPersonnelDetailsObj = (MasPersonnelDetails) hbt
					.load(MasPersonnelDetails.class, box.getInt("personnelId"));
			masPersonnelDetailsObj.setDataSheetStatus("c");
			hbt.update(masPersonnelDetailsObj);
			hbt.refresh(masPersonnelDetailsObj);

			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			PensionDataSheet pensionDataSheet = new PensionDataSheet();

			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionDataSheet.setPersonnel(masPersonnelDetails);

			pensionDataSheet.setOrganisationCode(box.getString("orgCode"));
			pensionDataSheet.setOrgGroup(box.getString("orgGroup"));
			pensionDataSheet.setGpfNo(box.getString("gpfNo"));
			pensionDataSheet.setHeadOfficeAddress(box
					.getString("headOfficeAddress"));
			pensionDataSheet
					.setNationalityCode(box.getString("natinalityCode"));
			pensionDataSheet.setRetirement(box.getString("retirementType"));
			pensionDataSheet.setNatureOfPension(box
					.getString("natureOfPension"));
			pensionDataSheet.setFormerServiceCounted(box
					.getString("formerService"));
			pensionDataSheet.setWeightageAllowed(box.getString("weightage"));
			pensionDataSheet.setMedicalAllowance(box
					.getString("medicalAllowance"));
			pensionDataSheet.setPayGroup(box.getString("payGroup"));

			pensionDataSheet.setPayCode(box.getString("payCode"));
			pensionDataSheet.setPayBandCode(box.getString("payBandCode"));
			pensionDataSheet.setPayInPayBandScale(box
					.getString("payInPayBandScale"));
			pensionDataSheet.setGradePay(box.getString("gradePay"));
			pensionDataSheet.setNpMsPay(box.getString("npa"));

			if (box.getString("lastPayDate") != null
					&& !box.getString("lastPayDate").equals(""))
				pensionDataSheet.setLastPayDrawn(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("lastPayDate")));
			if (box.getString("average") != null
					&& !box.getString("average").equals(""))
				pensionDataSheet.setMonAve(Integer.parseInt(box
						.getString("average")));
			else
				pensionDataSheet.setMonAve(Integer.parseInt("0"));

			//System.out.println("months average====" + box.getString("average"));
			pensionDataSheet.setGalAward(box.getString("galAward"));
			pensionDataSheet.setLastPayReduced(box.getString("lastPayReduced"));
			pensionDataSheet.setAcOfRdrHead(box.getString("rdrHead"));
			pensionDataSheet.setAcOtherThenRdrHead(box
					.getString("otherThenRdrHead"));
			pensionDataSheet.setInterestOnRdrDemand(box.getString("rdrDemand"));
			pensionDataSheet.setInterestPayable(box
					.getString("interestPayable"));

			if (box.getString("dateOfReceipt") != null
					&& !box.getString("dateOfReceipt").equals(""))
				pensionDataSheet.setDateOfReceipt(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("dateOfReceipt")));

			if (box.getString("fractionComm") != null
					&& !box.getString("fractionComm").equals(""))
				pensionDataSheet.setFractionComm(Integer.parseInt(box
						.getString("fractionComm")));
			else
				pensionDataSheet.setFractionComm(Integer.parseInt("0"));

			if (box.getString("amountComm") != null
					&& !box.getString("amountComm").equals(""))
				pensionDataSheet.setAmountComm(new BigDecimal(box
						.getString("amountComm")));
			else
				pensionDataSheet.setAmountComm(new BigDecimal("0"));

			if (box.getString("ageLoad") != null
					&& !box.getString("ageLoad").equals(""))
				pensionDataSheet.setAgeLoad(Integer.parseInt(box
						.getString("ageLoad")));

			pensionDataSheet.setMarriedBeforeRetirement(box
					.getString("marriedBeforeRetirement"));
			pensionDataSheet.setSpouseAlive(box.getString("spouseAlive"));
			pensionDataSheet.setNameOfSpouse(box.getString("spouseName"));
			// pensionDataSheet.setNationalityCodeSpouse(box.getString("natinalityCodeSpouse"));
			if (box.getString("ageSpouse") != null
					&& !box.getString("ageSpouse").equals(""))
				pensionDataSheet.setAgeSpouse(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("ageSpouse")));

			pensionDataSheet.setPdaCode(box.getString("pdaCode"));
			pensionDataSheet.setDpdoCode(box.getString("dpdoCode"));
			pensionDataSheet.setPdaStation(box.getString("pdaStation"));
			pensionDataSheet.setPdaStateCode(box.getString("pdaStateCode"));
			pensionDataSheet.setBankSubTryCode(box.getString("bankSubTryCode"));
			pensionDataSheet.setLinkBank(box.getString("linkBank"));
			pensionDataSheet.setBankBranch(box.getString("bankBranch"));
			pensionDataSheet.setBsrCodeOfBankBranch(box
					.getString("bsrCodeOfBankBranch"));
			pensionDataSheet.setBsrCodeOfLinkBank(box
					.getString("bsrCodeOfLinkBank"));
			pensionDataSheet.setHavingHandicappedChild(box
					.getString("handicappedChild"));
			pensionDataSheet.setNameOfHandicappedChild(box
					.getString("nameOfHandicappedChild"));

			//System.out.println("box.getInt             "+ box.getInt("relationId"));
			if (box.getInt("relationId") != 0) {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(box.getInt("relationId"));
				pensionDataSheet.setRelation(masRelation);
			} else {
				pensionDataSheet.setRelation(null);
			}
			pensionDataSheet.setCdrNo(box.getString("cdrNo"));

			pensionDataSheet.setPensionersStateCode(box
					.getString("pensionersStateCode"));

			pensionDataSheet.setLastChgBy(box.getString("changed_by"));
			pensionDataSheet.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionDataSheet.setLastChgTime(box.getString("changed_time"));

			hbt.save(pensionDataSheet);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	/*
	 * public boolean submitDataSheetJsp(Box box) { boolean
	 * successfullyAdded=false; Session session = (Session) getSession();
	 * //System.out.println("personnel id====="+box.getInt("personnelId"));
	 * //System.out.println("org code====="+box.getInt("orgCode")); Transaction tx
	 * = null; try{ tx= session.beginTransaction();
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false);
	 * 
	 * MasPersonnelDetails
	 * masPersonnelDetailsObj=(MasPersonnelDetails)hbt.load(MasPersonnelDetails
	 * .class, box.getInt("personnelId"));
	 * masPersonnelDetailsObj.setDataSheetStatus("c");
	 * hbt.update(masPersonnelDetailsObj);
	 * 
	 * 
	 * 
	 * PensionDataSheet pensionDataSheet= new PensionDataSheet();
	 * MasPersonnelDetails masPersonnelDetails= new MasPersonnelDetails();
	 * masPersonnelDetails.setId(box.getInt("personnelId"));
	 * pensionDataSheet.setPersonnel(masPersonnelDetails);
	 * pensionDataSheet.setOrganisationCode(box.getString("orgCode"));
	 * hbt.save(pensionDataSheet);
	 * 
	 * 
	 * 
	 * successfullyAdded=true; tx.commit(); }catch(Exception e) { if (tx !=
	 * null) tx.rollback(); e.printStackTrace();
	 * 
	 * } finally{ //--------Session Closing---------- session.close(); } return
	 * successfullyAdded; }
	 */

	public Map<String, Object> showUpdatePersonnelSearchForDataSheet(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> personnelDetailList = new ArrayList<MasPersonnelDetails>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (dataMap.get("personnelName") != null) {
			personnelName = (String) dataMap.get("personnelName");
		}
		if (dataMap.get("passNo") != null) {
			passNo = (Integer) dataMap.get("passNo");
		}
		if (dataMap.get("unitId") != null) {
			unitId = (Integer) dataMap.get("unitId");
		}
		if (dataMap.get("designationId") != null) {
			designationId = (Integer) dataMap.get("designationId");
		}

		//System.out.println("pass no=====" + passNo);
		try {
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();

			Criteria crit = session.createCriteria(MasPersonnelDetails.class)
					.add(Restrictions.eq("DataSheetStatus", "c"));

			if (personnelName != "") {
				crit = crit.add(Restrictions.like("PersonnelName",
						personnelName + "%"));

			}
			if (passNo != 0) {
				crit = crit.add(Restrictions.eq("PassNo", passNo));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (designationId != 0) {
				crit = crit.createAlias("Designation", "designation").add(
						Restrictions.eq("designation.Id", designationId));
			}

			personnelDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("unitList", unitList);
		map.put("designationList", designationList);
		map.put("personnelDetailList", personnelDetailList);

		return map;
	}

	public Map<String, Object> showUpdateDataSheet(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PensionDataSheet> pensionDataSheetList = new ArrayList<PensionDataSheet>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			pensionDataSheetList = session.createCriteria(
					PensionDataSheet.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			masRelationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pensionDataSheetList", pensionDataSheetList);
		map.put("masRelationList", masRelationList);
		return map;
	}

	public boolean updateDataSheet(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<PensionDataSheet> pensionDataSheetList = session
					.createCriteria(PensionDataSheet.class).createAlias(
							"Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", box
									.getInt("personnelId"))).list();
			PensionDataSheet pensionDataSheetObj = (PensionDataSheet) pensionDataSheetList
					.get(0);
			int pensionDataSheetId = pensionDataSheetObj.getId();
			PensionDataSheet pensionDataSheet = (PensionDataSheet) hbt.load(
					PensionDataSheet.class, pensionDataSheetId);

			pensionDataSheet.setOrganisationCode(box.getString("orgCode"));
			pensionDataSheet.setOrgGroup(box.getString("orgGroup"));
			pensionDataSheet.setGpfNo(box.getString("gpfNo"));
			pensionDataSheet.setHeadOfficeAddress(box
					.getString("headOfficeAddress"));
			pensionDataSheet
					.setNationalityCode(box.getString("natinalityCode"));
			pensionDataSheet.setRetirement(box.getString("retirementType"));
			pensionDataSheet.setNatureOfPension(box
					.getString("natureOfPension"));
			pensionDataSheet.setFormerServiceCounted(box
					.getString("formerService"));
			pensionDataSheet.setWeightageAllowed(box.getString("weightage"));
			pensionDataSheet.setMedicalAllowance(box
					.getString("medicalAllowance"));
			pensionDataSheet.setPayGroup(box.getString("payGroup"));

			pensionDataSheet.setPayCode(box.getString("payCode"));
			pensionDataSheet.setPayBandCode(box.getString("payBandCode"));
			pensionDataSheet.setPayInPayBandScale(box
					.getString("payInPayBandScale"));
			pensionDataSheet.setGradePay(box.getString("gradePay"));
			pensionDataSheet.setNpMsPay(box.getString("npa"));

			if (box.getString("lastPayDate") != null
					&& !box.getString("lastPayDate").equals(""))
				pensionDataSheet.setLastPayDrawn(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("lastPayDate")));
			if (box.getString("monthsAverage") != null
					&& !box.getString("monthsAverage").equals(""))
				pensionDataSheet.setMonAve(Integer.parseInt(box
						.getString("monthsAverage")));
			else
				pensionDataSheet.setMonAve(Integer.parseInt("0"));

			//System.out.println("months average====" + box.getString("average"));
			pensionDataSheet.setGalAward(box.getString("galAward"));
			pensionDataSheet.setLastPayReduced(box.getString("lastPayReduced"));
			pensionDataSheet.setAcOfRdrHead(box.getString("rdrHead"));
			pensionDataSheet.setAcOtherThenRdrHead(box
					.getString("otherThenRdrHead"));
			pensionDataSheet.setInterestOnRdrDemand(box.getString("rdrDemand"));
			pensionDataSheet.setInterestPayable(box
					.getString("interestPayable"));

			if (box.getString("dateOfReceipt") != null
					&& !box.getString("dateOfReceipt").equals(""))
				pensionDataSheet.setDateOfReceipt(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("dateOfReceipt")));

			if (box.getString("fractionComm") != null
					&& !box.getString("fractionComm").equals(""))
				pensionDataSheet.setFractionComm(Integer.parseInt(box
						.getString("fractionComm")));
			else
				pensionDataSheet.setFractionComm(Integer.parseInt("0"));

			if (box.getString("amountComm") != null
					&& !box.getString("amountComm").equals(""))
				pensionDataSheet.setAmountComm(new BigDecimal(box
						.getString("amountComm")));
			else
				pensionDataSheet.setAmountComm(new BigDecimal("0"));

			if (box.getString("ageLoad") != null
					&& !box.getString("ageLoad").equals(""))
				pensionDataSheet.setAgeLoad(Integer.parseInt(box
						.getString("ageLoad")));

			pensionDataSheet.setMarriedBeforeRetirement(box
					.getString("marriedBeforeRetirement"));
			if (box.getString("spouseAlive") != null
					&& !box.getString("spouseAlive").equals(""))
				pensionDataSheet.setSpouseAlive(box.getString("spouseAlive"));

			pensionDataSheet.setNameOfSpouse(box.getString("spouseName"));
			pensionDataSheet.setNationalityCodeSpouse(box
					.getString("natinalityCodeSpouse"));
			if (box.getString("ageSpouse") != null
					&& !box.getString("ageSpouse").equals(""))
				pensionDataSheet.setAgeSpouse(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("ageSpouse")));

			pensionDataSheet.setPdaCode(box.getString("pdaCode"));
			pensionDataSheet.setDpdoCode(box.getString("dpdoCode"));
			pensionDataSheet.setPdaStation(box.getString("pdaStation"));
			pensionDataSheet.setPdaStateCode(box.getString("pdaStateCode"));
			pensionDataSheet.setBankSubTryCode(box.getString("bankSubTryCode"));
			pensionDataSheet.setLinkBank(box.getString("linkBank"));
			pensionDataSheet.setBankBranch(box.getString("bankBranch"));
			pensionDataSheet.setBsrCodeOfBankBranch(box
					.getString("bsrCodeOfBankBranch"));
			pensionDataSheet.setBsrCodeOfLinkBank(box
					.getString("bsrCodeOfLinkBank"));
			pensionDataSheet.setHavingHandicappedChild(box
					.getString("handicappedChild"));
			pensionDataSheet.setNameOfHandicappedChild(box
					.getString("nameOfHandicappedChild"));
			System.out
					.println("relation Id    ==  " + box.getInt("relationId"));
			if (box.getInt("relationId") > 0) {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(box.getInt("relationId"));
				pensionDataSheet.setRelation(masRelation);
			}
			pensionDataSheet.setCdrNo(box.getString("cdrNo"));

			pensionDataSheet.setPensionersStateCode(box
					.getString("pensionersStateCode"));

			pensionDataSheet.setLastChgBy(box.getString("changed_by"));
			pensionDataSheet.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionDataSheet.setLastChgTime(box.getString("changed_time"));

			hbt.update(pensionDataSheet);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPersonnelDetailsForForm7Entry(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		List<PensionCalculationSheet> pensionCalculationList = new ArrayList<PensionCalculationSheet>();
		List<PensionEol> pensionEolList = new ArrayList<PensionEol>();
		List<PensionEmoluments> pensionEmolList = new ArrayList<PensionEmoluments>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();
			pensionCalculationList = session.createCriteria(
					PensionCalculationSheet.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			pensionEolList = session.createCriteria(PensionEol.class)
					.createAlias("Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();
			pensionEmolList = session.createCriteria(PensionEmoluments.class)
					.createAlias("Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pensionCalculationList", pensionCalculationList);
		map.put("pensionEolList", pensionEolList);
		map.put("pensionEmolList", pensionEmolList);
		map.put("masPersonnelDetailsList", masPersonnelDetailsList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean submitForm7Entry(Box box, Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		List<String> fromDateList = (List<String>) dataMap.get("fromDateList");
		List<String> toDateList = (List<String>) dataMap.get("toDateList");
		List<BigDecimal> payList = (List<BigDecimal>) dataMap.get("payList");
		List<Integer> noOfMonthsList = (List<Integer>) dataMap
				.get("noOfMonthsList");
		List<BigDecimal> personelPayList = (List<BigDecimal>) dataMap
				.get("personelPayList");
		List<BigDecimal> averageEmolList = (List<BigDecimal>) dataMap
				.get("averageEmolList");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasPersonnelDetails masPersonnelDetailsObj = (MasPersonnelDetails) hbt
					.load(MasPersonnelDetails.class, box.getInt("personnelId"));
			masPersonnelDetailsObj.setForm7Status("c");
			hbt.update(masPersonnelDetailsObj);

			PensionForm7Details pensionForm7Details = new PensionForm7Details();
			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionForm7Details.setPersonnel(masPersonnelDetails);

			pensionForm7Details.setGratuityPeriod(box
					.getString("gratuityPeriod"));
			pensionForm7Details.setGratuityRecievedMilitary(box
					.getString("recievedGratuityForMilitaryService"));
			pensionForm7Details.setGratuityRecievedCivilService(box
					.getString("recievedGratuityForCivilService"));
			if (box.get("noDemandCertificate") != null
					&& !box.get("noDemandCertificate").equals(""))
				pensionForm7Details.setNoDemandCertificate(HMSUtil
						.convertStringTypeDateToDateType(box
								.get("noDemandCertificate")));
			if (box.get("pensionQualifyingDate") != null
					&& !box.get("pensionQualifyingDate").equals(""))
				pensionForm7Details.setQualifyingPension(HMSUtil
						.convertStringTypeDateToDateType(box
								.get("pensionQualifyingDate")));
			if (box.get("duesAssessingDate") != null
					&& !box.get("duesAssessingDate").equals(""))
				pensionForm7Details.setDuesAssessment(HMSUtil
						.convertStringTypeDateToDateType(box
								.get("duesAssessingDate")));

			pensionForm7Details.setDeficiencies(box.get("deficiency"));
			pensionForm7Details.setInterruptionInService(box
					.getString("interruptionInService"));
			pensionForm7Details.setSuspensionPeriod(box
					.getString("suspensionPeriod"));
			pensionForm7Details.setOtherService(box.getString("otherService"));
			pensionForm7Details.setTotal(box.getString("total"));
			pensionForm7Details.setEmolReckoningGratuity(box
					.getString("emolGratuity"));
			if (box.get("form5Date") != null
					&& !box.get("form5Date").equals(""))
				pensionForm7Details.setForm5Date(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("form5Date")));

			if (box.getString("proposedGratuity") != null
					&& !box.getString("proposedGratuity").equals(""))
				pensionForm7Details.setProposedGratuity(new BigDecimal(box
						.getString("proposedGratuity")));
			if (box.getString("pensionDate") != null
					&& !box.getString("pensionDate").equals(""))
				pensionForm7Details.setPensionDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("pensionDate")));
			if (box.getString("proposedAmount") != null
					&& !box.getString("proposedAmount").equals(""))
				pensionForm7Details.setProposedAmount(new BigDecimal(box
						.getString("proposedAmount")));
			if (box.getString("licenceFee") != null
					&& !box.getString("licenceFee").equals(""))
				pensionForm7Details.setLicenceFee(new BigDecimal(box
						.getString("licenceFee")));
			if (box.getString("duesReferred") != null
					&& !box.getString("duesReferred").equals(""))
				pensionForm7Details.setDuesReferred(new BigDecimal(box
						.getString("duesReferred")));
			pensionForm7Details.setNominationForGratuity(box
					.getString("deathRetirementGruatuity"));
			pensionForm7Details
					.setFamilyPension(box.getString("familyPension"));
			pensionForm7Details.setPlaceOfPayment(box
					.getString("placeOfPayment"));
			pensionForm7Details.setAccountHeadPensionGratutityDebit(box
					.getString("accountHead"));
			hbt.save(pensionForm7Details);

			Iterator itr = fromDateList.iterator();
			for (int i = 0; i < fromDateList.size(); i++) {
				PensionForm7EmolumentsDetail pensionForm7EmolumentsDetail = new PensionForm7EmolumentsDetail();
				pensionForm7EmolumentsDetail.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateList.get(i)));
				pensionForm7EmolumentsDetail.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateList.get(i)));
				pensionForm7EmolumentsDetail.setPay(payList.get(i));
				// MasPersonnelDetails masPersonnelDetailsObj= new
				// MasPersonnelDetails();
				// masPersonnelDetails.setId(box.getInt("personnelId"));
				pensionForm7EmolumentsDetail
						.setPersonnel(masPersonnelDetailsObj);
				pensionForm7EmolumentsDetail.setForm7(pensionForm7Details);
				pensionForm7EmolumentsDetail.setNoOfMonths(noOfMonthsList
						.get(i));
				pensionForm7EmolumentsDetail.setPersonelPay(personelPayList
						.get(i));
				pensionForm7EmolumentsDetail
						.setAverageEmoluments(averageEmolList.get(i));
				pensionForm7EmolumentsDetail.setLastChgBy(box
						.getString("changed_by"));
				pensionForm7EmolumentsDetail.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionForm7EmolumentsDetail.setLastChgTime(box
						.getString("changed_time"));
				hbt.save(pensionForm7EmolumentsDetail);

			}

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public Map<String, Object> showPersonnelSearchForUpdatePersonnelAndForm7Jsp(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> personnelDetailList = new ArrayList<MasPersonnelDetails>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		String jspName = "";
		if (dataMap.get("personnelName") != null) {
			personnelName = (String) dataMap.get("personnelName");
		}
		if (dataMap.get("passNo") != null) {
			passNo = (Integer) dataMap.get("passNo");
		}
		if (dataMap.get("unitId") != null) {
			unitId = (Integer) dataMap.get("unitId");
		}
		if (dataMap.get("designationId") != null) {
			designationId = (Integer) dataMap.get("designationId");
		}
		if (dataMap.get("jspName") != null) {
			jspName = (String) dataMap.get("jspName");
		}
		try {
			Criteria crit = null;
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();
			if (jspName.equals("form7")) {
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("Form7Status", "o"));
			}
			if (jspName.equals("form8")) {
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("Form8Status", "o"));
			}
			if (jspName.equals("updateForm8")) {
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("Form8Status", "c"));
			}
			if (jspName.equals("updatePersonnelDetails")) {
				crit = session.createCriteria(MasPersonnelDetails.class);

			}
			if (jspName.equals("retirementEntry")) {
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("RetirementEntryStatus", "o"));

			}
			if (jspName.equals("updateRetirementForm")) {
				crit = session.createCriteria(MasPersonnelDetails.class).add(
						Restrictions.eq("RetirementEntryStatus", "c"));

			}
			if (personnelName != "") {
				crit = crit.add(Restrictions.like("PersonnelName",
						personnelName + "%"));

			}
			if (passNo != 0) {
				crit = crit.add(Restrictions.eq("PassNo", passNo));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (designationId != 0) {
				crit = crit.createAlias("Designation", "designation").add(
						Restrictions.eq("designation.Id", designationId));
			}
			personnelDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("personnelDetailList", personnelDetailList);
		map.put("unitList", unitList);
		map.put("designationList", designationList);
		return map;
	}

	public Map<String, Object> showUpdatePersonnelSearchForForm7(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> personnelDetailList = new ArrayList<MasPersonnelDetails>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (dataMap.get("personnelName") != null) {
			personnelName = (String) dataMap.get("personnelName");
		}
		if (dataMap.get("passNo") != null) {
			passNo = (Integer) dataMap.get("passNo");
		}
		if (dataMap.get("unitId") != null) {
			unitId = (Integer) dataMap.get("unitId");
		}
		if (dataMap.get("designationId") != null) {
			designationId = (Integer) dataMap.get("designationId");
		}

		//System.out.println("pass no=====" + passNo);
		try {
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).list();

			Criteria crit = session.createCriteria(MasPersonnelDetails.class)
					.add(Restrictions.eq("Form7Status", "c"));

			if (personnelName != "") {
				crit = crit.add(Restrictions.like("PersonnelName",
						personnelName + "%"));

			}
			if (passNo != 0) {
				crit = crit.add(Restrictions.eq("PassNo", passNo));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (designationId != 0) {
				crit = crit.createAlias("Designation", "designation").add(
						Restrictions.eq("designation.Id", designationId));
			}

			personnelDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("unitList", unitList);
		map.put("designationList", designationList);
		map.put("personnelDetailList", personnelDetailList);

		return map;
	}

	@SuppressWarnings("unused")
	public Map<String, Object> showUpdateForm7Jsp(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PensionForm7Details> pensionForm7List = new ArrayList<PensionForm7Details>();
		List<PensionForm7EmolumentsDetail> pensionForm7EmolList = new ArrayList<PensionForm7EmolumentsDetail>();

		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		List<PensionEmoluments> pensionEmolList = new ArrayList<PensionEmoluments>();
		List<PensionEol> pensionEolList = new ArrayList<PensionEol>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			pensionForm7List = session
					.createCriteria(PensionForm7Details.class).createAlias(
							"Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();

			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();
			pensionEmolList = session.createCriteria(PensionEmoluments.class)
					.createAlias("Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();
			pensionEolList = session.createCriteria(PensionEol.class)
					.createAlias("Personnel", "personnel").add(
							Restrictions.eq("personnel.Id", personnelId))
					.list();

			PensionForm7Details pensionForm7Details = (PensionForm7Details) pensionForm7List
					.get(0);
			int pensionForm7Id = pensionForm7Details.getId();

			pensionForm7EmolList = session.createCriteria(
					PensionForm7EmolumentsDetail.class).createAlias("Form7",
					"form7").add(Restrictions.eq("form7.Id", pensionForm7Id))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pensionForm7List", pensionForm7List);
		map.put("pensionForm7EmolList", pensionForm7EmolList);
		map.put("masPersonnelDetailsList", masPersonnelDetailsList);
		map.put("pensionEmolList", pensionEmolList);
		map.put("pensionEolList", pensionEolList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean updateForm7Entry(Box box, Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		List<String> fromDateList = (List<String>) dataMap.get("fromDateList");
		List<String> toDateList = (List<String>) dataMap.get("toDateList");
		List<BigDecimal> payList = (List<BigDecimal>) dataMap.get("payList");
		List<Integer> noOfMonthsList = (List<Integer>) dataMap
				.get("noOfMonthsList");
		List<BigDecimal> personelPayList = (List<BigDecimal>) dataMap
				.get("personelPayList");
		List<BigDecimal> averageEmolList = (List<BigDecimal>) dataMap
				.get("averageEmolList");
		int pensionForm7Id = (Integer) dataMap.get("pensionForm7Id");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<PensionForm7EmolumentsDetail> pensionForm7EmolList = session
					.createCriteria(PensionForm7EmolumentsDetail.class)
					.createAlias("Form7", "form7").add(
							Restrictions.eq("form7.Id", pensionForm7Id)).list();
			hbt.deleteAll(pensionForm7EmolList);

			PensionForm7Details pensionForm7Details = (PensionForm7Details) hbt
					.load(PensionForm7Details.class, pensionForm7Id);

			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionForm7Details.setPersonnel(masPersonnelDetails);

			pensionForm7Details.setGratuityPeriod(box
					.getString("gratuityPeriod"));
			pensionForm7Details.setGratuityRecievedMilitary(box
					.getString("recievedGratuityForMilitaryService"));
			pensionForm7Details.setGratuityRecievedCivilService(box
					.getString("recievedGratuityForCivilService"));
			if (box.get("noDemandCertificate") != null
					&& !box.get("noDemandCertificate").equals(""))
				pensionForm7Details.setNoDemandCertificate(HMSUtil
						.convertStringTypeDateToDateType(box
								.get("noDemandCertificate")));
			if (box.get("pensionQualifyingDate") != null
					&& !box.get("pensionQualifyingDate").equals(""))
				pensionForm7Details.setQualifyingPension(HMSUtil
						.convertStringTypeDateToDateType(box
								.get("pensionQualifyingDate")));
			if (box.get("duesAssessingDate") != null
					&& !box.get("duesAssessingDate").equals(""))
				pensionForm7Details.setDuesAssessment(HMSUtil
						.convertStringTypeDateToDateType(box
								.get("duesAssessingDate")));

			pensionForm7Details.setDeficiencies(box.get("deficiency"));
			pensionForm7Details.setInterruptionInService(box
					.getString("interruptionInService"));
			pensionForm7Details.setSuspensionPeriod(box
					.getString("suspensionPeriod"));
			pensionForm7Details.setOtherService(box.getString("otherService"));
			pensionForm7Details.setTotal(box.getString("total"));
			pensionForm7Details.setEmolReckoningGratuity(box
					.getString("emolGratuity"));

			if (box.get("form5Date") != null
					&& !box.get("form5Date").equals(""))
				pensionForm7Details.setForm5Date(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("form5Date")));

			if (box.getString("proposedGratuity") != null
					&& !box.getString("proposedGratuity").equals(""))
				pensionForm7Details.setProposedGratuity(new BigDecimal(box
						.getString("proposedGratuity")));
			if (box.getString("pensionDate") != null
					&& !box.getString("pensionDate").equals(""))
				pensionForm7Details.setPensionDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("pensionDate")));
			if (box.getString("proposedAmount") != null
					&& !box.getString("proposedAmount").equals(""))
				pensionForm7Details.setProposedAmount(new BigDecimal(box
						.getString("proposedAmount")));
			if (box.getString("licenceFee") != null
					&& !box.getString("licenceFee").equals(""))
				pensionForm7Details.setLicenceFee(new BigDecimal(box
						.getString("licenceFee")));
			if (box.getString("duesReferred") != null
					&& !box.getString("duesReferred").equals(""))
				pensionForm7Details.setDuesReferred(new BigDecimal(box
						.getString("duesReferred")));
			pensionForm7Details.setNominationForGratuity(box
					.getString("deathRetirementGruatuity"));
			pensionForm7Details
					.setFamilyPension(box.getString("familyPension"));
			pensionForm7Details.setPlaceOfPayment(box
					.getString("placeOfPayment"));
			pensionForm7Details.setAccountHeadPensionGratutityDebit(box
					.getString("accountHead"));
			hbt.update(pensionForm7Details);

			Iterator itr = fromDateList.iterator();
			for (int i = 0; i < fromDateList.size(); i++) {
				PensionForm7EmolumentsDetail pensionForm7EmolumentsDetail = new PensionForm7EmolumentsDetail();
				pensionForm7EmolumentsDetail.setFromDate(HMSUtil
						.convertStringTypeDateToDateType(fromDateList.get(i)));
				pensionForm7EmolumentsDetail.setToDate(HMSUtil
						.convertStringTypeDateToDateType(toDateList.get(i)));
				pensionForm7EmolumentsDetail.setPay(payList.get(i));
				MasPersonnelDetails masPersonnelDetailsObj = new MasPersonnelDetails();
				masPersonnelDetailsObj.setId(box.getInt("personnelId"));
				pensionForm7EmolumentsDetail
						.setPersonnel(masPersonnelDetailsObj);
				pensionForm7EmolumentsDetail.setForm7(pensionForm7Details);
				pensionForm7EmolumentsDetail.setNoOfMonths(noOfMonthsList
						.get(i));
				pensionForm7EmolumentsDetail.setPersonelPay(personelPayList
						.get(i));
				pensionForm7EmolumentsDetail
						.setAverageEmoluments(averageEmolList.get(i));
				pensionForm7EmolumentsDetail.setLastChgBy(box
						.getString("changed_by"));
				pensionForm7EmolumentsDetail.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changed_date")));
				pensionForm7EmolumentsDetail.setLastChgTime(box
						.getString("changed_time"));
				hbt.save(pensionForm7EmolumentsDetail);

			}

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public Map<String, Object> showPersonnelDetailsForForm8Entry(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();

		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masPersonnelDetailsList", masPersonnelDetailsList);

		return map;
	}

	public boolean submitForm8Entry(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasPersonnelDetails masPersonnelDetailsObj = (MasPersonnelDetails) hbt
					.load(MasPersonnelDetails.class, box.getInt("personnelId"));
			masPersonnelDetailsObj.setForm8Status("c");
			hbt.update(masPersonnelDetailsObj);

			PensionForm8Entry pensionForm8Entry = new PensionForm8Entry();
			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionForm8Entry.setPersonnel(masPersonnelDetails);

			pensionForm8Entry.setFileNo(box.getString("fileNo"));
			if (box.get("date") != null && !box.get("date").equals(""))
				pensionForm8Entry
						.setDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("date")));

			if (box.getString("balance") != null
					&& !box.getString("balance").equals(""))
				pensionForm8Entry.setBalanceOfHouse(new BigDecimal(box
						.getString("balance")));
			else
				pensionForm8Entry.setBalanceOfHouse(new BigDecimal("0"));
			if (box.getString("overPayment") != null
					&& !box.getString("overPayment").equals(""))
				pensionForm8Entry.setOverPayment(new BigDecimal(box
						.getString("overPayment")));
			else
				pensionForm8Entry.setOverPayment(new BigDecimal("0"));
			if (box.getString("taxDeductible") != null
					&& !box.getString("taxDeductible").equals(""))
				pensionForm8Entry.setIncomeTaxDeductible(new BigDecimal(box
						.getString("taxDeductible")));
			else
				pensionForm8Entry.setIncomeTaxDeductible(new BigDecimal("0"));
			if (box.getString("arrears") != null
					&& !box.getString("arrears").equals(""))
				pensionForm8Entry.setArrearsOfLicenceFee(new BigDecimal(box
						.getString("arrears")));
			else
				pensionForm8Entry.setArrearsOfLicenceFee(new BigDecimal("0"));
			if (box.getString("amountOfLicenceFee") != null
					&& !box.getString("amountOfLicenceFee").equals(""))
				pensionForm8Entry.setAmountOfLicenceFee(new BigDecimal(box
						.getString("amountOfLicenceFee")));
			else
				pensionForm8Entry.setAmountOfLicenceFee(new BigDecimal("0"));
			if (box.getString("otherDues") != null
					&& !box.getString("otherDues").equals(""))
				pensionForm8Entry.setOtherAssessedDues(new BigDecimal(box
						.getString("otherDues")));
			else
				pensionForm8Entry.setOtherAssessedDues(new BigDecimal("0"));
			if (box.getString("amountOfGratuityHeld") != null
					&& !box.getString("amountOfGratuityHeld").equals(""))
				pensionForm8Entry.setAmountOfGratuity(new BigDecimal(box
						.getString("amountOfGratuityHeld")));
			else
				pensionForm8Entry.setAmountOfGratuity(new BigDecimal("0"));
			if (box.getString("total") != null
					&& !box.getString("total").equals(""))
				pensionForm8Entry.setTotal(new BigDecimal(box
						.getString("total")));
			else
				pensionForm8Entry.setTotal(new BigDecimal("0"));

			pensionForm8Entry.setLastChgBy(box.getString("changed_by"));
			pensionForm8Entry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionForm8Entry.setLastChgTime(box.getString("changed_time"));
			hbt.save(pensionForm8Entry);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUpdateForm8Jsp(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PensionForm8Entry> pensionForm8EntryList = new ArrayList<PensionForm8Entry>();
		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			pensionForm8EntryList = session.createCriteria(
					PensionForm8Entry.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pensionForm8EntryList", pensionForm8EntryList);
		map.put("masPersonnelDetailsList", masPersonnelDetailsList);

		return map;
	}

	public boolean updateForm8Entry(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			PensionForm8Entry pensionForm8Entry = (PensionForm8Entry) hbt.load(
					PensionForm8Entry.class, box.getInt("form8Id"));

			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionForm8Entry.setPersonnel(masPersonnelDetails);

			pensionForm8Entry.setFileNo(box.getString("fileNo"));
			if (box.get("date") != null && !box.get("date").equals(""))
				pensionForm8Entry
						.setDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("date")));

			if (box.getString("balance") != null
					&& !box.getString("balance").equals(""))
				pensionForm8Entry.setBalanceOfHouse(new BigDecimal(box
						.getString("balance")));
			else
				pensionForm8Entry.setBalanceOfHouse(new BigDecimal("0"));
			if (box.getString("overPayment") != null
					&& !box.getString("overPayment").equals(""))
				pensionForm8Entry.setOverPayment(new BigDecimal(box
						.getString("overPayment")));
			else
				pensionForm8Entry.setOverPayment(new BigDecimal("0"));
			if (box.getString("taxDeductible") != null
					&& !box.getString("taxDeductible").equals(""))
				pensionForm8Entry.setIncomeTaxDeductible(new BigDecimal(box
						.getString("taxDeductible")));
			else
				pensionForm8Entry.setIncomeTaxDeductible(new BigDecimal("0"));
			if (box.getString("arrears") != null
					&& !box.getString("arrears").equals(""))
				pensionForm8Entry.setArrearsOfLicenceFee(new BigDecimal(box
						.getString("arrears")));
			else
				pensionForm8Entry.setArrearsOfLicenceFee(new BigDecimal("0"));
			if (box.getString("amountOfLicenceFee") != null
					&& !box.getString("amountOfLicenceFee").equals(""))
				pensionForm8Entry.setAmountOfLicenceFee(new BigDecimal(box
						.getString("amountOfLicenceFee")));
			else
				pensionForm8Entry.setAmountOfLicenceFee(new BigDecimal("0"));
			if (box.getString("otherDues") != null
					&& !box.getString("otherDues").equals(""))
				pensionForm8Entry.setOtherAssessedDues(new BigDecimal(box
						.getString("otherDues")));
			else
				pensionForm8Entry.setOtherAssessedDues(new BigDecimal("0"));
			if (box.getString("amountOfGratuityHeld") != null
					&& !box.getString("amountOfGratuityHeld").equals(""))
				pensionForm8Entry.setAmountOfGratuity(new BigDecimal(box
						.getString("amountOfGratuityHeld")));
			else
				pensionForm8Entry.setAmountOfGratuity(new BigDecimal("0"));
			if (box.getString("total") != null
					&& !box.getString("total").equals(""))
				pensionForm8Entry.setTotal(new BigDecimal(box
						.getString("total")));
			else
				pensionForm8Entry.setTotal(new BigDecimal("0"));

			pensionForm8Entry.setLastChgBy(box.getString("changed_by"));
			pensionForm8Entry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionForm8Entry.setLastChgTime(box.getString("changed_time"));
			hbt.update(pensionForm8Entry);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;

	}

	public boolean submitRetirementEntryForm(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasPersonnelDetails masPersonnelDetailsObj = (MasPersonnelDetails) hbt
					.load(MasPersonnelDetails.class, box.getInt("personnelId"));
			masPersonnelDetailsObj.setRetirementEntryStatus("c");
			hbt.update(masPersonnelDetailsObj);

			PensionRetirementEntry pensionRetirementEntry = new PensionRetirementEntry();
			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionRetirementEntry.setPersonnel(masPersonnelDetails);

			pensionRetirementEntry.setSubstantiveAppointment(box
					.getString("substantiveAppointment"));
			pensionRetirementEntry.setDeathCumRetirementGratuity(box
					.getString("deathRetirementGruatuity"));
			pensionRetirementEntry.setFamilyPension(box
					.getString("familyPension"));
			if (box.get("firstApplicationDate") != null
					&& !box.get("firstApplicationDate").equals(""))
				pensionRetirementEntry.setApplicationDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("firstApplicationDate")));
			pensionRetirementEntry
					.setInvolveInInquiry(box.getString("inquiry"));
			pensionRetirementEntry.setSuspensionDegradation(box
					.getString("suspensionOrDegradation"));
			pensionRetirementEntry.setGratuityPensionRecieved(box
					.getString("pensionRecieved"));
			pensionRetirementEntry.setRemarks(box.getString("remarks"));
			pensionRetirementEntry.setHeadOfficeOpinion(box
					.getString("headOfficeOpinion"));

			pensionRetirementEntry.setLastChgBy(box.getString("changed_by"));
			pensionRetirementEntry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionRetirementEntry
					.setLastChgTime(box.getString("changed_time"));
			hbt.save(pensionRetirementEntry);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;

	}

	public Map<String, Object> showUpdateRetirementForm(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PensionRetirementEntry> pensionRetirementEntryList = new ArrayList<PensionRetirementEntry>();
		List<MasPersonnelDetails> masPersonnelDetailsList = new ArrayList<MasPersonnelDetails>();
		int personnelId = (Integer) dataMap.get("personnelId");
		try {

			pensionRetirementEntryList = session.createCriteria(
					PensionRetirementEntry.class).createAlias("Personnel",
					"personnel").add(
					Restrictions.eq("personnel.Id", personnelId)).list();
			masPersonnelDetailsList = session.createCriteria(
					MasPersonnelDetails.class).add(
					Restrictions.eq("Id", personnelId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pensionRetirementEntryList", pensionRetirementEntryList);
		map.put("masPersonnelDetailsList", masPersonnelDetailsList);

		return map;

	}

	public boolean updateRetirementEntryForm(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			PensionRetirementEntry pensionRetirementEntry = (PensionRetirementEntry) hbt
					.load(PensionRetirementEntry.class, box
							.getInt("retirementFormId"));

			MasPersonnelDetails masPersonnelDetails = new MasPersonnelDetails();
			masPersonnelDetails.setId(box.getInt("personnelId"));
			pensionRetirementEntry.setPersonnel(masPersonnelDetails);

			pensionRetirementEntry.setSubstantiveAppointment(box
					.getString("substantiveAppointment"));
			pensionRetirementEntry.setDeathCumRetirementGratuity(box
					.getString("deathRetirementGruatuity"));
			pensionRetirementEntry.setFamilyPension(box
					.getString("familyPension"));
			if (box.get("firstApplicationDate") != null
					&& !box.get("firstApplicationDate").equals(""))
				pensionRetirementEntry.setApplicationDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("firstApplicationDate")));
			pensionRetirementEntry
					.setInvolveInInquiry(box.getString("inquiry"));
			pensionRetirementEntry.setSuspensionDegradation(box
					.getString("suspensionOrDegradation"));
			pensionRetirementEntry.setGratuityPensionRecieved(box
					.getString("pensionRecieved"));
			pensionRetirementEntry.setRemarks(box.getString("remarks"));
			pensionRetirementEntry.setHeadOfficeOpinion(box
					.getString("headOfficeOpinion"));

			pensionRetirementEntry.setLastChgBy(box.getString("changed_by"));
			pensionRetirementEntry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			pensionRetirementEntry
					.setLastChgTime(box.getString("changed_time"));
			hbt.update(pensionRetirementEntry);

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;

	}

	// -------------nidhi--------------------

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	//==============By Dipali=================================
	public Map<String, Object> fillRetier(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		int designationId = (Integer) dataMap.get("designationId");
		try {
			designationList = session.createCriteria(MasDesignation.class).add(
					Restrictions.eq("Status", "y")).add(Restrictions.eq("Id", designationId))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("designationList", designationList);

		return map;
	}

}
