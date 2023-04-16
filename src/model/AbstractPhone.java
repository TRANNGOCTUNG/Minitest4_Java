package model;

import java.util.ArrayList;

public abstract class AbstractPhone implements IPhone {
    protected ArrayList<Concat> arrayList = new ArrayList<Concat>();
    public abstract void display(Type type);
    public abstract void insertPhone(Concat concat);
    public abstract void removePhone(String name);
    public abstract void updatePhone(String name,String newPhone);

}
