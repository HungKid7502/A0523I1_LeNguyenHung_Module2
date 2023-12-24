package repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getList();
    void add(T obj);

//    void editById();
}
