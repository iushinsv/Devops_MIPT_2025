package studentls.service.mapper;

import studentls.api.Student;
import studentls.api.CreateStudentRequest;
import studentls.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface StudentMapper {

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "major", source = "major")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    StudentEntity extractStudentEntity(CreateStudentRequest student);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "major", source = "major")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    Student toStudentDto(StudentEntity studentEntity);

    List<Student> toStudentDtoList(List<StudentEntity> studentEntityList);
}
