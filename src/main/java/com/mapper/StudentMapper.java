package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.StudentDTO;
import com.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);  

	@Mapping(source = "major.name", target = "major_name")
    @Mapping(source = "educationProgram.name", target = "educationProgram_name")
    @Mapping(source = "studyHistories", target = "studyHistories")
    @Mapping(source = "notes", target = "notes")
	@Mapping(source = "enterSchool", target = "enter_school")
    StudentDTO toDTO(Student student);  
//    
//    @Mapping(source = "major_name", target = "major.id")
//    @Mapping(source = "semester_id", target = "semester.semester")
//    @Mapping(source = "year_id", target = "year.year")
//    @Mapping(source = "educationProgram_id", target = "educationProgram.id")
    @Mapping(source = "avatar", target = "avatar" )
    Student toEntity(StudentDTO studentDTO);  

    List<StudentDTO> toDTOList(List<Student> students);  
    
    List<Student> toEntityList(List<StudentDTO> studentDTOs);
}
