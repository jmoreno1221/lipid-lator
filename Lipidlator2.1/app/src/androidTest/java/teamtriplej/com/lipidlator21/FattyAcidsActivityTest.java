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
import static teamtriplej.com.lipidlator21.R.id.imbtnCholesterylEsters;

/* @Author: Joseph Tsegaye
 * @Date: 10/16/2017
 */
public class FattyAcidsActivityTest {
    @Rule
    public ActivityTestRule<FattyAcidsActivity> mActivityTestRule = new ActivityTestRule<>(FattyAcidsActivity.class);

    private FattyAcidsActivity mActivity = null;

    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(FattyAcids_Result_Activity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionIonTest()
    {
        onView(withId(R.id.spnIon)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.spnIon)).check(matches(withSpinnerText(containsString("[M+2H]2+"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity FattyAcid_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(FattyAcid_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionAcidTest()
    {
        onView(withId(R.id.spnAcid)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.spnAcid)).check(matches(withSpinnerText(containsString("8:0"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity FattyAcid_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(FattyAcid_Result);
    }

    //Integration Test between Selection Screen and Calculation Screen
    @Test
    public void selectionEsterTest()
    {
        onView(withId(R.id.spnEster)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.spnEster)).check(matches(withSpinnerText(containsString("Methyl ester"))));

        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity FattyAcid_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(FattyAcid_Result);
    }

    //This tests out the submit button and it should take you to the Result screen to pass
    @Test
    public void testLaunchOfResultActivity()
    {
        Assert.assertNotNull(mActivity.findViewById(R.id.btnSubmit));
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity FattyAcid_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(FattyAcid_Result);
        FattyAcid_Result.finish();
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
        mActivity = null;
    }
}