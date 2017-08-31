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
            $tr.append("<td>" + "<button onclick='editContact(" + single.id + ")'>Edit</button>" + "</td>" +
                "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "'>Delete</button>" + "</td>");
            $tbody.append($tr);
        });
    });
}

function deleteRow(r) {
    var row = r.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

var projectRows = 0;

function projectTable() {
    var $tbody = $('#project-table').find('tbody');

    var $tr = $("<tr>");


    $tr.append(

        "<td>" + "<hidden id='projectId" + projectRows + "'/>" +
        "<hidden id='projectVersion" + projectRows + "'/>" +
        "<input class='form-control' id='inputProjectName" + projectRows + "' placeholder='Project Name' type='text' required='true'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputClientName" + projectRows + "' placeholder='Client Name' type='text' required='true'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputRate" + projectRows + "' placeholder='Rate' type='number' required='true'></td>" +
        "<td>" + "<input type='button' value='Delete' onclick='deleteRow(this)'>" + "</td>");

    $tbody.append($tr);

    projectRows = projectRows + 1;
}

var addressRows = 0;

function addressTable() {

    var $tbody = $('#address-table').find('tbody');

    var $tr = $("<tr>");


    $tr.append(
        "<td>" + "<hidden id='addressId" + addressRows + "'/>" +
        "<hidden id='addressVersion" + addressRows + "'/>" +
        "<input class='form-control' id='inputStreet" + addressRows + "' placeholder='Street' type='text' required='true'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputCity" + addressRows + "' placeholder='City' type='text' required='true'>" + "</td>" +
        "<td>" + "<input class='form-control' id='inputState" + addressRows + "' placeholder='State' type='text' required='true'></td>" +
        "<td>" + "<input class='form-control' id='inputZip" + addressRows + "' placeholder='Zip' type='text' required='true'></td>" +
        "<td>" + "<input type='button' value='Delete' onclick='deleteRow(this)'>" + "</td>");
    $tbody.append($tr);

    addressRows = addressRows  + 1;
}

function insertContact() {
    //clear fields in modal
    $('#contactId').val("");
    $('#contactVersion').val("");
    $('#employeeId').val("");
    $('#employeeVersion').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#inputEmail').val("");
    $('#textAreaBackground').val("");

    //open modal
    $('#contactModal').modal('show');

    $('#project-table > tbody').html('');
    $('#address-table > tbody').html('');
    projectTable();
    addressTable();
}

function saveContact() {

    var projArray = [];
    var addressArray = [];
    var result = true;

    for(var k=0;k<$('#project-table tr').length-1;k++) {
        if(checkInput($('#inputRate'+k).val())) {

        } else {
            result = false;
            break;
        }
    }


    if(result ) {
    for(var i=0;i<$('#project-table tr').length-1;i++) {
        var element = {
            id: $('#projectId'+i).val(),
            version: $('#projectVersion'+i).val(),
            projectName: $('#inputProjectName'+i).val(),
            clientName: $('#inputClientName'+i).val(),
            fieldRate: $('#inputRate'+i).val()
        }
        projArray.push(element);
    }

    for(var j=0;j<$('#address-table tr').length-1;j++) {
        var element2 = {
            id: $('#addressId'+j).val(),
            version: $('#addressVersion'+j).val(),
            streetAddress: $('#inputStreet'+j).val(),
            zip: $('#inputZip'+j).val(),
            state: $('#inputState'+j).val(),
            city: $('#inputCity'+j).val()
        }
        addressArray.push(element2);
    }

    var contactId = $('#contactId').val();
    var contactVersion = $('#contactVersion').val();
    var emailAddress = $('#inputEmail').val();
    var employeeId = $('#employeeId').val();
    var employeeVersion = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var background = $('#textAreaBackground').val();



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
            projectList:
                projArray
        },
        addressList: addressArray
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
        success: function() {
            window.location.reload();
        }
    })
    }
    else {
        alert("Must input numbers in rate field");
    }
}

function editContact(id) {

    //retrieve the contact with the passed in id
    $.getJSON('/api/contact/' + id, {
        ajax: 'true'
    }, function (contact) {
        console.log(contact);
        if($('#project-table tr').length-1 === 0) {
            for (var i = 0; i < contact.employee.projectList.length; i++) {
                projectTable();
                $('#projectId' + i).val(contact.employee.projectList[i].id);
                $('#projectVersion' + i).val(contact.employee.projectList[i].version);
                $('#inputProjectName' + i).val(contact.employee.projectList[i].projectName);
                $('#inputClientName' + i).val(contact.employee.projectList[i].clientName);
                $('#inputRate' + i).val(contact.employee.projectList[i].fieldRate);
                console.log(contact.employee.projectList[i]);
                console.log($('#projectId' + i).val());
            }
        }

        if($('#address-table tr').length-1 === 0) {
            for (var j = 0; j < contact.addressList.length; j++) {
                addressTable();
                $('#addressId' + j).val(contact.addressList[j].id);
                $('#addressVersion' + j).val(contact.addressList[j].version);
                $('#inputStreet' + j).val(contact.addressList[j].streetAddress);
                $('#inputState' + j).val(contact.addressList[j].state);
                $('#inputZip' + j).val(contact.addressList[j].zip);
                $('#inputCity' + j).val(contact.addressList[j].city);
                console.log(contact.addressList[j]);
                console.log($('#addressId' + j).val());
            }
        }



        //populate values (hidden and input)
        $('#contactId').val(contact.id);
        $('#contactVersion').val(contact.version);
        $('#inputEmail').val(contact.emailAddress);
        $('#employeeId').val(contact.employee.id);
        $('#employeeVersion').val(contact.employee.version);
        $('#inputFirstName').val(contact.employee.firstName);
        $('#inputLastName').val(contact.employee.lastName);
        $('#textAreaBackground').val(contact.employee.background);

    //open the modal
    $('#contactModal').modal('show');
    });

}

function deleteModal() {
    $('#confirmDeleteModal').on('click','.btn-ok', function (e) {
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/contact/" + id,
            async: true,
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("Error Deleting Contact");
            }
        })
    });

    $('#confirmDeleteModal').on('show.bs.modal',function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId',data.recordId);
    });

}

function checkInput(x) {
    var regex=/^[0-9]+$/;
    if(x.match(regex))
    {
        return false;
    }
}