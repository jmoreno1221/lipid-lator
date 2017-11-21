package teamtriplej.com.lipidlator21;

/* @Author: Jessica Sok
 * @Date: 11/10/2017
 */

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
import static org.junit.Assert.assertNotNull;

public class SystemTestFattyAcid {
    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class);
    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(FattyAcids_Result_Activity.class.getName(),null,false);

    private HomeActivity mhomeActivity = null;


    //Declaring and initialize the variable
    @Before
    public void setUp() throws Exception {
        mhomeActivity = homeActivityActivityTestRule.getActivity();
    }

    @Test
    public void fullTest() {
        assertNotNull(mhomeActivity.findViewById(R.id.imbtnFattyAcids));
        onView(withId(R.id.imbtnFattyAcids)).perform(click());
        mhomeActivity.findViewById(R.id.spnIon);
        mhomeActivity.findViewById(R.id.spnAcid);
        mhomeActivity.findViewById(R.id.spnEster);
        mhomeActivity.findViewById(R.id.btnSubmit);
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity FattyAcid_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(FattyAcid_Result);
        mhomeActivity.findViewById(R.id.btnBack);
        onView(withId(R.id.btnBack)).perform(click());
        mhomeActivity.findViewById(R.id.btnSubmit);
        onView(withId(R.id.btnSubmit)).perform(click());
        assertNotNull(FattyAcid_Result);
        mhomeActivity.findViewById(R.id.btnBack);
        onView(withId(R.id.btnBack)).perform(click());
        assertNotNull(mhomeActivity);
    }

    @After
    public void tearDown() throws Exception {
        mhomeActivity = null;
    }
}

