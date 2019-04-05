package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.workservices.dataservice.WorkCategoryDataService;

public class WorkCategoryHandlerServiceImpl implements
		WorkCategoryHandlerService {
	WorkCategoryDataService workCategoryDataService = null;

	// ---------------------------------- Work Category
	// ------------------------------------

	public Map<String, Object> showWorkCategoryJsp() {
		return workCategoryDataService.showWorkCategoryJsp();
	}

	public boolean addWorkCategory(MasWorkCategory masWorkCategory) {
		return workCategoryDataService.addWorkCategory(masWorkCategory);
	}

	public Map<String, Object> searchWorkCategory(String workCategoryCode,
			String workCategoryName) {
		return workCategoryDataService.searchWorkCategory(workCategoryCode,
				workCategoryName);
	}

	public boolean editWorkCategoryToDatabase(Map<String, Object> generalMap) {
		return workCategoryDataService.editWorkCategoryToDatabase(generalMap);
	}

	public boolean deleteWorkCategory(int workCategoryId,
			Map<String, Object> generalMap) {
		return workCategoryDataService.deleteWorkCategory(workCategoryId,
				generalMap);
	}

	// ------------------------------------------------------------

	public WorkCategoryDataService getWorkCategoryDataService() {
		return workCategoryDataService;
	}

	public void setWorkCategoryDataService(
			WorkCategoryDataService workCategoryDataService) {
		this.workCategoryDataService = workCategoryDataService;
	}

}
