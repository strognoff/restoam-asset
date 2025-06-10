package restoamar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restoamar.domain.Asset;
import restoamar.service.AssetService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/restoar")
public class AssetHandler {

    private final AssetService assetService;

    @Autowired
    public AssetHandler(AssetService assetService) {
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

    @PostMapping("/")
    public ResponseEntity<Asset> save(@RequestBody Asset asset) {
        Asset savedAsset = assetService.save(asset);
        return ResponseEntity.status(201).body(savedAsset);
    }

    @PutMapping("/")
    public ResponseEntity<Asset> update(@RequestBody Asset asset) {
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
}