<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Controller.ItemController" %>
<%@ page import="com.example.model.Item" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show Item</title>
</head>
<body>
    <h1>Show Item</h1>
    <form action="show.jsp" method="post">
        <h2>Insert Item</h2>
        <input type="hidden" name="action" value="insert">
        Name: <input type="text" name="name"><br>
        Price: <input type="text" name="price"><br>
        <input type="submit" value="Insert">
    </form>
    <h2>Update Item</h2>
    <form action="show.jsp" method="post">
        <input type="hidden" name="action" value="update">
        ID: <input type="text" name="id"><br>
        Name: <input type="text" name="name"><br>
        Price: <input type="text" name="price"><br>
        <input type="submit" value="Update">
    </form>
    <h2>Delete Item</h2>
    <form action="show.jsp" method="post">
        <input type="hidden" name="action" value="delete">
        ID: <input type="text" name="id"><br>
        <input type="submit" value="Delete">
    </form>
    <h2>Items List</h2>
    <%
        ItemController itemController = new ItemController();
        List<Item> itemList = itemController.getAllItems();
        if (itemList != null && !itemList.isEmpty()) {
            for (Item item : itemList) {
    %>
                <ul>
                    <li>ID: <%= item.getId() %></li>
                    <li>Name: <%= item.getName() %></li>
                    <li>Price: <%= item.getPrice() %></li>
                </ul>
    <%
            }
        } else {
    %>
            <p>No items found.</p>
    <%
        }
    %>
    <a href="show.jsp">show Item</a>
</body>
</html>