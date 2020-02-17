package restoamar.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;

import java.util.UUID;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;


    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Mono<Asset> save(Asset asset) {
        if (asset.getId() == null) {
            asset.setId(UUID.randomUUID());
        }
        Mono<Asset> saved = this.assetRepository.save(asset);
        return saved.flatMap(savedAsset ->
                this.assetRepository.save(asset));
    }

    @Override
    public Mono<Asset> update(Asset asset) {
        return null;
    }

    @Override
    public Mono<Asset> findOne(UUID uuid) {
        return this.assetRepository.findOne(uuid);
    }

    @Override
    public Mono<Boolean> delete(UUID uuid) {
        Mono<Asset> arMono = this.assetRepository.findOne(uuid);
        return arMono
                .flatMap((Asset ar) -> this.assetRepository.delete(ar.getId()));
    }

}
