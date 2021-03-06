package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper {
    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(String productId);
}
