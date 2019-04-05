package jkt.hms.medicalboard.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMedicalBoardDetails;
import jkt.hms.masters.business.MasMedicalBoardProceedings;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.HMSUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Transaction;
public class MedicalBoardProceedingDataServiceImpl extends HibernateDaoSupport
		implements MedicalBoardProceedingDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicalBoardProceedingJsp(int Id) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasMedicalBoardDetails> medicalBoardDetailsList = new ArrayList<MasMedicalBoardDetails>();
		List<MasDistrict> cityList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();

		List<MasMedicalBoardProceedings> medicalBoardProceedingsList = new ArrayList<MasMedicalBoardProceedings>();
		List<MasMedicalCategory> medicalCategoryList = new ArrayList<MasMedicalCategory>();
		List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		// List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		patientList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Patient where Id ='" + Id + "'");
		if (patientList.size() > 0) {
			int hin_id = patientList.get(0).getId();

		}
		/*
		 * inpatientList = getHibernateTemplate().find( "from
		 * jkt.hms.masters.business.Inpatient as ip where ip.Id ='" + Id + "'");
		 */
		medicalCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalCategory");
		employeeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee me where me.Status='y'");
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		cityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");
		stateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");

		if (patientList.size() > 0) {
			int recordOfficeAddressId = patientList.get(0)
					.getRecordOfficeAddress().getId();
			recordOfficeAddressList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRecordOfficeAddress where Id= '"
							+ recordOfficeAddressId + "'");
		}

		map.put("medicalCategoryList", medicalCategoryList);
		map.put("employeeList", employeeList);
		map.put("cityList", cityList);
		map.put("stateList", stateList);
		map.put("patientList", patientList);
		map.put("unitList", unitList);
		map.put("medicalBoardDetailsList", medicalBoardDetailsList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		/* map.put("inpatientList", inpatientList); */
		List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from MasMedicalBoardProceedings");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		// //System.out.println("id------------------------------"+id);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addMedicalBoardProceeding(
			MasMedicalBoardProceedings masMedicalBoardProceedings,
			List<MasMedicalBoardDetails> masMedicalBoardDetails) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		Session session =(Session)getSession();
		Transaction ctx = null;
		int id = 0;
		try {
			ctx = session.beginTransaction();
			hbt1.save(masMedicalBoardProceedings);
			hbt1.refresh(masMedicalBoardProceedings);
			id=masMedicalBoardProceedings.getId();
			if (masMedicalBoardDetails != null) {

				for (MasMedicalBoardDetails masMedicalDetails : masMedicalBoardDetails) {
					MasMedicalBoardProceedings masMadicalBoardProceeding = new MasMedicalBoardProceedings();
					masMadicalBoardProceeding.setId(id);
					masMedicalDetails
							.setBoardProceedings(masMadicalBoardProceeding);
					hbt1.save(masMedicalDetails);
				}
				successfullyAdded = true;
			}
			List<TransactionSequence> transactionSequenceList = hbt1.find("from TransactionSequence ts where ts.TransactionPrefix='MBP'");
			//System.out.println("transactionSequenceList::"+ transactionSequenceList.size());
			TransactionSequence transactionSequence = transactionSequenceList.get(0);
			transactionSequence	.setTransactionSequenceNumber(1 + transactionSequence.getTransactionSequenceNumber());
			hbt1.saveOrUpdate(transactionSequence);
			hbt1.refresh(transactionSequence);
			ctx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			ctx.rollback(); 
		}
		/*String sqlQuery = "select max(id)from MasMedicalBoardProceedings";
		Query query = session.createQuery(sqlQuery);
		List list = query.list();
		int id = 0;
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
		}
		sess.close();*/
		
		
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateMedicalEntryNumber(String userName) {
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastEntryNo = "";
		String lastYear = "";
		Session session = (Session) getSession();
		String entryNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		List<MasMedicalBoardProceedings> masMedicalBoardProceedingsList = session.createCriteria(MasMedicalBoardProceedings.class).list();
		//System.out.println("MasMedicalBoardProceedingList in Entry no ::"+masMedicalBoardProceedingsList.size());
		for (MasMedicalBoardProceedings masMedicalBoardProceedings : masMedicalBoardProceedingsList) {
			lastEntryNo = (String) masMedicalBoardProceedings.getEntryNo();
		}
		StringTokenizer str = new StringTokenizer(lastEntryNo, "/");
		while (str.hasMoreElements()) {
			lastYear = str.nextToken();
		}
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MBP")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (medicalWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();
				if (lastYear.equals(currentYear)) {
					entryNo = entryNo.concat(String.valueOf(transactionSequence
							.getTransactionSequenceNumber() + 1));
					entryNo = entryNo.concat("/").concat(currentMonth);
					entryNo = entryNo.concat("/").concat(lastYear);
				} else {
					lastYear = currentYear;
					entryNo = entryNo.concat(String.valueOf(1));
					entryNo = entryNo.concat("/").concat(currentMonth);
					entryNo = entryNo.concat("/").concat(lastYear);
					transactionSequence.setTransactionSequenceNumber(0);
					session.saveOrUpdate(transactionSequence);
					session.refresh(transactionSequence);
				}

			}
		} else if (medicalWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMedicalBoardProceedings");
			tsObj.setTransactionPrefix("MBP");
			tsObj.setTransactionSequenceName("MedBoard Proceeding");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
			hbt.refresh(tsObj);
			entryNo = entryNo.concat(String.valueOf(1));
			entryNo = entryNo.concat("/").concat(currentMonth);
			entryNo = entryNo.concat("/").concat(currentYear);
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicalBoardProceedingForEmployeeJsp(int Id) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> selectedEmployeeForMedicalBoardList = new ArrayList<MasEmployee>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasMedicalBoardDetails> medicalBoardDetailsList = new ArrayList<MasMedicalBoardDetails>();
		List<MasDistrict> cityList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();

		List<MasMedicalBoardProceedings> medicalBoardProceedingsList = new ArrayList<MasMedicalBoardProceedings>();
		List<MasMedicalCategory> medicalCategoryList = new ArrayList<MasMedicalCategory>();
		List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		// List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		selectedEmployeeForMedicalBoardList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Id ='" + Id
						+ "'");
		if (selectedEmployeeForMedicalBoardList.size() > 0) {
			int hin_id = selectedEmployeeForMedicalBoardList.get(0).getId();

		}
		/*
		 * inpatientList = getHibernateTemplate().find( "from
		 * jkt.hms.masters.business.Inpatient as ip where ip.Id ='" + Id + "'");
		 */
		medicalCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalCategory");
		employeeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasEmployee me where me.Status='y'");
		unitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		cityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");
		stateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");

		/*
		 * if (selectedEmployeeForMedicalBoardList.size() > 0) { int
		 * recordOfficeAddressId =
		 * selectedEmployeeForMedicalBoardList.get(0).getRecordOfficeAddress
		 * ().getId(); recordOfficeAddressList = getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasRecordOfficeAddress where Id= '" +
		 * recordOfficeAddressId + "'"); }
		 */

		map.put("medicalCategoryList", medicalCategoryList);
		map.put("employeeList", employeeList);
		map.put("cityList", cityList);
		map.put("stateList", stateList);
		map.put("selectedEmployeeForMedicalBoardList",
				selectedEmployeeForMedicalBoardList);
		map.put("unitList", unitList);
		map.put("medicalBoardDetailsList", medicalBoardDetailsList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		/* map.put("inpatientList", inpatientList); */
		List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from MasMedicalBoardProceedings");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		// //System.out.println("id------------------------------"+id);

		return map;
	}

}
