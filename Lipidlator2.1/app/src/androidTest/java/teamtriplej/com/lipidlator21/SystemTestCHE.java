package teamtriplej.com.lipidlator21;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;


/* @Author: Joseph Tsegaye
 * @Date: 10/12/2017
 */
public class SystemTestCHE {

    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    private HomeActivity mhomeActivity = null;

    //public ActivityTestRule<CholesterylEstersActivity> mActivityTestRule = new ActivityTestRule<>(CholesterylEstersActivity.class);

    // private CholesterylEstersActivity mActivity = null;


    //Declaring and initialize the variable
    @Before
    public void setUp() throws Exception {
        mhomeActivity = homeActivityActivityTestRule.getActivity();
    }

    @Test
    public void fullTest() {
        //View viewCHE = mhomeActivity.findViewById(R.id.imbtnCholesterylEsters);
        // assertNotNull(mhomeActivity.findViewById(R.id.imbtnCholesterylEsters));
        //onView(withId(R.id.imbtnCholesterylEsters));
        assertNotNull(mhomeActivity.findViewById(R.id.imbtnCholesterylEsters));
        onView(withId(R.id.imbtnCholesterylEsters)).perform(click());
        mhomeActivity.findViewById(R.id.spnIon);
        mhomeActivity.findViewById(R.id.btnSubmit);
        onView(withId(R.id.btnSubmit)).perform(click());
        mhomeActivity.findViewById(R.id.btnBack);
        onView(withId(R.id.btnBack)).perform(click());
        mhomeActivity.findViewById(R.id.btnSubmit);
        onView(withId(R.id.btnSubmit)).perform(click());
        mhomeActivity.findViewById(R.id.btnHome);
        onView(withId(R.id.btnHome)).perform(click());
        assertNotNull(mhomeActivity);
        // View viewCHE = mhomeActivity.findViewById(R.id.imbtnCholesterylEsters);
        //assertNotNull(viewCHE);
//        onView(withId(R.id.spnIon)).perform(click());
//        onData(anything()).atPosition(3).perform(click());
//        onView(withId(R.id.spnIon)).check(matches(withSpinnerText(containsString("[M+3H]3+"))));
//        mhomeActivity.findViewById(R.id.spnAcylChain);
//        onView(withId(R.id.spnAcylChain)).perform(click());
//        onData(anything()).atPosition(3).perform(click());
//        onView(withId(R.id.spnAcylChain)).check(matches(withSpinnerText(containsString("8:0"))));
//        mhomeActivity.findViewById(R.id.btnSubmit);
    }

    @After
    public void tearDown() throws Exception {
        mhomeActivity = null;
    }
}