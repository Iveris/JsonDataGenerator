package generator.app;

import java.util.Random;

public class DataGenerator {

	Random rand = new Random();
	
	public String genPath() {
		int length = rand.nextInt(10) + 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append(genLetter());
		}
		return sb.toString();
	}
	
	public String genWebsite() {
		int length = rand.nextInt(10) + 1;
		StringBuilder sb = new StringBuilder();
		sb.append("http://www.");
		for(int i = 0; i < length; i++) {
			sb.append(genLetter());
		}
		sb.append(".com/");
		for(int i = 0; i < length; i++) {
			sb.append(genLetter());
		}
		return sb.toString();
	}
	
	public Integer genInt() {
		return rand.nextInt(1000) + 1;
	}
	
	private char genLetter() {
		int a = rand.nextInt(25) + 97;
		return (char) a;
	}
}
