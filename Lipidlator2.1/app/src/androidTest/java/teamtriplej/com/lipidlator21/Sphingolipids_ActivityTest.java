package teamtriplej.com.lipidlator21;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import org.junit.After;
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

/* @Author: Joseph Tsegaye
 * @Date: 10/12/2017
 */
public class Sphingolipids_ActivityTest {

    @Rule
    public ActivityTestRule<Sphingolipids_Activity> mActivityTestRule = new ActivityTestRule<>(Sphingolipids_Activity.class);

    private Sphingolipids_Activity mActivity = null;

    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Sphingolipids_Result_Activity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionIonTest()
    {
        onView(withId(R.id.spnIon)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.spnIon)).check(matches(withSpinnerText(containsString("[M+3H]3+"))));

        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Sphingolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Sphingolipids_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionHeadGroupTest()
    {
        onView(withId(R.id.spnHeadGroup)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.spnHeadGroup)).check(matches(withSpinnerText(containsString("1-phosphate"))));

        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Sphingolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Sphingolipids_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionSphingolipidsBaseTest()
    {
        onView(withId(R.id.spnSphingoidBase)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.spnSphingoidBase)).check(matches(withSpinnerText(containsString("d18:0"))));

        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Sphingolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Sphingolipids_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionNacylTest()
    {
        onView(withId(R.id.spnNAcyl)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.spnNAcyl)).check(matches(withSpinnerText(containsString("14:0"))));

        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Sphingolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Sphingolipids_Result);
    }

    //This tests out the submit button and it should take you to the Result screen to pass
    @Test
    public void testLaunchOfResultActivity()
    {
        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Sphingolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Sphingolipids_Result);
        Sphingolipids_Result.finish();
    }

    //This tests out the back button and it should take you to the Home screen to pass
    @Test
    public void testLaunchOfHomeActivity()
    {
        assertNotNull(mActivity.findViewById(R.id.btnBack));
        onView(withId(R.id.btnBack)).perform(click());
        mActivity.findViewById(imbtnCholesterylEsters);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}