<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>

    $(document).ready(function() {

        $("#successAlert").delay(8000).fadeOut(2000); // 8 seconds, 2 seconds
        $("#warningAlert").delay(10000).fadeOut(2000); //# to specify id

    });
</script>


<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                    <legend>Vehicle Management</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make: </label>
                        <div class="col-lg-10">
                            <form:select path="newVehicleMake" type="text" class="form-control" id="inputNewVehicleMake" >
                                <form:option value= "-" label="(Select)"/>
                                <form:options items="${vehicleMakeList}"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleModel" class="col-lg-2 control-label">Vehicle Model: </label>
                        <div class="col-lg-10">
                            <div class="col-lg-10">
                                <form:select path="newVehicleModel" type="text" class="form-control" id="inputNewVehicleModel" >
                                    <form:option value= "-" label="(Select)"/>
                                    <form:options items="${vehicleModelList}"/>
                                </form:select>
                            </div>
                            <%--<span class="help-block">Enter each new Element on a new line.</span>--%>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleOwner" class="col-lg-2 control-label">Vehicle Owner:</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleOwner" type="text" class="form-control" id="inputNewVehicleOwner" placeholder="Vehicle Owner"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleYear" class="col-lg-2 control-label">Vehicle Year:</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleYear" type="number" class="form-control" id="inputNewVehicleYear" placeholder="Vehicle Year"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleVIN" class="col-lg-2 control-label">Vehicle VIN:</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleVIN" type="text" class="form-control" id="inputNewVehicleVIN" placeholder="Vehicle VIN"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleColor" class="col-lg-2 control-label">Vehicle Color:</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleColor" type="text" class="form-control" id="inputNewVehicleColor" placeholder="Vehicle Color"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleLicensePlate" class="col-lg-2 control-label">Vehicle License Plate:</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleLicensePlate" type="text" class="form-control" id="inputNewVehicleLicensePlate" placeholder="Vehicle License Plate"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>

                </fieldset>
            </form:form>

        </div>
    </div>

</div>

<%@include file="../../includes/footer.jsp"%>