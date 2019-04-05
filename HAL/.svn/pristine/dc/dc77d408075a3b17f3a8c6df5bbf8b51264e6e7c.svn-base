/*-----------------------Validations------------------------------------------*/

errorMsg ="";
function validateFields(formName){
	focusFlag = false;
	errors = "";
	errorMsg += loopThroughElements(formName);
/*	inputs = div.getElementsByTagName('input')
	if(inputs)
		errorMsg += loopThroughElements(inputs);
	inputs = div.getElementsByTagName('select')
	if(inputs)
		errorMsg += loopThroughElements(inputs);
	inputs = div.getElementsByTagName('textarea')
	if(inputs)
		errorMsg += loopThroughElements(inputs);
		*/
	if(errorMsg == "")
		return true;
	else{
		return errorMsg;
	}
}


function loopThroughElements(frmName){
	inputs = eval('document.'+frmName+'.elements');
	errors = "";
	for(i=0;i<inputs.length;i++){
		if(inputs[i].type == 'text' || inputs[i].type == 'select-one'|| inputs[i].type == 'select-multiple'|| inputs[i].type == 'textarea'){
			if(!inputs[i].getAttribute('validate'))
				continue;
			name = inputs[i].getAttribute('validate').substring(0,inputs[i].getAttribute('validate').indexOf(','));
			type = inputs[i].getAttribute('validate').substring(inputs[i].getAttribute('validate').indexOf(',')+1,inputs[i].getAttribute('validate').lastIndexOf(','));

			mandatory =inputs[i].getAttribute('validate').substring((inputs[i].getAttribute('validate').lastIndexOf(',')+1)); 
			textValue = trimAll(inputs[i].value);	
				
			/*if(inputs[i].value!= textValue){
				errors += "Remove trailing or leading spaces from the "+name + " field.\n" 
			}*/
			if(mandatory == "yes" & textValue == "")
				errors += name + " cannot be blank.\n";
			if(textValue!= "" & type == 'date'){
				if(!validateDate(textValue))
					errors += name + " is not a valid date (dd/mm/yyyy).\n";
			}
			else if(textValue!= "" & type == 'num'){
							  
				
				if(!validateNumeric(textValue))
					errors += name + " should be a number.\n";
			}
			
			else if(textValue!= "" & type == 'checkCurrency')
			{
			  
			   
			  if(document.getElementById('2').value=="")
			   	 errors += " Currency cannot be blank.\n";
			   
			     var  priceValue = document.getElementById('1').value; 	 
			   	 
			   	
			     
			     if(!validatePrice(priceValue))
			       
			         errors += " Price is not Valid.\n";
			}
			
			else if(textValue!= "" & type == 'checkPrice')
			{
			    if(document.getElementById('1').value=="")
			       errors += "Price cannot be blank.\n";
			}
			
			
			
			else if(textValue!= "" & type == 'price'){
				 
				 if(textValue.substring(0,1)=="."||textValue.substring(0,1)=="-")
				 {
		           		textValue="notValid";
		         }
				  
				  
				for(k=0;k<textValue.length;k++)
				{
				   tryflag=false;
					   
						if( parseInt(textValue.charAt(k))!=0 && textValue.charAt(k)!='.')
                        { 
						  tryflag = true
						}
						
					   
                }  
				  
				 if(textValue==0)
				 {
				     textValue="notValid";
				 } 
				
				 if(textValue.substring(textValue.length-1,textValue.length)==".")
				 {
				      textValue="notValid";
				 }
				 
				 if(!validateNumeric(textValue))
				  {
				   errors += name + " is not valid.\n";
				  }
			
			}
			else if(textValue!= "" & type == 'int'){
				if(!validateInteger(trimAll(textValue)))
					errors += name + " should be a number(without spaces).\n";						
			}
			else if(textValue!= "" & type == 'email'){
				if(!validateEmail(textValue))
					errors +="Enter valid Email-Id.\n";						
			}	
			else if(textValue!= "" & type == 'char'){
				if(!validateChar(textValue))
					errors += name + " should contain characters only.\n";						
			}		
				
			else if(textValue!= "" & type == 'passport'){
				if(!validatePassport(textValue))
					errors += "Enter a valid passport no.\n";						
			}	
			else if(textValue!= "" & type == 'pan'){
				if(!validatePan(textValue))
					errors += "Enter a valid pan no.\n";						
			}	
			else if(textValue!= "" & type == 'float'){
			
				if(!validateFloat(textValue))
					errors +=  name + " should contain decimal value only.\n";						
			}
			else if(textValue!= "" & type == 'price'){
					if(!chkSpaces(textValue)){
						errors += name + " cannot contain spaces.\n";	
					}else if(!validatePrice(textValue)){
						errors +=  name + " is not valid.\n";	
					}				
			}		
			else if(textValue!= "" & type == 'marksInPercentage'){
				if(!validateMarksInPercentage(textValue))
					errors += name + " should contain valid marks.\n";						
			}
			
			else if(textValue!= "" & type == 'nothing'){
								
			}
			else if(textValue!= "" & type == 'dateOfBirth'){
				if(!validateDateOfBirth(textValue))
					errors += "Please Enter Valid Date Of Birth\n";						
			}
			else if(textValue!= "" & type == 'EmpCode'){
				msg = validateEmployeeCode(textValue);
				if(msg !="")
				{
					errors += msg;
				}						
			}
			else if(textValue!= "" & type == 'name'){
				if(!chkSpaces(textValue))
					errors += name + " cannot contain spaces.\n";						
				else if(!validateName(textValue))
					errors += name + " is not a valid name.\n";						
			}
			else if(textValue!= "" & type == 'alphaspace'){
				if(!validateAlphaSpace(textValue))
					errors += "Field " + name + " is not valid.\n";						
			}
			else if(textValue!= "" & type == 'isbn'){
				    tryflag = true;
				  
				  
					for(k=0;k<textValue.length;k++)
					{
					    
					    tryflag=false;
					   
						if( parseInt(textValue.charAt(k))!=0 && textValue.charAt(k)!='-')
                        { 
						  tryflag = true
						}
						
					   
                    }  
				   
				   for(k=0;k<textValue.length;k++){
						if(isNaN(parseInt(textValue.charAt(k))) && textValue.charAt(k)!= "-")
							tryflag= false
					}
					
					var c=0;
					
					for(k=0;k<textValue.length;k++){
						
						if(textValue.charAt(k)!= "-")
						{
						  c++;
						}
					   
					}
					
					
					if(c!=10 && c!=13)
					{
						tryflag = false;
				    }
				
				    if(!tryflag)
				    {
					   errors += name + " is not valid.\n";
					   return errors;
				    }
				
				if(textValue.indexOf('-')==0){
					errors += name + " is not valid.\n";
					return errors;						
				}
				
				/*if(textValue.indexOf('-')==-1){
					errors += name + " is not valid.\n";
					return errors;						
				}*/
				
				/*if(textValue.length<10 || textValue.length==11 || textValue.length>13 )
				{
					errors += name + " is not valid.\n";
					return errors;						
				}*/
				
				if(textValue.substring(0,1)=="-")
				 {
		           		textValue="notValid";
		         }
				
				if(textValue.length>13)
				{
				    textValue="notValid";
        		} 
				
				 if(textValue.substring(textValue.length-1,textValue.length)=="-")
				 {
				     textValue="notValid";
				 }
				
				 if(!validateIsbn(textValue))
					errors += name + " is not valid.\n";						
			}
			else if(textValue!= "" & type == 'accno'){

				if(textValue.length<7){
					errors += name + " is not valid.\n";
					return errors;	
				}
				
				if(!validateGoodString(textValue))
					errors +="Field "+ name +" is not valid.\n";
				
				
			}
			else if(textValue!= "" & type == 'vol')
			
			{
			    
			    for(k=0;k<textValue.length;k++)
					{
					    
				        tryflag=false;
					   
						if( parseInt(textValue.charAt(k))!=0 && textValue.charAt(k)!='.')
                        { 
						  tryflag = true
						}
						
					   
                    }  
			    
			    if(!tryflag)
			    {
			      errors += name + " is not valid.\n";
			      return errors;
			    }
			    
			    if(!validateVol(textValue))
					errors += name + " is not valid.\n";
					
			    								
			
			}
			else if(textValue!= "" & type == 'weight'){
				if(!validateWeight(textValue))
					errors += "Please enter valid weight.\n";						
			}
			else if(textValue!= "" & type == 'phone'){
				if(!validatePhone(textValue))
					errors += "Please enter the valid " + name +  " number.\n";						
			}
			
			else if(textValue!= "" & type == 'empphone'){
				if(!validateEmployeePhone(textValue))
					errors += "Please enter the valid " + name +  " number.\n";						
			}
			
			else if(textValue!= "" & type == 'fullName'){
				if(!validateFullName(textValue))
					errors += name + " is not a valid name.\n";						
			}
			else if(textValue!= "" & type == 'company'){
				if(!validateCompany(textValue))
					errors += name + " is not valid.\n";						
			}
			
			else if(textValue!= "" & type == 'location'){
				if(!validateLocation(textValue))
					errors += name + " is not valid.\n";						
			}
			
			else if(textValue!= "" & type == 'remarks'){
				if(!validateRemarks(textValue))
					errors += name + " is not valid.\n";						
			}
								
			else if(textValue!= "" & type == 'summary'){
				if(!validateSummary(textValue))
					errors += name + " is not valid.\n";						
			}
			
			else if(textValue!= "" & type == 'dateOfJoining'){
				if(!validateDateOfJoining(textValue))
					errors += name + " is not valid.\n";
			}
			
			else if(textValue!= "" & type == 'employeeDateOfJoining'){
				if(!validateEmployeeDateOfJoining(textValue))
					errors += name + " is not valid.\n";
			}
			
			else if(textValue!= "" & type == 'dateOfInterview'){
				if(!validateDateOfInterview(textValue))
					errors += name + " is not valid.\n";						
			}
			
			else if(textValue!= "" & type == 'address'){
				if(!validateAddress(textValue))
					errors += "Field " + name + " is not valid Address.\n";						
			}
			else if(textValue!= "" & type == 'alphaAndSpace'){
				if(!validateAlphabetsAndSpace(textValue))
					errors +="Field "+ name +" is not valid.\n";
			}
			else if(textValue!= "" & type == 'contact'){
			   if(!validateContact(textValue))
					errors += name +" is not valid.\n";
			}
			else if(textValue!= "" & type == 'author'){
				if(!validateAuthor(textValue))
					errors +="Field "+ name +" is not valid.\n";
			}
			else if(textValue!= "" & type == 'goodString'){
				if(!validateGoodString(textValue))
					errors +="Field "+ name +" is not valid.\n";
			}	
			else if(textValue!= "" & type == 'alphanumeric1'){
				if(! validateAlphaNumeric1(textValue))
					errors +="Field "+ name +" is not valid.\n";
			}		
			else if(textValue!= "" & type == 'experience'){
				if(!validateExperience(textValue))
					errors += name +" is not valid.\n";
			}
			else if(textValue!= "" & type == 'salary'){
				if(!validateSalary(textValue))
					errors += name +" is not valid.\n";
			}
			
			if(errors!="" && !focusFlag){
				
				inputs[i].focus();
				focusFlag = true;
			}
			
			
		}
	}
	return errors;
}
function validateWeight( strValue ){
	if(validateInteger(strValue)){
		if(strValue <=0 || strValue >200)
			return false;
		return true;
	}
	else	
		return false;
	
}
function chkSpaces(strValue){
	for(j=0; j<strValue.length; j++){
		if(strValue[j]==" ")
			return false;
	}
	return true;
}

function validatePhone( strValue ) {
	if(strValue.length < 9 || strValue.length > 11)
 		return false;
   	else
  		return validateInteger(strValue);
}

function validateEmployeePhone( strValue ) {
	if(strValue.length <= 9 || strValue.length > 12)
 		return false;
   	else
  		return validateInteger(strValue);
}

function validateContact( strValue ){
	if(strValue.length <= 9 || strValue.length > 12)
 		return false;
   	else{  		
  			 var objRegExp  = /(^\d\d*$)/;
  			return objRegExp.test(strValue);	
  	}
		
}
function  validateName( strValue ) {
  var objRegExp = /[^a-z\d]/i;
  if(!(parseInt(strValue)>0))
  		return !objRegExp.test(strValue);
  return false;
  
}

function validateAddress( strValue ) {
	 
	var objRegExp  = /[^a-z*(\d\,\\\/\.\(\)\_\:\"\&\-\'\`\#\“\‘\n\r )]/i;
	if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
			return false;
	}
	else{
		return !objRegExp.test(strValue);
	}
	return false;
}

function validateGoodString( strValue ) {
	 
	var objRegExp  = /[^a-z*(\d\,\\\/\.\(\)\_\:\+\@\&\#\-\n\r )]/i;
	if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
			return false;
	}
	else{
		return !objRegExp.test(strValue);
	}
	return false;
}
function validateAlphaSpace( strValue ) {
	
	var objRegExp  = /[^a-z*(\d\,\\\/\.\(\)\_\:\"\&\-\'\`\#\“\‘\?\n\r )]/i;
	if(!(parseInt(strValue)>0)){
		if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
			return false;
		}
		else{
			return !objRegExp.test(strValue);
		}
	}
  	return false;
}

function validateIsbn( strValue ) {
	  
	//changed on 2/11/2006	
		if(strValue.substring(0,1)=="-" || strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "'" || strValue.substring(0,1) == "'" || strValue.substring(0,1) == "`"  || strValue.substring(0,1) == " "|| strValue.substring(0,1) == "#"|| strValue.substring(0,1) == ":" || strValue.substring(0,1) == "\"" ){
			return false;
		}
		else{
			return true;
		}
  	
}



function validateAlphabetsAndSpace( strValue ){
	var objRegExp  = /[^a-z ]/i;
		return !objRegExp.test(strValue);
}

function validateAuthor( strValue ){
	var objRegExp  = /[^a-z(\.\&  )]/i;
	
		return !objRegExp.test(strValue);
}
function validateFullName( strValue ) {
	
	var objRegExp  = /[^a-z*(\.\, )]/i;
	if(parseInt(strValue)>0){
		return false;
	}
	else if(strValue.substring(0,1) == ".")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}

function validateCompany( strValue ) {
	
	var objRegExp  = /[^a-z*(\.\-\&\d )]/i;
	if(strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "&")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}

function validateLocation( strValue ) {
	
	var objRegExp  = /[^a-z*(\.\-\&\d\s\:\@\#\$\^\*\(\)\{\}\[\]\;\"\,\<\>\?\/\_\\\+\=\|)]/i;
	if(strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "&")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}

function validateRemarks( strValue ) {
	
	var objRegExp  = /[^a-z*(\.\-\&\d\s\:\@\#\$\^\*\(\)\{\}\[\]\;\"\,\<\>\?\/\_\\\+\=)]/i;
	if(strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "&")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}

function validateVol( strValue ) {
	var objRegExp  = /[^a-z*(\d )]/i;
	if(strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "&")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}
function validateSummary( strValue ) {
	
	var objRegExp  = /[^a-z*(\.\d )]/i;
	if(strValue.substring(0,1) == ".")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}

function validateAlphaNumeric( strValue ) {
	
	var objRegExp  = /[^a-z*(\d)]/i;
	return !objRegExp.test(strValue);
	
}

function validateAlphaNumeric1( strValue ) {
	
	var objRegExp  = /[^a-z*(\d)]/i;
	return objRegExp.test(strValue);
	
}

function  validateNumeric( strValue ) {
  var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateInteger( strValue ) {
  var objRegExp  = /(^\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateChar( strValue ) {
	var objRegExp  =  /[^a-z]/i;
  	return !objRegExp.test(strValue);
}

function validateFloat( strValue ) {
 	var objRegExp  =/^((\+|-)\d)?\d*(\.\d{2})?$/;
 	return objRegExp.test(strValue);
}


function validatePrice( strValue ) {
	var objRegExp  =/^(\d+([-+.]\d+)?)/;
    
    if(!validateInteger(strValue))
    {
      
      return false;
    }  
   	if(strValue.substring(0,1)==".")
		return false;
	else
		return objRegExp.test(strValue);
    if(strValue.value==0)
      return false; 
   
   if(!validateFloat(strValue))
    {
      return false;
    } 
  	
  	return strValue;
}

function validateMarksInPercentage( strValue ) {
  if(validateFloat)
  	if(strValue >= 33 && strValue <= 100)
  		return true;
  return false;
}

function validateExperience( strValue ) {
 
 	if(strValue.indexOf(".")!= -1) 
	{
 		var decimalvalue = strValue.substring(strValue.indexOf(".") + 1,strValue.length);
 		if(decimalvalue.length >= 3 || decimalvalue >= 12)
 		{
 			return false;
 		}
 	}
  if(validateFloat)
  	if(strValue >= 0 && strValue <= 58)
  		return true;
  return false;
}

function validateSalary( strValue ) {
 
 	if(strValue.indexOf(".")!= -1) 
	{
 		var decimalvalue = strValue.substring(strValue.indexOf(".") + 1,strValue.length);
 		if(decimalvalue.length >= 2 || decimalvalue > 9)
 		{
 			return false;
 		}
 	}
  if(validateFloat)
  	if(strValue >= 0 && strValue < 100)
  		return true;
  return false;
}

function validatePassport( strValue ) {
	if(strValue.length==8){
 		firstChar=strValue.substring(0,1);
 		rest=strValue.substring(1,8);
 		if(validateChar(firstChar) && validateInteger(rest)){
 			return true;
 		}
 		return false;
 	}
 	return false;
}

function validatePan( strValue ) {
	if(strValue.length==10)
	{
 		firstChar = strValue.substring(0,1);
 		rest = strValue.substring(1,10);
 		if(validateChar(firstChar))
 		{
 			if(validateAlphaNumeric(rest))
 			{
 				for(k = 0; k < rest.length; k++)
 				{
 					if(rest.charAt(k)>0 && rest.charAt(k)<9)
 					{
 						return true;
 					}	
 				} 
 			}
 		}
 		else
 			return false;
 	}
 	return false;
}


function validateDate( strValue ) {
  var objRegExp = /^\d{1,2}(\-|\/|\.)\d{1,2}\1\d{4}$/
	
  if(!objRegExp.test(strValue))
    return false; 
  else{
    var strSeparator = strValue.substring(2,3) 

    var arrayDate = strValue.split(strSeparator); 
    var arrayLookup = { '01' : 31,'03' : 31, '04' : 30,'05' : 31,'06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,'10' : 31,'11' : 30,'12' : 31}
	var intDay = parseInt(arrayDate[0],10);
		

    if(arrayLookup[arrayDate[1]] != null) {
      if(intDay <= arrayLookup[arrayDate[1]] && intDay != 0)
        return true; 
    }
	var intMonth = parseInt(arrayDate[1], 10);

    if (intMonth == 2) { 
       var intYear = parseInt(arrayDate[2]);
       if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0)
          return true;
       }
  }
  return false; 
}

function validateDateOfBirth(strValue) {
	
	var isValid=true;
	var dob=new Date(strValue);
	var nowDate=new Date();
	if(!validateDate( strValue )){
		isValid=false;
	}

	else if( ((dob.getFullYear()+18) > nowDate.getFullYear()) || ((dob.getFullYear() + 140) < nowDate.getFullYear())){
		isValid=false;
	}
	return isValid;
}

function validateEmployeeDateOfJoining(strValue) {

   	employeeDateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(employeeDateOfJoining < currentDate)
 	{
		return false;
 	}
	 return true;
}

function validateDateOfJoining(strValue) {
   	dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(dateOfJoining >= currentDate)
 	{
		return false;
 	}
	 return true;
}


function validateDateOfInterview(strValue) {
	dateOfInterview = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
 	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
 	if(dateOfInterview > currentDate){
		return false;
 	}
	 return true;
}

function validateEmployeeCode(strValue){
	
	msg = "";
	if(strValue.length != 6)
	{
		msg += "Employee Code Should be of 6 digits.\n";
	}
	else if(!validateInteger(strValue))
	{
		msg += "Employee Code should contain numeric value only.\n";
	
	}
	else if(strValue == '000000')
	{
	    msg += "Employee Code should not be '000000'. Please try value other than this!\n";
	    
	}
	else if(strValue.substring(0,1)!=0)
	{
		msg += "Employee Code should start with 0.\n";
	}	
	return msg;
}

function validateEmail(strValue) {
var objRegExp  =/^([a-zA-Z_\.\-][\w]*[a-zA-Z0-9\_])+\@(([a-zA-Z0-9\-])+\.)+(([a-zA-Z]{2,4})*([a-zA-Z]{2,4}))+$/;

if(objRegExp.test(strValue))
   return checkEmail(strValue);

}


function checkEmail(strValue)
	{
		var checkEmail=true;
 		var mytool_array=strValue.split("@");
		var afterRateArray= mytool_array[1].split(".");	

 		if(afterRateArray.length>3) {
 			checkEmail=false;
 		}
 		else if(afterRateArray.length == 3){ 
 		   if(afterRateArray[1].length>2 || afterRateArray[2].length>2){
 		    checkEmail=false;
 		   }
 		}   
 		else if(afterRateArray.length == 2){
 		   if(afterRateArray[1].length>3 || afterRateArray[1].length == 2){
 		   checkEmail=false;
 		   }
 		}
 	
 		if(!checkEmail)
 		{
 			return false;
 		}
 		
 		return true;
 	}




function trimAll( strValue ) {
 var objRegExp = /^(\s*)$/;

    //check for all spaces
    if(objRegExp.test(strValue)){
       strValue = strValue.replace(objRegExp, '');
       if( strValue.length == 0)
          return strValue;
    }

   //check for leading & trailing spaces
   objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
   if(objRegExp.test(strValue)) {
       //remove leading and trailing whitespace characters
       strValue = strValue.replace(objRegExp, '$2');
    }
  return strValue;
}

function checkTextareaLength(obj){
	if(obj.getAttribute("maxlength")){
		if(obj.value.length > obj.getAttribute("maxlength")-1){
			return false;
		}
	}
}

function xreplace(checkMe,toberep,repwith)
{ 
 var temp = checkMe; 
 var i = temp.indexOf(toberep); 
 while(i > -1)
 { 
  temp = temp.replace(toberep, repwith); 
  i = temp.indexOf(toberep); 
 } 
 
 return temp; 
}

function checkMaxLength(obj){
        if(window.event){
            keyObj = window.event.keyCode
            if(keyObj == 9 || keyObj == 8 ||keyObj == 46 || keyObj == 16 || keyObj == 37 || keyObj == 36 || keyObj == 35 || window.event.ctrlKey )
                return true;
        }
        if(obj.getAttribute("maxlength")){
	        if(obj.value.length>obj.getAttribute("maxlength")-1){    
    	        return false;
        	}

        }
    }
    pasteFlag = false
    function checkOnPaste(obj){
	    pasteFlag = true;
     /*   txt =window.clipboardData.getData("Text", obj.value)
        if(obj.getAttribute("maxlength")){
	        if((txt.length+obj.value.length)>obj.getAttribute("maxlength")-1){
    	        obj.value = obj.value.substring(0,obj.getAttribute("maxlength"));
        	    return false;
        	}
        }*/
    }
    function checkMaxLengthMoz(obj){
        if(obj.getAttribute("maxlength")){
	        if(obj.value.length>obj.getAttribute("maxlength")-1){
	            obj.value = obj.value.substring(0,obj.getAttribute("maxlength"))
    	        return false;
        	}
        }
    }
    function finalCheck(obj){
	    if(obj.getAttribute("maxlength")){
           	if(pasteFlag){
        		obj.value = obj.value.substring(0,obj.getAttribute("maxlength"));
        		pasteFlag = false;
        	}
        }
    }

/*-----------------------Validation Ends---------------------------------------*/

/*-----------------------------------------------Validations End---------------------------------*/






function editUserGroup(formName,action){
		userGroup = document.formName.userGroupName.value;
		if(userGroup == 0){
			alert("Please select User Group");
			return false;
		}
		
		obj = eval('document.'+formName)
    	if(obj){
        	obj.action = action;
       	    obj.submit();
    	}
    	else
	       	return false;	

       	return true;
	}

	function deleteUserGroupConfirmation(action){
		userGroup = document.showDeleteMapUserGroupFromHospital.userGroupName.value;
		if(userGroup == 0){
			alert("Please select User Group");
			return false;
		}
		if(confirm("Are you sure to delete this User Group? ")){
			deleteUserGroup(action);
		}else {
			return false;
		}
	}
	
	function deleteUserGroup(action){
		obj = eval('document.showDeleteMapUserGroupFromHospital')
    	if(obj){
        	obj.action = action;
       	    obj.submit();
    	}
    	else
	       	return false;	

       	return true;
	}


function editUserGroup(formName,action){
		userGroup = document.showEditUserGroup.userGroupName.value;
		if(userGroup == 0){
			alert("Please select User Group");
			return false;
		}
		
		obj = eval('document.'+formName)
    	if(obj){
        	obj.action = action;
       	    obj.submit();
    	}
    	else
	       	return false;	

       	return true;
	}

	function deleteUserGroupConfirmation(formName,action){
		userGroup = document.showEditUserGroup.userGroupName.value;
		if(userGroup == 0){
			alert("Please select User Group");
			return false;
		}
		if(confirm("Are you sure to delete this User Group? ")){
			deleteUserGroup(formName,action);
		}else {
			return false;
		}
	}
	
	function deleteUserGroup(formName,action){
		obj = eval('document.'+formName)
    	if(obj){
        	obj.action = action;
       	    obj.submit();
    	}
    	else
	       	return false;	

       	return true;
	}
	




