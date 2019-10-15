/*
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.

1.我的解法：用初始化为boolean[1000]的数组存储是否存在，用初始化为int[1000]的数组存储value，
                  当put的key大于数组时，用Arrays.copyOf(list, key*2)在尾部填零扩容；
				  当remove的key小于数组时，直接操作；大于时，则不操作。
				  当get的key小于数组且key存储过值时，直接输出值；大于时，则直接返回-1。
*/

class MyHashMap {
    int[] values;
    boolean[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        values = new int[1000];
        map = new boolean[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (key > map.length) {
            values = Arrays.copyOf(values, key + 1);
            map = Arrays.copyOf(map, key + 1);
        }
        values[key] = value;
        map[key] = true;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (key < map.length && map[key]) return values[key];
        else return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (key < map.length) map[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */