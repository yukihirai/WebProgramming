package controller;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class UtilLogic {
	/**
	 * パスワードをＭＤ５に変換する。
	 * @param pass
	 * @return
	 */
	public static String convertMd5(String pass) {
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(pass.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		pass = DatatypeConverter.printHexBinary(bytes);
		return pass;
	}
	public static String convertDate(String date) throws ParseException {
		String dateStr = date;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date cDate = f.parse(dateStr);
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
		String conDate = f2.format(cDate);
		return conDate;
	}

}
