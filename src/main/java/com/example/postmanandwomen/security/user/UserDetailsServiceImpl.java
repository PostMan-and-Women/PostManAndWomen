package com.example.postmanandwomen.security.user;

import com.example.postmanandwomen.dto.ResponseDto;
import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.exception.RequestException;
import com.example.postmanandwomen.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email){

        Account account = accountRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException("Account가 존재하지 않습니다.")
        );

        UserDetailsImpl userDetails = new UserDetailsImpl(account);

        return userDetails;
    }
}
