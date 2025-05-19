package studentls.service;

import studentls.api.GetStudentListResult;
import studentls.api.Student;
import studentls.api.CreateStudentRequest;
import studentls.entity.StudentEntity;
import studentls.repository.StudentRepository;
import studentls.service.mapper.StudentMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @Transactional
    public void createStudent(CreateStudentRequest createStudentRequest) {
        StudentEntity newStudent = studentMapper.extractStudentEntity(createStudentRequest);
        studentRepository.save(newStudent);
    }

    @Transactional
    public GetStudentListResult getStudentList() {
        List<Student> studentList = studentMapper.toStudentDtoList(studentRepository.findAll());
        return new GetStudentListResult(studentList);
    }
}
