package com.limiter.strategies;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LeakyBucketRateLimitingStrategy implements RateLimitingStrategy {

    static ConcurrentMap<String, Long> hm = new ConcurrentHashMap<String, Long>();
    private long nextAllowedTime;
    private final long REQUEST_INTERVAL_MILLIS;

    public LeakyBucketRateLimitingStrategy(int maxRequestPerSec) {
        REQUEST_INTERVAL_MILLIS = 1000 / maxRequestPerSec;
        nextAllowedTime = System.currentTimeMillis();
    }

    @Override
    public boolean allow(String key) {
        long curTime = System.currentTimeMillis();
        hm.putIfAbsent(key, nextAllowedTime);
        synchronized (this) {
            if (curTime >= hm.get(key)) {
                nextAllowedTime = curTime + REQUEST_INTERVAL_MILLIS;
                hm.put(key, nextAllowedTime);
                return true;
            }
            return false;
        }
    }
}
