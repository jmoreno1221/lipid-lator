package teamtriplej.com.lipidlator21;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/* @Author: Jessica Sok
 * @Date: 10/16/2017
 */
public class WaxEstersActivityTest {
    @Rule
    public ActivityTestRule<WaxEstersActivity> mActivityTestRule = new ActivityTestRule<WaxEstersActivity>(WaxEstersActivity.class);

    private WaxEstersActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(WaxEsters_Result_Activity.class.getName(), null, false);
    Instrumentation.ActivityMonitor home = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    // Test submit button to result screen
    @Test
    public void testLaunchOfResultActivity(){
        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity waxEster_Result = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(waxEster_Result);
        waxEster_Result.finish();
    }

    // Test back button to go to home screen
    @Test
    public void testLaunchOfHomeActivity(){
        assertNotNull(mActivity.findViewById(R.id.btnBack));
        onView(withId(R.id.btnBack)).perform(click());
        Activity homeScreen = getInstrumentation().waitForMonitorWithTimeout(home, 5000);
        assertNotNull(homeScreen);
        homeScreen.finish();
    }

    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }
}