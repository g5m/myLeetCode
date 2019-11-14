public class ConstructQuadTree_427 {
    static class Node {
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
    public static void main(String[] args) {
        int[][] grid={{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        construct(grid);
    }
    public static Node construct(int[][] grid) {
        int size=grid.length;
        Node node= fun(grid,0,size-1,0,size-1);
        return node;
    }
    public  static Node fun(int[][] grid,int rowStart,int rowEnd,int colStart,int colEnd){
        int first=grid[rowStart][colStart];
        boolean value=true;
        for (int i = rowStart; i <=rowEnd ; i++) {
            for (int j = colStart; j <=colEnd; j++) {
                if(first!=grid[i][j]){
                    value=false;
                    break;
                }
            }
        }
        if(value){
            Node node=new Node();
            node.isLeaf=true;
            node.val=(first==1);
            return node;
        }else {
            Node node=new Node();
            node.isLeaf=false;
            node.topLeft=fun(grid,rowStart,rowStart+(rowEnd-rowStart)/2,colStart,colStart+(colEnd-colStart)/2);
            node.topRight=fun(grid,rowStart,rowStart+(rowEnd-rowStart)/2,colStart+(colEnd-colStart)/2+1,colEnd);
            node.bottomLeft=fun(grid,rowStart+(rowEnd-rowStart)/2+1,rowEnd,colStart,colStart+(colEnd-colStart)/2);
            node.bottomRight=fun(grid,rowStart+(rowEnd-rowStart)/2+1,rowEnd,colStart+(colEnd-colStart)/2+1,colEnd);
            return node;
        }


    }
}
