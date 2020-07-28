package br.com.springboot.endpoint;

import br.com.springboot.error.NotFoundError;
import br.com.springboot.model.Student;
import br.com.springboot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    @Autowired
    private DateUtil dateUtil;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student student = new Student();
        student.setId(id);

        System.out.println(student.getId());

        int index = Student.studentList.indexOf(student);

        if(index == -1) {
            return new ResponseEntity<>(new NotFoundError("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }
}
