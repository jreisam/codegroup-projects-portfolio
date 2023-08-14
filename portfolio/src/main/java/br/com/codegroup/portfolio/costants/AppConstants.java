package br.com.codegroup.portfolio.costants;

public class AppConstants {
    // Kafka
    //public static final String KAFKA_LOCAL_SERVER_CONFIG = "localhost:9092";

    // Confluent async Kafka
    public static final String KAFKA_LOCAL_SERVER_CONFIG = "localhost:29092,localhost:39092";
    public static final String GROUP_ID_STRING = "group-id-string-1";
    public static final String KAFKA_LISTENER_CONTAINER_FACTORY = "kafkaListenerContainerFactory";
    public static final String GROUP_ID_JSON = "group-id-json-1";
    public static final String TOPIC_TESTE = "portfolio-topic-teste";
    public static final String TOPIC_NOVO_MEMBRO = "portfolio-topic-novo-membro";
}
