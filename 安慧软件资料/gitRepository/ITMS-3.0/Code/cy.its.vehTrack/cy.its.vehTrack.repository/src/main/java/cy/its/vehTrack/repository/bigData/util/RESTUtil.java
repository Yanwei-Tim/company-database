package cy.its.vehTrack.repository.bigData.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTUtil {

	public static String load(String url, String query) throws Exception {
		query = stringToUnicode(query);
		URL restURL = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setAllowUserInteraction(false);
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setReadTimeout(300000);
		PrintStream ps = new PrintStream(conn.getOutputStream());
		ps.print(query);
		ps.close();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String line, resultStr = "";
		while (null != (line = bReader.readLine())) {
			resultStr += line;
		}
		bReader.close();
		return resultStr;
	}
	
	/**
	 * 
	 * �������ַ���ת��Ϊʮ������Unicode�����ַ���
	 */
	public static String stringToUnicode(String s) {
		StringBuffer strb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			if (ch > 255) {
				strb.append("\\u" + Integer.toHexString(ch));
			}
			else {
				//str += "\\" + Integer.toHexString(ch);
				strb.append((char)ch);
			}
		}
		return strb.toString();
	}

}