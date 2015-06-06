package com.flipkart.flipomania.services;

import com.flipkart.flipomania.representations.ShortListed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by :- Shiv Pratap Singh Parmar
 * Created on :- 6/6/15.
 */
public class SelecterTest {

    private Selector selector;

    @Before
    public void setUp(){
        selector = new Selector();
    }

    @Test
    public void testExecute() throws Exception {
        Map<String, List<String>> expected = new HashMap<String, List<String>>() {{
            put("1", new ArrayList<String>() {{
                add("shiv");
            }});
            put("2", new ArrayList<String>() {{
            }});
            put("3", new ArrayList<String>() {{
                add("dhruv");
            }});
            put("4", new ArrayList<String>() {{
                add("ankit");
            }});
        }};
        Map<String, List<String>> actual = selector.execute(geShortListed());
        assertEquals(expected, actual);
    }


    public ShortListed geShortListed() {
        Map<String, List<String>> inputData = getInputData();
        int round = 1;
        List<String> activeProjects = getActiveProjects();
        List<Integer> projectCapacity = getProjectCapacity();
        ShortListed shortListed = new ShortListed(inputData,round,activeProjects,projectCapacity);
        return shortListed;
    }

    public Map<String, List<String>> getInputData() {
        return new HashMap<String, List<String>>() {
            {
                put("shiv", new ArrayList<String>() {{
                    add("1");
                    add("4");
                    add("2");
                    add("3");
                }});
                put("ankit", new ArrayList<String>() {{
                    add("4");
                    add("2");
                    add("3");
                    add("1");
                }});
                put("dhruv", new ArrayList<String>() {{
                    add("3");
                    add("2");
                    add("1");
                    add("4");
                }});
            }
        };
    }

    public List<String> getActiveProjects() {
        return new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};
    }

    public List<Integer> getProjectCapacity() {
        return new ArrayList<Integer>() {{
            add(3);
            add(1);
            add(3);
            add(1);
        }};
    }
    @After
    public void tearDown(){
        selector =null;
    }
}