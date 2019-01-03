package com.session.service;

import java.util.Map;

import com.session.entity.Role;
import com.session.entity.User;

public interface ILoginService {

	User addUser(Map<String, Object> map);

	Role addRole(Map<String, Object> map);

	User findByName(String name);

}
