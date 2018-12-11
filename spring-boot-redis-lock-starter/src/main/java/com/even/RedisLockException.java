package com.even;

public class RedisLockException extends RuntimeException {
    public RedisLockException(String message) {
        super(message);
    }
}
