/*  functions for pop-up date calender */
nonEditableDate =""
datelink=""
var mn=['January','February','March','April','May','June','July','August','September','October','November','December'];

function buildCal(m, y,flg){

	var dim=[31,0,31,30,31,30,31,31,30,31,30,31];
	var oD = new Date(y, m-1, 1); //DD replaced line to fix date bug when current day is 31st
	oD.od=oD.getDay()+1; //DD replaced line to fix date bug when current day is 31st

	var scanfortoday=(y==start.getFullYear() && m==start.getMonth()+1)? start.getDate() : 0 //DD added
	dim[1]=(((oD.getFullYear()%100!=0)&&(oD.getFullYear()%4==0))||(oD.getFullYear()%400==0))?29:28;

	var t='<div><table class="caltable" cols="7"><tr>';
	t+='<td colspan="7" align="center">'+mn[m-1]+' - '+y+'</td></tr><tr align="center">';
	for(s=0;s<7;s++)
		t+='<td class="calheader" width="30">'+"SMTWTFS".substr(s,1)+'</td>';
	t+='</tr><tr>';
	for(i=1;i<=42;i++){
		var x=((i-oD.od>=0)&&(i-oD.od<dim[m-1]))? i-oD.od+1 : '&nbsp;';
		if(i==36 && x=='&nbsp;')
			break;
		if(x!='&nbsp;'){

			dd=((x.toString()).length==1)? '0'+x : x
			mm=((oD.getMonth()+1).toString().length==1)? '0'+(oD.getMonth()+1) : (oD.getMonth()+1)
			datelink=dd+'/'+mm+'/'+oD.getFullYear()
			tmp='window.opener.dateobj1.value=\''+datelink+'\';'
			if(flg)
				tmp+='window.opener.displayAge(\''+datelink+'\');'
			tmp+='window.close()';			

		}	 
		else{
			tmp=''
		}
		if (x==scanfortoday) //DD added
		{
			t+='<td class="today" align="center" onclick="'+tmp+'"><a href="javascript:'+tmp+'">'+x+'</a></td>';
		}
		else if(x == "&nbsp;")
			t+='<td class="date" align="center" >&nbsp;</td>';
		else{
			t+='<td class="date" align="center" onclick="'+tmp+'" ><a href="javascript:'+tmp+'">'+x+'</a></td>';
		}
		if(((i)%7==0)&&(i<36))t+='</tr><tr align="center">';
	}
	return t+='</tr></table><br /><center><a href="javascript:window.opener.dateobj1.value=\'\';window.close();">Clear Date</a></center></div>';

}
function setAge(age){

	if(currentDate && dateobj1.name == "dateOfBirth")	{
		dob = age;
		dob = new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
		one_day=1000*60*60*24
		diffDays = Math.ceil((currentDate.getTime() - dob.getTime())/one_day)
	}
}
var selectedmonth;
var selectedyear;
var start;
var dateobj1;
var serverdateobj;

function setdate(dateString,obj,flg){

	if(!flg)
		flg=false;
	dateobj1=obj
	var mn=['January','February','March','April','May','June','July','August','September','October','November','December'];
	if(dateobj1 && dateobj1.value!=""){
		
		start  = new Date(dateobj1.value.substring(6),(dateobj1.value.substring(3,5) - 1) ,dateobj1.value.substring(0,2));
	
		}
		
	else
	{
		start  = new Date(dateString.substring(6),(dateString.substring(3,5) - 1) ,dateString.substring(0,2));}
		
	selectedmonth=start.getMonth()
	
	
	selectedyear=start.getFullYear();
	
	
	t=buildCal((start.getMonth()+1),start.getFullYear(),flg)
	openWindow(t)
}
function openWindow(text){

var styleStr ='chrome,modal,centerscreen,personalbar=no,hotkeys=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbar=no,resizable=no,copyhistory=yes,width=220,height=240';
    msgWindow = window.open("","msg", styleStr);
    
	var calhed='<head><title>Select a Date</title><link href="/hms/jsp/css/hms_basic_style.css" rel="stylesheet" type="text/css" /></head>'	
	var	calender='<body onunload="window.opener.resetdates();"><table width="100%" border="0" cellpadding="0" cellspacing="0" ><tr><td><table width="100%"><tr><td><input name="back" type="button" class="buttoncell" id="btnchar2" value="&lt;&lt;" onclick="window.opener.prevmonth()" /></td><td align="center"><select name="year" class="Dropdown" id="size8" onchange="window.opener.changeyear(this.value)">'

	for(aa=(start.getFullYear()-80);aa<=(start.getFullYear()+20);aa++){
		calender+=(aa==selectedyear)? '<option selected="selected" value="'+aa+'">'+aa+'</option>' : '<option value="'+aa+'">'+aa+'</option>'	
	}
	calender+='</select></td><td align="right" ><input name="forward" type="button" class="buttoncell" id="btnchar2" value="&gt;&gt;" onclick="window.opener.nextmonth();" /></td></tr></table></td></tr><tr><td id="calendertext">'+text+'</td></tr></table></body>'

	msgWindow.document.writeln(calhed + calender);
	msgWindow.focus();
	msgWindow.document.close();
	
}

function nextmonth(){

	selectedmonth++;

	if(selectedmonth>11){
		selectedmonth=0
		selectedyear++;
		msgWindow.document.getElementById('size8').value=selectedyear
	}
	t=buildCal(selectedmonth+1,selectedyear)
	msgWindow.document.getElementById('calendertext').innerHTML=t
}
function prevmonth(){
	selectedmonth--;

	if(selectedmonth<0){
		selectedmonth=11
		selectedyear--;
		msgWindow.document.getElementById('size8').value=selectedyear
	}
	t=buildCal(selectedmonth+1,selectedyear)
	msgWindow.document.getElementById('calendertext').innerHTML=t
}
function changeyear(yearchng){
	selectedyear=yearchng;
	t=buildCal(selectedmonth+1,selectedyear)
	msgWindow.document.getElementById('calendertext').innerHTML=t
}

function resetdates(){
	tempdate  = start;
	selectedmonth=tempdate.getMonth()+1;
	selectedyear=tempdate.getFullYear();
}