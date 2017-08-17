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