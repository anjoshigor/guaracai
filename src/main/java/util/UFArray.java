package util;

import java.util.ArrayList;
import java.util.Collections;

public final class UFArray {
	private final static String[] listOfUfs = new String[] {
			"AC",
			"AL",
			"AP",
			"AM",
			"BA",
			"CE",
			"DF",
			"ES",
			"GO",
			"MA",
			"MT",
			"MS",
			"MG",
			"PR",
			"PB",
			"PA",
			"PE",
			"PI",
			"RJ",
			"RN",
			"RS",
			"RO",
			"RR",
			"SC",
			"SE",
			"SP",
			"TO"
	};
	
	private UFArray() {
	/**prevent instantiation**/
	}
	

	public static String[] getListOfUfs() {
		return listOfUfs;
	}
	
	
}
