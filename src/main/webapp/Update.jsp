<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 p-8">
<center><h1>Update Product</h1></center><br/>
    <form action="updatedata" method="post" class="max-w-lg mx-auto bg-white p-8 rounded-lg shadow-md">
        <div class="mb-4">
            <label for="proname" class="block text-gray-700 font-bold mb-2">Product Name:</label>
            <input id="proname" name="proname" type="text" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
        </div>
        <div class="mb-4">
            <label for="protitle" class="block text-gray-700 font-bold mb-2">Product Title:</label>
            <input id="protitle" name="protitle" type="text" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
        </div>
        <div class="mb-4">
            <label for="probody" class="block text-gray-700 font-bold mb-2">Product Body:</label>
            <input id="probody" name="probody" type="text" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
        </div>
        <button type="submit" class="bg-indigo-600 text-white rounded-lg px-4 py-2 hover:bg-indigo-700">Update Product</button>
    </form>
</body>
</html>
