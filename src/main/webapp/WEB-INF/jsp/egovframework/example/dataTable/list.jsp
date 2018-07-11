
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
				"url": "<c:url value='/ajax.do'/>",
				"data": function ( d ) {
					d.table = "park";
				}
			},
			"columns": [
				{"title": "아이디", "data": "id"},
				{"title": "코드", "data": "code"},
				{"title": "이름", "data": "name"},
				{"title": "유형코드", "data": "park_type_code"},
				{"title": "도로명주소", "data": "address_road"},
				{"title": "지번주소", "data": "address_jibun"},
				{"title": "위도", "data": "latitude"},
				{"title": "경도", "data": "longitude"},
				{"title": "면적", "data": "area"},
				{"title": "등록자ID", "data": "registered_id"},
				{"title": "수정자ID", "data": "updated_id"},
				{"title": "등록일자", "data": "registered_at"},
				{"title": "수정일자", "data": "updated_at"}
				
			],
			"order": [[1, 'asc']]
		});

	} );
	</script>
</head>

<body>
	<div class="container">
		<h1>게시글 목록</h1>
		<table style="100%" id="example" class="table table-striped table-bordered" >
		</table>
	</div>
</body>
</html>
