package alg.framework.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "validLogins")
    public Object[][] validLogins() {
        return new Object [][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"}
        };
    }
    @DataProvider(name = "invalidLogins")
    public static Object[][] invalidLogins(){
        return new Object[][] {
                {"standard_user","wrongpass"},
                {"standard_user",""},
                {"","secret_sauce"},
                {"",""}
        };
    }
}
