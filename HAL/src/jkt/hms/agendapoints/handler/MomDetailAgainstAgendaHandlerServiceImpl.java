package jkt.hms.agendapoints.handler;

import java.util.Map;

import jkt.hms.agendapoints.dataservice.MomDetailAgainstAgendaDataService;

public class MomDetailAgainstAgendaHandlerServiceImpl implements
		MomDetailAgainstAgendaHandlerService {
	MomDetailAgainstAgendaDataService momdetailagainstagendadataservice = null;

	public Map<String, Object> showMomDetailAgainstAgendaJsp(int Id) {
		return momdetailagainstagendadataservice
				.showMomDetailAgainstAgendaJsp(Id);
	}

	public boolean addMomDetailAgainstAgenda(Map<String, Object> generalMap) {
		return momdetailagainstagendadataservice
				.addMomDetailAgainstAgenda(generalMap);
	}

	public MomDetailAgainstAgendaDataService getMomDetailAgainstAgendaDataService() {
		return momdetailagainstagendadataservice;
	}

	public void setMomDetailAgainstAgendaDataService(
			MomDetailAgainstAgendaDataService momdetailagainstagendadataservice) {
		this.momdetailagainstagendadataservice = momdetailagainstagendadataservice;
	}

	public String generateMomNumber(String userName) {
		return momdetailagainstagendadataservice.generateMomNumber(userName);
	}

}
