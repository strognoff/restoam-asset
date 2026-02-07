package restoamar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import restoamar.domain.Asset;
import restoamar.domain.ValueCurrency;
import restoamar.service.AssetService;

import java.util.UUID;

@RestController
@RequestMapping("/restoam/assets")
public class ApplicationRoutes {

    private final AssetService assetService;

    @Autowired
    public ApplicationRoutes(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> get(@PathVariable UUID id) {
        Asset asset = assetService.findOne(id);
        if (asset == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asset);
    }

    @PostMapping("")
    public ResponseEntity<Asset> save(@RequestBody Asset asset) {
        Asset savedAsset = assetService.save(asset);
        return ResponseEntity.status(201).body(savedAsset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> update(@PathVariable UUID id, @RequestBody Asset asset) {
        asset.setId(id);
        Asset updatedAsset = assetService.update(asset);
        return ResponseEntity.ok(updatedAsset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deleted = assetService.delete(id);
        if (deleted) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("")
    public ResponseEntity<Page<Asset>> getAllAssets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) ValueCurrency currency
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Asset> assets = assetService.findAll(pageable, name, location, description, currency);
        return ResponseEntity.ok(assets);
    }
}