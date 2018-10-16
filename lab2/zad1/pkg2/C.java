package pkg2;
import pkg1.B;

public class C extends B{

    public C(int _number, String _name) {
        super(_number, _name);
    }

    void changeName(String s) {
        s+=" C";
        callChangeName(s);
    }
}