package studentls.resource;

import studentls.api.GetStudentListResult;
import studentls.api.CreateStudentRequest;
import studentls.api.common.BaseResponse;
import studentls.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class StudentResource {

    private final StudentService studentService;


    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(
            value = "/createStudent",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public BaseResponse<Void> createStudent(
            @RequestBody @Valid
            CreateStudentRequest createStudentRequest
    ) {
        studentService.createStudent(createStudentRequest);
        return BaseResponse.wrap(null);
    }

    @GetMapping(
            value = "/getStudentList",
            produces = APPLICATION_JSON_VALUE
    )
    public BaseResponse<GetStudentListResult> getStudentList() {
        return BaseResponse.wrap(studentService.getStudentList());
    }
}
