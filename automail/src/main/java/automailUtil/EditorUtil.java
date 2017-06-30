package automailUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class EditorUtil {
	@Test
	public static boolean checkEmailAdress(String input){
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
