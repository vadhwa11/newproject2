package jkt.hms.agendapoints.dataservice;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.agendapoints.controller.AgendaDTO;
import jkt.hms.masters.business.ApAgendaRequest;
import jkt.hms.masters.business.ApMeetingAgenda;
import jkt.hms.masters.business.ApMeetingEmployee;
import jkt.hms.masters.business.ApMeetingSchedule;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AgendaDataServiceImpl extends HibernateDaoSupport implements
		AgendaDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAgendaJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<ApAgendaRequest> apAgendaList = new ArrayList<ApAgendaRequest>();
		apAgendaList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApAgendaRequest");
		map.put("apAgendaList", apAgendaList);
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		map.put("departmentList", departmentList);
		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();

		masEmployee = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Status = 'y'");
		map.put("masEmployee", masEmployee);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMeetingScheduleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		map.put("departmentList", departmentList);
		List<ApAgendaRequest> agendaRequestList = new ArrayList<ApAgendaRequest>();
		agendaRequestList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApAgendaRequest ");
		map.put("agendaRequestList", agendaRequestList);
		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();

		masEmployee = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee where Status = 'y' ");
		map.put("masEmployee", masEmployee);
		return map;
	}

	public boolean addAgendaPointsRequest(Map<String, Object> map) {
		boolean successfullyAdded = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		ApAgendaRequest apAgenda = (ApAgendaRequest) map.get("apAgendaRequest");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(apAgenda);
		hbt.refresh(apAgenda);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAgendaRequest(Map<String, Object> map) {
		List<ApAgendaRequest> searchAgendaList = new ArrayList<ApAgendaRequest>();
		Map<String, Object> agendaPointFieldsMap = new HashMap<String, Object>();
		String searchAgendaPoint = (String) map.get("searchAgendaPoints");
		if (searchAgendaPoint != null) {
			searchAgendaList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.ApAgendaRequest imc where imc.AgendaPoint like %'"
									+ searchAgendaPoint
									+ "%' order by imc.AgendaPoint");

		}
		agendaPointFieldsMap = showAgendaJsp();
		agendaPointFieldsMap.put("searchAgendaRequestList", searchAgendaList);
		return agendaPointFieldsMap;

	}

	public boolean deleteAgendaRequest(Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();

		String currentTime = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		int agendaPointId = Integer.parseInt(generalMap.get("agendaPointId")
				.toString());
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		ApAgendaRequest agendaPointReqest = new ApAgendaRequest();
		agendaPointReqest = (ApAgendaRequest) hbt.load(ApAgendaRequest.class,
				agendaPointId);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				agendaPointReqest.setStatus("r");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				agendaPointReqest.setStatus("o");
				dataDeleted = false;
			}
		}
		agendaPointReqest.setLastChgBy(changedBy);
		agendaPointReqest.setLastChgDate(currentDate);
		agendaPointReqest.setLastChgTime(currentTime);

		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(agendaPointReqest);
		hbt.refresh(agendaPointReqest);
		return dataDeleted;

	}

	public boolean editAgendaPointsRequest(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int agendaPointId = 0;
		String changedBy = "";
		ApAgendaRequest apAgendaRequest = (ApAgendaRequest) generalMap
				.get("apAgendaRequest");
		agendaPointId = apAgendaRequest.getId();
		MasEmployee masEmployee = new MasEmployee();
		MasDepartment masDepartment = new MasDepartment();
		ApAgendaRequest agendaPointRequest = (ApAgendaRequest) getHibernateTemplate()
				.load(ApAgendaRequest.class, agendaPointId);
		if (apAgendaRequest.getAgendaPoint() != null) {
			agendaPointRequest.setAgendaPoint(apAgendaRequest.getAgendaPoint());
		}
		if (apAgendaRequest.getEmpId().getId() != null) {
			masEmployee.setId(apAgendaRequest.getEmpId().getId());
			agendaPointRequest.setEmpId(masEmployee);
		}
		if (apAgendaRequest.getDepartmentId().getId() != null) {
			masDepartment.setId(apAgendaRequest.getDepartmentId().getId());
			agendaPointRequest.setDepartmentId(masDepartment);
		}

		if (apAgendaRequest.getLastChgBy() != null) {
			agendaPointRequest.setLastChgBy(apAgendaRequest.getLastChgBy());
		}
		if (apAgendaRequest.getLastChgDate() != null) {
			agendaPointRequest.setLastChgDate(apAgendaRequest.getLastChgDate());

		}
		if (apAgendaRequest.getLastChgTime() != null) {
			agendaPointRequest.setLastChgTime(apAgendaRequest.getLastChgTime());
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(agendaPointRequest);
		hbt.refresh(apAgendaRequest);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addMeetingScheduled(Map<String, Object> map) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		ApMeetingSchedule meetingSchedule = (ApMeetingSchedule) map
				.get("apMeetingSchedule");
		Box box = (Box) map.get("box");
		Vector v1 = box.getVector("selectedId");
		Vector v2 = box.getVector("rejectedId");
		Vector v3 = box.getVector(RequestConstants.EMPLOYEE_ID);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		boolean successfullyAdded = false;
		if (meetingSchedule != null) {
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(meetingSchedule);
			hbt.refresh(meetingSchedule);
			successfullyAdded = true;
		}
		List list = new ArrayList();
		int id = 0;
		list = getHibernateTemplate().find(
				"select max(Id)from ApMeetingSchedule");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
		}

		for (int i = 0; i < v1.size(); i++) {
			// updating selected meeting agenda in Agenda Point Request table
			if (!v1.get(i).toString().equalsIgnoreCase("")) {
				ApAgendaRequest agendaPointRequest = (ApAgendaRequest) getHibernateTemplate()
						.load(ApAgendaRequest.class,
								Integer.parseInt(v1.get(i).toString()));
				agendaPointRequest.setStatus("s");
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(agendaPointRequest);
				hbt.refresh(agendaPointRequest);
			}
		}
		for (int i = 0; i < v1.size(); i++) {

			if (!v1.get(i).toString().equalsIgnoreCase("")) {
				ApMeetingAgenda meetingAgenda = new ApMeetingAgenda();
				ApMeetingSchedule meetingScheduleLocal = new ApMeetingSchedule();
				meetingScheduleLocal.setId(id);
				ApAgendaRequest apAgendaRequest = new ApAgendaRequest();
				apAgendaRequest.setId(Integer.parseInt(v1.get(i).toString()));
				meetingAgenda.setMeeting(meetingScheduleLocal);
				meetingAgenda.setAgendaRequest(apAgendaRequest);
				hbt.setFlushModeName("FLUSH_AUTO");
				hbt.setCheckWriteOperations(false);
				hbt.save(meetingAgenda);
				hbt.refresh(meetingAgenda);
			}
		}

		for (int i = 0; i < v2.size(); i++) {
			// update agenda point request status to the agenda point request
			// table
			if (!v2.get(i).toString().equalsIgnoreCase("")) {
				ApAgendaRequest agendaPointRequest = (ApAgendaRequest) getHibernateTemplate()
						.load(ApAgendaRequest.class,
								Integer.parseInt(v2.get(i).toString()));
				agendaPointRequest.setStatus("r");
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(agendaPointRequest);
				hbt.refresh(agendaPointRequest);
			}
		}
		for (int i = 0; i < v3.size(); i++) {
			// setting meeting id to the meeting employee table
			if (!v3.get(i).toString().equalsIgnoreCase("")) {
				ApMeetingEmployee apMeetingEmp = new ApMeetingEmployee();
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt(v3.get(i).toString()));
				apMeetingEmp.setEmp(masEmployee);
				ApMeetingSchedule meetingScheduleLocal = new ApMeetingSchedule();
				meetingScheduleLocal.setId(id);
				apMeetingEmp.setMeeting(meetingScheduleLocal);
				hbt.setFlushModeName("FLUSH_AUTO");
				hbt.setCheckWriteOperations(false);
				hbt.save(apMeetingEmp);
				hbt.refresh(apMeetingEmp);
			}
		}

		if (successfullyAdded) {
			String date = "";
			date = (String) utilMap.get("currentDate");
			String[] currentDate = date.split("/");
			String currentMonth = currentDate[1];
			String currentMonthNo = currentDate[2];
			Session session = (Session) getSession();
			// org.springframework.orm.hibernate3.HibernateTemplate hbt2 =
			// getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			// hbt.setCheckWriteOperations(false);
			List<TransactionSequence> meetingNoList = new ArrayList<TransactionSequence>();
			meetingNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "AMS")).list();

			if (meetingNoList.size() > 0) {
				for (TransactionSequence transactionSequence : meetingNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id1);

					if (currentMonth.equalsIgnoreCase("01")
							&& transactionSequenceObj.getMonth() != Integer
									.parseInt(currentMonth)) {
						transactionSequenceObj.setTransactionSequenceNumber(1);
						transactionSequenceObj.setMonth(Integer
								.parseInt(currentMonthNo.toString()));
						seqNo = 1;
					} else {
						transactionSequenceObj
								.setTransactionSequenceNumber(++seqNo);
					}
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(transactionSequenceObj);
					hbt.refresh(transactionSequenceObj);
				}
			}
		}
		return successfullyAdded;
	}

	public String generateMeetingNumber(String userName) {
		List<TransactionSequence> meetingNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String meetingNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		meetingNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "AMS")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (meetingNoList.size() > 0) {
			for (TransactionSequence transactionSequence : meetingNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				meetingNo = meetingNo.concat(String.valueOf(seqNo));
				meetingNo = meetingNo.concat("/").concat(currentMonth);
				meetingNo = meetingNo.concat("/").concat(currentYear);
			}
		} else if (meetingNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("ApMeetingSchedule");
			tsObj.setTransactionPrefix("AMS");
			tsObj.setTransactionSequenceName("Meeting No");
			tsObj.setTransactionSequenceNumber(1);
			tsObj.setMonth(Integer.parseInt(currentMonth));
			hbt.save(tsObj);
		}
		return meetingNo;
	}

	public Map<String, Object> showMeetingDetailsJsp(int id) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<ApMeetingSchedule> apAgendaMeetingList = new ArrayList<ApMeetingSchedule>();
		apAgendaMeetingList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApMeetingSchedule as ams where ams.Id='"
						+ id + "'");
		map.put("apAgendameetingList", apAgendaMeetingList);

		List<ApMeetingAgenda> agendaPointsOfMeetingList = new ArrayList<ApMeetingAgenda>();
		agendaPointsOfMeetingList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApMeetingAgenda as ama where ama.Meeting.Id='"
						+ id + "'");
		map.put("agendaPointsOfMeetingList", agendaPointsOfMeetingList);
		List<ApMeetingEmployee> meetingEmployeeList = new ArrayList<ApMeetingEmployee>();

		meetingEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApMeetingEmployee as ama where ama.Meeting.Id='"
						+ id + "'");
		map.put("meetingEmployeeList", meetingEmployeeList);

		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();

		masEmployee = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		map.put("masEmployee", masEmployee);
		return map;

	}

	public Map<String, Object> showMeetingDetailSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<ApMeetingSchedule> apAgendaMeetingList = new ArrayList<ApMeetingSchedule>();
		apAgendaMeetingList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApMeetingSchedule");
		map.put("apAgendameetingList", apAgendaMeetingList);

		List<ApMeetingAgenda> agendaPointsOfMeetingList = new ArrayList<ApMeetingAgenda>();
		agendaPointsOfMeetingList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApMeetingAgenda");
		map.put("agendaPointsOfMeetingList", agendaPointsOfMeetingList);
		List<ApMeetingEmployee> meetingEmployeeList = new ArrayList<ApMeetingEmployee>();

		meetingEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.ApMeetingEmployee");
		map.put("meetingEmployeeList", meetingEmployeeList);

		List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();

		masEmployee = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		map.put("masEmployee", masEmployee);
		return map;

	}

	public Map<String, Object> searchAgendaMeetingDetailSearch(AgendaDTO map) {
		List<ApMeetingSchedule> searchAgendaMeetingDetailsSearchList = new ArrayList<ApMeetingSchedule>();
		Map agendaMeetingDetailSearchFieldsMap = new HashMap();
		DateFormat formatter;
		Date toDate = new Date();
		Date fromDate = null;
		Session session = (Session) getSession();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		if (map.getFromDate() != null) {
			try {
				fromDate = (Date) formatter.parse(map.getFromDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (map.getToDate() != null) {
			try {
				toDate = formatter.parse(map.getToDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		try {
			Criteria crit = session.createCriteria(ApMeetingSchedule.class);

			if (fromDate != null) {
				crit = crit.add(Restrictions.between("ProposedDate", fromDate,
						toDate));
			}

			searchAgendaMeetingDetailsSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		agendaMeetingDetailSearchFieldsMap.put(
				"searchAgendaMeetingDetailsSearchList",
				searchAgendaMeetingDetailsSearchList);
		return agendaMeetingDetailSearchFieldsMap;
	}

	public boolean editMeetingScheduled(Map<String, Object> map) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		ApMeetingSchedule meetingSchedule = (ApMeetingSchedule) map
				.get("apMeetingSchedule");
		Box box = (Box) map.get("box");
		Vector v1 = box.getVector(RequestConstants.EMPLOYEE_ID);
		Vector v2 = box.getVector(RequestConstants.EMPLOYEE_ID2);
		Vector v3 = box.getVector(RequestConstants.DECISION_IN_MEETING);
		Vector v4 = box.getVector(RequestConstants.ACTIONED_BY);
		Vector v5 = box.getVector(RequestConstants.ACTIONED_TO);
		Vector v6 = box.getVector(RequestConstants.AGENDA_POINT_ID);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		boolean successfullyUpdated = false;

		ApMeetingSchedule agendaPointMeetingEdit = (ApMeetingSchedule) getHibernateTemplate()
				.load(ApMeetingSchedule.class, meetingSchedule.getId());
		if (meetingSchedule != null) {
			agendaPointMeetingEdit.setActualChairedBy(meetingSchedule
					.getActualChairedBy());
			agendaPointMeetingEdit.setActualMeetingDate(meetingSchedule
					.getActualMeetingDate());
			agendaPointMeetingEdit.setActualTimeFrom(meetingSchedule
					.getActualTimeFrom());
			agendaPointMeetingEdit.setActualTimeTo(meetingSchedule
					.getActualTimeTo());
			agendaPointMeetingEdit.setLastChgBy(meetingSchedule.getLastChgBy());
			agendaPointMeetingEdit.setLastChgDate(meetingSchedule
					.getLastChgDate());
			agendaPointMeetingEdit.setLastChgTime(meetingSchedule
					.getLastChgTime());
			agendaPointMeetingEdit.setOtherAttendees(meetingSchedule
					.getOtherAttendees());
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(agendaPointMeetingEdit);
			hbt.refresh(agendaPointMeetingEdit);
			successfullyUpdated = true;
		}

		for (int i = 0; i < v1.size(); i++) {
			// updating selected meeting agenda in Agenda Point Request table
			if (!v1.get(i).toString().equalsIgnoreCase("")) {
				ApMeetingEmployee apMeetingEmployee = (ApMeetingEmployee) getHibernateTemplate()
						.load(ApMeetingEmployee.class,
								Integer.parseInt(v1.get(i).toString()));
				apMeetingEmployee.setPresenceStatus("p");
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(apMeetingEmployee);
				hbt.refresh(apMeetingEmployee);
			}
		}
		for (int i = 0; i < v2.size(); i++) {
			ApMeetingEmployee apMeetingEmployee = new ApMeetingEmployee();
			// setting meeting id in the meeting employee to add other attendees
			ApMeetingSchedule meetingScheduleLocal = new ApMeetingSchedule();
			meetingScheduleLocal.setId(meetingSchedule.getId());

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(Integer.parseInt(v2.get(i).toString()));
			apMeetingEmployee.setMeeting(meetingScheduleLocal);
			apMeetingEmployee.setEmp(masEmployee);
			apMeetingEmployee.setPresenceStatus("p");
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(apMeetingEmployee);
			hbt.refresh(apMeetingEmployee);
		}

		for (int i = 0; i < v6.size(); i++) {
			if (!v6.get(i).toString().equalsIgnoreCase("")) {
				ApAgendaRequest agendaPointRequest = (ApAgendaRequest) getHibernateTemplate()
						.load(ApAgendaRequest.class,
								Integer.parseInt(v6.get(i).toString()));
				// agendaPointRequest.setStatus("r");
				agendaPointRequest.setDecisionInMeeting(v3.get(i).toString());
				agendaPointRequest.setActionBy(v4.get(i).toString());
				agendaPointRequest.setActionTo(v5.get(i).toString());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(agendaPointRequest);
				hbt.refresh(agendaPointRequest);
			}
		}

		return successfullyUpdated;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

}