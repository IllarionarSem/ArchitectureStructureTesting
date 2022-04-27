package pageobject;

import framework.element.ModelList;
import framework.model.Product;

import java.util.List;

public class GuitarProductPage extends BasePage {

    public List<Product> getProductsList() {

        return new ModelList<>(Product.class).getProductList();
    }
}
