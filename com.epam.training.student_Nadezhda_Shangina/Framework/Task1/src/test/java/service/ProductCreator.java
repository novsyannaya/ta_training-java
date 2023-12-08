package service;

import model.Product;

public class ProductCreator {
    public static final String product="testdata.product";

    public static Product withCredentialsFromProperty(){
        return new Product(TestDataReader.getTestData(product));
    }

}
