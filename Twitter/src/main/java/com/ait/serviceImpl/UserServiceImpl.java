package com.ait.serviceImpl;

import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ait.bean.LoginUser;
import com.ait.bean.UserBean;
import com.ait.model.UserEntity;
import com.ait.repository.UserRepository;
import com.ait.service.UserService;

import jakarta.servlet.http.HttpSession;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepository;
	
	
	@Override
	public UserBean registerUser(UserBean user,MultipartFile profilePic) throws IOException {
		
		UserEntity entity=new UserEntity();
		 if (profilePic != null && !profilePic.isEmpty()) {
			 entity.setProfilePic(profilePic.getBytes());
	        }
		BeanUtils.copyProperties(user, entity);
		UserEntity userdata = userRepository.save(entity);
		BeanUtils.copyProperties(userdata, user);
		return user;
	}

	@Override
	public void deleteUser(String email) {
		 Optional<UserEntity> byEmail = userRepository.findByEmail(email);
		 if(byEmail.isPresent()) {
				UserEntity userEntity = byEmail.get();
				userRepository.deleteById(userEntity.getId());
			}
	}

	@Override
	public UserBean updateUser(String email) {
	 Optional<UserEntity> byEmail = userRepository.findByEmail(email);
	 UserBean bean=new UserBean();
	if(byEmail.isPresent()) {
		UserEntity userEntity = byEmail.get();
		BeanUtils.copyProperties(userEntity, bean);
	}
		return bean;
	}

	@Override
	public UserBean fetchUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> fetchAllUserById() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean loginUser(LoginUser user,HttpSession session) {
		 Optional<UserEntity> byEmailAndPassword = userRepository.findByEmailAndPassword(user.getEmail(),
				user.getPassword());
		 
	if(byEmailAndPassword.isPresent()) {
		session.setAttribute("profilepic", byEmailAndPassword.get().getProfilePic());
		
		return true;
	}else {
		return false;
	}
		 
	}

	@Override
	public UserBean updateUser(UserBean user) {
		
		Optional<UserEntity> entity = userRepository.findById(user.getId());
		UserEntity userEntity = entity.get();
		userEntity.setId(user.getId());
		userEntity.setContactNo(user.getContactNo());
		userEntity.setDob(user.getDob());
		userEntity.setGender(user.getGender());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		UserEntity userdata = userRepository.save(userEntity);
		BeanUtils.copyProperties(userdata, user);
		return user;
		
	}

}
