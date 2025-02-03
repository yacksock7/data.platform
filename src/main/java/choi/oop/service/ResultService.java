package choi.oop.service;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopAuthException;
import choi.oop.model.results.Result;
import choi.oop.model.results.contents.ResultContent;
import choi.oop.repository.results.ResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final ResultContentService resultContentService;

    public void create(Result result) {
        log.trace("create Start... result={}", result);
        resultRepository.insert(result);

        final ResultContent content = result.getContent();
        content.setResultId(result.getId());
        resultContentService.create(result.getContentType(), result.getContent());
    }

    public Result get(Long resultId) throws OopAuthException {
        log.trace("get Start... resultId={}", resultId);
        final Result result = resultRepository.select(resultId);
        if (result != null) {
            final ResultContent content = resultContentService.get(result.getContentType(), result.getId());
            return result.toBuilder()
                    .content(content)
                    .build();
        } else {
            throw new OopAuthException(ErrorCode.NotFound, "Can not found Result by resultId. resultId=" + resultId);
        }
    }

    public void modify(Result result) {
        log.trace("modify Start... result={}", result);
        resultRepository.update(result);
    }

    public void remove(Long resultId) {
        log.trace("delete Start... resultId={}", resultId);
        final Result result = resultRepository.select(resultId);
        resultContentService.remove(result.getContentType(), resultId);

        resultRepository.delete(resultId);
    }
}
