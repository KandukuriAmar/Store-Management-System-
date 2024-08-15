<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
         <style>
    .navbar-custom .navbar-brand,
    .navbar-custom .nav-link,
    .navbar-custom .dropdown-item,
    .navbar-custom .navbar-toggler-icon,
    .navbar-custom .btn {
      color: white !important;
    }
  </style>
</head>
<body>
    <div class = "bg-black">
    <nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container-fluid">
      <a class="navbar-brand" href="welcome.jsp">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="welcome.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="login.jsp">Logout</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>

        </ul>
        <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>
    </div>
  </nav>
  </div>
<br/>
<center><h2>Products</h2></center>
<div>
 <div id="card-container" class="container">
            <%
                String[] products = {"Orange Wafer", "Oreo", "Oreal Peper", "Bellvita Perfurm", "Tempation sent", "Grains", "Bread", "Ferrero Roster", "Mars", "Snikers", "Kitkat", "Nutella", "Black T-shirt", "Black roster bag", "Roulder Bag", "Jerk Pant", "Cluker Pant", "Klukker cargo", "Adventures books Collection", "Pot plant"};
            String[] pro = {"Orange Wafer: A crunchy wafer with a tangy orange flavor.","Oreo: Classic chocolate sandwich cookies with a sweet cream filling.","Oreal Peper: A pepper-flavored seasoning mix.","Bellvita Perfurm: A refreshing perfume with a floral scent.","Tempation sent: An alluring fragrance with a seductive aroma.","Grains: A mix of whole grains for a healthy diet.","Bread: Freshly baked bread, perfect for sandwiches and toast.","Ferrero Roster: A premium chocolate with a hazelnut center.","Mars: A popular chocolate bar with caramel and nougat.","Snikers: A chocolate bar with peanuts, caramel, and nougat.","Kitkat: Crisp wafers covered in smooth milk chocolate.","Nutella: Creamy hazelnut spread with cocoa.","Black T-shirt: A basic black T-shirt, versatile for any outfit.","Black roster bag: A stylish black bag for everyday use.","Roulder Bag: A durable and spacious bag for travel.","Jerk Pant: Comfortable and trendy pants for casual wear.","Cluker Pant: Stylish pants with a relaxed fit.","Klukker cargo: Utility cargo pants with multiple pockets.","Adventures books Collection: A collection of thrilling adventure books.","Pot plant: A potted plant to brighten up any space."};

                for (int i = 0; i < products.length; i++) {
            %>
                <div class="card" style="width: 18rem; margin: 10px; display: inline-block;">
                    <img src="<%= request.getContextPath() %>/images/<%= (i + 1) %>.jpg" class="card-img-top" alt="Image <%= (i + 1) %>">
                    <div class="card-body">
                        <h5 class="card-title">Card title <%= (i + 1) %></h5>
                        <p class="card-text"><%= products[i] %></p>
                        <h5 class="card-text"><%= pro[i] %></h5>
                        <a href="userbuy.jsp" class="btn btn-primary">Buy</a>
                    </div>
                </div>
            <%
                }
            %>
        </div>
</div>

</body>
</html>
