package main.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {

    public static void responseByJson(HttpServletResponse response, Object object) throws IOException {
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ResultUtils.success(object));
        System.out.println(json);
        out.write(json);
        out.flush();
        out.close();
    }
}
