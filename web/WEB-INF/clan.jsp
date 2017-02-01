<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Prikaz clana</title>
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
            var obrisiClana = false;
            $(document).ready(function () {
                var iznos = document.getElementById("iznos");
                iznos.value = "";
                $('input').on('blur', function () {
                    if (this.type !== 'checkbox') {
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
                var kontakt = document.getElementById("kontakt");
                var adresa = document.getElementById("adresa");
                if (ime.value === "") {
                    ime.className += " prazan";
                }
                if (prezime.value === "") {
                    prezime.className += " prazan";
                }
                if (kontakt.value === "") {
                    kontakt.className += " prazan";
                }
                if (adresa.value === "") {
                    adresa.className += " prazan";
                }
                var validacija = true;
                var greska = "";
                if (ime.value === "" || prezime.value === "" || kontakt.value === "" || adresa.value === "") {
                    greska += "Niste popunili sva polja. <br/>";
                    validacija = false;
                }
                if (!validacija) {
                    $("#upozorenje").html('<div class="alert alert-danger">' +
                            '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' +
                            '<strong>' + greska + '</strong></div>');
                    return false;
                }
                $("#akcija-forma").val('izmeni');
                return true;
            }

            function prikazi() {
                if (!obrisiClana) {
                    $("#btn-obrisi-da").show();
                    $("#btn-obrisi-ne").show();
                    $("#btn-obrisi-ne").html("Ne");
                    $("#naslov").text("");
                    $("#text").html("<p>Da li ste sigurni da želite da obrišete člana?</p>");
                    $("#myModal").modal({
                        show: true,
                        backdrop: 'static',
                        keyboard: false
                    });
                }
                $("#akcija-forma").val('obrisi');
                return obrisiClana;
            }

            function prikaziOdgovor(odgovor) {
                $("#btn-obrisi-da").hide();
                $("#btn-obrisi-ne").show();
                $("#btn-obrisi-ne").html("Ok");
                $("#text").html("<p>" + odgovor + "</p>");
                $("#myModal").modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
            }
            function obrisi() {
                obrisiClana = true;
                document.getElementById('forma').obrisi.click();
            }
            function izmeni() {
                var brojClana = $("#brojClana").val();
                var ime = $("#ime").val();
                var prezime = $("#prezime").val();
                var kontakt = $("#kontakt").val();
                var adresa = $("#adresa").val();
                var datumRodjenja = $("#datumRodjenja").val();
                var email = $("#email").val();
                $.ajax({
                    type: "POST",
                    url: "/karateklub/trener/api/clan/izmena",
                    beforeSend: function (request) {
                        request.setRequestHeader(header, token);
                    },
                    data: {brojClana: parseInt(brojClana), ime: ime, prezime: prezime, kontakt: kontakt,
                        adresa: adresa, datumRodjenja: datumRodjenja, email: email},
                    success: function (data) {
                        prikaziOdgovor(data.odgovor);
                        $("#naslov").text("");
                    },
                    error: function (e) {
                        prikaziOdgovor(e.responseText);
                        $("#naslov").text("Greška");
                    }
                });
            }
            function proveriIznos() {
                var iznos = document.getElementById("iznos");
                if (iznos.value === "") {
                    iznos.className += " prazan";
                    $("#upozorenje").html('<div class="alert alert-danger">' +
                            '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' +
                            '<strong>Unesite iznos.</strong></div>');
                    $('html,body').animate({
                        scrollTop: $("#upozorenje").offset().top - 10
                    });
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <%@include file="meni.jsp" %>
        <div class="container">
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" id="naslov"></h4>
                        </div>
                        <div class="modal-body" id="text">
                            <p>Da li ste sigurni da zelite da obrisete clana?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" id="btn-obrisi-da" data-dismiss="modal" onclick="obrisi()">Da</button>
                            <button type="button" class="btn btn-default" id="btn-obrisi-ne" data-dismiss="modal">Ne</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 unos-clana">
                    <br/>
                    <c:if test="${not empty poruka}">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>${poruka}</strong>
                        </div>
                    </c:if>
                    <h2>Prikaz clana</h2>
                    <hr/>
                    <div id="upozorenje">${greska}</div>
                    <div class="tab-wrap">
                        <div class="media">
                            <div class="parrent pull-left">
                                <ul class="nav nav-tabs nav-stacked">
                                    <li class="active"><a href="#tab1" data-toggle="tab" class="analistic-01">Clan</a></li>
                                    <li class=""><a href="#tab2" data-toggle="tab" class="analistic-02">Clanarina</a></li>
                                </ul>
                            </div>
                            <div class="parrent media-body">
                                <div class="tab-content">
                                    <div class="tab-pane active in" id="tab1">
                                        <div class="media">
                                            <div class="media-body">
                                                <form class="form-horizontal" id="forma" role="form" method="POST" >
                                                    <div class="dropdown">
                                                        <button class="btn btn-danger dropdown-toggle" type="button" id="akcija" data-toggle="dropdown">Akcija
                                                            <span class="glyphicon glyphicon-cog"></span> <span class="caret"></span></button>
                                                        <ul class="dropdown-menu akcija">
                                                            <li><button type="submit" name="izmeni" class="btn-link" onclick="return proveriPolja();"><span class ="glyphicon glyphicon-wrench"></span>Izmeni</button></li>
                                                            <li><button type="submit" name="obrisi" class="btn-link" onclick="return prikazi();"><span class ="glyphicon glyphicon-trash"></span>Obriši</button></li>
                                                        </ul>
                                                    </div>
                                                    <br/>
                                                    <input type="hidden" name="akcija" id="akcija-forma"/>
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-4" for="ime">Datum uclanjenja:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" name="datumUclanjenja" class="form-control" id="datumUclanjenja" value="<fmt:formatDate value="${clan.datumUclanjenja}" pattern="dd.MM.yyyy." />" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-4" for="ime">Ime:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" name="ime" class="form-control" id="ime" value="${clan.ime}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-4" for="prezime">Prezime:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" name="prezime" class="form-control" id="prezime" value="${clan.prezime}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-4" for="kontakt">Kontakt:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" name="kontakt" placeholder="Kontakt" class="form-control" id="kontakt" value="${clan.kontakt}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-4" for="adresa">Adresa:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" name="adresa" placeholder="Adresa" class="form-control" id="adresa" value="${clan.adresa}">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab2">
                                        <div class="media">
                                            <div class="media-body">
                                                <div class="table-responsive">
                                                    <table class="table" id="clanovi">
                                                        <thead>
                                                            <tr>
                                                                <th>Datum uplate</th>
                                                                <th>Mesec</th>
                                                                <th>Godina</th>
                                                                <th>Iznos</th>
                                                                <th>Korisnik</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="clanarina" items="${clan.clanarinaList}">
                                                                <tr>
                                                                    <td><fmt:formatDate value="${clanarina.datumUplate}" pattern="dd.MM.yyyy." /></td>
                                                                    <td>${clanarina.clanarinaPK.mesec}</td>
                                                                    <td>${clanarina.clanarinaPK.godina}</td>
                                                                    <td>${clanarina.iznos}</td>
                                                                    <td>${clanarina.korisnik}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>                                                
                                                <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">Dodaj clanarinu</button>
                                                <div id="demo" class="collapse">
                                                    <br/>
                                                    <form class="form-horizontal" role="form" method="POST" onsubmit="return proveriIznos()">
                                                        <input type="hidden" name="akcija" value="clanarina">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-3" for="iznos">Iznos</label>
                                                            <div class="col-sm-6">
                                                                <input type="number" class="form-control" id="iznos" name="iznos" min="500">
                                                            </div>
                                                        </div>
                                                        <div class="form-group"> 
                                                            <div class="col-sm-offset-6 col-sm-3">
                                                                <br/>
                                                                <button type="submit" class="btn btn-primary">Sacuvaj</button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div> 
                            </div> 
                        </div>  
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
