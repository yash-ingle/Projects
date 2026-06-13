import com.thinking.machines.util.*;
class psp
{
public static void main(String gg[])
{
TMArrayList<Integer> list1=new TMArrayList<Integer>();
list1.add(100);
list1.add(200);
list1.add(300);
list1.add(400);
list1.add(500);
list1.forEach((x)->{System.out.println(x);});
TMLinkedList<String> list2=new TMLinkedList<String>();
list2.add("Ujjain");
list2.add("Indore");
list2.add("Pune");
list2.add("Goa");
list2.forEach((x)->{System.out.println(x);});
}
}