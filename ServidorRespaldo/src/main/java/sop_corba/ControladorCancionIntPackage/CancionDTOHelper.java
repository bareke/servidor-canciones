package sop_corba.ControladorCancionIntPackage;


/**
* sop_corba/ControladorCancionIntPackage/CancionDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 19H40' CDT
*/

abstract public class CancionDTOHelper
{
  private static String  _id = "IDL:sop_corba/ControladorCancionInt/CancionDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.ControladorCancionIntPackage.CancionDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.ControladorCancionIntPackage.CancionDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "artista",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "titulo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[3] = new org.omg.CORBA.StructMember (
            "tamKB",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_octet);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (sop_corba.ControladorCancionIntPackage.flujoBytesHelper.id (), "flujoBytes", _tcOf_members0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "audio",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.ControladorCancionIntPackage.CancionDTOHelper.id (), "CancionDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.ControladorCancionIntPackage.CancionDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.ControladorCancionIntPackage.CancionDTO value = new sop_corba.ControladorCancionIntPackage.CancionDTO ();
    value.id = istream.read_long ();
    value.artista = istream.read_string ();
    value.titulo = istream.read_string ();
    value.tamKB = istream.read_long ();
    value.audio = sop_corba.ControladorCancionIntPackage.flujoBytesHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.ControladorCancionIntPackage.CancionDTO value)
  {
    ostream.write_long (value.id);
    ostream.write_string (value.artista);
    ostream.write_string (value.titulo);
    ostream.write_long (value.tamKB);
    sop_corba.ControladorCancionIntPackage.flujoBytesHelper.write (ostream, value.audio);
  }

}
