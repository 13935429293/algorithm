package org.xiaoyang.jvm;

import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {

    @Test
    public void testHashMapPut() {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put(null, null);
        map.put(null, null);
        map.put("a", 1);
        map.put("b", 2);
        map.put("b", 3);
        map.put("bb", 2);
        map.put("bbb", 2);
    }

}
