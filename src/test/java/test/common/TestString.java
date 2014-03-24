package test.common;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import common.factory.StringFactory;

public class TestString {
    
	private final Logger logger = Logger.getLogger(this.getClass());
    
    @Test
    public void testPlus() {
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s + String.valueOf(i);
        }
        long te = System.currentTimeMillis();
        logger.info("+ cost {} ms" + (te - ts));
    }
    @Test
    public void testConcat() {
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s.concat(String.valueOf(i));
        }
        long te = System.currentTimeMillis();
        logger.info("concat cost {} ms"+ (te - ts));
    }
    @Test
    public void testJoin() {
        List<String> list = new ArrayList<String>();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        StringUtils.join(list, "");
        long te = System.currentTimeMillis();
        logger.info("StringUtils.join cost {} ms"+ (te - ts));
    }
    
    @Test
    public void testStringBuffer() {
    	long ts = System.currentTimeMillis();
    	StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te = System.currentTimeMillis();
        logger.info("StringBuffer cost {} ms"+ (te - ts));
    }
    
    @Test
    public void testStringBuilder() {
        long ts = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te = System.currentTimeMillis();
        logger.info("StringBuilder cost {} ms"+ (te - ts));
    }
    
    @Test(timeout=3)
    public void testStringFactory(){
    	TestCase.assertEquals("Abcd", StringFactory.FristLetterToBigCase("abcd"));
    	TestCase.assertEquals("setAbc", StringFactory.buildSetterName("abc"));
    }
}
