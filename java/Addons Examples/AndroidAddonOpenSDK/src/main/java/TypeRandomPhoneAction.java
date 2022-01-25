import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.internal.addons.ParameterDirection;
import io.testproject.sdk.internal.addons.Platform;
import io.testproject.sdk.internal.addons.annotations.AddonAction;
import io.testproject.sdk.internal.addons.annotations.Parameter;
import io.testproject.sdk.internal.addons.interfaces.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



@AddonAction(platforms = Platform.Android, name = "Type random phone action")
public class TypeRandomPhoneAction implements ElementAction<AndroidDriver<WebElement>> {

    @Parameter
    public String countryCode = "1";

    @Parameter
    public int maxDigits;

    @Parameter(direction = ParameterDirection.OUTPUT)
    public String phone;


    @Override
    public boolean run(AndroidDriver androidDriver, By by) {
        long number = (long) (Math.random() * Math.pow(10, maxDigits));
        phone = String.format("+%s%s", countryCode, number);
        WebElement element = androidDriver.findElement(by);
        element.sendKeys(phone);
        return true;
    }
}