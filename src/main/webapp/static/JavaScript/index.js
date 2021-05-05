
function getMostRatings() {
    var xmlhttp = createXMLHTTPObject();
    var sUrl = "MostRatings";
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            // alert(xmlhttp.responseText);
            var jsonArray = JSON.parse(xmlhttp.responseText);

            var htmlContent = "" +
                "<ul class=\"responsive-table\">" +
                "<li class=\"table-header\">" +
                "<div class=\"col col-1\">movie_title</div>" +
                "<div class=\"col col-2\">movie_genres\t</div>" +
                "<div class=\"col col-3\">rating(s)</div>" +
                "</li>" ;
            for (var i = 0; i < jsonArray.length; i++) {
                htmlContent += "<li class=\"table-row\">" +
                    "    <div class=\"col col-1\" data-label=\"Job Id\">" + jsonArray[i].title + "</div>" +
                    "    <div class=\"col col-2\" data-label=\"Customer Name\">" + jsonArray[i].genres + "</div>" +
                    "    <div class=\"col col-3\" data-label=\"Amount\">" + jsonArray[i].ratingsNum + "</div>" +
                    "</li>";
            }
            htmlContent += "</ul>";
            document.getElementById("Recommend-result").innerHTML = htmlContent;
        }
    };
    xmlhttp.open('POST', sUrl);
    xmlhttp.send(null);

}

function recommend_for_user() {
    var xmlhttp = createXMLHTTPObject();
    if(!isNaN(document.getElementById("userId").value)) {
        var radio = document.getElementsByName("radio");
        var tableName = "";
        for (i=0; i<radio.length; i++) {
            if (radio[i].checked) {
                tableName = radio[i].value;
            }
        }
        var sUrl = "recommend_for_user" + "?userId=" + document.getElementById("userId").value + "&tableName=" + tableName;
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4) {
                var s = xmlhttp.responseText;
                if (s.trim() + "" ==  "未查找到相关用户信息")
                    alert(xmlhttp.responseText);
                else {
                    var radio = document.getElementsByName("radio");
                    var tableName = "";
                    for (i=0; i<radio.length; i++) {
                        if (radio[i].checked) {
                            tableName = radio[i].value;
                        }
                    }

                    //对输出结果的json数组处理
                    var jsonArray = JSON.parse(xmlhttp.responseText);
                    document.getElementById("name").innerHTML = "用户" + jsonArray[1].id + "的推荐内容"
                                    + "(" + tableName + ")";
                    var htmlContent = "" +
                        "<ul class=\"responsive-table\">" +
                        "<li class=\"table-header\">" +
                        "<div class=\"col col-1\">recommendation</div>" +
                        "<div class=\"col col-2\">score</div>" +
                        "</li>" ;
                    for (var i = 0; i < jsonArray.length; i++) {
                        htmlContent += "<li class=\"table-row\">" +
                            "    <div class=\"col col-1\" data-label=\"Job Id\">" + jsonArray[i].recommendation + "</div>" +
                            "    <div class=\"col col-2\" data-label=\"Customer Name\">" + jsonArray[i].score + "</div>" +
                            "</li>";
                    }
                    htmlContent += "</ul>";
                    document.getElementById("Recommend-result").innerHTML = htmlContent;
                }
            }
        };
        xmlhttp.open('GET', sUrl);
        xmlhttp.send(null);
    }
    else {
        alert("请输入合法用户id值");
    }
}

function searchMovie() {
    var str = document.getElementById("SearchText").value;
    //输入了电影名模糊查询
    if (isNaN(str)) {
        var sUrl = "SearchName?movieName=" + str;
        document.getElementById("name").innerHTML = '根据电影名查询结果为：';
    }
    //输入了电影ID
    else {
        var sUrl = "SearchId?movieId=" + str;
        document.getElementById("name").innerHTML = '根据电影ID查询结果为：';
    }
    var xmlhttp = createXMLHTTPObject();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            //为了防止电影名中出现的&被误认为是分隔符
            var textArray = xmlhttp.responseText.trim().replaceAll("]&[", "]&&&[").split("&&&");
            if (textArray[0].trim() == "[]") {
                alert("未查找到相关信息");
            }
            else if (textArray.length == 3) {
                var htmlContent = "<p style='margin-left: 4rem;'>电影基本信息：</p>";
                var jsonArray = JSON.parse(textArray[0]);

                htmlContent += "" +
                    "<ul class=\"responsive-table\">" +
                    "<li class=\"table-header\">" +
                    "<div class=\"col col-1\">movieId</div>" +
                    "<div class=\"col col-2\">title</div>" +
                    "<div class=\"col col-3\">genres</div>" +
                    "</li>" +
                    "<li class=\"table-row\">" +
                    "    <div class=\"col col-1\">" + jsonArray[0].movieId + "</div>" +
                    "    <div class=\"col col-2\">" + jsonArray[0].title + "</div>" +
                    "    <div class=\"col col-3\">" + jsonArray[0].genres + "</div>" +
                    "</li>" +
                    "</ul>";

                if (textArray[1].trim() != "[]") {
                    htmlContent += "<p style='margin-left: 4rem;'>观看过的用户评分情况如下：</p>";
                    jsonArray = JSON.parse(textArray[1]);

                    htmlContent += "" +
                        "<ul class=\"responsive-table\">" +
                        "<li class=\"table-header\">" +
                        "<div class=\"col col-1\">userId</div>" +
                        "<div class=\"col col-2\">rating</div>" +
                        "<div class=\"col col-3\">timestamp</div>" +
                        "</li>";
                    for (i = 0; i < jsonArray.length; i++) {
                        htmlContent += "<li class=\"table-row\">" +
                            "    <div class=\"col col-1\">" + jsonArray[i].userId + "</div>" +
                            "    <div class=\"col col-2\">" + jsonArray[i].rating + "</div>" +
                            "    <div class=\"col col-3\">" + jsonArray[i].timestamp + "</div>" +
                            "</li>";
                    }
                    htmlContent +="</ul>";
                }
                if (textArray[2].trim() != "[]") {
                    htmlContent += "<p style='margin-left: 4rem;'>观看过的用户标识Tag情况如下：</p>";
                    jsonArray = JSON.parse(textArray[2]);

                    htmlContent += "" +
                        "<ul class=\"responsive-table\">" +
                        "<li class=\"table-header\">" +
                        "<div class=\"col col-1\">userId</div>" +
                        "<div class=\"col col-3\">tag</div>" +
                        "<div class=\"col col-3\">timestamp</div>" +
                        "</li>";
                    for (i = 0; i < jsonArray.length; i++) {
                        htmlContent += "<li class=\"table-row\">" +
                            "    <div class=\"col col-1\">" + jsonArray[i].userId + "</div>" +
                            "    <div class=\"col col-2\">" + jsonArray[i].tag + "</div>" +
                            "    <div class=\"col col-4\">" + jsonArray[i].timestamp + "</div>" +
                            "</li>";
                    }
                    htmlContent +="</ul>";
                }
                document.getElementById("Recommend-result").innerHTML = htmlContent;
            }
            else if (textArray.length == 1) {
                var htmlContent = "<p style='margin-left: 4rem;'>电影基本信息：</p>";
                var jsonArray = JSON.parse(textArray[0]);
                htmlContent += "<ul class=\"responsive-table\">" +
                    "<li class=\"table-header\">" +
                    "<div class=\"col col-1\">movieId</div>" +
                    "<div class=\"col col-2\">title</div>" +
                    "<div class=\"col col-3\">genres</div></li>" ;
                for (var i = 0; i < jsonArray.length; i++) {
                    htmlContent += "" +
                        "<li class=\"table-row\">" +
                        "    <div class=\"col col-1\">" + jsonArray[i].movieId + "</div>" +
                        "    <div class=\"col col-2\">" + jsonArray[i].title + "</div>" +
                        "    <div class=\"col col-3\">" + jsonArray[i].genres + "</div>" +
                        "</li>";
                }
                htmlContent += "</ul>";
                document.getElementById("Recommend-result").innerHTML = htmlContent;
            }
            else{
                //&做分隔符在电影名中也可以找到，所以有时候会长度为2
                alert("未查找到相关信息");
            }
        }
    }
    xmlhttp.open('GET', sUrl);
    xmlhttp.send(null);
}

function getAlgorithmName() {
    var radio = document.getElementsByName("radio");
    var tableName = "";
    for (i=0; i<radio.length; i++) {
        if (radio[i].checked) {
            tableName = radio[i].value;
        }
    }
    var name = [{"en": "userBasedCF","cn": "基于用户的协同过滤推荐算法"},
        {"en": "itemBasedCF", "cn": "基于项目的协同过滤推荐算法"},
        {"en": "LFM","cn":  "基于矩阵分解的协同过滤推荐算法"}];
    var str = '';
    for (j in name){
        if (name[j].en = tableName) {
            str = name[j].cn;
        }
    }
    // document.getElementById("AlgorithmName").innerText = str;
    sUrl = "getRecResult" + "?algoName=" + tableName;
    var xmlhttp = createXMLHTTPObject();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            var resultSet = xmlhttp.responseText.split('&');
            document.getElementById("AlgorithmPrecision").innerText = resultSet[0];
            document.getElementById("AlgorithmRecall").innerText = resultSet[1];
            document.getElementById("AlgorithmCoverage").innerText = resultSet[2];
            document.getElementById("AlgorithmPopularity").innerText = resultSet[3];
        }
    }
    xmlhttp.open('GET', sUrl);
    xmlhttp.send(null);
}


function processKey1(e) {
    if (null == e)
        e = window.event ;
    if (e.keyCode == 13)  {
        searchMovie();
        return false;
    }
}


function processKey2(e) {
    if (null == e)
        e = window.event ;
    if (e.keyCode == 13)  {
        document.getElementById("searchUser").onclick();
        return false;
    }
}