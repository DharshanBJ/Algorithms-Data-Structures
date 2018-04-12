import java.util.HashMap;
import java.util.Map;

class TrieNode{
        public Map<Character,TrieNode> children;
        public boolean endofword;

        public TrieNode(){
            endofword=false;
            children=new HashMap<>();
        }
    }

    public class TrieImplementation {

        /** Initialize your data structure here. */
        private TrieNode root;

        public TrieImplementation() {
            root=new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                Character ch=word.charAt(i);
                if(!node.children.containsKey(ch)){
                    node.children.put(ch,new TrieNode());
                }
                node=node.children.get(ch);
            }
            node.endofword=true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node=check(word);
            return node!=null && node.endofword;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node=check(prefix);
            return node!=null;
        }

        public TrieNode check(String word){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                node=node.children.get(word.charAt(i));
                if(node==null)return null;
            }
            return node;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

