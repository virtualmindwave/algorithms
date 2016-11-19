package com.virtualmindwave.algorithms.dynamicconnectivity;
/*----------------------------------------------------------------
 *  Author:        virtualmindwave
 *  Written:       11/19/2016
 *
 *  Test method for QuickFindUF algorithm
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
class QuickFindUFMain {
    public static void main(String args[]){
        QuickFindUF qf = new QuickFindUF(10);
        
        qf.union(1, 5);
        qf.union(2, 9);
        
        System.out.println(qf.connected(1, 5));
        System.out.println(qf.connected(1, 4));
        System.out.println(qf.connected(2, 9));
        System.out.println(qf.connected(3, 9));
        
        qf.print();
    }
}
