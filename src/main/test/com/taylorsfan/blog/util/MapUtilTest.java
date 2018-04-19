package com.taylorsfan.blog.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author tianle
 */
public class MapUtilTest {

    @Test
    public void int2map() {
        Map<String, Integer> map = MapUtil.int2map(1, 2);
        System.out.println(map.get("pageNum"));
    }
}