<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="row">
            <div id="header-linker" class="col-sm-4">
                <a href="geopoints" class="navbar-brand"><fmt:message key="app.title"/></a>
            </div>
            <div class="col-sm-8">
                <form class="navbar-form navbar-left">

                    <a class="btn btn-info" role="button" href="profile"><fmt:message
                            key="app.profile"/> ${userTo.name}</a>
                    <a class="btn btn-primary" role="button" href="logout"><fmt:message key="app.logout"/></a>
                </form>
            </div>
        </div>
    </div>
</div>
