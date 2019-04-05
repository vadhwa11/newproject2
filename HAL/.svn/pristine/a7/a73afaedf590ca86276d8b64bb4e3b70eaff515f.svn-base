package jkt.hms.masters.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasEmployeeType;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasProposedMPR;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasWardImpanneledHospital;
import jkt.hms.masters.business.MasZonal;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GeneralMasterDataServiceImpl extends HibernateDaoSupport implements
		GeneralMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	// ---------------------------------------Title-------------------------

	public boolean addTitle(MasTitle masTitle) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTitle);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editTitleToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String titleName = "";
		@SuppressWarnings("unused")
		String titleCode = "";
		int titleId = 0;
		String changedBy = "";
		try {
			titleId = (Integer) generalMap.get("id");
			titleCode = (String) generalMap.get("titleCode");
			titleName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			//System.out.println("Exception before masTitle in dataserviceImpl "+ e);
		}

		MasTitle masTitle = (MasTitle) getHibernateTemplate().get(
				MasTitle.class, titleId);

		masTitle.setId(titleId);
		masTitle.setTitleName(titleName);
		masTitle.setLastChgBy(changedBy);
		masTitle.setLastChgDate(currentDate);
		masTitle.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masTitle);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTitle(String titleCode, String titleName) {
		List<MasTitle> searchTitleList = new ArrayList<MasTitle>();
		Map<String, Object> titleFieldsMap = new HashMap<String, Object>();
		try {
			if ((titleName != null) || (titleCode == null)) {

				searchTitleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTitle imc where imc.TitleName like '"
								+ titleName + "%' order by imc.TitleName");
			} else {
				searchTitleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTitle imc where imc.TitleCode like '"
								+ titleCode + "%' order by imc.TitleCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchTitleList  " + e);
		}
		titleFieldsMap.put("searchTitleList", searchTitleList);
		return titleFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTitleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> searchTitleList = new ArrayList<MasTitle>();
		searchTitleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTitle ");
		map.put("searchTitleList", searchTitleList);
		return map;
	}

	public boolean deleteTitle(int titleId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTitle masTitle = new MasTitle();
		masTitle = (MasTitle) getHibernateTemplate().get(MasTitle.class,
				titleId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTitle.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTitle.setStatus("y");
				dataDeleted = false;
			}
		}
		masTitle.setLastChgBy(changedBy);
		masTitle.setLastChgDate(currentDate);
		masTitle.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masTitle);
		return dataDeleted;
	}

	// ------------------------------------------------- Relation
	// ---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRelationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRelation> searchRelationList = new ArrayList<MasRelation>();
		searchRelationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRelation ");
		map.put("searchRelationList", searchRelationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRelation(String relationCode,
			String relationName) {
		List<MasRelation> searchRelationList = new ArrayList<MasRelation>();
		Map<String, Object> relationFieldsMap = new HashMap<String, Object>();
		try {
			if ((relationCode != null) || (relationName == null)) {
				searchRelationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRelation mr where mr.RelationName like '"
								+ relationCode + "%' order by mr.RelationName");
			} else {
				searchRelationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRelation mr where mr.NewRelationName like '"
								+ relationName + "%' order by mr.NewRelationName");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchRelation  " + e);
		}
		relationFieldsMap.put("searchRelationList", searchRelationList);
		return relationFieldsMap;
	}

	public boolean addRelation(MasRelation masRelation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRelation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editRelationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String relationName = "";
		@SuppressWarnings("unused")
		String relationCode = "";
		int relationId = 0;
		String changedBy = "";
		String codeNewRelation="";
		String codeRelation="";
		relationId = (Integer) generalMap.get("id");
		relationCode = (String) generalMap.get("relationCode");
		relationName = (String) generalMap.get("name");
		
		codeNewRelation = (String) generalMap.get("codeNewRelation");
		codeRelation = (String) generalMap.get("codeRelation");
		
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRelation masRelation = (MasRelation) getHibernateTemplate().get(
				MasRelation.class, relationId);

		masRelation.setId(relationId);
		
		
		masRelation.setRelationName(relationCode);
		masRelation.setNewRelationName(relationName);
		masRelation.setRelationCode(codeRelation);
		masRelation.setNewRelationCode(codeNewRelation);
		
		masRelation.setLastChgBy(changedBy);
		masRelation.setLastChgDate(currentDate);
		masRelation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRelation);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteRelation(int relationId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRelation masRelation = new MasRelation();
		masRelation = (MasRelation) getHibernateTemplate().get(
				MasRelation.class, relationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masRelation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRelation.setStatus("y");
				dataDeleted = false;
			}
		}
		masRelation.setLastChgBy(changedBy);
		masRelation.setLastChgDate(currentDate);
		masRelation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRelation);
		return dataDeleted;
	}

	// ------------------------------------Religion---------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReligionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
		searchReligionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReligion ");
		map.put("searchReligionList", searchReligionList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchReligion(String religionCode,
			String religionName) {
		List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
		Map<String, Object> religionFieldsMap = new HashMap<String, Object>();
		try {
			if ((religionName != null) || (religionCode == null)) {
				searchReligionList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReligion mr where mr.ReligionName like '"
								+ religionName + "%' order by mr.ReligionName");
			} else {
				searchReligionList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReligion mr where mr.ReligionCode like '"
								+ religionCode + "%' order by mr.ReligionCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchTitle  " + e);
		}
		religionFieldsMap.put("searchReligionList", searchReligionList);
		return religionFieldsMap;
	}

	public boolean addReligion(MasReligion masReligion) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masReligion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteReligion(int religionId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasReligion masReligion = new MasReligion();
		masReligion = (MasReligion) getHibernateTemplate().get(
				MasReligion.class, religionId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masReligion.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masReligion.setStatus("y");
				dataDeleted = false;
			}
		}
		masReligion.setLastChgBy(changedBy);
		masReligion.setLastChgDate(currentDate);
		masReligion.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReligion);
		return dataDeleted;
	}

	public boolean editReligionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String religionName = "";
		@SuppressWarnings("unused")
		String religionCode = "";
		int religionId = 0;
		String changedBy = "";
		religionId = (Integer) generalMap.get("id");
		religionCode = (String) generalMap.get("religionCode");
		religionName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasReligion masReligion = (MasReligion) getHibernateTemplate().get(
				MasReligion.class, religionId);
		masReligion.setId(religionId);
		masReligion.setReligionName(religionName);
		masReligion.setLastChgBy(changedBy);
		masReligion.setLastChgDate(currentDate);
		masReligion.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReligion);
		dataUpdated = true;
		return dataUpdated;
	}

	// ------------------------------------Marital Status
	// ---------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMaritalStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMaritalStatus> searchMaritalStatusList = new ArrayList<MasMaritalStatus>();
		searchMaritalStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMaritalStatus");
		map.put("searchMaritalStatusList", searchMaritalStatusList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName) {
		List<MasMaritalStatus> searchMaritalStatusList = new ArrayList<MasMaritalStatus>();
		Map<String, Object> maritalStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((maritalStatusName != null) || (maritalStatusCode == null)) {
				searchMaritalStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMaritalStatus sc where sc.MaritalStatusName like '"
										+ maritalStatusName
										+ "%' order by sc.MaritalStatusName");
			} else {
				searchMaritalStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMaritalStatus sc where sc.MaritalStatusCode like '"
										+ maritalStatusCode
										+ "%' order by sc.MaritalStatusCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMaritalStatus  " + e);
		}
		maritalStatusFieldsMap.put("searchMaritalStatusList",
				searchMaritalStatusList);
		return maritalStatusFieldsMap;
	}

	public boolean addMaritalStatus(MasMaritalStatus masMaritalStatus) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMaritalStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
		masMaritalStatus = (MasMaritalStatus) getHibernateTemplate().get(
				MasMaritalStatus.class, maritalStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masMaritalStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masMaritalStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masMaritalStatus.setLastChgBy(changedBy);
		masMaritalStatus.setLastChgDate(currentDate);
		masMaritalStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMaritalStatus);
		return dataDeleted;
	}

	public boolean editMaritalStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String maritalStatusName = "";
		@SuppressWarnings("unused")
		String maritalStatusCode = "";
		int maritalStatusId = 0;
		String changedBy = "";
		maritalStatusId = (Integer) generalMap.get("id");
		maritalStatusCode = (String) generalMap.get("maritalStatusCode");
		maritalStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasMaritalStatus masMaritalStatus = (MasMaritalStatus) getHibernateTemplate()
				.get(MasMaritalStatus.class, maritalStatusId);
		masMaritalStatus.setId(maritalStatusId);
		masMaritalStatus.setMaritalStatusName(maritalStatusName);
		masMaritalStatus.setLastChgBy(changedBy);
		masMaritalStatus.setLastChgDate(currentDate);
		masMaritalStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMaritalStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	// -----------------------------------------Disposal----------------------------------------

	public Map<String, Object> showDisposalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposal> searchDisposalList = new ArrayList<MasDisposal>();
		searchDisposalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDisposal ");
		map.put("searchDisposalList", searchDisposalList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDisposal(String disposalCode,
			String disposalName) {
		List<MasDisposal> searchDisposalList = new ArrayList<MasDisposal>();
		Map disposalFieldsMap = new HashMap();
		try {
			if ((disposalName != null) || (disposalCode == null)) {
				searchDisposalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDisposal md where md.DisposalName like '"
								+ disposalName + "%' order by md.DisposalName");
			} else {
				searchDisposalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDisposal md where md.DisposalCode like '"
								+ disposalCode + "%' order by md.DisposalCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchDisposal  " + e);
		}
		disposalFieldsMap.put("searchDisposalList", searchDisposalList);
		return disposalFieldsMap;
	}

	public boolean addDisposal(MasDisposal masDisposal) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDisposal);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDisposal(int disposalId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDisposal masDisposal = new MasDisposal();
		masDisposal = (MasDisposal) getHibernateTemplate().get(
				MasDisposal.class, disposalId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDisposal.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDisposal.setStatus("y");
				dataDeleted = false;
			}
		}
		masDisposal.setLastChgBy(changedBy);
		masDisposal.setLastChgDate(currentDate);
		masDisposal.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposal);
		return dataDeleted;
	}

	public boolean editDisposalToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String disposalName = "";
		@SuppressWarnings("unused")
		String disposalCode = "";
		int disposalId = 0;
		String changedBy = "";
		disposalId = (Integer) generalMap.get("id");
		disposalCode = (String) generalMap.get("disposalCode");
		disposalName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDisposal masDisposal = (MasDisposal) getHibernateTemplate().get(
				MasDisposal.class, disposalId);

		masDisposal.setId(disposalId);
		masDisposal.setDisposalName(disposalName);
		masDisposal.setLastChgBy(changedBy);
		masDisposal.setLastChgDate(currentDate);
		masDisposal.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDisposal);
		dataUpdated = true;
		return dataUpdated;
	}

	// ---------------------Admission
	// Type--------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAdmissionTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAdmissionType> searchAdmissionTypeList = new ArrayList<MasAdmissionType>();
		searchAdmissionTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAdmissionType ");
		map.put("searchAdmissionTypeList", searchAdmissionTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName) {
		List<MasAdmissionType> searchAdmissionTypeList = new ArrayList<MasAdmissionType>();
		Map admissionTypeFieldsMap = new HashMap();
		try {
			if ((admissionTypeName != null) || (admissionTypeCode == null)) {
				searchAdmissionTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAdmissionType mat where mat.AdmissionTypeName like '"
										+ admissionTypeName
										+ "%' order by mat.AdmissionTypeName");
			} else {
				searchAdmissionTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAdmissionType mat where mat.AdmissionTypeCode like '"
										+ admissionTypeCode
										+ "%' order by mat.AdmissionTypeCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchAdmissionType  " + e);
		}
		admissionTypeFieldsMap.put("searchAdmissionTypeList",
				searchAdmissionTypeList);
		return admissionTypeFieldsMap;
	}

	public boolean addAdmissionType(MasAdmissionType masAdmissionType) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAdmissionType);
		dataSaved = true;
		return dataSaved;
	}

	public boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAdmissionType masAdmissionType = new MasAdmissionType();
		masAdmissionType = (MasAdmissionType) getHibernateTemplate().get(
				MasAdmissionType.class, admissionTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAdmissionType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAdmissionType.setStatus("y");
				dataDeleted = false;
			}
		}
		masAdmissionType.setLastChgBy(changedBy);
		masAdmissionType.setLastChgDate(currentDate);
		masAdmissionType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdmissionType);
		return dataDeleted;
	}

	public boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String admissionTypeName = "";
		@SuppressWarnings("unused")
		String admissionTypeCode = "";
		int admissionTypeId = 0;
		String changedBy = "";
		admissionTypeId = (Integer) generalMap.get("id");
		admissionTypeCode = (String) generalMap.get("admissionTypeCode");
		admissionTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAdmissionType masAdmissionType = (MasAdmissionType) getHibernateTemplate()
				.get(MasAdmissionType.class, admissionTypeId);

		masAdmissionType.setId(admissionTypeId);
		masAdmissionType.setAdmissionTypeName(admissionTypeName);
		masAdmissionType.setLastChgBy(changedBy);
		masAdmissionType.setLastChgDate(currentDate);
		masAdmissionType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdmissionType);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------------Administrative
	// Sex-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAdministrativeSexJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAdministrativeSex> searchAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		searchAdministrativeSexList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAdministrativeSex ");
		map.put("searchAdministrativeSexList", searchAdministrativeSexList);
		return map;
	}

	public boolean addAdministrativeSex(
			MasAdministrativeSex masAdministrativeSex) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAdministrativeSex);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteAdministrativeSex(int administrativeSexId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex = (MasAdministrativeSex) getHibernateTemplate()
				.get(MasAdministrativeSex.class, administrativeSexId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAdministrativeSex.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAdministrativeSex.setStatus("y");
				dataDeleted = false;
			}
		}
		masAdministrativeSex.setLastChgBy(changedBy);
		masAdministrativeSex.setLastChgDate(currentDate);
		masAdministrativeSex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdministrativeSex);
		return dataDeleted;
	}

	public boolean editAdministrativeSexToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String administrativeSexName = "";
		@SuppressWarnings("unused")
		String administrativeSexCode = "";
		int administrativeSexId = 0;
		String changedBy = "";
		administrativeSexId = (Integer) generalMap.get("id");
		administrativeSexCode = (String) generalMap
				.get("administrativeSexCode");
		administrativeSexName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAdministrativeSex masAdministrativeSex = (MasAdministrativeSex) getHibernateTemplate()
				.get(MasAdministrativeSex.class, administrativeSexId);

		masAdministrativeSex.setId(administrativeSexId);
		masAdministrativeSex.setAdministrativeSexName(administrativeSexName);
		masAdministrativeSex.setLastChgBy(changedBy);
		masAdministrativeSex.setLastChgDate(currentDate);
		masAdministrativeSex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAdministrativeSex);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchAdministrativeSex(
			String administrativeSexCode, String administrativeSexName) {
		List<MasAdministrativeSex> searchAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		Map<String, Object> administrativeSexFieldsMap = new HashMap<String, Object>();
		try {
			if ((administrativeSexName != null)
					|| (administrativeSexCode == null)) {
				searchAdministrativeSexList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAdministrativeSex imc where imc.AdministrativeSexName like '"
										+ administrativeSexName
										+ "%' order by imc.AdministrativeSexName");
			} else {
				searchAdministrativeSexList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAdministrativeSex imc where imc.AdministrativeSexCode like '"
										+ administrativeSexCode
										+ "%' order by imc.AdministrativeSexCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchAdministrativeSexList  " + e);
		}
		administrativeSexFieldsMap.put("searchAdministrativeSexList",
				searchAdministrativeSexList);
		return administrativeSexFieldsMap;
	}

	// ---------------------------------------Document-------------------------

	public boolean addDocument(MasDocument masDocument) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDocument);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDocumentToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String documentName = "";
		@SuppressWarnings("unused")
		String documentCode = "";
		int documentId = 0;
		String changedBy = "";
		try {
			documentId = (Integer) generalMap.get("id");
			documentCode = (String) generalMap.get("documentCode");
			documentName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before masDocument in dataserviceImpl "
							+ e);
		}

		MasDocument masDocument = (MasDocument) getHibernateTemplate().get(
				MasDocument.class, documentId);

		masDocument.setId(documentId);
		masDocument.setDocumentName(documentName);
		masDocument.setLastChgBy(changedBy);
		masDocument.setLastChgDate(currentDate);
		masDocument.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masDocument);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDocument(String documentCode,
			String documentName) {
		List<MasDocument> searchDocumentList = new ArrayList<MasDocument>();
		Map<String, Object> documentFieldsMap = new HashMap<String, Object>();
		try {
			if ((documentName != null) || (documentCode == null)) {

				searchDocumentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDocument imc where imc.DocumentName like '"
										+ documentName
										+ "%' order by imc.DocumentName");
			} else {
				searchDocumentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDocument imc where imc.DocumentCode like '"
										+ documentCode
										+ "%' order by imc.DocumentCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchDocumentList  " + e);
		}
		documentFieldsMap.put("searchDocumentList", searchDocumentList);
		return documentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDocumentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDocument> searchDocumentList = new ArrayList<MasDocument>();
		searchDocumentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDocument ");
		map.put("searchDocumentList", searchDocumentList);
		return map;
	}

	public boolean deleteDocument(int documentId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDocument masDocument = new MasDocument();
		masDocument = (MasDocument) getHibernateTemplate().get(
				MasDocument.class, documentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDocument.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDocument.setStatus("y");
				dataDeleted = false;
			}
		}
		masDocument.setLastChgBy(changedBy);
		masDocument.setLastChgDate(currentDate);
		masDocument.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masDocument);
		return dataDeleted;
	}

	// ---------------------------------------Occupation-------------------------

	public boolean addOccupation(MasOccupation masOccupation) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masOccupation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editOccupationToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String occupationName = "";
		@SuppressWarnings("unused")
		String occupationCode = "";
		int occupationId = 0;
		String changedBy = "";
		try {
			occupationId = (Integer) generalMap.get("id");
			occupationCode = (String) generalMap.get("occupationCode");
			occupationName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			System.out
					.println("Exception before masOccupation in dataserviceImpl "
							+ e);
		}

		MasOccupation masOccupation = (MasOccupation) getHibernateTemplate()
				.get(MasOccupation.class, occupationId);

		masOccupation.setId(occupationId);
		masOccupation.setOccupationName(occupationName);
		masOccupation.setLastChgBy(changedBy);
		masOccupation.setLastChgDate(currentDate);
		masOccupation.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masOccupation);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOccupation(String occupationCode,
			String occupationName) {
		List<MasOccupation> searchOccupationList = new ArrayList<MasOccupation>();
		Map<String, Object> occupationFieldsMap = new HashMap<String, Object>();
		try {
			if ((occupationName != null) || (occupationCode == null)) {

				searchOccupationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasOccupation imc where imc.OccupationName like '"
										+ occupationName
										+ "%' order by imc.OccupationName");
			} else {
				searchOccupationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasOccupation imc where imc.OccupationCode like '"
										+ occupationCode
										+ "%' order by imc.OccupationCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchOccupationList  " + e);
		}
		occupationFieldsMap.put("searchOccupationList", searchOccupationList);
		return occupationFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOccupationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOccupation> searchOccupationList = new ArrayList<MasOccupation>();
		searchOccupationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasOccupation ");
		map.put("searchOccupationList", searchOccupationList);
		return map;
	}

	public boolean deleteOccupation(int occupationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOccupation masOccupation = new MasOccupation();
		masOccupation = (MasOccupation) getHibernateTemplate().get(
				MasOccupation.class, occupationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masOccupation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masOccupation.setStatus("y");
				dataDeleted = false;
			}
		}
		masOccupation.setLastChgBy(changedBy);
		masOccupation.setLastChgDate(currentDate);
		masOccupation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masOccupation);
		return dataDeleted;
	}

	// -------------------------------------------------
	// Caste--------------------------------------

	public boolean addCaste(MasCaste masCaste) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCaste);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCaste(String casteCode, String casteName) {

		List<MasCaste> searchCasteList = new ArrayList<MasCaste>();
		Map<String, Object> casteFieldsMap = new HashMap<String, Object>();
		try {
			if ((casteName != null) || (casteCode == null)) {
				searchCasteList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCaste imc where imc.CasteName like '"
								+ casteName + "%' order by imc.CasteName");
			} else {
				searchCasteList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCaste imc where imc.CasteCode like '"
								+ casteCode + "%' order by imc.CasteCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchCasteList  " + e);
		}
		casteFieldsMap.put("searchCasteList", searchCasteList);
		return casteFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCasteJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCaste> searchCasteList = new ArrayList<MasCaste>();
		searchCasteList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCaste ");
		map.put("searchCasteList", searchCasteList);
		return map;
	}

	public boolean editCasteToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String casteName = "";
		@SuppressWarnings("unused")
		String casteCode = "";
		int casteId = 0;
		String changedBy = "";
		casteId = (Integer) generalMap.get("id");
		casteCode = (String) generalMap.get("casteCode");
		casteName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCaste masCaste = (MasCaste) getHibernateTemplate().get(
				MasCaste.class, casteId);

		masCaste.setId(casteId);
		masCaste.setCasteName(casteName);
		masCaste.setLastChgBy(changedBy);
		masCaste.setLastChgDate(currentDate);
		masCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaste);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteCaste(int casteId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCaste masCaste = new MasCaste();
		masCaste = (MasCaste) getHibernateTemplate().get(MasCaste.class,
				casteId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaste.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaste.setStatus("y");
				dataDeleted = false;
			}
		}
		masCaste.setLastChgBy(changedBy);
		masCaste.setLastChgDate(currentDate);
		masCaste.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaste);
		return dataDeleted;
	}

	// -------------------------------------------------
	// UnitOfMeasurement-------------------------------------

	public boolean addUnitOfMeasurement(
			MasUnitOfMeasurement masUnitOfMeasurement) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUnitOfMeasurement);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchUnitOfMeasurement(
			String unitOfMeasurementCode, String unitOfMeasurementName) {

		List<MasUnitOfMeasurement> searchUnitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		Map<String, Object> unitOfMeasurementFieldsMap = new HashMap<String, Object>();
		Session session=(Session)getSession();
		try {
			if ((unitOfMeasurementName != null)
					|| (unitOfMeasurementCode == null)) {
				/*searchUnitOfMeasurementList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasUnitOfMeasurement imc where imc.UnitOfMeasurementName like '"
										+ unitOfMeasurementName
										+ "%' order by imc.UnitOfMeasurementName");
				*/
				session.createCriteria(MasUnitOfMeasurement.class).add(Restrictions.like("UnitOfMeasurementName","%"+ unitOfMeasurementName+"%"))
				.addOrder(Order.asc("unitOfMeasurementName")).list();
				
			} else {
				/*searchUnitOfMeasurementList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasUnitOfMeasurement imc where imc.UnitOfMeasurementCode like '"
										+ unitOfMeasurementCode
										+ "%' order by imc.UnitOfMeasurementCode");*/
				
				session.createCriteria(MasUnitOfMeasurement.class).add(Restrictions.like("UnitOfMeasurementCode","%"+ unitOfMeasurementCode+"%"))
				.addOrder(Order.asc("UnitOfMeasurementCode")).list();
				
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchUnitOfMeasurementList  " + e);
		}
		unitOfMeasurementFieldsMap.put("searchUnitOfMeasurementList",
				searchUnitOfMeasurementList);
		return unitOfMeasurementFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUnitOfMeasurementJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MasUnitOfMeasurement> searchUnitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		/*searchUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnitOfMeasurement ");
		*/
		searchUnitOfMeasurementList=session.createCriteria(MasUnitOfMeasurement.class).list();
		map.put("searchUnitOfMeasurementList", searchUnitOfMeasurementList);
		return map;
	}

	public boolean editUnitOfMeasurementToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitOfMeasurementName = "";
		@SuppressWarnings("unused")
		String unitOfMeasurementCode = "";
		int unitOfMeasurementId = 0;
		String changedBy = "";
		unitOfMeasurementId = (Integer) generalMap.get("id");
		unitOfMeasurementCode = (String) generalMap
				.get("unitOfMeasurementCode");
		unitOfMeasurementName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasUnitOfMeasurement masUnitOfMeasurement = (MasUnitOfMeasurement) getHibernateTemplate()
				.get(MasUnitOfMeasurement.class, unitOfMeasurementId);
		masUnitOfMeasurement.setId(unitOfMeasurementId);
		masUnitOfMeasurement.setUnitOfMeasurementName(unitOfMeasurementName);
		masUnitOfMeasurement.setLastChgBy(changedBy);
		masUnitOfMeasurement.setLastChgDate(currentDate);
		masUnitOfMeasurement.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnitOfMeasurement);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();
		masUnitOfMeasurement = (MasUnitOfMeasurement) getHibernateTemplate()
				.get(MasUnitOfMeasurement.class, unitOfMeasurementId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUnitOfMeasurement.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUnitOfMeasurement.setStatus("y");
				dataDeleted = false;
			}
		}
		masUnitOfMeasurement.setLastChgBy(changedBy);
		masUnitOfMeasurement.setLastChgDate(currentDate);
		masUnitOfMeasurement.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnitOfMeasurement);
		return dataDeleted;
	}

	// -----------------------District-------------------------------------------
	public boolean addDistrict(MasDistrict masDistrict) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDistrict);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDistrict(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int stateId = 0;
		String districtName = "";
		@SuppressWarnings("unused")
		String districtCode = "";
		int districtId = 0;
		String changedBy = "";
		districtId = (Integer) generalMap.get("id");
		districtCode = (String) generalMap.get("districtCode");
		districtName = (String) generalMap.get("name");
		stateId = (Integer) generalMap.get("stateId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDistrict masDistrict = (MasDistrict) getHibernateTemplate().get(
				MasDistrict.class, districtId);

		masDistrict.setId(districtId);
		masDistrict.setDistrictName(districtName);

		MasState masState = new MasState();
		masState.setId(stateId);
		masDistrict.setState(masState);

		masDistrict.setLastChgBy(changedBy);
		masDistrict.setLastChgDate(currentDate);
		masDistrict.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDistrict);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDistrict(String districtCode,
			String districtName) {
		List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
		List stateList = null;
		Map<String, Object> districtFieldsMap = new HashMap<String, Object>();
		List gridStateList = null;
		try {
			if ((districtName != null) || (districtCode == null)) {
				searchDistrictList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDistrict as i where i.DistrictName like '"
								+ districtName + "%' order by i.DistrictName");
			} else {
				searchDistrictList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDistrict as i where i.DistrictCode like '"
								+ districtCode + "%' order by i.DistrictCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		stateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		districtFieldsMap.put("gridStateList", gridStateList);
		districtFieldsMap.put("searchDistrictList", searchDistrictList);
		districtFieldsMap.put("stateList", stateList);
		return districtFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDistrict() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		searchDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict ");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState as isc");
		stateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasState as isc where isc.Status = 'y'");
		map.put("searchDistrictList", searchDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDistrict(int districtId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDistrict masDistrict = new MasDistrict();
		masDistrict = (MasDistrict) getHibernateTemplate().get(
				MasDistrict.class, districtId);
		@SuppressWarnings("unused")
		Integer stateId = masDistrict.getState().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List stateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasState as isc where isc.Id='"
							+ districtId + "' and isc.Status='y'");
			if (flag.equals("InActivate")) {
				masDistrict.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDistrict.setStatus("y");
				dataDeleted = false;
			}
		}
		masDistrict.setLastChgBy(changedBy);
		masDistrict.setLastChgDate(currentDate);
		masDistrict.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDistrict);
		return dataDeleted;
	}

	// ----------------------------------Block------------------------------------

	public boolean addBlock(MasBlock masBlock) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masBlock);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteBlock(int blockId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBlock masBlock = new MasBlock();
		masBlock = (MasBlock) getHibernateTemplate().get(MasBlock.class,
				blockId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Integer districtId = masBlock.getDistrict().getId();

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDistrict as mit where mit.Id='"
							+ districtId + "' and mit.Status='y'");
			if (flag.equals("InActivate")) {
				masBlock.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBlock.setStatus("y");
				dataDeleted = false;
			}
		}
		masBlock.setLastChgBy(changedBy);
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		return dataDeleted;
	}

	public boolean editBlock(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int districtId = 0;
		String blockName = "";
		@SuppressWarnings("unused")
		String blockCode = "";
		int blockId = 0;
		String changedBy = "";
		try {
			blockId = (Integer) generalMap.get("id");
			blockCode = (String) generalMap.get("blockCode");
			blockName = (String) generalMap.get("name");
			districtId = (Integer) generalMap.get("districtId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasBlock masBlock = (MasBlock) getHibernateTemplate().get(
					MasBlock.class, blockId);

			masBlock.setId(blockId);
			masBlock.setBlockName(blockName);
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masBlock.setDistrict(masDistrict);
			masBlock.setLastChgBy(changedBy);
			masBlock.setLastChgDate(currentDate);
			masBlock.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masBlock);
			dataUpdated = true;
		} catch (Exception e) {
			//System.out.println("eXCP in DS " + e);
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBlock(String blockCode, String blockName) {
		List masBlockList = new ArrayList();
		List masDistrictList = new ArrayList();
		Map<String, Object> blockFieldMap = new HashMap<String, Object>();
		List gridBlockList = new ArrayList();

		try {
			if ((blockName != null) || (blockCode == null)) {
				masBlockList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBlock sc where sc.BlockName like '"
								+ blockName + "%' order by sc.BlockName");
			} else {
				masBlockList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBlock sc where sc.BlockCode like '"
								+ blockCode + "%' order by sc.BlockCode");
			}
		} catch (Exception e) {
		}
		masDistrictList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as mit where mit.Status = 'y'");
		gridBlockList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as MasDistrict");
		blockFieldMap.put("masBlockList", masBlockList);
		blockFieldMap.put("masDistrictList", masDistrictList);
		blockFieldMap.put("gridBlockList", gridBlockList);
		return blockFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBlock() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBlock> masBlockList = new ArrayList<MasBlock>();
		List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
		List<MasBlock> gridBlockList = new ArrayList<MasBlock>();
		masBlockList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBlock ");
		masDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict as id");
		gridBlockList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDistrict as mit where mit.Status = 'y'");
		map.put("masBlockList", masBlockList);
		map.put("masDistrictList", masDistrictList);
		map.put("gridBlockList", gridBlockList);
		return map;
	}

	// ----------------------------Post Code---------------------------------
	public boolean addPostCode(MasPostCode masPostCode) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masPostCode);
			saveFlag = true;
		} catch (Exception e) {
			//System.out.println("Ds Exception in PharmacyMasterDataServiceImpl "+ e);
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deletePostCode(int postCodeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPostCode masPostCode = new MasPostCode();
		masPostCode = (MasPostCode) getHibernateTemplate().load(
				MasPostCode.class, postCodeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Integer blockId = masPostCode.getBlock().getId();
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasBlock as mit where mit.Id='"
							+ blockId + "' and mit.Status='y'");
			if (flag.equals("InActivate")) {
				masPostCode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPostCode.setStatus("y");
				dataDeleted = false;
			}
		}
		masPostCode.setLastChgBy(changedBy);
		masPostCode.setLastChgDate(currentDate);
		masPostCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPostCode);
		return dataDeleted;
	}

	public boolean editPostCode(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int blockId = 0;
		String postCodeName = "";
		@SuppressWarnings("unused")
		String postCodeCode = "";
		int postCodeId = 0;
		String changedBy = "";
		try {
			postCodeId = (Integer) generalMap.get("id");
			postCodeCode = (String) generalMap.get("postCodeCode");
			postCodeName = (String) generalMap.get("name");
			blockId = (Integer) generalMap.get("blockId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasPostCode masPostCode = (MasPostCode) getHibernateTemplate()
					.load(MasPostCode.class, postCodeId);

			masPostCode.setId(postCodeId);
			masPostCode.setPostCodeName(postCodeName);
			MasBlock masBlock = new MasBlock();
			masBlock.setId(blockId);
			masPostCode.setBlock(masBlock);
			masPostCode.setLastChgBy(changedBy);
			masPostCode.setLastChgDate(currentDate);
			masPostCode.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masPostCode);
			// getHibernateTemplate().update(masPostCode);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPostCode(String postCodeCode,
			String postCodeName) {

		List masPostCodeList = new ArrayList();
		List masBlockList = new ArrayList();
		Map<String, Object> postCodeFieldMap = new HashMap<String, Object>();
		List gridPostCodeList = new ArrayList();
		try {
			if ((postCodeName != null) || (postCodeCode == null)) {
				masPostCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPostCode sc where sc.PostCodeName like '"
								+ postCodeName + "%' order by sc.PostCodeName");
			} else {
				masPostCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasPostCode sc where sc.PostCode like '"
								+ postCodeCode + "%' order by sc.PostCode");
			}
		} catch (Exception e) {
		}
		masBlockList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBlock as mit where mit.Status = 'y'");
		gridPostCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBlock as MasBlock");
		postCodeFieldMap.put("masPostCodeList", masPostCodeList);
		postCodeFieldMap.put("masBlockList", masBlockList);
		postCodeFieldMap.put("gridPostCodeList", gridPostCodeList);
		return postCodeFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPostCodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPostCode> masPostCodeList = new ArrayList<MasPostCode>();
		List<MasBlock> masBlockList = new ArrayList<MasBlock>();
		List<MasPostCode> gridPostCodeList = new ArrayList<MasPostCode>();

		masPostCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPostCode ");
		masBlockList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBlock as bl order by bl.BlockName");
		gridPostCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBlock as mit where mit.Status = 'y'");
		map.put("masPostCodeList", masPostCodeList);
		map.put("masBlockList", masBlockList);
		map.put("gridPostCodeList", gridPostCodeList);
		return map;
	}

	// -----------------------------State ------------------------------------

	public boolean addState(MasState masState) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masState);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteState(int stateId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasState masState = new MasState();
		masState = (MasState) getHibernateTemplate().get(MasState.class,
				stateId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Integer countryId = masState.getCountry().getId();
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCountry as mit where mit.Id='"
							+ countryId + "' and mit.Status='y'");
			if (flag.equals("InActivate")) {
				masState.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masState.setStatus("y");
				dataDeleted = false;
			}
		}
		masState.setLastChgBy(changedBy);
		masState.setLastChgDate(currentDate);
		masState.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masState);
		return dataDeleted;
	}

	public boolean editState(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int countryId = 0;
		String stateName = "";
		@SuppressWarnings("unused")
		String stateCode = "";
		int stateId = 0;
		String changedBy = "";
		try {
			stateId = (Integer) generalMap.get("id");
			stateCode = (String) generalMap.get("stateCode");
			stateName = (String) generalMap.get("name");
			countryId = (Integer) generalMap.get("countryId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasState masState = (MasState) getHibernateTemplate().get(
					MasState.class, stateId);
			masState.setId(stateId);
			masState.setStateName(stateName);
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			masState.setCountry(masCountry);
			masState.setLastChgBy(changedBy);
			masState.setLastChgDate(currentDate);
			masState.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masState);
			dataUpdated = true;
		} catch (Exception e) {
			//System.out.println("eXCP in DS " + e);
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchState(String stateCode, String stateName) {

		List masStateList = new ArrayList();
		List masCountryList = new ArrayList();
		Map<String, Object> stateFieldMap = new HashMap<String, Object>();
		List gridStateList = new ArrayList();
		try {
			if ((stateName != null) || (stateCode == null)) {
				masStateList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasState sc where sc.StateName like '"
								+ stateName + "%' order by sc.StateName");
			} else {
				masStateList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasState sc where sc.StateCode like '"
								+ stateCode + "%' order by sc.StateCode");
			}
		} catch (Exception e) {
		}
		masCountryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCountry as mit where mit.Status = 'y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry as MasCountry");
		stateFieldMap.put("masStateList", masStateList);
		stateFieldMap.put("masCountryList", masCountryList);
		stateFieldMap.put("gridStateList", gridStateList);
		return stateFieldMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasState> masStateList = new ArrayList<MasState>();
		List<MasCountry> masCountryList = new ArrayList<MasCountry>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		masStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState ");
		masCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry as id");
		gridStateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCountry as mit where mit.Status = 'y'");
		map.put("masStateList", masStateList);
		map.put("masCountryList", masCountryList);
		map.put("gridStateList", gridStateList);
		return map;
	}

	// ---------------------------currency--------------------------------------

	public boolean addCurrency(MasCurrency masCurrency) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCurrency);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editCurrencyToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String currencyName = "";
		@SuppressWarnings("unused")
		String currencyCode = "";
		int currencyId = 0;
		String changedBy = "";
		currencyId = (Integer) generalMap.get("id");
		currencyCode = (String) generalMap.get("currencyCode");
		currencyName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCurrency masCurrency = (MasCurrency) getHibernateTemplate().get(
				MasCurrency.class, currencyId);

		masCurrency.setId(currencyId);
		masCurrency.setCurrencyName(currencyName);
		masCurrency.setLastChgBy(changedBy);
		masCurrency.setLastChgDate(currentDate);
		masCurrency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCurrency);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCurrency(String currencyCode,
			String currencyName) {
		List<MasCurrency> searchCurrencyList = new ArrayList<MasCurrency>();
		Map<String, Object> currencyFieldsMap = new HashMap<String, Object>();
		try {
			if ((currencyName != null) || (currencyCode == null)) {
				searchCurrencyList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCurrency imc where imc.CurrencyName like '"
										+ currencyName
										+ "%' order by imc.CurrencyName");
			} else {
				searchCurrencyList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCurrency imc where imc.CurrencyCode like '"
										+ currencyCode
										+ "%' order by imc.CurrencyCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		currencyFieldsMap.put("searchCurrencyList", searchCurrencyList);
		return currencyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCurrencyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCurrency> searchCurrencyList = new ArrayList<MasCurrency>();
		searchCurrencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCurrency ");
		map.put("searchCurrencyList", searchCurrencyList);
		return map;
	}

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCurrency masCurrency = new MasCurrency();
		masCurrency = (MasCurrency) getHibernateTemplate().get(
				MasCurrency.class, currencyId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCurrency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCurrency.setStatus("y");
				dataDeleted = false;
			}
		}
		masCurrency.setLastChgBy(changedBy);
		masCurrency.setLastChgDate(currentDate);
		masCurrency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCurrency);
		return dataDeleted;
	}

	// -----------------------------country----------------------------
	public boolean addCountry(MasCountry masCountry) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCountry);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteCountry(int countryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCountry masCountry = new MasCountry();
		masCountry = (MasCountry) getHibernateTemplate().get(MasCountry.class,
				countryId);
		@SuppressWarnings("unused")
		Integer currencyId = masCountry.getCurrency().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List currencyList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCurrency as isc where isc.Id='"
							+ countryId + "' and isc.Status='y'");
			if (flag.equals("InActivate")) {
				masCountry.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCountry.setStatus("y");
				dataDeleted = false;
			}
		}
		masCountry.setLastChgBy(changedBy);
		masCountry.setLastChgDate(currentDate);
		masCountry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCountry);
		return dataDeleted;
	}

	public boolean editCountryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int currencyId = 0;
		String countryName = "";
		@SuppressWarnings("unused")
		String countryCode = "";
		int countryId = 0;
		String changedBy = "";
		countryId = (Integer) generalMap.get("id");
		countryCode = (String) generalMap.get("countryCode");
		countryName = (String) generalMap.get("name");
		currencyId = (Integer) generalMap.get("currencyId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCountry masCountry = (MasCountry) getHibernateTemplate().get(
				MasCountry.class, countryId);

		masCountry.setId(countryId);
		masCountry.setCountryName(countryName);
		MasCurrency masCurrency = new MasCurrency();
		masCurrency.setId(currencyId);
		masCountry.setCurrency(masCurrency);
		masCountry.setLastChgBy(changedBy);
		masCountry.setLastChgDate(currentDate);
		masCountry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCountry);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCountry(String countryCode,
			String countryName) {
		List<MasCountry> searchCountryList = new ArrayList<MasCountry>();
		List currencyList = null;
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((countryName != null) || (countryCode == null)) {
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCountry as i where i.CountryName like '"
								+ countryName + "%' order by i.CountryName");
			} else {
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCountry as i where i.CountryCode like '"
								+ countryCode + "%' order by i.CountryCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchCountryList  " + e);
		}
		currencyList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCurrency as isc where isc.Status = 'y'");
		gridCurrencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCurrency as isc");
		countryFieldsMap.put("gridCurrencyList", gridCurrencyList);
		countryFieldsMap.put("searchCountryList", searchCountryList);
		countryFieldsMap.put("currencyList", currencyList);
		return countryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCountryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCountry> searchCountryList = new ArrayList<MasCountry>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MasCurrency> gridCurrencyList = new ArrayList<MasCurrency>();
		searchCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry ");
		gridCurrencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCurrency as isc");
		currencyList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCurrency as isc where isc.Status = 'y'");
		map.put("searchCountryList", searchCountryList);
		map.put("currencyList", currencyList);
		map.put("gridCurrencyList", gridCurrencyList);
		return map;
	}

	public List<MasBlock> getBlockList() {
		return null;
	}

	// ---------------------------------Reference----------------------------------
	public boolean addReference(MasReference masReference) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masReference);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteReference(int referenceId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasReference masReference = new MasReference();
		masReference = (MasReference) getHibernateTemplate().get(
				MasReference.class, referenceId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masReference.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masReference.setStatus("y");
				dataDeleted = false;
			}
		}
		masReference.setLastChgBy(changedBy);
		masReference.setLastChgDate(currentDate);
		masReference.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReference);
		return dataDeleted;
	}

	public boolean editReferenceToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String referenceName = "";
		@SuppressWarnings("unused")
		String referenceCode = "";
		int referenceId = 0;
		String changedBy = "";
		referenceId = (Integer) generalMap.get("id");
		referenceCode = (String) generalMap.get("referenceCode");
		referenceName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasReference masReference = (MasReference) getHibernateTemplate().get(
				MasReference.class, referenceId);

		masReference.setId(referenceId);
		masReference.setReferenceName(referenceName);
		masReference.setLastChgBy(changedBy);
		masReference.setLastChgDate(currentDate);
		masReference.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReference);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchReference(String referenceCode,
			String referenceName) {

		List<MasReference> searchReferenceList = new ArrayList<MasReference>();
		Map<String, Object> referenceFieldsMap = new HashMap<String, Object>();
		try {
			if ((referenceName != null) || (referenceCode == null)) {
				searchReferenceList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReference imc where imc.ReferenceName like '"
								+ referenceName
								+ "%' order by imc.ReferenceName");
			} else {
				searchReferenceList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasReference imc where imc.ReferenceCode like '"
								+ referenceCode
								+ "%' order by imc.ReferenceCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchReferenceList  " + e);
		}

		referenceFieldsMap.put("searchReferenceList", searchReferenceList);
		return referenceFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReferenceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReference> searchReferenceList = new ArrayList<MasReference>();
		searchReferenceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReference ");
		map.put("searchReferenceList", searchReferenceList);
		return map;
	}

	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showImmunizationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasImmunization> searchImmunizationList = new ArrayList<MasImmunization>();
		searchImmunizationList = getHibernateTemplate().find("from jkt.hms.masters.business.MasImmunization ");
		map.put("searchImmunizationList", searchImmunizationList);
		return map;
	}

	@Override
	public boolean addImmunization(MasImmunization masImmunization) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masImmunization);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean editImmunizationToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String immunizationName = "";
		@SuppressWarnings("unused")
		String immunizationCode = "";
		int immunizationId = 0;
		Users changedBy = new Users();
		try {
			immunizationId = (Integer) generalMap.get("id");
			immunizationCode = (String) generalMap.get("immunizationCode");
			immunizationName = (String) generalMap.get("name");
			changedBy = (Users) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasImmunization masImmunization = (MasImmunization) getHibernateTemplate().get(
				MasImmunization.class, immunizationId);

		masImmunization.setId(immunizationId);
		masImmunization.setImmunizationName(immunizationName);
		masImmunization.setLastChgBy(changedBy);
		masImmunization.setLastChgDate(currentDate);
		masImmunization.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masImmunization);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public boolean deleteImmunization(int immunizationId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Users changedBy = new Users();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasImmunization masImmunization = new MasImmunization();
		masImmunization = (MasImmunization) getHibernateTemplate().get(MasImmunization.class,
				immunizationId);
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masImmunization.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masImmunization.setStatus("y");
				dataDeleted = false;
			}
		}
		masImmunization.setLastChgBy(changedBy);
		masImmunization.setLastChgDate(currentDate);
		masImmunization.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masImmunization);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchImmunization(String immunizationCode,String immunizationName) {
		List<MasImmunization> searchImmunizationList = new ArrayList<MasImmunization>();
		Map<String, Object> immunizationFieldsMap = new HashMap<String, Object>();
		try {
			if ((immunizationName != null) || (immunizationCode == null)) {

				searchImmunizationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasImmunization imc where imc.ImmunizationName like '"
								+ immunizationName + "%' order by imc.ImmunizationName");
			} else {
				searchImmunizationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasImmunization imc where imc.ImmunizationCode like '"
								+ immunizationCode + "%' order by imc.ImmunizationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		immunizationFieldsMap.put("searchImmunizationList", searchImmunizationList);
		return immunizationFieldsMap;
	}

	// ---------------------------division--------------------------------------

			public boolean addDivision(MasDivision masDivision) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masDivision);
				successfullyAdded = true;
				return successfullyAdded;
			}

			public boolean editDivisionToDatabase(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				String nsaa = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String divisionName = "";
				@SuppressWarnings("unused")
				String divisionCode = "";
				int divisionId = 0;
				String changedBy = "";
				String cla="";
				String dla="";
				String dlh="";
				String dila="";
				String dela="";
				dila = (String) generalMap.get("dila");
				dla = (String) generalMap.get("dla");
				dlh = (String) generalMap.get("dlh");
				dela = (String) generalMap.get("dela");
				cla = (String) generalMap.get("cla");
				nsaa = (String) generalMap.get("nsaa");
				divisionId = (Integer) generalMap.get("id");
				divisionCode = (String) generalMap.get("divisionCode");
				divisionName = (String) generalMap.get("name");
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				MasDivision masDivision = (MasDivision) getHibernateTemplate().get(
						MasDivision.class, divisionId);

				masDivision.setId(divisionId);
				masDivision.setDivisionName(divisionName);
				//masDivision.setLastChgBy(changedBy);
				masDivision.setLastChgDate(currentDate);
				masDivision.setLastChgTime(currentTime);
				masDivision.setCoveringLetterAuthority(cla);
				masDivision.setDispatchLetterAuthority(dla);
				masDivision.setDispatchLetterHeader(dlh);
				masDivision.setDivisionalLetterAuthority(dila);
				masDivision.setDietLetterAuthority(dela);
				masDivision.setNoteSheetSignatureAuthority(nsaa);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masDivision);
				dataUpdated = true;
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchDivision(String divisionCode,
					String divisionName) {
				List<MasDivision> searchDivisionList = new ArrayList<MasDivision>();
				Map<String, Object> divisionFieldsMap = new HashMap<String, Object>();
				try {
					if ((divisionName != null) || (divisionCode == null)) {
						searchDivisionList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasDivision imc where imc.DivisionName like '"
												+ divisionName
												+ "%' order by imc.DivisionName");
					} else {
						searchDivisionList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasDivision imc where imc.DivisionCode like '"
												+ divisionCode
												+ "%' order by imc.DivisionCode");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				divisionFieldsMap.put("searchDivisionList", searchDivisionList);
				return divisionFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showDivisionJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasDivision> searchDivisionList = new ArrayList<MasDivision>();
				searchDivisionList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDivision ");
				map.put("searchDivisionList", searchDivisionList);
				return map;
			}

			public boolean deleteDivision(int divisionId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasDivision masDivision = new MasDivision();
				masDivision = (MasDivision) getHibernateTemplate().get(
						MasDivision.class, divisionId);
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masDivision.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masDivision.setStatus("y");
						dataDeleted = false;
					}
				}
				//masDivision.setLastChgBy(changedBy);
				masDivision.setLastChgDate(currentDate);
				masDivision.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masDivision);
				return dataDeleted;
			}

			// -----------------------------Grade ------------------------------------

			public boolean addGrade(MasGrade masGrade) {
				boolean saveFlag = false;
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(masGrade);
					saveFlag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return saveFlag;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteGrade(int gradeId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasGrade masGrade = new MasGrade();
				masGrade = (MasGrade) getHibernateTemplate().get(MasGrade.class,
						gradeId);
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				Integer rankCategoryId = masGrade.getRankCategory().getId();
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					List mainChargecodeList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasRankCategory as mit where mit.Id='"
									+ rankCategoryId + "' and mit.Status='y'");
					if (flag.equals("InActivate")) {
						masGrade.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masGrade.setStatus("y");
						dataDeleted = false;
					}
				}
				masGrade.setLastChgBy(changedBy);
				masGrade.setLastChgDate(currentDate);
				masGrade.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masGrade);
				return dataDeleted;
			}

			public boolean editGrade(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int rankCategoryId = 0;
				String gradeName = "";
				@SuppressWarnings("unused")
				String gradeCode = "";
				int gradeId = 0;
				String changedBy = "";
				try {
					gradeId = (Integer) generalMap.get("id");
					gradeCode = (String) generalMap.get("gradeCode");
					gradeName = (String) generalMap.get("name");
					rankCategoryId = (Integer) generalMap.get("rankCategoryId");
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					MasGrade masGrade = (MasGrade) getHibernateTemplate().get(
							MasGrade.class, gradeId);
					masGrade.setId(gradeId);
					masGrade.setGradeName(gradeName);
					MasRankCategory masRankCategory = new MasRankCategory();
					masRankCategory.setId(rankCategoryId);
					masGrade.setRankCategory(masRankCategory);
					masGrade.setLastChgBy(changedBy);
					masGrade.setLastChgDate(currentDate);
					masGrade.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masGrade);
					dataUpdated = true;
				} catch (Exception e) {
					//System.out.println("eXCP in DS " + e);
				}
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchGrade(String gradeCode, String gradeName) {

				List masGradeList = new ArrayList();
				List masRankCategoryList = new ArrayList();
				Map<String, Object> gradeFieldMap = new HashMap<String, Object>();
				List gridGradeList = new ArrayList();
				try {
					if ((gradeName != null) || (gradeCode == null)) {
						masGradeList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasGrade sc where sc.GradeName like '"
										+ gradeName + "%' order by sc.GradeName");
					} else {
						masGradeList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasGrade sc where sc.GradeCode like '"
										+ gradeCode + "%' order by sc.GradeCode");
					}
				} catch (Exception e) {
				}
				masRankCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasRankCategory as mit where mit.Status = 'y'");
				gridGradeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRankCategory as MasRankCategory");
				gradeFieldMap.put("masGradeList", masGradeList);
				gradeFieldMap.put("masRankCategoryList", masRankCategoryList);
				gradeFieldMap.put("gridGradeList", gridGradeList);
				return gradeFieldMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showGradeJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasGrade> masGradeList = new ArrayList<MasGrade>();
				List<MasRankCategory> masRankCategoryList = new ArrayList<MasRankCategory>();
				List<MasGrade> gridGradeList = new ArrayList<MasGrade>();
				masGradeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasGrade ");
				masRankCategoryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRankCategory as id");
				gridGradeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasRankCategory as mit where mit.Status = 'y'");
				map.put("masGradeList", masGradeList);
				map.put("masRankCategoryList", masRankCategoryList);
				map.put("gridGradeList", gridGradeList);
				return map;
			}
			
			
			// ---------------------------employeeType--------------------------------------

			public boolean addEmployeeType(MasEmployeeType masEmployeeType) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masEmployeeType);
				successfullyAdded = true;
				return successfullyAdded;
			}

			public boolean editEmployeeTypeToDatabase(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String employeeTypeName = "";
				@SuppressWarnings("unused")
				String employeeTypeCode = "";
				int employeeTypeId = 0;
				String changedBy = "";
				employeeTypeId = (Integer) generalMap.get("id");
				employeeTypeCode = (String) generalMap.get("employeeTypeCode");
				employeeTypeName = (String) generalMap.get("name");
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				MasEmployeeType masEmployeeType = (MasEmployeeType) getHibernateTemplate().get(
						MasEmployeeType.class, employeeTypeId);

				masEmployeeType.setId(employeeTypeId);
				masEmployeeType.setEmployeeTypeName(employeeTypeName);
				//masEmployeeType.setLastChgBy(changedBy);
				masEmployeeType.setLastChgDate(currentDate);
				masEmployeeType.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masEmployeeType);
				dataUpdated = true;
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchEmployeeType(String employeeTypeCode,
					String employeeTypeName) {
				List<MasEmployeeType> searchEmployeeTypeList = new ArrayList<MasEmployeeType>();
				Map<String, Object> employeeTypeFieldsMap = new HashMap<String, Object>();
				try {
					if ((employeeTypeName != null) || (employeeTypeCode == null)) {
						searchEmployeeTypeList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasEmployeeType imc where imc.EmployeeTypeName like '"
												+ employeeTypeName
												+ "%' order by imc.EmployeeTypeName");
					} else {
						searchEmployeeTypeList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasEmployeeType imc where imc.EmployeeTypeCode like '"
												+ employeeTypeCode
												+ "%' order by imc.EmployeeTypeCode");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				employeeTypeFieldsMap.put("searchEmployeeTypeList", searchEmployeeTypeList);
				return employeeTypeFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showEmployeeTypeJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployeeType> searchEmployeeTypeList = new ArrayList<MasEmployeeType>();
				searchEmployeeTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployeeType ");
				map.put("searchEmployeeTypeList", searchEmployeeTypeList);
				return map;
			}

			public boolean deleteEmployeeType(int employeeTypeId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasEmployeeType masEmployeeType = new MasEmployeeType();
				masEmployeeType = (MasEmployeeType) getHibernateTemplate().get(
						MasEmployeeType.class, employeeTypeId);
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masEmployeeType.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masEmployeeType.setStatus("y");
						dataDeleted = false;
					}
				}
				//masEmployeeType.setLastChgBy(changedBy);
				masEmployeeType.setLastChgDate(currentDate);
				masEmployeeType.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masEmployeeType);
				return dataDeleted;
			}

			@Override
			public Map<String, Object> searchImpanneledHospital(
					String impanneledHospitalCode, String impanneledHospitalName) {
				List<MasImpanneledHospital> searchImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
				Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
				try {
					if ((impanneledHospitalName != null) || (impanneledHospitalCode == null)) {

						searchImpanneledHospitalList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasImpanneledHospital imc where upper(imc.ImpanneledHospitalName) like upper('"
												+ impanneledHospitalName
												+ "%') order by imc.ImpanneledHospitalName");
					} else {
						searchImpanneledHospitalList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasImpanneledHospital imc where upper(imc.ImpanneledHospitalCode) like upper('"
												+ impanneledHospitalCode
												+ "%') order by imc.ImpanneledHospitalCode");
					}
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				userGroupsFieldsMap.put("searchImpanneledHospitalList", searchImpanneledHospitalList);
				return userGroupsFieldsMap;
			}

			@Override
			public Map<String, Object> showImpanneledHospitalJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasImpanneledHospital> searchImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
				
				searchImpanneledHospitalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasImpanneledHospital ");
				map.put("searchImpanneledHospitalList", searchImpanneledHospitalList);
				
				
				
				
				return map;
			}

			@Override
			public boolean deleteImpanneledHospital(int impanneledHospitalId,
					Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasImpanneledHospital masImpanneledHospital = new MasImpanneledHospital();
				masImpanneledHospital = (MasImpanneledHospital) getHibernateTemplate().get(
						MasImpanneledHospital.class, impanneledHospitalId);
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masImpanneledHospital.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masImpanneledHospital.setStatus("y");
						dataDeleted = false;
					}
				}
				masImpanneledHospital.setLastChgBy(changedBy);
				masImpanneledHospital.setLastChgDate(currentDate);
				masImpanneledHospital.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.saveOrUpdate(masImpanneledHospital);
				return dataDeleted;
			}

			@Override
			public boolean editImpanneledHospitalToDatabase(
					Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String impanneledHospitalName = "";
				@SuppressWarnings("unused")
				String impanneledHospitalCode = "";
				String impanneledHospitalAddress = "";
				int impanneledHospitalId = 0;
				String changedBy = "";
				try {
					impanneledHospitalId = (Integer) generalMap.get("id");
					impanneledHospitalCode = (String) generalMap.get("impanneledHospitalCode");
					impanneledHospitalName = (String) generalMap.get("name");
					impanneledHospitalAddress = (String) generalMap.get("impanneledHospitalAddress");
					
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					
				} catch (Exception e) {
					e.printStackTrace();
				}

				MasImpanneledHospital masImpanneledHospital = (MasImpanneledHospital) getHibernateTemplate().get(
						MasImpanneledHospital.class, impanneledHospitalId);

				masImpanneledHospital.setId(impanneledHospitalId);
				masImpanneledHospital.setImpanneledHospitalName(impanneledHospitalName);
				masImpanneledHospital.setAddress(impanneledHospitalAddress);
				
				masImpanneledHospital.setLastChgBy(changedBy);
				masImpanneledHospital.setLastChgDate(currentDate);
				masImpanneledHospital.setLastChgTime(currentTime);
				 
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.saveOrUpdate(masImpanneledHospital);
					dataUpdated = true;
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				return dataUpdated;
			}

			@Override
			public boolean addImpanneledHospital(
					MasImpanneledHospital masImpanneledHospital) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masImpanneledHospital);
				successfullyAdded = true;
				return successfullyAdded;
			}
//---------------------------
			public boolean addZonal(MasZonal masZonal) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masZonal);
				successfullyAdded = true;
				return successfullyAdded;
			}

			public boolean editZonalToDatabase(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String zonalName = "";
				@SuppressWarnings("unused")
				String zonalCode = "";
				int zonalId = 0;
				String changedBy = "";
				zonalId = (Integer) generalMap.get("id");
				zonalCode = (String) generalMap.get("zonalCode");
				zonalName = (String) generalMap.get("name");
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				MasZonal masZonal = (MasZonal) getHibernateTemplate().get(
						MasZonal.class, zonalId);

				masZonal.setId(zonalId);
				masZonal.setZonalName(zonalName);
				masZonal.setLastChgBy(changedBy);
				masZonal.setLastChgDate(currentDate);
				masZonal.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masZonal);
				dataUpdated = true;
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchZonal(String zonalCode,
					String zonalName) {
				List<MasZonal> searchZonalList = new ArrayList<MasZonal>();
				Map<String, Object> zonalFieldsMap = new HashMap<String, Object>();
				try {
					if ((zonalName != null) || (zonalCode == null)) {
						searchZonalList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasZonal imc where imc.ZonalName like '"
												+ zonalName
												+ "%' order by imc.ZonalName");
					} else {
						searchZonalList = getHibernateTemplate()
								.find(
										"from jkt.hms.masters.business.MasZonal imc where imc.ZonalCode like '"
												+ zonalCode
												+ "%' order by imc.ZonalCode");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				zonalFieldsMap.put("searchZonalList", searchZonalList);
				return zonalFieldsMap;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showZonalJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasZonal> searchZonalList = new ArrayList<MasZonal>();
				searchZonalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasZonal ");
				map.put("searchZonalList", searchZonalList);
				return map;
			}

			public boolean deleteZonal(int zonalId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasZonal masZonal = new MasZonal();
				masZonal = (MasZonal) getHibernateTemplate().get(
						MasZonal.class, zonalId);
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masZonal.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masZonal.setStatus("y");
						dataDeleted = false;
					}
				}
				masZonal.setLastChgBy(changedBy);
				masZonal.setLastChgDate(currentDate);
				masZonal.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masZonal);
				return dataDeleted;
			}

			public String getHospitalName(int hospitalId) {
				Session session = (Session) getSession();
				String hospitalName = "";
				List<MasHospital> list = session.createCriteria(MasHospital.class).add(
						Restrictions.eq("Status", "y")).add(
								Restrictions.eq("Id", hospitalId)).list();

				if (list != null && list.size() > 0) {
					MasHospital obj = (MasHospital) list.get(0);
					hospitalName = obj.getHospitalName();
				}
				return hospitalName;
			}

			@Override
			public Map<String, Object> showWardImpanneledHospitalJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasWardImpanneledHospital> searchWardImpanneledHospitalList = new ArrayList<MasWardImpanneledHospital>();
				searchWardImpanneledHospitalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasWardImpanneledHospital ");
				map.put("searchWardImpanneledHospitalList", searchWardImpanneledHospitalList);
				
				List<MasImpanneledHospital> impanneledHospitalList = new ArrayList<MasImpanneledHospital>();
				impanneledHospitalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasImpanneledHospital as mit where mit.Status = 'y'");
				map.put("impanneledHospitalList", impanneledHospitalList);
				return map;
			}

			@Override
			public Map<String, Object> checkForExistingWardImpanneledHospital(
					Map<String, Object> generalMap) {
				Map<String, Object> map = new HashMap<String, Object>();
				int impanneledHospital = 0;
				impanneledHospital=(Integer) generalMap.get("impanneledHospital");
				
				String name = "";
				String flag = "";
				name=(String) generalMap.get("name");
				Session session = (Session) getSession();
				List<MasWardImpanneledHospital> wardImpanneledHospitalList = new ArrayList<MasWardImpanneledHospital>();
				if(!name.equals("") && impanneledHospital!=0){
/*				if(flag.equals("update")){
					int id=0;
					id=(Integer) generalMap.get("id");
					wardImpanneledHospitalList = session.createCriteria(MasWardImpanneledHospital.class).add(
							Restrictions.like("WardName", name)).
								createAlias("ImpanneledHospital", "e")
								.add(Restrictions.eq("e.Id", impanneledHospital))
								.add(Restrictions.ne("Id", id))
							.list();
				}else{*/
			
					wardImpanneledHospitalList = session.createCriteria(MasWardImpanneledHospital.class).add(
						Restrictions.like("WardName", name)).
							createAlias("ImpanneledHospital", "e")
							.add(Restrictions.eq("e.Id", impanneledHospital))
						.list();
				}
				//}
				map.put("wardImpanneledHospitalList", wardImpanneledHospitalList);
				return map;
			
			}

			@Override
			public boolean addWardImpanneledHospitalJsp(
					MasWardImpanneledHospital masWardImpanneledHospital) {

				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masWardImpanneledHospital);
				successfullyAdded = true;
				return successfullyAdded;
			}

			@Override
			public boolean editWardImpanneledHospital(
					Map<String, Object> generalMap) {

				boolean dataUpdated = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				String wardName = "";
				int wardImpanneledHospitalId = 0;
				int impanneledHospital= 0;
				String changedBy = "";
				try {
					wardImpanneledHospitalId = (Integer) generalMap.get("id");
					wardName = (String) generalMap.get("name");
					impanneledHospital= (Integer) generalMap.get("impanneledHospital");
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
				} catch (Exception e) {
					//System.out.println("Exception before masTitle in dataserviceImpl "+ e);
				}

				MasWardImpanneledHospital masWardImpanneledHospital = (MasWardImpanneledHospital) getHibernateTemplate().get(
						MasWardImpanneledHospital.class, wardImpanneledHospitalId);

				masWardImpanneledHospital.setId(wardImpanneledHospitalId);
				masWardImpanneledHospital.setWardName(wardName);
				
				MasImpanneledHospital mih = new MasImpanneledHospital();
				mih.setId(impanneledHospital);
				masWardImpanneledHospital.setImpanneledHospital(mih);
				
				
				masWardImpanneledHospital.setLastChgBy(changedBy);
				masWardImpanneledHospital.setLastChgDate(currentDate);
				masWardImpanneledHospital.setLastChgTime(currentTime);
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.saveOrUpdate(masWardImpanneledHospital);
					dataUpdated = true;
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				return dataUpdated;
			}

			@Override
			public boolean deleteWardImpanneledHospital(
					int wardImpanneledHospitalId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasWardImpanneledHospital masWardImpanneledHospital = new MasWardImpanneledHospital();
				masWardImpanneledHospital = (MasWardImpanneledHospital) getHibernateTemplate().get(MasWardImpanneledHospital.class,
						wardImpanneledHospitalId);
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masWardImpanneledHospital.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masWardImpanneledHospital.setStatus("y");
						dataDeleted = false;
					}
				}
				masWardImpanneledHospital.setLastChgBy(changedBy);
				masWardImpanneledHospital.setLastChgDate(currentDate);
				masWardImpanneledHospital.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.saveOrUpdate(masWardImpanneledHospital);
				return dataDeleted;
			}

			@Override
			public Map<String, Object> searchWardImpanneledHospital(
					int impanneledHospitalSearch) {
				List<MasWardImpanneledHospital> searchWardImpanneledHospitalList = new ArrayList<MasWardImpanneledHospital>();
				Map<String, Object> wardImpanneledHospitalFieldsMap = new HashMap<String, Object>();
				Session session = (Session) getSession();
				String impanneledHospitalName="";
				try {
					if (impanneledHospitalSearch != 0) {
						
						
						searchWardImpanneledHospitalList = session.createCriteria(MasWardImpanneledHospital.class).
									createAlias("ImpanneledHospital", "e")
									.add(Restrictions.eq("e.Id", impanneledHospitalSearch))
								.list();
						
							impanneledHospitalName=searchWardImpanneledHospitalList.get(0).getImpanneledHospital().getImpanneledHospitalName();
							
							

						
						
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				List<MasImpanneledHospital> impanneledHospitalList = new ArrayList<MasImpanneledHospital>();
				impanneledHospitalList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasImpanneledHospital as mit where mit.Status = 'y'");
				wardImpanneledHospitalFieldsMap.put("impanneledHospitalList", impanneledHospitalList);
				
				wardImpanneledHospitalFieldsMap.put("searchWardImpanneledHospitalList", searchWardImpanneledHospitalList);
				wardImpanneledHospitalFieldsMap.put("impanneledHospitalName", impanneledHospitalName);
				return wardImpanneledHospitalFieldsMap;
			}
			


			//---------------------------
						public boolean addProposedMPR(MasProposedMPR masProposedMPR) {
							boolean successfullyAdded = false;
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.save(masProposedMPR);
							successfullyAdded = true;
							return successfullyAdded;
						}

						public boolean editProposedMPRToDatabase(Map<String, Object> generalMap) {
							boolean dataUpdated = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							String proposedMPRName = "";
							@SuppressWarnings("unused")
							String proposedMPRCode = "";
							int proposedMPRId = 0;
							String changedBy = "";
							proposedMPRId = (Integer) generalMap.get("id");
							proposedMPRCode = (String) generalMap.get("proposedMPRCode");
							proposedMPRName = (String) generalMap.get("name");
							changedBy = (String) generalMap.get("changedBy");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							MasProposedMPR masProposedMPR = (MasProposedMPR) getHibernateTemplate().get(
									MasProposedMPR.class, proposedMPRId);

							masProposedMPR.setId(proposedMPRId);
							masProposedMPR.setProposedMPRName(proposedMPRName);
							masProposedMPR.setLastChgBy(changedBy);
							masProposedMPR.setLastChgDate(currentDate);
							masProposedMPR.setLastChgTime(currentTime);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masProposedMPR);
							dataUpdated = true;
							return dataUpdated;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> searchProposedMPR(String proposedMPRCode,
								String proposedMPRName) {
							List<MasProposedMPR> searchProposedMPRList = new ArrayList<MasProposedMPR>();
							Map<String, Object> proposedMPRFieldsMap = new HashMap<String, Object>();
							try {
								if ((proposedMPRName != null) || (proposedMPRCode == null)) {
									searchProposedMPRList = getHibernateTemplate()
											.find(
													"from jkt.hms.masters.business.MasProposedMPR imc where imc.ProposedMPRName like '"
															+ proposedMPRName
															+ "%' order by imc.ProposedMPRName");
								} else {
									searchProposedMPRList = getHibernateTemplate()
											.find(
													"from jkt.hms.masters.business.MasProposedMPR imc where imc.ProposedMPRCode like '"
															+ proposedMPRCode
															+ "%' order by imc.ProposedMPRCode");
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							proposedMPRFieldsMap.put("searchProposedMPRList", searchProposedMPRList);
							return proposedMPRFieldsMap;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> showProposedMPRJsp() {
							Map<String, Object> map = new HashMap<String, Object>();
							List<MasProposedMPR> searchProposedMPRList = new ArrayList<MasProposedMPR>();
							searchProposedMPRList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasProposedMPR ");
							map.put("searchProposedMPRList", searchProposedMPRList);
							return map;
						}

						public boolean deleteProposedMPR(int proposedMPRId, Map<String, Object> generalMap) {
							boolean dataDeleted = false;
							String changedBy = "";
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							MasProposedMPR masProposedMPR = new MasProposedMPR();
							masProposedMPR = (MasProposedMPR) getHibernateTemplate().get(
									MasProposedMPR.class, proposedMPRId);
							changedBy = (String) generalMap.get("changedBy");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							if (generalMap.get("flag") != null) {
								String flag = (String) generalMap.get("flag");
								if (flag.equals("InActivate")) {
									masProposedMPR.setStatus("n");
									dataDeleted = true;
								} else if (flag.equals("Activate")) {
									masProposedMPR.setStatus("y");
									dataDeleted = false;
								}
							}
							masProposedMPR.setLastChgBy(changedBy);
							masProposedMPR.setLastChgDate(currentDate);
							masProposedMPR.setLastChgTime(currentTime);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masProposedMPR);
							return dataDeleted;
						}
}
