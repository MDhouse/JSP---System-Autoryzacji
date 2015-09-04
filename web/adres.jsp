<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Autoryzacji</title>
    </head>
    <body>
        <h1>Adres</h1>
        <h3>Dodaj adres</h3>
        
        <form action="AddTheAdres" method="post">
	<table>
 	<tr><td>Wybierz typ adresu:</td>
 	<td><select name="typeofadres">
 		<option value="default"></option>
		<option value="checkIn">Zameldowania</option>
		<option value="ofCorrespondence">Korespondencyjny</option>
		<option value="work">Praca</option>
	</select>
	</td></tr>
 	<tr><td>Wybierz województwo</td>
 	<td><select name="province">
 		<option value="default"></option>
		<option value="dolnoslaskie">dolnośląskie</option>
		<option value="kujawsko-pomorskie">kujawsko-pomorskie</option>
		<option value="lubelskie">lubelskie</option>
		<option value="lubuskie">lubuskie</option>
		<option value="lodzkie">łódzkie</option>
		<option value="malopolskie">małopolskie</option>
		<option value="mazowieckie">mazowieckie</option>
		<option value="opolskie">opolskie</option>
		<option value="podkarpackie">podkarpackie</option>
		<option value="podlaskie">podlaskie</option>
		<option value="pomorskie">pomorskie</option>
		<option value="slaskie">śląskie</option>
		<option value="swietokrzyskie">świętokrzyskie</option>
		<option value="warminsko-mazurskie">warmińsko-mazurskie</option>
		<option value="wielkopolskie">wielkopolskie</option>
		<option value="zachodniopomorskie">zachodniopomorskie</option>
	</select>
	</td></tr>
	<tr><td>Miasto:</td><td><input type="text" name="city"></td></tr>
	<tr><td>Kod pocztowy:</td><td><input type="text" name="postalcode"></td></tr>
	<tr><td>Ulica:</td><td><input type="text" name="street"></td></tr>
	<tr><td>Numer domu/mieszkania</td><td><input type="text" name="housenumber"></td></tr>
 	</table><br>
 	<input type="hidden" name="user" value="<%=session.getAttribute("username")%>">
               
 	<input type="submit" value="Dodaj adres">	
        <input type="reset" value="Wyczyść dane">
        </form>

        <h4><font color=red>
	<%
		if(request.getAttribute("adres") != null)
			out.println(request.getAttribute("adres"));
		if(request.getAttribute("province") != null)
			out.println(request.getAttribute("province"));
		if(request.getAttribute("type") != null)
			out.println(request.getAttribute("type"));
	%>
        </font></h4>
    </body>
</html>