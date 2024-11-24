package com.thinking.machines.utils;
public class tmLinkedList<T> implements TMList<T>
{
class  TMNode<T>
{
T data;
TMNode<T> next;
TMNode()
{
this.data=null;
this.next=null;
}
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
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}
public TMIterator<T> Iterator()
{
return new TMLinkedListIterator<T>(this.start);
}
TMNode<T> start,end;
int size;
public tmLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public void add(T data)
{
TMNode<T> t=new TMNode<T>();
t.data=data;
t.next=null;
if(start==null)
{
this.start=t;
this.end=t;
}
else
{
this.end.next=t;
this.end=t;
}
this.size++;
}
public void add(int index,T data)
{
if(index<0) throw new ArrayIndexOutOfBoundsException("invalid index:"+index);
TMNode<T> t=new TMNode<T>();
t.data=data;
t.next=null;
if(index>=size)
{
add(data);
return;
}
if(start==null)
{
this.start=t;
this.end=t;
}else if(index==0)
{
t.next=start;
this.start=t;
}
else
{
TMNode<T> j,k;
int i=0;
j=this.start;
k=null;
while(i<index)
{
k=j;
j=j.next;
i++;
}
k.next=t;
t.next=j;
}
this.size++;
}
public void insert(int index,T data)
{
add(index,data);
}
public T removeAt(int index)
{
if(index<0||index>size) throw new ArrayIndexOutOfBoundsException("invalid index:"+index);
T tdata;
if(start==end)
{
tdata=this.start.data;
this.start=null;
this.end=null;
this.size=0;
return tdata;
}if(index==0)
{
tdata=this.start.data;
this.start=this.start.next;
this.size--;
return tdata;
}
TMNode<T> j,k;
int i=0;
j=this.start;
k=null;
while(i<index)
{
k=j;
j=j.next;
i++;
}
tdata=j.data;
k.next=j.next;
if(this.end==j) this.end=k;
this.size--;
return tdata;
}
public void removeAll()
{
this.start=null;
this.end=null;
this.size=0;
}
public void clear()
{
removeAll();
}

public int getSize()
{
return this.size;
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0||index>size) throw new ArrayIndexOutOfBoundsException("invalid index:"+index);
TMNode<T> j=start;
int i=0;
while(i<index)
{
j=j.next;
i++;
}
return j.data;
}
public void getAll()
{
TMNode<T> j=start;
for(int e=0;e<size;e++)
{
System.out.println(j.data);
j=j.next;
}
}
public void update(int index,T data)
{
if(index<0||index>size) throw new ArrayIndexOutOfBoundsException("invalid index:"+index);
if(index==0)
{
this.start.data=data;
return;
}if(index==size-1)
{
this.end.data=data;
return;
}
TMNode<T> j=start;
int i=0;
while(i<index)
{
j=j.next;
i++;
}
j.data=data;
}
public void copyTo(TMList<T> other)
{
other.clear();
for(int e=0;e<this.size;e++) other.add(this.get(e));
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int e=0;e<other.size();e++) this.add(other.get(e));
}
public void appendTo(TMList<T> other)
{
for(int e=0;e<this.size;e++) other.add(this.get(e));
}
public void appendFrom(TMList<T> other)
{
for(int e=0;e<other.size();e++) this.add(other.get(e));
}
public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
TMNode <T>t;
for(t=start;t!=null;t=t.next)
{
a.accept(t.data);
}
}
}