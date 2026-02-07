package restoamar.service;

import org.springframework.stereotype.Service;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;
import restoamar.domain.ValueCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.Instant;
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
        if (asset.getCreatedDate() == null) {
            asset.setCreatedDate(Instant.now());
        }
        if (asset.getValueCurrency() == null) {
            asset.setValueCurrency(ValueCurrency.GBP);
        }
        return this.assetRepository.save(asset);
    }

    @Override
    public Asset update(Asset asset) {
        if (asset.getCreatedDate() == null && asset.getId() != null) {
            Asset existing = this.assetRepository.findById(asset.getId()).orElse(null);
            if (existing != null) {
                asset.setCreatedDate(existing.getCreatedDate());
            }
        }
        if (asset.getValueCurrency() == null) {
            asset.setValueCurrency(ValueCurrency.GBP);
        }
        return this.assetRepository.save(asset);
    }

    @Override
    public Asset findOne(UUID id) {
        return this.assetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    @Override
    public Page<Asset> findAll(Pageable pageable, String name, String location, String description, ValueCurrency currency) {
        String nameFilter = name == null ? "" : name;
        String locationFilter = location == null ? "" : location;
        String descriptionFilter = description == null ? "" : description;
        if (currency == null) {
            return assetRepository.findByNameContainingIgnoreCaseAndLocationContainingIgnoreCaseAndDescriptionContainingIgnoreCase(
                    nameFilter, locationFilter, descriptionFilter, pageable);
        }
        return assetRepository.findByNameContainingIgnoreCaseAndLocationContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndValueCurrency(
                nameFilter, locationFilter, descriptionFilter, currency, pageable);
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
