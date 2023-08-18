package br.com.codegroup.portfolio.controller;

import br.com.codegroup.portfolio.costants.AppConstants;
import br.com.codegroup.portfolio.dto.ProjectMemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author João Robson 12/08/2023
 */
@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/teste")
    public String sendMessage(@RequestBody String msg) {

        try {
            kafkaTemplate.send(AppConstants.TOPIC_TESTE, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "msg sent";
    }


    @PostMapping("/portfolio/membro")
    public String newProjectMember(@Valid @RequestBody ProjectMemberDto dto) {
        try {
            kafkaTemplate.send(AppConstants.TOPIC_NOVO_MEMBRO, dto);
            //  TODO: ASYNC
            //   this.newMemberAsync(dto, AppConstants.TOPIC_NOVO_MEMBRO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

 /*   private void newMemberAsync(ProjectMemberDto dto, String topicName) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, dto);
        future.completable((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + dto.toString() +
                        "] with offset=[" + result. .ge().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        dto.toString() + "] due to : " + ex.getMessage());
            }
        });
    }*/
}
