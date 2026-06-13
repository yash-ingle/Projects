import com.thinking.machines.util.*;
class ForEachTestCase
{
public static void main(String gg[])
{
TMLinkedList list=new TMLinkedList();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.forEach((x)->{System.out.println(x);});
}
}