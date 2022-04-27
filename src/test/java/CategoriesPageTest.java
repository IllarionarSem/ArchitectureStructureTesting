import org.testng.annotations.Test;
import pageobject.GuitarProductPage;
import pageobject.MainPage;

public class CategoriesPageTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final GuitarProductPage guitarProductPage = new GuitarProductPage();

//    @DataProvider(parallel = true)
//    public Object[][] groups() {
//        return new Object[][]{{MainPage.GroupSelection.BASS}, {MainPage.GroupSelection.GUITAR}, {MainPage.GroupSelection.DJ}, {MainPage.GroupSelection.DRUM}};
//    }
//
//    @Test(dataProvider = "groups")
//    public void guitarGroupTest(MainPage.GroupSelection groupSelection) {
//        mainPage.goToGroup(groupSelection);
//        guitarProductPage.getProductsList().forEach(value -> Logger.info(String.format("%s: %s%n", groupSelection, value)));
//    }

//    @Test(threadPoolSize = 3, invocationCount = 3)
//    public void guitarGroupTestParallel() {
//        mainPage.goToGroup(MainPage.GroupSelection.GUITAR);
//        guitarProductPage.getProductsList().forEach(value -> Logger.info(String.format("%s: %s%n", MainPage.GroupSelection.GUITAR, value)));
//    }

    @Test
    public void guitarGroupTestGuitar() {
        mainPage.goToGroup(MainPage.GroupSelection.GUITAR);
//        guitarProductPage.getProductsList().forEach(value -> Logger.info(String.format("%s: %s%n", MainPage.GroupSelection.GUITAR, value)));
        guitarProductPage.getProductsList().forEach(value -> System.out.printf("%s: %s%n", MainPage.GroupSelection.GUITAR, value));
    }

    @Test
    public void guitarGroupTestBass() {
        mainPage.goToGroup(MainPage.GroupSelection.BASS);
//        guitarProductPage.getProductsList().forEach(value -> Logger.info(String.format("%s: %s%n", MainPage.GroupSelection.BASS, value)));
        guitarProductPage.getProductsList().forEach(value -> System.out.printf("%s: %s%n", MainPage.GroupSelection.BASS, value));
    }

    @Test
    public void guitarGroupTestDJ() {
        mainPage.goToGroup(MainPage.GroupSelection.DJ);
//        guitarProductPage.getProductsList().forEach(value -> Logger.info(String.format("%s: %s%n", MainPage.GroupSelection.DJ, value)));
        guitarProductPage.getProductsList().forEach(value -> System.out.printf("%s: %s%n", MainPage.GroupSelection.DJ, value));
    }
}
