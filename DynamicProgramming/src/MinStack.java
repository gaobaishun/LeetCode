import java.util.ArrayList;
import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> sv;
    //private LinkedList<Integer> si;
    private int minIndex;
    /** initialize your data structure here. */
    public MinStack() {
        sv=new LinkedList<>();
        minIndex=0;
    }

    public void push(int x) {
//        int size=sv.size();
//        if(size==0){
//            sv.add(x);
//            si.addLast(0);
//        }
//        while(size>0){
//
//
//            if(x<sv.get(size-1)){
//                if(size-1==0){
//                    sv.addFirst(x);
//                    si.addLast(size-1);
//                    for (int i=0;i<si.size()-1;i++){
//                        si.set(i,si.get(i)+1);
//                    }
//                    break;
//                }
//                size--;
//            }else{
//                sv.add(size,x);
//                si.addLast(size);
//                for (int i = 0; i < si.size(); i++) {
//                    if (si.get(i) > size)
//                        si.set(i, si.get(i) + 1);
//                }
//                break;
//            }
//        }
        sv.addLast(x);
        if(x<sv.get(minIndex)){
            minIndex=sv.size()-1;
        }
    }

//    public void push2(int x){
//        int size=sv.size();
//        if(size==0){
//            sv.addFirst(x);
//        }
//        while(size>=0){
//            if(sv.get(size-1)>=x){
//
//            }else{
//
//            }
//        }
//    }

    public void pop() {

        if(minIndex==sv.size()-1){
            minIndex=0;
            for(int i=1;i<sv.size()-1;i++){
                if(sv.get(i)<sv.get(minIndex)){
                    minIndex=i;
                }
            }
        }
        sv.removeLast();
    }

    public int top() {

        return sv.getLast();
    }

    public int getMin() {

        return sv.get(minIndex);
    }

    public static void main(String[] args){
        LinkedList<Integer> list=new LinkedList<>();
        //list.a
        //list.set(0,0);
        MinStack stack=new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        System.out.println("sss");
    }
}
