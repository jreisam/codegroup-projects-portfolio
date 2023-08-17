package br.com.codegroup.portfolio.consumer;

import br.com.codegroup.portfolio.costants.AppConstants;
import br.com.codegroup.portfolio.dto.ProjectMemberDto;
import br.com.codegroup.portfolio.model.Person;
import br.com.codegroup.portfolio.model.Project;
import br.com.codegroup.portfolio.service.PersonService;
import br.com.codegroup.portfolio.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @author João Robson 12/08/2023
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private PersonService personService;

    @KafkaListener(groupId = AppConstants.GROUP_ID_JSON, topics = AppConstants.TOPIC_NOVO_MEMBRO, containerFactory = AppConstants.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receivedMessage(@Valid ProjectMemberDto projectMemberDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(projectMemberDto);
        logger.info("message received using Kafka listener " + jsonString);
        try {
            Person personAdded = personService.addPersonToProject(projectMemberDto);

            Project projectIncluded = projectService.getProjectById(projectMemberDto.getIdProjeto());
            logger.info("novo membro " + personAdded.getNome() + " salvo com sucesso ao projeto " + projectIncluded.getNome());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }
}
