<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Note creation</title>
</head>
<body>
	<form:form modelAttribute="newNote">
		<div>
			<div>Title:</div>
			<div>
				<form:input path="title" text="${note.title}" />
			</div>
		</div>
		<div>
			<div>Content:</div>
			<div>
				<form:input path="content" text="${note.content}" />
			</div>
		</div>
		<div>
			<div>Category:</div>
			<div>
				<form:select path="category">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${categoryList}" />
				</form:select>
			</div>
		</div>
		<br>
		<div>
			<input type="submit" value="Create Note" />
		</div>
	</form:form>
</body>
</html>