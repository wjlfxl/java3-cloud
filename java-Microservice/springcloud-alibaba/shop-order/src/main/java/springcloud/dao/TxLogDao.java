package springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springcloud.entity.TxLog;

public interface TxLogDao extends JpaRepository<TxLog, String> {
}
