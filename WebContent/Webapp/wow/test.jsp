<html>
<head>

<title>表单提交图片显示</title>
<style type="text/css"> 
#head { 
background:url(head.jpg) no-repeat ;
width: 160px; 
height: 160px; 
filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale); 
} 
</style> 
</head>
<body>
<div id="head"> 
</div> 

<br><br><br>
<form id="add" method="post">
<input accept="image/gif, image/jpeg, image/x-png" type="file" id="avatar" onchange="loadImageFile();"/><br><br><br>
<input type="submit" value="注册" ><br><br><br>
</form>


<script type="text/javascript"> 
var loadImageFile = (function () { 
if (window.FileReader) { 
var oPreviewImg = null, oFReader = new window.FileReader(), 
rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i; 

oFReader.onload = function (oFREvent) { 
if (!oPreviewImg) { 
var newPreview = document.getElementById("head"); 
oPreviewImg = new Image(); 
oPreviewImg.style.width = (newPreview.offsetWidth).toString() + "px"; 
oPreviewImg.style.height = (newPreview.offsetHeight).toString() + "px"; 
newPreview.appendChild(oPreviewImg); 
} 
oPreviewImg.src = oFREvent.target.result; 
}; 

return function () { 
var aFiles = document.getElementById("avatar").files; 
if (aFiles.length === 0) { return; } 
if (!rFilter.test(aFiles[0].type)) { alert("You must select a valid image file!"); return; } 
oFReader.readAsDataURL(aFiles[0]); 
} 

} 
if (navigator.appName === "Microsoft Internet Explorer") { 
return function () { 
alert(document.getElementById("avatar").value); 
document.getElementById("head").filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.getElementById("avatar").value; 
} 
} 
})(); 
</script> 
</body>



</html>