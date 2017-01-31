<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : unos_clana
    Created on : Apr 21, 2016, 9:44:27 PM
    Author     : Jelena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <c:if test="${rezim==1}">
            <title>Karate klub | Unos clana</title>
        </c:if> 

        <c:if test="${rezim==2}">
            <title>Karate klub | Rad sa clanom</title>
        </c:if> 
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="../resources/apple-touch-icon" href="../resources/apple-touch-icon.png">
        <link rel="icon" href="../resources/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resources/css/main.css">
        <script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="../resources/js/datapicker-sr.js"></script>
        <script>
            $(function () {
                $("#datum_rodjenja").datepicker({
                    dateFormat: "dd.mm.yy."
                });
            });
        </script>
    </head>
    <body>
        <%@include file="meni.jsp" %>
        <jsp:useBean id="clan" scope="request" class="domen.Clan" />

        <c:if test="${rezim==1}">
            <h2 class="text-center">Unos clana</h2>
        </c:if> 

        <c:if test="${rezim==2}">
            <h2 class="text-center">Rad sa clanom: <jsp:getProperty name="clan" property="ime" /> <jsp:getProperty name="clan" property="prezime" /></h2>
        </c:if> 

        <hr/>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <form class="form-horizontal" role="form" action="../action/unos_clana" method="POST">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="broj_clana">Broj clana:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="broj_clana" name="broj_clana"
                                       value="${clan.brojClana}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="datum_uclanjenja">Datum uclanjenja:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="datum_uclanjenja" name="datum_uclanjenja"
                                       value="<fmt:formatDate value="${clan.datumUclanjenja}" pattern="dd.MM.yyyy." />" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="ime">Ime:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="ime" name="ime" value="${(clan.ime!=null ? clan.ime: '')}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="prezime">Prezime:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="prezime" name="prezime" value="${(clan.prezime!=null ? clan.prezime: '')}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="datum_rodjenja">Datum rodjenja:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="datum_rodjenja" name="datum_rodjenja"  value="<fmt:formatDate value="${clan.datumRodjenja}" pattern="dd.MM.yyyy." />" placeholder="dd.MM.yyyy.">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="adresa">Adresa:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="adresa" name="adresa" value="${(clan.adresa!=null ? clan.adresa : '')}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="kontakt">Kontakt:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="kontakt" name="kontakt" value="${(clan.kontakt!=null ? clan.kontakt : '')}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="pojas">Pojas:</label>
                            <div class="col-sm-6">
                                <select class="form-control" id="pojas" name="pojas">
                                    <c:forEach var="pojas" items="${listaPojaseva}">
                                        <option value="${pojas.pojasId}" ${pojas.pojasId == clan.pojasId.pojasId ? 'selected="selected"' : ''}>${pojas.bojaPojasa}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group"> 
                            <div class="col-sm-offset-3 col-sm-9">
                                <br/>
                                <button type="submit" class="btn btn-default">Sacuvaj</button>
                            </div>
                        </div>
                    </form>

                </div>

                <c:if test="${rezim==2}" var="rezim" scope="request">
                    <div class="col-md-4">
                        <form role="form" action="../action/obrisi_clana?brojClana=<jsp:getProperty name="clan" property="brojClana" />" method="POST">
                            <button type="submit" class="btn btn-default">Obrisi</button>
                        </form>
                    </div>
                </c:if> 
            </div>
        </div>


        <script>window.jQuery || document.write('<script src="../resources/js/vendor/jquery-1.11.2.js"><\/script>')
        </script>
        <script src="../resources/js/vendor/bootstrap.min.js"></script>
        <script src="../resources/js/main.js"></script>
    </body>
</html>
