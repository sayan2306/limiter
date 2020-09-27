package com.limiter.strategies;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LeakyBucketRateLimitingStrategy implements RateLimitingStrategy {

    static ConcurrentMap<String, Long> hm = new ConcurrentHashMap<String, Long>();
    private long nextAllowedTime;
    private final long REQUEST_INTERVAL_MILLIS;

    public LeakyBucketRateLimitingStrategy(int maxRequestPerSec) {
        //super(maxRequestPerSec);
        REQUEST_INTERVAL_MILLIS = 1000 / maxRequestPerSec;
        nextAllowedTime = System.currentTimeMillis();
    }

    @Override
    public boolean allow(String key) {
        long curTime = System.currentTimeMillis();
        synchronized (this) {
            if (curTime >= nextAllowedTime) {
                nextAllowedTime = curTime + REQUEST_INTERVAL_MILLIS;
                return true;
            }
            return false;
        }
    }
}
