package com.example.dao;
import com.example.model.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ItemDao {
    private static final String URL = "jdbc:mysql://localhost:3306/MVC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "darshan3009";
    public Item getItemById(int id) {
        Item item = new Item();
        item.setId(id);
        item.setName("Item " + id);
        item.setPrice(10.0 * id);
        return item;
    }
    public List<Item> getAllItems() throws ClassNotFoundException {
        List<Item> itemList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM view";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return itemList;
    }
    public Item getItemById1(int Id) throws ClassNotFoundException {
        Item item = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM view WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return item;
    }
    public boolean getinsertItem(Item item) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO view (name, price) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    public boolean getupdateItem(Item item) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "UPDATE view SET name = ?, price = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setInt(3, item.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    public boolean getdeleteItem(int itemId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "DELETE FROM view WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}