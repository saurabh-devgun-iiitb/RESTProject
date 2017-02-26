package org.vaibhav.ebayAPI.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.vaibhav.ebayAPI.model.Item;
import org.vaibhav.ebayAPI.model.Seller;
import org.vaibhav.ebayAPI.util.DbConnection;

public class SellerService {

	private DbConnection db = new DbConnection();
	private Connection con = db.getConnection();

	public List<Seller> getSellers(int seller_address_pin){ 
		List <Seller> sellers = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from sellers where seller_address_pin = "+ seller_address_pin +";";

			ResultSet rs1 = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs1.next()) {

				Seller seller = new Seller();
				seller.setSeller_name(rs1.getString("seller_name"));
				seller.setSeller_address(rs1.getString("seller_address"));
				seller.setSeller_contactno(rs1.getString("seller_contact_no"));
				seller.setSeller_email(rs1.getString("seller_email"));
				seller.setSeller_address(rs1.getString("seller_address"));
				seller.setPin(rs1.getInt("seller_address_pin"));
				try{
					seller.setAvg_rating((double)(1*rs1.getInt("seller_one_star")+2*rs1.getInt("seller_two_star")+3*rs1.getInt("seller_three_star")+4*rs1.getInt("seller_four_star")+5*rs1.getInt("seller_five_star"))/(rs1.getInt("seller_one_star")+rs1.getInt("seller_two_star")+rs1.getInt("seller_three_star")+rs1.getInt("seller_four_star")+rs1.getInt("seller_five_star")));
					System.out.println("Value says:"+(rs1.getInt("seller_one_star")+rs1.getInt("seller_two_star")+rs1.getInt("seller_three_star")+rs1.getInt("seller_four_star")+rs1.getInt("seller_five_star")));
					System.out.println("did that go to catch block?");
				}
				catch(Exception ex){
					System.out.println("Did it ever come here!!");
					seller.setAvg_rating(0.0);
				}
				sellers.add(seller);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sellers;
	}
	
	
	private String fetchSellerId(int userFK) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "select * from sellers where seller_id = " + userFK + " ;";
			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next())
				return rs1.getString("seller_name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String fetchCategory(int categoryFK) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "select * from categories where category_id = " + categoryFK + " ;";
			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next())
				return rs1.getString("category_name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String fetchSubCategory(int subCategoryFK) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "select * from subCategories where subcategory_id = " + subCategoryFK + " ;";
			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next())
				return rs1.getString("subcategory_name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Item> getItemsWithoutWarranty() {
		List<Item> items = new ArrayList<Item>();

		//Blob tempImage;
		byte b[] = null;

		try {
			Statement stmt = con.createStatement();
			String sql = "select * from itemDetail where itemWarranty = -1;";

			ResultSet rs1 = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs1.next()) {

				Item itd = new Item();
				itd.setItemId(rs1.getString("itemId"));
				itd.setItemName(rs1.getString("itemName"));
				/*tempImage = rs1.getBlob("itemImage");
				b = new byte[(int) tempImage.length()];
				b = tempImage.getBytes(1, (int) tempImage.length());
				// itd.setItemImage(new Base64().encodeToString(b));
*/				itd.setItemPrice(rs1.getString("itemPrice"));
				itd.setItemDescription(rs1.getString("itemDescription"));
				String discount = rs1.getString("itemDiscount");
				if (discount == null) {
					itd.setItemDiscount("0");
				} else
					itd.setItemDiscount(discount);
				itd.setItemNoOfItemsSold("" + rs1.getInt("itemNoOfItemsSold"));
				itd.setItemAdvt(rs1.getInt("itemAdvt"));
				itd.setItemWeight("" + rs1.getDouble("itemWeight"));
				itd.setItemWarranty("" + rs1.getInt("itemWarranty"));
				itd.setItemBrand(rs1.getString("itemBrand"));
				itd.setItemQuantity(rs1.getString("itemQuantity"));
				itd.setSellerId(fetchSellerId(rs1.getInt("userFK")));
				itd.setCategory(fetchCategory(rs1.getInt("categoryFK")));
				itd.setSubCategory(fetchSubCategory(rs1.getInt("subCategoryFK")));
				items.add(itd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}

	public List<Item> getItemsHavingPrice(int subCategory, int minPrice, int maxPrice) {
		List<Item> items = new ArrayList<Item>();

		//Blob tempImage;
		byte b[] = null;

		try {
			Statement stmt = con.createStatement();
			String sql = "select * from items101 where item_subcat_id = "+ subCategory +" and item_price101 < " + maxPrice + " and item_price101 > " + minPrice + ";";

			ResultSet rs1 = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs1.next()) {

				Item itd = new Item();
				itd.setItemId(rs1.getString("item_id"));
				itd.setItemName(rs1.getString("item_name"));
				/*tempImage = rs1.getBlob("itemImage");
				b = new byte[(int) tempImage.length()];
				b = tempImage.getBytes(1, (int) tempImage.length());
				itd.setItemImage(new Base64().encodeToString(b));*/
				itd.setItemPrice(rs1.getString("item_price101"));
				itd.setItemDescription(rs1.getString("item_desc"));
				String discount = rs1.getString("item_discount");
				if (discount == null) {
					itd.setItemDiscount("0");
				} else
					itd.setItemDiscount(discount);
				itd.setItemNoOfItemsSold("" + rs1.getInt("item_sold"));
				itd.setItemAdvt(rs1.getInt("item_adv"));
				itd.setItemWeight("" + rs1.getDouble("item_weight"));
				itd.setItemWarranty("" + rs1.getString("item_warranty_period"));
				itd.setItemBrand(rs1.getString("item_brand"));
				itd.setItemQuantity(rs1.getString("item_quantity_available"));
				itd.setItemColor(rs1.getString("item_color"));
				itd.setSellerId(rs1.getString("item_seller_id"));
				itd.setCategory(fetchCategory(rs1.getInt("item_cat_id")));
				itd.setSubCategory(fetchSubCategory(rs1.getInt("item_subcat_id")));
				items.add(itd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

}
