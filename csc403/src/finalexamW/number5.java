package finalexamW;

import algs34.LinearProbingHashST;

public class number5 {

	public static void main(String[] args) {
		
		LinearProbingHashST<String, Integer> lph = new LinearProbingHashST<>(31);
		
		lph.put("hello", 1);
		lph.put("hEllo", 2);
		lph.put("heLlo", 3);
		lph.put("helLo", 4);
		lph.put("HellO", 5);
		lph.put("hELLO", 6);
		lph.put("HeLL0", 7);
		lph.put("HElLO", 8);
		lph.put("HELlO", 9);
		lph.put("hELLo", 10);
		
		
		
		for(String s : lph.keys()){
			System.out.println(s + " " + lph.get(s));
		}

	}

}
