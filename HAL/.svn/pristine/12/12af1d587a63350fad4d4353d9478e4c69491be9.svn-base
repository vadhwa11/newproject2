package jkt.hms.agendapoints.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAgendaPointForWorkServices;
import jkt.hms.masters.business.MasDepartment;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UpdateAgendaPointsDataServiceImpl extends HibernateDaoSupport
		implements UpdateAgendaPointsDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUpdateAgendaPointsForWorkServicesJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasAgendaPointForWorkServices> agendaList = new ArrayList<MasAgendaPointForWorkServices>();
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");

		agendaList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasAgendaPointForWorkServices as mwd where mwd.Id ='"
								+ Id + "'");
		map.put("departmentList", departmentList);
		map.put("agendaList", agendaList);
		return map;
	}

	public boolean editUpdateAgendaPointsForWorkServicesToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		int updateAgendaPointsForWorkServicesId = 0;

		String departmentName = "";
		Date agendaDate = null;
		String agendaTime = "";
		String agendaType = "";
		String agendaPlace = "";
		String startingTime = "";
		String endingTime = "";
		String agendaSummary = "";

		String agendaSummaryUpload = "";

		Map<String, Object> map = new HashMap<String, Object>();
		String changed_by = "";
		String agendaNo = "";
		String resoursePath = "";
		agendaNo = (String) generalMap.get("agendaNo");
		agendaDate = (Date) generalMap.get("agendaDate");
		agendaTime = (String) generalMap.get("agendaTime");
		agendaType = (String) generalMap.get("agendaType");
		agendaPlace = (String) generalMap.get("agendaPlace");
		startingTime = (String) generalMap.get("startingTime");
		endingTime = (String) generalMap.get("endingTime");
		agendaSummary = (String) generalMap.get("agendaSummary");
		changed_by = (String) generalMap.get("changed_by");
		departmentName = (String) generalMap.get("departmentName");
		// flag = generalMap.get("flag");
		agendaSummaryUpload = (String) generalMap.get("agendaSummaryUpload");
		agendaSummary = (String) generalMap.get("agendaSummary");

		resoursePath = (String) generalMap.get("resoursePath");
		updateAgendaPointsForWorkServicesId = (Integer) generalMap.get("id");

		MasAgendaPointForWorkServices masUpdateAgendaPointsForWorkServices = (MasAgendaPointForWorkServices) getHibernateTemplate()
				.load(MasAgendaPointForWorkServices.class,
						updateAgendaPointsForWorkServicesId);
		masUpdateAgendaPointsForWorkServices
				.setId((updateAgendaPointsForWorkServicesId));
		masUpdateAgendaPointsForWorkServices.setAgendaNo(agendaNo);
		masUpdateAgendaPointsForWorkServices.setAgendaDate(agendaDate);
		masUpdateAgendaPointsForWorkServices.setAgendaTime(agendaTime);
		masUpdateAgendaPointsForWorkServices.setAgendaType(agendaType);
		masUpdateAgendaPointsForWorkServices.setAgendaPlace(agendaPlace);

		masUpdateAgendaPointsForWorkServices.setLstChgBy(changed_by);

		masUpdateAgendaPointsForWorkServices.setDepartmentName(departmentName);

		masUpdateAgendaPointsForWorkServices.setStartingTime(startingTime);
		masUpdateAgendaPointsForWorkServices.setEndingTime(endingTime);
		masUpdateAgendaPointsForWorkServices.setAgendaSummary(agendaSummary);

		masUpdateAgendaPointsForWorkServices.setResoursePath(resoursePath);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(masUpdateAgendaPointsForWorkServices);
		dataUpdated = true;
		return dataUpdated;
	}

}
