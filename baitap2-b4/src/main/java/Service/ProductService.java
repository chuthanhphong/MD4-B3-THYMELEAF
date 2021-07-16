package Service;

import ModelProduct.Product;

import java.util.*;

public class ProductService implements IProductService {

    private static final Map<Integer,Product> productList;
    static {
        productList= new HashMap<>();
        productList.put(1,new Product(1,"Iphone12","Red","Iphone"));
        productList.put(2,new Product(2,"Iphone11","Blue","Iphone"));
        productList.put(3,new Product(3,"SamSung S1","Yellow","SamSung"));
        productList.put(4,new Product(4,"SamSung S2","Green","SamSung"));
        productList.put(5,new Product(5,"OPPO NEO5","Violet","OPPO"));
        productList.put(6,new Product(6,"OPPO F1S","Orange","OPPO"));
    }

    @Override
    public List<Product> findALL() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
         return  productList.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products =findALL();
        List<Product> productByName = new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                productByName.add(products.get(i));
            }
        }
        return productByName;
    }
}
