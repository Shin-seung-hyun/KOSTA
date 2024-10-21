package com.web.spring.jwt;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.gson.Gson;
import com.web.spring.domain.Member;
import com.web.spring.security.CustomMemberDetails;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter{ // 폼값을 받는 컨트롤러 역할의 필터이다.

	private final AuthenticationManager authenticationManager;
	
	private final JWTUtil jwtUtil;

	public LoginFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		//1. 클라이언트 로그인 요청 시, id/password 받아서 출력하는 부분
		String username = super.obtainUsername(request); // id
		String password = super.obtainPassword(request);
		
		log.info("username ::  {}", username);
		log.info("password ::  {}", password);
		
		
		//2. 스프링 시큐리티에서는 username, password를 검증하기 위해서 UsernamePasswordAuthenticationtoken에 담는다.
		// 지금 authorization은 없어서 null 담았다.
		// 파라미터가 두 개일 때는 UsernamePasswordToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
	
		
		//3. 토큰을 Manager에게 전달한다.
		// Manager -> Provider ->UserDetailsService -> DB연결 -> CustomMemberDetails 생성 후 back,back,back...
		//CustomMemberDetails를 반환한다.
		Authentication authentication = authenticationManager.authenticate(authToken); 
		
		log.info("Authentication ::  {}", authentication);
		return authentication; // 이제 이 정보로 jwt를 만든다.
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
		
	//로그인 성공시 JWT를 발급 받는 메소드 (여기서 JWT를 발급하면 됨)
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws  IOException{
    	
        response.setContentType("text/html;charset=UTF-8");
       log.info("로그인 성공 ......");
       
        //UserDetailsS
        CustomMemberDetails customMemberDetails = (CustomMemberDetails) authentication.getPrincipal(); //username에 해당하는 UserDetails 
        
        //이 정보는 왜 받아왔을까?
        String username = customMemberDetails.getUsername();//아이디
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority(); //ROLE_USER or ROLE_ADMIN
       
        //토큰생성과정...이때 password는 JWTUtil에서 안담았다.
        String token = jwtUtil.createJwt(
                customMemberDetails.getMember(), role, 1000L*60*10L);//1초*60*10 10분
        System.out.println("@@@@@@@@@@@@@@@@@@ getMember "+ customMemberDetails.getMember() +" @@@@@@@@@@@@@@@@@@");
        
        //응답할 때 헤더에 담겨져 날라간다.
        //베어러 뒤에 공백을 준다!!!!!!!!!. 관례적인  prefix
        response.addHeader("Authorization", "Bearer " + token); //"Bearer " 공백 하나 두고 서명한 사용자 정보가 값으로 날라간다.
        
        
        Map<String, Object> map = new HashMap<>();
        Member   member= customMemberDetails.getMember();
        map.put("memberNo",member.getMemberNo() );
        map.put("id", member.getId());
        map.put("name", member.getName());
        map.put("address", member.getAddress());
        Gson gson= new Gson();
        String arr = gson.toJson(map);
        response.getWriter().print(arr);
    }
    
    //로그인 실패시 실행하는 메소드
    //CustomMemberDetailsService에서 null이 떨어지면 이곳으로 리턴..
    //응답 메세지를 Json형태로 프론크 단으로 넘기기 위해서 Gson 라이브러리 사용함.
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        log.info("로그인 실패... ......");
        
        //로그인 실패시 401 응답 코드 반환
        response.setStatus(401);
        Map<String, Object> map = new HashMap<>();
        map.put("errMsg","정보를 다시 확인해주세요.");
        Gson gson= new Gson();
        String arr = gson.toJson(map);
        response.getWriter().print(arr);
    }
	
}
