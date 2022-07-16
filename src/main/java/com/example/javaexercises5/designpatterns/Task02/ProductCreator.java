package com.example.javaexercises5.designpatterns.Task02;

public class ProductCreator implements Creator {
    @Override
    public Product getProductByType(ProductType type) {
        switch (type) {
            case SIMPLE:
                return new SimpleProduct();
            case ADVANCED:
                return new AdvancedProduct();
            case VIRTUAL:
                return new VirtualProduct();
        }
        return null; /* never happen - no such option in ProductType enum */
    }
}
