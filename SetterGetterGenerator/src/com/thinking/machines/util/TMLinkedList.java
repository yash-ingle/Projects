package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
public class TMNode<T>
{
private T data;
private TMNode<T> nextPtr;
public TMNode()
{
this.data=null;
this.nextPtr=null;
}
public void setData(T data)
{
this.data=data;
}
public T getData()
{
return this.data;
}
public void setNextPtr(TMNode<T> nextPtr)
{
this.nextPtr=nextPtr;
}
public TMNode<T> getNextPtr()
{
return this.nextPtr;
}
}
private TMNode<T> start;
private TMNode<T> end;
private int size;
public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public class TMLinkedListIterator<T> implements TMIterator<T>
{
private TMNode<T> ptr;
public TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=ptr.data;
ptr=ptr.nextPtr;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
}
public void add(T data)
{
TMNode<T> newNode=new TMNode<T>();
newNode.setData(data);
if(this.start==null)
{
this.start=newNode;
this.end=newNode;
}
else
{
this.end.setNextPtr(newNode);
this.end=newNode;
}
this.size++;
}
public void add(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> newNode=new TMNode<T>();
newNode.setData(data);
if(this.start==null)
{
this.start=newNode;
this.end=newNode;
}
else
{
if(index==0)
{
newNode.setNextPtr(this.start);
this.start=newNode;
this.size++;
return;
}
if(index==this.size) 
{
this.add(data);
return;
}
TMNode<T> tmpNode=start;
TMNode<T> p2p=tmpNode;
for(int i=0;i<index;i++) 
{
p2p=tmpNode;
tmpNode=tmpNode.getNextPtr();
}
p2p.setNextPtr(newNode);
newNode.setNextPtr(tmpNode);
}
this.size++;
}
public void insert(int index,T data)
{
this.add(index,data);
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
if(this.start==null) throw new NullPointerException("start : null");
else
{
if(index==0)
{
T data=this.start.getData();
this.start=this.start.getNextPtr();
this.size--;
return data;
}
TMNode<T> tmpNode=this.start;
TMNode<T> p2p=tmpNode;
for(int i=0;i<index;i++) 
{
p2p=tmpNode;
tmpNode=tmpNode.getNextPtr();
}
if(index==this.size-1)
{
T data=tmpNode.getData();
this.end=p2p;
this.end.setNextPtr(null);
this.size--;
return data;
}
T data=tmpNode.getData();
p2p.setNextPtr(tmpNode.getNextPtr());
this.size--;
return data;
}
}
public void removeAll()
{
this.start=null;
this.end=null;
this.size=0;
}
public void clear()
{
this.start=null;
this.end=null;
this.size=0;
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> tmpNode=start;
for(int i=0;i<index;i++) tmpNode=tmpNode.getNextPtr();
return tmpNode.getData();
}
public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
if(this.start==null) throw new NullPointerException("start : null");
else
{
if(index==0)
{
this.start.setData(data);
return;
}
TMNode<T> tmpNode=start;
for(int i=1;i<=index;i++) 
{
tmpNode=tmpNode.getNextPtr();
}
tmpNode.setData(data);
}
}
public void copyTo(TMList<T> other)
{
other.clear();
for(int i=0;i<this.size();i++) other.add(this.get(i));
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void appendTo(TMList<T> other)
{
for(int i=0;i<this.size();i++) other.add(this.get(i));
}
public void appendFrom(TMList<T> other)
{
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
for(TMNode<T> i=start;i!=null;i=i.nextPtr) a.accept(i.data);
}
}