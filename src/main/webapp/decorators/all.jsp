<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<% request.setAttribute("appPath", request.getContextPath()); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><decorator:title default="billing" /></title>
	    <script type="text/javascript">var APP_PATH = "${appPath}";</script>  
		 
		<script src="${appPath}/static/jslib/jquery/jquery-1.6.2.js" type="text/javascript"></script>
		
		<script src="${appPath}/static/jslib/jquery-ui/jquery-ui-1.8.16.custom.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="${appPath}/static/css/ui-redmond/jquery-ui-1.8.16.custom.css" />
		
		<script src="${appPath}/static/jslib/jqgrid/i18n/grid.locale-cn.js" type="text/javascript"></script>
		<script src="${appPath}/static/jslib/jqgrid/jquery.jqGrid.src.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="${appPath}/static/css/ui.jqgrid.css" />
		
		<script src="${appPath}/static/jslib/jquery/multiselect2side/jquery.multiselect2side.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="${appPath}/static/jslib/jquery/multiselect2side/jquery.multiselect2side.css" />
		
		<script src="${appPath}/static/chart/FusionCharts.js" type="text/javascript"></script>
		
		<script src="${appPath}/static/js/namespace.js" type="text/javascript"></script>
		<script src="${appPath}/static/js/required.js" type="text/javascript"></script>
		<script src="${appPath}/static/js/multiselect.js" type="text/javascript"></script>
		<script src="${appPath}/static/js/areaSelect.js" type="text/javascript"></script>
		<script src="${appPath}/static/js/reportParam.js" type="text/javascript"></script>
		<script src="${appPath}/static/js/ajax-pushlet-client.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="${appPath}/static/css/main.css" />
		<decorator:head />
	</head>
	<body>	
 		<decorator:body />
    </body>
</html>