<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<h1>ADMIN welcome <security:authentication property="principal.username" /> !</h1>
