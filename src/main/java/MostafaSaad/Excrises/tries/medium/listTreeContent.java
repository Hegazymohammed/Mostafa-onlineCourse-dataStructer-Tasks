package MostafaSaad.Excrises.tries.medium;

import java.util.List;

class Trie{
        private boolean isLeaf;
        private final int MAX_CHILD=26;
        private Trie child[]=new Trie[MAX_CHILD];

        public void insert(String word){
                int length=word.length();
                Trie current=this;

                for(int i=0;i<length;++i){
                        char value=word.charAt(i);
                        int position=value-'a';
                        if(current.child[position]==null)
                                current.child[position]=new Trie();
                        current=current.child[position];
                }
                isLeaf=true;
            }

            public void listTrieContent(List<String> list, String word){
                    if(isLeaf)
                        list.add(word);
                    for(int i=0;i<26;++i)
                        if(child[i]!=null)
                        child[i].listTrieContent(list,word+(char)i+'a');


            }
}
