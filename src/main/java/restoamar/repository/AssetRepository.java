package restoamar.repository;

import restoamar.domain.Asset;
import restoamar.domain.ValueCurrency;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {
    List<Asset> findAll();

    Page<Asset> findByNameContainingIgnoreCaseAndLocationContainingIgnoreCaseAndDescriptionContainingIgnoreCase(
            String name, String location, String description, Pageable pageable);

    Page<Asset> findByNameContainingIgnoreCaseAndLocationContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndValueCurrency(
            String name, String location, String description, ValueCurrency valueCurrency, Pageable pageable);
}
