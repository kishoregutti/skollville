package com.denkensol.universaladmission.dao;

import com.denkensol.universaladmission.entity.StudentProfile;
import com.denkensol.universaladmission.requestresponse.StudentProfileRequestResponse;

public interface StudentProfileDao {

	Long saveUpdateStudentProfile(StudentProfile studentProfile);

	StudentProfile getStudentProfileByGuId(Long studentProfileGuid);

	StudentProfile getStudentProfileByAccountGuId(Long accountGuid);

	StudentProfileRequestResponse getStudentProfileByAccountId(Long accountGuid);

}
