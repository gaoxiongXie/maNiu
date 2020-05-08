package com.wen.maniu.utils;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局LiveData管理
 */
public class LiveDataBus {

    private static LiveDataBus liveDataBus = new LiveDataBus();
    private Map<String, MutableLiveData<Object>> map;

    private LiveDataBus() {
        map = new HashMap<>();
    }

    public static LiveDataBus getInstance() {
        return liveDataBus;
    }

    /**
     * 注册订阅方法，
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    public synchronized <T> MutableLiveData<T> with(String key, Class<T> type) {
        if (!map.containsKey(key)) {
            map.put(key, new MutableLiveData<Object>());
        }
        return (MutableLiveData<T>) map.get(key);
    }
}
