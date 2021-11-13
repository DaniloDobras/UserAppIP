<jsp:include flush="true" page="WEB-INF/header.jsp" />
<%@page import="java.util.ArrayList"%>
<%@page import = "dto.Flight" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/UserPageStyle.css">
    <link rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Montserrat">
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni" crossorigin="anonymous"> -->
    <!-- <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> -->
    <title>ETFBL</title>
</head>
<body>

 

    <div class="central-form">
       <div class="left" >
			<%
			ArrayList<Flight> flights = (ArrayList<Flight>)session.getAttribute("flights");
			for(Flight f : flights){%>
				<p> <%= f.getId() %></p>
			<%}%>
       </div>

       <div class="right">

       </div>
    </div>

    <div class="contact-form">

        <div class="map-form">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2832.6924676367707!2d17.18478981553424!3d44.766686279098884!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475e03220b799e4f%3A0x506efaeb756840da!2z0JXQu9C10LrRgtGA0L7RgtC10YXQvdC40YfQutC4INGE0LDQutGD0LvRgtC10YI!5e0!3m2!1sbs!2sba!4v1627154403264!5m2!1sbs!2sba" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
        </div>
        <h1>Kontaktirajte nas</h1>
       
        <div class="phone">
            <h3 class="phone"> Telefon: 0303003002</h3>
            <h3 class="phone"> Fax: 0303003002</h3>
        </div>
  
        <form class="contact">
            <input type="text" class="contact-text" placeholder="Email">
            <input type="text" class="contact-text" placeholder="Naslov">
            <textarea type="text" class="contact-text" placeholder="Poruka"></textarea>
            <input type="submit" class="send-button" value="Send">
        </form>
    </div>

    <footer>
        <div class="footer-content">
            <p>copyright &copy; 2021 ETFBL. designed by  <span>Danilo Dobras</span></p>
        </div>
    </footer>

</body>
</html>