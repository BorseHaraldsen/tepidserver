package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class ApiServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // /api/parts?name=
        // make it a getall for simplicity
        Part.getParts().forEach(p -> {
            try {
                resp.getWriter().write(p + "\r\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }); // WHEN WE WANT TO WRITE SOMETHING TO THE BODY WE USE GETWRITER
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Gonna take in some sort of body
        var newPart = req.getReader().lines().collect(Collectors.joining());
        Part.addParts(newPart);
        // resp.setStatus(200); // Maybe? Does it automatically potentially.


    }
}
