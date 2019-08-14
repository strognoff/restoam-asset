package restoamar.service;

import reactor.core.publisher.Mono;
import restoamar.domain.Asset;

import java.util.UUID;

public interface AssetService {
    Mono<Asset> save(Asset asset);
    Mono<Asset> update(Asset asset);
    Mono<Asset> findOne(UUID uuid);
    Mono<Boolean> delete(UUID uuid);
}
