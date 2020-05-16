import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainHash {
    public static void main(String[] args) {
        var hashTable = new HashTable();
        hashTable.Put("1","Maxim");
        hashTable.Put("2","Sergey");
        hashTable.Put("3","Alex");
        System.out.println(hashTable.Get("1"));
        System.out.println(hashTable.Get("2"));
        System.out.println(hashTable.Get("3"));
    }
}

class HashTable{
    private String key;
    private String value;
    private ArrayList list = new ArrayList();

    public void Put(String key,String value){
        list.add(key);
        list.add(value);
    }

    public String Get(String key){
        if(list.contains(key)){
            return (String) list.get(list.indexOf(key)+1);
        }
        return "List doesn't contain value with your key";
    }

}
