package MostafaSaad.Excrises.tries.easy;


class Trie {
        boolean isLeaf;
        private final int MAX=26;
        Trie child[]=new Trie[26];
      public void insert(String word){
          int length=word.length();
          StringBuilder reversedWord=new StringBuilder(word).reverse();
          Trie current =this;
          for(int i=0;i<length;++i){
             char  value= reversedWord.charAt(i);
              int position=value-'a';
              if(current.child[position]==null)
                    current.child[position]=new Trie();
              current=current.child[position];
          }
          current.isLeaf=true;
      }

      public boolean isSuffix(String suffix){

            StringBuilder reversedSuffix=new StringBuilder().reverse();
            Trie current=this;
            for(int i=0;i<reversedSuffix.length();++i){
                    char index=reversedSuffix.charAt(i);
                    int position=index-'a';
                    if(current.child[position]==null)
                            return false;
                    current=current.child[position];
            }
           return true;
      }

 }
