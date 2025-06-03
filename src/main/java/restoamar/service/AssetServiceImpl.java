package restoamar.service;

import org.springframework.stereotype.Service;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;
import java.util.UUID;
import java.util.List;


@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Asset save(Asset asset) {
        UUID uuid = UUID.randomUUID();

        if (asset.getId() == null) {
            asset.setId(uuid);
        }
//        if (asset.getDescription() == null) {
//            asset.setDescription("DESCNA");
//        }
//        if (asset.getLocation() == null) {
//            asset.setLocation("LOCNA");
//        }
        return this.assetRepository.save(asset);
    }

    @Override
    public Asset update(Asset asset) {
        return this.assetRepository.save(asset);
    }

    @Override
    public Asset findOne(UUID id) {
        return this.assetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Asset> findByName(String name) {
        return this.assetRepository.findByName(name);
    }

    @Override
    public boolean delete(UUID id) {
        Asset asset = this.assetRepository.findById(id).orElse(null);
        if (asset != null) {
            this.assetRepository.delete(asset);
            return true;
        }
        return false;
    }
}
