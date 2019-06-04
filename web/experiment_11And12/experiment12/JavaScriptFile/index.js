var xmlhttp;

function loadStory() {
    if (window.ActiveXObject) {
        // IE5 IE 6
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        //IE7 IE8 Firefox, Chrome, Safari, Opera
        xmlhttp = new XMLHttpRequest();
    }

    xmlhttp.onreadystatechange = trigered;
    xmlhttp.open("GET", "../Story/text.txt", true);
    xmlhttp.send(null);
}

function trigered() {
    if(xmlhttp.readyState == 4) {
        document.getElementById("output").innerHTML = xmlhttp.responseText;
    }
}