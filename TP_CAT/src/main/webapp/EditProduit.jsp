<%--
  Created by IntelliJ IDEA.
  User: salmane
  Date: 22/06/2021
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Produit</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<jsp:include page="/webContent/header.jsp"></jsp:include>
<p></p>

    <div class=" container card col-md-8 col-md-offset-2  ">
        <div class="card-header bg-primary " style="color: white; ">Saisir un Produit</div>
        <div class="card-body">
            <form action="UpdateProduit.php" method="post">
                <div class="mb-3">
                    <label class="form-label">ID</label>
                    <input type="text" name="id" value="${produit.id}" class="form-control"  required="required">
                    <span></span>
                </div>
                <div class="mb-3">
                    <label class="form-label">Désignation</label>
                    <input type="text" name="designation" value="${produit.designation}" class="form-control"  required="required">
                    <span></span>
                </div>
                <div class="mb-3">
                    <label class="form-label">Prix</label>
                    <input type="text" name="prix" value="${produit.prix}" class="form-control">
                    <span></span>
                </div>
                <div class="mb-3">
                    <label class="form-label">Quantité</label>
                    <input type="text" name="quantite" value="${produit.quantite}" class="form-control">
                    <span></span>
                </div>

                    <button type="submit" class="btn btn-primary">Edit</button>

            </form>





        </div>
    </div>

</body>
</html>
