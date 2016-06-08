<%--
  Created by IntelliJ IDEA.
  User: ahs
  Date: 06.06.16
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/header.jsp"/>
<div class="jumbotron">
    <div class="row">

        <div class="col-sm-4">
            <div class="container">

                <div class="shadow">
                    <h3><fmt:message key="app.title"/></h3>
                    <div id="knopovka">
                        <a class="btn btn-primary" role="button" href="geopoints"><fmt:message key="app.back"/></a>
                    </div>
                    <div id="pointka">


                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="container">
                <div class="mymap">
                    <div id="map"></div>
                    <script src="resources/js/geo.js"></script>
                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjWdyyOLaQL6Mjsxc2p-mYdxah2Dbu5c4&callback=initMap"
                            async defer></script>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
<script language="javascript" type="text/javascript">
    function txt() {
        document.getElementsById('pointka').innerHTML = "Hello!"
        console.info("loaded");
    };
    window.onload = txt;


</script>
<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="resources/js/geoPointsDatatables.js"></script>
</html>
