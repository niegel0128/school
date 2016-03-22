/**
 * 
 */
package com.moive.web.admin;

import java.util.List;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

/**
 * @file AdminService.java
 * @author CSY
 * @date 2016. 3. 23.
 * @stroy	
 */

public interface AdminService {
	public List<GradeMemberBean>getMemberList();
	public int addSource(GradeMemberBean bean);
	
}
