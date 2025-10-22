package seminar.group323.Seminar2.repository;

import seminar.group323.Seminar2.domain.Entity;

import java.util.ArrayList;

public class Repository<T extends Entity> {
    private ArrayList<T> elements;

    public Repository() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public boolean isIn(int id) {
        for (T element : elements) {
            if (id == element.getId()) {
                return true;
            }
        }
        return false;
    }

    public void deleteElement(Integer id) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getId() == id) {
                elements.remove(i);
                i--;
            }
        }
    }

    public void deleteElement(T element) {
        elements.remove(element);
    }

    public ArrayList<T> getElements() {
        return elements;
    }

    public T getById(int id) {
        for (T element : elements) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public void updateElement(T newElement) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getId() == newElement.getId()) {
                elements.set(i, newElement);
                return;
            }
        }
    }

    public int size() {
        return elements.size();
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(elements);
    }

    public void clear() {
        elements.clear();
    }

    public ArrayList<T> findByName(String name) {
        ArrayList<T> results = new ArrayList<>();
        for (T element : elements) {
            try {
                var method = element.getClass().getMethod("getName");
                String elementName = (String) method.invoke(element);
                if (elementName.equalsIgnoreCase(name)) {
                    results.add(element);
                }
            } catch (Exception ignored) {
            }
        }
        return results;
    }

    public boolean exists(int id) {
        return isIn(id);
    }

    @Override
    public String toString() {
        return "repository{" +
                "elements=" + elements +
                '}';
    }
}
