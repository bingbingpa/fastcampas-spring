package com.bingbingpa.cli;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data -> Getter, Setter, ToString, @EqualsAndHashCode 을 모두 포함하는 어노테이션
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // @NonNull이라고 명시한 필드로만 생성자를 만든다. 
public class Member {
	private int id;
	@NonNull private String username;
	@NonNull private String password;
	
	public Member(ResultSet resultSet) {
		try { 
			this.id = resultSet.getInt("id");
			this.username = resultSet.getString("username");
			this.password = resultSet.getString("password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
