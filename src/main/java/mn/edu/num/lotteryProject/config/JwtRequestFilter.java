package mn.edu.num.lotteryProject.config;


import mn.edu.num.lotteryProject.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenUtil.resolveToken(httpServletRequest);
        try {
            if (token != null && jwtTokenUtil.validateToken(token)) {
                Authentication auth = jwtTokenUtil.getAuthentication(token, jwtUserDetailsService);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (UsernameNotFoundException ex) {
            // this is very important, since it guarantees the user is not authenticated at all
            SecurityContextHolder.clearContext();
//            httpServletResponse.sendError(ex.getHttpStatus().value(), ex.getMessage());
//            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}