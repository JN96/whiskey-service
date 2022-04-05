package com.api.automation.putRequests;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class TestPutRunner {

    @Test
    public Karate runTest() {
        return Karate.run("putRequests").relativeTo(getClass());
    }

}
