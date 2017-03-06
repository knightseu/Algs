package common.datastructure;

/**
 * Created by xuanlin on 3/5/17.
 */
class TrieNodeArr {

    public TrieNode[] children;
    public boolean hasWord;

    public TrieNodeArr() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i)
            children[i] = null;
        hasWord = false;
    }
}