package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasWorkCategory;

public interface WorkCategoryHandlerService {
	// ---------------------------------------------- Work Category
	// ----------------------------------

	Map<String, Object> showWorkCategoryJsp();

	boolean addWorkCategory(MasWorkCategory workCategoryMaster);

	Map<String, Object> searchWorkCategory(String workCategoryCode,
			String workCategoryName);

	boolean editWorkCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteWorkCategory(int workCategoryId,
			Map<String, Object> generalMap);
}
