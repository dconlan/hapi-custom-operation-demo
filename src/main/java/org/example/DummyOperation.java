package org.example;

import ca.uhn.fhir.rest.annotation.Operation;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DummyOperation {

    private final Logger LOGGER = LoggerFactory.getLogger(DummyOperation.class);

    @Operation(name = "$manualInputAndOutput", manualResponse = true, manualRequest = true)
    public void manualInputAndOutput(HttpServletRequest theServletRequest, HttpServletResponse theServletResponse)
            throws IOException {
        String contentType = theServletRequest.getContentType();
        byte[] bytes = IOUtils.toByteArray(theServletRequest.getInputStream());

        LOGGER.info("Received call with content type {} and {} bytes", contentType, bytes.length);

        theServletResponse.setContentType("text/plain");
        theServletResponse.getWriter().write("hello");
        theServletResponse.getWriter().close();
    }
}
