package com.example.spring.security5.customauthenticate;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttemptService {

    private static final Integer MAX_ATTEMPT =3;

    private LoadingCache<String,Integer> attemptCache;

    public LoginAttemptService(){
        this.attemptCache = CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String s) throws Exception {
                        return 0;
                    }
                });
    }

    public void loginSucceeded(String ip){
        attemptCache.invalidate(ip);
    }

    public void loginFailed(String ip){
        Integer attempts = 0;
        try {
            attempts = attemptCache.get(ip).intValue();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        attempts++;
        attemptCache.put(ip,attempts);
    }

    public boolean isBlocked(String ip){
        try {
            return attemptCache.get(ip).intValue() > MAX_ATTEMPT;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }
}
