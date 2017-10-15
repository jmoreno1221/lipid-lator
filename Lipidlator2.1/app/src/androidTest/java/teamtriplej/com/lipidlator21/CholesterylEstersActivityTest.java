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
import static org.junit.Assert.*;

/**
 * Created by joseph on 10/13/2017.
 */
public class CholesterylEstersActivityTest {

    @Rule
    public ActivityTestRule<CholesterylEstersActivity> mActivityTestRule = new ActivityTestRule<CholesterylEstersActivity>(CholesterylEstersActivity.class);

    private CholesterylEstersActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CholesterylEsters_Result_Activity.class.getName(),null,false);
    Instrumentation.ActivityMonitor home = getInstrumentation().addMonitor(HomeActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    //This tests out the submit button and it should take you to the Result screen to pass
    @Test
    public void testLaunchOfResultActivity()
    {
        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity CholesterylEsters_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(CholesterylEsters_Result);
        CholesterylEsters_Result.finish();
    }

    //This tests out the back button and it should take you to the Home screen to pass
    @Test
    public void testLaunchOfHomeActivity()
    {
        assertNotNull(mActivity.findViewById(R.id.btnBack));
        onView(withId(R.id.btnBack)).perform(click());
        Activity homeScreen = getInstrumentation().waitForMonitorWithTimeout(home,5000);
        assertNotNull(homeScreen);
        homeScreen.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}