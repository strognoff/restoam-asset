package restoamar.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;

public interface AssetRepository  {
    Mono<Asset> save(Asset asset);
    Mono<Asset> update(Asset asset);
    Mono<Asset> findOne(String id);
    Mono<Boolean> delete(String id);
    Flux<Asset> findByName(String state);
}
