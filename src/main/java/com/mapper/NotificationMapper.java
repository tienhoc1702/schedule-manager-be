package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dto.NotificationDTO;
import com.entity.Notification;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

	NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);  

	NotificationDTO toDTO(Notification notification);  
    
	Notification toEntity(NotificationDTO notificationDTO); 
}
