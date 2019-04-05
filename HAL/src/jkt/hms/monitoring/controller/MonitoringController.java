package jkt.hms.monitoring.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.Users;
import jkt.hms.monitoring.handler.MonitoringHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import net.sf.jasperreports.engine.JRException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MonitoringController extends MultiActionController{
	
	MonitoringHandlerService monitoringHandlerService = null;
	
	public MonitoringHandlerService getMonitoringHandlerService() {
		return monitoringHandlerService;
	}
	public void setMonitoringHandlerService(
			MonitoringHandlerService monitoringHandlerService) {
		this.monitoringHandlerService = monitoringHandlerService;
	}

	String jsp ="";
	public ModelAndView showCmdHealthMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		
		
		String command="";
		
		if(request.getParameter("command")!=null && !request.getParameter("commandId").equals(""))
		{
			command = request.getParameter("command");
		}
		
		
		int userId = users.getId();
		map = monitoringHandlerService.getCmdHealthMonitoringDetails(userId,commandId);
		jsp = "CmdHealthMonitoring.jsp";
		map.put("commandId", commandId);
		map.put("command", command);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showCmdAviMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int userId = users.getId();
		map = monitoringHandlerService.getCmdAviMonitoringJsp(userId,commandId);
		map.put("commandId",commandId);
		map.put("command",command);
		jsp = "CmdAviMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showHealthMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.getHealthMonitoringDetails(users.getId());
		jsp = "AirHqHealthMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showMedExamBoardMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.getMedExamBoardMonitoringDetails(users.getId());
		jsp = "AirHqMedExamBoard.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView showStatsMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.showStatsMonitoringJsp(users.getId());
		jsp = "AirHqStatsMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	
	}
	
	public ModelAndView showMedExamBoardCmdJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = (request.getParameter("command"));
		}
		
		
		int userId = users.getId();
		map = monitoringHandlerService.getCmdMedExamBoardDetails(userId,commandId);
		jsp = "MedExamBoardCmd.jsp";
		map.put("contentJsp", jsp);
		map.put("commandId", commandId);
		map.put("command", command);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showStatsCmdJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		int userId = users.getId();
		map = monitoringHandlerService.getCmdStatsDetails(userId,commandId);
		jsp = "statsCmd.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showMedExamBoardSMCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int userId = users.getId();
		int hospitalId = 0;
		int commandId=0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command ="";
		if(request.getParameter("command") != null && !request.getParameter("command").equals(""))
		{
			command = (request.getParameter("command"));
		}
		
		String hospName ="";
		if(request.getParameter("hospName") != null && !request.getParameter("hospName").equals(""))
		{
			hospName = (request.getParameter("hospName"));
		}

		//map = monitoringHandlerService.getSmcMedExamBoardDetails(userId,hospitalId);
		map = monitoringHandlerService.getSmcMedExamBoardDetails(userId, hospitalId, commandId);

		map.put("hospitalId", hospitalId);
		map.put("commandId", commandId);
		map.put("command", command);
		map.put("hospName", hospName);
		jsp = "MedExamBoardSMC.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView showStatsSMCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int userId = users.getId();
	
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = request.getParameter("command");
		}
		String hospital = "";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("")){
			hospital = request.getParameter("hospital");
		}
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		
		
		map = monitoringHandlerService.getSmcStatsDetails(userId,hospitalId,commandId);
		map.put("hospitalId", hospitalId);
		map.put("hospital", hospital);
		map.put("command", command);
		map.put("commandId", commandId);
		jsp = "statsSMC.jsp";
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAvMedicineJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.getAvMedicineMonitoringDetails(users.getId());
		jsp = "AirHqAvMedicine.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSmcHealthMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int userId = users.getId();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		
		int commandId=0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		
		
		String hospName="";
		if(request.getParameter("hospName")!=null && !request.getParameter("hospName").equals("")){
			hospName = (request.getParameter("hospName"));
		}
		System.out.println("hospName--health --"+hospName);
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = (request.getParameter("command"));
		}
		
		
		map = monitoringHandlerService.getSmcHealthMonitoringDetails(userId,hospitalId,commandId);
		jsp = "SmcHealthMonitoring.jsp";
		map.put("hospitalId", hospitalId);
		map.put("commandId", commandId);
		map.put("hospName", hospName);
		map.put("command", command);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSmcAviationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int userId = users.getId();
		
		
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = request.getParameter("command");
		}
		String hospital = "";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("")){
			hospital = request.getParameter("hospital");
		}
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
	
		map = monitoringHandlerService.getSmcAviationDetails(userId,hospitalId,commandId);
		map.put("hospitalId", hospitalId);
		map.put("hospital", hospital);
		map.put("command", command);
		map.put("commandId", commandId);
		jsp = "SMCAviationMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAirHqStoreMonitoringJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.getAirHqStoregDetails(users.getId());
		jsp = "AirHqStoreMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	
	}
	
	public ModelAndView showCmdStoreMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}	
			
		String command ="";
		if(request.getParameter("command") != null && !request.getParameter("command").equals("0"))
		{
			command = (request.getParameter("command"));
		}
		int userId = users.getId();
		map = monitoringHandlerService.getCmdStoreMonitoringJsp(userId,commandId);
		jsp = "CmdStoreMonitoring.jsp";
		map.put("contentJsp", jsp);
		map.put("commandId", commandId);
		map.put("command", command);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSMCStoreMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int userId = users.getId();
		
		int hospitalId = 0;
		int commandId=0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		if(request.getParameter("commandId") != null && !request.getParameter("commandId").equals("0"))
		{
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		
		
		String command ="";
		if(request.getParameter("command") != null && !request.getParameter("command").equals(""))
		{
			command = (request.getParameter("command"));
		}
		String hospName ="";
		if(request.getParameter("hospName") != null && !request.getParameter("hospName").equals("0"))
		{
			hospName = (request.getParameter("hospName"));
		}
		
		map = monitoringHandlerService.getSMCStoreDetails(userId,hospitalId,commandId);
		jsp = "SMCStoreMonitoring.jsp";
		
		map.put("hospitalId", hospitalId);
		map.put("commandId", commandId);
		map.put("command", command);
		map.put("hospName", hospName);
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAirHqFWCMonitoringJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.getAirHqFWCDetails(users.getId());
		jsp = "AirHqFWCMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	
	}
	
	public ModelAndView showCmdFWCMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int userId = users.getId();
		map = monitoringHandlerService.getCmdFWCDetails(userId,commandId);
		map.put("commandId",commandId);
		map.put("command",command);
		
		jsp = "CmdFWCMonitoring.jsp";
		map.put("contentJsp", jsp);
		
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSMCFWCMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int userId = users.getId();

		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = request.getParameter("command");
		}
		String hospital = "";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("")){
			hospital = request.getParameter("hospital");
		}
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
	
		map = monitoringHandlerService.getSMCFWCDetails(userId,hospitalId,commandId);
		map.put("hospitalId", hospitalId);
		map.put("hospital", hospital);
		map.put("command", command);
		map.put("commandId", commandId);
		jsp = "SMCFWCMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		

	}

//------Method added by Kiran for SHO Module---
	//---Air Hq-----
	
	public ModelAndView showShoMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		map = monitoringHandlerService.getShoMonitoringJsp(users.getId());
		jsp = "shoMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//---CMD----
	
	public ModelAndView showShoMonitoringCmdJsp(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int userId = users.getId();
		map = monitoringHandlerService.getShoMonitoringCmdJsp(userId,commandId);
		map.put("commandId",commandId);
		map.put("command",command);
		jsp = "cmdShoMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

//----SMC---
	
	public ModelAndView showShoSmcMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		
		int userId = users.getId();
		
		
		int commandId = 0;
		if(request.getParameter("commandId")!=null && !request.getParameter("commandId").equals("0")){
			commandId = Integer.parseInt(request.getParameter("commandId"));
		}else{
			commandId = (Integer)session.getAttribute("commandId");
		}
		String command = "";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = request.getParameter("command");
		}
		String hospital = "";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("")){
			hospital = request.getParameter("hospital");
		}
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
	

		map = monitoringHandlerService.getShoSmcMonitoringJsp(userId,hospitalId,commandId);
		map.put("hospitalId", hospitalId);
		map.put("hospital", hospital);
		map.put("command", command);
		map.put("commandId", commandId);
		jsp = "shoSmcMonitoring.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}


	
	public ModelAndView showMedLecturePop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMedLecturePop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_MedLecturePop";
		return new ModelAndView(jsp,"map",map);
	}
	
		
	public ModelAndView showPreFlightMedCheckUpPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showPreFlightMedCheckUpPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_PreFlightMedCheckUpPop";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showCivilAviationPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showCivilAviationPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_CivilAviationPop";
		return new ModelAndView(jsp,"map",map);
	}
	
		
	
	public ModelAndView showMedLecturePopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMedLecturePopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_MedLecturePopH";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showPreFlightMedCheckUpPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showPreFlightMedCheckUpPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_PreFlightMedCheckUpPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showCivilAviationPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showCivilAviationPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_CivilAviationPopH";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showMedLecturePopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMedLecturePopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_MedLecturePopCH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showPreFlightMedCheckUpPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showPreFlightMedCheckUpPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_PreFlightMedCheckUpPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showCivilAviationPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showCivilAviationPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_CivilAviationPopCH";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showSilDilPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showSilDilPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_SilDilPop";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showEdReturnsPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showEdReturnsPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_EdReturnsPop";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showDeficientPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showDeficientPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_DeficientPop";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showSurplusPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showSurplusPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_SurplusPop";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showMonthlySickDetailsPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMonthlySickDetailsPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_MonthlySickDetailsPop";
		return new ModelAndView(jsp,"map",map);
	}
	
	
	public ModelAndView showSilDilPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showSilDilPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_SilDilPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showEdReturnsPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showEdReturnsPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_EdReturnsPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showDeficientPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showDeficientPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_DeficientPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showSurplusPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showSurplusPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_SurplusPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showMonthlySickDetailsPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMonthlySickDetailsPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_MonthlySickDetailsPopH";
		return new ModelAndView(jsp,"map",map);
	}
	
	
	public ModelAndView showSilDilPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showSilDilPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_SilDilPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showEdReturnsPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showEdReturnsPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_EdReturnsPopCH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showDeficientPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showDeficientPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_DeficientPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showSurplusPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showSurplusPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_SurplusPopCH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showMonthlySickDetailsPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMonthlySickDetailsPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_MonthlySickDetailsPopCH";
		return new ModelAndView(jsp,"map",map);
	}
	
	public  ModelAndView showServiceDetails(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetails(map);
		
		jsp = "serviceDetailJsp";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	public  ModelAndView showServiceDetailsAdmission(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsAdmission(map);
		
		jsp = "serviceDetailAdmissionJsp";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	
	public  ModelAndView showServiceDetailsAirCraft(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsAirCraft(map);
		
		jsp = "serviceDetailAirCraftJsp";
		return new ModelAndView(jsp,"map",map);
	  }
	

	
	public  ModelAndView showServiceDetailsH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("0")){
			hosp = request.getParameter("hosp");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsH(map);
		
		jsp = "serviceDetailRegH";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	public  ModelAndView showServiceDetailsAdmissionH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("0")){
			hosp = request.getParameter("hosp");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsAdmissionH(map);
		
		jsp = "serviceDetailAdmissionH";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	
	public  ModelAndView showServiceDetailsAirCraftH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("0")){
			hosp = request.getParameter("hosp");
		}
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsAirCraftH(map);
		
		jsp = "serviceDetailAirCraftH";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	
	public  ModelAndView showServiceDetailsS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("0")){
			hosp = request.getParameter("hosp");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsS(map);
		
		jsp = "serviceDetailRegS";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	public  ModelAndView showServiceDetailsAdmissionS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("0")){
			hosp = request.getParameter("hosp");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsAdmissionS(map);
		
		jsp = "serviceDetailAdmissionS";
		return new ModelAndView(jsp,"map",map);
	  }
	
	
	
	public  ModelAndView showServiceDetailsAirCraftS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("0")){
			hosp = request.getParameter("hosp");
		}
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsAirCraftS(map);
		
		jsp = "serviceDetailAirCraftS";
		return new ModelAndView(jsp,"map",map);
	  }
	
	public  ModelAndView showServiceDetailsME(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsME(map);
		
		jsp = "serviceDetailMe";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMePend(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMePend(map);
		
		jsp = "serviceDetailMePend";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMB(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMB(map);
		
		jsp = "serviceDetailMb";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMbPend(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMbPend(map);
		
		jsp = "serviceDetailMbPend";
		return new ModelAndView(jsp,"map",map);
	  }	
	


	public  ModelAndView showServiceDetailsMEH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMEH(map);
		
		jsp = "serviceDetailMeH";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMePendH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMePendH(map);
		
		jsp = "serviceDetailMePendH";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMBH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
					
		map = monitoringHandlerService.showServiceDetailsMBH(map);
		
		jsp = "serviceDetailMbH";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMbPendH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMbPendH(map);
		
		jsp = "serviceDetailMbPendH";
		return new ModelAndView(jsp,"map",map);
	  }	


	public  ModelAndView showServiceDetailsMES(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
				
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		
		System.out.println("command-->"+command);
		System.out.println("cmdId-->"+cmdId);
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMES(map);
		
		jsp = "serviceDetailMeS";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMePendS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMePendS(map);
		
		jsp = "serviceDetailMePendS";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMBS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
					
		map = monitoringHandlerService.showServiceDetailsMBS(map);
		
		jsp = "serviceDetailMbS";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	public  ModelAndView showServiceDetailsMbPendS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}
		
		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}
		
		map.put("hospId", hospId);
		map.put("hosp", hosp);
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showServiceDetailsMbPendS(map);
		
		jsp = "serviceDetailMbPendS";
		return new ModelAndView(jsp,"map",map);
	  }
	
	public  ModelAndView showAncVisitPop(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showAncVisitPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		
		jsp = "mon_AncVisit";
		return new ModelAndView(jsp,"map",map);
	  }
	
	public  ModelAndView showPncVisitPop(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showPncVisitPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		
		jsp = "mon_PncVisit";
		return new ModelAndView(jsp,"map",map);
	  }
	public  ModelAndView showAncVisitPopH(HttpServletRequest request,HttpServletResponse response)
	  { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showAncVisitPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_AncVisitH";
		return new ModelAndView(jsp,"map",map);
		
	  }
	
	public  ModelAndView showPncVisitPopH(HttpServletRequest request,HttpServletResponse response)
	  { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showPncVisitPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_PncVisitH";
		return new ModelAndView(jsp,"map",map);
		
	  }
	
	public  ModelAndView showAncVisitPopCH(HttpServletRequest request,HttpServletResponse response)
	  { 
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showAncVisitPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_AncVisitCH";
		return new ModelAndView(jsp,"map",map);
		
	  }
	
	public  ModelAndView showPncVisitPopCH(HttpServletRequest request,HttpServletResponse response)
	  { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showPncVisitPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_PncVisitCH";
		return new ModelAndView(jsp,"map",map);
		
	  }
	
	public ModelAndView showMonthlyMalariaCasePop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMonthlyMalariaCasePop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_MonthlyMalariaCasePop";
		return new ModelAndView(jsp,"map",map);
	}
	
		
	public ModelAndView showRtaPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showRtaPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_RtaPop";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showAttemptSuicideCasesPop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showAttemptSuicideCasesPop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_AttemptSuicideCasesPop";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showNotifiableDiseasePop(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showNotifiableDiseasePop(cmdId);
		map.put("command", command);
		map.put("f", f);
		map.put("t", t);
		map.put("cmdId", cmdId);
		String jsp = "mon_NotifiableDiseasePop";
		return new ModelAndView(jsp,"map",map);
	}
	
	
	public ModelAndView showMonthlyMalariaCasePopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMonthlyMalariaCasePopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_MonthlyMalariaCasePopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showRtaPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showRtaPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_RtaPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showAttemptSuicideCasesPopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showAttemptSuicideCasesPopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_AttemptSuicideCasesPopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showNotifiableDiseasePopH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showNotifiableDiseasePopH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_NotifiableDiseasePopH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showMonthlyMalariaCasePopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
	
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showMonthlyMalariaCasePopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_MonthlyMalariaCasePopCH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showRtaPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showRtaPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_RtaPopCH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showAttemptSuicideCasesPopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showAttemptSuicideCasesPopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_AttemptSuicideCasesPopCH";
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showNotifiableDiseasePopCH(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		
		String hospital="";
		if(request.getParameter("hospital")!=null && !request.getParameter("hospital").equals("0")){
			hospital = request.getParameter("hospital");
		}
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		map = monitoringHandlerService.showNotifiableDiseasePopCH(cmdId,hospitalId);
		map.put("hospital", hospital);
		map.put("f", f);
		map.put("t", t);
		map.put("hospitalId", hospitalId);
		map.put("cmdId", cmdId);
		map.put("command", command);
		String jsp = "mon_NotifiableDiseasePopCH";
		return new ModelAndView(jsp,"map",map);
	}
	
	
		
	public  ModelAndView showPerformaB(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
			
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showPerformaB(map);
		
		jsp = "performaB";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	
	public  ModelAndView showPerformaBPend(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
		
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showPerformaBPend(map);
		
		jsp = "performaBPend";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	
	public  ModelAndView showDefectiveDrug(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}
		
		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}
		
		
		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}
		
	
		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showDefectiveDrug(map);
		
		jsp = "defectiveDrug";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	
	public  ModelAndView showPerformaBH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}

		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}

		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}

		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}

		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}

		map.put("hospId", hospId);
		map.put("hosp", hosp);

		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showPerformaBH(map);
		
		jsp = "performaBH";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	
	public  ModelAndView showPerformaBPendH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}

		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}

		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}

		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}

		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}

		map.put("hospId", hospId);
		map.put("hosp", hosp);

		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showPerformaBPendH(map);
		
		jsp = "performaBPendH";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	
	public  ModelAndView showDefectiveDrugH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}

		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}

		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}

		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}

		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}

		map.put("hospId", hospId);
		map.put("hosp", hosp);

		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showDefectiveDrugH(map);
		
		jsp = "defectiveDrugH";
		return new ModelAndView(jsp,"map",map);
	  }
	
	public  ModelAndView showDefectiveDrugPendH(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}

		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("")){
			command = request.getParameter("command");
		}

		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}

		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}

		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}

		map.put("hospId", hospId);
		map.put("hosp", hosp);

		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showDefectiveDrugPendH(map);
		
		jsp = "defectiveDrugPendH";
		return new ModelAndView(jsp,"map",map);
	  }
	

	public  ModelAndView showPerformaBS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}

		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}

		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}

		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}

		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}

		map.put("hospId", hospId);
		map.put("hosp", hosp);

		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showPerformaBS(map);
		
		jsp = "performaBS";
		return new ModelAndView(jsp,"map",map);
	  }	
	
	

	
	
	public  ModelAndView showDefectiveDrugS(HttpServletRequest request,HttpServletResponse response)
	  { 
		HttpSession session = request.getSession();
		Map<String,Object>  map = new HashMap<String,Object>();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		int cmdId = 0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0")){
			cmdId = Integer.parseInt(request.getParameter("cmdId"));
		}

		String command="";
		if(request.getParameter("command")!=null && !request.getParameter("command").equals("0")){
			command = request.getParameter("command");
		}

		String f="";
		if(request.getParameter("f")!=null && !request.getParameter("f").equals("0")){
			f = request.getParameter("f");
		}
		String t="";
		if(request.getParameter("t")!=null && !request.getParameter("t").equals("0")){
			t = request.getParameter("t");
		}

		int hospId = 0;
		if(request.getParameter("hospId")!=null && !request.getParameter("hospId").equals("0")){
			hospId = Integer.parseInt(request.getParameter("hospId"));
		}

		String hosp="";
		if(request.getParameter("hosp")!=null && !request.getParameter("hosp").equals("")){
			hosp = request.getParameter("hosp");
		}

		map.put("hospId", hospId);
		map.put("hosp", hosp);

		map.put("command", command);
		map.put("cmdId", cmdId);
		map.put("f", f);
		map.put("t", t);
		
		map = monitoringHandlerService.showDefectiveDrugS(map);
		
		jsp = "defectiveDrugSmc";
		return new ModelAndView(jsp,"map",map);
	  }
	
//-----------Generate Report------
	//------Malaria Case Monitoring----
	
	public ModelAndView printMonthlyMalariaCaseReport(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
		int commandId =0;
		HttpSession session = request.getSession();
		session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
			{
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
			{
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			
			if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
			{
				hospitalId = Integer.parseInt(request.getParameter("smc"));
			}
			else if(session.getAttribute("hospitalId") != null)
			{
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			 
			
			if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
			{
				commandId = Integer.parseInt(request.getParameter("cmdId"));
			}
			else if(session.getAttribute("commandId") != null)
			{
				commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = monitoringHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		map.put("commandId", commandId);
		try 
		{
			map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("sho_Malaria_case_monitoring", map,(Connection) map.get("conn"), response,getServletContext());

		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
		
	  }

	
	public ModelAndView printNotifiableDiseaseReport(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
		int commandId =0;
		HttpSession session = request.getSession();
		session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
			{
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
			{
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			
			if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
			{
				hospitalId = Integer.parseInt(request.getParameter("smc"));
			}
			else if(session.getAttribute("hospitalId") != null)
			{
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			 
			
			if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
			{
				commandId = Integer.parseInt(request.getParameter("cmdId"));
			}
			else if(session.getAttribute("commandId") != null)
			{
				commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = monitoringHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		map.put("commandId", commandId);
		try 
		{
			map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("sho_notifiable_disease_monitoring", map,(Connection) map.get("conn"), response,getServletContext());

		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
		
	  }
	
	

	 public ModelAndView generateSuicideReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
		int commandId =0;
		HttpSession	session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			
			if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
			{
				hospitalId = Integer.parseInt(request.getParameter("smc"));
			}
			else if(session.getAttribute("hospitalId") != null)
			{
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			 
			
			if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
			{
				commandId = Integer.parseInt(request.getParameter("cmdId"));
			}
			else if(session.getAttribute("commandId") != null)
			{
				commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = monitoringHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		map.put("commandId", commandId);
		
		try {
				HMSUtil.generateReport("suicideCaseReport_monitoring", map,(Connection) map.get("conn"), response,getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	  }
	

	 
	 public ModelAndView printMonthlyAccidentalDetailReport(HttpServletRequest request,HttpServletResponse response)
	    {
		  Map<String,Object>  map = new HashMap<String,Object>();	    
			Date toDate = null;
			Date fromDate = null;
			int hospitalId =0;
			int commandId =0;
			HttpSession session = request.getSession();
			byte[] bytes = null;
			try {
				    if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
				    {
				    	toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				    }
				    
				    if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
				    {
					    fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				    }
				
					
					if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
					{
						hospitalId = Integer.parseInt(request.getParameter("smc"));
					}
					else if(session.getAttribute("hospitalId") != null)
					{
						hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					}
					 
					
					if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
					{
						commandId = Integer.parseInt(request.getParameter("cmdId"));
					}
					else if(session.getAttribute("commandId") != null)
					{
						commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
					}

			 } 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			map = monitoringHandlerService.getDBConnection();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
			map.put("hospitalId", hospitalId);
			map.put("commandId", commandId);
			try
			{
				map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
				HMSUtil
						.generateReport("monthlyAccidentalDetail_monitoring", map,(Connection) map.get("conn"), response,getServletContext());

			}
			catch (Exception e)
			{	e.printStackTrace();
			}
			return null;	  
		  
		  
	    }	

		public ModelAndView generateMOLectureDetailsRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();

			Date toDate = null;
			Date fromDate = null;
			int hospitalId =0;
			int commandId =0;
			
			   if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
			    {
			    	toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			    }
			    
			    if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
			    {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			    }
			
				
				if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
				{
					hospitalId = Integer.parseInt(request.getParameter("smc"));
				}
				else if(session.getAttribute("hospitalId") != null)
				{
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				}
				 
				
				if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
				{
					commandId = Integer.parseInt(request.getParameter("cmdId"));
				}
				else if(session.getAttribute("commandId") != null)
				{
					commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
				}
			
			detailsMap = monitoringHandlerService.getDBConnection();
			
			detailsMap.put("fromDate", fromDate);
			detailsMap.put("toDate", toDate);
			detailsMap.put("hospitalId", hospitalId);
			detailsMap.put("commandId", commandId);
			
		//	detailsMap.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("av_medLectureStats_monitoring", detailsMap, (Connection)detailsMap.get("conn"), response, getServletContext());
			return null;
		}

		public ModelAndView generateExamStatsReport(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Date toDate = null;
			Date fromDate = null;
			int hospitalId =0;
			int commandId =0;
			HttpSession session = request.getSession();
				
			 if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
			    {
			    	toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			    }
			    
			    if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
			    {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			    }
			
				
				if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
				{
					hospitalId = Integer.parseInt(request.getParameter("smc"));
				}
				else if(session.getAttribute("hospitalId") != null)
				{
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				}
				 
				
				if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
				{
					commandId = Integer.parseInt(request.getParameter("cmdId"));
				}
				else if(session.getAttribute("commandId") != null)
				{
					commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
				}
				
			detailsMap = monitoringHandlerService.getDBConnection();
			detailsMap.put("fromDate", fromDate);
			detailsMap.put("toDate", toDate);
			detailsMap.put("hospitalId", hospitalId);
			detailsMap.put("commandId", commandId);
		    HMSUtil.generateReport("av_Medical_Board_register_monitoring", detailsMap, (Connection)detailsMap.get("conn"), response, getServletContext());
		      		return null;
		}
		
		public ModelAndView generatePreFlightRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Date fromDate = null;
			Date toDate = null;
			int hospitalId =0;
			int commandId =0;
			Box box = null;
			if(session.getAttribute("box")!=null){
				box = (Box)session.getAttribute("box");
			}else{
				box = HMSUtil.getBox(request);
			}
			 if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
			    {
			    	toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			    }
			    
			    if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
			    {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			    }
			
				
				if(request.getParameter("smc") != null && !(request.getParameter("smc").equals("0")))
				{
					hospitalId = Integer.parseInt(request.getParameter("smc"));
				}
				else if(session.getAttribute("hospitalId") != null)
				{
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				}
				 
				
				if(request.getParameter("cmdId") != null && !(request.getParameter("cmdId").equals("0")))
				{
					commandId = Integer.parseInt(request.getParameter("cmdId"));
				}
				else if(session.getAttribute("commandId") != null)
				{
					commandId = Integer.parseInt(""+ session.getAttribute("commandId"));
				}
			detailsMap = monitoringHandlerService.getDBConnection();
			detailsMap.put("fromDate", fromDate);
			detailsMap.put("toDate", toDate);
			detailsMap.put("hospitalId", hospitalId);
			detailsMap.put("commandId", commandId);
			HMSUtil.generateReport("av_pre_flight_med_checkupDate_monitoring", detailsMap, (Connection)detailsMap.get("conn"), response, getServletContext());
			return null;
		}


}
