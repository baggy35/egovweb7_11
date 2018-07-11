
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><spring:message code="title.sample" /></title>

	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">

	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

	<script type="text/javascript" class="init">

	$.extend( true, $.fn.dataTable.defaults,
	{
		"language": {
			"url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Korean.json"
		}
	});

	$(document).ready(function() {

		var table = $('#example').DataTable({
			"processing": true,
			"serverSide": true,
			"ajax": {
				"url": "<c:url value='/ajax.dataTable.do'/>",
				"data": function ( d ) {
					d.table = "SAMPLE";
				}
			},
			"columns": [
				{"title": "아이디", "data": "ID"},
				{"title": "이름", "data": "NAME"},
				{"title": "상세설명", "data": "DESCRIPTION"},
				{"title": "사용여부", "data": "USE_YN"},
				{"title": "등록자", "data": "REG_USER"},
				
			],
			"order": [[1, 'asc']]
		});

	} );
	</script>
</head>

<body>
	<div class="container">
		<h1>게시글 목록</h1>
		<table id="example" class="table table-striped table-bordered" >
		</table>
	</div>
</body>
</html>
