package com.harvicom.kafkastreams.straightthrough.processor;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.text.DecimalFormat;
import java.time.Duration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.KeyValue;

@Component
public class EventStreamProcessor {

    @Value("${straightthrough.inputTopicName}")
    public String inputTopicName;

    @Value("${straightthrough.outputTopicName}")
    public String outputTopicName;

    @Autowired
    public void buildPipeline(StreamsBuilder streamsBuilder) {

        KStream<String, String> kStream = streamsBuilder.stream(inputTopicName,Consumed.with(Serdes.String(), Serdes.String()));
        kStream.to(outputTopicName,Produced.with(Serdes.String(), Serdes.String()));
    }
}
