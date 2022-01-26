package com.sportsshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportsshop.model.Product;

/**
 * It implements the services provided by the Shop application.
 */
public class ShopServiceImplementation implements ShopServices {
    private static final Map<String, List<Product>> SPORTS_KITS = new HashMap<>();

    /**
     * It adds the product.
     */
    public Map<String, List<Product>> addProduct(Product product) {
        final List<Product> sportsProducts = new ArrayList<>();

        if (!SPORTS_KITS.containsKey(product.getBrand())) {
            sportsProducts.add(product);
            SPORTS_KITS.put(product.getBrand(), sportsProducts);
        } else {
            SPORTS_KITS.get(product.getBrand()).add(product);
        }
        return SPORTS_KITS;
    }

    /**
     * It selects the product.
     */
    public Product selectProduct(Product product) {

        if (SPORTS_KITS.containsKey(product.getBrand())) {

            for (Product productDetails : SPORTS_KITS.get(product.getBrand())) {

                if (productDetails.getBrand().equals(product.getBrand()) && productDetails.getName().equals(product.getName()) 
                    && productDetails.getSize() == product.getSize()) {
                    return productDetails;
                }
            }
        }
        return null;
    }

    /**
     * To update the product price.
     */
    public Map<String, List<Product>> updateProductPrice(Product product) {
        final Product productDetails = selectProduct(product);

        if (productDetails != null) {
            productDetails.setPrice(product.getPrice());
            return SPORTS_KITS;
        }
        return null;
    }

    /**
     * To remove the product.
     */
    public Map<String, List<Product>> removeProduct(Product product) {
        final Product productDetails = selectProduct(product);
        
        if (productDetails != null) {
            SPORTS_KITS.get(product.getBrand()).remove(productDetails);
            return SPORTS_KITS;
        }
        return null;
    }
}
