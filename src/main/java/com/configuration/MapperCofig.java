package com.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mapper.AdminMapper;
import com.mapper.ApplyForMapper;
import com.mapper.AreaMapper;
import com.mapper.BelongMapper;
import com.mapper.BlockMapper;
import com.mapper.ClazzMapper;
import com.mapper.EducationProgramMapper;
import com.mapper.InstructorMapper;
import com.mapper.MajorMapper;
import com.mapper.MarkMapper;
import com.mapper.NoteMapper;
import com.mapper.NoteTypeMapper;
import com.mapper.NotificationMapper;
import com.mapper.RegisterMapper;
import com.mapper.RoomMapper;
import com.mapper.ScheduleMapper;
import com.mapper.School_YearMapper;
import com.mapper.SemesterMapper;
import com.mapper.ShiftMapper;
import com.mapper.SpecializationMapper;
import com.mapper.StudentMapper;
import com.mapper.StudyHistoryMapper;
import com.mapper.StudyInMapper;
import com.mapper.SubjectMapper;
import com.mapper.TeachForMapper;
import com.mapper.WeekDayMapper;

@Configuration
public class MapperCofig {
    @Bean
    AdminMapper adminMapper() {
        return Mappers.getMapper(AdminMapper.class);
    }

    @Bean
    AreaMapper areaMapper() {
        return Mappers.getMapper(AreaMapper.class);
    }

    @Bean
    ClazzMapper clazzMapper() {
        return Mappers.getMapper(ClazzMapper.class);
    }

    @Bean
    ApplyForMapper applyForMapper() {
        return Mappers.getMapper(ApplyForMapper.class);
    }

    @Bean
    BelongMapper belongMapper() {
        return Mappers.getMapper(BelongMapper.class);
    }

    @Bean
    BlockMapper blockMapper() {
        return Mappers.getMapper(BlockMapper.class);
    }

    @Bean
    EducationProgramMapper educationProgramMapper() {
        return Mappers.getMapper(EducationProgramMapper.class);
    }

    @Bean
    InstructorMapper instructorMapper() {
        return Mappers.getMapper(InstructorMapper.class);
    }

    @Bean
    MajorMapper majorMapper() {
        return Mappers.getMapper(MajorMapper.class);
    }

    @Bean
    MarkMapper markMapper() {
        return Mappers.getMapper(MarkMapper.class);
    }

    @Bean
    NoteMapper noteMapper() {
        return Mappers.getMapper(NoteMapper.class);
    }

    @Bean
    NoteTypeMapper noteTypeMapper() {
        return Mappers.getMapper(NoteTypeMapper.class);
    }

    @Bean
    NotificationMapper notificationMapper() {
        return Mappers.getMapper(NotificationMapper.class);
    }

    @Bean
    RegisterMapper registerMapper() {
        return Mappers.getMapper(RegisterMapper.class);
    }

    @Bean
    RoomMapper roomMapper() {
        return Mappers.getMapper(RoomMapper.class);
    }

//    @Bean
//    ScheduleMapper scheduleMapper() {
//        return Mappers.getMapper(ScheduleMapper.class);
//    }

    @Bean
    School_YearMapper school_yearMapper() {
        return Mappers.getMapper(School_YearMapper.class);
    }

    @Bean
    SemesterMapper semesterMapper() {
        return Mappers.getMapper(SemesterMapper.class);
    }

//    @Bean
//    ShiftMapper shiftMapper() {
//        return Mappers.getMapper(ShiftMapper.class);
//    }

    @Bean
    SpecializationMapper specializationMapper() {
        return Mappers.getMapper(SpecializationMapper.class);
    }

    @Bean
    StudentMapper studentMapper() {
        return Mappers.getMapper(StudentMapper.class);
    }

    @Bean
    StudyHistoryMapper studyHistoryMapper() {
        return Mappers.getMapper(StudyHistoryMapper.class);
    }

    @Bean
    StudyInMapper studyInMapper() {
        return Mappers.getMapper(StudyInMapper.class);
    }

//    @Bean
//    SubjectMapper subjectMapper() {
//        return Mappers.getMapper(SubjectMapper.class);
//    }
    @Bean
    TeachForMapper teachForMapper() {
        return Mappers.getMapper(TeachForMapper.class);
    }

    @Bean
    WeekDayMapper weekayMapper() {
        return Mappers.getMapper(WeekDayMapper.class);
    }
}
