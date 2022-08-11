package sop_corba;


/**
* sop_corba/ControladorCancionIntHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 19H40' CDT
*/

abstract public class ControladorCancionIntHelper
{
  private static String  _id = "IDL:sop_corba/ControladorCancionInt:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.ControladorCancionInt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.ControladorCancionInt extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sop_corba.ControladorCancionIntHelper.id (), "ControladorCancionInt");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.ControladorCancionInt read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ControladorCancionIntStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.ControladorCancionInt value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sop_corba.ControladorCancionInt narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.ControladorCancionInt)
      return (sop_corba.ControladorCancionInt)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._ControladorCancionIntStub stub = new sop_corba._ControladorCancionIntStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sop_corba.ControladorCancionInt unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sop_corba.ControladorCancionInt)
      return (sop_corba.ControladorCancionInt)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sop_corba._ControladorCancionIntStub stub = new sop_corba._ControladorCancionIntStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
