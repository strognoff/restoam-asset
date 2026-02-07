package restoamar.service;

import restoamar.domain.Asset;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import restoamar.domain.ValueCurrency;

public interface AssetService {
    Asset save(Asset asset);
    Asset update(Asset asset);
    Asset findOne(UUID id);
    List<Asset> findAll();
    Page<Asset> findAll(Pageable pageable, String name, String location, String description, ValueCurrency currency);
    boolean delete(UUID id);
}
