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
    <%@include file="../vehicle/vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicleMake/add" method="post">
                <fieldset>
                    <legend>Vehicle Make Management</legend>

                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make Name:</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleMake" type="text" class="form-control" id="inputNewVehicleMake" placeholder="Vehicle Make"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleModels" class="col-lg-2 control-label">Models</label>
                        <div class="col-lg-10">
                            <form:textarea path="newVehicleModel" type="text" class="form-control" rows="3" id="inputNewVehicleModels"></form:textarea>
                            <span class="help-block">Enter each new Model on a new Line.</span>
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