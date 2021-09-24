package com.evaluacionjava.nisum;

import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestClass {

    @Test
    internal fun testName() {
        Assert.assertEquals(2, 1 + 1)
    }
}
