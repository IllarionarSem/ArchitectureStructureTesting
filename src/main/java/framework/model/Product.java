package framework.model;

import lombok.Data;

@Data
public class Product extends Model {

    @ProductInfo(className = "prod_name")
    String name;
    @ProductInfo(className = "prod_desc")
    String description;
    @ProductInfo(className = "price")
    String price;
}
