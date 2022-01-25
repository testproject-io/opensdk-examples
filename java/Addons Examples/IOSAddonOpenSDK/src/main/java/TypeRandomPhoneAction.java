import io.appium.java_client.MobileElement;
import io.testproject.sdk.drivers.ios.IOSDriver;
import io.testproject.sdk.internal.addons.ParameterDirection;
import io.testproject.sdk.internal.addons.annotations.Parameter;
import io.testproject.sdk.internal.addons.interfaces.ElementAction;
import org.openqa.selenium.By;

public class TypeRandomPhoneAction implements ElementAction<IOSDriver<MobileElement>> {
    @Parameter
    public String countryCode = "1";

    @Parameter
    public int maxDigits;

    @Parameter(direction = ParameterDirection.OUTPUT)
    public String phone;

    @Override
    public boolean run(IOSDriver<MobileElement> mobileElementIOSDriver, By by) {
        long number = (long) (Math.random() * Math.pow(10, maxDigits));
        phone = String.format("+%s%s", countryCode, number);
        MobileElement element = mobileElementIOSDriver.findElement(by);
        element.sendKeys(phone);
        return true;    }
}
