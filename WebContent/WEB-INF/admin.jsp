<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ page import="entities.Commande" %>
        <%@ page import="entities.Produit" %>
    
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="web.EtsieServlet"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Admin</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style1.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>ETSY<span></span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        
          </li> 
        </ul> 
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li>
            <a class="logout" href="http://localhost:8080/Etsie/Deconnexion">Abmelden</a>
          </li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered">
            <a ><img src="img/ui-sam.jpg" class="img-circle" width="80"></a>
          </p>
          <h5 class="centered">Aymen Benjbara</h5>
          <li class="mt">
            <a href="http://localhost:8080/Etsie/Admin">
              <i class="fa fa-dashboard"></i>
              <span>Gesamtansicht</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span>Handlungen</span>
              </a>
            <ul class="sub">
              <li>
                <a href="http://localhost:8080/Etsie/ajoutProd">Ajouter un Produit</a>
              </li> 
            </ul>
          </li> 
           
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        </div>
        <div class="row mt">
          <div class="col-md-12">
          <c:if test="${succes != null }">
	<H2 style="color: green" role="alert">
  		<c:out value=" ${succes} "></c:out>
	</H2>
</c:if>
<c:if test="${erreur != null }">
	<H2 style="color: red"" role="alert">
  		<c:out value=" ${erreur} "></c:out>
	</H2>
</c:if>
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i> Liste des Produits</h4>
                <hr>
                <thead>
                  <tr>
                    <th><i class="fa fa-bookmark"></i> Numero du Produit</th>
                    <th class="fa fa-edit"> </i>Prix</th>
                    <th><i class=" fa fa-edit"></i> Nom du Produit</th>
                    <th><i class=" fa fa-edit"></i>Modifier/Supprimer</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ produit}" var="produit">
                  <tr>
                    <td>
                      <a>${ produit.numPro}</a>
                    </td>
                    <td>${ produit.puProd}</td>
                    <td>${ produit.nomPro} </td> 
                      <td>
                     <a href="http://localhost:8080/Etsie/editProduit?id_p=${ produit.numPro}"> <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button></a>
                     <a href="http://localhost:8080/Etsie/deleteProduit?id_p=${ produit.numPro}"><button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
                      </td>
                      </tr>
                  </c:forEach>

                   
                </tbody>
              </table>
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-md-12 -->
        </div>
        <!-- row -->
        <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i> Liste des Commandes</h4>
                <hr>
                <thead>
                  <tr>
                    <th><i class="fa fa-bookmark"></i>Numero du Commande</th>
                    <th class="fa fa-edit"> </i>Date de Commande</th> 
                      <th></th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach items="${ commande}" var="commande">
                  <tr>
                    <td>${ commande.numCde}</td>
                    <td>${ commande.dateCde}</td> 
                     <td>
				  </tr>
                  </c:forEach>
<!--                   <tr> -->
<!--                     <td class="hidden-phone">32</td> -->
<!--                     <td class="hidden-phone">Lounes Berhouchi</td> -->
<!--                       <td>lou.berh1@gmail.com</td>   -->
<!--                       <td>choko123</td>  -->
<!--                       <td> -->
<%--                   <button class="btn btn-danger btn-xs"><a href="http://localhost:8080/Etsie/ajoutDoc?id_r=${ responsable.id_respo}"><i class="fa fa-trash-o "></i></a></button>   --%>
<!--                     </td> -->
                    
<!--                   </tr> -->
                   
                </tbody>
              </table>
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-md-12 -->
        </div>
        <!-- /row -->
      </section>
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
     
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->
  
</body>

</html>
