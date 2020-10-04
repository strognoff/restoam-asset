package restoamar.service;

import reactor.core.publisher.Mono;
import restoamar.domain.Asset;

public interface AssetService {
    Mono<Asset> save(Asset asset);
    Mono<Asset> update(Asset asset);
    Mono<Asset> findOne(String assetid);
    Mono<Boolean> delete(String assetid);
}
