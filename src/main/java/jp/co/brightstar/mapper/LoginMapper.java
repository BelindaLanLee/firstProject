package jp.co.brightstar.mapper;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.model.User;

@Mapper
public interface LoginMapper {
	User getUserByUserid(String userid);
}
