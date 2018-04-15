package bioinformaticsW;

import java.util.*;
import algs33.*;
import bioinformatics.AminoAcid;

public class DNASequence2 {

	private String species;
	private String sequence;
	private int countA;
	private int countC;
	private int countG;
	private int countT;
	private ArrayList<String> names = new ArrayList<>();
	private String[] codon = {"AAA",	"AAC",	"AAG",	"AAT",	"ACA",	"ACC",	"ACG",	"ACT",	"AGA",	"AGC",	"AGG",	"AGT",	"ATA",	"ATC",	"ATG",	"ATT",	"CAA",	"CAC",	"CAG",	"CAT",	"CCA",	"CCC",	"CCG",	"CCT",	"CGA",	"CGC",	"CGG",	"CGT",	"CTA",	"CTC",	"CTG",	"CTT",	"GAA",	"GAC",	"GAG",	"GAT",	"GCA",	"GCC",	"GCG",	"GCT",	"GGA",	"GGC",	"GGG",	"GGT",	"GTA",	"GTC",	"GTG",	"GTT",	"TAA",	"TAC",	"TAG",	"TAT",	"TCA",	"TCC",	"TCG",	"TCT",	"TGA",	"TGC",	"TGG",	"TGT",	"TTA",	"TTC",	"TTG",	"TTT"};
	private String[] oneLetter = {"K",	"N",	"K",	"N",	"T",	"T",	"T",	"T",	"R",	"S",	"R",	"S",	"I",	"I",	"M",	"I",	"Q",	"H",	"Q",	"H",	"P",	"P",	"P",	"P",	"R",	"R",	"R",	"R",	"L",	"L",	"L",	"L",	"E",	"D",	"E",	"D",	"A",	"A",	"A",	"A",	"G",	"G",	"G",	"G",	"V",	"V",	"V",	"V",	"X",	"Y",	"X",	"Y",	"S",	"S",	"S",	"S",	"X",	"C",	"W",	"C",	"L",	"F",	"L",	"F"};
	private static AminoAcid aminoAcid;
	private AVLTreeST<String, String> avl;	
	String[] sequenceOfThrees = new String[256];
	
		
	public DNASequence2(String species, String sequence){
		this.species = species;
		this.sequence = sequence;
		
		
		int aminoArray = 0;
		String prev;
		//put sequence in array of 3's, do in initialization as opposed to each time the iterables are called
		for(int i =0; i<sequence.length(); i++){
			
			if(sequenceOfThrees[aminoArray]!=null){
				prev = sequenceOfThrees[aminoArray];
			}
			else
			{
				prev = "";
			}
			sequenceOfThrees[aminoArray] = prev + String.valueOf(sequence.charAt(i));
			
			System.out.println(String.valueOf(sequence.charAt(i)));
			System.out.println(aminoArray);
			if((i+1)%3==0) aminoArray++;
		}
		
		avl = new AVLTreeST<>();
		for(int i = 0; i<oneLetter.length; i++){
			avl.put(codon[i], oneLetter[i]);	
		}
		
	}
	
	
	
//	public Iterable<String> aminoAcidSequenceShortName(int start, int end){	
//		int requestedBlocks = end / 3; //4
//		int availableBlocks = sequence.length() / 3; //3
//		while(availableBlocks <= requestedBlocks){
//			for(int i = 0; i<blocks; i++){
//				names.add(aminoAcid.shortName(avl.get(sequenceOfThrees[i])));
//			}
//		}
//			
//		return names;
//	}
//	
//	public Iterable<String> aminoAcidSequenceFullName(int start, int end){
//		int requestedBlocks = end / 3;
//		for(int i = 0; i<blocks; i++){
//			names.add(aminoAcid.fullName(avl.get(sequenceOfThrees[i])));
//		}
//		return names;
//	}
//	
	

	
	public String speciesName(){
		return this.species;
	}
	
	public String sequnce(){
		return this.sequence;
	}
	
	public int countA(){		
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'A'){
				countA += 1;
			}
		}		
		return countA;
	}
	
	public int countC(){		
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'C'){
				countC += 1;
			}
		}		
		return countC;
	}
	
	public int countG(){		
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'G'){
				countG += 1;
			}
		}		
		return countG;
	}
	
	public int countT(){		
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'T'){
				countT += 1;
			}
		}		
		return countT;
	}
	
	public int Size(){
		return this.sequence.length();
	}
		
}
