package jkt.hms.leave.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jkt.hms.util.HMSUtil;
import jkt.hms.masters.business.HrMasLeaveTypeMediator;
import jkt.hms.masters.business.HrMasLeaveTypeNew;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MonthlyLeaveSchedulerDataService extends HibernateDaoSupport{

	@SuppressWarnings("unchecked")
	public List<HrMasLeaveTypeMediator> getMediatorList()
	{
		Session session = getSession();
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();
		List<HrMasLeaveTypeNew> hrMasLeaveTypeNewList = new ArrayList<HrMasLeaveTypeNew>();
		hrMasLeaveTypeMediatorList = session.createCriteria(HrMasLeaveTypeMediator.class).list();
		
		String now = HMSUtil.getDateFormat(new Date(), "yyyy-MM-dd");
		hrMasLeaveTypeNewList = session.createCriteria(HrMasLeaveTypeNew.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("FromDate",new Date())).list();
		System.out.println();
		return hrMasLeaveTypeMediatorList;
	}
	
}
