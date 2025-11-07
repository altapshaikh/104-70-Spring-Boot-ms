package com.ait.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ait.bean.LoginUser;
import com.ait.bean.UserBean;

import jakarta.servlet.http.HttpSession;

public interface UserService {
	public UserBean registerUser(UserBean userbean, MultipartFile profilePic) throws IOException;

	public boolean loginUser(LoginUser user, HttpSession session);

	public UserBean fetchUserById(int id);

	public List<UserBean> fetchAllUserById();

	public UserBean updateUser(String email);

	void deleteUser(String email);

	public UserBean updateUser(UserBean user);
}
