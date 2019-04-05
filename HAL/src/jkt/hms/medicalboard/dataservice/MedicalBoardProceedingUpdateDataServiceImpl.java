package jkt.hms.medicalboard.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMedicalBoardDetails;
import jkt.hms.masters.business.MasMedicalBoardProceedings;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.medicalboard.controller.MedicalBoardProceedingsDTO;
import jkt.hms.util.HMSUtil;

import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MedicalBoardProceedingUpdateDataServiceImpl extends
		HibernateDaoSupport implements MedicalBoardProceedingUpdateDataService {
	int sId = 0;
	HttpSession session = null;

	@SuppressWarnings( { "unchecked", "deprecation" })
	public Map<String, Object> showMedicalBoardUpdateJsp(int Id) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasMedicalBoardProceedings> medicalBoardProceedingsList = new ArrayList<MasMedicalBoardProceedings>();
		List<MasMedicalBoardProceedings> medicalBoardProceedingsList1 = new ArrayList<MasMedicalBoardProceedings>();
		List<MasMedicalBoardDetails> medicalBoardDetailList = new ArrayList<MasMedicalBoardDetails>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasMedicalCategory> medicalCategoryList = new ArrayList<MasMedicalCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
		List<MasState> masStateList = new ArrayList<MasState>();
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		masDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");
		masStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");
		medicalBoardProceedingsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalBoardProceedings  where Id='"
						+ Id + "'");
		medicalBoardProceedingsList1 = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalBoardProceedings");
		medicalBoardDetailList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMedicalBoardDetails mc where mc.BoardProceedings='"
								+ Id + "'");
		masEmployeeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee me where me.Status='y'");
		medicalCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalCategory");
		map.put("medicalBoardProceedingsList", medicalBoardProceedingsList);
		map.put("medicalBoardProceedingsList1", medicalBoardProceedingsList1);
		map.put("medicalBoardDetailList", medicalBoardDetailList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("unitList", unitList);
		map.put("medicalCategoryList", medicalCategoryList);
		map.put("citylist", masDistrictList);
		map.put("stateList", masStateList);
		map.put("Id", Id);
		return map;

	}

	public boolean medicalBoardUpdateToDatabase(Map<String, Object> generalMap) {
		Session sess = (Session) getSession();
		String type = "";
		Date dateOfComminishning = new Date();
		String recordOfficeWithAddress = "";
		String pastMedicalHistory = "";
		String priorToPresentMedicalBoard = "";
		int boardPresident = 0;
		int member1Name = 0;
		int member2Name = 0;
		String weight = "";
		String height = "";
		String clinicalSummary = "";
		String disabilityAttributableStatus = "";
		String disabilityAttributableDesc = "";
		String disabilityAgrawatedStatus = "";
		String disabilityAgrawatedDesc = "";
		String medicalCategoryName = "";
		String medicalCategoryDuration = "";
		Date dateOfRectegorization = new Date();
		String placeOfRectegorization = "";
		int previousDisamblent = 0;
		int presentDisamblent = 0;
		String reasonForVariation = "";
		String restrictionRegardingEmployeement = "";
		String introductionByPresident = "";
		int state = 0;
		int district = 0;
		String addressOnLeave = "";
		String medicalCategoryNameWithDuration = "";
		Date ceasedDutyOn = null;
		int Id = 0;
		Id = (Integer) (generalMap.get("id"));
		state = (Integer) (generalMap.get("state"));
		district = (Integer) (generalMap.get("district"));
		addressOnLeave = (String) (generalMap.get("addressOnLeave"));
		medicalCategoryNameWithDuration = (String) (generalMap
				.get("medicalCategoryNameWithDuration"));
		ceasedDutyOn = (Date) (generalMap.get("ceasedDutyOn"));
		type = (String) (generalMap.get("type"));
		dateOfComminishning = (Date) (generalMap.get("dateOfComminishning"));
		recordOfficeWithAddress = (String) (generalMap
				.get("recordOfficeWithAddress"));
		pastMedicalHistory = (String) (generalMap.get("pastMedicalHistory"));
		priorToPresentMedicalBoard = (String) (generalMap
				.get("priorToPresentMedicalBoard"));
		boardPresident = (Integer) generalMap.get("boardPresident");
		member1Name = (Integer) generalMap.get("member1Name");
		weight = (String) (generalMap.get("weight"));
		height = (String) (generalMap.get("height"));
		clinicalSummary = (String) (generalMap.get("clinicalSummary"));
		disabilityAttributableStatus = (String) (generalMap
				.get("disabilityAttributableStatus"));
		disabilityAttributableDesc = (String) (generalMap
				.get("disabilityAttributableDesc"));
		disabilityAgrawatedStatus = (String) (generalMap
				.get("disabilityAgrawatedStatus"));
		disabilityAgrawatedDesc = (String) (generalMap
				.get("disabilityAgrawatedDesc"));
		medicalCategoryName = (String) (generalMap.get("medicalCategoryName"));
		medicalCategoryDuration = (String) (generalMap
				.get("medicalCategoryDuration"));
		dateOfRectegorization = (Date) (generalMap.get("dateOfRectegorization"));
		placeOfRectegorization = (String) (generalMap
				.get("placeOfRectegorization"));
		previousDisamblent = Integer.parseInt((generalMap
				.get("previousDisamblent")).toString());
		presentDisamblent = (Integer.parseInt(generalMap.get(
				"presentDisamblent").toString()));
		reasonForVariation = (String) (generalMap).get("reasonForVariation");
		restrictionRegardingEmployeement = (String) (generalMap
				.get("restrictionRegardingEmployeement"));
		introductionByPresident = (String) (generalMap
				.get("introductionByPresident"));
		member2Name = (Integer) generalMap.get("member2Name");

		MasMedicalBoardProceedings masMedicalBoardProceedings = (MasMedicalBoardProceedings) getHibernateTemplate()
				.load(MasMedicalBoardProceedings.class, Id);
		masMedicalBoardProceedings.setMedicalType(type);
		masMedicalBoardProceedings.setDateOfCommissioning(dateOfComminishning);
		masMedicalBoardProceedings.setAddress(recordOfficeWithAddress);
		masMedicalBoardProceedings.setPastMedicalHistory(pastMedicalHistory);
		masMedicalBoardProceedings
				.setMedicalCategory(priorToPresentMedicalBoard);
		if (boardPresident != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(boardPresident);
			masMedicalBoardProceedings.setBoardPresident(masEmployee);
		}
		if (member1Name != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(member1Name);
			masMedicalBoardProceedings.setMember1Name(masEmployee);
		}
		if (member2Name != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(member2Name);
			masMedicalBoardProceedings.setMember2Name(masEmployee);
		}
		if (district != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(district);
			masMedicalBoardProceedings.setCity(masDistrict);
		}
		if (state != 0) {
			MasState masState = new MasState();
			masState.setId(state);
			masMedicalBoardProceedings.setState(masState);
		}
		masMedicalBoardProceedings.setAddressOnLeave(addressOnLeave);
		masMedicalBoardProceedings
				.setMedicalCategoryWithDuration(medicalCategoryNameWithDuration);
		if (ceasedDutyOn != null) {
			masMedicalBoardProceedings.setCeasedDutyOn(ceasedDutyOn);
		}
		masMedicalBoardProceedings.setClinicalSummary(clinicalSummary);
		masMedicalBoardProceedings.setWeight(weight);
		masMedicalBoardProceedings.setHeight(height);
		masMedicalBoardProceedings
				.setDisabilityAttributableStatus(disabilityAttributableStatus);
		masMedicalBoardProceedings
				.setDisabilityAttributableDesc(disabilityAttributableDesc);
		masMedicalBoardProceedings
				.setAggravatedServiceStatus(disabilityAgrawatedStatus);
		masMedicalBoardProceedings
				.setAggravatedServiceDesc(disabilityAgrawatedDesc);
		masMedicalBoardProceedings
				.setMedicalCategoryDuration(medicalCategoryName);
		masMedicalBoardProceedings
				.setMedicalCategoryDuration(medicalCategoryDuration);
		if (dateOfRectegorization != null) {
			masMedicalBoardProceedings
					.setDateOfRecategorization(dateOfRectegorization);
		}
		masMedicalBoardProceedings
				.setPlaceOfRecategorization(placeOfRectegorization);
		masMedicalBoardProceedings.setPreviousDisablement(previousDisamblent);
		masMedicalBoardProceedings.setPresentDisablement(presentDisamblent);
		masMedicalBoardProceedings.setReasonsForVariation(reasonForVariation);
		masMedicalBoardProceedings
				.setRestrictionRegardingEmployment(restrictionRegardingEmployeement);
		masMedicalBoardProceedings
				.setInstructionByPresident(introductionByPresident);
		boolean successfullyUpdated = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);

		try {
			hbt1.update(masMedicalBoardProceedings);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getting the second updated entity
		List<MedicalBoardProceedingsDTO> mbiList = (List<MedicalBoardProceedingsDTO>) generalMap
				.get("mbUnfitExplanationList");

		// getting entity from the table
		List<MasMedicalBoardDetails> mbiListFromDatabase = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMedicalBoardDetails as mbp where mbp.BoardProceedings='"
								+ Id + "'");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		org.hibernate.Transaction tx = null;
		if (mbiListFromDatabase != null && mbiList != null) {
			tx = sess.beginTransaction();
			int counter;

			for (MasMedicalBoardDetails mbInstructionToCandidateUnfitExpl : mbiListFromDatabase) {
				counter = 1;
				for (MedicalBoardProceedingsDTO mbMedicalBoardUpdateUpdateDTO : mbiList) {
					if (!mbMedicalBoardUpdateUpdateDTO.getId().equals("")
							&& mbInstructionToCandidateUnfitExpl.getId() == Integer
									.parseInt(mbMedicalBoardUpdateUpdateDTO
											.getId())) {

						try {
							MasMedicalBoardDetails mbInstructionToCandidateUnfitExplUpdate = (MasMedicalBoardDetails) getHibernateTemplate()
									.get(
											MasMedicalBoardDetails.class,
											mbInstructionToCandidateUnfitExpl
													.getId());
							mbInstructionToCandidateUnfitExplUpdate
									.setDisabilities(mbMedicalBoardUpdateUpdateDTO
											.getDisability());
							mbInstructionToCandidateUnfitExplUpdate
									.setDateOfOrigin(HMSUtil
											.dateFormatterDDMMYYYY(mbMedicalBoardUpdateUpdateDTO
													.getDateOfOrigin()));
							mbInstructionToCandidateUnfitExplUpdate
									.setPlaceOfOrigin(mbMedicalBoardUpdateUpdateDTO
											.getPlaceOfOrigin());
							mbInstructionToCandidateUnfitExplUpdate
									.setPreviousMedicalCategorisatrion(mbMedicalBoardUpdateUpdateDTO
											.getPreviousMedicalCategorization());
							mbInstructionToCandidateUnfitExplUpdate
									.setPreviousMedicalCategorisationDate(HMSUtil
											.dateFormatterDDMMYYYY(mbMedicalBoardUpdateUpdateDTO
													.getPreviousMedicalCategorizationDate()));
							mbInstructionToCandidateUnfitExplUpdate
									.setNextMedicalCategorisationDue(HMSUtil
											.dateFormatterDDMMYYYY(mbMedicalBoardUpdateUpdateDTO
													.getNextMedicalCategorizationDate()));
							hbt.update(mbInstructionToCandidateUnfitExplUpdate);
							mbMedicalBoardUpdateUpdateDTO.setId("0");// updating
							// DTO in
							// mbiList
							counter++;
							break;

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (mbMedicalBoardUpdateUpdateDTO.getId()
							.equals("0")
							&& mbiList.size() > counter) {
						counter++;
						continue;
					} else if (!mbMedicalBoardUpdateUpdateDTO.getId()
							.equals("")) {
						try {
							MasMedicalBoardDetails mbInstructionToCandidateUnfitExplUpdate = (MasMedicalBoardDetails) getHibernateTemplate()
									.get(
											MasMedicalBoardDetails.class,
											mbInstructionToCandidateUnfitExpl
													.getId());

							hbt.delete(mbInstructionToCandidateUnfitExplUpdate);
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (MedicalBoardProceedingsDTO mbInstructionToCandidateUpdateDTO : mbiList) {
				if (mbInstructionToCandidateUpdateDTO.getId() != null
						&& mbInstructionToCandidateUpdateDTO.getId().equals("")) {

					hbt.setCheckWriteOperations(false);
					MasMedicalBoardProceedings mbInstructionToCandidateMaster1 = new MasMedicalBoardProceedings();
					MasMedicalBoardDetails mbInstructionToCandidateUnfitExplUpdate = new MasMedicalBoardDetails();
					mbInstructionToCandidateUnfitExplUpdate
							.setDisabilities(mbInstructionToCandidateUpdateDTO
									.getDisability());
					mbInstructionToCandidateUnfitExplUpdate
							.setDateOfOrigin(HMSUtil
									.dateFormatterDDMMYYYY(mbInstructionToCandidateUpdateDTO
											.getDateOfOrigin()));
					mbInstructionToCandidateUnfitExplUpdate
							.setPlaceOfOrigin(mbInstructionToCandidateUpdateDTO
									.getPlaceOfOrigin());
					mbInstructionToCandidateUnfitExplUpdate
							.setPreviousMedicalCategorisatrion(mbInstructionToCandidateUpdateDTO
									.getPreviousMedicalCategorization());
					mbInstructionToCandidateUnfitExplUpdate
							.setPreviousMedicalCategorisationDate(HMSUtil
									.dateFormatterDDMMYYYY(mbInstructionToCandidateUpdateDTO
											.getPreviousMedicalCategorizationDate()));
					mbInstructionToCandidateUnfitExplUpdate
							.setNextMedicalCategorisationDue(HMSUtil
									.dateFormatterDDMMYYYY(mbInstructionToCandidateUpdateDTO
											.getNextMedicalCategorizationDate()));

					mbInstructionToCandidateMaster1.setId(Id);

					mbInstructionToCandidateUnfitExplUpdate
							.setBoardProceedings(mbInstructionToCandidateMaster1);
					hbt.save(mbInstructionToCandidateUnfitExplUpdate);

				}
			}
			successfullyUpdated = true;
			tx.commit();
		}

		return successfullyUpdated;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}
}
