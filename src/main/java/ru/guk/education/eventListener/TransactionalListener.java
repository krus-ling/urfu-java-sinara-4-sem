package ru.guk.education.eventListener;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.guk.education.eventListener.event.AppEvent;

@Log4j2
@Component
public class TransactionalListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleTransactional(AppEvent event) {
        log.info("🤍 [Transactional Listener] Обработано транзакционное событие: {},", event.message());
    }
}
