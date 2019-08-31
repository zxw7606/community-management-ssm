package group.slsd.utils;

import java.util.Random;

public class CodeUtil {
	private final static int CODE_NUM = 6;
	 
	private static char[] codeSequence = { 
			'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 
			'X', 'Y', 'Z', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9' };
	
	/**
	 * 
	* @Title：getCode 
	* @Description：验证码
	* @param ：@param codeNum
	 */
	public static String getCode(int...code) {
		int codeNum ;
		if(code.length == 0) {
			codeNum = CODE_NUM;
		}else {
			codeNum = code[0];
		}
		Random random = new Random();
		String codeS = "";
		for (int i = 0; i < codeNum; i++) {
			int index = random.nextInt(codeSequence.length);
			codeS += codeSequence[index];
		}
	return codeS;	
	}
	
	
}
