package common.factory;

import org.hibernate.dialect.FirebirdDialect;

public class StringFactory {
	
	public static String FristLetterToBigCase(String str) {
		StringBuilder builder = new StringBuilder();
		String frist_letter = str.substring(0,1);
		builder.append(frist_letter.toUpperCase());
		builder.append(str.substring(1));
		return builder.toString();
	}
	
	public static String FristLetterToBigCase(String str,StringBuilder builder) {
		String frist_letter = str.substring(0,1);
		builder.append(frist_letter.toUpperCase());
		builder.append(str.substring(1));
		return builder.toString();
	}
	
	public static String MergerString(String... strings){
		StringBuilder builder = new StringBuilder();
		for(String str : strings){
			builder.append(str);
		}
		return builder.toString();
	}
	
	public static String builderMergeredAfter(StringBuilder builder,String... strings){
		for(int i = 0;i < strings.length;i++){
			builder.insert(i, strings[i]);
		}
		return builder.toString();
	}
	
	public static String builderMergeredBefore(StringBuilder builder,String... strings){
		for(String str : strings){
			builder.append(str);
		}
		return builder.toString();
	}
	
	public static String buildSetterName(String propertyName){
		StringBuilder builder = new StringBuilder();
		FristLetterToBigCase(propertyName, builder);
		return builderMergeredAfter(builder, "set");
	}
	
	public static String buildGetterName(String propertyName){
		StringBuilder builder = new StringBuilder();
		FristLetterToBigCase(propertyName, builder);
		return builderMergeredAfter(builder, "get");
	}
	
}
