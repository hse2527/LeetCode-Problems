class Trie {

    class Tnode {
        char val;
        boolean end;
        HashMap<Character, Tnode> children;

        Tnode() {
            children = new HashMap<>();
            end = false;
        }

        Tnode(char val) {
            this.val = val;
            end = false;
            children = new HashMap<>();
        }
    }

    Tnode head;

    public Trie() {
        head = new Tnode();
    }
    
    public void insert(String word) {
        Tnode orig = head;
        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            Tnode next = orig.children.get(cur);
            if(next == null) {
                next = new Tnode(cur);
                orig.children.put(cur, next);
            }
            orig = next;
        }
        orig.end = true;
    }
    
    public boolean search(String word) {
        Tnode orig = head;
        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            Tnode next = orig.children.get(cur);
            if(next == null) {
                return false;
            }
            orig = next;
        }
        if(orig.end == true) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Tnode orig = head;
        for(int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            Tnode next = orig.children.get(cur);
            if(next == null) {
                return false;
            }
            orig = next;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */