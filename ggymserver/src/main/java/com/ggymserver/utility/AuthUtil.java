package com.ggymserver.utility;

import com.ggymserver.configuration.security.GGUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public static String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  ((GGUserDetails) authentication.getPrincipal()).getUsername();
    }
}
