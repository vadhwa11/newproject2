package jkt.hms.stores.controller;

import jkt.hms.stores.dataservice.StoresDataService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class GRNSchedulerController extends QuartzJobBean {

	private StoresDataService storesDataService = null;

	protected void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		boolean updated = false;
		try {
			//System.out.println("INside GRNSchedulerController .............");
			updated = storesDataService.updateGRN();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		if (updated == true) {
			//System.out.println("Data updated Succesfully!!");
		} else {
			//System.out.println("Some Problem Occred!!");
		}
	}

	public StoresDataService getStoresDataService() {
		return storesDataService;
	}

	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}

}
