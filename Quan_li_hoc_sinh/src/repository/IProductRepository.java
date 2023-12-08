package repository;

import model.Student;
import java.util.List;

public interface IProductRepository {
    List<Student> getList();

    void addStudent(Student product);

    void editById(int idEdit);

    void deleteById(List<String> stringList);

}
