//this is hashmap using hash-(no chainnig or open addressing )
import java.util.*;
import java.lang.Math;
public class HashMap {
   private Entity [] entities;
   private int size=5;
   public HashMap(){
    entities=new Entity[size];
   }
   private class Entity{
    String key;
    int val;
    public Entity(String key,int val){
        this.key=key;
        this.val=val;
    } 
}
    public void put(String key,int val){//allows duplicate keys
        int hash=Math.abs(key.hashCode()%entities.length);
            entities[hash]=new Entity(key,val);  //over riding
        
    }
    //using linear probing,better than over riding
    public void insert(String key,int val){
        int hash=Math.abs(key.hashCode()%entities.length);
        int starthash=hash;//for detecting loop
         
            while(entities[hash]!=null){
               // Check if the key already exists, then update the value
        if (entities[hash].key.equals(key)) {
            entities[hash].val = val;
            return;
        }

        hash = (hash + 1) % entities.length;//if hash==entities.length then it sets it to 0
                if(hash==starthash){
                    throw new RuntimeException("HashMap is full");
                }
            }
         
         entities[hash]=new Entity(key,val);
    }
    public int get(String key){
        int hash=Math.abs(key.hashCode()%entities.length);
         if(entities[hash].key.equals(key)&&entities[hash]!=null){
             return entities[hash].val;
         }
         return -1;
    }
    public void display(){
        for (int i = 0; i < entities.length; i++) {
            if(entities[i]!=null){
            System.out.println(entities[i].key+"->"+entities[i].val);
            }
        }
    }

   public static void main(String[] args) {
    HashMap map= new HashMap();
    // map.put("A",2);
    // map.put("B",7);
    // map.put("H",8);
    map.insert("a",1);
    map.insert("b",2);
    map.insert("s",18);
   



 map.display();

   }
}
