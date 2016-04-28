package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LogCollectorUtil {

	
	public static String executeCommand(String command) {
		StringBuffer output = new StringBuffer();
		Process process;
		try {
			System.out.println(command);
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output.toString();
	}
	
}
