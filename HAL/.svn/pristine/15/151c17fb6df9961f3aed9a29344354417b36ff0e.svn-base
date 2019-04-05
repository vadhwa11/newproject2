package jkt.hms.billing.dataservice;

import static jkt.hms.util.RequestConstants.ADVANCE_AMOUNT;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.CHARGE_SLIP_AMOUNT;
import static jkt.hms.util.RequestConstants.CHEQUE_DATE;
import static jkt.hms.util.RequestConstants.CHEQUE_NO;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.PAYMENT_MODE;
import static jkt.hms.util.RequestConstants.RECEIPT_DATE;
import static jkt.hms.util.RequestConstants.RECEIPT_TIME;
import static jkt.hms.util.RequestConstants.RECEIVED_FROM;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SETTLEMENT_DATE;
import static jkt.hms.util.RequestConstants.SETTLEMENT_TIME;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlDepositDetails;
import jkt.hms.masters.business.BlDepositHeader;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.BlPatientLedger;
import jkt.hms.masters.business.BlReceiptDetails;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.BlRefundDetails;
import jkt.hms.masters.business.BlRefundHeader;
import jkt.hms.masters.business.BlVoucherDetails;
import jkt.hms.masters.business.BlVoucherHeader;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAccount;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.dataservice.BillingMasterDataService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BillingDataServiceImpl extends HibernateDaoSupport implements
		BillingDataService {

	/**
	 * --------------------------- Method to get hin no for billing search
	 * -----------------------------------
	 * 
	 */
	
	BillingMasterDataService billingMasterDataService = null;


	@SuppressWarnings("unchecked")
	public List<Patient> getHinNo(String serviceNo) {
		List<Patient> hinNoList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {
			hinNoList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(
					Restrictions.eq("PatientStatus", "In Patient"))
					.createAlias("Inpatients", "ip").add(
							Restrictions.not(Restrictions
									.eq("ip.AdStatus", "D"))).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return hinNoList;
	}

	/**
	 * --------------------------- Method to get Admission no for billing search
	 * -----------------------------------
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Inpatient> getAdNo(String hin) {
		List<Inpatient> adNoList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		try {
			adNoList = session.createCriteria(Inpatient.class).add(
					Restrictions.not(Restrictions.eq("AdStatus", "D")))
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", hin)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return adNoList;
	}

	/**
	 * --------------------------- Method to get patient details for Ip billing
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(String adNo) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientDetailsList = new ArrayList<Patient>();

		Session session = (Session) getSession();

		try {
			patientDetailsList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdNo", adNo)).list();

			if (patientDetailsList.size() > 0) {
				detailsMap.put("patientDetailsList", patientDetailsList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/**
	 * --------------------------- Method to get charge code for auto
	 * complete-----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();

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
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Session session = (Session) getSession();
			if (subChargeCodeId != 0) {
				chargeCodeList = session.createCriteria(MasChargeCode.class)
						.add(Restrictions.like("ChargeCodeName", str))
						.createAlias("SubChargecode", "scc").add(
								Restrictions.eq("scc.Id", subChargeCodeId))
						.list();
			} else if (mainChargeCodeId != 0) {
				try {
					chargeCodeList = session
							.createCriteria(MasChargeCode.class).add(
									Restrictions.like("ChargeCodeName", str))
							.createAlias("MainChargecode", "mcc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} else if (subChargeCodeId == 0 && mainChargeCodeId == 0) {
				chargeCodeList = session.createCriteria(MasChargeCode.class)
						.add(Restrictions.like("ChargeCodeName", str)).list();
			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
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

	/**
	 * --------------------------- Method to get MainChargeCode & SubChargeCode
	 * List-----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMainAndSubCharge() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();

		Session session = (Session) getSession();
		try {
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).add(
							Restrictions.eq("Status", "y")).list();
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

	/**
	 * --------------------------- Method to fill details in grid for Charge
	 * code -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasStoreBrand> chargeList = new ArrayList<MasStoreBrand>();
		Session session = (Session) getSession();
		String chargeName = (String) dataMap.get("chargeName");
		try {
			chargeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("ChargeCodeName", chargeName)).list();
			map.put("chargeList", chargeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to submit billing details of a
	 * patient-----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitBillingDetails(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();
		List chargeList = new ArrayList();
		List rateList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List netAmountList = new ArrayList();
		boolean success = false;
		int chargeSlipMainId = 0;
		String userName = "";
		int chargeMainIdFromRequest = 0;
		BigDecimal billAmt = null;
		BigDecimal discountAmt = null;
		int inpatientId = 0;
		int hinId = 0;
		int hospitalId = 0;

		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		if (infoMap.get("rateList") != null) {
			rateList = (List) infoMap.get("rateList");
		}
		if (infoMap.get("amountList") != null) {
			amountList = (List) infoMap.get("amountList");
		}
		if (infoMap.get("discountList") != null) {
			discountList = (List) infoMap.get("discountList");
		}
		if (infoMap.get("netAmountList") != null) {
			netAmountList = (List) infoMap.get("netAmountList");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("chargeMainIdFromRequest") != null) {
			chargeMainIdFromRequest = (Integer) infoMap
					.get("chargeMainIdFromRequest");
		}
		if (infoMap.get("inpatientId") != null) {
			inpatientId = (Integer) infoMap.get("inpatientId");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("billAmt") != null) {
			billAmt = (BigDecimal) infoMap.get("billAmt");
		}
		if (infoMap.get("discountAmt") != null) {
			discountAmt = (BigDecimal) infoMap.get("discountAmt");
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);

		Session session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// --------------------------Saving Data into BlChargeSlipMain
			// Table---------------------------

			if (infoMap.get("blChargeSlipMain") != null) {
				blChargeSlipMain = (BlChargeSlipMain) infoMap
						.get("blChargeSlipMain");
				hbt.save(blChargeSlipMain);
				chargeSlipMainId = blChargeSlipMain.getId();
				map.put("chargeSlipMainId", chargeSlipMainId);
			} else {

				BlChargeSlipMain blChargeSlipMainObj = new BlChargeSlipMain();
				blChargeSlipMainObj = (BlChargeSlipMain) hbt.load(
						BlChargeSlipMain.class, chargeMainIdFromRequest);

				BigDecimal prevBillAmt = null;
				BigDecimal prevDiscountAmt = null;
				BigDecimal newDiscountAmt = null;
				prevBillAmt = blChargeSlipMainObj.getBillAmt();
				if (blChargeSlipMainObj.getDisAmt() != null) {
					prevDiscountAmt = blChargeSlipMainObj.getDisAmt();
				}

				BigDecimal newBillAmt = prevBillAmt.add(billAmt);
				if (prevDiscountAmt != null) {
					newDiscountAmt = prevDiscountAmt.add(discountAmt);
				} else {
					newDiscountAmt = discountAmt;
				}
				blChargeSlipMainObj.setBillAmt(newBillAmt);
				blChargeSlipMainObj.setDisAmt(newDiscountAmt);

				hbt.update(blChargeSlipMainObj);
			}

			// --------------------------Saving Data into BlPatientLedger
			// Table---------------------------

			List<BlPatientLedger> listfromPatientLedger = new ArrayList<BlPatientLedger>();
			listfromPatientLedger = session.createCriteria(
					BlPatientLedger.class).createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inpatientId)).list();

			Patient patient = new Patient();
			patient.setId(hinId);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);

			if (listfromPatientLedger.size() > 0) {
				BlPatientLedger ledgerObj = new BlPatientLedger();
				for (BlPatientLedger blPatientLedger : listfromPatientLedger) {
					int patientLedgerId = blPatientLedger.getId();
					ledgerObj = (BlPatientLedger) hbt.load(
							BlPatientLedger.class, patientLedgerId);
					BigDecimal newTotal = null;
					if (ledgerObj.getTotalChargeSlipAmt() != null) {
						BigDecimal amt = ledgerObj.getTotalChargeSlipAmt();
						newTotal = amt.add(billAmt);
					} else {
						newTotal = billAmt;
					}
					ledgerObj.setTotalChargeSlipAmt(newTotal);
					ledgerObj.setLastChgBy(userName);
					ledgerObj.setLastChgDate(changeDate);
					ledgerObj.setLastChgTime(time);
				}
				hbt.update(ledgerObj);

			} else {
				BlPatientLedger blPatientLedger = new BlPatientLedger();
				blPatientLedger.setHospital(hospital);
				blPatientLedger.setHin(patient);
				blPatientLedger.setInpatient(inpatient);
				blPatientLedger.setTotalChargeSlipAmt(billAmt);
				blPatientLedger.setLastChgBy(userName);
				blPatientLedger.setLastChgDate(changeDate);
				blPatientLedger.setLastChgTime(time);
				blPatientLedger.setStatus("y");

				hbt.save(blPatientLedger);
			}

			// --------------------------Saving Data into BlChargeSlipDetail
			// Table---------------------------

			if (infoMap.get("chargeList") != null) {
				chargeList = (List) infoMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {
						BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
						blChargeSlipDetail.setHospital(hospital);

						MasChargeCode masChargeCode = new MasChargeCode();
						if (chargeList.get(i) != null) {
							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							blChargeSlipDetail.setChargeCode(masChargeCode);

							if (rateList.get(i) != null) {
								BigDecimal rate = new BigDecimal(rateList
										.get(i).toString());
								blChargeSlipDetail.setRate(rate);
							}
							if (amountList.get(i) != null) {
								BigDecimal amount = new BigDecimal(amountList
										.get(i).toString());
								blChargeSlipDetail.setAmt(amount);
							}
							if (discountList.size() > 0) {
								if (discountList.get(i) != null) {
									BigDecimal discount = new BigDecimal(
											discountList.get(i).toString());
									blChargeSlipDetail.setDis(discount);
								}
							}
							if (netAmountList.get(i) != null) {
								BigDecimal netAmount = new BigDecimal(
										netAmountList.get(i).toString());
								blChargeSlipDetail.setNetAmt(netAmount);
							}
							if (qtyList.get(i) != null) {
								int qty = Integer.parseInt(qtyList.get(i)
										.toString());
								blChargeSlipDetail.setQuantity(qty);
								blChargeSlipDetail.setLastChgBy(userName);
								blChargeSlipDetail.setLastChgDate(changeDate);
								blChargeSlipDetail.setLastChgTime(time);
								blChargeSlipDetail.setStatus("y");
								if (infoMap.get("blChargeSlipMain") != null) {
									blChargeSlipDetail
											.setChargeSlipMain(blChargeSlipMain);

								} else {
									BlChargeSlipMain blSlipMain = new BlChargeSlipMain();
									blSlipMain.setId(chargeMainIdFromRequest);
									blChargeSlipDetail
											.setChargeSlipMain(blSlipMain);
								}
							}
							hbt.save(blChargeSlipDetail);
						}
					}
				}
			}
			success = true;
			map.put("success", success);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();
			map.put("rankList", rankList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("unitList", unitList);
			map.put("wardList", wardList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hinId = 0;

		Session session = (Session) getSession();
		Criteria crit = null;

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) mapForDs.get("serviceTypeId");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = (Integer) mapForDs.get("rankId");
		}
		if (mapForDs.get("unitId") != null) {
			unitId = (Integer) mapForDs.get("unitId");
		}
		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("serPersonMName") != null) {
			serPersonMName = (String) mapForDs.get("serPersonMName");
		}
		if (mapForDs.get("serPersonLName") != null) {
			serPersonLName = (String) mapForDs.get("serPersonLName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientMName") != null) {
			patientMName = (String) mapForDs.get("patientMName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		crit = session.createCriteria(Patient.class).add(
				Restrictions.eq("PatientStatus", "In Patient")).createAlias(
				"Inpatients", "ip").add(
				Restrictions.not(Restrictions.eq("ip.AdStatus", "D")));
		if (hinId == 0) {
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientFName
						+ "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("PMiddleName", patientMName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("PLastName", patientLName
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("SFirstName", serPersonFName
						+ "%"));
			}
			if (!serPersonMName.equals("")) {
				crit = crit.add(Restrictions.like("SMiddleName", serPersonMName
						+ "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("SLastName", serPersonLName
						+ "%"));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("ServiceType", "st").add(
						Restrictions.eq("st.Id", serviceTypeId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}

		} else if (hinId != 0) {
			crit = crit.add(Restrictions.idEq(hinId));
		}
		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public int getChargeSlipNo() {
		int chargeSlipSeqNo = 0;
		List<TransactionSequence> chargeSlipSeqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			chargeSlipSeqNoList = session.createCriteria(
					TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "CS")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		if (chargeSlipSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : chargeSlipSeqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				chargeSlipSeqNo = ++seqNo;
				transactionSequenceObj
						.setTransactionSequenceNumber(chargeSlipSeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (chargeSlipSeqNoList.size() == 0) {
			chargeSlipSeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BlChargeSlipMain");
			tsObj.setTransactionPrefix("CS");
			tsObj.setTransactionSequenceName("Charge Slip Seq. No.");
			tsObj.setTransactionSequenceNumber(chargeSlipSeqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);

		}
		return chargeSlipSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateSeqNo(String seqNoType) {
		String receiptNo = "";
		int receiptSeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		String tableName = "";
		String prefix = "";
		String seqNoName = "";
		if (seqNoType.equals("Receipt")) {
			tableName = "BlDepositHeader";
			prefix = "RE";
			seqNoName = "Receipt No.";
		} else if (seqNoType.equals("Refund")) {
			tableName = "BlRefundHeader";
			prefix = "RF";
			seqNoName = "Refund No.";
		}

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", prefix)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				receiptSeqNo = ++seqNo;
				transactionSequenceObj
						.setTransactionSequenceNumber(receiptSeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			receiptSeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename(tableName);
			tsObj.setTransactionPrefix(prefix);
			tsObj.setTransactionSequenceName(seqNoName);
			tsObj.setTransactionSequenceNumber(receiptSeqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);
		}

		receiptNo = String.valueOf(receiptSeqNo);
		return receiptNo;
	}

	@SuppressWarnings( { "unchecked", "static-access" })
	public String getSeqNoForDisplay(String prefix) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String seqNo = "";
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", prefix))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				seqNo = String.valueOf(maxSeqNo + 1);
			} else {
				seqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return seqNo;
	}

	@SuppressWarnings("unchecked")
	public List<BlPatientLedger> getDepositOfPatient(int inpatientId) {
		List<BlPatientLedger> depositList = new ArrayList<BlPatientLedger>();
		Session session = (Session) getSession();
		try {
			depositList = session.createCriteria(BlPatientLedger.class)
					.createAlias("Inpatient", "ip").add(
							Restrictions.eq("ip.Id", inpatientId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return depositList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitDepositDetails(
			Map<String, Object> parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}

		try {
			int inpatientId = box.getInt(INPATIENT_ID);
			int hinId = box.getInt(HIN_ID);
			String adNo = box.getString(AD_NO);
			String receiptNo = generateSeqNo("Receipt");
			String receiptDate = box.getString(RECEIPT_DATE);
			String receiptTime = box.getString(RECEIPT_TIME);
			String totalAdvAmt = box.getString(TOTAL_AMOUNT);
			String remarks = box.getString(REMARKS);

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

			// --------------------------Saving Data into BlDepositHeader
			// Table---------------------------

			BlDepositHeader blDepositHeader = new BlDepositHeader();

			Patient patient = new Patient();
			patient.setId(hinId);
			blDepositHeader.setHin(patient);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			blDepositHeader.setInpatient(inpatient);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			blDepositHeader.setHospital(hospital);

			blDepositHeader.setPatientReceiptType("PD");
			blDepositHeader.setReceiptNo(receiptNo);
			if (!receiptDate.equals("")) {
				blDepositHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(receiptDate));

			}
			blDepositHeader.setReceiptTime(receiptTime);

			BigDecimal totalAdv = null;
			try {
				totalAdv = new BigDecimal(totalAdvAmt);
			} catch (Exception e) {
				totalAdv = new BigDecimal(0);
			}
			blDepositHeader.setTotalAdvanceAmt(totalAdv);
			blDepositHeader.setRemarks(remarks);
			blDepositHeader.setLastChgBy(userName);
			blDepositHeader.setLastChgDate(date);
			blDepositHeader.setLastChgTime(time);
			blDepositHeader.setStatus("y");

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(blDepositHeader);

			// --------------------------Saving Data into BlVoucherHeader
			// Table--------------------------

			BlVoucherHeader blVoucherHeader = new BlVoucherHeader();

			blVoucherHeader.setHospital(hospital);

			String voucherNo = "";
			voucherNo = getVoucherNo();
			blVoucherHeader.setVoucherNo(voucherNo);

			blVoucherHeader.setVoucherType("CR");
			blVoucherHeader.setNaration("Patient Deposit");
			blVoucherHeader.setVoucherDate(date);
			blVoucherHeader.setVoucherTime(time);
			blVoucherHeader.setDebitAmt(totalAdv);
			blVoucherHeader.setCreditAmt(totalAdv);
			blVoucherHeader.setLastChgBy(userName);
			blVoucherHeader.setLastChgDate(date);
			blVoucherHeader.setLastChgTime(time);
			blVoucherHeader.setStatus("y");

			hbt.save(blVoucherHeader);

			// --------------------------Saving Data into BlVoucherDetails Table
			// For credit---------------------------

			BlVoucherDetails blVoucherDetails = new BlVoucherDetails();
			blVoucherDetails.setVoucherHeader(blVoucherHeader);
			blVoucherDetails.setHospital(hospital);
			blVoucherDetails.setNaration("Patient Deposit");

			MasAccount masAccount = new MasAccount();
			masAccount.setId(1);
			blVoucherDetails.setAcc(masAccount);

			blVoucherDetails.setSucAccCode(adNo);
			blVoucherDetails.setHin(patient);
			blVoucherDetails.setAmount(totalAdv);
			blVoucherDetails.setReceiptType("Cr");
			blVoucherDetails.setPatientType("IP");
			blVoucherDetails.setLastChgBy(userName);
			blVoucherDetails.setLastChgDate(date);
			blVoucherDetails.setLastChgTime(time);
			blVoucherDetails.setStatus("y");

			hbt.save(blVoucherDetails);

			// --------------------------Saving Data into BlDepositHeader Table
			// for debit---------------------------

			BlVoucherDetails blVoucherDetailsObj = new BlVoucherDetails();
			blVoucherDetailsObj.setVoucherHeader(blVoucherHeader);
			blVoucherDetailsObj.setHospital(hospital);
			blVoucherDetailsObj.setNaration("Patient Deposit");
			blVoucherDetailsObj.setAcc(masAccount);
			blVoucherDetailsObj.setSucAccCode(adNo);
			blVoucherDetailsObj.setHin(patient);
			blVoucherDetailsObj.setAmount(totalAdv);
			blVoucherDetailsObj.setReceiptType("Dr");
			blVoucherDetailsObj.setPatientType("IP");
			blVoucherDetailsObj.setLastChgBy(userName);
			blVoucherDetailsObj.setLastChgDate(date);
			blVoucherDetailsObj.setLastChgTime(time);
			blVoucherDetailsObj.setStatus("y");

			hbt.save(blVoucherDetailsObj);

			// --------------------------Saving Data into BlPatientLedger
			// Table---------------------------

			List<BlPatientLedger> listfromPatientLedger = new ArrayList<BlPatientLedger>();
			listfromPatientLedger = session.createCriteria(
					BlPatientLedger.class).createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inpatientId)).list();
			if (listfromPatientLedger.size() > 0) {
				BlPatientLedger ledgerObj = new BlPatientLedger();
				for (BlPatientLedger blPatientLedger : listfromPatientLedger) {
					int patientLedgerId = blPatientLedger.getId();
					ledgerObj = (BlPatientLedger) hbt.load(
							BlPatientLedger.class, patientLedgerId);
					BigDecimal amt = null;
					BigDecimal newTotal = null;

					if (ledgerObj.getTotalAdvAmt() != null) {
						amt = ledgerObj.getTotalAdvAmt();
						newTotal = amt.add(totalAdv);
					} else {
						newTotal = totalAdv;
					}

					ledgerObj.setTotalAdvAmt(newTotal);
					ledgerObj.setLastChgBy(userName);
					ledgerObj.setLastChgDate(date);
					ledgerObj.setLastChgTime(time);
					ledgerObj.setStatus("y");
				}
				hbt.update(ledgerObj);

			} else {
				BlPatientLedger blPatientLedger = new BlPatientLedger();
				blPatientLedger.setHospital(hospital);
				blPatientLedger.setHin(patient);
				blPatientLedger.setInpatient(inpatient);
				blPatientLedger.setTotalAdvAmt(totalAdv);
				blPatientLedger.setLastChgBy(userName);
				blPatientLedger.setLastChgDate(date);
				blPatientLedger.setLastChgTime(time);
				blPatientLedger.setStatus("y");

				hbt.save(blPatientLedger);
			}

			// --------------------------Saving Data into BlDepositDetails
			// Table---------------------------

			Vector paymentMode = box.getVector(PAYMENT_MODE);
			Vector advAmt = box.getVector(ADVANCE_AMOUNT);
			Vector chequeNo = box.getVector(CHEQUE_NO);
			Vector chequeDate = box.getVector(CHEQUE_DATE);
			Vector bank = box.getVector(BANK_NAME);
			Vector receivedFrom = box.getVector(RECEIVED_FROM);
			BigDecimal advance = null;

			for (int i = 0; i < paymentMode.size(); i++) {
				BlDepositDetails blDepositDetails = new BlDepositDetails();
				if (paymentMode.get(i) != null
						&& !paymentMode.get(i).equals("")) {
					blDepositDetails.setDepositHeader(blDepositHeader);

					MasHospital hospitalObj = new MasHospital();
					hospitalObj.setId(hospitalId);
					blDepositDetails.setHospital(hospitalObj);
					blDepositDetails
							.setPaymentMode((String) paymentMode.get(i));
					if (advAmt.get(i) != null && !advAmt.get(i).equals("")) {
						try {
							advance = new BigDecimal((String) advAmt.get(i));
						} catch (Exception e) {
							advance = new BigDecimal(0);
						}
						blDepositDetails.setAdvanceAmount(advance);
					}
					if (chequeNo.get(i) != null && !chequeNo.get(i).equals("")) {
						blDepositDetails.setChequeNo((String) chequeNo.get(i));
					}
					if (chequeDate.get(i) != null
							&& !chequeDate.get(i).equals("")) {
						blDepositDetails
								.setChequeDate(HMSUtil
										.convertStringTypeDateToDateType((String) chequeDate
												.get(i)));
					}
					if (bank.get(i) != null && !bank.get(i).equals("")) {
						blDepositDetails.setBankName((String) bank.get(i));
					}
					if (receivedFrom.get(i) != null
							&& !receivedFrom.get(i).equals("")) {
						blDepositDetails.setReceivedFrom((String) receivedFrom
								.get(i));
					}
					blDepositDetails.setLastChgBy(userName);
					blDepositDetails.setLastChgDate(date);
					blDepositDetails.setLastChgTime(time);
					blDepositDetails.setStatus("y");
					hbt.save(blDepositDetails);

				}

			}
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	private String getVoucherNo() {
		String voucherNo = "";
		int voucherSeqNo = 0;
		List<TransactionSequence> voucherSeqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			voucherSeqNoList = session
					.createCriteria(TransactionSequence.class).add(
							Restrictions.eq("TransactionPrefix", "VR")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (voucherSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : voucherSeqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				voucherSeqNo = ++seqNo;
				transactionSequenceObj
						.setTransactionSequenceNumber(voucherSeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (voucherSeqNoList.size() == 0) {
			voucherSeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BlVoucherHeader");
			tsObj.setTransactionPrefix("VR");
			tsObj.setTransactionSequenceName("Voucher Seq. No.");
			tsObj.setTransactionSequenceNumber(voucherSeqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);
		}

		voucherNo = String.valueOf(voucherSeqNo);
		return voucherNo;
	}

	@SuppressWarnings("unchecked")
	public List<BlPatientLedger> getTotalAdvAndBillAmt(int inpatientId) {
		List<BlPatientLedger> patientLedgerList = new ArrayList<BlPatientLedger>();
		Session session = (Session) getSession();
		patientLedgerList = session.createCriteria(BlPatientLedger.class)
				.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.Id", inpatientId)).list();
		return patientLedgerList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitBillingFinalSettlementDetails(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		hospitalId = box.getInt("hospitalId");
		userName = box.getString("userName");

		try {
			int inpatientId = box.getInt(INPATIENT_ID);
			int hinId = box.getInt(HIN_ID);
			String adNo = box.getString(AD_NO);
			String transType = box.getString("transType");
			String seqNo = "";
			BigDecimal totalAmount = null;

			String transDate = box.getString(SETTLEMENT_DATE);
			String transTime = box.getString(SETTLEMENT_TIME);
			String totalAmt = box.getString(TOTAL_AMOUNT);
			String remarks = box.getString(REMARKS);

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

			Patient patient = new Patient();
			patient.setId(hinId);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String naration = "";
			String transactionType = "";

			// --------------------------Saving Data into BlDepositHeader
			// Table---------------------------

			if (transType.equals("Receipt")) {
				naration = "Patient Settlement";
				transactionType = "CR";
				seqNo = generateSeqNo("Receipt");

				BlDepositHeader blDepositHeader = new BlDepositHeader();
				blDepositHeader.setHin(patient);
				blDepositHeader.setInpatient(inpatient);
				blDepositHeader.setHospital(hospital);
				blDepositHeader.setPatientReceiptType("PS");
				blDepositHeader.setReceiptNo(seqNo);
				blDepositHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(transDate));
				blDepositHeader.setReceiptTime(transTime);

				try {
					totalAmount = new BigDecimal(totalAmt);
				} catch (Exception e) {
					totalAmount = new BigDecimal(0);
				}
				blDepositHeader.setTotalAdvanceAmt(totalAmount);
				blDepositHeader.setRemarks(remarks);
				blDepositHeader.setLastChgBy(userName);
				blDepositHeader.setLastChgDate(date);
				blDepositHeader.setLastChgTime(time);
				blDepositHeader.setStatus("y");

				hbt.save(blDepositHeader);

				Vector paymentMode = box.getVector(PAYMENT_MODE);
				Vector amountVec = box.getVector(AMOUNT);
				Vector chequeNo = box.getVector(CHEQUE_NO);
				Vector chequeDate = box.getVector(CHEQUE_DATE);
				Vector bank = box.getVector(BANK_NAME);
				Vector receivedFrom = box.getVector(RECEIVED_FROM);
				BigDecimal amount = null;

				for (int i = 0; i < paymentMode.size(); i++) {
					BlDepositDetails blDepositDetails = new BlDepositDetails();
					if (paymentMode.get(i) != null
							&& !paymentMode.get(i).equals("")) {
						blDepositDetails.setDepositHeader(blDepositHeader);

						MasHospital hospitalObj = new MasHospital();
						hospitalObj.setId(hospitalId);
						blDepositDetails.setHospital(hospitalObj);
						blDepositDetails.setPaymentMode((String) paymentMode
								.get(i));
						if (amountVec.get(i) != null
								&& !amountVec.get(i).equals("")) {
							try {
								amount = new BigDecimal((String) amountVec
										.get(i));
							} catch (Exception e) {
								amount = new BigDecimal(0);
							}
							blDepositDetails.setAdvanceAmount(amount);
						}
						if (chequeNo.get(i) != null
								&& !chequeNo.get(i).equals("")) {
							blDepositDetails.setChequeNo((String) chequeNo
									.get(i));
						}
						if (chequeDate.get(i) != null
								&& !chequeDate.get(i).equals("")) {
							blDepositDetails
									.setChequeDate(HMSUtil
											.convertStringTypeDateToDateType((String) chequeDate
													.get(i)));
						}
						if (bank.get(i) != null && !bank.get(i).equals("")) {
							blDepositDetails.setBankName((String) bank.get(i));
						}
						if (receivedFrom.get(i) != null
								&& !receivedFrom.get(i).equals("")) {
							blDepositDetails
									.setReceivedFrom((String) receivedFrom
											.get(i));
						}
						blDepositDetails.setLastChgBy(userName);
						blDepositDetails.setLastChgDate(date);
						blDepositDetails.setLastChgTime(time);
						blDepositDetails.setStatus("y");
						hbt.save(blDepositDetails);

					}

				}
			} else if (transType.equals("Refund")) {
				naration = "Patient Refund";
				transactionType = "RF";
				seqNo = generateSeqNo("Refund");

				BlRefundHeader blRefundHeader = new BlRefundHeader();
				blRefundHeader.setHin(patient);
				blRefundHeader.setInpatient(inpatient);
				blRefundHeader.setHospital(hospital);
				blRefundHeader.setRefundNo(seqNo);
				blRefundHeader.setRefundDate(HMSUtil
						.convertStringTypeDateToDateType(transDate));
				blRefundHeader.setRefundTime(transTime);

				try {
					totalAmount = new BigDecimal(totalAmt);
				} catch (Exception e) {
					totalAmount = new BigDecimal(0);
				}
				blRefundHeader.setTotalRefundAmt(totalAmount);
				blRefundHeader.setRemarks(remarks);
				blRefundHeader.setLastChgBy(userName);
				blRefundHeader.setLastChgDate(date);
				blRefundHeader.setLastChgTime(time);
				blRefundHeader.setStatus("y");

				hbt.save(blRefundHeader);

				Vector paymentMode = box.getVector(PAYMENT_MODE);
				Vector refundAmt = box.getVector(AMOUNT);
				Vector chequeNo = box.getVector(CHEQUE_NO);
				Vector chequeDate = box.getVector(CHEQUE_DATE);
				Vector bank = box.getVector(BANK_NAME);
				Vector receivedFrom = box.getVector(RECEIVED_FROM);
				BigDecimal refund = null;

			/*	for (int i = 0; i < paymentMode.size(); i++) {
					BlRefundDetails blRefundDetails = new BlRefundDetails();
					if (paymentMode.get(i) != null
							&& !paymentMode.get(i).equals("")) {
						blRefundDetails.setRefundHeader(blRefundHeader);

						MasHospital hospitalObj = new MasHospital();
						hospitalObj.setId(hospitalId);
						blRefundDetails.setHospitalId(hospitalObj);
						blRefundDetails.setPaymentMode((String) paymentMode
								.get(i));
						if (refundAmt.get(i) != null
								&& !refundAmt.get(i).equals("")) {
							try {
								refund = new BigDecimal((String) refundAmt
										.get(i));
							} catch (Exception e) {
								refund = new BigDecimal(0);
							}
							blRefundDetails.setRefundAmount(refund);
						}
						if (chequeNo.get(i) != null
								&& !chequeNo.get(i).equals("")) {
							blRefundDetails.setChequeNo((String) chequeNo
									.get(i));
						}
						if (chequeDate.get(i) != null
								&& !chequeDate.get(i).equals("")) {
							blRefundDetails
									.setChequeDate(HMSUtil
											.convertStringTypeDateToDateType((String) chequeDate
													.get(i)));
						}
						if (bank.get(i) != null && !bank.get(i).equals("")) {
							blRefundDetails.setBankName((String) bank.get(i));
						}
						if (receivedFrom.get(i) != null
								&& !receivedFrom.get(i).equals("")) {
							blRefundDetails.setRefundTo((String) receivedFrom
									.get(i));
						}
						blRefundDetails.setLastChgBy(userName);
						blRefundDetails.setLastChgDate(date);
						blRefundDetails.setLastChgTime(time);
						blRefundDetails.setStatus("y");
						hbt.save(blRefundDetails);

					}

				}*/

			}

			// --------------------------Saving Data into BlVoucherHeader
			// Table--------------------------

			BlVoucherHeader blVoucherHeader = new BlVoucherHeader();

			blVoucherHeader.setHospital(hospital);

			String voucherNo = "";
			voucherNo = getVoucherNo();
			blVoucherHeader.setVoucherNo(voucherNo);

			blVoucherHeader.setVoucherType(transactionType);
			blVoucherHeader.setNaration(naration);
			blVoucherHeader.setVoucherDate(date);
			blVoucherHeader.setVoucherTime(time);
			blVoucherHeader.setDebitAmt(totalAmount);
			blVoucherHeader.setCreditAmt(totalAmount);
			blVoucherHeader.setLastChgBy(userName);
			blVoucherHeader.setLastChgDate(date);
			blVoucherHeader.setLastChgTime(time);
			blVoucherHeader.setStatus("y");

			hbt.save(blVoucherHeader);

			// --------------------------Saving Data into BlVoucherDetails Table
			// For credit---------------------------

			BlVoucherDetails blVoucherDetails = new BlVoucherDetails();
			blVoucherDetails.setVoucherHeader(blVoucherHeader);
			blVoucherDetails.setHospital(hospital);
			blVoucherDetails.setNaration(naration);

			MasAccount masAccount = new MasAccount();
			masAccount.setId(1);
			blVoucherDetails.setAcc(masAccount);

			blVoucherDetails.setSucAccCode(adNo);
			blVoucherDetails.setHin(patient);
			blVoucherDetails.setAmount(totalAmount);
			blVoucherDetails.setReceiptType("Cr");
			blVoucherDetails.setPatientType("IP");
			blVoucherDetails.setLastChgBy(userName);
			blVoucherDetails.setLastChgDate(date);
			blVoucherDetails.setLastChgTime(time);
			blVoucherDetails.setStatus("y");

			hbt.save(blVoucherDetails);

			// --------------------------Saving Data into BlVoucherDetails Table
			// for debit---------------------------

			BlVoucherDetails blVoucherDetailsObj = new BlVoucherDetails();
			blVoucherDetailsObj.setVoucherHeader(blVoucherHeader);
			blVoucherDetailsObj.setHospital(hospital);
			blVoucherDetailsObj.setNaration(naration);
			blVoucherDetailsObj.setAcc(masAccount);
			blVoucherDetailsObj.setSucAccCode(adNo);
			blVoucherDetailsObj.setHin(patient);
			blVoucherDetailsObj.setAmount(totalAmount);
			blVoucherDetailsObj.setReceiptType("Dr");
			blVoucherDetailsObj.setPatientType("IP");
			blVoucherDetailsObj.setLastChgBy(userName);
			blVoucherDetailsObj.setLastChgDate(date);
			blVoucherDetailsObj.setLastChgTime(time);
			blVoucherDetailsObj.setStatus("y");

			hbt.save(blVoucherDetailsObj);

			// --------------------------Saving Data into BlPatientLedger
			// Table---------------------------

			BigDecimal chargeSlipAmt = null;
			try {
				chargeSlipAmt = new BigDecimal(box
						.getString(CHARGE_SLIP_AMOUNT));
			} catch (Exception e) {
				chargeSlipAmt = new BigDecimal(0);
			}

			List<BlPatientLedger> listfromPatientLedger = new ArrayList<BlPatientLedger>();
			listfromPatientLedger = session.createCriteria(
					BlPatientLedger.class).createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inpatientId)).list();
			if (listfromPatientLedger.size() > 0) {
				BlPatientLedger ledgerObj = new BlPatientLedger();
				for (BlPatientLedger blPatientLedger : listfromPatientLedger) {
					int patientLedgerId = blPatientLedger.getId();
					ledgerObj = (BlPatientLedger) hbt.load(
							BlPatientLedger.class, patientLedgerId);
					BigDecimal amt = null;
					BigDecimal newTotal = null;

					if (transType.equals("Refund")) {
						if (ledgerObj.getTotalRefundAmt() != null) {
							amt = ledgerObj.getTotalRefundAmt();
							newTotal = amt.add(totalAmount);
						} else {
							newTotal = totalAmount;
						}

						ledgerObj.setTotalRefundAmt(newTotal);

					} else if (transType.equals("Receipt")) {
						ledgerObj.setTotalFinalBillAmt(totalAmount);
					}
					ledgerObj.setLastChgBy(userName);
					ledgerObj.setLastChgDate(date);
					ledgerObj.setLastChgTime(time);
					ledgerObj.setStatus("y");
				}
				hbt.update(ledgerObj);

			} else {
				BlPatientLedger blPatientLedger = new BlPatientLedger();
				blPatientLedger.setHospital(hospital);
				blPatientLedger.setHin(patient);
				blPatientLedger.setInpatient(inpatient);

				if (transType.equals("Refund")) {
					blPatientLedger.setTotalRefundAmt(totalAmount);
				} else if (transType.equals("Receipt")) {
					blPatientLedger.setTotalFinalBillAmt(chargeSlipAmt);
				}
				blPatientLedger.setLastChgBy(userName);
				blPatientLedger.setLastChgDate(date);
				blPatientLedger.setLastChgTime(time);
				blPatientLedger.setStatus("y");

				hbt.save(blPatientLedger);
			}

			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> getPendingListOfPatient(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String uhid = box.getString("hin_id");
		String patientName = box.getString("pName");
		String mobile = box.getString("mobile");
		int hospitalId = box.getInt("hospitalId");
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		Criteria crit = null;
		Calendar calender=Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -2);	
		crit = session.createCriteria(DgOrderdt.class, "orderdt")
				.createAlias("orderdt.Orderhd", "orderhd")
				.createAlias("orderhd.Hospital", "hospital")
				.createAlias("orderhd.Visit", "visit") // added by amit das on 27-06-2016
				.createAlias("orderhd.Visit.OpdPatientDetails", "opdPatientDetails",CriteriaSpecification.LEFT_JOIN) // added by amit das on 27-06-2016
				.createAlias("orderhd.Hin", "h")
				//.add(Restrictions.in("ChargeCode", masChargeCodes))
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.ge("orderhd.OrderDate", calender.getTime()))
				.add(Restrictions.isNotNull("orderhd.Visit"))
				.add(Restrictions.eq("orderdt.BillingStatus", "n").ignoreCase());

		if (!uhid.equals("")) {
			crit = crit.add(Restrictions.eq("h.HinNo", uhid));
		}
		if (!patientName.equals("")) {
			crit = crit.add(Restrictions.like("h.PFirstName",
					"%" + patientName.toLowerCase() + "%").ignoreCase()); 
		}
		if (!mobile.equals("")) {
			crit = crit.add(Restrictions.eq("h.MobileNumber", mobile));
		}
		if(uhid.equals("") || patientName.equals("")||mobile.equals("") )
		{
		crit.setProjection(Projections.projectionList().add(
				Projections.groupProperty("orderdt.Orderhd")));}
		dgOrderhdList = crit.list();
		map.put("dgOrderhdList", dgOrderhdList);
		return map;

	}

	@Override
	public Map<String, Object> getPatientDetailsForOpBilling(
			Map<String, Object> parameterMap) {


		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Object[]> masPTypeList = new ArrayList<Object[]>();
		List<Object[]> masPTypeLists = new ArrayList<Object[]>();
		List<Object[]> masPTypeListo = new ArrayList<Object[]>();
		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
		List<Object[]> mainChargeCodeList = new ArrayList<Object[]>();
		List<Object[]> subChargeCodeList = new ArrayList<Object[]>();
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		List<Object[]> authorizerList = new ArrayList<Object[]>();
		List<Object[]> bankList = new ArrayList<Object[]>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
	
		List<Patient> inpatientList = new ArrayList<Patient>();
		List<Integer> maxVisitList = new ArrayList<Integer>();
		List<Visit> lastVisitDetails = new ArrayList<Visit>();
		
		List<Object[]> masCharityList = new ArrayList<Object[]>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	//	List<PatientBalance> patientBalances = new ArrayList<PatientBalance>();
		List<BlOpBillHeader> opBillHeaders = new ArrayList<BlOpBillHeader>(); // Added by Amit Das on 03-02-2016
		
		Session session = getSession();
		int hospitalId=(Integer)parameterMap.get("hospitalId");
		String maxBlNo = "";

		String orderNo = "";
		String hinNo = "";
		String tempBillNo = "";
		int orderId = 0;
		if (parameterMap.get("hinNo") != null) {
			hinNo = (String) parameterMap.get("hinNo");
		}
		if (parameterMap.get("orderNo") != null) {
			orderNo = (String) parameterMap.get("orderNo");
		}
		if (parameterMap.get("tempBillNo") != null) {
			tempBillNo = (String) parameterMap.get("tempBillNo");
		}
		if (parameterMap.get("orderId") != null) {
			orderId = (Integer) parameterMap.get("orderId");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			if (!hinNo.equals("")) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo))
						.add(Restrictions.eq("PatientStatus", "Out Patient"))
						.list();

				maxVisitList = session.createCriteria(Visit.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.HinNo", hinNo))
						.setProjection(Projections.max("Id")).list();
				

				if (maxVisitList.size() > 0) {
					lastVisitDetails = session.createCriteria(Visit.class)
							.add(Restrictions.idEq(maxVisitList.get(0))).list();
					
					if (lastVisitDetails.size() > 0) 
						map.put("lastVisitDetails", lastVisitDetails);
					
				}
			}
			
			if (orderId != 0) {
				orderHdList = session
						.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("Id", orderId))
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.PatientStatus", "Out Patient")
								.ignoreCase())
								.list();
				
				

			if (orderHdList.size() > 0) {
					
					DgOrderhd orderHd = new DgOrderhd();
					orderHd = orderHdList.get(0);
					//Hibernate.initialize(orderHd.getDgOrderdts());
					Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
					patientList.add(orderHd.getHin());
					orderDtSet = orderHd.getDgOrderdts();
					
					for (DgOrderdt orderDt : orderDtSet) {
						if (orderDt.getBillingStatus().equals("n")) {
							// if
							// (orderDt.getChargeCode().getChargeType().getChargeTypeCode().equals("DIAG")
							// && ) {
							int chargeCodeId=orderDt.getChargeCode().getId();
							orderdtList.add(orderDt);	
					
							}
							
							map.put("orderHdList", orderHdList);
							map.put("orderdtList", orderdtList);
						}
					}
				}
			
		
			if (patientList.size() > 0) {
				map.put("patientList", patientList);
			} else {
				inpatientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo))
						.add(Restrictions.eq("PatientStatus", "In Patient"))
						.list();
				if (inpatientList.size() > 0) {
					map.put("inpatientList", inpatientList);
				}
			}
			
		
		
			if(opBillHeaders.size()!=0){
				map.put("patientOpBillHeader", opBillHeaders.get(0));
			}
			
			
			
					
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).setProjection(Projections.projectionList().add(Projections.property("MainChargecodeName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).setProjection(Projections.projectionList().add(Projections.property("MainChargecode")).add(Projections.property("SubChargecodeName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			// chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			authorizerList = session.createCriteria(MasAuthorizer.class).setProjection(Projections.projectionList().add(Projections.property("AuthorizerName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list(); // chagned by Amit Das on 21-03-2016
			
			bankList = session.createCriteria(MasBankMaster.class).setProjection(Projections.projectionList().add(Projections.property("BankName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			employeeList = session.createCriteria(MasEmployee.class).setProjection(Projections.projectionList().add(Projections.property("EmpCategory")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			// templateList = session.createCriteria(OpdTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("TemplateType", "I")).list();
			
			//patientBalances=session.createCriteria(PatientBalance.class).list();

			String billType = "OS";
		//	maxBlNo = generateBillNo(billType, "display",hospitalId);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	//	map.put("patientBalances", patientBalances);
		map.put("masCharityList", masCharityList);
		map.put("masPTypeListo", masPTypeListo);
		map.put("masPTypeLists", masPTypeLists);
		map.put("masPTypeList", masPTypeList);
		//map.put("discountList", discountList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		//map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("bankList", bankList);
		map.put("sexList", sexList);
		map.put("employeeList", employeeList);
		map.put("maxBlNo", maxBlNo);
		// map.put("templateList", templateList);
		return map;
	
		}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId,int schemeId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Box box = new Box("box");
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();

		try {
			
			/*chargeCodeRates = session.createCriteria(MasChargeCodeRates.class)
					.createAlias("ChargeCode", "charge")
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("charge.ChargeCodeCode", chargeCode))
				.list();
		     if(chargeCodeRates.size()>0)
		     {*/
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeCode", chargeCode)).list();
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode = chargeCodeList.get(0);
			int chargeId = masChargeCode.getId();
			int mainChargeId = masChargeCode.getMainChargecode().getId();
			int subChargeId = masChargeCode.getSubChargecode().getId();

			if (hinId != 0) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
			}
			if (patientList.size() > 0) {
				Patient patient = (Patient) patientList.get(0);
				int patientTypeId = 0;
				int companyId = 0;
				String regType = "";
				if (patientList.get(0).getPatientType() != null) {
					patientTypeId = patient.getPatientType().getId();
					detailsMap.put("patientTypeId", patientTypeId);
				}
				/*if (patientList.get(0).getCompany() != null) {
					companyId = patient.getCompany().getId();
					detailsMap.put("companyId", companyId);
				}*/
				/*if (patient.getRegistrationType() != null) {
					regType = patient.getRegistrationType();
					detailsMap.put("regType", regType);
				}*/

				if (patient.getPatientStatus().equals("Out Patient")) {
					detailsMap.put("patientCategory", "OP");
				}
				if (patient.getPatientStatus().equals("In Patient")) {
					detailsMap.put("patientCategory", "IP");
				}

				List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				inpatientList = session
						.createCriteria(Inpatient.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.or(Restrictions.eq("AdStatus", "R"),
								Restrictions.eq("AdStatus", "A"))).list();

				if (inpatientList.size() > 0) {
					Inpatient inpatient = inpatientList.get(0);
					// box.put(INPATIENT_ID, inpatient.getId());
					detailsMap.put(INPATIENT_ID, inpatient.getId());
					detailsMap.put("roomTypeId", inpatient.getBed().getRoom()
							.getRoomType().getId());
				}
			}
			detailsMap.put("chargeId", chargeId);
			detailsMap.put("mainChargeId", mainChargeId);
			detailsMap.put("subChargeId", subChargeId);
			detailsMap.put("billTypeId", 2);
			detailsMap.put("schemeId", schemeId); // added by amit das on 26-05-2016
			detailsMap.put(HIN_ID, hinId);
			// box.put(HIN_ID, hinId);
			detailsMap.put(RequestConstants.CHARGE_ID, chargeId);
			// box.put(RequestConstants.CHARGE_ID, RequestConstants.CHARGE_ID);

			// detailsMap.put("discountList",
			// billingMasterDataService.serviceDispensingAutoBilling(box));
			detailsMap.put("chargeCode", masChargeCode);
		
			detailsMap.put(HOSPITAL_ID, hospitalId);
			/*if(schemeId!=0)
			{
				detailsMap.put("schemeId", schemeId);
			}*/
		
			map.put("chargeCodeList", chargeCodeList);
		    /* }*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> submitvisit(Visit v) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(v);
		successfullyAdded = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@Override
	public String getage(String hinNo) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		Session session = getSession();
		String age = "";
		visitNoList = session.createCriteria(Visit.class)
				.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
		map.put("visitNoList", visitNoList);
		for (Visit v : visitNoList) {
			age = v.getHin().getAge();
		}
		// visitNo++;
		return age;
	
	}

	@Override
	public int getVisitNo(String hinNo) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		Session session = getSession();
		int visitNo = 0;
		visitNoList = session.createCriteria(Visit.class)
				.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
		map.put("visitNoList", visitNoList);
		for (Visit v : visitNoList) {
			/* visitNo = v.getVisitNo(); */
		}
		visitNo++;
		return visitNo;
	
	}

	@Override
	public Map<String, Object> submitBillServicingDetails(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		BlOpBillHeader opBillHeader = new BlOpBillHeader();
		String userName = "";
		boolean saved = false;
		boolean flag = false;
		int userId = 0;

		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List standardDeductionList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List disPercentList = new ArrayList();
		List proportionalDiscountList = new ArrayList();
		List netAmountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();

		List payModeList = new ArrayList();
		List amtReceivedList = new ArrayList();
		List chqNoList = new ArrayList();
		List chqDateList = new ArrayList();
		List bankNameList = new ArrayList();
		int visitIdNew = 0;
		int deptIdNew11 = 0;
		if (dataMap.get("visitIdNew") != null) {
			visitIdNew = (Integer) dataMap.get("visitIdNew");
		}
		if (dataMap.get("deptIdNew11") != null) {
			deptIdNew11 = (Integer) dataMap.get("deptIdNew11");
		}
		
		if (dataMap.get("opBillHeader") != null) {
			opBillHeader = (BlOpBillHeader) dataMap.get("opBillHeader");
		}
		if (dataMap.get("qtyList") != null) {
			qtyList = (List) dataMap.get("qtyList");
		}
		if (dataMap.get("rateList") != null) {
			rateList = (List) dataMap.get("rateList");
		}
		if (dataMap.get("standardDeductionList") != null) {
			standardDeductionList = (List) dataMap.get("standardDeductionList");
		}
		if (dataMap.get("amountList") != null) {
			amountList = (List) dataMap.get("amountList");
		}
		if (dataMap.get("disPercentList") != null) {
			disPercentList = (List) dataMap.get("disPercentList");
		}
		if (dataMap.get("discountList") != null) {
			discountList = (List) dataMap.get("discountList");
		}
		if (dataMap.get("netAmountList") != null) {
			netAmountList = (List) dataMap.get("netAmountList");
		}
		if (dataMap.get("mainChargeList") != null) {
			mainChargeList = (List) dataMap.get("mainChargeList");
		}
		if (dataMap.get("subChargeList") != null) {
			subChargeList = (List) dataMap.get("subChargeList");
		}
		if (dataMap.get("amtReceivedList") != null) {
			amtReceivedList = (List) dataMap.get("amtReceivedList");
		}
		if (dataMap.get("chqNoList") != null) {
			chqNoList = (List) dataMap.get("chqNoList");
		}
		if (dataMap.get("chqDateList") != null) {
			chqDateList = (List) dataMap.get("chqDateList");
		}
		if (dataMap.get("bankNameList") != null) {
			bankNameList = (List) dataMap.get("bankNameList");
		}

		if (dataMap.get("proportionalDiscountList") != null) {
			proportionalDiscountList = (List) dataMap
					.get("proportionalDiscountList");
		}
		if (dataMap.get("orderDetailIdList") != null) {
			orderDetailIdList = (List) dataMap.get("orderDetailIdList");
		}

		if (dataMap.get("deptCodeList") != null) {
			deptCodeList = (List) dataMap.get("deptCodeList");
		}
		if (dataMap.get("deptIdList") != null) {
			deptIdList = (List) dataMap.get("deptIdList");
		}
		int hinId = 0;
		int hospitalId = 0;
		BigDecimal advAdj = new BigDecimal(0);
		BigDecimal outstanding = new BigDecimal(0);
		BigDecimal avAdvAmtId = new BigDecimal(0);
		BigDecimal remainCId = new BigDecimal(0);
		
		
		if (dataMap.get("hinId") != null) {
			hinId = (Integer) dataMap.get("hinId");
		}
		if (dataMap.get("advAdj") != null) {
			advAdj = new BigDecimal((String) dataMap.get("advAdj"));
		}
		if (dataMap.get("outstanding") != null) {
			outstanding = new BigDecimal((String) dataMap.get("outstanding"));
		}
		
		if (dataMap.get("avAdvAmtId") != null) {
			avAdvAmtId = new BigDecimal((String) dataMap.get("avAdvAmtId"));
		}
		
		if (dataMap.get("remainCId") != null) {
			remainCId = new BigDecimal((String) dataMap.get("remainCId"));
		}
		if (dataMap.get("userName") != null) {
			userName = (String) dataMap.get("userName");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		if (dataMap.get("userId") != null) {
			userId = (Integer) dataMap.get("userId");
		}
		String registrationType = "";
		if (dataMap.get("registrationType") != null) {
			registrationType = (String) dataMap.get("registrationType");
		}
		Users user = new Users();
		user.setId(userId);

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		Transaction tx = null;
		Session session = getSession();
		try {
			tx =  session.beginTransaction();
			// ------------------Saving Data into bl_op_bill_header
			// table-------------------------

			String billNo = "";
			String billType = "OS";
			billNo = generateBillNo(billType, "save",hospitalId);
			opBillHeader.setBillNo(billNo);

			
			
				if (dataMap.get("payModeList") != null) {
					payModeList = (List) dataMap.get("payModeList");
				if (payModeList.size() > 0) {
					for (int i = 0; i < payModeList.size(); i++) {
						if (amtReceivedList.get(i) != null
								&& !(amtReceivedList.get(i).toString()).equals("")) {
							BigDecimal amtReceived = new BigDecimal(
									amtReceivedList.get(i)
											.toString());
											
						opBillHeader.setNetAmt(amtReceived);
						opBillHeader.setBillAmt(amtReceived);
						
					}
					}
					
				}
			}
			
			hbt.save(opBillHeader);

			map.put("billNo", billNo);

			// ------------------Saving Data into bl_op_bill_detail
			// table-------------------------

			if (dataMap.get("chargeList") != null) {
				chargeList = (List) dataMap.get("chargeList");
				if (chargeList.size()>0) {
					for (int i = 0; i < chargeList.size(); i++) {
				
						BlOpBillDetails opBillDetail = new BlOpBillDetails();
						MasChargeCode masChargeCode = new MasChargeCode();
						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {
							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							opBillDetail.setChargeCode(masChargeCode);

							if (rateList.get(i) != null
									&& !(rateList.get(i).toString()).equals("")) {
								BigDecimal rate = new BigDecimal(rateList
										.get(i).toString());
								opBillDetail.setRate(rate);
								opBillDetail.setAmount(rate);
							}
						
							if (amountList.get(i) != null
									&& !(amountList.get(i).toString())
											.equals("")) {
								BigDecimal amount = new BigDecimal(amountList
										.get(i).toString());
								
								opBillDetail.setAmount(amount);
								
															}
											
							if (qtyList.get(i) != null
									&& !(qtyList.get(i).toString()).equals("")) {
								int qty = Integer.parseInt(qtyList.get(i)
										.toString());
								opBillDetail.setQuantity(qty);
							}
							opBillDetail.setBillDate(changeDate);
							opBillDetail.setBillTime(time);
							opBillDetail.setChangedBy(user);
							opBillDetail.setOpBillHeader(opBillHeader);
							
							opBillDetail.setRefundableStatus("y");
							try {
								hbt.save(opBillDetail);
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}
					}
				}
				// ------------------Saving Data into bl_receipt_header
				// table-------------------------
			//	System.out.println("Data >>>>>>>>flag >>>>>>>> "+dataMap.get("flag"));
				//if(dataMap.get("flag").equals("P")){
				BlReceiptHeader receiptHeader = new BlReceiptHeader();

				if (dataMap.get("receiptHeader") != null) {
					receiptHeader = (BlReceiptHeader) dataMap
							.get("receiptHeader");
					String receiptNo = "";
					receiptNo = generateReceiptNo("save",hospitalId);
					receiptHeader.setReceiptNo(receiptNo);		
					
					receiptHeader.setOpBillHeader(opBillHeader); 
					try {
						hbt.save(receiptHeader);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					// ------------------Saving Data into bl_receipt_detail
					// table-------------------------

					if (dataMap.get("payModeList") != null) {
						payModeList = (List) dataMap.get("payModeList");
						if (payModeList.size() > 0) {
							for (int i = 0; i < payModeList.size(); i++) {
								BlReceiptDetails receiptDetails = new BlReceiptDetails();
								if (payModeList.get(i) != null) {
									receiptDetails.setPaymentMode(payModeList
											.get(i).toString());
									if (!(amtReceivedList.get(i).equals(""))) {
										BigDecimal amtReceived = new BigDecimal(
												amtReceivedList.get(i)
														.toString());
										receiptDetails.setAmount(amtReceived);
									}
									if (chqNoList.get(i) != null
											&& !(chqNoList.get(i).toString()
													.equals(""))) {
										receiptDetails.setChequeNo(chqNoList
												.get(i).toString());
									}
									if (chqDateList.size() > 0
											&& !(chqDateList.get(i).toString()
													.equals(""))) {
										receiptDetails
												.setChequeDate(HMSUtil
														.convertStringTypeDateToDateType(chqDateList
																.get(i)
																.toString()));
									}

									if (bankNameList.get(i) != null
											&& !(bankNameList.get(i).toString()
													.equals(""))) {
										MasBankMaster bankMaster = new MasBankMaster();
										bankMaster.setId(Integer
												.parseInt(bankNameList.get(i)
														.toString()));
										receiptDetails.setBank(bankMaster);
									}
									receiptDetails.setReceiptDate(changeDate);
									receiptDetails.setReceiptTime(time);
									receiptDetails.setChangedBy(user);
									receiptDetails
											.setReceiptHeader(receiptHeader);
									try {
										hbt.save(receiptDetails);
									} catch (DataAccessException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			
			flag = true;
			// ------------------Update past due in patient
			// table-------------------------

			if (flag) {
				BigDecimal pastDueBD = new BigDecimal(0);
				if (hinId != 0) {
					Patient patient = (Patient) hbt.load(Patient.class, hinId);
//					String pastDue = "";
//					if (patient.getPastDue() != null)
//						pastDue = patient.getPastDue();

//					String sign = "";
//					if (pastDue != null && !pastDue.equals("")
//							&& !pastDue.equals("0")) {
//						sign = pastDue.substring(0, 1);
//						pastDueBD = new BigDecimal(pastDue);
//						if (sign.equals("-")) {
//							if (!advAdj.equals(0)) {
//								pastDueBD = pastDueBD.add(advAdj);
//							}
//							if (!outstanding.equals(0)) {
//								pastDueBD = pastDueBD.subtract(outstanding);
//							}
//						} else {
//							if (!outstanding.equals(0)) {
//								pastDueBD = pastDueBD.add(outstanding);
//							}
//						}
//					} else {
//						if (!outstanding.equals(0)) {
//							pastDueBD = pastDueBD.add(outstanding);
//						}
//						if (!avAdvAmtId.equals(0)) {
//							pastDueBD = pastDueBD.add(avAdvAmtId);
//						}
//						if (!remainCId.equals(0)) {
//							pastDueBD = pastDueBD.add(remainCId);
//						}
//					}
						pastDueBD = pastDueBD.add(avAdvAmtId);					
						if (!remainCId.equals(0)) {
							pastDueBD = pastDueBD.add(remainCId);
						}					
									hbt.update(patient);
				}}
				// ------------------Saving Data into dg_orderhd
				// table-------------------------

				boolean diag = false;
				System.out.println("deptCodeid"+deptCodeList.size());
				for (int i = 0; i < deptCodeList.size(); i++) {
					if (deptCodeList.get(i).equals("RADIO")
							|| deptCodeList.get(i).equals("DIAG")
							|| deptCodeList.get(i).equals("PHYO") || deptCodeList.get(i).equals("LAB")) {
						diag = true;
						break;
					}
				}
				DgOrderhd orderhd = new DgOrderhd();
				if (diag == true) {
					int orderId = 0;
					try {
						if (dataMap.get("orderNo") != null) {
							orderhd = (DgOrderhd) dataMap.get("orderNo");
							orderhd.setBillingStatus("y");

					//	orderhd.setBillChargeSlpNo(billNo);
							hbt.update(orderhd);
						} else if (dataMap.get("orderId") != null) {
							orderId = (Integer) dataMap.get("orderId");
							DgOrderhd dgOrderHd = (DgOrderhd) hbt.load(
									DgOrderhd.class, orderId);
							dgOrderHd.setBillingStatus("y");
							//dgOrderHd.setBillChargeSlpNo(billNo);
							
							hbt.update(dgOrderHd);
							orderhd.setId(orderId);
						}

					} catch (RuntimeException e1) {
						e1.printStackTrace();
					}

					// ------------------Save or Update Data into dg_orderdt
					// table-------------------------

					if (dataMap.get("chargeList") != null) {
						chargeList = (List) dataMap.get("chargeList");
					}

					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
					if (chargeList.size() > 0) {
						for (int l = 0; l < chargeList.size(); l++) {
							if (!chargeList.get(l).equals("")
									&& orderDetailIdList.get(l).toString()
											.equals("")) {
								if (deptCodeList.get(l).toString()
										.equals("RADIO")) {
									if (hinId != 0) {
										Patient patient = new Patient();
										patient.setId(hinId);
										collHeader.setHin(patient);
									}
									MasDepartment department = new MasDepartment();
									department.setId(Integer
											.parseInt(deptIdList.get(l)
													.toString()));
									collHeader.setDepartment(department);
									collHeader.setHospital(hospital);
									collHeader.setOrder(orderhd);
									collHeader.setDiagnosisDate(changeDate);
									collHeader.setDiagnosisTime(time);
									collHeader.setOrderStatus("P");
									collHeader
											.setSampleValidationDate(changeDate);
									collHeader.setSampleValidationTime(time);
									Users user1 = new Users();
									user1.setId(userId);
									collHeader.setLastChangeBy(user1);
									collHeader.setLastChgDate(changeDate);
									collHeader.setLastChgTime(time);

									hbt.save(collHeader);
									break;
								}
							}
						}
					}
					System.out.println("charge"+chargeList.size());
				
					if (chargeList.size() > 0) {
						for (int i = 0; i < chargeList.size(); i++) {
							System.out.println("dept"+deptCodeList.get(i));
							if (deptCodeList.get(i).equals("RADIO")
									|| deptCodeList.get(i).equals("DIAG")
									|| deptCodeList.get(i).equals("PHYO") || deptCodeList.get(i).equals("LAB")) {

								if (!chargeList.get(i).equals("")
										&& orderDetailIdList.get(i).toString()
												.equals("")) {
									DgOrderdt orderdt = new DgOrderdt();
									orderdt.setOrderhd(orderhd);
									MasChargeCode masChargeCode = new MasChargeCode();
									if (chargeList.get(i) != null
											&& !(chargeList.get(i).toString())
													.equals("")) {
										int chargeId = Integer
												.parseInt(chargeList.get(i)
														.toString());
										masChargeCode.setId(chargeId);
										orderdt.setChargeCode(masChargeCode);

										if (qtyList.get(i) != null
												&& !(qtyList.get(i).toString())
														.equals("")) {
											int qty = Integer.parseInt(qtyList
													.get(i).toString());
											orderdt.setOrderQty(qty);
										}
										if (netAmountList.get(i) != null
												&& !(netAmountList.get(i)
														.toString()).equals("")) {
											BigDecimal netAmount = new BigDecimal(
													netAmountList.get(i)
															.toString());
											//orderdt.setAmount(netAmount);
										}
										if (!mainChargeList.get(i).toString()
												.equals("")) {
											int mainChargeId = Integer
													.parseInt(mainChargeList
															.get(i).toString());
											MasMainChargecode mainChargecode = new MasMainChargecode();
											mainChargecode.setId(mainChargeId);
											orderdt.setMainChargecode(mainChargecode);
										}
										if (!subChargeList.get(i).toString()
												.equals("")) {
											int subChargeId = Integer
													.parseInt(subChargeList
															.get(i).toString());
											MasSubChargecode subChargecode = new MasSubChargecode();
											subChargecode.setId(subChargeId);
											orderdt.setSubChargeid(subChargecode);
										}
										orderdt.setBillingStatus("y");
										orderdt.setOrderStatus("P");
										orderdt.setLastChgDate(changeDate);
										orderdt.setLastChgTime(time);
										Users user2 = new Users();
										user2.setId(userId);
										orderdt.setLastChgBy(user2);
										orderdt.setBill(opBillHeader);
										try {
											hbt.saveOrUpdate(orderdt);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}

									}
									if (deptCodeList.get(i).toString()
											.equals("RADIO")) {
										DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
										collDetails
												.setSampleCollectionHeader(collHeader);
										collDetails
												.setChargeCode(masChargeCode);
										String diagNo = generateDiagNumber(Integer
												.parseInt(subChargeList.get(i)
														.toString()));
										collDetails.setDiagNo(diagNo);
										collDetails.setCollected("y");
										Users user3 = new Users();
										user3.setId(userId);
										collDetails.setLastChangeBy(user3);
										collDetails.setLastChgDate(changeDate);
										collDetails.setLastChgTime(time);
										collDetails.setOrderStatus("P");
										collDetails
												.setSampleCollDatetime(changeDate);
										MasMainChargecode maincharge = new MasMainChargecode();
										maincharge.setId(Integer
												.parseInt(mainChargeList.get(i)
														.toString()));
										collDetails.setMaincharge(maincharge);
										MasSubChargecode subCharge = new MasSubChargecode();
										subCharge.setId(Integer
												.parseInt(subChargeList.get(i)
														.toString()));
										collDetails.setSubcharge(subCharge);
										DgMasInvestigation investigation = new DgMasInvestigation();
										investigation.setId(Integer
												.parseInt(chargeList.get(i)
														.toString()));
										collDetails
												.setInvestigation(investigation);
										collDetails
												.setSampleCollDatetime(new Date());
										hbt.save(collDetails);
									}
								} else if (!orderDetailIdList.get(i).toString()
										.equals("")) {
									DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(
											DgOrderdt.class,
											(Integer.parseInt(orderDetailIdList
													.get(i).toString())));
									dgOrderdt.setBillingStatus("y");
									dgOrderdt.setInvestigationToMh("n");
									dgOrderdt.setBill(opBillHeader);
									hbt.saveOrUpdate(dgOrderdt);

								}
							}
						}
					}
					new Thread(){
						public void run(){/*
							try {
						//	billingMasterDataService.pacsMethodForPacsServer();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						*/}
					}.start();
				}
				
			
			}
			try {
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			hbt.flush();
			hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			if (tx != null)
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			e.printStackTrace();
		}
		/*
		 * finally { if(session!=null){ session.close(); } }
		 */

		map.put("saved", saved);
		return map;
	}
	
	/**
	 * Method to generate (or Display) Bill No using bl_parameter Table
	 * 
	 */
	@SuppressWarnings("unchecked")
	public synchronized String generateBillNo(String billType, String flag,int hospitalId) {
		Integer billSeqNo = 0;
		List<BlParameter> billSeqNoList = new ArrayList<BlParameter>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();

		Session session = (Session) getSession();
		try {
			billSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "BS"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
			/*session
					.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Prefix", "BS"))
					.setProjection(
							Projections.projectionList()
									.add(Projections.property("BillSubType"))
									.add(Projections.property("Id"))
									.add(Projections.property("SeqNo"))
									.add(Projections.property("BillType")))
					.list();*/
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * String lastBlNo = ""; if (billType.equals("OS")) { opBlHeaderList =
		 * session.createCriteria(BlOpBillHeader.class) .list(); if
		 * (opBlHeaderList.size() > 0) { for (BlOpBillHeader opBlHeader :
		 * opBlHeaderList) { lastBlNo = opBlHeader.getBillNo(); } } } else {
		 * dispHeaderList = session.createCriteria(BlDispensingHeader.class)
		 * .list();
		 * 
		 * if (dispHeaderList.size() > 0) { for (BlDispensingHeader dispHeader :
		 * dispHeaderList) { lastBlNo = dispHeader.getBillNo(); } } }
		 */
		int id = 0;
		// String criteria = "";
		int seqNo = 0;
		if (billSeqNoList.size() > 0) {			
				for (BlParameter blParameter : billSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				// criteria = blParameter.getCriteria();
				billSeqNo = ++seqNo;
			}
			// billNo = commonSeqNo(billSeqNo, criteria, lastBlNo);

			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(billSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
			BlParameter blParameter = new BlParameter();
			billSeqNo = 1;
			blParameter.setSeqNo(billSeqNo);
			blParameter.setPrefix("BS");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);
		}
		hbt.flush();
		//hbt.clear();
		String blNo = billSeqNo.toString();
		return blNo;
	}

	@SuppressWarnings("unchecked")
	public synchronized String generateReceiptNo(String flag,int hospitalId) {
		Integer receiptSeqNo = 0;
		List<BlParameter> rcSeqNoList = new ArrayList<BlParameter>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		try {
			rcSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "RC"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * receiptHeaderList = session.createCriteria(BlReceiptHeader.class)
		 * .list(); String lastRcNo = ""; if (receiptHeaderList.size() > 0) {
		 * for (BlReceiptHeader receiptHeader : receiptHeaderList) { lastRcNo =
		 * receiptHeader.getReceiptNo(); } }
		 */
		int id = 0;
		int seqNo = 0;
		// String criteria = "";
		if (rcSeqNoList.size() > 0) {
			for (BlParameter blParameter : rcSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				// criteria = blParameter.getCriteria();
				receiptSeqNo = ++seqNo;
			}
			// receiptNo = commonSeqNo(receiptSeqNo, criteria, lastRcNo);

			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(receiptSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
			BlParameter blParameter = new BlParameter();
			receiptSeqNo = 1;
			blParameter.setSeqNo(receiptSeqNo);
			blParameter.setPrefix("RC");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);
		
		}
		String recNo = receiptSeqNo.toString();
		
		hbt.flush();
		return recNo;
	}
	
	@SuppressWarnings("unchecked")
	public String generateDiagNumber(int subChargeId) {
		Integer dgSeqNo = 0;
		String diagSeqNo = "";
		List<DiagParam> diagSeqNoList = new ArrayList<DiagParam>();
		List<Integer> maxIdDgDetailsList = new ArrayList<Integer>();
		List<DgSampleCollectionDetails> dgDetailsList = new ArrayList<DgSampleCollectionDetails>();
		Session session = (Session) getSession();
		try {
			diagSeqNoList = session.createCriteria(DiagParam.class)
					.createAlias("SubCharge", "sc")
					.add(Restrictions.eq("sc.Id", subChargeId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * dgDetailsList =
		 * session.createCriteria(DgSampleCollectionDetails.class) .list();
		 * String lastDiagNo = ""; if (dgDetailsList.size() > 0) { for
		 * (DgSampleCollectionDetails collDetails : dgDetailsList) { lastDiagNo
		 * = collDetails.getDiagNo(); } }
		 */

		maxIdDgDetailsList = session
				.createCriteria(DgSampleCollectionDetails.class)
				.setProjection(Projections.max("Id")).list();
		String lastDiagNo = "";
		if (maxIdDgDetailsList.size() > 0) {

			dgDetailsList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("Id", maxIdDgDetailsList.get(0)))
					.list();

			if (dgDetailsList.size() > 0) {
				lastDiagNo = dgDetailsList.get(0).getDiagNo();
				if (lastDiagNo == null) {
					lastDiagNo = "1";
				}
			} else {
				lastDiagNo = "1";
			}
		}
		String lastMnt = "";
		String lastYr = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		StringTokenizer str = new StringTokenizer(lastDiagNo, "/");

		int id = 0;
		String criteria = "";
		int seqNo = 0;
		String subcharge = "";
		if (diagSeqNoList.size() > 0) {
			for (DiagParam dgParam : diagSeqNoList) {
				id = dgParam.getId();
				seqNo = dgParam.getSeqNo();
				subcharge = dgParam.getSubCharge().getSubChargecodeCode();
				criteria = dgParam.getCriteria();
				dgSeqNo = ++seqNo;

			}
			if (criteria.equalsIgnoreCase("c")) {
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					str.nextToken();
					if (str.hasMoreTokens())
						lastMnt = str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					dgSeqNo = 1;
				}
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastYr.equals(currentYear)) {
					dgSeqNo = 1;
				}

				diagSeqNo = dgSeqNo.toString().concat("/").concat(currentYear)
						.concat(subcharge).concat("/").concat(currentMonth)
						.concat("/").concat(currentYear);
			}
			DiagParam diagParam = (DiagParam) hbt.load(DiagParam.class, id);
			diagParam.setSeqNo(dgSeqNo);
			hbt.update(diagParam);

		}
		return diagSeqNo;
	}

	@Override
	public Map<String, Object> getPendingListOfPatientOther(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String uhid = box.getString("hin_id");
		String patientName = box.getString("pName");
		String mobile = box.getString("mobile");
		int hospitalId = box.getInt("hospitalId");
		List<Patient> patientList = new ArrayList<Patient>();
		Criteria crit = null;
		Calendar calender=Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -2);	
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
		
		
		
		crit = session.createCriteria(Patient.class).createAlias("PatientType", "mpt")
				.add(Restrictions.eq("mpt.PatientTypeName", patientTypeNameForOther))
				.add(Restrictions.eq("Billable", "y"))
		        .add(Restrictions.isNull("PaymentStatus"))
		        .add(Restrictions.eq("Hospital.Id", hospitalId));

		
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> getOtherPatientDetailsForBilling(
			Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub



		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Object[]> masPTypeList = new ArrayList<Object[]>();
		List<Object[]> masPTypeLists = new ArrayList<Object[]>();
		List<Object[]> masPTypeListo = new ArrayList<Object[]>();
		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
		List<Object[]> mainChargeCodeList = new ArrayList<Object[]>();
		List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();
		List<Object[]> subChargeCodeList = new ArrayList<Object[]>();
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		List<Object[]> authorizerList = new ArrayList<Object[]>();
		List<Object[]> bankList = new ArrayList<Object[]>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
	//	List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();
		List<Patient> inpatientList = new ArrayList<Patient>();
		List<Integer> maxVisitList = new ArrayList<Integer>();
		List<Visit> lastVisitDetails = new ArrayList<Visit>();
		//List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<Object[]> masCharityList = new ArrayList<Object[]>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	//	List<PatientBalance> patientBalances = new ArrayList<PatientBalance>();
		List<BlOpBillHeader> opBillHeaders = new ArrayList<BlOpBillHeader>(); // Added by Amit Das on 03-02-2016
		String chargeCodeForOtherPatients="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			chargeCodeForOtherPatients=properties.getProperty("chargeCodeForOtherPatients");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Session session = getSession();
		int hospitalId=(Integer)parameterMap.get("hospitalId");
		String maxBlNo = "";

		String orderNo = "";
		String hinNo = "";
		String tempBillNo = "";
		int orderId = 0;
		if (parameterMap.get("hinNo") != null) {
			hinNo = (String) parameterMap.get("hinNo");
		}
		if (parameterMap.get("orderNo") != null) {
			orderNo = (String) parameterMap.get("orderNo");
		}
		if (parameterMap.get("tempBillNo") != null) {
			tempBillNo = (String) parameterMap.get("tempBillNo");
		}
		if (parameterMap.get("orderId") != null) {
			orderId = (Integer) parameterMap.get("orderId");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			if (!hinNo.equals("")) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo))
						.list();

				/*maxVisitList = session.createCriteria(Visit.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.HinNo", hinNo))
						.setProjection(Projections.max("Id")).list();*/
				

			/*	if (maxVisitList.size() > 0) {
					lastVisitDetails = session.createCriteria(Visit.class)
							.add(Restrictions.idEq(maxVisitList.get(0))).list();
					
					if (lastVisitDetails.size() > 0) 
						map.put("lastVisitDetails", lastVisitDetails);
					
				}*/
			}
			
			/*if (orderId != 0) {
				orderHdList = session
						.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("Id", orderId))
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.PatientStatus", "Out Patient")
								.ignoreCase())
								.list();
				
				

			if (orderHdList.size() > 0) {
					
					DgOrderhd orderHd = new DgOrderhd();
					orderHd = orderHdList.get(0);
					//Hibernate.initialize(orderHd.getDgOrderdts());
					Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
					patientList.add(orderHd.getHin());
					orderDtSet = orderHd.getDgOrderdts();
					
					for (DgOrderdt orderDt : orderDtSet) {
						if (orderDt.getBillingStatus().equals("n")) {
							// if
							// (orderDt.getChargeCode().getChargeType().getChargeTypeCode().equals("DIAG")
							// && ) {
							int chargeCodeId=orderDt.getChargeCode().getId();
							orderdtList.add(orderDt);	
					
							}
							
							map.put("orderHdList", orderHdList);
							map.put("orderdtList", orderdtList);
						}
					}
				}*/
			
		
			
				map.put("patientList", patientList);
			
			
		
			/*if(orderHdList.size()!=0)
			opBillHeaders =	session.createCriteria(BlOpBillHeader.class).setProjection(Projections.projectionList().add(Projections.property("Scheme")))
						.add(Restrictions.eq("Visit", orderHdList.get(0).getVisit())).list();*/
			if(opBillHeaders.size()!=0){
				map.put("patientOpBillHeader", opBillHeaders.get(0));
			}
			
			
					
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).setProjection(Projections.projectionList().add(Projections.property("MainChargecodeName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			masChargeCodeList = session
					.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeCode", chargeCodeForOtherPatients).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).setProjection(Projections.projectionList().add(Projections.property("MainChargecode")).add(Projections.property("SubChargecodeName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			// chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			authorizerList = session.createCriteria(MasAuthorizer.class).setProjection(Projections.projectionList().add(Projections.property("AuthorizerName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list(); // chagned by Amit Das on 21-03-2016
			
			bankList = session.createCriteria(MasBankMaster.class).setProjection(Projections.projectionList().add(Projections.property("BankName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			employeeList = session.createCriteria(MasEmployee.class).setProjection(Projections.projectionList().add(Projections.property("EmpCategory")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			// templateList = session.createCriteria(OpdTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("TemplateType", "I")).list();
			
			//patientBalances=session.createCriteria(PatientBalance.class).list();

			String billType = "OS";
		//	maxBlNo = generateBillNo(billType, "display",hospitalId);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	//	map.put("patientBalances", patientBalances);
		map.put("masCharityList", masCharityList);
		map.put("masPTypeListo", masPTypeListo);
		map.put("masPTypeLists", masPTypeLists);
		map.put("masPTypeList", masPTypeList);
		//map.put("discountList", discountList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("masChargeCodeList", masChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		//map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("bankList", bankList);
		map.put("sexList", sexList);
		map.put("employeeList", employeeList);
		map.put("maxBlNo", maxBlNo);
		// map.put("templateList", templateList);
		return map;
	
		
	}

	@Override
	public Map<String, Object> submitBillServicingDetailsOtherPatients(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub


		Map<String, Object> map = new HashMap<String, Object>();
		BlOpBillHeader opBillHeader = new BlOpBillHeader();
		String userName = "";
		boolean saved = false;
		boolean flag = false;
		int userId = 0;

		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List standardDeductionList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List disPercentList = new ArrayList();
		List proportionalDiscountList = new ArrayList();
		List netAmountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();

		List payModeList = new ArrayList();
		List amtReceivedList = new ArrayList();
		List chqNoList = new ArrayList();
		List chqDateList = new ArrayList();
		List bankNameList = new ArrayList();
		int visitIdNew = 0;
		int deptIdNew11 = 0;
		if (dataMap.get("visitIdNew") != null) {
			visitIdNew = (Integer) dataMap.get("visitIdNew");
		}
		if (dataMap.get("deptIdNew11") != null) {
			deptIdNew11 = (Integer) dataMap.get("deptIdNew11");
		}
		//
		//
		if (dataMap.get("opBillHeader") != null) {
			opBillHeader = (BlOpBillHeader) dataMap.get("opBillHeader");
		}
		if (dataMap.get("qtyList") != null) {
			qtyList = (List) dataMap.get("qtyList");
		}
		if (dataMap.get("rateList") != null) {
			rateList = (List) dataMap.get("rateList");
		}
		if (dataMap.get("standardDeductionList") != null) {
			standardDeductionList = (List) dataMap.get("standardDeductionList");
		}
		if (dataMap.get("amountList") != null) {
			amountList = (List) dataMap.get("amountList");
		}
		if (dataMap.get("disPercentList") != null) {
			disPercentList = (List) dataMap.get("disPercentList");
		}
		if (dataMap.get("discountList") != null) {
			discountList = (List) dataMap.get("discountList");
		}
		if (dataMap.get("netAmountList") != null) {
			netAmountList = (List) dataMap.get("netAmountList");
		}
		if (dataMap.get("mainChargeList") != null) {
			mainChargeList = (List) dataMap.get("mainChargeList");
		}
		if (dataMap.get("subChargeList") != null) {
			subChargeList = (List) dataMap.get("subChargeList");
		}
		if (dataMap.get("amtReceivedList") != null) {
			amtReceivedList = (List) dataMap.get("amtReceivedList");
		}
		if (dataMap.get("chqNoList") != null) {
			chqNoList = (List) dataMap.get("chqNoList");
		}
		if (dataMap.get("chqDateList") != null) {
			chqDateList = (List) dataMap.get("chqDateList");
		}
		if (dataMap.get("bankNameList") != null) {
			bankNameList = (List) dataMap.get("bankNameList");
		}

		if (dataMap.get("proportionalDiscountList") != null) {
			proportionalDiscountList = (List) dataMap
					.get("proportionalDiscountList");
		}
		if (dataMap.get("orderDetailIdList") != null) {
			orderDetailIdList = (List) dataMap.get("orderDetailIdList");
		}

		if (dataMap.get("deptCodeList") != null) {
			deptCodeList = (List) dataMap.get("deptCodeList");
		}
		if (dataMap.get("deptIdList") != null) {
			deptIdList = (List) dataMap.get("deptIdList");
		}
		int hinId = 0;
		int hospitalId = 0;
		BigDecimal advAdj = new BigDecimal(0);
		BigDecimal outstanding = new BigDecimal(0);
		BigDecimal avAdvAmtId = new BigDecimal(0);
		BigDecimal remainCId = new BigDecimal(0);
		
		
		if (dataMap.get("hinId") != null) {
			hinId = (Integer) dataMap.get("hinId");
		}
		if (dataMap.get("advAdj") != null) {
			advAdj = new BigDecimal((String) dataMap.get("advAdj"));
		}
		if (dataMap.get("outstanding") != null) {
			outstanding = new BigDecimal((String) dataMap.get("outstanding"));
		}
		
		if (dataMap.get("avAdvAmtId") != null) {
			avAdvAmtId = new BigDecimal((String) dataMap.get("avAdvAmtId"));
		}
		
		if (dataMap.get("remainCId") != null) {
			remainCId = new BigDecimal((String) dataMap.get("remainCId"));
		}
		if (dataMap.get("userName") != null) {
			userName = (String) dataMap.get("userName");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		if (dataMap.get("userId") != null) {
			userId = (Integer) dataMap.get("userId");
		}
		String registrationType = "";
		if (dataMap.get("registrationType") != null) {
			registrationType = (String) dataMap.get("registrationType");
		}
		Users user = new Users();
		user.setId(userId);

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.clear();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		Transaction tx = null;
		Session session = getSession();
		try {
			tx =  session.beginTransaction();
			// ------------------Saving Data into bl_op_bill_header
			// table-------------------------

			String billNo = "";
			String billType = "OS";
			billNo = generateBillNo(billType, "save",hospitalId);
			opBillHeader.setBillNo(billNo);
			
			hbt.save(opBillHeader);

			map.put("billNo", billNo);

			// ------------------Saving Data into bl_op_bill_detail
			// table-------------------------

			if (dataMap.get("chargeList") != null) {
				chargeList = (List) dataMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {
						BlOpBillDetails opBillDetail = new BlOpBillDetails();
						MasChargeCode masChargeCode = new MasChargeCode();
						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {
							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							opBillDetail.setChargeCode(masChargeCode);

							if (rateList.get(i) != null
									&& !(rateList.get(i).toString()).equals("")) {
								BigDecimal rate = new BigDecimal(rateList
										.get(i).toString());
								opBillDetail.setRate(rate);
							}
						
							if (amountList.get(i) != null
									&& !(amountList.get(i).toString())
											.equals("")) {
								BigDecimal amount = new BigDecimal(amountList
										.get(i).toString());
								opBillDetail.setAmount(amount);
							}
											
							if (qtyList.get(i) != null
									&& !(qtyList.get(i).toString()).equals("")) {
								int qty = Integer.parseInt(qtyList.get(i)
										.toString());
								opBillDetail.setQuantity(qty);
							}
							opBillDetail.setBillDate(changeDate);
							opBillDetail.setBillTime(time);
							opBillDetail.setChangedBy(user);
							opBillDetail.setOpBillHeader(opBillHeader);
							opBillDetail.setRefundableStatus("y");
							try {
								hbt.save(opBillDetail);
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}
					}
				}
				// ------------------Saving Data into bl_receipt_header
				// table-------------------------
			//	System.out.println("Data >>>>>>>>flag >>>>>>>> "+dataMap.get("flag"));
				//if(dataMap.get("flag").equals("P")){
				BlReceiptHeader receiptHeader = new BlReceiptHeader();

				if (dataMap.get("receiptHeader") != null) {
					receiptHeader = (BlReceiptHeader) dataMap
							.get("receiptHeader");
					String receiptNo = "";
					receiptNo = generateReceiptNo("save",hospitalId);
					receiptHeader.setReceiptNo(receiptNo);
					receiptHeader.setOpBillHeader(opBillHeader); 
					try {
						hbt.save(receiptHeader);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					// ------------------Saving Data into bl_receipt_detail
					// table-------------------------

					if (dataMap.get("payModeList") != null) {
						payModeList = (List) dataMap.get("payModeList");
						if (payModeList.size() > 0) {
							for (int i = 0; i < payModeList.size(); i++) {
								BlReceiptDetails receiptDetails = new BlReceiptDetails();
								if (payModeList.get(i) != null) {
									receiptDetails.setPaymentMode(payModeList
											.get(i).toString());
									if (!(amtReceivedList.get(i).equals(""))) {
										BigDecimal amtReceived = new BigDecimal(
												amtReceivedList.get(i)
														.toString());
										receiptDetails.setAmount(amtReceived);
									}
									if (chqNoList.get(i) != null
											&& !(chqNoList.get(i).toString()
													.equals(""))) {
										receiptDetails.setChequeNo(chqNoList
												.get(i).toString());
									}
									if (chqDateList.size() > 0
											&& !(chqDateList.get(i).toString()
													.equals(""))) {
										receiptDetails
												.setChequeDate(HMSUtil
														.convertStringTypeDateToDateType(chqDateList
																.get(i)
																.toString()));
									}

									if (bankNameList.get(i) != null
											&& !(bankNameList.get(i).toString()
													.equals(""))) {
										MasBankMaster bankMaster = new MasBankMaster();
										bankMaster.setId(Integer
												.parseInt(bankNameList.get(i)
														.toString()));
										receiptDetails.setBank(bankMaster);
									}
									receiptDetails.setReceiptDate(changeDate);
									receiptDetails.setReceiptTime(time);
									receiptDetails.setChangedBy(user);
									receiptDetails
											.setReceiptHeader(receiptHeader);
									try {
										hbt.save(receiptDetails);
									} catch (DataAccessException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			
			flag = true;
			// ------------------Update past due in patient
			// table-------------------------

			if (flag) {
				BigDecimal pastDueBD = new BigDecimal(0);
				if (hinId != 0) {
					Patient patient = (Patient) hbt.load(Patient.class, hinId);
					patient.setPaymentStatus("y");
					patient.setVisitCreated("n");
//					String pastDue = "";
//					if (patient.getPastDue() != null)
//						pastDue = patient.getPastDue();

//					String sign = "";
//					if (pastDue != null && !pastDue.equals("")
//							&& !pastDue.equals("0")) {
//						sign = pastDue.substring(0, 1);
//						pastDueBD = new BigDecimal(pastDue);
//						if (sign.equals("-")) {
//							if (!advAdj.equals(0)) {
//								pastDueBD = pastDueBD.add(advAdj);
//							}
//							if (!outstanding.equals(0)) {
//								pastDueBD = pastDueBD.subtract(outstanding);
//							}
//						} else {
//							if (!outstanding.equals(0)) {
//								pastDueBD = pastDueBD.add(outstanding);
//							}
//						}
//					} else {
//						if (!outstanding.equals(0)) {
//							pastDueBD = pastDueBD.add(outstanding);
//						}
//						if (!avAdvAmtId.equals(0)) {
//							pastDueBD = pastDueBD.add(avAdvAmtId);
//						}
//						if (!remainCId.equals(0)) {
//							pastDueBD = pastDueBD.add(remainCId);
//						}
//					}
						pastDueBD = pastDueBD.add(avAdvAmtId);					
						if (!remainCId.equals(0)) {
							pastDueBD = pastDueBD.add(remainCId);
						}					
									hbt.update(patient);
				}}
				// ------------------Saving Data into dg_orderhd
				// table-------------------------

				boolean diag = false;
				System.out.println("deptCodeid"+deptCodeList.size());
				for (int i = 0; i < deptCodeList.size(); i++) {
					if (deptCodeList.get(i).equals("RADIO")
							|| deptCodeList.get(i).equals("DIAG")
							|| deptCodeList.get(i).equals("PHYO") || deptCodeList.get(i).equals("LAB")) {
						diag = true;
						break;
					}
				}
				DgOrderhd orderhd = new DgOrderhd();
				if (diag == true) {
					int orderId = 0;
					try {
						if (dataMap.get("orderNo") != null) {
							orderhd = (DgOrderhd) dataMap.get("orderNo");
							orderhd.setBillingStatus("y");

					//	orderhd.setBillChargeSlpNo(billNo);
							hbt.update(orderhd);
						} else if (dataMap.get("orderId") != null) {
							orderId = (Integer) dataMap.get("orderId");
							DgOrderhd dgOrderHd = (DgOrderhd) hbt.load(
									DgOrderhd.class, orderId);
							dgOrderHd.setBillingStatus("y");
							//dgOrderHd.setBillChargeSlpNo(billNo);
							
							hbt.update(dgOrderHd);
							orderhd.setId(orderId);
						}

					} catch (RuntimeException e1) {
						e1.printStackTrace();
					}

					// ------------------Save or Update Data into dg_orderdt
					// table-------------------------

					if (dataMap.get("chargeList") != null) {
						chargeList = (List) dataMap.get("chargeList");
					}

					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
					if (chargeList.size() > 0) {
						for (int l = 0; l < chargeList.size(); l++) {
							if (!chargeList.get(l).equals("")
									&& orderDetailIdList.get(l).toString()
											.equals("")) {
								if (deptCodeList.get(l).toString()
										.equals("RADIO")) {
									if (hinId != 0) {
										Patient patient = new Patient();
										patient.setId(hinId);
										collHeader.setHin(patient);
									}
									MasDepartment department = new MasDepartment();
									department.setId(Integer
											.parseInt(deptIdList.get(l)
													.toString()));
									collHeader.setDepartment(department);
									collHeader.setHospital(hospital);
									collHeader.setOrder(orderhd);
									collHeader.setDiagnosisDate(changeDate);
									collHeader.setDiagnosisTime(time);
									collHeader.setOrderStatus("P");
									collHeader
											.setSampleValidationDate(changeDate);
									collHeader.setSampleValidationTime(time);
									Users user1 = new Users();
									user1.setId(userId);
									//collHeader.setLastChangeBy(user1);
									collHeader.setLastChgDate(changeDate);
									collHeader.setLastChgTime(time);

									hbt.save(collHeader);
									break;
								}
							}
						}
					}
					System.out.println("charge"+chargeList.size());
				
					if (chargeList.size() > 0) {
						for (int i = 0; i < chargeList.size(); i++) {
							System.out.println("dept"+deptCodeList.get(i));
							if (deptCodeList.get(i).equals("RADIO")
									|| deptCodeList.get(i).equals("DIAG")
									|| deptCodeList.get(i).equals("PHYO") || deptCodeList.get(i).equals("LAB")) {

								if (!chargeList.get(i).equals("")
										&& orderDetailIdList.get(i).toString()
												.equals("")) {
									DgOrderdt orderdt = new DgOrderdt();
									orderdt.setOrderhd(orderhd);
									MasChargeCode masChargeCode = new MasChargeCode();
									if (chargeList.get(i) != null
											&& !(chargeList.get(i).toString())
													.equals("")) {
										int chargeId = Integer
												.parseInt(chargeList.get(i)
														.toString());
										masChargeCode.setId(chargeId);
										orderdt.setChargeCode(masChargeCode);

										if (qtyList.get(i) != null
												&& !(qtyList.get(i).toString())
														.equals("")) {
											int qty = Integer.parseInt(qtyList
													.get(i).toString());
											orderdt.setOrderQty(qty);
										}
										if (netAmountList.get(i) != null
												&& !(netAmountList.get(i)
														.toString()).equals("")) {
											BigDecimal netAmount = new BigDecimal(
													netAmountList.get(i)
															.toString());
											//orderdt.setAmount(netAmount);
										}
										if (!mainChargeList.get(i).toString()
												.equals("")) {
											int mainChargeId = Integer
													.parseInt(mainChargeList
															.get(i).toString());
											MasMainChargecode mainChargecode = new MasMainChargecode();
											mainChargecode.setId(mainChargeId);
											orderdt.setMainChargecode(mainChargecode);
										}
										if (!subChargeList.get(i).toString()
												.equals("")) {
											int subChargeId = Integer
													.parseInt(subChargeList
															.get(i).toString());
											MasSubChargecode subChargecode = new MasSubChargecode();
											subChargecode.setId(subChargeId);
											orderdt.setSubChargeid(subChargecode);
										}
										orderdt.setBillingStatus("y");
										orderdt.setOrderStatus("P");
										orderdt.setLastChgDate(changeDate);
										orderdt.setLastChgTime(time);
										Users user2 = new Users();
										user2.setId(userId);
										orderdt.setLastChgBy(user2);
										orderdt.setBill(opBillHeader);
										try {
											hbt.saveOrUpdate(orderdt);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}

									}
									if (deptCodeList.get(i).toString()
											.equals("RADIO")) {
										DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
										collDetails
												.setSampleCollectionHeader(collHeader);
										collDetails
												.setChargeCode(masChargeCode);
										String diagNo = generateDiagNumber(Integer
												.parseInt(subChargeList.get(i)
														.toString()));
										collDetails.setDiagNo(diagNo);
										collDetails.setCollected("y");
										Users user3 = new Users();
										user3.setId(userId);
										collDetails.setLastChangeBy(user3);
										collDetails.setLastChgDate(changeDate);
										collDetails.setLastChgTime(time);
										collDetails.setOrderStatus("P");
										collDetails
												.setSampleCollDatetime(changeDate);
										MasMainChargecode maincharge = new MasMainChargecode();
										maincharge.setId(Integer
												.parseInt(mainChargeList.get(i)
														.toString()));
										collDetails.setMaincharge(maincharge);
										MasSubChargecode subCharge = new MasSubChargecode();
										subCharge.setId(Integer
												.parseInt(subChargeList.get(i)
														.toString()));
										collDetails.setSubcharge(subCharge);
										DgMasInvestigation investigation = new DgMasInvestigation();
										investigation.setId(Integer
												.parseInt(chargeList.get(i)
														.toString()));
										collDetails
												.setInvestigation(investigation);
										collDetails
												.setSampleCollDatetime(new Date());
										hbt.save(collDetails);
									}
								} else if (!orderDetailIdList.get(i).toString()
										.equals("")) {
									DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(
											DgOrderdt.class,
											(Integer.parseInt(orderDetailIdList
													.get(i).toString())));
									dgOrderdt.setBillingStatus("y");
									dgOrderdt.setInvestigationToMh("n");
									dgOrderdt.setBill(opBillHeader);
									hbt.saveOrUpdate(dgOrderdt);

								}
							}
						}
					}
					new Thread(){
						public void run(){/*
							try {
						//	billingMasterDataService.pacsMethodForPacsServer();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						*/}
					}.start();
				}
				
			
			}
			try {
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			hbt.flush();
			hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			if (tx != null)
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			e.printStackTrace();
		}
		/*
		 * finally { if(session!=null){ session.close(); } }
		 */

		map.put("saved", saved);
		return map;
	
	}

	
	
	
	
	
}
	
	
	
	
	

