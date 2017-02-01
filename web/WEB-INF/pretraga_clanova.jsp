<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pretraga clanova</title>
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
            function pretraga(kriterijumPretrage) {
                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url: "/epos/api/clanovi",
                    data: {kriterijumPretrage: kriterijumPretrage},
                    dataType: 'json',
                    success: function (data) {
                        var clanovi = JSON.parse(JSON.stringify(data));
                        $("#clanovi tbody").remove();
                        for (var i = 0; i < clanovi.length; i++) {
                            $('#clanovi').append('<tr><td>' + clanovi[i].brojClana + '</td><td>' +
                                            clanovi[i].ime + '</td><td>'
                                            + clanovi[i].prezime + '</td><td>' +
                                            clanovi[i].kontakt + '</td><td>' +
                                            clanovi[i].adresa + '</td><td><a href="/karateklub/trener/clan/' +
                                            clanovi[i].brojClana + '">Detalji</a></td></tr>');
                        }
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                    }
                });
            }
        </script>
    </head>
    <body>
        <%@include file="meni.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <h2>Pretraga clanova</h2>
                    <hr/>
                    <div class="form-group">
                        <label class="control-label" for="kriterijumPretrage">Unesite kriterijum pretrage:</label>
                        <input type="text" class="form-control" id="kriterijumPretrage" name="kriterijumPretrage" onkeyup="pretraga(this.value)" >
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover" id="clanovi">
                            <thead>
                                <tr>
                                    <th>Broj clana</th>
                                    <th>Ime</th>
                                    <th>Prezime</th>
                                    <th>Kontakt</th>
                                    <th>Adresa</th>
                                    <th>Akcija</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="clan" items="${clanovi}">
                                    <tr>
                                        <td>${clan.brojClana} </td>
                                        <td>${clan.ime} </td>
                                        <td>${clan.prezime} </td>
                                        <td>${clan.kontakt} </td>
                                        <td>${clan.adresa} </td>
                                        <td><a href="../action/clan?brojClana=${clan.brojClana}">Detalji</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
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
