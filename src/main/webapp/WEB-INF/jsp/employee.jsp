<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<script>

    $.getJSON('http://10.1.252.17:8080/api/employee/', {
        ajax: 'true'
    }, function (data) {
        console.log(data)
        $.each(data, function(index, single) {
            var fullName = single.firstName + " " + single.lastName
            $('#employee-table').find('tbody')
                .append($('<tr>'))
                .append($('<td>').text(single.id))
                .append($('<td>').text(fullName))
                .append($('<td>').text(single.background))
                .append($('<td>').text(single.projects))
        });
    });
</script>


<div class="container">

    <h2>Employee List</h2>

    <table id="employee-table" class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Background</th>
                <th>Projects</th>
            </tr>
        </thead>
        <tbody>
            <%--jquery will append our data here...     --%>
        </tbody>
    </table>


</div>


<%@include file="includes/footer.jsp"%>