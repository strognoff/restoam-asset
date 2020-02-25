package com.cechinel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.WriteResult;
import reactor.core.publisher.Mono;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;
import restoamar.service.AssetServiceImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class DataRepositoryTest {
    public static final UUID RANDOM_ASSET_ID = UUID.randomUUID();
    private AssetRepository mockAssetRepository;
    private AssetServiceImpl assetServiceImpl;

    private final String name  = "television45inch";
    private final UUID assetId = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        mockAssetRepository = mock(AssetRepository.class);
        assetServiceImpl = new AssetServiceImpl(mockAssetRepository);
    }

    @Test
    @DisplayName("insert data and verify insertion")
    void throwsDependencyExceptionWhenInsertFails() {
        when(mockAssetRepository.save(assetRecord())).thenReturn(Mono.just(assetRecord()));

        assetServiceImpl.save(assetRecord());

        verify(mockAssetRepository).save(assetRecord());

    }
    private Asset assetRecord() {
        final String name = "testasset1";
        return new Asset(RANDOM_ASSET_ID, name);
    }


}
