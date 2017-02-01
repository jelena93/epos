<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Unos clana</title>
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/css/font-awesome.min.css" rel="stylesheet">
        <link href="../resources/css/animate.min.css" rel="stylesheet">
        <link href="../resources/css/prettyPhoto.css" rel="stylesheet">
        <link href="../resources/css/main.css" rel="stylesheet">
        <link href="../resources/css/responsive.css" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="../resources/js/datepicker-sr.js"></script>

        <script>
            $(function() {
                $("#datumRodjenja").datepicker({
                    dateFormat: "dd.mm.yy.",
                    onSelect: function() {
                        this.focus();
                    },
                    onClose: function() {
                        this.blur();
                    }
//                    onSelect: function (dateText, datePicker) {
//                        $('#datumRodjenja').val(dateText);
//                        console.log(dateText);
//                        console.log($('#datumRodjenja').val());
//                    }
                });

            });
            $(document).ready(function() {
                $('input').on('blur', function() {
                    if (this.type !== 'checkbox' && this.type !== 'submit') {
                        if (this.value !== "" && this.value !== null) {
                            this.className = "form-control";
                        } else {
                            this.className += " prazan";
                        }
                    }
                });

            });
            function proveriPolja() {
                var ime = document.getElementById("ime");
                var prezime = document.getElementById("prezime");
                var datumRodjenja = document.getElementById("datumRodjenja");
                var kontakt = document.getElementById("kontakt");
                var adresa = document.getElementById("adresa");
                var email = document.getElementById("email");
                if (ime.value === "") {
                    ime.className += " prazan";
                }
                if (prezime.value === "") {
                    prezime.className += " prazan";
                }
                if (datumRodjenja.value === "") {
                    datumRodjenja.className += " prazan";
                }
                if (adresa.value === "") {
                    adresa.className += " prazan";
                }
                var validacija = true;
                var greska = "";
                if (ime.value === "" || prezime.value === "" || datumRodjenja.value === "" || adresa.value === "") {
                    greska += "Niste popunili sva polja. <br/>";
                    validacija = false;
                }
                if (!kontakt.value.match(/0\d{2}\/\d{3}-\d{4}/g)) {
                    kontakt.className += " prazan";
                    greska += "Kontakt nije u odgovarajućem formatu(0##/###-####). <br/>";
                    validacija = false;
                }
                if (!email.value.match("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")) {
                    email.className += " prazan";
                    greska += "Email nije validan.";
                    validacija = false;
                }
                if (!validacija) {
                    $("#upozorenje").html('<div class="alert alert-danger">' +
                            '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' +
                            '<strong>' + greska + '</strong></div>');
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
    <sec:authentication var="ulogovan" property="principal"/>
    <%@include file="trener_meni.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <h2>Unos člana</h2>
                <hr/>
                <div id="upozorenje"><c:if test="${not empty greska}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>${greska}</strong>
                        </div>
                    </c:if></div>
                <form:form class="form-horizontal" role="form" action="unos" method="POST" modelAttribute="clan" onsubmit="return proveriPolja()">
                    <form:hidden path="brojClana"></form:hidden> 
                    <form:hidden path="datumUclanjenja"></form:hidden> 

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="ime">Ime:</label>
                        <div class="col-sm-8">
                            <form:input path="ime" id="ime" class="form-control" cssErrorClass="form-control prazan"></form:input>
                            <form:errors path="ime" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="prezime">Prezime:</label>
                        <div class="col-sm-8">
                            <form:input path="prezime" id="prezime" class="form-control" cssErrorClass="form-control prazan"></form:input>
                            <form:errors path="prezime" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="datumRodjenja">Datum rođenja:</label>
                        <div class="col-sm-8">
                            <form:input path="datumRodjenja" id="datumRodjenja" placeholder="DD.MM.YYYY." class="form-control" cssErrorClass="form-control prazan"></form:input>
                            <form:errors path="datumRodjenja" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Email:</label>
                        <div class="col-sm-8">
                            <form:input path="email" id="email" class="form-control" cssErrorClass="form-control prazan"></form:input>
                            <form:errors path="email" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="kontakt">Kontakt telefon:</label>
                        <div class="col-sm-8">
                            <form:input path="kontakt" id="kontakt" placeholder="0##/###-####" class="form-control" cssErrorClass="form-control prazan"></form:input>
                            <form:errors path="kontakt" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="adresa">Adresa:</label>
                        <div class="col-sm-8">
                            <form:input path="adresa" id="adresa" class="form-control" cssErrorClass="form-control prazan"></form:input>
                            <form:errors path="adresa" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group"> 
                        <div class="col-sm-offset-9 col-sm-2">
                            <input type="submit" class="btn btn-primary" value="Sačuvaj">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>


    <script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
    <script src='<c:url value="/resources/js/jquery.prettyPhoto.js" />'></script>
    <script src='<c:url value="/resources/js/jquery.isotope.min.js" />'></script>
    <script src='<c:url value="/resources/js/main.js" />'></script>
    <script src='<c:url value="/resources/js/wow.min.js" />'></script>

</body>
</html>
