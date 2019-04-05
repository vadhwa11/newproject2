package jkt.hms.workservices.dataservice;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ApprovalOfMinorWorkDetailDataServiceImpl extends
		HibernateDaoSupport implements ApprovalOfMinorWorkDetailDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showApprovalOfMinorWorkDetailJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeDesignationList = new ArrayList<MasEmployee>();
		List<MasMinorWorkDetail> updateList = new ArrayList<MasMinorWorkDetail>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();

		List<MasAllotmentOfFundsForMinorWorks> allotmentList = new ArrayList<MasAllotmentOfFundsForMinorWorks>();
		allotmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks");
		map.put("allotmentList", allotmentList);

		minorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail");

		updateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail as mwd where mwd.Id ='"
						+ Id + "'");
		employeeDesignationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");

		map.put("masEmployee", employeeDesignationList);
		map.put("minorWorkDetailList", minorWorkDetailList);

		map.put("minorWorkDetailUpdateList", updateList);
		return map;
	}

	public boolean editApprovalOfMinorWorkDetailToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		int approvalOfMinorWorkDetailId = 0;

		String adminApprovalName = "";
		String adminApprovalDate = "";
		String adminApprovalTime = "";
		String pdc = "";
		String estimatedDate = "";
		String remark = "";

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		approvalOfMinorWorkDetailId = (Integer) generalMap.get("id");
		adminApprovalName = (String) generalMap.get("adminApprovalName");
		adminApprovalDate = (String) generalMap.get("adminApprovalDate");
		adminApprovalTime = (String) generalMap.get("adminApprovalTime");
		pdc = (String) generalMap.get("pdc");
		estimatedDate = (String) generalMap.get("estimatedDate");
		remark = (String) generalMap.get("remark");
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date myDate = null;
		try {
			myDate = myDateFormat.parse(adminApprovalDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date myEstimatedDate = null;
		try {
			myEstimatedDate = myDateFormat.parse(estimatedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MasMinorWorkDetail masApprovalOfMinorWorkDetail = (MasMinorWorkDetail) getHibernateTemplate()
				.load(MasMinorWorkDetail.class, approvalOfMinorWorkDetailId);
		masApprovalOfMinorWorkDetail.setId((approvalOfMinorWorkDetailId));

		masApprovalOfMinorWorkDetail.setAdminApprovalNo(adminApprovalName);
		masApprovalOfMinorWorkDetail.setAdminApprovalDate(myDate);
		masApprovalOfMinorWorkDetail.setAdminApprovalTime(adminApprovalTime);
		masApprovalOfMinorWorkDetail.setPdc(Integer.parseInt(pdc));
		masApprovalOfMinorWorkDetail.setEstimatedDate(myEstimatedDate);
		masApprovalOfMinorWorkDetail.setMinorWorkDetailRemarks(remark);

		masApprovalOfMinorWorkDetail.setBalance(Integer.parseInt(generalMap
				.get("totalBalance").toString()));
		masApprovalOfMinorWorkDetail.setStatus("a");
		masApprovalOfMinorWorkDetail.setLastChgBy(changedBy);
		masApprovalOfMinorWorkDetail.setLastChgDate(currentDate);
		masApprovalOfMinorWorkDetail.setLastChgTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(masApprovalOfMinorWorkDetail);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}
}
