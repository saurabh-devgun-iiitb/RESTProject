package org.vaibhav.ebayAPI.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.vaibhav.ebayAPI.model.Item;
import org.vaibhav.ebayAPI.model.Seller;
import org.vaibhav.ebayAPI.service.ItemService;
import org.vaibhav.ebayAPI.service.SellerService;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
	SellerService ss = new SellerService();
	ItemService is = new ItemService();
	
	@GET
	public Response getItemsExcludingPrice(@QueryParam("subCategory")int subCategory,
											@QueryParam("minPrice") int minPrice, 
											@QueryParam("maxPrice") int maxPrice){
		System.out.println("subCategory:"+subCategory+" minPrice:"+minPrice+" maxPrice:"+maxPrice);
		
		GenericEntity<ArrayList<Item>> list = new GenericEntity<ArrayList<Item>>((ArrayList<Item>) is.getItemsHavingPrice(subCategory,minPrice, maxPrice)) {};
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/try")
	public List<Seller> tellSomething(@QueryParam("seller_address_pin")int seller_address_pin){
		System.out.println("Inside Tell Sth");
		return ss.getSellers(seller_address_pin);
	}
	
	@GET
	@Path("/noWarranty")
	public List<Item> getItemsWithoutWarranty(){
		return is.getItemsWithoutWarranty();
	}
}
