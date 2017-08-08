<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <%--LIST OF EXISTING VEHICLES--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Owner Name</th>
                    <th>Vehicle Year</th>
                    <th>VIN</th>
                    <th>Color</th>
                    <th>License Plate</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                </tr>
                </thead>
                <tbody>

                <c:set var="model_idx" value="0" scope="page"/>
                <c:set var="vehicle_idx" value="0" scope="page"/>

                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                    <c:forEach var="vehicleModel" items="${vehicleMake.vehicleModelList}">
                        <c:forEach var="vehicle" items="${vehicleModel.vehicleList}">

                            <tr>
                                <td>${vehicle.id}</td>
                                <td>${vehicle.ownerName}</td>
                                <td>${vehicle.year}</td>
                                <td>${vehicle.VIN}</td>
                                <td>${vehicle.color}</td>
                                <td>${vehicle.licensePlate}</td>
                                <td>${vehicleMake}</td>
                                <td>${vehicleModel}</td>
                                <td><a href="/admin/vehicle/edit/${vehicleMake.id}_${vehicleModel.id}_${vehicle.id}">Edit</a></td>
                                <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                            </tr>

                        </c:forEach>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>


<%@include file="../../includes/footer.jsp"%>