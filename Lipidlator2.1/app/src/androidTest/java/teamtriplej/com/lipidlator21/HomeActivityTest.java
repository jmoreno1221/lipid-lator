package teamtriplej.com.lipidlator21;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/* @Author: Joseph Tsegaye
 * @Date: 10/12/2017
 */

public class HomeActivityTest {

    //This is the creation of the rule for the Home Screen
    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    private HomeActivity mhomeActivity = null;

    //Declaring and initialize the variable
    @Before
    public void setUp() throws Exception {
        mhomeActivity = homeActivityActivityTestRule.getActivity();
    }

    //This is testing the launch to confirm that it pass it is looking for the image button.
    @Test
    public void findFA()
    {
        View viewFA = mhomeActivity.findViewById(R.id.imbtnFattyAcids);
        assertNotNull(viewFA);
    }

    @Test
    public void findWE()
    {
        View viewWE = mhomeActivity.findViewById(R.id.imbtnWaxEsters);
        assertNotNull(viewWE);
    }

    @Test
    public void findAC()
    {
        View viewAC = mhomeActivity.findViewById(R.id.imbtnAcylCarnitines);
        assertNotNull(viewAC);
    }

    @Test
    public void findCoA()
    {
        View viewCoA = mhomeActivity.findViewById(R.id.imbtnCoAEsters);
        assertNotNull(viewCoA);
    }

    @Test
    public void findGly()
    {
        View viewGly = mhomeActivity.findViewById(R.id.imbtnGlycerolipids);
        assertNotNull(viewGly);
    }

    @Test
    public void findGph()
    {
        View viewGph = mhomeActivity.findViewById(R.id.imbtnGlycerophospholipids);
        assertNotNull(viewGph);
    }

    @Test
    public void findCA()
    {
        View viewCA = mhomeActivity.findViewById(R.id.imbtnCardiolipins);
        assertNotNull(viewCA);
    }

    @Test
    public void findSG()
    {
        View viewSG = mhomeActivity.findViewById(R.id.imbtnSphingolipids);
        assertNotNull(viewSG);
    }

    @Test
    public void findCHE()
    {
        View viewCHE = mhomeActivity.findViewById(R.id.imbtnCholesterylEsters);
        assertNotNull(viewCHE);
    }

    @After
    public void tearDown() throws Exception {
        mhomeActivity = null;
    }

}