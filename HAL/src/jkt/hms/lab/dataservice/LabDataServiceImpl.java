package jkt.hms.lab.dataservice;

import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.COLLECTION_CENTER_ID;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.CONTAINER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DG_SAMPLE_DETAIL_ID;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_NO;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ID;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING_ID;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.REASON;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VALIDATED;

import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgFixedValue;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
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
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.DischargeSummary;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PhysioRequisitionDetail;
import jkt.hms.masters.business.PhysioRequisitionHeader;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LabDataServiceImpl extends HibernateDaoSupport implements
		LabDataService {

	

	private static final String SAMPLE_ID = null;
	private static final String COLLECTED = null;
	private static final String EMPANELLED = null;
	

	// -------------------------method of Show Order Booking Screen For
	// IP----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showOrderBookingJsp(Map<String, Object> map) {
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();

		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		int inPatientId = 0;
		int deptId = (Integer) map.get("deptId");
		if (map.get("inPatientId") != null) {
			inPatientId = (Integer) map.get("inPatientId");
		}
		int orderHdId = 0;
		String adNo = "";
		String flagForUpdate = "";

		if (map.get("A&DNo") != null) {
			adNo = (String) map.get("A&DNo");
		}
		if (map.get("flagForUpdate") != null) {
			flagForUpdate = (String) map.get("flagForUpdate");
		}
		if (map.get("orderHdId") != null) {
			orderHdId = (Integer) map.get("orderHdId");
		}

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List orderNo = new ArrayList();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (inPatientId == 0) {
				if (!adNo.equals("")) {
					inPatientDetailList = session.createCriteria(
							Inpatient.class).add(Restrictions.eq("AdNo", adNo))
							.list();
				}
			} else if (inPatientId != 0) {
				inPatientDetailList = session.createCriteria(Inpatient.class)
						.add(Restrictions.eq("Id", inPatientId)).list();
			}

			orderNo = session.createQuery(
					"select syd from DgOrderhd as syd where syd.Department.Id="
							+ deptId).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			if (inPatientDetailList != null && inPatientDetailList.size() > 0) {
				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
				admissionNumber = inpatient.getAdNo();
			}
			if (flagForUpdate.equals("upatedOrderBooking")) {
				orderHdList = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Id", orderHdId)).list();
				String orderSeqNo = orderHdList.get(0).getOrderNo();
				DgOrderhd dgOrderhd = orderHdList.get(0);
				if (dgOrderhd.getPatientType().equalsIgnoreCase("OP")) {
					icdList = session.createCriteria(DischargeIcdCode.class)
							.createAlias("Visit", "v").add(
									Restrictions.eq("v.Id", dgOrderhd
											.getVisit().getId())).list();
				}
				map.put("orderHdListForUpdate", orderHdList);
				map.put("orderSeqNo", orderSeqNo);
			} else {
				if (map.get("buttonFlag") != null) {
					int orderSeqNo = (Integer) map.get("orderSeqNo");
					map.put("orderSeqNo", orderSeqNo);
				} else {
					if (orderNo.size() > 0) {
						DgOrderhd dgOrderhd = (DgOrderhd) orderNo.get(0);
						String orderSeqNo = dgOrderhd.getOrderNo();
						orderSeqNo = orderSeqNo + 1;
						map.put("orderSeqNo", orderSeqNo);
					}
				}
			}

			templateList = session.createCriteria(OpdTemplate.class)
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", 48)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("orderNo", orderNo);
		map.put("icdList", icdList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("employeeList", employeeList);
		map.put("templateList", templateList);
		return map;
	}

	public Map<String, Object> showAllOrdersForInPatientJsp(
			Map<String, Object> map) {
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		int deptId = (Integer) map.get("deptId");
		int inPatientId = (Integer) map.get("inPatientId");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List orderNo = new ArrayList();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inPatientId)).list();
			orderNo = session.createQuery(
					"select syd from DgOrderhd as syd where syd.Department.Id="
							+ deptId).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			if (inPatientDetailList != null) {
				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
				admissionNumber = inpatient.getAdNo();
			}
			if (map.get("buttonFlag") != null) {
				int orderSeqNo = (Integer) map.get("orderSeqNo");
				map.put("orderSeqNo", orderSeqNo);
			} else {
				if (orderNo.size() > 0) {
					DgOrderhd dgOrderhd = (DgOrderhd) orderNo.get(0);
					String orderSeqNo = dgOrderhd.getOrderNo();
					orderSeqNo = orderSeqNo + 1;
					map.put("orderSeqNo", orderSeqNo);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("orderNo", orderNo);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("employeeList", employeeList);
		return map;
	}

	// -----------------------Method For Get Main Charge
	// Code--------------------------

	public Map<String, Object> getMainChargeCode(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> mainChargeCodeList = new ArrayList<MasChargeCode>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Session session = (Session) getSession();
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).add(
							Restrictions.eq("MainChargecodeName", str)).list();
			if (mainChargeCodeList.size() > 0) {
				detailsMap.put("mainChargeCodeList", mainChargeCodeList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * fillItemsForMainChargeCode(Map<String, Object> dataMap) { Map<String,
	 * Object> map = new HashMap<String, Object>();
	 * 
	 * List<MasMainChargecode> mainChargeList= new
	 * ArrayList<MasMainChargecode>(); Session session = (Session)getSession();
	 * String mainChargeName=(String)dataMap.get("mainChargeName"); try {
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); mainChargeList =
	 * session.createCriteria
	 * (MasMainChargecode.class).add(Restrictions.eq("MainChargecodeName",
	 * mainChargeName)).list(); map.put("mainChargeList", mainChargeList);
	 * }catch(Exception e) { e.printStackTrace(); } return map; }
	 */
	// --------------------------- Method to get MainChargeCode & SubChargeCode
	// List-----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getMainAndSubCharge() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();

		Session session = (Session) getSession();
		try {
			List lst = new ArrayList();
			lst.add("DIAG");
			lst.add("RADIO");
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).add(
							Restrictions.eq("Status", "y")).createAlias(
							"Department", "dept").createAlias(
							"dept.DepartmentType", "dt").add(
							Restrictions.in("dt.DepartmentTypeCode", lst))
					.list();
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).list();
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Status", "y")).list();

			if (mainChargeCodeList.size() > 0) {
				detailsMap.put("mainChargeCodeList", mainChargeCodeList);
			}
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// --------------------------- Method to get charge code for
	// autocomplete-----------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();

		int subChargeCodeId = 0;
		int mainChargeCodeId = 0;
		String str = "";
		if (parameterMap.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) parameterMap.get("subChargeCodeId");
		}
		if (parameterMap.get("mainChargeCodeId") != null) {
			mainChargeCodeId = (Integer) parameterMap.get("mainChargeCodeId");
		}
		if (parameterMap.get("autoHint") != null) {
			str = "%" + parameterMap.get("autoHint") + "%";
		}
		/**
		 * Modified By Rajesh Kumar On 29 nov 2008 Code is modified to get ajax
		 * list in order booking screen in Test code column of grid List get
		 * data from Investigation master
		 */
		try {
			Session session = (Session) getSession();
			if (subChargeCodeId != 0) {
				// chargeCodeList =
				// session.createCriteria(DgMasInvestigation.class).add(Restrictions.like("InvestigationName",
				// str)).list();
				// chargeCodeList =
				// session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeCode",
				// str)).createAlias("SubChargecode",
				// "scc").add(Restrictions.eq("scc.Id",
				// subChargeCodeId)).createAlias("ChargeType",
				// "ct").add(Restrictions.eq("ct.ChargeTypeName",
				// "Diagnostic")).list();
				chargeCodeList = session.createCriteria(
						DgMasInvestigation.class).add(
						Restrictions.like("InvestigationName", str).ignoreCase())
						.createAlias("SubChargecode", "scc").add(
								Restrictions.eq("scc.Id", subChargeCodeId))
						.list();

			} else if (mainChargeCodeId != 0) {
				try {
					// chargeCodeList =
					// session.createCriteria(DgMasInvestigation.class).add(Restrictions.like("InvestigationName",
					// str)).list();
					// chargeCodeList =
					// session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeCode",
					// str)).createAlias("MainChargecode",
					// "mcc").add(Restrictions.eq("mcc.Id",
					// mainChargeCodeId)).createAlias("ChargeType",
					// "ct").add(Restrictions.eq("ct.ChargeTypeName",
					// "Diagnostic")).list();
					chargeCodeList = session.createCriteria(
							DgMasInvestigation.class).add(
							Restrictions.like("InvestigationName", str).ignoreCase())
							.createAlias("MainChargecode", "mcc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.list();

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} else if (subChargeCodeId == 0 && mainChargeCodeId == 0) {
				// chargeCodeList =
				// session.createCriteria(DgMasInvestigation.class).add(Restrictions.like("InvestigationName",
				// str)).list();
				// chargeCodeList =
				// session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeCode",
				// str)).createAlias("ChargeType",
				// "ct").add(Restrictions.eq("ct.ChargeTypeName",
				// "Diagnostic")).list();
				chargeCodeList = session.createCriteria(
						DgMasInvestigation.class).add(
						Restrictions.like("InvestigationName", str).ignoreCase()).list();

			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeList", chargeCodeList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// --------------------------- Method to fill details in grid for Charge
	// code -----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List chargeList = new ArrayList();
		Session session = (Session) getSession();
		String chargeCode = (String) dataMap.get("chargeCode");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			chargeList = session.createCriteria(DgMasInvestigation.class).add(
					Restrictions.eq("InvestigationName", chargeCode)).list();
			map.put("chargeList", chargeList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// public Map<String, Object> fillItemsForChargeCode(Map<String, Object>
	// dataMap) {
	// Map<String, Object> map = new HashMap<String, Object>();
	//		
	// List chargeList= new ArrayList();
	// Session session = (Session)getSession();
	// String chargeCode=(String)dataMap.get("chargeCode");
	// try {
	// org.springframework.orm.hibernate3.HibernateTemplate hbt =
	// getHibernateTemplate();
	// hbt.setFlushModeName("FLUSH_EAGER");
	// hbt.setCheckWriteOperations(false);
	// chargeList =
	// session.createCriteria(MasChargeCode.class).add(Restrictions.eq("ChargeCodeCode",
	// chargeCode)).list();
	// map.put("chargeList", chargeList);
	//			
	// }catch(Exception e)
	// {
	// e.printStackTrace();
	// }
	// return map;
	// }
	// --------------------------- Method to submit Order Booking of
	// IP-----------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitOrderBooking(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		List chargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List mainChargeList = new ArrayList();
		List qtyList = new ArrayList();
		boolean success = false;
		Box box = null;
		int chargeMainIdFromRequest = 0;
		int dgOrderhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;
		int deptId = 0;
		String orderSeqNo = "";
		String createdBy = "";
		String userName = "";
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd");
		}
		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		if (infoMap.get("mainChargeList") != null) {
			mainChargeList = (List) infoMap.get("mainChargeList");
		}
		if (infoMap.get("subChargeList") != null) {
			subChargeList = (List) infoMap.get("subChargeList");
		}
		if (infoMap.get("userId") != null) {
			userId = (Integer) infoMap.get("userId");
			
		}
		if (infoMap.get("chargeMainIdFromRequest") != null) {
			chargeMainIdFromRequest = (Integer) infoMap
					.get("chargeMainIdFromRequest");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("deptId") != null) {
			deptId = (Integer) infoMap.get("deptId");
		}
		if (infoMap.get("createdBy") != null) {
			createdBy = (String) infoMap.get("createdBy");
		}
		if (infoMap.get("placedBy") != null) {
			createdBy = (String) infoMap.get("placedBy");
		}
		if (infoMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) infoMap.get("orderSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("dgOrderhd") != null) {
				dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd");
				hbt.save(dgOrderhd);
				dgOrderhdId = dgOrderhd.getId();
				map.put("dgOrderhdId", dgOrderhdId);
			} else {

				DgOrderhd dgOrderhdObj = new DgOrderhd();
				dgOrderhdObj = (DgOrderhd) hbt.load(DgOrderhd.class,
						chargeMainIdFromRequest);
				hbt.update(dgOrderhdObj);
			}
			int mainChargeId = 0;
			if (infoMap.get("chargeList") != null) {
				chargeList = (List) infoMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {

						DgOrderdt dgOrderdt = new DgOrderdt();
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();

						try {
							if (chargeList.get(i) != null
									&& !chargeList.get(i).equals("")) {
								int chargeId = Integer.parseInt(chargeList.get(
										i).toString());
								masChargeCode.setId(chargeId);
								dgOrderdt.setChargeCode(masChargeCode);

								dgOrderdt
										.setInvestigation(new DgMasInvestigation(
												chargeId));

								if (mainChargeList.get(i) != null
										&& !mainChargeList.get(i).equals("")) {
									mainChargeId = Integer
											.parseInt(mainChargeList.get(i)
													.toString());
									masMainChargecode.setId(mainChargeId);
									dgOrderdt
											.setMainChargecode(masMainChargecode);
								}

								if (subChargeList.get(i) != null
										&& !subChargeList.get(i).equals("")) {
									int subChargeId = Integer
											.parseInt(subChargeList.get(i)
													.toString());
									masSubChargecode.setId(subChargeId);
									dgOrderdt.setSubChargeid(masSubChargecode);
								}
								if (qtyList.get(i) != null
										&& !qtyList.get(i).equals("")) {
									int qty = Integer.parseInt(""
											+ qtyList.get(i));
									dgOrderdt.setOrderQty(qty);
									dgOrderdt.setCreatedby(createdBy);
									dgOrderdt
											.setCreatedon(HMSUtil
													.convertStringTypeDateToDateType(date));
									
									Users user = new Users();
									user.setId(userId);
									dgOrderdt.setLastChgBy(user);
									dgOrderdt
											.setLastChgDate(HMSUtil
													.convertStringTypeDateToDateType(date));
									dgOrderdt.setLastChgTime(time);
									dgOrderdt.setOrderStatus("P");
									if (infoMap.get("dgOrderhd") != null) {
										dgOrderdt.setOrderhd(dgOrderhd);

									} else {
										DgOrderhd dgOrderheader = new DgOrderhd();
										dgOrderheader
												.setId(chargeMainIdFromRequest);
										dgOrderdt.setOrderhd(dgOrderheader);
									}
								}
								hbt.save(dgOrderdt);

							}

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}
			// ----------Saving Data in DgSampleCollection's Table where
			// MainCharge is RADIOLOGY-----------------------------
			Vector charge_code_Id = box.getVector(CHARGE_CODE_ID);
			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			Session session = (Session) getSession();
			int chargeCodeId = Integer.parseInt("" + charge_code_Id.get(0));
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Id", chargeCodeId)).list();

			if (chargeCodeList.size() > 0) {
				for (MasChargeCode chargeCode : chargeCodeList) {
					if (chargeCode.getMainChargecode().getDepartment()
							.getDepartmentType().getDepartmentTypeCode()
							.equals("RADIO")) {
						try {
							int inpatientId = 0;
							if (box.getInt(INPATIENT_ID) != 0) {
								inpatientId = box.getInt(INPATIENT_ID);
								Inpatient inpatient = new Inpatient();
								inpatient.setId(inpatientId);
								dgSampleCollectionHeader
										.setInpatient(inpatient);

							}
							int hinId = box.getInt(HIN_ID);

							int collectionCenterId = box
									.getInt(COLLECTION_CENTER_ID);
							if (hinId != 0) {
								Patient patient = new Patient();
								patient.setId(hinId);
								dgSampleCollectionHeader.setHin(patient);
							}
							if (hospitalId != 0) {
								MasHospital hospital = new MasHospital();
								hospital.setId(hospitalId);
								dgSampleCollectionHeader.setHospital(hospital);
							}

							if (departmentId != 0) {
								MasDepartment masDepartment = new MasDepartment();
								masDepartment.setId(chargeCode
										.getMainChargecode().getDepartment()
										.getId());
								dgSampleCollectionHeader
										.setDepartment(masDepartment);
							}

							if (departmentId != 0) {
								MasDepartment orderByDepartment = new MasDepartment();
								orderByDepartment.setId(departmentId);
								dgSampleCollectionHeader
										.setOrderByDepartment(orderByDepartment);
							}

							dgSampleCollectionHeader.setOrder(dgOrderhd);

							if (collectionCenterId != 0) {
								DgCollectionCenter dgCollectionCenter = new DgCollectionCenter();
								dgCollectionCenter.setId(collectionCenterId);
								dgSampleCollectionHeader
										.setCollectionCenter(dgCollectionCenter);
							}

							dgSampleCollectionHeader.setOrderStatus("P");
							dgSampleCollectionHeader.setLastChgBy(userName);
							dgSampleCollectionHeader.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							dgSampleCollectionHeader.setLastChgTime(time);
							dgSampleCollectionHeader.setDiagnosisDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							dgSampleCollectionHeader.setDiagnosisTime(time);
							hbt.save(dgSampleCollectionHeader);

						} catch (DataAccessException e) {
							e.printStackTrace();
						}
						try {

							int collectedBy = box.getInt(EMPLOYEE_ID);
							for (int i = 0; i < charge_code_Id.size(); i++) {
								int chargeId = 0;
								if (charge_code_Id.get(i) != null
										&& !charge_code_Id.get(i).equals("")) {
									MasChargeCode masChargeCode = new MasChargeCode();
									MasSubChargecode masSubChargecode = new MasSubChargecode();

									DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
									dgSampleCollectionDetails
											.setSampleCollectionHeader(dgSampleCollectionHeader);

									dgSampleCollectionDetails.setCollected("y");

									masChargeCode.setId(Integer
											.parseInt((String) charge_code_Id
													.get(i)));
									dgSampleCollectionDetails
											.setChargeCode(masChargeCode);
									chargeId = Integer
											.parseInt((String) charge_code_Id
													.get(i));
									MasMainChargecode masMainChargecode = new MasMainChargecode();
									masMainChargecode.setId(mainChargeId);
									dgSampleCollectionDetails
											.setMaincharge(masMainChargecode);

									if (subChargeList.get(i) != null
											&& !subChargeList.get(i).equals("")) {
										masSubChargecode
												.setId(Integer
														.parseInt((String) subChargeList
																.get(i)));
										dgSampleCollectionDetails
												.setSubcharge(masSubChargecode);
									}
									MasEmployee masEmployee = new MasEmployee();
									masEmployee.setId(collectedBy);
									dgSampleCollectionDetails
											.setCollectedBy(masEmployee);

									dgSampleCollectionDetails
											.setDiagNo(generateDiagNumber(Integer
													.parseInt((String) subChargeList
															.get(i))));

									dgSampleCollectionDetails
											.setInvestigation(new DgMasInvestigation(
													chargeId));
									dgSampleCollectionDetails
											.setLastChgBy(userName);
									dgSampleCollectionDetails
											.setLastChgDate(HMSUtil
													.convertStringTypeDateToDateType(date));
									dgSampleCollectionDetails
											.setLastChgTime(time);
									dgSampleCollectionDetails
											.setSampleCollDatetime(new Date());
									dgSampleCollectionDetails
											.setOrderStatus("P");
									try {
										hbt.save(dgSampleCollectionDetails);
									} catch (RuntimeException e) {
										e.printStackTrace();
									}
								}
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
				}
			}
			success = true;
			map.put("success", success);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		map.put("orderSeqNo", orderSeqNo);
		return map;
	}

	// ----------------------Method For Patient Name on the basis of Service
	// number------------
	@SuppressWarnings("unchecked")
	public List<Patient> getPatientName(String serviceNo) {
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(
					Restrictions.eq("PatientStatus", "Out Patient")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	// ----------------------Method For IPD Patient Name on the basis of Service
	// number------------
	@SuppressWarnings("unchecked")
	public List<Patient> getIPDPatientName(String serviceNo) {
		List<Patient> inPatientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {
			// Criteria crit =
			// session.createCriteria(Inpatient.class).add(Restrictions.eq("AdStatus",
			// "A"));
			// crit.createAlias("Hin", "hin")
			// .add(Restrictions.eq("hin.PatientStatus", "In Patient"))
			// .add(Restrictions.eq("hin.ServiceNo",serviceNo))
			// .setProjection(Projections.property("hin"));
			//	
			// inPatientList = crit.list();

			// inPatientList =
			// session.createCriteria(Inpatient.class).add(Restrictions.eq("ServiceNo",
			// serviceNo))
			// .add(Restrictions.eq("PatientStatus", "Out Patient")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return inPatientList;
	}

	// ----------------------Method For Visit Number on the basis of Patient
	// Name-------------
	@SuppressWarnings("unchecked")
	public List<Visit> getVisitNo(int hinId) {
		Session session = (Session) getSession();
		List<Visit> visitNoList = new ArrayList<Visit>();
		@SuppressWarnings("unused")
		Visit visit = new Visit();
		visitNoList = session.createCriteria(Visit.class).createAlias("Hin",
				"p").add(Restrictions.eq("p.Id", hinId)).list();

		return visitNoList;
	}

	// -------------------------Method For Show Order booking For
	// OP-------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showOrderBookingForInvestigationJsp(int visitNo) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Integer> maxVisitIdList = new ArrayList<Integer>();
		List<Visit> visitIdList = new ArrayList<Visit>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List orderNo = new ArrayList();
		int maxVisitId = 0;
		int doctorId = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			visitList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitNo)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();

			Visit visit = new Visit();
			visit = visitList.get(0);

			int hinId = visit.getHin().getId();
			try {
				maxVisitIdList = hbt
						.find("select max(v.Id) from jkt.hms.masters.business."
								+ "Visit v join v.Hin as p where p.Id = "
								+ hinId);
		//	maxVisitIdList=session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId)).list();
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			maxVisitId = maxVisitIdList.get(0);
			try {
				visitIdList = session.createCriteria(Visit.class).add(
						Restrictions.eq("Id", maxVisitId)).list();
				Visit lastVisit = new Visit();
				lastVisit = (Visit) visitIdList.get(0);
				if (lastVisit.getDoctor() != null) {
					doctorId = lastVisit.getDoctor().getId();
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Visit", "v").add(
							Restrictions.eq("v.Id", maxVisitId)).list();

			templateList = session.createCriteria(OpdTemplate.class)
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", 48)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("doctorId", doctorId);
		map.put("icdList", icdList);
		map.put("orderNo", orderNo);
		map.put("visitList", visitList);
		map.put("employeeList", employeeList);
		map.put("templateList", templateList);
		return map;
	}

	// --------------------------- Method to submit Order Booking of
	// OP-----------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitOrderBookingForInvestigation(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		List chargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List mainChargeList = new ArrayList();
		List qtyList = new ArrayList();
		boolean success = false;
		Box box = null;
		int chargeMainIdFromRequest = 0;
		int dgOrderhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;
		String orderSeqNo = "";
		String createdBy = "";
		String userName = "";
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd");
		}
		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		if (infoMap.get("mainChargeList") != null) {
			mainChargeList = (List) infoMap.get("mainChargeList");
		}
		if (infoMap.get("subChargeList") != null) {
			subChargeList = (List) infoMap.get("subChargeList");
		}
		if (infoMap.get("userId") != null) {
			userId = (Integer) infoMap.get("userId");
		}
		if (infoMap.get("chargeMainIdFromRequest") != null) {
			chargeMainIdFromRequest = (Integer) infoMap
					.get("chargeMainIdFromRequest");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("createdBy") != null) {
			createdBy = (String) infoMap.get("createdBy");
		}
		if (infoMap.get("placedBy") != null) {
			createdBy = (String) infoMap.get("placedBy");
		}
		if (infoMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) infoMap.get("orderSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Session session = (Session) getSession();
		Transaction tx = null;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			if (infoMap.get("dgOrderhd") != null) {
				dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd");
				hbt.save(dgOrderhd);
				dgOrderhdId = dgOrderhd.getId();
				map.put("dgOrderhdId", dgOrderhdId);
			} else {

				DgOrderhd dgOrderhdObj = new DgOrderhd();
				dgOrderhdObj = (DgOrderhd) hbt.load(DgOrderhd.class,
						chargeMainIdFromRequest);
				
				hbt.update(dgOrderhdObj);
			}
			int mainChargeId = 0;
			if (infoMap.get("chargeList") != null) {
				chargeList = (List) infoMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {

						DgOrderdt dgOrderdt = new DgOrderdt();
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();

						try {
							if (chargeList.get(i) != null
									&& !chargeList.get(i).equals("")) {
								int chargeId = Integer.parseInt(chargeList.get(
										i).toString());
								MasChargeCode maschrgCode = (MasChargeCode) session
										.createCriteria(MasChargeCode.class)
										.add(Restrictions.eq("Id", chargeId))
										.list().get(0);
								if (maschrgCode.getMainChargecode()
										.getMainChargecodeCode()
										.equalsIgnoreCase("Lab")) {
									dgOrderdt.setOrderStatus("P");
								} else {
									dgOrderdt.setOrderStatus("P");
								}
								dgOrderdt.setChargeCode(maschrgCode);

								// masChargeCode.setId(chargeId);
								// dgOrderdt.setChargeCode(masChargeCode);

								dgOrderdt
										.setInvestigation(new DgMasInvestigation(
												chargeId));

								if (mainChargeList.get(i) != null
										&& !mainChargeList.get(i).equals("")) {
									mainChargeId = Integer
											.parseInt(mainChargeList.get(i)
													.toString());
									masMainChargecode.setId(mainChargeId);
									dgOrderdt
											.setMainChargecode(masMainChargecode);
								}

								if (subChargeList.get(i) != null
										&& !subChargeList.get(i).equals("")) {
									int subChargeId = Integer
											.parseInt(subChargeList.get(i)
													.toString());
									masSubChargecode.setId(subChargeId);
									dgOrderdt.setSubChargeid(masSubChargecode);
								}
								// if (qtyList.get(i) != null &&
								// !qtyList.get(i).equals("")) {
								// int qty = Integer.parseInt(""+
								// qtyList.get(i));
								// dgOrderdt.setOrderQty(qty);
								dgOrderdt.setCreatedby(createdBy);
								dgOrderdt.setCreatedon(HMSUtil
										.convertStringTypeDateToDateType(date));
								Users user = new Users();
								user.setId(userId);
								
								dgOrderdt.setLastChgBy(user);
								dgOrderdt.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								dgOrderdt.setLastChgTime(time);
								// dgOrderdt.setOrderStatus("P");
								if (infoMap.get("dgOrderhd") != null) {
									dgOrderdt.setOrderhd(dgOrderhd);

								} else {
									DgOrderhd dgOrderheader = new DgOrderhd();
									dgOrderheader
											.setId(chargeMainIdFromRequest);
									dgOrderdt.setOrderhd(dgOrderheader);
								}
								// }
								hbt.save(dgOrderdt);

							}

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}
			// ----------Saving Data in DgSampleCollection's Table where
			// MainCharge is RADIOLOGY-----------------------------
	/*		Vector charge_code_Id = box.getVector(CHARGE_CODE_ID);
			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			boolean goneInLoop = false;

			for (int j = 0; j < chargeList.size() && !goneInLoop; j++) {
				int chargeCodeId = Integer.parseInt("" + chargeList.get(j));
				chargeCodeList = session.createCriteria(MasChargeCode.class)
						.add(Restrictions.eq("Id", chargeCodeId)).createAlias(
								"MainChargecode", "mcc").createAlias(
								"mcc.Department", "dept").createAlias(
								"dept.DepartmentType", "dt").add(
								Restrictions.eq("dt.DepartmentTypeCode",
										"RADIO")).list();

				if (chargeCodeList.size() > 0) {
					for (MasChargeCode chargeCode : chargeCodeList) {
						try {
							int inpatientId = 0;
							int visitId = 0;
							if (box.getInt(INPATIENT_ID) != 0) {
								inpatientId = box.getInt(INPATIENT_ID);
								Inpatient inpatient = new Inpatient();
								inpatient.setId(inpatientId);
								dgSampleCollectionHeader
										.setInpatient(inpatient);
								dgSampleCollectionHeader.setPatientType("IP");
							} else if (box.getString(VISIT_ID) != null
									&& !box.getString(VISIT_ID).equals("")) {
								visitId = box.getInt(VISIT_ID);
								Visit visit = new Visit();
								visit.setId(visitId);
								dgSampleCollectionHeader.setVisit(visit);
								dgSampleCollectionHeader.setPatientType("OP");
							}
							int hinId = box.getInt(HIN_ID);

							int collectionCenterId = box
									.getInt(COLLECTION_CENTER_ID);
							if (hinId != 0) {
								Patient patient = new Patient();
								patient.setId(hinId);
								dgSampleCollectionHeader.setHin(patient);
							}
							if (hospitalId != 0) {
								MasHospital hospital = new MasHospital();
								hospital.setId(hospitalId);
								dgSampleCollectionHeader.setHospital(hospital);
							}

							if (departmentId != 0) {
								MasDepartment masDepartment = new MasDepartment();
								masDepartment.setId(chargeCode
										.getMainChargecode().getDepartment()
										.getId());
								dgSampleCollectionHeader
										.setDepartment(masDepartment);
							}

							if (departmentId != 0) {
								MasDepartment orderByDepartment = new MasDepartment();
								orderByDepartment.setId(departmentId);
								dgSampleCollectionHeader
										.setOrderByDepartment(orderByDepartment);
							}

							dgSampleCollectionHeader.setOrder(dgOrderhd);

							if (collectionCenterId != 0) {
								DgCollectionCenter dgCollectionCenter = new DgCollectionCenter();
								dgCollectionCenter.setId(collectionCenterId);
								dgSampleCollectionHeader
										.setCollectionCenter(dgCollectionCenter);
							}

							dgSampleCollectionHeader.setOrderStatus("P");
							dgSampleCollectionHeader.setLastChgBy(userName);
							dgSampleCollectionHeader.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							dgSampleCollectionHeader.setLastChgTime(time);
							dgSampleCollectionHeader.setDiagnosisDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							dgSampleCollectionHeader.setDiagnosisTime(time);
							hbt.save(dgSampleCollectionHeader);

						} catch (DataAccessException e) {
							e.printStackTrace();
						}
						try {

							int collectedBy = box.getInt(EMPLOYEE_ID);
							for (int i = 0; i < chargeList.size(); i++) {
								int chargeId = 0;
								if (chargeList.get(i) != null
										&& !chargeList.get(i).equals("")) {
									chargeId = Integer
											.parseInt((String) chargeList
													.get(i));
									MasChargeCode maschrgCode = (MasChargeCode) session
											.createCriteria(MasChargeCode.class)
											.add(
													Restrictions.eq("Id",
															chargeId)).list()
											.get(0);
									if (maschrgCode.getMainChargecode()
											.getMainChargecodeCode()
											.equalsIgnoreCase("RADIO")) {
										MasChargeCode masChargeCode = new MasChargeCode();
										MasSubChargecode masSubChargecode = new MasSubChargecode();

										DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
										dgSampleCollectionDetails
												.setSampleCollectionHeader(dgSampleCollectionHeader);

										dgSampleCollectionDetails
												.setCollected("y");

										masChargeCode.setId(Integer
												.parseInt((String) chargeList
														.get(i)));
										dgSampleCollectionDetails
												.setChargeCode(masChargeCode);

										MasMainChargecode masMainChargecode = new MasMainChargecode();
										masMainChargecode.setId(maschrgCode
												.getMainChargecode().getId());
										dgSampleCollectionDetails
												.setMaincharge(masMainChargecode);

										if (subChargeList.get(i) != null
												&& !subChargeList.get(i)
														.equals("")) {
											masSubChargecode
													.setId(Integer
															.parseInt((String) subChargeList
																	.get(i)));
											dgSampleCollectionDetails
													.setSubcharge(masSubChargecode);
										}
										MasEmployee masEmployee = new MasEmployee();
										masEmployee.setId(collectedBy);
										dgSampleCollectionDetails
												.setCollectedBy(masEmployee);

										dgSampleCollectionDetails
												.setDiagNo(generateDiagNumber(Integer
														.parseInt((String) subChargeList
																.get(i))));

										dgSampleCollectionDetails
												.setInvestigation(new DgMasInvestigation(
														chargeId));
										dgSampleCollectionDetails
												.setLastChgBy(userName);
										dgSampleCollectionDetails
												.setLastChgDate(HMSUtil
														.convertStringTypeDateToDateType(date));
										dgSampleCollectionDetails
												.setLastChgTime(time);
										dgSampleCollectionDetails
												.setRejected("n");
										dgSampleCollectionDetails
												.setSampleCollDatetime(new Date());
										dgSampleCollectionDetails
												.setOrderStatus("P");
										try {
											hbt.save(dgSampleCollectionDetails);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}
									}
								}
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
					goneInLoop = true;
				}
			}
*/
			success = true;
			map.put("success", success);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("orderSeqNo", orderSeqNo);
		return map;
	}

	// --------------------------- Method to get patient details for Ip
	// -----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(String hinNo) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.not(Restrictions.eq("AdStatus", "D")))
					.createAlias("Hin", "p").add(
							Restrictions.eq("HinNo", hinNo)).list();
			if (inPatientDetailList.size() > 0) {
				detailsMap.put("inPatientDetailList", inPatientDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ----------------method For Get patient Details Regarding Visit
	// Number------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetail(int visitNo) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		try {
			visitList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitNo)).list();
			if (visitList.size() > 0) {
				detailsMap.put("visitList", visitList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ---------------------------Method For get search Crieteria For Pending
	// Sample Collection--------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
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

		Session session = (Session) getSession();
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		System.out.println("deptId="+deptId);
		try {

			/*Criteria criteria = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y"));*/
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).addOrder(Order.asc("SubChargecodeName")).list();
		
			
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}

			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Status", "y")).list();
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
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

	// ---------------------------Method For get SampleCollectionGrid For
	// Current Date--------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> patientAppList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		Criteria critApp = null;
		String requestFromMethod = "";
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("requestFromMethod") != null) {
			requestFromMethod = (String) mapForDs.get("requestFromMethod");
		}
		int deptId = (Integer)mapForDs.get("deptId");
		int hospitalId = (Integer)mapForDs.get("hospitalId");
		String qry="";
		try {
			if (requestFromMethod
					.equalsIgnoreCase("showPendingSampleCollectionJsp")) {
				crit = session.createCriteria(DgOrderhd.class)					
					//	Restrictions.eq("LabOrderStatus", "P")).add(
						.add(Restrictions.or(Restrictions.isNull("BillingStatus"),Restrictions.eq("BillingStatus", "Y").ignoreCase()))
						.add(Restrictions.eq("OrderStatus", "P")).add(
						Restrictions.eq("OrderDate", currentDate)).add(Restrictions.isNull("AppointmentDate"))
					//	Restrictions.or(Restrictions.eq("OrderDate", currentDate), Restrictions.eq("AppointmentDate", currentDate)))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id"));		
				/*critApp = session.createCriteria(DgOrderhd.class)
						.add(Restrictions.or(Restrictions.isNull("BillingStatus"),Restrictions.eq("BillingStatus", "Y").ignoreCase())).add(
							Restrictions.eq("OrderStatus", "P")).add(
							Restrictions.eq("AppointmentDate", currentDate))
							.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id"));	*/
							
			} else {
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.or(Restrictions.isNull("BillingStatus"),Restrictions.eq("BillingStatus", "Y").ignoreCase()))
				 .add(Restrictions.eq("OrderStatus", "P"))
				 .add(Restrictions.eq("OrderDate", currentDate)).add(Restrictions.isNull("AppointmentDate"))
			//	.add(Restrictions.or(Restrictions.eq("OrderDate", currentDate), Restrictions.eq("AppointmentDate", currentDate)))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id"));	
								
				 //.add(Restrictions.eq("OrderDate", currentDate))
						//.add(Restrictions.eq("PatientType", "OP"))
						;
						
				/*critApp = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("BillingStatus", "y")).add(
						Restrictions.eq("OrderStatus", "P")).add(
						Restrictions.eq("AppointmentDate", currentDate))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id"));	*/
			}
		
			
			patientList = crit.list();
			//patientAppList =  critApp.list();
			/*patientDetailList.addAll(patientList);
			patientDetailList.addAll(patientAppList);*/
			
			System.out.println("patientList="+patientList.size());
			System.out.println("patientAppList="+patientAppList.size());
			System.out.println("patientDetailList="+patientDetailList.size());
			//patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientList);
		return map;
	}

	// ---------------------------Method For get Patient Details After//
	// search--------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionHeader> completedCollectionList = new ArrayList<DgSampleCollectionHeader>();
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		Date fromDate = null;
		Date toDate = null;
		String serPersonFName = "";
		String patientFName = "";
		String pType = "";
		String orderStatus = "";
		String adNo = "";
		String requestFromMethod = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		String departmentId = "";
		int hospitalId = 0;
		Criteria crit = null;
		Criteria critApp = null;
		
		boolean completedCollectionFlag = false;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
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
		if (mapForDs.get("departmentId") != null) {
			departmentId = (String) mapForDs.get("departmentId");
		}
		if (mapForDs.get("orderStatus") != null) {
			orderStatus = (String) mapForDs.get("orderStatus");
		}
		if (mapForDs.get("requestFromMethod") != null) {
			requestFromMethod = (String) mapForDs.get("requestFromMethod");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> patientAppList = new ArrayList<DgOrderhd>();
		
		System.out.println("fdate="+fromDate);
		System.out.println("tdate="+toDate);
		
		try {
			if (requestFromMethod.equalsIgnoreCase("searchPatient")) {
				crit = session.createCriteria(DgOrderhd.class).add(
						//Restrictions.eq("LabOrderStatus", "P")).add(
						Restrictions.eq("OrderStatus", "P")).add(Restrictions.isNull("AppointmentDate"))
						.createAlias("Hin", "pt").createAlias("Hospital",
						"h").add(Restrictions.eq("h.Id", hospitalId));
				//
				
				int labSampleCollectionDays= 0;
			
				try
				{
					labSampleCollectionDays = Integer.parseInt(HMSUtil.getProperties("adt.properties", "labSampleCollectionDays"));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				Date date = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(date); 
				c.add(Calendar.DATE, -labSampleCollectionDays); 
				
				System.out.println("fromdate="+c.getTime());
				System.out.println("fromdate="+new Date());
			
					crit.add(Restrictions.between("OrderDate", c.getTime(), new Date()));
				
				
				
				critApp = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("OrderStatus", "P")).add(
						Restrictions.between("AppointmentDate", fromDate, toDate))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id"));		
			} else {
				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("OrderStatus", "P")).add(
						Restrictions.between("OrderDate", fromDate, toDate)).add(Restrictions.isNull("AppointmentDate"))
						.createAlias("Hin", "pt").createAlias("Hospital",
						"h").add(Restrictions.eq("h.Id", hospitalId));
				
				critApp = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("OrderStatus", "P")).add(
						Restrictions.between("AppointmentDate", fromDate, toDate))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id"));		
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
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
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.SFirstName",
						serPersonFName + "%").ignoreCase());
			}
			if (subGroupId != 0 || chargeCodeId != 0) {
				crit = crit.createAlias("DgOrderdts","dt");
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("dt.SubChargeid", "sc").add(
						Restrictions.eq("sc.Id", subGroupId));
			}
			if (chargeCodeId != 0) {
				crit = crit.createAlias("dt.ChargeCode", "ch").add(
						Restrictions.eq("ch.Id", chargeCodeId));
			}
			if (!departmentId.equals("")) {
				if(departmentId.equals("OPD")){
					String[] str = {"OPD","FollowUp"}; // Follow up is also OPD department
					crit = crit.createAlias("Visit", "v").add(Restrictions.in("v.ReportingFor", str));
				}else if(departmentId.equals("Ward")){
					crit = crit.add(Restrictions.isNotNull("Inpatient"));
				}else if(departmentId.equals("Reception")){
					String[] str = {"Lab","Radiology"}; // Direct Lab and radiology requisition will come in reception
					crit = crit.createAlias("Visit", "v").add(Restrictions.in("v.ReportingFor", str));
				}else{
					crit = crit.createAlias("Visit", "v").add(
							Restrictions.eq("v.ReportingFor", departmentId));
				}
			}
			patientList = crit.list();
			System.out.println("patientList="+patientList.size());
			patientAppList =  critApp.list();
			System.out.println("patientAppList1="+patientAppList.size());
			patientDetailList.addAll(patientList);
			patientDetailList.addAll(patientAppList);
//			patientDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		
		if(patientDetailList.size()==0)
		{
			crit = session.createCriteria(DgSampleCollectionHeader.class)
					
					.createAlias("Hin", "pt").createAlias("Hospital",
					"h").add(Restrictions.eq("h.Id", hospitalId));		
			
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
			}
			
			crit= crit.addOrder(Order.desc("DiagnosisDate"));
			
			crit.setFirstResult(0);
			crit.setMaxResults(10);
			completedCollectionList = crit.list();
			completedCollectionFlag=true;
			map.put("completedCollectionFlag", completedCollectionFlag);
			map.put("completedCollectionList", completedCollectionList);

		}
		
		System.out.println("completedCollectionList="+completedCollectionList.size());
		
		
		
		return map;
	}

	// --------------------------- Method to submit Sample
	// Collection-----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSampleCollection(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		String diagSeqNo = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
        
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("diagSeqNo") != null) {
			diagSeqNo = (String) parameterMap.get("diagSeqNo");
		}

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		int orderId = box.getInt("orderId");
		
	
		try {
			int inpatientId = 0;
			if (box.getString(INPATIENT_ID) != null
					&& !box.getString(INPATIENT_ID).equals("")) {
				inpatientId = box.getInt(INPATIENT_ID);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgSampleCollectionHeader.setInpatient(inpatient);
			}
			int hinId = box.getInt(HIN_ID);
			int collectionCenterId = box.getInt(COLLECTION_CENTER_ID);
			int departmentId = box.getInt(DEPARTMENT_ID);
			int sessDeptId = box.getInt("sessDeptId");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				dgSampleCollectionHeader.setHin(patient);
			}
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			dgSampleCollectionHeader.setHospital(hospital);
/**
 * Commented By Ritu
 */
		/*	List dgOrderhdList = session.createCriteria(DgOrderhd.class)
					.add(Restrictions.eq("Id", orderId)).list();

			DgOrderhd dgOrderhd = (DgOrderhd) dgOrderhdList.get(0);
			dgOrderhd.setOrderStatus("C");
			hbt.update(dgOrderhd);
			dgOrderhd.setId(orderId);*/

	/**
	 * Added By Ritu
	 */
			DgOrderhd dgOrderhd = new DgOrderhd();
			dgOrderhd.setId(orderId);
			/**
			 * End
			 */
			dgSampleCollectionHeader.setOrder(dgOrderhd);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(sessDeptId);
			dgSampleCollectionHeader.setDepartment(masDepartment);
			MasDepartment orderByDepartment = new MasDepartment();
			orderByDepartment.setId(departmentId);
			dgSampleCollectionHeader.setOrderByDepartment(orderByDepartment);
			DgCollectionCenter dgCollectionCenter = new DgCollectionCenter();
			dgCollectionCenter.setId(collectionCenterId);
			if(collectionCenterId !=0)
			dgSampleCollectionHeader.setCollectionCenter(dgCollectionCenter);
    
			dgSampleCollectionHeader.setOrderStatus("P");
			dgSampleCollectionHeader.setLastChgBy(userName);
			dgSampleCollectionHeader.setSampleValidationDate(date);
			dgSampleCollectionHeader.setSampleValidationTime(time);
			dgSampleCollectionHeader.setLastChgDate(date);
			dgSampleCollectionHeader.setLastChgTime(time);
			dgSampleCollectionHeader.setDiagnosisDate(date);
			dgSampleCollectionHeader.setDiagnosisTime(time);
			int collectedBy = box.getInt(EMPLOYEE_ID);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(collectedBy);
			dgSampleCollectionHeader.setValidatedBy(masEmployee);
			dgSampleCollectionHeader.setCollectionTime(new Date());
			hbt.save(dgSampleCollectionHeader);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		// --------------------------dgSampleCollectionDetails-------------------------------------------
		
		try {
			Vector charge_code_Id = box.getVector(CHARGE_CODE_ID);
			Vector charge_code_name = box.getVector("chargename");
			Vector sample_Id = box.getVector(SAMPLE_ID);
			Vector collected = box.getVector(COLLECTED);
			Vector emapanelled = box.getVector(EMPANELLED);
			
			
			Vector container = box.getVector(CONTAINER);
			Vector orderDtId = box.getVector("orderDtId");
			Vector investigationId = box.getVector(INVESTIGATION_ID);
			Vector remarks = box.getVector(REMARKS);
			Vector mainCharge = box.getVector("mainCharge");
			Vector mainChargeName = box.getVector("mainChargeName");
			Vector sub_Charge = box.getVector("subCharge");
			int collectedBy = box.getInt(EMPLOYEE_ID);
			int visitId = 0;
			List<String> collectedCheck = new ArrayList<String>();
			List<String> quantityCheck = new ArrayList<String>();
			List<String> sampleIddCheck = new ArrayList<String>();
			List<String> remarksCheck = new ArrayList<String>();
			List<String> empanelledCheck = new ArrayList<String>();
			
			if(parameterMap.get("collectedCheck")!=null){
				collectedCheck = (List<String>)parameterMap.get("collectedCheck");
			}
			if(parameterMap.get("empanelledCheck")!=null){
				empanelledCheck = (List<String>)parameterMap.get("empanelledCheck");
			}
			if(parameterMap.get("quantityCheck")!=null){
				quantityCheck = (List<String>)parameterMap.get("quantityCheck");
			}
			if(parameterMap.get("sampleIddCheck")!=null){
				sampleIddCheck = (List<String>)parameterMap.get("sampleIddCheck");
			}
			if(parameterMap.get("remarksCheck")!=null){
				remarksCheck = (List<String>)parameterMap.get("remarksCheck");
			}
			if(parameterMap.get("visitId")!=null){
				visitId = (Integer)parameterMap.get("visitId");
			}
			
			
			int medicalExamId = 0;
			List<MasMedicalExaminationReportOnEntry>medicalExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			medicalExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Visit.Id",visitId)).add(Restrictions.eq("medicalType", "MedicalExam")).list();
			if(medicalExamList.size()>0){
				 medicalExamId = medicalExamList.get(0).getId();
			}
			for (int i = 0; i < collectedCheck.size(); i++) {
				if ((collectedCheck.get(i) != null ||empanelledCheck.get(i)!=null) && (!collectedCheck.get(i).equals("n")||!empanelledCheck.get(i).equals("n"))) {
					DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
					dgSampleCollectionDetails
							.setSampleCollectionHeader(dgSampleCollectionHeader);

					dgSampleCollectionDetails.setCollected((String) collectedCheck
							.get(i));

					dgSampleCollectionDetails.setEmpanelledStatus((String) empanelledCheck
							.get(i));
					
					DgOrderdt dgOrderdt = (DgOrderdt)hbt.load(DgOrderdt.class, new Integer(orderDtId.get(i).toString()));
					if (collectedCheck.get(i).equalsIgnoreCase("Y")|| empanelledCheck.get(i).equalsIgnoreCase("Y"))
					{
					dgOrderdt.setOrderStatus("C");
					try {
						hbt.saveOrUpdate(dgOrderdt);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}

					if (charge_code_Id.get(i) != null
							&& !charge_code_Id.get(i).equals("")) {
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer
								.parseInt((String) charge_code_Id.get(i)));
						dgSampleCollectionDetails.setChargeCode(masChargeCode);
					}
					
					
					if (!sampleIddCheck.get(i).equals("")) {
						MasSample masSample = new MasSample();
						masSample.setId(Integer.parseInt((String) sampleIddCheck
								.get(i)));
						dgSampleCollectionDetails.setSample(masSample);
					}
					if (mainCharge.get(i) != null
							&& !mainCharge.get(i).equals("")) {
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						masMainChargecode.setId(Integer.parseInt(mainCharge.get(i).toString()));
						dgSampleCollectionDetails
								.setMaincharge(masMainChargecode);
					}

					if (sub_Charge.get(i) != null
							&& !sub_Charge.get(i).equals("")) {
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						masSubChargecode.setId(Integer.parseInt(sub_Charge.get(i).toString()));
						dgSampleCollectionDetails
								.setSubcharge(masSubChargecode);
					}

					if (investigationId.get(i) != null
							&& !investigationId.get(i).equals("0")) {
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgSampleCollectionDetails
								.setInvestigation(dgMasInvestigation);
					}
					
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(collectedBy);
					dgSampleCollectionDetails.setCollectedBy(masEmployee);
                    dgSampleCollectionDetails.setDiagNo(diagSeqNo);
                    dgSampleCollectionDetails.setRejected("n");
                    
					if (quantityCheck!=null && quantityCheck.get(i) != null && !quantityCheck.get(i).equals("")) {
						dgSampleCollectionDetails.setQuantity((String) quantityCheck
								.get(i));
					}
					if(remarksCheck.size()>0)
					{
					if ( remarksCheck.get(i) != null && !remarksCheck.get(i).equals("")) {
						dgSampleCollectionDetails.setRemarks((String) remarksCheck
								.get(i));
					}
					}
					dgSampleCollectionDetails.setSampleCollDatetime(new Date());
					dgSampleCollectionDetails.setLastChgBy(userName);
					dgSampleCollectionDetails.setLastChgDate(date);
					dgSampleCollectionDetails.setLastChgTime(time);	
					 if (empanelledCheck.get(i).equalsIgnoreCase("Y") && collectedCheck.get(i).equalsIgnoreCase("n"))
						{
						 dgSampleCollectionDetails.setOrderStatus("A");
						}
					 if (empanelledCheck.get(i).equalsIgnoreCase("y") && collectedCheck.get(i).equalsIgnoreCase("y"))
						{
						 dgSampleCollectionDetails.setOrderStatus("P");
						}
					 if (empanelledCheck.get(i).equalsIgnoreCase("n") && collectedCheck.get(i).equalsIgnoreCase("y"))
						{
						 dgSampleCollectionDetails.setOrderStatus("P");
						}
								
					dgSampleCollectionDetails.setRejected("n");
					
					//dgSampleCollectionDetails.setValidated("V");
					
					if (orderDtId.get(i) != null
							&& !orderDtId.get(i).equals("")) {
						DgOrderdt orderdt = new DgOrderdt();
						orderdt.setId(Integer.parseInt((String)orderDtId.get(i)));
						dgSampleCollectionDetails.setOrderdt(orderdt);
					}
					
					hbt.save(dgSampleCollectionDetails);
					
					
					}
					if(medicalExamId!=0 && charge_code_name.get(i).equals("ECG")){
						MasMedicalExaminationReportOnEntry medicalExam = (MasMedicalExaminationReportOnEntry)hbt.load(MasMedicalExaminationReportOnEntry.class, medicalExamId);
						medicalExam.setDiagNo(diagSeqNo);
					}
					System.out.println("medicalExamId---------->>"+medicalExamId);
					if(medicalExamId!=0 && mainChargeName.get(i).equals("Radio-Diagnosis")){
						MasMedicalExaminationReportOnEntry medicalExam = (MasMedicalExaminationReportOnEntry)hbt.load(MasMedicalExaminationReportOnEntry.class, medicalExamId);
						medicalExam.setDiagNoForRadio(diagSeqNo);
					}
					
 
				}
			}
			/**
			 * For Sample Collection Appointment'
			 * Added By Ritu
			 * Date: 14 March 2012
			 */
			List<String> appointmentCheck = new ArrayList<String>();
			List<String> appointmentDateCheck = new ArrayList<String>();
			if(parameterMap.get("appointmentCheck")!=null){
				appointmentCheck = (List<String>)parameterMap.get("appointmentCheck");
			}
			if(parameterMap.get("appointmentDateCheck")!=null){
				appointmentDateCheck = (List<String>)parameterMap.get("appointmentDateCheck");
			}
			String appDate = "";
			if(appointmentCheck.size() > 0){
				
				for (int i = 0; i < appointmentCheck.size(); i++) {
					if (appointmentCheck.get(i) != null && !appointmentCheck.get(i).equals("n") && !appointmentDateCheck.get(i).equals("")) {
						appDate = appointmentDateCheck.get(i);
						DgOrderdt orderdt = (DgOrderdt)hbt.load(DgOrderdt.class, Integer.parseInt(orderDtId.get(i).toString()));
						orderdt.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(appDate));
						hbt.update(orderdt);
					}
				}
			}
			
			/**
			 * End
			 */
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String labMainChargeCode = properties.getProperty("labMainChargeCode");
			
			
			List<DgOrderdt> tempList = new ArrayList<DgOrderdt>();
			tempList = session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "sch").createAlias("MainChargecode", "mn").add(Restrictions.eq("mn.Id", Integer.parseInt(labMainChargeCode)))
					.add(Restrictions.eq("sch.Id", orderId)).list();

			String headerOrderStaus = "";
			for (DgOrderdt object : tempList) {
				String invToMh = "n"; //n is default value
				if(object.getInvestigationToMh()!=null){
					invToMh = object.getInvestigationToMh();
				}
				if (invToMh.equals("n") && object.getOrderStatus().equalsIgnoreCase("P")) {
					headerOrderStaus = "P";
					break;
				} else{
					headerOrderStaus = "A";
				}

			}
			DgOrderhd dgOrderhdObj = (DgOrderhd) hbt.load(DgOrderhd.class, orderId);
			dgOrderhdObj.setOrderStatus(headerOrderStaus);
			dgOrderhdObj.setLabOrderStatus("A");
			if(appointmentCheck.size() > 0 && !appDate.equals("")){
				dgOrderhdObj.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(appDate));
			}
			
			hbt.saveOrUpdate(dgOrderhdObj);
			saved = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		tx.commit();
		map.put("sampleId", dgSampleCollectionHeader.getId());
		
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		
		
		map.put("saved", saved);
		map.put("OrderNo", diagSeqNo);
		return map;
	}


	// -----------------------Method For get Details on Sample Collection
	// -------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetails(Map orderMap) {
		System.out.println("call search of sample collection");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		List<MasDepartment> collectionCenterListForSampleCollection = new ArrayList<MasDepartment>();
		List<DgMasCollection> conatinerList = new ArrayList<DgMasCollection>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<String> departmentType = new ArrayList<String>();
		departmentType.add("WARD");
		departmentType.add("Colle");
		int hinId = 0;
		String requestFromMethod = "";
		String diagSeqNo = "";
		Session session = (Session) getSession();
		int hospitalId = (Integer)orderMap.get("hospitalId");
		try {
			collectionCenterList = session.createCriteria(
					DgCollectionCenter.class).add(
					Restrictions.eq("Status", "y")).list();
			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}

			collectionCenterListForSampleCollection = session.createCriteria(
					MasDepartment.class).createAlias("DepartmentType", "dt")
					.add(
							Restrictions.in("dt.DepartmentTypeCode",
									departmentType)).list();
			if (collectionCenterListForSampleCollection.size() > 0) {
				detailsMap.put("collectionCenterListForSampleCollection",
						collectionCenterListForSampleCollection);
			}

			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}

			conatinerList = session.createCriteria(DgMasCollection.class).add(
					Restrictions.eq("Status", "y")).list();
			if (conatinerList.size() > 0) {
				detailsMap.put("conatinerList", conatinerList);
			}
			/*employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Hospital",
					"h").add(Restrictions.eq("h.Id", hospitalId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}*/
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			if (orderMap.get("requestFromMethod") != null) {
				requestFromMethod = (String) orderMap.get("requestFromMethod");
			}
			if (orderMap != null && orderMap.size() > 0) {
				if (requestFromMethod.equalsIgnoreCase("searchPatient")) {
					dgOrderhdList = session.createCriteria(DgOrderhd.class)
							//.add(Restrictions.eq("LabOrderStatus", "P")).add(
					.add(Restrictions.eq("OrderStatus", "P")).add(
									Restrictions.eq("Id", (Integer) orderMap
											.get("orderId"))).createAlias("Hospital",
											"h").add(Restrictions.eq("h.Id", hospitalId)).list();
					/// added by shalini
					
					for (DgOrderhd hd : dgOrderhdList) {
						diagSeqNo = hd.getOrderNo();
				} }else {
					dgOrderhdList = session.createCriteria(DgOrderhd.class)
							.add(Restrictions.eq("OrderStatus", "P")).add(
									Restrictions.eq("Id", (Integer) orderMap
											.get("orderId"))).createAlias("Hospital",
											"h").add(Restrictions.eq("h.Id", hospitalId)).list();
				}
				List<String> prevRemarks = new ArrayList<String>();
				prevRemarks = session.createCriteria(DgSampleCollectionDetails.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "ord").add(Restrictions.eq("ord.Id", (Integer) orderMap.get("orderId")))
						.setProjection(Projections.property("Remarks")).list();
				detailsMap.put("prevRemarks", prevRemarks);
			}
			if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
				
				detailsMap.put("dgOrderhdList", dgOrderhdList);
				detailsMap.put("diagSeqNo", diagSeqNo);

				hinId = dgOrderhdList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		System.out.println("dgOrderhdList="+dgOrderhdList.size());
		detailsMap.put("diagSeqNo", diagSeqNo);
		return detailsMap;
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationSearch() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SubChargecodeName")).list();
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Status", "y")).list();
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
			sampleList = session.createCriteria(MasSample.class).add(
					Restrictions.eq("Status", "y")).list();
			if (sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getPatientDetailsForValidation(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String pType = "";
		String diagNo = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		int deptId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("diagNo") != null) {
			diagNo = (String) mapForDs.get("diagNo");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		int orderId = 0;
		if (mapForDs.get("orderId") != null) {
			orderId = (Integer) mapForDs.get("orderId");
		}
		try {

			crit = session.createCriteria(DgSampleCollectionHeader.class).add(
					Restrictions.eq("OrderStatus", "P")).add(
					Restrictions.between("DiagnosisDate", fromDate, toDate))
					.createAlias("Hin", "pt");
			if (!pType.equals("")) {
				crit = crit.add(Restrictions.eq("PatientType", pType));
			}
			if (!diagNo.equals("")) {
				crit = crit.add(Restrictions.eq("DiagnosisNo", diagNo));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("pt.Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
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
			if (deptId != 0) {
				crit = crit.createAlias("Department", "dep").add(
						Restrictions.eq("dep.Id", deptId));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.SFirstName",
						serPersonFName + "%"));
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("SubChargeid", "sc").add(
						Restrictions.eq("sc.Id", subGroupId));
			}
			if (chargeCodeId != 0) {
				crit = crit.createAlias("ChargeCode", "ch").add(
						Restrictions.eq("ch.Id", chargeCodeId));
			}
			patientDeatilList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		List<DgSampleCollectionHeader> dgSampleCollectionhdNotRejectedList = new ArrayList<DgSampleCollectionHeader>();
		for (DgSampleCollectionHeader dgSampleCollectionHeader : patientDeatilList) {
			Set<DgSampleCollectionDetails> dgSampleCollectiondtSet = dgSampleCollectionHeader
					.getDgSampleCollectionDetails();
			for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectiondtSet) {
				if (dgSampleCollectionDetails.getRejected() != null
						&& dgSampleCollectionDetails.getRejected()
								.equalsIgnoreCase("n")) {
					dgSampleCollectionhdNotRejectedList
							.add(dgSampleCollectionHeader);
					break;
				}
			}
		}
		map.put("patientDeatilList", dgSampleCollectionhdNotRejectedList);

		// map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	public Map<String, Object> getPatientDetailsForValidationLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		Date fromDate = null;
		Date toDate = null;
		String pType = "";
		String diagNo = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		int loginDeptId = 0;
		int orderByDepartmentId = 0;
		String barCodeOrderNo="";

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("diagNo") != null) {
			diagNo = (String) mapForDs.get("diagNo");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderByDepartmentId") != null) {
			orderByDepartmentId = (Integer) mapForDs.get("orderByDepartmentId");
		}
		if (mapForDs.get("loginDeptId") != null) {
			loginDeptId = (Integer) mapForDs.get("loginDeptId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("barCodeOrderNo") != null) {
			barCodeOrderNo = (String) mapForDs.get("barCodeOrderNo");
		}

		try {
			crit = session.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "sampleCollHeader").createAlias("sampleCollHeader.Order", "dgOrder")
					.add(Restrictions.eq("OrderStatus", "P")).add(
							Restrictions.eq("sampleCollHeader.Department.Id",
									loginDeptId)).createAlias(
							"sampleCollHeader.Hin", "pt");
			
			if(fromDate != null && toDate !=null)
							{
								crit.add(Restrictions.between("sampleCollHeader.DiagnosisDate", fromDate,toDate));
							}
			
			
			if (!pType.equals("")) {
				crit = crit.add(Restrictions.eq("sampleCollHeader.PatientType",
						pType));
			}
			if (!diagNo.equals("")) {
				crit = crit.add(Restrictions.eq("sampleCollHeader.DiagnosisNo",
						diagNo));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("pt.Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
				
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
			if (orderByDepartmentId != 0) {
				crit = crit.createAlias("sampleCollHeader.OrderByDepartment",
						"dep").add(
						Restrictions.eq("dep.Id", orderByDepartmentId));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.SFirstName",
						serPersonFName + "%").ignoreCase());
			}
			if (subGroupId != 0) {
				crit = crit.add(Restrictions.eq("Subcharge.Id", subGroupId));
			}
			if (chargeCodeId != 0) {
				crit = crit.add(Restrictions.eq("ChargeCode.Id", chargeCodeId));
			}
			if (!barCodeOrderNo.equals("")) {
				crit = crit.add(Restrictions.eq("dgOrder.OrderNo", barCodeOrderNo));
			}
			crit = crit.add(Restrictions.eq("Rejected", "n"));

			crit = crit.setProjection(Projections.projectionList().add(
					Projections.groupProperty("SampleCollectionHeader")).add(
					Projections.groupProperty("Subcharge")));

			patientDeatilList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("patientDeatilList", patientDeatilList);

		// map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	// -----------------------Method For get Details on Sample Validation
	// -------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationDetails(int orderId, int uid,
			int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<Users> usersList = new ArrayList<Users>();
		List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
		Session session = (Session) getSession();
		int hinId = 0;
		try {
			usersList = session.createCriteria(Users.class).add(
					Restrictions.eq("Id", uid)).list();
			Users user = usersList.get(0);
			int empid = user.getEmployee().getId();
			detailsMap.put("empid", empid);
			employeeCodeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("Department.Id", deptId)).add(
					Restrictions.eq("EmpCategory.Id", 4)).list();
			if (employeeCodeList != null || employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			samplehdList = session.createCriteria(
					DgSampleCollectionHeader.class).add(
					Restrictions.eq("Id", orderId)).list();
			hinId = samplehdList.get(0).getHin().getId();

			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientDeatilList", patientList);
			}
			if (samplehdList != null || samplehdList.size() > 0) {
				detailsMap.put("samplehdList", samplehdList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getSampleValidationDetailsLab(
			String combinedIds, int uid, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<Users> usersList = new ArrayList<Users>();
		List<DgSampleCollectionDetails> sampleCollectionDtList = new ArrayList<DgSampleCollectionDetails>();
		String[] idsArray = new String[0];
		int dgSampleHeaderId = 0;
		int subChargeId = 0;

		Session session = (Session) getSession();
		int hinId = 0;
		try {
			usersList = session.createCriteria(Users.class).add(
					Restrictions.eq("Id", uid)).list();
			Users user = usersList.get(0);
			int empid = user.getEmployee().getId();
			detailsMap.put("empid", empid);
			
			System.out.println("dept ID"+deptId);
			
			employeeCodeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("Department.Id", deptId))
					//.add(Restrictions.eq("EmpCategory.Id", 4))
							.list();
			
			System.err.println("employeeCodeList in ds"+employeeCodeList.size());
			if (employeeCodeList != null || employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}
			if (!combinedIds.equals("")) {
				idsArray = combinedIds.split(",");
				dgSampleHeaderId = Integer.parseInt(idsArray[0]);

				subChargeId = Integer.parseInt(idsArray[1]);

				sampleCollectionDtList = session.createCriteria(
						DgSampleCollectionDetails.class).add(
						Restrictions.eq("SampleCollectionHeader.Id",
								dgSampleHeaderId)).add(
						Restrictions.eq("Subcharge.Id", subChargeId)).add(
						Restrictions.eq("OrderStatus", "P"))/*.add(
						Restrictions.eq("Rejected", "n"))*/.list();

			}
			if (sampleCollectionDtList != null
					&& sampleCollectionDtList.size() > 0) {
				detailsMap
						.put("sampleCollectionDtList", sampleCollectionDtList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ---------------------------Method For get SampleValidationGrid For
	// Current Date--------------------------
	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		try {

			crit = session.createCriteria(DgSampleCollectionHeader.class).add(
					Restrictions.eq("OrderStatus", "P")).add(
					Restrictions.eq("DiagnosisDate", currentDate)).createAlias(
					"Department", "dep").add(Restrictions.eq("dep.Id", deptId));
			patientDeatilList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<DgSampleCollectionHeader> dgSampleCollectionhdNotRejectedList = new ArrayList<DgSampleCollectionHeader>();
		for (DgSampleCollectionHeader dgSampleCollectionHeader : patientDeatilList) {
			Set<DgSampleCollectionDetails> dgSampleCollectiondtSet = dgSampleCollectionHeader
					.getDgSampleCollectionDetails();
			for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectiondtSet) {
				if (dgSampleCollectionDetails.getRejected() != null
						&& dgSampleCollectionDetails.getRejected()
								.equalsIgnoreCase("n")) {
					dgSampleCollectionhdNotRejectedList
							.add(dgSampleCollectionHeader);
					break;
				}
			}
		}
		map.put("patientDeatilList", dgSampleCollectionhdNotRejectedList);
		return map;
	}

	// ---------------------------Method For get SampleValidationGrid For
	// Current Date--------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationLabGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		try {
			crit = session.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("OrderStatus", "P")).createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Department", "dept").add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("sampleHead.DiagnosisDate", currentDate))
					.add(Restrictions.or(Restrictions.isNull("Collected"),	Restrictions.eq("Collected", "Y").ignoreCase()))
					.addOrder(Order.asc("SampleCollectionHeader.Id")).add(Restrictions.eq("Rejected" , "n"))
					.addOrder(Order.asc("Subcharge.Id"));
			crit = crit.setProjection(Projections.projectionList().add(
					Projections.groupProperty("SampleCollectionHeader")).add(
					Projections.groupProperty("Subcharge")));

			patientDeatilList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	// --------------------------- Method to submit Sample
	// Acceptance-----------------------------------

	@SuppressWarnings("unchecked")
	public boolean submitSampleAcceptance(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String dateTime = (String) utilMap.get("dateTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, Object> date1 = HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Session session = (Session) getSession();
		boolean updatedSuccessfully = false;
		Box box = null;
		String userName = "";
		List<Integer> acceptedIdList = new ArrayList<Integer>();

		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("acceptedIdList") != null) {
			acceptedIdList = (List) parameterMap.get("acceptedIdList");
		}

		int sampleCollectionHeaderId = (Integer) box
				.getInt("sampleCollectionHeaderId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		DgSampleCollectionHeader dgSampleCollectionHeaderObj = (DgSampleCollectionHeader) hbt
				.load(DgSampleCollectionHeader.class, sampleCollectionHeaderId);
		int employeeId = box.getInt(EMPLOYEE_ID);
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			dgSampleCollectionHeaderObj.setValidatedBy(masEmployee);
		}

		dgSampleCollectionHeaderObj.setSampleValidationDate(date);
		dgSampleCollectionHeaderObj.setSampleValidationTime(time);
		dgSampleCollectionHeaderObj.setLastChgBy(userName);
		dgSampleCollectionHeaderObj.setLastChgDate(date);
		dgSampleCollectionHeaderObj.setLastChgTime(time);

		try {
			int dgOrderhdId = (Integer) box.getInt(ORDER_BOOKING_ID);
			DgOrderhd dgOrderhdToUpdate = (DgOrderhd) hbt.load(DgOrderhd.class,
					dgOrderhdId);
			Set<DgOrderdt> set = dgOrderhdToUpdate.getDgOrderdts();
			int counter = 0;
			for (DgOrderdt orderDt : set) {
				int dgOrderdtId = orderDt.getId();
				if (orderDt.getChargeCode().getMainChargecode()
						.getMainChargecodeCode().equalsIgnoreCase("RADIO")) {
					if (acceptedIdList
							.contains(orderDt.getChargeCode().getId())) {
						DgOrderdt dgOrderdtToUpdate = (DgOrderdt) hbt.load(
								DgOrderdt.class, dgOrderdtId);
						dgOrderdtToUpdate.setOrderStatus("A");
						hbt.update(dgOrderdtToUpdate);
					}
					// counter--;
				} else {
					counter++;
				}
			}
			DgOrderhd dgOrderhdToUpdatenew = (DgOrderhd) hbt.load(
					DgOrderhd.class, dgOrderhdId);
			Set<DgOrderdt> setNew = dgOrderhdToUpdate.getDgOrderdts();
			int temp = 0;
			for (DgOrderdt orderDt : setNew) {
				if (orderDt.getOrderStatus().equalsIgnoreCase("P")) {
					temp++;
				}
			}
			if (temp > 0) {
				dgOrderhdToUpdatenew.setOrderStatus("P");
			} else {
				dgOrderhdToUpdatenew.setOrderStatus("A");
			}
			hbt.update(dgOrderhdToUpdatenew);
		} catch (DataAccessException e1) {
			e1.printStackTrace();
		}

		// --------------------------dgSampleCollectionDetails-------------------------------------------

		try {
			Vector dgSampleCollectionDetailsId = box
					.getVector(DG_SAMPLE_DETAIL_ID);
			Vector reason = box.getVector(REASON);
			Vector validated = box.getVector(VALIDATED);
			Vector remarks = box.getVector(REMARKS);
			Vector diagnosisNo = box.getVector(DIAGNOSIS_NO);
			List accepList = new ArrayList();
			List rejList = new ArrayList();
			if (parameterMap.get("accepList") != null) {
				accepList = (List) parameterMap.get("accepList");
			}
			if (parameterMap.get("rejList") != null) {
				rejList = (List) parameterMap.get("rejList");
			}

			int i = 0;
			for (i = 0; i <= dgSampleCollectionDetailsId.size() - 1; i++) {
				if (dgSampleCollectionDetailsId.get(i) != null
						&& !dgSampleCollectionDetailsId.get(i).equals("")) {
					DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) hbt
							.load(
									DgSampleCollectionDetails.class,
									Integer
											.parseInt((String) dgSampleCollectionDetailsId
													.get(i)));
					dgSampleCollectionDetails.setValidated("y");

					if (reason.get(i) != null && !reason.get(i).equals("")) {
						dgSampleCollectionDetails.setReason((String) reason
								.get(i));
					}
					if (remarks.get(i) != null && !remarks.get(i).equals("")) {
						dgSampleCollectionDetails.setRemarks((String) remarks
								.get(i));
					}
					if (diagnosisNo.get(i) != null
							&& !diagnosisNo.get(i).equals("")) {
						dgSampleCollectionDetails
								.setDiagNo((String) diagnosisNo.get(i));
					}
					if (accepList.get(i).equals("y")
							&& rejList.get(i).equals("n")) {
						dgSampleCollectionDetails.setOrderStatus("A");
						dgSampleCollectionDetails.setRejected("n");
					} else if (rejList.get(i).equals("y")
							&& accepList.get(i).equals("n")) {
						dgSampleCollectionDetails.setOrderStatus("P");
						dgSampleCollectionDetails.setRejected("y");
					}
					dgSampleCollectionDetails.setSampleCollDatetime(date);
					dgSampleCollectionDetails.setLastChgBy(userName);
					dgSampleCollectionDetails.setLastChgDate(date);
					dgSampleCollectionDetails.setLastChgTime(time);
					hbt.saveOrUpdate(dgSampleCollectionDetails);
					hbt.refresh(dgSampleCollectionDetails);

				}
			}
			List<DgSampleCollectionDetails> tempList = new ArrayList<DgSampleCollectionDetails>();
			tempList = session.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "sch")
					.add(Restrictions.eq("sch.Id", sampleCollectionHeaderId))
					.list();

			String headerOrderStaus = "";
			for (DgSampleCollectionDetails object : tempList) {
				if (object.getOrderStatus().equalsIgnoreCase("P")
						&& object.getRejected().equalsIgnoreCase("n")) {
					headerOrderStaus = "P";
					break;
				} else {
					headerOrderStaus = "A";
				}

			}
			dgSampleCollectionHeaderObj.setOrderStatus(headerOrderStaus);
			hbt.saveOrUpdate(dgSampleCollectionHeaderObj);

			updatedSuccessfully = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return updatedSuccessfully;
	}

	public boolean submitSampleAcceptanceLab(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String dateTime = (String) utilMap.get("dateTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, Object> date1 = HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Session session = (Session) getSession();
		boolean updatedSuccessfully = false;
		int orderhdId =0;
		Box box = null;
		String userName = "";
		List<Integer> acceptedIdList = new ArrayList<Integer>();

		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("acceptedIdList") != null) {
			acceptedIdList = (List) parameterMap.get("acceptedIdList");
		}

		String combinedIds = (String) box.getString("combinedIds");

		String[] idsArray = new String[0];
		int dgSampleHeaderId = 0;
		int subChargeId = 0;

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (!combinedIds.equals("")) {
			idsArray = combinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);

			subChargeId = Integer.parseInt(idsArray[1]);
		}

		DgSampleCollectionHeader dgSampleCollectionHeaderObj = (DgSampleCollectionHeader) hbt
				.load(DgSampleCollectionHeader.class, dgSampleHeaderId);

		int employeeId = box.getInt(EMPLOYEE_ID);
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			dgSampleCollectionHeaderObj.setValidatedBy(masEmployee);
		}

		dgSampleCollectionHeaderObj.setSampleValidationDate(date);
		dgSampleCollectionHeaderObj.setSampleValidationTime(time);
		dgSampleCollectionHeaderObj.setLastChgBy(userName);
		dgSampleCollectionHeaderObj.setLastChgDate(date);
		dgSampleCollectionHeaderObj.setLastChgTime(time);

		try {
			int dgOrderhdId = (Integer) box.getInt(ORDER_BOOKING_ID);
			DgOrderhd dgOrderhdToUpdate = (DgOrderhd) hbt.load(DgOrderhd.class,
					dgOrderhdId);
			Set<DgOrderdt> set = dgOrderhdToUpdate.getDgOrderdts();

			DgOrderhd dgOrderhdToUpdatenew = (DgOrderhd) hbt.load(
					DgOrderhd.class, dgOrderhdId);
			Set<DgOrderdt> setNew = dgOrderhdToUpdate.getDgOrderdts();
			int temp = 0;
			for (DgOrderdt orderDt : setNew) {
				if (orderDt.getOrderStatus().equalsIgnoreCase("P")) {
					temp++;
				}
			}
			if (temp > 0) {
				dgOrderhdToUpdatenew.setOrderStatus("P");
			} else {
				dgOrderhdToUpdatenew.setOrderStatus("A");
			}
			hbt.update(dgOrderhdToUpdatenew);
		} catch (DataAccessException e1) {
			e1.printStackTrace();
		}

		// --------------------------dgSampleCollectionDetails-------------------------------------------

		try {
			Vector dgSampleCollectionDetailsId = box
					.getVector(DG_SAMPLE_DETAIL_ID);
			
			Vector reason = box.getVector(REASON);
			Vector validated = box.getVector(VALIDATED);
			Vector remarks = box.getVector(REMARKS);
			Vector diagnosisNo = box.getVector(DIAGNOSIS_NO);
			List accepList = new ArrayList();
			List rejList = new ArrayList();
			if (parameterMap.get("accepList") != null) {
				accepList = (List) parameterMap.get("accepList");
			}
			if (parameterMap.get("rejList") != null) {
				rejList = (List) parameterMap.get("rejList");
			}

			int i = 0;
			for (i = 0; i <= dgSampleCollectionDetailsId.size() - 1; i++) {
				if (dgSampleCollectionDetailsId.get(i) != null
						&& !dgSampleCollectionDetailsId.get(i).equals("")) {
					DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) hbt
							.load(
									DgSampleCollectionDetails.class,
									Integer
											.parseInt((String) dgSampleCollectionDetailsId.get(i)));
					dgSampleCollectionDetails.setValidated("y");

					if (reason.get(i) != null && !reason.get(i).equals("")) {
						dgSampleCollectionDetails.setReason((String) reason
								.get(i));
					}
					if (remarks.get(i) != null && !remarks.get(i).equals("")) {
						dgSampleCollectionDetails.setRemarks((String) remarks
								.get(i));
					}
					if (diagnosisNo.get(i) != null
							&& !diagnosisNo.get(i).equals("")) {
						dgSampleCollectionDetails
								.setDiagNo((String) diagnosisNo.get(i));
					}
					if (accepList.get(i).equals("y")
							&& rejList.get(i).equals("n")) {
						dgSampleCollectionDetails.setOrderStatus("A");
						dgSampleCollectionDetails.setRejected("n");
					} else if (rejList.get(i).equals("y")
							&& accepList.get(i).equals("n")) {
						dgSampleCollectionDetails.setOrderStatus("P");
						dgSampleCollectionDetails.setRejected("y");
					}
					dgSampleCollectionDetails.setSampleCollDatetime(date);
					dgSampleCollectionDetails.setLastChgBy(userName);
					dgSampleCollectionDetails.setLastChgDate(date);
					dgSampleCollectionDetails.setLastChgTime(time);
					hbt.saveOrUpdate(dgSampleCollectionDetails);
					hbt.refresh(dgSampleCollectionDetails);
					
					DgOrderdt dgOrderdt = (DgOrderdt) hbt.get(DgOrderdt.class,dgSampleCollectionDetails.getOrderdt().getId());
					if(dgOrderdt !=null)
					{
						if(dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") && dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("p"))
						{
							dgOrderdt.setOrderStatus("P");
							hbt.update(dgOrderdt);
							hbt.refresh(dgOrderdt);
							orderhdId = dgOrderdt.getOrderhd().getId();
						}
					}
					

				}
			}
			List<DgSampleCollectionDetails> tempList = new ArrayList<DgSampleCollectionDetails>();
			tempList = session.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "sch").add(
							Restrictions.eq("Id", dgSampleHeaderId)).list();
			String headerOrderStaus = "";
			for (DgSampleCollectionDetails object : tempList) {
				if (object.getOrderStatus().equalsIgnoreCase("P")
						&& object.getRejected().equalsIgnoreCase("n")) {
					headerOrderStaus = "P";
					break;
				} else {
					headerOrderStaus = "A";
				}

			}
			
			List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
			orderdtList = session.createCriteria(DgOrderdt.class).createCriteria("Orderhd", "header")
					.add(Restrictions.eq("header.Id", orderhdId)).list();
			String headerOrderHdStaus = "";
			for (DgOrderdt object : orderdtList) {
				if (object.getOrderStatus().equalsIgnoreCase("P"))
						{
					headerOrderHdStaus = "P";
					break;
				} else {
					headerOrderHdStaus = "A";
				}

			}
			
			DgOrderhd dgOrderhd = (DgOrderhd) hbt.get(DgOrderhd.class,orderhdId);
			if(dgOrderhd !=null)
			{
				
					dgOrderhd.setOrderStatus(headerOrderHdStaus);
					hbt.update(dgOrderhd);
					hbt.refresh(dgOrderhd);
					
				
			}
			
			
			dgSampleCollectionHeaderObj.setOrderStatus(headerOrderStaus);
			hbt.saveOrUpdate(dgSampleCollectionHeaderObj);
			hbt.refresh(dgSampleCollectionHeaderObj);

			updatedSuccessfully = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return updatedSuccessfully;
	}

	// ------------------------Mehod For display to Order
	// Number-----------------
	@SuppressWarnings("unchecked")
	public String getOrderSeqForDisplay(String string) {
                List<Integer> orderSeqNoList = new ArrayList<Integer>();
                List<DgOrderhd> seqNoList = new ArrayList<DgOrderhd>();
                String orderSeqNo = "";
                String lastSeqNo = "";
                String lastSeqYear = "";
                String lastSeqMonth = "";

                Map<String, Object> utilMap = new HashMap<String, Object>();
                utilMap = (Map) HMSUtil.getCurrentDateAndTime();
                String date = (String) utilMap.get("currentDate");

                String currentYear = date.substring(date.lastIndexOf("/") + 1);
                String currentMonth = date.substring(date.indexOf("/") + 1, date
                                .lastIndexOf("/"));

                Session session = (Session) getSession();
                try {
                        seqNoList = session.createCriteria(DgOrderhd.class).list();
                        if (seqNoList.size() > 0) {
                                for (DgOrderhd dgOrderhd : seqNoList) {
                                        lastSeqNo = dgOrderhd.getOrderNo();
                                }
                                StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
                                while (str.hasMoreTokens()) {
                                        lastSeqYear = str.nextToken();
                                }
                        } else {
                                lastSeqYear = currentYear;
                        }

                        // session.createCriteria(TransactionSequence.class)
                        // .setProjection(Projections.groupProperty(""))
                        // .list();

                        orderSeqNoList = session.createCriteria(TransactionSequence.class)
                                        .add(Restrictions.eq("TransactionPrefix", "ON"))
                                        .setProjection(
                                                        Projections.projectionList().add(
                                                                        Projections
                                                                                        .max("TransactionSequenceNumber")))
                                        .list();
                        if (orderSeqNoList.size() > 0) {
                                for (Integer maxOrderNo : orderSeqNoList) {
                                        if (currentYear.equals(lastSeqYear)) {
                                                orderSeqNo = String.valueOf(maxOrderNo + 1);
                                        } else {
                                                orderSeqNo = String.valueOf(1);
                                                lastSeqYear = currentYear;
                                        }
                                }
                        } else {
                                orderSeqNo = String.valueOf(1);
                        }
                        orderSeqNo = orderSeqNo.concat("/").concat(currentMonth)
                                        .concat("/").concat(String.valueOf(lastSeqYear));
                } catch (HibernateException e) {
                        e.printStackTrace();
                }
                return orderSeqNo;
        }


	// ------------------------Mehod For Generate to Order
	// Number-----------------
	@SuppressWarnings("unchecked")
	public String generateOrderNumber(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";

		Session session = (Session) getSession();
		String orderSeqNo = "";
		date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String lastOrderYear = "";
		int seqNo = 1;
	//	List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
       /*
		String currentyear = "";
		String lastOrderNo = "";
		orderNoList = session.createCriteria(DgOrderhd.class).list();
		for (DgOrderhd dgOrderhd : orderNoList) {
			lastOrderNo = dgOrderhd.getOrderNo();
		}
		StringTokenizer str = new StringTokenizer(lastOrderNo, "/");
		while (str.hasMoreTokens()) {

			lastOrderYear = str.nextToken();

		}
		*/
		try {
			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "ON")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			//for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				String seqNoStr=obj.getTransactionSequenceNumber().toString();
				lastOrderYear=obj.getMonth().toString();
				if (currentYear.equals(lastOrderYear)) {
					
					seqNo = Integer.parseInt(seqNoStr);
				} else {
					seqNo = 0;
					lastOrderYear=currentYear;
				}
				seqNo=seqNo+1;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
				.load(TransactionSequence.class, id);
		        
				orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
				//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
				transactionSequenceObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
				transactionSequenceObj.setMonth(Integer.parseInt(lastOrderYear));
				hbt.update(transactionSequenceObj);
		       hbt.refresh(transactionSequenceObj);
		       
			//}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgOrderhd");
			tsObj.setTransactionPrefix("ON");
			tsObj.setTransactionSequenceName("Order No");
			orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
			//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(currentYear));
			lastOrderYear=currentYear;
			tsObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
			tsObj.setMonth(Integer.parseInt(currentYear));
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			hbt.save(tsObj);
		}
		orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
		return orderSeqNo;
	}


	// ------------------------Mehod For display to Diagnosis
	// Number-----------------
	public String getDiagSeqForDisplay(String string, int hinId) {

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<Integer> diagSeqNoList = new ArrayList<Integer>();
		List<DiagParam> diagParamList = new ArrayList<DiagParam>();
		List<DgOrderhd> sampleList = new ArrayList<DgOrderhd>();
		DiagParam diagParam = new DiagParam();
		Session session = (Session) getSession();
		int maxDiagNo = 0;
		int subChargeId = 0;
		int serviceStatusId = 0;
		String diagSeqNo = "";
		String date = "";
		String seqNo = "";
		String criteria = "";
		String subChargeCode = "";
		String serviceStatusCode = "";
		String month = "";
		String year = "";
		date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		List diagNoList = null;

		List<DgSampleCollectionHeader> sampleCollList = new ArrayList<DgSampleCollectionHeader>();
		sampleCollList = session.createCriteria(DgSampleCollectionHeader.class)
				.createAlias("Hin", "P").add(Restrictions.eq("P.Id", hinId))
				.add(Restrictions.eq("OrderStatus", "P")).list();

		Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = sampleCollList
				.get(0).getDgSampleCollectionDetails();

		int subChargeCodeId = 0;
		for (Iterator iterator = dgSampleCollectionDetailsSet.iterator(); iterator
				.hasNext();) {
			DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) iterator
					.next();
			subChargeCodeId = dgSampleCollectionDetails.getChargeCode()
					.getSubChargecode().getId();
			try {

				// diagSeqNoList =
				// session.createCriteria(TransactionSequence.class)
				// .add(Restrictions.eq("TransactionPrefix", "DN"))
				// .setProjection(
				// Projections.projectionList().add(
				// Projections
				// .max("TransactionSequenceNumber")))
				// .list();
				try {
					// parameterList =
					// session.createCriteria(MasParameter.class).add(
					// Restrictions.eq("Status", "y")).list();
					diagParamList = session.createCriteria(DiagParam.class)
							.createAlias("SubCharge", "charge").add(
									Restrictions.eq("charge.Id",
											subChargeCodeId)).add(
									Restrictions.eq("Status", "y")).list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				if (diagParamList != null) {
					diagParam = diagParamList.get(0);
					subChargeCode = diagParam.getSubCharge()
							.getSubChargecodeCode();
					criteria = diagParam.getCriteria();

					if (criteria.equalsIgnoreCase("c")) {

						maxDiagNo = diagParam.getSeqNo();
						seqNo = String.valueOf(maxDiagNo + 1);
						diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo));
						subChargeId = diagParam.getSubCharge().getId();
						if (subChargeId != 0) {
							diagSeqNo = diagSeqNo.concat("/").concat(
									subChargeCode);
						}
						// serviceStatusId =
						// diagParam.getServiceStatus().getId();
						if (serviceStatusId != 0) {
							diagSeqNo = diagSeqNo.concat("/").concat(
									serviceStatusCode);
						}
						diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
						diagSeqNo = diagSeqNo.concat("/").concat(currentYear);
					}
					if (criteria.equalsIgnoreCase("m")) {
						// diagSeqNo =
						// diagSeqNo.concat("/").concat(currentMonth);
					}
					if (criteria.equalsIgnoreCase("y")) {
						// diagSeqNo =
						// diagSeqNo.concat("/").concat(currentYear);
					}

					// else {
					// diagSeqNo = String.valueOf(1);
					// }
					// subChargeId = diagParam.getSubCharge().getId();
					// if (subChargeId != 0) {
					// diagSeqNo = diagSeqNo.concat("/").concat(subChargeCode);
					// }
					// //serviceStatusId = diagParam.getServiceStatus().getId();
					// if (serviceStatusId != 0) {
					// diagSeqNo =
					// diagSeqNo.concat("/").concat(serviceStatusCode);
					// }
					// diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
					// diagSeqNo = diagSeqNo.concat("/").concat(currentYear);

				} else {
					diagSeqNo = String.valueOf(1);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return diagSeqNo;
	}

	// ------------------------Mehod For Generate to Diagnosis
	// Number-----------------
	@SuppressWarnings("unchecked")
	public String generateDiagNumber(int subChargeId) {

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<DiagParam> diagParamList = new ArrayList<DiagParam>();
		Session session = (Session) getSession();
		String diagSeqNo = "";
		String date = "";
		String subChargeCode = "";
		String prefix = "";
		date = (String) utilMap.get("currentDate");
		String criteria = "";
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		List<DgSampleCollectionHeader> sampleCollList = new ArrayList<DgSampleCollectionHeader>();
		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			diagParamList = session.createCriteria(DiagParam.class)
					.createAlias("SubCharge", "charge").add(
							Restrictions.eq("charge.Id", subChargeId)).add(
							Restrictions.eq("Status", "y")).list();
			if (diagParamList.size() > 0) {
				DiagParam diagParam = (DiagParam) diagParamList.get(0);
				criteria = diagParam.getCriteria();
				if (criteria.equals("c")) {
					int seqNo = diagParam.getSeqNo();
					DiagParam diagParamobj = (DiagParam) hbt.load(
							DiagParam.class, diagParam.getId());
					diagParamobj.setSeqNo((seqNo + 1));
					hbt.update(diagParamobj);
					// subChargeCode =
					// diagParam.getSubCharge().getSubChargecodeCode();
					prefix = diagParam.getPrefix();

					diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo + 1));
					diagSeqNo = diagSeqNo.concat("/").concat(prefix);
					// diagSeqNo =
					// diagSeqNo.concat("/").concat(serviceStatusCode);
					diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
					diagSeqNo = diagSeqNo.concat("/").concat(currentYear);
				}
				if (criteria.equals("m")) {
					int seqNo = diagParam.getSeqNo();
					Date now = new Date();
					Calendar today = Calendar.getInstance();
					// today.setTime(now);

					boolean mnthchnged = false;
					if ((mnthchnged == false)
							&& (today.get(Calendar.DATE) == 1) && seqNo != 1) {
						seqNo = 0;
						mnthchnged = true;
					} else {
						seqNo = diagParam.getSeqNo();
					}
					if ((mnthchnged == true) && (today.get(Calendar.DATE) != 1)) {
						mnthchnged = false;
					}
					DiagParam diagParamobj = (DiagParam) hbt.load(
							DiagParam.class, diagParam.getId());
					diagParamobj.setSeqNo((seqNo + 1));
					hbt.update(diagParamobj);

					// subChargeCode =
					// diagParam.getSubCharge().getSubChargecodeCode();
					prefix = diagParam.getPrefix();

					diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo + 1));
					diagSeqNo = diagSeqNo.concat("/").concat(prefix);
					diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
					diagSeqNo = diagSeqNo.concat("/").concat(currentYear);
				}
				if (criteria.equals("y")) {
					int seqNo = diagParam.getSeqNo();
					Calendar today = Calendar.getInstance();
					boolean yrChangd = false;
					if ((yrChangd == false)
							&& (today.MONTH == Calendar.JANUARY)
							&& (today.DAY_OF_MONTH == 1) && seqNo != 1) {
						seqNo = 0;
						yrChangd = true;
					} else {
						seqNo = diagParam.getSeqNo();
					}
					if ((yrChangd == false) && (today.DAY_OF_MONTH != 1)) {
						yrChangd = false;
					}

					DiagParam diagParamobj = (DiagParam) hbt.load(
							DiagParam.class, diagParam.getId());
					diagParamobj.setSeqNo((seqNo + 1));
					hbt.update(diagParamobj);
					// subChargeCode =
					// diagParam.getSubCharge().getSubChargecodeCode();
					prefix = diagParam.getPrefix();

					diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo + 1));
					diagSeqNo = diagSeqNo.concat("/").concat(prefix);
					diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
					diagSeqNo = diagSeqNo.concat("/").concat(currentYear);
				}
			} else if (diagParamList.size() == 0) {
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return diagSeqNo;
	}

	// ------------------------Mehod For display to Sample
	// Number-----------------
	@SuppressWarnings("unchecked")
	public String getSampleSeqForDisplay(String string) {
		List<Integer> sampleSeqNoList = new ArrayList<Integer>();
		List<DgSampleCollectionDetails> seqNoList = new ArrayList<DgSampleCollectionDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String sampleSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(DgSampleCollectionDetails.class)
					.list();
			if (seqNoList.size() > 0) {

				for (DgSampleCollectionDetails dgSampleCollectionDetails : seqNoList) {
					lastSeqNo = dgSampleCollectionDetails.getSampleNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			sampleSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", string))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (sampleSeqNoList.size() > 0) {
				for (Integer maxSampleNo : sampleSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						sampleSeqNo = String.valueOf(maxSampleNo + 1);
					} else {
						sampleSeqNo = String.valueOf(1);
					}
				}
			} else {
				sampleSeqNo = String.valueOf(1);
			}
			sampleSeqNo = sampleSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sampleSeqNo;
	}

	// ------------------------Mehod For generate to Sample
	// Number-----------------
	public String generateSampleNumber(int hospitalId) {
		String sampleSeqNo = "";
		List<TransactionSequence> sampleList = new ArrayList<TransactionSequence>();
		List<DgSampleCollectionDetails> seqNoList = new ArrayList<DgSampleCollectionDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		String lastSeqNo = "";
		String lastSeqYear = "";
		seqNoList = session.createCriteria(DgSampleCollectionDetails.class)
				.list();
		if (seqNoList.size() > 0) {
			for (DgSampleCollectionDetails dgSampleCollectionDetails : seqNoList) {
				lastSeqNo = dgSampleCollectionDetails.getSampleNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();
			}
		}
		try {
			sampleList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "SN")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (sampleList.size() > 0) {
			for (TransactionSequence transactionSequence : sampleList) {
				TransactionSequence obj = (TransactionSequence) sampleList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				sampleSeqNo = seqNo.toString().concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (sampleList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgSampleCollectionDetails");
			tsObj.setTransactionPrefix("SN");
			tsObj.setTransactionSequenceName("Sample No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			hbt.save(tsObj);
			sampleSeqNo = sampleSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return sampleSeqNo;
	}

	// ------------------------------------------Report's
	// Screen------------------------------------
	// ------------------------------DiagnosticRegister---------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiagnosticRegisterJsp(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasServiceType> serviceTypeList = null;
		List<MasRank> rankList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<Object[]> unitList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasTrade> tradeList = null;
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasSection> sectionList = null;
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		int hospitalId = 0;
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		try {
			/*subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).createAlias(
							"MainChargecode", "mcc").createAlias(
							"mcc.Department", "dep").add(
							Restrictions.eq("dep.Id", deptId)).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
					*/
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y"))
				.createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.DepartmentTypeCode", "DIAG")).list();
			chargeCodeList = session.createCriteria(DgMasInvestigation.class).createAlias("SubChargecode", "sc").createAlias("MainChargecode", "mcc").createAlias("mcc.Department", "d").add(Restrictions.eq("Status", "y"))
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("InvestigationName")).add(Projections.property("d.Id"))
						.add(Projections.property("sc.Id"))).addOrder(Order.asc("InvestigationName")).list();

			serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
			serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("Id")).list();
			rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
							.createAlias("Station", "station").setProjection(Projections.projectionList()
							.add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
			maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MaritalStatusName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec")
							.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
			map.put("serviceTypeList", serviceTypeList);
			map.put("serviceStatusList", serviceStatusList);
			map.put("rankList", rankList);
			map.put("rankCategoryList", rankCategoryList);
			map.put("unitList", unitList);
			map.put("maritalStatusList", maritalStatusList);
			map.put("tradeList", tradeList);
			map.put("employeeList", employeeList);
			map.put("sexList", sexList);
			map.put("sectionList", sectionList);
			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}
			if (departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			}
			map.put("chargeCodeList", chargeCodeList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// -----------------------------DiagnosticRegisterDoctorWise--------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiagnosticRegisterDoctorWise(
			Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).createAlias(
							"MainChargecode", "mcc").createAlias(
							"mcc.Department", "dep").add(
							Restrictions.eq("dep.Id", deptId)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"eCat").add(Restrictions.eq("eCat.EmpCategoryCode", "01"))
					.add(Restrictions.eq("Department.Id", deptId)).list();

			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}
			if (employeeList.size() > 0) {
				map.put("employeeList", employeeList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// ---------------------------DiagnosticRegisterTestWise----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiagnosticRegisterDiagnosisWise(
			Map<String, Object> map) {
		Session session = (Session) getSession();

		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).createAlias(
							"MainChargecode", "mcc").createAlias(
							"mcc.Department", "dep").add(
							Restrictions.eq("dep.Id", deptId)).list();
			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}
			chargeCodeList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (chargeCodeList.size() > 0) {
				map.put("chargeCodeList", chargeCodeList);
			}
			List lst = new ArrayList();
			lst.add("DIAG");
			lst.add("RADIO");
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).add(
							Restrictions.eq("Status", "y")).createAlias(
							"Department", "dept").createAlias(
							"dept.DepartmentType", "dt").add(
							Restrictions.in("dt.DepartmentTypeCode", lst))
					.list();
			map.put("mainChargeCodeList", mainChargeCodeList);

			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).addOrder(
					Order.asc("dt.DepartmentTypeName")).list();
			map.put("wardList", wardList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// ------------------------------------------Packing list
	// --------------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPackingListJsp() {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		try {
			List lst = new ArrayList();
			lst.add("DIAG");
			lst.add("RADIO");

			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).add(
							Restrictions.eq("Status", "y")).createAlias(
							"Department", "dept").createAlias(
							"dept.DepartmentType", "dt").add(
							Restrictions.in("dt.DepartmentTypeCode", lst))
					.list();

			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).list();
			collectionCenterList = session.createCriteria(
					DgCollectionCenter.class).add(
					Restrictions.eq("Status", "y")).list();

			if (mainChargeCodeList.size() > 0) {
				detailsMap.put("mainChargeCodeList", mainChargeCodeList);
			}
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ----------------------------Department Wise
	// Summary-----------------------------------
	public Map<String, Object> showDepartmentWiseSummary() {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		try {

			collectionCenterList = session.createCriteria(
					DgCollectionCenter.class).add(
					Restrictions.eq("Status", "y")).list();

			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// -----------------------------Patient Details For Sample
	// Collection---------------------------------

	public Map<String, Object> getPatientDetailsForSampleCollection(
			Map<String, Object> mapForDs) {
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
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String diagnosisNo = "";

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
				Restrictions.eq("ResultStatus", "P")).add(
				Restrictions.between("ResultDate", fromDate, toDate))
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
		if (!diagnosisNo.equals("")) {
			crit = crit
					.createAlias("SampleCollectionHeader", "sampleHead")
					.add(Restrictions.eq("sampleHead.DiagnosisNo", diagnosisNo));
		}

		patientList = crit.list();
		map.put("patientList", patientList);
		return map;
	}

	// -------------------------NextPatient--------- For Sample Collection
	public Map<String, Object> getSampleCollectionDetailsForNext(int newOrderId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<MasDepartment> collectionCenterListForSampleCollection = new ArrayList<MasDepartment>();
		List<DgMasCollection> conatinerList = new ArrayList<DgMasCollection>();
		List<String> departmentType = new ArrayList<String>();
		departmentType.add("WARD");
		departmentType.add("Colle");

		Session session = (Session) getSession();
		int orderDetailId = 0;
		int orderHeaderId = 0;
		Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();
		try {
			/*employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}*/
			collectionCenterList = session.createCriteria(
					DgCollectionCenter.class).add(
					Restrictions.eq("Status", "y")).list();
			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}

			collectionCenterListForSampleCollection = session.createCriteria(
					MasDepartment.class).createAlias("DepartmentType", "dt")
					.add(
							Restrictions.in("dt.DepartmentTypeCode",
									departmentType)).list();
			if (collectionCenterListForSampleCollection.size() > 0) {
				detailsMap.put("collectionCenterListForSampleCollection",
						collectionCenterListForSampleCollection);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			conatinerList = session.createCriteria(DgMasCollection.class).add(
					Restrictions.eq("Status", "y")).list();
			if (conatinerList.size() > 0) {
				detailsMap.put("conatinerList", conatinerList);
			}

			dgOrderhdList = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("Id", newOrderId))
					.addOrder(Order.asc("Id")).list();

			if (dgOrderhdList != null || dgOrderhdList.size() > 0) {

				detailsMap.put("dgOrderhdList", dgOrderhdList);
			}
			if (dgOrderhdList.size() > 0) {
				for (DgOrderhd dgOrderhd : dgOrderhdList) {
					dgOrderdtSet = dgOrderhd.getDgOrderdts();
					orderHeaderId = dgOrderhd.getId();

				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ---------------------NextPatient For Sample Validation-------------------
	public Map<String, Object> getSampleValidationDetailsForNext(int newSampleId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		int sampleDetailId = 0;
		int sampleHeaderId = 0;
		Set<DgSampleCollectionDetails> dgsampleValidationSet = new HashSet<DgSampleCollectionDetails>();

		try {
			employeeCodeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			if (employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			samplehdList = session.createCriteria(
					DgSampleCollectionHeader.class).add(
					Restrictions.eq("Id", newSampleId)).addOrder(
					Order.asc("Id")).list();

			if (samplehdList != null || samplehdList.size() > 0) {

				detailsMap.put("samplehdList", samplehdList);
			}
			if (samplehdList.size() > 0) {
				for (DgSampleCollectionHeader dgSampleHeader : samplehdList) {
					dgsampleValidationSet = dgSampleHeader
							.getDgSampleCollectionDetails();
					sampleHeaderId = dgSampleHeader.getId();

				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// --------------------Method For Connction of
	// Reports-------------------------
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	/*
	 * public String getOrderSeqForDisplay(String string) { // TODO
	 * Auto-generated method stub return null; }
	 */

	/*
	 * public Map<String, Object> getDetailsForSample() { Map<String , Object>
	 * map = new HashMap<String, Object>(); List<MasSubChargecode>
	 * subChargeCodeList = new ArrayList<MasSubChargecode>();
	 * List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	 * 
	 * Session session = (Session)getSession();
	 * 
	 * try { subChargeCodeList =
	 * session.createCriteria(MasSubChargecode.class).add
	 * (Restrictions.eq("Status", "y")).list(); chargeCodeList =
	 * session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status",
	 * "y")).list(); map.put("subChargeCodeList", subChargeCodeList);
	 * map.put("chargeCodeList", chargeCodeList); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return map; }
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<Patient> getHinNo(String
	 * serviceNo) { List<Patient> hinNoList = new ArrayList<Patient>(); Session
	 * session = (Session)getSession(); try { hinNoList =
	 * session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo",
	 * serviceNo)).list(); } catch (HibernateException e) { e.printStackTrace();
	 * } return hinNoList; }
	 */

	/*
	 * public String generateDiagNumber() { Map<String, Object>map = new
	 * HashMap<String, Object>(); List<TransactionSequence> diagSeqNoList = new
	 * ArrayList<TransactionSequence>(); Map<String, Object>utilMap = new
	 * HashMap<String, Object>(); utilMap = (Map<String,
	 * Object>)HMSUtil.getCurrentDateAndTime();
	 * 
	 * Session session = (Session) getSession(); String date = ""; date =
	 * (String)utilMap.get("currentDate"); String diagSeqNo = "";
	 * 
	 * try{ diagSeqNoList =
	 * session.createCriteria(TransactionSequence.class).add
	 * (Restrictions.eq("TransactionPrefix", "DN")).list();
	 * 
	 * }catch(HibernateException e){ e.printStackTrace(); }
	 * 
	 * HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * 
	 * if(diagSeqNoList.size() > 0 ){ for (TransactionSequence
	 * transactionSequence : diagSeqNoList) { TransactionSequence obj =
	 * (TransactionSequence)diagSeqNoList.get(0); int id = obj.getId(); int
	 * seqNo = obj.getTransactionSequenceNumber();
	 * 
	 * TransactionSequence transactionSequenceObj =
	 * (TransactionSequence)hbt.load(TransactionSequence.class, id);
	 * transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
	 * hbt.update(transactionSequenceObj);
	 * 
	 * diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo)).concat("/"); date =
	 * date.substring(3, date.length()); diagSeqNo = diagSeqNo.concat(date); }
	 * }else if(diagSeqNoList.size() == 0){ TransactionSequence tsObj = new
	 * TransactionSequence(); tsObj.setStatus("y");
	 * tsObj.setTablename("DgSampleCollectionDetails");
	 * tsObj.setTransactionPrefix("DN"); tsObj.setTransactionSequenceName("Diag
	 * No"); tsObj.setTransactionSequenceNumber(0);
	 * 
	 * hbt.save(tsObj); } return diagSeqNo; }
	 */
	/*
	 * private String generateDiagNumber(String string) { Map<String, Object>map
	 * = new HashMap<String, Object>(); List<TransactionSequence> diagSeqNoList
	 * = new ArrayList<TransactionSequence>(); Map<String, Object>utilMap = new
	 * HashMap<String, Object>(); utilMap = (Map<String,
	 * Object>)HMSUtil.getCurrentDateAndTime();
	 * 
	 * Session session = (Session) getSession(); String date = ""; date =
	 * (String)utilMap.get("currentDate"); String diagSeqNo = "";
	 * 
	 * try{ diagSeqNoList =
	 * session.createCriteria(TransactionSequence.class).add
	 * (Restrictions.eq("TransactionPrefix", "DN")).list();
	 * //System.out.println("diagSeqNoList------------"+diagSeqNoList);
	 * }catch(HibernateException e){ e.printStackTrace(); }
	 * 
	 * HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * 
	 * if(diagSeqNoList.size() > 0 ){ for (TransactionSequence
	 * transactionSequence : diagSeqNoList) { TransactionSequence obj =
	 * (TransactionSequence)diagSeqNoList.get(0); int id = obj.getId(); int
	 * seqNo = obj.getTransactionSequenceNumber();
	 * 
	 * TransactionSequence transactionSequenceObj =
	 * (TransactionSequence)hbt.load(TransactionSequence.class, id);
	 * transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
	 * hbt.update(transactionSequenceObj);
	 * 
	 * diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo)).concat("/"); date =
	 * date.substring(3, date.length()); diagSeqNo = diagSeqNo.concat(date);
	 * //System.out.println("diagSeqNo----"+diagSeqNo); } }else
	 * if(diagSeqNoList.size() == 0){ TransactionSequence tsObj = new
	 * TransactionSequence(); tsObj.setStatus("y");
	 * tsObj.setTablename("DgSampleCollectionDetails");
	 * tsObj.setTransactionPrefix("DN"); tsObj.setTransactionSequenceName("Diag
	 * No"); tsObj.setTransactionSequenceNumber(0);
	 * 
	 * hbt.save(tsObj); } return diagSeqNo; }
	 */

	/*
	 * List<Integer> sampleSeqNoList = new ArrayList<Integer>();
	 * List<DgSampleCollectionDetails> seqNoList = new
	 * ArrayList<DgSampleCollectionDetails>(); String sampleSeqNo = ""; String
	 * lastSeqNo = ""; String lastSeqYear = ""; Map<String,Object> utilMap = new
	 * HashMap<String,Object>(); utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 * String date = (String)utilMap.get("currentDate");
	 * 
	 * String currentYear = date.substring(date.lastIndexOf("/")+1); Session
	 * session = (Session) getSession(); try{ seqNoList =
	 * session.createCriteria(DgSampleCollectionDetails.class).list();
	 * if(seqNoList.size() > 0){
	 * 
	 * for (DgSampleCollectionDetails dgSampleCollectionDetails : seqNoList) {
	 * lastSeqNo = dgSampleCollectionDetails.getSampleNo(); } StringTokenizer
	 * str = new StringTokenizer(lastSeqNo,"/"); while(str.hasMoreTokens()){
	 * lastSeqYear = str.nextToken(); } }else{ lastSeqYear = currentYear; }
	 * sampleSeqNoList =
	 * session.createCriteria(TransactionSequence.class).add(Restrictions
	 * .eq("TransactionPrefix", "SN")).setProjection(
	 * Projections.projectionList() .add(
	 * Projections.max("TransactionSequenceNumber") ) ).list();
	 * if(sampleSeqNoList.size() > 0){ for(Integer maxSampleNo :
	 * sampleSeqNoList){ if(currentYear.equals(lastSeqYear)){ sampleSeqNo =
	 * String.valueOf(maxSampleNo+1); }else{ sampleSeqNo = String.valueOf(1); }
	 * } }else{ sampleSeqNo = String.valueOf(1); } sampleSeqNo =
	 * sampleSeqNo.concat("/").concat(String.valueOf(lastSeqYear));
	 * }catch(HibernateException e){ e.printStackTrace(); } return sampleSeqNo;
	 */
	/*
	 * public Map<String, Object> getPatientDetail(String visitNo) {
	 * //System.out.println("getPatientDetail--in dataService"); Session session =
	 * (Session)getSession(); Map<String, Object> detailsMap = new
	 * HashMap<String, Object>(); List<Visit> visitList = new
	 * ArrayList<Visit>(); try { visitList =
	 * session.createCriteria(Visit.class).add(Restrictions.eq("Id",
	 * visitNo)).list(); //System.out.println("visitList---in Data
	 * service------"+visitList); if(visitList.size() > 0){
	 * detailsMap.put("visitList", visitList); } } catch (HibernateException e)
	 * { e.printStackTrace(); } return detailsMap; }
	 */

	/*
	 * public List<Visit> getVisitNo(int hinId) { Session session =
	 * (Session)getSession(); List<Visit> visitNoList = new ArrayList<Visit>();
	 * 
	 * //visitNoList = session.createCriteria(Visit.class).createAlias("Hin",
	 * "p").add(Restrictions.eq("p.PFirstName", patientName)).list();
	 * visitNoList = session.createCriteria(Visit.class).setProjection(
	 * Projections
	 * .projectionList().add(Projections.max("VisitNo"))).createAlias("Hin",
	 * "p").add(Restrictions.eq("p.Id", hinId)).list();
	 * 
	 * return visitNoList; }
	 */

	public List<Visit> getVisitNo(String hinNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getDetailsForValidationSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showSampleNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getHinNoList(String serviceNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DgOrderhd> getOrderNoList(Map<String, Object> mapForDs) {
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		int orderDetailId = 0;
		int orderHeaderId = 0;
		String serviceNo = "";
		Integer hinId = 0;
		String hinNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String pType = "";
		String orderStatus = "";
		String adNo = "";
		int subGroupId = 0;
		int chargeCodeId = 0;
		int departmentId = 0;
		int dgOrderHdId = 0;
		int inPatientId = 0;
		Criteria crit = null;

		// if(mapForDs.get("hinId") != null){
		// hinId = (Integer)(mapForDs.get("hinId"));
		// }
		// /////////////////////////////////////////////////////////////
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) mapForDs.get("dgOrderHdId");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("inPatientId") != null) {
			inPatientId = (Integer) mapForDs.get("inPatientId");
		}

		// if (mapForDs.get("subGroupId") != null) {
		// subGroupId = (Integer) mapForDs.get("subGroupId");
		// }
		// if (mapForDs.get("hinId") != null) {
		// hinId = (Integer) mapForDs.get("hinId");
		// }
		// if (mapForDs.get("chargeCodeId") != null) {
		// chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		// }
		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		// if (mapForDs.get("departmentId") != null) {
		// departmentId = (Integer) mapForDs.get("departmentId");
		// }
		// if (mapForDs.get("orderStatus") != null) {
		// orderStatus = (String) mapForDs.get("orderStatus");
		// }
		try {
			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Id", dgOrderHdId));
			} else if (inPatientId != 0) {
				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Inpatient.Id", inPatientId));
			} else {
				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("PatientType", pType)).add(
						Restrictions.eq("OrderStatus", "P")).add(
						Restrictions.between("OrderDate", fromDate, toDate))
						.createAlias("Hin", "pt");
				if (!adNo.equals("")) {
					crit = crit.createAlias("Inpatient", "ip").add(
							Restrictions.eq("ip.AdNo", adNo));
				}
				if (!serviceNo.equals("")) {
					crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
				}
				// if (hinId != 0) {
				// crit = crit.add(Restrictions.eq("pt.Id", hinId));
				// }
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
				}
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("pt.PFirstName",
							patientFName + "%"));
				}
				if (!serPersonFName.equals("")) {
					crit = crit.add(Restrictions.like("pt.SFirstName",
							serPersonFName + "%"));
				}
				if (subGroupId != 0) {
					crit = crit.createAlias("SubChargeid", "sc").add(
							Restrictions.eq("sc.Id", subGroupId));
				}
				if (chargeCodeId != 0) {
					crit = crit.createAlias("ChargeCode", "ch").add(
							Restrictions.eq("ch.Id", chargeCodeId));
				}
			}
			dgOrderhdList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		// ///////////////////////////////////////////////

		// Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();

		// try{
		// dgOrderhdList =
		// session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Hin.Id",
		// hinId))
		// .add(Restrictions.eq("OrderStatus", "P"))
		// .addOrder( Order.asc("Id")).list();
		// } catch (HibernateException e) {
		// e.printStackTrace();
		// }
		return dgOrderhdList;
	}

	public Map<String, Object> getOrderNoForCancelOrderList(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> dgOrderhdTempList = new ArrayList<DgOrderhd>();

		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();

		String serviceNo = "";
		String hinNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String pType = "";
		String adNo = "";

		Integer dgOrderhdId = 0;

		Criteria crit = null;

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
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
		try {
			crit = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("PatientType", pType)).add(
					Restrictions.between("OrderDate", fromDate, toDate))
					.createAlias("Hin", "pt");
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.SFirstName",
						serPersonFName + "%"));
			}
			dgOrderhdList = (List<DgOrderhd>) crit.list();

			for (DgOrderhd dgOrderhd : dgOrderhdList) {
				List<Integer> dgSampleCollectionDetailsRowCount = new ArrayList<Integer>();
				List<DgOrderdt> dgOrderdtRowCount = new ArrayList<DgOrderdt>();
				List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabRowCount = new ArrayList<DgSampleCollectionDetails>();

				dgOrderhdId = dgOrderhd.getId();
				/************** Get Order Status Dettails For Radiology ************/
				if (dgOrderhdId != 0) {
					crit = session.createCriteria(
							DgSampleCollectionHeader.class).add(
							Restrictions.eq("Order.Id", dgOrderhdId))
							// .add(Restrictions.eq("OrderStatus", "P"))
							.createAlias("Department", "dep").add(
									Restrictions.eq("dep.Id", 49))
							.setProjection(Projections.property("Id"));
					dgSampleCollectionHeaderIds = crit.list();
				}
				if (dgSampleCollectionHeaderIds.size() > 0) {
					crit = session.createCriteria(
							DgSampleCollectionDetails.class).add(
							Restrictions.in("SampleCollectionHeader.Id",
									dgSampleCollectionHeaderIds)).createAlias(
							"Maincharge", "mc").add(
							Restrictions.eq("OrderStatus", "P")).add(
							Restrictions.eq("mc.MainChargecodeCode", "Radio"));
					// .setProjection(Projections.rowCount());
					dgSampleCollectionDetailsRowCount = crit.list();

				}
				/************ End Order Status Details For Radiology *****************/

				/********** Get Order Status Details For Lab ********************/
				if (dgOrderhdId != 0) {
					crit = session.createCriteria(DgOrderdt.class).add(
							Restrictions.eq("Orderhd.Id", dgOrderhdId))
							.createAlias("MainChargecode", "mcc").add(
									Restrictions.eq("mcc.MainChargecodeCode",
											"Lab")).add(
									Restrictions.eq("OrderStatus", "P"))
							.addOrder(Order.asc("ChargeCode.Id"));
					// .setProjection(Projections.rowCount());
					dgOrderdtRowCount = crit.list();
				}
				if (dgOrderhdId != 0) {
					crit = session.createCriteria(
							DgSampleCollectionHeader.class).add(
							Restrictions.eq("Order.Id", dgOrderhdId))
							// .add(Restrictions.eq("OrderStatus", "P"))
							.createAlias("Department", "dep").add(
									Restrictions.eq("dep.Id", 48))
							.setProjection(Projections.property("Id"));
					dgSampleCollectionHeaderLabIds = crit.list();
				}
				if (dgSampleCollectionHeaderLabIds.size() > 0) {
					crit = session.createCriteria(
							DgSampleCollectionDetails.class).add(
							Restrictions.in("SampleCollectionHeader.Id",
									dgSampleCollectionHeaderLabIds))
							.createAlias("Maincharge", "mc").add(
									Restrictions.eq("OrderStatus", "P")).add(
									Restrictions.eq("mc.MainChargecodeCode",
											"Lab"));
					// .setProjection(Projections.rowCount());
					dgSampleCollectionDetailsLabRowCount = crit.list();

				}
				/*********** End Get Order Status Details For Lab **********/

				/*********** Remove Object From List Which is not Pending *********/
				if (dgSampleCollectionDetailsRowCount.size() == 0
						&& dgOrderdtRowCount.size() == 0
						&& dgSampleCollectionDetailsLabRowCount.size() == 0) {
					dgOrderhdTempList.add(dgOrderhd);
				}
			}
			dgOrderhdList.removeAll(dgOrderhdTempList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		detailsMap.put("dgOrderhdList", dgOrderhdList);
		return detailsMap;
	}

	public Map<String, Object> getTestDetailsForCancel(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Session session = (Session) getSession();

		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();
		List<Integer> chargeCodeIds = new ArrayList<Integer>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();

		Integer dgOrderhdId = 0;

		Criteria crit = null;

		if (mapForDs.get("dgOrderHdId") != null) {
			dgOrderhdId = (Integer) mapForDs.get("dgOrderHdId");
		}
		try {
			/************** Get Order Status Details For Radiology ************/
			if (dgOrderhdId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", dgOrderhdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep").add(
								Restrictions.eq("dep.Id", 49)).setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderIds = crit.list();
			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "P")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio"));
				dgSampleCollectionDetailsList = crit.list();

			}
			/************ End Order Status Details For Radiology *****************/

			/********** Get Order Status Details For Lab ********************/
			if (dgOrderhdId != 0) {
				crit = session.createCriteria(DgOrderdt.class).add(
						Restrictions.eq("Orderhd.Id", dgOrderhdId))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.add(Restrictions.eq("OrderStatus", "P")).addOrder(
								Order.asc("ChargeCode.Id"));
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class).add(
						Restrictions.in("ChargeCode.Id", chargeCodeIds))
						.addOrder(Order.asc("ChargeCode.Id")).setProjection(
								Projections.groupProperty("ChargeCode.Id"))
						.setProjection(
								Projections.property("InvestigationName"));
				dgMasInvestigationList = crit.list();
			}

			if (dgOrderhdId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", dgOrderhdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep").add(
								Restrictions.eq("dep.Id", 48)).setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "P"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"));
				dgSampleCollectionDetailsLabList = crit.list();

			}
			/*********** End Get Order Status Details For Lab **********/

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		detailsMap.put("dgSampleCollectionDetailsList",
				dgSampleCollectionDetailsList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgSampleCollectionDetailsLabList",
				dgSampleCollectionDetailsLabList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("dgOrderhdId", dgOrderhdId);
		return detailsMap;
	}

	public Map<String, Object> cancelTestsInDgOrderdt(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		Criteria crit = null;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
		List<String> orderStatusList = new ArrayList<String>();
		List<String> orderStatusAllList = new ArrayList<String>();

		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();
		Transaction tx = null;

		Integer dgOrderhdId = 0;
		boolean noOrderdtOfRadio = true;

		boolean allLabTestCancelled = true;
		if (mapForDs.get("dgOrderdtIdList") != null) {
			dgOrderdtIdList = (List<Integer>) mapForDs.get("dgOrderdtIdList");
		}
		if (mapForDs.get("dgOrderhdId") != null) {
			dgOrderhdId = Integer
					.parseInt((String) mapForDs.get("dgOrderhdId"));
		}
		if (dgOrderhdId != 0) {
			crit = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("Id", dgOrderhdId));
			dgOrderhdList = crit.list();
			try {
				tx = session.beginTransaction();
				if (dgOrderhdList.size() > 0) {
					DgOrderhd dgOrderhd = dgOrderhdList.get(0);
					dgOrderdtSet = dgOrderhd.getDgOrderdts();
					if (dgOrderdtIdList.size() == dgOrderdtSet.size()) {
						for (DgOrderdt dgOrderdt : dgOrderdtSet) {
							dgOrderdt.setOrderStatus("X");
							hbt.update(dgOrderdt);
							hbt.refresh(dgOrderdt);
						}
						dgOrderhd.setOrderStatus("X");
						dgOrderhd.setLabOrderStatus("LX");
						hbt.update(dgOrderhd);
						hbt.refresh(dgOrderhd);
					} else {
						allLabTestCancelled = true;
						for (DgOrderdt dgOrderdt : dgOrderdtSet) {
							if (dgOrderdtIdList.contains(dgOrderdt.getId())) {
								dgOrderdt.setOrderStatus("X");
								hbt.update(dgOrderdt);
								hbt.refresh(dgOrderdt);
							}
							if (dgOrderdt.getMainChargecode()
									.getMainChargecodeCode().equalsIgnoreCase(
											"Lab")
									&& !dgOrderdt.getOrderStatus()
											.equalsIgnoreCase("X")) {
								allLabTestCancelled = false;
							}
							if (dgOrderdt.getMainChargecode()
									.getMainChargecodeCode().equalsIgnoreCase(
											"Lab")) {
								orderStatusList.add(dgOrderdt.getOrderStatus());
							}
							if (dgOrderdt.getMainChargecode()
									.getMainChargecodeCode().equalsIgnoreCase(
											"Radio")) {
								noOrderdtOfRadio = false;
							}
							orderStatusAllList.add(dgOrderdt.getOrderStatus());
						}
						if (allLabTestCancelled) {
							if (noOrderdtOfRadio) {
								dgOrderhd.setOrderStatus("X");
							}
							dgOrderhd.setLabOrderStatus("LX");
							hbt.update(dgOrderhd);
							hbt.refresh(dgOrderhd);
						}
						if (!orderStatusList.contains("P")) {
							if (orderStatusList.contains("C")) {
								if (noOrderdtOfRadio) {
									dgOrderhd.setOrderStatus("A");
								}
								dgOrderhd.setLabOrderStatus("LC");
								hbt.update(dgOrderhd);
								hbt.refresh(dgOrderhd);
							}
						}
						if (!orderStatusAllList.contains("P")) {
							if (orderStatusAllList.contains("A")
									|| orderStatusAllList.contains("C")) {
								dgOrderhd.setOrderStatus("A");
							}
						}
						if (!orderStatusAllList.contains("P")
								&& !orderStatusAllList.contains("A")
								&& !orderStatusAllList.contains("C")) {
							dgOrderhd.setOrderStatus("X");
						}
					}
				}
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		return detailsMap;
	}

	public Map<String, Object> cancelTestsInDgSampleCollectionDetailLab(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		Criteria crit = null;
		Transaction tx = null;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Integer dgOrderhdId = 0;

		Set<Integer> dgSampleCollectionHeaderLabIdSet = new LinkedHashSet<Integer>();
		List<Integer> dgSampleCollectionDetailLabIdList = new ArrayList<Integer>();

		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionHeader> dgSampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();
		Set<DgSampleCollectionDetails> dgSampleCollectionDetailSet = new HashSet<DgSampleCollectionDetails>();

		boolean allLabTestCancelled = true;

		if (mapForDs.get("dgSampleCollectionHeaderLabIdSet") != null) {
			dgSampleCollectionHeaderLabIdSet = (Set<Integer>) mapForDs
					.get("dgSampleCollectionHeaderLabIdSet");
		}
		if (mapForDs.get("dgSampleCollectionDetailLabIdList") != null) {
			dgSampleCollectionDetailLabIdList = (List<Integer>) mapForDs
					.get("dgSampleCollectionDetailLabIdList");
		}
		for (Integer dgSampleCollectionHeaderId : dgSampleCollectionHeaderLabIdSet) {
			crit = session.createCriteria(DgSampleCollectionHeader.class).add(
					Restrictions.eq("Id", dgSampleCollectionHeaderId));
			dgSampleCollectionHeaderList = crit.list();
			try {
				tx = session.beginTransaction();
				if (dgSampleCollectionHeaderList.size() > 0) {
					DgSampleCollectionHeader dgSampleCollectionHeader = dgSampleCollectionHeaderList
							.get(0);
					dgSampleCollectionDetailSet = dgSampleCollectionHeader
							.getDgSampleCollectionDetails();
					List<String> orderStatusList = new ArrayList<String>();
					allLabTestCancelled = true;
					for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailSet) {
						if (dgSampleCollectionDetailLabIdList
								.contains(dgSampleCollectionDetails.getId())) {
							dgSampleCollectionDetails.setOrderStatus("X");
							hbt.update(dgSampleCollectionDetails);
							hbt.refresh(dgSampleCollectionDetails);
						}
						if (dgSampleCollectionDetails.getMaincharge()
								.getMainChargecodeCode()
								.equalsIgnoreCase("Lab")
								&& !dgSampleCollectionDetails.getOrderStatus()
										.equalsIgnoreCase("X")) {
							allLabTestCancelled = false;
						}
						if (dgSampleCollectionDetails.getMaincharge()
								.getMainChargecodeCode()
								.equalsIgnoreCase("Lab")) {
							orderStatusList.add(dgSampleCollectionDetails
									.getOrderStatus());
						}
					}
					if (allLabTestCancelled) {
						dgSampleCollectionHeader.setOrderStatus("X");
						hbt.update(dgSampleCollectionHeader);
						hbt.refresh(dgSampleCollectionHeader);
					}
					if (!orderStatusList.contains("P")) {
						if (orderStatusList.contains("A")
								|| orderStatusList.contains("E")) {
							dgSampleCollectionHeader.setOrderStatus("A");
							hbt.update(dgSampleCollectionHeader);
							hbt.refresh(dgSampleCollectionHeader);
						}
					}
				}
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		return detailsMap;
	}

	public Map<String, Object> cancelTestsInDgSampleCollectionDetail(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		Criteria crit = null;
		Transaction tx = null;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Integer dgSampleCollectionhdId = 0;
		int dgOrderhdCommonId = 0;
		List<Integer> dgSampleCollectionDetailIdList = new ArrayList<Integer>();
		List<Integer> cancelledChargeCodeIds = new ArrayList<Integer>();
		List<String> orderStatusList = new ArrayList<String>();

		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionHeader> dgSampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();
		Set<DgSampleCollectionDetails> dgSampleCollectionDetailSet = new HashSet<DgSampleCollectionDetails>();

		boolean allTestCancelled = true;

		if (mapForDs.get("dgSampleCollectionhdId") != null) {
			dgSampleCollectionhdId = Integer.parseInt((String) mapForDs
					.get("dgSampleCollectionhdId"));
		}
		if (mapForDs.get("dgSampleCollectionDetailIdList") != null) {
			dgSampleCollectionDetailIdList = (List<Integer>) mapForDs
					.get("dgSampleCollectionDetailIdList");
		}
		if (mapForDs.get("dgOrderhdCommonId") != null) {
			dgOrderhdCommonId = Integer.parseInt((String) mapForDs
					.get("dgOrderhdCommonId"));
		}
		if (mapForDs.get("cancelledChargeCodeIds") != null) {
			cancelledChargeCodeIds = (List<Integer>) mapForDs
					.get("cancelledChargeCodeIds");
		}

		DgOrderhd dgOrderhdToUpdate = (DgOrderhd) hbt.load(DgOrderhd.class,
				dgOrderhdCommonId);
		Set<DgOrderdt> set = dgOrderhdToUpdate.getDgOrderdts();

		for (DgOrderdt orderDt : set) {
			int dgOrderdtId = orderDt.getId();
			if (cancelledChargeCodeIds
					.contains(orderDt.getChargeCode().getId())) {
				orderDt.setOrderStatus("X");
				hbt.update(orderDt);
				hbt.refresh(orderDt);
			}
			orderStatusList.add(orderDt.getOrderStatus());
		}
		if (!orderStatusList.contains("P")
				&& (orderStatusList.contains("A") || orderStatusList
						.contains("C"))) {
			dgOrderhdToUpdate.setOrderStatus("A");
		}
		if (!orderStatusList.contains("P") && !orderStatusList.contains("A")
				&& !orderStatusList.contains("C")) {
			dgOrderhdToUpdate.setOrderStatus("X");
		}

		if (dgSampleCollectionhdId != 0) {
			crit = session.createCriteria(DgSampleCollectionHeader.class).add(
					Restrictions.eq("Id", dgSampleCollectionhdId));
			dgSampleCollectionHeaderList = crit.list();
			try {
				tx = session.beginTransaction();
				if (dgSampleCollectionHeaderList.size() > 0) {
					DgSampleCollectionHeader dgSampleCollectionHeader = dgSampleCollectionHeaderList
							.get(0);
					dgSampleCollectionDetailSet = dgSampleCollectionHeader
							.getDgSampleCollectionDetails();
					List<String> orderStatusForSampleCollectionList = new ArrayList<String>();
					allTestCancelled = true;
					for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailSet) {
						if (dgSampleCollectionDetailIdList
								.contains(dgSampleCollectionDetails.getId())) {
							dgSampleCollectionDetails.setOrderStatus("X");
							hbt.update(dgSampleCollectionDetails);
							hbt.refresh(dgSampleCollectionDetails);
						}
						if (dgSampleCollectionDetails.getMaincharge()
								.getMainChargecodeCode().equalsIgnoreCase(
										"Radio")
								&& !dgSampleCollectionDetails.getOrderStatus()
										.equalsIgnoreCase("X")) {
							allTestCancelled = false;
						}
						orderStatusForSampleCollectionList
								.add(dgSampleCollectionDetails.getOrderStatus());
					}
					if (allTestCancelled) {
						dgSampleCollectionHeader.setOrderStatus("X");
						hbt.update(dgSampleCollectionHeader);
						hbt.refresh(dgSampleCollectionHeader);
					}
					if (!orderStatusForSampleCollectionList.contains("P")) {
						if (orderStatusForSampleCollectionList.contains("A")
								|| orderStatusForSampleCollectionList
										.contains("E")) {
							dgSampleCollectionHeader.setOrderStatus("A");
							hbt.update(dgSampleCollectionHeader);
							hbt.refresh(dgSampleCollectionHeader);
						}
					}
				}
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		return detailsMap;
	}

	public Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
				Box box =(Box)mapForDs.get("box");
				Criteria cr = null;
				List<DgOrderdt> dgOrderDtList = new ArrayList<DgOrderdt>();
				List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
				List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
				Session session = (Session) getSession();
				int pagingSize = 10;
				int pageNo = 1;	
				int hospitalId =1;
				int hinId=0;
				//String ServiceNo = box.getString("ServiceNo");
/*			if (box.getString("PN") != null)
					pageNo = Integer.parseInt(box.getString("PN"));*/
			
			if (mapForDs.get("PN") != null)
				pageNo = (Integer)mapForDs.get("PN");
			if (mapForDs.get("hinId") != null)
				hinId = (Integer)mapForDs.get("hinId");
				List<Integer> dtIdList = new ArrayList<>();
			 List<Integer> sampleCollectionId = new ArrayList<>();
			 List<Integer> sampleCollectionIdDtIds = new ArrayList<>();
			 List<Integer> resultEntryOrderDtIds = new ArrayList<>();
			 dtIdList.add(0);
			 sampleCollectionId.add(0);
			 
				
				String patientTypeNameForOther="";
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");

				try {
					properties.load(resourcePath.openStream());			 
					patientTypeNameForOther=properties.getProperty("patientTypeNameForOther");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				cr =  session.createCriteria(DgOrderdt.class)
						.createAlias("Orderhd", "hd")
						.add(Restrictions.eq("hd.Hin.Id", hinId))
						.createAlias("MainChargecode", "mc")
							.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
							.addOrder(Order.desc("hd.OrderDate"))
								;		
				
				List totalMatches = cr.list();
				cr = cr.setFirstResult(pagingSize * (pageNo - 1));
				cr = cr.setMaxResults(pagingSize);
				dgOrderDtList = cr.list();
				System.out.println("totalMatches"+totalMatches.size());
				System.out.println("totalMatches"+dgOrderDtList.size());

				
				for(DgOrderdt dt: dgOrderDtList){
					//if(dt.getOrderStatus().equalsIgnoreCase("C"))
						dtIdList.add(dt.getId());
				}
				
				dgSampleCollectionDetailsList = session.createCriteria(DgSampleCollectionDetails.class)
						.createAlias("Orderdt", "dt")
						.add(Restrictions.in("dt.Id", dtIdList)).list();
				
				for(DgSampleCollectionDetails collectionDt: dgSampleCollectionDetailsList){
					sampleCollectionIdDtIds.add(collectionDt.getOrderdt().getId());
					if(collectionDt.getOrderStatus().equalsIgnoreCase("e")){
						sampleCollectionId.add(collectionDt.getId());
					}
				}
				
				dgResultEntryDetailList = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								sampleCollectionId)).list();
				
				for(DgResultEntryDetail result: dgResultEntryDetailList){
					//if(result.getResultDetailStatus().equalsIgnoreCase("A"))
						resultEntryOrderDtIds.add(result.getSampleCollectionDetails().getOrderdt().getId());
				}
				
				
				int totalRecords = totalMatches.size();
				totalMatches.clear();
				
			
				map.put("dgOrderDtList", dgOrderDtList);		
				map.put("totalRecords", totalRecords);
				map.put("dgSampleCollectionDetailsList", dgSampleCollectionDetailsList);	
				map.put("dgResultEntryDetailList", dgResultEntryDetailList);	
				
				map.put("resultEntryOrderDtIds", resultEntryOrderDtIds);	
				map.put("sampleCollectionIdDtIds", sampleCollectionIdDtIds);	
				
				return map;
				
			}

	
	public Map<String, Object> getOrderDtMap1(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailOnlyMultipleLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderOnlySensitiveLabIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<String> scdRadioInvestigationList = new ArrayList<String>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();
	
		List<Integer> dgSampleCollectionDtTemplateIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailTemplateIdList = new ArrayList<Integer>();
		List<DgResultEntryHeader> dgResultEntryHeaderTemplateList = new ArrayList<DgResultEntryHeader>();
		
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		// session.setFlushMode(FlushMode.NEVER);
		//int dgOrderHdId = 0;
		int hinId = 0;
		Criteria crit = null;

	/*	if (mapForDs.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) mapForDs.get("dgOrderHdId");
		}*/
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		try {
			// /////////////////////////////////// Get Order Status Dettails For
			// Radiology ///////////////////////////////
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
			if (hinId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Hin.Id", hinId))
						//.add(Restrictions.eq("Order.Id", dgOrderHdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
					//	.createAlias("Department", "dep").add(
						//		Restrictions.eq("dep.Id", 49))
								.setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderIds = crit.list();
			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.ne("OrderStatus", "E")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio"));
				dgSampleCollectionDetailsList = crit.list();

			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio")).setProjection(
								Projections.property("Id"));
				dgSampleCollectionDetailsIds = crit.list();
			}
			if (dgSampleCollectionDetailsIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsIds)).createAlias(
						"ChargeCode", "cc").createAlias("cc.MainChargecode",
						"mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Radio"));
				dgResultEntryDetailList = crit.list();
			}
			// /////////////////////////////////// End Order Status Details For
			// Radiology ///////////////////////////////

			/********************************** Get Order Status Details For Lab ***************************************/
			List<String> orderStatus = new ArrayList<String>();
			orderStatus.add("P");
			orderStatus.add("X");
		String []chargeCode = {"Lab"};
			if (hinId != 0) {
				crit = session.createCriteria(DgOrderdt.class)
						.createAlias("Orderhd", "hd")
						.add(Restrictions.eq("hd.Hin.Id", hinId))
						//.add(Restrictions.eq("Orderhd.Id", dgOrderHdId))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.in("mcc.MainChargecodeCode", chargeCode))
						.add(Restrictions.in("OrderStatus", orderStatus))
						.addOrder(Order.asc("ChargeCode.Id"));
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class).add(
						Restrictions.in("ChargeCode.Id", chargeCodeIds))
						.addOrder(Order.asc("ChargeCode.Id"));

				dgMasInvestigationList = crit.list();
			}

			if (hinId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Hin.Id", hinId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						//.createAlias("Department", "dep").add(
						//		Restrictions.eq("dep.Id", 48))
								.setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.ne("OrderStatus", "E"))
						.add(Restrictions.in("mc.MainChargecodeCode", chargeCode));
				dgSampleCollectionDetailsLabList = crit.list();

			}
			// //////////// get only thos record which are not multiple type
			// ///////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.in("mc.MainChargecodeCode", chargeCode))
						.createAlias("Investigation", "inv").add(
								Restrictions.ne("inv.InvestigationType", "m"))
						.add(Restrictions.ne("inv.InvestigationType", "v"))
						//.add(Restrictions.ne("inv.InvestigationType", "t"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsLabIds = crit.list();
			}
			if (dgSampleCollectionDetailsLabIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsLabIds)).createAlias(
						"ChargeCode", "cc").createAlias("cc.MainChargecode",
						"mcc").add(
						Restrictions.in("mcc.MainChargecodeCode", chargeCode));
				dgResultEntryDetailLabList = crit.list();
			}
			// ///////////////// get only multiple type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "m"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlyMultipleLabIds = crit.list(); }
			 * if(dgSampleCollectionHeaderOnlyMultipleLabIds.size()>0){ crit =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderOnlyMultipleLabIds))
			 * .createAlias("MainChargecode", "mcc")
			 * .add(Restrictions.eq("mcc.MainChargecodeCode","Lab" ));
			 * dgResultEntryHeaderLabList = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.in("mc.MainChargecodeCode", chargeCode))
						.createAlias("Investigation", "inv").add(
								Restrictions.eq("inv.InvestigationType", "m"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailOnlyMultipleLabIds = crit.list();
			}
			if (dgSampleCollectionDetailOnlyMultipleLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(
								Restrictions
										.in("SampleCollectionDetails.Id",
												dgSampleCollectionDetailOnlyMultipleLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailIdList = crit.list();
			}
			if (dgResultEntryDetailIdList.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("Id", dgResultEntryDetailIdList))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.in("mcc.MainChargecodeCode", chargeCode));
				dgResultEntryHeaderLabList = crit.list();
			}
			
			/**
			 * Added By Ritu For Templates
			 * Date 10 Feb
			 * 
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.eq("inv.InvestigationType", "t"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDtTemplateIds = crit.list();
			}
			if (dgSampleCollectionDtTemplateIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(
								Restrictions
										.in("SampleCollectionDetails.Id",
												dgSampleCollectionDtTemplateIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailTemplateIdList = crit.list();
			}
			if (dgResultEntryDetailTemplateIdList.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("Id", dgResultEntryDetailTemplateIdList))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryHeaderTemplateList = crit.list();
			}
/**
 * End Of Code By Ritu
 */
			// ///////////////// get only Sensitive type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "v"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlySensitiveLabIds = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds)).createAlias(
						"DgMasInvestigation", "inv").add(
						Restrictions.eq("inv.InvestigationType", "v"))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryHeaderSensitiveLabList = crit.list();
			}

			/********************************** End Order Status Details For Lab ***************************************/
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList) {
			scdRadioInvestigationList.add(dgSampleCollectionDetails
					.getInvestigation().getInvestigationName());
		}
		detailsMap.put("dgSampleCollectionDetailsList",
				dgSampleCollectionDetailsList);
		detailsMap.put("scdRadioInvestigationList", scdRadioInvestigationList);

		detailsMap.put("dgResultEntryDetailList", dgResultEntryDetailList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("dgSampleCollectionDetailsLabList",
				dgSampleCollectionDetailsLabList);
		detailsMap
				.put("dgResultEntryDetailLabList", dgResultEntryDetailLabList);
		detailsMap
				.put("dgResultEntryHeaderLabList", dgResultEntryHeaderLabList);
		detailsMap.put("dgResultEntryHeaderSensitiveLabList",
				dgResultEntryHeaderSensitiveLabList);
		detailsMap.put("dgResultEntryHeaderTemplateList", dgResultEntryHeaderTemplateList);
		detailsMap.put("patientList",
				patientList);
		return detailsMap;
	}

	public Map<String, Object> printOrderStatusReport(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailOnlyMultipleLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderOnlySensitiveLabIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<String> subChargeCodeGroup = new ArrayList<String>();
		List<DgOrderdt> dgOrderdtForReport = new ArrayList<DgOrderdt>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<String> scdRadioInvestigationList = new ArrayList<String>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();

		Session session = (Session) getSession();
		// session.setFlushMode(FlushMode.NEVER);
		int orderIdForReport = 0;

		Criteria crit = null;

		if (mapForDs.get("orderIdForReport") != null) {
			orderIdForReport = (Integer) mapForDs.get("orderIdForReport");
		}

		try {
			// /////////////////////////////////// Get Order Status Dettails For
			// Radiology ///////////////////////////////
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", orderIdForReport))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep").add(
								Restrictions.eq("dep.Id", 49)).setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderIds = crit.list();
			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.ne("OrderStatus", "E")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio"));
				dgSampleCollectionDetailsList = crit.list();

			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio")).setProjection(
								Projections.property("Id"));
				dgSampleCollectionDetailsIds = crit.list();
			}
			if (dgSampleCollectionDetailsIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsIds)).createAlias(
						"ChargeCode", "cc").createAlias("cc.MainChargecode",
						"mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Radio"));
				dgResultEntryDetailList = crit.list();
			}
			// /////////////////////////////////// End Order Status Details For
			// Radiology ///////////////////////////////

			/********************************** Get Order Status Details For Lab ***************************************/
			List<String> orderStatus = new ArrayList<String>();
			orderStatus.add("P");
			orderStatus.add("X");
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgOrderdt.class).add(
						Restrictions.eq("Orderhd.Id", orderIdForReport))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.add(Restrictions.in("OrderStatus", orderStatus))
						.addOrder(Order.asc("ChargeCode.Id"));
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class).add(
						Restrictions.in("ChargeCode.Id", chargeCodeIds))
						.addOrder(Order.asc("ChargeCode.Id"));

				dgMasInvestigationList = crit.list();
			}

			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", orderIdForReport))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep").add(
								Restrictions.eq("dep.Id", 48)).setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.ne("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"));
				dgSampleCollectionDetailsLabList = crit.list();

			}
			// //////////// get only thos record which are not multiple type
			// ///////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.ne("inv.InvestigationType", "m"))
						.add(Restrictions.ne("inv.InvestigationType", "v"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsLabIds = crit.list();
			}
			if (dgSampleCollectionDetailsLabIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsLabIds)).createAlias(
						"ChargeCode", "cc").createAlias("cc.MainChargecode",
						"mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryDetailLabList = crit.list();
			}
			// ///////////////// get only multiple type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "m"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlyMultipleLabIds = crit.list(); }
			 * if(dgSampleCollectionHeaderOnlyMultipleLabIds.size()>0){ crit =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderOnlyMultipleLabIds))
			 * .createAlias("MainChargecode", "mcc")
			 * .add(Restrictions.eq("mcc.MainChargecodeCode","Lab" ));
			 * dgResultEntryHeaderLabList = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.eq("inv.InvestigationType", "m"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailOnlyMultipleLabIds = crit.list();
			}
			if (dgSampleCollectionDetailOnlyMultipleLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(
								Restrictions
										.in("SampleCollectionDetails.Id",
												dgSampleCollectionDetailOnlyMultipleLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						/*
						 * .setProjection(Projections.distinct(Projections
						 * .projectionList
						 * ().add(Projections.property("MenuType"))))
						 */
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailIdList = crit.list();
			}
			if (dgResultEntryDetailIdList.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("Id", dgResultEntryDetailIdList))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryHeaderLabList = crit.list();
			}

			// ///////////////// get only Sensitive type here //////////////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.eq("inv.InvestigationType", "v"))
						.setProjection(
								Projections
										.property("SampleCollectionHeader.Id"));
				dgSampleCollectionHeaderOnlySensitiveLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds)).createAlias(
						"DgMasInvestigation", "inv").add(
						Restrictions.eq("inv.InvestigationType", "v"))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryHeaderSensitiveLabList = crit.list();
			}

			/********************************** End Order Status Details For Lab ***************************************/

			/********************************** Get All Sub Charge Group Wise ***************************************/
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", orderIdForReport))
						.createAlias("SubChargeid", "scc")
						// .setProjection(Projections.groupProperty("scc.SubChargecodeName"))
						.setProjection(
								Projections
										.distinct(Projections
												.projectionList()
												.add(
														Projections
																.property("scc.SubChargecodeName"))));
				// .setProjection(Projections.property("scc.SubChargecodeName"));
				subChargeCodeGroup = crit.list();
			}
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgOrderdt.class).add(
						Restrictions.eq("Orderhd.Id", orderIdForReport));
				dgOrderdtForReport = crit.list();
				detailsMap.put("hinNo", dgOrderdtForReport.get(0).getOrderhd()
						.getHin().getHinNo());

				detailsMap.put("serviceNo", dgOrderdtForReport.get(0)
						.getOrderhd().getHin().getServiceNo());

				detailsMap.put("orderByDepartment", dgOrderdtForReport.get(0)
						.getOrderhd().getDepartment().getDepartmentName());
				Patient p = dgOrderdtForReport.get(0).getOrderhd().getHin();
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

				detailsMap.put("orderNo", dgOrderdtForReport.get(0)
						.getOrderhd().getOrderNo());

				detailsMap.put("orderDate", dgOrderdtForReport.get(0)
						.getOrderhd().getOrderDate());

				detailsMap.put("relationName", p.getRelation()
						.getRelationName());

				detailsMap.put("patientAge", p.getAge());

				detailsMap.put("sex", p.getSex().getAdministrativeSexName());

				// detailsMap.put("resultDate",
				// dgOrderdtForReport.get(0).getResultEntry().getResultDate());

				detailsMap.put("rankName", p.getRank().getRankName());

				detailsMap.put("subChargeCodeName", dgOrderdtForReport.get(0)
						.getSubChargeid().getSubChargecodeName());

				detailsMap.put("mainChargeCodeName", dgOrderdtForReport.get(0)
						.getMainChargecode().getMainChargecodeName());

				detailsMap.put("clinicalNotes", dgOrderdtForReport.get(0)
						.getOrderhd().getClinicalNote());

				String unitNameAndAddress = p.getUnit().getUnitName() + ","
						+ p.getUnit().getUnitAddress();
				detailsMap.put("unitNameAndAddress", unitNameAndAddress);
				if (p.getRecordOfficeAddress() != null) {
					String recordOfficeAddress = p.getRecordOfficeAddress()
							.getAddress();
					detailsMap.put("recordOfficeAddress", recordOfficeAddress);
				}

				// detailsMap.put("charge",
				// dgOrderdtForReport.get(0).getInvestigation().getInvestigationName());
				String patientType = dgOrderdtForReport.get(0).getOrderhd()
						.getPatientType();
				if (patientType.equalsIgnoreCase("IP")) {
					detailsMap.put("patientType", "In Patient");
				} else {
					detailsMap.put("patientType", "Out Patient");
				}

			}
			/********************************** Get All Sub Charge Group Wise ***************************************/
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList) {
			scdRadioInvestigationList.add(dgSampleCollectionDetails
					.getInvestigation().getInvestigationName());
		}
		detailsMap.put("dgSampleCollectionDetailsList",
				dgSampleCollectionDetailsList);
		detailsMap.put("scdRadioInvestigationList", scdRadioInvestigationList);

		detailsMap.put("dgResultEntryDetailList", dgResultEntryDetailList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("dgSampleCollectionDetailsLabList",
				dgSampleCollectionDetailsLabList);
		detailsMap
				.put("dgResultEntryDetailLabList", dgResultEntryDetailLabList);
		detailsMap
				.put("dgResultEntryHeaderLabList", dgResultEntryHeaderLabList);
		detailsMap.put("dgResultEntryHeaderSensitiveLabList",
				dgResultEntryHeaderSensitiveLabList);
		detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

		return detailsMap;
	}

	public Map<String, Object> getOrderDtForConfidentialTest(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailOnlyMultipleLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderOnlySensitiveLabIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();

		Session session = (Session) getSession();
		int dgOrderHdId = 0;

		Criteria crit = null;

		if (mapForDs.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) mapForDs.get("dgOrderHdId");
		}

		try {
			// /////////////////////////////////// Get Order Status Dettails For
			// Radiology ///////////////////////////////
			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", dgOrderHdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep").add(
								Restrictions.eq("dep.Id", 49)).setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderIds = crit.list();
			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.ne("OrderStatus", "E")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio"));
				dgSampleCollectionDetailsList = crit.list();

			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E")).add(
								Restrictions.eq("mc.MainChargecodeCode",
										"Radio")).setProjection(
								Projections.property("Id"));
				dgSampleCollectionDetailsIds = crit.list();
			}
			if (dgSampleCollectionDetailsIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsIds)).createAlias(
						"ChargeCode", "cc").createAlias("cc.MainChargecode",
						"mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Radio"));
				dgResultEntryDetailList = crit.list();
			}
			// /////////////////////////////////// End Order Status Details For
			// Radiology ///////////////////////////////

			/********************************** Get Order Status Details For Lab ***************************************/
			List<String> orderStatus = new ArrayList<String>();
			orderStatus.add("P");
			orderStatus.add("X");
			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgOrderdt.class).add(
						Restrictions.eq("Orderhd.Id", dgOrderHdId))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"))
						.add(Restrictions.in("OrderStatus", orderStatus))
						.addOrder(Order.asc("ChargeCode.Id"));
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class).add(
						Restrictions.in("ChargeCode.Id", chargeCodeIds))
						.addOrder(Order.asc("ChargeCode.Id"));

				dgMasInvestigationList = crit.list();
			}

			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", dgOrderHdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep").add(
								Restrictions.eq("dep.Id", 48)).setProjection(
								Projections.property("Id"));
				dgSampleCollectionHeaderLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.ne("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"));
				dgSampleCollectionDetailsLabList = crit.list();

			}
			// //////////// get only those record which are not multiple type
			// ///////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.ne("inv.InvestigationType", "m"))
						.add(Restrictions.ne("inv.InvestigationType", "v"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsLabIds = crit.list();
			}
			if (dgSampleCollectionDetailsLabIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryDetail.class).add(
						Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsLabIds)).createAlias(
						"ChargeCode", "cc").createAlias("cc.MainChargecode",
						"mcc").add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryDetailLabList = crit.list();
			}
			// ///////////////// get only multiple type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "m"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlyMultipleLabIds = crit.list(); }
			 * if(dgSampleCollectionHeaderOnlyMultipleLabIds.size()>0){ crit =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderOnlyMultipleLabIds))
			 * .createAlias("MainChargecode", "mcc")
			 * .add(Restrictions.eq("mcc.MainChargecodeCode","Lab" ));
			 * dgResultEntryHeaderLabList = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgSampleCollectionDetails.class)
						.add(
								Restrictions.in("SampleCollectionHeader.Id",
										dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc").add(
								Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Lab"))
						.createAlias("Investigation", "inv").add(
								Restrictions.eq("inv.InvestigationType", "m"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailOnlyMultipleLabIds = crit.list();
			}
			if (dgSampleCollectionDetailOnlyMultipleLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(
								Restrictions
										.in("SampleCollectionDetails.Id",
												dgSampleCollectionDetailOnlyMultipleLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Lab"))
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailIdList = crit.list();
			}
			if (dgResultEntryDetailIdList.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("Id", dgResultEntryDetailIdList))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryHeaderLabList = crit.list();
			}

			// ///////////////// get only Sensitive type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "v"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlySensitiveLabIds = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class).add(
						Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds)).createAlias(
						"DgMasInvestigation", "inv").add(
						Restrictions.eq("inv.InvestigationType", "v"))
						.createAlias("MainChargecode", "mcc").add(
								Restrictions
										.eq("mcc.MainChargecodeCode", "Lab"));
				dgResultEntryHeaderSensitiveLabList = crit.list();
			}

			/********************************** End Order Status Details For Lab ***************************************/
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		detailsMap.put("dgSampleCollectionDetailsList",
				dgSampleCollectionDetailsList);
		detailsMap.put("dgResultEntryDetailList", dgResultEntryDetailList);

		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("dgSampleCollectionDetailsLabList",
				dgSampleCollectionDetailsLabList);
		detailsMap
				.put("dgResultEntryDetailLabList", dgResultEntryDetailLabList);
		detailsMap
				.put("dgResultEntryHeaderLabList", dgResultEntryHeaderLabList);
		detailsMap.put("dgResultEntryHeaderSensitiveLabList",
				dgResultEntryHeaderSensitiveLabList);

		return detailsMap;
	}

	public Map<String, Object> getResultEntryDetailsForLabOrderStatus(
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

	public List<Object> getResultList(Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generateDiagNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDiagSeqForDisplay(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// //-------------------------------Start Methods developed by Vivek
	// --------------------------------------
	//	
	// @SuppressWarnings("unchecked")
	// public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
	// List objectList=new ArrayList();
	// String orGroupId ="";
	// try{
	// if(dataMap.get("orGroupId")!= null){
	// orGroupId = (""+dataMap.get("orGroupId"));
	// }
	// StringTokenizer s1 = new StringTokenizer(orGroupId,".");
	// while (s1.hasMoreTokens())
	// {
	// objectList.add(Integer.parseInt(""+s1.nextToken()));
	// }
	// Session session = (Session)getSession();
	// dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
	// .add(Restrictions.in("OrganismGroup.Id", objectList))
	// .addOrder( Order.asc("OrganismGroup.Id")).list();
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// map.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
	// return map;
	// }
	//
	// public Map<String, Object> getSensitivityList(Map<String, Object>
	// dataMap) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// String orIds ="";
	// List objectList=new ArrayList();
	// List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
	// try{
	// if(dataMap.get("orIds") !=null){
	// orIds =""+dataMap.get("orIds") ;
	// }
	// StringTokenizer s1 = new StringTokenizer(orIds,".");
	//		
	// while (s1.hasMoreTokens())
	// {
	// try{
	// objectList.add(Integer.parseInt(""+s1.nextToken()));
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// Session session = (Session)getSession();
	// //System.out.println("objectList  "+objectList.size());
	// dgOrgDtlList=
	// session.createCriteria(DgOrgDtl.class).add(Restrictions.in("Organism.Id",
	// objectList)).list();
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// map.put("dgOrgDtlList", dgOrgDtlList);
	// return map;
	// }
	//
	// public Map<String, Object> saveSensitivity(Map<String, Object> dataMap) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// //-------------------------------End Methods developed by
	// Vivek------------------------------------------
	/*
	 * public String getOrderSeqForDisplay(String string) { // TODO
	 * Auto-generated method stub return null; }
	 */

	public Map<String, Object> showPatientWiseFilmsJsp(
			Map<String, Object> requestMap) {
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int deptId = 0;
		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}

		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).createAlias(
							"MainChargecode", "mcc").createAlias(
							"mcc.Department", "dep").add(
							Restrictions.eq("dep.Id", deptId)).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			chargeCodeList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (chargeCodeList.size() > 0) {
				requestMap.put("chargeCodeList", chargeCodeList);
			}
			if (subChargeCodeList.size() > 0) {
				requestMap.put("subChargeCodeList", subChargeCodeList);
			}
			if (departmentList.size() > 0) {
				requestMap.put("departmentList", departmentList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return requestMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMicrobiologySensitiveWiseReportJsp(
			Map<String, Object> requestMap) {
		Session session = (Session) getSession();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int deptId = 0;
		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}

		try {
			dgMasOrganismGroupList = session.createCriteria(
					DgMasOrganismGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
					.add(Restrictions.eq("Status", "y")).list();
			masAntibioticLabList = session.createCriteria(
					MasAntibioticLab.class).add(Restrictions.eq("Status", "y"))
					.list();
			dgOrgDtlList = session.createCriteria(DgOrgDtl.class).add(
					Restrictions.eq("Status", "y")).list();
			dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "deptType").add(
					Restrictions.like("deptType.DepartmentTypeCode", "WARD"))
					.list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"empType").add(
					Restrictions.like("empType.EmpCategoryName", "Doctor"))
					.list();
			dgResultEntryDetailSenList = session.createCriteria(
					DgResultEntryDetailSen.class).list();
			// chargeCodeList =
			// session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("Status",
			// "y")).list();
			if (dgMasOrganismGroupList.size() > 0) {
				requestMap
						.put("dgMasOrganismGroupList", dgMasOrganismGroupList);
			}
			if (dgMasOrganismList.size() > 0) {
				requestMap.put("dgMasOrganismList", dgMasOrganismList);
			}
			if (departmentList.size() > 0) {
				requestMap.put("departmentList", departmentList);
			}
			if (employeeList.size() > 0) {
				requestMap.put("employeeList", employeeList);
			}
			if (masAntibioticLabList.size() > 0) {
				requestMap.put("masAntibioticLabList", masAntibioticLabList);
			}
			if (dgOrgDtlList.size() > 0) {
				requestMap.put("dgOrgDtlList", dgOrgDtlList);
			}
			if (dgOrgGrpDtlList.size() > 0) {
				requestMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
			}
			if (dgResultEntryDetailSenList.size() > 0) {
				requestMap.put("dgResultEntryDetailSenList",
						dgResultEntryDetailSenList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return requestMap;
	}

	public Map<String, Object> getDgOrderHd(Integer orderId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Integer> maxVisitIdList = new ArrayList<Integer>();
		List<Visit> visitIdList = new ArrayList<Visit>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List orderNoList = new ArrayList();

		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		int visitId = 0;

		int maxVisitId = 0;
		int doctorId = 0;
		try {

			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			dgOrderhdList = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("Id", orderId)).list();
			dgOrderhd = dgOrderhdList.get(0);

			visitId = dgOrderhd.getVisit().getId();

			if (dgOrderhd.getVisit().getDoctor() != null) {
				doctorId = dgOrderhd.getVisit().getDoctor().getId();
			}

			icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Visit", "v").add(
							Restrictions.eq("v.Id", visitId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("doctorId", doctorId);
		map.put("icdList", icdList);
		map.put("orderId", orderId);
		map.put("dgOrderhdList", dgOrderhdList);
		map.put("employeeList", employeeList);
		return map;

	}

	public Map<String, Object> getAllConfidentialOrders(
			Map<String, Object> requestMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<Integer> dgOrderhdIds = new ArrayList<Integer>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> dgOrderhdListTemp = new ArrayList<DgOrderhd>();

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
			crit = session.createCriteria(DgOrderhd.class).createAlias("Hin",
					"pt").createAlias("Inpatient", "inPt");
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

			dgOrderhdList = crit.list();
			for (DgOrderhd dgOrderhd : dgOrderhdList) {
				Set<DgOrderdt> dgOrderdtSet = dgOrderhd.getDgOrderdts();
				boolean confidentialRecord = false;
				for (DgOrderdt dgOrderdt : dgOrderdtSet) {
					if (dgOrderdt.getInvestigation() != null
							&& dgOrderdt.getInvestigation().getConfidential() != null
							&& dgOrderdt.getInvestigation().getConfidential()
									.equalsIgnoreCase("y")) {
						confidentialRecord = true;
						break;
					}
				}
				if (!confidentialRecord) {
					dgOrderhdListTemp.add(dgOrderhd);
				}
			}
			dgOrderhdList.removeAll(dgOrderhdListTemp);
			map.put("dgOrderhdList", dgOrderhdList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getAllOrderForOrderBookingReport(
			Map<String, Object> requestMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<Integer> dgOrderhdIds = new ArrayList<Integer>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> dgOrderhdListTemp = new ArrayList<DgOrderhd>();

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
			crit = session.createCriteria(DgOrderhd.class).createAlias("Hin",
					"pt").createAlias("Inpatient", "inPt");
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

			dgOrderhdList = crit.list();
			map.put("dgOrderhdList", dgOrderhdList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// methods added by shailesh for oreder update
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForOrderSearch() {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUpdatableOrdersGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		Date currentDate = new Date();
		int deptId = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		try {
			crit = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("OrderStatus", "P")).add(
					Restrictions.eq("OrderDate", currentDate)).add(
					Restrictions.eq("Department.Id", deptId));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUpdatableOrdersGridForSingleOrder(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		Date currentDate = new Date();
		String orderNo = "";
		int deptId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}

		try {
			crit = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("OrderStatus", "P")).add(
					Restrictions.eq("OrderDate", currentDate)).add(
					Restrictions.eq("OrderNo", orderNo)).add(
					Restrictions.eq("Department.Id", deptId));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrderDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		List<Visit> visitList = new ArrayList<Visit>();

		Session session = (Session) getSession();
		Criteria crit = null;

		try {
			DgOrderhd dgOrderhd = (DgOrderhd) session.load(DgOrderhd.class,
					(Integer) mapForDs.get("orderId"));
			if (dgOrderhd != null) {
				if (dgOrderhd.getVisit() != null) {
					visitList = session.createCriteria(Visit.class)
							.add(
									Restrictions.eq("Id", dgOrderhd.getVisit()
											.getId())).list();
					map.put("visitNo", visitList.get(0).getVisitNo());
					map.put("visitList", visitList);
				}
			}
			map.put("dgOrderhd", dgOrderhd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateOrderDetails(
			Map<String, Object> creationDetailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		List chargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List mainChargeList = new ArrayList();
		List qtyList = new ArrayList();
		boolean success = false;
		Box box = null;
		int chargeMainIdFromRequest = 0;
		int dgOrderhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;
		String orderSeqNo = "";
		String createdBy = "";
		String userName = "";
		int mainChargeId = 0;
		Session session = (Session) getSession();
		if (creationDetailsMap.get("departmentId") != null) {
			departmentId = (Integer) creationDetailsMap.get("departmentId");
		}
		if (creationDetailsMap.get("userName") != null) {
			userName = (String) creationDetailsMap.get("userName");
		}
		if (creationDetailsMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) creationDetailsMap.get("dgOrderhd");
		}
		if (creationDetailsMap.get("qtyList") != null) {
			qtyList = (List) creationDetailsMap.get("qtyList");
		}
		if (creationDetailsMap.get("mainChargeList") != null) {
			mainChargeList = (List) creationDetailsMap.get("mainChargeList");
		}
		if (creationDetailsMap.get("subChargeList") != null) {
			subChargeList = (List) creationDetailsMap.get("subChargeList");
		}
		if (creationDetailsMap.get("userId") != null) {
			userId = (Integer) creationDetailsMap.get("userId");
		}
		if (creationDetailsMap.get("chargeMainIdFromRequest") != null) {
			chargeMainIdFromRequest = (Integer) creationDetailsMap
					.get("chargeMainIdFromRequest");
		}

		if (creationDetailsMap.get("createdBy") != null) {
			createdBy = (String) creationDetailsMap.get("createdBy");
		}

		if (creationDetailsMap.get("box") != null) {
			box = (Box) creationDetailsMap.get("box");
		}
		Transaction tx = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		try {
			tx = session.beginTransaction();
			List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>(
					((DgOrderhd) creationDetailsMap.get("originalDgOrderhd"))
							.getDgOrderdts());
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (creationDetailsMap.get("newDgOrderhd") != null) {
				dgOrderhd = (DgOrderhd) creationDetailsMap.get("newDgOrderhd");
				hbt.update(dgOrderhd);
				dgOrderhdId = dgOrderhd.getId();
				map.put("dgOrderhdId", dgOrderhdId);
			}

			hbt.deleteAll(dgOrderdtList);
			if (creationDetailsMap.get("chargeList") != null) {
				chargeList = (List) creationDetailsMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {

						DgOrderdt dgOrderdt = new DgOrderdt();
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();

						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {
							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							dgOrderdt.setChargeCode(masChargeCode);

							if (mainChargeList.get(i) != null
									&& !mainChargeList.get(i).equals("")) {
								mainChargeId = Integer.parseInt(mainChargeList
										.get(i).toString());
								masMainChargecode.setId(mainChargeId);
								dgOrderdt.setMainChargecode(masMainChargecode);
							}

							if (subChargeList.get(i) != null
									&& !subChargeList.get(i).equals("")) {
								int subChargeId = Integer
										.parseInt(subChargeList.get(i)
												.toString());
								masSubChargecode.setId(subChargeId);
								dgOrderdt.setSubChargeid(masSubChargecode);
							}
							if (qtyList.get(i) != null
									&& !qtyList.get(i).equals("")) {
								int qty = Integer.parseInt("" + qtyList.get(i));
								dgOrderdt.setOrderQty(qty);
								dgOrderdt.setCreatedby(createdBy);
								dgOrderdt.setCreatedon(HMSUtil
										.convertStringTypeDateToDateType(date));
								Users user=new Users();
								user.setId(userId);
								dgOrderdt.setLastChgBy(user);
								dgOrderdt.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								dgOrderdt.setLastChgTime(time);
								dgOrderdt.setOrderStatus("P");
								if (creationDetailsMap.get("newDgOrderhd") != null) {
									dgOrderdt.setOrderhd(dgOrderhd);

								}

								hbt.save(dgOrderdt);
								success = true;
							}

						}
					}
				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("success", success);
		map.put("orderSeqNo", orderSeqNo);
		return map;
	}

	// ///////////////////// For Getting Total Film Used
	// public Map<String, Object> getTotalFilmUsed(int departmentId){

	// Session session = (Session) getSession();
	// Criteria crit = null;

	// try {
	// crit =
	// session.createCriteria(DgResultEntryHeader.class).add(Restrictions.eq("OrderStatus",
	// "P"))
	// .add(Restrictions.eq("OrderDate",
	// currentDate)).add(Restrictions.eq("OrderNo", orderNo))
	// .add(Restrictions.eq("Department.Id", deptId));
	// patientDetailList = crit.list();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }

	// }
	public Map<String, Object> getDetailsForIPDSearch() {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<MasRank> rankList = new ArrayList<MasRank>();
		// List<MasServiceType> serviceTypeList = new
		// ArrayList<MasServiceType>();
		// List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();

		try {
			// rankList=session.createQuery("select rank from MasRank as rank where rank.Status='y'  order by rank.RankName "
			// ).list();
			// serviceTypeList =
			// session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status",
			// "y")).list();
			// unitList =
			// session.createCriteria(MasUnit.class).add(Restrictions.eq("Status",
			// "y")).list();
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();
			// map.put("rankList", rankList);
			// map.put("serviceTypeList", serviceTypeList);
			// map.put("unitList", unitList);
			map.put("wardList", wardList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> getPatientDetailsForIPDOrderBooking(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientTempList = new ArrayList<Inpatient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();

		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		int deptId = 0;
		String serviceNo = "";
		String deptName = "";

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		if (mapForDs.get("wardId") != null) {
			wardId = (Integer) mapForDs.get("wardId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}

		List objectList = new ArrayList();
		objectList.add("A");
		objectList.add("R");
		objectList.add("S");

		Criteria crit = session.createCriteria(Inpatient.class).add(
				Restrictions.in("AdStatus", objectList));

		crit = crit.createAlias("Hin", "hinP");
		if (inpatientId == 0) {
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("AdNo", adNo));
			}
			if (adNo.equals("")) {
				crit = crit.add(Restrictions.eq("hinP.PatientStatus",
						"In Patient"));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("hinP.ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("hinP.HinNo", hinNo));
			}
			if (wardId != 0) {
				crit = crit.createAlias("Department", "dept").add(
						Restrictions.eq("dept.Id", wardId));

			}
		} else if (inpatientId != 0) {
			crit = crit.add(Restrictions.idEq(inpatientId));
		}

		// inPatientTempList = crit.list();
		inPatientList = crit.list();

		deptList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Id", deptId)).list();
		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();

		}

		// This part is commented because of new reqirement
		// That is patient will discharged without discharge Summary

		// Changed by ------------------Vivek

		// for (Inpatient inpatient : inPatientTempList) {
		// String admNo = inpatient.getAdNo();
		// dischargeSummaryList =
		// session.createCriteria(DischargeSummary.class).add(Restrictions.eq("AdNo",
		// admNo)).list();
		// }
		// map.put("dischargeSummaryList", dischargeSummaryList);
		// map.put("inpatientTempList", inPatientTempList);
		map.put("deptName", deptName);
		map.put("inpatientList", inPatientList);
		return map;
	}

	public Map<String, Object> getEmployeeDetailMap(Map<String, Object> mapForDs) {
		Session session = (Session) getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();

		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> getDetailsForAllResultTypes(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Integer dgMasInvestigationId = 0;

		if (mapForDs.get("dgMasInvestigationId") != null) {
			dgMasInvestigationId = (Integer) mapForDs
					.get("dgMasInvestigationId");
		}

		int subTestId = 0;
		Session session = (Session) getSession();
		try {
			subList = session.createCriteria(DgSubMasInvestigation.class).add(
					Restrictions.eq("Investigation.Id", dgMasInvestigationId))
					.addOrder(Order.asc("OrderNo")).list();
			if (subList.size() > 0) {
				detailsMap.put("subList", subList);
			}
			/*templateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.DgTemplate dt where dt.Investigation.Id= '"
							+ dgMasInvestigationId + "'");*/
			
			
			
			templateList=session.createCriteria(DgTemplate.class).add(Restrictions.eq("Investigation.Id", dgMasInvestigationId)).list();
			if (templateList.size() > 0) {
				detailsMap.put("templateList", templateList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;

	}

	public Map<String, Object> getResultForRadiologyTest(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		int dgResultEntryDetailId = 0;
		if (mapForDs.get("dgResultEntryDetailId") != null) {
			dgResultEntryDetailId = (Integer) mapForDs
					.get("dgResultEntryDetailId");
		}

		Session session = (Session) getSession();
		try {
			dgResultEntryDetailList = session.createCriteria(
					DgResultEntryDetail.class).add(
					Restrictions.eq("Id", dgResultEntryDetailId)).list();
			if (dgResultEntryDetailList.size() > 0) {
				detailsMap.put("dgResultEntryDetailList",
						dgResultEntryDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getDiagnosticRegister(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		List<String> subChargeList = new ArrayList<String>();
		List<String> testNameList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> confidentialList = new ArrayList<String>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("depart") != null) {
			depart = (Integer) mapForDs.get("depart");
		}
		if (mapForDs.get("patient") != null) {
			patient = (String) mapForDs.get("patient");
		}
		if (mapForDs.get("resultType") != null) {
			resultType = (String) mapForDs.get("resultType");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Session session = (Session) getSession();
		Criteria crit = null;
		/*crit = session.createCriteria(DgResultEntryDetail.class).createAlias("ResultEntry", "re").createAlias(
				"re.Patient", "p").createAlias("re.SampleCollectionHeader",
				"sch").createAlias("sch.Order", "orderN").add(
				Restrictions.eq("re.ResultStatus", "A")).add(
				Restrictions.between("re.ResultDate", fromDate, toDate));
		if (subChargeId != 0) {
			crit = crit.createAlias("re.SubChargecode", "subChg");
			crit = crit.add(Restrictions.eq("subChg.Id", subChargeId));
		}
		if (depart != 0) {
			crit = crit.createAlias("orderN.Department", "dep");
			crit = crit.add(Restrictions.eq("dep.Id", depart));
		}
		if (!patient.equals("")) {
			crit = crit.add(Restrictions.eq("orderN.PatientType", patient));
		}
		if (!resultType.equals("")) {
			crit = crit.add(Restrictions.eq("ResultType", resultType));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("re.Department", "departmentId");
			crit = crit.add(Restrictions.eq("departmentId.Id", departmentId));
		}*/
		Box box = (Box)mapForDs.get("box");
		String qry ="select dgd from DgResultEntryDetail dgd join dgd.ResultEntry dgh " +
			 	" join dgh.SampleCollectionHeader sch left join dgh.Patient p" +
				" join sch.Order dgorder left join dgorder.PrescribedBy pb " +
				/*" left join p.DischargeIcdCodes dic " +
				" left join dic.Icd icd"+*/
				" left join dgh.DgMasInvestigation inv join inv.MainChargecode mcc"+
				" where dgh.ResultDate between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
				" and dgh.ResultStatus = 'A' and dgd.ResultType = '"+resultType+"' and dgh.MasHospital.Id="+hospitalId;
	
		if (subChargeId != 0) {
				qry += " and dgh.SubChargecode.Id = "+subChargeId;
		}
		if (depart != 0) {
			qry += " and mcc.Department.Id = "+depart;
		}
		if(box.getInt(SERVICE_TYPE_ID)!=0){
		//	crit = crit.createAlias("p.ServiceType", "st").add(Restrictions.eq("st.Id", box.getInt(SERVICE_TYPE_ID)));
			qry += " and p.ServiceType.Id = "+box.getInt(SERVICE_TYPE_ID);
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0 ){
		//	crit = crit.createAlias("p.ServiceStatus", "ss").add(Restrictions.eq("ss.Id", box.getInt(SERVICE_STATUS_ID)));
			qry += " and p.ServiceStatus.Id = "+box.getInt(SERVICE_STATUS_ID);
		}
		if(box.getInt("fromRankId")!= 0 && box.getInt("toRankId")!=0){
		//	crit = crit.createAlias("p.Rank", "rank").add(Restrictions.between("rank.Id", box.getInt("fromRankId"),box.getInt("toRankId")));
			qry += " and p.Rank.Id between  "+box.getInt("fromRankId")+" and "+box.getInt("toRankId");
		}
		if(box.getInt(RANK_CATEGORY_ID)!=0){
	//		crit = crit.createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", box.getInt(RANK_CATEGORY_ID)));
			qry += " and p.Rank.RankCategory.Id = "+box.getInt(RANK_CATEGORY_ID);
		}
		if(box.getInt(TRADE_ID)!=0 ){
//			crit = crit.createAlias("p.Trade", "tr").add(Restrictions.eq("tr.Id", box.getInt(TRADE_ID)));
			qry += " and p.Trade.Id = "+box.getInt(TRADE_ID);
		}
		if(box.getInt(UNIT_ID)!=0){
//			crit = crit.createAlias("p.Unit", "u").add(Restrictions.eq("u.Id", box.getInt(UNIT_ID)));
			qry += " and p.Unit.Id = "+box.getInt(UNIT_ID);
		}
		if(box.getInt(SECTION_ID)!=0){
//			crit = crit.createAlias("p.Section", "se").add(Restrictions.eq("se.Id", box.getInt(SECTION_ID)));
			qry += " and p.Section.Id = "+box.getInt(SECTION_ID);
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
//			crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(MARITAL_STATUS_ID)));
			qry += " and p.MaritalStatus.Id = "+box.getInt(MARITAL_STATUS_ID);
		}
		if(box.getInt(SEX_ID)!=0 ){
//			crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(SEX_ID)));
			qry += " and p.Sex.Id = "+box.getInt(SEX_ID);
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
//			crit = crit.add(Restrictions.eq("p.ServiceNo", box.getInt(SERVICE_NO)));
			qry += " and p.ServiceNo = '"+box.getString(SERVICE_NO)+"'";
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			 qry += " and substr(p.Age,0,INSTR(p.Age,' ')) >="+fromAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("fromAgeUnit")+"'" +
					" and substr(p.Age,0,INSTR(p.Age,' ')) <="+toAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("toAgeUnit")+"'";
		
		}
		if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			 qry +="  p.ServiceYears >="+fromServ+" " +
					" and  TotalServicePeriod='"+box.getString("fromServUnit")+"'" +
					" and p.ServiceYears <="+toServ+" " +
					" and  TotalServicePeriod='"+box.getString("toServUnit")+"'";
			
		}
		if(box.getInt(CONSULTING_DOCTOR)!=0 ){
		    qry += " and pb.Id = "+box.getInt(CONSULTING_DOCTOR)+"";
		}
		if(box.getInt(INVESTIGATION_ID)!=0 ){
			qry += " and dgh.DgMasInvestigation.Id = "+box.getInt(INVESTIGATION_ID);
		}
		
		/*if ( !(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			   String icdCode =""+icd.substring(index1, index2);
			qry += " and icd.IcdCode='"+icdCode+"'";
		
		}
		if (!(box.getString("icdNo").equals(""))) {
			qry += " and icd.IcdCode='"+box.getString("icdNo")+"'";
		}*/
		dgResultdetailList = session.createQuery(qry).list();
		if (dgResultdetailList.size() > 0) {
			detailsMap.put("dgResultdetailList", dgResultdetailList);
			detailsMap.put("hinNo", dgResultdetailList.get(0).getResultEntry()
					.getPatient().getHinNo());

			detailsMap.put("serviceNo", dgResultdetailList.get(0)
					.getResultEntry().getPatient().getServiceNo());

			detailsMap.put("orderByDepartment", dgResultdetailList.get(0)
					.getResultEntry().getSampleCollectionHeader().getOrder()
					.getDepartment().getDepartmentName());
			Patient p = dgResultdetailList.get(0).getResultEntry().getPatient();

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
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderNo());

			detailsMap.put("orderDate", dgResultdetailList.get(0)
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderDate());

			detailsMap.put("relationName", p.getRelation().getRelationName());

			detailsMap.put("patientAge", p.getAge());

			detailsMap.put("sex", p.getSex().getAdministrativeSexName());

			detailsMap.put("resultDate", dgResultdetailList.get(0)
					.getResultEntry().getResultDate());

			detailsMap.put("rankName", p.getRank().getRankName());

			detailsMap
					.put("subChargeCodeName", dgResultdetailList.get(0)
							.getResultEntry().getSubChargecode()
							.getSubChargecodeName());

			detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
					.getResultEntry().getMainChargecode()
					.getMainChargecodeName());

			detailsMap.put("remarks", dgResultdetailList.get(0).getRemarks());

			detailsMap.put("charge", dgResultdetailList.get(0)
					.getInvestigation().getInvestigationName());
			String patientType = dgResultdetailList.get(0)
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getPatientType();
			if (patientType.equalsIgnoreCase("IP")) {
				detailsMap.put("patientType", "In Patient");
			} else {
				detailsMap.put("patientType", "Out Patient");
			}
			detailsMap.put("hospitalName", dgResultdetailList.get(0).getResultEntry().getMasHospital().getHospitalName());
			detailsMap.put("hospitalAddress", dgResultdetailList.get(0).getResultEntry().getMasHospital().getAddress());
			DgResultEntryDetail dgResultEntryDetail = dgResultdetailList.get(0);

			String confidential = dgResultEntryDetail.getInvestigation()
					.getConfidential();
			if (confidential != null && !confidential.equals("")
					&& !confidential.equalsIgnoreCase("n")) {
				detailsMap.put("confidential", "y");
			} else {
				detailsMap.put("confidential", "n");
			}

			MasEmployee e = dgResultdetailList.get(0).getResultEntry()
					.getSampleCollectionHeader().getOrder().getPrescribedBy();
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
				detailsMap.put("doctorName", dFirst + " " + dMiddleName + " "
						+ dLastName);
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
				detailsMap.put("entryPersonName", eFirst + " " + eMiddleName
						+ " " + eLastName);
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
				detailsMap.put("verifiedPersonName", vFirst + " " + vMiddleName
						+ " " + vLastName);
			}
		}
		/*
		 * for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){
		 * subChargeList
		 * .add(dgResultEntryDetail.getResultEntry().getSubChargecode
		 * ().getSubChargecodeName());
		 * testNameList.add(dgResultEntryDetail.getInvestigation
		 * ().getInvestigationName());
		 * remarksList.add(dgResultEntryDetail.getRemarks()); String
		 * confidential =
		 * dgResultEntryDetail.getInvestigation().getConfidential();
		 * if(confidential != null && !confidential.equals("") &&
		 * !confidential.equalsIgnoreCase("n") ){ confidentialList.add("y");
		 * }else{ confidentialList.add("n"); } detailsMap.put("subChargeList",
		 * subChargeList); detailsMap.put("testNameList", testNameList);
		 * detailsMap.put("remarksList", remarksList);
		 * detailsMap.put("confidentialList", confidentialList); }
		 */

		crit = session
				.createCriteria(DgResultEntryDetail.class)
				.createAlias("ResultEntry", "re")
				.createAlias("re.SampleCollectionHeader", "sch")
				.createAlias("sch.Order", "orderN")
				.add(Restrictions.eq("re.ResultStatus", "A"))
				.add(Restrictions.between("re.ResultDate", fromDate, toDate))
				.createAlias("Investigation", "inv")
				.createAlias("inv.SubChargecode", "subCharg")
				.setProjection(
						Projections
								.distinct(Projections
										.projectionList()
										.add(
												Projections
														.property("subCharg.SubChargecodeName"))));
		subChargeCodeGroup = crit.list();
		detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);
		return detailsMap;
	}

	public Map<String, Object> getDiagnosticRegisterForMultipleTestType(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		List<String> subChargeList = new ArrayList<String>();
		List<String> testNameList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> confidentialList = new ArrayList<String>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("depart") != null) {
			depart = (Integer) mapForDs.get("depart");
		}
		if (mapForDs.get("patient") != null) {
			patient = (String) mapForDs.get("patient");
		}
		if (mapForDs.get("resultType") != null) {
			resultType = (String) mapForDs.get("resultType");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();

		Session session = (Session) getSession();
		Criteria crit = null;
		/*crit = session.createCriteria(DgResultEntryHeader.class).createAlias(
				"SampleCollectionHeader", "sch").createAlias("sch.Order",
				"orderN").add(Restrictions.eq("ResultStatus", "A"))
				.createAlias("MainChargecode", "mcc").createAlias(
						"DgMasInvestigation", "inv").add(
						Restrictions.eq("inv.InvestigationType", "m")).add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab")).add(
						Restrictions.between("ResultDate", fromDate, toDate));

		if (subChargeId != 0) {
			crit = crit.createAlias("SubChargecode", "subChg");
			crit = crit.add(Restrictions.eq("subChg.Id", subChargeId));
		}
		if (depart != 0) {
			crit = crit.createAlias("orderN.Department", "dep");
			crit = crit.add(Restrictions.eq("dep.Id", depart));
		}
		if (!patient.equals("")) {
			crit = crit.add(Restrictions.eq("orderN.PatientType", patient));
		}
		
		 * if(!resultType.equals("")){ crit =
		 * crit.add(Restrictions.eq("ResultType", resultType)); }
		 
		if (departmentId != 0) {
			crit = crit.createAlias("Department", "departmentId");
			crit = crit.add(Restrictions.eq("departmentId.Id", departmentId));
		}

		dgMultipleResultdetailList = crit.list();*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Box box = (Box)mapForDs.get("box");
		String qry ="select distinct dgh from DgResultEntryHeader dgh  join dgh.DgResultEntryDetails dgd join dgh.SampleCollectionHeader sch join dgh.Patient p" +
				" join sch.Order dgorder left join dgh.MainChargecode mcc left join dgh.DgMasInvestigation inv where dgh.ResultDate between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
				" and dgh.ResultStatus = 'A' and mcc.MainChargecodeCode='Lab' and inv.InvestigationType='m' and dgh.MasHospital.Id="+hospitalId;
	
		if (subChargeId != 0) {
				qry += " and dgh.SubChargecode.Id = "+subChargeId;
		}
		if (depart != 0) {
			qry += " and mcc.Department.Id = "+depart;
		}
		if(box.getInt(SERVICE_TYPE_ID)!=0){
		//	crit = crit.createAlias("p.ServiceType", "st").add(Restrictions.eq("st.Id", box.getInt(SERVICE_TYPE_ID)));
			qry += " and p.ServiceType.Id = "+box.getInt(SERVICE_TYPE_ID);
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0 ){
		//	crit = crit.createAlias("p.ServiceStatus", "ss").add(Restrictions.eq("ss.Id", box.getInt(SERVICE_STATUS_ID)));
			qry += " and p.ServiceStatus.Id = "+box.getInt(SERVICE_STATUS_ID);
		}
		if(box.getInt("fromRankId")!= 0 && box.getInt("toRankId")!=0){
		//	crit = crit.createAlias("p.Rank", "rank").add(Restrictions.between("rank.Id", box.getInt("fromRankId"),box.getInt("toRankId")));
			qry += " and p.Rank.Id between  "+box.getInt("fromRankId")+" and "+box.getInt("toRankId");
		}
		if(box.getInt(RANK_CATEGORY_ID)!=0){
	//		crit = crit.createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", box.getInt(RANK_CATEGORY_ID)));
			qry += " and p.Rank.RankCategory.Id = "+box.getInt(RANK_CATEGORY_ID);
		}
		if(box.getInt(TRADE_ID)!=0 ){
//			crit = crit.createAlias("p.Trade", "tr").add(Restrictions.eq("tr.Id", box.getInt(TRADE_ID)));
			qry += " and p.Trade.Id = "+box.getInt(TRADE_ID);
		}
		if(box.getInt(UNIT_ID)!=0){
//			crit = crit.createAlias("p.Unit", "u").add(Restrictions.eq("u.Id", box.getInt(UNIT_ID)));
			qry += " and p.Unit.Id = "+box.getInt(UNIT_ID);
		}
		if(box.getInt(SECTION_ID)!=0){
//			crit = crit.createAlias("p.Section", "se").add(Restrictions.eq("se.Id", box.getInt(SECTION_ID)));
			qry += " and p.Section.Id = "+box.getInt(SECTION_ID);
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
//			crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(MARITAL_STATUS_ID)));
			qry += " and p.MaritalStatus.Id = "+box.getInt(MARITAL_STATUS_ID);
		}
		if(box.getInt(SEX_ID)!=0 ){
//			crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(SEX_ID)));
			qry += " and p.Sex.Id = "+box.getInt(SEX_ID);
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
//			crit = crit.add(Restrictions.eq("p.ServiceNo", box.getInt(SERVICE_NO)));
			qry += " and p.ServiceNo = '"+box.getString(SERVICE_NO)+"'";
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			 qry += " and substr(p.Age,0,INSTR(p.Age,' ')) >="+fromAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("fromAgeUnit")+"'" +
					" and substr(p.Age,0,INSTR(p.Age,' ')) <="+toAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("toAgeUnit")+"'";
		
		}
		if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			 qry +="  p.ServiceYears >="+fromServ+" " +
					" and  TotalServicePeriod='"+box.getString("fromServUnit")+"'" +
					" and p.ServiceYears <="+toServ+" " +
					" and  TotalServicePeriod='"+box.getString("toServUnit")+"'";
		}
		if(box.getInt(CONSULTING_DOCTOR)!=0 ){
		//	qry += " and visit.doctor_id = "+box.getInt(CONSULTING_DOCTOR)+"";
		}
		
		dgMultipleResultdetailList = session.createQuery(qry).list();
		
		DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
		if (dgMultipleResultdetailList != null
				&& dgMultipleResultdetailList.size() > 0) {

			dgResultEntryDetailForData = dgMultipleResultdetailList.get(0)
					.getDgResultEntryDetails().iterator().next();
		}

		if (dgMultipleResultdetailList != null
				&& dgMultipleResultdetailList.size() > 0) {
			detailsMap.put("dgMultipleResultdetailList",
					dgMultipleResultdetailList);
			detailsMap.put("hinNo", dgResultEntryDetailForData.getResultEntry()
					.getPatient().getHinNo());

			detailsMap.put("serviceNo", dgResultEntryDetailForData
					.getResultEntry().getPatient().getServiceNo());
            if(dgResultEntryDetailForData.getResultEntry().getSampleCollectionHeader().getOrder().getDepartment()!=null)
            {
			detailsMap.put("orderByDepartment", dgResultEntryDetailForData
					.getResultEntry().getSampleCollectionHeader()
					.getOrder().getDepartment().getDepartmentName());
            }
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
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderNo());

			detailsMap.put("orderDate", dgResultEntryDetailForData
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderDate());

			detailsMap.put("relationName", p.getRelation().getRelationName());

			detailsMap.put("patientAge", p.getAge());

			detailsMap.put("sex", p.getSex().getAdministrativeSexName());

			detailsMap.put("resultDate", dgResultEntryDetailForData
					.getResultEntry().getResultDate());

			detailsMap.put("rankName", p.getRank().getRankName());

			detailsMap
					.put("subChargeCodeName", dgResultEntryDetailForData
							.getResultEntry().getSubChargecode()
							.getSubChargecodeName());

			detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
					.getResultEntry().getMainChargecode()
					.getMainChargecodeName());

			detailsMap.put("remarks", dgResultEntryDetailForData.getRemarks());

			detailsMap.put("charge", dgResultEntryDetailForData
					.getInvestigation().getInvestigationName());
			String patientType = dgResultEntryDetailForData
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getPatientType();
			if (patientType.equalsIgnoreCase("IP")) {
				detailsMap.put("patientType", "In Patient");
			} else {
				detailsMap.put("patientType", "Out Patient");
			}
			detailsMap.put("hospitalName", dgResultEntryDetailForData.getResultEntry().getMasHospital().getHospitalName());
			detailsMap.put("hospitalAddress", dgResultEntryDetailForData.getResultEntry().getMasHospital().getAddress());
			
			// DgResultEntryDetail dgResultEntryDetail =
			// dgResultdetailList.get(0);

			String confidential = dgResultEntryDetailForData.getInvestigation()
					.getConfidential();
			if (confidential != null && !confidential.equals("")
					&& !confidential.equalsIgnoreCase("n")) {
				detailsMap.put("confidential", "y");
			} else {
				detailsMap.put("confidential", "n");
			}

			MasEmployee e = dgResultEntryDetailForData.getResultEntry()
					.getSampleCollectionHeader().getOrder().getPrescribedBy();
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
				detailsMap.put("doctorName", dFirst + " " + dMiddleName + " "
						+ dLastName);
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
				detailsMap.put("entryPersonName", eFirst + " " + eMiddleName
						+ " " + eLastName);
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
				detailsMap.put("verifiedPersonName", vFirst + " " + vMiddleName
						+ " " + vLastName);
			}
		}
		/*
		 * for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){
		 * subChargeList
		 * .add(dgResultEntryDetail.getResultEntry().getSubChargecode
		 * ().getSubChargecodeName());
		 * testNameList.add(dgResultEntryDetail.getInvestigation
		 * ().getInvestigationName());
		 * remarksList.add(dgResultEntryDetail.getRemarks()); String
		 * confidential =
		 * dgResultEntryDetail.getInvestigation().getConfidential();
		 * if(confidential != null && !confidential.equals("") &&
		 * !confidential.equalsIgnoreCase("n") ){ confidentialList.add("y");
		 * }else{ confidentialList.add("n"); } detailsMap.put("subChargeList",
		 * subChargeList); detailsMap.put("testNameList", testNameList);
		 * detailsMap.put("remarksList", remarksList);
		 * detailsMap.put("confidentialList", confidentialList); }
		 */

		crit = session
				.createCriteria(DgResultEntryDetail.class)
				.createAlias("ResultEntry", "re")
				.createAlias("re.SampleCollectionHeader", "sch")
				.createAlias("sch.Order", "orderN")
				.add(Restrictions.eq("re.ResultStatus", "A"))
				.add(Restrictions.between("re.ResultDate", fromDate, toDate))
				.createAlias("Investigation", "inv")
				.createAlias("inv.SubChargecode", "subCharg")
				.setProjection(
						Projections
								.distinct(Projections
										.projectionList()
										.add(
												Projections
														.property("subCharg.SubChargecodeName"))));
		subChargeCodeGroup = crit.list();
		detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

		return detailsMap;
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
						
						// Code hide by amit on 15/08/2012 for Sql Injection
						/*fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");*/
						// Code updated by amit on 15/08/2012 due to Sql Injection occur
						fixedValList = session.createCriteria(DgFixedValue.class)
						.add(Restrictions.eq("SubInvestigation.Id", fixedId))
						.add(Restrictions.isNotNull("FixedValue")).list();															
						
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

	public Map<String, Object> checkForExistingSeqNo(
			Map<String, Object> mapForDs) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsListTemp = new ArrayList<DgSampleCollectionDetails>();

		String radioIdToCheck = "";
		Integer sampleCollectionIdToCheck = 0;

		if (mapForDs.get("radioIdToCheck") != null) {
			radioIdToCheck = (String) mapForDs.get("radioIdToCheck");
		}
		if (mapForDs.get("sampleCollectionIdToCheck") != null) {
			sampleCollectionIdToCheck = (Integer) mapForDs
					.get("sampleCollectionIdToCheck");
		}

		Session session = (Session) getSession();

		dgSampleCollectionDetailsList = session.createCriteria(
				DgSampleCollectionDetails.class).add(
				Restrictions.eq("DiagNo", radioIdToCheck)).list();

		if (dgSampleCollectionDetailsList.size() == 0) {
			detailsMap.put("flag", "NoDuplicateFound");
		}

		for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList) {
			if ((dgSampleCollectionDetails.getId())
					.equals(sampleCollectionIdToCheck)) {
				dgSampleCollectionDetailsListTemp
						.add(dgSampleCollectionDetails);
			}
		}
		if (dgSampleCollectionDetailsList.size() > 0) {
			dgSampleCollectionDetailsList
					.removeAll(dgSampleCollectionDetailsListTemp);
		}

		if (dgSampleCollectionDetailsList.size() > 0) {
			detailsMap.put("flag", "FoundDuplicate");
		} else {
			detailsMap.put("flag", "NoDuplicateFound");
		}

		return detailsMap;
	}

	public Map<String, Object> updateOrderBookingForInvestigation(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		List chargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List mainChargeList = new ArrayList();

		List qtyList = new ArrayList();
		boolean success = false;
		Box box = null;
		int chargeMainIdFromRequest = 0;
		int dgOrderhdId = 0;
		int sampleCollectionHeaderId = 0;
		int sampleCollDtId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;
		String orderSeqNo = "";
		String createdBy = "";
		String userName = "";
		DgOrderhd dgOrderhdObj = new DgOrderhd();

		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("mainChargeList") != null) {
			mainChargeList = (List) infoMap.get("mainChargeList");
		}
		if (infoMap.get("subChargeList") != null) {
			subChargeList = (List) infoMap.get("subChargeList");
		}
		if (infoMap.get("createdBy") != null) {
			createdBy = (String) infoMap.get("createdBy");
		}

		if (infoMap.get("userId") != null) {
			userId = (Integer) infoMap.get("userId");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("dgOrderhdId") != null) {
			dgOrderhdId = (Integer) infoMap.get("dgOrderhdId");
		}
		if (infoMap.get("sampleCollDtId") != null) {
			sampleCollDtId = (Integer) infoMap.get("sampleCollDtId");
		}
		if (infoMap.get("sampleCollectionHeaderId") != null) {
			sampleCollectionHeaderId = (Integer) infoMap
					.get("sampleCollectionHeaderId");
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Session session = (Session) getSession();
		Transaction tx = null;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			if (dgOrderhdId != 0) {
				dgOrderhdObj = (DgOrderhd) hbt.load(DgOrderhd.class,
						dgOrderhdId);
				Users users = new Users();
				users.setId(userId);
				dgOrderhdObj.setLastChgBy(users);
				dgOrderhdObj.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				dgOrderhdObj.setLastChgTime(time);

				// dgOrderDtSet = dgOrderhdObj.getDgOrderdts();

				int mainChargeId = 0;
				if (infoMap.get("chargeList") != null) {
					chargeList = (List) infoMap.get("chargeList");
					if (chargeList.size() > 0) {
						for (int i = 0; i < chargeList.size(); i++) {

							DgOrderdt dgOrderdt = new DgOrderdt();
							MasChargeCode masChargeCode = new MasChargeCode();
							MasSubChargecode masSubChargecode = new MasSubChargecode();
							MasMainChargecode masMainChargecode = new MasMainChargecode();

							try {
								if (chargeList.get(i) != null
										&& !chargeList.get(i).equals("")) {
									int chargeId = Integer.parseInt(chargeList
											.get(i).toString());
									MasChargeCode maschrgCode = (MasChargeCode) session
											.createCriteria(MasChargeCode.class)
											.add(
													Restrictions.eq("Id",
															chargeId)).list()
											.get(0);
									if (maschrgCode.getMainChargecode()
											.getMainChargecodeCode()
											.equalsIgnoreCase("Lab")) {
										dgOrderdt.setOrderStatus("C");
									} else {
										dgOrderdt.setOrderStatus("P");
									}
									dgOrderdt.setChargeCode(maschrgCode);

									// masChargeCode.setId(chargeId);
									// dgOrderdt.setChargeCode(masChargeCode);

									dgOrderdt
											.setInvestigation(new DgMasInvestigation(
													chargeId));

									if (mainChargeList.get(i) != null
											&& !mainChargeList.get(i)
													.equals("")) {
										mainChargeId = Integer
												.parseInt(mainChargeList.get(i)
														.toString());
										masMainChargecode.setId(mainChargeId);
										dgOrderdt
												.setMainChargecode(masMainChargecode);
									}

									if (subChargeList.get(i) != null
											&& !subChargeList.get(i).equals("")) {
										int subChargeId = Integer
												.parseInt(subChargeList.get(i)
														.toString());
										masSubChargecode.setId(subChargeId);
										dgOrderdt
												.setSubChargeid(masSubChargecode);
									}
									// if (qtyList.get(i) != null &&
									// !qtyList.get(i).equals("")) {
									// int qty = Integer.parseInt(""+
									// qtyList.get(i));
									// dgOrderdt.setOrderQty(qty);
									dgOrderdt.setCreatedby(createdBy);
									dgOrderdt
											.setCreatedon(HMSUtil
													.convertStringTypeDateToDateType(date));
									Users user=new Users();
									user.setId(userId);
									dgOrderdt.setLastChgBy(user);
									dgOrderdt
											.setLastChgDate(HMSUtil
													.convertStringTypeDateToDateType(date));
									dgOrderdt.setLastChgTime(time);
									// dgOrderdt.setOrderStatus("P");
									// if (infoMap.get("dgOrderhd") != null) {
									dgOrderdt.setOrderhd(dgOrderhdObj);

									// } else {
									// DgOrderhd dgOrderheader = new
									// DgOrderhd();
									// dgOrderheader.setId(chargeMainIdFromRequest);
									// dgOrderdt.setOrderhd(dgOrderheader);
									// }
									// }
									// dgOrderDtSet.add(dgOrderdt);
									hbt.save(dgOrderdt);
									hbt.refresh(dgOrderdt);
								}

							} catch (RuntimeException e) {
								e.printStackTrace();
							}

						}
					}
				}
				// dgOrderhdObj.setDgOrderdts(dgOrderDtSet);
				hbt.update(dgOrderhdObj);
				hbt.refresh(dgOrderhdObj);
			}
			// ----------Saving Data in DgSampleCollection's Table where
			// MainCharge is RADIOLOGY-----------------------------
			Vector charge_code_Id = box.getVector(CHARGE_CODE_ID);
			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			boolean goneInLoop = false;

			for (int j = 0; j < chargeList.size() && !goneInLoop; j++) {
				int chargeCodeId = Integer.parseInt("" + chargeList.get(j));
				chargeCodeList = session.createCriteria(MasChargeCode.class)
						.add(Restrictions.eq("Id", chargeCodeId)).createAlias(
								"MainChargecode", "mcc").createAlias(
								"mcc.Department", "dept").createAlias(
								"dept.DepartmentType", "dt").add(
								Restrictions.eq("dt.DepartmentTypeCode",
										"RADIO")).list();

				if (chargeCodeList.size() > 0) {
					dgSampleCollectionHeader = (DgSampleCollectionHeader) hbt
							.load(DgSampleCollectionHeader.class,
									sampleCollectionHeaderId);
					// dgSampleCollectionDetailsSet =
					// dgSampleCollectionHeader.getDgSampleCollectionDetails();
					for (MasChargeCode chargeCode : chargeCodeList) {
						try {
							/*
							 * int inpatientId = 0; int visitId = 0; if
							 * (box.getInt(INPATIENT_ID) != 0) { inpatientId =
							 * box.getInt(INPATIENT_ID); Inpatient inpatient =
							 * new Inpatient(); inpatient.setId(inpatientId);
							 * dgSampleCollectionHeader.setInpatient(inpatient);
							 * dgSampleCollectionHeader.setPatientType("IP");
							 * }else if(box.getString(VISIT_ID) != null &&
							 * !box.getString(VISIT_ID).equals("")){ visitId =
							 * box.getInt(VISIT_ID); Visit visit = new Visit();
							 * visit.setId(visitId);
							 * dgSampleCollectionHeader.setVisit(visit);
							 * dgSampleCollectionHeader.setPatientType("OP"); }
							 * int hinId = box.getInt(HIN_ID);
							 * 
							 * int collectionCenterId =
							 * box.getInt(COLLECTION_CENTER_ID); if (hinId != 0)
							 * { Patient patient = new Patient();
							 * patient.setId(hinId);
							 * dgSampleCollectionHeader.setHin(patient); } if
							 * (hospitalId != 0) { MasHospital hospital = new
							 * MasHospital(); hospital.setId(hospitalId);
							 * dgSampleCollectionHeader.setHospital(hospital); }
							 * 
							 * if (departmentId != 0) { MasDepartment
							 * masDepartment = new MasDepartment();
							 * masDepartment
							 * .setId(chargeCode.getMainChargecode()
							 * .getDepartment().getId());
							 * dgSampleCollectionHeader
							 * .setDepartment(masDepartment); }
							 * 
							 * if (departmentId != 0) { MasDepartment
							 * orderByDepartment = new MasDepartment();
							 * orderByDepartment.setId(departmentId);
							 * dgSampleCollectionHeader
							 * .setOrderByDepartment(orderByDepartment); }
							 * 
							 * dgSampleCollectionHeader.setOrder(dgOrderhd);
							 * 
							 * if (collectionCenterId != 0) { DgCollectionCenter
							 * dgCollectionCenter = new DgCollectionCenter();
							 * dgCollectionCenter.setId(collectionCenterId);
							 * dgSampleCollectionHeader
							 * .setCollectionCenter(dgCollectionCenter); }
							 * 
							 * dgSampleCollectionHeader.setOrderStatus("P");
							 */
							dgSampleCollectionHeader.setLastChgBy(userName);
							dgSampleCollectionHeader.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							dgSampleCollectionHeader.setLastChgTime(time);
							/*
							 * dgSampleCollectionHeader.setDiagnosisDate(HMSUtil.
							 * convertStringTypeDateToDateType(date));
							 * dgSampleCollectionHeader.setDiagnosisTime(time);
							 */
							// hbt.save(dgSampleCollectionHeader);

						} catch (DataAccessException e) {
							e.printStackTrace();
						}
						try {

							int collectedBy = box.getInt(EMPLOYEE_ID);
							for (int i = 0; i < chargeList.size(); i++) {
								int chargeId = 0;
								if (chargeList.get(i) != null
										&& !chargeList.get(i).equals("")) {
									chargeId = Integer
											.parseInt((String) chargeList
													.get(i));
									MasChargeCode maschrgCode = (MasChargeCode) session
											.createCriteria(MasChargeCode.class)
											.add(
													Restrictions.eq("Id",
															chargeId)).list()
											.get(0);
									if (maschrgCode.getMainChargecode()
											.getMainChargecodeCode()
											.equalsIgnoreCase("RADIO")) {
										MasChargeCode masChargeCode = new MasChargeCode();
										MasSubChargecode masSubChargecode = new MasSubChargecode();

										DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
										dgSampleCollectionDetails
												.setSampleCollectionHeader(dgSampleCollectionHeader);

										dgSampleCollectionDetails
												.setCollected("y");

										masChargeCode.setId(Integer
												.parseInt((String) chargeList
														.get(i)));
										dgSampleCollectionDetails
												.setChargeCode(masChargeCode);

										MasMainChargecode masMainChargecode = new MasMainChargecode();
										masMainChargecode.setId(maschrgCode
												.getMainChargecode().getId());
										dgSampleCollectionDetails
												.setMaincharge(masMainChargecode);

										if (subChargeList.get(i) != null
												&& !subChargeList.get(i)
														.equals("")) {
											masSubChargecode
													.setId(Integer
															.parseInt((String) subChargeList
																	.get(i)));
											dgSampleCollectionDetails
													.setSubcharge(masSubChargecode);
										}
										MasEmployee masEmployee = new MasEmployee();
										masEmployee.setId(collectedBy);
										dgSampleCollectionDetails
												.setCollectedBy(masEmployee);

										dgSampleCollectionDetails
												.setDiagNo(generateDiagNumber(Integer
														.parseInt((String) subChargeList
																.get(i))));

										dgSampleCollectionDetails
												.setInvestigation(new DgMasInvestigation(
														chargeId));
										dgSampleCollectionDetails
												.setLastChgBy(userName);
										dgSampleCollectionDetails
												.setLastChgDate(HMSUtil
														.convertStringTypeDateToDateType(date));
										dgSampleCollectionDetails
												.setLastChgTime(time);
										dgSampleCollectionDetails
												.setRejected("n");
										dgSampleCollectionDetails
												.setSampleCollDatetime(new Date());
										dgSampleCollectionDetails
												.setOrderStatus("P");
										try {
											hbt.save(dgSampleCollectionDetails);
											hbt
													.refresh(dgSampleCollectionDetails);
											// dgSampleCollectionDetailsSet.add(dgSampleCollectionDetails);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}
									}
								}
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
					goneInLoop = true;
					// dgSampleCollectionHeader.setDgSampleCollectionDetails(dgSampleCollectionDetailsSet);
					hbt.update(dgSampleCollectionHeader);
					hbt.refresh(dgSampleCollectionHeader);
				}
			}

			success = true;
			map.put("success", success);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("orderSeqNo", orderSeqNo);
		return map;
	}

	public Map<String, Object> updateSampleCollection(
			Map<String, Object> parameterMap) {
		List chargeList = new ArrayList();
		List subChargeList = new ArrayList();
		Box box = null;
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;

		String orderSeqNo = "";
		String createdBy = "";
		String userName = "";
		int dgOrderhdId = 0;
		int sampleCollDtId = 0;
		int sampleCollectionHeaderId = 0;

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("dgOrderhdId") != null) {
			dgOrderhdId = (Integer) parameterMap.get("dgOrderhdId");
		}

		chargeList = (List) parameterMap.get("chargeList");

		if (parameterMap.get("subChargeList") != null) {
			subChargeList = (List) parameterMap.get("subChargeList");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("departmentId") != null) {
			departmentId = (Integer) parameterMap.get("departmentId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("sampleCollectionHeaderId") != null) {
			sampleCollectionHeaderId = (Integer) parameterMap
					.get("sampleCollectionHeaderId");
		}
		if (parameterMap.get("sampleCollDtId") != null) {
			sampleCollDtId = (Integer) parameterMap.get("sampleCollDtId");
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		Transaction tx = null;
		Session session = (Session) getSession();

		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Vector charge_code_Id = box.getVector(CHARGE_CODE_ID);
		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		boolean goneInLoop = false;
		try {
			tx = session.beginTransaction();
			// //////////
			for (int j = 0; j < chargeList.size() && !goneInLoop; j++) {
				int chargeCodeId = Integer.parseInt("" + chargeList.get(j));
				chargeCodeList = session.createCriteria(MasChargeCode.class)
						.add(Restrictions.eq("Id", chargeCodeId)).createAlias(
								"MainChargecode", "mcc").createAlias(
								"mcc.Department", "dept").createAlias(
								"dept.DepartmentType", "dt").add(
								Restrictions
										.eq("dt.DepartmentTypeCode", "DIAG"))
						.list();

				if (chargeCodeList.size() > 0) {

					dgSampleCollectionHeader = (DgSampleCollectionHeader) hbt
							.load(DgSampleCollectionHeader.class,
									sampleCollectionHeaderId);
					// dgSampleCollectionDetailsSet =
					// dgSampleCollectionHeader.getDgSampleCollectionDetails();

					for (MasChargeCode chargeCode : chargeCodeList) {
						try {
							/*
							 * int inpatientId = 0; int visitId = 0; if
							 * (box.getInt(INPATIENT_ID) != 0) { inpatientId =
							 * box.getInt(INPATIENT_ID); Inpatient inpatient =
							 * new Inpatient(); inpatient.setId(inpatientId);
							 * dgSampleCollectionHeader.setInpatient(inpatient);
							 * dgSampleCollectionHeader.setPatientType("IP");
							 * }else if(box.getString(VISIT_ID) != null &&
							 * !box.getString(VISIT_ID).equals("")){ visitId =
							 * box.getInt(VISIT_ID); Visit visit = new Visit();
							 * visit.setId(visitId);
							 * dgSampleCollectionHeader.setVisit(visit);
							 * dgSampleCollectionHeader.setPatientType("OP"); }
							 * int hinId = box.getInt(HIN_ID);
							 * 
							 * int collectionCenterId =
							 * box.getInt(COLLECTION_CENTER_ID); if (hinId != 0)
							 * { Patient patient = new Patient();
							 * patient.setId(hinId);
							 * dgSampleCollectionHeader.setHin(patient); } if
							 * (hospitalId != 0) { MasHospital hospital = new
							 * MasHospital(); hospital.setId(hospitalId);
							 * dgSampleCollectionHeader.setHospital(hospital); }
							 * 
							 * if (departmentId != 0) { MasDepartment
							 * masDepartment = new MasDepartment();
							 * masDepartment
							 * .setId(chargeCode.getMainChargecode()
							 * .getDepartment().getId());
							 * dgSampleCollectionHeader
							 * .setDepartment(masDepartment); }
							 * 
							 * if (departmentId != 0) { MasDepartment
							 * orderByDepartment = new MasDepartment();
							 * orderByDepartment.setId(departmentId);
							 * dgSampleCollectionHeader
							 * .setOrderByDepartment(orderByDepartment); }
							 * if(dgOrderhdId != 0){ DgOrderhd dgOrderhd = new
							 * DgOrderhd(); dgOrderhd.setId(dgOrderhdId);
							 * dgSampleCollectionHeader.setOrder(dgOrderhd); }
							 * 
							 * 
							 * if (collectionCenterId != 0) { DgCollectionCenter
							 * dgCollectionCenter = new DgCollectionCenter();
							 * dgCollectionCenter.setId(collectionCenterId);
							 * dgSampleCollectionHeader
							 * .setCollectionCenter(dgCollectionCenter); }
							 * 
							 * dgSampleCollectionHeader.setOrderStatus("P");
							 */
							dgSampleCollectionHeader.setLastChgBy(userName);
							dgSampleCollectionHeader.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							dgSampleCollectionHeader.setLastChgTime(time);
							/*
							 * dgSampleCollectionHeader.setDiagnosisDate(HMSUtil.
							 * convertStringTypeDateToDateType(date));
							 * dgSampleCollectionHeader.setDiagnosisTime(time);
							 * hbt.save(dgSampleCollectionHeader);
							 */

						} catch (DataAccessException e) {
							e.printStackTrace();
						}
						try {

							int collectedBy = box.getInt(EMPLOYEE_ID);
							for (int i = 0; i < chargeList.size(); i++) {
								int chargeId = 0;
								if (chargeList.get(i) != null
										&& !chargeList.get(i).equals("")) {
									chargeId = Integer
											.parseInt((String) chargeList
													.get(i));
									MasChargeCode maschrgCode = (MasChargeCode) session
											.createCriteria(MasChargeCode.class)
											.add(
													Restrictions.eq("Id",
															chargeId)).list()
											.get(0);
									if (maschrgCode.getMainChargecode()
											.getMainChargecodeCode()
											.equalsIgnoreCase("Lab")) {
										MasChargeCode masChargeCode = new MasChargeCode();
										MasSubChargecode masSubChargecode = new MasSubChargecode();

										DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
										dgSampleCollectionDetails
												.setSampleCollectionHeader(dgSampleCollectionHeader);

										dgSampleCollectionDetails
												.setCollected("y");

										masChargeCode.setId(Integer
												.parseInt((String) chargeList
														.get(i)));
										dgSampleCollectionDetails
												.setChargeCode(masChargeCode);

										MasMainChargecode masMainChargecode = new MasMainChargecode();
										masMainChargecode.setId(maschrgCode
												.getMainChargecode().getId());
										dgSampleCollectionDetails
												.setMaincharge(masMainChargecode);

										if (subChargeList.get(i) != null
												&& !subChargeList.get(i)
														.equals("")) {
											masSubChargecode
													.setId(Integer
															.parseInt((String) subChargeList
																	.get(i)));
											dgSampleCollectionDetails
													.setSubcharge(masSubChargecode);
										}
										MasEmployee masEmployee = new MasEmployee();
										masEmployee.setId(collectedBy);
										dgSampleCollectionDetails
												.setCollectedBy(masEmployee);

										dgSampleCollectionDetails
												.setDiagNo(generateDiagNumber(Integer
														.parseInt((String) subChargeList
																.get(i))));

										dgSampleCollectionDetails
												.setInvestigation(new DgMasInvestigation(
														chargeId));
										dgSampleCollectionDetails
												.setLastChgBy(userName);
										dgSampleCollectionDetails
												.setLastChgDate(HMSUtil
														.convertStringTypeDateToDateType(date));
										dgSampleCollectionDetails
												.setLastChgTime(time);
										dgSampleCollectionDetails
												.setRejected("n");
										dgSampleCollectionDetails
												.setSampleCollDatetime(new Date());
										dgSampleCollectionDetails
												.setOrderStatus("P");
										try {
											// dgSampleCollectionDetailsSet.add(dgSampleCollectionDetails);
											hbt.save(dgSampleCollectionDetails);
											hbt
													.refresh(dgSampleCollectionDetails);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}

									}
								}
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}

					goneInLoop = true;
					// dgSampleCollectionHeader.setDgSampleCollectionDetails(dgSampleCollectionDetailsSet);
					hbt.update(dgSampleCollectionHeader);
					hbt.refresh(dgSampleCollectionHeader);
				}
			}
			// //////////
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> rejectSample(Map<String, Object> mapForDs) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();

		int sampleCollDtId = 0;
		String rejReason = "";
		Integer sampleCollectionIdToCheck = 0;

		if (mapForDs.get("sampleCollDtId") != null) {
			sampleCollDtId = (Integer) mapForDs.get("sampleCollDtId");
		}
		if (mapForDs.get("rejReason") != null) {
			rejReason = (String) mapForDs.get("rejReason");
		}

		Session session = (Session) getSession();

		dgSampleCollectionDetailsList = session.createCriteria(
				DgSampleCollectionDetails.class).add(
				Restrictions.eq("Id", sampleCollDtId)).list();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (dgSampleCollectionDetailsList.size() > 0) {
			DgSampleCollectionDetails dgSampleCollectionDetails = dgSampleCollectionDetailsList
					.get(0);
			dgSampleCollectionDetails.setRejected("y");
			dgSampleCollectionDetails.setReason(rejReason);
			hbt.update(dgSampleCollectionDetails);
			hbt.refresh(dgSampleCollectionDetails);
		}
		return detailsMap;
	}

	public Map<String, Object> getTotalCountDepartmentWise(
			Map<String, Object> mapForDs) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> pendingForSampleValidationList = new ArrayList<DgSampleCollectionDetails>();
		List<DgSampleCollectionDetails> pendingForResultEntryList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryHeader> pendingForResultValidationList = new ArrayList<DgResultEntryHeader>();

		int mainChargeCodeId = 0;
		int subChargeId = 0;
		Date currentDate = new Date();

		if (mapForDs.get("mainChargeCodeId") != null) {
			mainChargeCodeId = (Integer) mapForDs.get("mainChargeCodeId");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "P")).createAlias(
						"SampleCollectionHeader", "sampleHead").createAlias(
						"Maincharge", "mainChargeCode").add(
						Restrictions.eq("mainChargeCode.Id", mainChargeCodeId))
				.add(Restrictions.le("sampleHead.DiagnosisDate", currentDate));
		if (subChargeId != 0) {
			crit = crit.add(Restrictions.eq("Subcharge.Id", subChargeId));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id")).add(
				Restrictions.eq("Rejected", "n")).addOrder(
				Order.asc("Subcharge.Id"));
		crit = crit.setProjection(Projections.projectionList().add(
				Projections.groupProperty("SampleCollectionHeader")).add(
				Projections.groupProperty("Subcharge")));

		pendingForSampleValidationList = crit.list();

		crit = session.createCriteria(DgSampleCollectionDetails.class).add(
				Restrictions.eq("OrderStatus", "A")).createAlias(
				"SampleCollectionHeader", "sampleHead").createAlias(
				"sampleHead.Department", "dept").createAlias("Maincharge",
				"mainChargeCode").add(
				Restrictions.eq("mainChargeCode.Id", mainChargeCodeId));
		if (subChargeId != 0) {
			crit = crit.add(Restrictions.eq("Subcharge.Id", subChargeId));
		}
		crit = crit
				.add(
						Restrictions.le("sampleHead.SampleValidationDate",
								currentDate))
				.setProjection(
						Projections
								.projectionList()
								.add(
										Projections
												.groupProperty("SampleCollectionHeader"))
								.add(Projections.groupProperty("Subcharge")));
		pendingForResultEntryList = crit.list();

		crit = session.createCriteria(DgResultEntryHeader.class).add(
				Restrictions.eq("ResultStatus", "P")).createAlias("Department",
				"dept").add(
				Restrictions.eq("MainChargecode.Id", mainChargeCodeId));
		if (subChargeId != 0) {
			crit = crit.add(Restrictions.eq("SubChargecode.Id", subChargeId));
		}
		crit = crit.add(Restrictions.le("ResultDate", currentDate)).addOrder(
				Order.asc("SampleCollectionHeader.Id")).addOrder(
				Order.asc("SubChargecode.Id"));
		pendingForResultValidationList = crit.list();

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		if (pendingForResultValidationList.size() > 0) {
			patientListSubDepartWise.add(pendingForResultValidationList.get(0));
			stringOfIds = stringOfIds
					+ pendingForResultValidationList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ pendingForResultValidationList.get(0).getSubChargecode()
							.getId();

			// stringOfIdsList.add(stringOfIds);
			// stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < pendingForResultValidationList.size() - 1; ilop++) {
				if (!pendingForResultValidationList.get(ilop)
						.getSampleCollectionHeader().getId().equals(
								pendingForResultValidationList.get(ilop + 1)
										.getSampleCollectionHeader().getId())) {
					patientListSubDepartWise.add(pendingForResultValidationList
							.get(ilop + 1));
				} else {
					if (!pendingForResultValidationList.get(ilop)
							.getSubChargecode().getId().equals(
									pendingForResultValidationList
											.get(ilop + 1).getSubChargecode()
											.getId())) {
						patientListSubDepartWise
								.add(pendingForResultValidationList
										.get(ilop + 1));
					}
				}
			}
		}
		pendingForResultValidationList = patientListSubDepartWise;

		detailsMap.put("pendingForSampleValidationListTotal",
				pendingForSampleValidationList.size());
		detailsMap.put("pendingForResultEntryListTotal",
				pendingForResultEntryList.size());
		detailsMap.put("pendingForResultValidationListTotal",
				pendingForResultValidationList.size());

		return detailsMap;
	}

	@Override
	public Map<String, Object> showDiagnosticRegisterSummaryJsp(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		
		/*subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y")).createAlias(
						"MainChargecode", "mcc").createAlias(
								"mcc.Department", "dep").add(
										Restrictions.eq("dep.Id", deptId)).list();*/
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
							.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SubChargecodeName")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y"))
				.createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.DepartmentTypeCode", "DIAG")).addOrder(Order.asc("DepartmentName")).list();
		chargeCodeList = session.createCriteria(DgMasInvestigation.class).createAlias("SubChargecode", "sc").createAlias("MainChargecode", "mcc").createAlias("mcc.Department", "d").add(Restrictions.eq("Status", "y"))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("InvestigationName")).add(Projections.property("d.Id"))
							.add(Projections.property("sc.Id"))).addOrder(Order.asc("InvestigationName")).list();
		if (subChargeCodeList.size() > 0) {
			map.put("subChargeCodeList", subChargeCodeList);
		}
		if (departmentList.size() > 0) {
			map.put("departmentList", departmentList);
		}
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}

	@Override
	public Map<String, Object> getDiagnosticSummary(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> diagnosticRegisterList = new ArrayList<Object[]>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		String subQry = "";
		if(box.getInt(DEPARTMENT_ID)!=0) {
			subQry += " and mcc.department_id="+box.getInt(DEPARTMENT_ID);
		}
		if(box.getInt(SUB_CHARGECODE_ID)!=0) {
			subQry += " and inv.sub_chargecode_id="+box.getInt(SUB_CHARGECODE_ID);
		}
		if(box.getInt(INVESTIGATION_ID)!=0) {
			subQry += " and inv.investigation_id="+box.getInt(INVESTIGATION_ID);
		}
	/*	String qry ="select distinct (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID " +
				" where inpatient_id is null and dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
				" between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) op ," +
				" (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID " +
				" where inpatient_id is not null and dghe.investigation_id=dgh.investigation_id " +
				" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' and " +
				" dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) ip ," +
				" (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID " +
				" where  dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
				" between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) total," +
				" investigation_name,scc.sub_chargecode_name,mcc.main_chargecode_name" +
				" from dg_result_entry_detail dgd inner join dg_result_entry_header dgh on dgd.RESULT_ENTRY_ID=dgh.RESULT_ENTRY_ID" +
				" left join dg_mas_investigation inv on dgh.INVESTIGATION_ID=inv.INVESTIGATION_ID" +
				" left join mas_main_chargecode mcc on inv.MAIN_CHARGECODE_ID = mcc.MAIN_CHARGECODE_ID" +
				" left join mas_sub_chargecode scc on inv.SUB_CHARGECODE_ID = scc.SUB_CHARGECODE_ID" +
				" where dgh.result_date between '"+fromDate+"' and '"+toDate+"' and dgh.hospital_id ="+box.getInt("hospitalId")+
				" "+subQry+
				" order by mcc.main_chargecode_name,scc.sub_chargecode_name,investigation_name";
		*/
		String qry ="select distinct (select count(*) from  dg_result_entry_header dghe" +
		" where inpatient_id is null and dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
		" between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
		" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) op ," +
		" (select count(*)from  dg_result_entry_header dghe"+
		" where inpatient_id is not null and dghe.investigation_id=dgh.investigation_id " +
		" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' and " +
		" dghe.hospital_id ="+box.getInt("hospitalId")+
		" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) ip ," +
		" (select count(*) from  dg_result_entry_header dghe " +
		" where  dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
		" between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
		" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) total," +
		" investigation_name,scc.sub_chargecode_name,mcc.main_chargecode_name" +
		" from dg_result_entry_detail dgd inner join dg_result_entry_header dgh on dgd.RESULT_ENTRY_ID=dgh.RESULT_ENTRY_ID" +
		" left join dg_mas_investigation inv on dgh.INVESTIGATION_ID=inv.INVESTIGATION_ID" +
		" left join mas_main_chargecode mcc on inv.MAIN_CHARGECODE_ID = mcc.MAIN_CHARGECODE_ID" +
		" left join mas_sub_chargecode scc on inv.SUB_CHARGECODE_ID = scc.SUB_CHARGECODE_ID" +
		" where dgh.result_date between '"+fromDate+"' and '"+toDate+"' and dgh.hospital_id ="+box.getInt("hospitalId")+
		" "+subQry+
		" order by mcc.main_chargecode_name,scc.sub_chargecode_name,investigation_name";

		diagnosticRegisterList = session.createSQLQuery(qry).list();	
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("hospitalId"))).list();
		map.put("hospitalList", hospitalList);
		map.put("diagnosticRegisterList", diagnosticRegisterList);
	  return map;
	}

	@Override
	public Map<String, Object> showBloodDonorPanelJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasRank> rankList = null;
		List<MasRelation> relationList = null;
		List<MasAdministrativeSex> sexList = null;
		Session session = (Session)getSession();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(
				Order.asc("UnitName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		relationList = session.createCriteria(MasRelation.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		map.put("bloodGroupList", bloodGroupList);
		map.put("unitList", unitList);
		map.put("rankList", rankList);
		map.put("relationList", relationList);
		map.put("sexList", sexList);
		return map;
	}

	@Override
	public Map<String, Object> getDiagnosticDetailstForGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> diagnosticRegisterList = new ArrayList<Object[]>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		String subQry = "";
		if(box.getInt(DEPARTMENT_ID)!=0) {
			subQry += " and mcc.department_id="+box.getInt(DEPARTMENT_ID);
		}
		if(box.getInt(SUB_CHARGECODE_ID)!=0) {
			subQry += " and inv.sub_chargecode_id="+box.getInt(SUB_CHARGECODE_ID);
		}
		if(box.getInt(INVESTIGATION_ID)!=0) {
			subQry += " and inv.investigation_id="+box.getInt(INVESTIGATION_ID);
		}
		String qry ="select distinct " +
				" (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID" +
				" where inpatient_id is null and dghe.sub_chargecode_id=dgh.sub_chargecode_id" +
				" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.sub_chargecode_id) op," +
				" (select count(*) from  dg_result_entry_detail red" +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID" +
				" where inpatient_id is not null and dghe.sub_chargecode_id=dgh.sub_chargecode_id" +
				" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.sub_chargecode_id) ip ," +
				" (select count(*) from  dg_result_entry_detail red" +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID" +
				" where  dghe.sub_chargecode_id=dgh.sub_chargecode_id" +
				" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.sub_chargecode_id) total," +
				" scc.sub_chargecode_name" +
				" from dg_result_entry_detail dgd inner join dg_result_entry_header dgh on dgd.RESULT_ENTRY_ID=dgh.RESULT_ENTRY_ID" +
				" left join mas_sub_chargecode scc on dgh.SUB_CHARGECODE_ID = scc.SUB_CHARGECODE_ID" +
				" where dgh.result_date between '"+fromDate+"' and '"+toDate+"' and dgh.hospital_id ="+box.getInt("hospitalId")+
				" order by scc.sub_chargecode_name";
		
		diagnosticRegisterList = session.createSQLQuery(qry).list();	
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("hospitalId"))).list();
		map.put("hospitalList", hospitalList);
		map.put("diagnosticRegisterList", diagnosticRegisterList);
	  return map;
	}

	@Override
	public Map<String, Object> showInvestigationRequisitionWaitingList(int hospitalId, int deptId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> labWaitingList = new ArrayList<Visit>();
		List<DgOrderhd> otherDgWaitList = new ArrayList<DgOrderhd>();
		
		Session session = (Session)getSession();
		String rptFor = "";
		if(deptId==117){
			rptFor = "Lab";
		}else if(deptId==49){
			rptFor = "Radiology";
		}
		labWaitingList = session.createCriteria(Visit.class).add(
						Restrictions.eq("VisitDate", new Date())).add(
						Restrictions.eq("VisitStatus", "w"))
						.add(Restrictions.eq("ReportingFor",rptFor))
						.createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId))
						.addOrder(Order.asc("VisitTime"))
						.list();
		
		otherDgWaitList = session.createCriteria(DgOrderhd.class)
		.add(Restrictions.eq("OrderDate", new Date()))
		.add(Restrictions.eq("OrderStatus", "p").ignoreCase())
		.add(Restrictions.isNotNull("OtherInvestigation")).list();
		map.put("labWaitingList", labWaitingList);
		map.put("otherDgWaitList", otherDgWaitList);
		return map;
	}

	@Override
	public Map<String, Object> showInvestigationRequisitionJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		
		Session session = (Session)getSession();
		patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(box.getInt("hinId"))).list();
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> submitInvestigationRequisition(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		boolean saved = false;
		Session session = (Session)getSession();
		Transaction tx = null;
		try {
			tx= session.beginTransaction();
			int count = box.getInt("hiddenValue");
			String chargeCodeName = "";
			for (int l = 1; l <= count; l++) {
				chargeCodeName = box.getString("chargeCodeName"+l);
				if(!chargeCodeName.equals("")){
					break;
				}
			}
			if (!chargeCodeName.equals("")) {

				MasDepartment masDepartment = new MasDepartment();
				MasHospital masHospital = new MasHospital();
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();
				DgOrderhd dgOrderhd = new DgOrderhd();
				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				if(box.getInt("dgOrderhdId")==0){
					dgOrderhd.setOrderDate(new Date());
					dgOrderhd.setOrderTime(time);
					masHospital.setId(box.getInt("hospitalId"));
					dgOrderhd.setHospital(masHospital);
					patient.setId(box.getInt("hinId"));
					dgOrderhd.setHin(patient);
					masDepartment.setId( box.getInt("deptId"));
					dgOrderhd.setDepartment(masDepartment);
					/*	if ( box.getInt("empId") != 0) {
				masEmployee2.setId(box.getInt("empId") );
				dgOrderhd.setPrescribedBy(masEmployee2);
			}*/
					dgOrderhd.setPatientType("OP");
					dgOrderhd.setTestType("Regular");
					dgOrderhd.setCreatedby(box.getString("userName"));
					dgOrderhd.setCreatedon(new Date());

					String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
					dgOrderhd.setOrderNo(orderSeqNo);
					if (box.getInt("visitId") != 0) {
						Visit visit = new Visit();
						visit.setId(box.getInt("visitId"));
						dgOrderhd.setVisit(visit);
					}else if (box.getInt("visitId") == 0) { // for direct investigation entry without visit
						Visit visit = new Visit();
						visit.setVisitNo(box.getInt("currentVisitNo")+1);
						visit.setTokenNo(0);
						visit.setHin(patient);
						visit.setAge(box.getString("age"));
						visit.setVisitDate(new Date());
						visit.setVisitTime(time);
						Users user = new Users();
						user.setId(box.getInt("userId"));
						visit.setAddEditBy(user);
						visit.setAddEditDate(new Date());
						visit.setAddEditTime(time);
						visit.setStatus("y");
						visit.setVisitStatus("c");
						visit.setAppointmentType("D");
						visit.setHospital(masHospital);
						visit.setReportingFor("Lab");
						visit.setPriority(3);
						hbt.save(visit);

						Patient p =(Patient) hbt.load(Patient.class, box.getInt("hinId"));
						p.setCurrentVisitNo(box.getInt("currentVisitNo")+1);
						hbt.update(p);

						dgOrderhd.setVisit(visit);
					}
					//dgOrderhd.setClinicalNote(clinicalNotes1);
					dgOrderhd.setOrderStatus("P");
					dgOrderhd.setLabOrderStatus("P");
					
					Users user = new Users();
					user.setId(box.getInt("userId"));
					dgOrderhd.setLastChgBy(user);
					
					dgOrderhd.setLastChgDate(new Date());
					dgOrderhd.setLastChgTime(time);
					hbt.save(dgOrderhd);
				}else if(box.getInt("dgOrderhdId")!=0 && box.getInt("patientInvId")!=0){
					dgOrderhd.setId(box.getInt("dgOrderhdId"));
					patientInvestigationHeader.setId(box.getInt("patientInvId"));
				}
				for (int i =1; i <= count; i++) {
					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					MasChargeCode masChargeCode = new MasChargeCode();
					String chargeCode = box.getString("chargeCodeName"+i);
					int index1 = chargeCode.lastIndexOf("[");
					int index2 = chargeCode.lastIndexOf("]");
					index1++;
					String chargeCodeId = chargeCode.substring(index1,index2);
					masChargeCode.setId(Integer.parseInt(chargeCodeId));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setOrderQty(1);

					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(new Date());
					Users user = new Users();
					user.setId(box.getInt("userId"));
					
					
					dgOrderdt.setLastChgBy(user);
					dgOrderdt.setLastChgDate(new Date());
					dgOrderdt.setLastChgTime(time);
					List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
					masChargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Id", Integer.parseInt(chargeCodeId))).list();
					
					MasChargeCode masChargeCodeObj = masChargeList.get(0);
					int mainChargeId = masChargeCodeObj.getMainChargecode().getId();
					int subChargeId = masChargeCodeObj.getSubChargecode().getId();
					if (masChargeCodeObj.getMainChargecode().getMainChargecodeCode().equalsIgnoreCase("Lab")) {
						dgOrderdt.setOrderStatus("P");
					} else {
						dgOrderdt.setOrderStatus("P");
					}
			       MasMainChargecode masMainChargecode = new MasMainChargecode();
					masMainChargecode.setId(mainChargeId);
					dgOrderdt.setMainChargecode(masMainChargecode);
					MasSubChargecode masSubChargecode = new MasSubChargecode();
					masSubChargecode.setId(subChargeId);
					dgOrderdt.setSubChargeid(masSubChargecode);
					dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeId)));
					dgOrderdt.setInvestigationToMh("n");
					dgOrderdt.setReferToMh("n");
					hbt.save(dgOrderdt);
					
					if(box.getInt("patientInvId")!=0){
						PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
						patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
						patientInvestigationDetails.setChargeCode(masChargeCode);
						patientInvestigationDetails.setReferToMh("n");

						hbt.save(patientInvestigationDetails);
					}
					
				}
				
				Visit visitobj = (Visit)hbt.load(Visit.class, box.getInt("visitId"));
				visitobj.setVisitStatus("c");
				hbt.update(visitobj);
			}
			saved = true;
			tx.commit();
			
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} catch (NumberFormatException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> getInvestigationDetailsForDischargeSummary(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<DgResultEntryHeader> invResultList = new ArrayList<DgResultEntryHeader>();
		List<PatientInvestigationDetails> patientInvestigationList = new ArrayList<PatientInvestigationDetails>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		Session session = (Session)getSession();
		
		patientInvestigationList = (List<PatientInvestigationDetails>) session
										.createCriteria(PatientInvestigationDetails.class)
										.createAlias("InvestigationHeader", "ih").add(Restrictions.eq("ih.Inpatient.Id", inpatientId))
												.addOrder(Order.desc("Id")).list();
		/*if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader",patientInvestigationHeader);

		}*/
		map.put("patientInvestigationList", patientInvestigationList);
		
		invResultList = session.createCriteria(DgResultEntryHeader.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		map.put("invResultList", invResultList);
		return map;
	}

	@Override
	public Map<String, Object> getPhysiotherapyList(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhysioRequisitionHeader> physioReqList = new ArrayList<PhysioRequisitionHeader>();
		Session session = (Session)getSession();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		physioReqList = session.createCriteria(PhysioRequisitionHeader.class).add(Restrictions.eq("Inpatient.Id",inpatientId)).list();
		map.put("physioReqList", physioReqList);
		return map;
	}

	@Override
	public Map<String, Object> getResponseForPhysiotherapyDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhysioRequisitionDetail> physioDetailsList = new ArrayList<PhysioRequisitionDetail>();
		Session session = (Session)getSession();
		int physioReqHeaderId = box.getInt("physioReqHeaderId");
		physioDetailsList = session.createCriteria(PhysioRequisitionDetail.class).add(Restrictions.eq("PhysioRequisitionHeader.Id",physioReqHeaderId)).list();
		map.put("physioDetailsList", physioDetailsList);
		return map;
	}
	
	
	@Override
	public Map<String, Object> getHospitalName(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		
		hospitalNameList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",hospitalId)).list();
		map.put("hospitalNameList", hospitalNameList);
		return map;
	}

	
	@Override
	public Map<String, Object> investigationResult(Box box) {
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
		int chargeCodeId=0;
		Criteria crit = null;
		try {
			if (box.get("orderNo") != null) {
				orderNo = (String) box.get("orderNo");
			}
			
			if (box.get("chargeCodeId") != null) {
				chargeCodeId = box.getInt("chargeCodeId");
			}
			Session session = (Session) getSession();

			List<DgOrderhd> hdList = new ArrayList<DgOrderhd>();
			hdList = session.createCriteria(DgOrderhd.class)
					.add(Restrictions.eq("OrderNo", orderNo)).list();
			List<DgOrderhd> dtList = new ArrayList<DgOrderhd>();

			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
			if (!orderNo.equals("")) {
				dgResultEntryHeaderByOrderNo = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("DgMasInvestigation", "inv")
						.add(Restrictions.eq("inv.Id", chargeCodeId)) 
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo)) 
						.add(Restrictions.eq("Verified", "V").ignoreCase()) 
						.createAlias("MainChargecode", "mcc")
						/*.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB")) */
					
						.addOrder(Order.asc("Id")).list();
			}
			
			List<UploadDocuments> documentList = new ArrayList<UploadDocuments>();
			int resultHeaderId=0;
			
			for(DgResultEntryHeader header : dgResultEntryHeaderByOrderNo)
			{
				resultHeaderId = header.getId();
			}
			
			System.out.println("resultHeaderId="+resultHeaderId);
			
			documentList = session
					.createCriteria(UploadDocuments.class)
					.createAlias("ResultEntry", "resultEntry")
					.add(Restrictions.eq("resultEntry.Id", resultHeaderId)).list();
			
			detailsMap.put("documentList", documentList);
			
			
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("DgMasInvestigation", "inv")
						.add(Restrictions.eq("inv.Id", chargeCodeId)) 
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo)) 
						.add(Restrictions.eq("Verified", "V").ignoreCase()) 
						.createAlias("MainChargecode", "mcc")
						/*.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))*/
						.createAlias("SubChargecode", "subCharg")
						.setProjection(
								Projections.distinct(Projections
										.projectionList()
										.add(Projections
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
				if (dgResultEntryDetailForData.getResultEntry().getPatient() != null) {
					detailsMap.put("serviceNo", dgResultEntryDetailForData
							.getResultEntry().getPatient().getServiceNo());
				}

				detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrder().getDepartment().getDepartmentName());
				/*
				 * detailsMap.put("departmentType",session.getAttribute("deptId")
				 * );
				 */

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

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());

				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
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
					if (e1.getRank() != null) {
						String entryPersonNameDesignation = e1.getRank()
								.getRankName();
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
					if (e2.getRank() != null) {
						String verifiedPersonNameDesignation = e2.getRank()
								.getRankName();
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
				if (dgResultEntryDetailSenForData.getResultEntry() != null) {
					if (dgResultEntryDetailSenForData.getResultEntry().getPatient()!= null) {
						detailsMap.put("serviceNo", dgResultEntryDetailSenForData
								.getResultEntry().getPatient().getServiceNo());
					}

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
					detailsMap.put("orderNo", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderNo());
					detailsMap.put("orderDate", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderDate());

					detailsMap.put("patientAge", p.getAge());
					detailsMap
							.put("sex", p.getSex().getAdministrativeSexName());
					detailsMap.put("resultDate", dgResultEntryDetailSenForData
							.getResultEntry().getResultDate());
					detailsMap.put("subChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getSubChargecode().getSubChargecodeName());
					detailsMap.put("mainChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getMainChargecode()
									.getMainChargecodeName());
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

					MasEmployee e = dgResultEntryDetailSenForData
							.getResultEntry().getSampleCollectionHeader()
							.getOrder().getPrescribedBy();
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

					MasEmployee e1 = dgResultEntryDetailSenForData
							.getResultEntry().getEmployee();
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
						if (e1.getRank() != null) {
							String entryPersonNameDesignation = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameDesignation",
									entryPersonNameDesignation);
						}
						if (e1.getRank() != null) {
							String entryPersonNameRank = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameRank",
									entryPersonNameRank);

						}

					}
					MasEmployee e2 = dgResultEntryDetailSenForData
							.getResultEntry().getResultVerifiedBy();
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
						if (e2.getRank() != null) {
							String verifiedPersonNameDesignation = e2.getRank()
									.getRankName();
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsforBackup(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionHeader> completedCollectionList = new ArrayList<DgSampleCollectionHeader>();
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		Date fromDate = null;
		Date toDate = null;
		String serPersonFName = "";
		String patientFName = "";
		String pType = "";
		String orderStatus = "";
		String adNo = "";
		String requestFromMethod = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		String departmentId = "";
		int hospitalId = 0;
		Criteria crit = null;
		Criteria critApp = null;
		
		boolean completedCollectionFlag = false;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		
		String orderNo="";
		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
			
		System.out.println("orderNo2"+orderNo);
		if(patientDetailList.size()==0)
		{
			crit = session.createCriteria(DgSampleCollectionHeader.class)
					.createAlias("Order", "hd")
					.createAlias("Hospital","h").add(Restrictions.eq("h.Id", hospitalId));		
			
			if (!orderNo.equals("")) {
				crit = crit.add(Restrictions.eq("hd.OrderNo", orderNo));
			}
			
			crit= crit.addOrder(Order.desc("DiagnosisDate"));
			
			crit.setFirstResult(0);
			crit.setMaxResults(10);
			completedCollectionList = crit.list();
			completedCollectionFlag=true;
			map.put("completedCollectionFlag", completedCollectionFlag);
			map.put("completedCollectionList", completedCollectionList);

		}
		
		System.out.println("completedCollectionList="+completedCollectionList.size());
		
		
		
		return map;
	}


	
	


}
