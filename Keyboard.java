package com.thinking.machines.utils;
import java.io.*;
public class Keyboard
{
private BufferedReader bufferedReader;
public Keyboard()
{
bufferedReader=new BufferedReader(new InputStreamReader(System.in));
}
public String getString()
{
String str;
try
{
str=bufferedReader.readLine();
}catch(IOException ioException)
{
str="";
}
return str;
}
public String getString(String message)
{
System.out.println(message);
return getString();
}
public char getCharacter()
{
return getString().charAt(0);
}
public char getCharacter(String message)
{
System.out.println(message);
return getCharacter();
}
public long getLong()
{
long l;
try
{
l=Long.parseLong(getString());
}catch(NumberFormatException nfe)
{
l=0;
}
return l;
}
public long getLong(String message)
{
System.out.println(message);
return getLong();
}
public int getInteger()
{
int i;
try
{
i=Integer.parseInt(getString());
}catch(NumberFormatException nfe)
{
i=0;
}
return i;
}
public int getInteger(String message)
{
System.out.println(message);
return getInteger();
}
public short getShort()
{
Short s;
try
{
s=Short.parseShort(getString());
}catch(NumberFormatException nfe)
{
s=0;
}
return s;
}
public short getShort(String message)
{
System.out.println(message);
return getShort();
}
public Byte getByte()
{
byte b;
try
{
b=Byte.parseByte(getString());
}catch(NumberFormatException nfe)
{
b=0;
}
return b;
}
public byte getByte(String message)
{
System.out.println(message);
return getByte();
}
public double getDouble()
{
double d;
try
{
d=Double.parseDouble(getString());
}catch(NumberFormatException nfe)
{
d=0;
}
return d;
}
public double getDouble(String message)
{
System.out.println(message);
return getDouble();
}
public float getFloat()
{
float f;
try
{
f=Float.parseFloat(getString());
}catch(NumberFormatException nfe)
{
f=0;
}
return f;
}
public float getFloat(String message)
{
System.out.println(message);
return getFloat();
}
public boolean getBoolean()
{
boolean boo;
try
{
boo=Boolean.parseBoolean(getString());
}catch(NumberFormatException nfe)
{
boo=false;
}
return boo;
}
public boolean getBoolean(String message)
{
System.out.println(message);
return getBoolean();
}

}
