import java.io.Serializable;

public class Fatura implements Cloneable, Serializable {
    private int id;
    private String sklad;
    private Products products;

    Fatura(int id, String sklad, Products products){
        this.id = id;
        this.sklad = sklad;
        this.products = products;
    }

    /**
     * Конструктор копирования.
     *
     * @param otherFatura
     */
    // НЕглубокое копирование через конструктор
//    public Fatura(Fatura otherFatura) {
//        this(otherFatura.getId(), otherFatura.getSklad(), otherFatura.getProducts());
//    }

    // глубокое копирование через конструктор
    public Fatura(Fatura otherFatura)  throws CloneNotSupportedException {
        this(otherFatura.getId(), otherFatura.getSklad(), new Products(otherFatura.products));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSklad() {
        return sklad;
    }

    public void setSklad(String sklad) {
        this.sklad = sklad;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "id=" + id +
                ", sklad='" + sklad + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        используется если примитив или неизменный объект (Н: String)
//        return super.clone();

//        используется если есть ссылка на другие объекты
        Fatura fatura = (Fatura) super.clone();
        Products products = (Products) this.getProducts().clone();
        fatura.setProducts(products);
        return fatura;
    }
}