<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<c:url var="resources" value="/resources/adminica" />

<!DOCTYPE html>
	<!--[if lt IE 7]> <html lang="en-us" class="no-js ie6"> <![endif]-->
	<!--[if IE 7]>    <html lang="en-us" class="no-js ie7"> <![endif]-->
	<!--[if IE 8]>    <html lang="en-us" class="no-js ie8"> <![endif]-->
	<!--[if IE 9]>    <html lang="en-us" class="no-js ie9"> <![endif]-->
	<!--[if gt IE 8]><!--> <html lang="en-us" class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8">

	<title><spring:message code="application.title" /></title>

	<!-- iPhone, iPad and Android specific settings -->
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1;">
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
		<link rel="apple-touch-icon" href="${resources}/images/iOS_icon.png">


	<!-- Styles -->
		<link rel="stylesheet" type="text/css" href="${resources}/css/all.css" media="screen">
		<link rel="stylesheet" type="text/css" href="${resources}/css/theme/switcher.css" media="screen">
		
<!-- Style Switcher -->
<!-- <link rel="stylesheet" type="text/css" href="css/theme/switcher.css" media="screen"> -->
<!-- <link rel="stylesheet" type="text/css" href="css/theme/switcher1.php?default=switcher.css" media="screen" /> -->
<!-- <link rel="stylesheet" type="text/css" href="css/theme/switcher2.php?default=switcher.css" media="screen" /> -->
<!-- <link rel="stylesheet" type="text/css" href="css/theme/switcher3.php?default=switcher.css" media="screen" /> -->
<!-- <link rel="stylesheet" type="text/css" href="css/theme/switcher4.php?default=switcher.css" media="screen" /> -->
		
	<!-- Scripts -->
		<script type="text/javascript" src="${resources}/js/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="${resources}/js/jquery-ui-1.9.1.js"></script>
		<script type="text/javascript" src="${resources}/js/plugins.js"></script>
		<script type="text/javascript" src="${resources}/js/fancybox/jquery.fancybox-1.3.4.js"></script>
		<script type="text/javascript" src="${resources}/js/quicksand/jquery.quicksand.js"></script>
		<script type="text/javascript" src="${resources}/js/quicksand/custom_sorter.js"></script>
		<script type="text/javascript" src="${resources}/js/quicksand/dash_sorter.js"></script>
		<script type="text/javascript" src="${resources}/js/quicksand/jquery-css-transform.js"></script>
		<script type="text/javascript" src="${resources}/js/quicksand/jquery-animate-css-rotate-scale.js"></script>
		<script type="text/javascript" src="${resources}/js/tinyeditor/tinyeditor.js"></script>
		<script type="text/javascript" src="${resources}/js/jqueryFileTree/jqueryFileTree.js"></script>
		<script type="text/javascript" src="${resources}/js/DataTables/jquery.dataTables.js"></script>
		<script type="text/javascript" src="${resources}/js/slidernav/slidernav.js"></script>
		<!-- This file configures the various jQuery plugins for Adminica. Contains links to help pages for each plugin. -->
		<script type="text/javascript" src="${resources}/js/adminica/adminica_ui.js"></script>

</head>
<body>

	<tiles:insertAttribute name="bodycontent" />

</body>
</html>