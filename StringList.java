public class StringList{
    int count = 0;

    stringList(String txt, int count){
        this.txt = txt;
        this.count = count;
        count++;
    }

    public int getCount(){
        return count;
    }

}