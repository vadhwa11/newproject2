package jkt.hms.workservices.handler;

import java.util.Map;

import jkt.hms.masters.business.MasWorkType;
import jkt.hms.workservices.dataservice.WorkTypeDataService;

public class WorkTypeHandlerServiceImpl implements WorkTypeHandlerService {
	WorkTypeDataService workTypeDataService = null;

	public Map<String, Object> showWorkTypeJsp() {
		return workTypeDataService.showWorkTypeJsp();
	}

	public String addWorkType(MasWorkType masWorkType) {
		return workTypeDataService.addWorkType(masWorkType);
	}

	public Map<String, Object> searchWorkType(String workTypeCode,
			String workTypeName) {
		return workTypeDataService.searchWorkType(workTypeCode, workTypeName);
	}

	public String editWorkTypeToDatabase(Map<String, Object> generalMap) {
		return workTypeDataService.editWorkTypeToDatabase(generalMap);
	}

	public boolean deleteWorkType(int workTypeId, Map<String, Object> generalMap) {
		return workTypeDataService.deleteWorkType(workTypeId, generalMap);
	}

	// ------------------------------------------------------------

	public WorkTypeDataService getWorkTypeDataService() {
		return workTypeDataService;
	}

	public void setWorkTypeDataService(WorkTypeDataService workTypeDataService) {
		this.workTypeDataService = workTypeDataService;
	}

}
