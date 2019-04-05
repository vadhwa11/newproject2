package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.FIRST_NAME;
import static jkt.hms.util.RequestConstants.LAST_NAME;
import static jkt.hms.util.RequestConstants.MEDICAL_ADMIN_NO;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_PROCEEDINGS_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.RANK;
import static jkt.hms.util.RequestConstants.SERVICE_NO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasMedicalBoardProceedings;
import jkt.hms.medicalboard.handler.MedicalBoardProceedingUpdateSearchHandlerService;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalBoardProceedingUpdateSearchController extends
		MultiActionController {
	MedicalBoardProceedingUpdateSearchHandlerService medicalBoardProceedingUpdateSearchHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalBoardSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		//System.out.println("in controller");
		map = medicalBoardProceedingUpdateSearchHandlerService
				.showMedicalBoardSearchJsp();
		jsp = MEDICAL_BOARD_PROCEEDINGS_SEARCH_JSP;
		jsp += ".jsp";
		title = "Medical Board Search For Update";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMedicalBoardSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		//System.out.println("in controller");
		map = medicalBoardProceedingUpdateSearchHandlerService
				.showMedicalBoardSearchJsp();
		jsp = RequestConstants.MEDICAL_BOARD_PROCEEDINGS_PRINT_JSP;
		jsp += ".jsp";
		title = "Medical Board Proceeding Print";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMedicalBoardProceedingSearch(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String rank = "";
		String jsp = "";
		String title = "";
		String flag = "";
		MedicalBoardProceedingsUpdateSearchDTO medicalBoardProceedingsSearchDTO = new MedicalBoardProceedingsUpdateSearchDTO();

		if (request.getParameter(RequestConstants.FLAG_FOR_PRINT) != null
				&& !(request.getParameter(RequestConstants.FLAG_FOR_PRINT)
						.equals(""))) {
			flag = request.getParameter(RequestConstants.FLAG_FOR_PRINT);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			medicalBoardProceedingsSearchDTO.setServiceNo(request
					.getParameter(SERVICE_NO));
		}
		if (request.getParameter(RANK) != null
				&& !(request.getParameter(RANK).equals(""))) {
			medicalBoardProceedingsSearchDTO
					.setRank(request.getParameter(RANK));
		}
		if (request.getParameter(MEDICAL_ADMIN_NO) != null
				&& !(request.getParameter(MEDICAL_ADMIN_NO).equals(""))) {
			medicalBoardProceedingsSearchDTO.setAdNo(request
					.getParameter(MEDICAL_ADMIN_NO));
		}
		if (request.getParameter(FIRST_NAME) != null
				&& !(request.getParameter(FIRST_NAME).equals(""))) {
			medicalBoardProceedingsSearchDTO.setFirstName(request
					.getParameter(FIRST_NAME));
		}
		if (request.getParameter(LAST_NAME) != null
				&& !(request.getParameter(LAST_NAME).equals(""))) {
			medicalBoardProceedingsSearchDTO.setLastName(request
					.getParameter(LAST_NAME));
		}

		map = medicalBoardProceedingUpdateSearchHandlerService
				.searchMedicalBoardProceedingSearch(medicalBoardProceedingsSearchDTO);
		if (((List<MasMedicalBoardProceedings>) map.get("medicalBoardList"))
				.size() != 0)// flag.equalsIgnoreCase("y")
		{
			jsp = RequestConstants.MEDICAL_BOARD_PROCEEDINGS_PRINT_JSP;
		} else {
			jsp = MEDICAL_BOARD_PROCEEDINGS_SEARCH_JSP;
		}

		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public MedicalBoardProceedingUpdateSearchHandlerService getMedicalBoardProceedingUpdateSearchHandlerService() {
		return medicalBoardProceedingUpdateSearchHandlerService;
	}

	public void setMedicalBoardProceedingUpdateSearchHandlerService(
			MedicalBoardProceedingUpdateSearchHandlerService medicalBoardProceedingUpdateSearchHandlerService) {
		this.medicalBoardProceedingUpdateSearchHandlerService = medicalBoardProceedingUpdateSearchHandlerService;
	}

}
