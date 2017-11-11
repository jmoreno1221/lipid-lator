package teamtriplej.com.lipidlator21;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static teamtriplej.com.lipidlator21.R.id.imbtnCholesterylEsters;


public class CoA_EstersActivityTest {
    @Rule
    public ActivityTestRule<CoA_EstersActivity> mActivityTestRule = new ActivityTestRule<>(CoA_EstersActivity.class);

    private CoA_EstersActivity mActivity = null;

    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CoA_Esters_Result_Activity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionIonTest()
    {
        onView(withId(R.id.spnIon)).perform(click());
        onData(anything()).atPosition(10).perform(click());
        onView(withId(R.id.spnIon)).check(matches(withSpinnerText(containsString("[M+2Na-H]+"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity CoAEster_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(CoAEster_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionAcylTest()
    {
        onView(withId(R.id.spnAcylChain)).perform(click());
        onData(anything()).atPosition(15).perform(click());
        onView(withId(R.id.spnAcylChain)).check(matches(withSpinnerText(containsString("17:2(9Z,12Z)"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity CoAEster_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(CoAEster_Result);
    }

    //This tests out the submit button and it should take you to the Result screen to pass
    @Test
    public void testLaunchOfResultActivity()
    {
        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity CoA_Esters_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(CoA_Esters_Result);
        CoA_Esters_Result.finish();
    }

    //This tests out the back button and it should take you to the Home screen to pass
    @Test
    public void testLaunchOfHomeActivity()
    {
        Assert.assertNotNull(mActivity.findViewById(R.id.btnBack));
        onView(withId(R.id.btnBack)).perform(click());
        mActivity.findViewById(imbtnCholesterylEsters);
    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}