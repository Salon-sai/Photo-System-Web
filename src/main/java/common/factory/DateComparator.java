package common.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Date;

public class DateComparator<E> implements Comparator<E>{

	private String DateMethodName;
	private Class<?> classType;
	
	public DateComparator(String dateMethodName,Class<?> classType){
		this.DateMethodName = dateMethodName;
		this.classType = classType;
	}
	
	public int compare(E o1, E o2) {
		try {
			Method method = this.getterMethod(DateMethodName);
			Date date1 = (Date)method.invoke(01);
			Date date2 = (Date)method.invoke(o2);
			return date1.after(date2) ? 1 : -1;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Method getterMethod(String getterName) throws NoSuchMethodException, SecurityException{
		return this.classType.getMethod(getterName);
	}
	
}
