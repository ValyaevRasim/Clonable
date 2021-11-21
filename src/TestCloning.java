//https://howtodoinjava-com.translate.goog/java/cloning/a-guide-to-object-cloning-in-java/?_x_tr_sl=en&_x_tr_tl=ru&_x_tr_hl=ru&_x_tr_pto=nui

public class TestCloning
{

    public static void main(String[] args) throws CloneNotSupportedException
    {
        Department dept = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", dept);
        Employee cloned = (Employee) original.clone();
        cloned.getDepartment().setName("Finance");
        System.out.println(original.getDepartment().getName());
        System.out.println(cloned.getDepartment().getName());

        /*
        // 3 типа сравнения клона и оригинала
        System.out.println(original != cloned);
        System.out.println(original.getClass() == cloned.getClass());
        System.out.println(original.equals(cloned));
        */
    }
}