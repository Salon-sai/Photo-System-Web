package common.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class SortFatory {
	
	public static List<Object> insertByDate(List<Object> list,Object object,String proportyName) throws NoSuchMethodException, SecurityException{
		String methodName = StringFactory.buildGetterName(proportyName);
		Method getMethod = object.getClass().getMethod(methodName);
		if(list != null && !list.isEmpty()){
			int index = 0;
			for(Object element : list){
				try {
					Date date1 = (Date)getMethod.invoke(element);
					Date date2 = (Date)getMethod.invoke(object);
					if(date1.after(date2)){
						list.add(index, object);
						break;
					}else{
						index++;
					}
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
			}
		}else if(list.isEmpty()){
			list.add(object);
		}else{
			return null;
		}
		return list;
	}
	
}
