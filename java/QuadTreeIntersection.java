/*
A quadtree is a tree data in which each internal node has exactly four children: topLeft, topRight, bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional space by recursively subdividing it into four quadrants or regions.

We want to store True/False information in our quad tree. The quad tree is used to represent a N * N boolean grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same. Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

For example, below are two quad trees A and B:

A:
+-------+-------+   T: true
|       |       |   F: false
|   T   |   T   |
|       |       |
+-------+-------+
|       |       |
|   F   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight: T
bottomLeft: F
bottomRight: F

B:               
+-------+---+---+
|       | F | F |
|   T   +---+---+
|       | T | T |
+-------+---+---+
|       |       |
|   T   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight:
     topLeft: F
     topRight: F
     bottomLeft: T
     bottomRight: T
bottomLeft: T
bottomRight: F
 

Your task is to implement a function that will take two quadtrees and return a quadtree that represents the logical OR (or union) of the two trees.

A:                 B:                 C (A or B):
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       | F | F |  |       |       |
|   T   |   T   |  |   T   +---+---+  |   T   |   T   |
|       |       |  |       | T | T |  |       |       |
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       |       |  |       |       |
|   F   |   F   |  |   T   |   F   |  |   T   |   F   |
|       |       |  |       |       |  |       |       |
+-------+-------+  +-------+-------+  +-------+-------+
Note:

Both A and B represent grids of size N * N.
N is guaranteed to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.
The logic OR operation is defined as this: "A or B" is true if A is true, or if B is true, or if both A and B are true.

1.注意几种情况：

    A:                 B:                 C (A or B):
    +-------+-------+  +-------+---+---+  +-------+-------+
    | T | T |       |  | F | F | F | F |  |       |       |
    +---+---+   T   |  +---+---+---+---+  |   T   |   T   |
    | F | F |       |  | T | T | T | T |  |       |       |
    +-------+-------+  +-------+---+---+  +-------+-------+
    |       | F | F |  |       |       |  |       | F | F |
    |   F   +---+---+  |   T   |   F   |  |   T   +---+---+
    |       | T | T |  |       |       |  |       | T | T |
    +-------+-------+  +-------+-------+  +-------+-------+
	
    case1（二者存在叶子时）：1/3：4象限：if (quadTree1.isLeaf) return quadTree1.val ? quadTree1 : quadTree2;
             一旦有叶子结点，则找正，有正回正（1，3），无正回另一个（4）；
    case2（二者全不是叶子时的某个特例）：2象限：四个结果全为正或者负时，升为一个。
*/
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) return quadTree1.val ? quadTree1 : quadTree2;  //case1
        if (quadTree2.isLeaf) return quadTree2.val ? quadTree2 : quadTree1;  //case1
        else {
            Node res = new Node();
            res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (res.topLeft.isLeaf && res.topRight.isLeaf   //case2
                && res.bottomLeft.isLeaf && res.bottomRight.isLeaf
                && res.topLeft.val == res.topRight.val
                && res.topRight.val == res.bottomLeft.val
                && res.bottomLeft.val == res.bottomRight.val)  {
                res.isLeaf = true;
                res.val = res.topLeft.val;
                return res;
            }
            res.isLeaf = false;
            return res;
        }
    }
}
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        Node res = new Node();
        if (quadTree1.isLeaf) return quadTree1.val ? quadTree1 : quadTree2;
        if (quadTree2.isLeaf) return quadTree2.val ? quadTree2 : quadTree1;
        res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (res.topLeft.isLeaf && res.topRight.isLeaf
            && res.bottomLeft.isLeaf && res.bottomRight.isLeaf
            && res.topLeft.val == res.topRight.val
            && res.topRight.val == res.bottomLeft.val
            && res.bottomLeft.val == res.bottomRight.val) {
            res.isLeaf = true;
            res.val = res.topLeft.val;
        }
        return res;
    }
}
