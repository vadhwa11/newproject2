import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.sql.*;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.ORC;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.model.v23.segment.PV1;
import ca.uhn.hl7v2.model.v23.segment.PV2;

import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
public class hl7Message {
	/*static String databaseUrl = "jdbc:sqlserver://192.168.203.136:1433;database=VBCHLIVE";
static String databaseDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
static String databaseUserName = "sa";
static String databasePassword = "Password@1234";*/
static String databaseUrl = "jdbc:oracle:thin:@192.168.203.191:1521:XE";
static String databaseDriverName = "oracle.jdbc.driver.OracleDriver";
static String databaseUserName = "MEDNET";
static String databasePassword = "mednet";

//static int localPort = 5556;

  public static void main(String[] args) throws Exception
    {
    	/*String databaseUrl = "jdbc:sqlserver://192.168.203.136:1433;database=VBCHLIVE";
    String databaseDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String databaseUserName = "sa";
    String databasePassword = "Password@1234";
    */
        System.out.println("Client Started...");
        /*
         * Code for Request String 
         */
       // ServerSocket serverSocket = new ServerSocket(localPort);
		 int i=0;
		while (true)
         {
			++i;
			System.out.println("process data--->"+hl7Message.doProcessRequest(databaseUrl,databaseDriverName,databaseUserName,databasePassword));
         }
		/*for (int i = 0; i < 5; i++) {
			 byte[] byteData = receive(is);
			 String responseData = new String(byteData);
			 System.out.println("Server Response = " + responseData.trim());
		}*/
		//if(res.next()){
			//System.out.println(res.next());
			/*while (res.next())
			{
				System.out.println("Hello");
				if(){
					doProcessResponse(st,is);
				}
				// Code for process date 22 Jun 2011
			}*/
		
        /*
         * End Of Code for Request String
         */                
}


/**
 * doProcessRequest() Create Database and PACS Server Socket Connection and Send Requisition in HL7 2.3 Version {Radiology Requisition} to PACS Server and Get Response in HL7 2.3 Version On the Behalf of response {AA means Receive Successfully an AE means Some error Occurred} and msg_sent Status(y=Send Successfully ,n=Not Send , c=Cancel Successfully) And department_type_id=12{Only Radiology}
 * @author Mukesh.narayan
 * @Date 22 July 2011
 * @param  String databaseUrl
 * @param  String databaseDriverName
 * @param  String databaseUserName
 * @param  String databasePassword
 * @return {@link Boolean}
 */
	
public static boolean doProcessRequest(String databaseUrl,String databaseDriverName,String databaseUserName,String databasePassword) throws Exception
{
	boolean flag=true;
/*	java.sql.Connection con = null;
     Class.forName(databaseDriverName).newInstance();*/
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection(databaseUrl, databaseUserName, databasePassword);

	Statement st = con.createStatement();
	

	String query = "SELECT * FROM dg_orderhd dg left outer join dg_orderdt dt on dt.orderhd_id = dg.orderhd_id "+
	" left outer join  patient p on  p.hin_id = dg.hin_id  "+
	" left outer join mas_administrative_sex sexid on sexid.administrative_sex_id  = p.sex_id "+
	" left outer join  mas_employee emp on dg.prescribed_by = emp.employee_id "+
	" left outer join inpatient inp on dg.inpatient_id = inp.inpatient_id "+
	" left outer join mas_charge_code mcc on dt.charge_code_id = mcc.charge_code_id "+
	" left outer join visit v on dg.visit_id= v.visit_id "+
	" left outer join mas_department dept on v.department_id= dept.department_id "+
	"left outer join mas_department deptInv on inp.department_id= deptInv.department_id ";
//	" WHERE dt.msg_sent = 'n' and dt.payment_made='y'  and dt.pacs_status='n'";
	try {
		ResultSet res = st.executeQuery(query);
		while (res.next())
		{
			Date DOB = null;
			Date DOA = null;
			String TOA = null;
			String adtym = "";
			String doa_val = null;
			Statement st2 = con.createStatement();
			int accessionNo = res.getInt("orderdt_id");
			int mainChargeCodeId = res.getInt("main_chargecode_id");
			//String mainQuery = "select main_chargecode_name from mas_main_chargecode where main_chargecode_id = "+mainChargeCodeId;
			String mainQueryRaidio="";
			mainQueryRaidio="select main_chargecode_name from mas_main_chargecode mmc left outer join mas_department dept on dept.department_id= mmc.department_id"+ 
			" left outer join mas_department_type deptType on deptType.department_type_id= dept.department_type_id where  deptType.department_type_id=19 and mmc.main_chargecode_id = "+mainChargeCodeId;
			
			ResultSet res_mainChargeCode = st2.executeQuery(mainQueryRaidio);
			String mshPidPv1OrcObr="";
			while(res_mainChargeCode.next())
			{
				String mainCName = res_mainChargeCode.getString("main_chargecode_name");
				System.out.println("mainCName--->"+mainCName);
				/*if(mainCName.equalsIgnoreCase("XRAY") || mainCName.equalsIgnoreCase("ULTRASOUND")
			  || mainCName.equalsIgnoreCase("CT SCAN") || mainCName.equalsIgnoreCase("MRI"))
		   	  {*/
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A01 adt1 = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
				ORU_R01 message1 = new ORU_R01();

				message1.getMSH().getEncodingCharacters().setValue("^~\\&");
				message1.getMSH().getFieldSeparator().setValue("|");
				//ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
				ORU_R01_ORDER_OBSERVATION orderObservation = message1.getRESPONSE().getORDER_OBSERVATION();
				//ORU_R01_ORDER_OBSERVATION orderObservation = null;//= message1.getDSC().getContinuationPointer().

				// Populate the MSH Segment

				MSH mshSegment = adt1.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("INSTAPACS");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
				/*
				 * Accession No this will come from investigation details table
				 */
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				System.out.println("accessionNo--ds---->"+accessionNo);
				mshSegment.getMsh10_MessageControlID().setValue(""+accessionNo);
				mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("P");
				mshSegment.getMsh12_VersionID().setValue(adt1.getVersion());

				DOB = res.getDate("date_of_birth");
				String abc ="";
				if(DOB!=null){
					abc = DateUtils.convertDatetoString(DOB);
				}
				// Populate the PID Segment
				PID pid = adt1.getPID();
				pid.getPid3_PatientIDInternalID(0).getID().setValue(res.getString("hin_id"));
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
				pid.getPid5_PatientName().getMiddleInitialOrName().setValue(res.getString("p_middle_name"));
				pid.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid.getPid8_Sex().setValue(res.getString("administrative_sex_code"));

				PV1 pv1 = adt1.getPV1();
				/*
				 * This Block is changed By Mukesh On Date 10 Jun 2011
				 */
				String patientType=res.getString("patient_type");
				String patientTypeFinal="";
				String vistIdAndPatient="";
				String roomType="";
				if(patientType.equalsIgnoreCase("OP")){
					patientTypeFinal="O";
					String visitId = DateUtils.convertSimple(res.getInt("visit_id"));
					pv1.getPv119_VisitNumber().getID().setValue(visitId);
					vistIdAndPatient=res.getString("visit_id");
					roomType =res.getString("department_name");
					if(res.getDate("visit_date") != null || res.getString("visit_time") != null)
					{
						DOA = res.getDate("visit_date");
						TOA = res.getString("visit_time");

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
					//	TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = DateUtils.convertDatetoString(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}else if (patientType.equalsIgnoreCase("IP")) {
					patientTypeFinal="I";
					String inpatient_id = DateUtils.convertSimple(res.getInt("inpatient_id"));
					pv1.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=res.getString("inpatient_id");
					roomType =res.getString(323);
					if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
					{
						DOA = res.getDate("date_of_addmission");
						TOA = res.getString("time_of_addmission");

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = DateUtils.convertDatetoString(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}
				pv1.getPv12_PatientClass().setValue(patientTypeFinal);

				pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
				pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(res.getString("employee_id"));
				pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(res.getString("last_name"));
		//		pv1.getPv18_ReferringDoctor(0).getGivenName().setValue(res.getString("first_name").concat(res.getString("middle_name")));

				ORC orc = orderObservation.getORC();
				orc.getOrc1_OrderControl().setValue("NW");      
				/*
				 * Code changed By Mukesh for accessionNo
				//orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
				 */
				//orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+accessionNo);

				orc.insertOrc2_PlacerOrderNumber(0).getEi1_EntityIdentifier().setValue(""+accessionNo);
				orc.getOrc5_OrderStatus().setValue("SC");             // ( = In Progress Scheduled)
				orc.getDateTimeOfTransaction().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				/*
				 * Code changed By Mukesh for Hin_id
				orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue("1234"); //Order Entry Person (ID)
				 */

				orc.getOrc10_EnteredBy().getIDNumber().setValue(res.getString("employee_id")); //Order Entry Person (ID)
				//orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue("Abhi Gupta"); //Order Entry Person (Name)
				orc.getOrc10_EnteredBy().getFamilyName().setValue(res.getString("last_name"));
				orc.getOrc10_EnteredBy().getGivenName().setValue(res.getString("first_name"));
				orc.getOrc10_EnteredBy().getMiddleInitialOrName().setValue(res.getString("middle_name"));

				// Populate the OBR
				ca.uhn.hl7v2.model.v23.segment.OBR obr = orderObservation.getOBR();
				/*
				 * Code changed By Mukesh for accessionNo
				obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
				 */
				obr.insertObr2_PlacerOrderNumber(0).getEi1_EntityIdentifier().setValue(""+accessionNo);


				obr.getObr3_FillerOrderNumber().getEi1_EntityIdentifier().setValue(res.getString("order_no"));

				obr.getObr3_FillerOrderNumber().getEi2_NamespaceID().setValue(vistIdAndPatient);
				obr.getObr3_FillerOrderNumber().getEi3_UniversalID().setValue(patientTypeFinal);
				obr.getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue(res.getString("charge_code_code"));
				obr.getObr4_UniversalServiceIdentifier().getCe2_Text().setValue(res.getString("charge_code_name"));
				//obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				obr.getObr13_RelevantClinicalInformation().setValue(res.getString("clinical_note"));


				obr.getObr16_OrderingProvider(0).getIDNumber().setValue(res.getString("employee_id"));
				obr.getObr16_OrderingProvider(0).getFamilyName().setValue(res.getString("last_name"));
				obr.getObr16_OrderingProvider(0).getGivenName().setValue(res.getString("first_name"));
				obr.getObr16_OrderingProvider(0).getMiddleInitialOrName().setValue(res.getString("middle_name"));
				//obr.getObr16_OrderingProvider().getCn3_GivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));

				obr.getObr24_DiagnosticServiceSectionID().setValue(mainCName);

				obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				//Order Scheduling Details (will not be present if HIS does not have scheduling engine

				// Now, let's encode the message and look at the output
				char BeginFormat = (char)0x0B;
				//char EndFormat1 = (char)0x1C;
				char EndFormat2 = (char)0x0D;

				Parser p1 = new PipeParser();
				String encodedMessage = p1.encode(adt1);

				String[] mainStr=encodedMessage.split("PID");
				String mshStr=mainStr[0].trim();
				String pidAndPv1Str=mainStr[1].trim();
				String[] mainStr2=pidAndPv1Str.split("PV1");
				String pidStr="PID"+mainStr2[0].trim();
				String pv1Str="PV1"+mainStr2[1].trim();

				String encMsg = p1.encode(message1);
				String newString = encMsg.substring(8);
				String[] mainStringORCAndOBR=newString.split("OBR");
				String orcStr="";
				String obrStr="OBR";
				orcStr=mainStringORCAndOBR[0].trim();
				obrStr="OBR"+mainStringORCAndOBR[1].trim();

				//-------------------------
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A03 adt3 = new ca.uhn.hl7v2.model.v23.message.ADT_A03();
				ORU_R01 message3 = new ORU_R01();

				message3.getMSH().getEncodingCharacters().setValue("^~\\&");
				message3.getMSH().getFieldSeparator().setValue("|");
				//ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
				ORU_R01_ORDER_OBSERVATION orderObservation3 = message1.getRESPONSE().getORDER_OBSERVATION();
				//ORU_R01_ORDER_OBSERVATION orderObservation = null;//= message1.getDSC().getContinuationPointer().

				// Populate the MSH Segment

				MSH mshSegment3 = adt3.getMSH();
				mshSegment3.getMsh1_FieldSeparator().setValue("|");
				mshSegment3.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment3.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment3.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("Discharge Patient");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment3.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				mshSegment3.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment3.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
				/*
				 * Accession No this will come from investigation details table
				 */
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				mshSegment3.getMsh10_MessageControlID().setValue(""+accessionNo);
				mshSegment3.getMsh11_ProcessingID().getProcessingMode().setValue("P");
				mshSegment3.getMsh12_VersionID().setValue(adt1.getVersion());

				DOB = res.getDate("date_of_birth");
				String abc3 ="";
				if(DOB!=null){
					abc3 = DateUtils.convertDatetoString(DOB);
				}
				// Populate the PID Segment
				PID pid3 = adt3.getPID();
				pid3.getPid3_PatientIDInternalID(0).getID().setValue(res.getString("hin_id"));
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid3.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
				pid3.getPid5_PatientName().getMiddleInitialOrName().setValue(res.getString("p_middle_name"));
				pid3.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
				pid3.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid3.getPid8_Sex().setValue(res.getString("administrative_sex_code"));

				PV1 pv3 = adt3.getPV1();
				 if (patientType.equalsIgnoreCase("IP")) {
					patientTypeFinal="I";
					String inpatient_id = DateUtils.convertSimple(res.getInt("inpatient_id"));
					pv3.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=res.getString("inpatient_id");
					roomType =res.getString(323);
					if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
					{
						DOA = res.getDate("date_of_addmission");
						TOA = res.getString("time_of_addmission");

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
//						TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = DateUtils.convertDatetoString(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv3.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}
				 pv3.getPv12_PatientClass().setValue(patientTypeFinal);

				 pv3.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
				 pv3.getPv18_ReferringDoctor(0).getIDNumber().setValue(res.getString("employee_id"));
				 pv3.getPv18_ReferringDoctor(0).getFamilyName().setValue(res.getString("last_name"));
				// pv3.getPv18_ReferringDoctor(0).getGivenName().setValue(res.getString("first_name").concat(res.getString("middle_name")));

				 PV2 dg1 = adt3.getPV2();

				 Parser p3 = new PipeParser();
				String encodedMessage3 = p3.encode(adt3);
				String[] mainStr3=encodedMessage3.split("PID");
				String mshStr3=mainStr3[0].trim();
				String pid3AndPv3Str3=mainStr3[1].trim();
				String[] mainStr4=pid3AndPv3Str3.split("PV1");
				String pidStr3="PID"+mainStr4[0].trim();
				String pv3Str3="PV1"+mainStr4[1].trim();
				
				
//------------------------
				mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+"\r"+orcStr+"\r"+obrStr+"\r"+mshStr3+"\r"+pidStr3+"\r"+pv3Str3+EndFormat2;
			//	mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+"\r"+orcStr+"\r"+obrStr+EndFormat2;

				System.out.println("final msg created at client----> "+mshPidPv1OrcObr);
				
				
			/*	int port = 5555;
	 		    String pacsServer="192.168.203.148";
	 		    Socket socket = new Socket(pacsServer, port);
	 		    //DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	             DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	            
				send(os, mshPidPv1OrcObr.getBytes());
				//doProcessResponse(con,socket);
				DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	            
	        	try
	        	{
	        		Statement stUpdate = con.createStatement();
	        		byte[] byteData = receive(is);
	        		String responseData = new String(byteData);

	        		Parser response_parser = new GenericParser();

	        		Message hapiMsg;


	        		// The parse method performs the actual parsing
	        		if(responseData.trim()!=""){
        			System.out.println("Server Response doProcessRequest= " + responseData.trim());
	        		
	        		hapiMsg = response_parser.parse(responseData.trim());


	        		if (hapiMsg instanceof ACK)
	        		{
	        			ACK ack = (ACK) hapiMsg;

	        		  System.out.println("inside ach msh"+ack.getMSH().getMsh3_SendingApplication());
		              System.out.println("inside ach msh"+ack.getMSH().getMsh5_ReceivingApplication());
		              System.out.println("inside ach msh"+ack.getMSH().getMsh4_SendingFacility());
		              System.out.println("inside ach msh"+ack.getMSH().getMsh6_ReceivingFacility());
	        			 
	        			
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh9_MessageType().getCm_msg1_MessageType());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh10_MessageControlID());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh11_ProcessingID());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh12_VersionID());
	        			System.out.println("**********************************************************");	                
	        			System.out.println("inside ach msa  "+ack.getMSA().getMsa1_AcknowledgementCode().getValue());
	        			System.out.println("inside ach msa  "+ack.getMSA().getMsa2_MessageControlID());
	        			System.out.println("inside ach msa  "+ack.getMSA().getMsa3_TextMessage().getValue());
	        			System.out.println("**********************************************************");	                
	        			System.out.println("inside ach err1  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue());
	        			System.out.println("inside ach err2  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe1_Identifier());
	        			System.out.println("inside ach err3  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe3_NameOfCodingSystem());

	        			if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA") 
	        					&& ack.getMSA().getMsa3_TextMessage().getValue() == null 
	        					&& ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
	        			{
	        				String assersionNo="";
	        				assersionNo=""+ack.getMSA().getMsa2_MessageControlID();
	        				
	        				if(assersionNo!=""){
	        					System.out.println("Assersion Id-AA->"+ack.getMSA().getMsa2_MessageControlID());
	        					String sql = "UPDATE dg_orderdt SET  msg_sent='y' WHERE  orderdt_id = "+Integer.parseInt(assersionNo);
	        					int updateCount = stUpdate.executeUpdate(sql); 
	        				}

	        				// updateCount contains the number of updated rows 
	        			}else if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AE") 
	        					&& ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
	        			{
	        				String assersionNo="";
	        				assersionNo=""+ack.getMSA().getMsa2_MessageControlID();
	        				String errorCode="";
	        				errorCode=""+ack.getMSA().getMsa6_ErrorCondition();
	        				String errorMessage="";
	        				errorMessage=""+ack.getMSA().getMsa3_TextMessage().getValue();
	        				if(assersionNo!=""){
	        					//pacs_error_message
	        					//pacs_error_code
	        					String sql = "UPDATE dg_orderdt SET  msg_sent='e',pacs_error_message="+errorMessage+ " , pacs_error_code="+errorCode+ "  WHERE  orderdt_id = "+Integer.parseInt(assersionNo);
	        					int updateCount = stUpdate.executeUpdate(sql); 
	        				}

	        				// updateCount contains the number of updated rows 
	        			}			                			                
	        		}
	        		}else{
	        			//System.out.println("*************Blank Response****************");
	        		}

	        	}
	        	catch (Exception e)
	        	{
	        		System.out.println("Exception: " + e.getMessage());
	        	}*/
			}
			res_mainChargeCode.close();
			st2.close();
		}
		res.close();
		st.close();
	} catch (Exception e) {
		flag=false;
		e.printStackTrace();
	}
	return flag;
}
/**
 * doProcessRequestCancle() Create Database and PACS Server Socket Connection and Send Requisition in HL7 2.3 Version {Radiology Requisition} to PACS Server and Get Response in HL7 2.3 Version On the Behalf of response {AA means Receive Successfully an AE means Some error Occurred} and msg_sent Status(y=Send Successfully ,n=Not Send , c=Cancel Successfully)  And department_type_id=12{Only Radiology}
 * @author Mukesh.narayan
 * @Date 22 July 2011
 * @param  String databaseUrl
 * @param  String databaseDriverName
 * @param  String databaseUserName
 * @param  String databasePassword
 * @return {@link Boolean}
 */
	
public static boolean doProcessRequestCancle(String databaseUrl,String databaseDriverName,String databaseUserName,String databasePassword) throws Exception
{
	boolean flag=true;
	java.sql.Connection con = null;
    
   
     Class.forName(databaseDriverName).newInstance();
	con = DriverManager.getConnection(databaseUrl, databaseUserName, databasePassword);

	Statement st = con.createStatement();
	

	String query = "SELECT * FROM dg_orderhd dg left outer join dg_orderdt dt on dt.orderhd_id = dg.orderhd_id "+
	" left outer join  patient p on  p.hin_id = dg.hin_id  "+
	" left outer join mas_administrative_sex sexid on sexid.administrative_sex_id  = p.sex_id "+
	" left outer join  mas_employee emp on dg.prescribed_by = emp.employee_id "+
	" left outer join inpatient inp on dg.inpatient_id = inp.inpatient_id "+
	" left outer join mas_charge_code mcc on dt.charge_code_id = mcc.charge_code_id "+
	" left outer join visit v on dg.visit_id= v.visit_id "+
	" left outer join mas_department dept on v.department_id= dept.department_id "+
	"left outer join mas_department deptInv on inp.department_id= deptInv.department_id ";
	//" WHERE dt.msg_sent = 'y' and dt.pacs_status='n' and dt.order_cancel_status='y'";
	try {
		ResultSet res = st.executeQuery(query);
		while (res.next())
		{
			Date DOB = null;
			Date DOA = null;
			String TOA = null;
			String adtym = "";
			String doa_val = null;
			Statement st2 = con.createStatement();
			int accessionNo = res.getInt("orderdt_id");
			int mainChargeCodeId = res.getInt("main_chargecode_id");
			
			//String mainQuery = "select main_chargecode_name from mas_main_chargecode where main_chargecode_id = "+mainChargeCodeId;
			String mainQueryRaidio="";
			mainQueryRaidio="select main_chargecode_name from mas_main_chargecode mmc left outer join mas_department dept on dept.department_id= mmc.department_id"+ 
			"left outer join mas_department_type deptType on deptType.department_type_id= dept.department_type_id where  deptType.department_type_id=12 and mmc.main_chargecode_id = "+mainChargeCodeId;
			


			ResultSet res_mainChargeCode = st2.executeQuery(mainQueryRaidio);
			String mshPidPv1OrcObr="";
			while(res_mainChargeCode.next())
			{
				String mainCName = res_mainChargeCode.getString("main_chargecode_name");
				/*if(mainCName.equalsIgnoreCase("XRAY") || mainCName.equalsIgnoreCase("ULTRASOUND")
			  || mainCName.equalsIgnoreCase("CT SCAN") || mainCName.equalsIgnoreCase("MRI"))
		   	  {*/
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A01 adt1 = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
				ORU_R01 message1 = new ORU_R01();

				message1.getMSH().getEncodingCharacters().setValue("^~\\&");
				message1.getMSH().getFieldSeparator().setValue("|");
				//ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
				ORU_R01_ORDER_OBSERVATION orderObservation = message1.getRESPONSE().getORDER_OBSERVATION();
				//ORU_R01_ORDER_OBSERVATION orderObservation = null;//= message1.getDSC().getContinuationPointer().

				// Populate the MSH Segment

				MSH mshSegment = adt1.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("INSTAPACS");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
				/*
				 * Accession No this will come from investigation details table
				 */
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				mshSegment.getMsh10_MessageControlID().setValue(""+accessionNo);
				mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("P");
				mshSegment.getMsh12_VersionID().setValue(adt1.getVersion());

				DOB = res.getDate("date_of_birth");
				String abc ="";
				if(DOB!=null){
					abc = DateUtils.convertDatetoString(DOB);
				}
				// Populate the PID Segment
				PID pid = adt1.getPID();
				pid.getPid3_PatientIDInternalID(0).getID().setValue(res.getString("hin_id"));
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
				pid.getPid5_PatientName().getMiddleInitialOrName().setValue(res.getString("p_middle_name"));
				pid.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid.getPid8_Sex().setValue(res.getString("administrative_sex_code"));

				PV1 pv1 = adt1.getPV1();
				/*
				 * This Block is changed By Mukesh On Date 10 Jun 2011
				 */
				String patientType=res.getString("patient_type");
				String patientTypeFinal="";
				String vistIdAndPatient="";
				String roomType="";
				if(patientType.equalsIgnoreCase("OP")){
					patientTypeFinal="O";
					String visitId = DateUtils.convertSimple(res.getInt("visit_id"));
					pv1.getPv119_VisitNumber().getID().setValue(visitId);
					vistIdAndPatient=res.getString("visit_id");
					roomType =res.getString("department_name");

					if(res.getDate("visit_date") != null || res.getString("visit_time") != null)
					{
						DOA = res.getDate("visit_date");
						TOA = res.getString("visit_time");

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = DateUtils.convertDatetoString(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}else if (patientType.equalsIgnoreCase("IP")) {
					patientTypeFinal="I";
					String inpatient_id = DateUtils.convertSimple(res.getInt("inpatient_id"));
					pv1.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=res.getString("inpatient_id");
					roomType =res.getString(323);
					if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
					{
						DOA = res.getDate("date_of_addmission");
						TOA = res.getString("time_of_addmission");

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = DateUtils.convertDatetoString(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}
				pv1.getPv12_PatientClass().setValue(patientTypeFinal);

				pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
				pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(res.getString("employee_id"));
				pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(res.getString("last_name"));
				pv1.getPv18_ReferringDoctor(0).getGivenName().setValue(res.getString("first_name").concat(res.getString("middle_name")));

				ORC orc = orderObservation.getORC();
				orc.getOrc1_OrderControl().setValue("CA");            // Cancle Order
				/*
				 * Code changed By Mukesh for accessionNo
				//orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
				 */
				//orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+accessionNo);

				orc.insertOrc2_PlacerOrderNumber(0).getEi1_EntityIdentifier().setValue(""+accessionNo);
				orc.getOrc5_OrderStatus().setValue("SC");             // ( = In Progress Scheduled)
				orc.getDateTimeOfTransaction().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				/*
				 * Code changed By Mukesh for Hin_id
				orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue("1234"); //Order Entry Person (ID)
				 */

				orc.getOrc10_EnteredBy().getIDNumber().setValue(res.getString("employee_id")); //Order Entry Person (ID)
				//orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue("Abhi Gupta"); //Order Entry Person (Name)
				orc.getOrc10_EnteredBy().getFamilyName().setValue(res.getString("last_name"));
				orc.getOrc10_EnteredBy().getGivenName().setValue(res.getString("first_name"));
				orc.getOrc10_EnteredBy().getMiddleInitialOrName().setValue(res.getString("middle_name"));

				// Populate the OBR
				ca.uhn.hl7v2.model.v23.segment.OBR obr = orderObservation.getOBR();
				/*
				 * Code changed By Mukesh for accessionNo
				obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
				 */
				obr.insertObr2_PlacerOrderNumber(0).getEi1_EntityIdentifier().setValue(""+accessionNo);


				obr.getObr3_FillerOrderNumber().getEi1_EntityIdentifier().setValue(res.getString("order_no"));

				obr.getObr3_FillerOrderNumber().getEi2_NamespaceID().setValue(vistIdAndPatient);
				obr.getObr3_FillerOrderNumber().getEi3_UniversalID().setValue(patientTypeFinal);
				obr.getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue(res.getString("charge_code_code"));
				obr.getObr4_UniversalServiceIdentifier().getCe2_Text().setValue(res.getString("charge_code_name"));
				//obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				obr.getObr13_RelevantClinicalInformation().setValue(res.getString("clinical_note"));


				obr.getObr16_OrderingProvider(0).getIDNumber().setValue(res.getString("employee_id"));
				obr.getObr16_OrderingProvider(0).getFamilyName().setValue(res.getString("last_name"));
				obr.getObr16_OrderingProvider(0).getGivenName().setValue(res.getString("first_name"));
				obr.getObr16_OrderingProvider(0).getMiddleInitialOrName().setValue(res.getString("middle_name"));
				//obr.getObr16_OrderingProvider().getCn3_GivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));

				obr.getObr24_DiagnosticServiceSectionID().setValue(mainCName);

				obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				//Order Scheduling Details (will not be present if HIS does not have scheduling engine

				// Now, let's encode the message and look at the output
				char BeginFormat = (char)0x0B;
				//char EndFormat1 = (char)0x1C;
				char EndFormat2 = (char)0x0D;

				Parser p1 = new PipeParser();
				String encodedMessage = p1.encode(adt1);

				String[] mainStr=encodedMessage.split("PID");
				String mshStr=mainStr[0].trim();
				String pidAndPv1Str=mainStr[1].trim();
				String[] mainStr2=pidAndPv1Str.split("PV1");
				String pidStr="PID"+mainStr2[0].trim();
				String pv1Str="PV1"+mainStr2[1].trim();

				String encMsg = p1.encode(message1);
				String newString = encMsg.substring(8);
				String[] mainStringORCAndOBR=newString.split("OBR");
				String orcStr="";
				String obrStr="OBR";
				orcStr=mainStringORCAndOBR[0].trim();
				obrStr="OBR"+mainStringORCAndOBR[1].trim();
//-------------------------
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A03 adt3 = new ca.uhn.hl7v2.model.v23.message.ADT_A03();
				ORU_R01 message3 = new ORU_R01();

				message3.getMSH().getEncodingCharacters().setValue("^~\\&");
				message3.getMSH().getFieldSeparator().setValue("|");
				//ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
				ORU_R01_ORDER_OBSERVATION orderObservation3 = message1.getRESPONSE().getORDER_OBSERVATION();
				//ORU_R01_ORDER_OBSERVATION orderObservation = null;//= message1.getDSC().getContinuationPointer().

				// Populate the MSH Segment

				MSH mshSegment3 = adt3.getMSH();
				mshSegment3.getMsh1_FieldSeparator().setValue("|");
				mshSegment3.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment3.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment3.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("Discharge Patient");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment3.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				mshSegment3.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment3.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
				/*
				 * Accession No this will come from investigation details table
				 */
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				mshSegment3.getMsh10_MessageControlID().setValue(""+accessionNo);
				mshSegment3.getMsh11_ProcessingID().getProcessingMode().setValue("P");
				mshSegment3.getMsh12_VersionID().setValue(adt1.getVersion());

				DOB = res.getDate("date_of_birth");
				String abc3 ="";
				if(DOB!=null){
					abc3 = DateUtils.convertDatetoString(DOB);
				}
				// Populate the PID Segment
				PID pid3 = adt3.getPID();
				pid3.getPid3_PatientIDInternalID(0).getID().setValue(res.getString("hin_id"));
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid3.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
				pid3.getPid5_PatientName().getMiddleInitialOrName().setValue(res.getString("p_middle_name"));
				pid3.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
				pid3.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid3.getPid8_Sex().setValue(res.getString("administrative_sex_code"));

				PV1 pv3 = adt3.getPV1();
				 if (patientType.equalsIgnoreCase("IP")) {
					patientTypeFinal="I";
					String inpatient_id = DateUtils.convertSimple(res.getInt("inpatient_id"));
					pv3.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=res.getString("inpatient_id");
					roomType =res.getString(323);
					if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
					{
						DOA = res.getDate("date_of_addmission");
						TOA = res.getString("time_of_addmission");

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = DateUtils.convertDatetoString(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv3.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}
				 pv3.getPv12_PatientClass().setValue(patientTypeFinal);

				 pv3.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
				 pv3.getPv18_ReferringDoctor(0).getIDNumber().setValue(res.getString("employee_id"));
				 pv3.getPv18_ReferringDoctor(0).getFamilyName().setValue(res.getString("last_name"));
				 pv3.getPv18_ReferringDoctor(0).getGivenName().setValue(res.getString("first_name").concat(res.getString("middle_name")));

				 PV2 dg1 = adt3.getPV2();

				 Parser p3 = new PipeParser();
				String encodedMessage3 = p3.encode(adt3);
				String[] mainStr3=encodedMessage3.split("dfsdfsd");
				String mshStr3=mainStr[0].trim();
				String pid3AndPv3Str3=mainStr3[1].trim();
				String[] mainStr4=pid3AndPv3Str3.split("PV342341");
				String pidStr3="PIDsds"+mainStr4[0].trim();
				String pv1Str3="PV1sadas"+mainStr4[1].trim();

				String encMsg3 = p3.encode((Message) mshSegment3);
				String newString3 = encMsg3.substring(8);
				
				
				
				
//------------------------
				mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+"\r"+orcStr+"\r"+obrStr+"\r"+mshStr3+"/"+pidStr3+EndFormat2;
				adtym = "";

				
				/*int port = 5555;
	 		    String pacsServer="192.168.203.148";
	 		    Socket socket = new Socket(pacsServer, port);
	 		    //DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	             DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	            
				send(os, mshPidPv1OrcObr.getBytes());
				//doProcessResponse(con,socket);
				DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	           
	        	try
	        	{
	        		Statement stUpdate = con.createStatement();
	        		 while (true)
	                    {
	        		byte[] byteData = receive(is);
	        		String responseData = new String(byteData);

	        		Parser response_parser = new GenericParser();

	        		Message hapiMs


	        		// The parse method performs the actual parsing
	        		if(responseData!="")	
	        		hapiMsg = response_parser.parse(responseData.trim())


	        		if (hapiMsg instanceof ACK)
	        		{
	        			ACK ack = (ACK) hapiMsg;
	        			System.out.println("inside ach msh"+ack.getMSH().getMsh3_SendingApplication())					              System.out.println("inside ach msh"+ack.getMSH().getMsh5_ReceivingApplication())					              System.out.println("inside ach msh"+ack.getMSH().getMsh4_SendingFacility())					              System.out.println("inside ach msh"+ack.getMSH().getMsh6_ReceivingFacility())	
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh9_MessageType().getCm_msg1_MessageType());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh10_MessageControlID());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh11_ProcessingID());
	        			System.out.println("inside ach msh "+ack.getMSH().getMsh12_VersionID());
	        			System.out.println("**********************************************************");	                
	        			System.out.println("inside ach msa  "+ack.getMSA().getMsa1_AcknowledgementCode().getValue());
	        			System.out.println("inside ach msa  "+ack.getMSA().getMsa2_MessageControlID());
	        			System.out.println("inside ach msa  "+ack.getMSA().getMsa3_TextMessage().getValue());
	        			System.out.println("**********************************************************");	                
	        			System.out.println("inside ach err1  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue());
	        			System.out.println("inside ach err2  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe1_Identifier());
	        			System.out.println("inside ach err3  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe3_NameOfCodingSystem());

	        			if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA") 
	        					&& ack.getMSA().getMsa3_TextMessage().getValue() == null 
	        					&& ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
	        			{
	        				String assersionNo="";
	        				assersionNo=""+ack.getMSA().getMsa2_MessageControlID();
	        				
	        				if(assersionNo!=""){
	        					String sql = "UPDATE dg_orderdt SET  msg_sent='c' WHERE  orderdt_id = "+Integer.parseInt(assersionNo);
	        					int updateCount = stUpdate.executeUpdate(sql); 
	        				}

	        				// updateCount contains the number of updated rows 
	        			}else if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AE") 
	        					&& ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
	        			{
	        				String assersionNo="";
	        				assersionNo=""+ack.getMSA().getMsa2_MessageControlID();
	        				String errorCode="";
	        				errorCode=""+ack.getMSA().getMsa6_ErrorCondition();
	        				String errorMessage="";
	        				errorMessage=""+ack.getMSA().getMsa3_TextMessage().getValue();
	        				if(assersionNo!=""){
	        					//pacs_error_message
	        					//pacs_error_code
	        					String sql = "UPDATE dg_orderdt SET  msg_sent='e',pacs_error_message="+errorMessage+ " , pacs_error_code="+errorCode+ "  WHERE  orderdt_id = "+Integer.parseInt(assersionNo);
	        					int updateCount = stUpdate.executeUpdate(sql); 
	        				}

	        				// updateCount contains the number of updated rows 
	        			}			                			                
	        		}
	        		}else{
	        			System.out.println("*************Blank Response****************");
	        		}

	        	}
	        	catch (Exception e)
	        	{
	        		System.out.println("Exception: " + e.getMessage());
	        	}*/
			}
			
		}
	} catch (Exception e) {
		flag=false;
		e.printStackTrace();
	}
	return flag;
}
/**
 * doProcessGetRadOrderDetails() Create Database and PACS Server Socket Connection and get Query For Confirmation for creating Image on PACS Server in HL7 2.3 Version {Radiology Requisition} to PACS Server and Get Response in HL7 2.3 Version On the Behalf of response {AA means Receive Successfully an AE means Some error Occurred} and msg_sent Status(y=Send Successfully ,n=Not Send , c=Cancel Successfully)  And department_type_id=12{Only Radiology}
 * @author Mukesh.narayan
 * @Date 22 July 2011
 * @param  String databaseUrl
 * @param  String databaseDriverName
 * @param  String databaseUserName
 * @param  String databasePassword
 * @return {@link Boolean}
 */
    
  /*  public static boolean doProcessGetRadOrderDetails(String databaseUrl,String databaseDriverName,String databaseUserName,String databasePassword) throws Exception
{
	boolean flag=true;
	try {
		DataInputStream is;
		DataOutputStream os;
		int port = 5555;
	    String pacsServer="192.168.203.148";
	    Socket socket = new Socket(pacsServer, port);
		//System.out.println("Server Socket is Running...");
		//System.out.println("Server is waiting for Connections");

		//System.out.println("Server is waiting for Connections  111 ");
		is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		byte[] byteData = receive(is);
		String clientRequestMessage = new String(byteData).trim();
		if(clientRequestMessage.trim()!=""){
			System.out.println("Received Message = " + clientRequestMessage);
		}
	} catch (Exception e) {

		e.printStackTrace();
	}

	return flag;
}*/
/**
 * Method receives the Server Response
 */
public static byte[] receive(DataInputStream is) throws Exception
{
        try
        {
                byte[] inputData = new byte[1024];
                is.read(inputData);
                return inputData;
        }
        catch (Exception exception)
        {
                throw exception;
        }
}

/**
 * Method used to Send Request to Server
 */
        public static void send(DataOutputStream os, byte[] byteData) throws Exception
        {
                try
                {
                        os.write(byteData);
                        os.flush();
                }
                catch (Exception exception)
                {
                        throw exception;
                }
        }
        
}
