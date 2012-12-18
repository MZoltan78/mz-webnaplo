<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="resources" value="/resources/adminica" />
		<div id="template_options" class="clearfix">
<!-- 			<h3> -->
<%-- 				<img src="${resources}/images/adminica.png" alt="Adminica"> --%>
<!-- 			</h3> -->
			<div class="round_all">
				<label>MyCompany</label>
			</div>
<!-- 			<div class="layout_size round_all"> -->
<!-- 				<label>Layout:</label> <a href="css/theme/switcher1.php?style=switcher.css">Fluid</a><span>|</span> <a -->
<!-- 					href="css/theme/switcher1.php?style=../layout_fixed.css">Fixed</a><span> -->
<!-- 			</div> -->
<!-- 			<div class="layout_position round_all"> -->
<!-- 				<label>Header: </label> <a href="css/theme/switcher2.php?style=switcher.css">Side</a><span>|</span> <a -->
<!-- 					href="css/theme/switcher2.php?style=../header_top.css">Top</a><span>|</span> <a -->
<!-- 					href="css/theme/switcher2.php?style=../header_slideout.css">Slide</a> -->
<!-- 			</div> -->
			<div class="theme_colour round_all">
				<c:url var="themeSwitcherUrl" value="/theme" />
				<form action="${themeSwitcherUrl}" method="get">
					<label>Colour:</label>
					<a class="black" href="${themeSwitcherUrl}/black"><span>Black</span></a> 
					<a class="blue" href="${themeSwitcherUrl}/blue"><span>Blue</span></a> 
<!-- 					<a class="navy"	href="css/theme/switcher3.php?style=theme_navy.css"><span>Navy</span></a>  -->
<!-- 					<a class="red"	href="css/theme/switcher3.php?style=theme_red.css"><span>Red</span></a>  -->
<!-- 					<a class="green" href="css/theme/switcher3.php?style=theme_green.css"><span>Green</span></a>  -->
<!-- 					<a class="magenta" href="css/theme/switcher3.php?style=theme_magenta.css"><span>Magenta</span></a>  -->
<!-- 					<a class="orange" href="css/theme/switcher3.php?style=theme_brown.css"><span>Brown</span></a> -->
				</form>
			</div>
			<div class="theme_background round_all">
				<label>Background:</label> 
<!-- 				<a href="css/theme/switcher4.php?style=switcher.css">Boxes</a><span>|</span> <a -->
<!-- 					href="css/theme/switcher4.php?style=bg_punched.css">Punched</a><span>|</span> <a href="css/theme/switcher4.php?style=bg_honeycomb.css">Honeycomb</a><span>|</span> -->
<!-- 				<a href="css/theme/switcher4.php?style=bg_wood.css">Wood</a><span>|</span> <a href="css/theme/switcher4.php?style=bg_dark_wood.css">Timber</a><span>|</span> -->
<!-- 				<a href="css/theme/switcher4.php?style=bg_noise.css">Noise</a> -->
			</div>
		</div>
