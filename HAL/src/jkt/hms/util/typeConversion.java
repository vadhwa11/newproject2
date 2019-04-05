package jkt.hms.util;
public class typeConversion
{
	
	public static  String convertNumber( String number ){
		number = cleanNumber( number );
		double num = 0.0;
		try{
		num = Double.parseDouble( number );
		}catch( Exception e ){
		return "Invalid Number Sent to Convert";
		} //catch

		String returnValue = "Rupees ";
		while( num > 0 ){
		number = "" + (int)num;
		double place = getPlace(number);
		if( place == TENS || place == TENTHOUSANDS || place == TENLAKHS || place == TENCRORES ){
		int subNum = Integer.parseInt( number.charAt(0) + "" + number.charAt(1) );

		if( subNum >= 21 && (subNum%10) != 0 ){
		returnValue += getWord( Integer.parseInt( "" + number.charAt(0) ) * 10 ) + " " + getWord( subNum%10 ) ;
		} //if
		else{
		returnValue += getWord(subNum);
		}//else

		if( place == TENS ){
		num = 0;
		}//if
		else if( place == TENTHOUSANDS ){
		num -= subNum * THOUSANDS;
		returnValue += " Thousands ";
		}//if
		else if( place == TENLAKHS ){
		num -= subNum * LAKHS;
		returnValue += " Lakhs ";
		}//if
		else if( place == TENCRORES ){
		num -= subNum * CRORES;
		returnValue += " Crores ";
		}//if
		}//if
		else{
		int subNum = Integer.parseInt( "" + number.charAt(0) );

		returnValue += getWord( subNum );
		if( place == UNITS ){
		num = 0;
		}//if
		else if( place == HUNDREDS ){
		num -= subNum * HUNDREDS;
		returnValue += " Hundred ";
		}//if
		else if( place == THOUSANDS ){
		num -= subNum * THOUSANDS;
		returnValue += " Thousand ";
		}//if
		else if( place == LAKHS ){
		num -= subNum * LAKHS;
		returnValue += " Lakh ";
		}//if
		else if( place == CRORES ){
		num -= subNum * CRORES;
		returnValue += " Crore ";
		}//if
		}//else
		}//while
		returnValue += " Only ";
		return returnValue;
		}//convert number
	
	public static  String convertNumber11( String number ){
		number = cleanNumber( number );
		double num = 0.0;
		try{
		num = Double.parseDouble( number );
		}catch( Exception e ){
		return "Invalid Number Sent to Convert";
		} //catch

		String returnValue = "Items ";
		while( num > 0 ){
		number = "" + (int)num;
		double place = getPlace(number);
		if( place == TENS || place == TENTHOUSANDS || place == TENLAKHS || place == TENCRORES ){
		int subNum = Integer.parseInt( number.charAt(0) + "" + number.charAt(1) );

		if( subNum >= 21 && (subNum%10) != 0 ){
		returnValue += getWord( Integer.parseInt( "" + number.charAt(0) ) * 10 ) + " " + getWord( subNum%10 ) ;
		} //if
		else{
		returnValue += getWord(subNum);
		}//else

		if( place == TENS ){
		num = 0;
		}//if
		else if( place == TENTHOUSANDS ){
		num -= subNum * THOUSANDS;
		returnValue += " Thousands ";
		}//if
		else if( place == TENLAKHS ){
		num -= subNum * LAKHS;
		returnValue += " Lakhs ";
		}//if
		else if( place == TENCRORES ){
		num -= subNum * CRORES;
		returnValue += " Crores ";
		}//if
		}//if
		else{
		int subNum = Integer.parseInt( "" + number.charAt(0) );

		returnValue += getWord( subNum );
		if( place == UNITS ){
		num = 0;
		}//if
		else if( place == HUNDREDS ){
		num -= subNum * HUNDREDS;
		returnValue += " Hundred ";
		}//if
		else if( place == THOUSANDS ){
		num -= subNum * THOUSANDS;
		returnValue += " Thousand ";
		}//if
		else if( place == LAKHS ){
		num -= subNum * LAKHS;
		returnValue += " Lakh ";
		}//if
		else if( place == CRORES ){
		num -= subNum * CRORES;
		returnValue += " Crore ";
		}//if
		}//else
		}//while
		returnValue += " Only ";
		return returnValue;
		}//convert number
	
	
	
	
	public static final double UNITS = 1;
	public static final double TENS = 10 * UNITS;
	public static final double HUNDREDS = 10 * TENS;
	public static final double THOUSANDS = 10 * HUNDREDS;
	public static final double TENTHOUSANDS = 10 * THOUSANDS;
	public static final double LAKHS = 10 * TENTHOUSANDS;
	public static final double TENLAKHS = 10 * LAKHS;
	public static final double CRORES = 10 * TENLAKHS;
	public static final double TENCRORES = 10 * CRORES;
	
	 public static double getPlace( String number ){
switch( number.length() ){
case 1:
return UNITS;
case 2:
return TENS;
case 3:
return HUNDREDS;
case 4:
return THOUSANDS;
case 5:
return TENTHOUSANDS;
case 6:
return LAKHS;
case 7:
return TENLAKHS;
case 8:
return CRORES;
case 9:
return TENCRORES;
}//switch
return 0.0;
}// getPlace

	public static String getWord( int number ){
switch( number ){
case 1:
return "One";
case 2:
return "Two";
case 3:
return "Three";
case 4:
return "Four";
case 5:
return "Five";
case 6:
return "Six";
case 7:
return "Seven";
case 8:
return "Eight";
case 9:
return "Nine";
case 0:
return "Zero";
case 10:
return "Ten";
case 11:
return "Eleven";
case 12:
return "Twelve";
case 13:
return "Thirteen";
case 14:
return "Fourteen";
case 15:
return "Fifteen";
case 16:
return "Sixteen";
case 17:
return "Seventeen";
case 18:
return "Eighteen";
case 19:
return "Nineteen";
case 20:
return "Twenty";
case 30:
return "Thirty";
case 40:
return "Forty";
case 50:
return "Fifty";
case 60:
return "Sixty";
case 70:
return "Seventy";
case 80:
return "Eighty";
case 90:
return "Ninety";
case 100:
return "Hundred";
} //switch
return "";
} //getWord

	public static String cleanNumber( String number ){
String cleanedNumber = "";

cleanedNumber = number.replace( '.', ' ' ).replaceAll( " ", "" );
cleanedNumber = cleanedNumber.replace( ',', ' ' ).replaceAll( " ", "" );
if( cleanedNumber.startsWith( "0" ) )
cleanedNumber = cleanedNumber.replaceFirst( "0", "" );

return cleanedNumber;
} //cleanNumber


	
	public static  String convertNumber1( String number ){
		number = cleanNumber( number );
		double num = 0.0;
		try{
		num = Double.parseDouble( number );
		}catch( Exception e ){
		return "Invalid Number Sent to Convert";
		} //catch

		String returnValue = "ITEM ";
		while( num > 0 ){
		number = "" + (int)num;
		double place = getPlace(number);
		if( place == TENS || place == TENTHOUSANDS || place == TENLAKHS || place == TENCRORES ){
		int subNum = Integer.parseInt( number.charAt(0) + "" + number.charAt(1) );

		if( subNum >= 21 && (subNum%10) != 0 ){
		returnValue += getWord( Integer.parseInt( "" + number.charAt(0) ) * 10 ) + " " + getWord( subNum%10 ) ;
		} //if
		else{
		returnValue += getWord(subNum);
		}//else

		if( place == TENS ){
		num = 0;
		}//if
		else if( place == TENTHOUSANDS ){
		num -= subNum * THOUSANDS;
		returnValue += " Thousands ";
		}//if
		else if( place == TENLAKHS ){
		num -= subNum * LAKHS;
		returnValue += " Lakhs ";
		}//if
		else if( place == TENCRORES ){
		num -= subNum * CRORES;
		returnValue += " Crores ";
		}//if
		}//if
		else{
		int subNum = Integer.parseInt( "" + number.charAt(0) );

		returnValue += getWord( subNum );
		if( place == UNITS ){
		num = 0;
		}//if
		else if( place == HUNDREDS ){
		num -= subNum * HUNDREDS;
		returnValue += " Hundred ";
		}//if
		else if( place == THOUSANDS ){
		num -= subNum * THOUSANDS;
		returnValue += " Thousand ";
		}//if
		else if( place == LAKHS ){
		num -= subNum * LAKHS;
		returnValue += " Lakh ";
		}//if
		else if( place == CRORES ){
		num -= subNum * CRORES;
		returnValue += " Crore ";
		}//if
		}//else
		}//while
		returnValue += " ONLY ";
		return returnValue;
		}//convert number
}