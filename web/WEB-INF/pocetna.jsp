<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Pocetna</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="../resources/apple-touch-icon" href="../resources/apple-touch-icon.png">
        <link rel="icon" href="../resources/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resources/css/main.css">
        <script src="../resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
</head>
<body>
    <%@include file="meni.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <br/>
                <div class="panel-body inf-content">
                    <strong>Podaci</strong>
                    <br/>
                    <div class="table-responsive">
                        <table class="table table-condensed table-responsive table-user-information">
                            <tbody>
                                <tr><td><strong>Username:</strong></td>
                                    <td class="text-danger">${ulogovan.username}</td>
                                </tr>
                                <tr><td><strong>Ime:</strong></td>
                                    <td class="text-danger">${ulogovan.ime}</td>
                                </tr>
                                <tr><td><strong>Prezime:</strong></td>
                                    <td class="text-danger">${ulogovan.prezime}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="../resources/js/jquery-1.11.1.min.js"></script>
</body>
</html>
