<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${note.title}</title>
</head>
<body>
	<c:forEach var="note" items="${noteList}">
		<ul>
			<li>
				<div>${note.id})${note.title} / ${note.category.name} /
					${note.content} / last modification: ${note.lastModification} /
					creation: ${note.creationDate}</div>
			</li>
		</ul>
	</c:forEach>
</body>
</html>