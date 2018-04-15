package finalexamW;

import stdlib.StdDraw;
import stdlib.StdIn;
import stdlib.StdOut;

public class TestAVLTreeST {
    /**
     * Unit tests the {@code AVLTreeST} data type.
     */
    public static void main(String[] args) {
        AVLTreeST<String, Integer> st = new AVLTreeST<String, Integer>();
        
//        StdIn.fromFile("data/radio_alphabet.txt");
//        String[] words = StdIn.readAllStrings();
//        int count = 0;
//        for (String word: words) {
//            st.put(word, count);
//            count++;
//        }
//        st.drawTree();
        
        StdIn.fromString ("15, 20, 25, 30, 05, 08, 10, 02, 16");
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		st.drawTree ();
		StdDraw.save("data/final#4.png");
        
        // st.delete("Papa");
        // st.drawTree();
    }
}
