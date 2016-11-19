package com.virtualmindwave.algorithms.dynamicconnectivity;

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
