package Service;

import ModelProduct.Product;

import java.util.List;

public interface IProductService {
    List<Product> findALL();
    void save(Product product);
    Product findById(int id);
    void edit(int id,Product product);
    void delete(int id);
    List<Product> search(String name);

}
