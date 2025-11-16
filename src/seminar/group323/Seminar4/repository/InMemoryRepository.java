package seminar.group323.Seminar4.repository;

import seminar.group323.Seminar4.domain.Entity;
import seminar.group323.Seminar4.exceptions.DuplicateIdException;
import seminar.group323.Seminar4.exceptions.ObjectNotFoundException;
import seminar.group323.Seminar4.repository.Repository;

import java.util.ArrayList;

public class InMemoryRepository<T extends Entity> implements Repository<T> {
    private final ArrayList<T> elements = new ArrayList<>();

    @Override
    public void addElement(T element) {
        if (exists(element.getId())) {
            throw new DuplicateIdException(element.getId());
        }
        elements.add(element);
    }

    @Override
    public boolean isIn(int id) {
        for (T e : elements) if (e.getId() == id) return true;
        return false;
    }

    @Override
    public void deleteElement(Integer id) {
        boolean removed = false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getId() == id) {
                elements.remove(i);
                removed = true;
                i--;
            }
        }
        if (!removed) {
            throw new ObjectNotFoundException(id);
        }
    }

    @Override
    public void deleteElement(T element) {
        boolean ok = elements.remove(element);
        if (!ok) throw new ObjectNotFoundException(element.getId());
    }

    @Override
    public ArrayList<T> getElements() {
        return elements;
    }

    @Override
    public T getById(int id) {
        for (T e : elements) if (e.getId() == id) return e;
        return null;
    }

    @Override
    public void updateElement(T newElement) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getId() == newElement.getId()) {
                elements.set(i, newElement);
                return;
            }
        }
        throw new ObjectNotFoundException(newElement.getId());
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public ArrayList<T> getAll() {
        return new ArrayList<>(elements);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public ArrayList<T> findByName(String name) {
        ArrayList<T> results = new ArrayList<>();
        for (T element : elements) {
            try {
                var method = element.getClass().getMethod("getName");
                String elementName = (String) method.invoke(element);
                if (elementName.equalsIgnoreCase(name)) results.add(element);
            } catch (Exception ignored) {
            }
        }
        return results;
    }

    @Override
    public boolean exists(int id) {
        return isIn(id);
    }

    @Override
    public String toString() {
        return "repository{elements=" + elements + '}';
    }
}
