<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>

<script language="javascript">
var imgRe = /^.+\.(jpg|jpeg|gif|png)$/i;
function previewImage(pathField, previewName)
{       
    var path = pathField.value;
    if (path.search(imgRe) != -1)
    {   
        document[previewName].src = 'file://'+path;
    }       
    else    
    {   
        alert("JPG, PNG, and GIFs only!");
    }   
}
function displayImage()
{
	var url = document.getElementById('fileId').value;
	//document.getElementById('img1').style.display = 'inline';
	document["pat"].src="file://"+url;
	//document.getElementById('img1').src=url;
	
}
</script>
</head>
<body>
<form name="imageTest">
<div align="center"><img id="img1" name="pat"
	src="file:C:\Documents and Settings\rashmi\My Documents\My Pictures\1.jpg"
	width="110" height="120"> <input type="file" id="fileId"
	name="image" class="file" onchange="displayImage();"></div>
</form>
</body>
</html>