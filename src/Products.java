import java.io.Serializable;

public class Products implements Cloneable, Serializable {
    private String name;
    private String marka;

    Products(String name, String marka){
        this.name = name;
        this.marka = marka;
    }

//    для глубокого копирование
    Products(Products products) {
        this(products.getName(), products.getMarka());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", marka='" + marka + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Products) super.clone();
    }
}
