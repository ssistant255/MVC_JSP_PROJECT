package com.example.Controller;
import java.util.List;

import com.example.dao.ItemDao;
import com.example.model.Item;

public class ItemController {
    private ItemDao itemDAO;

    public ItemController() {
        this.itemDAO = new ItemDao();
    }

    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }
    
    public Item getItemById1(int id) throws ClassNotFoundException {
        return itemDAO.getItemById1(id);
    }
    public List<Item> getAllItems() throws ClassNotFoundException
    {
		return itemDAO.getAllItems();
    }
    public boolean getinsertItem(Item item)throws ClassNotFoundException
    {
    	return itemDAO.getinsertItem(item);
    }
    public boolean getupdateItem(Item item)throws ClassNotFoundException
    {
    	
    	return itemDAO.getupdateItem(item);
    }
    public boolean getdeleteItem(int itemId)throws ClassNotFoundException
    {
    	return itemDAO.getdeleteItem(itemId);
    }
}