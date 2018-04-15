package bioinformatics;

import java.util.*;
import stdlib.StdDraw;

public class DNASequence {

	private String species;
	private String sequence;
	private int countA;
	private int countC;
	private int countG;
	private int countT;
	private static String[] codon = {"AAA",	"AAC",	"AAG",	"AAT",	"ACA",	"ACC",	"ACG",	"ACT",	"AGA",	"AGC",	"AGG",	"AGT",	"ATA",	"ATC",	"ATG",	"ATT",	"CAA",	"CAC",	"CAG",	"CAT",	"CCA",	"CCC",	"CCG",	"CCT",	"CGA",	"CGC",	"CGG",	"CGT",	"CTA",	"CTC",	"CTG",	"CTT",	"GAA",	"GAC",	"GAG",	"GAT",	"GCA",	"GCC",	"GCG",	"GCT",	"GGA",	"GGC",	"GGG",	"GGT",	"GTA",	"GTC",	"GTG",	"GTT",	"TAA",	"TAC",	"TAG",	"TAT",	"TCA",	"TCC",	"TCG",	"TCT",	"TGA",	"TGC",	"TGG",	"TGT",	"TTA",	"TTC",	"TTG",	"TTT"};
	private static String[] oneLetter = {"K",	"N",	"K",	"N",	"T",	"T",	"T",	"T",	"R",	"S",	"R",	"S",	"I",	"I",	"M",	"I",	"Q",	"H",	"Q",	"H",	"P",	"P",	"P",	"P",	"R",	"R",	"R",	"R",	"L",	"L",	"L",	"L",	"E",	"D",	"E",	"D",	"A",	"A",	"A",	"A",	"G",	"G",	"G",	"G",	"V",	"V",	"V",	"V",	"X",	"Y",	"X",	"Y",	"S",	"S",	"S",	"S",	"X",	"C",	"W",	"C",	"L",	"F",	"L",	"F"};
	
	private ArrayList<String> names = new ArrayList<>();
	private AminoAcid aminoAcid;
	private static AVLTreeST<String, String> avl;	
//	private static HashMap<String, String> hm;	
	
	
	public DNASequence(String species, String sequence){
		this.species = species;
		this.sequence = sequence;
	}
	
	static{
		avl = new AVLTreeST<>();
		for(int i = 0; i<oneLetter.length; i++){
			avl.put(codon[i], oneLetter[i]);	
		}		
//		avl.drawTree();
//		StdDraw.save("data/DNASequenceAVL.png");
		
//		hm = new HashMap<>();
//		for(int i = 0; i<oneLetter.length; i++){
//			hm.put(codon[i],  oneLetter[i]);
//		}
	}
	
	
	public int GetAminoAcidCountsByName(String name){
		int count = 0;
		int sequenceLength = this.sequence.length();
		//ensure sequence length is multiple of three		
		int multipleThree = sequenceLength % 3; //result 0,1,2; adjust for 1,2
		switch(multipleThree){
			case 1: sequenceLength -= 1;
			break;
			case 2: sequenceLength -= 2;
			break;
		}
		
		for(String n : this.aminoAcidSequenceFullName(0, sequenceLength)){
			if(n == name){
				count++;
			}
		}
		return count;
	}
	
	
	public Iterable<Integer> subsequencePositions(String subsequence){
		LinkedList<Integer> list = new LinkedList<>();
		
		int i = sequence.indexOf(subsequence);
		while(i>=0){
			list.add(i);
			i = sequence.indexOf(subsequence, i+1);
		}
		
		if(list.size() == 0){
			System.out.println("The subsequnce does not appear in the species sequence.");
		}
		
		return list;
	}
	
	//would prefer to combine the two methods and add a 3rd parameter to specify the name type
	public Iterable<String> aminoAcidSequenceShortName(int start, int end){	
		names.clear();
		//check request bounds
		if(end>sequence.length()){
			System.out.println("Your request was greater than the sequence length.");
		}
		else
		{
			String sequenceToCheck = sequence.substring(start, end);
			//System.out.println(sequenceToCheck);	
			//check if multiple of 3
			if((sequenceToCheck.length() % 3) != 0){
				System.out.println(sequenceToCheck.length());
				System.out.println("Your request sequence length must be a multiple of three.");
			}			
			else
			{							
				String block = "";
				for(int i = 0; i<sequenceToCheck.length(); i++){
					
					block = block + sequenceToCheck.charAt(i);
					
					if(block.length() == 3){
						names.add(aminoAcid.shortName(avl.get(block.toUpperCase()).toUpperCase()));
					}
					
					if(i%3 == 2 && i != 0){
						//System.out.println("block: " + block);
						block = "";
					}
				}
			}			
		}
		
		return names;
	}
	
	public Iterable<String> aminoAcidSequenceFullName(int start, int end){
		names.clear();
		//check request bounds
		if(end>sequence.length()){
			System.out.println("Your request was greater than the sequence length.");
		}
		else
		{
			String sequenceToCheck = sequence.substring(start, end);
			//check if multiple of 3
			if((sequenceToCheck.length() % 3) != 0){
				System.out.println("Your request sequence length must be a multiple of three.");
			}			
			else
			{
				String block = "";
				for(int i = 0; i<sequenceToCheck.length(); i++){
					
					block = block + sequenceToCheck.charAt(i);
					
					if(block.length() == 3){
						names.add(aminoAcid.fullName(avl.get(block.toUpperCase()).toUpperCase()));
					}
					
					if(i%3 == 2 && i != 0){
						block = "";
					}
				}
			}			
		}
		
		return names;
	}
	
	
	public String speciesName(){
		return this.species;
	}
	
	public String sequnce(){
		return this.sequence;
	}
	
	public int countA(){	
		countA = 0;
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'A'){
				countA += 1;
			}
		}		
		return countA;
	}
	
	public int countC(){	
		countC = 0;
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'C'){
				countC += 1;
			}
		}		
		return countC;
	}
	
	public int countG(){	
		countG = 0;
		for(int i = 0; i<sequence.length(); i++){
			if(Character.toUpperCase(sequence.charAt(i)) == 'G'){
				countG += 1;
			}
		}		
		return countG;
	}
	
	public int countT(){	
		countT = 0;
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
