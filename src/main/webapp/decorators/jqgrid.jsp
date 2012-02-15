<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<% request.setAttribute("appPath", request.getContextPath()); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"　http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><decorator:title default="billing" /></title>
	    <script type="text/javascript">var APP_PATH = "${appPath}";</script>
	    
	    <link rel="stylesheet" type="text/css" media="screen" href="${appPath}/static/css/ui-redmond/jquery-ui-1.8.16.custom.css" />
		<link rel="stylesheet" type="text/css" media="screen" href="${appPath}/static/css/ui.jqgrid.css" />
		 
		<script src="${appPath}/static/jslib/jquery/jquery-1.6.2.js" type="text/javascript"></script>
		<script src="${appPath}/static/jslib/jquery-ui/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
		<script src="${appPath}/static/jslib/jqgrid/i18n/grid.locale-cn.js" type="text/javascript"></script>
		<script src="${appPath}/static/jslib/jqgrid/jquery.jqGrid.src.js" type="text/javascript"></script>
		<script src="${appPath}/static/js/namespace.js" type="text/javascript"></script>
	    <style type="text/css">
		html, body, div, td {
		    font-size: 12px;
		}
		</style>
		<style>
	#tabs { margin-top: 1em; }
	#tabs li .ui-icon-close { float: left; margin: 0.4em 0.2em 0 0; cursor: pointer; }
	</style>
		<decorator:head />
	</head>
	<body>	
 		<decorator:body />
    </body>
</html>