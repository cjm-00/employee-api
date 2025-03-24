package nology.employee_api.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);

        mapper.addConverter(new NullConverter());
        return mapper;
    }

    private class NullConverter implements Converter<String, String> {

        @Override
        public String convert(MappingContext<String, String> context) {
            String source = context.getSource();
            if (source.isEmpty()) {
                return null;
            }
            return source;
        }

    }
}
