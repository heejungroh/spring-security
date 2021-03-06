package com.cos.security.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //디폴트 생성자 생성
@AllArgsConstructor
@Builder
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // 해당 데이터베이스 번호증가 전략을 따라가기.

	private int id;
	
	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private String role; //권한
	
}
