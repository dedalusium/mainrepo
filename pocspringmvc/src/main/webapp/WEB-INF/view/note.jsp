<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${note.title}</title>
</head>
<body>
	<h1>${note.title}</h1>
	<h2>${note.category.name}</h2>
	<div>(${note.category})</div>
	<br>
	<div>${note.content}</div>
	<div>date creation: ${note.creationDate}</div>
	<div>dernière modification: ${note.lastModification}</div>
</body>
</html>