package choi.oop.configuration;

import choi.oop.util.SystemEnvUtil;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public SystemEnvUtil systemEnvUtil() {
        return new SystemEnvUtil();
    }

    @Bean
    public ModelMapper modelMapper() {
        Provider<LocalDateTime> localDateTimeProvider = new AbstractProvider<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        };

        Converter<String, LocalDateTime> toStringDate = new AbstractConverter<String, LocalDateTime>() {
            @Override
            protected LocalDateTime convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return LocalDateTime.parse(source, format);
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(String.class, LocalDateTime.class);
        modelMapper.addConverter(toStringDate);
        modelMapper.getTypeMap(String.class, LocalDateTime.class).setProvider(localDateTimeProvider);
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
