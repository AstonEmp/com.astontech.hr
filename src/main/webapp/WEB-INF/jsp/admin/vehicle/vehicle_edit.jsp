<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>

    $(document).ready(function() {
        // attach an onclick function to the remove buttons
        $('.remove_button').click(function() {
            //log name button, and contents of associated text box
            console.log(this.name);
            console.log($('#'+ this.name).val());
            //clear the value / contents of the textbox
            $('#'+ this.name).val('')
            //submit the form
            $('#elementType').submit();
        });

    });

</script>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">


            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/edit" method="post" name="edit">


                <c:set var = "vehicleMakeEdit" scope = "page" value = "${vehicleMakeEdit}"/>
                <c:set var = "vehicleModelEdit" scope = "page" value = "${vehicleModelEdit}"/>
                <c:set var = "vehicleEdit" scope = "page" value = "${vehicleEdit}"/>
            <fieldset>
                <Legend>Edit Vehicle</Legend>


                        <select name="selectMake">
                        <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                            <c:choose>
                                <c:when test="${vehicleMakeEdit.id == vehicleMake.id}">
                                    <option selected value="${vehicleMake.vehicleMakeName}">${vehicleMake.vehicleMakeName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${vehicleMake.vehicleMakeName}">${vehicleMake.vehicleMakeName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </select>

                        <select name="selectModel">
                            <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                <c:forEach var="vehicleModel" items="${vehicleMake.vehicleModelList}">
                                    <c:choose>
                                        <c:when test="${vehicleModelEdit.id == vehicleModel.id}">
                                            <option selected value="${vehicleModel.vehicleModelName}">${vehicleModel.vehicleModelName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${vehicleModel.vehicleModelName}">${vehicleModel.vehicleModelName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:forEach>
                        </select>


                <div class="form-group">
                    <label for="inputNewVehicleOwner" class="col-lg-2 control-label">Vehicle Owner:</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleOwner" type="text" class="form-control" id="inputNewVehicleOwner" value="${vehicleEdit.ownerName}"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleYear" class="col-lg-2 control-label">Vehicle Year:</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleYear" type="number" class="form-control" id="inputNewVehicleYear" value="${vehicleEdit.year}"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleVIN" class="col-lg-2 control-label">Vehicle VIN:</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleVIN" type="text" class="form-control" id="inputNewVehicleVIN" value="${vehicleEdit.VIN}"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleColor" class="col-lg-2 control-label">Vehicle Color:</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleColor" type="text" class="form-control" id="inputNewVehicleColor" value="${vehicleEdit.color}"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleLicensePlate" class="col-lg-2 control-label">Vehicle License Plate:</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleLicensePlate" type="text" class="form-control" id="inputNewVehicleLicensePlate" value="${vehicleEdit.licensePlate}"></form:input>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>

            </fieldset>
            </form:form>

        </div>
    </div>
</div>


<%@include file="../../includes/footer.jsp"%>