package com.virtualmindwave.algorithms.dynamicconnectivity;
/*----------------------------------------------------------------
 *  Author:        virtualmindwave
 *  Written:       11/19/2016
 *
 *  Implementation of the Quick Find Algorithm 
 *  for Dynamic Connectivity.
 *  
 *  usage: Generate array of integers
 *  n = 10
 *  [0][1][2][3][4][5][6][7][8][9]
 *  
 *  union(1, 5) - this will link 1 and 5
 *  result = [0][5][2][3][4][5][6][7][8][9]
 *  connected(1, 5) = true = this will check if 1 and 5 is connected
 *  
 *----------------------------------------------------------------*/
public class QuickFindUF {
    private int[] arr;
    
    /**
     *  Constructor that initializes sample array values n
     */
    public QuickFindUF(int n){
        arr = new int[n];
        
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }

    /**
     *  To link the elements, this will always change x to y.
     *  This will also check every element and will assign to 
     *  all other element linked before.
     */
    public void union(int x, int y){
        validate(x, y);
        int oldId = arr[x];
        int newId = arr[y];
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == oldId){
                arr[i] = newId;
            }
        }

    }
    
    /**
     *  Will check if elements are connected
     */
    public boolean connected(int x, int y){
        validate(x, y);
        if(arr[x] == arr[y]){
            return true;
        }
        return false;
    }
    
    /**
     *  Test method for QuickFindUF algorithm
     */
    public static void main(String args[]){
        QuickFindUF qf = new QuickFindUF(10);
        
        qf.union(1, 5);
        qf.union(2, 9);
        
        qf.print();
        
        System.out.println(qf.connected(1, 5));
        System.out.println(qf.connected(1, 4));
        System.out.println(qf.connected(2, 9));
        System.out.println(qf.connected(3, 9));
        
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

    /**
     *  Utility Method Only
     *  Test print output to check elements
     */
    public void print(){
        StringBuffer original = new StringBuffer();
        StringBuffer connected = new StringBuffer();
        for (int i=0; i < arr.length; i++){
            original.append("["+i+"]");
            if(i+1 == arr.length) original.append("\n");
            connected.append(" " + arr[i] + " ");
        }
        original.append(connected);
        System.out.println(original);
    }
}
