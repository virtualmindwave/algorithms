package com.virtualmindwave.algorithms.dynamicconnectivity;
/*----------------------------------------------------------------
 *  Author:        virtualmindwave
 *  Written:       11/19/2016
 *
 *  This is my implementation of the Quick Find
 *  Algorithm for Dynamic Connectivity.
 *  
 *  
 *  
 *----------------------------------------------------------------*/
public class QuickFindUF {
    private int[] arr;
    
    /**
     *  Constructor that initializes array values
     */
    public QuickFindUF(int n){
        arr = new int[n];
        
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }

    /**
     *   
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
    
    public boolean connected(int x, int y){
        if(arr[x] == arr[y]){
            return true;
        }
        return false;
    }

    public void print(){
        for (int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
