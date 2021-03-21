package com.webperside.user_website.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerUtil {

    public static void redirectToError(HttpServletResponse resp, String message){
        try {
            resp.sendRedirect("error?msg="+message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
