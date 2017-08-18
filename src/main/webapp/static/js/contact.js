function buildTable() {

    $.getJSON('/api/contact/', {
        ajax: 'true'
    }, function (data) {
        //console.log(data)
        var $tbody = $('#contact-table').find('tbody');
        $.each(data, function(index, single) {
            var fullName = single.employee.firstName + " " + single.employee.lastName
            var $tr = $("<tr>");
            $tr.append(
                "<td>" + single.id + "</td>" +
                "<td>" + single.employee.firstName + " " + single.employee.lastName + "</td>" +
                "<td>" + single.emailAddress + "</td>" +
                "<td>" + single.employee.background + "</td>");

            var $s1 = $("<select class='form-control'><options>single.employee.projectList</options></select>");
            $.each(single.employee.projectList, function(_, project) {
                $s1.append('<option value="'+ project.projectName +'">'+ project.projectName +'</option>')
            });
            $tr.append($("<td/>").append($s1));
            var $s2 = $("<select class='form-control'><options>single.addressList</options></select>");
            $.each(single.addressList, function(_, addr) {
                $s2.append('<option value="'+addr.streetAddress +'">'+addr.streetAddress+'</option>');
            });
            $tr.append($("<td/>").append($s2));
            $tr.append("<td>" + "<button onclick='editEmployee(" + single.id + ")'>Edit</button>" + "</td>" +
                "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "'>Delete</button>" + "</td>");
            $tbody.append($tr);
        });
    });
}

function deleteRow(r) {
    var row = r.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

function projectTable() {

    var $tbody = $('#project-table').find('tbody');
    var $tr = $("<tr>");


    $tr.append(
        "<td>" + "<input class='form-control' id='inputProjectName' placeholder='Project Name' type='text'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputClientName' placeholder='Client Name' type='text'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputRate' placeholder='Rate' type='text'></td>" +
        "<td>" + "<input type='button' value='Delete' onclick='deleteRow(this)'>" + "</td>");
    $tbody.append($tr);
}

function addressTable() {
    var $tbody = $('#address-table').find('tbody');
    var $tr = $("<tr>");


    $tr.append(
        "<td>" + "<input class='form-control' id='inputStreet' placeholder='Street' type='text'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputCity' placeholder='City' type='text'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputState' placeholder='State' type='text'></td>" +
        "<td>" + "<input class='form-control' id='inputZip' placeholder='Zip' type='text'></td>" +
        "<td>" + "<input type='button' value='Delete' onclick='deleteRow(this)'>" + "</td>");
    $tbody.append($tr);
}

function insertContact() {
    //clear fields in modal
    $('#contactId').val("");
    $('#contactVersion').val("");
    $('#employeeId').val("");
    $('#employeeVersion').val("");
    $('#addressId').val("");
    $('#addressVersion').val("");
    $('#projectId').val("");
    $('#projectVersion').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#inputEmail').val("");
    $('#textAreaBackground').val("");
    $('#inputProjectName').val("");
    $('#inputClientName').val("");
    $('#inputFieldRate').val("");
    $('#inputStreet').val("");
    $('#inputCity').val("");
    $('#inputState').val("");
    $('#inputZip').val("");


    //open modal
    $('#contactModal').modal('show');

    $('#project-table > tbody').html('');
    $('#address-table > tbody').html('');
    projectTable();
    addressTable();
}

function saveContact() {
    var contactId = $('#contactId').val();
    var contactVersion = $('#contactVersion').val();
    var emailAddress = $('#inputEmail').val();
    var employeeId = $('#employeeId').val();
    var employeeVersion = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var background = $('#textAreaBackground').val();
    var projectId = $('#projectId').val();
    var projectVersion = $('#projectVersion').val();
    var projectName = $('#inputProjectName').val();
    var clientName = $('#inputClientName').val();
    var fieldRate = $('#inputFieldRate').val();
    var addressId = $('#addressId').val();
    var addressVersion = $('#addressVersion').val();
    var streetAddress = $('#inputStreet').val();
    var zip = $('#inputZip').val();
    var state = $('#inputState').val();
    var city = $('#inputCity').val();



    // creating an object in javascript (json)
    var contact = {
        id: contactId,
        version: contactVersion,
        emailAddress: emailAddress,
        employee: {
            id: employeeId,
            version: employeeVersion,
            firstName: firstName,
            lastName: lastName,
            background: background,
            projectList: [
                {
                    id: projectId,
                    version: projectVersion,
                    projectName: projectName,
                    clientName: clientName,
                    fieldRate: fieldRate
                }
                // ,{
                //     id: id,
                //     version: version,
                //     projectName: projectName,
                //     clientName: clientName,
                //     fieldRate: fieldRate
                // }
            ]
        },
        addressList: [
            {

                id: addressId,
                version: addressVersion,
                streetAddress: streetAddress,
                zip: zip,
                state: state,
                city: city
            }
            // ,{
            //     id: id,
            //     version: version,
            //     streetAddress: streetAddress,
            //     zip: zip,
            //     state: state,
            //     city: city
            // }
        ]

    }

    console.log(contact);

    // asynchronous javascript call
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/json",
        url: "/api/contact/",
        data: JSON.stringify(contact),
        async: true,
        // success: function() {
        //     window.location.reload();
        // }
    })
}