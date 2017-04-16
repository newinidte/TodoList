package org.todolist.items.bean;

public class Item{
	
	int id;
	String itemName;
	String itemStatus;
	String itemCategory;
	String tagValue;
	String delIndictor;
	String reminder;
 

 
 public Item() {
 super();
 }
 public Item(int id,String itemName, String itemStatus,String itemCategory,String tagValue,String delIndictor,String reminder) {
 super();
 this.id = id;
 this.itemName = itemName;
 this.itemStatus = itemStatus;
 this.itemCategory = itemCategory;
 this.tagValue=tagValue;
 this.delIndictor=delIndictor;
 this.reminder=reminder;
 }
 
 
 
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the itemName
 */
public String getItemName() {
	return itemName;
}
/**
 * @param itemName the itemName to set
 */
public void setItemName(String itemName) {
	this.itemName = itemName;
}
/**
 * @return the itemStatus
 */
public String getItemStatus() {
	return itemStatus;
}
/**
 * @param itemStatus the itemStatus to set
 */
public void setItemStatus(String itemStatus) {
	this.itemStatus = itemStatus;
}


/**
 * @return the tagValue
 */
public String getTagValue() {
	return tagValue;
}
/**
 * @param tagValue the tagValue to set
 */
public void setTagValue(String tagValue) {
	this.tagValue = tagValue;
}
/**
 * @return the delIndictor
 */
public String getDelIndictor() {
	return delIndictor;
}
/**
 * @param delIndictor the delIndictor to set
 */
public void setDelIndictor(String delIndictor) {
	this.delIndictor = delIndictor;
}



/**
 * @return the reminder
 */
public String getReminder() {
	return reminder;
}
/**
 * @param reminder the reminder to set
 */
public void setReminder(String reminder) {
	this.reminder = reminder;
}
/**
 * @return the itemCategory
 */
public String getItemCategory() {
	return itemCategory;
}
/**
 * @param itemCategory the itemCategory to set
 */
public void setItemCategory(String itemCategory) {
	this.itemCategory = itemCategory;
}
 
 
 
}