package me.nego.shortenurl.infrastructure.repository;

/**
 * @author Nick
 * @since 2024-04-06
 */

public interface Cache<K, V> {

    void set(K key, V value);

    V get(K key);

    void delete(K key);

    boolean isHit(K key);

}
