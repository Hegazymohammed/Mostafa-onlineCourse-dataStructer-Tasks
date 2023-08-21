package MostafaSaad.Excrises.tries;

public class Tri {
    private Tri array[]=new Tri[26];
    private  boolean isLeaf;

    public Tri(){

    }

    public void add(String string,int index){
            if(index==string.length())
                isLeaf=true;

            else{
            int position=string.charAt(index)-'a';
            if(array[position]==null)
            array[position]=new Tri();
            array[position].add(string,index++);
            }
    }

    public boolean wordIsExist(String word,int index){
                if(index==word.length())
                        return isLeaf;

                    int position=word.charAt(index)-'a';

                    if(array[position]==null)
                            return false;
                    return array[position].wordIsExist(word,index++);

    }

    public boolean wordIsExist(String word){
        return wordIsExist(word,0);
    }
    public boolean prefixIsExist(String word,int index){
                if(index==word.length())
                        return true;
                int position=word.charAt(index)-'a';
                if(array[position]==null)
                    return false;
                return array[position].prefixIsExist(word,index+1);
    }

    public boolean prefixIsExist(String word){
        return prefixIsExist(word,0);
    }

    void insertIterative(String word){
            int length=word.length();
            Tri current=this;
        for (int i = 0; i < length; i++) {
             int position=word.charAt(i)-'a';
            if(current.array[position]==null)
                array[position]=new Tri();

             current=array[position];

        }     current.isLeaf=true;
    }

    public boolean wordExist(String word){
        int length=word.length();

        Tri current=this;
        for (int i = 0; i < length; i++) {
            int position=word.charAt(i)-'a';
            if(current.array[position]==null)
                    return false;
            current=array[position];

        }
        return isLeaf;
    }



}
