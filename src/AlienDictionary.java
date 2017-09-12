import java.util.*;

public class AlienDictionary {
	public static void main(String[] args) {
		System.out.println("Given a sorted dictionary of an alien language, find sequence of characters\n\n");
		String words[] = {"baa", "abcd", "abca", "cab", "cad"};
		HashMap<Character,Node> hmap = new HashMap<Character,Node>();
		for(int i=0;i<words.length-1;i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			for(int j=0;j<word1.length()&&j<word2.length();j++) {
				if(word1.charAt(j)!=word2.charAt(j)) {
					if(!hmap.containsKey(word1.charAt(j))) {
						Node temp = new Node(word1.charAt(j));
						hmap.put(word1.charAt(j), temp);
					}
					if(!hmap.containsKey(word2.charAt(j))) {
						Node temp = new Node(word2.charAt(j));
						hmap.put(word2.charAt(j), temp);
					}
					hmap.get(word1.charAt(j)).addEdge(hmap.get(word2.charAt(j)));
					break;
				}
			}
		}

		while(hmap.size()>=1)
		for(Map.Entry<Character,Node> entry:hmap.entrySet()) {
			
			if(entry.getValue().getIndegree() == 0) {
				entry.getValue().adjustAdjacentIndegree();
				hmap.remove(entry.getKey());
				break;
			}
		}
	}
}

class Node {
	private char alphabet;
	private int indegree;
	private LinkedList<Node> ll; 
	
	public Node(char key) {
		alphabet = key;
		indegree = 0;
		ll = new LinkedList<Node>();
	}
	
	public void addEdge(Node node) {
		ll.add(node);
		node.updateIndegree(1);
		
	}
	
	public int getIndegree() {
		return indegree;
		
	}
	
	private void updateIndegree(int val) {
		indegree = indegree+val;
	}
	
	public void adjustAdjacentIndegree() {
		System.out.println(alphabet);
		ListIterator<Node> li = ll.listIterator();
		while(li.hasNext()) {
			Node temp = li.next();
			temp.updateIndegree(-1);
		}
	}
}
