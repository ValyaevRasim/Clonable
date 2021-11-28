import java.io.*;
/*
 * https://habr.com/ru/post/246993/
 *
 * виды глубокого копирования:
 * через переопределение метода Clone
 * через конструктор
 * через сериализацию
 */

public class DemoClone {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        Fatura fatura = new Fatura(1,"DepoOriginal",new Products("ProductNameOriginal","ProductMarkaOriginal"));

//        через клонирование. У объектов, на которые идет ссылка реализовать интерфейс Cloneable
        Fatura faturaClone = (Fatura) fatura.clone();
        faturaClone.setId(2);
        faturaClone.setSklad("DepoClone");
        Products products = faturaClone.getProducts();
        products.setMarka("ProductMarkaClone");
        products.setName("ProductNameClone");

//        через конструктор
        Fatura faturaCloneConstructor = new Fatura(fatura);
        faturaCloneConstructor.setId(3);
        faturaCloneConstructor.setSklad("DepoConstructor");
        faturaCloneConstructor.getProducts().setName("ProductNameConstructor");
        faturaCloneConstructor.getProducts().setMarka("ProductMarkaConstructor");

//        через сериализацию. У объектов, на которые идет ссылка реализовать интерфейс Serializable
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(fatura);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Fatura faturaCloneIO = (Fatura) ois.readObject();
        faturaCloneIO.setId(4);
        faturaCloneIO.setSklad("DepoIO");
        faturaCloneIO.getProducts().setName("ProductNameIO");
        faturaCloneIO.getProducts().setMarka("ProductMarkaIO");
        ois.close();

        System.out.println(fatura);
        System.out.println(faturaClone);
        System.out.println(faturaCloneConstructor);
        System.out.println(faturaCloneIO);
    }
}
