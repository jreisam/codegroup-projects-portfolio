package br.com.codegroup.portfolio.consumer;

import br.com.codegroup.portfolio.costants.AppConstants;
import br.com.codegroup.portfolio.dto.ProjectMemberDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author João Robson 12/08/2023
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(groupId = AppConstants.GROUP_ID_JSON, topics = AppConstants.TOPIC_NOVO_MEMBRO, containerFactory = AppConstants.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receivedMessage(ProjectMemberDto message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("message received using Kafka listener " + jsonString);

        // TODO: verifica se a pessoa é funcionario (funcionario=true) e então salvar o novo membro ao projeto informado (puxar o PersonService)

        logger.info("novo membro $x salvo com sucesso ao projeto $y");

    }
}
