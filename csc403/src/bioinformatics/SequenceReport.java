package bioinformatics;

import stdlib.StdIn;
import java.util.*;

public class SequenceReport {

	public static void main(String[] args) {
				
		try{
			
			StdIn.fromFile("data/sequences.txt");
			
			while(StdIn.hasNextLine()){
				String line = StdIn.readLine();
				String[] fields = line.split("\\t");
				String species = fields[0];
				String sequence = fields[1];
				
				DNAReport(species,sequence);
			}
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	public static void DNAReport(String species, String sequence){
		
		DNASequence dnaSequence = new DNASequence(species, sequence);
		//1. The name of the species
		System.out.println("Specie's name: " + dnaSequence.speciesName());
		//System.out.println(dnaTest.sequnce());
		
		//2. The number of bases in the sequence
		System.out.println();
		System.out.println(String.format("Number of bases: %d [A: %d] [C: %d] [G: %d] [T: %d]",
				dnaSequence.Size(), dnaSequence.countA(), dnaSequence.countC(), dnaSequence.countG(), dnaSequence.countT()));
		
		//3. The number of codons in the sequence
		System.out.println();
		System.out.println("Number of codons: " + dnaSequence.Size()/3);
		
		//4. The percentage of the occurrence of each base
		System.out.println();
		System.out.println("Percentage of A: " + (double)Math.round(((double)dnaSequence.countA()/(double)dnaSequence.Size()*100)*10)/10 + "%");
		System.out.println("Percentage of C: " + (double)Math.round(((double)dnaSequence.countC()/(double)dnaSequence.Size()*100)*10)/10 + "%");
		System.out.println("Percentage of G: " + (double)Math.round(((double)dnaSequence.countG()/(double)dnaSequence.Size()*100)*10)/10 + "%");
		System.out.println("Percentage of T: " + (double)Math.round(((double)dnaSequence.countT()/(double)dnaSequence.Size()*100)*10)/10 + "%");
		
		//5. The positions in the sequence where the subsequence "CCAAT" occurs
		System.out.println();
		System.out.print("The positions in the sequence where \"CCAAT\" occur: ");
		for(Integer i : dnaSequence.subsequencePositions("CCAAT")){
			System.out.print(i.toString() + " ");
		}
		System.out.println();
					
		//6. The first twelve amino acids, by their short names, that are coded beginning at position 0.
		//note, the code in dnasequence will take care of the 0,36 as opposed to 35.
		System.out.println("Short Names: ");
		for(String acid : dnaSequence.aminoAcidSequenceShortName(0,36)){
			System.out.println(acid.toString());
		}
		System.out.println();
		System.out.println("Full Names: ");
		//7.Same as the previous but by the amino acid long names.
		for(String acid : dnaSequence.aminoAcidSequenceFullName(0,36)){
			System.out.println(acid.toString());
		}		
					
		System.out.println();
		System.out.println("phenylalanine occurs: " + dnaSequence.GetAminoAcidCountsByName("phenylalanine"));
		System.out.println("histidine occurs: " + dnaSequence.GetAminoAcidCountsByName("histidine"));
		System.out.println();
		System.out.println();
		
		//my other test cases
//		for(String acid : dnaTest.aminoAcidSequenceShortName(2,6)){
//		System.out.println(acid.toString());
//	}	
//	for(String acid : dnaTest.aminoAcidSequenceShortName(2,7)){
//		System.out.println(acid.toString());
//	}
//	for(String acid : dnaTest.aminoAcidSequenceFullName(0,27)){
//		System.out.println(acid.toString());
//	}
//	for(String acid : dnaTest.aminoAcidSequenceFullName(0,9)){
//		System.out.println(acid.toString());
//	}
//		System.out.print("The positions in the sequence where \"X\" occur: ");
//		for(Integer i : dnaTest.subsequencePositions("X")){
//			System.out.print(i.toString() + " ");
//		}
//		System.out.println();
	}
}
