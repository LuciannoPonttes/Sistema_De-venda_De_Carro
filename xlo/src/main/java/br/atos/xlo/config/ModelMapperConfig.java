package br.atos.xlo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper obterModelMapper() {
        ModelMapper mapper = new ModelMapper();
        org.modelmapper.config.Configuration config = mapper.getConfiguration();
        config.setCollectionsMergeEnabled(true);
        config.setSkipNullEnabled(true);
        return mapper;
    }
}