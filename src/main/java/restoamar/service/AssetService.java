package restoamar.service;

import restoamar.domain.Asset;

import java.util.List;
import java.util.UUID;

public interface AssetService {
    Asset save(Asset asset);
    Asset update(Asset asset);
    Asset findOne(UUID id);
    List<Asset> findAll();
    boolean delete(UUID id);
}
