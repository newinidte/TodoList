package org.todolist.items.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.todolist.items.bean.Item;

/*
 * It is just a helper class which should be replaced by database implementation.
 * Its Just for Demonstration
 */
public class ToDoListService {

 static Map<Integer,Item> itemMap;


 public ToDoListService() {
 super();

 if(itemMap==null)
 {
	 itemMap=new HashMap<Integer,Item>();
 // Creating some objects of Items while initializing
 Item item1=new Item(1, "Coding","Completed","Office","High","N","15/4/2017");
 Item item2=new Item(2, "buy vegetables","pending","home","Medium","N","15/4/2017");
 Item item3=new Item(3, "Meet a friend","In progress","personal","Low","N","15/4/2017");
 Item item4=new Item(4, "pay bill","Not Strated","home","Very Low","N","15/4/2017");


 itemMap.put(1,item1);
 itemMap.put(2,item2);
 itemMap.put(3,item3);
 itemMap.put(4,item4);
 }
 }

 /**
  * Retrieves all the todo list tasks
 * @return
 */
public List<Item> getAllItems()
 {
	
	 List<Item> listOfItems = new ArrayList<Item>();
	 for (Integer key: itemMap.keySet()) {
		 Item item = itemMap.get(key);
		
			 listOfItems.add(item);
		 
		 
	 }
	 return listOfItems;
 }

 /**
  * Retrieves only the specific task
 * @param id
 * @return
 */
public Item getItem(int id)
 {
 Item item= itemMap.get(id);
 return item;
 }
 /**
  * Retrieves a list of task based on the category
 * @param category
 * @return
 */
public List<Item> getItemByCategory(String category)
 {

 List<Item> listOfItems = new ArrayList<Item>();
 for (Integer key: itemMap.keySet()) {
	 Item item = itemMap.get(key);
	 if(category.equalsIgnoreCase(item.getItemCategory())){
		 listOfItems.add(item);
	 }
	 
 }
 return listOfItems;

 }
 /**
  * Adding an item to the todo list
 * @param items
 * @return
 */
public Item addItem(Item items)
 {
 items.setId(itemMap.size()+1);
 itemMap.put(items.getId(), items);
 return items;
 }
 
 /**
  * Update parameters in the task item.
 * @param items
 * @return
 */
public Item updateItem(int id,Item item)
 {
 Item items= itemMap.get(id);
	 
	 items.setItemStatus(!isEmpty(item.getItemStatus())?item.getItemStatus() : items.getItemStatus());
	 items.setItemCategory(!isEmpty(item.getItemCategory())?item.getItemCategory() : items.getItemCategory());
	 items.setItemName(!isEmpty(item.getItemName())?item.getItemName() : items.getItemName());
	 items.setDelIndictor(!isEmpty(item.getDelIndictor())?item.getDelIndictor() : items.getDelIndictor());
	 items.setTagValue(!isEmpty(item.getTagValue())?item.getTagValue() : items.getTagValue());
	 items.setReminder(!isEmpty(item.getReminder())?item.getReminder() : items.getReminder());
	 
 return items;

 }
 /**
  * Delete an item in the todo list
 * @param id
 */
public void deleteItem(int id)
 {
	
	 Item item= itemMap.get(id);
	 item.setDelIndictor("Y");
	
 }
 
public boolean isEmpty(String objValue){
	if(null == objValue || "".equals(objValue))
		return true;
	else
		return false;
	
}


/**
 * Restore all soft deleted values
 * @return
 */
public List<Item> restoreAll() {
	List<Item> listOfItems = new ArrayList<Item>();
	 for (Integer key: itemMap.keySet()) {
		 Item item = itemMap.get(key);
		 if("Y".equalsIgnoreCase(item.getDelIndictor())){	
			 item.setDelIndictor("N");
			 listOfItems.add(item);
		 }
		 }
	 return listOfItems;
}


}
