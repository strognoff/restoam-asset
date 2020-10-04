package restoamar.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;

import java.util.UUID;

@Service
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;


    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Mono<Asset> save(Asset asset) {

        UUID uuid = UUID.randomUUID();

        if (asset.getId() == null) {
            asset.setId(uuid);
        }
        if (asset.getDescription() == null) {
            asset.setDescription("DESCNA");
        }
        if (asset.getLocation() == null) {
            asset.setLocation("LOCNA");
        }
        Mono<Asset> saved = this.assetRepository.save(asset);
        return saved.flatMap(savedAsset ->
                this.assetRepository.save(asset));
    }

    @Override
    public Mono<Asset> update(Asset asset) {
        return this.assetRepository.update(asset);
    }

    @Override
    public Mono<Asset> findOne(UUID id) {
        return this.assetRepository.findOne(id);
    }

    @Override
    public Flux<Asset> findByName(String name) {
        return this.assetRepository.findByName(name);
    }

    @Override
    public Mono<Boolean> delete(UUID id) {
        Mono<Asset> arMono = this.assetRepository.findOne(id);
        return arMono
                .flatMap((Asset ar) -> this.assetRepository.delete(ar.getId()));
    }

}
