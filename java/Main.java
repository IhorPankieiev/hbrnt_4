public class Main {
    public static void main(String[] args) {
        AnimalHelper ah = new AnimalHelper();
        Animal animal = new Animal();
        animal.setAge(11);
        animal.setName("Dog");
        animal.setTail(true);
//        ah.create(animal);
//        ah.read(2);
//        ah.update(animal);
//        ah.delete(animal);
        ah.getAll();
    }
}
