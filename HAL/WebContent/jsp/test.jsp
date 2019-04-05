package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jkt.hms.util.HMSUtil;
import static jkt.hms.util.RequestConstants.*;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.MdContigentMedicalBillHd;

public final class md_005fGeneralClaimTracking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"/hms/jsp/js/proto.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/hms/jsp/js/ajax.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/hms/jsp/js/prototype.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/hms/jsp/js/divideprototype.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/hms/jsp/js/scriptaculous.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"/hms/jsp/js/calendar.js\"></script>\r\n");
      out.write("<script src=\"/hms/jsp/js/unittest.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\thistory.forward();\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}

      out.write("\r\n");
      out.write("\tserverdate = '");
      out.print(dateCal+"/"+month+"/"+year);
      out.write("'\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MdContigentMedicalBillHd> contingentHdList = new ArrayList<MdContigentMedicalBillHd>();
	MdContigentMedicalBillHd contigentMedicalBillHd= new MdContigentMedicalBillHd();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int contingenthdId=0;
	int hinId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("contingentHdList") != null){
			contingentHdList=(List)map.get("contingentHdList");
		}
		if(contingentHdList != null) {
			contigentMedicalBillHd = (MdContigentMedicalBillHd) contingentHdList.get(0);
				hinId =contigentMedicalBillHd.getHin().getId();
		}
		List<Patient> patientList = new ArrayList<Patient>();
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("contingenthdId") != null){
			contingenthdId=(Integer)map.get("contingenthdId");
		}

      out.write("\r\n");
      out.write("<form name=\"contingentBill\" method=\"post\" action=\"\">\r\n");
      out.write("<div class=\"titlebg\">\r\n");
      out.write("<h2>Bill Movement Status</h2>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"Block\" >\r\n");
      out.write("\r\n");
      out.write("<label>Service No.</label> <label\r\n");
      out.write("\tclass=\"value\">");
      out.print(contigentMedicalBillHd.getHin().getServiceNo());
      out.write("</label>\r\n");
      out.write("\r\n");
      out.write("<label>HIN</label> <label class=\"value\">");
      out.print(contigentMedicalBillHd.getHin().getHinNo());
      out.write("</label>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<label>First Name</label> <label class=\"value\">");
      out.print(contigentMedicalBillHd.getHin().getPFirstName());
      out.write("</label>\r\n");
      out.write("\r\n");
      out.write("<div class=\"Clear\"></div>\r\n");
      out.write("<label>Last Name</label>\r\n");
 if(contigentMedicalBillHd.getHin().getPLastName() !=null){ 
      out.write("\r\n");
      out.write("<label class=\"value\">");
      out.print(contigentMedicalBillHd.getHin().getPLastName());
      out.write("</label>\r\n");
}else{ 
      out.write("<label class=\"value\"></label>\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<label>Rank </label> ");
if(contigentMedicalBillHd.getHin().getRank() !=null){ 
      out.write("\r\n");
      out.write("<label class=\"value\">");
      out.print(contigentMedicalBillHd.getHin().getRank().getRankName());
      out.write("</label>\r\n");
}else{ 
      out.write(" <label> - </label> ");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<label>Unit </label> ");
if(contigentMedicalBillHd.getHin().getUnit() !=null){ 
      out.write("\r\n");
      out.write("<label class=\"value\">");
      out.print(contigentMedicalBillHd.getHin().getUnit().getUnitName());
      out.write("</label>\r\n");
}else{ 
      out.write(" <label class=\"value\"> - </label> ");
} 
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<div class=\"Clear\"></div>\r\n");
      out.write("\r\n");
      out.write("<label>Bill No </label>\r\n");
if(contigentMedicalBillHd.getBillNo()!=null){ 
      out.write(" <label class=\"value\">");
      out.print(contigentMedicalBillHd.getBillNo());
      out.write("</label>\r\n");
}else{ 
      out.write(" <label class=\"value\"> - </label> ");
} 
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<label>Bill Date\r\n");
      out.write("</label> ");
if(contigentMedicalBillHd.getBillDate()!=null){ 
      out.write(" <label class=\"value\">");
      out.print(HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getBillDate()));
      out.write("</label>\r\n");
}else{ 
      out.write(" <label class=\"value\"> - </label> ");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<label>Bill Amount </label> ");
if(contigentMedicalBillHd.getAmount()!=null){ 
      out.write("\r\n");
      out.write("<label class=\"value\">");
      out.print(contigentMedicalBillHd.getAmount());
      out.write("</label> ");
}else{ 
      out.write("\r\n");
      out.write("<label class=\"value\"> - </label> ");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"division\"></div>\r\n");
				
				if(contingentHdList.size() == 0){
				out.println(" No Record Found!");
							}else if(contingentHdList.size() > 0){
	
      out.write("\r\n");
      out.write("<div class=\"tableHolderAuto\">\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\r\n");
      out.write("\tid=\"chargeDetails\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th scope=\"col\">Bill FWT To</th>\r\n");
      out.write("\t\t\t<th scope=\"col\">Bill FWT Date</th>\r\n");
      out.write("\t\t\t<th scope=\"col\">Document No</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><input type=\"text\"\r\n");
      out.write("\t\t\tvalue=\"");
      out.print(contigentMedicalBillHd.getFwtTo().getAuthorityName());
      out.write("\"\r\n");
      out.write("\t\t\tname=\"");
      out.print(FWT_TO );
      out.write("\" readonly=\"readonly\" /></td>\r\n");
      out.write("\t\t<td><input type=\"text\"\r\n");
      out.write("\t\t\tvalue=\"");
      out.print(HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getFwtDate()));
      out.write("\"\r\n");
      out.write("\t\t\tname=\"");
      out.print(FWT_DATE );
      out.write("\" readonly=\"readonly\" /></td>\r\n");
      out.write("\t\t<td><input type=\"text\"\r\n");
      out.write("\t\t\tvalue=\"");
      out.print(contigentMedicalBillHd.getEntryNo());
      out.write("\" name=\"");
      out.print(ENTRY_NO);
      out.write("\"\r\n");
      out.write("\t\t\treadonly=\"readonly\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
