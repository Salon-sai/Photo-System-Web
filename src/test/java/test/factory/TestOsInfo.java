/**
 * 
 */
package test.factory;

import junit.framework.TestCase;

import org.junit.Test;

import common.factory.OSInfo;

/**
 * @author sai
 *
 */
public class TestOsInfo {
	
	@Test
	public void testOSLinux(){
		TestCase.assertEquals(true, OSInfo.isLinux());
	}
	
}
