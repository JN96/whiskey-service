package getRequests;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class TestGetRunner {

    @Test
    public Karate runTest() {
        return Karate.run("getRequests").relativeTo(this.getClass());
    }

}