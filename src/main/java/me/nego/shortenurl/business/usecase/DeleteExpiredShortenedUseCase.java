package me.nego.shortenurl.business.usecase;

/**
 * @author Nick
 * @since 2024-04-10
 */
public interface DeleteExpiredShortenedUseCase {

    // TODO : 명명을 반복해야 할까? '[유즈케이스명].실행()'과 같은 형식이 되도록 명명해도 괜찮을 듯 하다
    void deleteExpiredShortened(Request request);

    record Request(
           Long beforeDays
    ) {
    }

}
