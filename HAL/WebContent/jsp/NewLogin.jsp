<script type="text/javascript">
var newwindow;
function popwindow()
{
 newwindow=window.open('/hms/hms/login?method=showLoginJsp','name',"height=800,width=1020,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}
</script>
<body onload="popwindow();">
</body>