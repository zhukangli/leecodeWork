package com.conley.zhu.leetcode;

/**
 * 这里还需要再仔细理解一下
 * 现在先大概有个印象
 */
public class Code208 {
    public static class TrieNode{
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public TrieNode(){
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }
        public void put(char ch,TrieNode node){
            links[ch - 'a'] = node;
        }
        public void setEnd(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }


    private TrieNode root;

    /** Initialize your data structure here. */
    public Code208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            char currChar = word.charAt(i);
            if(!node.containsKey(currChar)){
                node.put(currChar,new TrieNode());
            }
            node = node.get(currChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            char currLetter = word.charAt(i);
            if(node.containsKey(currLetter)){
                node = node.get(currLetter);
            }else {
                return null;
            }
        }
        return node;
    }

}
