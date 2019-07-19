package kr.or.yi.gradle_mybatis_dev.dao;

import kr.or.yi.gradle_mybatis_dev.dto.UserPics;

public interface UserPicMapper {
	int insertUserPic(UserPics userPics);
	UserPics selectUserPics(UserPics userPics);
	int deleteUserPics(UserPics userPics);
}
