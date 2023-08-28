package com.spring.mark.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessImplStubTest {

    @Test
    void basic_scenario() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
        int result = businessImpl.findTheGreatestFromAllData();

        assertEquals(25, result);
    }
}

/**
 * Stub 사용의 단점
 * Stub 구현체를 업데이트 해야하는 번거로움이 있음
 */
class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
}