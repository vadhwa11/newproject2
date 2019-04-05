package jkt.hms.investigation.dataservice;

import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.RESULT_ID;
import static jkt.hms.util.RequestConstants.RESULT_ID_SINGLE_VALUE;
import static jkt.hms.util.RequestConstants.SAMPLE_ID;
import static jkt.hms.util.RequestConstants.SAMPLE_ID_SINGLE_VALUE;
import static jkt.hms.util.RequestConstants.UPLOAD_FILENAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.DgFilmDetail;
import jkt.hms.masters.business.DgFixedValue;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgNormalValue;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryDetailSen;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSubTest;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InvestigationDataServiceImpl extends HibernateDaoSupport implements
		InvestigationDataService {
	HibernateTransactionManager transactionManager = null;
	Session session;

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * showInvestigationJsp(jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showInvestigationJsp(Box box) {
		int deptId = 0;
		String deptType = "";
		Map<String, Object> map = new HashMap<String, Object>();
		// if(box.get("deptId") !=null)
		// deptId = Integer.parseInt(""+box.get("deptId"));
		if (box.get("deptType") != null)
			deptType = ("" + box.get("deptType"));
		deptId=box.getInt("deptId");
		Session session = (Session) getSession();
		List<MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		List<DgUom> uomList = new ArrayList<DgUom>();
		List<DgMasInvestigation> searchInvestigationList = new ArrayList<DgMasInvestigation>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<DgMasCollection> collectionList = new ArrayList<DgMasCollection>();
		List<MasMainChargecode> gridMainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> gridSubChargecodeList = new ArrayList<MasSubChargecode>();
		List<MasSample> gridSampleList = new ArrayList<MasSample>();
		List<DgUom> gridUnitOfMeasurementList = new ArrayList<DgUom>();
		List<MasChargeCode> gridChargeCodeList = new ArrayList<MasChargeCode>();
		List<DgMasCollection> gridCollectionList = new ArrayList<DgMasCollection>();

		List lst = new ArrayList();
		lst.add("DIAG");
		lst.add("RADIO");
		mainChargecodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MainChargecodeName")).list();
		if (mainChargecodeList.size() > 0)
			map.put("mainChargecodeList", mainChargecodeList);
		
		//Hide search query by Amit for Sql Injection on 14/08/2012
		
		/*uomList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgUom as isc where isc.Status = 'y'");
		subChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y' ");
		searchInvestigationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasInvestigation ");
		subChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y'");
		sampleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y'");
		chargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeCode as stm where stm.Status = 'y'and stm.ChargeType.Id='2'");
		collectionList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgMasCollection as isc where isc.Status = 'y'");
		gridSubChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		gridMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode");
		gridUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgUom ");
		gridChargeCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode");
		gridCollectionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasCollection");*/
		
		//Code updated by amit on 14/08/2012 for Sql injection
		
		uomList = session.createCriteria(DgUom.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UomName")).list();
		subChargecodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SubChargecodeName")).list();
		searchInvestigationList = session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("InvestigationName"))
				.createAlias("MainChargecode", "mc")
				.createAlias("mc.Department", "dt").add(Restrictions.eq("dt.Id", deptId))
				.list();
		subChargecodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SubChargecodeName"))
				.createAlias("Department", "dt").add(Restrictions.eq("dt.Id", deptId))
				.list();
		sampleList = session.createCriteria(MasSample.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SampleDescription")).list();
		chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ChargeCodeName")).list();
		collectionList = session.createCriteria(DgMasCollection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CollectionName")).list();
		gridSubChargecodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y")).list();
		gridMainChargecodeList = session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y")).list();
		gridUnitOfMeasurementList = session.createCriteria(DgUom.class).add(Restrictions.eq("Status", "y")).list();
		gridChargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
		gridCollectionList = session.createCriteria(DgMasCollection.class).add(Restrictions.eq("Status", "y")).list();
		
		//////////////////////End////////////////////////////

		map.put("chargeCodeList", chargeCodeList);
		map.put("gridSubChargecodeList", gridSubChargecodeList);
		map.put("gridSampleList", gridSampleList);
		map.put("gridMainChargecodeList", gridMainChargecodeList);
		map.put("gridUnitOfMeasurementList", gridUnitOfMeasurementList);
		map.put("searchInvestigationList", searchInvestigationList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("sampleList", sampleList);
		map.put("uomList", uomList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("gridChargeCodeList", gridChargeCodeList);
		map.put("gridCollectionList", gridCollectionList);
		map.put("collectionList", collectionList);

		return map;
	}

	public Map<String, Object> populateAllDgresultEntryHeader(
			Map<String, Object> mapDs) {
		int deptId = 0;
		String deptType = "";
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<DgResultEntryHeader> dgResultEntryHeaderList = new ArrayList<DgResultEntryHeader>();

		dgResultEntryHeaderList = session.createCriteria(
				DgResultEntryHeader.class).createAlias("MainChargecode", "mcc")
				.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab")).list();

		for (DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderList) {
			if (dgResultEntryHeader.getDgResultEntryDetails().size() > 0) {
				DgResultEntryDetail detail = dgResultEntryHeader
						.getDgResultEntryDetails().iterator().next();
				dgResultEntryHeader.setDgMasInvestigation(detail
						.getInvestigation());
			} else if (dgResultEntryHeader.getDgResultEntryDetailSen().size() > 0) {
				DgResultEntryDetailSen detail = dgResultEntryHeader
						.getDgResultEntryDetailSen().iterator().next();
				dgResultEntryHeader.setDgMasInvestigation(detail
						.getInvestigation());
			}
			hbt.save(dgResultEntryHeader);
			hbt.refresh(dgResultEntryHeader);
		}
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * checkInvestigationExsist(java.lang.String, java.lang.String)
	 */

	@SuppressWarnings("unchecked")
	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName) {
		List investigationExsistList = null;
		boolean investigationExsist = true;
		try {
			/*investigationExsistList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.DgMasInvestigation as ccm where ccm.InvestigationName = '"
									+ investigationName + "' ");
			
			
			*/
			Session session = (Session) getSession();
			investigationExsistList=session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("InvestigationName", investigationName)).list();
			if (investigationExsistList.size() > 0) {
				investigationExsist = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return investigationExsist;
	}

	/*
	 * for getting charge code details
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeDetails(int subChargeCodeId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> chargeDetailsList = new ArrayList<MasChargeCode>();
		List<DgUom> uomList = new ArrayList<DgUom>();
		Session session = (Session) getSession();
		chargeDetailsList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.eq("SubChargecode.Id", subChargeCodeId)).list();
		/*uomList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgUom as isc where isc.Status = 'y'");*/
		uomList=session.createCriteria(DgUom.class).add(Restrictions.eq("Status", "y")).list();
		
		detailsMap.put("uomList", uomList);
		detailsMap.put("chargeDetailsList", chargeDetailsList);
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getParameterDetails(jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getParameterDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<DgMasInvestigation> testList = new ArrayList<DgMasInvestigation>();
		List<DgUom> uomList = new ArrayList<DgUom>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<DgSubMasInvestigation> subMasList = new ArrayList<DgSubMasInvestigation>();
		/*chargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeCode as mi where  mi.SubChargecode.Id = "
								+ box
										.getInt(RequestConstants.SUB_CHARGECODE_ID)
								+ "");*/
		Session session = (Session) getSession();
		chargeCodeList=session.createCriteria(MasChargeCode.class).add(Restrictions.eq("SubChargecode.Id", box
										.getInt(RequestConstants.SUB_CHARGECODE_ID))).list();
		
		/*uomList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgUom as isc where isc.Status = 'y'");*/
		uomList=session.createCriteria(DgUom.class).add(Restrictions.eq("Status", "y")).list();
		
		/*testList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgMasInvestigation as mi where  mi.ChargeCode.Id = "
								+ box.getInt(RequestConstants.CHARGE_CODE_ID)
								+ "");
		*/
		testList=session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("ChargeCode.Id", box.getInt(RequestConstants.CHARGE_CODE_ID))).list();
		
		/*sampleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y'");*/
		
		sampleList=session.createCriteria(MasSample.class).add(Restrictions.eq("Status", "y")).list();
/*		subMasList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgSubMasInvestigation as isc  where isc.ChargeCode.Id ="
								+ box.getInt(RequestConstants.CHARGE_CODE_ID)
								+ "");
*/		
		subMasList=session.createCriteria(DgSubMasInvestigation.class).add(Restrictions.eq("ChargeCode.Id", box.getInt(RequestConstants.CHARGE_CODE_ID))).list();
		
		map.put("testList", testList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("uomList", uomList);
		map.put("sampleList", sampleList);
		map.put("subMasList", subMasList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getChargeDetails
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List investigationList = new ArrayList();
/*		investigationList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgSubMasInvestigation as mi where  mi.Investigation.Id = "
								+ box.getInt(RequestConstants.INVESTIGATION_ID)
								+ "");
		
*/		Session session = (Session) getSession();
		
		investigationList=session.createCriteria(DgSubMasInvestigation.class).add(Restrictions.eq("Investigation.Id", box.getInt(RequestConstants.INVESTIGATION_ID))).list();
		map.put("investigationList", investigationList);
		return map;
	}

	/*
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#addSubTest
	 * (jkt.hms.util.Box, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> addSubTest(Box box, Map dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataSaved = false;
		int i = 0;
		Vector quantity = box.getVector(RequestConstants.QUANTITY);
		int chargeCodeId = box.getInt(RequestConstants.CHARGE_CODE_ID);
		int mainChargeCodeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int subChargeId = box.getInt("subChargeCodeId");

		// int sampleId = box.getInt(RequestConstants.SAMPLE_ID);
		int collectionCenterId = box
				.getInt(RequestConstants.COLLECTION_CENTER_ID);
		Vector investigationName = box
				.getVector(RequestConstants.INVESTIGATION_NAME);
		String confidential = box.getString(RequestConstants.CONFIDENTIAL);
		Vector investigationType = box
				.getVector(RequestConstants.INVESTIGATION_TYPE);
		Vector dischargeSummary = box
				.getVector(RequestConstants.DSICHARGE_SUMMARY);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID);

		String userName = box.getString("userName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subChargeId);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeCodeId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		dgmasInvestigation.setId(chargeCodeId);
		if (investigationName != null && investigationName.size() > 0) {
			dgmasInvestigation.setInvestigationName((String) investigationName
					.get(i));
		}
		if (investigationType != null && investigationType.size() > 0) {
			dgmasInvestigation.setInvestigationType((String) investigationType
					.get(i));

		}
		if (quantity != null && quantity.size() > 0) {
			dgmasInvestigation.setQuantity((String) quantity.get(i));
		}
		dgmasInvestigation.setConfidential(confidential);
		if (dischargeSummary != null && dischargeSummary.size() > 0) {
			dgmasInvestigation
					.setAppearInDischargeSummary((String) dischargeSummary
							.get(i));
		}
		dgmasInvestigation.setStatus("y");
		dgmasInvestigation.setSubChargecode(masSubChargecode);
		dgmasInvestigation.setChargeCode(masChargeCode);
		dgmasInvestigation.setMainChargecode(masMainChargecode);
		// if(sampleId != 0){
		// MasSample masSample = new MasSample();
		// masSample.setId(sampleId);
		// dgmasInvestigation.setSample(masSample);
		// }
		if (collectionCenterId != 0) {
			DgMasCollection dgMasCollection = new DgMasCollection();
			dgMasCollection.setId(collectionCenterId);
			dgmasInvestigation.setContainer(dgMasCollection);
		}
		dgmasInvestigation.setLastChgBy("admin");
		dgmasInvestigation.setLastChgDate(date);
		dgmasInvestigation.setLastChgTime(time);
		if (investigationType.contains("m")) {
			dgmasInvestigation.setMultipleResults("y");
		} else {
			dgmasInvestigation.setMultipleResults("n");
		}
		hbt.save(dgmasInvestigation);
		HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);

		Vector subTestName = box.getVector(RequestConstants.SUBTEST_NAME);
		Vector subTestCode = box.getVector(RequestConstants.SUBTEST_CODE);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector orderNo = box.getVector(RequestConstants.ORDER_NO);
		Vector comparisonType = box.getVector(RequestConstants.COMPARISON_TYPE);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector sampleId = box.getVector(RequestConstants.SAMPLE_ID);

		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		try {

			for (i = 0; i < orderNo.size(); i++) {
				if (orderNo.get(i) != null && !orderNo.get(i).equals("")) {
					DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
					dgSubMasInvestigation.setInvestigation(dgmasInvestigation);
					dgSubMasInvestigation
							.setSubInvestigationName((String) subTestName
									.get(i));
					dgSubMasInvestigation
							.setSubInvestigationCode((String) subTestCode
									.get(i));
					if (resultType.get(i) != null
							&& !resultType.get(i).equals("")) {
						dgSubMasInvestigation.setResultType((String) resultType
								.get(i));
					}
					dgSubMasInvestigation.setOrderNo(Integer
							.parseInt((String) orderNo.get(i)));
					if (comparisonType.get(i) != null
							&& !comparisonType.get(i).equals("")) {
						dgSubMasInvestigation
								.setComparisonType((String) comparisonType
										.get(i));
					}
					dgSubMasInvestigation.setStatus("y");

					/*if (sampleId.get(i) != null && !sampleId.get(i).equals("")) {
						MasSample masSample = new MasSample();
						masSample.setId(Integer.parseInt((String) sampleId
								.get(i)));
						dgSubMasInvestigation.setSample(masSample);
					}*/
					dgSubMasInvestigation.setLastChgBy(userName);
					dgSubMasInvestigation.setLastChgDate(date);
					dgSubMasInvestigation.setLastChgTime(time);
					dgSubMasInvestigation.setSubChargecode(masSubChargecode);
					dgSubMasInvestigation.setChargeCode(masChargeCode);
					dgSubMasInvestigation.setMainChargecode(masMainChargecode);

					if (uomId.get(i) != null && !uomId.get(i).equals("")) {
						DgUom dgUom = new DgUom();
						dgUom.setId(Integer.parseInt((String) uomId.get(i)));
						dgSubMasInvestigation.setUom(dgUom);
					}

					hbt1.save(dgSubMasInvestigation);
					map.put("dgSubMasInvestigation", dgSubMasInvestigation);
					subInvestigationlist.add(dgSubMasInvestigation);

				}
			}
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}
		map.put("dataSaved", dataSaved);
		map.put("subInvestigationlist", subInvestigationlist);
		return map;
	}

	public Map<String, Object> addSubTestWithoutAddingInMasInvestigation(
			Box box, Map dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataSaved = false;

		int chargeCodeId = box.getInt(RequestConstants.CHARGE_CODE_ID);
		int mainChargeCodeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int subChargeId = box.getInt("subChargeCodeId");

		String userName = box.getString("userName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		Vector subTestName = box.getVector(RequestConstants.SUBTEST_NAME);
		Vector subTestCode = box.getVector(RequestConstants.SUBTEST_CODE);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector orderNo = box.getVector(RequestConstants.ORDER_NO);
		Vector comparisonType = box.getVector(RequestConstants.COMPARISON_TYPE);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector sampleId = box.getVector(RequestConstants.SAMPLE_ID);

		List<DgMasInvestigation> dgMasInvestigationListForUpdateList = new ArrayList<DgMasInvestigation>();
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();

		if (dataMap.get("dgMasInvestigationListForUpdateList") != null
				&& ((List) dataMap.get("dgMasInvestigationListForUpdateList"))
						.size() > 0) {
			dgMasInvestigationListForUpdateList = (List) dataMap
					.get("dgMasInvestigationListForUpdateList");
			dgMasInvestigation = dgMasInvestigationListForUpdateList.get(0);
			dgMasInvestigation.setInvestigationType("m");
			dgMasInvestigation.setMultipleResults("y");
		}

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subChargeId);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeCodeId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		try {

			for (int i = 0; i < orderNo.size(); i++) {
				if (orderNo.get(i) != null && !orderNo.get(i).equals("")) {
					DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
					dgSubMasInvestigation.setInvestigation(dgMasInvestigation);
					dgSubMasInvestigation
							.setSubInvestigationName((String) subTestName
									.get(i));
					dgSubMasInvestigation
							.setSubInvestigationCode((String) subTestCode
									.get(i));
					if (resultType.get(i) != null
							&& !resultType.get(i).equals("")) {
						dgSubMasInvestigation.setResultType((String) resultType
								.get(i));
					}
					dgSubMasInvestigation.setOrderNo(Integer
							.parseInt((String) orderNo.get(i)));
					if (comparisonType.get(i) != null
							&& !comparisonType.get(i).equals("")) {
						dgSubMasInvestigation
								.setComparisonType((String) comparisonType
										.get(i));
					}
					dgSubMasInvestigation.setStatus("y");
					dgSubMasInvestigation.setLastChgBy(userName);
					dgSubMasInvestigation.setLastChgDate(date);
					dgSubMasInvestigation.setLastChgTime(time);
					dgSubMasInvestigation.setSubChargecode(masSubChargecode);
					dgSubMasInvestigation.setChargeCode(masChargeCode);
					dgSubMasInvestigation.setMainChargecode(masMainChargecode);

					/*if (sampleId.get(i) != null && !sampleId.get(i).equals("")) {
						MasSample masSample = new MasSample();
						masSample.setId(Integer.parseInt((String) sampleId
								.get(i)));
						dgSubMasInvestigation.setSample(masSample);
					}*/

					if (uomId.get(i) != null && !uomId.get(i).equals("")) {
						DgUom dgUom = new DgUom();
						dgUom.setId(Integer.parseInt((String) uomId.get(i)));
						dgSubMasInvestigation.setUom(dgUom);
					}

					hbt.save(dgSubMasInvestigation);
					map.put("dgSubMasInvestigation", dgSubMasInvestigation);
					subInvestigationlist.add(dgSubMasInvestigation);

				}
			}
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}
		map.put("dataSaved", dataSaved);
		map.put("subInvestigationlist", subInvestigationlist);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getResponseSubchargeList(jkt.hms.util.Box)
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getResponseSubchargeList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		/*subChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as mi where  mi.MainChargecode.Id = "
								+ box
										.getInt(RequestConstants.MAIN_CHARGECODE_ID)
								+ "");*/
		Session session = (Session) getSession();
		
		subChargecodeList=session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("MainChargecode.Id", box
				.getInt(RequestConstants.MAIN_CHARGECODE_ID)))
		.list();
		
		map.put("subChargecodeList", subChargecodeList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getNormalValueDetails(jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getNormalValueDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgNormalValue> normalValueList = new ArrayList<DgNormalValue>();
		/*normalValueList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgNormalValue as isc where isc.SubInvestigation.Id="
								+ box.getInt(RequestConstants.SUBTEST_ID) + "");*/
		Session session = (Session) getSession();
		normalValueList=session.createCriteria(DgNormalValue.class).add(Restrictions.eq("SubInvestigation.Id", box.getInt(RequestConstants.SUBTEST_ID))).list();
		map.put("normalValueList", normalValueList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#updateSubTest
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public boolean updateSubTest(Box box) {
		boolean dataUpdated = false;
		int i = 0;
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Vector subTestName = box.getVector(RequestConstants.SUBTEST_NAME);
		Vector subTestCode = box.getVector(RequestConstants.SUBTEST_CODE);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector orderNo = box.getVector(RequestConstants.ORDER_NO);
		Vector comparisonType = box.getVector(RequestConstants.COMPARISON_TYPE);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector sampleId = box.getVector(RequestConstants.SAMPLE_ID);
		
		String subTestIdArray = box.getString("subTestIdArray");
		System.out.println("subTestIdArray"+subTestIdArray);
		
		MasMainChargecode mainChargecode = new MasMainChargecode();
		MasChargeCode chargeCode = new MasChargeCode();
		MasSubChargecode subChargecode = new MasSubChargecode();
		DgMasInvestigation investigation = new DgMasInvestigation();
		
		Date lastChangedDate = HMSUtil.convertStringTypeDateToDateType(box.getString("lastChangedDate"));
		String lastChgTime = box.getString("lastChangedTime");
		int mainChargecodeId = box.getInt("mainChargecodeId");
		int subChargecodeId = box.getInt("subChargecodeId");		
		int chargeCodeId = box.getInt("chargeCodeId");		
		int investigationId = box.getInt("investigationId");
		mainChargecode.setId(mainChargecodeId);
		chargeCode.setId(chargeCodeId);
		subChargecode.setId(subChargecodeId);
		investigation.setId(investigationId);
		

	
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
	
			if(!subTestIdArray.trim().equals(""))
			{
				session.createQuery("Delete from DgNormalValue dnv where dnv.SubInvestigation.Id in ("+subTestIdArray+")").executeUpdate();
				session.createQuery("Delete from DgFixedValue dfv where dfv.SubInvestigation.Id in ("+subTestIdArray+")").executeUpdate();
				session.createQuery("Delete from DgSubMasInvestigation dsi where dsi.Id in ("+subTestIdArray+")").executeUpdate();
			}
	
		

		for (i = 0; i < subTestId.size(); i++) {
			System.out.println("subTestId"+subTestId.size());
			DgSubMasInvestigation dgMasSubInvestigation = new DgSubMasInvestigation();
			if (subTestId.get(i).toString() != null
					) {
				if(!subTestId.get(i).toString().equals(""))
				{
					int sId = Integer.parseInt(subTestId.get(i).toString());
					dgMasSubInvestigation = (DgSubMasInvestigation) getHibernateTemplate()
							.load(DgSubMasInvestigation.class, sId);
					dgMasSubInvestigation.setId(Integer.parseInt((String) subTestId
							.get(i)));
				
				}
				else
				{
					dgMasSubInvestigation.setLastChgDate(lastChangedDate);
					dgMasSubInvestigation.setLastChgTime(lastChgTime);
					dgMasSubInvestigation.setMainChargecode(mainChargecode);
					dgMasSubInvestigation.setChargeCode(chargeCode);
					dgMasSubInvestigation.setSubChargecode(subChargecode);
					dgMasSubInvestigation.setInvestigation(investigation);
					dgMasSubInvestigation.setLastChgTime(lastChgTime);
				}
			    

			
				dgMasSubInvestigation
						.setSubInvestigationName((String) subTestName.get(i));
				dgMasSubInvestigation.setStatus("y");
				dgMasSubInvestigation.setStatus("y");
				dgMasSubInvestigation
						.setSubInvestigationCode((String) subTestCode.get(i));
				dgMasSubInvestigation.setComparisonType((String) comparisonType
						.get(i));
				
				System.out.println("resultType.get(i="+resultType.get(i));
				dgMasSubInvestigation.setResultType((String) resultType.get(i));
				dgMasSubInvestigation.setOrderNo(Integer
						.parseInt((String) orderNo.get(i)));
				if (uomId.get(i) != null && !uomId.get(i).equals("")) {
					DgUom dgUom = new DgUom();
					dgUom.setId(Integer.parseInt((String) uomId.get(i)));
					dgMasSubInvestigation.setUom(dgUom);
				}
				/*if (sampleId.get(i) != null && !sampleId.get(i).equals("")) {
					MasSample masSample = new MasSample();
					masSample.setId(Integer.parseInt((String) sampleId.get(i)));
					dgMasSubInvestigation.setSample(masSample);
				}*/
				hbt.saveOrUpdate(dgMasSubInvestigation);
			}
		}
		tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			dataUpdated = true;

		}
		return dataUpdated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getDetailsForSearch()
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		int deptId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
	
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").add(Restrictions.eq("dept.Id", deptId)).addOrder(Order.asc("SubChargecodeName")).list();
		/*subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("SubChargecodeName")).list();*/
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

		sampleList = session.createCriteria(MasSample.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("SampleDescription")).list();
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}
		
		String departmentTypeCodeForOpd="";
		String departmentTypeCodeForWard="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
			departmentTypeCodeForWard=properties.getProperty("departmentTypeCodeForWard");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<String> arrayDeptCode = new ArrayList<String>();
		arrayDeptCode.add(departmentTypeCodeForWard);
		arrayDeptCode.add(departmentTypeCodeForOpd);
		
		
		departmentList = session.createCriteria(MasDepartment.class)
				.createAlias("DepartmentType", "dt").add(Restrictions.in("dt.DepartmentTypeCode", arrayDeptCode))	
				
				.add(Restrictions.eq("Status", "y")).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}
		chargeCodeList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("ChargeCodeName")).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}

		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getPatientDetails
	 * (java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		int subChargeCodeId = 0;
		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("sampleCollectionDetailId") != null) {
			sampleCollectionDetailId = (Integer) mapForDs
					.get("sampleCollectionDetailId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		String deptName = "";
		if (dataMap.get("deptName") != null)
			deptName = ("" + dataMap.get("deptName"));

		crit = session.createCriteria(DgSampleCollectionDetails.class).add(
				Restrictions.eq("OrderStatus", "A")).createAlias(
				"SampleCollectionHeader", "sampleHead").createAlias(
				"sampleHead.Department", "dept").add(
				Restrictions.eq("dept.Id", deptId))
		// .add(Restrictions.eq("sampleHead.OrderStatus", "A"))
				.add(
						Restrictions.between("sampleHead.SampleValidationDate",
								fromDate, toDate));
		if (!hinNo.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.HinNo", hinNo + "%"));
		}
		if (hinId != 0) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.eq("pt.Id", hinId));
		}
		if (!patientFName.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.PFirstName", patientFName + "%"));
		}
		if (!serviceNo.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.ServiceNo", serviceNo + "%"));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.SFirstName", serPersonFName + "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("sampleHead.Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("sampleHead.Order", "or").add(
					Restrictions.eq("or.PatientType", orderType));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.createAlias("ChargeCode", "charge").createAlias(
					"charge.SubChargecode", "subChrg").add(
					Restrictions.eq("subChrg.Id", subChargeCodeId));
		}
		if (!diagnosisNo.equals("")) {
			crit = crit.add(Restrictions.like("DiagNo", diagnosisNo));
		}

		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientList = new ArrayList<Object[]>();
		Date fromDate = null;
		Date toDate = null;
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		int subChargeCodeId = 0;

		String diagnosisNo = "";
		String barCodeOrderNo="";

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		int hospitalId = 0;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("barCodeOrderNo") != null) {
			barCodeOrderNo = (String) mapForDs.get("barCodeOrderNo");
		}
		
		String flag="";
		if (mapForDs.get("flag") != null)
			flag =  (String)mapForDs.get("flag");
		System.out.println("flag1="+flag);
	/*	crit = session.createCriteria(DgSampleCollectionDetails.class).add(
				Restrictions.eq("OrderStatus", "A")).createAlias(
				"SampleCollectionHeader", "sampleHead").createAlias(
				"sampleHead.Department", "dept").add(
				Restrictions.eq("dept.Id", deptId))
		        .add(Restrictions.eq("sampleHead.OrderStatus", "A"))
				.add(
						Restrictions.between("sampleHead.SampleValidationDate",
								fromDate, toDate));*/
		
				
		crit = session.createCriteria(DgSampleCollectionDetails.class).add(
				Restrictions.eq("OrderStatus", "A")).createAlias(
				"SampleCollectionHeader", "sampleHead").createAlias("sampleHead.Order", "dgOrder")/*.add(Restrictions.eq("sampleHead.OrderStatus", "A"))*/
				
				.createAlias("sampleHead.Department","d").add(Restrictions.eq("d.Id", deptId))
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId));
		
		if(fromDate != null || toDate !=null)
		{
			crit.add(Restrictions.between("sampleHead.SampleValidationDate",fromDate, toDate));
		}
		
		if(flag.equalsIgnoreCase("investigationForEmpanelledHospital"))
		{
			crit= crit.add(Restrictions.eq("EmpanelledStatus", "y").ignoreCase());
		}
		if(flag.equalsIgnoreCase("investigationForHalHospital"))
		{
			crit= crit.add(Restrictions.eq("EmpanelledStatus", "n").ignoreCase());
		}
		
		
		if (!hinNo.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.HinNo", hinNo + "%"));
		}
		if (hinId != 0) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.eq("pt.Id", hinId));
		}
		if (!patientFName.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.PFirstName", patientFName + "%").ignoreCase());
		}
		if (!serviceNo.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.eq("pt.ServiceNo", serviceNo));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.createAlias("sampleHead.Hin", "pt").add(
					Restrictions.like("pt.SFirstName", serPersonFName + "%").ignoreCase());
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("sampleHead.Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("sampleHead.Order", "or").add(
					Restrictions.eq("or.PatientType", orderType));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("sampleHead.OrderByDepartment.Id",
					departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.createAlias("ChargeCode", "charge").createAlias(
					"charge.SubChargecode", "subChrg").add(
					Restrictions.eq("subChrg.Id", subChargeCodeId));
		}
		if (!diagnosisNo.equals("")) {
			crit = crit.add(Restrictions.like("DiagNo", diagnosisNo));
		}
		
		if (!barCodeOrderNo.equals("")) {
			crit = crit.add(Restrictions.eq("dgOrder.OrderNo", barCodeOrderNo));
		}
		crit = crit.setProjection(Projections.projectionList().add(
				Projections.groupProperty("SampleCollectionHeader")).add(
				Projections.groupProperty("Subcharge")));

		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		System.out.println("patientList="+patientList.size());
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getAllDetails
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * List<DgSampleCollectionHeader> patientList=new
		 * ArrayList<DgSampleCollectionHeader>();
		 * List<DgSubMasInvestigation>investigationList = new
		 * ArrayList<DgSubMasInvestigation>();
		 * patientList=getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.DgSampleCollectionHeader");
		 * System.out.
		 * println("patient list in dssssssssss     "+patientList.size());
		 * investigationList=getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.DgSubMasInvestigation as dgm ");
		 * 
		 * map.put("investigationList", investigationList);
		 * map.put("patientList", patientList);
		 */
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getChargeList
	 * (jkt.hms.util.Box)
	 */

	@SuppressWarnings("unchecked")
	public List<DgSubMasInvestigation> getChargeList(Box box) {

		Session session = (Session) getSession();
		List investigationList = new ArrayList();
		try {
			investigationList = session
					.createQuery(
							"select ugh from DgSubMasInvestigation as ugh where ugh.ChargeCode.Id="
									+ box
											.getInt(RequestConstants.CHARGE_CODE_ID)
									+ " ").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return investigationList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getTemplateList
	 * (int)
	 */

	@SuppressWarnings("unchecked")
	public List<DgTemplate> getTemplateList(int chargeCodeId) {
		Session session = (Session) getSession();
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		try {
			templateList = session.createCriteria(DgTemplate.class)
			.createAlias("ChargeCode", "charge").add(Restrictions.eq("charge.Id", chargeCodeId)).list();
			
			//templateList = session.createQuery("select ugh from DgTemplate as ugh where ugh.ChargeCode.Id="+ chargeCodeId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return templateList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getFixedList
	 * (jkt.hms.util.Box)
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFixedList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgFixedValue> fixedList = new ArrayList<DgFixedValue>();
		/*fixedList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgFixedValue as isc where isc.SubInvestigation.Id="
								+ box.getInt(RequestConstants.SUBTEST_ID)
								+ " and isc.FixedValue != null");
		*/
		Session session = (Session) getSession();
		fixedList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", box.getInt(RequestConstants.SUBTEST_ID))).list();
		map.put("fixedList", fixedList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * searchInvestigation(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchInvestigation(int searchModality,
			String investigationName,int deptId) {
		List<DgMasInvestigation> searchInvestigationList = new ArrayList<DgMasInvestigation>();
		List chargeTypeList = null;
		List departmentList = null;
		List mainChargecodeList = null;
		List subChargecodeList = null;
		List sampleList = null;
		List uomList = null;
		List subTestList = null;
		List<MasChargeCode> chargeCodeList = null;
		List<DgMasCollection> collectionList = null;
		List gridChargeTypeList = null;
		List gridDepartmentList = null;
		List gridMainChargecodeList = null;
		List gridSubChargecodeList = null;
		List gridUnitOfMeasurementList = null;
		List gridSampleList = null;
		List gridSubTestList = null;
		List<MasChargeCode> gridChargeCodeList = null;
		List<DgMasCollection> gridCollectionList = null;
		Map<String, Object> chargeCodeFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try {
			if ((investigationName != null)) {
				//Code hide by amit on 14/08/2012 for Sql Injection
				/*searchInvestigationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.DgMasInvestigation as i where upper(i.InvestigationName) like upper('"
										+ investigationName
										+ "%') order by i.InvestigationName");*/
				
				//Code start added by amit on 14/08/2012 for Sql Injection
				System.out.println("investigationName="+investigationName);
				searchInvestigationList = session.createCriteria(DgMasInvestigation.class)
						.createAlias("MainChargecode", "mc")
						.createAlias("mc.Department", "dt").add(Restrictions.eq("dt.Id", deptId))
				.add(Restrictions.ilike("InvestigationName", "%"+investigationName+"%"))
				.addOrder(Order.asc("InvestigationName"))
				.list();
				///////////////End/////////////////////////
			}if(searchModality!=0){
				searchInvestigationList = session.createCriteria(DgMasInvestigation.class)
						.createAlias("SubChargecode", "m")
						.add(Restrictions.eq("m.Id", searchModality)).list();
			}
			// else{
			// searchInvestigationList=getHibernateTemplate().find("from jkt.hms.masters.business.DgMasInvestigation as i where i.InvestigationCode like '"+
			// investigationCode+"%' order by i.InvestigationCode");}
		} catch (Exception e) {
			e.printStackTrace();
		}
/*		chargeTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeType as isc where isc.Status = 'y'");
*/	
		//Session session = (Session) getSession();
		chargeTypeList=session.createCriteria(MasChargeType.class).add(Restrictions.eq("Status", "y")).list();
		
		/*departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");
		*/
		departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		/*subChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y'");*/
		
		subChargecodeList=session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y")).list();
		/*sampleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y'");*/
		
		sampleList=session.createCriteria(MasSample.class).add(Restrictions.eq("Status", "y")).list();
		/*mainChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Status = 'y'");*/
		mainChargecodeList=session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y")).list();
		
		/*uomList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgUom as uomm where uomm.Status='y'");*/
		uomList=session.createCriteria(DgUom.class).add(Restrictions.eq("Status", "y")).list();
	/*	subTestList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubTest as stm where stm.Status = 'y'");*/
		
		subTestList=session.createCriteria(MasSubTest.class).add(Restrictions.eq("Status", "y")).list();
		/*chargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeCode as stm where stm.Status = 'y'");*/
		
		chargeCodeList=session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
		
		/*collectionList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgMasCollection as stm where stm.Status = 'y'");*/
		collectionList=session.createCriteria(DgMasCollection.class).add(Restrictions.eq("Status", "y")).list();
		

	/*	gridChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType");*/
		gridChargeTypeList=session.createCriteria(MasChargeType.class).add(Restrictions.eq("Status", "y")).list();
		
		/*gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");*/
		gridDepartmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		/*gridSubChargecodeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSubChargecode ");*/
		
		gridSubChargecodeList=session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y")).list();
		/*gridSampleList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSample ");*/
		
		gridSampleList=session.createCriteria(MasSample.class).add(Restrictions.eq("Status", "y")).list();
		
		/*gridMainChargecodeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasMainChargecode");*/
		
		gridMainChargecodeList=session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y")).list();
		
		/*gridUnitOfMeasurementList = getHibernateTemplate().find("from jkt.hms.masters.business.DgUom ");*/
		
		gridUnitOfMeasurementList=session.createCriteria(DgUom.class).add(Restrictions.eq("Status", "y")).list();
		
		
		/*gridSubTestList = getHibernateTemplate().find("from jkt.hms.masters.business.MasSubTest ");*/
		
		gridSubTestList=session.createCriteria(MasSubTest.class).add(Restrictions.eq("Status", "y")).list();
		
		/*gridChargeCodeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasChargeCode ");*/
		
		gridChargeCodeList=session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
		
		/*gridCollectionList = getHibernateTemplate().find("from jkt.hms.masters.business.DgMasCollection ");*/
		
		gridCollectionList=session.createCriteria(DgMasCollection.class).add(Restrictions.eq("Status", "y")).list();

		chargeCodeFieldsMap.put("gridChargeTypeList", gridChargeTypeList);
		chargeCodeFieldsMap.put("gridDepartmentList", gridDepartmentList);
		chargeCodeFieldsMap.put("gridSubChargecodeList", gridSubChargecodeList);
		chargeCodeFieldsMap.put("gridSubTestList", gridSubTestList);
		chargeCodeFieldsMap.put("gridSampleList", gridSampleList);
		chargeCodeFieldsMap.put("gridMainChargecodeList",
				gridMainChargecodeList);
		chargeCodeFieldsMap.put("gridUnitOfMeasurementList",
				gridUnitOfMeasurementList);
		chargeCodeFieldsMap.put("gridCollectionList", gridCollectionList);

		chargeCodeFieldsMap.put("searchInvestigationList",
				searchInvestigationList);
		chargeCodeFieldsMap.put("subTestList", subTestList);
		chargeCodeFieldsMap.put("chargeTypeList", chargeTypeList);
		chargeCodeFieldsMap.put("subChargecodeList", subChargecodeList);
		chargeCodeFieldsMap.put("departmentList", departmentList);
		chargeCodeFieldsMap.put("mainChargecodeList", mainChargecodeList);
		chargeCodeFieldsMap.put("subChargecodeList", subChargecodeList);
		chargeCodeFieldsMap.put("sampleList", sampleList);
		chargeCodeFieldsMap.put("uomList", uomList);
		chargeCodeFieldsMap.put("gridChargeCodeList", gridChargeCodeList);
		chargeCodeFieldsMap.put("chargeCodeList", chargeCodeList);
		chargeCodeFieldsMap.put("collectionList", collectionList);

		return chargeCodeFieldsMap;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#addInvestigation
	 * (jkt.hms.masters.business.DgMasInvestigation)
	 */
	@SuppressWarnings("unchecked")
	public boolean addInvestigation(DgMasInvestigation dgMasInvestigation) {
		boolean dataSaved = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgMasInvestigation);
			hbt.refresh(dgMasInvestigation);
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#editInvestigation
	 * (jkt.hms.masters.business.DgMasInvestigation)
	 */

	@SuppressWarnings("unchecked")
	public boolean editInvestigation(Map<String, Object> generalMap) {
		boolean editedSuccessfully = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";
		String quantity = "";
		String normalValue = "";
		String minNormalValue = "";
		String maxNormalValue = "";
		String confidential = "";
		String dischargeSummary = "";
		String numericOrString = "";
		String investigationType = "";
		int investigationId = (Integer) generalMap.get("investigationId");
		int mainChargecodeId = (Integer) generalMap.get("mainChargeId");
		String investigationName = (String) generalMap.get("investigationName");
		int chargeCodeId = (Integer) generalMap.get("chargeCodeId");
		int subChargeCodeId = (Integer) generalMap.get("subChargeId");
		int sampleId = 0;
		sampleId = (Integer) generalMap.get("sampleId");
		int collectionId = 0;
		collectionId = (Integer) generalMap.get("collectionId");
		int uomId = 0;
		uomId = (Integer) generalMap.get("unitOfResult");
		quantity = (String) generalMap.get("quantity");
		numericOrString = (String) generalMap.get("numericOrString");
		normalValue = (String) generalMap.get("normalValue");
		minNormalValue = (String) generalMap.get("minNormalValue");
		maxNormalValue = (String) generalMap.get("maxNormalValue");
		confidential = (String) generalMap.get("checkBoxConfidence");
		dischargeSummary = (String) generalMap.get("checkBoxDischargeSummary");
		investigationType = (String) generalMap.get("investigationType");
		
		String screenTest = "";
		String reactionTest = "";

		screenTest = (String) generalMap.get("screenTest");
		reactionTest = (String) generalMap.get("reactionTest");

		DgMasInvestigation dgMasInvestigation2 = (DgMasInvestigation) getHibernateTemplate()
				.get(DgMasInvestigation.class, investigationId);
		if (investigationId != '0') {
			dgMasInvestigation2.setId(investigationId);
		}
		dgMasInvestigation2.setBloodBankScreenTest(screenTest);
		dgMasInvestigation2.setBloodReactionTest(reactionTest);

		dgMasInvestigation2.setInvestigationName(investigationName);
		dgMasInvestigation2.setInvestigationType(investigationType);
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargecodeId);
		dgMasInvestigation2.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subChargeCodeId);
		dgMasInvestigation2.setSubChargecode(masSubChargecode);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);
		dgMasInvestigation2.setChargeCode(masChargeCode);
		String instruction = "";
		if(generalMap.get("instruction")!= null){
			instruction = (String)generalMap.get("instruction");
			dgMasInvestigation2.setInstructions(instruction);
		}

		if (sampleId != 0) {
			MasSample masSample = new MasSample();
			masSample.setId(sampleId);
			dgMasInvestigation2.setSample(masSample);
		} else {
			dgMasInvestigation2.setSample(null);
		}

		if (uomId != 0) {
			DgUom dgUom = new DgUom();
			dgUom.setId(uomId);
			dgMasInvestigation2.setUom(dgUom);
		} else {
			dgMasInvestigation2.setUom(null);
		}

		if (collectionId != 0) {
			DgMasCollection dgMasCollection = new DgMasCollection();
			dgMasCollection.setId(collectionId);
			dgMasInvestigation2.setContainer(dgMasCollection);
		} else {
			dgMasInvestigation2.setContainer(null);
		}

		dgMasInvestigation2.setQuantity(quantity);
		dgMasInvestigation2.setNumericOrString(numericOrString);
		if (normalValue != null) {
			dgMasInvestigation2.setNormalValue(normalValue);
		}
		if (minNormalValue != null) {
			dgMasInvestigation2.setMinNormalValue(minNormalValue);
		}
		if (maxNormalValue != null) {
			dgMasInvestigation2.setMaxNormalValue(maxNormalValue);
		}
		dgMasInvestigation2.setConfidential(confidential);
		dgMasInvestigation2.setAppearInDischargeSummary(dischargeSummary);
		dgMasInvestigation2.setLastChgBy(changedBy);
		dgMasInvestigation2.setLastChgDate(currentDate);
		dgMasInvestigation2.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasInvestigation2);
		hbt.refresh(dgMasInvestigation2);

		editedSuccessfully = true;
		return editedSuccessfully;
	}
	public Map<String, Object> showInstructionsPopupJsp(int investigationId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationListForPopup = new ArrayList<DgMasInvestigation>();
		Session session = (Session)getSession();
		investigationListForPopup = session.createCriteria(DgMasInvestigation.class).add(Restrictions.idEq(investigationId)).list();
		if(investigationListForPopup.size()>0){
			DgMasInvestigation dgMasInvestigation = investigationListForPopup.get(0);
			String instruction = dgMasInvestigation.getInstructions();
			map.put("instruction", instruction);
		}
		return map;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * generateResultNumber(java.util.Map)
	 */

	@SuppressWarnings("unchecked")
	public String generateResultNumber(Map<String, Object> diagMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> resultSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String resultSeqNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");
		String month = "";
		String year = "";
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		
		int hospitalId = (Integer)diagMap.get("hospitalId");

		resultSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RES")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (resultSeqNoList.size() > 0) {
		//	for (TransactionSequence transactionSequence : resultSeqNoList) {
				TransactionSequence obj = (TransactionSequence) resultSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(seqNo);
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				resultSeqNo = resultSeqNo.concat(String.valueOf(seqNo));
				resultSeqNo = resultSeqNo.concat("/").concat(currentMonth);
				resultSeqNo = resultSeqNo.concat("/").concat(currentYear);
			//}
		} else if (resultSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgResultEntryHeader");
			tsObj.setTransactionPrefix("RES");
			tsObj.setTransactionSequenceName("Result No");
			tsObj.setTransactionSequenceNumber(1);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			tsObj.setMonth(Integer.parseInt(""+currentMonth));
			hbt.save(tsObj);
			hbt.refresh(tsObj);
		}
		return resultSeqNo;
	}

	public String generateResultNumberForLab(Map<String, Object> diagMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> resultSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String resultSeqNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");
		String month = "";
		String year = "";
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		int hospitalId = (Integer)diagMap.get("hospitalId");
		
		resultSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RES")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (resultSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : resultSeqNoList) {
				TransactionSequence obj = (TransactionSequence) resultSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(seqNo);
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				resultSeqNo = resultSeqNo.concat(String.valueOf(seqNo));
				resultSeqNo = resultSeqNo.concat("/").concat(currentMonth);
				resultSeqNo = resultSeqNo.concat("/").concat(currentYear);
			}
		} else if (resultSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgResultEntryHeader");
			tsObj.setTransactionPrefix("RES");
			tsObj.setTransactionSequenceName("Result No");
			tsObj.setTransactionSequenceNumber(1);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			tsObj.setMonth(Integer.parseInt(""+currentMonth));
			hbt.save(tsObj);
			hbt.refresh(tsObj);
			resultSeqNo = resultSeqNo.concat(String.valueOf(1));
			resultSeqNo = resultSeqNo.concat("/").concat(currentMonth);
			resultSeqNo = resultSeqNo.concat("/").concat(currentYear);
		}
		return resultSeqNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitResultEntry
	 * (java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntry(			
			Map<String, Object> parameterMap) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		String resultNo = box.getString(RequestConstants.RESULT_NO);
		String remarks = box.getString(RequestConstants.REMARKS);
		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(RequestConstants.HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);

		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
		int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);

		dgResultEntryHeader.setResultNo(resultNo);
		dgResultEntryHeader.setLastChgdBy(userName);
		dgResultEntryHeader.setLastChgdDate(date);
		dgResultEntryHeader.setLastChgdTime(time);
		dgResultEntryHeader.setRemarks(remarks);
		dgResultEntryHeader.setResultDate(date);
		dgResultEntryHeader.setResultStatus("P");
		dgResultEntryHeader.setResultTime(time);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeId);
		dgResultEntryHeader.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subchargeId);
		dgResultEntryHeader.setSubChargecode(masSubChargecode);

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setId(sampleCollectionId);
		dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		dgResultEntryHeader.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		dgResultEntryHeader.setMasHospital(masHospital);

		Patient patient = new Patient();
		patient.setId(hinId);
		dgResultEntryHeader.setPatient(patient);

		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			dgResultEntryHeader.setInpatient(inpatient);
		}

		if (resultEnteredId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(resultEnteredId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// hbt.save(dgResultEntryHeader);

			Vector result = box.getVector(RequestConstants.RESULT);
			Vector additionalRemarks = box
					.getVector(RequestConstants.ADDITIONAL_REMARKS);
			Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
			Vector sample_Id = box.getVector(SAMPLE_ID);
			Vector normalId = box.getVector(RequestConstants.NORMAL_ID);
			Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
			Vector uomId = box
					.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
			Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
			Vector investigationId = box
					.getVector(RequestConstants.INVESTIGATION_ID);
			Vector sampleDetailId = box
					.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID);
			
			Vector vectorChargeCodeId = box
					.getVector("chargeCodeId");

			hbt.save(dgResultEntryHeader);

			for (int i = 0; i < subTestId.size(); i++) {
				if (subTestId.get(i) != null && !subTestId.get(i).equals("")) {
					DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
					if (sample_Id.get(i) != null
							&& !sample_Id.get(i).equals("")) {
						MasSample masSample = new MasSample();
						masSample.setId(Integer.parseInt((String) sample_Id
								.get(i)));
						dgResultEntryDetail.setSample(masSample);
					}
					if (normalId.get(i) != null && !normalId.get(i).equals("")) {

						DgNormalValue dgNormalValue = new DgNormalValue();
						dgNormalValue.setId(Integer.parseInt((String) normalId
								.get(i)));
						dgResultEntryDetail.setNormal(dgNormalValue);
					} else {
						dgResultEntryDetail.setNormal(null);
					}

					if (fixedId.get(i) != null && !fixedId.get(i).equals("")) {
						DgFixedValue dgFixedValue = new DgFixedValue();
						dgFixedValue.setId(Integer.parseInt((String) fixedId
								.get(i)));
						dgResultEntryDetail.setFixed(dgFixedValue);
					}

					if (investigationId.get(i) != null
							&& !investigationId.get(i).equals("")) {
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail
								.setInvestigation(dgMasInvestigation);
					}
					if (investigationId.get(i) != null
							&& !investigationId.get(i).equals("")) {
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail.setChargeCode(masChargeCode);
					}
					if (result.get(i) != null && !result.get(i).equals("")) {
						dgResultEntryDetail.setResult((String) result.get(i));
					}

					if (additionalRemarks.get(i) != null) {
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
					}

					if (resultType != null && !resultType.equals("")) {
						dgResultEntryDetail.setResultType((String) resultType
								.get(i));
					}

					if (subTestId.get(i) != null
							&& !subTestId.get(i).equals("")) {
						DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
						dgSubMasInvestigation.setId(Integer
								.parseInt((String) subTestId.get(i)));
						dgResultEntryDetail
								.setSubInvestigation(dgSubMasInvestigation);
					}
					dgResultEntryDetail.setResultDetailStatus("P");

					if (uomId.get(i) != null && !uomId.get(i).equals("")) {
						DgUom dgUom = new DgUom();
						dgUom.setId(Integer.parseInt((String) uomId.get(i)));
						dgResultEntryDetail.setUom(dgUom);
					}
					if (sampleDetailId.get(i) != null
							&& !sampleDetailId.get(i).equals("")) {
						DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
						dgSample.setId(Integer.parseInt((String) sampleDetailId
								.get(i)));
						dgResultEntryDetail
								.setSampleCollectionDetails(dgSample);
					}
					dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
					hbt.save(dgResultEntryDetail);
					map.put("resultType", (String) resultType.get(i));
					int sId = Integer.parseInt((String) sampleDetailId.get(i));
					DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
							.load(DgSampleCollectionDetails.class, sId);
					dgDetails.setOrderStatus("E");
					hbt.update(dgDetails);
					hbt.refresh(dgDetails);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("resultNo", resultNo);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForMultipleInvestigationType(
			Map<String, Object> parameterMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
      
		System.out.println("submit for mulitiple");
		boolean saved = true;
		boolean resultFlag = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		Vector resultNo = box
				.getVector(RequestConstants.RESULT_NO_FOR_MULTIPLE_VALUE);
		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_MULTIPLE_VALUE);

		String remarks = box.getString(RequestConstants.REMARKS);

		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(RequestConstants.HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);

		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
		int resultEnteredId = box.getInt("employeeId");
		Vector HeaderCountFlag = box.getVector("HeaderCountFlag");

		Vector result = box.getVector(RequestConstants.RESULT);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS);
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Vector sample_Id = box.getVector(SAMPLE_ID);
		Vector normalId = box.getVector(RequestConstants.NORMAL_ID);
		Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID);
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID);
		Vector subTestSize = box.getVector(RequestConstants.SUB_TEST_SIZE);
		Vector vectorChargeCodeId = box
				.getVector("chargeCodeId");
		int srNo1=0;
		try
		{
			srNo1=box.getInt("srNo1");
		}catch(Exception e)
		{
			
		}

		Transaction tx = null;
		int i = 0;
		int k=0;
		int StartCounter=0;
		int EndCounter=0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean rejectedFlag = false;
		int orderHdId = 0;
		
		int counter=0;
		try {
			tx = session.beginTransaction();
		for (int j = 0; j < HeaderCountFlag.size(); j++) {
			i++;
			k++;
			/*
			 * List<DgResultEntryHeader> dgResultEntrylist = new
			 * ArrayList<DgResultEntryHeader>(); Criteria criteria =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.eq("SampleCollectionHeader.Id",
			 * sampleCollectionId))
			 * .add(Restrictions.eq("DgMasInvestigation.Id",
			 * Integer.parseInt((String)investigationId.get(i))));
			 * dgResultEntrylist = criteria.list();
			 */
			
			if(box.getString("sampleRejected"+srNo1).equals("")) {
				
				
		
				if(j==0)
				{
					StartCounter=1;
					EndCounter=Integer.parseInt((String) subTestSize.get(j));
				}
				else
				{
					StartCounter=EndCounter+2;
					
					
					EndCounter=StartCounter+Integer.parseInt((String) subTestSize.get(j));
					EndCounter=EndCounter-1;
				}
				
				
				System.out.println("StartCounter="+StartCounter);
				System.out.println("EndCounter="+EndCounter);
					
				for (int loopCount1 = StartCounter; loopCount1 <= EndCounter; loopCount1++, k++) {
					
					System.out.println("subTestSize.get(j)="+subTestSize.get(j));
					
					counter++;
					
					
					resultFlag=false;
					if (result.get(loopCount1) != null && !result.get(loopCount1).equals("") || fixedId.get(loopCount1)!= null && !fixedId.get(loopCount1).equals("")) {
						System.out.println("result.get(loopCount1)="+result.get(loopCount1));
						
						resultFlag=true;
						break;
						
					}
				}
				System.out.println("resultFlag="+resultFlag);
				if(resultFlag==true)
				{

				DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
				// if(dgResultEntrylist.size() == 0){

				dgResultEntryHeader.setResultNo((String) resultNo.get(j));
				if (testOrderNo.get(j) != null
						&& !testOrderNo.get(j).equals("")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(j)));
				}

				dgResultEntryHeader.setLastChgdBy(userName);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks(remarks);
				dgResultEntryHeader.setResultDate(date);
				dgResultEntryHeader.setResultStatus("P");
				dgResultEntryHeader.setResultTime(time);

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgResultEntryHeader.setMasHospital(masHospital);

				
				if (investigationId.get(StartCounter) != null
						&& !investigationId.get(StartCounter).equals("")) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(Integer
							.parseInt((String) investigationId.get(StartCounter)));
					dgResultEntryHeader
							.setDgMasInvestigation(dgMasInvestigation);
				}

				Patient patient = new Patient();
				patient.setId(hinId);
				dgResultEntryHeader.setPatient(patient);

				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}

				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
				}

				hbt.save(dgResultEntryHeader);
				hbt.refresh(dgResultEntryHeader);
				/*
				 * }else{ dgResultEntryHeader = dgResultEntrylist.get(0);
				 * dgResultEntryHeader.setLastChgdBy(userName);
				 * dgResultEntryHeader.setLastChgdDate(date);
				 * dgResultEntryHeader.setLastChgdTime(time);
				 * hbt.update(dgResultEntryHeader);
				 * hbt.refresh(dgResultEntryHeader); }
				 */
				// ////////////////////////////////////////////////////

				i=StartCounter;
				for (int loopCount = 0; loopCount < Integer
						.parseInt((String) subTestSize.get(j)); loopCount++, i++) {
					System.out.println("i="+i);
					System.out.println("StartCounter="+StartCounter);
					System.out.println("subTestId.get(i)="+subTestId.get(i));
					System.out.println(subTestId.get(i) != null && !subTestId.get(i).equals(""));
					if (// result.get(i) != null && !result.get(i).equals("") &&
					subTestId.get(i) != null && !subTestId.get(i).equals("")) {
						DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
						if (sample_Id.get(i) != null
								&& !sample_Id.get(i).equals("")) {
							MasSample masSample = new MasSample();
							masSample.setId(Integer.parseInt((String) sample_Id
									.get(i)));
							dgResultEntryDetail.setSample(masSample);
						}
						if (normalId.get(i) != null
								&& !normalId.get(i).equals("")) {

							DgNormalValue dgNormalValue = new DgNormalValue();
							dgNormalValue.setId(Integer
									.parseInt((String) normalId.get(i)));
							dgResultEntryDetail.setNormal(dgNormalValue);
						} else {
							dgResultEntryDetail.setNormal(null);
						}

						if (fixedId.get(i) != null
								&& !fixedId.get(i).equals("")) {
							DgFixedValue dgFixedValue = new DgFixedValue();
							dgFixedValue.setId(Integer
									.parseInt((String) fixedId.get(i)));
							dgResultEntryDetail.setFixed(dgFixedValue);
							
							List<String> fixedValue = new ArrayList<String>();
							fixedValue = session.createCriteria(DgFixedValue.class).add(Restrictions.idEq(Integer.parseInt((String) fixedId.get(i)))).setProjection(Projections.property("FixedValue")).list();
							dgResultEntryDetail.setResult(fixedValue.get(0));
						}

						if (investigationId.get(i) != null
								&& !investigationId.get(i).equals("")) {
							DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
							dgMasInvestigation.setId(Integer
									.parseInt((String) investigationId.get(i)));
							dgResultEntryDetail
									.setInvestigation(dgMasInvestigation);
						}
						System.out.println("investigationId.get(i)="+investigationId.get(i));
						/*System.out.println("investigationId.get(i)="+investigationId.get(i));
						System.out.println("vectorChargeCodeId.get(i)="+vectorChargeCodeId.get(i-1));
						System.out.println("LengthvectorInvestigation="+investigationId.size());
						System.out.println("vectorChargeCodeIdLength="+vectorChargeCodeId.size());*/
						
							
							
						resultFlag=false;
						if (result.get(i) != null && !result.get(i).equals("")) {
							dgResultEntryDetail.setResult((String) result
									.get(i));
							
							resultFlag=true;
							
						}

						if (additionalRemarks.get(i) != null) {
							dgResultEntryDetail
									.setRemarks((String) additionalRemarks
											.get(i));
						}

						if (resultType != null && !resultType.equals("")) {
							dgResultEntryDetail
									.setResultType((String) resultType.get(i));
						}

						if (subTestId.get(i) != null
								&& !subTestId.get(i).equals("")) {
							DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
							dgSubMasInvestigation.setId(Integer
									.parseInt((String) subTestId.get(i)));
							dgResultEntryDetail
									.setSubInvestigation(dgSubMasInvestigation);
						}
						dgResultEntryDetail.setResultDetailStatus("P");

						if (uomId.get(i) != null && !uomId.get(i).equals("")) {
							DgUom dgUom = new DgUom();
							dgUom
									.setId(Integer.parseInt((String) uomId
											.get(i)));
							dgResultEntryDetail.setUom(dgUom);
						}
						if (sampleDetailId.get(i) != null
								&& !sampleDetailId.get(i).equals("")) {
							DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
							dgSample.setId(Integer
									.parseInt((String) sampleDetailId.get(i)));
							dgResultEntryDetail
									.setSampleCollectionDetails(dgSample);
						}
						
						map.put("resultType", (String) resultType.get(i));
						int sId = Integer.parseInt((String) sampleDetailId
								.get(i));
						DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
								.load(DgSampleCollectionDetails.class, sId);
						dgDetails.setOrderStatus("E");
						hbt.update(dgDetails);
						hbt.refresh(dgDetails);
						
						
							dgResultEntryDetail.setChargeCode(dgDetails.getChargeCode());
						
						
						dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
						hbt.save(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);

					}
					k++;
				}

				// //////////////////////////////////////////////////
				// saved = true;
			
				}
			}else {
				int sId = Integer.parseInt((String) sampleDetailId.get(i));
				DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate().load(DgSampleCollectionDetails.class, sId);
				dgDetails.setOrderStatus("P");  // R for rejected 
				dgDetails.setRejected("y");
				hbt.update(dgDetails);
				hbt.refresh(dgDetails);
				int orderDtId = dgDetails.getOrderdt().getId();
				DgOrderdt orderdt = (DgOrderdt)hbt.load(DgOrderdt.class, orderDtId);
				orderdt.setOrderStatus("P");
				hbt.update(orderdt);
				orderHdId = orderdt.getOrderhd().getId();
				System.out.println("orderHdId-- "+orderHdId);
			}
		}
		if(orderHdId!=0){
			DgOrderhd orderhd = (DgOrderhd)hbt.load(DgOrderhd.class, orderHdId);
			orderhd.setOrderStatus("P");
			hbt.update(orderhd);
		}
		
		
			tx.commit();
			saved = true;
	
		
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			saved = false;
			e.printStackTrace();
		}
		
		map.put("saved", saved);
		map.put("resultNo", resultNo);

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultEntryForSingleParameter(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSingleParameter(
			Map<String, Object> parameterMap) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		
		System.out.println("submit for single");
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		String resultNo = box.getString(RequestConstants.RESULT_NO);
		String remarks = box.getString(RequestConstants.REMARKS);
		// Vector resultSingle = null;
		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(RequestConstants.HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
		int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
		int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);

		// resultSingle = box.getVector(RequestConstants.RESULT);

		dgResultEntryHeader.setResultNo(resultNo);
		dgResultEntryHeader.setLastChgdBy(userName);
		dgResultEntryHeader.setLastChgdDate(date);
		dgResultEntryHeader.setLastChgdTime(time);
		dgResultEntryHeader.setRemarks(remarks);
		dgResultEntryHeader.setResultDate(date);
		dgResultEntryHeader.setResultStatus("P");
		dgResultEntryHeader.setResultTime(time);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeId);
		dgResultEntryHeader.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subchargeId);
		dgResultEntryHeader.setSubChargecode(masSubChargecode);

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setId(sampleCollectionId);
		dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		dgResultEntryHeader.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		dgResultEntryHeader.setMasHospital(masHospital);

		Patient patient = new Patient();
		patient.setId(hinId);
		dgResultEntryHeader.setPatient(patient);
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			dgResultEntryHeader.setInpatient(inpatient);
		}
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		if (resultEnteredId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(resultEnteredId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(dgResultEntryHeader);

			String result = box.getString(RequestConstants.RESULT);

			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);
			int charge_code_Id = box.getInt(CHARGE_CODE_ID);
			int sample_Id = box.getInt(SAMPLE_ID);
			int investigationId = box.getInt(RequestConstants.INVESTIGATION_ID);
			int uomId = box.getInt(RequestConstants.UNIT_OF_MEASUREMENT_ID);
			String resultType = box.getString(RequestConstants.RESULT_TYPE);
			int sampleDetailId = box
					.getInt(RequestConstants.DG_SAMPLE_DETAIL_ID);

			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			if (investigationId != 0) {
				if (sample_Id != 0) {
					MasSample masSample = new MasSample();
					masSample.setId(sample_Id);
					dgResultEntryDetail.setSample(masSample);
				}

				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetail.setInvestigation(dgMasInvestigation);
				}
				dgResultEntryDetail.setResult(result);
				dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResultType(resultType);
				dgResultEntryDetail.setResultDetailStatus("P");

				if (charge_code_Id != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(charge_code_Id);
					dgResultEntryDetail.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetail.setSampleCollectionDetails(dgSample);
				}
				if (uomId != 0) {
					DgUom dgUom = new DgUom();
					dgUom.setId(uomId);
					dgResultEntryDetail.setUom(dgUom);
				}
				hbt.save(dgResultEntryDetail);
				map.put("resultType", resultType);
				DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
						.load(DgSampleCollectionDetails.class, sampleDetailId);
				dgDetails.setOrderStatus("E");
				hbt.update(dgDetails);
				hbt.refresh(dgDetails);

			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSingleParameterOnly(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("submit for single");
		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		String formSubmitFrom ="HAL";
		
		if (parameterMap.get("formSubmitFrom") != null) {
			formSubmitFrom = (String) parameterMap.get("formSubmitFrom");
		}
		
		System.out.println("formSubmitFrom="+formSubmitFrom);
		
		boolean rejectedFlag = false;
		int orderHdId = 0;
		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_SINGLE_VALUE);
		Vector resultNo = box
				.getVector(RequestConstants.RESULT_NO_SINGLE_VALUE);
		Vector remarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector resultTypeSingleValue = box
				.getVector(RequestConstants.RESULT_TYPE_SINGLE_VALUE);
		// ///////////////////// Data For Details
		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector charge_code_Id = box
				.getVector(RequestConstants.CHARGE_CODE_ID_SINGLE_VALUE);
		Vector sample_Id = box.getVector(SAMPLE_ID_SINGLE_VALUE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID_SINGLE_VALUE);
		Vector uomId = box
				.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE);
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID_SINGLE_VALUE);
		// ///////////////////// Data For Details
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (int i = 0; i < resultTypeSingleValue.size(); i++) {
			if(box.getString("sampleRejected"+i).equals("")) {
			if (result.get(i) != null && !result.get(i).equals("")
					&& resultTypeSingleValue.get(i) != null
					&& !resultTypeSingleValue.get(i).equals("")) {
			
					DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
					// Vector resultSingle = null;
					int subchargeId = box
					.getInt(RequestConstants.SUB_CHARGECODE_ID);
					int mainChargeId = box
					.getInt(RequestConstants.MAIN_CHARGECODE_ID);
					int sampleCollectionId = box
					.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
					int hinId = box.getInt(RequestConstants.HIN_ID);
					int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
					int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
					int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
					int resultEnteredId = box
					.getInt(RequestConstants.RESULT_ENTERED_BY);

					// resultSingle = box.getVector(RequestConstants.RESULT);

					dgResultEntryHeader.setResultNo((String) resultNo.get(i));
					dgResultEntryHeader.setLastChgdBy(userName);
					dgResultEntryHeader.setLastChgdDate(date);
					dgResultEntryHeader.setLastChgdTime(time);
					dgResultEntryHeader.setRemarks((String) remarks.get(i));
					dgResultEntryHeader.setResultDate(date);
					dgResultEntryHeader.setResultStatus("P");
					if(formSubmitFrom.equalsIgnoreCase("Empanelled"))
					{
						dgResultEntryHeader.setResultStatus("A");
						dgResultEntryHeader.setVerified("V");
						dgResultEntryHeader.setVerifiedOn(date);
						dgResultEntryHeader.setVerifiedTime(time);
						
					}
					dgResultEntryHeader.setResultTime(time);

					if (testOrderNo.get(i) != null
							&& !testOrderNo.get(i).equals("")) {
						dgResultEntryHeader.setTestOrderNo(Integer
								.parseInt((String) testOrderNo.get(i)));
					}

					DgMasInvestigation dgMasInvestigationForHeader = new DgMasInvestigation();
					dgMasInvestigationForHeader.setId(Integer
							.parseInt((String) investigationId.get(i)));
					dgResultEntryHeader
					.setDgMasInvestigation(dgMasInvestigationForHeader);

					MasMainChargecode masMainChargecode = new MasMainChargecode();
					masMainChargecode.setId(mainChargeId);
					dgResultEntryHeader.setMainChargecode(masMainChargecode);

					MasSubChargecode masSubChargecode = new MasSubChargecode();
					masSubChargecode.setId(subchargeId);
					dgResultEntryHeader.setSubChargecode(masSubChargecode);

					DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
					dgSampleCollectionHeader.setId(sampleCollectionId);
					dgResultEntryHeader
					.setSampleCollectionHeader(dgSampleCollectionHeader);

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					dgResultEntryHeader.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					dgResultEntryHeader.setMasHospital(masHospital);

					Patient patient = new Patient();
					patient.setId(hinId);
					dgResultEntryHeader.setPatient(patient);
					if (inpatientId != 0) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						dgResultEntryHeader.setInpatient(inpatient);
					}
					if (employeeId != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(employeeId);
						dgResultEntryHeader.setEmployee(masEmployee);
					}

					if (resultEnteredId != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(resultEnteredId);
						dgResultEntryHeader.setEmployee(masEmployee);
					}
					Transaction tx = null;
					try {
						tx = session.beginTransaction();					

						hbt.save(dgResultEntryHeader);
						hbt.refresh(dgResultEntryHeader);
						// ///////////////////////////////

						DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
						// int x = Integer.parseInt((String)investigationId.get(i));

						if (Integer.parseInt((String) investigationId.get(i)) != 0) {

							if (!((String) sample_Id.get(i)).equals("")
									&& Integer.parseInt((String) sample_Id.get(i)) != 0) {
								MasSample masSample = new MasSample();
								masSample.setId(Integer.parseInt((String) sample_Id
										.get(i)));
								dgResultEntryDetail.setSample(masSample);
							}

							// if(investigationId != 0){
							DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
							dgMasInvestigation.setId(Integer
									.parseInt((String) investigationId.get(i)));
							dgResultEntryDetail
							.setInvestigation(dgMasInvestigation);
							// }
							dgResultEntryDetail.setResult((String) result.get(i));
							dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
							dgResultEntryDetail
							.setRemarks((String) additionalRemarks.get(i));
							dgResultEntryDetail
							.setResultType((String) resultTypeSingleValue
									.get(i));
							dgResultEntryDetail.setResultDetailStatus("P");
							if(formSubmitFrom.equalsIgnoreCase("Empanelled"))
							{
								dgResultEntryDetail.setResultDetailStatus("A");
								dgResultEntryDetail.setValidated("Y");
								
								
							}

							if (!((String) charge_code_Id.get(i)).equals("")
									&& Integer.parseInt((String) charge_code_Id
											.get(i)) != 0) {
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(Integer
										.parseInt((String) charge_code_Id.get(i)));
								dgResultEntryDetail.setChargeCode(masChargeCode);
							}
							if (!((String) sampleDetailId.get(i)).equals("")
									&& Integer.parseInt((String) sampleDetailId
											.get(i)) != 0) {
								DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
								dgSample.setId(Integer
										.parseInt((String) sampleDetailId.get(i)));
								dgResultEntryDetail
								.setSampleCollectionDetails(dgSample);
							}
							if (!((String) uomId.get(i)).equals("")
									&& Integer.parseInt((String) uomId.get(i)) != 0) {
								DgUom dgUom = new DgUom();
								dgUom
								.setId(Integer.parseInt((String) uomId
										.get(i)));
								dgResultEntryDetail.setUom(dgUom);
							}
							hbt.save(dgResultEntryDetail);
							hbt.refresh(dgResultEntryDetail);
							// map.put("resultType", resultType);
							DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
							.load(DgSampleCollectionDetails.class,Integer.parseInt((String) sampleDetailId.get(i)));
							dgDetails.setOrderStatus("E");
							hbt.update(dgDetails);
							hbt.refresh(dgDetails);
						}
						saved = true;
						tx.commit();
					} catch (Exception e) {
						if (tx != null)
							tx.rollback();
						saved = false;
						e.printStackTrace();
					}
				}
			}else {
				DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
						.load(DgSampleCollectionDetails.class,Integer.parseInt((String) sampleDetailId.get(i)));
				dgDetails.setOrderStatus("P"); //R for rejected
				dgDetails.setRejected("y");
				hbt.update(dgDetails);
				hbt.refresh(dgDetails);
				
				int orderDtId = dgDetails.getOrderdt().getId();
				DgOrderdt orderdt = (DgOrderdt)hbt.load(DgOrderdt.class, orderDtId);
				orderdt.setOrderStatus("P");
				hbt.update(orderdt);
				rejectedFlag = true;
				orderHdId = orderdt.getOrderhd().getId();
				System.out.println("orderHdId-- "+orderHdId);
			}
		}
		if(rejectedFlag && orderHdId!=0){
			DgOrderhd orderhd = (DgOrderhd)hbt.load(DgOrderhd.class, orderHdId);
			orderhd.setOrderStatus("P");
			hbt.update(orderhd);
		}
		// saved = true;
		map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getPatientDetailsForResultValidation(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForResultValidation(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		// String FromDateString =
		// HMSUtil.convertDateToStringWithoutTime(fromDate);

		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");

		}
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.between("ResultDate", fromDate, toDate))
					.createAlias("Patient", "pt");
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "P")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId));
			if (!deptType.equalsIgnoreCase("RADIO")) {
				crit = crit.add(Restrictions.between("ResultDate", fromDate,
						toDate));
			}
			//
			crit = crit.createAlias("Patient", "pt");
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo + "%"));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.SFirstName", serPersonFName
					+ "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.PatientType", orderType));
		}

		patientList = crit.list();
		Date sampleCollDate = new Date();
		if (deptType.equalsIgnoreCase("RADIO")) {
			for (DgResultEntryHeader dgResultEntryHeader : patientList) {
				Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
						.getDgResultEntryDetails();
				for (DgResultEntryDetail dgResultEntryDetail : dgResultEntrySet) {
					DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
							.getSampleCollectionDetails();
					Date sampleCollectionDate = dgSampleCollectionDetails
							.getSampleCollDatetime();

					sampleCollDateString = HMSUtil
							.convertDateToStringWithoutTime(sampleCollectionDate);
					sampleCollDate = HMSUtil
							.convertStringTypeDateToDateType(sampleCollDateString);
					if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
							.compareTo(toDate) <= 0)) {
						patientListTemp.add(dgResultEntryHeader);
					}
				}
			}
			patientList = patientListTemp;
			// patientList.removeAll(patientListTemp);

		}

		map.put("patientDetailsList", patientList);
		return map;
	}

	public Map<String, Object> getPatientDetailsForResultEntryModification(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		// String FromDateString =
		// HMSUtil.convertDateToStringWithoutTime(fromDate);

		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");

		}
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.between("ResultDate", fromDate, toDate))
					.createAlias("Patient", "pt");
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "P")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId));
			if (!deptType.equalsIgnoreCase("RADIO")) {
				crit = crit.add(Restrictions.between("ResultDate", fromDate,
						toDate));
			}
			//
			crit = crit.createAlias("Patient", "pt");
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo + "%"));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.SFirstName", serPersonFName
					+ "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.PatientType", orderType));
		}

		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	public Map<String, Object> getPatientDetailsForResultValidationLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = null;
		/*String fromDateString = HMSUtil
				.convertDateToStringWithoutTime(new Date());
		fromDate = HMSUtil.convertStringTypeDateToDateType(fromDateString);*/

		Date toDate = null;
		/*String toDateString = HMSUtil
				.convertDateToStringWithoutTime(new Date());
		toDate = HMSUtil.convertStringTypeDateToDateType(toDateString);*/

		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int hospitalId = 0;
		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		String barCodeOrderNo="";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		// String FromDateString =
		// HMSUtil.convertDateToStringWithoutTime(fromDate);
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");

		}
		if (mapForDs.get("barCodeOrderNo") != null) {
			barCodeOrderNo = (String) mapForDs.get("barCodeOrderNo");

		}
		
		System.out.println("departmentId="+departmentId);
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("MasHospital.Id", hospitalId))
					.createAlias("Patient", "pt");
			
			if(fromDate != null && toDate !=null)
			{
				crit.add(Restrictions.between("ResultDate", fromDate, toDate));
			}
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "P")).createAlias(
					"Department", "dept")/*.add(
					Restrictions.eq("dept.Id", departmentId))*/.add(Restrictions.eq("MasHospital.Id", hospitalId));
			// if(!deptType.equalsIgnoreCase("RADIO")){
			if(fromDate != null && toDate !=null)
			{
				crit.add(Restrictions.between("ResultDate", fromDate, toDate));
			}
			// }
			//
			crit = crit.createAlias("Patient", "pt");
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%").ignoreCase());
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.SFirstName", serPersonFName
					+ "%").ignoreCase());
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.PatientType", orderType));
		}
		System.out.println("barCodeOrderNo="+barCodeOrderNo);
		if (!barCodeOrderNo.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.OrderNo", barCodeOrderNo));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id")).addOrder(
				Order.asc("SubChargecode.Id"));

		patientList = crit.list();
		/*
		 * Date sampleCollDate = new Date(); for(DgResultEntryHeader
		 * dgResultEntryHeader : patientList){
		 * if(dgResultEntryHeader.getResultType() != null &&
		 * dgResultEntryHeader.getResultType().equalsIgnoreCase("S")){
		 * Set<DgResultEntryDetailSen> dgResultEntrySet =
		 * dgResultEntryHeader.getDgResultEntryDetailSen();
		 * DgResultEntryDetailSen dgResultEntryDetailSen =
		 * dgResultEntrySet.iterator().next(); DgSampleCollectionDetails
		 * dgSampleCollectionDetails =
		 * dgResultEntryDetailSen.getSampleCollection(); Date
		 * sampleCollectionDate =
		 * dgSampleCollectionDetails.getSampleCollDatetime();
		 * 
		 * sampleCollDateString =
		 * HMSUtil.convertDateToStringWithoutTime(sampleCollectionDate);
		 * sampleCollDate =
		 * HMSUtil.convertStringTypeDateToDateType(sampleCollDateString); if(
		 * (sampleCollDate.compareTo(fromDate) >=0 &&
		 * sampleCollDate.compareTo(toDate)<=0) ){
		 * patientListTemp.add(dgResultEntryHeader); } }else{
		 * Set<DgResultEntryDetail> dgResultEntrySet =
		 * dgResultEntryHeader.getDgResultEntryDetails(); DgResultEntryDetail
		 * dgResultEntryDetail = dgResultEntrySet.iterator().next();
		 * DgSampleCollectionDetails dgSampleCollectionDetails =
		 * dgResultEntryDetail.getSampleCollectionDetails(); Date
		 * sampleCollectionDate =
		 * dgSampleCollectionDetails.getSampleCollDatetime();
		 * 
		 * sampleCollDateString =
		 * HMSUtil.convertDateToStringWithoutTime(sampleCollectionDate);
		 * sampleCollDate =
		 * HMSUtil.convertStringTypeDateToDateType(sampleCollDateString); if(
		 * (sampleCollDate.compareTo(fromDate) >=0 &&
		 * sampleCollDate.compareTo(toDate)<=0) ){
		 * patientListTemp.add(dgResultEntryHeader); } } } patientList =
		 * patientListTemp;
		 */

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		if (patientList.size() > 0) {
			patientListSubDepartWise.add(patientList.get(0));
			stringOfIds = stringOfIds + patientList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ patientList.get(0).getSubChargecode().getId();

			stringOfIdsList.add(stringOfIds);
			stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
				if (!patientList.get(ilop).getSampleCollectionHeader().getId()
						.equals(
								patientList.get(ilop + 1)
										.getSampleCollectionHeader().getId())) {

					patientListSubDepartWise.add(patientList.get(ilop + 1));
					stringOfIdsList.add(patientList.get(ilop + 1).getId()
							.toString());
					stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
							.getSubChargecode().getId().toString());
				} else {
					if (!patientList.get(ilop).getSubChargecode().getId()
							.equals(
									patientList.get(ilop + 1)
											.getSubChargecode().getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						int ii = stringOfIdsList.size() - 1;
						stringOfIds = stringOfIdsList.get(ii);
						stringOfIdsList.remove(ii);
						stringOfIds = stringOfIds + ","
								+ patientList.get(ilop + 1).getId().toString();
						stringOfIdsList.add((ii), stringOfIds);
					}
				}
			}
		}

		patientList = patientListSubDepartWise;
		map.put("patientDetailsList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}

	public Map<String, Object> getPatientDetailsForResultEntryModificationLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;

		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		// String FromDateString =
		// HMSUtil.convertDateToStringWithoutTime(fromDate);

		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");

		}
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.between("ResultDate", fromDate, toDate))
					.createAlias("Patient", "pt");
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A"))/*.createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId))*/;
			// if(!deptType.equalsIgnoreCase("RADIO")){
			/*crit = crit.add(Restrictions
					.between("ResultDate", fromDate, toDate));*/
			// }
			//
			crit = crit.createAlias("Patient", "pt");
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo + "%"));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.SFirstName", serPersonFName
					+ "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.PatientType", orderType));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id")).addOrder(
				Order.asc("SubChargecode.Id"));

		patientList = crit.list();
		
		System.out.println("patientList="+patientList.size());

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		if (patientList.size() > 0) {
			patientListSubDepartWise.add(patientList.get(0));
			stringOfIds = stringOfIds + patientList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ patientList.get(0).getSubChargecode().getId();

			stringOfIdsList.add(stringOfIds);
			stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
				if (!patientList.get(ilop).getSampleCollectionHeader().getId()
						.equals(
								patientList.get(ilop + 1)
										.getSampleCollectionHeader().getId())) {

					patientListSubDepartWise.add(patientList.get(ilop + 1));
					stringOfIdsList.add(patientList.get(ilop + 1).getId()
							.toString());
					stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
							.getSubChargecode().getId().toString());
				} else {
					if (!patientList.get(ilop).getSubChargecode().getId()
							.equals(
									patientList.get(ilop + 1)
											.getSubChargecode().getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						int ii = stringOfIdsList.size() - 1;
						stringOfIds = stringOfIdsList.get(ii);
						stringOfIdsList.remove(ii);
						stringOfIds = stringOfIds + ","
								+ patientList.get(ilop + 1).getId().toString();
						stringOfIdsList.add((ii), stringOfIds);
					}
				}
			}
		}

		patientList = patientListSubDepartWise;
		map.put("patientDetailsList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getSampleCollectionDetails(int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetails(
			int sampleCollectionDetailId, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgFixedValue> fixedValAllList = new ArrayList<DgFixedValue>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int subTestId = 0;
		Session session = (Session) getSession();

		try {
		/*	employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();*/
			/*employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();*/
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			sampleCollectionList = session.createCriteria(
					DgSampleCollectionDetails.class).add(
					Restrictions.eq("Id", sampleCollectionDetailId)).list();
			if (sampleCollectionList.size() > 0) {
				detailsMap.put("sampleCollectionList", sampleCollectionList);

			}
			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();
					subList = session.createCriteria(
							DgSubMasInvestigation.class).add(
							Restrictions
									.eq("Investigation.Id", investigationId))
							.addOrder(Order.asc("OrderNo")).list();

				}
			}
			if (subList.size() > 0) {
				// for(DgSubMasInvestigation dgSubMasInvestigation : subList){
				detailsMap.put("subList", subList);
				// }
			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subInvSet = dgApp.getInvestigation()
						.getDgSubMasInvestigations();

				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();

				/*	fixedValList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
											+ subTestId
											+ "' and ga.FixedValue != null");*/
					
					
					fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", subTestId))
					.add(Restrictions.isNotNull("FixedValue")).list();
					if (fixedValList.size() > 0) {
						fixedValAllList.addAll(fixedValList);
						detailsMap.put("fixedValList", fixedValAllList);

					}
				}

			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subTempSet = dgApp.getInvestigation().getDgTemplates();
				for (DgTemplate dgTemplate : subTempSet) {
					investigationId = dgTemplate.getInvestigation().getId();
					/*templateList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.DgTemplate dt where dt.Investigation.Id= '"
									+ investigationId + "'");*/

					
					templateList=session.createCriteria(DgTemplate.class).add(Restrictions.eq("Investigation.Id", investigationId)).list();
					
					if (templateList.size() > 0) {
						detailsMap.put("templateList", templateList);
					}
				}
			}
			Criteria criteria = null;
			criteria = session.createCriteria(DgResultEntryDetail.class).add(
					Restrictions.eq("SampleCollectionDetails.Id",
							sampleCollectionDetailId));
			dgResultEntryDetailList = criteria.list();
			detailsMap.put("dgResultEntryDetailListForResult",
					dgResultEntryDetailList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetailsForLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgFixedValue> fixedValAllList = new ArrayList<DgFixedValue>();
		List<List<DgFixedValue>> allFixedValueList = new ArrayList<List<DgFixedValue>>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int deptId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int subTestId = 0;
		int hospitalId = 0;
		if (mapForDs.get("dgSampleHeaderId") != null) {
			dgSampleHeaderId = (Integer) mapForDs.get("dgSampleHeaderId");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		
		String flag="";
		if (mapForDs.get("flag") != null)
			flag =  (String)mapForDs.get("flag");
		System.out.println("flag1="+flag);
		Session session = (Session) getSession();
		Criteria crit=null;

		try {
		/*	employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();*/
			/*employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}*/
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			crit = session.createCriteria(DgSampleCollectionDetails.class).createAlias("SampleCollectionHeader", "sch").add(
					Restrictions.eq("sch.Id",dgSampleHeaderId))
					.add(Restrictions.eq("Subcharge.Id", subChargeId))
					.add(Restrictions.eq("OrderStatus", "A"))				
					.createAlias("Investigation", "inv")
					.addOrder(Order.asc("inv.TestOrderNo")).createAlias("sch.Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("sch.Hospital.Id", hospitalId));
			

			if(flag.equalsIgnoreCase("investigationForEmpanelledHospital"))
			{
				crit= crit.add(Restrictions.eq("EmpanelledStatus", "y").ignoreCase());
			}
			if(flag.equalsIgnoreCase("investigationForHalHospital"))
			{
				crit= crit.add(Restrictions.eq("EmpanelledStatus", "n").ignoreCase());
			}
					
			sampleCollectionList= crit.list();
			System.out.println("sampleCollectionList="+sampleCollectionList.size()+flag);

			if (sampleCollectionList.size() > 0) {
				detailsMap.put("sampleCollectionList", sampleCollectionList);

			}

			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();
					subList = session.createCriteria(
							DgSubMasInvestigation.class).add(
							Restrictions
									.eq("Investigation.Id", investigationId))
							.addOrder(Order.asc("OrderNo")).list();

				}
			}
			if (subList.size() > 0) {
				// for(DgSubMasInvestigation dgSubMasInvestigation : subList){
				detailsMap.put("subList", subList);
				// }
			}

			for (DgSampleCollectionDetails dgApp1 : sampleCollectionList) {
				subInvSet = dgApp1.getInvestigation()
						.getDgSubMasInvestigations();
				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();
					//Code hide by amit on 15/08/2012 for Sql Injection
					/*fixedValList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
											+ subTestId
											+ "' and ga.FixedValue != null");*/
					//Code added by amit  on 15/08/2012 due to Sql Injection
					
					fixedValList = session.createCriteria(DgFixedValue.class)
					.add(Restrictions.eq("SubInvestigation.Id", subTestId))
					.add(Restrictions.isNotNull("FixedValue")).list();
					////////////////////End///////////////////////////////////////
					
					if (fixedValList.size() > 0) {
						fixedValAllList.addAll(fixedValList);
						detailsMap.put("fixedValList", fixedValAllList);

					}
				}
				allFixedValueList.add(fixedValAllList);
				detailsMap.put("allFixedValueList", allFixedValueList);
			}
	/*		if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
					investigationId = dgApp.getInvestigation().getId();
					//System.out.println("investigationId data---"+investigationId);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					try {
						templateList =hbt.find("from jkt.hms.masters.business.DgTemplate dt where dt.Investigation.Id= "+ investigationId + "");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
		   //     	templateList=session.createCriteria(DgTemplate.class).add(Restrictions.eq("Investigation.Id", investigationId)).list();
					System.out.println("templateList----in DS--"+templateList.size());
					if (templateList.size() > 0) {
						detailsMap.put("templateList", templateList);
					}
			}
			 */
			if (sampleCollectionList.size() > 0) {
				Criteria criteria = null;
				criteria = session.createCriteria(DgResultEntryDetail.class)
						.add(
								Restrictions.eq("SampleCollectionDetails.Id",
										sampleCollectionList.get(0).getId()));
				dgResultEntryDetailList = criteria.list();
				detailsMap.put("dgResultEntryDetailListForResult",
						dgResultEntryDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getResultList
	 * (int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultList(int resultId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> resultHeaderList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> resultDetailList = new ArrayList<DgResultEntryDetail>();
		/*resultHeaderList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgResultEntryHeader as md where md.Id='"
						+ resultId + "'");
		*/
		Session session = (Session) getSession();
		resultHeaderList=session.createCriteria(DgResultEntryHeader.class).add(Restrictions.eq("Id", resultId)).list();
		
/*		resultDetailList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.DgResultEntryDetail as md where md.ResultEntry.Id ='"
								+ resultId + "'");
*/		
		
		resultDetailList=session.createCriteria(DgResultEntryDetail.class).add(Restrictions.eq("ResultEntry.Id", resultId)).list();
		
		return map;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getResultEntryDetails(int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultEntryDetails(int resultId, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultDetailId = 0;
		int resultHeaderId = 0;
		int fixedId = 0;
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Id", resultId)).list();
			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();

					resultHeaderId = dgResultHeader.getId();

				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "P"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session.createCriteria(
							DgResultEntryDetailSen.class).createAlias(
							"ResultEntry", "rs").add(
							Restrictions.eq("rs.Id", resultHeaderId)).list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);

				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).add(
						Restrictions.eq("Status", "y")).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.add(Restrictions.eq("Status", "y")).list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).add(
						Restrictions.eq("Status", "y")).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
/*						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
						
*/						
						fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", fixedId)).add(Restrictions.isNotNull("FixedValue")).list();
						
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultEntryForModification(int resultId,
			int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultHeaderId = 0;
		int fixedId = 0;
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Id", resultId)).list();
			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					resultHeaderId = dgResultHeader.getId();
				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "P"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session.createCriteria(
							DgResultEntryDetailSen.class).createAlias(
							"ResultEntry", "rs").add(
							Restrictions.eq("rs.Id", resultHeaderId)).list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);

				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
						/*fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
						*/
						fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", fixedId)).add(Restrictions.isNotNull("FixedValue")).list();
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}

					}
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultEntryDetailsLab(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultHeaderId = 0;
		int fixedId = 0;
		int deptId = 0;
		String resultId = "";
		String stringOfIds = "";
		Integer stringSubDeptIds = 0;
		int hospitalId = 0;
		String[] idsArray = new String[0];
		String[] headerIdsValue = new String[0];

		List<Integer> headerIdsInt = new ArrayList<Integer>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();

		if (requestMap.get("resultId") != null) {
			resultId = (String) requestMap.get("resultId");
		}
		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}
		if (requestMap.get("hospitalId") != null) {
			hospitalId = (Integer) requestMap.get("hospitalId");
		}
		/*
		 * if(resultIdToRemove != 0){ if(!resultId.equals("")){ idsArray =
		 * resultId.split("@"); stringOfIds = idsArray[0]; stringSubDeptIds =
		 * Integer.parseInt(idsArray[1]);
		 * 
		 * //System.out.println("String Of Ids :"+stringOfIds); headerIdsValue =
		 * stringOfIds.split(","); for(String id : headerIdsValue ){
		 * headerIdsInt.add(Integer.parseInt(id)); } } }else{
		 */
		if (!resultId.equals("")) {
			idsArray = resultId.split("@");
			stringOfIds = idsArray[0];
			stringSubDeptIds = Integer.parseInt(idsArray[1]);

			headerIdsValue = stringOfIds.split(",");
			for (String id : headerIdsValue) {
				headerIdsInt.add(Integer.parseInt(id));
			}
		}
		// }
		try {
		/*	employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();*/
			/*employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}*/
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.in("Id", headerIdsInt)).add(
					Restrictions.eq("SubChargecode.Id", stringSubDeptIds)).add(
					Restrictions.eq("ResultStatus", "P")).createAlias(
					"DgMasInvestigation", "inv").addOrder(
					Order.asc("inv.TestOrderNo")).add(Restrictions.eq("MasHospital.Id", hospitalId)).list();

			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					resultHeaderId = dgResultHeader.getId();
				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "P"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session.createCriteria(
							DgResultEntryDetailSen.class).createAlias(
							"ResultEntry", "rs").add(
							Restrictions.eq("rs.Id", resultHeaderId)).list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}

				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
/*						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
*/						fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", fixedId)).add(Restrictions.isNotNull("FixedValue")).list();
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getResultEntryDetailsForTemplate(
			String resultNo, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		Session session = (Session) getSession();
		try {
			dgResultdetailList = session.createCriteria(
					DgResultEntryDetail.class).createAlias("ResultEntry", "r")
					.add(Restrictions.eq("r.ResultNo", resultNo)).add(
							Restrictions.eq("r.Department.Id", deptId)).list();
			if (dgResultdetailList != null || dgResultdetailList.size() > 0) {
				detailsMap.put("resultList", dgResultdetailList);
				detailsMap.put("hinNo", dgResultdetailList.get(0)
						.getResultEntry().getPatient().getHinNo());

				detailsMap.put("serviceNo", dgResultdetailList.get(0)
						.getResultEntry().getPatient().getServiceNo());

				Patient p = dgResultdetailList.get(0).getResultEntry()
						.getPatient();
				String prefix = "";
				prefix = p.getPrefix();
				detailsMap.put("prefix", prefix);

				String suffix = "";
				suffix = p.getSuffix();
				detailsMap.put("suffix", suffix);

				String pFullName = p.getPFirstName();
				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultdetailList.get(0)
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultdetailList.get(0)
						.getInvestigation().getInvestigationName());
				DgResultEntryDetail dgResultEntryDetail = dgResultdetailList
						.get(0);
				String clinicalNotes = dgResultEntryDetail
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNotes", clinicalNotes);

				String radioId = dgResultEntryDetail
						.getSampleCollectionDetails().getDiagNo();
				detailsMap.put("radioId", radioId);

				String confidential = dgResultEntryDetail.getInvestigation()
						.getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultdetailList.get(0).getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultdetailList.get(0).getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}
				}
				MasEmployee e2 = dgResultdetailList.get(0).getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getProvisionalResultEntryDetailsForTemplate(
			int resultId, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		Session session = (Session) getSession();
		try {
			dgResultdetailList = session.createCriteria(
					DgResultEntryDetail.class).createAlias("ResultEntry", "r")
					.add(Restrictions.eq("Id", resultId)).add(
							Restrictions.eq("r.Department.Id", deptId)).list();
			if (dgResultdetailList != null || dgResultdetailList.size() > 0) {
				detailsMap.put("resultList", dgResultdetailList);
				detailsMap.put("hinNo", dgResultdetailList.get(0)
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultdetailList.get(0)
						.getResultEntry().getPatient().getServiceNo());
				Patient p = dgResultdetailList.get(0).getResultEntry()
						.getPatient();
				String pFullName = p.getPFirstName();
				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultdetailList.get(0)
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultdetailList.get(0)
						.getInvestigation().getInvestigationName());
				DgResultEntryDetail dgResultEntryDetail = dgResultdetailList
						.get(0);
				String clinicalNotes = dgResultEntryDetail
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNotes", clinicalNotes);

				String radioId = dgResultEntryDetail
						.getSampleCollectionDetails().getDiagNo();
				detailsMap.put("radioId", radioId);

				String confidential = dgResultEntryDetail.getInvestigation()
						.getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultdetailList.get(0).getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultdetailList.get(0).getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "+ eMiddleName + " " + eLastName);

				}
				MasEmployee e2 = dgResultdetailList.get(0).getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public boolean updateResultTemplateForValidation(Map<String, Object> dataMap) {

		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Session session = (Session) getSession();
		String resultNo = "";
		String templateData = "";
		boolean flag = false;

		int deptId = 0;
		try {
			if (dataMap.get("resultNo") != null) {
				resultNo = (String) dataMap.get("resultNo");
			}
			if (dataMap.get("deptId") != null) {
				deptId = (Integer) dataMap.get("deptId");
			}
			if (dataMap.get("templateData") != null) {
				templateData = (String) dataMap.get("templateData");
			}

			dgResultdetailList = session.createCriteria(
					DgResultEntryDetail.class).createAlias("ResultEntry", "re")
					.add(Restrictions.eq("re.ResultNo", resultNo)).add(
							Restrictions.eq("re.Department.Id", deptId)).list();
			dgResultdetailList.get(0).setResult(templateData);
			session.update(dgResultdetailList.get(0));
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return flag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultValidation(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitResultValidation(Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null)
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		int resultUpdatedBy = 0;
		if (infoMap.get("resultUpdatedBy") != null)
			resultUpdatedBy = Integer.parseInt(""
					+ infoMap.get("resultUpdatedBy"));

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
				dgEntryHeader.setVerified("V");
				dgEntryHeader.setVerifiedOn(date);
				dgEntryHeader.setVerifiedTime(time);
			}
			
			System.out.println("resultUpdatedBy1="+resultUpdatedBy);
			if (resultUpdatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultUpdatedBy);
				dgEntryHeader.setResultUpdatedBy(masEmployee);
				dgEntryHeader.setUpdateOn(new Date());
				
			}
			
			// dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			Vector dgResultDetailsId = box
					.getVector(RequestConstants.RESULT_DETAIL_ID);

			Vector result = box.getVector(RequestConstants.RESULT);
			Vector additionalRemarks = box
					.getVector(RequestConstants.ADDITIONAL_REMARKS);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
			dgResultDetailList = session.createCriteria(
					DgResultEntryDetail.class).add(
					Restrictions.eq("ResultEntry.Id", resultId)).list();
			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) hbt
							.load(DgResultEntryDetail.class,
									Integer.parseInt((String) dgResultDetailsId
											.get(i)));

					dgResultEntryDetail.setResultEntry(dgEntryHeader);
					dgResultEntryDetail.setValidated("Y");
					dgResultEntryDetail.setResultDetailStatus("A");
					dgResultEntryDetail.setRemarks((String) additionalRemarks
							.get(i));
					dgResultEntryDetail.setResult((String) result.get(i));

					hbt.saveOrUpdate(dgResultEntryDetail);
				}
			}

			List<DgResultEntryDetail> tempList = new ArrayList<DgResultEntryDetail>();
			tempList = session.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "res").add(
							Restrictions.eq("res.Id", resultId)).list();

			String headerOrderStaus = "";
			for (DgResultEntryDetail object : tempList) {
				if (object.getResultDetailStatus().equals("P")) {
					headerOrderStaus = "P";
					break;
				} else {
					headerOrderStaus = "A";
				}

			}
			dgEntryHeader.setResultStatus(headerOrderStaus);
			hbt.saveOrUpdate(dgEntryHeader);

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded = true;
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	public boolean submitResultValidationLab(Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = true;
		List<String> validatedListMultipleType = new ArrayList<String>();
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListMultipleType") != null) {
			validatedListMultipleType = (List) infoMap
					.get("validatedListMultipleType");
		}

		Map<String, Object> map = new HashMap<String, Object>();

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null)
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		
		int resultUpdatedBy = 0;
		if (infoMap.get("resultUpdatedBy") != null)
			resultUpdatedBy = Integer.parseInt(""
					+ infoMap.get("resultUpdatedBy"));
		
		

		Vector resultIdList = box.getVector(RESULT_ID);
		Vector dgResultDetailsId = box
				.getVector(RequestConstants.RESULT_DETAIL_ID);
		Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
		Vector result = box.getVector(RequestConstants.RESULT);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS);
		Vector subTestSize = box.getVector(RequestConstants.SUB_TEST_SIZE);
		int i = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (int it = 0; it < resultIdList.size(); it++) {
				i++;
				Integer resultId = Integer.parseInt((String) resultIdList
						.get(it));
				DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
						.load(DgResultEntryHeader.class, resultId);
				if (resultValidatedBy != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultValidatedBy);
					dgEntryHeader.setResultVerifiedBy(masEmployee);
					dgEntryHeader.setVerified("V");
					dgEntryHeader.setVerifiedOn(date);
					dgEntryHeader.setVerifiedTime(time);
				}
				System.out.println("resultUpdatedBy="+resultUpdatedBy);
				if (resultUpdatedBy != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultUpdatedBy);
					dgEntryHeader.setResultUpdatedBy(masEmployee);
					dgEntryHeader.setUpdateOn(new Date());
					
				}
				
				
				
				dgEntryHeader.setResultStatus("A");
				hbt.update(dgEntryHeader);
				hbt.refresh(dgEntryHeader);

				List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
				dgResultDetailList = session.createCriteria(
						DgResultEntryDetail.class).add(
						Restrictions.eq("ResultEntry.Id", resultId)).list();
				for (int loopCount = 0; loopCount < Integer
						.parseInt((String) subTestSize.get(it)); loopCount++, i++) {
					if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("y")) {
						DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) hbt
								.load(DgResultEntryDetail.class, Integer
										.parseInt((String) dgResultDetailsId
												.get(i)));

						dgResultEntryDetail.setResultEntry(dgEntryHeader);
						dgResultEntryDetail.setValidated("Y");
						dgResultEntryDetail.setResultDetailStatus("A");
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail.setResult((String) result.get(i));

						if (fixedId.get(i) != null
								&& !fixedId.get(i).equals("")) {
							DgFixedValue dgFixedValue = new DgFixedValue();
							dgFixedValue.setId(Integer
									.parseInt((String) fixedId.get(i)));
							dgResultEntryDetail.setFixed(dgFixedValue);
							
							List<String> fixedValue = new ArrayList<String>();
							fixedValue = session.createCriteria(DgFixedValue.class).add(Restrictions.idEq(Integer.parseInt((String) fixedId.get(i)))).setProjection(Projections.property("FixedValue")).list();
							dgResultEntryDetail.setResult(fixedValue.get(0));
						}

						hbt.saveOrUpdate(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
					}
				}
				List<DgResultEntryDetail> tempList = new ArrayList<DgResultEntryDetail>();
				tempList = session.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "res").add(
								Restrictions.eq("res.Id", resultId)).list();

				String headerOrderStaus = "";
				for (DgResultEntryDetail object : tempList) {
					if (object.getResultDetailStatus().equals("P")) {
						headerOrderStaus = "P";
						break;
					} else {
						headerOrderStaus = "A";
					}

				}
				dgEntryHeader.setResultStatus(headerOrderStaus);
				hbt.saveOrUpdate(dgEntryHeader);
				hbt.refresh(dgEntryHeader);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded = true;
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean submitResultEntryLabForCorrectionMultipleType(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = true;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> map = new HashMap<String, Object>();

		int resultEnteredBy = 0;
		if (infoMap.get("resultEnteredBy") != null)
			resultEnteredBy = Integer.parseInt(""
					+ infoMap.get("resultEnteredBy"));

		Vector resultIdList = box.getVector(RESULT_ID);
		Vector dgResultDetailsId = box
				.getVector(RequestConstants.RESULT_DETAIL_ID);

		Vector result = box.getVector(RequestConstants.RESULT);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS);
		Vector subTestSize = box.getVector(RequestConstants.SUB_TEST_SIZE);
		int i = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (int it = 0; it < resultIdList.size(); it++) {
				i++;
				Integer resultId = Integer.parseInt((String) resultIdList
						.get(it));
				DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
						.load(DgResultEntryHeader.class, resultId);
				if (resultEnteredBy != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredBy);
					dgEntryHeader.setEmployee(masEmployee);
				}
				// dgEntryHeader.setVerified("V");
				// dgEntryHeader.setVerifiedOn(date);
				// dgEntryHeader.setVerifiedTime(time);
				// dgEntryHeader.setResultStatus("A");
				hbt.update(dgEntryHeader);
				hbt.refresh(dgEntryHeader);

				List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
				dgResultDetailList = session.createCriteria(
						DgResultEntryDetail.class).add(
						Restrictions.eq("ResultEntry.Id", resultId)).list();
				for (int loopCount = 0; loopCount < Integer
						.parseInt((String) subTestSize.get(it)); loopCount++, i++) {
					DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) hbt
							.load(DgResultEntryDetail.class,
									Integer.parseInt((String) dgResultDetailsId
											.get(i)));

					dgResultEntryDetail.setResultEntry(dgEntryHeader);
					// dgResultEntryDetail.setValidated("Y");
					// dgResultEntryDetail.setResultDetailStatus("A");
					dgResultEntryDetail.setRemarks((String) additionalRemarks
							.get(i));
					dgResultEntryDetail.setResult((String) result.get(i));

					hbt.saveOrUpdate(dgResultEntryDetail);
					hbt.refresh(dgResultEntryDetail);
				}
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded = true;
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getPatientDetailsForReportCollection(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForReportCollection(
			Map<String, Object> mapForDs) {
		Session session = (Session) getSession();
		Criteria crit = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String diagnosisNo = "";
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}

		crit = session.createCriteria(DgResultEntryHeader.class).add(
				Restrictions.eq("Department.Id", deptId)).add(
				Restrictions.eq("ResultStatus", "A")).add(
				Restrictions.between("VerifiedOn", fromDate, toDate))
				.createAlias("Patient", "pt");
		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo + "%"));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.SFirstName", serPersonFName
					+ "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.like("ip.AdNo", adNo + "%"));
		}

		if (departmentId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.createAlias("SubChargecode", "SubChargecode").add(
					Restrictions.like("SubChargecode.Id", subChargeCodeId));
		}

		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sh")
					.createAlias("sh.Order", "or").add(
							Restrictions.eq("or.PatientType", orderType));
		}

		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getResultDetails
	 * (int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultDetails(Map<String, Object> mapForDs) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultdetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasEmployee> prescribedByList = new ArrayList<MasEmployee>();

		int resultId = 0;
		int deptId = 0;

		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}

		int resultHeaderId = 0;

		Session session = (Session) getSession();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"empCat").add(
					Restrictions.eq("empCat.EmpCategoryName", "Para Medical"))
					.list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			if (relationList.size() > 0) {
				detailsMap.put("relationList", relationList);
			}
			prescribedByList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"empCat").add(Restrictions.eq("empCat.Id", 4)).add(
					Restrictions.eq("Department.Id", deptId)).list();
			if (prescribedByList.size() > 0) {
				detailsMap.put("prescribedByList", prescribedByList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Verified", "V")).add(
					Restrictions.eq("Id", resultId)).list();

			if (resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}

			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();

				}
				dgResultdetailList = session.createCriteria(
						DgResultEntryDetail.class).add(
						Restrictions.eq("ResultEntry.Id", resultHeaderId))
						.createAlias("SubInvestigation", "subInv").addOrder(
								Order.asc("subInv.OrderNo")).list();
				dgResultdetailSenList = session.createCriteria(
						DgResultEntryDetailSen.class).createAlias(
						"ResultEntry", "result").add(
						Restrictions.eq("result.Id", resultHeaderId)).list();
				if (dgResultdetailList.size() > 0) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
				if (dgResultdetailSenList.size() > 0) {
					detailsMap.put("dgResultdetailSenList",
							dgResultdetailSenList);
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * deleteInvestigation(int, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteInvestigation(int investigationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgMasInvestigation masCaseType = new DgMasInvestigation();
		masCaseType = (DgMasInvestigation) getHibernateTemplate().get(
				DgMasInvestigation.class, investigationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
/*			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			
*/			Session session=(Session)getSession();
			List mainChargecodeList =session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Id", investigationId)).add(Restrictions.eq("Status", "y")).list();
			/*
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");*/
			
			List subChargecodeList=session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Id", investigationId)).add(Restrictions.eq("Status", "y")).list();

			
		/*	List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");*/
			
			List departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", investigationId)).add(Restrictions.eq("Status", "y")).list();
			/*List chargeTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeCode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");*/
			
			
			List chargeTypeList=session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Id", investigationId)).add(Restrictions.eq("Status", "y")).list();
			/*List sampleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSample as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");*/
			
			
			List sampleList=session.createCriteria(MasSample.class).add(Restrictions.eq("Id", investigationId)).add(Restrictions.eq("Status", "y")).list();
			@SuppressWarnings("unused")
			/*List unitOfMeasurementList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.DgUom as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");*/

			List unitOfMeasurementList=session.createCriteria(DgUom.class).add(Restrictions.eq("Id", investigationId)).add(Restrictions.eq("Status", "y")).list();
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaseType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaseType.setStatus("y");
				dataDeleted = false;
			}
		}
		masCaseType.setLastChgBy(changedBy);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		return dataDeleted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultValidationForSingleParameter(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitResultValidationForSingleParameter(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null)
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}

			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			String result = box.getString(RequestConstants.RESULT);
			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);
			String validated = box.getString(RequestConstants.VALIDATED);
			List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();

			dgResultDetailList = session.createCriteria(
					DgResultEntryDetail.class).add(
					Restrictions.eq("ResultEntry.Id", resultId)).list();
			if (dgResultDetailList != null && dgResultDetailList.size() > 0) {
				DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
				dgResultEntryDetail = dgResultDetailList.get(0);
				dgResultEntryDetail.setValidated("Y");
				dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResult(result);

				hbt.saveOrUpdate(dgResultEntryDetail);

			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	public boolean submitResultValidationForSingleParameterOnly(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<String> validatedListSingleType = new ArrayList<String>();

		boolean successfullyAdded = true;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListSingleType") != null) {
			validatedListSingleType = (List) infoMap
					.get("validatedListSingleType");
		}

		Vector resultIdSingleValue = box.getVector(RESULT_ID_SINGLE_VALUE);

		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);

		int resultValidatedBy = 0;

		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}
		
		int resultUpdatedBy = 0;
		if (infoMap.get("resultUpdatedBy") != null)
			resultUpdatedBy = Integer.parseInt(""
					+ infoMap.get("resultUpdatedBy"));
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < resultIdSingleValue.size(); i++) {
				if (resultIdSingleValue.get(i) != null) {
					if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("y")) {
						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						if (resultValidatedBy != 0) {
							MasEmployee masEmployee = new MasEmployee();
							masEmployee.setId(resultValidatedBy);
							dgEntryHeader.setResultVerifiedBy(masEmployee);
							dgEntryHeader.setVerified("V");
							dgEntryHeader.setVerifiedOn(date);
							dgEntryHeader.setVerifiedTime(time);
						}
						
						if (resultUpdatedBy != 0) {
							MasEmployee masEmployee = new MasEmployee();
							masEmployee.setId(resultUpdatedBy);
							dgEntryHeader.setResultUpdatedBy(masEmployee);
							dgEntryHeader.setUpdateOn(new Date());
							
						}
						dgEntryHeader.setResultStatus("A");
						hbt.update(dgEntryHeader);
						hbt.refresh(dgEntryHeader);

						List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
						dgResultDetailList = session.createCriteria(
								DgResultEntryDetail.class).add(
								Restrictions.eq("ResultEntry.Id", resultId))
								.list();
						if (dgResultDetailList != null
								&& dgResultDetailList.size() > 0) {
							DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
							dgResultEntryDetail = dgResultDetailList.get(0);
							dgResultEntryDetail.setValidated("Y");
							dgResultEntryDetail.setResultDetailStatus("A");
							dgResultEntryDetail
									.setRemarks((String) additionalRemarks
											.get(i));
							dgResultEntryDetail.setResult((String) result
									.get(i));
							hbt.saveOrUpdate(dgResultEntryDetail);
							hbt.refresh(dgResultEntryDetail);
						}
					}
				}
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean submitResultEntryForCorrectionSingleInvestigationType(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<String> validatedListSingleType = new ArrayList<String>();

		boolean successfullyAdded = true;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListSingleType") != null) {
			validatedListSingleType = (List) infoMap
					.get("validatedListSingleType");
		}

		Vector resultIdSingleValue = box.getVector(RESULT_ID_SINGLE_VALUE);

		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);

		int resultEnteredBy = 0;

		if (infoMap.get("resultEnteredBy") != null) {
			resultEnteredBy = Integer.parseInt(""
					+ infoMap.get("resultEnteredBy"));
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < resultIdSingleValue.size(); i++) {
				if (resultIdSingleValue.get(i) != null) {

					int resultId = Integer
							.parseInt((String) resultIdSingleValue.get(i));
					DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
							.load(DgResultEntryHeader.class, resultId);
					if (resultEnteredBy != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(resultEnteredBy);
						dgEntryHeader.setEmployee(masEmployee);
					}

					// dgEntryHeader.setVerified("V");
					// dgEntryHeader.setVerifiedOn(date);
					// dgEntryHeader.setVerifiedTime(time);
					// dgEntryHeader.setResultStatus("A");
					hbt.update(dgEntryHeader);
					hbt.refresh(dgEntryHeader);

					List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
					dgResultDetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultId)).list();
					if (dgResultDetailList != null
							&& dgResultDetailList.size() > 0) {
						DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
						dgResultEntryDetail = dgResultDetailList.get(0);
						// dgResultEntryDetail.setValidated("Y");
						// dgResultEntryDetail.setResultDetailStatus("A");
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail.setResult((String) result.get(i));
						hbt.saveOrUpdate(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
					}
				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultValidationForTemplate(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitResultValidationForTemplate(Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		String validated = "";
		String additionalRemarks = "";

		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}

		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null)
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));

		if (infoMap.get("additionalRemarks") != null)
			additionalRemarks = (String) infoMap.get("additionalRemarks");

		if (infoMap.get("validated") != null)
			validated = (String) infoMap.get("validated");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}

			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			Vector result = box.getVector("test2");
			/*
			 * Vector additionalRemarks =
			 * box.getVector(RequestConstants.ADDITIONAL_REMARKS); Vector
			 * validated = box.getVector(RequestConstants.VALIDATED);
			 */List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			dgResultDetailList = session.createCriteria(
					DgResultEntryDetail.class).add(
					Restrictions.eq("ResultEntry.Id", resultId)).list();
			/*
			 * for (int i = 0; i< validated.size() ; i++) {
			 */if (validated.equalsIgnoreCase("on")) {
				if (dgResultDetailList != null && dgResultDetailList.size() > 0) {
					dgResultEntryDetail = dgResultDetailList.get(0);
					dgResultEntryDetail.setValidated("Y");
					dgResultEntryDetail.setResultDetailStatus("A");
					dgResultEntryDetail.setRemarks(additionalRemarks);

					// dgResultEntryDetail.setResult((String)result.get(i));

					hbt.saveOrUpdate(dgResultEntryDetail);
				}
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	public boolean submitResultEntryForModificationTemplate(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;

		String additionalRemarks = "";

		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}

		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));

		int resultEnteredBy = 0;
		if (infoMap.get("resultEnteredBy") != null)
			resultEnteredBy = Integer.parseInt(""
					+ infoMap.get("resultEnteredBy"));

		if (infoMap.get("additionalRemarks") != null)
			additionalRemarks = (String) infoMap.get("additionalRemarks");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultEnteredBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredBy);
				dgEntryHeader.setEmployee(masEmployee);
			}

			// dgEntryHeader.setVerified("V");
			// dgEntryHeader.setVerifiedOn(date);
			// dgEntryHeader.setVerifiedTime(time);
			// dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			Vector result = box.getVector("test2");
			/*
			 * Vector additionalRemarks =
			 * box.getVector(RequestConstants.ADDITIONAL_REMARKS); Vector
			 * validated = box.getVector(RequestConstants.VALIDATED);
			 */List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			dgResultDetailList = session.createCriteria(
					DgResultEntryDetail.class).add(
					Restrictions.eq("ResultEntry.Id", resultId)).list();
			/*
			 * for (int i = 0; i< validated.size() ; i++) {
			 */
			if (dgResultDetailList != null && dgResultDetailList.size() > 0) {
				dgResultEntryDetail = dgResultDetailList.get(0);
				// dgResultEntryDetail.setValidated("Y");
				// dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setRemarks(additionalRemarks);

				// dgResultEntryDetail.setResult((String)result.get(i));

				hbt.saveOrUpdate(dgResultEntryDetail);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getDetailsForResultValidation()
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForResultValidation(
			Map<String, Object> dataMap) {

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date FromDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Date ToDate = HMSUtil.convertStringTypeDateToDateType(currentDate);

		/*subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").add(Restrictions.eq("dept.Id", deptId)).list();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("SubChargecodeName")).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}
        */
		
		//Hide by amit on 14/08/2012 for Sql Injection
		
		/*sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");*/
		
		//Added by amit on 14/08/2012 for Sql Injection
		
		//sampleList = session.createCriteria(MasSample.class).addOrder(Order.asc("SampleDescription")).list();
		
		///////////////////////End///////////////////////////
		/*
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}
		*/
		String departmentTypeCodeForOpd="";
		String departmentTypeCodeForWard="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
			departmentTypeCodeForWard=properties.getProperty("departmentTypeCodeForWard");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<String> arrayDeptCode = new ArrayList<String>();
		arrayDeptCode.add(departmentTypeCodeForWard);
		arrayDeptCode.add(departmentTypeCodeForOpd);
		
		
		/*departmentList = session.createCriteria(MasDepartment.class)
				.createAlias("DepartmentType", "dt").add(Restrictions.in("dt.DepartmentTypeCode", arrayDeptCode))	
				
				.add(Restrictions.eq("Status", "y")).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		

		chargeCodeList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("ChargeCodeName")).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}
*/
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getSubTestList
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSubTestList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSubMasInvestigation> subCodeList = new ArrayList<DgSubMasInvestigation>();
		Session session = (Session) getSession();

	/*	subCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgSubMasInvestigation as mi where  mi.Id = "
						+ box.getInt(RequestConstants.SUBTEST_ID) + "");*/
		subCodeList=session.createCriteria(DgSubMasInvestigation.class).add(Restrictions.eq("Id", box.getInt(RequestConstants.SUBTEST_ID))).list();
		map.put("subCodeList", subCodeList);

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getDetailsForReportCollection()
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForReportCollection(
			Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgResultEntryHeader> reportCollectionList = new ArrayList<DgResultEntryHeader>();
		Session session = (Session) getSession();

		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").add(Restrictions.eq("dept.Id", deptId)).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

		/*sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");*/
		
		sampleList=session.createCriteria(MasSample.class).list();
		
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		chargeCodeList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.eq("Status", "y")).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}

		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getDetails()
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetails(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").add(Restrictions.eq("dept.Id", deptId)).list();
		dgMasOrganismGroupList = session.createCriteria(
				DgMasOrganismGroup.class).add(Restrictions.eq("Status", "y"))
				.list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}
/*
		sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");*/
		//Session session=(Session)getSession();
		sampleList=session.createCriteria(MasSample.class).list();
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		chargeCodeList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.eq("Status", "y")).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}
		detailsMap.put("dgMasOrganismGroupList", dgMasOrganismGroupList);
		return detailsMap;
	}

	public Map<String, Object> getDetailsForLab(Map<String, Object> dataMap) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null)
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		if (dataMap.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		if (dataMap.get("userName") != null)
			userName = ("" + dataMap.get("userName"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		/*subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").add(Restrictions.eq("dept.Id", deptId)).list();*/
		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
				Restrictions.eq("Status", "y")).list();
		dgMasOrganismGroupList = session.createCriteria(
				DgMasOrganismGroup.class).add(Restrictions.eq("Status", "y"))
				.list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

	/*	sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");*/
		sampleList=session.createCriteria(MasSample.class).list();
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		chargeCodeList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.eq("Status", "y")).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}
		detailsMap.put("dgMasOrganismGroupList", dgMasOrganismGroupList);
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitNormalValues
	 * (jkt.hms.util.Box)
	 */
	
	@SuppressWarnings("unchecked")
	public boolean submitNormalValues(Box box) {
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<DgNormalValue> subTestList = new ArrayList<DgNormalValue>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		int submitNormalValues = box.getInt("submitNormalValues");
		int i = 0;
		Vector fromAge = box.getVector(RequestConstants.FROM_AGE);
		Vector toAge = box.getVector(RequestConstants.TO_AGE);
		Vector sex = box.getVector(RequestConstants.SEX);
		Vector minNormalValue = box
				.getVector(RequestConstants.MIN_NORMAL_VALUE);
		Vector maxNormalValue = box
				.getVector(RequestConstants.MAX_NORMAL_VALUE);
		Vector normalValue = box.getVector(RequestConstants.NORMAL_VALUE);
		int chargeCodeId = box.getInt(RequestConstants.CHARGE_CODE_ID);
		int subTestId = box.getInt(RequestConstants.SUBTEST_ID);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		DgSubMasInvestigation dgSubMasObj = new DgSubMasInvestigation();
		dgSubMasObj.setId(subTestId);
		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			for (i = 0; i < sex.size(); i++) {
				if (sex.get(i) != null && !sex.get(i).equals("0")) {
					DgNormalValue dgNormalValue = new DgNormalValue();
					dgNormalValue.setChargeCode(masChargeCode);
					dgNormalValue.setSubInvestigation(dgSubMasObj);
					if (!fromAge.get(i).equals("")) {
						dgNormalValue.setFromAge(Integer
								.parseInt((String) fromAge.get(i)));
					}
					if (!toAge.get(i).equals("")) {
						dgNormalValue.setToAge(Integer.parseInt((String) toAge
								.get(i)));
					}
					if (minNormalValue.size() > i) {
						if (!minNormalValue.get(i).equals("")) {
							dgNormalValue
									.setMinNormalValue((String) minNormalValue
											.get(i));
						}
					}
					if (maxNormalValue.size() > i) {
						if (!maxNormalValue.get(i).equals("")) {
							dgNormalValue
									.setMaxNormalValue((String) maxNormalValue
											.get(i));
						}
					}
					if (!sex.get(i).equals("")) {
						dgNormalValue.setSex((String) sex.get(i));
					}
					if (normalValue.size() > i) {
						if (!normalValue.get(i).equals("")) {
							dgNormalValue.setNormalValue((String) normalValue
									.get(i));
						}
					}
					hbt.save(dgNormalValue);
				}
			}
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitFixedValues
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitFixedValues(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		int i = 0;
		// amcTDetailsListSize
		// Vector fixedValue1 = box.getVector("fixedValue1");
		Integer fixedValueSize = box.getInt("amcTDetailsListSize");
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (i = 0; i < subTestId.size(); i++) {
				if (subTestId.get(i) != null && !subTestId.get(i).equals("")) {
					DgSubMasInvestigation dgSubMasObj = new DgSubMasInvestigation();
					dgSubMasObj.setId(Integer.parseInt((String) subTestId
							.get(i)));
					for (int x = 1; x <= fixedValueSize; x++) {
						DgFixedValue dgFixedValue = new DgFixedValue();
						dgFixedValue.setSubInvestigation(dgSubMasObj);
						dgFixedValue.setFixedValue(box.getString("fixedValue"
								+ x));
						hbt.save(dgFixedValue);
					}

					/*
					 * if (fixedValue1.get(i) != null &&
					 * !fixedValue1.get(i).equals("")) {
					 * 
					 * dgFixedValue1.setSubInvestigation(dgSubMasObj1);
					 * dgFixedValue1 .setFixedValue((String)
					 * fixedValue1.get(i)); }
					 * 
					 * hbt.save(dgFixedValue1);
					 */
				}
			}
			dataSaved = true;

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			dataSaved = false;
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultEntryForTemplate(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForTemplate(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryList = new ArrayList<DgResultEntryDetail>();
		boolean saved = false;
		int sampleDetailId = 0;
		DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) parameterMap
				.get("dgResultEntryHeader");
		DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) parameterMap
				.get("dgResultEntryDetail");
		sampleDetailId = (Integer) parameterMap.get("sampleDetailId");

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Criteria criteria = null;

			criteria = session.createCriteria(DgResultEntryDetail.class).add(
					Restrictions.eq("SampleCollectionDetails.Id",
							sampleDetailId));

			dgResultEntryList = criteria.list();
			if (dgResultEntryList.size() > 0) {
				DgResultEntryDetail dgResultEntryDetail2 = dgResultEntryList
						.get(0);
				DgResultEntryHeader dgResultEntryHeader2 = dgResultEntryList
						.get(0).getResultEntry();
				// ///////////
				dgResultEntryHeader2.setResultNo(dgResultEntryHeader
						.getResultNo());
				dgResultEntryHeader2.setLastChgdBy(dgResultEntryHeader
						.getLastChgdBy());
				dgResultEntryHeader2.setLastChgdDate(dgResultEntryHeader
						.getLastChgdDate());
				dgResultEntryHeader2.setLastChgdTime(dgResultEntryHeader
						.getLastChgdTime());
				dgResultEntryHeader2.setRemarks(dgResultEntryHeader
						.getRemarks());
				dgResultEntryHeader2.setResultDate(dgResultEntryHeader
						.getResultDate());
				dgResultEntryHeader2.setResultStatus(dgResultEntryHeader
						.getResultStatus());
				// dgResultEntryHeader.setResultStatus("P");
				dgResultEntryHeader2.setResultTime(dgResultEntryHeader
						.getResultTime());
				dgResultEntryHeader2.setEmployee(dgResultEntryHeader
						.getEmployee());
				hbt.update(dgResultEntryHeader2);
				hbt.refresh(dgResultEntryHeader2);

				// /////////
				dgResultEntryDetail2.setResult(dgResultEntryDetail.getResult());
				dgResultEntryDetail2.setResultEntry(dgResultEntryHeader2);
				dgResultEntryDetail2.setRemarks(dgResultEntryDetail
						.getRemarks());
				dgResultEntryDetail2.setResultDetailStatus(dgResultEntryDetail
						.getResultDetailStatus());
				// //////////////
				/*
				 * dgResultEntryHeader2 = dgResultEntryHeader;
				 * dgResultEntryHeader2
				 * .setId(dgResultEntryList.get(0).getResultEntry().getId());
				 * 
				 * dgResultEntryDetail2 = dgResultEntryDetail;
				 * dgResultEntryDetail2.setId(dgResultEntryList.get(0).getId());
				 */
				// ////////

				hbt.update(dgResultEntryDetail2);
				hbt.refresh(dgResultEntryDetail2);
			} else {
				hbt.save(dgResultEntryHeader);
			//	hbt.refresh(dgResultEntryHeader);
				hbt.save(dgResultEntryDetail);
				hbt.refresh(dgResultEntryDetail);
			}

			DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
					.load(DgSampleCollectionDetails.class, sampleDetailId);
			dgDetails.setOrderStatus("E");
			hbt.update(dgDetails);
			hbt.refresh(dgDetails);
			
			/**
			 * For document upload
			 */
			System.out.println(dgResultEntryHeader.getId()+"----uploadDocumentId--"+parameterMap.get("uploadDocumentId"));
			int uploadDocumentId = 0;
			if(parameterMap.get("uploadDocumentId")!=null){
				uploadDocumentId = (Integer)parameterMap.get("uploadDocumentId");
				if(uploadDocumentId!=0){
					UploadDocuments uploadDocuments = (UploadDocuments)hbt.load(UploadDocuments.class, uploadDocumentId);
					uploadDocuments.setResultEntry(dgResultEntryHeader);
					hbt.update(uploadDocuments);
				}
				
				
			}
			
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> submitResultEntryForTemplateTemparory(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int sampleDetailId = 0;
		int dgResultEntryHeaderId = 0;

		List<DgResultEntryDetail> dgResultEntryList = new ArrayList<DgResultEntryDetail>();

		DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) parameterMap
				.get("dgResultEntryHeader");
		DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) parameterMap
				.get("dgResultEntryDetail");
		sampleDetailId = (Integer) parameterMap.get("sampleDetailId");

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Criteria criteria = null;

			criteria = session.createCriteria(DgResultEntryDetail.class).add(
					Restrictions.eq("SampleCollectionDetails.Id",
							sampleDetailId));

			dgResultEntryList = criteria.list();

			if (dgResultEntryList.size() > 0) {
				DgResultEntryDetail dgResultEntryDetail2 = dgResultEntryList
						.get(0);
				DgResultEntryHeader dgResultEntryHeader2 = dgResultEntryList
						.get(0).getResultEntry();
				// ///////////
				dgResultEntryHeader2.setResultNo(dgResultEntryHeader
						.getResultNo());
				dgResultEntryHeader2.setLastChgdBy(dgResultEntryHeader
						.getLastChgdBy());
				dgResultEntryHeader2.setLastChgdDate(dgResultEntryHeader
						.getLastChgdDate());
				dgResultEntryHeader2.setLastChgdTime(dgResultEntryHeader
						.getLastChgdTime());
				dgResultEntryHeader2.setRemarks(dgResultEntryHeader
						.getRemarks());
				dgResultEntryHeader2.setResultDate(dgResultEntryHeader
						.getResultDate());
				dgResultEntryHeader2.setResultStatus(dgResultEntryHeader
						.getResultStatus());
				// dgResultEntryHeader.setResultStatus("P");
				dgResultEntryHeader2.setResultTime(dgResultEntryHeader
						.getResultTime());
				dgResultEntryHeader2.setEmployee(dgResultEntryHeader
						.getEmployee());
				hbt.update(dgResultEntryHeader2);
				hbt.refresh(dgResultEntryHeader2);

				// /////////
				dgResultEntryDetail2.setResult(dgResultEntryDetail.getResult());
				dgResultEntryDetail2.setResultEntry(dgResultEntryHeader2);
				dgResultEntryDetail2.setRemarks(dgResultEntryDetail
						.getRemarks());
				dgResultEntryDetail2.setResultDetailStatus(dgResultEntryDetail
						.getResultDetailStatus());
				// //////////////
				/*
				 * dgResultEntryHeader2 = dgResultEntryHeader;
				 * dgResultEntryHeader2
				 * .setId(dgResultEntryList.get(0).getResultEntry().getId());
				 * 
				 * dgResultEntryDetail2 = dgResultEntryDetail;
				 * dgResultEntryDetail2.setId(dgResultEntryList.get(0).getId());
				 */
				// ////////

				hbt.update(dgResultEntryDetail2);
				hbt.refresh(dgResultEntryDetail2);
			} else {
				hbt.save(dgResultEntryHeader);
				hbt.refresh(dgResultEntryHeader);
				hbt.save(dgResultEntryDetail);
				hbt.refresh(dgResultEntryDetail);
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitTemplate
	 * (java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitTemplate(Map<String, Object> dataMap) {
		DgMasInvestigation dgMasInv = (DgMasInvestigation) dataMap
				.get("dgMasInv");
		DgTemplate dgTemp = (DgTemplate) dataMap.get("dgTemp");
		boolean dataSaved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			// changed to update
			//hbt.saveOrUpdate(dgMasInv);
			// hbt.save(dgMasInv);

			hbt.save(dgTemp);
			dataSaved = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#updateTemplate
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public boolean updateTemplate(Map<String, Object> map) {
		boolean dataUpdated = false;
		int i = 0;
		int Id = (Integer) map.get("templateId");
		String result =(String) map.get("result");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		DgTemplate dgTemplate = (DgTemplate) hbt.load(DgTemplate.class, Id);
		dgTemplate.setResult(result);
		hbt.update(dgTemplate);
		dataUpdated = true;
		return dataUpdated;
	}

	/*
	 * end
	 */

	public Map<String, Object> getResultEntryDetailsForNext(int newResultId,
			int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> previousresultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		int resultDetailId = 0;
		int resultHeaderId = 0;
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Id", newResultId)).addOrder(
					Order.asc("Id")).list();
			if (resultList != null || resultList.size() > 0) {

				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();

				}
				dgResultdetailList = session.createCriteria(
						DgResultEntryDetail.class).add(
						Restrictions.eq("ResultEntry.Id", resultHeaderId)).add(
						Restrictions.eq("ResultDetailStatus", "P"))
						.createAlias("SubInvestigation", "subInv").addOrder(
								Order.asc("subInv.OrderNo")).list();
				if (dgResultdetailList.size() > 0) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/** for updation of normal value **/
	@SuppressWarnings("unchecked")
	public boolean updateNormalValue(Box box) {
		boolean dataUpdated = false;
		int i = 0;
		Vector fromAge = box.getVector(RequestConstants.FROM_AGE);
		Vector toAge = box.getVector(RequestConstants.TO_AGE);
		Vector sex = box.getVector(RequestConstants.SEX);
		Vector minNormalValue = box
				.getVector(RequestConstants.MIN_NORMAL_VALUE);
		Vector maxNormalValue = box
				.getVector(RequestConstants.MAX_NORMAL_VALUE);
		Vector normalValue = box.getVector(RequestConstants.NORMAL_VALUE);

		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Vector normalId = box.getVector(RequestConstants.NORMAL_ID);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (i = 0; i < subTestId.size(); i++) {
			DgNormalValue dgNormalValue = new DgNormalValue();
			if (subTestId.get(i).toString() != null
					&& !subTestId.get(i).toString().equals("")) {
				int sId = Integer.parseInt(subTestId.get(i).toString());
				int nId = Integer.parseInt(normalId.get(i).toString());
				dgNormalValue = (DgNormalValue) getHibernateTemplate().load(
						DgNormalValue.class, nId);
				if (toAge.get(i) != null && !toAge.get(i).equals("")) {
					dgNormalValue.setToAge(Integer.parseInt((String) toAge
							.get(i)));
				}
				if (fromAge.get(i) != null && !fromAge.get(i).equals("")) {
					dgNormalValue.setFromAge(Integer.parseInt((String) fromAge
							.get(i)));
				}
				if (minNormalValue.get(i) != null
						&& !minNormalValue.get(i).equals("")) {
					dgNormalValue.setMinNormalValue((String) minNormalValue
							.get(i));
				}
				if (maxNormalValue.get(i) != null
						&& !maxNormalValue.get(i).equals("")) {
					dgNormalValue.setMaxNormalValue((String) maxNormalValue
							.get(i));
				}
				hbt.saveOrUpdate(dgNormalValue);
			}
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean updateFixedValues(Box box) {
		boolean dataUpdated = false;
		Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector fixedValue = box.getVector(RequestConstants.FIXED_VALUE);
		try {
			for (int j = 0; j < fixedValue.size(); j++) {
				DgFixedValue dgFixedValue = new DgFixedValue();
				int sId = Integer.parseInt(fixedId.get(j).toString());
				dgFixedValue = (DgFixedValue) getHibernateTemplate().load(
						DgFixedValue.class, sId);
				dgFixedValue.setFixedValue((String) fixedValue.get(j));
				hbt.update(dgFixedValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/** For updating report Collction records **/
	public boolean updateReceivedDetails(Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		int dispatchedId = 0;
		int relationId = 0;
		String receivedBy = "";
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		if (infoMap.get("dispatchedId") != null)
			dispatchedId = Integer.parseInt("" + infoMap.get("dispatchedId"));
		if (infoMap.get("relationId") != null)
			relationId = Integer.parseInt("" + infoMap.get("relationId"));
		if (infoMap.get("receivedBy") != null
				&& !infoMap.get("receivedBy").equals(""))
			receivedBy = (String) infoMap.get("receivedBy");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (dispatchedId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(dispatchedId);
				dgEntryHeader.setPrescribedBy(masEmployee);
			}
			if (relationId != 0) {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(relationId);
				dgEntryHeader.setRelation(masRelation);
			}
			if (receivedBy != null && !receivedBy.equals("")) {
				dgEntryHeader.setReceivedBy(receivedBy);
			}

			hbt.saveOrUpdate(dgEntryHeader);

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/** For Result Validation Grid Data **/
	public Map<String, Object> getResultValidationGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			if (deptType.equalsIgnoreCase("RADIO")) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.eq("ResultStatus", "P")).createAlias(
						"Department", "dept").add(
						Restrictions.eq("dept.Id", deptId));
				// .add(Restrictions.eq("ResultDate", currentDate));

				patientList = crit.list();
				for (DgResultEntryHeader dgResultEntryHeader : patientList) {
					Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetails();
					for (DgResultEntryDetail dgResultEntryDetail : dgResultEntrySet) {
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollectionDetails();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				}
				patientList.removeAll(patientListTemp);
			} else {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.eq("ResultStatus", "P")).createAlias(
						"Department", "dept").add(
						Restrictions.eq("dept.Id", deptId)).add(
						Restrictions.eq("ResultDate", currentDate));
				patientList = crit.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getResultValidationLabGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		int hospitalId = 0;
		if (mapForDs.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + mapForDs.get("hospitalId"));
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "P"))/*.createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId))*/.add(
					Restrictions.eq("ResultDate", currentDate))
					.createAlias("MasHospital", "h").add(
							Restrictions.eq("h.Id", hospitalId))
					.addOrder(
					Order.asc("SampleCollectionHeader.Id")).addOrder(
					Order.asc("SubChargecode.Id"));
			// .setProjection(Projections.projectionList()
			// .add(Projections.groupProperty("SampleCollectionHeader"))
			// .add(Projections.groupProperty("SubChargecode")));
			// .add(Projections.property("DgResultEntryDetails")));

			patientList = crit.list();

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList.get(ilop).getSampleCollectionHeader()
							.getId().equals(
									patientList.get(ilop + 1)
											.getSampleCollectionHeader()
											.getId())) {
						patientListSubDepartWise.add(patientList.get(ilop + 1));

						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList.get(ilop).getSubChargecode().getId()
								.equals(
										patientList.get(ilop + 1)
												.getSubChargecode().getId())) {
							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);
		return map;
	}

	public Map<String, Object> getResultEntryCorrectionLabGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "P")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("ResultDate", currentDate)).addOrder(
					Order.asc("SampleCollectionHeader.Id")).addOrder(
					Order.asc("SubChargecode.Id"));

			patientList = crit.list();

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList.get(ilop).getSampleCollectionHeader()
							.getId().equals(
									patientList.get(ilop + 1)
											.getSampleCollectionHeader()
											.getId())) {
						patientListSubDepartWise.add(patientList.get(ilop + 1));

						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList.get(ilop).getSubChargecode().getId()
								.equals(
										patientList.get(ilop + 1)
												.getSubChargecode().getId())) {
							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);
		return map;
	}

	// /* Result For Update Film Size Accepted Only */
	public Map<String, Object> getResultValidationAcceptedGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));

		try {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("ResultDate", currentDate));
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	// ///////////////////////////////
	/** for result entry **/

	public Map<String, Object> getResultGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		String deptName = "";
		if (map.get("dataMap") != null) {
			dataMap = (Map<String, Object>) map.get("dataMap");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		int hospitalId = 0;
		if (mapForDs.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + mapForDs.get("hospitalId"));

		try {
			crit = session.createCriteria(DgSampleCollectionDetails.class).add(
					Restrictions.eq("OrderStatus", "A")).createAlias(
					"SampleCollectionHeader", "sampleHead").createAlias(
					"sampleHead.Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).add(
					Restrictions.eq("sampleHead.SampleValidationDate",
							currentDate)).add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
			// .createAlias("", arg1)
					.addOrder(Order.asc("Subcharge.Id"));
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getResultGridLab(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Object[]> patientList = new ArrayList<Object[]>();
		List<DgSampleCollectionHeader> dgSampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();

		Date currentDate = new Date();
		;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		String deptName = "";
		if (map.get("dataMap") != null) {
			dataMap = (Map<String, Object>) map.get("dataMap");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		int hospitalId = 0;
		if (mapForDs.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + mapForDs.get("hospitalId"));
		String flag="";
		if (mapForDs.get("flag") != null)
			flag =  (String)mapForDs.get("flag");
		System.out.println("flag="+flag);
		try {
			crit = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("OrderStatus", "A"))
					
					
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
					.add(Restrictions.eq("sampleHead.SampleValidationDate",currentDate));
			
			System.out.println("currentdate="+currentDate);
					
					if(flag.equalsIgnoreCase("investigationForEmpanelledHospital"))
					{
						crit= crit.add(Restrictions.eq("EmpanelledStatus", "y").ignoreCase());
					}
					if(flag.equalsIgnoreCase("investigationForHalHospital"))
					{
						crit= crit.add(Restrictions.eq("EmpanelledStatus", "n").ignoreCase());
					}
					
					crit= crit.setProjection(Projections.projectionList()
									.add(Projections.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge")));
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getResultViewGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		try {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.eq("ResultStatus", "A")).add(
					Restrictions.eq("VerifiedOn", currentDate));
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	// =============================== end of methods by ABHA
	// =========================

	/** stsrt of methods by mansi **/

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientList1 = new ArrayList<Object[]>();
		List<Object[]> patientList2 = new ArrayList<Object[]>();
		Date fromDate = null;
		Date toDate = null;
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int orderByDepartmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String orderNo = "";

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("orderByDepartmentId") != null) {
			orderByDepartmentId = (Integer) mapForDs.get("orderByDepartmentId");
		}

		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		
		System.out.println("fromDate="+fromDate);
		
		System.out.println("toDate="+toDate);
		
		
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
		int hospitalId = 0;
		if (mapForDs.get("hospitalId") != null)
			hospitalId = Integer.parseInt("" + mapForDs.get("hospitalId"));
		System.out.println("hospitalId--- "+hospitalId);
		crit = session.createCriteria(DgResultEntryHeader.class).add(
				Restrictions.eq("ResultStatus", "A"))
				.createAlias("Patient", "pt").createAlias(
						"SampleCollectionHeader", "sampleHead").createAlias(
						"sampleHead.Order", "or").add(Restrictions.eq("MasHospital.Id", hospitalId));
		
		if(fromDate != null || toDate !=null)
		{
			crit.add(Restrictions.between("ResultDate", fromDate, toDate));
		}
		
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%").ignoreCase());
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo.trim() + "%"));
		}
		
		
	
		crit = crit		
				.setProjection(Projections.projectionList().add(
						Projections.groupProperty("sampleHead.Order")));

		patientList1 = crit.list();
		
		map.put("patientDetailsList", patientList1);

		return map;
	}

	/** end of methods by Mansi **/

	/** method for connection of report **/

	public Map<String, Object> getConnectionForReport() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;

	}

	/**
	 * new method for next functionality in result entry
	 * */
	public Map<String, Object> getResultEntryForNext(int newSampleCollectionId,
			int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int subTestId = 0;
		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		Session session = (Session) getSession();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			sampleCollectionList = session.createCriteria(
					DgSampleCollectionDetails.class).add(
					Restrictions.eq("Id", newSampleCollectionId)).addOrder(
					Order.asc("Id")).list();
			if (sampleCollectionList != null || sampleCollectionList.size() > 0) {

				detailsMap.put("sampleCollectionList", sampleCollectionList);
			}
			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();
					subList = session.createCriteria(
							DgSubMasInvestigation.class).add(
							Restrictions
									.eq("Investigation.Id", investigationId))
							.addOrder(Order.asc("OrderNo")).list();

				}
			}
			if (subList.size() > 0) {
				for (DgSubMasInvestigation dgSubMasInvestigation : subList) {
					detailsMap.put("subList", subList);
				}
			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subInvSet = dgApp.getInvestigation()
						.getDgSubMasInvestigations();

				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();

					/*fixedValList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
											+ subTestId
											+ "' and ga.FixedValue != null");
					*/
					fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", subTestId)).add(Restrictions.isNotNull("FixedValue")).list();
					if (fixedValList.size() > 0) {
						detailsMap.put("fixedValList", fixedValList);

					}
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		List objectList = new ArrayList();
		String orGroupId = "";
		try {
			if (dataMap.get("orGroupId") != null) {
				orGroupId = ("" + dataMap.get("orGroupId"));
			}
			StringTokenizer s1 = new StringTokenizer(orGroupId, ".");
			while (s1.hasMoreTokens()) {
				objectList.add(Integer.parseInt("" + s1.nextToken()));
			}
			Session session = (Session) getSession();
			if (objectList.size() > 0) {
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.add(Restrictions.in("OrganismGroup.Id", objectList))
						.addOrder(Order.asc("OrganismGroup.Id")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
		return map;
	}

	public Map<String, Object> getSensitivityList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] idsArray = new String[0];
		String orIds = "";

		List<Integer> organismIds = new ArrayList<Integer>();
		List<Integer> organismGroupIds = new ArrayList<Integer>();

		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		try {
			if (dataMap.get("orIds") != null) {
				orIds = "" + dataMap.get("orIds");
			}
			StringTokenizer s1 = new StringTokenizer(orIds, ".");
			while (s1.hasMoreTokens()) {
				try {
					int organismId = 0;
					int organismGroupId = 0;
					String combinedOrgGrpOrgId = s1.nextToken();

					idsArray = combinedOrgGrpOrgId.split("@");

					organismId = Integer.parseInt(idsArray[0]);
					organismIds.add(organismId);

					organismGroupId = Integer.parseInt(idsArray[1]);
					organismGroupIds.add(organismGroupId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Session session = (Session) getSession();
			if (organismIds.size() > 0) {
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).add(
						Restrictions.in("Organism.Id", organismIds)).add(
						Restrictions.in("OrganismGroup.Id", organismGroupIds))
						.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("dgOrgDtlList", dgOrgDtlList);
		return map;
	}

	public Map<String, Object> saveSensitivity(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int sampleDetailId = 0;
		String remarks = "";
		String result1 = "";
		String result2 = "";
		int investigationId = 0;
		String nosoc = "";

		DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) parameterMap
				.get("dgResultEntryHeader");
		// DgResultEntryDetailSen dgResultEntryDetailSen =
		// (DgResultEntryDetailSen)parameterMap.get("dgResultEntryDetailSen");

		investigationId = (Integer) parameterMap.get("investigationId");

		nosoc = (String) parameterMap.get("nosoc");
		String[] resArray = (String[]) parameterMap.get("resArray");
		result1 = (String) parameterMap.get("result1");
		result2 = (String) parameterMap.get("result2");
		sampleDetailId = (Integer) parameterMap.get("sampleDetailId");
		String[] senArray = (String[]) parameterMap.get("senArray");
		String growthOption = "";
		growthOption = (String) parameterMap.get("growthOption");

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgResultEntryHeader);

			if (growthOption.equalsIgnoreCase("o")) {

				DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetailSen.setInvestigation(dgMasInvestigation);
				}
				if (investigationId != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(investigationId);
					// dgResultEntryDetailSen.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetailSen.setSampleCollection(dgSample);
				}
				dgResultEntryDetailSen.setResult(result1);
				dgResultEntryDetailSen.setResultOther(result2);
				dgResultEntryDetailSen.setGrowthOption(growthOption);
				dgResultEntryDetailSen.setNosocomial(nosoc);
				dgResultEntryDetailSen.setResultEntry(dgResultEntryHeader);
				hbt.save(dgResultEntryDetailSen);
			}
			if (growthOption.equalsIgnoreCase("g")) {
				for (int ilop = 0; ilop < senArray.length; ilop++) {
					if (senArray[ilop] != null) {
						DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
						if (investigationId != 0) {
							if (investigationId != 0) {
								DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
								dgMasInvestigation.setId(investigationId);
								dgResultEntryDetailSen
										.setInvestigation(dgMasInvestigation);
							}
							if (investigationId != 0) {
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(investigationId);
								// dgResultEntryDetailSen.setChargeCode(masChargeCode);
							}
							if (sampleDetailId != 0) {
								DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
								dgSample.setId(sampleDetailId);
								dgResultEntryDetailSen
										.setSampleCollection(dgSample);
							}
							// MasAntibioticLab masAntibioticLab = new
							// MasAntibioticLab();
							// masAntibioticLab.setId(senArray[ilop]);
							String[] idsArray = new String[0];

							idsArray = senArray[ilop].split("@");
							int antibiticId = 0;
							int organismId = 0;
							int organismGroupId = 0;

							antibiticId = Integer.parseInt(idsArray[0]);

							organismId = Integer.parseInt(idsArray[1]);

							organismGroupId = Integer.parseInt(idsArray[2]);

							DgOrgDtl dgOrgDtl = (DgOrgDtl) session
									.createCriteria(DgOrgDtl.class)
									.createAlias("AntibioticLab", "Ab").add(
											Restrictions.eq("Ab.Id",
													antibiticId)).add(
											Restrictions.eq("Organism.Id",
													organismId)).add(
											Restrictions.eq("OrganismGroup.Id",
													organismGroupId)).list()
									.get(0);
							if (dgOrgDtl != null) {
								dgResultEntryDetailSen.setSensitivity(dgOrgDtl
										.getAntibioticLab());
								dgResultEntryDetailSen.setOrganism(dgOrgDtl
										.getOrganism());
								dgResultEntryDetailSen
										.setOrganismGroup(dgOrgDtl
												.getOrganismGroup());
							}
							/*
							 * DgOrgGrpDtl dgOrgGrpDtl =
							 * (DgOrgGrpDtl)session.createCriteria
							 * (DgOrgGrpDtl.class
							 * ).createAlias("Organism","Og").add
							 * (Restrictions.eq
							 * ("Og.Id",dgOrgDtl.getOrganism().getId
							 * ())).list().get(0); if(dgOrgGrpDtl!=null){
							 * dgResultEntryDetailSen
							 * .setOrganismGroup(dgOrgGrpDtl
							 * .getOrganismGroup());
							 * 
							 * }
							 */
							dgResultEntryDetailSen.setResult(resArray[ilop]);
							dgResultEntryDetailSen.setNosocomial(nosoc);
							dgResultEntryDetailSen
									.setResultEntry(dgResultEntryHeader);
							dgResultEntryDetailSen
									.setGrowthOption(growthOption);
							hbt.save(dgResultEntryDetailSen);
							dgResultEntryDetailSen = null;
						}
					}
				}
			}

			DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
					.load(DgSampleCollectionDetails.class, sampleDetailId);
			dgDetails.setOrderStatus("E");
			hbt.update(dgDetails);
			hbt.refresh(dgDetails);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------

	public Map<String, Object> getResultOrganismList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		int resultId = 0;
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		try {
			if (dataMap.get("resultId") != null) {
				resultId = (Integer) dataMap.get("resultId");
			}

			Session session = (Session) getSession();

			List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
			List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
			dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (resultId > 0) {
				dgResultEntryDetailSenList = session.createCriteria(
						DgResultEntryDetailSen.class).createAlias(
						"ResultEntry", "rs").add(
						Restrictions.eq("rs.Id", resultId)).list();
			}
			if (dgResultEntryDetailSenList.size() > 0) {
				map.put("dgResultEntryDetailSenList",
						dgResultEntryDetailSenList);
			}
			map.put("dgMasOrganismList", dgMasOrganismList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("dgOrgDtlList", dgOrgDtlList);
		return map;
	}

	public Map<String, Object> getResultSensitivityList(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		int resultId = 0;
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		try {
			if (dataMap.get("resultId") != null) {
				resultId = (Integer) dataMap.get("resultId");
			}

			Session session = (Session) getSession();

			List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
			if (resultId > 0) {
				dgResultEntryDetailSenList = session.createCriteria(
						DgResultEntryDetailSen.class).createAlias(
						"ResultEntry", "rs").add(
						Restrictions.eq("rs.Id", resultId)).list();
			}
			if (dgResultEntryDetailSenList.size() > 0) {
				map.put("dgResultEntryDetailSenList",
						dgResultEntryDetailSenList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("dgOrgDtlList", dgOrgDtlList);
		return map;
	}

	public boolean submitResultValidationForSensitivity(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		String remarks = "";
		remarks = (String) infoMap.get("remarks");

		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		String result1 = "";
		String result2 = "";
		String nosoc = "";
		result1 = (String) infoMap.get("result1");
		result2 = (String) infoMap.get("result2");
		nosoc = (String) infoMap.get("nosoc");
		String growthOption = "";
		if (infoMap.get("growthOption") != null)
			growthOption = (String) infoMap.get("growthOption");
		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null)
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}

			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setRemarks(remarks);
			dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);
			hbt.refresh(dgEntryHeader);

			String result = box.getString(RequestConstants.RESULT);
			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);
			String validated = box.getString(RequestConstants.VALIDATED);
			/*
			 * List<DgResultEntryDetail> dgResultDetailList = new
			 * ArrayList<DgResultEntryDetail>();
			 * 
			 * dgResultDetailList =
			 * session.createCriteria(DgResultEntryDetail.class
			 * ).add(Restrictions.eq("ResultEntry.Id", resultId)).list(); if
			 * (dgResultDetailList!=null && dgResultDetailList.size()>0) {
			 * DgResultEntryDetail dgResultEntryDetail = new
			 * DgResultEntryDetail();
			 * dgResultEntryDetail=dgResultDetailList.get(0);
			 * dgResultEntryDetail.setValidated("Y");
			 * dgResultEntryDetail.setResultDetailStatus("A");
			 * dgResultEntryDetail.setRemarks(additionalRemarks);
			 * dgResultEntryDetail.setResult(result);
			 * hbt.saveOrUpdate(dgResultEntryDetail); }
			 */
			int index = 1;

			String[] senArray = (String[]) infoMap.get("senArray");
			int sampleDetailId = 0;
			int investigationId = 0;

			if (infoMap.get("sampleDetailId") != null) {
				sampleDetailId = (Integer) infoMap.get("sampleDetailId");
			}
			if (infoMap.get("investigationId") != null) {
				investigationId = (Integer) infoMap.get("investigationId");
			}
			String[] resArray = (String[]) infoMap.get("resArray");
			DgResultEntryDetailSen temp = null;
			if (growthOption.equalsIgnoreCase("g")) {
				if (senArray != null && senArray.length > 0) {
					Query deleteQuery = session
							.createQuery("delete from DgResultEntryDetailSen "
									+ "where ResultEntry.Id=" + resultId);
					int row = deleteQuery.executeUpdate();
					/*if (row == 0) {
						//System.out.println("Doesn't deleted any row!");
					} else {
						//System.out.println("Deleted	Row: " + row);
					}*/
					/*
					 * tx.commit(); tx= session.beginTransaction();
					 */
					for (int ilop = 0; ilop < senArray.length; ilop++) {
						if (senArray[ilop] != null) {
							DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
							if (investigationId != 0) {
								if (investigationId != 0) {
									DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
									dgMasInvestigation.setId(investigationId);
									dgResultEntryDetailSen
											.setInvestigation(dgMasInvestigation);
								}

								if (sampleDetailId != 0) {
									DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
									dgSample.setId(sampleDetailId);
									dgResultEntryDetailSen
											.setSampleCollection(dgSample);
								}

								String[] idsArray = new String[0];

								idsArray = senArray[ilop].split("@");
								int antibiticId = 0;
								int organismId = 0;
								int organismGroupId = 0;

								antibiticId = Integer.parseInt(idsArray[0]);
								organismId = Integer.parseInt(idsArray[1]);
								organismGroupId = Integer.parseInt(idsArray[2]);

								MasAntibioticLab antibioticLab = new MasAntibioticLab();
								antibioticLab.setId(antibiticId);
								dgResultEntryDetailSen
										.setSensitivity(antibioticLab);

								DgMasOrganism dgMasOrganism = new DgMasOrganism();
								dgMasOrganism.setId(organismId);
								dgResultEntryDetailSen
										.setOrganism(dgMasOrganism);

								DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
								dgMasOrganismGroup.setId(organismGroupId);
								dgResultEntryDetailSen
										.setOrganismGroup(dgMasOrganismGroup);

								dgResultEntryDetailSen
										.setResult(resArray[ilop]);
								dgResultEntryDetailSen.setNosocomial(nosoc);
								dgResultEntryDetailSen
										.setResultEntry(dgEntryHeader);
								dgResultEntryDetailSen
										.setGrowthOption(growthOption);
								hbt.save(dgResultEntryDetailSen);
								hbt.refresh(dgResultEntryDetailSen);
								dgResultEntryDetailSen = null;
							}
						}
					}
				}

			} else {
				List dgResultEntryDetailSenList = session.createCriteria(
						DgResultEntryDetailSen.class).createAlias(
						"ResultEntry", "result").add(
						Restrictions.eq("result.Id", resultId)).list();
				DgResultEntryDetailSen newDgResultEntryDetailSen = (DgResultEntryDetailSen) dgResultEntryDetailSenList
						.get(0);
				newDgResultEntryDetailSen.setResultOther(result2);
				newDgResultEntryDetailSen.setResult(result1);
				newDgResultEntryDetailSen.setNosocomial(nosoc);
				hbt.update(newDgResultEntryDetailSen);
				hbt.refresh(newDgResultEntryDetailSen);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	public boolean submitResultEntryModificationForSensitivity(
			Map<String, Object> infoMap) {
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		String remarks = "";
		remarks = (String) infoMap.get("remarks");

		int resultId = 0;
		if (infoMap.get("resultId") != null)
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		String result1 = "";
		String result2 = "";
		String nosoc = "";
		result1 = (String) infoMap.get("result1");
		result2 = (String) infoMap.get("result2");
		nosoc = (String) infoMap.get("nosoc");
		String growthOption = "";
		if (infoMap.get("growthOption") != null)
			growthOption = (String) infoMap.get("growthOption");
		int resultEnteredBy = 0;
		if (infoMap.get("resultEnteredBy") != null)
			resultEnteredBy = Integer.parseInt(""
					+ infoMap.get("resultEnteredBy"));
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultEnteredBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredBy);
				dgEntryHeader.setEmployee(masEmployee);
			}

			// dgEntryHeader.setVerified("V");
			// dgEntryHeader.setVerifiedOn(date);
			// dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setRemarks(remarks);
			// dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);
			hbt.refresh(dgEntryHeader);

			String result = box.getString(RequestConstants.RESULT);
			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);

			int sampleDetailId = 0;
			int investigationId = 0;

			if (infoMap.get("sampleDetailId") != null) {
				sampleDetailId = (Integer) infoMap.get("sampleDetailId");
			}
			if (infoMap.get("investigationId") != null) {
				investigationId = (Integer) infoMap.get("investigationId");
			}

			String[] senArray = (String[]) infoMap.get("senArray");
			String[] resArray = (String[]) infoMap.get("resArray");
			DgResultEntryDetailSen temp = null;
			if (growthOption.equalsIgnoreCase("g")) {
				if (senArray != null && senArray.length > 0) {
					Query deleteQuery = session
							.createQuery("delete from DgResultEntryDetailSen "
									+ "where ResultEntry.Id=" + resultId);
					int row = deleteQuery.executeUpdate();
					/*if (row == 0) {
						//System.out.println("Doesn't deleted any row!");
					} else {
						//System.out.println("Deleted	Row: " + row);
					}*/
					/*
					 * tx.commit(); tx= session.beginTransaction();
					 */
					for (int ilop = 0; ilop < senArray.length; ilop++) {
						if (senArray[ilop] != null) {
							DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
							if (investigationId != 0) {
								if (investigationId != 0) {
									DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
									dgMasInvestigation.setId(investigationId);
									dgResultEntryDetailSen
											.setInvestigation(dgMasInvestigation);
								}

								if (sampleDetailId != 0) {
									DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
									dgSample.setId(sampleDetailId);
									dgResultEntryDetailSen
											.setSampleCollection(dgSample);
								}

								String[] idsArray = new String[0];

								idsArray = senArray[ilop].split("@");
								int antibiticId = 0;
								int organismId = 0;
								int organismGroupId = 0;

								antibiticId = Integer.parseInt(idsArray[0]);
								organismId = Integer.parseInt(idsArray[1]);
								organismGroupId = Integer.parseInt(idsArray[2]);

								MasAntibioticLab antibioticLab = new MasAntibioticLab();
								antibioticLab.setId(antibiticId);
								dgResultEntryDetailSen
										.setSensitivity(antibioticLab);

								DgMasOrganism dgMasOrganism = new DgMasOrganism();
								dgMasOrganism.setId(organismId);
								dgResultEntryDetailSen
										.setOrganism(dgMasOrganism);

								DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
								dgMasOrganismGroup.setId(organismGroupId);
								dgResultEntryDetailSen
										.setOrganismGroup(dgMasOrganismGroup);

								dgResultEntryDetailSen
										.setResult(resArray[ilop]);
								dgResultEntryDetailSen.setNosocomial(nosoc);
								dgResultEntryDetailSen
										.setResultEntry(dgEntryHeader);
								dgResultEntryDetailSen
										.setGrowthOption(growthOption);
								hbt.save(dgResultEntryDetailSen);
								hbt.refresh(dgResultEntryDetailSen);
								dgResultEntryDetailSen = null;
							}
						}
					}
				}

			} else {
				List dgResultEntryDetailSenList = session.createCriteria(
						DgResultEntryDetailSen.class).createAlias(
						"ResultEntry", "result").add(
						Restrictions.eq("result.Id", resultId)).list();
				DgResultEntryDetailSen newDgResultEntryDetailSen = (DgResultEntryDetailSen) dgResultEntryDetailSenList
						.get(0);
				newDgResultEntryDetailSen.setResultOther(result2);
				newDgResultEntryDetailSen.setResult(result1);
				newDgResultEntryDetailSen.setNosocomial(nosoc);
				hbt.update(newDgResultEntryDetailSen);
				hbt.refresh(newDgResultEntryDetailSen);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		return successfullyAdded;
	}

	// /////////////////////////////////////////////////////////

	public Map updateDgResultEntryHeader(
			Map<String, Object> mapForUpdateFilmDetailDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int dgResultEntryHeaderId = 0;
		String impression = "";

		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();

		List<String> filmSizeUsedList = (List) mapForUpdateFilmDetailDs
				.get("filmSizeUsedList");
		List<Integer> filmUsedList = (List) mapForUpdateFilmDetailDs
				.get("filmUsedList");
		int hdb = (Integer) mapForUpdateFilmDetailDs.get("hdb");
		int dgResultEntryDetailId = (Integer) mapForUpdateFilmDetailDs
				.get("dgResultEntryDetailId");
		if (mapForUpdateFilmDetailDs.get("dgResultEntryDetailId") != null) {
			dgResultEntryHeaderId = (Integer) mapForUpdateFilmDetailDs
					.get("dgResultEntryHeaderId");
		}
		if (mapForUpdateFilmDetailDs.get("dgResultEntryDetailId") != null) {
			impression = (String) mapForUpdateFilmDetailDs.get("impression");
		}

		dgResultEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
				.load(DgResultEntryHeader.class, dgResultEntryHeaderId);
		dgResultEntryHeader.setImpression(impression);
		hbt.update(dgResultEntryHeader);
		hbt.refresh(dgResultEntryHeader);

		Query deleteQuery = session
				.createQuery("delete from DgFilmDetail where ResultEntryDetail.Id="
						+ dgResultEntryDetailId);
		int row = deleteQuery.executeUpdate();
		/*if (row == 0) {
			//System.out.println("Doesn't deleted any row!");
		} else {
			//System.out.println("Deleted	Row: " + row);
		}*/

		try {
			for (int i = 0; i < hdb; i++) {
				DgFilmDetail dgFilmDetail = new DgFilmDetail();
				DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
				dgResultEntryDetail.setId(dgResultEntryDetailId);
				dgFilmDetail.setResultEntryDetail(dgResultEntryDetail);
				dgFilmDetail.setFilmSize(filmSizeUsedList.get(i));
				dgFilmDetail.setFilmUsed(filmUsedList.get(i));
				hbt.save(dgFilmDetail);
				hbt.refresh(dgFilmDetail);
			}
			saved = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		// hbt.update(dgResultEntryHeader);
		// hbt.refresh(dgResultEntryHeader);

		map.put("saved", saved);
		return map;

	}

	public Map<String, Object> getAllValidatedTestForOrder(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String orderNo = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Criteria crit = null;
		try {
			if (requestMap.get("orderNo") != null) {
				orderNo = (String) requestMap.get("orderNo");
			}
			Session session = (Session) getSession();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			if (!orderNo.equals("")) {
				dgResultdetailList = session.createCriteria(
						DgResultEntryDetail.class).createAlias("ResultEntry",
						"re").createAlias("re.SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN").add(
								Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultDetailStatus", "A"))
						.createAlias("re.MainChargecode", "mcc").add(
								Restrictions.eq("mcc.MainChargecodeCode",
										"Radio")).list();
			}
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "re")
						.createAlias("re.SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultDetailStatus", "A"))
						.createAlias("re.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Radio"))
						.createAlias("Investigation", "inv")
						.createAlias("inv.SubChargecode", "subCharg")
						.setProjection(
								Projections
										.distinct(Projections
												.projectionList()
												.add(
														Projections
																.property("subCharg.SubChargecodeName"))));

				// .setProjection(Projections.property("scc.SubChargecodeName"));
				subChargeCodeGroup = crit.list();
			}

			/*
			 * if(!orderNo.equals("")){ crit =
			 * session.createCriteria(DgOrderdt.class) .createAlias("Orderhd",
			 * "oNo") .add(Restrictions.eq("oNo.OrderNo", orderNo))
			 * .createAlias("SubChargeid", "scc")
			 * //.setProjection(Projections.groupProperty
			 * ("scc.SubChargecodeName"))
			 * .setProjection(Projections.distinct(Projections
			 * .projectionList().
			 * add(Projections.property("scc.SubChargecodeName"))));
			 * //.setProjection(Projections.property("scc.SubChargecodeName"));
			 * subChargeCodeGroup = crit.list(); }
			 */
			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {

				// detailsMap.put("dgResultdetailList", dgResultdetailList);

				detailsMap.put("resultList", dgResultdetailList);
				detailsMap.put("hinNo", dgResultdetailList.get(0)
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultdetailList.get(0)
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultdetailList.get(0)
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultdetailList.get(0).getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultdetailList.get(0).getResultEntry()
						.getPatient();

				String prefix = "";
				prefix = p.getPrefix();
				detailsMap.put("prefix", prefix);

				String suffix = "";
				suffix = p.getSuffix();
				detailsMap.put("suffix", suffix);

				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultdetailList.get(0)
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultdetailList.get(0)
						.getInvestigation().getInvestigationName());
				DgResultEntryDetail dgResultEntryDetail = dgResultdetailList
						.get(0);
				String clinicalNotes = dgResultEntryDetail
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNotes", clinicalNotes);

				String radioId = dgResultEntryDetail
						.getSampleCollectionDetails().getDiagNo();
				detailsMap.put("radioId", radioId);

				String confidential = dgResultEntryDetail.getInvestigation()
						.getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultdetailList.get(0).getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultdetailList.get(0).getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultdetailList.get(0).getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getAllValidatedTestForLabOrder(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String orderNo = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Criteria crit = null;
		try {
			if (requestMap.get("orderNo") != null) {
				orderNo = (String) requestMap.get("orderNo");
			}
			Session session = (Session) getSession();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();
			List<DgResultEntryHeader> dgSensitiveResultdetailList = new ArrayList<DgResultEntryHeader>();
			/* Get All Multiple Test Only */
			if (!orderNo.equals("")) {
				dgMultipleResultdetailList = session.createCriteria(
						DgResultEntryHeader.class).createAlias(
						"SampleCollectionHeader", "sch").createAlias(
						"sch.Order", "orderN").add(
						Restrictions.eq("orderN.OrderNo", orderNo)).add(
						Restrictions.eq("ResultStatus", "A")).createAlias(
						"MainChargecode", "mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab")).add(
						Restrictions.isNull("ResultType"))
				// .createAlias("DgResultEntryDetails", "reDtl")
						// .createAlias("reDtl.Investigation", "invest")
						// .add(Restrictions.eq("invest.InvestigationType",
						// "m"))
						.list();
			}
			/* Get All Sensitive Test Only */
			if (!orderNo.equals("")) {
				dgSensitiveResultdetailList = session.createCriteria(
						DgResultEntryHeader.class).createAlias(
						"SampleCollectionHeader", "sch").createAlias(
						"sch.Order", "orderN").add(
						Restrictions.eq("orderN.OrderNo", orderNo)).add(
						Restrictions.eq("ResultStatus", "A")).createAlias(
						"MainChargecode", "mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab")).add(
						Restrictions.eq("ResultType", "S")).list();
			}

			/* Get All except Multiple Test Only */
			List<String> investTypeList = new ArrayList<String>();
			investTypeList.add("t");
			investTypeList.add("s");
			if (!orderNo.equals("")) {
				dgResultdetailList = session.createCriteria(
						DgResultEntryDetail.class).createAlias("ResultEntry",
						"re").createAlias("re.SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN").add(
								Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultDetailStatus", "A"))
						.createAlias("re.MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv")
						// .createAlias("inv.InvestigationType", "investType")
						.add(
								Restrictions.in("inv.InvestigationType",
										investTypeList)).list();
			}
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultStatus", "A"))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("SubChargecode", "subCharg")
						.setProjection(
								Projections
										.distinct(Projections
												.projectionList()
												.add(
														Projections
																.property("subCharg.SubChargecodeName"))));
				subChargeCodeGroup = crit.list();
			}

			/*
			 * if(!orderNo.equals("")){ crit =
			 * session.createCriteria(DgOrderdt.class) .createAlias("Orderhd",
			 * "oNo") .add(Restrictions.eq("oNo.OrderNo", orderNo))
			 * .createAlias("SubChargeid", "scc")
			 * //.setProjection(Projections.groupProperty
			 * ("scc.SubChargecodeName"))
			 * .setProjection(Projections.distinct(Projections
			 * .projectionList().
			 * add(Projections.property("scc.SubChargecodeName"))));
			 * //.setProjection(Projections.property("scc.SubChargecodeName"));
			 * subChargeCodeGroup = crit.list(); }
			 */
			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);
			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				detailsMap.put("resultList", dgResultdetailList);
			}
			List<DgResultEntryHeader> headerToRemove = new ArrayList<DgResultEntryHeader>();

			for (DgResultEntryHeader dgResultEntryHeader : dgMultipleResultdetailList) {
				DgResultEntryDetail dgResultEntryDetail = dgResultEntryHeader
						.getDgResultEntryDetails().iterator().next();
				if (dgResultEntryDetail.getInvestigation()
						.getInvestigationType() != null
						&& !dgResultEntryDetail.getInvestigation()
								.getInvestigationType().equalsIgnoreCase("m")) {
					headerToRemove.add(dgResultEntryHeader);
				}
			}
			dgMultipleResultdetailList.removeAll(headerToRemove);

			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				dgResultEntryDetailForData = dgResultdetailList.get(0);
			} else if (dgMultipleResultdetailList != null
					&& dgMultipleResultdetailList.size() > 0) {
				dgResultEntryDetailForData = dgMultipleResultdetailList.get(0)
						.getDgResultEntryDetails().iterator().next();
			} else if (dgSensitiveResultdetailList != null
					&& dgSensitiveResultdetailList.size() > 0) {
				dgResultEntryDetailSenForData = dgSensitiveResultdetailList
						.get(0).getDgResultEntryDetailSen().iterator().next();
			}

			if (dgMultipleResultdetailList != null
					&& dgMultipleResultdetailList.size() > 0) {
				detailsMap.put("dgMultipleResultdetailList",
						dgMultipleResultdetailList);
			}
			if (dgSensitiveResultdetailList != null
					&& dgSensitiveResultdetailList.size() > 0) {
				detailsMap.put("dgSensitiveResultdetailList",
						dgSensitiveResultdetailList);
			}

			if ((dgResultdetailList != null && dgResultdetailList.size() > 0)
					|| (dgMultipleResultdetailList != null && dgMultipleResultdetailList
							.size() > 0)) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader()
								.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailSenForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String orderNo = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();
		/*String flagMo="";*/
		int hinId=0;
		
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Criteria crit = null;
		Criteria crit1 = null;
		try {
			if (requestMap.get("orderNo") != null) {
				orderNo = (String) requestMap.get("orderNo");
			}
			int orderId =0;
			if(!orderNo.equals("")){
				orderId = Integer.parseInt(orderNo);
			}
			/*if (requestMap.get("flag") != null && requestMap.get("flag") !="") {
				flagMo = (String) requestMap.get("flag");
			}*/
			if (requestMap.get("hinId") != null && requestMap.get("hinId") !="") {
				hinId = (Integer) requestMap.get("hinId");
			}
			Session session = (Session) getSession();

			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
			if (!orderNo.equals("")) {
				crit1 = session.createCriteria(
						DgResultEntryHeader.class).createAlias(
						"SampleCollectionHeader", "sch").createAlias(
						"sch.Order", "orderN").add(
						Restrictions.eq("orderN.Id", orderId)).add(
						Restrictions.eq("ResultStatus", "A")).createAlias(
						"MainChargecode", "mcc")//.add(
						//Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("DgMasInvestigation", "inv").addOrder(
								Order.asc("inv.TestOrderNo"))
						// .createAlias("DgResultEntryDetails", "reDtl")
						// .createAlias("reDtl.Investigation", "invest")
						// .add(Restrictions.eq("invest.InvestigationType",
						// "m"))
						;
				if(hinId>0){
					crit1 = crit1.createAlias("Patient", "pat")
					.add(Restrictions.eq("pat.Id", hinId));
				}
				dgResultEntryHeaderByOrderNo= crit1.list();
			}
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.Id", orderId))
						.add(Restrictions.eq("ResultStatus", "A"))
						.createAlias("MainChargecode", "mcc")
						//.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("SubChargecode", "subCharg");
				if(hinId>0){
					crit = crit.createAlias("Patient", "pat")
					.add(Restrictions.eq("pat.Id", hinId));
				}
						crit =crit.setProjection(
								Projections
										.distinct(Projections
												.projectionList()
												.add(
														Projections
																.property("subCharg.SubChargecodeName"))));
				subChargeCodeGroup = crit.list();
			}

			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();

			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				detailsMap.put("dgResultEntryHeaderByOrderNo",
						dgResultEntryHeaderByOrderNo);
			}
			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				DgResultEntryHeader header = dgResultEntryHeaderByOrderNo
						.get(0);
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
				} else if (header.getDgResultEntryDetailSen().size() > 0) {
					dgResultEntryDetailSenForData = header
							.getDgResultEntryDetailSen().iterator().next();
				}
			}

			if (flag) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				/*
				 * coded by Ujjwal for null value of middle and last name
				 */
				if( p.getPFirstName()!=null && ! (p.getPFirstName()).equals("")){
				pFullName = p.getPFirstName();
				}

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
				detailsMap.put("hospitalName", dgResultEntryDetailForData.getResultEntry().getMasHospital().getHospitalName());
				detailsMap.put("hospitalAddress", dgResultEntryDetailForData.getResultEntry().getMasHospital().getAddress());
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader()
								.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailSenForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
				detailsMap.put("hospitalName", dgResultEntryDetailSenForData.getResultEntry().getMasHospital().getHospitalName());
				detailsMap.put("hospitalAddress", dgResultEntryDetailSenForData.getResultEntry().getMasHospital().getAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getDetailsForProvisionalReportLab(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String combinedIds = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		Criteria crit = null;
		try {
			if (requestMap.get("dgSampleHeaderId") != null) {
				dgSampleHeaderId = (Integer) requestMap.get("dgSampleHeaderId");
			}
			if (requestMap.get("subChargeId") != null) {
				subChargeId = (Integer) requestMap.get("subChargeId");
			}

			Session session = (Session) getSession();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();
			List<DgResultEntryHeader> dgSensitiveResultdetailList = new ArrayList<DgResultEntryHeader>();
			/* Get All Multiple Test Only */
			if (dgSampleHeaderId != 0) {
				dgMultipleResultdetailList = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.eq("SampleCollectionHeader.Id",
								dgSampleHeaderId)).add(
						Restrictions.eq("SubChargecode.Id", subChargeId)).add(
						Restrictions.eq("ResultStatus", "P")).createAlias(
						"MainChargecode", "mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab")).add(
						Restrictions.isNull("ResultType")).list();
			}
			/* Get All Sensitive Test Only */
			if (dgSampleHeaderId != 0) {
				dgSensitiveResultdetailList = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.eq("SampleCollectionHeader.Id",
								dgSampleHeaderId)).add(
						Restrictions.eq("SubChargecode.Id", subChargeId)).add(
						Restrictions.eq("ResultStatus", "P")).createAlias(
						"MainChargecode", "mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab")).add(
						Restrictions.eq("ResultType", "S")).list();
			}

			/* Get All except Multiple Test Only */
			List<String> investTypeList = new ArrayList<String>();
			investTypeList.add("t");
			investTypeList.add("s");
			if (dgSampleHeaderId != 0) {
				dgResultdetailList = session.createCriteria(
						DgResultEntryDetail.class).createAlias("ResultEntry",
						"re").createAlias("re.SampleCollectionHeader", "sch")
						.add(Restrictions.eq("sch.Id", dgSampleHeaderId))
						.add(
								Restrictions.eq("re.SubChargecode.Id",
										subChargeId))
						// .add(Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultDetailStatus", "P"))
						.createAlias("re.MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv")
						// .createAlias("inv.InvestigationType", "investType")
						.add(
								Restrictions.in("inv.InvestigationType",
										investTypeList)).list();
			}
			/*
			 * List<Integer> dgResultEntryHeaderOrderNoWise = new
			 * ArrayList<Integer>(); if(dgSampleHeaderId != 0){
			 * dgResultEntryHeaderOrderNoWise =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.eq("SampleCollectionHeader.Id",
			 * dgSampleHeaderId)) .add(Restrictions.eq("SubChargecode.Id",
			 * subChargeId)) .setProjection(Projections.property("TestOrderNo"))
			 * .addOrder(Order.asc("TestOrderNo")) .list(); }
			 * detailsMap.put("dgResultEntryHeaderOrderNoWise",
			 * dgResultEntryHeaderOrderNoWise);
			 */

			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				detailsMap.put("resultList", dgResultdetailList);
			}
			List<DgResultEntryHeader> headerToRemove = new ArrayList<DgResultEntryHeader>();

			for (DgResultEntryHeader dgResultEntryHeader : dgMultipleResultdetailList) {
				DgResultEntryDetail dgResultEntryDetail = dgResultEntryHeader
						.getDgResultEntryDetails().iterator().next();
				if (dgResultEntryDetail.getInvestigation()
						.getInvestigationType() != null
						&& !dgResultEntryDetail.getInvestigation()
								.getInvestigationType().equalsIgnoreCase("m")) {
					headerToRemove.add(dgResultEntryHeader);
				}
			}
			dgMultipleResultdetailList.removeAll(headerToRemove);

			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				dgResultEntryDetailForData = dgResultdetailList.get(0);
			} else if (dgMultipleResultdetailList != null
					&& dgMultipleResultdetailList.size() > 0) {
				dgResultEntryDetailForData = dgMultipleResultdetailList.get(0)
						.getDgResultEntryDetails().iterator().next();
			} else if (dgSensitiveResultdetailList != null
					&& dgSensitiveResultdetailList.size() > 0) {
				dgResultEntryDetailSenForData = dgSensitiveResultdetailList
						.get(0).getDgResultEntryDetailSen().iterator().next();
			}

			if (dgMultipleResultdetailList != null
					&& dgMultipleResultdetailList.size() > 0) {
				detailsMap.put("dgMultipleResultdetailList",
						dgMultipleResultdetailList);
			}
			if (dgSensitiveResultdetailList != null
					&& dgSensitiveResultdetailList.size() > 0) {
				detailsMap.put("dgSensitiveResultdetailList",
						dgSensitiveResultdetailList);
			}

			if ((dgResultdetailList != null && dgResultdetailList.size() > 0)
					|| (dgMultipleResultdetailList != null && dgMultipleResultdetailList
							.size() > 0)) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader()
								.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailSenForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getProvisionalReportDetailsOrderNoWiseLab(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String combinedIds = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;
		String resultStatus = "";

		Criteria crit = null;
		try {
			if (requestMap.get("dgSampleHeaderId") != null) {
				dgSampleHeaderId = (Integer) requestMap.get("dgSampleHeaderId");
			}
			if (requestMap.get("subChargeId") != null) {
				subChargeId = (Integer) requestMap.get("subChargeId");
			}
			if (requestMap.get("resultStatus") != null) {
				resultStatus = (String) requestMap.get("resultStatus");
			}

			Session session = (Session) getSession();
			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();

			if (dgSampleHeaderId != 0) {
				/*dgResultEntryHeaderByOrderNo = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.eq("SampleCollectionHeader.Id",
								dgSampleHeaderId)).add(
						Restrictions.eq("SubChargecode.Id", subChargeId)).add(
						Restrictions.eq("ResultStatus", resultStatus))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("DgMasInvestigation", "inv").addOrder(
								Order.asc("inv.TestOrderNo")).list();*/
				dgResultEntryHeaderByOrderNo = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.eq("SampleCollectionHeader.Id",
								dgSampleHeaderId)).add(
						Restrictions.eq("SubChargecode.Id", subChargeId)).add(
						Restrictions.eq("ResultStatus", resultStatus))
						.createAlias("DgMasInvestigation", "inv").addOrder(
								Order.asc("inv.TestOrderNo")).list();
			}
			System.out.println("dgResultEntryHeaderByOrderNo.size()-----"+dgResultEntryHeaderByOrderNo.size());
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				detailsMap.put("dgResultEntryHeaderByOrderNo",
						dgResultEntryHeaderByOrderNo);
			}
			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0)
			{
			    boolean status=false;	
			  for(DgResultEntryHeader header :dgResultEntryHeaderByOrderNo) 
			  {	  
				//DgResultEntryHeader header = dgResultEntryHeaderByOrderNo.get(0);
				
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
					//System.out.println("getDgResultEntryDetails size >>>>>"+header.getDgResultEntryDetails().size());
					status=true;
				} else if (header.getDgResultEntryDetailSen().size() > 0) {
					dgResultEntryDetailSenForData = header
							.getDgResultEntryDetailSen().iterator().next();
					//System.out.println("getDgResultEntryDetails size else >>>>>"+header.getDgResultEntryDetailSen().size());
					status=true;
				}
				if(status==true)
					break;
			  }	
			}
			if (flag) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					if (e.getRank() != null) {
						detailsMap.put("empRank", e.getRank().getRankName());
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
				detailsMap.put("hospitalName", dgResultEntryDetailForData.getResultEntry().getMasHospital().getHospitalName());
				detailsMap.put("hospitalAddress", dgResultEntryDetailForData.getResultEntry().getMasHospital().getAddress());
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader()
								.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailSenForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
				detailsMap.put("hospitalName", dgResultEntryDetailSenForData.getResultEntry().getMasHospital().getHospitalName());
				detailsMap.put("hospitalAddress", dgResultEntryDetailSenForData.getResultEntry().getMasHospital().getAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getDetailsForFinalReportLab(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String combinedIds = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String resultId = "";
		String stringOfIds = "";
		String resultStatusRequired = "";
		String[] headerIdsValue = new String[0];
		String[] idsArray = new String[0];
		List<Integer> headerIdsInt = new ArrayList<Integer>();

		Integer dgSampleHeaderId = 0;
		Integer stringSubDeptIds = 0;
		if (requestMap.get("resultStatusRequired") != null) {
			resultStatusRequired = (String) requestMap
					.get("resultStatusRequired");
		}
		if (!resultStatusRequired.equals("")) {
			resultStatusRequired = "P";
		} else {
			resultStatusRequired = "A";
		}
		Criteria crit = null;
		try {
			if (requestMap.get("resultId") != null) {
				resultId = (String) requestMap.get("resultId");
				if (!resultId.equals("")) {
					idsArray = resultId.split("@");
					stringOfIds = idsArray[0];
					stringSubDeptIds = Integer.parseInt(idsArray[1]);

					headerIdsValue = stringOfIds.split(",");
					for (String id : headerIdsValue) {
						headerIdsInt.add(Integer.parseInt(id));
					}
				}
			}

			Session session = (Session) getSession();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();
			List<DgResultEntryHeader> dgSensitiveResultdetailList = new ArrayList<DgResultEntryHeader>();

			/* Get All Multiple Test Only */
			if (!resultId.equals("")) {
				dgMultipleResultdetailList = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.in("Id", headerIdsInt)).add(
						Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
						.add(
								Restrictions.eq("ResultStatus",
										resultStatusRequired)).createAlias(
								"MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.add(Restrictions.isNull("ResultType")).list();
			}
			/* Get All Sensitive Test Only */
			if (!resultId.equals("")) {
				dgSensitiveResultdetailList = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.in("Id", headerIdsInt)).add(
						Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
						.add(
								Restrictions.eq("ResultStatus",
										resultStatusRequired)).createAlias(
								"MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.add(Restrictions.eq("ResultType", "S")).list();
			}
			/* Get All except Multiple Test Only */
			List<String> investTypeList = new ArrayList<String>();
			investTypeList.add("t");
			investTypeList.add("s");
			if (!resultId.equals("")) {
				dgResultdetailList = session.createCriteria(
						DgResultEntryDetail.class).createAlias("ResultEntry",
						"re").add(Restrictions.in("re.Id", headerIdsInt)).add(
						Restrictions
								.eq("re.SubChargecode.Id", stringSubDeptIds))
						.add(
								Restrictions.eq("ResultDetailStatus",
										resultStatusRequired)).createAlias(
								"re.MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.in("inv.InvestigationType",
										investTypeList)).list();
			}

			/*
			 * List<Integer> dgResultEntryHeaderOrderNoWise = new
			 * ArrayList<Integer>(); if(dgSampleHeaderId != 0){
			 * dgResultEntryHeaderOrderNoWise =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.in("Id", headerIdsInt))
			 * .add(Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
			 * .setProjection(Projections.property("TestOrderNo"))
			 * .addOrder(Order.asc("TestOrderNo")) .list(); }
			 * detailsMap.put("dgResultEntryHeaderOrderNoWise",
			 * dgResultEntryHeaderOrderNoWise);
			 */

			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				detailsMap.put("resultList", dgResultdetailList);
			}
			List<DgResultEntryHeader> headerToRemove = new ArrayList<DgResultEntryHeader>();

			for (DgResultEntryHeader dgResultEntryHeader : dgMultipleResultdetailList) {
				DgResultEntryDetail dgResultEntryDetail = dgResultEntryHeader
						.getDgResultEntryDetails().iterator().next();
				if (dgResultEntryDetail.getInvestigation()
						.getInvestigationType() != null
						&& !dgResultEntryDetail.getInvestigation()
								.getInvestigationType().equalsIgnoreCase("m")) {
					headerToRemove.add(dgResultEntryHeader);
				}
			}
			dgMultipleResultdetailList.removeAll(headerToRemove);

			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				dgResultEntryDetailForData = dgResultdetailList.get(0);
			} else if (dgMultipleResultdetailList != null
					&& dgMultipleResultdetailList.size() > 0) {
				dgResultEntryDetailForData = dgMultipleResultdetailList.get(0)
						.getDgResultEntryDetails().iterator().next();
			} else if (dgSensitiveResultdetailList != null
					&& dgSensitiveResultdetailList.size() > 0) {
				dgResultEntryDetailSenForData = dgSensitiveResultdetailList
						.get(0).getDgResultEntryDetailSen().iterator().next();
			}

			if (dgMultipleResultdetailList != null
					&& dgMultipleResultdetailList.size() > 0) {
				detailsMap.put("dgMultipleResultdetailList",
						dgMultipleResultdetailList);
			}
			if (dgSensitiveResultdetailList != null
					&& dgSensitiveResultdetailList.size() > 0) {
				detailsMap.put("dgSensitiveResultdetailList",
						dgSensitiveResultdetailList);
			}
			if ((dgResultdetailList != null && dgResultdetailList.size() > 0)
					|| (dgMultipleResultdetailList != null && dgMultipleResultdetailList
							.size() > 0)) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);

				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}
				}
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader()
								.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailSenForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);

				}

				MasEmployee e1 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getDetailsForFinalReportByOrderNoLab(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String combinedIds = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String resultId = "";
		String stringOfIds = "";
		String resultStatusRequired = "";
		String[] headerIdsValue = new String[0];
		String[] idsArray = new String[0];
		List<Integer> headerIdsInt = new ArrayList<Integer>();

		Integer dgSampleHeaderId = 0;
		Integer stringSubDeptIds = 0;
		if (requestMap.get("resultStatusRequired") != null) {
			resultStatusRequired = (String) requestMap
					.get("resultStatusRequired");
		}
		if (!resultStatusRequired.equals("")) {
			resultStatusRequired = "P";
		} else {
			resultStatusRequired = "A";
		}
		Criteria crit = null;
		try {
			if (requestMap.get("resultId") != null) {
				resultId = (String) requestMap.get("resultId");
				if (!resultId.equals("")) {
					idsArray = resultId.split("@");
					stringOfIds = idsArray[0];
					stringSubDeptIds = Integer.parseInt(idsArray[1]);

					headerIdsValue = stringOfIds.split(",");
					for (String id : headerIdsValue) {
						headerIdsInt.add(Integer.parseInt(id));
					}
				}
			}

			Session session = (Session) getSession();

			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();

			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();

			/* Get All Multiple Test Only */
			if (!resultId.equals("")) {
				/*dgResultEntryHeaderByOrderNo = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.in("Id", headerIdsInt)).add(
						Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
						.add(
								Restrictions.eq("ResultStatus",
										resultStatusRequired)).createAlias(
								"MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.createAlias("DgMasInvestigation", "inv").addOrder(
								Order.asc("inv.TestOrderNo")).list();*/
				dgResultEntryHeaderByOrderNo = session.createCriteria(
						DgResultEntryHeader.class).add(
						Restrictions.in("Id", headerIdsInt)).add(
						Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
						.add(
								Restrictions.eq("ResultStatus",
										resultStatusRequired))
						.createAlias("DgMasInvestigation", "inv").addOrder(
								Order.asc("inv.TestOrderNo")).list();
			}
			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				DgResultEntryHeader header = dgResultEntryHeaderByOrderNo
						.get(0);
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
				} else if (header.getDgResultEntryDetailSen().size() > 0) {
					dgResultEntryDetailSenForData = header
							.getDgResultEntryDetailSen().iterator().next();
				}
			}
			detailsMap.put("dgResultEntryHeaderByOrderNo",
					dgResultEntryHeaderByOrderNo);

			if (flag) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailForData
						.getResultEntry().getPatient().getServiceNo());
				/*detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrderByDepartment().getDepartmentName());*/
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					if(e.getRank()!= null){
						detailsMap.put("empRank", e.getRank().getRankName());
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
					
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}
					
				}
				detailsMap.put("hospitalName", dgResultEntryDetailForData.getResultEntry().getMasHospital().getHospitalName());
				detailsMap.put("hospitalAddress", dgResultEntryDetailForData.getResultEntry().getMasHospital().getAddress());
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getHinNo());
				detailsMap.put("serviceNo", dgResultEntryDetailSenForData
						.getResultEntry().getPatient().getServiceNo());
				
				/*detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader()
								.getOrderByDepartment().getDepartmentName());*/
				
				detailsMap.put("orderByDepartment",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSampleCollectionHeader().getOrder()
								.getDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailSenForData.getResultEntry()
						.getPatient();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				detailsMap.put("relationName", p.getRelation()
						.getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);

				}

				MasEmployee e1 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getDesignation() != null) {
						String entryPersonNameDesignation = e1.getDesignation();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

					if (e2.getDesignation() != null) {
						String verifiedPersonNameDesignation = e2
								.getDesignation();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
				detailsMap.put("hospitalName", dgResultEntryDetailForData.getResultEntry().getMasHospital().getHospitalName());
				detailsMap.put("hospitalAddress", dgResultEntryDetailForData.getResultEntry().getMasHospital().getAddress());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getAllResultValidatedConfidentialOrders(
			Map<String, Object> mapForDs) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList1 = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String orderNo = "";

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}

		crit = session.createCriteria(DgResultEntryHeader.class).add(
				Restrictions.eq("ResultStatus", "A")).add(
				Restrictions.between("ResultDate", fromDate, toDate))
				.createAlias("Patient", "pt").createAlias(
						"DgResultEntryDetails", "dgResDet").createAlias(
						"dgResDet.Investigation", "inv").add(
						Restrictions.eq("inv.Confidential", "y"));

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.ServiceNo", serviceNo + "%"));
		}

		if (!serPersonFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.SFirstName", serPersonFName
					+ "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.PatientType", orderType));
		}
		if (!orderNo.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.OrderNo", orderNo));
		}

		patientList1 = crit.list();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		if (patientList1.size() > 0) {
			patientList.add(patientList1.get(0));
			for (int ilop = 0; ilop < patientList1.size() - 1; ilop++) {
				if (!patientList1.get(ilop).getSampleCollectionHeader()
						.getOrder().getOrderNo().equals(
								patientList1.get(ilop + 1)
										.getSampleCollectionHeader().getOrder()
										.getOrderNo()))
					patientList.add(patientList1.get(ilop + 1));
			}

			map.put("patientDetailsList", patientList);
		} else {
			map.put("patientDetailsList", patientList1);
		}
		return map;

	}

	public Map<String, Object> getResultEntryDetailsForMultipleResultType(
			int resultId, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultHeaderId = 0;
		int fixedId = 0;
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Id", resultId)).list();
			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					resultHeaderId = dgResultHeader.getId();
				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultHeaderId))
							// .add(Restrictions.eq("ResultDetailStatus", "P"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session.createCriteria(
							DgResultEntryDetailSen.class).createAlias(
							"ResultEntry", "rs").add(
							Restrictions.eq("rs.Id", resultHeaderId)).list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
					/*	fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");*/
						
						fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", fixedId)).add(Restrictions.isNotNull("FixedValue")).list();

						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getDetailsForSearch() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();

		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Status", "y")).list();
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();
			if (wardList.size() > 0) {
				detailsMap.put("wardList", wardList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> searchProvisionalResultEntryDetails(
			Map<String, Object> requestMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		// List<Integer> dgOrderhdIds =new ArrayList<Integer>();
		List<DgOrderhd> dgResultEntryList = new ArrayList<DgOrderhd>();
		// List<DgOrderhd> dgOrderhdListTemp = new ArrayList<DgOrderhd>();

		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		String serviceNo = "";

		if (requestMap.get("serviceNo") != null) {
			serviceNo = (String) requestMap.get("serviceNo");
		}
		if (requestMap.get("hinNo") != null) {
			hinNo = (String) requestMap.get("hinNo");
		}
		if (requestMap.get("wardId") != null) {
			wardId = (Integer) requestMap.get("wardId");
		}
		if (requestMap.get("adNo") != null) {
			adNo = (String) requestMap.get("adNo");
		}

		Criteria crit = null;
		try {
			crit = session.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "re").createAlias("re.Patient",
							"pt").createAlias("re.Inpatient", "inPt");
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
			}
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("inPt.AdNo", adNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (wardId != 0) {
				crit = crit.createAlias("inPt.AdWardId", "wId");
				crit = crit.add(Restrictions.eq("wId.Id", wardId));
			}
			crit = crit.createAlias("Investigation", "inv");
			crit = crit.createAlias("inv.MainChargecode", "mcc");
			crit = crit.add(Restrictions.eq("mcc.MainChargecodeCode", "Radio"));
			crit = crit.add(Restrictions.eq("ResultDetailStatus", "P"));

			dgResultEntryList = crit.list();
			map.put("dgResultEntryList", dgResultEntryList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchProvisionalResultEntryDetailsLab(
			Map<String, Object> requestMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		int deptId = 0;
		String serviceNo = "";

		if (requestMap.get("serviceNo") != null) {
			serviceNo = (String) requestMap.get("serviceNo");
		}
		if (requestMap.get("hinNo") != null) {
			hinNo = (String) requestMap.get("hinNo");
		}
		if (requestMap.get("wardId") != null) {
			wardId = (Integer) requestMap.get("wardId");
		}
		if (requestMap.get("adNo") != null) {
			adNo = (String) requestMap.get("adNo");
		}
		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}

		Criteria crit = null;
		try {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "P")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).createAlias("Patient",
					"pt").createAlias("Inpatient", "inPt").addOrder(
					Order.asc("SampleCollectionHeader.Id")).addOrder(
					Order.asc("SubChargecode.Id"));
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
			}
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("inPt.AdNo", adNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (wardId != 0) {
				crit = crit.createAlias("inPt.AdWardId", "wId");
				crit = crit.add(Restrictions.eq("wId.Id", wardId));
			}

			patientList = crit.list();

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				// DgResultEntryDetail dgResultEntryDetail =
				// patientList.get(0).getDgResultEntryDetails().iterator().next();

				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList.get(ilop).getSampleCollectionHeader()
							.getId().equals(
									patientList.get(ilop + 1)
											.getSampleCollectionHeader()
											.getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList.get(ilop).getSubChargecode().getId()
								.equals(
										patientList.get(ilop + 1)
												.getSubChargecode().getId())) {

							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}

	public Map<String, Object> searchFinalResultEntryDetailsLab(
			Map<String, Object> requestMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		int deptId = 0;
		String serviceNo = "";

		if (requestMap.get("serviceNo") != null) {
			serviceNo = (String) requestMap.get("serviceNo");
		}
		if (requestMap.get("hinNo") != null) {
			hinNo = (String) requestMap.get("hinNo");
		}
		if (requestMap.get("wardId") != null) {
			wardId = (Integer) requestMap.get("wardId");
		}
		if (requestMap.get("adNo") != null) {
			adNo = (String) requestMap.get("adNo");
		}
		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}

		Criteria crit = null;
		try {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", deptId)).createAlias("Patient",
					"pt").createAlias("Inpatient", "inPt").addOrder(
					Order.asc("SampleCollectionHeader.Id")).addOrder(
					Order.asc("SubChargecode.Id"));
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
			}
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("inPt.AdNo", adNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (wardId != 0) {
				crit = crit.createAlias("inPt.AdWardId", "wId");
				crit = crit.add(Restrictions.eq("wId.Id", wardId));
			}

			patientList = crit.list();

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				DgResultEntryDetail dgResultEntryDetail = patientList.get(0)
						.getDgResultEntryDetails().iterator().next();

				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ dgResultEntryDetail.getInvestigation()
								.getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList.get(ilop).getSampleCollectionHeader()
							.getId().equals(
									patientList.get(ilop + 1)
											.getSampleCollectionHeader()
											.getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList.get(ilop).getSubChargecode().getId()
								.equals(
										patientList.get(ilop + 1)
												.getSubChargecode().getId())) {

							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}

	public Map<String, Object> searchFinalResultEntryDetails(
			Map<String, Object> requestMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		// List<Integer> dgOrderhdIds =new ArrayList<Integer>();
		List<DgOrderhd> dgResultEntryList = new ArrayList<DgOrderhd>();
		// List<DgOrderhd> dgOrderhdListTemp = new ArrayList<DgOrderhd>();

		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		String serviceNo = "";

		if (requestMap.get("serviceNo") != null) {
			serviceNo = (String) requestMap.get("serviceNo");
		}
		if (requestMap.get("hinNo") != null) {
			hinNo = (String) requestMap.get("hinNo");
		}
		if (requestMap.get("wardId") != null) {
			wardId = (Integer) requestMap.get("wardId");
		}
		if (requestMap.get("adNo") != null) {
			adNo = (String) requestMap.get("adNo");
		}

		Criteria crit = null;
		try {
			crit = session.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "re").createAlias("re.Patient",
							"pt").createAlias("re.Inpatient", "inPt");
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
			}
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("inPt.AdNo", adNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (wardId != 0) {
				crit = crit.createAlias("inPt.AdWardId", "wId");
				crit = crit.add(Restrictions.eq("wId.Id", wardId));
			}
			crit = crit.createAlias("Investigation", "inv");
			crit = crit.createAlias("inv.MainChargecode", "mcc");
			crit = crit.add(Restrictions.eq("mcc.MainChargecodeCode", "Radio"));
			crit = crit.add(Restrictions.eq("ResultDetailStatus", "A"));

			dgResultEntryList = crit.list();
			map.put("dgResultEntryList", dgResultEntryList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getPatientHistory(Map<String, Object> requestMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		// List<Integer> dgOrderhdIds =new ArrayList<Integer>();
		List<DgResultEntryDetail> dgResultEntryDtList = new ArrayList<DgResultEntryDetail>();
		// List<DgOrderhd> dgOrderhdListTemp = new ArrayList<DgOrderhd>();

		String hinNo = "";
		String serviceNo = "";
		String adNo = "";
		int inpatientId = 0;
		int wardId = 0;
		int investigationId = 0;
		int hinId = 0;

		if (requestMap.get("investigationId") != null) {
			investigationId = (Integer) requestMap.get("investigationId");
		}
		if (requestMap.get("hinId") != null) {
			hinId = (Integer) requestMap.get("hinId");
		}

		Criteria crit = null;
		try {
			crit = session.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "re").add(
							Restrictions.eq("re.Patient.Id", hinId)).add(
							Restrictions.eq("re.ResultStatus", "A")).add(
							Restrictions
									.eq("Investigation.Id", investigationId))
					.addOrder(Order.desc("re.VerifiedOn"));

			dgResultEntryDtList = crit.list();
			map.put("dgResultEntryDtList", dgResultEntryDtList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> rejectTemplateSample(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = (Box)parameterMap.get("box");
		Vector sampleDetailId = box.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID_TEMPLATE);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			int orderHdId =0 ;
			if(sampleDetailId.size() > 0) {
				for (int i = 0; i < sampleDetailId.size(); i++) {
					System.out.println("rejec-------"+box.getString("sampleRejected"+i+1));
					if(! box.getString("sampleRejected"+i).equals("")) {
						DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
						.load(DgSampleCollectionDetails.class,Integer.parseInt((String) sampleDetailId.get(i)));
						dgDetails.setOrderStatus("P"); //R for rejected
						dgDetails.setRejected("y");
						hbt.update(dgDetails);
						hbt.refresh(dgDetails);
						
						int orderDtId = dgDetails.getOrderdt().getId();
						DgOrderdt orderdt = (DgOrderdt)hbt.load(DgOrderdt.class, orderDtId);
						orderdt.setOrderStatus("P");
						hbt.update(orderdt);
						orderHdId = orderdt.getOrderhd().getId();
						System.out.println("-----orderHdId-- "+orderHdId);
					}
				}
				if(orderHdId!=0){
				DgOrderhd orderhd = (DgOrderhd)hbt.load(DgOrderhd.class, orderHdId);
				orderhd.setOrderStatus("P");
				hbt.update(orderhd);
				}
			}
			tx.commit();
			map.put("saved", true);
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			map.put("saved", false);
		} catch (NumberFormatException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			map.put("saved", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> uploadInvDocuments(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
		String fileName = null;
		String fileExtension = null;
		/*String patientName = box.getString("patientName");
		String age = box.getString("age");
		String sex = box.getString("sex");*/
	/*	String hinNo = box.getString("hinNo");
		String address = box.getString("address");*/
		String hin_no = box.getString("hin_no");
		String diagNo = box.getString("diagNo");
		int hinId = box.getInt("hinId");
		int inpatientId = box.getInt("inpatientId");
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		String uploadURL = box.getString("uploadURL");
		String fileSeparator = box.getString("fileSeparator");
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			 hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			File file1 =  new File(box.getString("filename"));
    		String filename = file1.getName();
    		StringTokenizer strToken = new StringTokenizer(filename, ".");

        	fileName = strToken.nextToken();
        	fileExtension = strToken.nextToken();
        	
            List uploadDocumentList = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("FileName", fileName)).list();
            UploadDocuments uploadDocuments = new UploadDocuments();
            if(uploadDocumentList.size()==0)
            {
            	File file=null;
             	
            	file = new File(uploadURL+fileSeparator+hin_no +fileSeparator+filename);
            	File f = new File(uploadURL);
            	try {
            		if (f.exists()) {
            			f.delete();
            			f.mkdir();
            			FileInputStream is = new FileInputStream(file);
            			long length = file.length();

            			if (length > Integer.MAX_VALUE) {
            				// File is too large
            			}
            			// Create the byte array to hold the data
            			byte[] bytes = new byte[(int)length];
            			int offset = 0;
            			int numRead = 0;
            			while (offset < bytes.length
            					&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            				offset += numRead;
            			}

            			if (offset < bytes.length) {
            				throw new IOException("Could not completely read file "+file.getName());
            			}

            			uploadDocuments.setPatientDocument(bytes);
            			is.close();
            		} else {
            			f.mkdir();
            			FileInputStream is = new FileInputStream(file);
            			long length = file.length();
            			//ByteBuffer byteBuff=null;
            			//  int modLength=length/
            			if (length > Integer.MAX_VALUE) {
            				// File is too large
            			}
            			// Create the byte array to hold the data
            			byte[] bytes = new byte[(int)length];
            			int offset = 0;
            			int numRead = 0;
            			while (offset < bytes.length
            					&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            				offset += numRead;
            			}

            			if (offset < bytes.length) {
            				throw new IOException("Could not completely read file "+file.getName());
            			}
            			is.close();

            			uploadDocuments.setPatientDocument(bytes);
            		}

            		//fileExtension=strToken.nextToken();

            	} catch (Exception e) {
            		e.printStackTrace();
            	}

            	
               	uploadDocuments.setFileExtension(fileExtension);
            	uploadDocuments.setFileName(fileName);

            	if (hinId != 0) {
            		Patient patient = new Patient();
            		patient.setId(hinId);
            		uploadDocuments.setHin(patient);
            	}
            	if (box.getInt("visitId") != 0) {
            		Visit visit= new Visit();
            		visit.setId(box.getInt("visitId"));
            		uploadDocuments.setVisit(visit);
            	}
            	if (inpatientId != 0) {
            		Inpatient inpatient = new Inpatient();
            		inpatient.setId(inpatientId);
            		uploadDocuments.setInpatient(inpatient);
            	}
            	uploadDocuments.setDiagNo(diagNo);
            	uploadDocuments.setFwcFlag("diag");
            	uploadDocuments.setDescription(box.getString("description"));
            	uploadDocuments.setUploadDate(date);
            	uploadDocuments.setLastChgDate(date);
            	uploadDocuments.setLastChgTime(time);
            	//uploadDocuments.setLastChgBy(lastChgBy);
            	MasHospital masHospital = new MasHospital();
            	masHospital.setId(hospitalId);
            	uploadDocuments.setHospital(masHospital);
            	hbt.save(uploadDocuments);}
		
		    map.put("dataSaved", true);
		    map.put("uploadDocumentId", uploadDocuments.getId());
		}catch (Exception e) {
			e.printStackTrace();
			map.put("dataSaved", false);
		}
		
		return map;

	}

	@Override
	public Map<String, Object> viewUploadInvDocuments(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hinId = 0;
		int hospitalId = 0;
		int resultEntryId = 0;
		String hinNo="";
		String diagNo="";
		if(map.get("hinId")!=null){
			hinId = (Integer)map.get("hinId");
		}
		if(map.get("hospitalId")!=null){
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("resultEntryId")!=null){
			resultEntryId = (Integer)map.get("resultEntryId");
		}
		if(map.get("hinNo")!=null){
			hinNo = (String)map.get("hinNo");
		}
		if(map.get("diagNo")!=null){
			diagNo = (String)map.get("diagNo");
		}

		List<UploadDocuments> uploadDocList = new ArrayList<UploadDocuments>();
		
		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(UploadDocuments.class)
						.add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("Hospital.Id",hospitalId))
						.add(Restrictions.eq("DiagNo", diagNo));
			
		if(resultEntryId!=0){
			crit = crit.add(Restrictions.eq("ResultEntry.Id", resultEntryId));
			
		}
		uploadDocList = crit.list();
		dataMap.put("uploadDocList", uploadDocList);
		return dataMap;
	}

	@Override
	public Map<String, Object> uploadAndViewDocuments(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getResultGridForEmpanelled(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		
		Session session = (Session) getSession();
		Criteria crit = null;
		
		//uploadDocuments = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("Id", uploadedDocumentId)).list();
		uploadDocuments = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("Id", uploadedDocumentId)).list();
		
		
		return uploadDocuments;
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
	
	
	
	public Map<String,Object> getPendingListforRadiologyInvestigation(Box box)
	{
		Session session = (Session)getSession();
		Map<String,Object> map= new HashMap<String,Object>();
		
		
		Criteria cr = null;
		List<DgOrderdt> orderList = new ArrayList<DgOrderdt>();			
	
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int fromDepartment = box.getInt("fromDepartment");

		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));
		
		String flag="NA";  // flag=DX/CT/US
	
		flag = box.getString("flag");
		
		String empNo="NA";  // flag=DX/CT/US
		
		if(box.getString("empNo") !="")
		empNo = box.getString("empNo");
		
		
		
		
		
		cr = session.createCriteria(DgOrderdt.class)			
				.add(Restrictions.eq("MsgSent", "n").ignoreCase())	
				.createAlias("Orderhd", "hd")
				.add(Restrictions.eq("hd.Hospital.Id", hospitalId));
		
		if(flag.equalsIgnoreCase("DX"))
		{
			cr= cr.createAlias("SubChargeid", "modality").add(Restrictions.eq("modality.Id", 8));
		}
		if(flag.equalsIgnoreCase("CT"))
		{
			cr= cr.createAlias("SubChargeid", "modality").add(Restrictions.eq("modality.Id", 9));
		}
		if(flag.equalsIgnoreCase("US"))
		{
			cr= cr.createAlias("SubChargeid", "modality").add(Restrictions.eq("modality.Id", 10));
		}
		if(!empNo.equalsIgnoreCase("NA"))
		{
			cr= cr.createAlias("hd.Hin", "patient").add(Restrictions.eq("patient.ServiceNo", empNo));
		}
			
		cr= cr.addOrder(Order.asc("Createdon"));
				
		  
		
			
	
		orderList = cr.list();		
		 	    
		    List totalMatches = cr.list();
		    cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		    cr = cr.setMaxResults(pagingSize);
		    orderList = cr.list();
		    
		    int totalRecords = totalMatches.size();
		    totalMatches.clear();
		    	    
		    map.put("totalRecords", Integer.valueOf(totalRecords));
		    map.put("orderList", orderList);
		
		
		return map;
		
	}

	@Override
	public Map<String, Object> markCompleteRadiologyInvestigation(Box box) {
		
		Map<String,Object> datamap = new HashMap<String,Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		Transaction tx = null;
		hbt.setCheckWriteOperations(false);
		boolean flag=false;
		
		Users user = new Users();
		user.setId(box.getInt("userId"));
		int Id= box.getInt("Id");	
		
		String var = box.getString("var");	
		String invDate = box.getString("invDate");
		
		if(var.equalsIgnoreCase("complete"))
				{
						DgOrderdt orderDt = (DgOrderdt) hbt.get(DgOrderdt.class, Id);
						
						if(orderDt !=null)
						{
							orderDt.setMsgSent("C");
							orderDt.setOrderStatus("C");
							orderDt.setLastChgBy(user);
							orderDt.setLastChgDate(new Date());
							hbt.update(orderDt);
							hbt.refresh(orderDt);
							datamap.put("flag", "C");
						}
						else
						{
							datamap.put("flag", "n");
						}
				}
		
		if(var.equalsIgnoreCase("reschedule"))
				{
						DgOrderdt orderDt = (DgOrderdt) hbt.get(DgOrderdt.class, Id);
						
						if(orderDt !=null)
						{
							orderDt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(invDate));
							orderDt.setLastChgBy(user);
							
							hbt.update(orderDt);
							hbt.refresh(orderDt);
							datamap.put("flag", "C");
						}
						else
						{
							datamap.put("flag", "n");
						}
				}
	
		
		
				
		return datamap;
	}
	
	
	public Map<String, Object> getPatientDetailsForResultUpdationLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = null;
		/*String fromDateString = HMSUtil
				.convertDateToStringWithoutTime(new Date());
		fromDate = HMSUtil.convertStringTypeDateToDateType(fromDateString);*/

		Date toDate = null;
		/*String toDateString = HMSUtil
				.convertDateToStringWithoutTime(new Date());
		toDate = HMSUtil.convertStringTypeDateToDateType(toDateString);*/

		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int hospitalId = 0;
		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		String barCodeOrderNo="";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null)
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		// String FromDateString =
		// HMSUtil.convertDateToStringWithoutTime(fromDate);
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		
		if (mapForDs.get("barCodeOrderNo") != null) {
			barCodeOrderNo = (String) mapForDs.get("barCodeOrderNo");

		}
		
		System.out.println("departmentId="+departmentId);
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("MasHospital.Id", hospitalId))
					.createAlias("Patient", "pt");
			
			if(fromDate != null && toDate !=null)
			{
				crit.add(Restrictions.between("ResultDate", fromDate, toDate));
			}
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"Department", "dept").add(Restrictions.eq("MasHospital.Id", hospitalId));
			
			crit = crit.createAlias("Patient", "pt");
		}

		
		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
		}

		
		System.out.println("barCodeOrderNo="+barCodeOrderNo);
		if (!barCodeOrderNo.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or").add(
							Restrictions.eq("or.OrderNo", barCodeOrderNo));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id")).addOrder(
				Order.asc("SubChargecode.Id"));
        if(!barCodeOrderNo.equals("") || !serviceNo.equals(""))
		patientList = crit.list();
		/*
		 * Date sampleCollDate = new Date(); for(DgResultEntryHeader
		 * dgResultEntryHeader : patientList){
		 * if(dgResultEntryHeader.getResultType() != null &&
		 * dgResultEntryHeader.getResultType().equalsIgnoreCase("S")){
		 * Set<DgResultEntryDetailSen> dgResultEntrySet =
		 * dgResultEntryHeader.getDgResultEntryDetailSen();
		 * DgResultEntryDetailSen dgResultEntryDetailSen =
		 * dgResultEntrySet.iterator().next(); DgSampleCollectionDetails
		 * dgSampleCollectionDetails =
		 * dgResultEntryDetailSen.getSampleCollection(); Date
		 * sampleCollectionDate =
		 * dgSampleCollectionDetails.getSampleCollDatetime();
		 * 
		 * sampleCollDateString =
		 * HMSUtil.convertDateToStringWithoutTime(sampleCollectionDate);
		 * sampleCollDate =
		 * HMSUtil.convertStringTypeDateToDateType(sampleCollDateString); if(
		 * (sampleCollDate.compareTo(fromDate) >=0 &&
		 * sampleCollDate.compareTo(toDate)<=0) ){
		 * patientListTemp.add(dgResultEntryHeader); } }else{
		 * Set<DgResultEntryDetail> dgResultEntrySet =
		 * dgResultEntryHeader.getDgResultEntryDetails(); DgResultEntryDetail
		 * dgResultEntryDetail = dgResultEntrySet.iterator().next();
		 * DgSampleCollectionDetails dgSampleCollectionDetails =
		 * dgResultEntryDetail.getSampleCollectionDetails(); Date
		 * sampleCollectionDate =
		 * dgSampleCollectionDetails.getSampleCollDatetime();
		 * 
		 * sampleCollDateString =
		 * HMSUtil.convertDateToStringWithoutTime(sampleCollectionDate);
		 * sampleCollDate =
		 * HMSUtil.convertStringTypeDateToDateType(sampleCollDateString); if(
		 * (sampleCollDate.compareTo(fromDate) >=0 &&
		 * sampleCollDate.compareTo(toDate)<=0) ){
		 * patientListTemp.add(dgResultEntryHeader); } } } patientList =
		 * patientListTemp;
		 */

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		if (patientList.size() > 0) {
			patientListSubDepartWise.add(patientList.get(0));
			stringOfIds = stringOfIds + patientList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ patientList.get(0).getSubChargecode().getId();

			stringOfIdsList.add(stringOfIds);
			stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
				if (!patientList.get(ilop).getSampleCollectionHeader().getId()
						.equals(
								patientList.get(ilop + 1)
										.getSampleCollectionHeader().getId())) {

					patientListSubDepartWise.add(patientList.get(ilop + 1));
					stringOfIdsList.add(patientList.get(ilop + 1).getId()
							.toString());
					stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
							.getSubChargecode().getId().toString());
				} else {
					if (!patientList.get(ilop).getSubChargecode().getId()
							.equals(
									patientList.get(ilop + 1)
											.getSubChargecode().getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						int ii = stringOfIdsList.size() - 1;
						stringOfIds = stringOfIdsList.get(ii);
						stringOfIdsList.remove(ii);
						stringOfIds = stringOfIds + ","
								+ patientList.get(ilop + 1).getId().toString();
						stringOfIdsList.add((ii), stringOfIds);
					}
				}
			}
		}

		patientList = patientListSubDepartWise;
		map.put("patientDetailsList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultEntryDetailsLabForUpdation(
			Map<String, Object> requestMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultHeaderId = 0;
		int fixedId = 0;
		int deptId = 0;
		String resultId = "";
		String stringOfIds = "";
		Integer stringSubDeptIds = 0;
		int hospitalId = 0;
		String[] idsArray = new String[0];
		String[] headerIdsValue = new String[0];

		List<Integer> headerIdsInt = new ArrayList<Integer>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();

		if (requestMap.get("resultId") != null) {
			resultId = (String) requestMap.get("resultId");
		}
		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}
		if (requestMap.get("hospitalId") != null) {
			hospitalId = (Integer) requestMap.get("hospitalId");
		}
		/*
		 * if(resultIdToRemove != 0){ if(!resultId.equals("")){ idsArray =
		 * resultId.split("@"); stringOfIds = idsArray[0]; stringSubDeptIds =
		 * Integer.parseInt(idsArray[1]);
		 * 
		 * //System.out.println("String Of Ids :"+stringOfIds); headerIdsValue =
		 * stringOfIds.split(","); for(String id : headerIdsValue ){
		 * headerIdsInt.add(Integer.parseInt(id)); } } }else{
		 */
		if (!resultId.equals("")) {
			idsArray = resultId.split("@");
			stringOfIds = idsArray[0];
			stringSubDeptIds = Integer.parseInt(idsArray[1]);

			headerIdsValue = stringOfIds.split(",");
			for (String id : headerIdsValue) {
				headerIdsInt.add(Integer.parseInt(id));
			}
		}
		// }
		try {
		/*	employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();*/
			/*employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}*/
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.in("Id", headerIdsInt)).add(
					Restrictions.eq("SubChargecode.Id", stringSubDeptIds)).add(
					Restrictions.eq("ResultStatus", "A")).createAlias(
					"DgMasInvestigation", "inv").addOrder(
					Order.asc("inv.TestOrderNo")).add(Restrictions.eq("MasHospital.Id", hospitalId)).list();

			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					resultHeaderId = dgResultHeader.getId();
				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "A"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session.createCriteria(
							DgResultEntryDetailSen.class).createAlias(
							"ResultEntry", "rs").add(
							Restrictions.eq("rs.Id", resultHeaderId)).list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}

				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
/*						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
*/						fixedValList=session.createCriteria(DgFixedValue.class).add(Restrictions.eq("SubInvestigation.Id", fixedId)).add(Restrictions.isNotNull("FixedValue")).list();
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
}
