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

public class GlycerolipidsActivityTest {
    @Rule
    public ActivityTestRule<GlycerolipidsActivity> mActivityTestRule = new ActivityTestRule<>(GlycerolipidsActivity.class);

    private GlycerolipidsActivity mActivity = null;

    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Glycerolipids_Result_Activity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionIonTest()
    {
        onView(withId(R.id.spnIon)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.spnIon)).check(matches(withSpinnerText(containsString("[M+H-H2O]+"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Glycerolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(Glycerolipids_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionSn1Test()
    {
        onView(withId(R.id.spnSn1)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.spnSn1)).check(matches(withSpinnerText(containsString("10:0"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Glycerolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(Glycerolipids_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionSn2Test()
    {
        onView(withId(R.id.spnSn2)).perform(click());
        onData(anything()).atPosition(9).perform(click());
        onView(withId(R.id.spnSn2)).check(matches(withSpinnerText(containsString("14:1(9Z)"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Glycerolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(Glycerolipids_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionSn3Test()
    {
        onView(withId(R.id.spnSn3)).perform(click());
        onData(anything()).atPosition(6).perform(click());
        onView(withId(R.id.spnSn3)).check(matches(withSpinnerText(containsString("12:0"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Glycerolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(Glycerolipids_Result);
    }

    //This tests out the submit button and it should take you to the Result screen to pass
    @Test
    public void testLaunchOfResultActivity()
    {
        assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity Glycerolipids_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Glycerolipids_Result);
        Glycerolipids_Result.finish();
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