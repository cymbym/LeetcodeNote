/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.


1.我的方法：先排序生成一个含k个从大到小排序的初始【数组】，随后在这个数组中进行插值。382ms。
2.较优解：用基于优先级堆的无界【优先队列】PriorityQueue<>(k)对数据进行存储。会自动进行排序。62ms。
3.最优解：53ms。
*/

class KthLargest {
    ArrayList<Integer> list = new ArrayList();
    int index;
    public KthLargest(int k, int[] nums) {
        index = k - 1;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length - i - 1; j ++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
            if (i > index) break;
            else list.add(nums[nums.length - i - 1]);
        }
    }
    
    public int add(int val) {
        if (list.size() == 0) list.add(val);
        else if (list.size() <= index) {
            int i = list.size() - 1;
            if (val > list.get(0)) list.add(0, val);
            else if (val > list.get(i)) {
                while (i - 1 >= 0 && val >= list.get(i - 1)) i --;
                list.add(i, val);
            } else list.add(val);
        }
        else{System.out.println(val);
            int i = index;
            if (val > list.get(0)) list.add(0, val);
            else if (val > list.get(i)) {
                while (i - 1 >= 0 && val >= list.get(i - 1)) i --;
                list.add(i, val);
            }
        }
        return list.get(index);
    }
}


class KthLargest {
    private Queue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() == k + 1) {
            pq.remove();
        }
        return pq.peek();
    }
}



public class KthLargest {
  private int[] heap;
  private int size = 0;

  public KthLargest(int k, int[] nums) {
    heap = new int[k];
    for (int num : nums) {
      addAnItem(num);
    }
  }

  private void addAnItem(int item) {
    // add to end of the array until array is full and heapifyUp
    if (size < heap.length) {
      heap[size++] = item;
      heapifyUp();
    } else {
      // add to the top only if less than the least and heapifyDown
      if (item < heap[0]) return;
      heap[0] = item;
      heapifyDown();
    }
  }

  public int add(int val) {
    addAnItem(val);
    return heap[0];
  }

  private void swap(int parentNodeIndex, int i) {
    int temp = heap[i];
    heap[i] = heap[parentNodeIndex];
    heap[parentNodeIndex] = temp;
  }

  private void heapifyUp() {
    int indexToStartWith = size - 1;
    while(indexToStartWith > 0) {
      int parentIndex = (indexToStartWith - 1) / 2; // best way to find parent
      if (heap[indexToStartWith] < heap[parentIndex]) {
        swap(indexToStartWith, parentIndex);
        indexToStartWith = parentIndex;
      } else {
        break;
      }
    }
  }

  private void heapifyDown() {
    if (size == 1) return;
    int largest = 0;
    int startIndex = 0;
    while(startIndex < size ) {
      int leftChildIndex = 2*startIndex + 1;
      int rightChildIndex = 2*startIndex + 2;
      if (leftChildIndex < size && heap[largest] > heap[leftChildIndex]) {
        largest = leftChildIndex;
      }
      if (rightChildIndex < size && heap[largest] > heap[rightChildIndex]) {
        largest = rightChildIndex;
      }
      if (startIndex != largest) {
        swap(largest, startIndex);
        startIndex = largest;
      } else {
        break;
      }
    }
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */