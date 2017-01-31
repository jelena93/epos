<%-- 
    Document   : prijava
    Created on : Apr 20, 2016, 2:50:42 PM
    Author     : Jelena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Karate klub | Prijava</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="resources/apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="/karateklub/resources/css/bootstrap.min.css">
        <link rel="icon" href="resources/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="resources/css/main.css">
        <script src="resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>

    <body>
        <div class="jumbotron">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <h2 class="text-center">Karate klub - Prijava</h2>
                        <hr/>
                        <form class="form-horizontal" role="form" action="/karateklub/action/prijava" method="POST">
                            <div class="form-group">
                                <label for="ime" class="col-sm-3 control-label">Korisnicko ime:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="ime" name="korisnickoIme">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sifra" class="col-sm-3 control-label">Korisnicka sifra:</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="sifra" name="korisnickaSifra">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-10 col-sm-2">
                                    <button type="submit" class="btn btn-default">Prijavi se</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/vendor/jquery-1.11.2.js"><\/script>')
        </script>

        <script src="resources/js/vendor/bootstrap.min.js"></script>

        <script src="resources/js/main.js"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
//            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
//            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
//            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
//            e.src='//www.google-analytics.com/analytics.js';
//            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
//            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>
    </body>
</html>
