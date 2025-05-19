package studentls.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class GetStudentListResult {

    @JsonProperty("students")
    @NotNull
    private List<Student> students;


    public GetStudentListResult(List<Student> students) {
        this.students = students;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
