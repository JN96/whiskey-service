package com.api.automation;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SequentialRunner {

	@Test
    @Order(1)
    public Karate runGetTest() {
        return Karate.run("getRequests/getRequests").relativeTo(getClass());
    }

    @Test
    @Order(2)
    public Karate runPutTest() {
        return Karate.run("putRequests/putRequests").relativeTo(getClass());
    }

    @Test
    @Order(3)
    public Karate runDeleteTest() {
        return Karate.run("deleteRequests/deleteRequests").relativeTo(getClass());
    }

    @Test
    @Order(4)
    public Karate runPostTest() {
        return Karate.run("postRequests/postRequests").relativeTo(getClass());
    }

}
