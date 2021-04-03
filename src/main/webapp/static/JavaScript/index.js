

//asp对Ajax的响应
function request(url) {
    var xmlhttp = createXMLHTTPObject();
    xmlhttp.open("GET", url, false);
    xmlhttp.send(null);
    document.writeln(xmlhttp.responseText);
}

//J2EE对Ajax的响应
function simple_ajax() {
    var xmlhttp = createXMLHTTPObject();
    var input = document.getElementById("sayhello");
    var sUrl = "SimpleAjax?name=guys";
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            alert(xmlhttp.responseText);
        }
    };
    xmlhttp.open('GET', sUrl);
    xmlhttp.send(null);
}

function getMostRatings() {
    var xmlhttp = createXMLHTTPObject();
    var sUrl = "MostRatings";
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            // alert(xmlhttp.responseText);
            document.getElementById("Recommend").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open('POST', sUrl);
    xmlhttp.send(null);

}