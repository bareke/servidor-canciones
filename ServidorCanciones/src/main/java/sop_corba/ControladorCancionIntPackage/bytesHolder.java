package sop_corba.ControladorCancionIntPackage;


/**
* sop_corba/ControladorCancionIntPackage/bytesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mi�rcoles 10 de agosto de 2022 19H40' CDT
*/

public final class bytesHolder implements org.omg.CORBA.portable.Streamable
{
  public byte value[] = null;

  public bytesHolder ()
  {
  }

  public bytesHolder (byte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ControladorCancionIntPackage.bytesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ControladorCancionIntPackage.bytesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ControladorCancionIntPackage.bytesHelper.type ();
  }

}