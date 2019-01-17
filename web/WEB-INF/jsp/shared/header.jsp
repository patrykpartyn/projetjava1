<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 20.10.2018
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap-material-design/4.1.1/assets/css/docs.min.css?<%=new Random().nextLong()%>" />
    <link rel="stylesheet" type="text/css"
          href="statics/css/main.css" />

</head>

<html>
    <body class="card-header">
        <nav id="header" class="navbar navbar-expand bg-dark flex-column flex-md-row">
            <div class="navbar-nav-scroll">
                <ul class="nav nav-tabs bg-dark">

                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'home' ?'active':''}"  href="/" >Strona główna</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'vehicleList' ?'active':''}"  href="vehicleList.html">Lista pojazdów</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'vehicleForm' ?'active':''}"  href="vehicleForm.html">Nowy pojazd</a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>


