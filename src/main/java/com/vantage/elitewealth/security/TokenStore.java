package com.vantage.elitewealth.security;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thread-safe in-memory store for the current Bearer access token.
 */
@Component
public class TokenStore {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private String accessToken;
    private String refreshToken;
    private Instant expiresAt;

    public void store(String accessToken, String refreshToken, long validityInSeconds) {
        lock.writeLock().lock();
        try {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.expiresAt = Instant.now().plusSeconds(validityInSeconds);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String getAccessToken() {
        lock.readLock().lock();
        try {
            return accessToken;
        } finally {
            lock.readLock().unlock();
        }
    }

    public String getRefreshToken() {
        lock.readLock().lock();
        try {
            return refreshToken;
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean isExpiredOrAboutToExpire(long bufferSeconds) {
        lock.readLock().lock();
        try {
            if (accessToken == null || expiresAt == null) {
                return true;
            }
            return Instant.now().plusSeconds(bufferSeconds).isAfter(expiresAt);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void clear() {
        lock.writeLock().lock();
        try {
            this.accessToken = null;
            this.refreshToken = null;
            this.expiresAt = null;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
