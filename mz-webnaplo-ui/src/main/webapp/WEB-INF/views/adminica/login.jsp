<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<c:url var="resources" value="/resources/adminica" />
<div id="login_box" class="round_all clearfix">



	<label class="fields">
		<strong><spring:message code="ui.user.email"/></strong>
		<input type="text" id="email" class="indent round_all">
	</label> 
	<label class="fields">
		<strong><spring:message code="ui.user.password"/></strong>
		<input type="password" id="password" class="indent round_all">
		<span class="aprobetus">Elfelejtetted?</span>
	</label>
	<button class="button_colour round_all" onClick="location.href='index.html'">
		<img width="24" height="24" alt="Locked 2" src="${resources}/images/icons/small/white/Locked%202.png"><span>Login</span>
	</button>
	<div id="bar" class="round_bottom">
		<label><input type="checkbox">Auto-login in future.</label> <a href="#">Forgot your password?</a>
	</div>
	<a href="#" id="login_logo"><span>Adminica Pro II</span></a>
</div>

<script type="text/javascript">
	// focus on first field in form
	$("input[type='text']:first", document.forms[0]).focus();

	var username = new LiveValidation('email');
	username.add(Validate.Presence);

	var password = new LiveValidation('password');
	password.add(Validate.Presence);
</script>
