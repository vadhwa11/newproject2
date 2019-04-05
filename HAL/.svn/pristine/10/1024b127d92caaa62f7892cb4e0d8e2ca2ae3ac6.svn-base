package jkt.hms.workservices.dataservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.business.ProposalDepartment;
import jkt.hms.util.HMSUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkDetailsUpdateDataServiceImpl extends HibernateDaoSupport
		implements MinorWorkDetailsUpdateDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMinorWorkDetailsUpdateJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList2 = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList2 = new ArrayList<MasWorkType>();
		List<MasMinorWorkDetail> updateList2 = new ArrayList<MasMinorWorkDetail>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<ProposalDepartment> searchDetailDeptList = new ArrayList<ProposalDepartment>();

		workCategoryList2 = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList2 = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		updateList2 = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail as mwd where mwd.Id ='"
						+ Id + "'");
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		if (Id != 0) {
			searchDetailDeptList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.ProposalDepartment as imc where imc.ProposalType='"
									+ Id + "'");
		}
		map.put("searchProposalDeptList", searchDetailDeptList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("workCategoryList", workCategoryList2);
		map.put("workTypeList", worktypeList2);
		map.put("minorWorkDetailUpdateList", updateList2);
		return map;
	}

	public boolean editMinorWorkDetailsUpdateToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		int minorWorkDetailsUpdateId = 0;
		String financialYear = "";
		String minorWorkNo = "";
		Date minorWorkDate = null;
		String minorWorkTime = "";
		String workCategory = "";
		String workType = "";
		String detailsOfWork = "";
		String estimatedCost = "";
		String remark = "";
		Date dateOfCostingReceived = null;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		MasWorkCategory masWorkCategory = new MasWorkCategory();
		MasWorkType masWorkType = new MasWorkType();

		minorWorkDetailsUpdateId = (Integer) generalMap.get("id");
		financialYear = (String) generalMap.get("financialYear");
		minorWorkNo = (String) generalMap.get("minorWorkNo");
		minorWorkDate = HMSUtil.convertStringTypeDateToDateType(generalMap.get(
				"minorWorkDate").toString());
		if (!generalMap.get("dateOfCostingReceived").toString().trim()
				.endsWith(""))
			dateOfCostingReceived = HMSUtil
					.convertStringTypeDateToDateType(generalMap.get(
							"dateOfCostingReceived").toString());
		minorWorkTime = (String) generalMap.get("minorWorkTime");
		workCategory = (String) generalMap.get("workCategory");
		workType = (String) generalMap.get("workType");
		detailsOfWork = (String) generalMap.get("detailsOfWork");
		estimatedCost = (String) generalMap.get("estimatedCost");
		remark = (String) generalMap.get("remark");
		changedBy = (String) generalMap.get("changedBy");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DateFormat myDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date myDate = null;

		MasMinorWorkDetail masMinorWorkDetailsUpdate = (MasMinorWorkDetail) getHibernateTemplate()
				.load(MasMinorWorkDetail.class, minorWorkDetailsUpdateId);
		masMinorWorkDetailsUpdate.setId((minorWorkDetailsUpdateId));
		masMinorWorkDetailsUpdate.setFinancialYear(financialYear);
		masMinorWorkDetailsUpdate.setMinorWorkDetailNo(minorWorkNo);
		masMinorWorkDetailsUpdate
				.setDateOfCostingReceived(dateOfCostingReceived);
		masMinorWorkDetailsUpdate.setMinorWorkDetailDate(minorWorkDate);
		masMinorWorkDetailsUpdate.setMinorWorkDetailTime(minorWorkTime);

		masMinorWorkDetailsUpdate.setWorkCategoryId(workCategory);

		masWorkType.setId(Integer.parseInt(workType));
		masMinorWorkDetailsUpdate.setWorkType(masWorkType);

		masMinorWorkDetailsUpdate.setMinorWorkDetail(detailsOfWork);
		masMinorWorkDetailsUpdate
				.setMinorWorkDetailEstimatedCost(estimatedCost);
		masMinorWorkDetailsUpdate.setMinorWorkDetailRemarks(remark);

		masMinorWorkDetailsUpdate.setLastChgBy(changedBy);
		masMinorWorkDetailsUpdate.setLastChgDate(currentDate);
		masMinorWorkDetailsUpdate.setLastChgTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(true);
		hbt.update(masMinorWorkDetailsUpdate);
		hbt.refresh(masMinorWorkDetailsUpdate);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteMinorWorkDetailsUpdate(int minorWorkDetailId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMinorWorkDetail masMinorWorkDetailsUpdate = new MasMinorWorkDetail();
		masMinorWorkDetailsUpdate = (MasMinorWorkDetail) getHibernateTemplate()
				.load(MasMinorWorkDetail.class, minorWorkDetailId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		masMinorWorkDetailsUpdate.setStatus("c");
		masMinorWorkDetailsUpdate.setLastChgBy(changedBy);
		masMinorWorkDetailsUpdate.setLastChgDate(currentDate);
		masMinorWorkDetailsUpdate.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMinorWorkDetailsUpdate);
		dataDeleted = true;
		return dataDeleted;
	}

}
