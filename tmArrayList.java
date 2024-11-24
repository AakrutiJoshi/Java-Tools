package com.thinking.machines.utils;
public class  tmArrayList<T> implements TMList<T>
{
private Object[]Collection;
private static int size;
public class TMArrayListIterator<T> implements TMIterator<T>
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return this.index!=size;
}
public T next()
{
if(index==size) throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)get(index);
index++;
return data;
}
}
public TMIterator<T> Iterator()
{
return new TMArrayListIterator<T>();
}
public tmArrayList()
{
Collection=new Object[10];
size=0;
}
public void add(T data)
{
int length=Collection.length;
if(size==length)
{
Object[]tmp;
tmp=new Object[this.size+10];
for(int e=0; e<this.size;e++) tmp[e]=this.Collection[e];
this.Collection=tmp;
}
this.Collection[this.size]=data;
this.size++;
}
public void add(int index,T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("invalid index:"+index);
int length=Collection.length;
if(this.size==length)
{
Object[]tmp;
tmp=new Object[this.size+10];
for(int e=0; e<this.size;e++) tmp[e]=this.Collection[e];
this.Collection=tmp;
}
for(int e=this.size;e>index;e--)this.Collection[e]=this.Collection[e-1];
this.Collection[index]=data;
this.size++;
}
public void insert(int index,T data)
{
add(index,data);
}
public T removeAt(int index)
{
if(index>size || index<0 ) throw new IndexOutOfBoundsException("Invalid index:"+index);
if(index==0 && size==1)
{
T data=(T)Collection[index];
Collection[index]=0;
return data;
}
T data=(T)this.Collection[index];
int ep=this.size-2;
for(int e=index;e<=ep;e++) this.Collection[e]=this.Collection[e+1];
this.size--;
return data;
}
public void clear()
{
this.size=0;
}
public void removeAll()
{
clear();
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
if(index<0 || index>size) throw new IndexOutOfBoundsException("invalid index:"+index);
return (T)this.Collection[index];
}
public void getAll()
{
for(int e=0;e<size;e++)
{
System.out.println(Collection[e]);
}
}
public void update(int index,T data)
{
if(index<0 || index>size) throw new IndexOutOfBoundsException("invalid index:"+index);
this.Collection[index]=data;
}

public void copyTo(TMList<T> other)
{
other.clear();
for(int e=0; e<=this.size;e++) other.add(this.get(e));
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int e=0; e<=other.size();e++) this.add(other.get(e));
}
public void appendTo(TMList<T> other)
{
for(int e=0; e<=this.size;e++) other.add(this.get(e));
}
public void appendFrom(TMList<T> other)
{
for(int e=0; e<=other.size();e++) this.add(other.get(e));
}
public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
for(int e=0;e<this.size;e++)
{
a.accept((T)Collection[e]);
}
}

}