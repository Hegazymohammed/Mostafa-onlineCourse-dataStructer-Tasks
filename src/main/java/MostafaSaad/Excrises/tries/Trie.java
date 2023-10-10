package MostafaSaad.Excrises.tries;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Trie {
    private final int max=26;
    private Trie[]childern=new Trie[max];
    private boolean isLeaf=false;
    public Trie() {

    }




    public void insert(String word) {
        int length=word.length();
        Trie current=this;
        for(int i=0;i<length;++i){
            int position=word.charAt(i)-'a';
            if( current.childern[position]==null)
                current.childern[position]=new Trie();

            current=current.childern[position];
        }
        current.isLeaf=true;
    }

    public boolean search(String word) {
        int length=word.length();
        Trie current=this;
        for(int i=0;i<length;++i){
            int position=word.charAt(i)-'a';
            if(current!=null&&current.childern[position]==null)
                return false;

            current=current.childern[position];
        }
        return isLeaf;
    }



    public String searchPrefix(String word){
        StringBuilder prefix=new StringBuilder();
        int length=word.length();
        Trie current=this;
        for(int i=0;i<length;++i){
            char value=word.charAt(i);
            int position=value-'a';

            if(current==null||current.childern[position]==null)
                return "";
            prefix.append(value);
            current=current.childern[position];
            if(current.isLeaf==true)
                return prefix.toString();
        }
        return "";
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        for(String prefix:dictionary) {
            trie.insert(prefix);
        }

        String[]words=sentence.split(" ");

        for(int i=0;i<words.length;++i){
            String newWord=trie.searchPrefix(words[i]);
            if(newWord.isEmpty())
                continue;
            else
                words[i]=newWord;

        }
        StringBuilder result=new StringBuilder();
        for(String word:words){
            result.append(word);
            result.append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String word="the cattle was rattled by the battery";
        List<String>dic=new ArrayList<>(Arrays.asList("cat","bat","rat"));

        ArrayDeque<Integer>array=new ArrayDeque<>();
        array.addLast(2);
        System.out.println(Integer.MIN_VALUE);
    }
}