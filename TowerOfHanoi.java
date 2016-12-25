package stack;

import java.lang.reflect.Array;

class Tower<E> extends stack<E>{
    stack<Integer> disks;

    Tower(int ndisks){
        disks = new stack<>();
    }
}

class TowerOfHanoi{ 
    int n;
    Tower[] towers;
    
    TowerOfHanoi(int disks, int sourceTower) throws FullStackException{ 
        n = disks;
        towers = (Tower[])Array.newInstance(Tower.class, 3);
        for(int i=0;i<towers.length;++i)towers[i] = new Tower(n);
        for(int i=disks;i>=1;--i)towers[sourceTower].disks.push(i);
    }
    
    void move(int disks, Tower source, Tower destination, Tower buffer) throws FullStackException, EmptyStackException{
        if(disks==1)destination.disks.push(source.disks.pop());
        else{
            move(disks-1, source, buffer, destination); 
            destination.disks.push(source.disks.pop());
            move(disks-1, buffer, destination, source);
        }
    }
    
    void move(int source, int buffer, int destination) throws FullStackException, EmptyStackException{
        if(towers[source].disks.isEmpty()) System.out.println("Empty");
        else move(n, towers[source], towers[destination], towers[buffer]);
    }

    public static void main(String[] args) throws FullStackException, EmptyStackException{
    	TowerOfHanoi toh = new TowerOfHanoi(4, 0);
  // System.out.println("Show the stack");
       
          
        
        toh.move(0, 1, 2);
        System.out.println("After the operation");
        while(!toh.towers[2].disks.isEmpty()){
            System.out.println(toh.towers[2].disks.pop());
        }
    }
}