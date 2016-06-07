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
                    <div class="btn-add">
                        <a class="btn btn-sm btn-info" onclick="add()"><fmt:message key="app.create"/></a>
                    </div>

                    <table class="table table-striped display" id="datatable">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>

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
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title"><fmt:message key="app.point"/></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="control-label col-xs-3">Address</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="address" name="address" placeholder="address">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="resources/js/geoPointsDatatables.js"></script>

</html>