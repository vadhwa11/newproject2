package jkt.hms.monitoring.dataservice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.util.HMSUtil;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MonitoringDataServiceImpl extends HibernateDaoSupport implements MonitoringDataService {
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getHealthMonitoringDetails(int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		try {
			
			CallableStatement cals = con.prepareCall("{call health_monitoring_airhq(?)}");
			cals.setInt(1, userId);
			cals.execute();
			cals.close();
			con.close();			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from airhq_monitoring_details where user_id="+userId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
			map.put("commandList", commandList);
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
			
			
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getMedExamBoardMonitoringDetails(Integer userId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {			
			CallableStatement cals = con.prepareCall("{call exam_board_monitoring_airhq(?)}");
			cals.setInt(1, userId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from airhq_monitoring_details where user_id="+userId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
			map.put("commandList", commandList);
			
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getAvMedicineMonitoringDetails(Integer id) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call aviation_monitoring_airhq(?)}");
			cals.setInt(1, id);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from airhq_monitoring_details where user_id="+id;
			monitoringDetails = session.createSQLQuery(qry).list(); 			
			map.put("monitoringDetails", monitoringDetails);			
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
			map.put("commandList", commandList);
			
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getCmdHealthMonitoringDetails(int userId,int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {			
			CallableStatement cals = con.prepareCall("{call health_monitoring_command(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 			
			map.put("monitoringDetails", monitoringDetails);			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			if(hospitalList.size()>0)
			{
				String commandName=hospitalList.get(0).getCommand().getCommandName();
				map.put("commandName", commandName);
			}
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getCmdMedExamBoardDetails(int userId,
			int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call exam_board_monitoring_command(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			String cmdName="";
			if(hospitalList.size()>0)
			{
				cmdName =hospitalList.get(0).getCommand().getCommandName();
				map.put("cmdName", cmdName);
			}
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getCmdAviMonitoringJsp(int userId, int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call aviation_monitoring_command(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getSmcHealthMonitoringDetails(int userId,int hospitalId,int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call health_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			

			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
			}
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Map<String, Object> getSmcMedExamBoardDetails(int userId,int hospitalId,int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {

			
			CallableStatement cals = con.prepareCall("{call exam_board_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			

			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
			}
			
			
			/*CallableStatement cals = con.prepareCall("{call exam_board_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			*/
			
	
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Map<String, Object> getSmcAviationDetails(int userId, int hospitalId, int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call aviation_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
					
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
			}
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Map<String, Object> getAirHqFWCDetails(Integer id) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call fwc_monitoring_airhq(?)}");
			cals.setInt(1, id);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from airhq_monitoring_details where user_id="+id;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
			map.put("commandList", commandList);
			

			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Map<String, Object> getCmdFWCDetails(int userId, int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call fwc_monitoring_command(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			
			if(hospitalList.size()>0)
			{
				String commandName=hospitalList.get(0).getCommand().getCommandName();
				map.put("commandName", commandName);
			}
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Map<String, Object> getSMCFWCDetails(int userId, int hospitalId,int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call fwc_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
					
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
			}
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@Override
	public Map<String, Object> showStatsMonitoringJsp(Integer id) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call stats_monitoring_airhq(?)}");
			cals.setInt(1, id);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from airhq_monitoring_details where user_id="+id;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
			map.put("commandList", commandList);
			

			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	
	}

	@Override
	public Map<String, Object> getCmdStatsDetails(int userId, int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call stats_monitoring_command(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				int cId = hospitalList.get(0).getCommand().getId();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
				map.put("cId", cId);
			}
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@Override
	public Map<String, Object> getSmcStatsDetails(int userId, int hospitalId,int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call stats_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
					
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
				int cId = hospitalList.get(0).getCommand().getId();
				map.put("cId", cId);
			}
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}

	@Override
	public Map<String, Object> showCivilAviationPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showMedLecturePop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showPreFlightMedCheckUpPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}


	public Map<String, Object> showServiceDetails(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsAdmission(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsAirCraft(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsAdmissionH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsAirCraftH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsAdmissionS(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
		}

	@Override
	public Map<String, Object> showServiceDetailsAirCraftS(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsS(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;}

	@Override
	public Map<String, Object> showServiceDetailsMB(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Category> CategoryList = null;
		List<MasRank> rankList = null;
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		map.put("rankList", rankList);
		map.put("CategoryList", CategoryList);
		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsME(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Category> CategoryList = null;
		List<MasRank> rankList = null;
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		map.put("rankList", rankList);
		map.put("CategoryList", CategoryList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMbPend(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<MasUnit> unitList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMePend(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<MasUnit> unitList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMBH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Category> CategoryList = null;
		List<MasRank> rankList = null;
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		map.put("rankList", rankList);
		map.put("CategoryList", CategoryList);
		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMEH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Category> CategoryList = null;
		List<MasRank> rankList = null;
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		map.put("rankList", rankList);
		map.put("CategoryList", CategoryList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMbPendH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<MasUnit> unitList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMePendH(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<MasUnit> unitList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMBS(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Category> CategoryList = null;
		List<MasRank> rankList = null;
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		map.put("rankList", rankList);
		map.put("CategoryList", CategoryList);
		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMES(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Category> CategoryList = null;
		List<MasRank> rankList = null;
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		map.put("rankList", rankList);
		map.put("CategoryList", CategoryList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMbPendS(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<MasUnit> unitList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showServiceDetailsMePendS(Map<String, Object> map) {
		Session session = (Session)getSession();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRank> rankList = null;
		List<MasUnit> unitList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}
	
	
	
	@Override
	public Map<String, Object> showCivilAviationPopH(int cmdId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showMedLecturePopH(int cmdId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showPreFlightMedCheckUpPopH(int cmdId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}
	@Override
	public Map<String, Object> showCivilAviationPopCH(int cmdId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showMedLecturePopCH(int cmdId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showPreFlightMedCheckUpPopCH(int cmdId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showSilDilPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showDeficientPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		map.put("rankList", rankList);
		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("tradeList", tradeList);
	
		return map;
	}

	@Override
	public Map<String, Object> showEdReturnsPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		map.put("rankCategoryList", rankCategoryList);
		return map;
	}

	@Override
	public Map<String, Object> showMonthlySickDetailsPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		map.put("rankCategoryList", rankCategoryList);
		
		return map;
	}

	@Override
	public Map<String, Object> showSurplusPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		
		
		
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		map.put("rankList", rankList);
		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("tradeList", tradeList);
		return map;
	}

	@Override
	public Map<String, Object> showDeficientPopH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
	
	
		
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		map.put("rankList", rankList);
		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("tradeList", tradeList);
		return map;
	}

	@Override
	public Map<String, Object> showEdReturnsPopH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		map.put("rankCategoryList", rankCategoryList);
		return map;
	}

	@Override
	public Map<String, Object> showMonthlySickDetailsPopH(int cmdId,int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
	
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		map.put("rankCategoryList", rankCategoryList);
		return map;
	}

	@Override
	public Map<String, Object> showSilDilPopH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	
	}

	@Override
	public Map<String, Object> showSurplusPopH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
	
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		map.put("rankList", rankList);
		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("tradeList", tradeList);
		return map;
	}
	
	@Override
	public Map<String, Object> showDeficientPopCH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
	
	
		
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		map.put("rankList", rankList);
		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("tradeList", tradeList);
		return map;
	}

	@Override
	public Map<String, Object> showEdReturnsPopCH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		map.put("rankCategoryList", rankCategoryList);
		return map;
	}

	@Override
	public Map<String, Object> showMonthlySickDetailsPopCH(int cmdId,int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
	
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		rankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		map.put("rankCategoryList", rankCategoryList);
		return map;
	}

	@Override
	public Map<String, Object> showSilDilPopCH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	
	}

	@Override
	public Map<String, Object> showSurplusPopCH(int cmdId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
	
		List<MasRank> rankList = new ArrayList<MasRank>();
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		map.put("rankList", rankList);
		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("tradeList", tradeList);
		return map;
	}

	@Override
	public Map<String, Object> showAncVisitPop(int cmdId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
				
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	@Override
	public Map<String, Object> showPncVisitPop(int cmdId) {		
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	
	List<MasServiceType> serviceTypeList = null;
	List<MasServiceStatus> serviceStatusList = null;
	List<MasRankCategory> rankCategoryList = null;
	List<MasTrade> tradeList = null;
	List<MasAdministrativeSex> sexList = null;
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	
	serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
	serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
	rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
	tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
	sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
	hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

	
	map.put("serviceTypeList", serviceTypeList);
	map.put("serviceStatusList", serviceStatusList);
	map.put("rankCategoryList", rankCategoryList);
	map.put("tradeList", tradeList);
	map.put("sexList", sexList);
	map.put("hospitalList", hospitalList);
	
	return map;}

	@Override
	public Map<String, Object> showAncVisitPopCH(int cmdId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();

		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
	
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showAncVisitPopH(int cmdId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
	
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
	
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showPncVisitPopCH(int cmdId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();

		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
	
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showPncVisitPopH(int cmdId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<MasTrade> tradeList = null;
		List<MasAdministrativeSex> sexList = null;
	
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showAttemptSuicideCasesPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showAttemptSuicideCasesPopCH(int cmdId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showAttemptSuicideCasesPopH(int cmdId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showMonthlyMalariaCasePop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showMonthlyMalariaCasePopCH(int cmdId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showMonthlyMalariaCasePopH(int cmdId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showNotifiableDiseasePop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showNotifiableDiseasePopCH(int cmdId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showNotifiableDiseasePopH(int cmdId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showRtaPop(int cmdId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();
		map.put("hospitalList", hospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showRtaPopCH(int cmdId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}

	@Override
	public Map<String, Object> showRtaPopH(int cmdId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).add(Restrictions.eq("Id", hospitalId)).list();
		map.put("hospitalList", hospitalList);
		if(hospitalList.size()>0)
		{
			String commandName = hospitalList.get(0).getCommand().getCommandName();
			String hospitalName = hospitalList.get(0).getHospitalName();
			map.put("commandName", commandName);
			map.put("hospitalName", hospitalName);
		}
		return map;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Map<String, Object> getShoSmcMonitoringJsp(int userId, int hospitalId, int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call sho_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			

			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
			}
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;}




	@Override
	public Map<String, Object> showDefectiveDrugPendS(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}


	@Override
	public Map<String, Object> showPerformaBPendS(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}

	


	
	//-----------
	
	public Map<String, Object> getAirHqStoregDetails(Integer userId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		List<Object[]> budgetList = new ArrayList<Object[]>();
		try {
			
			CallableStatement cals = con.prepareCall("{call med_store_monitoring_airhq(?)}");
			cals.setInt(1, userId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from airhq_monitoring_details where user_id="+userId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
			map.put("commandList", commandList);
			
			budgetList = session.createCriteria(MasStoreBudget.class).createAlias("Hospital", "hosp").setProjection(Projections.projectionList().add(Projections.sum("TotalAllocatedAmount")).add(Projections.sum("BalanceAmount")).add(Projections.groupProperty("hosp.Command.Id"))).list();
			map.put("budgetList", budgetList);
			
			
			
		
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	
	}




public Map<String, Object> getCmdStoreMonitoringJsp(int userId,int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		List<Object[]> budgetList = new ArrayList<Object[]>();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call med_store_monitoring_command(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, commandId);
			cals.execute();
			cals.close();
			con.close();			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
			monitoringDetails = session.createSQLQuery(qry).list(); 			
			map.put("monitoringDetails", monitoringDetails);			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
			
			
			
			if(hospitalList.size()>0)
			{
				String commandName=hospitalList.get(0).getCommand().getCommandName();
				map.put("commandName", commandName);
			}
			
			
			if(hospitalList.size()>0)
			{
				String commandName=hospitalList.get(0).getCommand().getCommandName();
				map.put("commandName", commandName);
			}
			
			
			budgetList = session.createCriteria(MasStoreBudget.class).createAlias("Hospital", "hosp").add(Restrictions.eq("hosp.Command.Id", commandId)).setProjection(Projections.projectionList()
					.add(Projections.sum("TotalAllocatedAmount")).add(Projections.sum("BalanceAmount")).add(Projections.groupProperty("hosp.Id"))).list();
			map.put("budgetList", budgetList);
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}



public Map<String, Object> getSMCStoreDetails(int userId, int hospitalId, int commandId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		List<Object[]> budgetList = new ArrayList<Object[]>();
		
		try {
			
			CallableStatement cals = con.prepareCall("{call med_store_monitoring_smc(?,?)}");
			cals.setInt(1, userId);
			cals.setInt(2, hospitalId);
			cals.execute();
			cals.close();
			con.close();
			
			List<Object[]> monitoringDetails = new ArrayList<Object[]>();
			String qry ="select * from command_monitoring_details where user_id="+userId+" and hospital_id="+hospitalId;
			monitoringDetails = session.createSQLQuery(qry).list(); 
			
			map.put("monitoringDetails", monitoringDetails);
			budgetList = session.createCriteria(MasStoreBudget.class).createAlias("Hospital", "hosp").add(Restrictions.eq("hosp.Id", hospitalId)).setProjection(Projections.projectionList().add(Projections.sum("TotalAllocatedAmount")).add(Projections.sum("BalanceAmount"))).list();
			map.put("budgetList", budgetList);
			
			
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
			map.put("hospitalList", hospitalList);
					
			if(hospitalList.size()>0)
			{
				String commandName = hospitalList.get(0).getCommand().getCommandName();
				String hospitalName = hospitalList.get(0).getHospitalName();
				map.put("commandName", commandName);
				map.put("hospitalName", hospitalName);
			}
			
			
			int year=0;
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
				
			String yfDate="01/01/"+year;
			String ytDate="31/12/"+year;
			
			String jfDate="01/01/"+year;
			String jtDate="31/01/"+year;
			
			String ffDate="01/02/"+year;
			String ftDate="";
			if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			{
				ftDate="29/02/"+year;
			}
			else
			{
				ftDate="28/02/"+year;
			}
			
			
			String mfDate="01/03/"+year;
			String mtDate="31/03/"+year;
			
			String afDate="01/04/"+year;
			String atDate="30/04/"+year;
			
			String mafDate="01/05/"+year;
			String matDate="31/05/"+year;
			
			String jufDate="01/06/"+year;
			String jutDate="30/06/"+year;
			
			String jyfDate="01/07/"+year;
			String jytDate="31/07/"+year;
			
			String aufDate="01/08/"+year;
			String autDate="31/08/"+year;
			
			String sfDate="01/09/"+year;
			String stDate="30/09/"+year;
			
			String ofDate="01/10/"+year;
			String otDate="31/10/"+year;
			
			String nfDate="01/11/"+year;
			String ntDate="30/11/"+year;
			
			
			String dfDate="01/12/"+year;
			String dtDate="31/12/"+year;
			
		
			map.put("yfDate",yfDate);
			map.put("ytDate",ytDate);
			map.put("jfDate",jfDate);
			map.put("jtDate",jtDate);
			map.put("ffDate",ffDate);
			map.put("ftDate",ftDate);
			map.put("mfDate",mfDate);
			map.put("mtDate",mtDate);
			map.put("afDate",afDate);
			map.put("atDate",atDate);
			map.put("mafDate",mafDate);
			map.put("matDate",matDate);
			map.put("jufDate",jufDate);
			map.put("jutDate",jutDate);
			map.put("jyfDate",jyfDate);
			map.put("jytDate",jytDate);
			map.put("aufDate",aufDate);
			map.put("autDate",autDate);
			map.put("sfDate",sfDate);
			map.put("stDate",stDate);
			map.put("ofDate",ofDate);
			map.put("otDate",otDate);
			map.put("nfDate",nfDate);
			map.put("ntDate",ntDate);
			map.put("dfDate",dfDate);
			map.put("dtDate",dtDate);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
		
	}


public Map<String, Object> showPerformaB(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}

public Map<String, Object> showPerformaBPend(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}


	public Map<String, Object> showDefectiveDrug(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}


	
public Map<String, Object> showPerformaBH(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}



public Map<String, Object> showPerformaBPendH(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}



	@Override
	public Map<String, Object> showDefectiveDrugH(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}



	@Override
	public Map<String, Object> showPerformaBS(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}




	@Override
	public Map<String, Object> showDefectiveDrugS(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}





public Map<String, Object> showDefectiveDrugPendH(Map<String, Object> map) {
		Session session = (Session)getSession();
		
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		int cmdId=0;
		if(map.get("cmdId")!=null)
		{
			cmdId = (Integer)(map.get("cmdId"));	
		}
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", cmdId)).list();

		
		map.put("hospitalList", hospitalList);
		
		return map;
	}

@Override
public Map<String, Object> getShoMonitoringCmdJsp(int userId, int commandId) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	Connection con = session.connection();
	
	try {			
		CallableStatement cals = con.prepareCall("{call sho_monitoring_command(?,?)}");
		cals.setInt(1, userId);
		cals.setInt(2, commandId);
		cals.execute();
		cals.close();
		con.close();
		
		List<Object[]> monitoringDetails = new ArrayList<Object[]>();
		String qry ="select * from command_monitoring_details where user_id="+userId+" and command_id="+commandId;
		monitoringDetails = session.createSQLQuery(qry).list(); 			
		map.put("monitoringDetails", monitoringDetails);			
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Command.Id", commandId)).list();
		map.put("hospitalList", hospitalList);
		
		if(hospitalList.size()>0)
		{
			String commandName=hospitalList.get(0).getCommand().getCommandName();
			map.put("commandName", commandName);
		}
		
		
		int year=0;
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
			
		String yfDate="01/01/"+year;
		String ytDate="31/12/"+year;
		
		String jfDate="01/01/"+year;
		String jtDate="31/01/"+year;
		
		String ffDate="01/02/"+year;
		String ftDate="";
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
		{
			ftDate="29/02/"+year;
		}
		else
		{
			ftDate="28/02/"+year;
		}
		
		
		String mfDate="01/03/"+year;
		String mtDate="31/03/"+year;
		
		String afDate="01/04/"+year;
		String atDate="30/04/"+year;
		
		String mafDate="01/05/"+year;
		String matDate="31/05/"+year;
		
		String jufDate="01/06/"+year;
		String jutDate="30/06/"+year;
		
		String jyfDate="01/07/"+year;
		String jytDate="31/07/"+year;
		
		String aufDate="01/08/"+year;
		String autDate="31/08/"+year;
		
		String sfDate="01/09/"+year;
		String stDate="30/09/"+year;
		
		String ofDate="01/10/"+year;
		String otDate="31/10/"+year;
		
		String nfDate="01/11/"+year;
		String ntDate="30/11/"+year;
		
		
		String dfDate="01/12/"+year;
		String dtDate="31/12/"+year;
		
	
		map.put("yfDate",yfDate);
		map.put("ytDate",ytDate);
		map.put("jfDate",jfDate);
		map.put("jtDate",jtDate);
		map.put("ffDate",ffDate);
		map.put("ftDate",ftDate);
		map.put("mfDate",mfDate);
		map.put("mtDate",mtDate);
		map.put("afDate",afDate);
		map.put("atDate",atDate);
		map.put("mafDate",mafDate);
		map.put("matDate",matDate);
		map.put("jufDate",jufDate);
		map.put("jutDate",jutDate);
		map.put("jyfDate",jyfDate);
		map.put("jytDate",jytDate);
		map.put("aufDate",aufDate);
		map.put("autDate",autDate);
		map.put("sfDate",sfDate);
		map.put("stDate",stDate);
		map.put("ofDate",ofDate);
		map.put("otDate",otDate);
		map.put("nfDate",nfDate);
		map.put("ntDate",ntDate);
		map.put("dfDate",dfDate);
		map.put("dtDate",dtDate);
		
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (RuntimeException e) {
		e.printStackTrace();
	}
	return map;}

@Override
public Map<String, Object> getShoMonitoringJsp(int userId) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	Connection con = session.connection();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	try {
		
		CallableStatement cals = con.prepareCall("{call sho_monitoring_airhq(?)}");
		cals.setInt(1, userId);
		cals.execute();
		cals.close();
		con.close();			
		List<Object[]> monitoringDetails = new ArrayList<Object[]>();
		String qry ="select * from airhq_monitoring_details where user_id="+userId;
		monitoringDetails = session.createSQLQuery(qry).list(); 
		
		map.put("monitoringDetails", monitoringDetails);
		
		List<MasCommand> commandList = new ArrayList<MasCommand>();
		commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
		map.put("commandList", commandList);
		
		
		int year=0;
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
			
		String yfDate="01/01/"+year;
		String ytDate="31/12/"+year;
		
		String jfDate="01/01/"+year;
		String jtDate="31/01/"+year;
		
		String ffDate="01/02/"+year;
		String ftDate="";
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
		{
			ftDate="29/02/"+year;
		}
		else
		{
			ftDate="28/02/"+year;
		}
		
		String mfDate="01/03/"+year;
		String mtDate="31/03/"+year;
		
		String afDate="01/04/"+year;
		String atDate="30/04/"+year;
		
		String mafDate="01/05/"+year;
		String matDate="31/05/"+year;
		
		String jufDate="01/06/"+year;
		String jutDate="30/06/"+year;
		
		String jyfDate="01/07/"+year;
		String jytDate="31/07/"+year;
		
		String aufDate="01/08/"+year;
		String autDate="31/08/"+year;
		
		String sfDate="01/09/"+year;
		String stDate="30/09/"+year;
		
		String ofDate="01/10/"+year;
		String otDate="31/10/"+year;
		
		String nfDate="01/11/"+year;
		String ntDate="30/11/"+year;
		
		
		String dfDate="01/12/"+year;
		String dtDate="31/12/"+year;
		
	
		map.put("yfDate",yfDate);
		map.put("ytDate",ytDate);
		map.put("jfDate",jfDate);
		map.put("jtDate",jtDate);
		map.put("ffDate",ffDate);
		map.put("ftDate",ftDate);
		map.put("mfDate",mfDate);
		map.put("mtDate",mtDate);
		map.put("afDate",afDate);
		map.put("atDate",atDate);
		map.put("mafDate",mafDate);
		map.put("matDate",matDate);
		map.put("jufDate",jufDate);
		map.put("jutDate",jutDate);
		map.put("jyfDate",jyfDate);
		map.put("jytDate",jytDate);
		map.put("aufDate",aufDate);
		map.put("autDate",autDate);
		map.put("sfDate",sfDate);
		map.put("stDate",stDate);
		map.put("ofDate",ofDate);
		map.put("otDate",otDate);
		map.put("nfDate",nfDate);
		map.put("ntDate",ntDate);
		map.put("dfDate",dfDate);
		map.put("dtDate",dtDate);
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (RuntimeException e) {
		e.printStackTrace();
	}
	return map;
	
}


public Map<String, Object> getDBConnection() {
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	Connection conn = session.connection();
	map.put("conn", conn);
	return map;
}

}
