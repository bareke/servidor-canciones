package sop_corba;

/**
* sop_corba/ControladorCancionIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* mi�rcoles 10 de agosto de 2022 19H40' CDT
*/

public final class ControladorCancionIntHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ControladorCancionInt value = null;

  public ControladorCancionIntHolder ()
  {
  }

  public ControladorCancionIntHolder (sop_corba.ControladorCancionInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ControladorCancionIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ControladorCancionIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ControladorCancionIntHelper.type ();
  }

}
