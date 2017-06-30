package automail.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class EditorTest {
	@Test
	public void checkEmailAdress(){
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("346860245@qq.com");
		System.out.println(matcher.matches()); 
	}
}
