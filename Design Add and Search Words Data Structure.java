class WordDictionary {
    class Node{
        Node[] child;
        boolean isEnd;
        Node(){
            child = new Node[26];
        }
    }
    
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null){
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean travel(Node node, String word, int index){
        if(node == null) return false;
        if(index == word.length()) return node.isEnd;
        
        if(word.charAt(index) == '.'){
            for(int i = 0 ; i < 26 ; i++){
                if(travel(node.child[i], word, index + 1)) return true;
            }
            return false;
        }
        else{
            return travel(node.child[word.charAt(index) - 'a'], word, index + 1);    
        }
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        return travel(root, word, 0);
    }
}
