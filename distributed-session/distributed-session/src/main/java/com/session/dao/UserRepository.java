package com.session.dao;

import com.session.entity.User;

public interface UserRepository extends BaseRepository<User, Long> {
	 User findByName(String name);
}
