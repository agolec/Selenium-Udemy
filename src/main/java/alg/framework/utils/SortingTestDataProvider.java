package alg.framework.utils;

import org.testng.annotations.DataProvider;

public class SortingTestDataProvider {
    @DataProvider(name = "sortOptions")
    public Object[][] getSortOptions() {
        return SortingTestData.sortOptions();
    }
}