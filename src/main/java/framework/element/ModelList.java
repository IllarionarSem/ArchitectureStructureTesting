package framework.element;

import framework.browser.Browser;
import framework.model.Model;
import framework.model.ProductInfo;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModelList<T extends Model> {

    @Getter
    private final String xpathProduct = "//div[contains(@class,'product_list')]/a";
    @Getter
    private final String xpathProductInfoFormat = ".//span[@class='%s']";

    private final Class<T> clazz;

    public ModelList(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> getProductList() {

        List<WebElement> elements = Browser.getInstance().getDriver().findElements(By.xpath(getXpathProduct()));
        return elements.stream().collect(ArrayList::new, (list, element) -> list.add(getProductInfo(element)), ArrayList::addAll);
    }

    @SneakyThrows
    private T getProductInfo(WebElement element) {

        T product = clazz.getDeclaredConstructor().newInstance();
        Class<?> productClass = product.getClass();

        Field[] fields = productClass.getDeclaredFields();
        for (Field field : fields) {

            String className = field.getAnnotation(ProductInfo.class).className();
            String productInfo = element.findElement(By.xpath(String.format(getXpathProductInfoFormat(), className))).getText().trim();
            field.setAccessible(true);
            try {
                field.set(product, productInfo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return product;
    }
}
