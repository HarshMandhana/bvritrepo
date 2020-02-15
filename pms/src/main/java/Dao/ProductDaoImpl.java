package Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exception.ProductException;
import bean.Product;

public class ProductDaoImpl implements ProductDao{
	
	private Map<Integer,Product> map;
	
	public ProductDaoImpl()
	{
		map=new HashMap<Integer,Product>();
	}

	public int addProduct(Product product) throws ProductException {
		
		boolean flag=map.containsKey(product.getProductid());
		if(flag==true)
		{
			throw new ProductException("ProductId already exist");
		}
		else
		{
			map.put(product.getProductid(), product);
		}
		return product.getProductid();
	}

	public Product findProductId(int productid) throws ProductException {
		
		boolean flag=map.containsKey(productid);
		Product product=null;
		if(flag==true)
		{
			product=map.get(productid);
		}
		else
		{
			throw new ProductException("ProdutcId not found");
		}
		return product;
	}

	public Product deleteProductId(int productid) throws ProductException {
		Product product=null;
		boolean flag=map.containsKey(productid);
		if(flag==true)
		{
			product=map.remove(productid);
		}
		else
		{
			throw new ProductException("ProductId not found");
		}
		
		return product;
	}

	public List<Product> findAllProduct() throws ProductException {

		Collection<Product> col=map.values();
		List<Product> list=new ArrayList<Product>(col);
		return list;
	}
	
}
