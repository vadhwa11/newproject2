package jkt.hms.workservices.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MajorWorkStatus;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMajorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MajorWorkDetailUpdateDataServiceImpl extends HibernateDaoSupport
		implements MajorWorkDetailUpdateDataService {

	int sId = 0;

	public Map<String, Object> showMajorWorkDetailUpdateJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> pendingScrutinyAtList = new ArrayList<MasEmployee>();

		List<MasMajorWorkDetail> majorWorkDetailList = new ArrayList<MasMajorWorkDetail>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MajorWorkStatus> statusList = new ArrayList<MajorWorkStatus>();

		pendingScrutinyAtList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		String status = "";
		majorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMajorWorkDetail  where Id='"
						+ Id + "'");
		workCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		statusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MajorWorkStatus as ism where ism.Id='"
						+ majorWorkDetailList.get(0).getMajorWorkDetailStatus()
								.getId() + "'");
		status = statusList.get(0).getMajorWorkStatusMessage();
		map.put("workCategoryList", workCategoryList);
		map.put("workTypeList", worktypeList);
		map.put("departmentTypeList", departmentTypeList);

		map.put("status", status);
		map.put("majorWorkDetailList", majorWorkDetailList);
		map.put("pendingScrutinyAtList", pendingScrutinyAtList);

		map.put("Id", Id);
		return map;

	}

	public boolean majorWorkDetailUpdateToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;

		String majorWorkRemarks1 = "";
		int majorWorkStatus1 = 1;
		String majorWorkHroNo1 = "";
		Date hroDate1 = null;
		Date booAssembledOn1 = null;
		Date majorWorkToBeComplete1 = null;
		String majorWorkPressidingOffice1 = "";
		Date majorWorkCompletedOn1 = null;
		String majorWorkBpsSentForAesLetter1 = "";
		Date majorWorkBpsSentFor1 = null;
		Date majorWorkAesReceivedOn1 = null;
		String majorEstimatedCost1 = "";
		double progressPercentage1 = 0.00;
		String majorWorkAdminAproovalNo1 = "";
		Date majorWorkAdminAproovalDate1 = null;
		String majorWorkAdminFwdLetter1 = "";
		Date majorWorkAdminFwdLetterDate1 = null;
		String majorWorkFundReleaseAuth1 = "";
		Date majorWorkFundReleasedOn1 = null;
		int majorWorkWeek1 = 0;
		Date majorWorkPdc1 = null;
		Date majorWorkRevisedPd1 = null;
		String majorWorkTenderActionInHand1 = "";
		Date majorWorkTenderIssuedOn1 = null;
		Date majorWorkTenderComplete1 = null;
		String projectOfficer1 = "";
		Date pendingScrutinyDate = null;
		Date receivedDate = null;
		String pendingScrutinyAt = "";
		String progressRemarks1 = "";
		Date majorWorkCompletionOn1 = null;
		Date majorWorkCommencedOn1 = null;
		int Id = 0;
		Id = (Integer) (generalMap.get("Id"));
		majorWorkRemarks1 = (String) generalMap.get("majorWorkRemarks");
		majorWorkHroNo1 = (String) generalMap.get("majorWorkHroNo");
		hroDate1 = (Date) generalMap.get("hroDate");
		booAssembledOn1 = (Date) generalMap.get("booAssembledOn");
		majorWorkToBeComplete1 = (Date) generalMap.get("majorWorkToBeComplete");
		majorWorkPressidingOffice1 = (String) generalMap
				.get("majorWorkPressidingOffice");
		majorWorkCompletedOn1 = (Date) generalMap.get("majorWorkCompletedOn");
		majorWorkBpsSentForAesLetter1 = (String) generalMap
				.get("majorWorkBpsSentForAesLetter");
		majorWorkBpsSentFor1 = (Date) generalMap.get("majorWorkBpsSentFor");
		majorWorkAesReceivedOn1 = (Date) generalMap
				.get("majorWorkAesReceivedOn");
		majorEstimatedCost1 = (String) (generalMap.get("majorEstimatedCost"));
		progressPercentage1 = (Double) (generalMap.get("progressPercentage"));
		majorWorkAdminAproovalNo1 = (String) generalMap
				.get("majorWorkAdminAproovalNo");
		majorWorkAdminAproovalDate1 = (Date) generalMap
				.get("majorWorkAdminAproovalDate");
		majorWorkAdminFwdLetter1 = (String) generalMap
				.get("majorWorkAdminFwdLetter");
		majorWorkAdminFwdLetterDate1 = (Date) generalMap
				.get("majorWorkAdminFwdLetterDate");
		majorWorkFundReleaseAuth1 = (String) generalMap
				.get("majorWorkFundReleaseAuth");
		majorWorkFundReleasedOn1 = (Date) generalMap
				.get("majorWorkFundReleasedOn");
		majorWorkWeek1 = (Integer) generalMap.get("majorWorkWeek");
		majorWorkPdc1 = (Date) generalMap.get("majorWorkPdc");
		majorWorkRevisedPd1 = (Date) generalMap.get("majorWorkRevisedPd");
		majorWorkTenderActionInHand1 = (String) generalMap
				.get("majorWorkTenderActionInHand");
		majorWorkTenderIssuedOn1 = (Date) generalMap
				.get("majorWorkTenderIssuedOn");
		majorWorkTenderComplete1 = (Date) generalMap
				.get("majorWorkTenderComplete");
		receivedDate = (Date) generalMap.get("receivedDate");
		pendingScrutinyDate = (Date) generalMap.get("pendingScrutinyDate");
		pendingScrutinyAt = (String) generalMap.get("pendingScrutinyAt");

		projectOfficer1 = (String) generalMap.get("projectOfficer");

		progressRemarks1 = (String) generalMap.get("progressRemarks");
		majorWorkCommencedOn1 = (Date) generalMap.get("majorWorkCommencedOn");
		majorWorkCompletionOn1 = (Date) generalMap.get("majorWorkCompletionOn");
		majorWorkStatus1 = Integer.parseInt(generalMap.get("majorWorkStatus")
				.toString());
		int workTypeId = Integer.parseInt(generalMap.get("workTypeId")
				.toString());

		MasMajorWorkDetail masMajorWorkdetail = (MasMajorWorkDetail) getHibernateTemplate()
				.load(MasMajorWorkDetail.class, Id);

		masMajorWorkdetail.setPendingScruitanyAt(pendingScrutinyAt);
		masMajorWorkdetail.setPendingScrutanyDate(pendingScrutinyDate);
		masMajorWorkdetail.setReceivedDate(receivedDate);
		masMajorWorkdetail.setMajorWorkDetail(majorWorkRemarks1);
		masMajorWorkdetail.setMajorWorkHroNo(majorWorkHroNo1);
		masMajorWorkdetail.setMajorWorkHroDate(hroDate1);
		masMajorWorkdetail.setMajorWorkBooAssembledOn(booAssembledOn1);
		masMajorWorkdetail.setMajorWorkToBeComplete(majorWorkToBeComplete1);
		masMajorWorkdetail
				.setMajorWorkPresidingOffice(majorWorkPressidingOffice1);
		masMajorWorkdetail.setMajorWorkCompletedOn(majorWorkCompletedOn1);
		masMajorWorkdetail
				.setMajorWorkBpsSentforAesLetter(majorWorkBpsSentForAesLetter1);
		masMajorWorkdetail.setMajorWorkBpsSentfor(majorWorkBpsSentFor1);
		masMajorWorkdetail.setMajorWorkAesReceiveOn(majorWorkAesReceivedOn1);
		masMajorWorkdetail.setMajorWorkEstimatedCost(majorEstimatedCost1);
		masMajorWorkdetail
				.setMajorWorkAdminApprovalNo(majorWorkAdminAproovalNo1);
		masMajorWorkdetail
				.setMajorWorkAdminApprovalDate(majorWorkAdminAproovalDate1);
		masMajorWorkdetail
				.setMajorWorkAdminApprovalFwdLetter(majorWorkAdminFwdLetter1);
		masMajorWorkdetail
				.setMajorWorkAdminApprovalFwdDate(majorWorkAdminFwdLetterDate1);
		masMajorWorkdetail
				.setMajorWorkFundRealeseAuth(majorWorkFundReleaseAuth1);
		masMajorWorkdetail.setMajorWorkFundRealesedOn(majorWorkFundReleasedOn1);
		masMajorWorkdetail.setMajorWorkWeek(majorWorkWeek1);
		masMajorWorkdetail.setMajorWorkPdc(majorWorkPdc1);
		masMajorWorkdetail.setMajorWorkRevisedPd(majorWorkRevisedPd1);
		masMajorWorkdetail
				.setMajorWorkTenderActionInhand(majorWorkTenderActionInHand1);
		masMajorWorkdetail.setMajorWorkTenderIssuedOn(majorWorkTenderIssuedOn1);
		masMajorWorkdetail
				.setMajorWorkTenderCompletedDate(majorWorkTenderComplete1);
		masMajorWorkdetail.setMajorWorkProjectOfficer(projectOfficer1);
		masMajorWorkdetail.setMajorWorkProgressPercentage(new BigDecimal(
				progressPercentage1));
		masMajorWorkdetail.setMajorWorkProgressRemarks(progressRemarks1);
		masMajorWorkdetail.setMajorWorkCommencedOn(majorWorkCommencedOn1);
		masMajorWorkdetail.setMajorWorkCompletionOn(majorWorkCompletionOn1);
		MasWorkType masWorkType = new MasWorkType();
		masWorkType.setId(workTypeId);
		masMajorWorkdetail.setWorkType(masWorkType);
		MajorWorkStatus majorWorkStatus = new MajorWorkStatus();
		majorWorkStatus.setId(majorWorkStatus1);
		masMajorWorkdetail.setMajorWorkDetailStatus(majorWorkStatus);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMajorWorkdetail);
		hbt.refresh(masMajorWorkdetail);
		dataUpdated = true;
		return dataUpdated;

	}

}
