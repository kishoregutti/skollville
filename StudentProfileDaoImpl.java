package com.denkensol.universaladmission.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.denkensol.universaladmission.dao.StudentProfileDao;
import com.denkensol.universaladmission.entity.StudentProfile;
import com.denkensol.universaladmission.requestresponse.StudentProfileRequestResponse;
import com.denkensol.universaladmission.util.CommonUtil;

@Repository
public class StudentProfileDaoImpl extends BaseDaoImpl<Long, StudentProfile> implements StudentProfileDao {

	@Override
	public Long saveUpdateStudentProfile(StudentProfile studentProfile) {
		Long studentProfileGuid = null;
		if (studentProfile.getStudentProfileGuid() != null) {
			studentProfileGuid = studentProfile.getStudentProfileGuid();
			saveOrUpdate(studentProfile);
		} else {
			studentProfileGuid = save(studentProfile);
		}
		return studentProfileGuid;
	}

	@Override
	public StudentProfile getStudentProfileByGuId(Long studentProfileGuid) {
		return getById(studentProfileGuid);
	}

	@Override
	public StudentProfile getStudentProfileByAccountGuId(Long accountGuid) {
		Criterion criterionObj = Restrictions.eq("account.guid", accountGuid);
		return getByCondition(criterionObj);
	}

	@Override
	public StudentProfileRequestResponse getStudentProfileByAccountId(Long accountGuid) {

		StudentProfileRequestResponse studentProfile = new StudentProfileRequestResponse();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("accountGuid", accountGuid);
		List<StudentProfileRequestResponse> studentProfileList = (List<StudentProfileRequestResponse>) executeNativeNamedQuery(
				"GET_STUDENT_PROFILE", parameters, StudentProfileRequestResponse.class);

		if (CommonUtil.isListNotNullAndNotEmpty(studentProfileList)) {
			studentProfile = studentProfileList.get(0);
		}
		return studentProfile;
	}

}
