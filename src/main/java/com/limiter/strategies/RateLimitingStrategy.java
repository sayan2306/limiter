package com.limiter.strategies;

public interface RateLimitingStrategy {
    public boolean allow();
}
