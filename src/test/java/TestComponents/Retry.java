package TestComponents;

import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 3;

    @Override
    public boolean retry (ITestResult result) {
        if (count < maxTry) {
            Uninterruptibles.sleepUninterruptibly (2, TimeUnit.SECONDS);

            count++;
            return true;
        }
        return false;
    }
}
