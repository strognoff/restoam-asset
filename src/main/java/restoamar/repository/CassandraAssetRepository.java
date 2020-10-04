package restoamar.repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;

import java.util.UUID;

@Repository
public class CassandraAssetRepository implements AssetRepository {

    private final ReactiveCassandraOperations cassandraTemplate;

    public CassandraAssetRepository(ReactiveCassandraOperations cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public Mono<Asset> save(Asset asset) {
        return this.cassandraTemplate.insert(asset);
    }

    @Override
    public Mono<Asset> update(Asset asset) {
        return this.cassandraTemplate.update(asset);
    }

    @Override
    public Mono<Asset> findOne(UUID id) {
        return this.cassandraTemplate.selectOneById(id, Asset.class);
    }

    @Override
    public Mono<Boolean> delete(UUID id) {
        return this.cassandraTemplate.deleteById(id, Asset.class);
    }

    @Override
    public Flux<Asset> findByName(String name) {
        Select select = QueryBuilder.select().from("asset");
        select.where(QueryBuilder.eq("name", name));
        return this.cassandraTemplate.select(select, Asset.class);
    }
}

