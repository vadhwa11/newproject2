package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.HOSPITAL_ID;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jkt.hms.adt.dataservice.RegistrationDataService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HL7MessgaeController extends QuartzJobBean {

	private RegistrationDataService registrationDataService = null;

	protected synchronized void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		boolean saveOrUpdate = false;
		try {
			System.out.println("INside HL7MessgaeController .............");
			saveOrUpdate = registrationDataService.addRecordForHL7();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

}
