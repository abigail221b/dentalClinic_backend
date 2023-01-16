package com.abigail221b.dentalClinic_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abigail221b.dentalClinic_backend.Appointment.Appointment;
import com.abigail221b.dentalClinic_backend.Appointment.AppointmentDTO;

@SpringBootApplication
@Configuration
public class DentalClinicBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalClinicBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper
			.typeMap(Appointment.class, AppointmentDTO.class)
			.addMappings(m -> m.map(src -> src.getPatient().getId(), AppointmentDTO::setPatientId));

		return mapper;
	}

}
