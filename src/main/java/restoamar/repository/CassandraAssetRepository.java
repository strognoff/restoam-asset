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
    public Mono<Asset> findOne(UUID assetId) {
        return this.cassandraTemplate.selectOneById(assetId, Asset.class);
    }

    @Override
    public Mono<Boolean> delete(UUID assetId) {
        return this.cassandraTemplate.deleteById(assetId, Asset.class);
    }

    @Override
    public Flux<Asset> findByState(String state) {
        Select select = QueryBuilder.select().from("asset_by_state");
        select.where(QueryBuilder.eq("state", state));
        return this.cassandraTemplate.select(select, Asset.class);
    }
}

