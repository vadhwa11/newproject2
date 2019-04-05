package jkt.hms.enquiry.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.SilDilStatus;
import jkt.hms.masters.business.StoreIpIssueM;
import jkt.hms.masters.business.StoreIpIssueT;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Visit;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EnquiryDataServiceImpl extends HibernateDaoSupport implements
		EnquiryDataService {

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getWardList() {
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return wardList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDoctorList(Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		String doctorName = "";
		int departmentId = 0;
		String hql = "";
		Session session = (Session) getSession();

		if (enquiryMap.get("doctorName") != null) {
			doctorName = (String) enquiryMap.get("doctorName");
		}
		if (enquiryMap.get("departmentId") != null) {
			departmentId = (Integer) enquiryMap.get("departmentId");
		}

		if (enquiryMap.size() > 0) {
			hql = "from MasEmployee me join me.Department as md";

			if (!doctorName.equals("")) {
				hql += " where me.FirstName like '" + doctorName + "%'";
			}

			if (departmentId != 0 && (doctorName.equals(""))) {
				hql += " where me.Department=" + departmentId;
			} else if (departmentId != 0 && (!doctorName.equals(""))) {
				hql += " and me.Department=" + departmentId;
			}
		}
		try {
			if (!hql.equals("")) {
				Query query = session.createQuery(hql);
				doctorList = query.list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("doctorList", doctorList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForEnquiry() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class).add(
					Restrictions.eq("Status", "y")).list();
			districtList = session.createCriteria(MasDistrict.class).add(
					Restrictions.eq("Status", "y")).list();
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("wardList", wardList);
		return map;
	}

	public Map<String, Object> getPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String serMName = "";
		String serLName = "";
		String patientName = "";
		String patMName = "";
		String patLName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String adNo = "";
		String patientStatus = "";

		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (enquiryMap.get("serviceNo") != null) {
			serviceNo = (String) enquiryMap.get("serviceNo");
		}
		if (enquiryMap.get("hinNo") != null) {
			hinNo = (String) enquiryMap.get("hinNo");
		}
		if (enquiryMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) enquiryMap.get("serviceTypeId");
		}
		if (enquiryMap.get("rankId") != null) {
			rankId = (Integer) enquiryMap.get("rankId");
		}
		if (enquiryMap.get("unitId") != null) {
			unitId = (Integer) enquiryMap.get("unitId");
		}
		if (enquiryMap.get("serPersonName") != null) {
			serPersonName = (String) enquiryMap.get("serPersonName");
		}
		if (enquiryMap.get("serMName") != null) {
			serMName = (String) enquiryMap.get("serMName");
		}
		if (enquiryMap.get("serLName") != null) {
			serLName = (String) enquiryMap.get("serLName");
		}
		if (enquiryMap.get("patientName") != null) {
			patientName = (String) enquiryMap.get("patientName");
		}
		if (enquiryMap.get("patMName") != null) {
			patMName = (String) enquiryMap.get("patMName");
		}
		if (enquiryMap.get("patLName") != null) {
			patLName = (String) enquiryMap.get("patLName");
		}

		if (enquiryMap.get("hinId") != null) {
			hinId = (Integer) enquiryMap.get("hinId");
		}
		if (enquiryMap.get("address") != null) {
			address = (String) enquiryMap.get("address");
		}
		if (enquiryMap.get("districtId") != null) {
			districtId = (Integer) enquiryMap.get("districtId");
		}
		if (enquiryMap.get("stateId") != null) {
			stateId = (Integer) enquiryMap.get("stateId");
		}
		if (enquiryMap.get("adNo") != null) {
			adNo = (String) enquiryMap.get("adNo");
		}
		if (enquiryMap.get("patientStatus") != null) {
			patientStatus = (String) enquiryMap.get("patientStatus");
		}
		//System.out.println("stateId   " + stateId);

		try {
			/*
			 * Criteria crit = session.createCriteria(Patient.class);
			 * 
			 * if(!serviceNo.equals("") ){ crit =
			 * crit.add(Restrictions.like("ServiceNo", serviceNo+"%")); }
			 * if(!hinNo.equals("")){ crit = crit.add(Restrictions.like("HinNo",
			 * hinNo+"%")); } if(!patientName.equals("")){ crit =
			 * crit.add(Restrictions.like("PFirstName", patientName+"%")); }
			 * if(!patMName.equals("")){ crit =
			 * crit.add(Restrictions.like("PMiddleName", patMName+"%")); }
			 * if(!patLName.equals("")){ crit =
			 * crit.add(Restrictions.like("PLastName", patLName+"%")); }
			 * if(!serPersonName.equals("")){ crit =
			 * crit.add(Restrictions.like("SFirstName", serPersonName+"%")); }
			 * if(!serMName.equals("")){ crit =
			 * crit.add(Restrictions.like("SMiddleName", serMName+"%")); }
			 * if(!serLName.equals("")){ crit =
			 * crit.add(Restrictions.like("SLastName", serLName+"%")); }
			 * if(!address.equals("")){ crit =
			 * crit.add(Restrictions.eq("Address", address+"%")); }
			 * if(serviceTypeId != 0 ){ crit = crit.createAlias("ServiceType",
			 * "st").add(Restrictions.eq("st.Id", serviceTypeId)); } if(rankId
			 * != 0 ){ crit = crit.createAlias("Rank",
			 * "rank").add(Restrictions.eq("rank.Id", rankId)); } if(unitId != 0
			 * ){ crit = crit.createAlias("Unit",
			 * "unit").add(Restrictions.eq("unit.Id", unitId)); } if(districtId
			 * != 0 ){ crit = crit.createAlias("District",
			 * "dist").add(Restrictions.eq("dist.Id", districtId)); } if(stateId
			 * != 0 ){ crit = crit.createAlias("State",
			 * "state").add(Restrictions.eq("state.Id", stateId)); }
			 * if(!adNo.equals("")){ crit = crit.createAlias("Inpatients",
			 * "ip").add(Restrictions.eq("ip.AdNo", adNo)); }
			 * if(!patientStatus.equals("")){
			 * //System.out.println(" patientStatus ===================   "
			 * +patientStatus); if(patientStatus.equals("Expired")){ crit =
			 * crit.add(Restrictions.eq("PatientStatus", "Expired")); }else
			 * if(patientStatus.equals("In Patient")){ crit =
			 * crit.add(Restrictions.eq("PatientStatus", "In Patient")); }else
			 * if(patientStatus.equals("Out Patient")){ crit =
			 * crit.add(Restrictions.eq("PatientStatus", "Out Patient")); } }
			 */
			if (!adNo.equals("")) {
				inpatientList = session.createCriteria(Inpatient.class).add(
						Restrictions.like("AdNo", adNo)).list();
			}

			List curDisObj = new ArrayList();
			String list = "";
			if (inpatientList.size() > 0 && inpatientList != null) {
				for (Inpatient inpatient : inpatientList) {
					if (list.length() > 0) {
						list = list + ",'" + inpatient.getHin().getId() + "'";
					} else {
						list = list + "'" + inpatient.getHin().getId() + "'";
					}
				}
			}

			String query = "";
			boolean check = false;
			query = " select p from Patient as p,MasServiceType as st,MasRank as mr,"
					+ " MasUnit as mu,MasDistrict as md,MasState as ms where "
					+ " st.Id = p.ServiceType.Id"
					+ " and mr.Id = p.Rank.Id and mu.Id = p.Unit.Id "
					+ " and md.Id = p.District.Id and  ms.Id = p.State.Id  ";

			if (!serviceNo.equals("")) {
				query = query + " and p.ServiceNo like '" + serviceNo + "%'";
				check = true;
			}

			if (!hinNo.equals("")) {
				query = query + " and p.HinNo like '" + hinNo + "%'";
				check = true;
			}

			if (!address.equals("")) {
				query = query + " and p.Address like '" + address + "%'";
				check = true;
			}

			if (serviceTypeId != 0) {
				query = query + " and p.ServiceType.Id = '" + serviceTypeId
						+ "'";
				check = true;
			}

			if (rankId != 0) {
				query = query + " and p.Rank.Id = '" + rankId + "'";
				check = true;
			}

			if (unitId != 0) {
				query = query + " and p.Unit.Id = '" + unitId + "'";
				check = true;
			}

			if (districtId != 0) {
				query = query + " and p.District.Id = '" + districtId + "'";
				check = true;
			}

			if (stateId != 0) {
				query = query + " and p.State.Id = '" + stateId + "'";
				check = true;
			}

			if (!patientStatus.equals("")) {
				query = query + " and p.PatientStatus = '" + patientStatus
						+ "'";
				check = true;
			}

			if (!adNo.equals("")) {
				if (list.length() > 0) {
					query = query + "and p.Id in (" + list + ")";
				}
				check = true;
			}

			String pquery = "";
			if (!patientName.equals("")) {
				pquery = pquery
						+ " concat(p.PFirstName,':',p.PMiddleName,':',p.PLastName) like '%"
						+ patientName + "%'";
			}

			if (!patMName.equals("")) {
				if (pquery.length() > 0) {
					pquery = pquery
							+ " or concat(p.PFirstName,':',p.PMiddleName,':',p.PLastName) like '%"
							+ patMName + "%'";
				} else {
					pquery = pquery
							+ " concat(p.PFirstName,':',p.PMiddleName,':',p.PLastName) like '%"
							+ patMName + "%'";
				}
			}
			if (!patLName.equals("")) {
				if (pquery.length() > 0) {
					pquery = pquery
							+ " or concat(p.PFirstName,':',p.PMiddleName,':',p.PLastName) like '%"
							+ patLName + "%'";
				} else {
					pquery = pquery
							+ " concat(p.PFirstName,':',p.PMiddleName,':',p.PLastName) like '%"
							+ patLName + "%'";
				}
			}

			if (pquery.length() > 0) {
				query = query + "and (" + pquery + " )";
				check = true;
			}

			String squery = "";
			if (!serPersonName.equals("")) {
				squery = squery
						+ " concat(p.SFirstName,':',p.SMiddleName,':',p.SLastName) like '%"
						+ serPersonName + "%'";
			}
			if (!serMName.equals("")) {
				if (squery.length() > 0) {
					squery = squery
							+ " or concat(p.SFirstName,':',p.SMiddleName,':',p.SLastName) like '%"
							+ serMName + "%'";
				} else {
					squery = squery
							+ " concat(p.SFirstName,':',p.SMiddleName,':',p.SLastName) like '%"
							+ serMName + "%'";
				}
			}
			if (!serLName.equals("")) {
				if (squery.length() > 0) {
					squery = squery
							+ " or concat(p.SFirstName,':',p.SMiddleName,':',p.SLastName) like '%"
							+ serLName + "%'";
				} else {
					squery = squery
							+ " concat(p.SFirstName,':',p.SMiddleName,':',p.SLastName) like '%"
							+ serLName + "%'";
				}
			}

			if (squery.length() > 0) {
				query = query + " and (" + squery + " )";
				check = true;
			}

			//System.out.println("::query:" + query);
			if (check) {
				Query q = session.createQuery(query);
				patientList = q.list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("patientList  " + patientList.size());
		map.put("patientList", patientList);
		return map;
	}

	// -----------------------------------------InPatient
	// Enquiry--------------------------------
	public Map<String, Object> getInPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String patientName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String adNo = "";

		Session session = (Session) getSession();

		if (enquiryMap.get("serviceNo") != null) {
			serviceNo = (String) enquiryMap.get("serviceNo");
		}
		if (enquiryMap.get("hinNo") != null) {
			hinNo = (String) enquiryMap.get("hinNo");
		}
		if (enquiryMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) enquiryMap.get("serviceTypeId");
		}
		if (enquiryMap.get("rankId") != null) {
			rankId = (Integer) enquiryMap.get("rankId");
		}
		if (enquiryMap.get("unitId") != null) {
			unitId = (Integer) enquiryMap.get("unitId");
		}
		if (enquiryMap.get("serPersonName") != null) {
			serPersonName = (String) enquiryMap.get("serPersonName");
		}
		if (enquiryMap.get("patientName") != null) {
			patientName = (String) enquiryMap.get("patientName");
		}
		if (enquiryMap.get("hinId") != null) {
			hinId = (Integer) enquiryMap.get("hinId");
		}
		if (enquiryMap.get("address") != null) {
			address = (String) enquiryMap.get("address");
		}
		if (enquiryMap.get("districtId") != null) {
			districtId = (Integer) enquiryMap.get("districtId");
		}
		if (enquiryMap.get("stateId") != null) {
			stateId = (Integer) enquiryMap.get("stateId");
		}
		if (enquiryMap.get("adNo") != null) {
			adNo = (String) enquiryMap.get("adNo");
		}
		try {
			Criteria crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("PatientStatus", "In Patient"));
			if (hinId == 0) {
				if (!serviceNo.equals("")) {
					crit = crit.add(Restrictions.like("ServiceNo", serviceNo
							+ "%"));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.like("HinNo", hinNo + "%"));
				}
				if (!patientName.equals("")) {
					crit = crit.add(Restrictions.like("PFirstName", patientName
							+ "%"));
				}
				if (!serPersonName.equals("")) {
					crit = crit.add(Restrictions.like("SFirstName",
							serPersonName + "%"));
				}
				if (!address.equals("")) {
					crit = crit.add(Restrictions.eq("Address", address + "%"));
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
				if (districtId != 0) {
					crit = crit.createAlias("District", "dist").add(
							Restrictions.eq("dist.Id", districtId));
				}
				if (stateId != 0) {
					crit = crit.createAlias("State", "state").add(
							Restrictions.eq("state.Id", stateId));
				}
				if (!adNo.equals("")) {
					crit = crit.createAlias("Inpatients", "ip").add(
							Restrictions.eq("ip.AdNo", adNo));
				}
			} else if (hinId != 0) {
				crit = crit.add(Restrictions.idEq(hinId));
			}
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getDetailsForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getInPatientDetailsForEnquiry2(
			Map<String, Object> mapForDs) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Object> inPatientList = new ArrayList<Object>();
		Session session = (Session) getSession();

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
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;

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
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		if (mapForDs.get("wardId") != null) {
			wardId = (Integer) mapForDs.get("wardId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		List objectList = new ArrayList();
		objectList.add("A");
		objectList.add("W");
		Criteria crit = session.createCriteria(Inpatient.class).add(
				Restrictions.in("AdStatus", objectList));
		if (inpatientId == 0) {
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("AdNo", adNo));
			}
			if (adNo.equals("")) {
				crit = crit.createAlias("Hin", "hin");
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PFirstName",
						patientFName + "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PMiddleName",
						patientMName + "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PLastName", patientLName
						+ "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SFirstName",
						serPersonFName + "%"));
			}
			if (!serPersonMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SMiddleName",
						serPersonMName + "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SLastName",
						serPersonLName + "%"));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("hin.ServiceType", "st").add(
						Restrictions.eq("st.Id", serviceTypeId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("hin.Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			if (unitId != 0) {
				crit = crit.createAlias("hin.Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (wardId != 0) {
				crit = crit.createAlias("Department", "dept").add(
						Restrictions.eq("dept.Id", wardId));
			}
		} else if (inpatientId != 0) {
			crit = crit.add(Restrictions.idEq(inpatientId));
		}

		inPatientList = crit.list();
		map.put("inpatientList", inPatientList);
		return map;

	}

	// --------------- Added at Bangalore By Vivek-------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();
		String hinNo = "";
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		//System.out.println("hinNo  " + hinNo);
		Session session = getSession();
		try {
			patientList = (List<Patient>) session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();
			inPatientList = (List<Inpatient>) session.createCriteria(
					Inpatient.class).createAlias("Hin", "pt").add(
					Restrictions.eq("pt.HinNo", hinNo)).list();
			visitList = (List<Visit>) session.createCriteria(Visit.class)
					.createAlias("Hin", "pt").add(
							Restrictions.eq("pt.HinNo", hinNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("patientList  " + patientList.size());
		//System.out.println("inPatientList  " + inPatientList.size());
		//System.out.println("visitList  " + visitList.size());

		map.put("patientList", patientList);
		map.put("inPatientList", inPatientList);
		map.put("visitList", visitList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdVisitDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		int id = 0;

		if (dataMap.get("id") != null) {
			id = Integer.parseInt("" + dataMap.get("id"));
		}

		Session session = getSession();
		inPatientList = (List<Inpatient>) session.createCriteria(
				Inpatient.class).add(Restrictions.eq("Id", id)).list();
		map.put("inPatientList", inPatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllEnquiry(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		int id = 0;
		int hinId = 0;
		String opOrString = "";
		String detailId = "";
		@SuppressWarnings("unused")
		String adNo = "";
		if (dataMap.get("id") != null) {
			id = Integer.parseInt("" + dataMap.get("id"));
		}
		if (dataMap.get("opOrString") != null) {
			opOrString = ("" + dataMap.get("opOrString"));
		}
		if (dataMap.get("detailId") != null) {
			detailId = ("" + dataMap.get("detailId"));
		}
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + dataMap.get("hinId"));
		}
		Session session = getSession();
		if (opOrString.equals("IP")) {
			List<Inpatient> inPatientList = new ArrayList<Inpatient>();
			inPatientList = (List<Inpatient>) session.createCriteria(
					Inpatient.class).add(Restrictions.eq("Id", id)).list();
			Inpatient inpatient = inPatientList.get(0);
			hinId = Integer.parseInt("" + inpatient.getHin().getId());
			adNo = inpatient.getAdNo();
			if (detailId.equals("Discharge")) {
				dischargeIcdCodeList = (List<DischargeIcdCode>) session
						.createCriteria(DischargeIcdCode.class).add(
								Restrictions.eq("Inpatient.Id", id)).add(
								Restrictions.eq("DiagnosisStatus", "f")).list();

				dischargeList = (List<Discharge>) session.createCriteria(
						Discharge.class).add(Restrictions.eq("AdNo", adNo))
						.list();
			} else if (detailId.equals("Mlc")) {
				mlcCaseList = (List<MlcCase>) session.createCriteria(
						MlcCase.class).add(Restrictions.eq("AdNo", adNo))
						.list();
			} else if (detailId.equals("Sil/Dil")) {
				silDilStatusList = (List<SilDilStatus>) session.createCriteria(
						SilDilStatus.class).add(
						Restrictions.eq("Inpatient.Id", id)).list();
			} else if (detailId.equals("Transfer")) {
				transferList = (List<Transfer>) session.createCriteria(
						Transfer.class).add(Restrictions.eq("AdNo", adNo))
						.list();
			}

		} else if (opOrString.equals("OP")) {
			if (detailId.equals("Visit")) {
				visitList = (List<Visit>) session.createCriteria(Visit.class)
						.add(Restrictions.eq("Id", id)).list();
			} else if (detailId.equals("OP-Mlc")) {
				visitList = (List<Visit>) session.createCriteria(Visit.class)
						.add(Restrictions.eq("Id", id)).list();
				Visit visit = visitList.get(0);
				mlcCaseList = (List<MlcCase>) session.createCriteria(
						MlcCase.class).add(
						Restrictions.eq("VisitNo", visit.getVisitNo())).add(
						Restrictions.eq("Hin.Id", hinId)).list();
			}
		}
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
		map.put("visitList", visitList);
		map.put("mlcCaseList", mlcCaseList);
		map.put("transferList", transferList);
		map.put("silDilStatusList", silDilStatusList);
		map.put("dischargeList", dischargeList);
		return map;
	}
	public Map<String, Object> getAllEnquiry1(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
		List<PatientPrescriptionHeader> patientPrescriptionHdList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientPrescriptionDetails> patientPrescriptionList = new ArrayList<PatientPrescriptionDetails>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<StoreIpIssueM> storeIssueMList = new ArrayList<StoreIpIssueM>();
        List<StoreIpIssueT> storeIssueTList = new ArrayList<StoreIpIssueT>();
		int id = 0;
		int hinId = 0;
		String opOrString = "";
		String detailId = "";
		@SuppressWarnings("unused")
		String adNo = "";
		if (dataMap.get("id") != null) {
			id = Integer.parseInt("" + dataMap.get("id"));
		}
		if (dataMap.get("opOrString") != null) {
			opOrString = ("" + dataMap.get("opOrString"));
		}
		if (dataMap.get("detailId") != null) {
			detailId = ("" + dataMap.get("detailId"));
		}
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + dataMap.get("hinId"));
		}
		Session session = getSession();
		if (opOrString.equals("IP")) {
			List<Inpatient> inPatientList = new ArrayList<Inpatient>();
			inPatientList = (List<Inpatient>) session.createCriteria(
					Inpatient.class).add(Restrictions.eq("Id", id)).list();
			Inpatient inpatient = inPatientList.get(0);
			hinId = Integer.parseInt("" + inpatient.getHin().getId());
			adNo = inpatient.getAdNo();
			if (detailId.equals("Discharge")) {
				dischargeIcdCodeList = (List<DischargeIcdCode>) session
						.createCriteria(DischargeIcdCode.class).add(
								Restrictions.eq("Inpatient.Id", id)).add(
								Restrictions.eq("DiagnosisStatus", "f")).list();

				dischargeList = (List<Discharge>) session.createCriteria(
						Discharge.class).add(Restrictions.eq("AdNo", adNo))
						.list();
			} else if (detailId.equals("Mlc")) {
				mlcCaseList = (List<MlcCase>) session.createCriteria(
						MlcCase.class).add(Restrictions.eq("AdNo", adNo))
						.list();
			} else if (detailId.equals("Sil/Dil")) {
				silDilStatusList = (List<SilDilStatus>) session.createCriteria(
						SilDilStatus.class).add(
						Restrictions.eq("Inpatient.Id", id)).list();
			} else if (detailId.equals("Transfer")) {
				transferList = (List<Transfer>) session.createCriteria(
						Transfer.class).add(Restrictions.eq("AdNo", adNo))
						.list();
			} else if (detailId.equals("Diagnostics")) {
				dgOrderhdList = session.createCriteria(DgOrderhd.class).createAlias("Inpatient","ip")
				.add(Restrictions.eq("ip.Id", id)).list();
			}else if(detailId.equals("Prescription")){
              storeIssueMList =session.createCriteria(StoreIpIssueM.class)
                 .add(Restrictions.eq("AdNo",adNo)).list();
              if (storeIssueMList.size() > 0) {
                    StoreIpIssueM storeIpIssueM = (StoreIpIssueM)storeIssueMList.get(0);
              int storeIssueMId=storeIpIssueM.getId();
              storeIssueTList = session.createCriteria(StoreIpIssueT.class).createAlias("IpIssue","sipm")
                  .add(Restrictions.eq("sipm.Id", storeIssueMId)).list();
              }

        }


		} else if (opOrString.equals("OP")) {
			if (detailId.equals("Visit")) {
				visitList = (List<Visit>) session.createCriteria(Visit.class)
						.add(Restrictions.eq("Id", id)).list();
			} else if (detailId.equals("OP-Mlc")) {
				visitList = (List<Visit>) session.createCriteria(Visit.class)
						.add(Restrictions.eq("Id", id)).list();
				Visit visit = visitList.get(0);
				mlcCaseList = (List<MlcCase>) session.createCriteria(
						MlcCase.class).add(Restrictions.eq("VisitNo", visit.getVisitNo()))
						.add(Restrictions.eq("Hin.Id", hinId)).list();
			}else if(detailId.equals("Prescription")){
				visitList = (List<Visit>) session.createCriteria(Visit.class).add(Restrictions.eq("Id", id)).list();
				Visit visit = visitList.get(0);
				patientPrescriptionHdList = session.createCriteria(PatientPrescriptionHeader.class)
				.createAlias("Visit","visit").add(Restrictions.eq("visit.Id", visit.getId())).list();
				if (patientPrescriptionHdList.size() > 0) {
					PatientPrescriptionHeader patientPrescriptionHeader = (PatientPrescriptionHeader) patientPrescriptionHdList
							.get(0);

					int prescriptionId = patientPrescriptionHeader.getId();
					patientPrescriptionList = session.createCriteria(PatientPrescriptionDetails.class)
					 	.createAlias("Prescription", "prescription").add(Restrictions.eq("prescription.Id", prescriptionId))
							.list();
				}
				
				//--------For diagnostic---
			}else if(detailId.equals("Diagnostics")){
				visitList = (List<Visit>) session.createCriteria(Visit.class)
				.add(Restrictions.eq("Id", id)).list();
				Visit visit = visitList.get(0);
				
				dgOrderhdList = session.createCriteria(DgOrderhd.class).createAlias("Visit","visit")
				.add(Restrictions.eq("visit.Id", visit.getId())).list();
			}
		}
		map.put("dgOrderhdList", dgOrderhdList);
		map.put("patientPrescriptionHdList", patientPrescriptionHdList);
		map.put("patientPrescriptionList", patientPrescriptionList);
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
		map.put("visitList", visitList);
		map.put("mlcCaseList", mlcCaseList);
		map.put("transferList", transferList);
		map.put("silDilStatusList", silDilStatusList);
		map.put("dischargeList", dischargeList);
		map.put("storeIssueTList", storeIssueTList);
		map.put("storeIssueMList", storeIssueMList);
		return map;
	}

}
