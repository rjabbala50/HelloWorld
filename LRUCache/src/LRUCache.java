
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCache {

    private int cacheCapacity;  //total capacity
    private int cacheSize;   //Occupied capacity
    private Map<Integer, Integer> cache;
    private Deque<Integer> lruKey;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.cacheSize = 0;
        cache = new HashMap<>(capacity);
        lruKey = new LinkedList<>();
    }

    public int get(int key) {
        if (lruKey.contains(key)) {
            updateLRUKey(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheSize >= cacheCapacity) {
            cache.remove(getLRUkey());
        }
        cache.put(key, value);
        cacheSize += 1;
        updateLRUKey(key);
    }

    private Integer getLRUkey() {
        return lruKey.getLast();
    }

    private void updateLRUKey(int key) {
        lruKey.remove(key);
        lruKey.offerFirst(key);
    }

    public static void main(String args[]) {
        UnitTest ut = new UnitTest();
        ut.testCapacity();

       /*
        try {
            LRUCache lru = new LRUCache(1);
            lru.put(1, 1);
            lru.put(2, 2);
            System.out.println(" Value Returned:  " + lru.get(2));
            lru.get(2);
            lru.put(3, 3);
            System.out.println(" Value Returned 2nd : " + lru.get(2));
        }
        catch(Exception e) {
            System.out.println("System retured exception");
        }
    } */
    }

    static class UnitTest {
        @RepeatedTest(2)
        @DisplayName("Capacity Test")
        public void testCapacity() {
            LRUCache lru = new LRUCache(1);
            lru.put(3, 3);
            lru.put(2, 2);
            System.out.println(" Value Returned:  ");
            assertEquals (3,lru.get(2)," Print ");
        }
    }
}