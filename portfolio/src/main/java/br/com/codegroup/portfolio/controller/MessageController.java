package br.com.codegroup.portfolio.controller;

import br.com.codegroup.portfolio.costants.AppConstants;
import br.com.codegroup.portfolio.dto.ProjectMemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author João Robson 12/08/2023
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/teste")
    public String sendMessage(@RequestBody ProjectMemberDto dto) {

        try {
            kafkaTemplate.send(AppConstants.TOPIC_TESTE, dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "json message sent successfully";
    }


    @PostMapping("/portfolio/send")
    public String readAndCommitEFD(@RequestBody ProjectMemberDto dto) {
        try {
            kafkaTemplate.send(AppConstants.TOPIC_NOVO_MEMBRO, dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("novo membro $x salvo com sucesso ao projeto $y");
        return "";
    }
}
