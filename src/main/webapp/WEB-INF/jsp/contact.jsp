<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<%--reference to js file--%>
<c:url value="/static/js/contact.js" var="contact"/>
<script src="${contact}"></script>


<script>
    //this javascript code executes when the page has loaded
    $(document).ready(function() {
        buildTable();
        //deleteModal();
    })
</script>

<div class="container">

    <h2>Contact List</h2>

    <button onclick="insertContact()" class="btn btn-default">Add New Contact</button>

    <table id="contact-table" class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Background</th>
                <th>Projects</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <%--jquery will append our data here...     --%>
        </tbody>
    </table>

    <div id="contactModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Contact Details</h4>
                </div>
                <div class="modal-body">

                    <form class="form-horizontal">

                        <fieldset>
                            <hidden id="employeeId" />
                            <hidden id="employeeVersion" />
                            <hidden id="contactId" />
                            <hidden id="contactVersion" />
                            <hidden id="addressId" />
                            <hidden id="addressVersion" />
                            <hidden id="projectId" />
                            <hidden id="projectVersion" />



                            <div class="form-group">
                                <label for="inputFirstName" class="col-lg-2 control-label">FirstName</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputFirstName" placeholder="First Name" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputLastName" class="col-lg-2 control-label">LastName</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputLastName" placeholder="Last Name" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputEmail" placeholder="Email" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="textAreaBackground" class="col-lg-2 control-label">Background</label>
                                <div class="col-lg-10">
                                    <textarea class="form-control" rows="3" id="textAreaBackground"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputProjectName" class="col-lg-2 control-label">Project</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputProjectName" placeholder="Project" type="text">
                                </div>
                                <label for="inputClientName" class="col-lg-2 control-label">Client</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputClientName" placeholder="Client" type="text">
                                </div>
                                <label for="inputFieldRate" class="col-lg-2 control-label">Rate</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputFieldRate" placeholder="Rate" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputStreet" class="col-lg-2 control-label">Street</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputStreet" placeholder="Street" type="text">
                                </div>
                                <label for="inputCity" class="col-lg-2 control-label">City</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputCity" placeholder="City" type="text">
                                </div>
                                <label for="inputState" class="col-lg-2 control-label">State</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputState" placeholder="State" type="text">
                                </div>
                                <label for="inputZip" class="col-lg-2 control-label">Zip</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="inputZip" placeholder="Zip" type="text">
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveContact()">Save changes</button>
                </div>
            </div>
        </div>
    </div>


    <%--<div id="confirmDeleteModal" class="modal">--%>
        <%--<div class="modal-dialog">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                    <%--<h4 class="modal-title">Confirm Delete</h4>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<p>Are you sure you want to delete? This cannot be undone!</p>--%>
                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>--%>
                    <%--<button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete">Delete</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>



</div>


<%@include file="includes/footer.jsp"%>