package org.todolist.items.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.todolist.items.bean.Item;
import org.todolist.items.service.ToDoListService;

@RestController
public class ToDoListController {
	
	ToDoListService todoListService = new ToDoListService();
	
	/**
	 * This method is used to generate all the todo list.
	 * @return
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Item> getItems()
	{
		List<Item> listOfItems;
		listOfItems=todoListService.getAllItems();
		return listOfItems;
	}

	/**
	 * This method is  used to get a particular todo task.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Item getItemsById(@PathVariable int id)
	{
		
		Item item = todoListService.getItem(id);
		
		return item;
	}
	/**
	 * This method is used to retrieve the list of list, Example to retrieve only the todolist of Home tasks.
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/listItemsByCategory/{category}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Item> getItemByCategory(@PathVariable String category)
	{
		 List<Item> listOfItems = todoListService.getItemByCategory(category);
		
		return listOfItems;
	}
	
	/**
	 * This method is used to add items to the list.
	 * @param items
	 * @return
	 */
	@RequestMapping(value = "/items", method = RequestMethod.POST, headers = "Accept=application/json")
	 public Item addItem(@RequestBody Item item) {
	 return todoListService.addItem(item);
	 }
	
	/**
	 * This method used to update the Tag value,Set reminders,Status Change and other fields related to Item.
	 * @param item - pass items that need to updated
	 * @return
	 */
	@RequestMapping(value = "/items/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public Item updateItem(@PathVariable("id") int id,@RequestBody Item item) {
	 return todoListService.updateItem(id,item);
	 
	 }
	
	/** This method to retrieve the soft deleted value by changing the field delIndicator to "N".
	 * @return
	 */
	@RequestMapping(value = "/restoreAll", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List<Item> restoreAll() {
	 return todoListService.restoreAll();
	 
	 }
	
	
	 
	 /**
	  * This method id used to soft delete the items by changing the field delIndicator to "Y".
	 * @param id
	 */
	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteItem(@PathVariable("id") int id) {
		 todoListService.deleteItem(id);
	 
	 }

}
