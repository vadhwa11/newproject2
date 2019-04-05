


<!-- amcolumn script--> 
<script type="text/javascript"	src="/hms/jsp/chart/swfobjectnew.js"></script>
<script type="text/javascript" src="/hms/jsp/chart/amcharts.js"></script>
<script type="text/javascript" src="/hms/jsp/chart/amfallback.js"></script>
<script type="text/javascript" src="/hms/jsp/chart/raphael.js"></script>
   <link href="/hms/jsp/css/report.css" rel="stylesheet" type="text/css" />
 <h2>Procedure Register</h2>
<div class="clear"></div>  
<div id="chartdiv" style="float: center;">
<strong>You need to upgrade your Flash Player</strong>
</div>

<!-- end of amcolumn script -->

<script>
var params = 
{
    bgcolor:"#FFFFFF"
};

var flashVars = 
{
    path: "/hms/jsp/chart/",
    settings_file: "/hms/jsp/chart/amcolumn_settings_register.xml",
    data_file: "/hms/jsp/chart/amcolumn_procedure_data.xml"
};

window.onload = function()
{
	 // change 8 to 80 to test javascript version
    if (swfobject.hasFlashPlayerVersion("8"))
    {
        swfobject.embedSWF("/hms/jsp/chart/amcolumn.swf", "chartdiv", "100%", "400", "8.0.0", "/hms/jsp/chart/expressInstall.swf", flashVars, params);
    }
    else
    {
        // Note, as this example loads external data, JavaScript version might only work on server
        var amFallback = new AmCharts.AmFallback();
       // amFallback.pathToImages = "../../../../amcharts/javascript/images/";
       
        amFallback.settingsFile = flashVars.settings_file;
        amFallback.dataFile = flashVars.data_file;				
        amFallback.type = "column";
        amFallback.write("chartdiv");
    }
}


</script>





<%--
<script>
var so = new SWFObject("/hms/jsp/chart/amcolumn.swf", "amcolumn", "290", "230", "8", "#FFFFFF");
so.addVariable("path", "/hms/jsp/chart/");
so.addVariable("settings_file", encodeURIComponent("/hms/jsp/chart/amcolumn_settings_register.xml"));
so.addVariable("data_file",  encodeURIComponent("/hms/jsp/chart/amcolumn_opd_data.xml"));
so.addVariable("preloader_color", "#999999");
so.write("flashcontent");
</script> --%>