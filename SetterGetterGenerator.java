package com.thinking.machines.utils;
import java.lang.reflect.*;
import java.io.*;
public class SetterGetterGenerator
{
public static void main(String gg[])
{
if(gg.length!=1 && gg.length!=2)
{
System.out.println("Usage: java -classpath path_to_jar_file;. com.thinking.machines.utils.SetterGetterGenerator class_name constructor=true/false");
return;
}
String className=gg[0];
if(gg.length==2)
{
if(gg[1].equalsIgnoreCase("constructor=true")==false && gg[1].equalsIgnoreCase("constructor=false")==false )
{
System.out.println("Usage: java -classpath path_to_jar_file;. com.thinking.machines.utils.SetterGetterGenerator class_name constructor=true/false");
return;
}
}
try
{
Class c=Class.forName(className);
Field fields[]=c.getDeclaredFields();
Field field;
TMList <String> list=new tmArrayList<String>();
String setterName;
String getterName;
String tmp;
String fieldName;
String line;
Class fieldType;
if(gg.length==1 || (gg.length==2 &&gg[1].equalsIgnoreCase("constructor=true")))
{
line="public " +c.getSimpleName()+"()";
list.add(line);
list.add("{");
for(int f=0;f<fields.length;f++)
{
field=fields[f];
line="this."+field.getName()+"="+getDefaultValue(field.getType())+";";
list.add(line);
}
list.add("}");
}
for(int e=0;e<fields.length;e++)
{
field=fields[e];
fieldName=field.getName();
fieldType=field.getType();
if(fieldName.charAt(0)>=97 && fieldName.charAt(0)<=122)
{
tmp=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
}
else
{
tmp=fieldName;
}
setterName="set"+tmp;
getterName="get"+tmp;
line="public void "+setterName+"("+fieldType.getName()+" "+fieldName+")";
list.add(line);
list.add("{");
line="this."+fieldName+"="+fieldName+";";
list.add(line);
list.add("}");
line="public "+fieldType.getName()+" "+getterName+"()";
list.add(line);
list.add("{");
line="return this."+fieldName+";";
list.add(line);
list.add("}");
}
File file=new File("tmp.tmp");
if(file.exists()) file.delete();
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
TMIterator<String>iterator=list.Iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line+"\r\n");
}
randomAccessFile.close();
System.out.println("setter/getter for:"+c.getName()+"generated in folder tmp.tmp");
}catch(ClassNotFoundException classnotFoundException)
{
System.out.println("unable to load this class");
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
public static String getDefaultValue(Class c)
{
String className=c.getName();
if(className.equals("java.lang.long")||className.equals("long")) return "0";
if(className.equals("java.lang.Integer")||className.equals("int")) return "0";
if(className.equals("java.lang.Short")||className.equals("short")) return "0";
if(className.equals("java.lang.Byte")||className.equals("byte")) return "0";
if(className.equals("java.lang.Double")||className.equals("double")) return "0.0";
if(className.equals("java.lang.Float")||className.equals("float")) return "0.0";
if(className.equals("java.lang.Character")||className.equals("char")) return " ";
if(className.equals("java.lang.Boolean")||className.equals("boolean")) return "false";
if(className.equals("java.lang.String")) return "\"\"" ;
return null;
}
}