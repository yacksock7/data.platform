package choi.oop.repository.results.manager;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.results.contents.DefaultRepository;
import choi.oop.repository.results.contents.ResultContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor
public class ResultContentContainerBySpringV4 implements ResultContentManager {

    /**
     * 다음은 ResultContentContainerV3의 기능을 Spring Di Container로 대체한 최종버전이다.
     * 기존 ResultContentContainerV3까지 개발하며, Spring의 위엄과 목적을 알게되었다.
     * 내가 고민한 것들에 대해 Spring이 지원하는 것을 알게 되었고, 대채한 후 받은 충격은 아직도 잊지 못한다.
     *
     * DI에 대한 고민,
     * component를 싱글톤으로 관리하며,
     * command patterm 마저 지원하는 Spring을 더 깊이 이해할 수 있는 경험이었다.
     */

    private final Map<String, ResultContentRepository> repositories;
    private final ResultContentRepository defaultRepository = new DefaultRepository();
    private final String SUBFIX = "ContentRepository";

    public ResultContentRepository getRepository(ResultContentType type) {
        final String key = type.name().toLowerCase() + SUBFIX;
        return repositories.getOrDefault(key, defaultRepository);
    }

}
