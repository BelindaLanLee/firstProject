package jp.co.brightstar.mapper;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.model.UserCondition;

@Mapper
public interface UserMapper {
	void insertUserInfo(UserCondition condition);

	UserCondition userInfoDetail(String userid);

	UserCondition userInfo(String userid);

	void deleteUserInfo(String phoneNo);

	void userInfoUpdate(UserCondition condition2);

}
