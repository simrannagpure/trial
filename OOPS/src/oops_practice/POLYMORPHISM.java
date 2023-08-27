package oops_practice;

public class POLYMORPHISM extends Math{
    int poly = 123;
    int flatId = 102;
    boolean lift = true;
    @Override
    public int add(int a, int b){
        return (a+b)/2;
    }
    public int polysub(int a, int b){

        return a-b;
    }
    public static void main(String[] args){
        //parent - parents combination
        Math math = new Math();
        System.out.println(math.add(5, 10));
        System.out.println(math.sub(9, 7));
        System.out.println(math);

        //child child combination
        POLYMORPHISM xyz = new POLYMORPHISM();
        System.out.println(xyz.polysub(8,2));
        System.out.println(xyz.flatId);

        //parent child combination
        Math pqr = new POLYMORPHISM();
        System.out.println(pqr.flatId);
        System.out.println(pqr.add(8,6)); //overidden in polymorphism class

        //child parent combination (not possible)
       // oops_practice.POLYMORPHISM lmn = new oops_practice.Math();
       // System.out.println(lmn.flatId);
    }
}
