<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Controller.ItemController, com.example.model.Item" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show Item</title>
</head>
<body>
    <h1>Item Details</h1>
    <% 
    ItemController itemController = new ItemController();
    int itemId = 2;
    Item item = itemController.getItemById(itemId);
    if (item != null) {
    %>
        <ul>
            <li>ID: <%= item.getId() %></li>
            <li>Name: <%= item.getName() %></li>
            <li>Price: <%= item.getPrice() %></li>
        </ul>
    <%
    } else {
        out.println("<p>Item not found.</p>");
    }
    %>
    <% 
    String action = request.getParameter("action");
    if (action != null) {
        if (action.equals("insert")) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            boolean success = itemController.getinsertItem(new Item(name, price));
            if (success) {
                out.println("<p>Item inserted successfully.</p>");
            } else {
                out.println("<p>Failed to insert item.</p>");
            }
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            boolean success = itemController.getupdateItem(new Item(id, name, price));
            if (success) {
                out.println("<p>Item updated successfully.</p>");
            } else {
                out.println("<p>Failed to update item.</p>");
            }
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean success = itemController.getdeleteItem(id);
            if (success) {
                out.println("<p>Item deleted successfully.</p>");
            } else {
                out.println("<p>Failed to delete item.</p>");
            }
        }
    }
    %>

    <a href="index.jsp">Back to Home</a>
</body>
</html>