import io.testproject.sdk.drivers.ReportingDriver;
import io.testproject.sdk.internal.addons.ParameterDirection;
import io.testproject.sdk.internal.addons.Platform;
import io.testproject.sdk.internal.addons.annotations.AddonAction;
import io.testproject.sdk.internal.addons.annotations.Parameter;
import io.testproject.sdk.internal.addons.interfaces.GenericAction;


@AddonAction(platforms = Platform.Any, name = "Addition", description = "Add {{a}} to {{b}}")
public class AdditionAction implements GenericAction {

    @Parameter
    public int a;

    @Parameter
    public int b;

    @Parameter(description = "Addition result", direction = ParameterDirection.OUTPUT)
    public int result;


    @Override
    public boolean run(ReportingDriver reportingDriver) {
        result = a + b;
        reportingDriver.report().step(String.format("Addition result is: {}" + result), true);

        return true;
    }
}
