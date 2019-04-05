package jkt.hms.diet.controller;

import jkt.hms.diet.dataservice.DietDataService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DietSchedulerController extends QuartzJobBean {

	private DietDataService dietDataService = null;

	protected void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		boolean saved = false;
		try {
			saved = dietDataService.addPatientDietDetails();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		if (saved == true) {
			//System.out.println("Data Saved Succesfully!!");
		} else {
			//System.out.println("Some Problem Occred!!");
		}
	}

	public DietDataService getDietDataService() {
		return dietDataService;
	}

	public void setDietDataService(DietDataService dietDataService) {
		this.dietDataService = dietDataService;
	}

}
