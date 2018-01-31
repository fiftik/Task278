package ru.acmp.task278;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		String text, sSqnc, tSqnc;

		String myJarPath = Main.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		String dirPath = new File(myJarPath).getParent();
		dirPath = dirPath + "\\files";

		FileInputStream fstream = new FileInputStream(dirPath + "\\INPUT.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		sSqnc = br.readLine();
		tSqnc = br.readLine();
		br.close();

		if (sSqnc.length() <= tSqnc.length()) {
			int snum, tnum, g = 0, result = 0;
			char s, t;
			for (snum = 0; snum < sSqnc.length(); snum++) {
				for (tnum = 0; g < tSqnc.length(); g++) {
					tnum = g;
					s = sSqnc.charAt(snum);
					t = tSqnc.charAt(tnum);
					if (s == t) {
						result++;
						break;
					}
				}
				g++;
			}
			if (result == sSqnc.length()) {
				text = "YES";
			} else {
				text = "NO";
			}
		} else {
			text = "NO";
		}

		try (FileWriter writer = new FileWriter(dirPath + "\\OUTPUT.txt", false)) {
			writer.write(text);
			writer.flush();
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}

	}

}
