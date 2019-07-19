package kr.or.yi.gradle_mybatis_dev.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.UserPics;
import kr.or.yi.gradle_mybatis_dev.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.UserPicMapper";
	@Override
	public int insertUserPic(UserPics userPics) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".insertUserPic", userPics);
			sqlSession.commit();
			return res;
		}
		
	}

	@Override
	public UserPics selectUserPics(UserPics userPics) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectUserPics", userPics);
			
			 
		}
	}

	@Override
	public int deleteUserPics(UserPics userPics) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".deleteUserPics", userPics);
			sqlSession.commit();
			return res;
		}
		
	}

}
