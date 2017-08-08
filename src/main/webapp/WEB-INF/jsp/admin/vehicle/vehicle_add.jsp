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

        <div class="col-sm-4">

            <%--ALERTS--%>
            <%--Success Alert--%>
            <%--? is short for if else--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Element added successfully to the database!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>

            <%--Warning Alert--%>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>All fields required. Please enter an Element Type and associated Elements separated by a new line<a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>

            <%--Error Alert--%>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>

        </div>
    </div>

</div>

<%@include file="../../includes/footer.jsp"%>