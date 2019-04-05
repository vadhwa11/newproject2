package jkt.hms.pacs.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;


import jkt.hms.util.HMSUtil;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.examples.ExampleReceiverApplication;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ORU_R01;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v23.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class PacsHL7Service {
	
	public void sendService(String qr) throws SQLException, FileNotFoundException, IOException{
		//System.out.println("Ranjesh Prasad:  Pacs Integration");
		System.out.println("Ranjesh Prasad:  ----"+qr);
		qr="";
		java.sql.Connection con = null;
		URL	resourcePath = Thread.currentThread().getContextClassLoader().getResource("jdbc.properties");
		Properties pacProper = new Properties();
		pacProper.load(new FileInputStream(new File(resourcePath.getFile())));
		String url = pacProper.getProperty("database.url");
		String driverName =pacProper.getProperty("database.driver");
		String userName = pacProper.getProperty("database.user");
		String password = pacProper.getProperty("database.password");
		int port = Integer.parseInt(pacProper.getProperty("pacs.hl7.port"));
	
		LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
		PipeParser parser = new PipeParser(); // The message parser
		SimpleServer server = new SimpleServer(port, llp, parser);
			
		/*
		* The server may have any number of "application" objects registered to handle messages. We
		* are going to create an application to listen to ADT^A01 messages.
		*/
			 
		Application handler = new ExampleReceiverApplication();
		server.registerApplication("ADT", "A01", handler);
			   
		/*
		* We are going to register the same application to handle ADT^A02 messages. Of course, we
		* could just as easily have specified a different handler.
		*/
		
		server.registerApplication("ADT", "A02", handler);
		server.registerApplication("ORM", "O01", handler);
		server.start();
			 
		/*
		* Another option would be to specify a single application to handle all messages, like
		* this:
		* 
		* server.registerApplication("*", "*", handler);
		*/
			   
		// Start the server listening for messages
		//server.start();
		//System.out.println("server main "+server);
			   
		/*
		* Now, create a connection to that server, and send a message
		*/
			 
		try
		{
			 Class.forName(driverName).newInstance();
		     con = DriverManager.getConnection(url, userName, password);
		     ca.uhn.hl7v2.app.Connection connection = null;
		     try
		     {
		          Statement st = con.createStatement();
		          Statement st2 = con.createStatement(
                          ResultSet.TYPE_SCROLL_INSENSITIVE,
                          ResultSet.CONCUR_READ_ONLY);
		          Statement st3 = con.createStatement();
		          Statement st4 = con.createStatement();

		          String query = "SELECT  * FROM dg_orderhd dg left outer join dg_orderdt dt on dt.orderhd_id = dg.orderhd_id "+
		          " left outer join  patient p on  p.hin_id = dg.hin_id  "+
		          " left outer join mas_administrative_sex sexid on sexid.administrative_sex_id  = p.sex_id "+
		          " left outer join  mas_employee emp on dg.prescribed_by = emp.employee_id "+ 
		          " left outer join inpatient inp on dg.inpatient_id = inp.inpatient_id "+
		          " left outer join mas_charge_code mcc on dt.charge_code_id = mcc.charge_code_id "+ 
		          " left outer join mas_sub_chargecode mscc on dt.sub_chargeid = mscc.sub_chargecode_id "+
		          " WHERE dt.msg_sent = 'n' "+qr+" order by dg.orderhd_id  ";
		          
		          ResultSet res = st.executeQuery(query);
		          //System.out.println("Ranjesh Prasad:  Pacs Integration ->>>>--"+query);
			      Date DOB = null;
			      Date DOA = null;
			      String TOA = null;
			      String adtym = "";
			      String doa_val = null;
			      int count=1;
			      while (res.next())
			      {
			    	  int mainChargeCodeId = res.getInt("main_chargecode_id");
			    	  String subChargeCodeName = res.getString("sub_chargecode_name");
			    	  //System.out.println("mainChargeCodeId main>>> "+mainChargeCodeId);
			    	  
			    	  String mainQuery = "select main_chargecode_name from mas_main_chargecode where main_chargecode_id = "+mainChargeCodeId;
			    	  //System.out.println("mainQuery main "+mainQuery);
			    	  ResultSet res_mainChargeCode = st2.executeQuery(mainQuery);
			    	  String a1 = "";
			    	  a1 = res.getString("orderhd_id");
			    	  String mainQuery1 = "select d.orderdt_id from dg_orderdt d where d.orderhd_id = '"+a1+"'";
			    	  //System.out.println("Ranjesh>>"+mainQuery1);
			    	  ResultSet res_orderdt_id = st3.executeQuery(mainQuery1);
			    	  String a = "";
			    	  while(res_orderdt_id.next())
			    	  {
				    	//System.out.println(res_orderdt_id.getInt(1));
				    	a=""+(res_orderdt_id.getInt(1));
			    	  }
			    	  //System.out.println("res_mainChargeCode");
			    	  while(res_mainChargeCode.next())
			    	  {
			    	  //System.out.println("orderdt_id>>"+a);
			    	  
			    		 // String mainCName = res_mainChargeCode.getString("main_chargecode_name");
			    		  //System.out.println("mainCName main "+mainCName);
			    		  if(subChargeCodeName.equalsIgnoreCase("X-RAY") || subChargeCodeName.equalsIgnoreCase("ULTRA SOUND") || subChargeCodeName.equalsIgnoreCase("SONOGRAPHY")
			    			 || subChargeCodeName.equalsIgnoreCase("CT-SCAN") || subChargeCodeName.equalsIgnoreCase("MRI"))
			    		 //if(mainCName.equalsIgnoreCase("Radiology Services"))
			    		  {
			    			  String modality="";
			    			  switch(subChargeCodeName){
			    			  case "X-RAY":
			    				  modality="DX";
			    				  break;
			    			  case "ULTRA SOUND":
			    				  modality="US";
			    				  break;
			    			  case "SONOGRAPHY":
			    				  modality="SN";
			    				  break;
			    			  case "CT-SCAN":
			    				  modality="CT";
			    				  break;
			    			  case "MRI":
			    				  modality="MR";
			    				  break;
			    			  }
			    			 // modality="DX";
			    			  /*
			    			  //Start creating message
						  	  ADT_A01 adt1 = new ADT_A01();
						  	  ORU_R01 message1 = new ORU_R01();
						  		
						  	  message1.getMSH().getEncodingCharacters().setValue("^~\\&");
						  	  message1.getMSH().getFieldSeparator().setValue("|");
						  	  ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
						  	  
						  	  // Populate the MSH Segment
						  	  MSH mshSegment = adt1.getMSH();
						  	  mshSegment.getMsh1_FieldSeparator().setValue("|");
						  	  mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
						  	  //mshSegment.getMsh3_SendingApplication().setValue("HIS");...........
						  	  mshSegment.getMsh3_SendingApplication().setValue("MPA");
						  	  mshSegment.getMsh4_SendingFacility().setValue("HMS");
						  	  mshSegment.getMsh5_ReceivingApplication().setValue("IMPAX");
						  	  //mshSegment.getMsh5_ReceivingApplication().setValue("EKG"); 
						  	  mshSegment.getMsh6_ReceivingFacility().setValue("JKTPACS"); 
						  	  mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmm"));
						  	  mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
						  	  mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
						  	  //mshSegment.getMsh10_MessageControlID().setValue("1001");
						  	  mshSegment.getMsh10_MessageControlID().setValue(a);
						  	  mshSegment.getMsh11_ProcessingID().setValue("P");
						  	  mshSegment.getMsh12_VersionID().setValue("2.3.1"); 
						  	  //System.err.println("PPppp====>"+mshSegment.getMessage());
						  	  DOB = res.getDate("date_of_birth");
						  	  String pAge= res.getString("age");
						  	  String abc="";
						  	  if(DOB!=null){
						  		  abc= HMSUtil.convertDatetoString(DOB);
						  	  }else if(pAge!=null){
						  		  abc=HMSUtil.calculateAgeForADT(pAge, new Date()); 
						  	  }else{
						  		 abc = HMSUtil.convertDatetoString(new Date());
						  	  } 
						  	  // Populate the PID Segment
						  	  PID pid = adt1.getPID(); 
						  	  pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue(res.getString("hin_id"));
//						  	  pid.getPid4_AlternatePatientID().setValue(res.getString("hin_id"));
						  	  pid.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
						  	  pid.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
						  	  pid.getPid6_MotherSMaidenName().setValue(res.getString("p_first_name"));
						  	  if(abc!=null && !"".equals(abc)){
						  		 pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
						  	  } else{
						  		 pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(HMSUtil.convertDatetoString(new Date()));
						  	  }
						  	  pid.getPid8_Sex().setValue(res.getString("administrative_sex_code"));
						  	  pid.getPid11_PatientAddress(0);
						  	  pid.getPid19_SocialSecurityNumberPatient().setValue(a);
						  	  pid.getPid27_VeteransMilitaryStatus().setValue("Single");
						  	//System.err.println("PIDppp====>"+pid.getMessage());      
						  	  PV1 pv1 = adt1.getPV1();
						  	  pv1.getPv12_PatientClass().setValue(res.getString("patient_type"));
//						  	  pv1.getPv18_ReferringDoctor().getIDNumber().setValue(res.getString("pe_no"));
						  	  //pv1.getPv18_ReferringDoctor().getGivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
						  	     
						  	  String visitId = HMSUtil.convertSimple(res.getInt("visit_id"));
						  	  pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue(visitId);
						  	  if(res.getString("patient_type").equalsIgnoreCase("IP")){
						  	  if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
						  	  {
						  		  DOA = res.getDate("date_of_addmission");
						  		  TOA = res.getString("time_of_addmission");
							  	  TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
							  	 // TOA =  TOA.substring(0, 4).concat(TOA.substring(5));
								  doa_val = HMSUtil.convertDatetoString(DOA);
								  adtym = adtym.concat(doa_val).concat(TOA);
//								  pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						  	  }
						  	  }else{ // for OP 
						  		DOA = res.getDate("order_date");
						  		  TOA = res.getString("order_time");
							  	  TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
							  	 // TOA =  TOA.substring(0, 4).concat(TOA.substring(5));
								  doa_val = HMSUtil.convertDatetoString(DOA);
								  adtym = adtym.concat(doa_val).concat(TOA);
//								  pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						  	  } 
						  	//System.err.println("PV1====>"+pv1.getMessage());      
						  	
						  	  // Populate the ORC
						  	  ORC orc = orderObservation.getORC();
						  	  orc.getOrc1_OrderControl().setValue("NW");            // New order
						  	  // orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
						  	  orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+a);
						  	  orc.getOrc3_FillerOrderNumber().getCm_filler1_UniqueFillerId().setValue(res.getInt("bill_id")+"");
						  	  orc.getOrc5_OrderStatus().setValue("SC");             // ( = In Progress Scheduled)
						  	  orc.getDateTimeOfTransaction().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(res.getString("hin_no")); //Order Entry Person (ID)
						  	  orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue(res.getString("next_of_kin_name")); //Order Entry Person (Name)
						  	  orc.getOrc12_OrderingProvider().getCn12_OnlineNummer().setValue(res.getString("charge_code_name"));
						  	  orc.getOrc17_EnteringOrganization().getCe2_Text().setValue("JKT");
						  	  //orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(""+res.getInt("employee_id")); //Order Entry Person (ID)
						  	  //orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue("Abhi Gupta"); //Order Entry Person (Name)
						  	  //System.err.println("ORC====>"+orc.getMessage());    
						  	    
							  // Populate the OBR
						  	  OBR obr = orderObservation.getOBR();
						  	  //obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
						  	  obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(a+"."+count);
						  	  //obr.getObr3_FillerOrderNumber().getCm_filler1_UniqueFillerId().setValue(res.getInt("bill_id")+""); 
						  	  //obr.getObr4_UniversalServiceID().getCe1_Identifier().setValue(res.getString("charge_code_code"));
						  	  obr.getObr4_UniversalServiceID().getCe1_Identifier().setValue(""+res.getInt("charge_code_id"));
						  	  //obr.getObr4_UniversalServiceID().getCe2_Text().setValue(res.getString("charge_code_name"));
						  	  obr.getObr4_UniversalServiceID().getCe2_Text().setValue(res.getString("charge_code_name"));
//						  	  obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  obr.getObr13_RelevantClinicalInformation().setValue(res.getString("clinical_note"));
						  	  obr.getObr16_OrderingProvider().getCn1_IDNumber().setValue(res.getInt("bill_id")+"");
						  	  obr.getObr16_OrderingProvider().getCn3_GivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
						  	  obr.getObr19_PlacerField2().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss")+"."+count);
						  	  obr.getObr20_FillerField1().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss")+"."+count);
						  	  count = count+1;
						  	  obr.getObr21_FillerField2().setValue(res.getString("charge_code_name"));
//						  	  obr.getObr22_ResultsReportStatusChangeDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
//						  	  obr.getObr23_ChargeToPractice().getCm_moc2_ChargeCode().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  obr.getObr24_DiagnosticServiceSectionID().setValue(res.getString("charge_code_code"));
						  	  obr.getObr24_DiagnosticServiceSectionID().setValue(modality);
						  	  obr.getObr27_QuantityTiming(0);
//						  	  obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  //Order Scheduling Details (will not be present if HIS does not have scheduling engine
						  	   
						  	System.err.println("OBR--->  "+obr.getMessage()); 
						  	  // Now, let's encode the message and look at the output
						  	  Parser p1 = new PipeParser(); 
						  	  String encodedMessage = p1.encode(adt1); 
						  	  String encMsg = p1.encode(message1);
						  	  String newString = encMsg.substring(8);
							  //System.out.println("Ranjesh "+message1);
						  	  //System.out.println("Start String"); 
							  //System.out.println(encMsg+"<---Ranjesh---->"+newString);
							  //System.out.println("End String"); 
						  	  */
			    			  String msg="MSH|^~\\&|JKT_HL7_CLIENT|HMS|JKT_HL7_SERVER|RADIOLOGY_VBCH|"+HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss")+"||ORM^O01|"+res.getInt("orderdt_id")+"|P|2.3||||AL||||\r"+
										"PID|||"+res.getInt("hin_no")+"||"+res.getString("p_first_name")+"^"+res.getString("p_last_name")+"||"+HMSUtil.convertDatetoString(res.getDate("date_of_birth"))+"|"+res.getString("administrative_sex_code")+"||||||||||||||||||||||\r"+
										"PV1||O||||||"+res.getString("first_name")+" "+res.getString("last_name")+"^"+res.getString("first_name")+" "+res.getString("last_name")+"|||||||||||"+res.getInt("visit_id")+"||||||||||||||||||||||||||||||||\r"+
										"ORC|NW||||||^^^"+HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss")+"|||||"+res.getString("charge_code_name")+"^"+res.getString("charge_code_name")+"|||||"+res.getString("charge_code_name")+"|||||||\r"+
										"OBR||"+res.getInt("orderdt_id")+"||"+res.getString("charge_code_name")+"^Cor pulmo^mpa^"+res.getString("charge_code_name")+"^"+modality+"^mpa||||||||||||"+res.getString("charge_code_name")+"^"+res.getString("charge_code_name")+"||"+res.getInt("orderdt_id")+"|"+res.getInt("orderdt_id")+"|||||"+modality+"|||||||||||||||||||||\r"+
										"ZDS|"+res.getInt("orderdt_id");
//			    			  System.out.println("====>"+msg);
						  	  Parser p = new GenericParser();
						  	  Message adt = p.parse(msg);
						  	 // The connection hub connects to listening servers
							  ConnectionHub connectionHub = ConnectionHub.getInstance();
							 // A connection object represents a socket attached to an HL7 server
							  String pacsServer= pacProper.getProperty("pacs.hl7.server");
							  //connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
							  connection = connectionHub.attach(pacsServer, port, new PipeParser(), MinLowerLayerProtocol.class);
							  // The initiator is used to transmit unsolicited messages
							  Initiator initiator = connection.getInitiator();
							  System.setProperty("ca.uhn.hl7v2.app.initiator.timeout",
									  Integer.toString(10));
							 // System.out.println(initiator+"-**-"+connection+"   "+adt.getName());6000000
							  Message response = initiator.sendAndReceive(adt);
							  String responseString = parser.encode(response);
							  System.out.println("Received response:\n" + responseString);
							  Parser response_parser = new GenericParser();
						      Message hapiMsg;
						      try
						      {
						    	  // The parse method performs the actual parsing
						       	  hapiMsg = response_parser.parse(responseString);
						       	  System.out.println("hapiMsg="+hapiMsg);
						       	   if (hapiMsg instanceof ACK)
						          {
						       		  ACK ack = (ACK) hapiMsg;
						       		  System.out.println("Recieve acknowledge");
						                   
						             /* System.out.println("inside ach msh "+ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
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
						               */  
						               if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA") 
						                  && ack.getMSA().getMsa2_MessageControlID().getValue().equals(res.getString("orderdt_id")))
						              {  //System.out.println("update ");
						                	String sql = "UPDATE dg_orderdt SET  msg_sent='y' WHERE  orderhd_id = "+res.getInt("orderhd_id")+" and orderdt_id = "+res.getInt("orderdt_id");
						                	int updateCount = st4.executeUpdate(sql); 
//						                	System.out.println("update2 ");
						              }	
						          }else{
						        	  System.out.println("else of pacs");
						          }
						      }
						      catch (EncodingNotSupportedException e)
						      {
						    	  e.printStackTrace();
						    	  System.out.println("EncodingNotSupportedException="+e);
						    	  return;
						      }
						      catch (HL7Exception e)
						      {
						    	  e.printStackTrace();
						    	  
						    	  System.out.println("HL7Exception="+e);
						    	  return;
						      }
						      adtym = "";
			    		  }
			    		  else
			    		  {
			    			 // System.out.println("Ranjesh Prasad:  Pacs Integration Different Charge Code......");
			    		  }
			    	  }
			      }
		     }
			 catch(SQLException s)
			 {
				 s.printStackTrace();
			     System.out.println("Ranjesh Prasad:  Pacs Integration SQL query does not execute."+s);
			 }
			 finally
			 {
				 con.close();
			     server.stop();
			     System.out.println("finally block");
			 }
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    System.out.println("last catch block");
		    
		}
	
}
}
