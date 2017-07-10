package com.denkensol.universaladmission.dao;

import com.denkensol.universaladmission.entity.StudentSchoolDocument;

public interface StudentSchoolDocumentDao {

	StudentSchoolDocument getStudentSchoolDocumentByGuId(Long studentSchoolDocumentGuid);

	void uploadStudentSchoolDocument(StudentSchoolDocument studentSchoolDocument);

	StudentSchoolDocument getDocumentByStudentAndDocumentId(Long schoolDocumentGuid, Long guid);
	
	StudentSchoolDocument getDocumentByStudentAndDocumentIdAndSchoolId(Long schoolDocumentGuid,Long schoolGuid, Long guid);
}
