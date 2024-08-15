<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 p-8">
<h1><center>Products that added by admin</center></h1>
    <div class="max-w-4xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-2xl font-bold mb-4">Product List</h1>
        <table class="min-w-full bg-white">
            <thead class="bg-gray-800 text-white">
                <tr>
                    <th class="w-1/3 px-4 py-2">Product Name</th>
                    <th class="w-1/3 px-4 py-2">Product Title</th>
                    <th class="w-1/3 px-4 py-2">Product Body</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Connection con = null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "7799");
                        stmt = con.createStatement();
                        String sql = "SELECT proname, protitle, probody FROM products";
                        rs = stmt.executeQuery(sql);

                        while (rs.next()) {
                            String proname = rs.getString("proname");
                            String protitle = rs.getString("protitle");
                            String probody = rs.getString("probody");
                %>
                <tr class="bg-gray-100">
                    <td class="border px-4 py-2"><%= proname %></td>
                    <td class="border px-4 py-2"><%= protitle %></td>
                    <td class="border px-4 py-2"><%= probody %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
