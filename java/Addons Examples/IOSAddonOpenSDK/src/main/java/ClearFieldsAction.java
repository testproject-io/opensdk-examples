import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.testproject.sdk.internal.addons.interfaces.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClearFieldsAction implements Action<IOSDriver> {
    @Override
    public boolean run(IOSDriver iosDriver) {
        for (Object element : iosDriver.findElements(By.className("XCUIElementTypeTextField"))) {
            ((IOSElement)element).clear();
        }

        for (Object element : iosDriver.findElements(By.className("XCUIElementTypeSecureTextField"))) {
            ((IOSElement)element).clear();
        }

        for (Object element : iosDriver.findElements(By.className("XCUIElementTypeSearchField"))) {
            ((IOSElement)element).clear();
        }

        return true;
    }
}
