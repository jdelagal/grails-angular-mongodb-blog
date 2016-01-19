<!DOCTYPE html>
<html ng-app="gambApp" lang="en">
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>
    <g:layoutTitle default="Catalogo de Servicios"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <asset:link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
        <asset:stylesheet href="font-awesome/css/font-awesome.css" />
        <asset:stylesheet href="bootstrap-css/css/bootstrap.css" />
        <asset:stylesheet href="admin/main.css" />
        <asset:javascript src="ckeditor/ckeditor.js"/>
        <asset:javascript src="admin.js"/>
    <g:layoutHead/>
</head>
<body>
<div id="wrap">
    <div ng-include="'views/includes/header.html'"></div>
    <div class="container" id="content">
        <g:layoutBody/>
    </div>
</div>
<div ng-include="'views/includes/footer.html'"></div>
</body>
</html>
