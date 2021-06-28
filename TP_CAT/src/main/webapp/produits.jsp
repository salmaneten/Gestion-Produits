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
    <title>Produits</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/webContent/header.jsp"></jsp:include>
    <p></p>
    <div class="container">
        <div class=" card col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 ">
            <div class="card-header bg-primary " style="color: white; ">Recherche des produits</div>
            <div class="card-body">
                <form action="chercher.php" method="get">
                    <label>Mot cle</label>
                    <input type="text" name="motCle" value="${model.motCle}">
                    <button type="submit" class="btn btn-primary">chercher</button>
                </form>
                <table class="table table-striped">
                    <tr>
                        <th>ID</th><th>Designation</th><th>Prix</th><th>Quantite</th>
                    </tr>
                    <c:forEach items="${model.produits}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.designation}</td>
                            <td>${p.prix}</td>
                            <td>${p.quantite}</td>
                            <td><a onclick="return confirm('êtes vous sûr?')"  href="Supprimer.php?id=${p.id}" class="btn btn-danger">Supprimer</a></td>
                            <td><a href="Edit.php?id=${p.id} " class="btn btn-warning">Modifier</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
