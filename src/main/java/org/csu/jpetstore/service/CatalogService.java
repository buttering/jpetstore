package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Category;
import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.persistence.CategoryMapper;
import org.csu.jpetstore.persistence.ItemMapper;
import org.csu.jpetstore.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ItemMapper itemMapper;
    public String findProductListString(String name){
        List<Product> nameList=searchProductList(name);
        String res="";
        for (int i=0;i<nameList.size();i++) {
            if(i>0){
                res+=","+nameList.get(i).getName();
            }else{
                res+=nameList.get(i).getName();
            }
        }
        return res;
    }
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryMapper.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productMapper.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemMapper.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemMapper.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemMapper.getInventoryQuantity(itemId) > 0;
    }

    /**************************分割线***********************************/

    public void addCategory(Category category){ categoryMapper.addCategory(category); }

    public void updateCategory(Category category){
        categoryMapper.updateCategory(category);
    }

    public void deleteCategory(String categoryId){ categoryMapper.deleteCategory(categoryId); }

    public void addProduct(Product product){ productMapper.addProduct(product);}

    public void updateProduct(Product product){ productMapper.updateProduct(product);}

    public void deleteProduct(String productId){ productMapper.deleteProduct(productId);}

    public void addItem(Item item){
        itemMapper.addItem(item);
        itemMapper.addItemInventory(item);
    }

    public void updateItem(Item item){
        itemMapper.updateItem(item);
        itemMapper.updateItemInventory(item);
    }

    public void deleteItem(String itemId){
        itemMapper.deleteItem(itemId);
        itemMapper.deleteItemInventory(itemId);
    }

    public List<Item> getAllItem(){
        return itemMapper.getAllItem();
    }

//    public List<Item> searchItemList(String keywords){
//        return itemMapper.searchItemList(keywords);
//    }
}
