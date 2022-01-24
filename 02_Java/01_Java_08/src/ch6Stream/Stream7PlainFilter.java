package ch6Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Product
{
	int p_id;
	String p_name;
	double p_price;
	
	public Product(int id, String name, double price)
	{
		this.p_id = id;
		this.p_name = name;
		this.p_price = price;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", "
				+ "p_name=" + p_name + ", "
				+ "p_price=" + p_price + "]";
	}
	
	
}

public class Stream7PlainFilter {
	
	public static void main(String[] args) {
		
		List<Product> lstProducts = new ArrayList<Product>();
		
		lstProducts.add(new Product(1, "Lenovo", 55700));
		lstProducts.add(new Product(2, "Dell", 48000));
		lstProducts.add(new Product(3, "HP", 49700));
		lstProducts.add(new Product(4, "Asus", 38600));
		
		List<Product> lstFinal = new ArrayList<Product>();
		//to filter elements greater than 50k
		for(Product product: lstProducts)
		{
			if(product.p_price > 50000)
			{
				lstFinal.add(product);
			}
		}
		
		//to print values
		lstFinal.forEach(product -> 
			{
				System.out.println("product: "+product.toString());
			});
		
		//using stream and filter
		lstFinal = lstProducts.stream()
				.filter(product -> product.p_price > 50000)
				.collect(Collectors.toList());
		
		lstFinal.forEach(product -> 
		{
			System.out.println("product: "+product.toString());
		});
		
		//to create predicate object for filter method
		//implementing predicate method for filter
		Predicate<Product> objPredicate = new Predicate<Product>()
			{
				public boolean test(Product prod)
				{
					return ( prod.p_price> 50000);
				}
			};
				
		lstFinal = lstProducts.stream()
				.filter(objPredicate)
				.collect(Collectors.toList());
		
		lstFinal.forEach(product -> 
		{
			System.out.println("product: "+product.toString());
		});
	
	}

}
