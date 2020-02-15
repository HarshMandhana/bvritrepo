package service;

import java.util.List;

import Exception.ProductException;
import bean.Product;

public interface ProductService {
	
	public boolean validateName(String productName);
	public int addProduct(Product p) throws ProductException;
	public Product findProductId(int productid) throws ProductException;
	public Product deleteProductId(int productid) throws ProductException;
	public List<Product> findAllProduct() throws ProductException;

}
