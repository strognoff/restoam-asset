package restoamar.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table("asset")
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id;

    private String name;


    public Asset() {
    }

    public Asset(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(UUID randomUUID) {
        this.id = randomUUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}