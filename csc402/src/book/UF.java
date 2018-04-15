package book;

import edu.princeton.cs.algs4.In;

public class UF {
	
	private int[] id;
	private int count;
	
	public int count(){
		return count;
	}
	
	public UF(int n){
		count = n;
		id = new int[n];
		for(int i = 0; i<n; i++){
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		return id[p];
	}
	
	public void union(int p, int q){
		int pID = find(p);
		int qID = find(q);
		
		if(pID == qID) return;
		
		for(int i=0; i<id.length; i++){
			if(id[i] == pID){
				id[i] = qID;
				count--;
			}
			//count--;
		}
	}
	
	
	
	public static void main(String[] args){
		In in = new In(args[0]);
		int n = in.readInt();
		UF uf = new UF(n);
		
		while(!in.isEmpty()){
			int p = in.readInt();
			int q = in.readInt();
			//System.out.println(uf.connected(p,q));
			if(uf.connected(p, q)){
				continue;
			}
			uf.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + " components");
	}
}

