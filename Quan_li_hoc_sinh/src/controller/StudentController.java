package controller;

import service.IStudentService;
import service.impl.StudentService;

public class StudentController {
    private IStudentService productService = new StudentService();

    public void display() {
        productService.display();
    }

    public void addStudent() {
        productService.addStudent();
    }

    public void editById(int id) {
        productService.editById(id);
    }

    public void deleteById(int idDel) {
        productService.deleteById(idDel);
    }

    public void findByName(String nameFind) {
      productService.findByName(nameFind);
    }
}
