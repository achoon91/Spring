package com.sist.di;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/*
 * 		1. XML 이용
 * 		2. Annotation
 * 		3. XML + Annotation
 * 		4. 순수 자바 (차세대) = 스프링 5에서 주로 사용
 */
import java.util.*;
public class MusicDAO extends SqlSessionDaoSupport{
	public List<MusicVO> musicAllData()
	{
		return getSqlSession().selectList("musicAllData");
	}
}
