class parent implements Serializable {
    int parentVersion = 10;
}

class contain implements Serializable{
    int containVersion = 11;
}
public class SerialTest extends parent implements Serializable {
    int version = 66;
    contain con = new contain();

    public int getVersion() {
        return version;
    }
    public static void main(String args[]) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SerialTest st = new SerialTest();
        oos.writeObject(st);
        oos.flush();
        oos.close();
    }
}

