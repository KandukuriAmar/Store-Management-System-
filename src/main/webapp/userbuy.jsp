<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 p-8">
    <div class="max-w-lg mx-auto bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl font-bold mb-4">Add Product</h1>
        <form action="useritemsadd" method="post">
    <div class="mb-4">
        <label for="PRODUCT_NUMBER" class="block text-gray-700 font-bold mb-2">Product Number:</label>
        <input id="PRODUCT_NUMBER" name="PRODUCT_NUMBER" type="text" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
    </div>
    <div class="mb-4">
        <label for="USERNAME" class="block text-gray-700 font-bold mb-2">Username:</label>
        <input id="USERNAME" name="USERNAME" type="text" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
    </div>
    <div class="mb-4">
        <label for="QUANTITY" class="block text-gray-700 font-bold mb-2">Quantity:</label>
        <input id="QUANTITY" name="QUANTITY" type="number" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
    </div>
    <div class="mb-4">
        <label for="GMAIL" class="block text-gray-700 font-bold mb-2">Gmail:</label>
        <input id="GMAIL" name="GMAIL" type="email" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-600"/>
    </div>
    <button type="submit" class="bg-indigo-600 text-white rounded-lg px-4 py-2 hover:bg-indigo-700">Submit</button>
</form>

    </div>
</body>
</html>
