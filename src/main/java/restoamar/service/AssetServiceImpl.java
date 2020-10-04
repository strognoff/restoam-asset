package restoamar.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;


    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Mono<Asset> save(Asset asset) {
        if (asset.getId() == null) {
            asset.setId("ASSET01");
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
    public Mono<Asset> findOne(String id) {
        return this.assetRepository.findOne(id);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        Mono<Asset> arMono = this.assetRepository.findOne(id);
        return arMono
                .flatMap((Asset ar) -> this.assetRepository.delete(ar.getId()));
    }

}
