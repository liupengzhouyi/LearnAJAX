var xmlhttp;

function getTime() {
    if (window.ActiveXObject) {
        // IE5 IE 6
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        //IE7 IE8 Firefox, Chrome, Safari, Opera
        xmlhttp = new XMLHttpRequest();
    }

    xmlhttp.onreadystatechange = trigered;
    xmlhttp.open("GET", "/experiment_11And12/experiment12/GetTimeServlet?m="+Math.random(), true);
    xmlhttp.send(null);
}

function trigered() {
    if(xmlhttp.readyState == 4&&xmlhttp.status==200) {
        document.getElementById("time").innerHTML = xmlhttp.responseText;
    }
}