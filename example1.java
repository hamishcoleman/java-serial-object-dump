public class BasicSerializableClass
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int ival;
    private String sval;

    public BasicSerializableClass(int i, String s)
    {
        ival = i;
        sval = s;
    }

    public int getIval()
    {
        return ival;
    }

    public String getSval()
    {
        return sval;
    }
}

public static void main(String[] argv)
throws Exception
{
    File tmpFile = File.createTempFile("example", ".ser");
    tmpFile.deleteOnExit();

    BasicSerializableClass orig = new BasicSerializableClass(123, "Hello, World");

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmpFile));
    oos.writeObject(orig);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tmpFile));
    BasicSerializableClass rslt = (BasicSerializableClass)ois.readObject();
    ois.close();

    System.out.println("result.ival = " + rslt.getIval());
    System.out.println("result.sval = " + rslt.getSval());
}

