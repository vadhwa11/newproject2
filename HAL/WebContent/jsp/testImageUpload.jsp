
<%@ page import="java.util.*" %>
<%
String hinNo="";
if(request.getParameter("hinNo")!=null){
	hinNo=request.getParameter("hinNo");
}
 //hinNo = "02019000601"; 
%>
	<!-- First, include the JPEGCam JavaScript Library -->
<!-- First, include the JPEGCam JavaScript Library -->
	<script type="text/javascript" src="/hms/jsp/webcam.js"></script>

	<!-- Configure a few settings -->
	<script language="JavaScript">
		webcam.set_api_url( '/hms/jsp/uploadphoto.jsp?hinNo2=<%=hinNo%>' );
		webcam.set_quality( 90 ); // JPEG quality (1 - 100)
		webcam.set_shutter_sound( true ); // play shutter click sound
	</script>

	<!-- Next, write the movie to the page at 320x240 -->
	<script language="JavaScript">
		document.write( webcam.get_html(220, 160) );
	</script>
<div style="width:500px; margin:0px auto;">
<div class="clear"></div>
	<!-- Some buttons for controlling things -->
	<form>
		<input type=button value="Take Snapshot" onClick="take_snapshot()" class="buttonBig" /><!--

		<input type=button value="Reset" class="button"  onClick="webcam.reset()">
	--></form>
	</div>
	<!-- Code to handle the server response (see test.php) -->
	<script language="JavaScript">
		webcam.set_hook( 'onComplete', 'my_completion_handler' );

		function take_snapshot() {
			// take snapshot and upload to server
			//alert(" Take Snap")
			document.getElementById('upload_results').innerHTML = '';
			webcam.snap();
			//alert(" Take Snap 12")
			webcam.configure('camera');
			//alert(" Take Snap 13")
			
		}

		function my_completion_handler(msg) {
			// extract URL out of PHP output
			if (msg.match(/(http\:\/\/\S+)/)) {
				var image_url = RegExp.$1;
				// show JPEG image in page
				document.getElementById('upload_results').innerHTML ='';

				// reset camera for another shot
				webcam.reset();
			}
			//else alert("PHP Error: " + msg);
		}
	</script>


		<div id="upload_results"></div>


