import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper implements IAnimalHelper {
    EntityManagerFactory emf;
    EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("hibernate_jpa");
    }

    @Override
    public Animal create(Animal animal) {
        System.out.println("\nStart of CREATE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
        em.close();
        System.out.println("End of CREATE...");
        return animal;
    }

    @Override
    public Animal read(long id) {
        System.out.println("\nStart of READ...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        em.close();
        System.out.println("End of READ...");
        return animal;
    }

    @Override
    public void update(Animal animal) {
        System.out.println("\nStart of UPDATE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
        System.out.println("End of UPDATE...");
    }

    @Override
    public void delete(Animal animal) {
        System.out.println("\nStart of DELETE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(animal) ? animal : em.merge(animal));
        em.getTransaction().commit();
        em.close();
        System.out.println("End of DELETE...");
    }

    @Override
    public List<Animal> getAll() {
        System.out.println("\nStart of GET ALL...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animals FROM Animal animals");
        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();
        em.close();
        System.out.println("End of GET ALL...");
        return animals;
    }
}
