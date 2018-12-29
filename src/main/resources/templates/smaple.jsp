<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<html>
<head>
<title>Hibernate/JPA concurrency demo</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
</head>
<body>

	<p>Order status: ${command.status}.</p>
	<p>Order Date: ${command.orderDate}.</p>

	<form:form>
		<div>
			<form:label path="description">Order detail: </form:label>
			<form:textarea path="description" />
		</div>
		<div>
			<form:label path="orderDate">Order Date: </form:label>
			
			<input type="text" name="orderDate" value="${ command.orderDate }" id="datepicker">
		</div>
		<div>
			<form:label path="status">Change status: </form:label>
			<form:select path="status">
				<form:option value="Approved" />
				<form:option value="Rejected" />
			</form:select>
		</div>
		<form:hidden path="id" />
		<form:hidden path="version" />
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>

