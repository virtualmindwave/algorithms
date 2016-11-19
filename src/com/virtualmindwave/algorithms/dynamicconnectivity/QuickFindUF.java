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
 *  [0][5][2][3][4][5][6][7][8][9]
 *  connected(1, 5) - this will check if 1 and 5 is connected
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
     *  To link the arrays method will need to assign the element   
     *  arr[x] to arr[y] everytime.
     *  This will also check every element and will assign to 
     *  all other element linked before.
     *  
     */
    public void union(int x, int y){
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
        if(arr[x] == arr[y]){
            return true;
        }
        return false;
    }

    /**
     *  Sample print output to check elements
     */
    public void print(){
        for (int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
