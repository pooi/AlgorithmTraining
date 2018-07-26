package d5;

import java.util.Scanner;

public class P9204 {
    public static final int MAX_N = 100000;
    static int N, M;
    static Trie root;
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            N = scn.nextInt(); M = scn.nextInt();
            root = new Trie();

            String [] words = new String[MAX_N];
            for(int i=0; i<N; i++){
                words[i] = scn.next();
                root.insert(words[i], 0);
            }

            int result = 0;
            for(int i=0; i<M; i++){
                int query;
                query = scn.nextInt();
                switch (query){
                    case 1: {
                        String word = scn.next();
                        result += root.findCompletelyMatching(word, 0);
                        break;
                    }
                    case 2: {
                        String word = scn.next();
                        result += root.findPartiallyMatching(word, 0);
                        break;
                    }
                    case 3: {
                        String word1 = scn.next();
                        String word2 = scn.next();
                        int add = root.findCompletelyMatching(word1, 0);
                        if(add > 0){
                            root.remove(word1, 0, add);
                            root.add(word2, 0, add);
                        }
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static class Trie{
        boolean isFinish;
        Trie [] next;
        int count;
        int total;
        public Trie(){
            next = new Trie[26];
            count = 0;
            total = 0;
        }
        public void insert(String key, int index){
            if(index == key.length()){
                isFinish = true;
                count++;
            }else{
                int pos = key.charAt(index) - 'a';
                if(next[pos] == null){
                    next[pos] = new Trie();
                }
                next[pos].total++;
                next[pos].insert(key, index+1);
            }
        }
        public int findCompletelyMatching(String key, int index){
            if(index == key.length() && isFinish){
                return count;
            }
            int pos = key.charAt(index) - 'a';
            if(next[pos] == null)
                return 0;
            return next[pos].findCompletelyMatching(key, index+1);
        }

        public int findPartiallyMatching(String key, int index){
            if(index == key.length()){
                return total;
            }
            int pos = key.charAt(index) - 'a';
            if(next[pos] == null){
                return 0;
            }
            return next[pos].findPartiallyMatching(key, index+1);
        }

        public void remove(String key, int index, int add){
            if(index == key.length()){
                count = 0;
                isFinish = false;
                return;
            }
            int pos = key.charAt(index) - 'a';
            next[pos].total -= add;
            next[pos].remove(key, index+1, add);
        }

        public void add(String key, int index, int add){
            if(index == key.length()){
                isFinish = true;
                count += add;
            }else{
                int pos = key.charAt(index) - 'a';
                if(next[pos] == null){
                    next[pos] = new Trie();
                }
                next[pos].total += add;
                next[pos].add(key, index+1, add);
            }
        }
    }
}
