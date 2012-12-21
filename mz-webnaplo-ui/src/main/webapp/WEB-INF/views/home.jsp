<h1>HOME</h1>

login page: <a href="<c:url value='/login'/>">LOGIN</a><br/>
admin page: <a href="<c:url value='/admin/welcome'/>">ADMIN</a><br/>
auth page: <a href="<c:url value='/auth/welcome'/>">AUTH</a><br/>
Attack page: <a href="<c:url value='/attack'/>">ATTACK</a><br/>
QR Code page: <a href="<c:url value='/qr'/>">QR CODE</a><br/><br/>

facebook: <a href="<c:url value="/connect/facebook" />">Connect to facebook (GET)</a>		<br/><br/>
example get: <a href="<c:url value="/facebook/example" />">Example (GET)</a>		<br/><br/>
<a href="<c:url value="/connect" />">Your connections</a>	<br/><br/>

<!-- FACEBOOK SIGNIN -->
<form name="fb_signin" id="fb_signin" action="<c:url value="/signin/facebook"/>" method="POST">
       <input type="hidden" name="scope" value="publish_stream,user_photos,offline_access" />
	<button type="submit">SIGN-IN FB</button>
</form>

<form action="<c:url value="/signin/facebook" />" method="POST">
    <button type="submit">Sign in with Facebook</button>
    <input type="hidden" name="scope" value="email,publish_stream,offline_access" />		    
</form>
<br/><br/>

actual connection :
<img src="${connection.imageUrl}" /> <a href="${connection.profileUrl}">${connection.displayName}</a>
<br/><br/>



<!--
nem működik!! 
<c:url var="uploadUrl" value="/upload" />
file upload page: <a href="${uploadUrl}">LINK</a>
 -->



<%--

(local)host:
	http://mz1234valami.com:8080/mz-webnaplo-ui/

--------------------------------------------------------

facebook:
	app_id-hoz regisztrálni kell fb-on, telefonszámra kapunk kódot, és website is kell hozzá
	https://developers.facebook.com/
	https://developers.facebook.com/apps/224886380976924/summary

	teszt application
	App ID:	224886380976924
	App Secret:	cbf8d7fd4c1fd8a06c863ef7abf7108c

--------------------------------------------------------

twitter:
	Wasser Spiegel
	@wasserspiegel8
	wasserspiegel8@gmail.com
	
	wasserapp8	(teszt application)
	http://mz1234valami.com:8080/mz-webnaplo-ui/
	Access level	 	Read-only 
	Consumer key		ZNqWyajyb6itScXdIaKxw
	Consumer secret		TrzgQJGaelFPulAgOesETMFNSRcUDuAF397t63W4wg
	Request token URL	https://api.twitter.com/oauth/request_token
	Authorize URL		https://api.twitter.com/oauth/authorize
	Access token URL	https://api.twitter.com/oauth/access_token
	Callback URL		None


--%>