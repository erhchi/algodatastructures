package bioinformaticsW;

import stdlib.StdIn;
import java.util.*;
import algs31.*;

public class SequenceReport {

	public static void main(String[] args) {
		
		BinarySearchST<String, String> bst = new BinarySearchST<>();
		
		try{
			
			DNASequence dnaTest = new DNASequence("Vulpes vulpes", "ATGTTCATT");
			
			System.out.println(dnaTest.speciesName());
			System.out.println(dnaTest.sequnce());
			System.out.println(dnaTest.Size());
			System.out.println(dnaTest.countA());
			System.out.println(dnaTest.countC());
			System.out.println(dnaTest.countG());
			System.out.println(dnaTest.countT());
			
			for(String acid : dnaTest.aminoAcidSequenceShortName(0,12)){
				System.out.println(acid.toString());
			}
			
//			StdIn.fromFile("data/sequences_test.txt");
//			
//			while(StdIn.hasNextLine()){
//				String line = StdIn.readLine();
//				String[] fields = line.split("\\t");
//				String species = fields[0];
//				String sequence = fields[1];
//				bst.put(species, sequence);
//				
//				//each has to create a DNA sequence object
//				DNASequence dnaSequence = new DNASequence(species, sequence);
//			}
//			
//			for(String name : bst.keys()){
//				System.out.println(bst.get(name));
//			}
			
			
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}

	}

}
