<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 p-8">
<center><h1>Delete Product</h1></center><br/>
    <form action="deletedata" method="post" class="max-w-lg mx-auto bg-white p-8 rounded-lg shadow-md">
        <div class="mb-4">
            <label for="proname" class="block text-gray-700 font-bold mb-2">Product Name:</label>
            <input id="proname" name="proname" type="text" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
        </div>
        <button type="submit" class="bg-red-600 text-white rounded-lg px-4 py-2 hover:bg-red-700">Delete Product</button>
    </form>
</body>
</html>


