package restoamar.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;

import java.util.UUID;

public interface AssetRepository  {
    Mono<Asset> save(Asset asset);
    Mono<Asset> update(Asset asset);
    Mono<Asset> findOne(UUID assetId);
    Mono<Boolean> delete(UUID assetId);
    Flux<Asset> findByName(String state);
}
