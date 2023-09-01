package com.spring.mark.aopexample.data;

import com.spring.mark.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    @TrackTime
    public int[] retrieveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new int[] {111, 222, 333, 444, 555};
    }
}
