import java.util.List;

public interface IAnimalHelper {

    Animal create(Animal animal);

    Animal read(long id);

    void update(Animal animal);

    void delete(Animal animal);

    List<Animal> getAll();
}
