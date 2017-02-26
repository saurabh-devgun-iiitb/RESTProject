package org.vaibhav.ebayAPI.model;

import java.io.File;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private String itemId;
	private int subCatId;
	private String itemName;
	private String itemImage;
	private File itemImageFile;
	private String itemPrice;
	private String itemDescription;
	private String itemDiscount;
	private String itemNoOfItemsSold;
	private int itemAdvt;
	private String itemWeight;
	private String itemWarranty;
	private String itemBrand;
	private String itemQuantity;
	private int userFK;
	private String sellerId;
	private int categoryFK;
	private String category;
	private int subCategoryFK;
	private String subCategory;
	private String itemColor;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public File getItemImageFile() {
		return itemImageFile;
	}
	public void setItemImageFile(File itemImageFile) {
		this.itemImageFile = itemImageFile;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemDiscount() {
		return itemDiscount;
	}
	public void setItemDiscount(String itemDiscount) {
		this.itemDiscount = itemDiscount;
	}
	public String getItemNoOfItemsSold() {
		return itemNoOfItemsSold;
	}
	public void setItemNoOfItemsSold(String itemNoOfItemsSold) {
		this.itemNoOfItemsSold = itemNoOfItemsSold;
	}
	public int getItemAdvt() {
		return itemAdvt;
	}
	public void setItemAdvt(int itemAdvt) {
		this.itemAdvt = itemAdvt;
	}
	public String getItemWeight() {
		return itemWeight;
	}
	public void setItemWeight(String itemWeight) {
		this.itemWeight = itemWeight;
	}
	public String getItemWarranty() {
		return itemWarranty;
	}
	public void setItemWarranty(String itemWarranty) {
		this.itemWarranty = itemWarranty;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public String getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getUserFK() {
		return userFK;
	}
	public void setUserFK(int userFK) {
		this.userFK = userFK;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public int getCategoryFK() {
		return categoryFK;
	}
	public void setCategoryFK(int categoryFK) {
		this.categoryFK = categoryFK;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSubCategoryFK() {
		return subCategoryFK;
	}
	public void setSubCategoryFK(int subCategoryFK) {
		this.subCategoryFK = subCategoryFK;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getItemColor() {
		return itemColor;
	}
	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
}
