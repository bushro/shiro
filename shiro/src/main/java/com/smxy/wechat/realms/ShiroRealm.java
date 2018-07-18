package com.smxy.wechat.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.smxy.wechat.pojo.WcUser;
import com.smxy.wechat.pojo.WcUserAll;
import com.smxy.wechat.service.WcUserService;

/**
 * 
 * @Description :自定义Realm
 * @author Bush罗
 * @date 2018年7月12日 
 *
 */
public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	WcUserService wcUserService;
	
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		//2. 从 UsernamePasswordToken 中来获取 username
		String username = upToken.getUsername();
		
		//3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
		WcUser wcUser= wcUserService.selectByPrimaryKey(username);
		System.out.println(wcUser.toString());
		//4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
		if(wcUser!=null){
			//6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
			//以下信息是从数据库中获取的.
			//1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象. 
			Object principal = username;
			//2). credentials: 密码
			Object credentials = wcUser.getUserPassword(); 
			//3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
			String realmName = getName();
			//4). 盐值. 可以使用随机字符串或者用户名，只要是唯一的就行了
			ByteSource credentialsSalt = ByteSource.Util.bytes(username);
			SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
			info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
			return info;
		}else{
			return null;
		}	
	}


	//授权会被 shiro 回调的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//1. 从 PrincipalCollection  
		Object principal = principals.getPrimaryPrincipal();
		System.out.println(principal);
		//2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
		Set<String> roles = new HashSet<>();
		WcUserAll wcUserAll=wcUserService.selectRoleByPrimaryKey(String.valueOf(principal));
		roles.add(wcUserAll.getWcUserRoles().getUserRole());
		
		//3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		//4. 返回 SimpleAuthorizationInfo 对象. 
		return info;
	}
	/**
	 * MD5加密方式
	 * @param args
	 */
	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		Object credentials = "123456";
		Object salt = ByteSource.Util.bytes("user");;
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}
}
