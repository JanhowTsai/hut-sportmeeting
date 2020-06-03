public class Dog {
    private String name = "xxx";
    private Dog dog = new Dog();

    public void add(){
        add();
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
