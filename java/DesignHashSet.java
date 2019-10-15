/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.

1.我的解法：用boolean[1000000]的数组存储是否存在。58ms。
2.最优解：用初始化为boolean[1000]的数组存储，当add的key大于数组时，用Arrays.copyOf(list, key*2)在尾部填零扩容；
                                             当remove的key小于数组时，直接操作；大于时，则不操作。
                                             当contains的key小于数组时，直接判断；大于时，则直接返回false。
*/

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] list;
    public MyHashSet() {
        list = new boolean[1000000];
    }
    
    public void add(int key) {
        list[key] = true;
    }
    
    public void remove(int key) {
        list[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list[key];
    }
}


class MyHashSet {
    
    /** Initialize your data structure here. */
    
    boolean[] list;
    public MyHashSet() {
        list = new boolean[1000];
    }
    
    public void add(int key) {
        if(key>=list.length){
            list = Arrays.copyOf(list, key*2);;
        }
        list[key]=true;
        
    }
    
    public void remove(int key) {
        if(key<list.length){
            list[key]=false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key<list.length){
            return list[key];
        }
        
         return false;
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */