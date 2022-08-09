package com.ec.inventorymanager.service;

import java.util.List;
import com.ec.inventorymanager.model.Faculty;

public interface FacultyService {
	
	Faculty addStaff(Faculty faculty);
	
	List<Faculty> getAllStaff();
	
	Faculty getStaffById(Long id);
	
	Faculty updateStaff(Faculty faculty, Long id);
	
	void deleteStaff(Long id);

}
