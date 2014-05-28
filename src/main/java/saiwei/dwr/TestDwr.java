package saiwei.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

@RemoteProxy(name="testDwr")
public class TestDwr {

	@RemoteMethod
	public String testDwr(){
		return "success";
	}
	
}
