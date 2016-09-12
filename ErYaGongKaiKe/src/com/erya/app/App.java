package com.erya.app;

import java.util.List;

import com.erya.base.ChanelService;
import com.erya.util.ReadFileToObjects;

public class App {

	public static void main(String[] args) {
		ReadFileToObjects chanelsInfo = new ReadFileToObjects(
				"data\\chanel.txt", true, false);
		List<String> chanels = chanelsInfo.StringsFromFile();
		ChanelService.doChanels(chanels);
	}

}
