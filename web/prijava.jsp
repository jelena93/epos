<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Prijava</title>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link href="resources/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
        <link href="resources/css/font-awesome.min.css" rel="stylesheet" />
        <link href="resources/css/login-form-elements.css" rel="stylesheet" />
        <link href="resources/css/login.css" rel="stylesheet" />
        <script src="resources/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Prijava</h3>
                                    <p>Unesite username i lozinku:</p>    
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" action="action/prijava" method="post" class="login-form">
                                    <div class="form-group">
                                        <label class="sr-only" for="form-username">Username</label>
                                        <input type="text" name="username" placeholder="Username" class="form-username form-control" id="form-username">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="form-password">Lozinka:</label>
                                        <input type="password" name="lozinka" placeholder="Lozinka" class="form-password form-control" id="form-password">
                                    </div>
                                    <button type="submit" class="btn">Prijavi se</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.backstretch.min.js"></script>
        <script src="resources/js/scripts.js"></script>
    </body>
</html>
