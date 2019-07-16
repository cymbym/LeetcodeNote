/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

1.我的解：boomerangs中，第一个数不变，第二个数和第三个数到第一个数的距离相同。因此采用两层循环，依次将每个数作为第一个数，用HashMap存储各点到该数的距离。
  若距离同为key的有value个，由排列关系，得boomerangs多出了value * (value - 1)个。
  140ms。
2.最优解：没看懂。41ms。
*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		for (int i = 0; i < points.length; i ++) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = 0; j < points.length; j ++) {
				if (i != j) {
					int temp = distance(points[i], points[j]);
					map.put(temp, map.getOrDefault(temp, 0) + 1);
				}
			}
			for(int value : map.values())
			{
				if (value >= 2) res += value * (value - 1);
			}
		}
        return res;
    }
	private int distance(int[] x, int[] y) {
		int res = 0;
		for (int i = 0; i < x.length; i ++) {
			res += Math.pow(x[i] - y[i], 2);
		}
		return res;
	}
}

class Solution {
    public int numberOfBoomerangs(int[][] p) {
        
        int l = p.length;
        int c[] = new int[l<<1];
        int u = 0;
        for(int pr[] : p){
            c[u++] = pr[0];   
            c[u++] = pr[1];
        }
        
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>(u<<1);
        for(int i=0;i<u;i+=2){
            for(int j=0,x = c[i],y = c[i+1];j<u;j+=2){
                int d = (x-c[j])*(x-c[j])+(y-c[j+1])*(y-c[j+1]);
                Integer v = map.get(d);
                if(v!=null){
                    map.put(d,v+1);
                    count+=v<<1;
                } else 
                    map.put(d,1);
            }
            map.clear();
        }
        return count;
    }
}