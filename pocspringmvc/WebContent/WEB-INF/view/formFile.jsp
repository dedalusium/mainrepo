<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File creation</title>
</head>
<body>
	<form:form modelAttribute="fileToCreate">
		<div>
			<div>Name:</div>
			<div>
				<form:input path="name" />
			</div>
		</div>
		<div>
			<div>ID:</div>
			<div>
				<form:input path="id" />
			</div>
		</div>
		<div>
			<input type="submit" value="Create file" />
		</div>
	</form:form>
</body>
</html>