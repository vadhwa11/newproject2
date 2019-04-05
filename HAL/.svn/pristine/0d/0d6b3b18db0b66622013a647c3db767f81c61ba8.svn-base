package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasApplication;

public interface CommonMasterHandlerService {

	// ---------------General Methods For all Masters By Deepti
	// Tevatia---------------

	Map checkForExistingMasters(Map<String, Object> generalMap);

	List getMastersList(Map<String, Object> generalMap);

	List getMastersInformationOnChange(Map<String, Object> generalMap);

	List getMastersListByName(Map<String, Object> mastersEnquiryMap,
			String status);

	List getTableRecords(Map<String, Object> mapForDs);

	List getAllMasterRecords(String masterName);

	MasApplication getAppIdObject(String appId);

	Map<String, Object> getBreadCrumbs(String appId);

	Map<String, Object> getUserButtonRights(Map<String, Object> dataMap);

	// added by yogesh 0n 08/10/2009
	public Object loadObject(Class clazz, Integer id);

}
