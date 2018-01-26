package com.mart;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class ProductCatalog {
	
	public List<String> getProductCatalog(){
		List<String> productCatalog = new ArrayList<String>();
		productCatalog.add("Books");
		productCatalog.add("Movies");
		productCatalog.add("Music");
		return productCatalog;
	}

}
