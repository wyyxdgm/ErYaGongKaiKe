package com.erya.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author 戴贵茂
 * @version 1.0
 * @create date 2014-3-15 下午8:37:09
 *
 */
public class ReadFileToObjects {

	File file = null;
	BufferedWriter bw = null;
	BufferedReader br = null;
	boolean read;
	boolean write;

	public ReadFileToObjects(String path, boolean read, boolean write) {
		this.write = write;
		this.read = read;
		this.file = new File(path);
		if (!this.file.exists()) {
			System.out.println("File is not exists!");
		} else {
			try {
				FileWriter fw = null;
				FileReader fr = null;
				if (write) {
					write = false;
					fw = new FileWriter(file);
					this.bw = new BufferedWriter(fw);
					write = true;
				}
				if (read) {
					read = false;
					fr = new FileReader(file);
					this.br = new BufferedReader(fr);
					read = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void MatrixToFile(int arr[][]) throws IOException {
		if (write) {
			for (int i = 0; i < arr.length; i++) {
				String tmp = "";
				for (int js : arr[i]) {
					tmp += (js + " ");
				}
				bw.write(tmp);
				bw.newLine();
			}
			bw.flush();
		}
	}

	public HashMap<String, String> MapFromFile() {
		HashMap<String, String> content = null;
		List<String> keys = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if (read) {
			content = new HashMap<String, String>();
			String line = null;
			String[] con;
			try {

				do {
					line = br.readLine();
					if (line != null && !line.equals("")) {
						con = line.split("[\t]");
						keys.add(con[0]);
						values.add(con[1]);
					}
				} while (line != null && !line.equals(""));
				while (keys.size() > 0) {
					content.put(keys.remove(keys.size() - 1),
							values.remove(values.size() - 1));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return content;
	}

	public List<String> StringsFromFile() {
		List<String> values = null;
		if (read) {
			values = new ArrayList<String>();
			String line = null;
			try {
				while (null != (line = br.readLine())) {
					values.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return values;
	}

	/*
	 * public static void main(String[] args) { ReadFileToObjects rfto = new
	 * ReadFileToObjects("key.txt", true, false); HashMap<String, String>
	 * content = rfto.MapFromFile(); int i = 0; for (String s :
	 * content.keySet()) { i++; System.out.println(i + " " + s + " " +
	 * content.get(s)); } }
	 */
}
