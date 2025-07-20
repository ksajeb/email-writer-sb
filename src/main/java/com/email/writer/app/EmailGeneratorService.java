package com.email.writer.app;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmailGeneratorService {
    public  String generateEmailReply(EmailRequest emailRequest){
        //build the prompt
        String prompt=buildPrompt(emailRequest);

        //craft a request
        Map<String, Object> requestBody = Map.of(
                "k1", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        //do request and get response

        //return response
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt=new StringBuilder();
        prompt.append("Generate a professional email reply fo the following email content.Please don't generate a subject lines ");
        if(emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a ").append(emailRequest.getTone()).append("tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());

        return  prompt.toString();
    }
}
