package jkt.hms.workservices.dataservice;

import java.util.Map;

import jkt.hms.masters.business.MasWorkCategory;

public interface WorkCategoryDataService {

	Map<String, Object> showWorkCategoryJsp();

	boolean addWorkCategory(MasWorkCategory workCategoryMaster);

	Map<String, Object> searchWorkCategory(String workCategoryCode,
			String workCategoryName);

	boolean editWorkCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteWorkCategory(int workCategoryId,
			Map<String, Object> generalMap);

}
