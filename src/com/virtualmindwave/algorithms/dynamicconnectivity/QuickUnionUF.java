package com.virtualmindwave.algorithms.dynamicconnectivity;

/*----------------------------------------------------------------
 *  Author:        virtualmindwave
 *  Written:       11/19/2016
 *
 *  Implementation of the Quick Union Algorithm 
 *  for Dynamic Connectivity.
 *  
 *  Difference from Quick Find is the interpretation.
 *  Quick Union is interpreted as a tree structure.
 *  
 *  usage: Generate array of integers
 *  n = 10
 *  [0][1][2][3][4][5][6][7][8][9]
 *  
 *  union(7, 3)
 *  union(9, 2)
 *  union(1, 5)
 *  union(3, 5)
 *  union(0, 9)
 *  
 *  1 [2] 4 [5] 6 8
 *    /\    /\
 *   9  0  1  3
 *            |
 *            7
 *  
 *  result = [0][5][2][5][4][5][6][3][8][2]
 *              
 *  connected(9, 2) = true
 *  connected(3, 1) = false
 * 
 *----------------------------------------------------------------*/
class QuickUnionUF {

    private int[] arr;
    
    /**
     *  Constructor that initializes sample array values n
     */
    public QuickUnionUF(int n){
        arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }
    
    /**
     *  Retrieves the root value of the element i
     *  This will loop until the top root is found for large trees
     */
    public int root(int i){
        while(i != arr[i]){
            i = arr[i];
        }
        return i;
    }
    
    /**
     *  This will always change the root of x to y.
     *  Quick Union will always link to the root.
     */
    public void union(int x, int y){
        validate(x, y);
        int i = root(x);
        int j = root(y);
        arr[i] = j;
    }
    
    /**
     *  Quick Union will compare if elements are connected
     *  thru their root
     */
    public boolean connected(int x, int y){
        if(root(x) == root(y)){
            return true;
        }
        return false;
    }
    
    /**
     *  Test method for Quick Union Algorithm
     */
    public static void main(String[] args){
        QuickUnionUF qu = new QuickUnionUF(10);
        qu.union(7, 3);
        qu.union(9, 2);
        qu.union(1, 5);
        qu.union(3, 5);
        qu.union(7, 5);
        //this union will link 0 to 2 instead of 0 to 9
        //this is because the root of 9 is 2
        qu.union(0, 9); 
        
        qu.print();
        
        System.out.println(qu.connected(9, 0));
        System.out.println(qu.connected(7, 1));
    }
    
    /**
     *  Utility Method Only
     *  Print output to check elements
     */
    public void print(){
        StringBuffer original = new StringBuffer();
        StringBuffer connected = new StringBuffer();
        for (int i=0; i < arr.length; i++){
            original.append("["+i+"]");
            
            if(i+1 == arr.length) {
                original.append("\n");
            }
            
            connected.append(" " + arr[i] + " ");
        }
        original.append(connected);
        System.out.println(original);
    }
    
    /**
     *  Utility Method Only
     *  Validation
     */
    private void validate(int x, int y){
        if (x < 0 || y < 0){
            throw new IndexOutOfBoundsException("Array Length is " +arr.length+
                    ". x index "+x+" y index "+y+" out of bounds");
        }
        if (x > arr.length || y > arr.length){
            throw new IndexOutOfBoundsException("Array Length is " +arr.length+
                    ". x index "+x+" y index "+y+" out of bounds");
        }
    }
}
