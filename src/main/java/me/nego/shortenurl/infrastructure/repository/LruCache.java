package me.nego.shortenurl.infrastructure.repository;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.springframework.stereotype.Component;

/**
 * @author Nick
 * @since 2024-04-06
 */

@Component
public class LruCache<K, V>
        extends LinkedHashMap<K, V>
        implements Cache<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private final int capacity;

    public LruCache() {
        this(DEFAULT_CAPACITY);
    }
    public LruCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > capacity;
    }

    @Override
    public void set(K key, V value) {
        put(key, value);
    }

    @Override
    public void delete(K key) {
        remove(key);
    }

    public boolean isHit(K key) {
        return this.containsKey(key);
    }

}
