package jkt.hms.adt.controller;

import jkt.hms.adt.dataservice.ADTDataService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BedSchedulerController extends QuartzJobBean {

	private ADTDataService adtDataService = null;

	protected void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		boolean updated = false;
		try {
			updated = adtDataService.updateBedStatics();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		if (updated == true) {
			//System.out.println("Data updated Succesfully!!");
		} else {
			//System.out.println("Some Problem Occred!!");
		}
	}

	public ADTDataService getAdtDataService() {
		return adtDataService;
	}

	public void setAdtDataService(ADTDataService adtDataService) {
		this.adtDataService = adtDataService;
	}

}
