package common.factory;

import java.lang.reflect.Method;
import java.util.Comparator;

public class DateComparator<E> implements Comparator<E>{

	private String DateMethodName;
	
	public DateComparator(String dateMethodName){
		this.DateMethodName = dateMethodName;
	}
	
	public int compare(E o1, E o2) {
		this.getterMethod(DateMethodName);
		return 0;
	}
	
	public Method getterMethod(String getterName){
		return null;
	}
	
}
