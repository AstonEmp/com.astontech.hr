<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="../vehicle/vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <%--LIST OF EXISTING VEHICLES--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Model Name</th>
                </tr>
                </thead>
                <tbody>

                <c:set var="model_idx" value="0" scope="page"/>
                <c:set var="vehicle_idx" value="0" scope="page"/>

                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                    <c:forEach var="vehicleModel" items="${vehicleMake.vehicleModelList}">

                    <tr>
                        <td>${vehicleModel.id}</td>
                        <td>${vehicleModel.vehicleModelName}</td>
                    </tr>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>


<%@include file="../../includes/footer.jsp"%>