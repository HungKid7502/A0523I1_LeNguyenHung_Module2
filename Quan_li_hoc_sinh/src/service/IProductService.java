package service;

public interface IProductService {
    void display();

    void addStudent();

    void editById(int id);

    void deleteById(int idDel);

    void findByName(String nameFind);
}
