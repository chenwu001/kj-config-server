package com.suixingpay.config.server.mapper;

import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.CacheDelete;
import com.jarvis.cache.annotation.CacheDeleteKey;
import com.suixingpay.config.server.entity.ProfileDO;

import java.util.List;

/**
 * @author: qiujiayu[qiu_jy@suixingpay.com]
 * @date: 2017年8月31日 下午10:45:06
 * @version: V1.0
 * @review: qiujiayu[qiu_jy@suixingpay.com]/2017年8月31日 下午10:45:06
 */
public interface ProfileMapper {
    int EXPIRE = 3600;

    
    @Cache(key = "'profile_'+#args[0]", expire = EXPIRE)
    ProfileDO getByProfile(String profile);

    
    List<ProfileDO> listAll();

    
    @CacheDelete(@CacheDeleteKey("'profile_'+#args[0].profile"))
    int addProfile(ProfileDO profile);

    
    @CacheDelete(@CacheDeleteKey("'profile_'+#args[0].profile"))
    int updateProfile(ProfileDO profile);

}
