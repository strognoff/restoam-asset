package restoamar.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;

import java.util.UUID;

public interface AssetService {
    Mono<Asset> save(Asset asset);
    Mono<Asset> update(Asset asset);
    Mono<Asset> findOne(UUID assetid);
    Mono<Boolean> delete(UUID assetid);
    Flux<Asset> findByName(String name);
}
