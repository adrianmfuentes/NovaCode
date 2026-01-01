package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static double lexemeToReal(String str){
		try {
			return Double.parseDouble(str);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		return -1;
	}

	public static char lexemeToChar(String str){
		int length = str.length();

		if(length == 3) return str.charAt(1);
		if(str.charAt(2) == 'n') return '\n';
		if(str.charAt(2) == 't') return '\t';

		int decimalValue = Integer.parseInt(str.substring(2, str.length() - 1));
		return (char) decimalValue;
	}
}
