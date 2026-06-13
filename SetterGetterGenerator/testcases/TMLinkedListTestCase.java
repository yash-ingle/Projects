import com.thinking.machines.util.*;
class TMLinkedListTestCase
{
public static void main(String gg[])
{
/*
TMLinkedList list=new TMLinkedList();
System.out.println("Size : "+list.size());
for(int i=0;i<22;i++) list.add(i+1);
list.add(12,1113);
list.insert(0,22);

System.out.println("List Data");
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize (After elements added) : "+list.size());

list.update(2,2102003);
System.out.println("\nList after updating data at 2nd index");
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize (After updation) : "+list.size());

System.out.println("\nList after removing data at 2nd index");
System.out.println("Removed element : "+list.removeAt(2));
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize (After removal) : "+list.size());

System.out.println("\nList after clearing");
list.clear();
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize (After clearing) : "+list.size());

System.out.println("\nSize of list 1 (before adding element) : "+list.size());
for(int i=0;i<22;i++) list.add(i+1);
TMLinkedList list2=new TMLinkedList();
System.out.println("Size of list 2 (before adding element) : "+list2.size());
for(int i=0;i<22;i++) list2.add(i*10);
System.out.println("List 1 Data");
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize of list 1 : "+list.size());
System.out.println("List 2 Data");
for(int i=0;i<list2.size();i++) System.out.print(list2.get(i)+" ");
System.out.println("\nSize of list 2 : "+list2.size());

System.out.println("\nAppending list 1 to list 2");
list.appendTo(list2); // list2.appendFrom(list);
System.out.println("List 2 Data (After Appending list 1)");
for(int i=0;i<list2.size();i++) System.out.print(list2.get(i)+" ");
System.out.println("\nSize of list 2 : "+list2.size());
System.out.println("List 1 Data");
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize of list 1 : "+list.size());

System.out.println("\nCopying list 1 to list 2");
list.copyTo(list2); // list2.copyFrom(list);
System.out.println("List 2 Data (After copying list 1)");
for(int i=0;i<list2.size();i++) System.out.print(list2.get(i)+" ");
System.out.println("\nSize of list 2 : "+list2.size());
System.out.println("List 1 Data");
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("\nSize of list 2 : "+list.size());
list.removeAll();
list2.clear();
*/
TMLinkedList list=new TMLinkedList();
System.out.println("Size : "+list.size());
list.add(20);
list.add(10);
list.add(10);
list.add(10);
System.out.println("Size : "+list.size());
for(int i=0;i<list.size();i++) System.out.println(list.get(i));
System.out.println("Size : "+list.size());
System.out.println("Removed : "+list.removeAt(0));
for(int i=0;i<list.size();i++) System.out.println(list.get(i));
System.out.println("Size : "+list.size());
}
}